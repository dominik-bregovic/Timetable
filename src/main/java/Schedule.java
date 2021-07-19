import javax.persistence.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Schedule extends User{
    @Id @GeneratedValue
    @Column
    private int id;
    @Column
    @OneToMany
    private List<Assistant> assistant;
    @Column(name = "class")
    @OneToMany
    private List<Class> aClass;
    @Column
    @OneToMany
    private List<Room> room;



    public Schedule(){
    }

    public Schedule(Assistant assistant, Class aClass, Room room){
        this.assistant.add(assistant);
        this. aClass.add(aClass);
        this.room.add(room);
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
