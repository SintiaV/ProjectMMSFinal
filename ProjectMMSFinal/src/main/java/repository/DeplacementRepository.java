package repository;

import DAO.DeplacementDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeplacementRepository extends MongoRepository<DeplacementDAO, String> {
}
