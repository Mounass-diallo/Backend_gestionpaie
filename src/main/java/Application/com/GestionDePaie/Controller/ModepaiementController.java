package Application.com.GestionDePaie.Controller;


import Application.com.GestionDePaie.Model.Modepaiement;
import Application.com.GestionDePaie.Model.Typepaie;
import Application.com.GestionDePaie.Service.ModepaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/modepaie")
public class ModepaiementController {
    @Autowired
    private ModepaiementService modepaiementService;

    // Add new Mode paiement
    @PostMapping("/addModepaiement")
    public Modepaiement addModepaiement(@RequestBody Modepaiement modepaiement) {
        return modepaiementService.addModepaiement(modepaiement);
    }

    // Add more than 1 mode paiement
    @PostMapping("/addModepaiements")
    public List<Modepaiement> addAllModepaiements(@RequestBody List<Modepaiement> modepaiements) {
        return modepaiementService.addAllModepaiements(modepaiements);
    }
    // Get mode paiement by Id
    @GetMapping("/getModepaiementByID/{id}")
    public Modepaiement getModepaiementById(@PathVariable int id) {
        return modepaiementService.getModepaiementByID(id);
    }
    // Get mode paiement by name
    @GetMapping("/getModepaiementByName/{name}")
    public  Modepaiement getModepaiementByName(@PathVariable String name) {
        return  modepaiementService.getModepaiementByName(name);
    }

    // Update mode paiement
    @PutMapping("/updateModepaiement")
    public Modepaiement updateModepaiement(@RequestBody Modepaiement modepaiement) {
        return modepaiementService.updateModepaiement(modepaiement);
    }

    // Delete mode paiement
    @DeleteMapping("/deleteModepaiementById/{id}")
    public boolean deleteModepaiementByID(@PathVariable int id) {
        return modepaiementService.deleteModepaiementByID(id);
    }
    // Get all mode paie
    @GetMapping("/getAll")
    public List<Modepaiement> getAllModepaiement() {
        return modepaiementService.getAllModepaiements();
    }
}