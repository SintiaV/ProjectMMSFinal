package controller;

import DAO.DeplacementDAO;
import DAO.InfirmierDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.DeplacementService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deplacement")
public class DeplacementController {
    private DeplacementService service;


    @Autowired
    public DeplacementController(DeplacementService service) {

        this.service = service;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<DeplacementDAO> getAll() {

        return this.service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<DeplacementDAO> getById(@PathVariable String id) {

        return this.service.getById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public DeplacementDAO createDeplacement(@RequestBody DeplacementDAO deplacement) {

        return this.service.createDeplacement(deplacement);
    }
    //La mmethode génére un nouvel objet !!!! A revoir
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeplacementDAO update(@PathVariable String id, @RequestBody DeplacementDAO deplacement) {
        return this.service.update(id, deplacement);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable String id) {
        this.service.delete(id);
        return "{}";
    }

    @PatchMapping("/ajouterDeplacement/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeplacementDAO addDeplacement(@PathVariable String id, @RequestBody InfirmierDAO infirmier) {
        return this.service.addInfirmier(id, infirmier);
    }



    //PATCH a revoir
    // @PatchMapping("/{id}")
    // @ResponseStatus(HttpStatus.OK)
    // public InfirmierDAO updatePatients(@RequestBody PatientDAO patient, @PathVariable String id) {
    // return this.service.addPatient(id, patient);
}
