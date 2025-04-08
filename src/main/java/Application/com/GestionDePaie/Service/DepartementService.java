package Application.com.GestionDePaie.Service;


import Application.com.GestionDePaie.Model.Departement;
import Application.com.GestionDePaie.Repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;
    public Departement addDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    public List<Departement> addAllDepartements(List<Departement> departements) {
        return  departementRepository.saveAll(departements);
    }

    public Departement getDepartementByID(int id) {
        return departementRepository.findById(id).orElse(null);
    }

    public Departement getDepartementByName(String name) {
        return  departementRepository.findByName(name);
    }

    public Departement updateDepartement(Departement departement) {
        Departement existingEMP = departementRepository.findById(departement.getId()).orElse(null);
        System.out.println(departement);
        if (existingEMP == null) {
            System.out.println("depar not found");
            return departementRepository.save(departement);
        }else {
            existingEMP.setName(departement.getName());
            departementRepository.save(existingEMP);
        }
        return  departement;
    }
    public boolean deleteDepartementByID(int id) {
        Departement existingEMP = departementRepository.getById(id);
        if(existingEMP != null) {
            departementRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

}
