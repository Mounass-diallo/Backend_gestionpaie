package Application.com.GestionDePaie.Controller;


import Application.com.GestionDePaie.EchellonService;
import Application.com.GestionDePaie.Model.Echellon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ech")
public class EchellonController {
    @Autowired
    private EchellonService echellonService;

    @PostMapping("/addEchellon")

    public Echellon addEchellon(@RequestBody Echellon echellon){

        return  echellonService.addEchellon( echellon);
    }
    @PostMapping("/addEchellons")
    public List< Echellon> addAllEchellons(@RequestBody List<Echellon>  echellons){
        return  echellonService.addAllEchellons(echellons);
    }
    @GetMapping("/getEchellonByID/{id}")

    public Echellon getEchellonByID(@PathVariable int id){
        return echellonService.getEchellonByID(id);
    }
    @GetMapping("/getEchellonByName/{name}")
    public Echellon getEchellonByName(@PathVariable String name){
        return echellonService.getEchellonByName(name);
    }

    @PutMapping("/updateEchellon")

    public Echellon updateEchellon(@RequestBody Echellon echellon){
        return echellonService.updateEchellon(echellon);

    }
    @DeleteMapping("/deleteEchellonById/{id}")

    public boolean deleteEchellonByID(@PathVariable int id){

        return echellonService.deleteEchellonByID(id);
    }

    @GetMapping("/getAll")

    public List<Echellon> getAllEchellon() {
        return echellonService.getAllEchellons();
    }
}
