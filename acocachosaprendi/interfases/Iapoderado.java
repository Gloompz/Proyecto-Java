package acocachosaprendi.interfases;

import acocachosaprendi.clases.apoderado;
import acocachosaprendi.clases.distrito;
import acocachosaprendi.clases.tipodocumento;
import javax.swing.JComboBox;
import javax.swing.JTable;

public interface Iapoderado {
     public void findAll(JTable jtbapoderado);
    public void findAllCustom(JTable jtbapoderado);
    public void findById(JTable jtbapoderado, int codigo);
    public void findByName(JTable jtbapoderado, String nombre);
    public int GenerarCodigo();
    public boolean add(apoderado obj);
    public boolean update(apoderado obj);
    public boolean delete(apoderado obj);
    public boolean enable(apoderado obj);
    public void CargarCombo(JComboBox cbodistrito);
}
