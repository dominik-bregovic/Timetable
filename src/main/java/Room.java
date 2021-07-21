import javax.persistence.*;

@Entity
public class Room implements SaveAndDelete{
    @Id @GeneratedValue
    @Column(name = "room_ID", length = 11, nullable = false, unique = true)
    private int roomId;

    @Column(length = 20)
    private String location;

    public Room(){
    }

    public Room(String location){
        this.location = location;
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

    //the roomId could be a composition of the floor and the room number

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
