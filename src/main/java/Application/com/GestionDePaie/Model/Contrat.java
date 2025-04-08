package Application.com.GestionDePaie.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date embouche;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    private String numCompte;
    private String salaireBase;
    private String nbrPartFical;
    private String nbrPartImpot;
    private String nbrDenfantPrest;
    private String jourBase;
    private String nbreJourPresence;
//    private  boolean isDeleted = false;

    @Transient
    private int corpId;
    @ManyToOne
    @JoinColumn(name = "corp_id")
    @JsonIgnore
    private Corp corp;

    @Transient
    private int classeId;
    @ManyToOne
    @JoinColumn(name = "classe_id")
    @JsonIgnore
    private Classe classe;
    @Transient
    private int echellonId;
    @ManyToOne
    @JoinColumn(name = "echellon_id")
    @JsonIgnore
    private Echellon echellon;

    @Transient
    private int typeContratId;
    @ManyToOne
    @JoinColumn(name = "typeContrat_id")
    @JsonIgnore
    private TypeContrat typeContrat;

    @Transient
    private  int employeeId;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;
    @Transient
    private int typepaieId;
    @ManyToOne
    @JoinColumn(name = "typepaie_id")
    private Typepaie typepaie;


    @Transient
    private int agenceId;
    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;
}
