/*
 * The MIT License
 *
 * Copyright 2015 Rene Gielen (rene.gielen@gmail.com).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.rgielen.actionframeworks.jsr371.controller;

import static java.util.stream.Collectors.toList;
import net.rgielen.actionframeworks.domain.Actor;
import net.rgielen.actionframeworks.service.ActorService;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.mvc.annotation.CsrfValid;
import javax.mvc.annotation.View;
import javax.mvc.binding.BindingResult;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

/**
 * ActorsController.
 *
 * @author Rene Gielen
 */
@Controller
@Path("actors")
public class ActorsController {

   @Inject
   private Models models;

   @Inject
   private ActorService actorService;

   @Inject
   private BindingResult br;

   @Inject
   private ErrorDataBean errorDataBean;

   @GET
   @View("actors.xhtml")
   public void actors() {
      models.put("actors", actorService.findAll());
   }

   @GET
   @View("actor.xhtml")
   @Path("new")
   public void newActor() {
      models.put("actor", new Actor());
   }

   @GET
   @View("actor.xhtml")
   @Path("{id}")
   public void actor(@PathParam("id") String id) {
      models.put("actor", actorService.findById(id));
   }

   @CsrfValid
   @POST
   @Path("new")
   @ValidateOnExecution(type = ExecutableType.NONE)
   public Response create(@Valid @BeanParam Actor actor) {

      if (br.isFailed()) {

         errorDataBean.setMessages(
                 br.getAllViolations().stream()
                 .map(v -> v.getMessage())
                 .collect(toList()));

         return Response.status(BAD_REQUEST).entity("error.jsp").build();
      }

      actorService.save(actor);
      models.put("actor", actor);
      return Response.ok("redirect:actors/" + actor.getId()).build();
   }

   @POST
   @Path("{id}")
   public String update(@BeanParam Actor actor, @PathParam("id") String id) {
      actorService.save(actor);
      models.put("actor", actor);
      return "redirect:actors/" + actor.getId();
   }

}
