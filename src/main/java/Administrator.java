import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Administrator extends User {
    @Id @GeneratedValue
    @Column(name = "id", length = 11, nullable = false, unique = true)
    private int id;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String password;

    public Administrator() {
    }

    public Administrator(String name, String pass) {
        this.name = name;
        this.password = pass;
    }
////////////////////////////////////////
    private void registerNewAdmin(){

    }

    private void deleteAdmin(){

    }
/////////////////////////////////////////

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
