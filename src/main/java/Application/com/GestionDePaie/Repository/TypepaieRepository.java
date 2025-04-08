package Application.com.GestionDePaie.Repository;

import Application.com.GestionDePaie.Model.Typepaie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypepaieRepository extends JpaRepository<Typepaie, Integer> {
    Typepaie findByName(String name);
}
