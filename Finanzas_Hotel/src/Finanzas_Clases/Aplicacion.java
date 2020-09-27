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

public class Aplicacion {
    
    JTextField id_Aplicacion;
    JLabel dpi;
    JTextField cumple_Requisitos;
    JTextField buscar_Aplicacion;
    JTable tbl_Ap;



    public Aplicacion(JTextField id_Aplicacion, JLabel dpi, JTextField cumple_Requisitos, JTextField buscar_Aplicacion, JTable tbl_Ap) {
        this.id_Aplicacion = id_Aplicacion;
        this.dpi = dpi;
        this.cumple_Requisitos = cumple_Requisitos;
        this.buscar_Aplicacion = buscar_Aplicacion;
        this.tbl_Ap = tbl_Ap;
    }
    
    
     public int Cantidad_Registros()
    {
        int cant = 0;
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from aplicacion");
            
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
        
        
        String[] Referencias_Laborales = new String [3];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from aplicacion");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Aplicacion");
            model.addColumn("DPI Persona");
            model.addColumn("Cumple Requisitos");
            
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                Referencias_Laborales[0] = rs.getString("id_aplicacion");
                Referencias_Laborales[1] = rs.getString("dpi_persona");
                Referencias_Laborales[2] = rs.getString("cumple_requisitos");
                
                
                model.addRow(Referencias_Laborales);
                
                tbl_Ap.setModel(model);
                
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tbl_Ap.setModel(model);
        }catch(Exception e)
        {
            System.out.println(e);
        }
                
    }
    
    
    public void Insertar_Aplicacion()
    {
        try
        {
            Connection  cnAp = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstAp = cnAp.prepareStatement("insert into aplicacion values(?,?,?)");
            
            pstAp.setString(1, id_Aplicacion.getText().trim());
            pstAp.setString(2, dpi.getText().trim());
            pstAp.setString(3, cumple_Requisitos.getText().trim());
           
            pstAp.executeUpdate();
            
            id_Aplicacion.setText("");
            dpi.setText("");
            cumple_Requisitos.setText("");
            
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            
            
            Actualizar_Tabla();

            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
     public void Modificar_Aplicacion()
    {
        try
        {
            String ID = buscar_Aplicacion.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("update aplicacion set id_aplicacion = ?, dpi_persona=?,cumple_requisitos = ? where id_aplicacion = " + ID);

            pst.setString(1, id_Aplicacion.getText().trim());
            pst.setString(2, dpi.getText().trim());
            pst.setString(3, cumple_Requisitos.getText().trim());

            pst.executeUpdate();

            buscar_Aplicacion.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
     public void Eliminar_Aplicacion()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from aplicacion where id_aplicacion = ?");

            pst.setString(1, buscar_Aplicacion.getText().trim());
            pst.executeUpdate();

            id_Aplicacion.setText("");
            dpi.setText("");
            cumple_Requisitos.setText("");
            

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
     
    
    public DefaultTableModel Buscar_Aplicacion(String Buscar)
    {
        String[] nombre_ColumnasSE = {"ID Aplicacion", "DPI", "Cumple Requisitos"};
        String[] RegistrosSE = new String[3];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasSE);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from aplicacion WHERE id_aplicacion LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                 RegistrosSE[0] = rs.getString("id_aplicacion");
                RegistrosSE[1] = rs.getString("dpi_persona");
                RegistrosSE[2] = rs.getString("cumple_requisitos");
                
                
                model.addRow(RegistrosSE);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
    
    public void Buscar_AplicacionE(String Buscar)
    {
        DefaultTableModel model = Buscar_Aplicacion(Buscar);
        tbl_Ap.setModel(model);
    }
    
    
    /*Combobox*/
    public void Encontrar_ListaAplicacion(String tablaBD, String nombre,JComboBox boxNombre)
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
    
    
    /*Para Foraneas*/
    public void EncontrarID_dpi(String ID, String tablaBD, String Nombre,JComboBox boxNombre,JLabel label)
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
    
    
    public void BuscarFila_AP(String Nombre,String tablaBD, String ID,JComboBox boxNombre,JLabel labelID)
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
