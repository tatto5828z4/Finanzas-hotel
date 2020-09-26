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
 * @author Langas
 */
public class Curriculum {
    
    JTextField txt_DPICV;
    JTextField txt_NombreCV;
    JTextField txt_ApellidoCV;
    JTextField txt_TelefonoCV;
    JTextField txt_CorreoCV;
    JTextField txt_DireccionCV;
    JTextField txt_GeneroCV;
    JTextField txt_EdadCV;
    JLabel jLabel_NivelA_CV;
    JLabel jLabel_RP_CV;
    JLabel jLabel_RL_CV;
    JLabel jLabel_EL_CV;
    JLabel jLabel_Medio_CV;
    JTextField txt_Buscar_CV;
    JTable tbl_CV;
    
    public Curriculum (JTextField txt_DPICV, JTextField txt_NombreCV,JTextField txt_ApellidoCV,JTextField txt_TelefonoCV,JTextField txt_CorreoCV, JTextField txt_DireccionCV, JTextField txt_GeneroCV,JTextField txt_EdadCV, JLabel jLabel_NivelA_CV, JLabel jLabel_RP_CV,JLabel jLabel_RL_CV,JLabel jLabel_EL_CV,JLabel jLabel_Medio_CV,JTextField txt_Buscar_CV,JTable tbl_CV){
        this.txt_DPICV = txt_DPICV;
        this.txt_NombreCV = txt_NombreCV;
        this.txt_ApellidoCV = txt_ApellidoCV;
        this.txt_TelefonoCV = txt_TelefonoCV;
        this.txt_CorreoCV = txt_CorreoCV;
        this.txt_DireccionCV = txt_DireccionCV;
        this.txt_GeneroCV = txt_GeneroCV;
        this.txt_EdadCV = txt_EdadCV;
        this.jLabel_NivelA_CV = jLabel_NivelA_CV;
        this.jLabel_RP_CV = jLabel_RP_CV;
        this.jLabel_RL_CV = jLabel_RL_CV;
        this.jLabel_EL_CV = jLabel_EL_CV;
        this.jLabel_Medio_CV = jLabel_Medio_CV;
        this.txt_Buscar_CV = txt_Buscar_CV;
        this.tbl_CV = tbl_CV;        
        
    }
    
