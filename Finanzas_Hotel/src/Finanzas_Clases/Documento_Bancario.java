/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas_Clases;
import static Finanzas_Clases.Departamento.Base_de_Datos;
import static Finanzas_Clases.Departamento.Clave;
import static Finanzas_Clases.Departamento.Usuario;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

/**
 *
 * @author jorgi
 */
public class Documento_Bancario {
    JLabel jLabel_MMon1;
    JTextField txt_cod;
    JTextField txt_nombred;
    JTextField txt_afec;
    JTextField txt_estd;
    JTextField txt_buscard;
    JTable tbl_Doc;

    public Documento_Bancario(JLabel jLabel_MMon1, JTextField txt_cod, JTextField txt_nombred, JTextField txt_afec, JTextField txt_estd, JTextField txt_buscard, JTable tbl_Doc) {
        this.jLabel_MMon1 = jLabel_MMon1;
        this.txt_cod = txt_cod;
        this.txt_nombred = txt_nombred;
        this.txt_afec = txt_afec;
        this.txt_estd = txt_estd;
        this.txt_buscard = txt_buscard;
        this.tbl_Doc = tbl_Doc;
    }

    
    //constructor
   //Documento_Bancario DB = new Documento_Bancario (jLabel_MMon1,txt_cod,txt_nombred,txt_afec,txt_estd,txt_buscard,tbl_Doc);
    public void Actualizar_Tabla()
    {
        int cantidad = Cantidad_Registros();        
        String[] DB_Datos = new String [4];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from Documento_bancario");     
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("CODIGO DOCUMENTO");
            model.addColumn("NOMBRE DOCUMENTO");
            model.addColumn("AFECTA");
            model.addColumn("ESTATUS DOCUMENTO");            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                DB_Datos[0] = rs.getString("codigo_Documento");
                DB_Datos[1] = rs.getString("nombre_Documento");
                DB_Datos[2] = rs.getString("afecta");
                DB_Datos[3] = rs.getString("estatus_concepto");
                model.addRow(DB_Datos);
                
            }
            //JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tbl_Doc.setModel(model);
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
            PreparedStatement pst = cn.prepareStatement("select * from Documento_bancario");            
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
    
    public void Insertar_DB()
    {
        try
        {
            Connection  cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cn.prepareStatement("insert into Documento_bancario values(?,?,?,?)");
            
            pstIP.setString(1, txt_cod.getText().trim());
            pstIP.setString(2, txt_nombred.getText().trim());
             pstIP.setString(3, txt_afec.getText().trim());
            pstIP.setString(4, txt_estd.getText().trim());   
            pstIP.executeUpdate();
            
            txt_cod.setText("");
            txt_nombred.setText("");
            txt_afec.setText("");
            txt_estd.setText("");    
            JOptionPane.showMessageDialog(null,"Registro Exitoso");  
            
            Actualizar_Tabla();    
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Eliminar_DB()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from Documento_bancario where codigo_Documento = ?");

            pst.setString(1, txt_buscard.getText().trim());
            pst.executeUpdate();

            
            txt_cod.setText("");
            txt_nombred.setText("");
            txt_afec.setText("");
            txt_estd.setText("");
            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Modificar_DB()
    {
        try
        {
            String ID = txt_buscard.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstSE = cn.prepareStatement("update Documento_bancario set codigo_Documento = ?, nombre_Documento = ?, afecta = ?, estatus_concepto=? where codigo_Documento = " + ID);
            
            pstSE.setString(1, txt_cod.getText().trim());
            pstSE.setString(2, txt_nombred.getText().trim());
            pstSE.setString(3, txt_afec.getText().trim());
            pstSE.setString(4, txt_estd.getText().trim());
            pstSE.executeUpdate();
            
            txt_cod.setText("");
            txt_nombred.setText("");
            txt_afec.setText("");
            txt_estd.setText("");
            txt_buscard.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public DefaultTableModel BuscarMon(String Buscar)
    {
        String[] nombre_ColumnasMon = {"CODIGO DOCUMENTO", "NOMBRE DOCUMENTO","AFECTA","ESTATUS DOCUMENTO"};
        String[] RegistrosMon = new String[4];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasMon);      
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from Documento_Bancario WHERE codigo_Documento LIKE '%" + Buscar + "%'");
            ResultSet rs = pst.executeQuery();            
            while(rs.next())
            {
                RegistrosMon[0] = rs.getString("codigo_Documento");
                RegistrosMon[1] = rs.getString("nombre_Documento");
                RegistrosMon[2] = rs.getString("afecta");
                RegistrosMon[3] = rs.getString("estatus_concepto");                
                model.addRow(RegistrosMon);
                
            }
            tbl_Doc.setModel(model);                

        }catch(Exception e)
        {
            System.out.println(e);
        }        
        return model;
    }
    
    
}
