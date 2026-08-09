package acocachosaprendi.implementaciones;

import acocachosaprendi.bd.Conexion;
import acocachosaprendi.clases.apoderado;
import acocachosaprendi.clases.distrito;
import acocachosaprendi.clases.tipodocumento;
import acocachosaprendi.interfases.Iapoderado;
import acocachosaprendi.interfases.Idistrito;
import acocachosaprendi.interfases.Itipodocumento;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;


public class implapoderado implements Iapoderado{
    private final Conexion objconexion = new Conexion();
    private Connection xcon = null;
    private ResultSet rs = null;
    private Statement st = null;
    private PreparedStatement pst = null;
    DefaultTableModel modelo = null;

    

    @Override
    public void findAll(JTable jtbApoderado) {
        Object[] fila = new Object[14];
        String columna[] = {"Codigo", "Nombre", "A. Paterno", "A. Materno", "Fecha", "N. Documento",
            "Tipo Doc.", "Direccion", "Distrito", "Telefono", "Celular", "Correo", "Sexo", "Estado"};
        modelo = new DefaultTableModel(null, columna);
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("select ap.codapo,ap.nomapo,ap.apepapo,ap.apemapo,ap.fecapo,ap.docapo,"
                    + "td.nomtipd,ap.dirapo,d.nomdis,ap.telapo,ap.celapo,ap.corapo,s.nomsex,ap.estapo "
                    + "from apoderado ap inner join tipodocumento td on ap.codtipd=td.codtipd "
                    + "inner join distrito d on ap.coddis=d.coddis inner join sexo s "
                    + "on ap.codsex=s.codsex where ap.estapo=1");
            while (rs.next()) {
                fila[0] = rs.getInt("codapo");
                fila[1] = rs.getString("nomapo");
                fila[2] = rs.getString("apepapo");
                fila[3] = rs.getString("apemapo");
                fila[4] = rs.getString("fecapo");
                fila[5] = rs.getString("docapo");
                fila[6] = rs.getString("nomtipd");
                fila[7] = rs.getString("dirapo");
                fila[8] = rs.getString("nomdis");
                fila[9] = rs.getString("telapo");
                fila[10] = rs.getString("celapo");
                fila[11] = rs.getString("corapo");
                fila[12] = rs.getString("nomsex");
                fila[13] = rs.getBoolean("estapo") ? "Habilitado" : "Deshabilitado";
                modelo.addRow(fila);
            }
            jtbApoderado.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }

    }

    @Override
    public void findAllCustom(JTable jtbApoderado) {
        Object[] fila = new Object[14];
        String columna[] = {"Codigo", "Nombre", "A. Paterno", "A. Materno", "Fecha", "N. Documento",
            "Tipo Doc.", "Direccion", "Distrito", "Telefono", "Celular", "Correo", "Sexo", "Estado"};
        modelo = new DefaultTableModel(null, columna);
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("select ap.codapo,ap.nomapo,ap.apepapo,ap.apemapo,ap.fecapo,ap.docapo,"
                    + "td.nomtipd,ap.dirapo,d.nomdis,ap.telapo,ap.celapo,ap.corapo,s.nomsex,ap.estapo "
                    + "from apoderado ap inner join tipodocumento td on ap.codtipd=td.codtipd "
                    + "inner join distrito d on ap.coddis=d.coddis inner join sexo s "
                    + "on ap.codsex=s.codsex");
            while (rs.next()) {
                fila[0] = rs.getInt("codapo");
                fila[1] = rs.getString("nomapo");
                fila[2] = rs.getString("apepapo");
                fila[3] = rs.getString("apemapo");
                fila[4] = rs.getString("fecapo");
                fila[5] = rs.getString("docapo");
                fila[6] = rs.getString("nomtipd");
                fila[7] = rs.getString("dirapo");
                fila[8] = rs.getString("nomdis");
                fila[9] = rs.getString("telapo");
                fila[10] = rs.getString("celapo");
                fila[11] = rs.getString("corapo");
                fila[12] = rs.getString("nomsex");
                fila[13] = rs.getBoolean("estapo") ? "Habilitado" : "Deshabilitado";
                modelo.addRow(fila);
            }
            jtbApoderado.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }

    }

    @Override
    public void findById(JTable jtbApoderado, int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void findByName(JTable jtbApoderado, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int GenerarCodigo() {
         int codigo = 0;
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("select max(codapo)+1 as CodigoNuevo from apoderado");
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
    public boolean add(apoderado obj) {
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("INSERT INTO apoderado (codapo, nomapo, apepapo, apemapo, fecapo, codtipd, docapo, dirapo, coddis, "
                    + "telapo, celapo, corapo, codsex, codestc, estapo) VALUES (seq_apoderado.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
            pst.setInt(14, obj.isEstado() ? 1 : 0);
            int res = pst.executeUpdate();
            return res == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
            return false;
        }

    }

    @Override
    public boolean update(apoderado obj) {
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("update apoderado set nomapo=?, apepapo=?, apemapo=?, fecapo=?, codtipd=?, docapo=?, dirapo=?, coddis=?, "
                    + "telapo=?, celapo=?, corapo=?, codsex=?, codestc=?, estapo=? where codapo=?");
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
            pst.setInt(14, obj.isEstado() ? 1 : 0);
            pst.setInt(15, obj.getCodigo());
            int res = pst.executeUpdate();
            return res == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
            return false;
        }

    }

    @Override
    public boolean delete(apoderado obj) {
         try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("update apoderado set estapo=0 where codapo=?");
            pst.setInt(1, obj.getCodigo());
            int res = pst.executeUpdate();
            return res == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
            return false;
        }
    }

    @Override
    public boolean enable(apoderado obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void CargarCombo(JComboBox cbodistrito) {
        String tipd = "";
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("select * from apoderado where estapo=1");
            cbodistrito.addItem("Seleccione un apoderado");
            //cargamos los datos en el JTable
            while (rs.next()) {
                tipd = rs.getString("nomapo") + " " + rs.getString("apepapo") + " " + rs.getString("apemapo");
                cbodistrito.addItem(tipd);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }

    }
    
}
