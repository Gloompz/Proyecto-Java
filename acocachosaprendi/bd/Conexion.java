package acocachosaprendi.bd;
import java.sql.*;

public class Conexion {
   //objeto de la clase Connection
    private Connection xcon = null;
    //cadena de conexion -> Oracle
    private final String cadena = "jdbc:oracle:thin:@localhost:1521/xe";
    //usuario de la bd
    private final String usuario = "SYSTEM";
    //clave de la base de datos
    private final String clave = "123";

    //creamos una funcion para conectar a la base de datos
    public  Connection Conectar() {
        try {
            //instanceamos el driver -> Oracle
            Class.forName("oracle.jdbc.OracleDriver");
            xcon = DriverManager.getConnection(cadena,usuario, clave);
            System.out.println("La conexion se realizo con exito");
            return xcon;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error: " + ex.toString());
            return null;
        }
    }
}

