package Application.com.GestionDePaie.Controller;


import Application.com.GestionDePaie.Model.Departement;
import Application.com.GestionDePaie.Service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/depar")
public class DepartementController {
    @Autowired
    private DepartementService departementService;

    // Add new departement
    @PostMapping("/addDepartement")
    public Departement addDepartement(@RequestBody Departement departement) {
        return departementService.addDepartement(departement);
    }
    // Add more than 1 depar
    @PostMapping("/addDepartements")
    public List<Departement> addAllDepartements(@RequestBody List<Departement> departements) {
        return departementService.addAllDepartements(departements);
    }

    // Get depar by Id
    @GetMapping("/getDepartementByID/{id}")
    public Departement getDepartementById(@PathVariable int id) {
        return departementService.getDepartementByID(id);
    }
    // Get depar by name
    @GetMapping("/getDepartementByName/{name}")
    public  Departement getDepartementByName(@PathVariable String name) {
        return  departementService.getDepartementByName(name);
    }

    // Update depar
    @PutMapping("/updateDepartement")
    public Departement updateDepartement(@RequestBody Departement departement) {
        return departementService.updateDepartement(departement);
    }

    // Delete depar
    @DeleteMapping("/deleteDepartementById/{id}")
    public boolean deleteDepartementByID(@PathVariable int id) {
        return departementService.deleteDepartementByID(id);
    }
    // Get all depar
    @GetMapping("/getAll")
    public List<Departement> getAllDepartements() {

        return departementService.getAllDepartements();
    }
}
