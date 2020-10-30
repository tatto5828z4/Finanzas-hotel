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
 * @author Brayan Cifuentes
 */
public class Empleado_Contratado {
    
    JTextField id_empleado;
    JLabel id_contratacion;
    JLabel id_puesto;
    JLabel id_departamento;
    JTextField sueldo_empleado;
    JTextField buscar_empleado;
    JTable tbl_empleado;

    
    
    public Empleado_Contratado(JTextField id_empleado, JLabel id_contratacion, JLabel id_puesto, JLabel id_departamento, JTextField sueldo_empleado, JTextField buscar_empleado, JTable tbl_empleado) {
        this.id_empleado = id_empleado;
        this.id_contratacion = id_contratacion;
        this.id_puesto = id_puesto;
        this.id_departamento = id_departamento;
        this.sueldo_empleado = sueldo_empleado;
        this.buscar_empleado = buscar_empleado;
        this.tbl_empleado = tbl_empleado;
    }

 
    
    public int Cantidad_Registros() {
        int cant = 0;

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from empleado_contratado");

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

    
    public void Actualizar_Tabla() 
    {
        
        int cantidad = Cantidad_Registros();

        String[] Referencias_Laborales = new String[5];
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from empleado_contratado");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Empleado ");
            model.addColumn("ID Contratacion");
            model.addColumn("ID Puesto");
            model.addColumn("ID Departamento");
            model.addColumn("Sueldo Empleado");
            

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Referencias_Laborales[0] = rs.getString("id_empleado");
                Referencias_Laborales[1] = rs.getString("id_contratacion");
                Referencias_Laborales[2] = rs.getString("id_puesto");
                Referencias_Laborales[3] = rs.getString("id_departamento");
                Referencias_Laborales[4] = rs.getString("sueldo_empleado");
                

                model.addRow(Referencias_Laborales);

                tbl_empleado.setModel(model);

            }
            
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tbl_empleado.setModel(model);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    
    public void Insertar_PP() 
    {
        try {
            Connection cnIEL = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into empleado_contratado values(?,?,?,?,?)");

            pstIP.setString(1, id_empleado.getText().trim());
            pstIP.setString(2, id_contratacion.getText().trim());
            pstIP.setString(3, id_puesto.getText().trim());
            pstIP.setString(4, id_departamento.getText().trim());
            pstIP.setString(5, sueldo_empleado.getText().trim());
            

            pstIP.executeUpdate();

            id_empleado.setText("");
            id_contratacion.setText("");
            id_puesto.setText("");
            id_departamento.setText("");
            sueldo_empleado.setText("");
            

            JOptionPane.showMessageDialog(null, "Registro Exitoso");

            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public void Modificar_EC()
    {
        try
        {
            String ID = buscar_empleado.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstSE = cn.prepareStatement("update empleado_contratado set id_empleado = ?, id_contratacion = ?, id_puesto = ?, id_departamento=?, sueldo_empleado=? where id_empleado = " + ID);
            
            pstSE.setString(1, id_empleado.getText().trim());
            pstSE.setString(2, id_contratacion.getText().trim());
            pstSE.setString(3, id_puesto.getText().trim());
            pstSE.setString(4, id_departamento.getText().trim());
            pstSE.setString(5, sueldo_empleado.getText().trim());
            
             

            pstSE.executeUpdate();

            buscar_empleado.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
     
    
    
    public void Eliminar_EC()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from empleado_contratado where id_empleado = ?");

            pst.setString(1, buscar_empleado.getText().trim());
            pst.executeUpdate();

            
            id_empleado.setText("");
            id_contratacion.setText("");
            id_puesto.setText("");
            id_departamento.setText("");
            sueldo_empleado.setText("");
            

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    
     public DefaultTableModel Buscar_EC(String Buscar) 
    {
        String[] nombre_ColumnasSE = {"ID Empleado", "ID Contratacion", "ID Puesto", "ID Departamento", "Sueldo Empleado"};
        String[] RegistrosSE = new String[5];

        DefaultTableModel model = new DefaultTableModel(null, nombre_ColumnasSE);

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from empleado_contratado WHERE id_empleado LIKE '%" + Buscar + "%'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) 
            {
                RegistrosSE[0] = rs.getString("id_empleado");
                RegistrosSE[1] = rs.getString("id_contratacion");
                RegistrosSE[2] = rs.getString("id_puesto");
                RegistrosSE[3] = rs.getString("id_departamento");
                RegistrosSE[4] = rs.getString("sueldo_empleado");
                
                

                model.addRow(RegistrosSE);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return model;
    }
    

    public void Buscar_ECE(String Buscar) 
    {
        DefaultTableModel model = Buscar_EC(Buscar);
        tbl_empleado.setModel(model);
    }

    
    
    
    public void Encontrar_ListaEC(String tablaBD, String nombre, JComboBox boxNombre) 
    {
        
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
    public void EncontrarID_CE(String ID, String tablaBD, String Nombre, JComboBox boxNombre, JLabel label) {

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

    
     public void BuscarFila_EC(String Nombre,String tablaBD, String ID,JComboBox boxNombre,JLabel labelID)
    {
        
        try{
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select " +  Nombre  + " from " + tablaBD +" where " + ID + "= ?");
            pst.setString(1, labelID.getText());

            ResultSet rs = pst.executeQuery();
             

            if(rs.next()) {
                boxNombre.setSelectedItem(rs.getString(Nombre));
            } 
        }catch(Exception e){
            
        }
    }
    
    
    
}
