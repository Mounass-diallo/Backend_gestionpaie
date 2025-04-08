package Application.com.GestionDePaie.Repository;

import Application.com.GestionDePaie.Model.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenceRepository  extends JpaRepository<Agence, Integer> {
    Agence findByName(String name);
}
