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
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
public class Planilla_Detalle 
{
    //Atributos
    JTextField id_PD;
    JTextField id_PG;
    JComboBox ConceptoP;
    JLabel id_ConceptoP;
    JTextField Valor_PD;
    JCheckBox DeduccionPD;
    JCheckBox PercepcionPD;
    JButton igssPD;
    JLabel ISR;
    JTextField BuscarPD;
    JTable TablaPD;

    public Planilla_Detalle(JTextField id_PD, JTextField id_PG, JComboBox ConceptoP, JLabel id_ConceptoP, JTextField Valor_PD, JCheckBox DeduccionPD, JCheckBox PercepcionPD, JButton igssPD, JLabel ISR, JTextField BuscarPD, JTable TablaPD) {
        this.id_PD = id_PD;
        this.id_PG = id_PG;
        this.ConceptoP = ConceptoP;
        this.id_ConceptoP = id_ConceptoP;
        this.Valor_PD = Valor_PD;
        this.DeduccionPD = DeduccionPD;
        this.PercepcionPD = PercepcionPD;
        this.igssPD = igssPD;
        this.ISR = ISR;
        this.BuscarPD = BuscarPD;
        this.TablaPD = TablaPD;
    }
    
    public void Actualizar_PD()
    {
        int cantidad = Cantidad_Registros();
        
        String[] CP_Datos = new String [5];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from planilla_det");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Planilla Detalle");
            model.addColumn("ID Planilla General");
            model.addColumn("ID Empleado");
            model.addColumn("ID Concepto Planilla");
            model.addColumn("Valor Concepto");
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                CP_Datos[0] = rs.getString("id_planillaDe");
                CP_Datos[1] = rs.getString("id_planillaenc");
                CP_Datos[2] = rs.getString("id_empleado");
                CP_Datos[3] = rs.getString("id_conceptoPlanilla");
                CP_Datos[4] = rs.getString("valor_conceptoDet");
                
                model.addRow(CP_Datos);
                
                TablaPD.setModel(model);
                
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            TablaPD.setModel(model);
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
            PreparedStatement pst = cn.prepareStatement("select * from planilla_det");
            
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
    
