package acocachosaprendi.implementaciones;

import acocachosaprendi.bd.Conexion;
import acocachosaprendi.clases.alumno;
import acocachosaprendi.interfases.Ialumno;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class implalumno implements Ialumno{
    
    private final Conexion objconexion = new Conexion();
    private Connection xcon = null;
    private ResultSet rs = null;
    private Statement st = null;
    private PreparedStatement pst = null;
    DefaultTableModel modelo = null;


    @Override
    public void findall(JTable jtbalumno) {
        Object[] fila = new Object[14];
        String columna[] = {"Codigo", "Nombre", "A. Paterno", "A. Materno", "Fecha", "N. Documento",
            "Tipo Doc.", "Direccion", "Distrito", "Telefono", "Celular", "Correo", "Sexo", "Estado"};
        modelo = new DefaultTableModel(null, columna);
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("select al.codalu,al.nomalu,al.apepalu,al.apemalu,al.fecalu,al.docalu,"
                    + "td.nomtipd,al.diralu,d.nomdis,al.telalu,al.celalu,al.coralu,s.nomsex,al.estalu "
                    + "from alumno al inner join tipodocumento td on al.codtipd=td.codtipd "
                    + "inner join distrito d on al.coddis=d.coddis inner join sexo s "
                    + "on al.codsex=s.codsex where al.estalu=1");
            while (rs.next()) {
                fila[0] = rs.getInt("codalu");
                fila[1] = rs.getString("nomalu");
                fila[2] = rs.getString("apepalu");
                fila[3] = rs.getString("apemalu");
                fila[4] = rs.getString("fecalu");
                fila[5] = rs.getString("docalu");
                fila[6] = rs.getString("nomtipd");
                fila[7] = rs.getString("diralu");
                fila[8] = rs.getString("nomdis");
                fila[9] = rs.getString("telalu");
                fila[10] = rs.getString("celalu");
                fila[11] = rs.getString("coralu");
                fila[12] = rs.getString("nomsex");
                fila[13] = rs.getBoolean("estalu") ? "Habilitado" : "Deshabilitado";
                modelo.addRow(fila);
            }
            jtbalumno.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
    }

    @Override
    public void findAllCustom(JTable jtbalumno) {
        Object[] fila = new Object[14];
        String columna[] = {"Codigo", "Nombre", "A. Paterno", "A. Materno", "Fecha", "N. Documento",
            "Tipo Doc.", "Direccion", "Distrito", "Telefono", "Celular", "Correo", "Sexo", "Estado"};
        modelo = new DefaultTableModel(null, columna);
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("select al.codalu,al.nomalu,al.apepalu,al.apemalu,al.fecalu,al.docalu,"
                    + "td.nomtipd,al.diralu,d.nomdis,al.telalu,al.celalu,al.coralu,s.nomsex,al.estalu "
                    + "from alumno al inner join tipodocumento td on al.codtipd=td.codtipd "
                    + "inner join distrito d on al.coddis=d.coddis inner join sexo s "
                    + "on al.codsex=s.codsex");
            while (rs.next()) {
                fila[0] = rs.getInt("codalu");
                fila[1] = rs.getString("nomalu");
                fila[2] = rs.getString("apepalu");
                fila[3] = rs.getString("apemalu");
                fila[4] = rs.getString("fecalu");
                fila[5] = rs.getString("docalu");
                fila[6] = rs.getString("nomtipd");
                fila[7] = rs.getString("diralu");
                fila[8] = rs.getString("nomdis");
                fila[9] = rs.getString("telalu");
                fila[10] = rs.getString("celalu");
                fila[11] = rs.getString("coralu");
                fila[12] = rs.getString("nomsex");
                fila[13] = rs.getBoolean("estalu") ? "Habilitado" : "Deshabilitado";
                modelo.addRow(fila);
            }
            jtbalumno.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.toString());
        }
    }

    @Override
    public void findById(JTable jtbalumno, int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void findByName(JTable jtbalumno, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int GenerarCodigo() {
        int codigo = 0;
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("select max(codalu)+1 as CodigoNuevo from alumno");
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
    public boolean add(alumno obj) {
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("INSERT INTO alumno (codalu, nomalu, apepalu, apemalu, fecalu, codtipd, docalu, diralu, coddis, "
                    + "telalu, celalu, coralu, codsex, codapo, estalu) VALUES (seq_alumno.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
            pst.setInt(13, obj.getApoderado().getCodigo());
            pst.setInt(14, obj.isEstado() ? 1 : 0);
            int res = pst.executeUpdate();
            return res == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
            return false;
        }
    }

    @Override
    public boolean update(alumno obj) {
         try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("update alumno set nomalu=?, apepalu=?, apemalu=?, fecalu=?, codtipd=?, docalu=?, diralu=?, coddis=?, "
                    + "telalu=?, celalu=?, coralu=?, codsex=?, codapo=?, estalu=? where codalu=?");
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
            pst.setInt(13, obj.getApoderado().getCodigo());
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
    public boolean delete(alumno obj) {
        try {
            xcon = objconexion.Conectar();
            pst = xcon.prepareStatement("update alumno set estalu=0 where codalu=?");
            pst.setInt(1, obj.getCodigo());
            int res = pst.executeUpdate();
            return res == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
            return false;
        }
    }

    @Override
    public boolean enable(alumno obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void CargarCombo(JComboBox cboAlumno) {
        String alum = "";
        try {
            xcon = objconexion.Conectar();
            st = xcon.createStatement();
            rs = st.executeQuery("select * from apoderado where estapo=1");
            cboAlumno.addItem("Seleccione un apoderado");
            //cargamos los datos en el JTable
            while (rs.next()) {
                alum = rs.getString("nomalu") + " " + rs.getString("apepalu") + " " + rs.getString("apemalu");
                cboAlumno.addItem(alum);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }

    }
    
}
