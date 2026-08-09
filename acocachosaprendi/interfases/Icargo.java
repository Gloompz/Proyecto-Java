package acocachosaprendi.interfases;

import acocachosaprendi.clases.cargo;
import javax.swing.JTable;

public interface Icargo {
    
    public void findAll(JTable jtbcargo);
    public void findAllCustom(JTable jtbcargo);
    public void findById(JTable jtbcargo, int codigo);
    public void findByName(JTable jtbcargo, String nombre);
    public int GenerarCodigo();
    public boolean add(cargo obj);
    public boolean update(cargo obj);
    public boolean delete(cargo obj);
    public boolean enable(cargo obj);
    
}
