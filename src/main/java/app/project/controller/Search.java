package app.project.controller;

import app.project.entity.Subject;
import app.project.repository.SubjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class Search {

    private SubjectRepository subjectRepository;

    @GetMapping("/subject/search")
    public String searchSubject(Model model) {
        List<Subject> subjects = this.subjectRepository.findAll();
        if (!subjects.isEmpty()) {
//            System.out.format("You want to see subject with n/ ID: %s", subject.getName());
            model.addAttribute("subjects", subjects);
            return "fragments/findSubjectById";
        } else {
//            TODO throw my own exception
//            return "redirect:/subject/search";
            System.out.println("ERROR THROW ==> [ NotFoundSubjectException{} ]");
            return "redirect:/subject/search";
        }
    }



    @GetMapping("/subject/{id}")
    public String findSubjectById(@PathVariable long id, Model model) {
        Optional<Subject> subject = this.subjectRepository.findById(id);
        if (subject.isPresent()) {
            System.out.format("You want to see subject with ID: %s", id);
            System.out.format("You want to see subject with n/ NAME: %s", subject.get().getName());
            model.addAttribute("teachers", subject.get());
            return "fragments/findAllTeacherBySubject";
//            return "redirect:/subject/search?id=" + id;
        } else {
            return "redirect:/subject/search";
        }
    }
}
