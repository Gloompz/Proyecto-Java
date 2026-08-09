package acocachosaprendi.clases;
import java.util.Date;
public class apoderado{
    private int codigo;
    private String nombre;
    private String apellidopaterno;
    private String apellidomaterno;
    private Date fechanacimiento;
    private String numerodocumento;
    private String direccion;
    private String telefono;
    private String celular;
    private String correo;
    private boolean estado;
    //claves foraneas
    private tipodocumento tipodocumento;
    private distrito distrito;
    private sexo sexo;
    private estadocivil estadocivil;
    
    //metodo constructor

    public apoderado() {
    }

    public apoderado(int codigo, String nombre, String apellidopaterno, String apellidomaterno, Date fechanacimiento, String numerodocumento, String direccion, String telefono, String celular, String correo, boolean estado, tipodocumento tipodocumento, distrito distrito, sexo sexo, estadocivil estadocivil) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.fechanacimiento = fechanacimiento;
        this.numerodocumento = numerodocumento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.correo = correo;
        this.estado = estado;
        this.tipodocumento = tipodocumento;
        this.distrito = distrito;
        this.sexo = sexo;
        this.estadocivil = estadocivil;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public tipodocumento getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(tipodocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(distrito distrito) {
        this.distrito = distrito;
    }

    public sexo getSexo() {
        return sexo;
    }

    public void setSexo(sexo sexo) {
        this.sexo = sexo;
    }

    public estadocivil getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(estadocivil estadocivil) {
        this.estadocivil = estadocivil;
    }
    
    
    
}
