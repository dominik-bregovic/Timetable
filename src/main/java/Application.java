import javax.persistence.EntityManager;
import java.sql.Date;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        Schedule schedule = new Schedule(new ArrayList<>());
        Assistant assistant = new Assistant("Tom", "qwe", schedule);
        Subject subject = new Subject("Mathematiks", schedule); // consider using ENUMS !!!!
        Room room = new Room("East",schedule); // consider using ENUM !!!

        schedule.addAssistant(assistant);
        schedule.addSubject(subject);
        schedule.addRoom(room);

        Administrator admin = new Administrator("1234");


        HibernateSupport.beginTransaction();
        admin.saveToDB();
        assistant.saveToDB();
        subject.saveToDB();
        room.saveToDB();


        schedule.saveToDB();

        HibernateSupport.commitTransaction();

    }
}
