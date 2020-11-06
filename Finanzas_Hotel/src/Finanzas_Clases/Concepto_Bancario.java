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
public class Concepto_Bancario {

    JTextField Codigo_Concepto;
    JTextField Nombre_Concepto;
    JTextField Afecta;
    JTextField Estatus;
    JLabel Id_Cuenta;
    JTable Tabla_Concepto;
    JTextField Buscar_CB;

    public Concepto_Bancario(JTextField Codigo_Concepto, JTextField Nombre_Concepto, JTextField Afecta, JTextField Estatus, JLabel Id_Cuenta, JTable Tabla_Concepto, JTextField Buscar_CB) {
        this.Codigo_Concepto = Codigo_Concepto;
        this.Nombre_Concepto = Nombre_Concepto;
        this.Afecta = Afecta;
        this.Estatus = Estatus;
        this.Id_Cuenta = Id_Cuenta;
        this.Tabla_Concepto = Tabla_Concepto;
        this.Buscar_CB = Buscar_CB;
    }

    public void Actualizar_Tabla() {
        int cantidad = Cantidad_Registros();

        String[] ConceptoB_Datos = new String[5];
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from concepto_bancario");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Codigo Concepto");
            model.addColumn("Nombre Concepto");
            model.addColumn("Afecta");
            model.addColumn("Estatus");
            model.addColumn("ID Cuenta");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ConceptoB_Datos[0] = rs.getString("codigo_concepto");
                ConceptoB_Datos[1] = rs.getString("nombre_concepto");
                ConceptoB_Datos[2] = rs.getString("afecta");
                ConceptoB_Datos[3] = rs.getString("estatus_concepto");
                ConceptoB_Datos[4] = rs.getString("id_cuenta");

                model.addRow(ConceptoB_Datos);

                Tabla_Concepto.setModel(model);

            }
            //JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            Tabla_Concepto.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public int Cantidad_Registros() {
        int cant = 0;

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from concepto_bancario");

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

    public void Insertar_ConceptoB() {
        try {
            Connection cnIEL = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into concepto_bancario values(?,?,?,?,?)");

            pstIP.setString(1, Codigo_Concepto.getText().trim());
            pstIP.setString(2, Nombre_Concepto.getText().trim());
            pstIP.setString(3, Afecta.getText().trim());
            pstIP.setString(4, Estatus.getText().trim());
            pstIP.setString(5, Id_Cuenta.getText().trim());

            pstIP.executeUpdate();

            Codigo_Concepto.setText("");
            Nombre_Concepto.setText("");
            Afecta.setText("");
            Id_Cuenta.setText("");
            Estatus.setText("");

            JOptionPane.showMessageDialog(null, "Registro Exitoso");

            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Eliminar_ConceptoB() {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("delete from concepto_bancario where codigo_concepto = ?");

            pst.setString(1, Buscar_CB.getText().trim());
            pst.executeUpdate();

            Codigo_Concepto.setText("");
            Nombre_Concepto.setText("");
            Afecta.setText("");
            Id_Cuenta.setText("");
            Estatus.setText("");

            JOptionPane.showMessageDialog(null, "Eliminacion Exitosa");
            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Modificar_ConceptoB() {
        try {
            String ID = Buscar_CB.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pstSE = cn.prepareStatement("update concepto_bancario set codigo_concepto = ?, nombre_concepto = ?, afecta = ?,estatus_concepto=?,id_cuenta=? where codigo_concepto = " + ID);

            pstSE.setString(1, Codigo_Concepto.getText().trim());
            pstSE.setString(2, Nombre_Concepto.getText().trim());
            pstSE.setString(3, Afecta.getText().trim());
            pstSE.setString(4, Estatus.getText().trim());
            pstSE.setString(5, Id_Cuenta.getText().trim());

            pstSE.executeUpdate();

            Buscar_CB.setText("");
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");

            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public DefaultTableModel Buscar_ConceptoB(String Buscar) {
        String[] nombre_ColumnasCon = {"Codigo Concepto", "Nombre Concepto", "Afecta", "Estatus", "ID Cuenta"};
        String[] RegistrosCon = new String[5];

        DefaultTableModel model = new DefaultTableModel(null, nombre_ColumnasCon);

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from concepto_bancario WHERE codigo_concepto LIKE '%" + Buscar + "%'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                RegistrosCon[0] = rs.getString("codigo_concepto");
                RegistrosCon[1] = rs.getString("nombre_concepto");
                RegistrosCon[2] = rs.getString("afecta");
                RegistrosCon[3] = rs.getString("estatus_concepto");
                RegistrosCon[4] = rs.getString("id_cuenta");

                model.addRow(RegistrosCon);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return model;
    }

    public void Buscar_SolicitudConceptoB(String Buscar) {
        DefaultTableModel model = Buscar_ConceptoB(Buscar);
        Tabla_Concepto.setModel(model);
    }

    public void Encontrar_ListaConceptoB(String tablaBD, String nombre, JComboBox boxNombre) {
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

    public void Encontrar_ListaConceptoBan(String tablaBD, String nombre, JComboBox boxNombre) {
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
    public void EncontrarID_ConceptoB(String ID, String tablaBD, String Nombre, JComboBox boxNombre, JLabel label) {
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

    public void BuscarFila_ConceptoB(String Nombre, String tablaBD, String ID, JComboBox boxNombre, JLabel labelID) {
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
