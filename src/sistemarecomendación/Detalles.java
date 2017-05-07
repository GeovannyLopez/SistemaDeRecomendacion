/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarecomendación;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Detalles extends javax.swing.JFrame {

    public String Id;
    public ArrayList<Integer> Likes;
    public frmInicio Inicio;
    SQLConnection con;
    /**
     * Creates new form Detalles
     */
    public Detalles(String lId, ArrayList<Integer> lLikes, frmInicio lInicio) {
        initComponents();
        this.setLocationRelativeTo(null);
        Id = lId;
        Likes = lLikes;
        Inicio = lInicio;
        LLenarCampos();
        
        Integer id = Integer.parseInt(lId);
        if(Likes.contains(id))
        {
            btnSolicitar.setEnabled(false);
        }
    }
    
    
    private void LLenarCampos()
    {
        con = new SQLConnection();
        String queryString = "SELECT ISNULL(Nombre,'') [Nombre], " + 
                        "ISNULL(Tipo,'') [Tipo], " +
                        "ISNULL(Director,'') [Director], " +
                        "ISNULL(Link,'') [Link], " +
                        "ISNULL(Punteo,'') [Punteo], " +
                        "ISNULL(Anio,'') [Anio], " +
                        "ISNULL(Duracion,'') [Duracion], " +
                        "ISNULL(Pais,'') [Pais], " +
                        "ISNULL(Idioma,'') [Idioma], " +
                        "ISNULL(Clasificacion,'') [Clasificacion], " +
                        "ISNULL(Actor1,'') [Actor1], " +
                        "ISNULL(Actor2,'') [Actor2], " +
                        "ISNULL(Actor3,'') [Actor3] " +
                        "FROM MOVIE WHERE IDMOVIE = " + Id + " ;";
        
        ArrayList<String> Columns = new ArrayList<String>();

            Columns.add("Nombre");
            Columns.add("Tipo");
            Columns.add("Director");
            Columns.add("Link");
            Columns.add("Punteo");
            Columns.add("Anio");
            Columns.add("Duracion");
            Columns.add("Pais");
            Columns.add("Idioma");
            Columns.add("Clasificacion");
            Columns.add("Actor1");
            Columns.add("Actor2");
            Columns.add("Actor3");
            
            ArrayList<ArrayList<String>> Datos = con.ExecuteReaderQuery(queryString, Columns);
            lblTitulo.setText(Datos.get(0).get(0));
            lblTipo.setText("Tipo: " + Datos.get(0).get(1));
            lblDirector.setText("Director: " + Datos.get(0).get(2));
            lblEnlace.setText("Link: " + Datos.get(0).get(3));
            lblPunteo.setText("Punteo: " + Datos.get(0).get(4));
            lblAnio.setText("Año: " + Datos.get(0).get(5));
            lblDuracion.setText("Duración:" + Datos.get(0).get(6));
            lblPais.setText("País: " + Datos.get(0).get(7));
            lblIdioma.setText("Idioma: " + Datos.get(0).get(8));
            lblClasificacion.setText("Clasificación: " + Datos.get(0).get(9));
            lblActor1.setText(Datos.get(0).get(10));
            lblActor2.setText(Datos.get(0).get(11));
            lblActor3.setText(Datos.get(0).get(12));
            
            
            queryString = "SELECT ISNULL(Nombre,'') [Nombre] " + 
                        "FROM MOVIEGENERO MG JOIN GENERO G on MG.IDGENERO = G.IDGENERO " +
                        "WHERE MG.IDMOVIE = " + Id + " ;";
            
            Columns = new ArrayList<String>();

            Columns.add("Nombre");
            
            Datos = con.ExecuteReaderQuery(queryString, Columns);
            lblGeneros.setText("");
            String generos = "";
            for (int i = 0; i < Datos.size(); i++) {
                if (i==0) {
                    generos = "Generos: " + Datos.get(i).get(0).toUpperCase();
                }
                else
                {
                    generos = generos + ", " + Datos.get(i).get(0).toUpperCase();
                }
            lblGeneros.setText(generos);
        }
            
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plDetalles = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblPunteo = new javax.swing.JLabel();
        lblAnio = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblDuracion = new javax.swing.JLabel();
        lblDirector = new javax.swing.JLabel();
        lblEnlace = new javax.swing.JLabel();
        lblPais = new javax.swing.JLabel();
        lblIdioma = new javax.swing.JLabel();
        lblClasificacion = new javax.swing.JLabel();
        lblReparto = new javax.swing.JLabel();
        lblActor1 = new javax.swing.JLabel();
        lblActor2 = new javax.swing.JLabel();
        lblActor3 = new javax.swing.JLabel();
        btnSolicitar = new javax.swing.JButton();
        lblGeneros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblTitulo.setText("lblTitulo");

        lblPunteo.setText("Punteo");

        lblAnio.setText("Año");

        lblTipo.setText("Tipo");

        lblDuracion.setText("Duración");

        lblDirector.setText("Director");

        lblEnlace.setText("Enlace");

        lblPais.setText("País");

        lblIdioma.setText("Idioma");

        lblClasificacion.setText("Clasificación");

        lblReparto.setText("Reparto:");

        lblActor1.setText("Actor 1");

        lblActor2.setText("Actor 2");

        lblActor3.setText("Actor 3");

        btnSolicitar.setText("Solicitar");
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });

        lblGeneros.setText("Generos");

        javax.swing.GroupLayout plDetallesLayout = new javax.swing.GroupLayout(plDetalles);
        plDetalles.setLayout(plDetallesLayout);
        plDetallesLayout.setHorizontalGroup(
            plDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plDetallesLayout.createSequentialGroup()
                        .addGroup(plDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDuracion)
                            .addComponent(lblTipo)
                            .addComponent(lblIdioma)
                            .addComponent(lblPais)
                            .addComponent(lblClasificacion)
                            .addComponent(lblActor2)
                            .addComponent(lblActor3)
                            .addComponent(btnSolicitar, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 96, Short.MAX_VALUE))
                    .addGroup(plDetallesLayout.createSequentialGroup()
                        .addGroup(plDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(plDetallesLayout.createSequentialGroup()
                                .addGap(198, 198, 198)
                                .addComponent(lblTitulo))
                            .addComponent(lblActor1)
                            .addComponent(lblPunteo)
                            .addComponent(lblEnlace)
                            .addComponent(lblDirector)
                            .addComponent(lblAnio)
                            .addComponent(lblGeneros))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(plDetallesLayout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(lblReparto)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        plDetallesLayout.setVerticalGroup(
            plDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(11, 11, 11)
                .addComponent(lblTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDirector)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEnlace)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPunteo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAnio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDuracion)
                .addGap(4, 4, 4)
                .addComponent(lblPais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIdioma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClasificacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGeneros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(lblReparto)
                .addGap(4, 4, 4)
                .addComponent(lblActor1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblActor2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblActor3)
                .addGap(18, 18, 18)
                .addComponent(btnSolicitar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(plDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        //Object [] opciones ={"Aceptar","Cancelar"};
        //int eleccion = JOptionPane.showOptionDialog(rootPane,"En realidad desea realizar cerrar la aplicacion","Mensaje de Confirmacion",
        //JOptionPane.YES_NO_OPTION,
        //JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        //if (eleccion == JOptionPane.YES_OPTION)
        //{
            Inicio.setVisible(true);
            this.setVisible(false);
        //}else{
        //}
    }//GEN-LAST:event_formWindowClosing

    private void btnSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarActionPerformed
        Likes.add(Integer.parseInt(Id));
        Object [] opciones ={"Aceptar"};
        Thread hilo = new Proceso("Actualizar", Id, Inicio);
        hilo.start();
        //Inicio.ActualizarSugerencias(Id);
        btnSolicitar.setEnabled(false);
        JOptionPane.showOptionDialog(rootPane,"Se Solicitado la película","Mensaje de Confirmacion",JOptionPane.YES_NO_OPTION,
        JOptionPane.INFORMATION_MESSAGE,null,opciones,"Aceptar");
    }//GEN-LAST:event_btnSolicitarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Detalles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JLabel lblActor1;
    private javax.swing.JLabel lblActor2;
    private javax.swing.JLabel lblActor3;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblClasificacion;
    private javax.swing.JLabel lblDirector;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblEnlace;
    private javax.swing.JLabel lblGeneros;
    private javax.swing.JLabel lblIdioma;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblPunteo;
    private javax.swing.JLabel lblReparto;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel plDetalles;
    // End of variables declaration//GEN-END:variables
}
