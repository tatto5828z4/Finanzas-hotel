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
 * @author Brayan Cifuentes
 */
public class Periodo_Prueba {

    JTextField id_PeriodoP;
    JLabel id_Seleccion;
    JTextField fecha_inicio;
    JTextField fecha_finalizacion;
    JTextField pago;
    JLabel id_actividad;
    JTextField buscar_Periodop;
    JTable tabla_periodop;

    
    
    public Periodo_Prueba(JTextField id_PeriodoP, JLabel id_Seleccion, JTextField fecha_inicio, JTextField fecha_finalizacion, JTextField pago, JLabel id_actividad, JTextField buscar_Periodop, JTable tabla_periodop) {
        this.id_PeriodoP = id_PeriodoP;
        this.id_Seleccion = id_Seleccion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_finalizacion = fecha_finalizacion;
        this.pago = pago;
        this.id_actividad = id_actividad;
        this.buscar_Periodop = buscar_Periodop;
        this.tabla_periodop = tabla_periodop;
    }

    
    
    public int Cantidad_Registros() {
        int cant = 0;

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from periodo_prueba");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                cant++;
            }
            //JOptionPane.showMessageDialog(null, "La cantidad es " + cant);
        } catch (Exception e) {
            System.out.println(e);
        }

        return cant;
    }

    
    public void Actualizar_Tabla() 
    {
        
        int cantidad = Cantidad_Registros();

        String[] Referencias_Laborales = new String[6];
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from periodo_prueba");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Periodo Prueba");
            model.addColumn("ID Seleccion");
            model.addColumn("Fecha Inicio");
            model.addColumn("Fecha Finalizacion");
            model.addColumn("Pago");
            model.addColumn("ID Actividad");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Referencias_Laborales[0] = rs.getString("id_periodop");
                Referencias_Laborales[1] = rs.getString("id_seleccion");
                Referencias_Laborales[2] = rs.getString("fecha_inicio");
                Referencias_Laborales[3] = rs.getString("fecha_finalizacion");
                Referencias_Laborales[4] = rs.getString("pago");
                Referencias_Laborales[5] = rs.getString("id_actividad");

                model.addRow(Referencias_Laborales);

                tabla_periodop.setModel(model);

            }
            
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tabla_periodop.setModel(model);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void Insertar_PP() 
    {
        try {
            Connection cnIEL = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into periodo_prueba values(?,?,?,?,?,?)");

            pstIP.setString(1, id_PeriodoP.getText().trim());
            pstIP.setString(2, id_Seleccion.getText().trim());
            pstIP.setString(3, fecha_inicio.getText().trim());
            pstIP.setString(4, fecha_finalizacion.getText().trim());
            pstIP.setString(5, pago.getText().trim());
            pstIP.setString(6, id_actividad.getText().trim());

            pstIP.executeUpdate();

            id_PeriodoP.setText("");
            id_Seleccion.setText("");
            fecha_inicio.setText("");
            fecha_finalizacion.setText("");
            pago.setText("");
            id_actividad.setText("");

            JOptionPane.showMessageDialog(null, "Registro Exitoso");

            Actualizar_Tabla();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    public void Modificar_PP()
    {
        try
        {
            String ID = buscar_Periodop.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstSE = cn.prepareStatement("update periodo_prueba set id_periodop = ?, id_seleccion = ?, fecha_inicio = ?, fecha_finalizacion=?, pago=?, id_actividad=? where id_periodop = " + ID);
            
            pstSE.setString(1, id_PeriodoP.getText().trim());
            pstSE.setString(2, id_Seleccion.getText().trim());
            pstSE.setString(3, fecha_inicio.getText().trim());
            pstSE.setString(4, fecha_finalizacion.getText().trim());
            pstSE.setString(5, pago.getText().trim());
            pstSE.setString(6, id_actividad.getText().trim());
             

            pstSE.executeUpdate();

            buscar_Periodop.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
     
    
    
    public void Eliminar_PP()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from periodo_prueba where id_periodop = ?");

            pst.setString(1, buscar_Periodop.getText().trim());
            pst.executeUpdate();

            
            id_PeriodoP.setText("");
            id_Seleccion.setText("");
            fecha_inicio.setText("");
            fecha_finalizacion.setText("");
            pago.setText("");
            id_actividad.setText("");
            

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    
    
    public DefaultTableModel Buscar_PP(String Buscar) 
    {
        String[] nombre_ColumnasSE = {"ID Periodo Prueba", "ID Seleccion", "Fecha Inicio", "Fecha Finalizacion", "Pago", "ID Actividad"};
        String[] RegistrosSE = new String[6];

        DefaultTableModel model = new DefaultTableModel(null, nombre_ColumnasSE);

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from periodo_prueba WHERE id_periodop LIKE '%" + Buscar + "%'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) 
            {
                RegistrosSE[0] = rs.getString("id_periodop");
                RegistrosSE[1] = rs.getString("id_seleccion");
                RegistrosSE[2] = rs.getString("fecha_inicio");
                RegistrosSE[3] = rs.getString("fecha_finalizacion");
                RegistrosSE[4] = rs.getString("pago");
                RegistrosSE[5] = rs.getString("id_actividad");
                

                model.addRow(RegistrosSE);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return model;
    }
    

    public void Buscar_PPE(String Buscar) 
    {
        DefaultTableModel model = Buscar_PP(Buscar);
        tabla_periodop.setModel(model);
    }

    
    public void Encontrar_ListaPP(String tablaBD, String nombre, JComboBox boxNombre) 
    {
        
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from " + tablaBD);

            ResultSet rs = pst.executeQuery();

            //id_ExpLD.addItem("Seleccione Experiencia Laboral");
            while (rs.next()) {

                boxNombre.addItem(rs.getString(nombre));
                //idL_ExpLD.setText(rs.getString("id_tipoexp"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /*Usar Para foraneas*/
    public void EncontrarID_PP(String ID, String tablaBD, String Nombre, JComboBox boxNombre, JLabel label) {

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select " + ID + " from " + tablaBD + " where " + Nombre + "= ?");
            pst.setString(1, boxNombre.getSelectedItem().toString());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                label.setText(rs.getString(ID));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    
    
    public void BuscarFila_PP(String Nombre,String tablaBD, String ID,JComboBox boxNombre,JLabel labelID)
    {
        
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
