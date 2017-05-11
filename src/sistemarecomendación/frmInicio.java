/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarecomendación;

import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author usuario
 */
public class frmInicio extends javax.swing.JFrame {

    /**
     * Creates new form frmInicio
     */
    DefaultTableModel model;
    ArrayList<Integer> Likes;
    SQLConnection connection = new SQLConnection();
    KNN knn = new KNN();
    public frmInicio() {
        //Inicializar componentes del formulario
        initComponents();
        this.setLocationRelativeTo(null);
        //knn.GenerarDistancias();
        Likes = new ArrayList<Integer>();
        //Obtener el modelo de la tabla
        model = (DefaultTableModel)tBuscar.getModel();
        //Ocultar la columna de Id
        TableColumnModel tcm = tBuscar.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0));
        tcm = tSugerencias.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0));
        tcm = tVolverA.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0));
        //Ajustar el tamaño de la tabla
        tBuscar.setRowHeight(30);
        tSugerencias.setRowHeight(30);
        tVolverA.setRowHeight(30);
        //Habilitar la aparición de botones en la tabla
        tBuscar.setDefaultRenderer(Object.class, new Render());
        tSugerencias.setDefaultRenderer(Object.class, new Render());
        tVolverA.setDefaultRenderer(Object.class, new Render());
        ColdStart();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        tbBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tBuscar = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lblTitulo2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tSugerencias = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tVolverA = new javax.swing.JTable();
        lblSolicitadas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(550, 500));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(550, 500));

        lblTitulo.setText("Sistema de recomendación de películas");
        lblTitulo.setName("lblTitulo"); // NOI18N

        lblBuscar.setText("Buscar:");
        lblBuscar.setName("lblBuscar"); // NOI18N

        tbBuscar.setName("tbBuscar"); // NOI18N
        tbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBuscarActionPerformed(evt);
            }
        });
        tbBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbBuscarKeyReleased(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.setName("btnBuscar"); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tBuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Director", "Año", "Idioma", "País", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tBuscar.setUpdateSelectionOnSort(false);
        tBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tBuscarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tBuscar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscar)
                .addGap(18, 18, 18)
                .addComponent(tbBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar)
                    .addComponent(tbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Buscador", jPanel1);

        lblTitulo2.setText("Sistema de recomendación de películas");
        lblTitulo2.setName("lblTitulo"); // NOI18N

        tSugerencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Director", "Año", "Idioma", "País", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tSugerencias.setUpdateSelectionOnSort(false);
        tSugerencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tSugerenciasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tSugerencias);

        tVolverA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Director", "Año", "Idioma", "País", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tVolverA.setUpdateSelectionOnSort(false);
        tVolverA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tVolverAMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tVolverA);

        lblSolicitadas.setText("Ya solicitadas...");
        lblSolicitadas.setName("lblTitulo"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(lblTitulo2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblSolicitadas)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSolicitadas)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Recomendaciones", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tSugerenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tSugerenciasMouseClicked
        //Con este método capturamos el evento en la tabla y obtenemos el Id de la película que queremos ver
        int column = tSugerencias.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tSugerencias.getRowHeight();

        if (row < tSugerencias.getRowCount() && row >=0 && column < tSugerencias.getColumnCount() && column >= 0) {
            Object value = tSugerencias.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                TableColumnModel tcm = tSugerencias.getColumnModel();
                String SId = (String)tSugerencias.getModel().getValueAt(row, 0);
                Detalles details = new Detalles(SId, Likes, this);
                this.setVisible(false);
                details.setVisible(true);
            }
        }
    }//GEN-LAST:event_tSugerenciasMouseClicked

    private void tBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tBuscarMouseClicked
        //Con este método capturamos el evento en la tabla y obtenemos el Id de la película que queremos ver
        int column = tBuscar.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tBuscar.getRowHeight();

        if (row < tBuscar.getRowCount() && row >=0 && column < tBuscar.getColumnCount() && column >= 0) {
            Object value = tBuscar.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                TableColumnModel tcm = tBuscar.getColumnModel();
                String SId = (String)tBuscar.getModel().getValueAt(row, 0);
                Detalles details = new Detalles(SId, Likes, this);
                this.setVisible(false);
                details.setVisible(true);
            }
        }
    }//GEN-LAST:event_tBuscarMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void Buscar()
    {
        String SearchString = tbBuscar.getText().replace("'", "''");
        if (SearchString.length() > 0) {
            String sqlQuery =   "SELECT " +
            "IDMOVIE [Id], " +            
            "Nombre [Nombre], " +
            "Director [Director], " +
            "CASE WHEN Anio = 0 THEN '-' ELSE CONVERT(NVARCHAR(5), Anio) END [Anio], " +
            "IDIOMA [Idioma], " +
            "PAIS [Pais] " +
            "FROM MOVIE " +
            "WHERE LOWER(Nombre) LIKE ('%" +
            SearchString
            + "%'); ";
            ArrayList<String> Columns = new ArrayList<String>();

            Columns.add("Id");            
            Columns.add("Nombre");
            Columns.add("Director");
            Columns.add("Anio");
            Columns.add("Idioma");
            Columns.add("Pais");

            ArrayList<ArrayList<String>> Busqueda = connection.ExecuteReaderQuery(sqlQuery, Columns);

            //Remove all rows in table
            int rowCount = model.getRowCount();
            //Remove rows one by one from the end of the table
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            
            ImageIcon icon = new ImageIcon(new ImageIcon("lupa.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            JButton buton = new JButton("Ver");
            buton.setIcon(icon);
            for (int i = 0; i < Busqueda.size(); i++) {
                model.insertRow(model.getRowCount(),
                    new Object[]{Busqueda.get(i).get(0),
                        Busqueda.get(i).get(1),
                        Busqueda.get(i).get(2),
                        Busqueda.get(i).get(3),
                        Busqueda.get(i).get(4),
                        Busqueda.get(i).get(5),
                        buton
                    });
                }

        }
    }
    private void tbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbBuscarActionPerformed

    private void tVolverAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tVolverAMouseClicked
        int column = tVolverA.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tVolverA.getRowHeight();

        if (row < tVolverA.getRowCount() && row >=0 && column < tVolverA.getColumnCount() && column >= 0) {
            Object value = tVolverA.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                TableColumnModel tcm = tVolverA.getColumnModel();
                String SId = (String)tVolverA.getModel().getValueAt(row, 0);
                Detalles details = new Detalles(SId, Likes, this);
                this.setVisible(false);
                details.setVisible(true);
            }
        }
    }//GEN-LAST:event_tVolverAMouseClicked

    private void tbBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbBuscarKeyReleased
        int code = evt.getKeyCode(); 
        //Si es enter que busque
        if (code == 10) {
            Buscar();
        }
    }//GEN-LAST:event_tbBuscarKeyReleased
    
    public void ActualizarSugerencias(String NewId) throws SQLException
    {
        //ArrayList<Movie> movies = knn.GenerarSugerencias(Likes);
        ArrayList<Movie> movies = knn.ActualizarSugerencias(Likes, NewId);
        DefaultTableModel modelaux = (DefaultTableModel)tSugerencias.getModel();
        //Remove all rows in table
        int rowCount = modelaux.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
                modelaux.removeRow(i);
            }
        int contador = 0;
        ImageIcon icon = new ImageIcon(new ImageIcon("lupa.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        JButton buton = new JButton("Ver");
        buton.setIcon(icon);
        for (int i = 0; i < movies.size(); i++) {
            if (!Likes.contains(movies.get(i).Id)) {
                if(contador<20)
                {
                    String anio;
                    if(movies.get(i).Anio!=0)
                    {
                        anio = String.valueOf(movies.get(i).Anio);
                    }
                    else
                    {
                        anio = "-";
                    }
                    modelaux.insertRow(modelaux.getRowCount(),
                    new Object[]{String.valueOf(movies.get(i).Id),
                        movies.get(i).Nombre,
                        movies.get(i).Director,
                        anio,
                        movies.get(i).Idioma,
                        movies.get(i).Pais,
                        buton
                    });
                    contador++;
                }
                else
                {
                    break;
                }
            }
            
        }
        //Remove all rows of the table
        modelaux = (DefaultTableModel)tVolverA.getModel();
        rowCount = modelaux.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
                modelaux.removeRow(i);
        }
        
        //Add to the other table
        for (int i = 0; i < movies.size(); i++) {
            if (Likes.contains(movies.get(i).Id)) {
                modelaux.insertRow(modelaux.getRowCount(),
                new Object[]{String.valueOf(movies.get(i).Id),
                    movies.get(i).Nombre,
                    movies.get(i).Director,
                    String.valueOf(movies.get(i).Anio),
                    movies.get(i).Idioma,
                    movies.get(i).Pais,
                    buton
                });
            }
        }
        
    }
    private void ColdStart()
    {
        String sqlQuery =   "SELECT TOP 12 " +
            "IDMOVIE [Id], " +
            "Nombre [Nombre], " +
            "Director [Director], " +
            "CASE WHEN Anio = 0 THEN '-' ELSE CONVERT(NVARCHAR(5), Anio) END [Anio], " +
            "IDIOMA [Idioma], " +
            "PAIS [Pais], " +
            "(Punteo/2+5*(1-POWER((2.71828),-NumRating/500000)))  [Ponderacion]" +
            "FROM MOVIE ORDER BY Ponderacion DESC;";

        ArrayList<String> Columns = new ArrayList<String>();
        
        Columns.add("Id");
        Columns.add("Nombre");
        Columns.add("Director");
        Columns.add("Anio");
        Columns.add("Idioma");
        Columns.add("Pais");

        ArrayList<ArrayList<String>> Busqueda = connection.ExecuteReaderQuery(sqlQuery, Columns);
        DefaultTableModel modelaux = (DefaultTableModel)tSugerencias.getModel();
        //Remove all rows in table
        int rowCount = modelaux.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
                modelaux.removeRow(i);
            }
        for (int i = rowCount - 1; i >= 0; i--) {
            //(, i);
        }
        ImageIcon icon = new ImageIcon(new ImageIcon("lupa.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        JButton buton = new JButton("Ver");
        buton.setIcon(icon);
        for (int i = 0; i < Busqueda.size(); i++) {
            modelaux.insertRow(modelaux.getRowCount(),
                new Object[]{Busqueda.get(i).get(0),
                    Busqueda.get(i).get(1),
                    Busqueda.get(i).get(2),
                    Busqueda.get(i).get(3),
                    Busqueda.get(i).get(4),
                    Busqueda.get(i).get(5),
                    buton
                });
        }
    }
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
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInicio().setVisible(true);
            }
        });
    }
//https://www.mssqltips.com/sqlservertip/4709/connecting-a-java-program-to-sql-server/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblSolicitadas;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JTable tBuscar;
    private javax.swing.JTable tSugerencias;
    private javax.swing.JTable tVolverA;
    private javax.swing.JTextField tbBuscar;
    // End of variables declaration//GEN-END:variables
}
