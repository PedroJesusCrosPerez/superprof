package app.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @GetMapping("/page1")
    public String page1() {
        return "page1";
    }

//    @GetMapping("/page2")
//    public String page2() {
//        return "page2";
//    }
//
//    @GetMapping("/page3")
//    public String page3() {
//        return "page3";
//    }
//
//    @GetMapping("/page4")
//    public String page4() {
//        return "page4";
//    }
//
//    @GetMapping("/layout")
//    public String layout() {
//        return "fragments/layout";
//    }

    @GetMapping("/index")
    public String index2() {
        return "index";
    }
    @GetMapping("/details")
    public String showDetails() {
        return "details";
    }


    @GetMapping("/index_copilot")
    public String index_copilot() {
        return "index_copilot";
    }
    @GetMapping("/details_copilot")
    public String details_copilot() {
        return "details_copilot";
    }


    @GetMapping("/")
    public String index() {
        return "redirect:home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/teacher")
    public String teacherById(@RequestParam(defaultValue = "1") Long idTeacher) {
        return "findByIdTeacher";
    }

}