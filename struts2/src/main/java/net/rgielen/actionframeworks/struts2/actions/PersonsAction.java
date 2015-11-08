package net.rgielen.actionframeworks.struts2.actions;

import com.opensymphony.xwork2.ActionSupport;
import net.rgielen.actionframeworks.domain.Person;
import net.rgielen.actionframeworks.service.PersonService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/**
 * PersonAction.
 *
 * @author Rene Gielen
 */
public class PersonsAction extends ActionSupport {

    @Inject
    private PersonService personService;

    @Valid
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getAllPersons() {
        return personService.findAll();
    }

    public void setId(String id) {
        person = personService.findById(id);
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    @Action(value = "/persons/{id}", results = {
            @Result(name = "success", location = "person.jsp")
            , @Result(name = "error", type="httpheader", params={"status", "404", "errorMessage", "No such resource"})
    })
    public String get() throws Exception {
        if (person != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

}
