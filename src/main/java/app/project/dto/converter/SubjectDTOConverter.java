package app.project.dto.converter;

import javax.annotation.PostConstruct;

import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import app.project.entity.Subject;
import app.project.dto.SubjectDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SubjectDTOConverter {

    private final ModelMapper modelMapper;


    @PostConstruct
    public void init() {
        modelMapper.addMappings(new PropertyMap<Subject, SubjectDTO>() {

            @Override
            protected void configure() {
                map().setCategoria(source.getCategoria().getNombre());
            }
        });
    }

    public ProductoDTO convertToDto(Producto producto) {
        return modelMapper.map(producto, ProductoDTO.class);

    }

}