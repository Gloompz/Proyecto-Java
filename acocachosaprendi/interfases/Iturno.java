package acocachosaprendi.interfases;

import acocachosaprendi.clases.Turno;
import javax.swing.JTable;

public interface Iturno {
    
    public void findAll(JTable jtbTurno);
    public void findAllCustom(JTable jtbTurno);
    public void findById(JTable jtbTurno, int codigo);
    public void findByName(JTable jtbTurno, String nombre);
    public int GenerarCodigo();
    public boolean add(Turno obj);
    public boolean update(Turno obj);
    public boolean delete(Turno obj);
    public boolean enable(Turno obj);
    
}
