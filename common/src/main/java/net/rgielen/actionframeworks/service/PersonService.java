package net.rgielen.actionframeworks.service;

import net.rgielen.actionframeworks.domain.Person;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

/**
 * PersonService.
 *
 * @author Rene Gielen
 */
@Named
@Singleton
public class PersonService {

    Set<Person> persons = new HashSet<>();

    public Person save(Person person) {
        if (person != null) {
            if (person.getId() == null) {
                person.setId(UUID.randomUUID().toString());
            }
            persons.add(person);
        }
        return person;
    }

    public Person findById(String id) {
        return persons.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Person> findAll() {
        return persons.stream().sorted((p1, p2) -> p1.getLastname().compareTo(p2.getLastname())).collect(toList());
    }

    @PostConstruct
    protected void addSampleData() {
        save(new Person("Arnold", "Schwarzenegger"));
        save(new Person("Bruce", "Willis"));
        save(new Person("Daniel", "Craig"));
    }


}