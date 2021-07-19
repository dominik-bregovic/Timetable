import javax.persistence.*;

@Entity
public class Class {
    @Id @GeneratedValue
    @Column(name = "class_ID", length = 11, nullable = false, unique = true)
    private int classID;
    @Column(length = 11)
    private String className;
    /*@ManyToOne
    private Schedule schedule;*/

    public Class(){
    }

    public Class( String className){
        this.className = className;
    }

    public int getClassID() {
        return classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
