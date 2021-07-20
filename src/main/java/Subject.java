import javax.persistence.*;

@Entity
public class Subject implements SaveAndDelete{
    @Id @GeneratedValue
    @Column(name = "subject_id", length = 11, nullable = false, unique = true)
    private int subjectId;
    @Column(name = "subject_Name", length = 11)
    private String subjectName;
    @ManyToOne
    private Schedule schedule;

    public Subject(){
    }

    public Subject(String className, Schedule s){
        this.subjectName = className;
        this.schedule = s;
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
