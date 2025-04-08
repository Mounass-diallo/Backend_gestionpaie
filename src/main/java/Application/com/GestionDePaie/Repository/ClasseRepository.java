package Application.com.GestionDePaie.Repository;

import Application.com.GestionDePaie.Model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasseRepository extends JpaRepository<Classe, Integer> {
    Classe findByName(String name);
}
