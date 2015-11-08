package net.rgielen.actionframeworks.service;

import net.rgielen.actionframeworks.domain.Actor;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

/**
 * ActorService is a dummy in-memory service implementation.
 *
 * @author Rene Gielen
 */
@Named
@Singleton
public class ActorService {

    Set<Actor> actors = new HashSet<>();

    public Actor save(Actor actor) {
        if (actor != null) {
            if (actor.getId() == null || actor.getId().isEmpty()) {
                actor.setId(UUID.randomUUID().toString());
            }
            actors.add(actor);
        }
        return actor;
    }

    public Actor findById(String id) {
        return actors.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Actor> findAll() {
        return actors.stream().sorted((a1, a2) -> a1.getLastname().compareTo(a2.getLastname())).collect(toList());
    }

    @PostConstruct
    protected void addSampleData() {
        save(new Actor("Arnold", "Schwarzenegger"));
        save(new Actor("Bruce", "Willis"));
        save(new Actor("Daniel", "Craig"));
    }


}
