package app.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/products")
public class ProductController {


//    private final ProductRepository repository;
//
//    public ProductController(ProductRepository repository) {
//        this.repository = repository;
//    }

    /*
    GET http://localhost:8080/products
     */
    @GetMapping("/products")
    public String findAll(Model model){
//        List<Product> products = this.repository.findAll();
//        model.addAttribute("products", products);
        return "product-list";
    }

//    /*
//    GET http://localhost:8080/products/new
//     */
//    @GetMapping("/new")
//    public String getForm(Model model){
//        model.addAttribute("products", new Product());
//        return "product-form";
//    }
//
//    /*
//    POST http://localhost:8080/products
//     */
//    @PostMapping
//    public String save(@ModelAttribute("product") Product product){
//        this.repository.save(product);
//        return "redirect:/products";
//    }
//
//    /*
//    GET http://localhost:8080/products/{id}/view
//     */
//
//        /*
//    GET http://localhost:8080/products/{id}/edit
//     */
//
//            /*
//    GET http://localhost:8080/products/{id}/delete
//     */
//
//    /*
//    GET http://localhost:8080/products/delete/all
//     */
}
