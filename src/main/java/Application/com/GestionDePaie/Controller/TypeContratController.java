package Application.com.GestionDePaie.Controller;

import Application.com.GestionDePaie.Model.TypeContrat;
import Application.com.GestionDePaie.Service.TypeContratService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ty")
public class TypeContratController {
    @Autowired
    private TypeContratService typeContratService;

    @PostMapping("/addTypeContrat")
    public TypeContrat addTypeContrat(@RequestBody TypeContrat typeContrat){
        return typeContratService.addTypeContrat(typeContrat);
    }

    @PostMapping("/addTypeContrats")
    public List<TypeContrat> addAllTypeContrat(@RequestBody List<TypeContrat> typeContrats){

        return typeContratService.addAllTypeContrats(typeContrats);
    }
    @GetMapping("/getTypeContratByID/{id}")

    public TypeContrat getTypeContratByID(@PathVariable int id)
    {

        return typeContratService.getTypeContratByID(id);
    }
    @GetMapping("/getTypeContratByName/{name}")
    public TypeContrat getTypeContratByName(@PathVariable String name){

        return typeContratService.getTypeContratByName(name);
    }

    @PutMapping("/updateTypeContrat")

    public TypeContrat updateTypeContrat(@RequestBody TypeContrat typeContrat){
        return typeContratService.updateTypeContrat(typeContrat);

    }
    @DeleteMapping("/deleteTypeContratById/{id}")

    public boolean deleteTypeContratByID(@PathVariable int id){

        return typeContratService.deleteTypeContratByID(id);
    }

    @GetMapping("/getAll")

    public List<TypeContrat> getAllTypeContrat() {

        return typeContratService.getAllTypeContrats();
    }
}
