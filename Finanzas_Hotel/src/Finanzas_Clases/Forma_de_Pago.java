
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
 * @author Brayan Cifuentes
 */

public class Forma_de_Pago {
    
    //Atributos 
    JTextField Forma_Pago;
    JTextField Tipo_pago;
    JTextField Buscar;
    JTable tbl_formapago;

    public Forma_de_Pago(JTextField Forma_Pago, JTextField Tipo_pago, JTextField Buscar, JTable tbl_formapago) {
        this.Forma_Pago = Forma_Pago;
        this.Tipo_pago = Tipo_pago;
        this.Buscar = Buscar;
        this.tbl_formapago = tbl_formapago;
    }

   
    
    
    public int Cantidad_Registros()
    {
        int cant = 0;
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from forma_pago");
            
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
        
        
        String[] Ac_Datos = new String [2];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from forma_pago");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Forma Pago");
            model.addColumn("Tipo Pago");
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                Ac_Datos[0] = rs.getString("id_formapago");
                Ac_Datos[1] = rs.getString("tipo_pago");
                
                model.addRow(Ac_Datos);
                
                tbl_formapago.setModel(model);
                
            }
            //JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tbl_formapago.setModel(model);
        }catch(Exception e)
        {
            System.out.println(e);
        }
                
    }
    
    
    public void Insertar_FormaPago()
    {
        try
        {
            Connection  cnIEL = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into forma_pago values(?,?)");
            
            pstIP.setString(1, Forma_Pago.getText().trim());
            pstIP.setString(2, Tipo_pago.getText().trim());
            
            
            pstIP.executeUpdate();
            
            Forma_Pago.setText("");
            Tipo_pago.setText("");
            
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            
            
            Actualizar_Tabla();
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public void Modificar_FormaPago()
    {
        try
        {
            String ID = Buscar.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("update forma_pago set id_formapago = ?, tipo_pago=? where id_formapago = " + ID);

            pst.setString(1, Forma_Pago.getText().trim());
            pst.setString(2, Tipo_pago.getText().trim());
            

            pst.executeUpdate();

            Forma_Pago.setText("");
            Tipo_pago.setText("");
            
            
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public void Eliminar_formapago()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from forma_pago where id_formapago = ?");

            pst.setString(1, Buscar.getText().trim());
            pst.executeUpdate();

            Forma_Pago.setText("");
            Tipo_pago.setText("");

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public DefaultTableModel Buscar_FP(String Buscar)
    {
        String[] nombre_ColumnasAC = {"ID Forma Pago","Tipo Pago"};
        String[] RegistrosAC = new String[4];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasAC);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from forma_pago WHERE id_formapago LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                RegistrosAC[0] = rs.getString("id_formapago");
                RegistrosAC[1] = rs.getString("tipo_pago");
                
                model.addRow(RegistrosAC);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
    
    public void Buscar_FPF(String Buscar)
    {
        DefaultTableModel model = Buscar_FP(Buscar);
        tbl_formapago.setModel(model);
    }
    
}
