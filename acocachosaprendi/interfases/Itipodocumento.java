package acocachosaprendi.interfases;

import acocachosaprendi.clases.tipodocumento;
import javax.swing.JComboBox;
import javax.swing.JTable;

public interface Itipodocumento {
    
    public void findall(JTable jtbtipodocumento); 
    public void findById(JTable jtbtipodocumento, int codigo);
    public void findByName(JTable jtbtipodocumento, String nombre);
    public int GenerarCodigo();
    public boolean add(tipodocumento obj);
    public boolean update(tipodocumento obj);
    public boolean delete(tipodocumento obj);
    public boolean enable(tipodocumento obj);
    public void findAllCustom(JTable jtbtipodocumento);
    public void CargarCombo(JComboBox cbotipodocumento);
}
