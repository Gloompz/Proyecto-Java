package acocachosaprendi.interfases;

import acocachosaprendi.clases.nivel;
import javax.swing.JTable;

public interface Inivel {
    
    public void findAll(JTable jtbnivel);
    public void findAllCustom(JTable jtbnivel);
    public void findById(JTable jtbnivel, int codigo);
    public void findByName(JTable jtbnivel, String nombre);
    public int GenerarCodigo();
    public boolean add(nivel obj);
    public boolean update(nivel obj);
    public boolean delete(nivel obj);
    public boolean enable(nivel obj);
    
}
