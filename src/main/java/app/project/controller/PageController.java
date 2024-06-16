package app.project.controller;

import app.project.content.agreement.infrastructure.repository.jpa.AgreementRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PageController {

    @GetMapping("/page1")
    public String page1() {
        return "page1";
    }

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


    private final AgreementRepositoryJpa agreementRepositoryJpa;

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("agreements", agreementRepositoryJpa.findAll());
        return "test";
    }
}