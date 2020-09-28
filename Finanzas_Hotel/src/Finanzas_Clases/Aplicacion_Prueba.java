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
public class Aplicacion_Prueba 
{
    //Atributos
    JTextField idAPP;
    JLabel pruebaAPP;
    JLabel aplicacionAPP;
    JTextField estatusAPP;
    JTextField buscarAPP;
    JTable tabla_APP;

    public Aplicacion_Prueba(JTextField idAPP, JLabel pruebaAPP, JLabel aplicacionAPP, JTextField estatusAPP, JTextField buscarAPP, JTable tabla_APP) {
        this.idAPP = idAPP;
        this.pruebaAPP = pruebaAPP;
        this.aplicacionAPP = aplicacionAPP;
        this.estatusAPP = estatusAPP;
        this.buscarAPP = buscarAPP;
        this.tabla_APP = tabla_APP;
    }
    
    public int Cantidad_Registros()
    {
        int cant = 0;
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from aplicacion_prueba");
            
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
        
        
        String[] APP_Datos = new String [4];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from aplicacion_prueba");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Aplicacion Prueba");
            model.addColumn("ID Prueba");
            model.addColumn("ID Aplicacion");
            model.addColumn("Estatus Aplicacion Prueba");
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                APP_Datos[0] = rs.getString("id_ap");
                APP_Datos[1] = rs.getString("id_prueba");
                APP_Datos[2] = rs.getString("id_aplicacion");
                APP_Datos[3] = rs.getString("estatus_prueba");
                
                model.addRow(APP_Datos);
                
                tabla_APP.setModel(model);
                
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tabla_APP.setModel(model);
        }catch(Exception e)
        {
            System.out.println(e);
        }
                
    }
    
    public void Insertar_APP()
    {
        try
        {
            Connection  cnIEL = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into aplicacion_prueba values(?,?,?,?)");
            
            pstIP.setString(1, idAPP.getText().trim());
            pstIP.setString(2, pruebaAPP.getText().trim());
            pstIP.setString(3, aplicacionAPP.getText().trim());
            pstIP.setString(4, estatusAPP.getText().trim());
            
            pstIP.executeUpdate();
            
            idAPP.setText("");
            pruebaAPP.setText("");
            aplicacionAPP.setText("");
            estatusAPP.setText("");
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            
            
            Actualizar_Tabla();
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Modificar_APP()
    {
        try
        {
            String ID = buscarAPP.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstSE = cn.prepareStatement("update aplicacion_prueba set id_ap = ?, id_prueba = ?, id_aplicacion = ?,estatus_prueba=? where id_ap = " + ID);
            
            pstSE.setString(1, idAPP.getText().trim());
            pstSE.setString(2, pruebaAPP.getText().trim());
            pstSE.setString(3, aplicacionAPP.getText().trim());
            pstSE.setString(4, estatusAPP.getText().trim());
            
           

            pstSE.executeUpdate();

            
            buscarAPP.setText("");
            idAPP.setText("");
            pruebaAPP.setText("");
            aplicacionAPP.setText("");
            estatusAPP.setText("");
            
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Eliminar_APP()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from aplicacion_prueba where id_ap = ?");

            pst.setString(1, buscarAPP.getText().trim());
            pst.executeUpdate();

            
            idAPP.setText("");
            pruebaAPP.setText("");
            aplicacionAPP.setText("");
            estatusAPP.setText("");

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public DefaultTableModel Buscar_APP(String Buscar)
    {
        String[] nombre_ColumnasAPP = {"ID Aplicacion Prueba","ID Prueba","ID Aplicacion", "Estatus Aplicacion Prueba"};
        String[] RegistrosAPP = new String[4];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasAPP);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from aplicacion_prueba WHERE id_ap LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                RegistrosAPP[0] = rs.getString("id_ap");
                RegistrosAPP[1] = rs.getString("id_prueba");
                RegistrosAPP[2] = rs.getString("id_aplicacion");
                RegistrosAPP[3] = rs.getString("estatus_prueba");
                
               
                
                model.addRow(RegistrosAPP);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
    
    public void Encontrar_ListaAPP(String tablaBD, String nombre,JComboBox boxNombre)
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
    
    public void Buscar_APPF(String Buscar)
    {
        DefaultTableModel model = Buscar_APP(Buscar);
        tabla_APP.setModel(model);
    }
    
    public void EncontrarID_APP(String ID, String tablaBD, String Nombre,JComboBox boxNombre,JLabel label)
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
    
    public void BuscarFila_APP(String Nombre,String tablaBD, String ID,JComboBox boxNombre,JLabel labelID){
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
