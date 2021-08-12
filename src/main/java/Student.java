import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * Author: Bregovic Dominik
 * hibernate student class
 * Last change: 12.08.2021
 */

@Entity
public class Student extends User {
    @Id @GeneratedValue
    @Column(name= "student_ID",length = 11, nullable = false, unique = true)
    private int id;
    @Column(length = 20)
    private String name;
    @Column(length = 3)
    final private String password = "msd";

    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

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
