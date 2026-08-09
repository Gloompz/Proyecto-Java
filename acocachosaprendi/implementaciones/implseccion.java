package acocachosaprendi.implementaciones;

import acocachosaprendi.bd.Conexion;
import acocachosaprendi.clases.seccion;
import acocachosaprendi.interfases.Iseccion;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class implseccion implements Iseccion{
    
    private Conexion objconexion = new Conexion();
    private Connection xcon = null;
    private ResultSet rs = null;
    private Statement st = null;
    private PreparedStatement pst = null;
    private DefaultTableModel modelo = null;

    @Override
    public void findAll(JTable jtbseccion) {
        Object[] fila = new Object[3];
        String columna[] = {"Código", "Nombre", "Estado"};
        modelo = new DefaultTableModel(null, columna);
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT * FROM seccion");
            while (rs.next()) {
                fila[0] = rs.getInt("codsec");
                fila[1] = rs.getString("nomsec");
                if (rs.getBoolean("estsec") == true) {
                    fila[2] = "Habilitado";
                } else {
                    fila[2] = "Deshabilitado";
                }
                modelo.addRow(fila);
            }
            jtbseccion.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
    }

    @Override
    public void findAllCustom(JTable jtbseccion) {
        Object[] fila = new Object[3];
        String columna[] = {"Código", "Nombre", "Estado"};
        modelo = new DefaultTableModel(null, columna);
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT * FROM seccion WHERE estsec=1");
            while (rs.next()) {
                fila[0] = rs.getInt("codsec");
                fila[1] = rs.getString("nomsec");
                fila[2] = "Habilitado";
                modelo.addRow(fila);
            }
            jtbseccion.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
    }

    @Override
    public void findById(JTable jtbseccion, int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void findByName(JTable jtbseccion, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int GenerarCodigo() {
        int cod = 0;
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT MAX(codseccion) FROM seccion");
            if (rs.next()) {
                cod = rs.getInt(1) + 1;
            } else {
                cod = 1;
            }
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
        return cod;
    }

    @Override
    public boolean add(seccion obj) {
        boolean res = false;
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("INSERT INTO seccion(codseccion, nomseccion, estseccion) VALUES(?,?,?)");
            pst.setInt(1, obj.getCodigo());
            pst.setString(2, obj.getNombre());
            pst.setBoolean(3, obj.isEstado());
            int r = pst.executeUpdate();
            if (r > 0) {
                res = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
        return res;
    }

    @Override
    public boolean update(seccion obj) {
        boolean res = false;
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("UPDATE seccion SET nomseccion=?, estseccion=? WHERE codseccion=?");
            pst.setString(1, obj.getNombre());
            pst.setBoolean(2, obj.isEstado());
            pst.setInt(3, obj.getCodigo());
            int r = pst.executeUpdate();
            if (r > 0) {
                res = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
        return res;
    }

    @Override
    public boolean delete(seccion obj) {
        boolean res = false;
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("UPDATE seccion SET estseccion=0 WHERE codseccion=?");
            pst.setInt(1, obj.getCodigo());
            int r = pst.executeUpdate();
            if (r > 0) {
                res = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
        return res;
    }

    @Override
    public boolean enable(seccion obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
