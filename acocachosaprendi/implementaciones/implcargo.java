package acocachosaprendi.implementaciones;

import acocachosaprendi.bd.Conexion;
import acocachosaprendi.clases.cargo;
import acocachosaprendi.interfases.Icargo;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class implcargo implements Icargo{
    private final Conexion objconexion = new Conexion();
    private Connection xcon = null;
    private ResultSet rs = null;
    private Statement st = null;
    private PreparedStatement pst = null;
    private DefaultTableModel modelo = null;

    @Override
    public void findAll(JTable jtbcargo) {
        Object[] fila = new Object[3];
        String columna[] = {"Código", "Nombre", "Estado"};
        modelo = new DefaultTableModel(null, columna);
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT * FROM cargo");
            while (rs.next()) {
                fila[0] = rs.getInt("codcargo");
                fila[1] = rs.getString("nomcargo");
                if (rs.getBoolean("estcargo") == true) {
                    fila[2] = "Habilitado";
                } else {
                    fila[2] = "Deshabilitado";
                }
                modelo.addRow(fila);
            }
            jtbcargo.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
    }

    @Override
    public void findAllCustom(JTable jtbcargo) {
        Object[] fila = new Object[3];
        String columna[] = {"Código", "Nombre", "Estado"};
        modelo = new DefaultTableModel(null, columna);
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT * FROM cargo WHERE estcar=1");
            while (rs.next()) {
                fila[0] = rs.getInt("codcar");
                fila[1] = rs.getString("nomcar");
                fila[2] = "Habilitado";
                modelo.addRow(fila);
            }
            jtbcargo.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
    }

    @Override
    public void findById(JTable jtbcargo, int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void findByName(JTable jtbcargo, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int GenerarCodigo() {
        int cod = 0;
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT MAX(codcar) FROM cargo");
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
    public boolean add(cargo obj) {
        boolean res = false;
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("INSERT INTO cargo(codcar, nomcar, estcar) VALUES(?,?,?)");
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
    public boolean update(cargo obj) {
        boolean res = false;
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("UPDATE cargo SET nomcar=?, estcar=? WHERE codcar=?");
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
    public boolean delete(cargo obj) {
        boolean res = false;
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("UPDATE cargo SET estcar=0 WHERE codcar=?");
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
    public boolean enable(cargo obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
