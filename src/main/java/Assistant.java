import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Assistant {
    @Id @GeneratedValue
    @Column(name = "assist_ID",length = 11, nullable = false, unique = true)
    private int id;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String password;
}
