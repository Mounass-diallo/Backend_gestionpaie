package Application.com.GestionDePaie.Controller;


import Application.com.GestionDePaie.Model.Banque;
import Application.com.GestionDePaie.Model.Civil;
import Application.com.GestionDePaie.Service.BanqueService;
import Application.com.GestionDePaie.Service.CivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/civ")
public class CivilController {
    @Autowired
    private CivilService civilService;

    // Add new etat civil
    @PostMapping("/addCivil")
    public Civil addCivil(@RequestBody Civil civil) {
        return civilService.addCivil(civil);
    }
    // Add more than 1 etat civil
    @PostMapping("/addCivils")
    public List<Civil> addAllCivils(@RequestBody List<Civil> civils) {
        return civilService.addAllCivils(civils);
    }
    // Get etat civil by Id
    @GetMapping("/getCivilByID/{id}")
    public Civil getCivilById(@PathVariable int id) {
        return civilService.getCivilByID(id);
    }
    // Get etat civil by name
    @GetMapping("/getCivilByName/{name}")
    public  Civil getCivilByName(@PathVariable String name) {
        return  civilService.getCivilByName(name);
    }

    // Update etat civil
    @PutMapping("/updateCivil")
    public Civil updateCivil(@RequestBody Civil civil) {
        return civilService.updateCivil(civil);
    }

    // Delete etat civil
    @DeleteMapping("/deleteCivilById/{id}")
    public boolean deleteCivilByID(@PathVariable int id) {
        return civilService.deleteCivilByID(id);
    }

    // Get all etat civil
    @GetMapping("/getAll")
    public List<Civil> getAllCivil() {
        return civilService.getAllCivils();
    }
}
