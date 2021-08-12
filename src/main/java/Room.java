import javax.persistence.*;
/*
 * Author: Bregovic Dominik
 * hibernate room class
 * Last change: 12.08.2021
 */


@Entity
public class Room implements SaveAndDelete {
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
    public void saveToDB() {
        if (HibernateSupport.commit(this)){
        }
    }

    @Override
    public void deleteFromDB() {
        HibernateSupport.deleteObject(this);
    }
}
