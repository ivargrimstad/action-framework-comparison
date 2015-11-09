package net.rgielen.actionframeworks.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IndexController.
 *
 * @author Rene Gielen
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping
    public String index() {
        return "index";
    }
}
