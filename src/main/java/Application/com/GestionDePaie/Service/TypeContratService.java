package Application.com.GestionDePaie.Service;

import Application.com.GestionDePaie.Model.TypeContrat;
import Application.com.GestionDePaie.Repository.TypeContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeContratService {
    @Autowired
    private TypeContratRepository typeContratRepository;
    public TypeContrat addTypeContrat(TypeContrat typeContrat) {
        return typeContratRepository.save(typeContrat);
    }

    public List<TypeContrat> addAllTypeContrats(List<TypeContrat> typeContrats) {
        return typeContratRepository.saveAll(typeContrats);
    }
    public TypeContrat getTypeContratByID(int id) {
        return typeContratRepository.findById(id).orElse(null);
    }

    public TypeContrat getTypeContratByName(String name) {
        return typeContratRepository.findByName(name);
    }

    public TypeContrat updateTypeContrat(TypeContrat typeContrat) {
        TypeContrat existingEMP = typeContratRepository.findById(typeContrat.getId()).orElse(null);
        if (existingEMP == null) {
            System.out.println("TypeContrat not found");
            return typeContratRepository.save(typeContrat);
        }
        else {

            existingEMP.setName(typeContrat.getName());

            typeContratRepository.save(existingEMP);
        }
        return typeContrat;
    }
    public boolean deleteTypeContratByID(int id) {
        TypeContrat existingEMP = typeContratRepository.getById(id);
        if (existingEMP != null) {
            typeContratRepository.deleteById(id);
            return true;
        }
        return false;

    }

    public List<TypeContrat> getAllTypeContrats() {
        return typeContratRepository.findAll();
    }

}
