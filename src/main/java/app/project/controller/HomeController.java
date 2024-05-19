//package app.project.controller;
//
////import app.proyecto.entity.UserAll;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class HomeController {
//
//    @GetMapping("/")
//    public String index() {
//        return "redirect:/home";
//    }
//
//    @GetMapping("/home")
//    public String home() {
//        return "fragments/home";
//    }
//    @GetMapping("/main")
//    public String layoutmain() {
//        return "structure/main";
//    }
//
//    @GetMapping("/details")
//    public String details() {
//        return "fragments/details";
//    }
//
////    @GetMapping("/entity/userAll")
////    public String testEntity(Model model) {
////        model.addAttribute(String.valueOf(new UserAll(3L, "pedro@gmail.es", "1234", "pedro", "cros")), "user");
////        return "home2"; // Esto asume que tienes una vista llamada "header.html"
////    }
//}
