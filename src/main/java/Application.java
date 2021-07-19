
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Administrator admin = new Administrator("1234");
        Assistant assistant = new Assistant("Tom", "qwe");

        Class aClass = new Class("Mathematiks"); // consider using ENUMS !!!!
        Room room = new Room("East"); // consider using ENUM !!!

        /////here i have an annotaion error, the relationships are wrong

        //Schedule schedule = new Schedule(assistant, aClass, room);

        HibernateSupport.beginTransaction();
        //schedule.saveToDB();
        admin.saveToDB();
        HibernateSupport.commitTransaction();

    }
}
