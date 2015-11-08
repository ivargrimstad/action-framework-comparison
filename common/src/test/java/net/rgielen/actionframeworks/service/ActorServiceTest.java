package net.rgielen.actionframeworks.service;

import net.rgielen.actionframeworks.domain.Actor;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ActorServiceTest {

    private ActorService actorService;

    @Before
    public void setUp() {
        actorService = new ActorService();
    }

    @Test
    public void testSave() throws Exception {
        final Actor actor = new Actor("foo", "bar");
        actorService.save(actor);
        assertThat(actorService.actors).contains(actor);
        assertThat(actor.getId()).isNotNull();
        assertThat(actorService.actors.size()).isEqualTo(1);

        actorService.save(actor);
        assertThat(actorService.actors.size()).isEqualTo(1);
    }

    @Test
    public void testSaveCreatesNewIdWhenGivenIdIsEmpty() throws Exception {
        final Actor actor = new Actor("","foo", "bar");
        assertThat(actor.getId()).isEmpty();
        actorService.save(actor);
        assertThat(actorService.actors).contains(actor);
        assertThat(actor.getId()).isNotEmpty();
    }

    @Test
    public void testFindById() throws Exception {
        final Actor actor = new Actor("123","foo", "bar");
        actorService.save(actor);
        final Actor byId = actorService.findById("123");
        assertThat(byId).isNotNull();
        assertThat(byId).isSameAs(actor);
    }

    @Test
    public void testFindAll() throws Exception {
        actorService.save(new Actor("A", "a"));
        actorService.save(new Actor("B", "b"));
        actorService.save(new Actor("C", "c"));
        assertThat(actorService.findAll()).hasSize(3);
    }
}