package controller;

import DAO.InfirmierDAO;
import DAO.PatientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.PatientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private PatientService service;

    @Autowired
    public PatientController(PatientService service) {

        this.service = service;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<PatientDAO> getAll() {

        return this.service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<PatientDAO> getById(@PathVariable String id) {

        return this.service.getById(id);
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public PatientDAO create(@RequestBody PatientDAO patient) {

        return this.service.create(patient);
    }



    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PatientDAO update(@PathVariable String id, @RequestBody PatientDAO patient) {
        return this.service.update(id, patient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable String id) {
        this.service.delete(id);
        return "{}";
    }

    @PatchMapping("/ajouterInfirmier/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PatientDAO addInfirmier(@PathVariable String id, @RequestBody InfirmierDAO infirmier) {
        return this.service.addInfirmier(id, infirmier);
    }

}
