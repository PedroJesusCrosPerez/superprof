package app.project;

import app.project.entity.Product;
import app.project.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

//        Insertar datos de ejemplo
        var productRepository = context.getBean(ProductRepository.class);

        productRepository.saveAll(Arrays.asList(
                new Product(null, "apple", 45.99, 5),
                new Product(null, "banana", 12.50, 10),
                new Product(null, "orange", 30.75, 8)
        ));
    }

}
