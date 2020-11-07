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
public class Banco {

    JTextField Id_Banco;
    JTextField Nombre_Banco;
    JTextField Nombre_Cuenta;
    JTextField Clave_Banco;
    JTextField Funcionario;
    JTextField Telefono;
    JTextField Numero_Plaza;
    JTextField Numero_Sucursal;
    JTextField Saldo_Inicial;
    JLabel ID_Moneda;
    JLabel ID_MovimientoE;
    JTextField Buscar_Banco;
    JTable Tbl_Bancos;

    public Banco(JTextField Id_Banco, JTextField Nombre_Banco, JTextField Nombre_Cuenta, JTextField Clave_Banco, JTextField Funcionario, JTextField Telefono, JTextField Numero_Plaza, JTextField Numero_Sucursal, JTextField Saldo_Inicial, JLabel ID_Moneda, JLabel ID_MovimientoE, JTextField Buscar_Banco, JTable Tbl_Bancos) {
        this.Id_Banco = Id_Banco;
        this.Nombre_Banco = Nombre_Banco;
        this.Nombre_Cuenta = Nombre_Cuenta;
        this.Clave_Banco = Clave_Banco;
        this.Funcionario = Funcionario;
        this.Telefono = Telefono;
        this.Numero_Plaza = Numero_Plaza;
        this.Numero_Sucursal = Numero_Sucursal;
        this.Saldo_Inicial = Saldo_Inicial;
        this.ID_Moneda = ID_Moneda;
        this.ID_MovimientoE = ID_MovimientoE;
        this.Buscar_Banco = Buscar_Banco;
        this.Tbl_Bancos = Tbl_Bancos;
    }

    public void Actualizar_Tabla() {
        int cantidad = Cantidad_Registros();

        String[] ConceptoB_Datos = new String[11];
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from banco");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Banco");
            model.addColumn("Nombre Banco");
            model.addColumn("Nombre Cuenta");
            model.addColumn("Clave Banco");
            model.addColumn("Funcionario");
            model.addColumn("Telefono");
            model.addColumn("Numero Plaza");
            model.addColumn("Numero Sucursal");
            model.addColumn("Saldo Inicial");
            model.addColumn("ID Moneda");
            model.addColumn("ID MovimientoEnc");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ConceptoB_Datos[0] = rs.getString("Id_Banco");
                ConceptoB_Datos[1] = rs.getString("nombre_banco");
                ConceptoB_Datos[2] = rs.getString("nombre_cuenta");
                ConceptoB_Datos[3] = rs.getString("clave_banco");
                ConceptoB_Datos[4] = rs.getString("funcionario");
                ConceptoB_Datos[5] = rs.getString("telefono");
                ConceptoB_Datos[6] = rs.getString("numero_plaza");
                ConceptoB_Datos[7] = rs.getString("numero_sucursal");
                ConceptoB_Datos[8] = rs.getString("saldo_inicial");
                ConceptoB_Datos[9] = rs.getString("id_moneda");
                ConceptoB_Datos[10] = rs.getString("id_movEnc");

                model.addRow(ConceptoB_Datos);

