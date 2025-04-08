package Application.com.GestionDePaie.Repository;

import Application.com.GestionDePaie.Model.Corp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorpRepository extends JpaRepository<Corp,Integer> {
    Corp findByName(String name);
}