    public void Actualizar_Tabla()
    {
        int cantidad = Cantidad_Registros();
        
        
        String[] C_Datos = new String [13];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from curriculum");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("DPI PERSONA");
            model.addColumn("NOMBRES PERSONA");
            model.addColumn("APELLIDOS PERSONA");
            model.addColumn("TELEFONO PERSONA");
            model.addColumn("CORREO ELECTRONICO");
            model.addColumn("DIRECCION PERSONA");
            model.addColumn("GENERO PERSONA");
            model.addColumn("EDAD PERSONA");
            model.addColumn("ID NIVEL ACADEMICO");
            model.addColumn("ID REFERENCIA PERSONAL");
            model.addColumn("ID REFERENCIA LABORAL");
            model.addColumn("ID EXPERIENCIA LABORAL");
            model.addColumn("ID MEDIO");
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                C_Datos[0] = rs.getString("dpi_persona");
                C_Datos[1] = rs.getString("nombres_persona");
                C_Datos[2] = rs.getString("apellidos_persona");
                C_Datos[3] = rs.getString("telefono_persona");
                C_Datos[4] = rs.getString("correo_electronico");
                C_Datos[5] = rs.getString("direccion_persona");
                C_Datos[6] = rs.getString("genero_persona");
                C_Datos[7] = rs.getString("edad_persona");
                C_Datos[8] = rs.getString("id_nivel_academico");
                C_Datos[9] = rs.getString("id_referenciaP");
                C_Datos[10] = rs.getString("id_referenciaL");
                C_Datos[11] = rs.getString("id_experiencia");
                C_Datos[12] = rs.getString("id_medio");
                
                model.addRow(C_Datos);
                
                tbl_CV.setModel(model);
                
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tbl_CV.setModel(model);
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
            PreparedStatement pst = cn.prepareStatement("select * from curriculum");
            
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
    
    public void Insertar_C()
    {
        try
        {
            Connection  cnIEL = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into curriculum values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            pstIP.setString(1, txt_DPICV.getText().trim());
            pstIP.setString(2, txt_NombreCV.getText().trim());
            pstIP.setString(3, txt_ApellidoCV.getText().trim());
            pstIP.setString(4, txt_TelefonoCV.getText().trim());
            pstIP.setString(5, txt_CorreoCV.getText().trim());
            pstIP.setString(6, txt_DireccionCV.getText().trim());
            pstIP.setString(7, txt_GeneroCV.getText().trim());
            pstIP.setString(8, txt_EdadCV.getText().trim());
            pstIP.setString(9, jLabel_NivelA_CV.getText().trim());
            pstIP.setString(10, jLabel_RP_CV.getText().trim());
            pstIP.setString(11, jLabel_RL_CV.getText().trim());
            pstIP.setString(12, jLabel_EL_CV.getText().trim());
            pstIP.setString(13, jLabel_Medio_CV.getText().trim());
            
            
            pstIP.executeUpdate();
            
            txt_DPICV.setText("");
            txt_NombreCV.setText("");
            txt_ApellidoCV.setText("");
            txt_TelefonoCV.setText("");
            txt_CorreoCV.setText("");
            txt_DireccionCV.setText("");
            txt_GeneroCV.setText("");
            txt_EdadCV.setText("");
            jLabel_NivelA_CV.setText("");
            jLabel_RP_CV.setText("");
            jLabel_RL_CV.setText("");
            jLabel_EL_CV.setText("");
            jLabel_Medio_CV.setText("");
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");        
            Actualizar_Tabla();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Eliminar_C()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from curriculum where dpi_persona = ?");

            pst.setString(1, txt_Buscar_CV.getText().trim());
            pst.executeUpdate();

            txt_DPICV.setText("");
            txt_NombreCV.setText("");
            txt_ApellidoCV.setText("");
            txt_TelefonoCV.setText("");
            txt_CorreoCV.setText("");
            txt_DireccionCV.setText("");
            txt_GeneroCV.setText("");
            txt_EdadCV.setText("");
            jLabel_NivelA_CV.setText("");
            jLabel_RP_CV.setText("");
            jLabel_RL_CV.setText("");
            jLabel_EL_CV.setText("");
            jLabel_Medio_CV.setText("");
            

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_Tabla(); 
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Modificar_C()
    {
        try
        {
            String ID = txt_Buscar_CV.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstC = cn.prepareStatement("update curriculum set dpi_persona = ?, nombres_persona = ?, apellidos_persona = ?,telefono_persona =?,correo_electronico=?, direccion_persona=?, genero_persona=?, edad_persona=?, id_nivel_academico=?,id_referenciaP =?, id_referenciaL =?, id_experiencia=?, id_medio=? where dpi_persona = " + ID);
            
            pstC.setString(1, txt_DPICV.getText().trim());
            pstC.setString(2, txt_NombreCV.getText().trim());
            pstC.setString(3, txt_ApellidoCV.getText().trim());
            pstC.setString(4, txt_TelefonoCV.getText().trim());
            pstC.setString(5, txt_CorreoCV.getText().trim());
            pstC.setString(6, txt_DireccionCV.getText().trim());
            pstC.setString(7, txt_GeneroCV.getText().trim());
            pstC.setString(8, txt_EdadCV.getText().trim());
            pstC.setString(9, jLabel_NivelA_CV.getText().trim());
            pstC.setString(10, jLabel_RP_CV.getText().trim());
            pstC.setString(11, jLabel_RL_CV.getText().trim());
            pstC.setString(12, jLabel_EL_CV.getText().trim());
            pstC.setString(13, jLabel_Medio_CV.getText().trim());
            pstC.executeUpdate();

            txt_Buscar_CV.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");           
            Actualizar_Tabla();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public DefaultTableModel Buscar_CV(String Buscar)
    {
        String[] nombre_ColumnasCV = {"DPI PERSONA", "NOMBRES PERSONA","APELLIDOS PERSONA","TELEFONO PERSONA","CORREO ELECTRONICO","DIRECCION PERSONA","GENERO PERSONA","EDAD PERSONA","ID NIVEL ACADEMICO","ID REFERENCIA PERSONAL","ID REFERENCIA LABORAL","ID EXPERIENCIA","ID MEDIO"};
        String[] RegistrosCV = new String[13];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasCV);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from Curriculum WHERE dpi_persona LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                RegistrosCV[0] = rs.getString("dpi_persona");
                RegistrosCV[1] = rs.getString("nombres_persona");
                RegistrosCV[2] = rs.getString("apellidos_persona");
                RegistrosCV[3] = rs.getString("telefono_persona");
                RegistrosCV[4] = rs.getString("correo_electronico");
                RegistrosCV[5] = rs.getString("direccion_persona");
                RegistrosCV[6] = rs.getString("genero_persona");
                RegistrosCV[7] = rs.getString("edad_persona");
                RegistrosCV[8] = rs.getString("id_nivel_academico");
                RegistrosCV[9] = rs.getString("id_referenciaP");
                RegistrosCV[10] = rs.getString("id_referenciaL");
                RegistrosCV[11] = rs.getString("id_experiencia");
                RegistrosCV[12] = rs.getString("id_medio");    
                
                model.addRow(RegistrosCV);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
    
    public void Buscar_SolicitudCV(String Buscar)
    {
        DefaultTableModel model = Buscar_CV(Buscar);
        tbl_CV.setModel(model);
    }
   
    
    public void Encontrar_ListaCV(String tablaBD, String nombre,JComboBox boxNombre)
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
    
    public void EncontrarID_CV(String ID, String tablaBD, String Nombre,JComboBox boxNombre,JLabel label)
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
    
    public void BuscarFila_CV(String Nombre,String tablaBD, String ID,JComboBox boxNombre,JLabel labelID){
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
