package controller;

import DAO.InfirmierDAO;
import DAO.PatientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.InfirmierService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/infirmier")
@CrossOrigin
public class InfirmierController {
    private InfirmierService service;

    @Autowired
    public InfirmierController(InfirmierService service) {

        this.service = service;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<InfirmierDAO> getAll() {

        return this.service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<InfirmierDAO> getById(@PathVariable String id) {

        return this.service.getById(id);
    }

    @GetMapping("/name/{nom}")
    @ResponseStatus(HttpStatus.OK)
    public InfirmierDAO getByNom(@PathVariable String nom) {

        return this.service.getByName(nom);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public InfirmierDAO create(@RequestBody InfirmierDAO infirmier) {

        return this.service.create(infirmier);
    }

//    @PatchMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public InfirmierDAO updatePatients(@RequestBody PatientDAO patient, @PathVariable String id) {
//        return this.service.addPatient(id, patient);
//    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InfirmierDAO update(@PathVariable String id, @RequestBody InfirmierDAO infirmier) {
        return this.service.update(id, infirmier);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable String id) {
        this.service.delete(id);
        return "{}";
    }

    @PatchMapping("/ajouterPatient/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InfirmierDAO addPatient(@PathVariable String id, @RequestBody List<PatientDAO> patients) {
        return this.service.addPatient(id, patients);
    }

}
