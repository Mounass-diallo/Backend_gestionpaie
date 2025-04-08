package Application.com.GestionDePaie.Service;


import Application.com.GestionDePaie.Model.LeService;
import Application.com.GestionDePaie.Repository.LeServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class LeServiceService {
    @Autowired
    private LeServiceRepository leServiceRepository;
    public LeService addLeService(LeService leService) {
        return leServiceRepository.save(leService);
    }

    public List<LeService> addAllLeServices(List<LeService> leServices) {
        return  leServiceRepository.saveAll(leServices);
    }

    public LeService getLeServiceByID(int id) {
        return leServiceRepository.findById(id).orElse(null);
    }

    public LeService getLeServiceByName(String name) {
        return  leServiceRepository.findByName(name);
    }

    public LeService updateLeService(LeService leService) {
        LeService existingEMP = leServiceRepository.findById(leService.getId()).orElse(null);
        System.out.println(leService);
        if (existingEMP == null) {
            System.out.println("service not found");
            return leServiceRepository.save(leService);
        }else {
            existingEMP.setName(leService.getName());
            leServiceRepository.save(existingEMP);
        }
        return  leService;
    }
    public boolean deleteLeServiceByID(int id) {
        LeService existingEMP = leServiceRepository.getById(id);
        if(existingEMP != null) {
            leServiceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<LeService> getAllLeServices() {
        return leServiceRepository.findAll();
    }

}

