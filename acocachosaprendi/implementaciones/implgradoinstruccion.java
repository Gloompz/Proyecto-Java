package acocachosaprendi.implementaciones;

import acocachosaprendi.bd.Conexion;
import acocachosaprendi.clases.gradoinstruccion;
import acocachosaprendi.interfases.Igradoinstruccion;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class implgradoinstruccion implements Igradoinstruccion {
    
    private final Conexion objconexion = new Conexion();
    private Connection xcon = null;
    private ResultSet rs = null;
    private Statement st = null;
    private PreparedStatement pst = null;
    private DefaultTableModel modelo = null;

    @Override
    public void findAll(JTable jtbgradoinstruccion) {
        Object[] fila = new Object[3];
        String columna[] = {"Código", "Nombre", "Estado"};
        modelo = new DefaultTableModel(null, columna);
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT * FROM gradoinstruccion");
            while (rs.next()) {
                fila[0] = rs.getInt("codgradi");
                fila[1] = rs.getString("nomgradi");
                if (rs.getBoolean("estgradi") == true) {
                    fila[2] = "Habilitado";
                } else {
                    fila[2] = "Deshabilitado";
                }
                modelo.addRow(fila);
            }
            jtbgradoinstruccion.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
    }

    @Override
    public void findAllCustom(JTable jtbgradoinstruccion) {
        Object[] fila = new Object[3];
        String columna[] = {"Código", "Nombre", "Estado"};
        modelo = new DefaultTableModel(null, columna);
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT * FROM gradoinstruccion WHERE estgradi=1");
            while (rs.next()) {
                fila[0] = rs.getInt("codgradi");
                fila[1] = rs.getString("nomgradi");
                fila[2] = "Habilitado";
                modelo.addRow(fila);
            }
            jtbgradoinstruccion.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
    }

    @Override
    public void findById(JTable jtbgradoinstruccion, int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void findByName(JTable jtbgradoinstruccion, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int GenerarCodigo() {
        int cod = 0;
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT MAX(codgradi) FROM gradoinstruccion");
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
    public boolean add(gradoinstruccion obj) {
        boolean res = false;
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("INSERT INTO gradoinstruccion(codgradi, nomgradi, estgradi) VALUES(?,?,?)");
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
    public boolean update(gradoinstruccion obj) {
        boolean res = false;
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("UPDATE gradoinstruccion SET nomgradi=?, estgradi=? WHERE codgradi=?");
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
    public boolean delete(gradoinstruccion obj) {
        boolean res = false;
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("UPDATE gradoinstruccion SET estgradi=0 WHERE codgradi=?");
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
    public boolean enable(gradoinstruccion obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void CargarCombo(JComboBox cbogradoinstruccion) {
    String grado = "";
    try {
        xcon = objconexion.Conectar();
        st = xcon.createStatement();
        rs = st.executeQuery("select codgradi, nomgradi from gradoinstruccion where estgradi=1");
        cbogradoinstruccion.addItem("Seleccione un grado de instruccion");
        while (rs.next()) {
            grado = rs.getString("nomgradi");
            cbogradoinstruccion.addItem(grado);
        }
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.toString());
    }
}
}
