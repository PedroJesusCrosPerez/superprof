package app.project.api;

import app.project.dto.SubjectDTO;
import app.project.entity.Subject;
import app.project.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subject")
public class SubjectApi {

    private final SubjectRepository subjectRepository;

    /**
     * Obtenemos todos los productos
     *
     * @return
     */
    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<Producto> result = productoRepositorio.findAll();

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {

            List<SubjectDTO> dtoList = result.stream().map(productoDTOConverter::convertToDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(dtoList);
        }
    }

    /**
     * Obtenemos un Subject en base a su ID
     *
     * @param id
     * @return Null si no encuentra el Producto
     */
    @GetMapping("/{id}")
    public Subject findById(@PathVariable Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    /**
     * Insertamos un nuevo Subject
     *
     * @param newProduct
     * @return Subject insertado
     */
    @PostMapping("")
    public Subject insert(@RequestBody Subject newProduct) {
        return subjectRepository.save(newProduct);
    }

    /**
     *
     * @param updateProduct
//     * @param id
     * @return
     */
//    @PutMapping("/{id}")
    @PutMapping("")
    public Subject update(@RequestBody Subject updateProduct) {
        Long id = updateProduct.getId(); // Obtiene el ID del producto a actualizar
        if (subjectRepository.existsById(id)) {
            return subjectRepository.save(updateProduct);
        } else {
            return null;
        }
    }


    /**
     * Borra un Subject del catálogo en base a su id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Subject delete(@PathVariable Long id) {
        if (subjectRepository.existsById(id)) {
            Subject result = subjectRepository.findById(id).get();
            subjectRepository.deleteById(id);
            return result;
        } else
            return null;
    }

}
