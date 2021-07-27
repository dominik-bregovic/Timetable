public class Application {

    public static void main(String[] args) {
        Assistant assistant = new Assistant("Tom", "1234");
        Subject subject = new Subject("Mathematiks"); // consider using ENUMS !!!!
        Room room = new Room("East"); // consider using ENUM !!!
        Schedule schedule = new Schedule("01.01.2020", "Monday", "17:00", "17:30",assistant.getName(),subject.getSubjectName(),room.getRoomId());
        Schedule schedule1 = new Schedule("02.01.2020", "Tuesday", "17:00", "17:30",assistant.getName(),subject.getSubjectName(),room.getRoomId());
        Administrator admin = new Administrator("1234");


        HibernateSupport.beginTransaction();
        admin.saveToDB();
        assistant.saveToDB();
        subject.saveToDB();
        room.saveToDB();

        //HibernateSupport.searchEntity(assistant,"Tom");
        schedule.saveToDB();
        schedule1.saveToDB();
        HibernateSupport.commitTransaction();

        //LogGui gui = new LogGui();
        ProgramLogic logic = new ProgramLogic(new LogGui(), new MyJDBC());
        //if (logic.myJDBC.searchForRecord("name", "assistant", "Tom"))
        //    System.out.println("Hallo");
    }
}
