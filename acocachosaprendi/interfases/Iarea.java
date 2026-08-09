package acocachosaprendi.interfases;

import acocachosaprendi.clases.area;
import javax.swing.JTable;

public interface Iarea {
    
    public void findAll(JTable jtbarea);
    public void findAllCustom(JTable jtbarea);
    public void findById(JTable jtbarea, int codigo);
    public void findByName(JTable jtbarea, String nombre);
    public int GenerarCodigo();
    public boolean add(area obj);
    public boolean update(area obj);
    public boolean delete(area obj);
    public boolean enable(area obj);
    
}
