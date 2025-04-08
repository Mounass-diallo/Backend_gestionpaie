package Application.com.GestionDePaie;

import Application.com.GestionDePaie.Model.Echellon;
import Application.com.GestionDePaie.Repository.EchellonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EchellonService {
    @Autowired
    private EchellonRepository echellonRepository;

    public Echellon addEchellon(Echellon echellon) {

        return echellonRepository.save(echellon);
    }

    public List<Echellon> addAllEchellons(List<Echellon> echellons) {

        return echellonRepository.saveAll(echellons);
    }


    public Echellon getEchellonByID(int id) {
        return echellonRepository.findById(id).orElse(null);
    }


    public Echellon getEchellonByName(String name) {
        return echellonRepository.findByName(name);
    }
    public Echellon updateEchellon(Echellon echellon) {

        Echellon existingEMP = echellonRepository.findById(echellon.getId()).orElse(null);
        if (existingEMP == null) {
            System.out.println("Emp not found");
            return echellonRepository.save(echellon);
        }
        else {

            existingEMP.setName(echellon.getName());
            echellonRepository.save(existingEMP);
        }
        return echellon;
    }

    public boolean deleteEchellonByID(int id) {

        Echellon existingEMP = echellonRepository.getById(id);
        if (existingEMP != null) {
            echellonRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Echellon> getAllEchellons() {
        return echellonRepository.findAll();
    }
}
