/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas_Tablas;

import Clases_RRHH.Experiencia_Laboral_Detallada;
import Clases_RRHH.Puesto;

/**
 *
 * @author Langas
 */
public class Nivel_Academico_Ve extends javax.swing.JFrame {

    /**
     * Creates new form ExpLD
     */
    int x, y;

    public Nivel_Academico_Ve() {
        initComponents();

        //AWTUtilities.setWindowOpacity();
        Clases_RRHH.Nivel_Academico NA = new Clases_RRHH.Nivel_Academico(txt_id_NivelA, txt_Nombre_NivelA, txt_Descripcion_NivelA, txt_Buscar_NivelA, tbl_NivelA);
        NA.Actualizar_Tabla();
        txt_id_NivelA.setVisible(false);
        txt_Nombre_NivelA.setVisible(false);
        txt_Descripcion_NivelA.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ExpLD = new javax.swing.JPanel();
        jLabel_Titulo = new javax.swing.JLabel();
        Movimiento = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Buscar_NivelA = new javax.swing.JLabel();
        txt_Buscar_NivelA = new javax.swing.JTextField();
        jScrollPane23 = new javax.swing.JScrollPane();
        tbl_NivelA = new javax.swing.JTable();
        icono_Buscar2 = new javax.swing.JLabel();
        txt_id_NivelA = new javax.swing.JTextField();
        txt_Descripcion_NivelA = new javax.swing.JTextField();
        txt_Nombre_NivelA = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExpLD.setBackground(new java.awt.Color(28, 27, 33));
        ExpLD.setEnabled(false);
        ExpLD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Titulo.setText("Nivel Academico");
        ExpLD.add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 280, 40));

        Movimiento.setBackground(new java.awt.Color(28, 27, 33));
        Movimiento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MovimientoMouseDragged(evt);
            }
        });
        Movimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MovimientoMousePressed(evt);
            }
        });
        Movimiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        Movimiento.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 20, 30));

        ExpLD.add(Movimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 40));

        jLabel_Buscar_NivelA.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_NivelA.setText("Buscar");
        ExpLD.add(jLabel_Buscar_NivelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        txt_Buscar_NivelA.setBackground(new java.awt.Color(40, 41, 46));
        txt_Buscar_NivelA.setForeground(new java.awt.Color(255, 255, 255));
        txt_Buscar_NivelA.setBorder(null);
        txt_Buscar_NivelA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Buscar_NivelAActionPerformed(evt);
            }
        });
        txt_Buscar_NivelA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Buscar_NivelAKeyReleased(evt);
            }
        });
        ExpLD.add(txt_Buscar_NivelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 290, 20));

        tbl_NivelA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_NivelA.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_NivelA.setSelectionBackground(new java.awt.Color(40, 41, 46));
        tbl_NivelA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NivelAMouseClicked(evt);
            }
        });
        jScrollPane23.setViewportView(tbl_NivelA);

        ExpLD.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 600, 190));

        icono_Buscar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        ExpLD.add(icono_Buscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 20, 20));

        txt_id_NivelA.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_NivelA.setForeground(new java.awt.Color(255, 255, 255));
        txt_id_NivelA.setBorder(null);
        txt_id_NivelA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_NivelAActionPerformed(evt);
            }
        });
        ExpLD.add(txt_id_NivelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 140, 20));

        txt_Descripcion_NivelA.setBackground(new java.awt.Color(40, 41, 46));
        txt_Descripcion_NivelA.setForeground(new java.awt.Color(255, 255, 255));
        txt_Descripcion_NivelA.setBorder(null);
        txt_Descripcion_NivelA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Descripcion_NivelAActionPerformed(evt);
            }
        });
        ExpLD.add(txt_Descripcion_NivelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 140, 20));

        txt_Nombre_NivelA.setBackground(new java.awt.Color(40, 41, 46));
        txt_Nombre_NivelA.setForeground(new java.awt.Color(255, 255, 255));
        txt_Nombre_NivelA.setBorder(null);
        txt_Nombre_NivelA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Nombre_NivelAActionPerformed(evt);
            }
        });
        ExpLD.add(txt_Nombre_NivelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 140, 20));

        getContentPane().add(ExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        setBounds(0, 0, 629, 423);
    }// </editor-fold>//GEN-END:initComponents

    private void MovimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MovimientoMousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_MovimientoMousePressed

    private void MovimientoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MovimientoMouseDragged
        // TODO add your handling code here:
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_MovimientoMouseDragged

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_Buscar_NivelAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Buscar_NivelAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Buscar_NivelAActionPerformed

    private void txt_Buscar_NivelAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Buscar_NivelAKeyReleased
        // TODO add your handling code here:
        Clases_RRHH.Nivel_Academico NA = new Clases_RRHH.Nivel_Academico(txt_id_NivelA, txt_Nombre_NivelA, txt_Descripcion_NivelA, txt_Buscar_NivelA, tbl_NivelA);
        NA.Buscar_NivelAF(txt_Buscar_NivelA.getText());
    }//GEN-LAST:event_txt_Buscar_NivelAKeyReleased

    private void tbl_NivelAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NivelAMouseClicked
        // TODO add your handling code here:
        int Seleccion = tbl_NivelA.rowAtPoint(evt.getPoint());
        txt_id_NivelA.setText(String.valueOf(tbl_NivelA.getValueAt(Seleccion, 0)));
        txt_Nombre_NivelA.setText(String.valueOf(tbl_NivelA.getValueAt(Seleccion, 1)));
        txt_Descripcion_NivelA.setText(String.valueOf(tbl_NivelA.getValueAt(Seleccion, 2)));
    }//GEN-LAST:event_tbl_NivelAMouseClicked

    private void txt_id_NivelAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_NivelAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_NivelAActionPerformed

    private void txt_Nombre_NivelAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Nombre_NivelAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Nombre_NivelAActionPerformed

    private void txt_Descripcion_NivelAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Descripcion_NivelAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Descripcion_NivelAActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Nivel_Academico_Ve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nivel_Academico_Ve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nivel_Academico_Ve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nivel_Academico_Ve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nivel_Academico_Ve().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ExpLD;
    private javax.swing.JPanel Movimiento;
    private javax.swing.JLabel icono_Buscar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Buscar_NivelA;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JTable tbl_NivelA;
    private javax.swing.JTextField txt_Buscar_NivelA;
    private javax.swing.JTextField txt_Descripcion_NivelA;
    private javax.swing.JTextField txt_Nombre_NivelA;
    private javax.swing.JTextField txt_id_NivelA;
    // End of variables declaration//GEN-END:variables
}
