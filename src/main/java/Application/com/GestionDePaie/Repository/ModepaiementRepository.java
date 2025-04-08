package Application.com.GestionDePaie.Repository;

import Application.com.GestionDePaie.Model.Modepaiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModepaiementRepository extends JpaRepository<Modepaiement, Integer> {
    Modepaiement findByName(String name);
}
