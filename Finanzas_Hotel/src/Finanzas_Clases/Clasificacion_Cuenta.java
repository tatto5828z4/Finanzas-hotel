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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorgi
 */
public class Clasificacion_Cuenta {
    JLabel jLabel_CC;
    JTextField txt_idclasi;
    JTextField txt_nombrecla;
    JTextField txt_buscarclasi;
    JTable tbl_Clasi;
    
    public Clasificacion_Cuenta(JLabel jLabel_CC, JTextField txt_idclasi, JTextField txt_nombrecla, JTextField txt_buscarclasi, JTable tbl_Clasi)
    {
        this.jLabel_CC =jLabel_CC;
        this.txt_idclasi = txt_idclasi;
        this.txt_nombrecla =txt_nombrecla;
        this.txt_buscarclasi =txt_buscarclasi;
        this.tbl_Clasi =tbl_Clasi;        
    }
    //constructor clasi
    //Clasificacion_Cuenta CC = new Clasificacion_Cuenta (jLabel_CC, txt_idclasi, txt_nombrec, txt_buscarclasi, tbl_Clasi);
    
    public void Actualizar_Tabla()
    {
        int cantidad = Cantidad_Registros();        
        String[] Clas_Datos = new String [3];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from clasificacion_cuenta");     
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID CLASIFICACION");
            model.addColumn("NOMBRE CLASIFICACION");            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                Clas_Datos[0] = rs.getString("id_clasificacion");
                Clas_Datos[1] = rs.getString("nombre_clasificacion");
                model.addRow(Clas_Datos);
                
               tbl_Clasi.setModel(model);                
            }
            //JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tbl_Clasi.setModel(model);
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
            PreparedStatement pst = cn.prepareStatement("select * from clasificacion_cuenta");            
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
    
    public void Insertar_CC()
    {
        try
        {
            Connection  cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cn.prepareStatement("insert into clasificacion_cuenta values(?,?)");
            
            pstIP.setString(1, txt_idclasi.getText().trim());
            pstIP.setString(2, txt_nombrecla.getText().trim());  
            pstIP.executeUpdate();
            
            txt_idclasi.setText("");
            txt_nombrecla.setText(""); 
            JOptionPane.showMessageDialog(null,"Registro Exitoso");  
            
            Actualizar_Tabla();    
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Eliminar_CC()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from clasificacion_cuenta where id_clasificacion = ?");

            pst.setString(1, txt_buscarclasi.getText().trim());
            pst.executeUpdate();

            
            txt_idclasi.setText("");
            txt_nombrecla.setText("");

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Modificar_CC()
    {
        try
        {
            String ID = txt_buscarclasi.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstSE = cn.prepareStatement("update clasificacion_cuenta set id_clasificacion = ?, nombre_clasificacion = ? where id_clasificacion = " + ID);
            
            pstSE.setString(1, txt_idclasi.getText().trim());
            pstSE.setString(2, txt_nombrecla.getText().trim());
            pstSE.executeUpdate();
            
            txt_idclasi.setText("");
            txt_nombrecla.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public DefaultTableModel BuscarCC(String Buscar)
    {
        String[] nombre_ColumnasMon = {"ID CLASIFICACION", "NOMBRE CLASIFICACION"};
        String[] RegistrosMon = new String[2];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasMon);      
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from clasificacion_cuenta WHERE id_clasificacion LIKE '%" + Buscar + "%'");
            ResultSet rs = pst.executeQuery();            
            while(rs.next())
            {
                RegistrosMon[0] = rs.getString("id_clasificacion");
                RegistrosMon[1] = rs.getString("nombre_clasificacion");              
                model.addRow(RegistrosMon);
                
            }
            tbl_Clasi.setModel(model);                

        }catch(Exception e)
        {
            System.out.println(e);
        }        
        return model;
    }
    
}
