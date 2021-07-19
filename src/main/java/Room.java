import javax.persistence.*;

@Entity
public class Room {
    @Id @GeneratedValue
    @Column(name = "room_ID", length = 11, nullable = false, unique = true)
    private int roomId;
    @Column(length = 20)
    private String location;
    /*@ManyToOne
    private Schedule schedule;*/

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
}
