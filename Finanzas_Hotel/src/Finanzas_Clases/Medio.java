/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas_Clases;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static Finanzas_Clases.Departamento.Base_de_Datos;
import static Finanzas_Clases.Departamento.Clave;
import static Finanzas_Clases.Departamento.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jorgi
 */
public class Medio {
    JTextField txt_id_Medio;
    JLabel jLabel_ID_SEM;
    JTextField txt_NombreM;
    JTextArea jTextArea_DescripcionM;
    JTextField txt_BuscarM;
    JTable tbl_Medio;
    
    public Medio(JTextField txt_id_Medio, JLabel jLabel_ID_SEM, JTextField txt_NombreM,JTextArea jTextArea_DescripcionM, JTextField txt_BuscarM, JTable tbl_Medio) {
        this.txt_id_Medio = txt_id_Medio;
        this.jLabel_ID_SEM = jLabel_ID_SEM;
        this.txt_NombreM = txt_NombreM;
        this.jTextArea_DescripcionM = jTextArea_DescripcionM;
        this.txt_BuscarM = txt_BuscarM;
        this.tbl_Medio = tbl_Medio;
    }

    public Medio(JTextField txt_id_Medio, JLabel jLabel_ID_SEM, JTextField txt_NombreM, JTextArea jTextArea_DescripcionM) {
        
    }

    
     public void Actualizar_Tabla()
    {
        int cantidad = Cantidad_Registros();        
        String[] M_Datos = new String [4];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from medio");     
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID MEDIO");
            model.addColumn("ID SOLICITUD EMPRESARIAL");
            model.addColumn("NOMBRE MEDIO");
            model.addColumn("DESCRIPCION MEDIO");            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                M_Datos[0] = rs.getString("id_medio");
                M_Datos[1] = rs.getString("id_solicitud");
                M_Datos[2] = rs.getString("nombre_medio");
                M_Datos[3] = rs.getString("descripcion");
                model.addRow(M_Datos);
                
               tbl_Medio.setModel(model);                
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tbl_Medio.setModel(model);
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
            Connection  cnIEL = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into medio values(?,?,?,?)");
            
            pstIP.setString(1, txt_id_Medio.getText().trim());
            pstIP.setString(2, jLabel_ID_SEM.getText().trim());
             pstIP.setString(3, txt_NombreM.getText().trim());
            pstIP.setString(4, jTextArea_DescripcionM.getText().trim());   
            pstIP.executeUpdate();
            
            txt_id_Medio.setText("");
            jLabel_ID_SEM.setText("");
            txt_NombreM.setText("");
            jTextArea_DescripcionM.setText("");    
            JOptionPane.showMessageDialog(null,"Registro Exitoso");  
            
            Actualizar_Tabla();    
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
     public void Eliminar_SE()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from medio where id_medio = ?");

            pst.setString(1, txt_BuscarM.getText().trim());
            pst.executeUpdate();

            
            txt_id_Medio.setText("");
            jLabel_ID_SEM.setText("");
            txt_NombreM.setText("");
            jTextArea_DescripcionM.setText("");
            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
     
     public void Modificar_SE()
    {
        try
        {
            String ID = txt_BuscarM.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstSE = cn.prepareStatement("update medio set id_medio = ?, id_solicitud = ?, nombre_medio = ?,descripcion=? where id_medio = " + ID);
            
            pstSE.setString(1, txt_id_Medio.getText().trim());
            pstSE.setString(2, jLabel_ID_SEM.getText().trim());
             pstSE.setString(3, txt_NombreM.getText().trim());
            pstSE.setString(4, jTextArea_DescripcionM.getText().trim());
            pstSE.executeUpdate();
            
            txt_BuscarM.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
     
      public DefaultTableModel BuscarM(String Buscar)
    {
        String[] nombre_ColumnasM = {"ID MEDIO", "ID SOLICITUD","NOMBRE MEDIO","DESCRIPCION"};
        String[] RegistrosM = new String[4];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasM);      
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from medio WHERE id_medio LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();            
            while(rs.next())
            {
                RegistrosM[0] = rs.getString("id_medio");
                RegistrosM[1] = rs.getString("id_solicitud");
                RegistrosM[2] = rs.getString("nombre_medio");
                RegistrosM[3] = rs.getString("descripcion");                
                model.addRow(RegistrosM);
                
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }        
        return model;
    }
       public void Buscar_SolicitudM(String Buscar)
    {
        DefaultTableModel model = BuscarM(Buscar);
        tbl_Medio.setModel(model);
    }
       
       public void Encontrar_ListaM(String tablaBD, String nombre,JComboBox boxNombre)
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
       
       public void EncontrarID_M(String ID, String tablaBD, String Nombre,JComboBox boxNombre,JLabel label){     
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
       
       public void BuscarFila_M(String Nombre,String tablaBD, String ID,JComboBox boxNombre,JLabel labelID){
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
