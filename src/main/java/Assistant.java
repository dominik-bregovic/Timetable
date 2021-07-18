import javax.persistence.*;

@Entity
public class Assistant extends User {
    @Id @GeneratedValue
    @Column(name = "assist_ID",length = 11, nullable = false, unique = true)
    private int id;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String password;
    @ManyToOne
    private Schedule schedule;

    public Assistant() {
    }

    public Assistant(String name, String pass) {
        this.name = name;
        this.password = pass;
    }

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public void delete() {

    }
}
