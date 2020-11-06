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
public class Movimiento_Bancario_Encabezado {

    JTextField Id_MovimientoE;
    JLabel Codigo_Documento;
    JTextField fecha;
    JTextField Monto;
    JTextField Descripcion;
    JTextField Buscar;
    JTable Tabla_MBEN;

    public Movimiento_Bancario_Encabezado(JTextField Id_MovimientoE, JLabel Codigo_Documento, JTextField fecha, JTextField Monto, JTextField Descripcion, JTextField Buscar, JTable Tabla_MBEN) {
        this.Id_MovimientoE = Id_MovimientoE;
        this.Codigo_Documento = Codigo_Documento;
        this.fecha = fecha;
        this.Monto = Monto;
        this.Descripcion = Descripcion;
        this.Buscar = Buscar;
        this.Tabla_MBEN = Tabla_MBEN;
    }
    

    public void Actualizar_Tabla() {
        int cantidad = Cantidad_Registros();

        String[] ConceptoB_Datos = new String[5];
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from mov_bancEnc");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Movimiento Encabezado");
            model.addColumn("Codigo Movimiento");
            model.addColumn("Fecha");
            model.addColumn("Monto");
            model.addColumn("Descripcion");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ConceptoB_Datos[0] = rs.getString("id_movEnc");
                ConceptoB_Datos[1] = rs.getString("codigo_Documento");
                ConceptoB_Datos[2] = rs.getString("fecha");
                ConceptoB_Datos[3] = rs.getString("monto");
                ConceptoB_Datos[4] = rs.getString("descripcion");

                model.addRow(ConceptoB_Datos);

                Tabla_MBEN.setModel(model);

            }
            //JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            Tabla_MBEN.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public int Cantidad_Registros() {
        int cant = 0;

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from mov_bancEnc");

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

    public void Insertar_MOBAEN() {
        try {
            Connection cnIEL = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into mov_bancEnc values(?,?,?,?,?)");

            pstIP.setString(1, Id_MovimientoE.getText().trim());
            pstIP.setString(2, Codigo_Documento.getText().trim());
            pstIP.setString(3, fecha.getText().trim());
            pstIP.setString(4, Monto.getText().trim());
            pstIP.setString(5, Descripcion.getText().trim());

            pstIP.executeUpdate();

            Id_MovimientoE.setText("");
            Codigo_Documento.setText("");
            fecha.setText("");
            Monto.setText("");
            Descripcion.setText("");

            JOptionPane.showMessageDialog(null, "Registro Exitoso");

            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Eliminar_MOBAEN() {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("delete from mov_bancEnc where id_movEnc = ?");

            pst.setString(1, Buscar.getText().trim());
            pst.executeUpdate();

            Id_MovimientoE.setText("");
            Codigo_Documento.setText("");
            fecha.setText("");
            Monto.setText("");
            Descripcion.setText("");

            JOptionPane.showMessageDialog(null, "Eliminacion Exitosa");
            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Modificar_MOBAEN() {
        try {
            String ID = Buscar.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pstSE = cn.prepareStatement("update mov_bancEnc set id_movEnc = ?, codigo_Documento = ?, fecha = ?,monto=?,descripcion=? where id_movEnc = " + ID);

            pstSE.setString(1, Id_MovimientoE.getText().trim());
            pstSE.setString(2, Codigo_Documento.getText().trim());
            pstSE.setString(3, fecha.getText().trim());
            pstSE.setString(4, Monto.getText().trim());
            pstSE.setString(5, Descripcion.getText().trim());

            pstSE.executeUpdate();

            Buscar.setText("");
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");

            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public DefaultTableModel Buscar_MOBAEN(String Buscar) {
        String[] nombre_ColumnasCon = {"id Movimiento Encabezado", "Codigo Documentos", "Fecha", "Monto", "Descripcion"};
        String[] RegistrosCon = new String[5];

        DefaultTableModel model = new DefaultTableModel(null, nombre_ColumnasCon);

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from mov_bancEnc WHERE id_movEnc LIKE '%" + Buscar + "%'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                RegistrosCon[0] = rs.getString("id_movEnc");
                RegistrosCon[1] = rs.getString("codigo_Documento");
                RegistrosCon[2] = rs.getString("fecha");
                RegistrosCon[3] = rs.getString("monto");
                RegistrosCon[4] = rs.getString("descripcion");

                model.addRow(RegistrosCon);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return model;
    }

    public void Buscar_MovimientoBanEn(String Buscar) {
        DefaultTableModel model = Buscar_MOBAEN(Buscar);
        Tabla_MBEN.setModel(model);
    }

    public void Encontrar_ListaMovimientoBAEN(String tablaBD, String nombre, JComboBox boxNombre) {
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

    /*Usar Para foraneas*/
    public void EncontrarID_MovimientoBAEN(String ID, String tablaBD, String Nombre, JComboBox boxNombre, JLabel label) {
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

    public void BuscarFila_MovimientoBAEN(String Nombre, String tablaBD, String ID, JComboBox boxNombre, JLabel labelID) {
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
