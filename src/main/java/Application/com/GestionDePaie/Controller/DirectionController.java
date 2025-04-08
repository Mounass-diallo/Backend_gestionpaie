package Application.com.GestionDePaie.Controller;


import Application.com.GestionDePaie.Model.Direction;
import Application.com.GestionDePaie.Service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/direc")
public class DirectionController {
    @Autowired
    private DirectionService directionService;
    // Add new direction
    @PostMapping("/addDirection")
    public Direction addDirection(@RequestBody Direction direction) {
        return directionService.addDirection(direction);
    }
    // Add more than 1 direc
    @PostMapping("/addDirections")
    public List<Direction> addAllDirections(@RequestBody List<Direction> directions) {
        return directionService.addAllDirections(directions);
    }
    // Get direc by Id
    @GetMapping("/getDirectionByID/{id}")
    public Direction getDirectiontById(@PathVariable int id) {
        return directionService.getDirectionByID(id);
    }
    // Get direc by name
    @GetMapping("/getDirectionByName/{name}")
    public  Direction getDirectionByName(@PathVariable String name) {
        return  directionService.getDirectionByName(name);
    }
    // Update direction
    @PutMapping("/updateDirection")
    public Direction updateDirection(@RequestBody Direction direction) {
        return directionService.updateDirection(direction);
    }

    // Delete direction
    @DeleteMapping("/deleteDirectionById/{id}")
    public boolean deleteDirectionByID(@PathVariable int id) {
        return directionService.deleteDirectionByID(id);
    }
    // Get all diurection
    @GetMapping("/getAll")
    public List<Direction> getAllDirection() {
        return directionService.getAllDirections();
    }
}
