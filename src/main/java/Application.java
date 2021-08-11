public class Application {

    public static void main(String[] args) {
        // making objects will be part of Admin and Assist
        initializeDatabase();
    }

    public static void initializeDatabase(){

        Student student = new Student( "Nika");
        Student student1 = new Student("Dominik");
        Subject subject = new Subject("Mathematics"); // consider using ENUMS !!!!
        Subject subject1 = new Subject("German");
        Subject subject2= new Subject("English");
        //want to sign in
        //subject.addStudent(student);
        Assistant assistant = new Assistant("Tom", "1234", subject.getSubjectName());
        Assistant assistant1 = new Assistant("Daniel", "1234", subject2.getSubjectName());
        Assistant assistant2= new Assistant("Marko", "1234", subject1.getSubjectName());
        Room room = new Room("East"); // consider using ENUM !!!
        Room room1 = new Room("West");
        Room room2 = new Room("South");
        Schedule schedule = new Schedule("01.01.2021", "wednesday", "08:00", "09:00",assistant.getName(),assistant.getSubject(),room);
        Schedule schedule1 = new Schedule("03.01.2021", "thursday", "08:00", "09:00",assistant.getName(),assistant.getSubject(),room);
        Schedule schedule2 = new Schedule("04.01.2021", "monday", "08:00", "09:00",assistant1.getName(),assistant1.getSubject(),room2);
        Schedule schedule3 = new Schedule("02.01.2021", "tuesday", "11:00", "12:00",assistant2.getName(),assistant2.getSubject(),room1);
        Administrator admin = new Administrator("Domi","12345");


        HibernateSupport.beginTransaction();

        admin.saveToDB();
        subject.saveToDB();
        subject1.saveToDB();
        subject2.saveToDB();
        assistant.saveToDB();
        assistant1.saveToDB();
        assistant2.saveToDB();
        student.saveToDB();
        student1.saveToDB();
        room.saveToDB();
        room1.saveToDB();
        room2.saveToDB();

        schedule.saveToDB();
        schedule1.saveToDB();
        schedule2.saveToDB();
        schedule3.saveToDB();

        HibernateSupport.commitTransaction();

        //StudGui studGui = new StudGui();
        //LogGui gui = new LogGui();
        AdminAssistOrStudInterface logic = new AdminAssistOrStudInterface(new LogGui(), new MyJDBC());
        //if (logic.myJDBC.searchForRecord("name", "assistant", "Tom"))
        //    System.out.println("Hallo");
    }
}
