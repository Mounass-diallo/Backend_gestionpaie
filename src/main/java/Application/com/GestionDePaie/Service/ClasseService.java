package Application.com.GestionDePaie.Service;

import Application.com.GestionDePaie.Model.Civil;
import Application.com.GestionDePaie.Model.Classe;
import Application.com.GestionDePaie.Repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService {
    @Autowired
    private ClasseRepository classeRepository;

    public Classe addClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    public List<Classe> addAllClasses(List<Classe> classes) {
        return  classeRepository.saveAll(classes);
    }

    public Classe getClasseByID(int id) {
        return classeRepository.findById(id).orElse(null);
    }

    public Classe getClasseByName(String name) {
        return  classeRepository.findByName(name);
    }

    public Classe updateClasse(Classe classe) {
        Classe existingEMP = classeRepository.findById(classe.getId()).orElse(null);
        System.out.println(classe);
        if (existingEMP == null) {
            System.out.println("clas not found");
            return classeRepository.save(classe);
        }else {
            existingEMP.setName(classe.getName());
            classeRepository.save(existingEMP);
        }
        return  classe;
    }
    public boolean deleteClasseByID(int id) {
        Classe existingEMP = classeRepository.getById(id);
        if(existingEMP != null) {
            classeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }
}


