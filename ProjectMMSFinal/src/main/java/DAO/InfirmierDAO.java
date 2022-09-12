package DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Infirmiers")
public class InfirmierDAO {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String numTelProf;
    private String numMobile;
    private String numTelFixe;
    @DBRef
    private List<PatientDAO> patients;



    public void addPatients(List<PatientDAO> patients) {
        if (this.patients == null){
            this.patients=new ArrayList<>(patients);
        } else {

            for (int i = 0; i < patients.size(); i++) {
                this.patients.add(patients.get(i));
            }
        }
    }
}
