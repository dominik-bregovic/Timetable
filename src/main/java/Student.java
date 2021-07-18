import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student extends User{
    @Id @GeneratedValue
    @Column(name= "student_ID",length = 11, nullable = false, unique = true)
    private int id;
    @Column(length = 20)
    private String name;
    @Column(length = 3)
    final private String password = "msd";

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public void delete() {

    }
}
