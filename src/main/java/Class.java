import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Class {
    @Id @GeneratedValue
    @Column(name = "class_ID", length = 11, nullable = false, unique = true)
    private int classID;
    @Column(length = 11)
    private String className;

    public Class(){
    }

    public Class( String className){
        this.className = className;
    }
}
