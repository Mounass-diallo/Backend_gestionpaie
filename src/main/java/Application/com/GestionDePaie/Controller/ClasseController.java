package Application.com.GestionDePaie.Controller;


import Application.com.GestionDePaie.Model.Classe;
import Application.com.GestionDePaie.Model.TypeContrat;
import Application.com.GestionDePaie.Service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/clas")
public class ClasseController {
    @Autowired
    private ClasseService classeService;

    // Add new classe
    @PostMapping("/addClasse")
    public Classe addClasse(@RequestBody Classe classe) {
        return classeService.addClasse(classe);
    }

    // Add more than 1 classe
    @PostMapping("/addClasses")
    public List<Classe> addAllClasses(@RequestBody List<Classe> classes) {
        return classeService.addAllClasses(classes);
    }
    // Get classe by Id
    @GetMapping("/getClasseByID/{id}")
    public Classe getClasseById(@PathVariable int id) {
        return classeService.getClasseByID(id);
    }
    // Get classe by name
    @GetMapping("/getClasseByName/{name}")
    public  Classe getClasseByName(@PathVariable String name) {
        return  classeService.getClasseByName(name);
    }

    // Update classe
    @PutMapping("/updateClasse")
    public Classe updateClasse(@RequestBody Classe classe) {
        return classeService.updateClasse(classe);
    }

    // Delete classe
    @DeleteMapping("/deleteClasseById/{id}")
    public boolean deleteClasseByID(@PathVariable int id) {
        return classeService.deleteClasseByID(id);
    }
    @GetMapping("/getAll")

    public List<Classe> getAllClasse() {

        return classeService.getAllClasses();
    }
}
