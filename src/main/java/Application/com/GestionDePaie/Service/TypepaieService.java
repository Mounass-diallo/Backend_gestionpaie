package Application.com.GestionDePaie.Service;

import Application.com.GestionDePaie.Model.Civil;
import Application.com.GestionDePaie.Model.Employee;
import Application.com.GestionDePaie.Model.Typepaie;
import Application.com.GestionDePaie.Repository.CivilRepository;
import Application.com.GestionDePaie.Repository.TypepaieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypepaieService {
    @Autowired
    private TypepaieRepository typepaieRepository;

    public Typepaie addTypepaie(Typepaie typepaie) {
        return typepaieRepository.save(typepaie);
    }

    public List<Typepaie> addAllTypepaies(List<Typepaie> typepaies) {
        return  typepaieRepository.saveAll(typepaies);
    }

    public Typepaie getTypepaieByID(int id) {
        return typepaieRepository.findById(id).orElse(null);
    }

    public Typepaie getTypepaieByName(String name) {
        return  typepaieRepository.findByName(name);
    }
    public Typepaie updateTypepaie(Typepaie typepaie) {
        Typepaie existingEMP = typepaieRepository.findById(typepaie.getId()).orElse(null);
        System.out.println(typepaie);
        if (existingEMP == null) {
            System.out.println("civil not found");
            return typepaieRepository.save(typepaie);
        }else {
            typepaieRepository.save(existingEMP);
        }
        return  typepaie;
    }
    public boolean deleteTypepaieByID(int id) {
        Typepaie existingEMP = typepaieRepository.getById(id);
        if(existingEMP != null) {
            typepaieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Typepaie> getAllTypepaies() {
        return typepaieRepository.findAll();
    }
}
