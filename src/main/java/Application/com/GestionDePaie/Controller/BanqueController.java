package Application.com.GestionDePaie.Controller;


import Application.com.GestionDePaie.Model.Banque;
import Application.com.GestionDePaie.Repository.BanqueRepository;
import Application.com.GestionDePaie.Service.BanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ban")
public class BanqueController {

    @Autowired
    private BanqueService banqueService;

    // Add new banque
    @PostMapping("/addBanque")
    public Banque addBanque(@RequestBody Banque banque) {
        return banqueService.addBanque(banque);
    }
    // Add more than 1 banque
    @PostMapping("/addBanques")
    public List<Banque> addAllBanques(@RequestBody List<Banque> banques) {
        return banqueService.addAllBanques(banques);
    }
    // Get banque by Id
    @GetMapping("/getBanqueByID/{id}")
    public Banque getBanqueById(@PathVariable int id) {
        return banqueService.getBanqueByID(id);
    }
    // Get banque by name
    @GetMapping("/getBanqueByName/{name}")
    public  Banque getBanqueByName(@PathVariable String name) {
        return  banqueService.getBanqueByName(name);
    }

    // Update banque
    @PutMapping("/updateBanque")
    public Banque updateBanque(@RequestBody Banque banque) {
        return banqueService.updateBanque(banque);
    }

    // Delete banque
    @DeleteMapping("/deleteBanqueById/{id}")
    public boolean deleteBanqueByID(@PathVariable int id) {
        return banqueService.deleteBanqueByID(id);
    }

    // Get all banque
    @GetMapping("/getAll")
    public List<Banque> getAllBanque() {
        return banqueService.getAllBanques();
    }
}
