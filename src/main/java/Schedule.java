import javax.persistence.*;
import java.util.Date;
import java.sql.Time;

@Entity
public class Schedule extends User{
    @Id @GeneratedValue
    @Column
    private int id;
    @Column @OneToMany
    private Assistant assistant;
    @Column(name = "class")
    private Class aClass;
    @Column
    private Room room;



    public Schedule(){
    }

    public Schedule(Assistant assistant, Class aClass, Room room){
        this.assistant = assistant;
        this. aClass = aClass;
        this.room = room;
    }

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public void delete() {

    }
}
