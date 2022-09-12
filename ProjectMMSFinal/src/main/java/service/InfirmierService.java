package service;

import DAO.InfirmierDAO;
import DAO.PatientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.InfirmierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InfirmierService {
    private InfirmierRepository repo;
    @Autowired
    public InfirmierService (InfirmierRepository repo) {

        this.repo=repo;
    }
    public List<InfirmierDAO> getAll(){

        return this.repo.findAll();
    }
    public Optional<InfirmierDAO> getById (String id) {

        return this.repo.findById(id);
    }

    public InfirmierDAO getByName (String nom) {
        return this.repo.findInfirmierDAOByNom(nom);
    }

    public InfirmierDAO create (InfirmierDAO infirmier) {

        return this.repo.insert(infirmier);
    }
    public InfirmierDAO update (String id, InfirmierDAO infirmier) {
//        if(id != infirmier.getId()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return this.repo.save(infirmier);
    }

    public void delete(String id){

        this.repo.deleteById(id);

    }


    public InfirmierDAO addPatient (String id, List<PatientDAO> patients) {
        InfirmierDAO doc = this.repo.findById(id).get();
        System.out.println(doc);
        System.out.println(patients);
        doc.addPatients(patients);
        return this.repo.save(doc);
    }

}
