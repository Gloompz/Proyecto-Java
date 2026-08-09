package acocachosaprendi.interfases;

import acocachosaprendi.clases.grado;
import javax.swing.JTable;

public interface Igrado {
    
    public void findAll(JTable jtbgrado);
    public void findAllCustom(JTable jtbgrado);
    public void findById(JTable jtbgrado, int codigo);
    public void findByName(JTable jtbgrado, String nombre);
    public int GenerarCodigo();
    public boolean add(grado obj);
    public boolean update(grado obj);
    public boolean delete(grado obj);
    public boolean enable(grado obj);
    
}
