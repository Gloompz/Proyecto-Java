package acocachosaprendi.implementaciones;

import acocachosaprendi.bd.Conexion;
import acocachosaprendi.clases.Turno;
import acocachosaprendi.interfases.Iturno;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class implturno implements Iturno{
    private final Conexion objconexion = new Conexion();
    private Connection xcon = null;
    private ResultSet rs = null;
    private Statement st = null;
    private PreparedStatement pst = null;
    private DefaultTableModel modelo = null;

    @Override
    public void findAll(JTable jtbTurno) {
        Object[] fila = new Object[3];
        String columna[] = {"Código", "Nombre", "Estado"};
        modelo = new DefaultTableModel(null, columna);
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT * FROM turno");
            while (rs.next()) {
                fila[0] = rs.getInt("codtur");
                fila[1] = rs.getString("nomtur");
                if (rs.getBoolean("esttur") == true) {
                    fila[2] = "Habilitado";
                } else {
                    fila[2] = "Deshabilitado";
                }
                modelo.addRow(fila);
            }
            jtbTurno.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
    }

    @Override
    public void findAllCustom(JTable jtbTurno) {
        Object[] fila = new Object[3];
        String columna[] = {"Código", "Nombre", "Estado"};
        modelo = new DefaultTableModel(null, columna);
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT * FROM turno WHERE esttur=1");
            while (rs.next()) {
                fila[0] = rs.getInt("codtur");
                fila[1] = rs.getString("nomtur");
                fila[2] = "Habilitado";
                modelo.addRow(fila);
            }
            jtbTurno.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
    }

    @Override
    public void findById(JTable jtbTurno, int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void findByName(JTable jtbTurno, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int GenerarCodigo() {
        int cod = 0;
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT MAX(codtur) FROM turno");
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
    public boolean add(Turno obj) {
        boolean res = false;
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("INSERT INTO turno(codtur, nomtur, esttur) VALUES(?,?,?)");
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
    public boolean update(Turno obj) {
        boolean res = false;
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("UPDATE turno SET nomtur=?, esttur=? WHERE codtur=?");
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
    public boolean delete(Turno obj) {
        boolean res = false;
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("UPDATE turno SET esttur=0 WHERE codtur=?");
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
    public boolean enable(Turno obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
