import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/*
 * Author: Bregovic Dominik
 * hibernate subject class
 * Last change: 12.08.2021
 */

@Entity
public class Subject implements SaveAndDelete {
    @Id @GeneratedValue
    @Column(name = "subject_id", length = 11, nullable = false, unique = true)
    private int subjectId;
    @Column(name = "subject_Name", length = 20)
    private String subjectName;
    @ManyToMany
    private List<Student> students = new ArrayList<>();

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student s){
        this.students.add(s);
    }



    @Override
    public void saveToDB() {
        HibernateSupport.commit(this);
    }

    @Override
    public void deleteFromDB() {
        HibernateSupport.deleteObject(this);
    }
}
