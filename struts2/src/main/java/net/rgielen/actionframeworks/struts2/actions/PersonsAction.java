package net.rgielen.actionframeworks.struts2.actions;

import com.opensymphony.xwork2.ActionSupport;
import net.rgielen.actionframeworks.domain.Person;
import net.rgielen.actionframeworks.service.PersonService;

import javax.inject.Inject;
import java.util.List;

/**
 * PersonAction.
 *
 * @author Rene Gielen
 */
public class PersonsAction extends ActionSupport {

    @Inject
    private PersonService personService;

    public List<Person> getAllPersons() {
        return personService.findAll();
    }

}
