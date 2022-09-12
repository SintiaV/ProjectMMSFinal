package repository;

import DAO.InfirmierDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfirmierRepository extends MongoRepository<InfirmierDAO, String> {
    InfirmierDAO findInfirmierDAOByNom(String nom);
}
