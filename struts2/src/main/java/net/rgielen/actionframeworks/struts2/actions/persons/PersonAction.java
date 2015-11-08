package net.rgielen.actionframeworks.struts2.actions.persons;

import com.opensymphony.xwork2.ActionSupport;
import net.rgielen.actionframeworks.domain.Person;
import net.rgielen.actionframeworks.service.PersonService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;
import java.util.SimpleTimeZone;

/**
 * PersonAction.
 *
 * @author Rene Gielen
 */
public class PersonAction extends ActionSupport {

    @Inject
    private PersonService personService;

    private String id;

    @Valid
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Action(value = "save", results = {
            @Result(name = "success", location = "${person.id}", type = "redirectAction"),
            @Result(name = "input", location = "person.jsp")
    })
    public String save() throws Exception {
        personService.save(person);
        return SUCCESS;
    }

    @Action(value = "new", results=@Result(location = "person.jsp"))
    public String create() throws Exception {
        return SUCCESS;
    }

    @Action(value = "{id}", results = {
            @Result(name = "success", location = "person.jsp")
            , @Result(name = "error", type="httpheader", params={"status", "404", "errorMessage", "No such resource"})
    })
    public String get() throws Exception {
        person = personService.findById(id);
        if (person != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

}
