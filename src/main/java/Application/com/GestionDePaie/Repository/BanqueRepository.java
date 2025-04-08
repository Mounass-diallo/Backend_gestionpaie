package Application.com.GestionDePaie.Repository;

import Application.com.GestionDePaie.Model.Banque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanqueRepository extends JpaRepository<Banque, Integer> {
     Banque findByName(String name);
}
