package Application.com.GestionDePaie.Controller;


import Application.com.GestionDePaie.Model.Corp;
import Application.com.GestionDePaie.Model.Typepaie;
import Application.com.GestionDePaie.Service.CorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/co")
public class CorpController {
    @Autowired
    private CorpService corpService;

    // Add new corps
    @PostMapping("/addCorp")
    public Corp addCorp(@RequestBody Corp corp) {
        return corpService.addCorp(corp);
    }

    // Add more than 1 corps
    @PostMapping("/addCorps")
    public List<Corp> addAllCorps(@RequestBody List<Corp> corps) {
        return corpService.addAllCorps(corps);
    }
    // Get corps by Id
    @GetMapping("/getCorpByID/{id}")
    public Corp getCorpById(@PathVariable int id) {
        return corpService.getCorpByID(id);
    }
    // Get corps by name
    @GetMapping("/getCorpByName/{name}")
    public Corp getCorpByID(@PathVariable String name) {
        return  corpService.getCorpByName(name);
    }

    // Update corps
    @PutMapping("/updateCorp")
    public Corp updateCorp(@RequestBody Corp corp) {
        return corpService.updateCorp(corp);
    }

    // Delete corps
    @DeleteMapping("/deleteCorpById/{id}")
    public boolean deleteCorpByID(@PathVariable int id) {
        return corpService.deleteCorpByID(id);
    }
    // Get all corps
    @GetMapping("/getAll")
    public List<Corp> getAllCorp() {
        return corpService.getAllCorps();
    }
}
