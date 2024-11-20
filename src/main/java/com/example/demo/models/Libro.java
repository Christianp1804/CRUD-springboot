package com.example.demo.models;

import java.util.Date;
import jakarta.validation.constraints.*;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "libros")
public class Libro {

    @Id
    private String id;

    @NotNull(message = "El título es obligatorio.")
    @Size(min = 2, max = 100, message = "El título debe tener entre 2 y 100 caracteres.")
    private String titulo;

    @NotNull(message = "El autor es obligatorio.")
    @Size(min = 3, max = 50, message = "El autor debe tener entre 3 y 50 caracteres.")
    private String autor;

    @NotNull(message = "El ISBN es obligatorio.")
    @Pattern(regexp = "\\d{13}", message = "El ISBN debe ser un número único con exactamente 13 dígitos.")
    private String isbn;

    @PastOrPresent(message = "La fecha de publicación debe ser pasada o el día de hoy.")
    private Date fechaPublicacion;

    @NotNull(message = "El género es obligatorio.")
    @Pattern(regexp = "Ficción|No Ficción|Educativo|Otro", message = "El género debe ser uno válido (Ficción, No Ficción, Educativo, Otro).")
    private String genero;

    @NotNull(message = "El precio es obligatorio.")
    @DecimalMin(value = "0.01", message = "El precio debe ser un número positivo mayor a 0.")
    @DecimalMax(value = "1000.00", message = "El precio no puede superar los 1000.")
    private double precio;

    @NotNull(message = "La cantidad en stock es obligatoria.")
    @Min(value = 1, message = "La cantidad en stock debe ser un entero positivo.")
    @Max(value = 500, message = "La cantidad en stock no puede ser mayor a 500.")
    private int cantidadStock;

    @Size(min = 10, max = 500, message = "La descripción debe tener entre 10 y 500 caracteres.")
    private String descripcion;

    @NotNull(message = "El idioma es obligatorio.")
    @Pattern(regexp = "Español|Inglés|Francés|Alemán", message = "El idioma debe ser uno válido (Español, Inglés, Francés, Alemán).")
    private String idioma;



}
