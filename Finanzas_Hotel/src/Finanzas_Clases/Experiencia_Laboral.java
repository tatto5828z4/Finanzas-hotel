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
 * @author Langas
 */
public class Experiencia_Laboral 
{
    //Atributos
    JTextField id_ExpL;
    JLabel idL_ExpLD;
    JTextField buscar_ExpL;
    JTable tabla_ExpL;

    public Experiencia_Laboral(JTextField id_ExpL, JLabel idL_ExpLD, JTextField buscar_ExpL, JTable tabla_ExpL) {
        this.id_ExpL = id_ExpL;
        this.idL_ExpLD = idL_ExpLD;
        this.buscar_ExpL = buscar_ExpL;
        this.tabla_ExpL = tabla_ExpL;
    }
    
    public void Actualizar_Tabla()
    {
        int cantidad = Cantidad_Registros();
        
        
        String[] ExpL_Datos = new String [2];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from experiencia_laboral");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Experiencia Laboral");
            model.addColumn("ID Experiencia Laboral Detallada");
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                ExpL_Datos[0] = rs.getString("id_experiencia");
                ExpL_Datos[1] = rs.getString("id_tipoexp");
                
                model.addRow(ExpL_Datos);
                
                tabla_ExpL.setModel(model);
                
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tabla_ExpL.setModel(model);
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
            PreparedStatement pst = cn.prepareStatement("select * from experiencia_laboral");
            
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
    
    public void Insertar_ExpL()
    {
        try
        {
            Connection  cnIEL = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into experiencia_laboral values(?,?)");
            
            pstIP.setString(1, id_ExpL.getText().trim());
            pstIP.setString(2, idL_ExpLD.getText().trim());
            
            pstIP.executeUpdate();
            
            id_ExpL.setText("");
            idL_ExpLD.setText("");
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            
            
            Actualizar_Tabla();
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Eliminar_ExpL()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from experiencia_laboral where id_experiencia = ?");

            pst.setString(1, buscar_ExpL.getText().trim());
            pst.executeUpdate();

            id_ExpL.setText("");
            idL_ExpLD.setText("");

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Modificar_ExpL()
    {
        try
        {
            String ID = buscar_ExpL.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("update experiencia_laboral set id_experiencia = ?, id_tipoexp = ? where id_experiencia = " + ID);

            pst.setString(1, id_ExpL.getText().trim());
            pst.setString(2, idL_ExpLD.getText().trim());

            pst.executeUpdate();

            buscar_ExpL.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public DefaultTableModel Buscar_ExpL(String Buscar)
    {
        String[] nombre_ColumnasExpL = {"ID Nivel  Experiencia Laboral", "Experienca Laboral Detallada"};
        String[] RegistrosExpL = new String[2];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasExpL);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from experiencia_laboral WHERE id_experiencia LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                RegistrosExpL[0] = rs.getString("id_experiencia");
                RegistrosExpL[1] = rs.getString("id_tipoexp");
                
                model.addRow(RegistrosExpL);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
    
    public void Buscar_ExpLF(String Buscar)
    {
        DefaultTableModel model = Buscar_ExpL(Buscar);
        tabla_ExpL.setModel(model);
    }
   
    
    public void Encontrar_ListaExpLD(String tablaBD, String nombre,JComboBox boxNombre)
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
    
    /*Usar Para foraneas*/
    public void EncontrarID_ExpLD(String ID, String tablaBD, String Nombre,JComboBox boxNombre)
    {     
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select " +  ID  + " from " + tablaBD +" where " + Nombre + "= ?");
            pst.setString(1, boxNombre.getSelectedItem().toString());

            ResultSet rs = pst.executeQuery();

            if(rs.next()) {
                idL_ExpLD.setText(rs.getString(ID));
            } 

        } catch (Exception e) 
        {
            System.out.println(e);
        }
    }
    
    public void BuscarFila_ExpL(String Nombre,String tablaBD, String ID,JComboBox boxNombre,JLabel labelID)
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
