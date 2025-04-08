package Application.com.GestionDePaie.Repository;

import Application.com.GestionDePaie.Model.Echellon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EchellonRepository extends JpaRepository<Echellon, Integer> {
    Echellon findByName(String name);
}
