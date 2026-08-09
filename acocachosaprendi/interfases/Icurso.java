package acocachosaprendi.interfases;

import acocachosaprendi.clases.curso;
import javax.swing.JTable;

public interface Icurso {
    
    public void findAll(JTable jtbcurso);
    public void findAllCustom(JTable jtbcurso);
    public void findById(JTable jtbcurso, int codigo);
    public void findByName(JTable jtbcurso, String nombre);
    public int GenerarCodigo();
    public boolean add(curso obj);
    public boolean update(curso obj);
    public boolean delete(curso obj);
    public boolean enable(curso obj);
    
}
