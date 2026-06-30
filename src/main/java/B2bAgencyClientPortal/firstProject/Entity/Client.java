package B2bAgencyClientPortal.firstProject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

    @Entity
    @Data // automatically generates all your getters and setters!
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Add this line
    public class Client {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Client name cannot be empty")
        private String name;

        // can be blank, when working for individual
        private String companyName;

        @NotBlank(message = "Contact number is required")
        private String contactNumber;

        @NotBlank(message = "Email is required")
        @Email(message = "Must be a valid email format")
        private String email;
    }
