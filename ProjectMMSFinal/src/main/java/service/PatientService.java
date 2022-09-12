package service;

import DAO.InfirmierDAO;
import DAO.PatientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private PatientRepository repo;

    @Autowired
    public PatientService(PatientRepository repo) {

        this.repo = repo;
    }

    public List<PatientDAO> getAll() {

        return this.repo.findAll();
    }

    public Optional<PatientDAO> getById(String id) {

        return this.repo.findById(id);
    }


    //    public Optional<PatientDAO> getByName (String nom) {
//        return this.repo.findByName(nom);
//    }
    public PatientDAO create(PatientDAO patient) {

        return this.repo.insert(patient);
    }

    public PatientDAO update(String id, PatientDAO patient) {
//        if(id != patient.getId()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return this.repo.save(patient);
    }

    public void delete(String id) {
        this.repo.deleteById(id);
    }


    public PatientDAO addInfirmier (String id, InfirmierDAO infirmier){
        PatientDAO patient = this.repo.findById(id).get();
        patient.setInfirmiers(infirmier);
        return this.repo.save(patient);
    }
}
