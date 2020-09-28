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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Langas
 */
public class Actividad 
{
    //Atributos
    JTextField idA;
    JTextField tipoAA;
    JTextArea descripcionA;
    JTextField buscarA;
    JTable tablaA;

    public Actividad(JTextField idA, JTextField tipoAA, JTextArea descripcionA, JTextField buscarA, JTable tablaA) {
        this.idA = idA;
        this.tipoAA = tipoAA;
        this.descripcionA = descripcionA;
        this.buscarA = buscarA;
        this.tablaA = tablaA;
    }
    
    public int Cantidad_Registros()
    {
        int cant = 0;
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from actividad");
            
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
        
        
        String[] Ac_Datos = new String [3];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from actividad");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Actividad");
            model.addColumn("Tipo Actividad");
            model.addColumn("Descripcion");
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                Ac_Datos[0] = rs.getString("id_actividad");
                Ac_Datos[1] = rs.getString("tipo_actividad");
                Ac_Datos[2] = rs.getString("descripcion");
                
                model.addRow(Ac_Datos);
                
                tablaA.setModel(model);
                
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tablaA.setModel(model);
        }catch(Exception e)
        {
            System.out.println(e);
        }
                
    }
    
    public void Insertar_AC()
    {
        try
        {
            Connection  cnIEL = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into actividad values(?,?,?)");
            
            pstIP.setString(1, idA.getText().trim());
            pstIP.setString(2, tipoAA.getText().trim());
            pstIP.setString(3, descripcionA.getText().trim());
            
            pstIP.executeUpdate();
            
            idA.setText("");
            tipoAA.setText("");
            descripcionA.setText("");
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            
            
            Actualizar_Tabla();
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Modificar_AC()
    {
        try
        {
            String ID = buscarA.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("update actividad set id_actividad = ?, tipo_actividad=?,descripcion = ? where id_actividad = " + ID);

            pst.setString(1, idA.getText().trim());
            pst.setString(2, tipoAA.getText().trim());
            pst.setString(3, descripcionA.getText().trim());

            pst.executeUpdate();

            buscarA.setText("");
            idA.setText("");
            tipoAA.setText("");
            descripcionA.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Eliminar_AC()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from actividad where id_actividad = ?");

            pst.setString(1, buscarA.getText().trim());
            pst.executeUpdate();

            idA.setText("");
            tipoAA.setText("");
            descripcionA.setText("");

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public DefaultTableModel Buscar_AC(String Buscar)
    {
        String[] nombre_ColumnasAC = {"ID Actividad","Tipo Actividad","Descripcion"};
        String[] RegistrosAC = new String[3];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasAC);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from actividad WHERE id_actividad LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                RegistrosAC[0] = rs.getString("id_actividad");
                RegistrosAC[1] = rs.getString("tipo_actividad");
                RegistrosAC[2] = rs.getString("descripcion");
                
                model.addRow(RegistrosAC);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
    
    public void Buscar_ACF(String Buscar)
    {
        DefaultTableModel model = Buscar_AC(Buscar);
        tablaA.setModel(model);
    }
    
}
