package acocachosaprendi.implementaciones;

import acocachosaprendi.bd.Conexion;
import acocachosaprendi.clases.docente;
import acocachosaprendi.interfases.Idocente;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;


public class impldocente implements Idocente {
    private final Conexion objconexion = new Conexion();
    private Connection xcon = null;
    private ResultSet rs = null;
    private Statement st = null;
    private PreparedStatement pst = null;
    DefaultTableModel modelo = null;

    @Override
    public void findall(JTable jtbdocente) {
        Object[] fila = new Object[16];
        String columna[] = {"Código", "Nombre", "A. Paterno", "A. Materno", "Fecha Nac.", "N. Documento",
            "Tipo Doc.", "Dirección", "Distrito", "Teléfono", "Celular", "Correo", "Sexo", 
            "Estado Civil", "Grado Instrucción", "Estado"};
        modelo = new DefaultTableModel(null, columna);
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT d.coddoc, d.nomdoc, d.apepdoc, d.apemdoc, d.fecdoc, d.docdoc, "
                    + "td.nomtipd, d.dirdoc, dis.nomdis, d.teldoc, d.celdoc, d.cordoc, "
                    + "s.nomsex, ec.nomestc, gi.nomgradi, d.estdoc "
                    + "FROM docente d "
                    + "INNER JOIN tipodocumento td ON d.codtipd = td.codtipd "
                    + "INNER JOIN distrito dis ON d.coddis = dis.coddis "
                    + "INNER JOIN sexo s ON d.codsex = s.codsex "
                    + "INNER JOIN estadocivil ec ON d.codestc = ec.codestc "
                    + "INNER JOIN gradoinstruccion gi ON d.codgradi = gi.codgradi "
                    + "WHERE d.estdoc = 1");
            while (rs.next()) {
                fila[0] = rs.getInt("coddoc");
                fila[1] = rs.getString("nomdoc");
                fila[2] = rs.getString("apepdoc");
                fila[3] = rs.getString("apemdoc");
                fila[4] = rs.getString("fecdoc");
                fila[5] = rs.getString("docdoc");
                fila[6] = rs.getString("nomtipd");
                fila[7] = rs.getString("dirdoc");
                fila[8] = rs.getString("nomdis");
                fila[9] = rs.getString("teldoc");
                fila[10] = rs.getString("celdoc");
                fila[11] = rs.getString("cordoc");
                fila[12] = rs.getString("nomsex");
                fila[13] = rs.getString("nomestc");
                fila[14] = rs.getString("nomgradi");
                fila[15] = rs.getBoolean("estdoc") ? "Habilitado" : "Deshabilitado";
                modelo.addRow(fila);
            }
            jtbdocente.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
    }

    @Override
    public void findAllCustom(JTable jtbdocente) {
         Object[] fila = new Object[16];
        String columna[] = {"Código", "Nombre", "A. Paterno", "A. Materno", "Fecha Nac.", "N. Documento",
            "Tipo Doc.", "Dirección", "Distrito", "Teléfono", "Celular", "Correo", "Sexo", 
            "Estado Civil", "Grado Instrucción", "Estado"};
        modelo = new DefaultTableModel(null, columna);
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT d.coddoc, d.nomdoc, d.apepdoc, d.apemdoc, d.fecdoc, d.docdoc, "
                    + "td.nomtipd, d.dirdoc, dis.nomdis, d.teldoc, d.celdoc, d.cordoc, "
                    + "s.nomsex, ec.nomestc, gi.nomgradi, d.estdoc "
                    + "FROM docente d "
                    + "INNER JOIN tipodocumento td ON d.codtipd = td.codtipd "
                    + "INNER JOIN distrito dis ON d.coddis = dis.coddis "
                    + "INNER JOIN sexo s ON d.codsex = s.codsex "
                    + "INNER JOIN estadocivil ec ON d.codestc = ec.codestc "
                    + "INNER JOIN gradoinstruccion gi ON d.codgradi = gi.codgradi");
            while (rs.next()) {
                fila[0] = rs.getInt("coddoc");
                fila[1] = rs.getString("nomdoc");
                fila[2] = rs.getString("apepdoc");
                fila[3] = rs.getString("apemdoc");
                fila[4] = rs.getString("fecdoc");
                fila[5] = rs.getString("docdoc");
                fila[6] = rs.getString("nomtipd");
                fila[7] = rs.getString("dirdoc");
                fila[8] = rs.getString("nomdis");
                fila[9] = rs.getString("teldoc");
                fila[10] = rs.getString("celdoc");
                fila[11] = rs.getString("cordoc");
                fila[12] = rs.getString("nomsex");
                fila[13] = rs.getString("nomestc");
                fila[14] = rs.getString("nomgradi");
                fila[15] = rs.getBoolean("estdoc") ? "Habilitado" : "Deshabilitado";
                modelo.addRow(fila);
            }
            jtbdocente.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
    }

    @Override
    public void findById(JTable jtbdocente, int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void findByName(JTable jtbdocente, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int GenerarCodigo() {
         int codigo = 0;
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT MAX(coddoc)+1 as CodigoNuevo FROM docente");
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
    public boolean add(docente obj) {
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("INSERT INTO docente (coddoc, nomdoc, apepdoc, apemdoc, fecdoc, codtipd, docdoc, "
                    + "dirdoc, coddis, teldoc, celdoc, cordoc, codsex, codestc, codgradi, nomesp, estdoc) "
                    + "VALUES (seq_docente.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, obj.getNombre());
            pst.setString(2, obj.getApellidopaterno());
            pst.setString(3, obj.getApellidomaterno());
            pst.setDate(4, new java.sql.Date(obj.getFechanacimiento().getTime()));
            pst.setInt(5, obj.getTipodocumento().getCodigo());
            pst.setString(6, obj.getNumerodocumento());
            pst.setString(7, obj.getDireccion());
            pst.setInt(8, obj.getDistrito().getCodigo());
            pst.setString(9, obj.getTelefono());
            pst.setString(10, obj.getCelular());
            pst.setString(11, obj.getCorreo());
            pst.setInt(12, obj.getSexo().getCodigo());
            pst.setInt(13, obj.getEstadocivil().getCodigo());
            pst.setInt(14, obj.getGradoinstruccion().getCodigo());
            pst.setString(15, obj.getEspecialidad());
            pst.setInt(16, obj.isEstado() ? 1 : 0);
            int res = pst.executeUpdate();
            return res == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
            return false;
        }
    }

    @Override
    public boolean update(docente obj) {
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("UPDATE docente SET nomdoc=?, apepdoc=?, apemdoc=?, fecdoc=?, codtipd=?, docdoc=?, "
                    + "dirdoc=?, coddis=?, teldoc=?, celdoc=?, cordoc=?, codsex=?, codestc=?, codgradi=?, nomesp=?, estdoc=? "
                    + "WHERE coddoc=?");
            pst.setString(1, obj.getNombre());
            pst.setString(2, obj.getApellidopaterno());
            pst.setString(3, obj.getApellidomaterno());
            pst.setDate(4, new java.sql.Date(obj.getFechanacimiento().getTime()));
            pst.setInt(5, obj.getTipodocumento().getCodigo());
            pst.setString(6, obj.getNumerodocumento());
            pst.setString(7, obj.getDireccion());
            pst.setInt(8, obj.getDistrito().getCodigo());
            pst.setString(9, obj.getTelefono());
            pst.setString(10, obj.getCelular());
            pst.setString(11, obj.getCorreo());
            pst.setInt(12, obj.getSexo().getCodigo());
            pst.setInt(13, obj.getEstadocivil().getCodigo());
            pst.setInt(14, obj.getGradoinstruccion().getCodigo());
            pst.setString(15, obj.getEspecialidad());
            pst.setInt(16, obj.isEstado() ? 1 : 0);
            pst.setInt(17, obj.getCodigo());
            int res = pst.executeUpdate();
            return res == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
            return false;
        }
    }

    @Override
    public boolean delete(docente obj) {
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("UPDATE docente SET estdoc=0 WHERE coddoc=?");
            pst.setInt(1, obj.getCodigo());
            int res = pst.executeUpdate();
            return res == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
            return false;
        }
    }

    @Override
    public boolean enable(docente obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void CargarCombo(JComboBox cbodocente) {
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("SELECT coddoc, nomdoc, apepdoc, apemdoc FROM docente WHERE estdoc=1");
            cbodocente.addItem("Seleccione un docente");
            while (rs.next()) {
                String docente = rs.getString("nomdoc") + " " + rs.getString("apepdoc") + " " + rs.getString("apemdoc");
                cbodocente.addItem(docente);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }
    }
    
}
