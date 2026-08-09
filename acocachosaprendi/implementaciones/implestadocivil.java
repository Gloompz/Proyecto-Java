package acocachosaprendi.implementaciones;

import acocachosaprendi.bd.Conexion;
import acocachosaprendi.clases.estadocivil;
import acocachosaprendi.interfases.Iestadocivil;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class implestadocivil implements Iestadocivil{
    
    private final Conexion objconexion = new Conexion();
    private Connection xcon = null;
    private ResultSet rs = null;
    private Statement st = null;
    private PreparedStatement pst = null;
    private DefaultTableModel modelo = null;

    @Override
    public void findAll(JTable jtbestadocivil) {
        Object[] fila = new Object[3];
        String columna[] = {"Código", "Nombre", "Estado"};
        modelo = new DefaultTableModel(null, columna);
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT * FROM estadocivil");
            while (rs.next()) {
                fila[0] = rs.getInt("codestciv");
                fila[1] = rs.getString("nomestciv");
                if (rs.getBoolean("estestciv") == true) {
                    fila[2] = "Habilitado";
                } else {
                    fila[2] = "Deshabilitado";
                }
                modelo.addRow(fila);
            }
            jtbestadocivil.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
    }

    @Override
    public void findAllCustom(JTable jtbestadocivil) {
        Object[] fila = new Object[3];
        String columna[] = {"Código", "Nombre", "Estado"};
        modelo = new DefaultTableModel(null, columna);
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT * FROM estadocivil WHERE estestc=1");
            while (rs.next()) {
                fila[0] = rs.getInt("codestc");
                fila[1] = rs.getString("nomestc");
                fila[2] = "Habilitado";
                modelo.addRow(fila);
            }
            jtbestadocivil.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
    }

    @Override
    public void findById(JTable jtbestadocivil, int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void findByName(JTable jtbestadocivil, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int GenerarCodigo() {
        int cod = 0;
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT MAX(codestc) FROM estadocivil");
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
    public boolean add(estadocivil obj) {
        boolean res = false;
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("INSERT INTO estadocivil(codestc, nomestc, estestc) VALUES(?,?,?)");
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
    public boolean update(estadocivil obj) {
        boolean res = false;
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("UPDATE estadocivil SET nomestc=?, estestc=? WHERE codestc=?");
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
    public boolean delete(estadocivil obj) {
        boolean res = false;
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("UPDATE estadocivil SET estestc=0 WHERE codestc=?");
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
    public boolean enable(estadocivil obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void CargarCombo(JComboBox cboestadocivil) {
         String estc = "";
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("select * from estadocivil where estestc=1");
            cboestadocivil.addItem("Seleccione un estado civil");
            //cargamos los datos en el JTable
            while (rs.next()) {
                estc = rs.getString("nomestc");
                cboestadocivil.addItem(estc);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }

    }
    
}
