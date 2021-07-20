import javax.persistence.*;

@Entity
public class Room implements SaveAndDelete{
    @Id @GeneratedValue
    @Column(name = "room_ID", length = 11, nullable = false, unique = true)
    private int roomId;
    @Column(length = 20)
    private String location;
    @ManyToOne
    private Schedule schedule;

    public Room(){
    }

    public Room(String location, Schedule s){
        this.location = location;
        this.schedule = s;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