    public void EncontrarID_PD(String ID, String tablaBD, String Nombre,JComboBox boxNombre)
    {     
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select " +  ID  + " from " + tablaBD +" where " + Nombre + "= ?");
            pst.setString(1, boxNombre.getSelectedItem().toString());

            ResultSet rs = pst.executeQuery();

            if(rs.next()) {
                id_ConceptoP.setText(rs.getString(ID));
            } 

        } catch (Exception e) 
        {
            System.out.println(e);
        }
    }
    
    public void Encontrar_ListaPD(String tablaBD, String nombre,JComboBox boxNombre)
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
    
    public void Obtener_Rangos(int RangoMenor,int RangoMayor,int IDU,JTextField RU,JLabel Titulo,JLabel Titulo2)
    {
        
        
        if(RangoMenor > 0  && RangoMayor > 0)
        {
            Titulo.setVisible(true);
            Titulo2.setVisible(false);
            
            RU.setText("" + RangoMenor + "-" + RangoMayor);
        }
        else if(IDU > 0)
        {
            Titulo.setVisible(false);
            Titulo2.setVisible(true);
            
            RU.setText("" + IDU);
        }
    }
    
    public float Encontrar_DPL(String DPL,float f_DPL,String Nombre)
    {
        try {
            String ID = id_PG.getText().trim();
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from planilla_enc where id_planillaenc = " + ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                DPL = rs.getString(Nombre);
                f_DPL = Float.parseFloat(DPL);
            } 
            

        } catch (Exception e) 
        {
            System.out.println(e);
        }
        
        System.out.println(f_DPL);
        return f_DPL;
    }
    
    public float Encontrar_VC(String DPL,float f_DPL,String Nombre,String NombreBD,String IDBD)
    {
        try {
            String ID = BuscarPD.getText().trim();
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from " + NombreBD + " where " +  IDBD + " = " + ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                DPL = rs.getString(Nombre);
                f_DPL = Float.parseFloat(DPL);
            } 
            

        } catch (Exception e) 
        {
            System.out.println(e);
        }
        
        System.out.println(f_DPL);
        return f_DPL;
    }
    
    public float SumaT_DPL(String S_Valor,JTextField Valor,float f_Valor,float SumaA,float Sumat,JTextField IDCP,int RangoMe,int RangoMa,int IDU, JCheckBox DP)
    {
        try {
            String ID = IDCP.getText().trim();
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from planilla_enc where id_planillaenc = " + ID);

            ResultSet rs = pst.executeQuery();

            
                if(RangoMa > 0 && RangoMe >0)
                {
                    
                    if (rs.next()) 
                    {
                        for(int i = RangoMe; i<=RangoMa;i++)
                        {
                            S_Valor = Valor.getText();
                            f_Valor = Float.parseFloat(S_Valor);
                            
                            Sumat +=  f_Valor;
                        } 
                        
                        Sumat += SumaA;
                    }  
                }
                if(IDU > 0)
                {
                    if (rs.next()) 
                    {
                            
                        S_Valor = Valor.getText();
                        f_Valor = Float.parseFloat(S_Valor);
                            
                        Sumat += SumaA + f_Valor;
                    }     
                }
           
            
            
        } catch (Exception e) 
        {
            System.out.println(e);
        }               
        
        System.out.println(IDU);
        System.out.println("La SumaA es " +SumaA);
        System.out.println("La f_Valor es " +f_Valor);
        return Sumat;
        
    }
    
    
    public void Insertar_PD(int CantidadR,int RangoMe, int RangoMa, int IDU)
    {   
        try
        {
            Connection  cnIP = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cnIP.prepareStatement("insert into planilla_det values(?,?,?,?,?)");
            
            if(RangoMe > 0 && RangoMa > 0)
            {
                for(int i = RangoMe; i <= RangoMa; i++ )
                {
                    pstIP.setString(1, id_PD.getText());
                    pstIP.setString(2, id_PG.getText());
                    pstIP.setString(3, String.valueOf(i));
                    pstIP.setString(4, id_ConceptoP.getText());
                    pstIP.setString(5, Valor_PD.getText());
            
                    pstIP.executeUpdate(); 
                }
            }
            
            if(IDU > 0)
            {
                pstIP.setString(1, id_PD.getText());
                pstIP.setString(2, id_PG.getText());
                pstIP.setString(3, String.valueOf(IDU));
                pstIP.setString(4, id_ConceptoP.getText());
                pstIP.setString(5, Valor_PD.getText());
            
                pstIP.executeUpdate();   
            }
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            
            
            Actualizar_PD();

            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Modificar_PD(int RangoMe, int RangoMa,int IDU) {
        try {
            String ID = BuscarPD.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("update planilla_det set id_planillaDe = ?,id_planillaenc = ?, id_empleado=?,id_conceptoPlanilla = ?, valor_conceptoDet=? where id_planillaDe= " + ID);

            if(RangoMe > 0 && RangoMa > 0)
            {
                for(int i = RangoMe; i<= RangoMa; i++)
                {
                    
                    pst.setString(1, id_PD.getText().trim());
                    pst.setString(2, id_PG.getText().trim());
                    pst.setString(3, String.valueOf(i));
                    pst.setString(4, id_ConceptoP.getText());
                    pst.setString(5, Valor_PD.getText().trim());
                }
            }
            if(IDU > 0)
            {
                pst.setString(1, id_PD.getText().trim());
                pst.setString(2, id_PG.getText().trim());
                pst.setString(3, String.valueOf(IDU));
                pst.setString(4, id_ConceptoP.getText());
                pst.setString(5, Valor_PD.getText().trim());
            }
            

            pst.executeUpdate();

            BuscarPD.setText("");
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");

            Actualizar_PD();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public float Impuesto_PG(String S_Sueldo,float f_Sueldo,int ID)
    {
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select sueldo_empleado from  empleado_contratado where id_empleado = " + ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                S_Sueldo = rs.getString("sueldo_empleado");
                f_Sueldo = Float.parseFloat(S_Sueldo);
            } 

        } catch (Exception e) 
        {
            System.out.println(e);
        }
        
        System.out.println(f_Sueldo);
        return f_Sueldo;
    }   
    
    public DefaultTableModel Buscar_PD(String Buscar)
    {
        String[] nombre_ColumnasExpL = {"ID Planilla Detalle", "ID Planilla General","ID Empleado","ID Concepto Planilla","Valor Concepto"};
        String[] RegistrosExpL = new String[5];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasExpL);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from planilla_det WHERE id_planillaDe LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                RegistrosExpL[0] = rs.getString("id_planillaDe");
                RegistrosExpL[1] = rs.getString("id_planillaenc");
                RegistrosExpL[2] = rs.getString("id_empleado");
                RegistrosExpL[3] = rs.getString("id_conceptoPlanilla");
                RegistrosExpL[4] = rs.getString("valor_conceptoDet");
                
                model.addRow(RegistrosExpL);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
    
    public void Buscar_PDF(String Buscar)
    {
        DefaultTableModel model = Buscar_PD(Buscar);
        TablaPD.setModel(model);
        
        Nomina NO = new Nomina();
        NO.Datos_PD();
    }
    
    
    public void BuscarFila_PD(String Nombre,String tablaBD, String ID,JComboBox boxNombre,JLabel labelID)
    {
        try{
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select " +  Nombre  + " from " + tablaBD +" where " + ID + "= ?");
            pst.setString(1, labelID.getText());

            ResultSet rs = pst.executeQuery();
             

            if(rs.next()) {
                boxNombre.setSelectedItem(rs.getString(Nombre));
            } 
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Eliminar_PD(String ID)
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from planilla_det where id_planillaDe = ?");

            pst.setString(1, ID);
            pst.executeUpdate();


            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_PD();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
