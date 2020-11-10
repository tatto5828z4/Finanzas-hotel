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
public class Moneda {
    JLabel jLabel_MMon;
    JTextField txt_IDM;
    JTextField txt_NombreM;
    JTextField txt_TipoM;
    JTextField txt_estM;
    JTextField txt_buscarMon;
    JTable tbl_Moneda;
    
    public Moneda(JLabel jLabel_MMon, JTextField txt_IDM, JTextField txt_NombreM,JTextField txt_TipoM, JTextField txt_estM, JTextField txt_buscarMon,JTable tbl_Moneda ) {
        this.jLabel_MMon = jLabel_MMon;
        this.txt_IDM = txt_IDM;
        this.txt_NombreM = txt_NombreM;
        this.txt_TipoM = txt_TipoM;
        this.txt_estM = txt_estM;
        this.txt_buscarMon = txt_buscarMon;
        this.tbl_Moneda = tbl_Moneda;
    }
    //constructor moneda
    //Moneda mon = new Moneda (jLabel_MMon, txt_IDM, txt_NombreM, txt_TipoM, txt_estM, txt_buscarMon, tbl_Moneda);
    
    
    public void Actualizar_Tabla()
    {
        int cantidad = Cantidad_Registros();        
        String[] Mon_Datos = new String [4];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from moneda");     
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID MONEDA");
            model.addColumn("NOMBRE MONEDA");
            model.addColumn("TIPO CAMBIO");
            model.addColumn("ESTATUS MONEDA");            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                Mon_Datos[0] = rs.getString("id_moneda");
                Mon_Datos[1] = rs.getString("nombre_moneda");
                Mon_Datos[2] = rs.getString("tipo_cambio");
                Mon_Datos[3] = rs.getString("estatus_moneda");
                model.addRow(Mon_Datos);
                
               tbl_Moneda.setModel(model);                
            }
            //JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tbl_Moneda.setModel(model);
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
            PreparedStatement pst = cn.prepareStatement("select * from medio");            
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
    public void Insertar_Me()
    {
        try
        {
            Connection  cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cn.prepareStatement("insert into moneda values(?,?,?,?)");
            
            pstIP.setString(1, txt_IDM.getText().trim());
            pstIP.setString(2, txt_NombreM.getText().trim());
             pstIP.setString(3, txt_TipoM.getText().trim());
            pstIP.setString(4, txt_estM.getText().trim());   
            pstIP.executeUpdate();
            
            txt_IDM.setText("");
            txt_NombreM.setText("");
            txt_TipoM.setText("");
            txt_estM.setText("");    
            JOptionPane.showMessageDialog(null,"Registro Exitoso");  
            
            Actualizar_Tabla();    
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Eliminar_M()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from moneda where id_moneda = ?");

            pst.setString(1, txt_buscarMon.getText().trim());
            pst.executeUpdate();

            
            txt_IDM.setText("");
            txt_NombreM.setText("");
            txt_TipoM.setText("");
            txt_estM.setText("");
            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Modificar_M()
    {
        try
        {
            String ID = txt_buscarMon.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstSE = cn.prepareStatement("update moneda set id_moneda = ?, nombre_moneda = ?, tipo_cambio = ?, estatus_moneda=? where id_moneda = " + ID);
            
            pstSE.setString(1, txt_IDM.getText().trim());
            pstSE.setString(2, txt_NombreM.getText().trim());
            pstSE.setString(3, txt_TipoM.getText().trim());
            pstSE.setString(4, txt_estM.getText().trim());
            pstSE.executeUpdate();
            
            txt_IDM.setText("");
            txt_buscarMon.setText("");
            txt_NombreM.setText("");
            txt_TipoM.setText("");
            txt_estM.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public DefaultTableModel BuscarMon(String Buscar)
    {
        String[] nombre_ColumnasMon = {"ID MONEDA", "NOMBRE MONEDA","TIPO CAMBIO","ESTATUS MONEDA"};
        String[] RegistrosMon = new String[4];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasMon);      
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from moneda WHERE id_moneda LIKE '%" + Buscar + "%'");
            ResultSet rs = pst.executeQuery();            
            while(rs.next())
            {
                RegistrosMon[0] = rs.getString("id_moneda");
                RegistrosMon[1] = rs.getString("nombre_moneda");
                RegistrosMon[2] = rs.getString("tipo_cambio");
                RegistrosMon[3] = rs.getString("estatus_moneda");                
                model.addRow(RegistrosMon);
                
            }
            tbl_Moneda.setModel(model);                

        }catch(Exception e)
        {
            System.out.println(e);
        }        
        return model;
    }
    
    
    
}
