package app.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
// TODO terminar teacher
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

//        Insertar datos de ejemplo
//        var productRepository = context.getBean(ProductRepository.class);
//
//        productRepository.saveAll(Arrays.asList(
//                new Product(null, "apple", 45.99, 5),
//                new Product(null, "banana", 12.50, 10),
//                new Product(null, "orange", 30.75, 8)
//        ));
    }

}
