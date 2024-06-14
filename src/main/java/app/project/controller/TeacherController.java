package app.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeacherController {

    @GetMapping("/teacher/my_agreements")
    public String my_agreements() {
        return "roles/teacher/my_agreements";
    }
}
