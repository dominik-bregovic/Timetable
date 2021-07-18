import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Administrator {
    @Id @GeneratedValue
    @Column(name = "admin", length = 11, nullable = false, unique = true)
    private int id;
    @Column(length = 20)
    String password;
}
