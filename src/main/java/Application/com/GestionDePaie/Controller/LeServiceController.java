package Application.com.GestionDePaie.Controller;


import Application.com.GestionDePaie.Model.LeService;
import Application.com.GestionDePaie.Service.LeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/serv")
public class LeServiceController {
    @Autowired
    private LeServiceService leServiceService;

    // Add new service
    @PostMapping("/addLeService")
    public LeService addLeService(@RequestBody LeService leService) {
        return leServiceService.addLeService(leService);
    }

    // Add more than 1 service
    @PostMapping("/addLeServices")
    public List<LeService> addAllLeServices(@RequestBody List<LeService> leServices) {
        return leServiceService.addAllLeServices(leServices);
    }
    // Get service by Id
    @GetMapping("/getLeServiceByID/{id}")
    public LeService getLeServiceById(@PathVariable int id) {
        return leServiceService.getLeServiceByID(id);
    }

    // Get service by name
    @GetMapping("/getLeServiceByName/{name}")
    public  LeService getLeServiceByName(@PathVariable String name) {
        return  leServiceService.getLeServiceByName(name);
    }
    // Update service
    @PutMapping("/updateLeService")
    public LeService updateLeService(@RequestBody LeService leService) {
        return leServiceService.updateLeService(leService);
    }

    // Delete service
    @DeleteMapping("/deleteLeServiceById/{id}")
    public boolean deleteLeServiceByID(@PathVariable int id) {
        return leServiceService.deleteLeServiceByID(id);
    }

    // Get all employee
    @GetMapping("/getAll")
    public List<LeService> getAllLeServices() {
        return leServiceService.getAllLeServices();
    }
}