                Tbl_Bancos.setModel(model);

            }
            //JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            Tbl_Bancos.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public int Cantidad_Registros() {
        int cant = 0;

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from banco");

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

    public void Insertar_Banco() {
        try {
            Connection cnIEL = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into banco values(?,?,?,?,?,?,?,?,?,?,?)");

            pstIP.setString(1, Id_Banco.getText().trim());
            pstIP.setString(2, Nombre_Banco.getText().trim());
            pstIP.setString(3, Nombre_Cuenta.getText().trim());
            pstIP.setString(4, Clave_Banco.getText().trim());
            pstIP.setString(5, Funcionario.getText().trim());
            pstIP.setString(6, Telefono.getText().trim());
            pstIP.setString(7, Numero_Plaza.getText().trim());
            pstIP.setString(8, Numero_Sucursal.getText().trim());
            pstIP.setString(9, Saldo_Inicial.getText().trim());
            pstIP.setString(10, ID_Moneda.getText().trim());
            pstIP.setString(11, ID_MovimientoE.getText().trim());

            pstIP.executeUpdate();

            Id_Banco.setText("");
            Nombre_Banco.setText("");
            Nombre_Cuenta.setText("");
            Clave_Banco.setText("");
            Funcionario.setText("");
            Telefono.setText("");
            Numero_Plaza.setText("");
            Numero_Sucursal.setText("");
            Saldo_Inicial.setText("");
            ID_Moneda.setText("");
            ID_MovimientoE.setText("");

            JOptionPane.showMessageDialog(null, "Registro Exitoso");

            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Eliminar_Banco() {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("delete from banco where Id_Banco = ?");

            pst.setString(1, Buscar_Banco.getText().trim());
            pst.executeUpdate();

            Id_Banco.setText("");
            Nombre_Banco.setText("");
            Nombre_Cuenta.setText("");
            Clave_Banco.setText("");
            Funcionario.setText("");
            Telefono.setText("");
            Numero_Plaza.setText("");
            Numero_Sucursal.setText("");
            Saldo_Inicial.setText("");
            ID_Moneda.setText("");
            ID_MovimientoE.setText("");

            JOptionPane.showMessageDialog(null, "Eliminacion Exitosa");
            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Modificar_Bancos() {
        try {
            String ID = Buscar_Banco.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pstSE = cn.prepareStatement("update banco set Id_Banco = ?, nombre_banco = ?, nombre_cuenta = ?,clave_banco=?,funcionario=?,telefono=?,numero_plaza=?,numero_sucursal=?,saldo_inicial=?,id_moneda=?,id_movEnc=? where Id_Banco = " + ID);

            pstSE.setString(1, Id_Banco.getText().trim());
            pstSE.setString(2, Nombre_Banco.getText().trim());
            pstSE.setString(3, Nombre_Cuenta.getText().trim());
            pstSE.setString(4, Clave_Banco.getText().trim());
            pstSE.setString(5, Funcionario.getText().trim());
            pstSE.setString(6, Telefono.getText().trim());
            pstSE.setString(7, Numero_Plaza.getText().trim());
            pstSE.setString(8, Numero_Sucursal.getText().trim());
            pstSE.setString(9, Saldo_Inicial.getText().trim());
            pstSE.setString(10, ID_Moneda.getText().trim());
            pstSE.setString(11, ID_MovimientoE.getText().trim());

            pstSE.executeUpdate();

            Buscar_Banco.setText("");
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");

            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public DefaultTableModel Buscar_Banco(String Buscar) {
        String[] nombre_ColumnasCon = {"ID Banco", "Nombre Banco", "Nombre Cuenta", "Clavo Banco", "Funcionario", "Telefono", "Numero Plaza", "Numero Sucurasal", "Saldo Inicial", "ID Moneda", "ID MovimientoEnc"};
        String[] ConceptoB_Datos = new String[11];

        DefaultTableModel model = new DefaultTableModel(null, nombre_ColumnasCon);

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from banco WHERE Id_Banco LIKE '%" + Buscar + "%'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ConceptoB_Datos[0] = rs.getString("Id_Banco");
                ConceptoB_Datos[1] = rs.getString("nombre_banco");
                ConceptoB_Datos[2] = rs.getString("nombre_cuenta");
                ConceptoB_Datos[3] = rs.getString("clave_banco");
                ConceptoB_Datos[4] = rs.getString("funcionario");
                ConceptoB_Datos[5] = rs.getString("telefono");
                ConceptoB_Datos[6] = rs.getString("numero_plaza");
                ConceptoB_Datos[7] = rs.getString("numero_sucursal");
                ConceptoB_Datos[8] = rs.getString("saldo_inicial");
                ConceptoB_Datos[9] = rs.getString("id_moneda");
                ConceptoB_Datos[10] = rs.getString("id_movEnc");
                model.addRow(ConceptoB_Datos);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return model;
    }

    public void Buscar_BancosB(String Buscar) {
        DefaultTableModel model = Buscar_Banco(Buscar);
        Tbl_Bancos.setModel(model);
    }

    public void Encontrar_ListaBancos(String tablaBD, String nombre, JComboBox boxNombre) {
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
    public void EncontrarID_Bancos(String ID, String tablaBD, String Nombre, JComboBox boxNombre, JLabel label) {
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

    public void BuscarFila_Bancos(String Nombre, String tablaBD, String ID, JComboBox boxNombre, JLabel labelID) {
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
