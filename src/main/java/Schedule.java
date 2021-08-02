import javax.persistence.*;
import java.util.Locale;

@Entity
public class Schedule extends User {


    @Id @GeneratedValue
    @Column(name = "Schedule")
    private int id;

    @Column
    private String date;

    @Column
    private String dayOfWeek;

    @Column
    private String timeFrom;

    @Column
    private String timeTo;

    @Column
    //@JoinColumn(name = "the foraign keys name")
    // with the join collum i can prevent Hibernate to map into a new table,
    // so the two tables should be mapped together with their original tables
    private String assistant;

    @Column
    private String subject;

    @OneToOne
    private Room room;


    public Schedule(){
    }

    public Schedule(String date, String day, String from, String until, String a, String s, Room r){
        this.date = date;
        this.dayOfWeek = day;
        this.timeFrom = from;
        this.timeTo = until;
        this.assistant = a;
        this.subject = s;
        this.room = r;
    }

    public void checkDateValue(){


    }

    public void checkDayValue(String dayToCheckOn){
        String checkDay = dayToCheckOn.toLowerCase();

        switch (checkDay) {
            case "monday":
                this.dayOfWeek = "Monday";
            case "tuesday":
                this.dayOfWeek = "Tuesday";
            case "wendnesday":
                this.dayOfWeek = "Wednesday";
            case "thursday":
                this.dayOfWeek = "Thursday";
            case "friday":
                this.dayOfWeek = "Friday";
            case "saturday":
                this.dayOfWeek = "Saturday";
            case "sunday":
                this.dayOfWeek = "Sunday";
            default:
                System.out.println("Wrong input");
                //let the user try again
                //Call InvalidInputError
        }
    }


    public String getAssistant() {
        return assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    /*public void addAssistant(Assistant a){
        this.assistant.add(a);
    }

    public void addSubject(Subject s){
        this.subject.add(s);
    }
    public void addRoom(Room r){
        this.room.add(r);
    }*/

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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
