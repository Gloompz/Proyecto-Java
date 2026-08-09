package acocachosaprendi.interfases;

import acocachosaprendi.clases.alumno;
import javax.swing.JComboBox;
import javax.swing.JTable;

public interface Ialumno {
    public void findall(JTable jtbalumno);
    public void findAllCustom(JTable jtbalumno);
    public void findById(JTable jtbalumno, int codigo);
    public void findByName(JTable jtbalumno, String nombre);
    public int GenerarCodigo();
    public boolean add(alumno obj);
    public boolean update(alumno obj);
    public boolean delete(alumno obj);
    public boolean enable(alumno obj);
    public void CargarCombo(JComboBox cboAlumno);
    
}
