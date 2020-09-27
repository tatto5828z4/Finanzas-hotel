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
public class Tipo_Prueba {

    JTextField Id_TipoPrueba;
    JTextField Tipo_Prueba;
    JTable Tb_Tipo;
    JTextField Buscar_TipoPrueba;

    public Tipo_Prueba(JTextField Id_TipoPrueba, JTextField Tipo_Prueba, JTable Tb_Tipo, JTextField Buscar_TipoPrueba) {
        this.Id_TipoPrueba = Id_TipoPrueba;
        this.Tipo_Prueba = Tipo_Prueba;
        this.Tb_Tipo = Tb_Tipo;
        this.Buscar_TipoPrueba = Buscar_TipoPrueba;
    }

  
   public void Insertar_TipoPrueba()
    {
        try
        {
            Connection  cnIP = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cnIP.prepareStatement("insert into tipo_pruebas values(?,?)");
            
            pstIP.setString(1, Id_TipoPrueba.getText().trim());
            pstIP.setString(2, Tipo_Prueba.getText().trim());
           
            pstIP.executeUpdate();
            
            Id_TipoPrueba.setText("");
            Tipo_Prueba.setText("");
           
            
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            
            
            Actualizar_Tabla();

            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    

   public void Modificar_TipoPrueba()
    {
        try
        {
            String ID = Buscar_TipoPrueba.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("update tipo_pruebas set id_prueba = ?, tipo_prueba=? where id_prueba = " + ID);

            pst.setString(1, Id_TipoPrueba.getText().trim());
            pst.setString(2, Tipo_Prueba.getText().trim());
            

            pst.executeUpdate();

            Buscar_TipoPrueba.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void Eliminar_TipoPrueba()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from tipo_pruebas where id_prueba = ?");

            pst.setString(1, Buscar_TipoPrueba.getText().trim());
            pst.executeUpdate();

            Id_TipoPrueba.setText("");
            Tipo_Prueba.setText("");
            
            

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

     public DefaultTableModel Buscar_TipoPrueba(String Buscar)
    {
        String[] nombre_ColumnasD = {"ID Tipo Prueba", "Nombre Tipo Prueba"};
        String[] RegistrosD = new String[2];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasD);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from tipo_pruebas WHERE id_prueba LIKE '%"+Buscar+"%' OR tipo_prueba LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                RegistrosD[0] = rs.getString("id_prueba");
                RegistrosD[1] = rs.getString("tipo_prueba");
                
                
                
                model.addRow(RegistrosD);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
    

    public void Buscar_TP(String Buscar)
    {
        DefaultTableModel model = Buscar_TipoPrueba(Buscar);
        Tb_Tipo.setModel(model);
    }


     public void Actualizar_Tabla()
    {
        int cantidad = Cantidad_Registros();
        
        
        String[] Tipo_Prueba = new String [2];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from tipo_pruebas");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Tipo Prueba");
            model.addColumn("Nombre Tipo Prueba");
           
            
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                Tipo_Prueba[0] = rs.getString("id_prueba");
                Tipo_Prueba[1] = rs.getString("tipo_prueba");
               
                
                
                model.addRow(Tipo_Prueba);
                
                Tb_Tipo.setModel(model);
                
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            Tb_Tipo.setModel(model);
        }catch(Exception e)
        {
            System.out.println(e);
        }
                
    }

 

    public int Cantidad_Registros() {
        int cant = 0;

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from tipo_pruebas");

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
}
