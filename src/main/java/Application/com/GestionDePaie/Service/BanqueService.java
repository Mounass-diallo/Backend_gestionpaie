package Application.com.GestionDePaie.Service;

import Application.com.GestionDePaie.Model.Banque;
import Application.com.GestionDePaie.Repository.BanqueRepository;
import Application.com.GestionDePaie.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BanqueService {

    @Autowired
    private BanqueRepository banqueRepository;

    public Banque addBanque(Banque banque) {
        return banqueRepository.save(banque);
    }

    public List<Banque> addAllBanques(List<Banque> banques) {
        return  banqueRepository.saveAll(banques);
    }

    public Banque getBanqueByID(int id) {
        return banqueRepository.findById(id).orElse(null);
    }

    public Banque getBanqueByName(String name) {
        return  banqueRepository.findByName(name);
    }


    public Banque updateBanque(Banque banque) {
        Banque existingEMP = banqueRepository.findById(banque.getId()).orElse(null);
        System.out.println(banque);
        if (existingEMP == null) {
            System.out.println("bank not found");
            return banqueRepository.save(banque);
        }else {
            existingEMP.setName(banque.getName());
            banqueRepository.save(existingEMP);
        }
       return  banque;
    }
        public boolean deleteBanqueByID(int id) {
            Banque existingEMP = banqueRepository.getById(id);
            if(existingEMP != null) {
                banqueRepository.deleteById(id);
                return true;
            }
            return false;
        }

        public List<Banque> getAllBanques() {
            return banqueRepository.findAll();
        }

}
