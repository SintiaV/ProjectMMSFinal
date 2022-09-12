package service;

import DAO.DeplacementDAO;
import DAO.InfirmierDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DeplacementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DeplacementService {
    private DeplacementRepository repo;

    @Autowired
    DeplacementService (DeplacementRepository repo) {
        this.repo = repo;
    }

    public List<DeplacementDAO> getAll(){
        return this.repo.findAll();
    }

    public Optional<DeplacementDAO> getById (String id) {
        return this.repo.findById(id);
    }

    public DeplacementDAO createDeplacement(DeplacementDAO item) {
        return this.repo.save(item);
    }




    public DeplacementDAO update(String id, DeplacementDAO deplacement) {
//        if(id != patient.getId()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return this.repo.save(deplacement);
    }

    public void delete(String id) {
        this.repo.deleteById(id);
    }

    //PATCH
    public DeplacementDAO addInfirmier(String id, InfirmierDAO infirmier){
        DeplacementDAO deplacement = this.repo.findById(id).get();
        deplacement.addInfirmier(infirmier);
        return this.repo.save(deplacement);
    }



}
