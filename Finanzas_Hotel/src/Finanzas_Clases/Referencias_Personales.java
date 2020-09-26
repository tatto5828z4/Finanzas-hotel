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
 * @author jorgi
 */
public class Referencias_Personales {
    JTextField txt_id_RP;
    JTextField txt_Nombre_RP;
    JTextField txt_Telefono_RP;
    JTextField txt_Buscar_RP;
    JTable tbl_RP;
    
    public Referencias_Personales(JTextField txt_id_RP, JTextField txt_Nombre_RP, JTextField txt_Telefono_RP, JTextField txt_Buscar_RP, JTable tbl_RP) {
        this.txt_id_RP = txt_id_RP;
        this.txt_Nombre_RP = txt_Nombre_RP;
        this.txt_Telefono_RP = txt_Telefono_RP;
        this.txt_Buscar_RP = txt_Buscar_RP;
        this.tbl_RP = tbl_RP;
    }
    
     public int Cantidad_Registros()
    {
        int cant = 0; 
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from referenciasP");
            
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
        
        
        String[] Referencias_Personales = new String [3];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from referenciasP");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID REFERENCIA PERSONAL");
            model.addColumn("NOMBRE PERSONA REFERENCIA PERSONAL");
            model.addColumn("TELEFONO PERSONA REFERENCIA PERSONAL");
            
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                Referencias_Personales[0] = rs.getString("id_referenciaP");
                Referencias_Personales[1] = rs.getString("nombre_personaP");
                Referencias_Personales[2] = rs.getString("telefono_personaP");
                
                model.addRow(Referencias_Personales);
                tbl_RP.setModel(model);
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tbl_RP.setModel(model);
        }catch(Exception e)
        {
            System.out.println(e);
        }
                
    }
    
    public void Insertar_ReferenciasP()
    {
        try
        {
            Connection  cnIP = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement jeje = cnIP.prepareStatement("insert into referenciasp values(?,?,?)");
            
            jeje.setString(1, txt_id_RP.getText().trim());
            jeje.setString(2, txt_Nombre_RP.getText().trim());
            jeje.setString(3, txt_Telefono_RP.getText().trim());           
            jeje.executeUpdate();
            
            txt_id_RP.setText("");
            txt_Nombre_RP.setText("");
            txt_Telefono_RP.setText("");                       
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            Actualizar_Tabla();           
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
  
    
    public void Modificar_RefPer()
    {
        try
        {
            String ID = txt_Buscar_RP.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("update referenciasP set id_referenciaP = ?, nombre_personaP=?,telefono_personaP = ? where id_referenciaP = " + ID);

            pst.setString(1, txt_id_RP.getText().trim());
            pst.setString(2, txt_Nombre_RP.getText().trim());
            pst.setString(3, txt_Telefono_RP.getText().trim());

            pst.executeUpdate();

            txt_Buscar_RP.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Eliminar_ReferenciasP()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from referenciasP where id_referenciaP = ?");

            pst.setString(1, txt_Buscar_RP.getText().trim());
            pst.executeUpdate();

            txt_id_RP.setText("");
            txt_Nombre_RP.setText("");
            txt_Telefono_RP.setText("");
            

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
   public DefaultTableModel Buscar_ReferenciaP(String Buscar)
    {
        String[] nombre_ColumnasD = {"ID Referencia Personal", "Nombre Persona Referencia Personal","Telefono Referencia Personal"};
        String[] RegistrosD = new String[3];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasD);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from referenciasP WHERE id_referenciaP LIKE '%"+Buscar+"%' OR nombre_personaP LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                RegistrosD[0] = rs.getString("id_referenciaP");
                RegistrosD[1] = rs.getString("nombre_personaP");
                RegistrosD[2] = rs.getString("telefono_personaP");
                
                
                model.addRow(RegistrosD);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
   public void Buscar_ReferenciasP(String Buscar)
    {
        DefaultTableModel model = Buscar_ReferenciaP(Buscar);
        tbl_RP.setModel(model);
    }
    
}
