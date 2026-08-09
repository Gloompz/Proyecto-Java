package acocachosaprendi.interfases;

import acocachosaprendi.clases.estadocivil;
import javax.swing.JComboBox;
import javax.swing.JTable;

public interface Iestadocivil {
    
    public void findAll(JTable jtbestadocivil);
    public void findAllCustom(JTable jtbestadocivil);
    public void findById(JTable jtbestadocivil, int codigo);
    public void findByName(JTable jtbestadocivil, String nombre);
    public int GenerarCodigo();
    public boolean add(estadocivil obj);
    public boolean update(estadocivil obj);
    public boolean delete(estadocivil obj);
    public boolean enable(estadocivil obj);
    public void CargarCombo(JComboBox cboestadocivil);
    
}
