package acocachosaprendi.interfases;

import acocachosaprendi.clases.docente;
import javax.swing.JComboBox;
import javax.swing.JTable;

public interface Idocente {
    public void findall(JTable jtbdocente);
    public void findAllCustom(JTable jtbdocente);
    public void findById(JTable jtbdocente, int codigo);
    public void findByName(JTable jtbdocente, String nombre);
    public int GenerarCodigo();
    public boolean add(docente obj);
    public boolean update(docente obj);
    public boolean delete(docente obj);
    public boolean enable(docente obj);
    public void CargarCombo(JComboBox cbodocente);  
    
}
