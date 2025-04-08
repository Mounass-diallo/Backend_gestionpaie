package Application.com.GestionDePaie.Repository;

import Application.com.GestionDePaie.Model.Direction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DirectionRepository extends JpaRepository<Direction, Integer>{
    Direction findByName(java.lang.String name);
}
