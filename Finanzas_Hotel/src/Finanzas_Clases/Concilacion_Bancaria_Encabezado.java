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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Geovani
 */
public class Concilacion_Bancaria_Encabezado {

    JTextField ID_Encabezado;
    JTextField Cargo_Conciliar;
    JTextField Abono_Conciliar;
    JTextField Saldo_Corte;
    JTextField Cargo_Conciliado;
    JTextField Abono_Conciliado;
    JTextField Saldo_Final;
    JTextField Buscar_Conciliacion;
    JTable Tbl_Concilacion;

    public Concilacion_Bancaria_Encabezado(JTextField ID_Encabezado, JTextField Cargo_Conciliar, JTextField Abono_Conciliar, JTextField Saldo_Corte, JTextField Cargo_Conciliado, JTextField Abono_Conciliado, JTextField Saldo_Final, JTextField Buscar_Conciliacion, JTable Tbl_Concilacion) {
        this.ID_Encabezado = ID_Encabezado;
        this.Cargo_Conciliar = Cargo_Conciliar;
        this.Abono_Conciliar = Abono_Conciliar;
        this.Saldo_Corte = Saldo_Corte;
        this.Cargo_Conciliado = Cargo_Conciliado;
        this.Abono_Conciliado = Abono_Conciliado;
        this.Saldo_Final = Saldo_Final;
        this.Buscar_Conciliacion = Buscar_Conciliacion;
        this.Tbl_Concilacion = Tbl_Concilacion;
    }

    public void Actualizar_Tabla() {
        //int cantidad = Cantidad_Registros();

        String[] ConciliacionEn = new String[7];
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from conciliacion_bancenc");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Encabezado");
            model.addColumn("Cargo Conciliar");
            model.addColumn("Abono Conciliar");
            model.addColumn("Saldo Corte");
            model.addColumn("Cargo Conciliado");
            model.addColumn("Abono Conciliado");
            model.addColumn("Saldo Final");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ConciliacionEn[0] = rs.getString("id_encabezado");
                ConciliacionEn[1] = rs.getString("cargo_conciliar");
                ConciliacionEn[2] = rs.getString("abono_conciliar");
                ConciliacionEn[3] = rs.getString("saldo_corte");
                ConciliacionEn[4] = rs.getString("cargo_conciliado");
                ConciliacionEn[5] = rs.getString("abono_conciliado");
                ConciliacionEn[6] = rs.getString("saldo_final");

                model.addRow(ConciliacionEn);

                Tbl_Concilacion.setModel(model);

            }
            //JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            Tbl_Concilacion.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int Cantidad_Registros() {
        int cant = 0;

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from conciliacion_bancenc");

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

    public void Insertar_ConciliacionEn() {
        try {
            Connection cnINA = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pstINA = cnINA.prepareStatement("insert into conciliacion_bancenc values(?,?,?,?,?,?,?)");

            pstINA.setString(1, ID_Encabezado.getText().trim());
            pstINA.setString(2, Cargo_Conciliar.getText().trim());
            pstINA.setString(3, Abono_Conciliar.getText().trim());
            pstINA.setString(4, Saldo_Corte.getText().trim());
            pstINA.setString(5, Cargo_Conciliado.getText().trim());
            pstINA.setString(6, Abono_Conciliado.getText().trim());
            pstINA.setString(7, Saldo_Final.getText().trim());

            pstINA.executeUpdate();

            ID_Encabezado.setText("");
            Cargo_Conciliar.setText("");
            Abono_Conciliar.setText("");
            Saldo_Corte.setText("");
            Cargo_Conciliado.setText("");
            Abono_Conciliado.setText("");
            Saldo_Final.setText("");

            JOptionPane.showMessageDialog(null, "Registro Exitoso");

            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Modificar_ConciliacionEN() {
        try {
            String ID = Buscar_Conciliacion.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("update conciliacion_bancenc set id_encabezado = ?, cargo_conciliar=?,abono_conciliar = ?,saldo_corte=?,cargo_conciliado=?,abono_conciliado=?,saldo_final=? where id_encabezado = " + ID);

            pst.setString(1, ID_Encabezado.getText().trim());
            pst.setString(2, Cargo_Conciliar.getText().trim());
            pst.setString(3, Abono_Conciliar.getText().trim());
            pst.setString(4, Saldo_Corte.getText().trim());
            pst.setString(5, Cargo_Conciliado.getText().trim());
            pst.setString(6, Abono_Conciliado.getText().trim());
            pst.setString(7, Saldo_Final.getText().trim());

            pst.executeUpdate();

            Buscar_Conciliacion.setText("");
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");

            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Eliminar_ConcilacionEn() {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("delete from conciliacion_bancenc where id_encabezado = ?");

            pst.setString(1, Buscar_Conciliacion.getText().trim());
            pst.executeUpdate();

            ID_Encabezado.setText("");
            Cargo_Conciliar.setText("");
            Abono_Conciliar.setText("");
            Saldo_Corte.setText("");
            Cargo_Conciliado.setText("");
            Abono_Conciliado.setText("");
            Saldo_Final.setText("");
            JOptionPane.showMessageDialog(null, "Eliminacion Exitosa");
            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public DefaultTableModel Buscar_ConcilacionEn(String Buscar) {
        String[] nombre_ColumnasD = {"ID Encabezado", "Cargo Conciliar", "Abono Conciliar","Saldo Corte","Cargo Conciliado","Abono Conciliado","Saldo Final"};
        String[] ConciliacionEn = new String[7];

        DefaultTableModel model = new DefaultTableModel(null, nombre_ColumnasD);

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from conciliacion_bancenc WHERE id_encabezado LIKE '%" + Buscar + "%' OR nombre_nivel LIKE '%" + Buscar + "%'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                ConciliacionEn[0] = rs.getString("id_encabezado");
                ConciliacionEn[1] = rs.getString("cargo_conciliar");
                ConciliacionEn[2] = rs.getString("abono_conciliar");
                ConciliacionEn[3] = rs.getString("saldo_corte");
                ConciliacionEn[4] = rs.getString("cargo_conciliado");
                ConciliacionEn[5] = rs.getString("abono_conciliado");
                ConciliacionEn[6] = rs.getString("saldo_final");

                model.addRow(ConciliacionEn);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return model;
    }

    public void Buscar_ConciliacionEncabezado(String Buscar) {
        DefaultTableModel model = Buscar_ConcilacionEn(Buscar);
        Tbl_Concilacion.setModel(model);
    }
}
