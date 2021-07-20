import javax.persistence.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity
public class Schedule extends User{
    @Id
    @Column(name = "Timetable")
    final private String namoOfTable = "My Timetable";
    //@Column
    //private List<Date> dates = new ArrayList<>();
    @OneToMany
    // with the join collum i can prevent Hibernate to map into a new table,
    // so the two tables should be mapped together with their original tables
    private List<Assistant> assistant;
    @Column(name = "subjekt")
    @OneToMany

    private List<Subject> subject = new ArrayList<>();
    @Column
    @OneToMany

    private List<Room> room = new ArrayList<>();



    public Schedule(){
    }

    public Schedule(List<Assistant> a){
        this.assistant = a;
    }


    public List<Assistant> getAssistant() {
        return assistant;
    }

    public void setAssistant(List<Assistant> assistant) {
        this.assistant = assistant;
    }

    public void addAssistant(Assistant a){
        this.assistant.add(a);
    }

    public void addSubject(Subject s){
        this.subject.add(s);
    }
    public void addRoom(Room r){
        this.room.add(r);
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
