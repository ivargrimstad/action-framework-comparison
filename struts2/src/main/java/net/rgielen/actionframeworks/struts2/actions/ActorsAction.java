package net.rgielen.actionframeworks.struts2.actions;

import com.opensymphony.xwork2.ActionSupport;
import net.rgielen.actionframeworks.domain.Actor;
import net.rgielen.actionframeworks.service.ActorService;

import javax.inject.Inject;
import java.util.List;

/**
 * Action to deal with list semantics for actors.
 *
 * @author Rene Gielen
 */
public class ActorsAction extends ActionSupport {

    @Inject
    private ActorService actorService;

    public List<Actor> getAllActors() {
        return actorService.findAll();
    }

}
