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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Langas
 */
public class Experiencia_Laboral_Detallada 
{
    //Atributos
    JTextField id_ExpLD;
    JTextField nombre_ExpLD;
    JTextField nombreE_ExpLD;
    JTextField tiempoI_ExpLD;
    JTextField tiempoF_ExpLD;
    JTextField buscar_ExpLD;
    JTable tabla_ExpLD;

    public Experiencia_Laboral_Detallada(JTextField id_ExpLD, JTextField nombre_ExpLD, JTextField nombreE_ExpLD, JTextField tiempoI_ExpLD, JTextField tiempoF_ExpLD, JTextField buscar_ExpLD, JTable tabla_ExpLD) {
        this.id_ExpLD = id_ExpLD;
        this.nombre_ExpLD = nombre_ExpLD;
        this.nombreE_ExpLD = nombreE_ExpLD;
        this.tiempoI_ExpLD = tiempoI_ExpLD;
        this.tiempoF_ExpLD = tiempoF_ExpLD;
        this.buscar_ExpLD = buscar_ExpLD;
        this.tabla_ExpLD = tabla_ExpLD;
    }
    
    public void Actualizar_Tabla()
    {
        int cantidad = Cantidad_Registros();
        
        
        String[] Departamento_Datos = new String [5];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from explab_detallado");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Experiencia Laboral Detallada");
            model.addColumn("Nombre de Experiencia Laboral Detallada");
            model.addColumn("Nombre Empresa de Experiencia Laboral Detallada");
            model.addColumn("Tiempo de Inicio de Experiencia Laboral Detallada");
            model.addColumn("Tiempo de Finalizacion de Experiencia Laboral Detallada");
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                Departamento_Datos[0] = rs.getString("id_tipoexp");
                Departamento_Datos[1] = rs.getString("nombre_tipo");
                Departamento_Datos[2] = rs.getString("nombre_empresa");
                Departamento_Datos[3] = rs.getString("tiempo_inicio");
                Departamento_Datos[4] = rs.getString("tiempo_finalizacion");
                
                model.addRow(Departamento_Datos);
                
                tabla_ExpLD.setModel(model);
                
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tabla_ExpLD.setModel(model);
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
            PreparedStatement pst = cn.prepareStatement("select * from explab_detallado");
            
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
    
    public void Insertar_ExpLD()
    {
        try
        {
            Connection  cnIP = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cnIP.prepareStatement("insert into explab_detallado values(?,?,?,?,?)");
            
            pstIP.setString(1, id_ExpLD.getText().trim());
            pstIP.setString(2, nombre_ExpLD.getText().trim());
            pstIP.setString(3, nombreE_ExpLD.getText().trim());
            pstIP.setString(4, tiempoI_ExpLD.getText().trim());
            pstIP.setString(5, tiempoF_ExpLD.getText().trim());
            
            pstIP.executeUpdate();
            
            id_ExpLD.setText("");
            nombre_ExpLD.setText("");
            nombreE_ExpLD.setText("");
            tiempoI_ExpLD.setText("");
            tiempoF_ExpLD.setText("");
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            
            
            Actualizar_Tabla();

            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Modificar_ExpLD()
    {
        try
        {
            String ID = buscar_ExpLD.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("update explab_detallado set id_tipoexp = ?, nombre_tipo=?,nombre_empresa = ?, tiempo_inicio=?,tiempo_finalizacion=? where id_tipoexp = " + ID);

            pst.setString(1, id_ExpLD.getText().trim());
            pst.setString(2, nombre_ExpLD.getText().trim());
            pst.setString(3, nombreE_ExpLD.getText().trim());
            pst.setString(4, tiempoI_ExpLD.getText().trim());
            pst.setString(5, tiempoF_ExpLD.getText().trim());

            pst.executeUpdate();

            buscar_ExpLD.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Eliminar_ExpLD()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from explab_detallado where id_tipoexp = ?");

            pst.setString(1, buscar_ExpLD.getText().trim());
            pst.executeUpdate();

            id_ExpLD.setText("");
            nombre_ExpLD.setText("");
            nombreE_ExpLD.setText("");
            tiempoI_ExpLD.setText("");
            tiempoF_ExpLD.setText("");

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public DefaultTableModel Buscar_ExpLD(String Buscar)
    {
        String[] nombre_ColumnasD = {"ID Experiencia Laboral Detallada", "Nombre de Experiencia Laboral Detallada","Nombre Empresa de Experiencia Laboral Detallada","Tiempo de Inicio de Experiencia Laboral Detallada", "Tiempo de Finalizacion de Experiencia Laboral Detallada"};
        String[] RegistrosD = new String[5];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasD);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from explab_detallado WHERE id_tipoexp LIKE '%"+Buscar+"%' OR nombre_tipo LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                RegistrosD[0] = rs.getString("id_tipoexp");
                RegistrosD[1] = rs.getString("nombre_tipo");
                RegistrosD[2] = rs.getString("nombre_empresa");
                RegistrosD[3] = rs.getString("tiempo_inicio");
                RegistrosD[4] = rs.getString("tiempo_finalizacion");
                
                model.addRow(RegistrosD);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
    
    public void Buscar_ExpLDF(String Buscar)
    {
        DefaultTableModel model = Buscar_ExpLD(Buscar);
        tabla_ExpLD.setModel(model);
    }
    

}
