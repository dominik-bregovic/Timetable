import javax.persistence.*;

    @Entity
    public class Assistant extends User {
        @Id
        @GeneratedValue
        @Column(name = "assistant_id",length = 11, nullable = false, unique = true)
        private int id;
        @Column(length = 20)
        private String name;
        @Column(length = 20)
        private String password;


        public Assistant() {
        }

        public Assistant(String name, String pass) {
            this.name = name;
            this.password = pass;
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

        public void setPassword(String password) {
            this.password = password;
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

