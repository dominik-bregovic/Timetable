public class Application {

    public static void main(String[] args) {
        Assistant assistant = new Assistant("Tom", "1234");
        Student student = new Student( "Nika");
        Subject subject = new Subject("Mathematiks"); // consider using ENUMS !!!!
        Room room = new Room("East"); // consider using ENUM !!!
        Schedule schedule = new Schedule("01.01.2021", "monday", "08:00", "09:00",assistant.getName(),subject.getSubjectName(),room.getRoomId());
        Schedule schedule1 = new Schedule("02.01.2021", "tuesday", "11:00", "12:00",assistant.getName(),subject.getSubjectName(),room.getRoomId());
        Administrator admin = new Administrator("Domi","12345");


        HibernateSupport.beginTransaction();
        admin.saveToDB();
        assistant.saveToDB();
        student.saveToDB();
        subject.saveToDB();
        room.saveToDB();

        //HibernateSupport.searchEntity(assistant,"Tom");
        schedule.saveToDB();
        schedule1.saveToDB();
        HibernateSupport.commitTransaction();

        //StudGui studGui = new StudGui();
        //LogGui gui = new LogGui();
        ProgramLogic logic = new ProgramLogic(new LogGui(), new MyJDBC());
        //ProgramLogic logic2 = new ProgramLogic(new LogGui(), new MyJDBC());
        //if (logic.myJDBC.searchForRecord("name", "assistant", "Tom"))
        //    System.out.println("Hallo");
    }
}
