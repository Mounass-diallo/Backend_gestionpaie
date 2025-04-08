package Application.com.GestionDePaie.Service;

import Application.com.GestionDePaie.Model.Banque;
import Application.com.GestionDePaie.Model.Civil;
import Application.com.GestionDePaie.Repository.BanqueRepository;
import Application.com.GestionDePaie.Repository.CivilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CivilService {
    @Autowired
    private CivilRepository civilRepository;

    public Civil addCivil(Civil civil) {
        return civilRepository.save(civil);
    }

    public List<Civil> addAllCivils(List<Civil> civils) {
        return  civilRepository.saveAll(civils);
    }

    public Civil getCivilByID(int id) {
        return civilRepository.findById(id).orElse(null);
    }

    public Civil getCivilByName(String name) {
        return  civilRepository.findByName(name);
    }
    public Civil updateCivil(Civil civil) {
        Civil existingEMP = civilRepository.findById(civil.getId()).orElse(null);
        System.out.println(civil);
        if (existingEMP == null) {
            System.out.println("civil not found");
            return civilRepository.save(civil);
        }else {
            existingEMP.setName(civil.getName());
            civilRepository.save(existingEMP);
        }
        return  civil;
    }
    public boolean deleteCivilByID(int id) {
        Civil existingEMP = civilRepository.getById(id);
        if(existingEMP != null) {
            civilRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Civil> getAllCivils() {
        return civilRepository.findAll();
    }
}
