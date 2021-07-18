
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Administrator admin = new Administrator("1234");
        HibernateSupport support = new HibernateSupport();

        HibernateSupport.beginTransaction();
        admin.saveToDB();
        HibernateSupport.commitTransaction();

    }
}
