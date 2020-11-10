/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Nomina;

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
 * @author Langas
 */
public class Concepto_Planilla {

    //Atributos
    JTextField ID_CP;
    JTextField Nombre_CP;
    String Tipo_CP;
    String Clase_CP;
    JTextField Valor_CP;
    String Aplicacion_CP;
    JTextField Buscar_CP;
    JTable Tabla_CP;
    JComboBox Combo_TipoCP;
    JComboBox Combo_ClaseCP;
    JComboBox Combo_AplicacionCP;

    public Concepto_Planilla(JTextField ID_CP, JTextField Nombre_CP, String Tipo_CP, String Clase_CP, JTextField Valor_CP, String Aplicacion_CP, JTextField Buscar_CP, JTable Tabla_CP, JComboBox Combo_TipoCP, JComboBox Combo_ClaseCP, JComboBox Combo_AplicacionCP) {
        this.ID_CP = ID_CP;
        this.Nombre_CP = Nombre_CP;
        this.Tipo_CP = Tipo_CP;
        this.Clase_CP = Clase_CP;
        this.Valor_CP = Valor_CP;
        this.Aplicacion_CP = Aplicacion_CP;
        this.Buscar_CP = Buscar_CP;
        this.Tabla_CP = Tabla_CP;
        this.Combo_TipoCP = Combo_TipoCP;
        this.Combo_ClaseCP = Combo_ClaseCP;
        this.Combo_AplicacionCP = Combo_AplicacionCP;
    }

    public void Actualizar_CP() {
        int cantidad = Cantidad_Registros();

        String[] CP_Datos = new String[5];
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from concepto_planilla");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Concepto Planilla");
            model.addColumn("Nombre Concepto Planilla");
            model.addColumn("Tipo Concepto Planilla");
            model.addColumn("Clase Concepto Planilla");
            model.addColumn("Valor Concepto Planilla");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                CP_Datos[0] = rs.getString("id_conceptoPlanilla");
                CP_Datos[1] = rs.getString("nombre_concepto");
                CP_Datos[2] = rs.getString("tipo_concepto");
                CP_Datos[3] = rs.getString("clase_concepto");
                CP_Datos[4] = rs.getString("Valor_concepto");

                model.addRow(CP_Datos);

                Tabla_CP.setModel(model);

            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            Tabla_CP.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int Cantidad_Registros() {
        int cant = 0;

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from concepto_planilla");

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

    public void Agregando_Item(String Item_TCP, String Item_CCP, String Item_ACP) {
        Combo_TipoCP.addItem(Item_TCP);
        Combo_ClaseCP.addItem(Item_CCP);
        Combo_AplicacionCP.addItem(Item_ACP);
    }

    public void Vaciando_TextField(JTextField RangoMenor, JTextField RangoMayor, JTextField IDEmpleado) {
        RangoMenor.setText("");
        RangoMayor.setText("");
        IDEmpleado.setText("");
    }

    public void Insertar_CP() {
        Tipo_CP = Combo_TipoCP.getSelectedItem().toString();
        Clase_CP = Combo_ClaseCP.getSelectedItem().toString();
        Aplicacion_CP = Combo_AplicacionCP.getSelectedItem().toString();

        try {
            Connection cnIP = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pstIP = cnIP.prepareStatement("insert into concepto_planilla values(?,?,?,?,?)");

            pstIP.setString(1, ID_CP.getText().trim());
            pstIP.setString(2, Nombre_CP.getText().trim());
            pstIP.setString(3, Tipo_CP);
            pstIP.setString(4, Clase_CP);
            pstIP.setString(5, Valor_CP.getText().trim());

            pstIP.executeUpdate();

            ID_CP.setText("");
            Nombre_CP.setText("");

            JOptionPane.showMessageDialog(null, "Registro Exitoso");

            Actualizar_CP();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Modificar_CP() {
        try {
            String ID = ID_CP.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("update concepto_planilla set id_conceptoPlanilla = ?, nombre_concepto=?,tipo_concepto = ?, clase_concepto=?, Valor_concepto=? where id_conceptoPlanilla = " + ID);

            pst.setString(1, ID_CP.getText().trim());
            pst.setString(2, Nombre_CP.getText().trim());
            pst.setString(3, Tipo_CP);
            pst.setString(4, Clase_CP);
            pst.setString(5, Valor_CP.getText().trim());

            pst.executeUpdate();

            Buscar_CP.setText("");
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");

            Actualizar_CP();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Eliminar_CP() {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("delete from concepto_planilla where id_conceptoPlanilla = ?");

            pst.setString(1, Buscar_CP.getText().trim());
            pst.executeUpdate();

            ID_CP.setText("");
            Nombre_CP.setText("");
            Tipo_CP = "";
            Clase_CP = "";
            Valor_CP.setText("");

            JOptionPane.showMessageDialog(null, "Eliminacion Exitosa");
            Actualizar_CP();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public DefaultTableModel Buscar_CP(String Buscar) {
        String[] nombre_ColumnasD = {"ID Concepto Planilla", "Nombre Concepto Planilla", "Tipo Concepto Planilla", "Clase Concepto Planilla", "Valor Concepto Planilla", "Aplicacion Concepto Planilla"};
        String[] RegistrosD = new String[5];

        DefaultTableModel model = new DefaultTableModel(null, nombre_ColumnasD);

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from concepto_planilla WHERE id_conceptoPlanilla LIKE '%" + Buscar + "%'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                RegistrosD[0] = rs.getString("id_conceptoPlanilla");
                RegistrosD[1] = rs.getString("nombre_concepto");
                RegistrosD[2] = rs.getString("tipo_concepto");
                RegistrosD[3] = rs.getString("clase_concepto");
                RegistrosD[4] = rs.getString("Valor_concepto");

                model.addRow(RegistrosD);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return model;
    }

    public void Buscar_CPF(String Buscar) {
        DefaultTableModel model = Buscar_CP(Buscar);
        Tabla_CP.setModel(model);
    }

    public void Encontrar_ListaCP(String tablaBD, String nombre, JComboBox boxNombre) {
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

    public void EncontrarID_CPP(String ID, String tablaBD, JLabel id) {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select " + ID + " from " + tablaBD);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                id.setText(rs.getString(ID));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void BuscarFila_CP(String Nombre, String tablaBD, JComboBox boxNombre) {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select " + Nombre + " from " + tablaBD);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                boxNombre.setSelectedItem(rs.getString(Nombre));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Datos_CP(JLabel L_ID) {
        String[] Concepto = new String[5];

        try 
        {
            String ID = L_ID.getText();
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from concepto_planilla where id_conceptoPlanilla = ?");
            pst.setString(1, ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) 
            {
                Concepto[0] = rs.getString("id_conceptoPlanilla");
                Concepto[1] = rs.getString("nombre_concepto");
                Concepto[2] = rs.getString("tipo_concepto");
                Concepto[3] = rs.getString("clase_concepto");
                Concepto[4] = rs.getString("Valor_concepto");
            } else 
            {

            }

        } catch (Exception e) 
        {
            System.out.println(e);
        }

    }

}

