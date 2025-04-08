package Application.com.GestionDePaie.Service;

import Application.com.GestionDePaie.Model.Agence;
import Application.com.GestionDePaie.Repository.AgenceRepository;
import Application.com.GestionDePaie.Repository.BanqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceService {
    @Autowired
    private AgenceRepository agenceRepository;

    @Autowired
    private BanqueRepository banqueRepository;
    public Agence addAgence(Agence agence) {

        agence.setBanque(banqueRepository.getById(agence.getBanqueId()));
        return agenceRepository.save(agence);
    }

    public List<Agence> addAllAgences(List<Agence> agence) {
        return  agenceRepository.saveAll(agence);
    }

    public Agence getAgenceByID(int id) {
        return agenceRepository.findById(id).orElse(null);
    }

    public Agence getAgenceByName(String name) {
        return  agenceRepository.findByName(name);
    }

    public Agence updateAgence(Agence agence) {
        Agence existingEMP = agenceRepository.findById(agence.getId()).orElse(null);
        System.out.println(agence);
        if(existingEMP == null) {
            System.out.println("agence not found");
            return  agenceRepository.save(agence);
        }else{
            existingEMP.setName(agence.getName());
            existingEMP.setBanque(banqueRepository.getById(agence.getBanqueId()));
            agenceRepository.save(existingEMP);
        }
        return agence;
        }
    public boolean deleteAgenceByID(int id) {
        Agence existingEMP = agenceRepository.getById(id);
        if(existingEMP != null) {
            agenceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Agence> getAllAgences() {
        return agenceRepository.findAll();
    }
}
