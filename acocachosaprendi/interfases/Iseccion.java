package acocachosaprendi.interfases;

import acocachosaprendi.clases.seccion;
import javax.swing.JTable;

public interface Iseccion {
    
    public void findAll(JTable jtbseccion);
    public void findAllCustom(JTable jtbseccion);
    public void findById(JTable jtbseccion, int codigo);
    public void findByName(JTable jtbseccion, String nombre);
    public int GenerarCodigo();
    public boolean add(seccion obj);
    public boolean update(seccion obj);
    public boolean delete(seccion obj);
    public boolean enable(seccion obj);
    
}
