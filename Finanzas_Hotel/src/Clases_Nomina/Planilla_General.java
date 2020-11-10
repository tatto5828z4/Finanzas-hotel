/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Nomina;

import Finanzas.Nomina;
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
 * @author Supervisor
 */
public class Planilla_General 
{
    //Atributos
    JTextField id_PE;
    String total_PercepcionPE;
    String total_DeduccionPE;
    String total_LiquidoPE;
    JTextField BuscarPG;
    JTable TablaPG;

    public Planilla_General(JTextField id_PE, String total_PercepcionPE, String total_DeduccionPE, String total_LiquidoPE, JTextField BuscarPG, JTable TablaPG) {
        this.id_PE = id_PE;
        this.total_PercepcionPE = total_PercepcionPE;
        this.total_DeduccionPE = total_DeduccionPE;
        this.total_LiquidoPE = total_LiquidoPE;
        this.BuscarPG = BuscarPG;
        this.TablaPG = TablaPG;
    }
    
    public void Actualizar_PG()
    {
        int cantidad = Cantidad_Registros();
        
        String[] CP_Datos = new String [4];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from planilla_enc");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Planilla General");
            model.addColumn("Total Percepcion");
            model.addColumn("Total Deduccion");
            model.addColumn("Total Liquido");
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                CP_Datos[0] = rs.getString("id_planillaenc");
                CP_Datos[1] = rs.getString("total_percepcion");
                CP_Datos[2] = rs.getString("total_deduccion");
                CP_Datos[3] = rs.getString("total_liquido");
                
                model.addRow(CP_Datos);
                
                TablaPG.setModel(model);
                
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            TablaPG.setModel(model);
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
            PreparedStatement pst = cn.prepareStatement("select * from planilla_enc");
            
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
    
    public void Insertar_PG()
    {   
       
            try
            {
            Connection  cnIP = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cnIP.prepareStatement("insert into planilla_enc values(?,?,?,?)");
            
            pstIP.setString(1, id_PE.getText().trim());
            pstIP.setString(2, total_PercepcionPE);
            pstIP.setString(3, total_DeduccionPE);
            pstIP.setString(4, total_LiquidoPE);
            
            pstIP.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            
            
            Actualizar_PG();

            
            }catch(Exception e)
            {
                System.out.println(e);
            }
        
        
    }
    
    public void Modificar_PG(float Deduccion,float Percepcion,float Liquido)
    {
        try
        {
            String ID = id_PE.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("update planilla_enc set id_planillaenc = ?, total_percepcion = ?,total_deduccion = ?,total_liquido = ? where id_planillaenc = " + ID);

            pst.setString(1, id_PE.getText());
            pst.setString(2, String.valueOf(Percepcion));
            pst.setString(3, String.valueOf(Deduccion));
            pst.setString(4, String.valueOf(Liquido));

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_PG();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public boolean Encontrar_IDPG()
    {
        boolean Encontrado = false;
        
        try {

            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from planilla_enc where id_planillaenc = ?");
            pst.setString(1, id_PE.getText().trim());

            ResultSet rs = pst.executeQuery();

            if(rs.next()) {
                
                Encontrado = true;
            } 
            else
            {
                Encontrado = false;
            }
            
            

        } catch (Exception e) 
        {
            System.out.println(e);
        }
        
        return Encontrado;
    }
    
    public float Percepcion_T(String S_PercepcionT,float f_PercepcionT)
    {
        try {
            String ID = id_PE.getText().trim();
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from planilla_enc where id_planillaenc = " + ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                S_PercepcionT = rs.getString("total_percepcion");
                f_PercepcionT = Float.parseFloat(S_PercepcionT);
            } 

        } catch (Exception e) 
        {
            System.out.println(e);
        }
        
        System.out.println(f_PercepcionT);
        return f_PercepcionT;
    } 
    
    public void Eliminar_PG()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from planilla_enc where id_planillaenc = ?");

            pst.setString(1, BuscarPG.getText().trim());
            pst.executeUpdate();

            /*id_PE.setText("");
            total_PercepcionPE = "";
            total_DeduccionPE = "";
            total_LiquidoPE = "";*/

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_PG();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public DefaultTableModel Buscar_PG(String Buscar)
    {
        String[] nombre_ColumnasExpL = {"ID Planilla General", "Total Percepcion","total_deduccion","Total Liquido"};
        String[] RegistrosExpL = new String[4];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasExpL);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from planilla_enc WHERE id_planillaenc LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                RegistrosExpL[0] = rs.getString("id_planillaenc");
                RegistrosExpL[1] = rs.getString("total_percepcion");
                RegistrosExpL[2] = rs.getString("total_deduccion");
                RegistrosExpL[3] = rs.getString("total_liquido");
                
                model.addRow(RegistrosExpL);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
    
    public void Buscar_PGF(String Buscar)
    {
        DefaultTableModel model = Buscar_PG(Buscar);
        TablaPG.setModel(model);
        
        Nomina NO = new Nomina();
        NO.Datos_PD();
    }
}
