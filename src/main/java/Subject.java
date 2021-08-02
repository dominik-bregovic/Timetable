import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject implements SaveAndDelete {
    @Id @GeneratedValue
    @Column(name = "subject_id", length = 11, nullable = false, unique = true)
    private int subjectId;
    @Column(name = "subject_Name", length = 20)
    private String subjectName;
    @OneToMany
    private List<Student> student = new ArrayList<>();

    public Subject(){
    }

    public Subject(String className){
        this.subjectName = className;
    }

    public int getSubjectID() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }


    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public void addStudent(Student s){
        this.student.add(s);
    }



    @Override
    public boolean saveToDB() {
        if (HibernateSupport.commit(this)){
            return false;
        }
        return false;
    }

    @Override
    public void deleteFromDB() {
        HibernateSupport.deleteObject(this);
    }
}
