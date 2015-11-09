package net.rgielen.actionframeworks.struts2.actions.actors;

import com.opensymphony.xwork2.ActionSupport;
import net.rgielen.actionframeworks.domain.Actor;
import net.rgielen.actionframeworks.service.ActorService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Action to deal with single resource semantics for actors.
 * Namespaces and view locations are determined by convention, see
 * https://struts.apache.org/docs/convention-plugin.html
 *
 * @author Rene Gielen
 */
public class ActorAction extends ActionSupport {

    @Inject
    private ActorService actorService;

    private String id;

    @Valid
    private Actor actor;

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Action(value = "save", results = {
            @Result(name = "success", location = "${actor.id}", type = "redirectAction"),
            @Result(name = "input", location = "actor.jsp")
    })
    public String save() throws Exception {
        actorService.save(actor);
        return SUCCESS;
    }

    @Action(value = "new", results=@Result(location = "actor.jsp"))
    public String create() throws Exception {
        return SUCCESS;
    }

    @Action(value = "{id}", results = {
            @Result(name = "success", location = "actor.jsp")
            , @Result(name = "error", type="httpheader", params={"status", "404", "errorMessage", "No such resource"})
    })
    public String get() throws Exception {
        actor = actorService.findById(id);
        if (actor != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

}
