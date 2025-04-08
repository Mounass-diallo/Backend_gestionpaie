package Application.com.GestionDePaie.Service;

import Application.com.GestionDePaie.Model.Corp;
import Application.com.GestionDePaie.Repository.CorpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorpService {
    @Autowired
    private CorpRepository corpRepository;

    public Corp addCorp(Corp corp) {
        return corpRepository.save(corp);
    }

    public List<Corp> addAllCorps(List<Corp> corps) {
        return  corpRepository.saveAll(corps);
    }

    public Corp getCorpByID(int id) {
        return corpRepository.findById(id).orElse(null);
    }

    public Corp getCorpByName(String name) {
        return  corpRepository.findByName(name);
    }

    public Corp updateCorp(Corp corp) {
        Corp existingEMP = corpRepository.findById(corp.getId()).orElse(null);
        System.out.println(corp);
        if (existingEMP == null) {
            System.out.println("corps not found");
            return corpRepository.save(corp);
        }else {
            existingEMP.setName(corp.getName());
            corpRepository.save(existingEMP);
        }
        return corp;
    }
    public boolean deleteCorpByID(int id) {
        Corp existingEMP = corpRepository.getById(id);
        if(existingEMP != null) {
            corpRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Corp> getAllCorps() {
        return corpRepository.findAll();
    }
}
