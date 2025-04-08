package Application.com.GestionDePaie.Repository;

import Application.com.GestionDePaie.Model.Civil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CivilRepository extends JpaRepository<Civil, Integer> {
    Civil findByName(String name);
}
