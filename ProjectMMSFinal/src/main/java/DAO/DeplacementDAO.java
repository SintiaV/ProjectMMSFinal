package DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Deplacement") //mettre un S
public class DeplacementDAO {
    @Id
    private String id;
    private Double cout;
    private String date;

    @DBRef
    private List<InfirmierDAO> infirmieres;
    @DBRef
    private PatientDAO patients;

    public void add(DeplacementDAO deplacement) {
        this.add(deplacement);
    }

    public void addInfirmier(InfirmierDAO infirmier) {
        this.addInfirmier(infirmier);
    }
}
