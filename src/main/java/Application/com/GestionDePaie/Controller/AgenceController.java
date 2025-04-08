package Application.com.GestionDePaie.Controller;


import Application.com.GestionDePaie.Model.Agence;
import Application.com.GestionDePaie.Model.Banque;
import Application.com.GestionDePaie.Service.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/agen")
public class AgenceController {
    @Autowired
    private AgenceService agenceService;

  //Add new agence
  @PostMapping("/addAgence")
  public Agence addAgence(@RequestBody Agence agence) {
      return agenceService.addAgence(agence);
  }
    // Add more than 1 Agence
    @PostMapping("/addAgences")
    public List<Agence> addAllAgences(@RequestBody List<Agence> agence) {
        return agenceService.addAllAgences(agence);
    }
    // Get Agence by Id
    @GetMapping("/getAgenceByID/{id}")
    public Agence getAgenceById(@PathVariable int id) {
        return agenceService.getAgenceByID(id);
    }
    // Get Agence by name
    @GetMapping("/getAgenceByName/{name}")
    public  Agence getAgenceByName(@PathVariable String name) {
        return  agenceService.getAgenceByName(name);
    }
    // Update Agence
    @PutMapping("/updateAgence")
    public Agence updateAgence(@RequestBody Agence agence) {
        return agenceService.updateAgence(agence);
    }

    // Delete Agence
    @DeleteMapping("/deleteAgenceById/{id}")
    public boolean deleteAgenceByID(@PathVariable int id) {
        return agenceService.deleteAgenceByID(id);
    }

    // Get all Agence
    @GetMapping("/getAllAgence")
    public List<Agence> getAllAgences() {
        return agenceService.getAllAgences();
    }


}
