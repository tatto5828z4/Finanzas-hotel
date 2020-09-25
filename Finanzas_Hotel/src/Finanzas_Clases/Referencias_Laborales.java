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
 * @author Brayan Cifuentes
 */
public class Referencias_Laborales 
{
    JTextField id_referenciaL;
    JTextField nombre_personaL;
    JTextField telefono_personalL;
    JTextField buscar_referenciaL;
    JTable tabla_referenciasL;

    public Referencias_Laborales(JTextField id_referenciaL, JTextField nombre_personaL, JTextField telefono_personalL, JTextField buscar_referenciaL, JTable tabla_referenciasL) {
        this.id_referenciaL = id_referenciaL;
        this.nombre_personaL = nombre_personaL;
        this.telefono_personalL = telefono_personalL;
        this.buscar_referenciaL = buscar_referenciaL;
        this.tabla_referenciasL = tabla_referenciasL;
    }

    
     public int Cantidad_Registros()
    {
        int cant = 0;
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from referenciasL");
            
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
            PreparedStatement pst = cn.prepareStatement("select * from referenciasL");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Referencia Laboral");
            model.addColumn("Nombre Persona Referencia Laboral");
            model.addColumn("Telefono Persona Referencia Laboral");
            
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                Referencias_Laborales[0] = rs.getString("id_referenciaL");
                Referencias_Laborales[1] = rs.getString("nombre_personaL");
                Referencias_Laborales[2] = rs.getString("telefono_personaL");
                
                
                model.addRow(Referencias_Laborales);
                
                tabla_referenciasL.setModel(model);
                
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tabla_referenciasL.setModel(model);
        }catch(Exception e)
        {
            System.out.println(e);
        }
                
    }
    
    public void Insertar_ReferenciasL()
    {
        try
        {
            Connection  cnIP = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cnIP.prepareStatement("insert into referenciasL values(?,?,?)");
            
            pstIP.setString(1, id_referenciaL.getText().trim());
            pstIP.setString(2, nombre_personaL.getText().trim());
            pstIP.setString(3, telefono_personalL.getText().trim());
           
            pstIP.executeUpdate();
            
            id_referenciaL.setText("");
            nombre_personaL.setText("");
            telefono_personalL.setText("");
            
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            
            
            Actualizar_Tabla();

            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public void Modificar_RefLab()
    {
        try
        {
            String ID = buscar_referenciaL.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("update referenciasL set id_referenciaL = ?, nombre_personaL=?,telefono_personaL = ? where id_referenciaL = " + ID);

            pst.setString(1, id_referenciaL.getText().trim());
            pst.setString(2, nombre_personaL.getText().trim());
            pst.setString(3, telefono_personalL.getText().trim());

            pst.executeUpdate();

            buscar_referenciaL.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public void Eliminar_ReferenciasL()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from referenciasL where id_referenciaL = ?");

            pst.setString(1, buscar_referenciaL.getText().trim());
            pst.executeUpdate();

            id_referenciaL.setText("");
            nombre_personaL.setText("");
            telefono_personalL.setText("");
            

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public DefaultTableModel Buscar_ReferenciaL(String Buscar)
    {
        String[] nombre_ColumnasD = {"ID Referencia Laboral", "Nombre Persona Referencia Laboral","Telefono Referencia Personal"};
        String[] RegistrosD = new String[3];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasD);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from referenciasL WHERE id_referenciaL LIKE '%"+Buscar+"%' OR nombre_personaL LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                RegistrosD[0] = rs.getString("id_referenciaL");
                RegistrosD[1] = rs.getString("nombre_personaL");
                RegistrosD[2] = rs.getString("telefono_personaL");
                
                
                model.addRow(RegistrosD);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
    
    public void Buscar_ReferenciasLF(String Buscar)
    {
        DefaultTableModel model = Buscar_ReferenciaL(Buscar);
        tabla_referenciasL.setModel(model);
    }
    
}
