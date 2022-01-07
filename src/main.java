import java.sql.Connection;

public class main {
    public static void main(String[] args) {
        setupDriver();
    }

        private  static void setupDriver(){
            try {
                Class.forName("org.postgresql.Driver");
                System.out.println("driver okay");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
}
