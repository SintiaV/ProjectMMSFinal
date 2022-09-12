package DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Patients")
public class PatientDAO {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String dateDeNaissance;
    private String sexe;
    private String addresse;
    private String numSecurite;

    @DBRef
    private InfirmierDAO infirmiers;
}
