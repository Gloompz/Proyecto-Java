package acocachosaprendi.interfases;

import acocachosaprendi.clases.sexo;
import javax.swing.JComboBox;
import javax.swing.JTable;

public interface Isexo {
    
    public void findAll(JTable jtbsexo);
    public void findAllCustom(JTable jtbsexo);
    public void findById(JTable jtbsexo, int codigo);
    public void findByName(JTable jtbsexo, String nombre);
    public int GenerarCodigo();
    public boolean add(sexo obj);
    public boolean update(sexo obj);
    public boolean delete(sexo obj);
    public boolean enable(sexo obj);
    public void CargarCombo(JComboBox cbosexo);
    
}
