package acocachosaprendi.interfases;

import acocachosaprendi.clases.distrito;
import javax.swing.JComboBox;
import javax.swing.JTable;

public interface Idistrito {
    
    public void findAll(JTable jtbdistrito);
    public void findAllCustom(JTable jtbdistrito);
    public void findById(JTable jtbdistrito, int codigo);
    public void findByName(JTable jtbdistrito, String nombre);
    public int GenerarCodigo();
    public boolean add(distrito obj);
    public boolean update(distrito obj);
    public boolean delete(distrito obj);
    public boolean enable(distrito obj);
    public void CargarCombo(JComboBox cbodistrito);
}
