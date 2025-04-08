package Application.com.GestionDePaie.Repository;

import Application.com.GestionDePaie.Model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
    Departement findByName(String name);
}
