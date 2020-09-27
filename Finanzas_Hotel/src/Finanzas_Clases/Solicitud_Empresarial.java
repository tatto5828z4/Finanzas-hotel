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
 * @author Geovani
 */
public class Solicitud_Empresarial {

    //Atributos
    JTextField txt_id_SolicitudE;
    JTextField txt_RangoEdadM;
    JTextField txt_RangoEdadMa;
    JTextField txt_Genero;
    JLabel id_Puesto;
    JLabel id_Departamento;
    JLabel id_NivelA;
    JLabel id_ExpL;
    JTextArea jTextArea_DescripcionSE;
    JTextField txt_Buscar_SE;
    JTable tbl_SE;

    public Solicitud_Empresarial(JTextField txt_id_SolicitudE, JTextField txt_RangoEdadM, JTextField txt_RangoEdadMa, JTextField txt_Genero, JLabel id_Puesto, JLabel id_Departamento, JLabel id_NivelA, JLabel id_ExpL, JTextArea jTextArea_DescripcionSE, JTextField txt_Buscar_SE, JTable tbl_SE) {
        this.txt_id_SolicitudE = txt_id_SolicitudE;
        this.txt_RangoEdadM = txt_RangoEdadM;
        this.txt_RangoEdadMa = txt_RangoEdadMa;
        this.txt_Genero = txt_Genero;
        this.id_Puesto = id_Puesto;
        this.id_Departamento = id_Departamento;
        this.id_NivelA = id_NivelA;
        this.id_ExpL = id_ExpL;
        this.jTextArea_DescripcionSE = jTextArea_DescripcionSE;
        this.txt_Buscar_SE = txt_Buscar_SE;
        this.tbl_SE = tbl_SE;
    }
    
   
    public void Actualizar_Tabla()
    {
        int cantidad = Cantidad_Registros();
        
        
        String[] SE_Datos = new String [9];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from solicitud_empresarial");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID  Solicitud");
            model.addColumn("Rango de Edad Menor");
            model.addColumn("Rango de Edad Mayor");
            model.addColumn("Genero");
            model.addColumn("ID  Puesto");
            model.addColumn("ID Departamento");
            model.addColumn("ID  Nivel Academico");
            model.addColumn("ID Experiencia");
            model.addColumn("Descripcion");
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                SE_Datos[0] = rs.getString("id_solicitud");
                SE_Datos[1] = rs.getString("rango_edad_menor");
                SE_Datos[2] = rs.getString("rango_edad_mayor");
                SE_Datos[3] = rs.getString("genero");
                SE_Datos[4] = rs.getString("id_puesto");
                SE_Datos[5] = rs.getString("id_departamento");
                SE_Datos[6] = rs.getString("id_nivel_academico");
                SE_Datos[7] = rs.getString("id_experiencia");
                SE_Datos[8] = rs.getString("descripcion");
                
                model.addRow(SE_Datos);
                
                tbl_SE.setModel(model);
                
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tbl_SE.setModel(model);
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
            PreparedStatement pst = cn.prepareStatement("select * from solicitud_empresarial");
            
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
    public void Insertar_SE()
    {
        try
        {
            Connection  cnIEL = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into solicitud_empresarial values(?,?,?,?,?,?,?,?,?)");
            
            pstIP.setString(1, txt_id_SolicitudE.getText().trim());
            pstIP.setString(2, txt_RangoEdadM.getText().trim());
             pstIP.setString(3, txt_RangoEdadMa.getText().trim());
            pstIP.setString(4, txt_Genero.getText().trim());
             pstIP.setString(5, id_Puesto.getText().trim());
            pstIP.setString(6, id_Departamento.getText().trim());
             pstIP.setString(7, id_NivelA.getText().trim());
            pstIP.setString(8, id_ExpL.getText().trim());
             pstIP.setString(9, jTextArea_DescripcionSE.getText().trim());
            
            
            pstIP.executeUpdate();
            
            txt_id_SolicitudE.setText("");
            txt_RangoEdadM.setText("");
            txt_RangoEdadMa.setText("");
            txt_Genero.setText("");
            id_Puesto.setText("");
            id_Departamento.setText("");
            id_NivelA.setText("");
            id_ExpL.setText("");
            jTextArea_DescripcionSE.setText("");
            
            
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
            PreparedStatement pst = cn.prepareStatement("delete from solicitud_empresarial where id_solicitud = ?");

            pst.setString(1, txt_Buscar_SE.getText().trim());
            pst.executeUpdate();

            
             txt_id_SolicitudE.setText("");
            txt_RangoEdadM.setText("");
            txt_RangoEdadMa.setText("");
            txt_Genero.setText("");
            id_Puesto.setText("");
            id_Departamento.setText("");
            id_NivelA.setText("");
            id_ExpL.setText("");
            jTextArea_DescripcionSE.setText("");

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
            String ID = txt_Buscar_SE.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstSE = cn.prepareStatement("update solicitud_empresarial set id_solicitud = ?, rango_edad_menor = ?, rango_edad_mayor = ?,genero=?,id_puesto=?,id_departamento=?,id_nivel_academico=?,id_experiencia=?,descripcion=? where id_solicitud = " + ID);
            
            pstSE.setString(1, txt_id_SolicitudE.getText().trim());
            pstSE.setString(2, txt_RangoEdadM.getText().trim());
             pstSE.setString(3, txt_RangoEdadMa.getText().trim());
            pstSE.setString(4, txt_Genero.getText().trim());
             pstSE.setString(5, id_Puesto.getText().trim());
            pstSE.setString(6, id_Departamento.getText().trim());
             pstSE.setString(7, id_NivelA.getText().trim());
            pstSE.setString(8, id_ExpL.getText().trim());
             pstSE.setString(9, jTextArea_DescripcionSE.getText().trim());
            
           

            pstSE.executeUpdate();

            txt_Buscar_SE.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
     
     
    public DefaultTableModel Buscar_SE(String Buscar)
    {
        String[] nombre_ColumnasSE = {"ID Solicitud", "Rango de Edad Menor","Rando de Edad Mayor","Genero","ID Puesto","ID Departamento","ID Nivel Academino","ID Experiencia Labboral","ID Descripcion"};
        String[] RegistrosSE = new String[9];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasSE);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from solicitud_empresarial WHERE id_solicitud LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                 RegistrosSE[0] = rs.getString("id_solicitud");
                RegistrosSE[1] = rs.getString("rango_edad_menor");
                RegistrosSE[2] = rs.getString("rango_edad_mayor");
                RegistrosSE[3] = rs.getString("genero");
                RegistrosSE[4] = rs.getString("id_puesto");
                RegistrosSE[5] = rs.getString("id_departamento");
                RegistrosSE[6] = rs.getString("id_nivel_academico");
                RegistrosSE[7] = rs.getString("id_experiencia");
                RegistrosSE[8] = rs.getString("descripcion");
                
               
                
                model.addRow(RegistrosSE);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
    
    public void Buscar_SolicitudE(String Buscar)
    {
        DefaultTableModel model = Buscar_SE(Buscar);
        tbl_SE.setModel(model);
    }
   
    
    public void Encontrar_ListaSE(String tablaBD, String nombre,JComboBox boxNombre)
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
    
     /*Usar Para foraneas*/
    public void EncontrarID_SE(String ID, String tablaBD, String Nombre,JComboBox boxNombre,JLabel label)
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
    
    
    public void BuscarFila_SE(String Nombre,String tablaBD, String ID,JComboBox boxNombre,JLabel labelID){
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
