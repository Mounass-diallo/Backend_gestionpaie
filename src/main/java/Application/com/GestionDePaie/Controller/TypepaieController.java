package Application.com.GestionDePaie.Controller;

import Application.com.GestionDePaie.Model.Typepaie;
import Application.com.GestionDePaie.Service.TypepaieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/type")
public class TypepaieController {
    @Autowired
    private TypepaieService typepaieService;

    // Add new type paie
    @PostMapping("/addTypepaie")
    public Typepaie addTypepaie(@RequestBody Typepaie typepaie) {
        return typepaieService.addTypepaie(typepaie);
    }
    // Add more than 1 type paie
    @PostMapping("/addTypepaies")
    public List<Typepaie> addAllTypepaies(@RequestBody List<Typepaie> typepaies) {
        return typepaieService.addAllTypepaies(typepaies);
    }
    // Get type paie by Id
    @GetMapping("/getTypepaieByID/{id}")
    public Typepaie getTypepaieById(@PathVariable int id) {
        return typepaieService.getTypepaieByID(id);
    }
    // Get type paie by name
    @GetMapping("/getTypepaieByName/{name}")
    public  Typepaie getTypepaieByName(@PathVariable String name) {
        return  typepaieService.getTypepaieByName(name);
    }
    // Update type paie
    @PutMapping("/updateTypepaie")
    public Typepaie updateTypepaie(@RequestBody Typepaie typepaie) {
        return typepaieService.updateTypepaie(typepaie);
    }

    // Delete type paie
    @DeleteMapping("/deleteTypepaieById/{id}")
    public boolean deleteTypepaieByID(@PathVariable int id) {
        return typepaieService.deleteTypepaieByID(id);
    }

    // Get all type paie
    @GetMapping("/getAll")
    public List<Typepaie> getAllTypepaie() {
        return typepaieService.getAllTypepaies();
    }

}
