package Application.com.GestionDePaie.Repository;

import Application.com.GestionDePaie.Model.TypeContrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeContratRepository extends JpaRepository<TypeContrat, Integer> {
    TypeContrat findByName(String name);
}
