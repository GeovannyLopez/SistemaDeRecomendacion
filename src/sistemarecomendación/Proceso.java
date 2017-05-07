/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarecomendación;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author usuario
 */
public class Proceso extends Thread{
    String Id;
    frmInicio Inicio;
    public Proceso(String msg, String lId, frmInicio lInicio)
    {
        super(msg);
        Id = lId;
        Inicio = lInicio;
    }
    @Override
    public void run()
    {
        try {
            Inicio.ActualizarSugerencias(Id);
        } catch (SQLException ex) {
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
