package Application.com.GestionDePaie.Service;


import Application.com.GestionDePaie.Model.Direction;
import Application.com.GestionDePaie.Repository.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionService {
    @Autowired
    private DirectionRepository directionRepository;
    public Direction addDirection(Direction direction) {
        return directionRepository.save(direction);
    }

    public List<Direction> addAllDirections(List<Direction> directions) {
        return  directionRepository.saveAll(directions);
    }

    public Direction getDirectionByID(int id) {
        return directionRepository.findById(id).orElse(null);
    }

    public Direction getDirectionByName(String name) {
        return  directionRepository.findByName(name);
    }

    public Direction updateDirection(Direction direction) {
        Direction existingEMP = directionRepository.findById(direction.getId()).orElse(null);
        System.out.println(direction);
        if (existingEMP == null) {
            System.out.println("direction not found");
            return directionRepository.save(direction);
        }else {
            existingEMP.setName(direction.getName());
            directionRepository.save(existingEMP);
        }
        return  direction;
    }
    public boolean deleteDirectionByID(int id) {
        Direction existingEMP = directionRepository.getById(id);
        if(existingEMP != null) {
            directionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Direction> getAllDirections() {
        return directionRepository.findAll();
    }
}
