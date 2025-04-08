package Application.com.GestionDePaie.Repository;

import Application.com.GestionDePaie.Model.LeService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeServiceRepository extends JpaRepository<LeService, Integer>{
    LeService findByName(java.lang.String name);
}
