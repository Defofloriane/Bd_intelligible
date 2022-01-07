import java.sql.*;
//import java.sql.DriverManager;

import java.sql.Connection;
import java.util.Date;
import java.util.SimpleTimeZone;

public class connect {
    static Connection cnx;
    static Statement st;
    static ResultSet rst;

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            cnx = connecterBD();
//            st = cnx.createStatement();
//            rst = st.executeQuery("SELECT * FROM \"Classe\"");
//
//            while (rst.next()){
//                System.out.print(rst.getInt("cls_id")+"\t");
//                System.out.println(rst.getString("nom_classe")+"\t");
//            }
            //Creer_contrat(" 'ner3456' "," 'defo' ", "'floriane'",78," 'Feminin' ","'ingenieur'","' celibataire' "," 'floriane@gmail.com '");
            Rechercher_contrat("'ner3456'");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static Connection connecterBD(){
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver  ok");

            String url = "jdbc:postgresql://localhost:5432/contrat";
            String user = "contrat";
            String passwd = "contrat";

            Connection conn= DriverManager.getConnection(url,user,passwd);
            System.out.println("Connexion effective !");
            return  conn;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void Creer_contrat(String NumCni, String nom, String prenom, int age,String sexe, String profession, String statut_social, String email){
        try {
            String query= "INSERT INTO \"creer_contrat\"VALUES("+NumCni+","+nom +","+prenom+","+ age+","+sexe+","+profession+","+statut_social+","+email+")";
            cnx = connecterBD();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("compte creer");

        }catch (SQLException e){
            System.out.println( e.getMessage());
        }

    }
    public static void Rechercher_contrat(String cni){
        try {
            String query="SELECT * FROM \"creer_contrat\" WHERE numcni="+cni+" ";

/*
* cnx = connecterBD();
            st= cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int nbrRow = rst.getRow();
            if(nbrRow != 0){
                System.out.println("Classe trouvee");
            }else
                System.out.println("Classe non trouvee");

* */
            cnx = connecterBD();
            st= cnx.createStatement();
            rst=st.executeQuery(query);
            rst.next();
            String numcni = String.valueOf(rst.getRow());
            boolean comparaison = Boolean.parseBoolean(String.valueOf(numcni.compareTo(cni)));

            if(comparaison){

                System.out.println("contrat trouvee");
            }else
                System.out.println("contrat non  trouvee");

            int comparaisons = numcni.compareToIgnoreCase(cni);
            System.out.println(comparaisons);
            System.out.print(cni);
        }catch (SQLException e){
            System.out.println( e.getMessage());
        }
    }
    /*public static void main(String[] args) throws ClassNotFoundException {
        //Connection conn = connecterBD();
       // Creer_ou_ajout_Classe(5," 'chimieL3'");
       //Supprimer_classe(6);
        Rechercher_classe("'infoL2'");//TO DO ERROR
        //Modifier_classe(6," AnglaisL2 ");
       try {
           cnx = connecterBD();
           st = cnx.createStatement();
           rst = st.executeQuery("SELECT * FROM \"Classe\"");

            while (rst.next()){
                System.out.print(rst.getInt("cls_id")+"\t");
                System.out.println(rst.getString("nom_classe")+"\t");
            }

       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }
*/
/*
    public static Connection connecterBD(){
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver  ok");

            String url = "jdbc:postgresql://localhost:5432/ICT2";
            String user = "ict2";
            String passwd = "ict2";

            Connection conn= DriverManager.getConnection(url,user,passwd);
            System.out.println("Connexion effective !");
            return  conn;
        }catch (Exception e) {
            e.printStackTrace();
           return null;
        }
    }*/

    /*public static void Creer_ou_ajout_Classe(int cls_id,String nom_classe){
        try {
           String query= "INSERT INTO \"Classe\"VALUES("+cls_id+","+nom_classe +")";
           cnx = connecterBD();
           st=cnx.createStatement();
           st.executeUpdate(query);
           System.out.println("CLASSE CREEER");

        }catch (SQLException e){
          System.out.println( e.getMessage());
        }

    }
*/
//    public static void Supprimer_classe(int cls_id){
//        try {
//            String query="DELETE FROM \"Classe\" WHERE cls_id="+cls_id;
//            cnx = connecterBD();
//            st= cnx.createStatement();
//            st.executeUpdate(query);
//            System.out.println("Classe supprimer");
//
//        }catch (SQLException e){
//            System.out.println( e.getMessage());
//        }
//    }
/*    public static void Rechercher_classe(String nom_classe){
        try {
           String query="SELECT * FROM \"Classe\"  WHERE nom_classe ='"+nom_classe+"'";
            //String query=("SELECT \"Classe\" + ?::nom_classe;");
//            PreparedStatement hj=cnx.prepareStatement("select cls_id from \"Classe\" where cls_id=? and nom_classe=?" );
//            hj.setString(1,"infoL2");


            cnx = connecterBD();
            st= cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int nbrRow = rst.getRow();
            if(nbrRow != 0){
                System.out.println("Classe trouvee");
            }else
                System.out.println("Classe non trouvee");


        }catch (SQLException e){
            System.out.println( e.getMessage());
        }
    }*/
    public static void Modifier_classe(int cls_id,String nom_classe){
        try {
            String query="UPDATE \"Classe\" SET nom_classe= ' "+ nom_classe+ " ' WHERE cls_id= "+cls_id+ " ";
            cnx = connecterBD();
            st= cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Classe modifiee");

        }catch (SQLException e){
            System.out.println( e.getMessage());
        }
    }
}
