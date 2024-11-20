package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*; // Use javax.validation.* if using older versions of Java EE
import java.util.Date;

import lombok.Data;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String id;

    @NotNull(message = "El nombre completo es obligatorio.")
    @Size(min = 3, max = 50, message = "El nombre completo debe tener entre 3 y 50 caracteres.")
    private String nombreCompleto;

    @NotNull(message = "El correo electrónico es obligatorio.")
    @Email(message = "El correo electrónico debe tener un formato válido.")
    private String correoElectronico;


    @NotNull(message = "La contraseña es obligatoria.")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,20}$", //expresion regular para validar si el String contiene las condiciones especificadas en el ACA
            message = "La contraseña debe tener entre 8 y 20 caracteres e incluir al menos una letra mayúscula, una letra minúscula, un número y un carácter especial."
    )
    private String contraseña;

    private Date fechaRegistro;

    @Min(value = 14, message = "La edad debe ser mayor de 13 años.")
    private Integer edad;

    @Pattern(regexp = "\\d{10}", message = "El número de teléfono debe tener exactamente 10 dígitos.")
    private String numeroTelefono;

    @NotNull(message = "El rol es obligatorio.")
    @Pattern(regexp = "Administrador|Lector", message = "El rol debe ser válido (Administrador o Lector).")
    private String rol;

}
