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
package net.rgielen.actionframeworks.springmvc.controller;

import net.rgielen.actionframeworks.domain.Actor;
import net.rgielen.actionframeworks.service.ActorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * ActorsController.
 *
 * @author Rene Gielen
 */
@Controller
@RequestMapping("actors")
public class ActorsController {

    @Inject
    ActorService actorService;

    @RequestMapping(method = GET)
    public String actors(Model model) {
        model.addAttribute("actors", actorService.findAll());
        return "actors";
    }

    @RequestMapping(value = "new")
    public String showNew(Model model) {
        model.addAttribute("actor", new Actor());
        return "actor";
    }

    @RequestMapping(value = "{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("actor", actorService.findById(id));
        return "actor";
    }

    @RequestMapping(method = POST, value = "new")
    public String create(@Valid Actor actor, Errors errors, Model model) {
        return saveAndRedirect(actor, model, errors);
    }

    @RequestMapping(method = POST, value = "{id}")
    public String update(@Valid Actor actor, Errors errors, @PathVariable String id, Model model) {
        return saveAndRedirect(actor, model, errors);
    }

    private String saveAndRedirect(Actor actor, Model model, Errors errors) {
        if (errors.hasErrors()) {
            return "actor";
        }
        actorService.save(actor);
        model.addAttribute("actor", actor);
        return "redirect:" + actor.getId();
    }

}
