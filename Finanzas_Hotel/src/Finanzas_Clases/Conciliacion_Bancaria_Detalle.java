/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas_Clases;
import static Finanzas_Clases.Departamento.Base_de_Datos;
import static Finanzas_Clases.Departamento.Clave;
import static Finanzas_Clases.Departamento.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jorgi
 */
public class Conciliacion_Bancaria_Detalle {
    JLabel jLabel_ID_Encabezado;
    JLabel jLabel_Idcodigoconcepto;
    JTextField txt_fechaap;
    JTextArea jTextArea_Descrip;
    JLabel jLabel_idformapago;
    JTextField txt_beneficiario;
    JTextField txt_estcon;
    JTextField txt_cargo;
    JTextField txt_abono;
    JTextField txt_buscardCBD;
    JTable tbl_CBD;
    //constructor
    //Conciliacion_Bancaria_Detalle CBD = new Conciliacion_Bancaria_Detalle(jLabel_ID_Encabezado,jLabel_Idcodigoconcepto,txt_fechaap,jTextArea_Descrip,jLabel_idformapago, txt_beneficiario,txt_estcon,txt_cargo,txt_abono,txt_buscardBan1,tbl_CBD);
    public Conciliacion_Bancaria_Detalle(JLabel jLabel_ID_Encabezado, JLabel jLabel_Idcodigoconcepto, JTextField txt_fechaap, JTextArea jTextArea_Descrip, JLabel jLabel_idformapago, JTextField txt_beneficiario, JTextField txt_estcon, JTextField txt_cargo, JTextField txt_abono, JTextField txt_buscardCBD, JTable tbl_CBD) {
        this.jLabel_ID_Encabezado = jLabel_ID_Encabezado;
        this.jLabel_Idcodigoconcepto = jLabel_Idcodigoconcepto;
        this.txt_fechaap = txt_fechaap;
        this.jTextArea_Descrip = jTextArea_Descrip;
        this.jLabel_idformapago = jLabel_idformapago;
        this.txt_beneficiario = txt_beneficiario;
        this.txt_estcon = txt_estcon;
        this.txt_cargo = txt_cargo;
        this.txt_abono = txt_abono;
        this.txt_buscardCBD = txt_buscardCBD;
        this.tbl_CBD = tbl_CBD;
    }
    
    public void Actualizar_Tabla() {
        int cantidad = Cantidad_Registros();

        String[] ConciliacionBD_Datos = new String[9];
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from conciliacion_bancaria_det");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Encabezado");
            model.addColumn("Codigo Concepto");
            model.addColumn("Fecha Aplicacion");
            model.addColumn("Descripcion");
            model.addColumn("ID forma de pago");
            model.addColumn("beneficiario");
            model.addColumn("Estado Conciliacion");
            model.addColumn("Cargo");
            model.addColumn("Abono");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ConciliacionBD_Datos[0] = rs.getString("id_encabezado");
                ConciliacionBD_Datos[1] = rs.getString("codigo_concepto");
                ConciliacionBD_Datos[2] = rs.getString("fecha_aplicacion");
                ConciliacionBD_Datos[3] = rs.getString("descripcion");
                ConciliacionBD_Datos[4] = rs.getString("id_formapago");
                ConciliacionBD_Datos[5] = rs.getString("beneficiario");
                ConciliacionBD_Datos[6] = rs.getString("estado_conciliacion");
                ConciliacionBD_Datos[7] = rs.getString("cargo");
                ConciliacionBD_Datos[8] = rs.getString("abono");

                model.addRow(ConciliacionBD_Datos);

