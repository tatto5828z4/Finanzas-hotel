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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Geovani
 */
public class Contratacion {

    JTextField Id_Contratacion;
    JLabel Periodo_Prueba;
    JTextField Fecha_Contratacion;
    JTextField Duracion_Contrato;
    JTextField Estatus;
    JTextField Buscar_Con;
    JTable tbl_Contratacion;

    public Contratacion(JTextField Id_Contratacion, JLabel Periodo_Prueba, JTextField Fecha_Contratacion, JTextField Duracion_Contrato, JTextField Estatus, JTextField Buscar_Con, JTable tbl_Contratacion) {
        this.Id_Contratacion = Id_Contratacion;
        this.Periodo_Prueba = Periodo_Prueba;
        this.Fecha_Contratacion = Fecha_Contratacion;
        this.Duracion_Contrato = Duracion_Contrato;
        this.Estatus = Estatus;
        this.Buscar_Con = Buscar_Con;
        this.tbl_Contratacion = tbl_Contratacion;
    }

    public void Actualizar_Tabla() {
        int cantidad = Cantidad_Registros();

        String[] SE_Datos = new String[9];
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from contratacion");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID  Contratacion");
            model.addColumn("Periodo De Prueba");
            model.addColumn("Fecha de Contratacion");
            model.addColumn("Duracion De Contrato");
            model.addColumn("Estatus Contratacion");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                SE_Datos[0] = rs.getString("Id_Contratacion");
                SE_Datos[1] = rs.getString("id_periodop");
                SE_Datos[2] = rs.getString("fecha_contratacion");
                SE_Datos[3] = rs.getString("duracion_contrato");
                SE_Datos[4] = rs.getString("estatus_contratacion");

                model.addRow(SE_Datos);

                tbl_Contratacion.setModel(model);

            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tbl_Contratacion.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public int Cantidad_Registros() {
        int cant = 0;

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from contratacion");

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

    public void Insertar_Contratacion() {
        try {
            Connection cnIEL = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into contratacion values(?,?,?,?,?)");

            pstIP.setString(1, Id_Contratacion.getText().trim());
            pstIP.setString(2, Periodo_Prueba.getText().trim());
            pstIP.setString(3, Fecha_Contratacion.getText().trim());
            pstIP.setString(4, Duracion_Contrato.getText().trim());
            pstIP.setString(5, Estatus.getText().trim());

            pstIP.executeUpdate();

            Id_Contratacion.setText("");
            Periodo_Prueba.setText("");
            Fecha_Contratacion.setText("");
            Duracion_Contrato.setText("");
            Estatus.setText("");

            JOptionPane.showMessageDialog(null, "Registro Exitoso");

            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Eliminar_Contratacion() {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("delete from contratacion where id_contratacion = ?");

            pst.setString(1, Buscar_Con.getText().trim());
            pst.executeUpdate();

            Id_Contratacion.setText("");
            Periodo_Prueba.setText("");
            Fecha_Contratacion.setText("");
            Duracion_Contrato.setText("");
            Estatus.setText("");

            JOptionPane.showMessageDialog(null, "Eliminacion Exitosa");
            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Modificar_Contratacion() {
        try {
            String ID = Buscar_Con.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pstSE = cn.prepareStatement("update contratacion set id_contratacion = ?, id_periodop = ?, fecha_contratacion = ?,duracion_contrato=?,estatus_contratacion=? where id_contratacion = " + ID);

            pstSE.setString(1, Id_Contratacion.getText().trim());
            pstSE.setString(2, Periodo_Prueba.getText().trim());
            pstSE.setString(3, Fecha_Contratacion.getText().trim());
            pstSE.setString(4, Duracion_Contrato.getText().trim());
            pstSE.setString(5, Estatus.getText().trim());

            pstSE.executeUpdate();

            Buscar_Con.setText("");
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");

            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public DefaultTableModel Buscar_Contratacion(String Buscar) {
        String[] nombre_ColumnasCon = {"ID Contratacion", "Periodo De Prueba", "Fecha de Contratacion", "Duracion Del Contrato", "Estatus"};
        String[] RegistrosCon = new String[5];

        DefaultTableModel model = new DefaultTableModel(null, nombre_ColumnasCon);

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from contratacion WHERE id_contratacion LIKE '%" + Buscar + "%'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                RegistrosCon[0] = rs.getString("id_contratacion");
                RegistrosCon[1] = rs.getString("id_periodop");
                RegistrosCon[2] = rs.getString("fecha_contratacion");
                RegistrosCon[3] = rs.getString("duracion_contrato");
                RegistrosCon[4] = rs.getString("estatus_contratacion");

                model.addRow(RegistrosCon);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return model;
    }

    public void Buscar_SolicitudCon(String Buscar) {
        DefaultTableModel model = Buscar_Contratacion(Buscar);
        tbl_Contratacion.setModel(model);
    }

    public void Encontrar_ListaContratacion(String tablaBD, String nombre, JComboBox boxNombre) {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from " + tablaBD);

            ResultSet rs = pst.executeQuery();

            //id_ExpLD.addItem("Seleccione Experiencia Laboral");
            while (rs.next()) {

                boxNombre.addItem(rs.getString(nombre));
                //idL_ExpLD.setText(rs.getString("id_tipoexp"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void Encontrar_ListaCon(String tablaBD, String nombre, JComboBox boxNombre) {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from " + tablaBD);

            ResultSet rs = pst.executeQuery();

            //id_ExpLD.addItem("Seleccione Experiencia Laboral");
            while (rs.next()) {

                boxNombre.addItem(rs.getString(nombre));
                //idL_ExpLD.setText(rs.getString("id_tipoexp"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /*Usar Para foraneas*/
    public void EncontrarID_Contratacion(String ID, String tablaBD, String Nombre, JComboBox boxNombre, JLabel label) {
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

    public void BuscarFila_Contratacion(String Nombre, String tablaBD, String ID, JComboBox boxNombre, JLabel labelID) {
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
