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
 * @author Langas
 */
public class Bitacora_Empleado 
{
    //Atributos
    JTextField id_empleadoB;
    JTextField buscar_BE;
    JTable tabla_BE;

    public Bitacora_Empleado(JTextField id_empleadoB, JTextField buscar_BE, JTable tabla_BE) {
        this.id_empleadoB = id_empleadoB;
        this.buscar_BE = buscar_BE;
        this.tabla_BE = tabla_BE;
    }

    
    
    public int Cantidad_Registros()
    {
        int cant = 0;
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from bitacora_empleado");
            
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
        
        
        String[] APP_Datos = new String [9];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from bitacora_empleado");
            PreparedStatement pst2 = cn.prepareStatement("select * from contratacion");
            PreparedStatement pst3 = cn.prepareStatement("select nombre_puesto from puesto");
            PreparedStatement pst4 = cn.prepareStatement("select nombre_departamento from departamento");
            PreparedStatement pst5 = cn.prepareStatement("select * from curriculum");
            PreparedStatement pst6 = cn.prepareStatement("select * from empleado_contratado");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Bitacora");
            model.addColumn("ID Empleado Contratado");
            model.addColumn("ID Contatacion");
            model.addColumn("Puesto");
            model.addColumn("Departamento");
            model.addColumn("DPI");
            model.addColumn("Nombres");
            model.addColumn("Fecha de Contratacion");
            model.addColumn("Sueldo");
            
            ResultSet rs = pst.executeQuery();
            ResultSet rs2 = pst2.executeQuery();
            ResultSet rs3 = pst3.executeQuery();
            ResultSet rs4 = pst4.executeQuery();
            ResultSet rs5 = pst5.executeQuery();
            ResultSet rs6 = pst6.executeQuery();

            while(rs.next() && rs2.next() && rs3.next() && rs4.next() && rs5.next() && rs6.next()) {
                
                APP_Datos[0] = rs.getString("id_bitacora");
                APP_Datos[1] = rs.getString("id_empleado_B");
                APP_Datos[2] = rs2.getString("id_contratacion");
                APP_Datos[3] = rs3.getString("nombre_puesto");
                APP_Datos[4] = rs4.getString("nombre_departamento");
                APP_Datos[5] = rs5.getString("dpi_persona");
                APP_Datos[6] = rs5.getString("nombres_persona");
                APP_Datos[7] = rs2.getString("fecha_contratacion");
                APP_Datos[8] = rs6.getString("sueldo_empleado");
                
                model.addRow(APP_Datos);
                
                tabla_BE.setModel(model);
                
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tabla_BE.setModel(model);
        }catch(Exception e)
        {
            System.out.println(e);
        }
                
    }
    
    public void Insertar_BE()
    {
        JTextField empleadoB = Busqueda_IDEC();
        
        try
        {
            Connection  cnIEL = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into bitacora_empleado values(?,?)");
            
            pstIP.setString(1, "0");
            pstIP.setString(2, empleadoB.getText().trim());
            
            pstIP.executeUpdate();
                      
            Actualizar_Tabla();
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        id_empleadoB.setText(" ");
    }
    
    public JTextField Busqueda_IDEC()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select id_empleado from empleado_contratado" );
            //pst.setString(1, id_empleadoB.getText());
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                id_empleadoB.setText(rs.getString("id_empleado"));
            }
            
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return id_empleadoB;

    }
    
}