                tbl_CBD.setModel(model);

            }
            //JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tbl_CBD.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public int Cantidad_Registros() {
        int cant = 0;

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from conciliacion_bancaria_det");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                cant++;
            }
            //JOptionPane.showMessageDialog(null, "La cantidad es " + cant);
        } catch (Exception e) {
            System.out.println(e);
        }

        return cant;
    }
    
    public void Insertar_CBD() {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("insert into conciliacion_bancaria_det values(?,?,?,?,?,?,?,?,?)");

            pst.setString(1, jLabel_ID_Encabezado.getText().trim());
            pst.setString(2, jLabel_Idcodigoconcepto.getText().trim());
            pst.setString(3, txt_fechaap.getText().trim());
            pst.setString(4, jTextArea_Descrip.getText().trim());
            pst.setString(5, jLabel_idformapago.getText().trim());
            pst.setString(6, txt_beneficiario.getText().trim());
            pst.setString(7, txt_estcon.getText().trim());
            pst.setString(8, txt_cargo.getText().trim());
            pst.setString(9, txt_abono.getText().trim());

            pst.executeUpdate();

            jLabel_ID_Encabezado.setText("");
            jLabel_Idcodigoconcepto.setText("");
            txt_fechaap.setText("");
            jTextArea_Descrip.setText("");
            jLabel_idformapago.setText("");
            txt_beneficiario.setText("");
            txt_estcon.setText("");
            txt_cargo.setText("");
            txt_abono.setText("");

            JOptionPane.showMessageDialog(null, "Registro Exitoso");

            

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void Eliminar_CBD() {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("delete from conciliacion_bancaria_det where codigo_concepto = ?");

            pst.setString(1, txt_buscardCBD.getText().trim());
            pst.executeUpdate();

            jLabel_ID_Encabezado.setText("");
            jLabel_Idcodigoconcepto.setText("");
            txt_fechaap.setText("");
            jTextArea_Descrip.setText("");
            jLabel_idformapago.setText("");
            txt_beneficiario.setText("");
            txt_estcon.setText("");
            txt_cargo.setText("");
            txt_abono.setText("");

            JOptionPane.showMessageDialog(null, "Eliminacion Exitosa");
            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }    
    public void Modificar_CBD() {
        try {
            String ID = txt_buscardCBD.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pstSE = cn.prepareStatement("update conciliacion_bancaria_det set id_encabezado = ?, codigo_concepto = ?, fecha_aplicacion = ?,descripcion=?,id_formapago=?,beneficiario=?,estado_conciliacion=?,cargo=?,abono=? where codigo_concepto = " + ID);

            pstSE.setString(1, jLabel_ID_Encabezado.getText().trim());
            pstSE.setString(2, jLabel_Idcodigoconcepto.getText().trim());
            pstSE.setString(3, txt_fechaap.getText().trim());
            pstSE.setString(4, jTextArea_Descrip.getText().trim());
            pstSE.setString(5, jLabel_idformapago.getText().trim());
            pstSE.setString(6, txt_beneficiario.getText().trim());
            pstSE.setString(7, txt_estcon.getText().trim());
            pstSE.setString(8, txt_cargo.getText().trim());
            pstSE.setString(9, txt_abono.getText().trim());

            pstSE.executeUpdate();

            txt_buscardCBD.setText("");
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");

            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public DefaultTableModel Buscar_CBD(String Buscar) {
        String[] nombre_ColumnasCon = {"ID ENCABEZADO", "CODIGO CONCEPTO", "FECHA APLICACION", "DESCRIPCION", "ID FORMA PAGO", "BENEFICIARIO", "ESTADO CONCILIACION", "CARGO", "ABONO"};
        String[] ConceptoBD_Datos = new String[11];

        DefaultTableModel model = new DefaultTableModel(null, nombre_ColumnasCon);

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from conciliacion_bancaria_det WHERE codigo_concepto LIKE '%" + Buscar + "%'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ConceptoBD_Datos[0] = rs.getString("id_encabezado");
                ConceptoBD_Datos[1] = rs.getString("codigo_concepto");
                ConceptoBD_Datos[2] = rs.getString("fecha_aplicacion");
                ConceptoBD_Datos[3] = rs.getString("descripcion");
                ConceptoBD_Datos[4] = rs.getString("id_formapago");
                ConceptoBD_Datos[5] = rs.getString("beneficiario");
                ConceptoBD_Datos[6] = rs.getString("estado_conciliacion");
                ConceptoBD_Datos[7] = rs.getString("cargo");
                ConceptoBD_Datos[8] = rs.getString("abono");
                model.addRow(ConceptoBD_Datos);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return model;
    }
    
    public void Buscar_CBD2(String Buscar) {
        DefaultTableModel model = Buscar_CBD(Buscar);
        tbl_CBD.setModel(model);
    }
    
    public void Encontrar_ListaCBD(String tablaBD, String nombre, JComboBox boxNombre) {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from " + tablaBD);

            ResultSet rs = pst.executeQuery();

            //id_ExpLD.addItem("Seleccione Experiencia Laboral");
            while (rs.next()) {

                boxNombre.addItem(rs.getString(nombre));

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public void EncontrarID_CBD(String ID, String tablaBD, String Nombre, JComboBox boxNombre, JLabel label) {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select " + ID + " from " + tablaBD + " where " + Nombre + "= ?");
            pst.setString(1, boxNombre.getSelectedItem().toString());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                label.setText(rs.getString(ID));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void BuscarFila_CBD(String Nombre, String tablaBD, String ID, JComboBox boxNombre, JLabel labelID) {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select " + Nombre + " from " + tablaBD + " where " + ID + "= ?");
            pst.setString(1, labelID.getText());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                boxNombre.setSelectedItem(rs.getString(Nombre));
            }
        } catch (Exception e) {

        }
    }
}
