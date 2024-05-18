package app.project.api;

import app.project.entity.Product;
import app.project.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class AgreementApi {

    private final ProductRepository productRepository;

    /**
     * Obtenemos todos los productos
     *
     * @return
     */
    @GetMapping("")
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /**
     * Obtenemos un Product en base a su ID
     *
     * @param id
     * @return Null si no encuentra el Producto
     */
    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Insertamos un nuevo Product
     *
     * @param newProduct
     * @return Product insertado
     */
    @PostMapping("")
    public Product insert(@RequestBody Product newProduct) {
        return productRepository.save(newProduct);
    }

    /**
     *
     * @param updateProduct
//     * @param id
     * @return
     */
//    @PutMapping("/{id}")
    @PutMapping("")
    public Product update(@RequestBody Product updateProduct) {
        Long id = updateProduct.getId(); // Obtiene el ID del producto a actualizar
        if (productRepository.existsById(id)) {
            return productRepository.save(updateProduct);
        } else {
            return null;
        }
    }


    /**
     * Borra un Product del catálogo en base a su id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Product delete(@PathVariable Long id) {
        if (productRepository.existsById(id)) {
            Product result = productRepository.findById(id).get();
            productRepository.deleteById(id);
            return result;
        } else
            return null;
    }

}
