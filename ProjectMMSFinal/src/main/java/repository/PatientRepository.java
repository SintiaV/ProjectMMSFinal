package repository;

import DAO.PatientDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<PatientDAO, String> {
    PatientDAO findPatientDAOByNom(String nom);
}
