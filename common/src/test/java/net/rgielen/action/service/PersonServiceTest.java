package net.rgielen.action.service;

import net.rgielen.action.domain.Person;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonServiceTest {

    private PersonService personService;

    @Before
    public void setUp() {
        personService = new PersonService();
    }

    @Test
    public void testSave() throws Exception {
        final Person person = new Person("foo", "bar");
        personService.save(person);
        assertThat(personService.persons).contains(person);
        assertThat(person.getId()).isNotNull();
        assertThat(personService.persons.size()).isEqualTo(1);

        personService.save(person);
        assertThat(personService.persons.size()).isEqualTo(1);
    }

    @Test
    public void testFindById() throws Exception {
        final Person person = new Person("123","foo", "bar");
        personService.save(person);
        final Person byId = personService.findById("123");
        assertThat(byId).isNotNull();
        assertThat(byId).isSameAs(person);
    }

    @Test
    public void testFindAll() throws Exception {
        personService.save(new Person("A", "a"));
        personService.save(new Person("B", "b"));
        personService.save(new Person("C", "c"));
        assertThat(personService.findAll()).hasSize(3);
    }
}