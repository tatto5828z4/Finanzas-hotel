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
    JTable tabla_BE;
    JTextField jTextField_Encontraid;
    JTextField txt_contra;
    JTextField txt_puesto;
    JTextField txt_depa;
    JTextField txt_peri;
    JTextField txt_selec;
    JTextField txt_ap;
    JTextField txt_idap;
    JTextField txt_dpi;
    JTextField txt_Buscar_BE;
    JTable tbl_BE;
    JTextField empleadoB;

    public Bitacora_Empleado(JTable tabla_BE, JTextField jTextField_Encontraid, JTextField txt_contra, JTextField txt_puesto, JTextField txt_depa, JTextField txt_peri, JTextField txt_selec, JTextField txt_ap, JTextField txt_idap, JTextField txt_dpi, JTextField txt_Buscar_BE, JTable tbl_BE, JTextField empleadoB) {
        this.tabla_BE = tabla_BE;
        this.jTextField_Encontraid = jTextField_Encontraid;
        this.txt_contra = txt_contra;
        this.txt_puesto = txt_puesto;
        this.txt_depa = txt_depa;
        this.txt_peri = txt_peri;
        this.txt_selec = txt_selec;
        this.txt_ap = txt_ap;
        this.txt_idap = txt_idap;
        this.txt_dpi = txt_dpi;
        this.txt_Buscar_BE = txt_Buscar_BE;
        this.tbl_BE = tbl_BE;
        this.empleadoB = empleadoB;
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
            model.addColumn("ID Bitacora"); //si
            model.addColumn("ID Empleado Contratado"); // tambien
            model.addColumn("ID Contatacion"); // tambien
            model.addColumn("Puesto"); // tambien
            model.addColumn("Departamento"); // tambien
            model.addColumn("DPI");
            model.addColumn("Nombres");
            model.addColumn("Fecha de Contratacion");
            model.addColumn("Sueldo"); // 
            
            ResultSet rs = pst.executeQuery();
            ResultSet rs2 = pst2.executeQuery();
            ResultSet rs3 = pst3.executeQuery();
            ResultSet rs4 = pst4.executeQuery();
            ResultSet rs5 = pst5.executeQuery();
            ResultSet rs6 = pst6.executeQuery();

            while(rs.next() && rs2.next() && rs3.next() && rs4.next() && rs5.next() && rs6.next()) {
                
                APP_Datos[0] = rs.getString("id_bitacora");
                APP_Datos[1] = rs.getString("id_empleado_B"); //ya
                APP_Datos[2] = rs2.getString("id_contratacion");//ya
                APP_Datos[3] = rs3.getString("nombre_puesto");//ya
                APP_Datos[4] = rs4.getString("nombre_departamento");
                APP_Datos[5] = rs5.getString("dpi_persona");
                APP_Datos[6] = rs5.getString("nombres_persona");
                APP_Datos[7] = rs2.getString("fecha_contratacion");
                APP_Datos[8] = rs6.getString("sueldo_empleado");
                
                model.addRow(APP_Datos);
                
                //tabla_BE.setModel(model);
                
            }
            JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            //tabla_BE.setModel(model);
        }catch(Exception e)
        {
            System.out.println(e);
        }
                
    }
    
    public void Insertar_BE()
    {
        empleadoB = Busqueda_IDEC();
        
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
        
//        id_empleadoB.setText(" ");
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
                empleadoB.setText(rs.getString("id_empleado"));
            }
            
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return empleadoB;

    }
    
    
    public void buscarBit()
    {
        String[] B_datos = new String [12];
        String Idbus;
        String contrata;
        Idbus = txt_Buscar_BE.getText();
        try
        {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Bitacora");//0
            model.addColumn("ID Empleado Contratado");//1
            model.addColumn("ID Contatacion");//2
            model.addColumn("Fecha contratacion");//3
            model.addColumn("ID Puesto");//4
            model.addColumn("Nombre Puesto");//5
            model.addColumn("ID Departamento");//6
            model.addColumn("Nombre Departamento");//7
            model.addColumn("Sueldo");//8
            model.addColumn("Dpi persona");//9
            model.addColumn("Nombre Persona");//10
            model.addColumn("Apellido Persona");//11

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select id_empleado, id_contratacion, id_puesto, id_departamento, sueldo_empleado from empleado_contratado where id_empleado =" + Idbus );
            PreparedStatement pst2 = cn.prepareStatement("select id_bitacora from bitacora_empleado where id_empleado_B =" + Idbus);
            ResultSet rs = pst.executeQuery();
            ResultSet rs2 = pst2.executeQuery();
            while(rs.next() && rs2.next())
            {
                txt_contra.setText(rs.getString("id_contratacion"));
                txt_puesto.setText(rs.getString("id_puesto"));
                txt_depa.setText(rs.getString("id_departamento"));
                B_datos[0] = rs2.getString("id_bitacora");
                B_datos[1] = rs.getString("id_empleado");
                B_datos[2] = rs.getString("id_contratacion");
                B_datos[4] = rs.getString("id_puesto");
                B_datos[6] = rs.getString("id_departamento");
                B_datos[8] = rs.getString("sueldo_empleado");
                PreparedStatement pst3 = cn.prepareStatement("select fecha_contratacion from contratacion where id_contratacion = " + txt_contra.getText());
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                    B_datos[3] = rs3.getString("fecha_contratacion");

                    PreparedStatement pst4 = cn.prepareStatement("select nombre_puesto from puesto where id_puesto = " + txt_puesto.getText());
                    ResultSet rs4 = pst4.executeQuery();
                    while(rs4.next())
                    {
                        B_datos[5] = rs4.getString("nombre_puesto");

                        PreparedStatement pst5 = cn.prepareStatement("select nombre_departamento from departamento where id_departamento = " + txt_depa.getText());
                        ResultSet rs5 = pst5.executeQuery();
                        while(rs5.next())
                        {
                            B_datos[7] = rs5.getString("nombre_departamento");

                            PreparedStatement pst6 = cn.prepareStatement("select id_periodop from contratacion where id_contratacion = " + txt_contra.getText());
                            ResultSet rs6 = pst6.executeQuery();
                            while(rs6.next())
                            {
                                txt_peri.setText(rs6.getString("id_periodop"));

                                PreparedStatement pst7 = cn.prepareStatement("select id_seleccion from periodo_prueba where id_periodop = " + txt_peri.getText());
                                ResultSet rs7 = pst7.executeQuery();
                                while(rs7.next())
                                {
                                    txt_selec.setText(rs7.getString("id_seleccion"));

                                    PreparedStatement pst8 = cn.prepareStatement("select id_ap from seleccion where id_seleccion = " + txt_selec.getText());
                                    ResultSet rs8 = pst8.executeQuery();
                                    while(rs8.next())
                                    {
                                        txt_ap.setText(rs8.getString("id_ap"));

                                        PreparedStatement pst9 = cn.prepareStatement("select id_aplicacion from aplicacion_prueba where id_ap = " + txt_ap.getText());
                                        ResultSet rs9 = pst9.executeQuery();
                                        while(rs9.next())
                                        {
                                            txt_idap.setText(rs9.getString("id_aplicacion"));

                                            PreparedStatement pst10 = cn.prepareStatement("select * from aplicacion where id_aplicacion = " + txt_idap.getText());
                                            ResultSet pel = pst10.executeQuery();
                                            while(pel.next())
                                            {
                                                txt_dpi.setText(pel.getString("dpi_persona"));
                                                B_datos[9] = pel.getString("dpi_persona");
                                                //tbl_BE.setModel(model);

                                                PreparedStatement pst11 = cn.prepareStatement("select nombres_persona, apellidos_persona from curriculum where dpi_persona = " + txt_dpi.getText());
                                                ResultSet res = pst11.executeQuery();
                                                while(res.next())
                                                {
                                                    //B_datos[9] = res.getString("dpi_persona");
                                                    B_datos[10] = res.getString("nombres_persona");
                                                    B_datos[11] = res.getString("apellidos_persona");
                                                    model.addRow(B_datos);
                                                }

                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }

                }
            }
            tbl_BE.setModel(model);

        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void actualizarBit()
    {
        String[] Bi_datos = new String [9];
        try
        {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Bitacora");
            model.addColumn("ID Empleado Contratado");
            model.addColumn("ID Contatacion");
            model.addColumn("Puesto");
            model.addColumn("Departamento");
            model.addColumn("Sueldo");

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select id_empleado, id_contratacion, id_puesto, id_departamento, sueldo_empleado from empleado_contratado ");
            PreparedStatement pst2 = cn.prepareStatement("select id_bitacora from bitacora_empleado");
            ResultSet rs = pst.executeQuery();
            ResultSet rs2 = pst2.executeQuery();
            while(rs.next() && rs2.next())
            {
                Bi_datos[0] = rs2.getString("id_bitacora");
                Bi_datos[1] = rs.getString("id_empleado");
                Bi_datos[2] = rs.getString("id_contratacion");
                Bi_datos[3] = rs.getString("id_puesto");
                Bi_datos[4] = rs.getString("id_departamento");
                Bi_datos[5] = rs.getString("sueldo_empleado");
                model.addRow(Bi_datos);
            }
            tbl_BE.setModel(model);

        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
