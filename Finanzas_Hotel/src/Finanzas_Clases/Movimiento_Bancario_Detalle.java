
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

public class Movimiento_Bancario_Detalle {
    
    //atributos 
    JLabel ID_MovE;
    JLabel Codigo_concepto;
    JTextField Saldo;
    JTextField Tipo_saldo;
    JTextField Buscar;
    JTable tbl_mov;

    
    public Movimiento_Bancario_Detalle(JLabel ID_MovE, JLabel Codigo_concepto, JTextField Saldo, JTextField Tipo_saldo, JTextField Buscar, JTable tbl_mov) {
        this.ID_MovE = ID_MovE;
        this.Codigo_concepto = Codigo_concepto;
        this.Saldo = Saldo;
        this.Tipo_saldo = Tipo_saldo;
        this.Buscar = Buscar;
        this.tbl_mov = tbl_mov;
    }

    

    
    public int Cantidad_Registros()
    {
        int cant = 0;
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from mov_bancDet");
            
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
        
        
        String[] Ac_Datos = new String [4];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from mov_bancDet");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Movimiento Encabezado");
            model.addColumn("Codigo Concepto");
            model.addColumn("Saldo");
            model.addColumn("Tipo Saldo");
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                Ac_Datos[0] = rs.getString("id_movEnc");
                Ac_Datos[1] = rs.getString("codigo_concepto");
                Ac_Datos[2] = rs.getString("saldo");
                Ac_Datos[3] = rs.getString("tipo_saldo");
                
                model.addRow(Ac_Datos);
                
                tbl_mov.setModel(model);
                
            }
            //JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tbl_mov.setModel(model);
        }catch(Exception e)
        {
            System.out.println(e);
        }
                
    }
    
    
    public void Insertar_Mov()
    {
        try
        {
            Connection  cnIEL = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into mov_bancDet values(?,?,?,?)");
            
            pstIP.setString(1, ID_MovE.getText().trim());
            pstIP.setString(2, Codigo_concepto.getText().trim());
            pstIP.setString(3, Saldo.getText().trim());
            pstIP.setString(4, Tipo_saldo.getText().trim());
            
            pstIP.executeUpdate();
            
            ID_MovE.setText("");
            Codigo_concepto.setText("");
            Saldo.setText("");
            Tipo_saldo.setText("");
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            
            
            Actualizar_Tabla();
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public void Modificar_Mov()
    {
        try
        {
            String ID = Buscar.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("update mov_bancDet set id_movEnc = ?, codigo_concepto=?,saldo = ?, tipo_saldo=? where codigo_concepto = " + ID);

            pst.setString(1, ID_MovE.getText().trim());
            pst.setString(2, Codigo_concepto.getText().trim());
            pst.setString(3, Saldo.getText().trim());
            pst.setString(4, Tipo_saldo.getText().trim());

            pst.executeUpdate();

            ID_MovE.setText("");
            Codigo_concepto.setText("");
            Saldo.setText("");
            Tipo_saldo.setText("");
            
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void Eliminar_Mov()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from mov_bancDet where codigo_concepto = ?");

            pst.setString(1, Buscar.getText().trim());
            pst.executeUpdate();

            ID_MovE.setText("");
            Codigo_concepto.setText("");
            Saldo.setText("");
            Tipo_saldo.setText("");

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_Tabla();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public DefaultTableModel Buscar_Mov(String Buscar)
    {
        String[] nombre_ColumnasAC = {"ID Mov Bancario Detalle","Codigo Concepto","Saldo", "Tipo Saldo"};
        String[] RegistrosAC = new String[4];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasAC);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from mov_bancDet WHERE codigo_concepto LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                RegistrosAC[0] = rs.getString("id_movEnc");
                RegistrosAC[1] = rs.getString("codigo_concepto");
                RegistrosAC[2] = rs.getString("saldo");
                RegistrosAC[3] = rs.getString("tipo_saldo");
                
                model.addRow(RegistrosAC);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
    
    public void Buscar_MovD(String Buscar)
    {
        DefaultTableModel model = Buscar_Mov(Buscar);
        tbl_mov.setModel(model);
    }
    
    
    
    
    
    public void Encontrar_ListaMov(String tablaBD, String nombre,JComboBox boxNombre)
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
    
    
     public void EncontrarIDMov(String ID, String tablaBD, String Nombre,JComboBox boxNombre,JLabel label)
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
 
     
    // Fila 
    public void BuscarFila_Mov(String Nombre,String tablaBD, String ID,JComboBox boxNombre,JLabel labelID){
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
