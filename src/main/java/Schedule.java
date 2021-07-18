import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Schedule {
    @Id
    @Column
    private Date date;
    @Column
    private Assistant assistant;
    @Column(name = "class")
    private Class aClass;
    @Column
    private Room room;
    @Column
    private Time time;

   /* public Schedule(new Date, new Time){

    }*/
}
