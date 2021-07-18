import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {
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
}
