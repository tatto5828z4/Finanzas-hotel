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
 * @author Langas
 */
public class Nivel_Academico 
{
    //Atributos
    JTextField id_NivelA;
    JTextField nombre_NivelA;
    JTextField descripcion_NivelA;
    JTextField buscar_NivelA;
    JTable tabla_NivelA;

    public Nivel_Academico(JTextField id_NivelA, JTextField nombre_NivelA, JTextField descripcion_NivelA, JTextField buscar_NivelA, JTable tabla_NivelA) {
        this.id_NivelA = id_NivelA;
        this.nombre_NivelA = nombre_NivelA;
        this.descripcion_NivelA = descripcion_NivelA;
        this.buscar_NivelA = buscar_NivelA;
        this.tabla_NivelA = tabla_NivelA;
    }
    
    public void Actualizar_Tabla()
    {
        int cantidad = Cantidad_Registros();
        
        
        String[] NivelA_Datos = new String [3];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from nivel_academico");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Nivel Academico");
            model.addColumn("Nombre Nivel Academico");
            model.addColumn("Descripcion Nivel Academico");
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                NivelA_Datos[0] = rs.getString("id_nivel_academico");
                NivelA_Datos[1] = rs.getString("nombre_nivel");
                NivelA_Datos[2] = rs.getString("descripcion");
                
                model.addRow(NivelA_Datos);
                
                tabla_NivelA.setModel(model);
                
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tabla_NivelA.setModel(model);
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
            PreparedStatement pst = cn.prepareStatement("select * from nivel_academico");
            
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
    
    public void Insertar_NivelA()
    {
        try
        {
            Connection  cnINA = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstINA = cnINA.prepareStatement("insert into nivel_academico values(?,?,?)");
            
            pstINA.setString(1, id_NivelA.getText().trim());
            pstINA.setString(2, nombre_NivelA.getText().trim());
            pstINA.setString(3, descripcion_NivelA.getText().trim());
            
            pstINA.executeUpdate();
            
            id_NivelA.setText("");
            nombre_NivelA.setText("");
            descripcion_NivelA.setText("");
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            
            
            Actualizar_Tabla();

            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Modificar_NivelA()
    {
        try
        {
            String ID = buscar_NivelA.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("update nivel_academico set id_nivel_academico = ?, nombre_nivel=?,descripcion = ? where id_nivel_academico = " + ID);

            pst.setString(1, id_NivelA.getText().trim());
            pst.setString(2, nombre_NivelA.getText().trim());
            pst.setString(3, descripcion_NivelA.getText().trim());

            pst.executeUpdate();

            buscar_NivelA.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Eliminar_NivelA()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from nivel_academico where id_nivel_academico = ?");

            pst.setString(1, buscar_NivelA.getText().trim());
            pst.executeUpdate();

            id_NivelA.setText("");
            nombre_NivelA.setText("");
            descripcion_NivelA.setText("");

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public DefaultTableModel Buscar_NivelA(String Buscar)
    {
        String[] nombre_ColumnasD = {"ID Nivel Academico", "Nombre Nivel Academico","Descripcion Nivel Academico"};
        String[] RegistrosD = new String[3];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasD);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from nivel_academico WHERE id_nivel_academico LIKE '%"+Buscar+"%' OR nombre_nivel LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                RegistrosD[0] = rs.getString("id_nivel_academico");
                RegistrosD[1] = rs.getString("nombre_nivel");
                RegistrosD[2] = rs.getString("descripcion");
                
                model.addRow(RegistrosD);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
    
    public void Buscar_NivelAF(String Buscar)
    {
        DefaultTableModel model = Buscar_NivelA(Buscar);
        tabla_NivelA.setModel(model);
    }
}
