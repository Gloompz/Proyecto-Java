package acocachosaprendi.interfases;

import acocachosaprendi.clases.gradoinstruccion;
import javax.swing.JComboBox;
import javax.swing.JTable;

public interface Igradoinstruccion {
    
    public void findAll(JTable jtbgradoinstruccion);
    public void findAllCustom(JTable jtbgradoinstruccion);
    public void findById(JTable jtbgradoinstruccion, int codigo);
    public void findByName(JTable jtbgradoinstruccion, String nombre);
    public int GenerarCodigo();
    public boolean add(gradoinstruccion obj);
    public boolean update(gradoinstruccion obj);
    public boolean delete(gradoinstruccion obj);
    public boolean enable(gradoinstruccion obj);
    public void CargarCombo(JComboBox cbogradoinstruccion);
}
