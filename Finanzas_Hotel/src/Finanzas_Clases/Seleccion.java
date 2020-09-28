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
public class Seleccion {

    JTextField Id_Seleccion;
    JLabel Aplicacion_Prueba;
    JTextField Status;
    JTextField Buscar_Seleccion;
    JTable Tabla_Sele;

    public Seleccion(JTextField Id_Seleccion, JLabel Aplicacion_Prueba, JTextField Status, JTextField Buscar_Seleccion, JTable Tabla_Sele) {
        this.Id_Seleccion = Id_Seleccion;
        this.Aplicacion_Prueba = Aplicacion_Prueba;
        this.Status = Status;
        this.Buscar_Seleccion = Buscar_Seleccion;
        this.Tabla_Sele = Tabla_Sele;
    }

    public void Actualizar_Tabla() {
        int cantidad = Cantidad_Registros();

        String[] SE_Datos = new String[9];
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from seleccion");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID  Seleccion");
            model.addColumn("Aplicacion Prueba");
            model.addColumn("Estatus Selección");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                SE_Datos[0] = rs.getString("id_seleccion");
                SE_Datos[1] = rs.getString("id_ap");
                SE_Datos[2] = rs.getString("estatus_seleccion");

                model.addRow(SE_Datos);

                Tabla_Sele.setModel(model);

            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            Tabla_Sele.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public int Cantidad_Registros() {
        int cant = 0;

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from seleccion");

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

    public void Insertar_Seleccion() {
        try {
            Connection cnIEL = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into seleccion values(?,?,?)");

            pstIP.setString(1, Id_Seleccion.getText().trim());
            pstIP.setString(2, Aplicacion_Prueba.getText().trim());
            pstIP.setString(3, Status.getText().trim());

            pstIP.executeUpdate();

            Id_Seleccion.setText("");
            Aplicacion_Prueba.setText("");
            Status.setText("");

            JOptionPane.showMessageDialog(null, "Registro Exitoso");

            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Eliminar_Seleccion() {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("delete from seleccion where id_seleccion = ?");

            pst.setString(1, Buscar_Seleccion.getText().trim());
            pst.executeUpdate();

            Id_Seleccion.setText("");
            Aplicacion_Prueba.setText("");
            Status.setText("");

            JOptionPane.showMessageDialog(null, "Eliminacion Exitosa");
            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Modificar_Seleccion() {
        try {
            String ID = Buscar_Seleccion.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pstSE = cn.prepareStatement("update seleccion set id_seleccion = ?, id_ap = ?, estatus_seleccion = ? where id_seleccion = " + ID);

            pstSE.setString(1, Id_Seleccion.getText().trim());
            pstSE.setString(2, Aplicacion_Prueba.getText().trim());
            pstSE.setString(3, Status.getText().trim());

            pstSE.executeUpdate();

            Buscar_Seleccion.setText("");
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");

            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public DefaultTableModel Buscar_Selecion(String Buscar) {
        String[] nombre_ColumnasSeleccion = {"ID Seleccion", "Aplicacion Prueba", "Estatus Seleccion"};
        String[] RegistrosSeleccion = new String[3];

        DefaultTableModel model = new DefaultTableModel(null, nombre_ColumnasSeleccion);

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from seleccion WHERE id_seleccion LIKE '%" + Buscar + "%'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                RegistrosSeleccion[0] = rs.getString("id_seleccion");
                RegistrosSeleccion[1] = rs.getString("id_ap");
                RegistrosSeleccion[2] = rs.getString("estatus_seleccion");

                model.addRow(RegistrosSeleccion);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return model;
    }

    public void Buscar_Sele(String Buscar) {
        DefaultTableModel model = Buscar_Selecion(Buscar);
        Tabla_Sele.setModel(model);
    }

    public void Encontrar_ListaSeleccion(String tablaBD, String nombre, JComboBox boxNombre) {
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

    public void EncontrarID_Seleccion(String ID, String tablaBD, String Nombre, JComboBox boxNombre, JLabel label) {
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

    public void BuscarFila_Seleccion(String Nombre, String tablaBD, String ID, JComboBox boxNombre, JLabel labelID) {
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
