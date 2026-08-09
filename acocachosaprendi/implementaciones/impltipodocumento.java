package acocachosaprendi.implementaciones;

import acocachosaprendi.bd.Conexion;
import acocachosaprendi.clases.tipodocumento;
import acocachosaprendi.interfases.Itipodocumento;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class impltipodocumento implements Itipodocumento{
    
    private final Conexion objconexion = new Conexion();
    //creamos una variable para la conexion
    private Connection xcon = null;
    //para poder guardar los resultados de la consulta ResultSet
    private ResultSet rs = null;
    //para poder realizar la consulta a la BD utilizamos Statment
    private Statement st = null;
    private PreparedStatement pst = null;
    //definimos el modelo de la tabla
    DefaultTableModel modelo = null; 


    @Override
    public void findall(JTable jtbtipodocumento) {
        Object[] fila = new Object[3];
        String columna[] = {"Codigo", "Nombre", "Estado"}; 
        modelo = new DefaultTableModel(null, columna);
        try {
            //nos conectamos a la base de datos
            xcon = objconexion.Conectar();
            //generamos la consulta a la base de datos
            st = xcon.createStatement();
            //ejecutamos la sentencia SQL
            rs = st.executeQuery("select * from tipodocumento");
            //cargamos los datos en el JTable
            while (rs.next()) {
                fila[0] = rs.getInt("codtipd");
                fila[1] = rs.getString("nomtipd");
                if (rs.getBoolean("esttipd") == true) {
                    fila[2] = "Habilitado";
                } else {
                    fila[2] = "Deshabilitado";
                }
                //agregas las filas al modelo
                modelo.addRow(fila);
            }
            //enviamos el modelo al JTable
            jtbtipodocumento.setModel(modelo);
        } catch (SQLException ex) {
        System.out.println("Error:" + ex.toString());
        }
    } 

    @Override
    public void findById(JTable jtbtipodocumento, int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void findByName(JTable jtbtipodocumento, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int GenerarCodigo() {
        int codigo = 0;
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("select max(codtipd)+1 as CodigoNuevo from tipodocumento");
            //cargamos los datos en el JTable
            while (rs.next()) {
                codigo = rs.getInt("CodigoNuevo");
            }
            return codigo;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
            return 0;
        }
    }

    @Override
    public boolean add(tipodocumento obj) {
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            pst = xcon.prepareStatement("insert into tipodocumento(codtipd,nomtipd,esttipd) values(seq_tipodocumento.NEXTVAL,?,?)");
            pst.setString(1, obj.getNombre());
            pst.setBoolean(2, obj.isEstado());
            int res = pst.executeUpdate();
            return res == 1;
        } catch (SQLException ex) {
        System.out.println("Error: " + ex.toString());
        return false;
        } 
    }

    @Override
    public boolean update(tipodocumento obj) {
       try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareCall("update tipodocumento set nomtipd=?, esttipd=? where codtipd=?");
            pst.setString(1, obj.getNombre());
            pst.setBoolean(2, obj.isEstado());
            pst.setInt(3, obj.getCodigo());
            int res = pst.executeUpdate();
            return res == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
            return false;
        } 
    }

    @Override
    public boolean delete(tipodocumento obj) {
        try {
            xcon = objconexion.Conectar();
            //pst = xcon.prepareCall("delete from tipodocumento where codtipd=?");
            pst = xcon.prepareCall("update tipodocumento set esttipd=0 where codtipd=?");
            pst.setInt(1, obj.getCodigo());
            int res = pst.executeUpdate();
            return res == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
            return false;
        }
    }

    @Override
    public boolean enable(tipodocumento obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void findAllCustom(JTable jtbtipodocumento) {
        Object[] fila = new Object[3];
        String columna[] = {"Codigo", "Nombre", "Estado"};
        //instanciamos el modelo
        modelo = new DefaultTableModel(null, columna);
        try {
            //nos conectamos a la base de datos
            xcon = objconexion.Conectar();
            //generamos la consulta a la base de datos
            st = xcon.createStatement();
            //ejecutamos la sentencia SQL
            rs = st.executeQuery("select * from tipodocumento where esttipd=1");
            //cargamos los datos en el JTable
            while (rs.next()) {
                fila[0] = rs.getInt("codtipd");
                fila[1] = rs.getString("nomtipd");
                //fila[2]=rs.getBoolean("estdis"); -> true o false
                if (rs.getBoolean("esttipd") == true) {
                    fila[2] = "Habilitado";
                } else {
                    fila[2] = "Deshabilitado";
            }
            //agregas las filas al modelo
            modelo.addRow(fila);
        }
        //enviamos el modelo al JTable
        jtbtipodocumento.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        } 
       }

    @Override
    public void CargarCombo(JComboBox cbotipodocumento) {
        String tipd = "";
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("select * from tipodocumento where esttipd=1");
            cbotipodocumento.addItem("Seleccione un tipo de documento");
            //cargamos los datos en el JTable
            while (rs.next()) {
                tipd = rs.getString("nomtipd");
                cbotipodocumento.addItem(tipd);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }

    }
    
}
