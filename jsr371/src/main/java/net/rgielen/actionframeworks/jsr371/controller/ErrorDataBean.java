/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rgielen.actionframeworks.jsr371.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.mvc.annotation.RedirectScoped;

/**
 * @author Ivar Grimstad (ivar.grimstad@gmail.com)
 */
@Named
@RedirectScoped
public class ErrorDataBean implements Serializable {

    private static final long serialVersionUID = 601263646224546642L;

    private List<String> messages = new ArrayList();

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }


}
