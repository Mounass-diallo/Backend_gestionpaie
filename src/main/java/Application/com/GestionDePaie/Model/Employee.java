package Application.com.GestionDePaie.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String name;
    private String email;
    private int numeroCNI;
    private String matricule;
    @Transient
    private int civilId;
    @ManyToOne
    @JoinColumn(name = "civil_id")
    private Civil civil;






}
