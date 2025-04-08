package Application.com.GestionDePaie.Service;

import Application.com.GestionDePaie.Model.Modepaiement;
import Application.com.GestionDePaie.Repository.ModepaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModepaiementService {
    @Autowired
    private ModepaiementRepository modepaiementRepository;

    public Modepaiement addModepaiement(Modepaiement modepaiement) {
        return modepaiementRepository.save(modepaiement);
    }

    public List<Modepaiement> addAllModepaiements(List<Modepaiement> modepaiements) {
        return  modepaiementRepository.saveAll(modepaiements);
    }

    public Modepaiement getModepaiementByID(int id) {
        return modepaiementRepository.findById(id).orElse(null);
    }

    public Modepaiement getModepaiementByName(String name) {
        return  modepaiementRepository.findByName(name);
    }

    public Modepaiement updateModepaiement(Modepaiement modepaiement) {
        Modepaiement existingEMP = modepaiementRepository.findById(modepaiement.getId()).orElse(null);
        System.out.println(modepaiement);
        if (existingEMP == null) {
            System.out.println("mode paiement not found");
            return modepaiementRepository.save(modepaiement);
        }else {
            modepaiementRepository.save(existingEMP);
        }
        return  modepaiement;
    }
    public boolean deleteModepaiementByID(int id) {
        Modepaiement existingEMP = modepaiementRepository.getById(id);
        if(existingEMP != null) {
            modepaiementRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Modepaiement> getAllModepaiements() {
        return modepaiementRepository.findAll();
    }
}
