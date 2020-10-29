/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas_Clases;

import static Finanzas_Clases.Departamento.Base_de_Datos;
import static Finanzas_Clases.Departamento.Clave;
import static Finanzas_Clases.Departamento.Usuario;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Langas
 */
public class Actividad_Empleado 
{
    //Atributos
    JLabel id_EAE;
    JLabel id_AAE;
    JTextField buscar_AE;
    JTable tabla_AE;

    public Actividad_Empleado(JLabel id_EAE, JLabel id_AAE, JTextField buscar_AE, JTable tabla_AE) {
        this.id_EAE = id_EAE;
        this.id_AAE = id_AAE;
        this.buscar_AE = buscar_AE;
        this.tabla_AE = tabla_AE;
    }

    
    
    public int Cantidad_Registros()
    {
        int cant = 0;
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from actividad_empleado");
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                cant++;
            }
         //JOptionPane.showMessageDialog(null, "La cantidad es " + cant);
        }catch(Exception e)
        {
            System.out.println(e);
        }

        
        return cant;
    }
    
    public void Actualizar_Tabla()
    {
        int cantidad = Cantidad_Registros();
        
        
        String[] APP_Datos = new String [2];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from actividad_empleado");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Empleado Contratado");
            model.addColumn("ID Actividad");
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                APP_Datos[0] = rs.getString("id_empleado");
                APP_Datos[1] = rs.getString("id_actividad");
                
                model.addRow(APP_Datos);
                
                tabla_AE.setModel(model);
                
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tabla_AE.setModel(model);
        }catch(Exception e)
        {
            System.out.println(e);
        }
                
    }
    
    public void Insertar_AE()
    {
        try
        {
            Connection  cnIEL = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into actividad_empleado values(?,?)");
            
            pstIP.setString(1, id_EAE.getText().trim());
            pstIP.setString(2, id_AAE.getText().trim());
            
            pstIP.executeUpdate();
            
            id_EAE.setText("");
            id_AAE.setText("");
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            
            
            Actualizar_Tabla();
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Modificar_AE()
    {
        try
        {
            String ID = buscar_AE.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstSE = cn.prepareStatement("update actividad_empleado set id_empleado = ? where actividad_empleado = " + ID);
            
            pstSE.setString(1, id_EAE.getText().trim());
            pstSE.setString(2, id_AAE.getText().trim());
            
           

            pstSE.executeUpdate();

            
            id_EAE.setText("");
            id_AAE.setText("");
            
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Eliminar_AE()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from actividad_empleado where id_empleado = ?");

            pst.setString(1, buscar_AE.getText().trim());
            pst.executeUpdate();

            
            id_EAE.setText("");
            id_AAE.setText("");

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public DefaultTableModel Buscar_AE(String Buscar)
    {
        String[] nombre_ColumnasAE = {"ID Empleado Contratado","ID Actividad"};
        String[] RegistrosAE = new String[2];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasAE);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from actividad_empleado WHERE id_empleado LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                RegistrosAE[0] = rs.getString("id_empleado");
                RegistrosAE[1] = rs.getString("id_actividad");
                
                model.addRow(RegistrosAE);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
    
    public void Encontrar_ListaAE(String tablaBD, String nombre,JComboBox boxNombre)
    {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from " + tablaBD);

            ResultSet rs = pst.executeQuery();
        
            //id_ExpLD.addItem("Seleccione Experiencia Laboral");

            while(rs.next()) {
                
                boxNombre.addItem(rs.getString(nombre));
                //idL_ExpLD.setText(rs.getString("id_tipoexp"));
            } 

        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void Buscar_AEF(String Buscar)
    {
        DefaultTableModel model = Buscar_AE(Buscar);
        tabla_AE.setModel(model);
    }
    
    public void EncontrarID_AE(String ID, String tablaBD, String Nombre,JComboBox boxNombre,JLabel label)
    {     
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select " +  ID  + " from " + tablaBD +" where " + Nombre + "= ?");
            pst.setString(1, boxNombre.getSelectedItem().toString());

            ResultSet rs = pst.executeQuery();
             

            if(rs.next()) {
                label.setText(rs.getString(ID));
            } 
         

        } catch (Exception e) 
        {
            System.out.println(e);
        }
    }
    
    public void BuscarFila_AE(String Nombre,String tablaBD, String ID,JComboBox boxNombre,JLabel labelID){
        try{
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select " +  Nombre  + " from " + tablaBD +" where " + ID + "= ?");
            pst.setString(1, labelID.getText());

            ResultSet rs = pst.executeQuery();
             

            if(rs.next()) {
                boxNombre.setSelectedItem(rs.getString(Nombre));
            } 
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
