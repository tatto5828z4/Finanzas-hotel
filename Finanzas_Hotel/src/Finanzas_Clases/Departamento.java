/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas_Clases;

import java.sql.*;
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
public class Departamento 
{
    //Atributos
    String id_Departamento;
    String nombre_Departamento;
    String estatus_Departamento;
    
    public static String Base_de_Datos = "jdbc:mysql://localhost/Hotel";
    public static String Usuario = "root";
    public static String Clave = "root";
    

    //Constructor

    public Departamento(String id_Departamento, String nombre_Departamento, String estatus_Departamento) {
        this.id_Departamento = id_Departamento;
        this.nombre_Departamento = nombre_Departamento;
        this.estatus_Departamento = estatus_Departamento;
    }
    
    public void Insertar_Departamento(JTextField id, JTextField Nombre, JTextField Estatus,JTable Tabla)
    {
        try
        {
            Connection  cnID = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstID = cnID.prepareStatement("insert into departamento values(?,?,?)");
            
            pstID.setString(1, id.getText().trim());
            pstID.setString(2, Nombre.getText().trim());
            pstID.setString(3, Estatus.getText().trim());
            
            pstID.executeUpdate();
             
            id.setText("");
            Nombre.setText("");
            Estatus.setText("");
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            
            Actualizar_Tabla(Tabla);
            
  
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Modificar_Departamento(JTextField id, JTextField Nombre, JTextField Estatus,JTable Tabla, JTextField Buscar)
    {
        try
        {
            String ID = Buscar.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("update departamento set id_departamento = ?, nombre_departamento=?, estatus_departamento=? where id_departamento = " + ID);

            pst.setString(1, id.getText().trim());
            pst.setString(2, Nombre.getText().trim());
            pst.setString(3, Estatus.getText().trim());

            pst.executeUpdate();

            Buscar.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla(Tabla);
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Eliminar_Departamento(JTextField id, JTextField Nombre, JTextField Estatus,JTable Tabla, JTextField Buscar)
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from departamento where id_departamento = ?");

            pst.setString(1, Buscar.getText().trim());
            pst.executeUpdate();

            id.setText("");
            Nombre.setText("");
            Estatus.setText("");

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_Tabla(Tabla);
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public int Cantidad_Registros()
    {
        int cant = 0;
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from departamento");
            
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
  
    public void Actualizar_Tabla(JTable Tabla)
    {
        int cantidad = Cantidad_Registros();
        
        
        String[] Departamento_Datos = new String [3];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from departamento");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("id");
            model.addColumn("Nombre Departamento");
            model.addColumn("Estatus Departamento");
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                Departamento_Datos[0] = rs.getString("id_departamento");
                Departamento_Datos[1] = rs.getString("nombre_departamento");
                Departamento_Datos[2] = rs.getString("estatus_departamento");
                
                model.addRow(Departamento_Datos);
                
                Tabla.setModel(model);
                
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            Tabla.setModel(model);
        }catch(Exception e)
        {
            System.out.println(e);
        }
                
    }
    
    public DefaultTableModel Buscar_Departamento(String Buscar)
    {
        String[] nombre_ColumnasD = {"ID Departamento", "Nombre Departamento", "Estatus Departamento"};
        String[] RegistrosD = new String[3];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasD);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from departamento WHERE id_departamento LIKE '%"+Buscar+"%' OR nombre_departamento LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                RegistrosD[0] = rs.getString("id_Departamento");
                RegistrosD[1] = rs.getString("nombre_departamento");
                RegistrosD[2] = rs.getString("estatus_departamento");
                
                model.addRow(RegistrosD);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
    
    public void Buscar_Departamento(String Buscar,JTable Tabla)
    {
        DefaultTableModel model = Buscar_Departamento(Buscar);
        Tabla.setModel(model);
    }
    
    public void BuscarFila_Departamento(String Nombre,String tablaBD, String ID,JComboBox boxNombre,JLabel labelID)
    {
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
