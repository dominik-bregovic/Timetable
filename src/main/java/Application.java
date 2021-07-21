import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Assistant assistant = new Assistant("Tom", "Mathematiks");
        Subject subject = new Subject("Mathematiks"); // consider using ENUMS !!!!
        Room room = new Room("East"); // consider using ENUM !!!

        Schedule schedule = new Schedule("01.01.2020", "Monday", "17:00", "17:30",assistant.getName(),subject.getSubjectName(),room.getRoomId());
        Schedule schedule1 = new Schedule("02.01.2020", "Tuesday", "17:00", "17:30",assistant.getName(),subject.getSubjectName(),room.getRoomId());
        /*schedule.addAssistant(assistant);
        schedule.addSubject(subject);
        schedule.addRoom(room);*/

        Administrator admin = new Administrator("1234");


        HibernateSupport.beginTransaction();
        admin.saveToDB();
        assistant.saveToDB();
        subject.saveToDB();
        room.saveToDB();

        schedule.saveToDB();
        schedule1.saveToDB();
        HibernateSupport.commitTransaction();

    }
}
