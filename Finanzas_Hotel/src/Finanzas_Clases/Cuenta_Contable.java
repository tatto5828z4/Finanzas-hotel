
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
 * @author Brayan Cifuentes
 */

public class Cuenta_Contable {
    
    // Atributos 
    JTextField ID_cuenta;
    JTextField Nombre_cuenta;
    JTextField Tipo_cuenta;
    JLabel ID_clasificacion;
    JTextField Saldo_anterior;
    JTextField Cargos_acumulados;
    JTextField Abonos_acumulados;
    JTextField Saldo_actual;
    JTextArea Descripcion;
    JTextField Buscar;
    JTable tbl_cc;

    public Cuenta_Contable(JTextField ID_cuenta, JTextField Nombre_cuenta, JTextField Tipo_cuenta, JLabel ID_clasificacion, JTextField Saldo_anterior, JTextField Cargos_acumulados, JTextField Abonos_acumulados, JTextField Saldo_actual, JTextArea Descripcion, JTextField Buscar, JTable tbl_cc) {
        this.ID_cuenta = ID_cuenta;
        this.Nombre_cuenta = Nombre_cuenta;
        this.Tipo_cuenta = Tipo_cuenta;
        this.ID_clasificacion = ID_clasificacion;
        this.Saldo_anterior = Saldo_anterior;
        this.Cargos_acumulados = Cargos_acumulados;
        this.Abonos_acumulados = Abonos_acumulados;
        this.Saldo_actual = Saldo_actual;
        this.Descripcion = Descripcion;
        this.Buscar = Buscar;
        this.tbl_cc = tbl_cc;
    }

    
    
    
    
    
    public int Cantidad_Registros()
    {
        int cant = 0;
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from cuenta_contable");
            
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
        
        
        String[] C_Datos = new String [9];
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from cuenta_contable");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Cuenta");
            model.addColumn("Nombre Cuenta");
            model.addColumn("Tipo Cuenta");
            model.addColumn("ID Clasificacion");
            model.addColumn("Saldo Anterior");
            model.addColumn("Cargos Acumulados");
            model.addColumn("Abonos Acumulados");
            model.addColumn("Saldo Actual");
//            model.addColumn("Cargos Acumulados");
//            model.addColumn("Abonos Acumulados");
            model.addColumn("Descripcion Cuenta");
            
            
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                
                C_Datos[0] = rs.getString("id_cuenta");
                C_Datos[1] = rs.getString("nombre_cuenta");
                C_Datos[2] = rs.getString("tipo_cuenta");
                C_Datos[3] = rs.getString("id_clasificacion");
                C_Datos[4] = rs.getString("saldo_anterior");
                C_Datos[5] = rs.getString("cargos_acumulados");
                C_Datos[6] = rs.getString("abonos_acumulados");
                C_Datos[7] = rs.getString("saldo_actual");
//                C_Datos[8] = rs.getString("cargos_acumulados");
//                C_Datos[9] = rs.getString("abonos_acumulados");
                C_Datos[8] = rs.getString("descripcion_cuenta");
                
                model.addRow(C_Datos);
                
                tbl_cc.setModel(model);
                
            }
            //JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            tbl_cc.setModel(model);
        }catch(Exception e)
        {
            System.out.println(e);
        }
                
    }
    
    
    public void Insertar_CC()
    {
        try
        {
            Connection  cnIEL = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstIP = cnIEL.prepareStatement("insert into cuenta_contable values(?,?,?,?,?,?,?,?,?)");
            
            pstIP.setString(1, ID_cuenta.getText().trim());
            pstIP.setString(2, Nombre_cuenta.getText().trim());
            pstIP.setString(3, Tipo_cuenta.getText().trim());
            pstIP.setString(4, ID_clasificacion.getText().trim());
            pstIP.setString(5, "0");
            pstIP.setString(6, "0");
            pstIP.setString(7, "0");
            pstIP.setString(8, "0");
            pstIP.setString(9, Descripcion.getText().trim());
            
            
            pstIP.executeUpdate();
            
            ID_cuenta.setText("");
            Nombre_cuenta.setText("");
            Tipo_cuenta.setText("");
            ID_clasificacion.setText("");
            Saldo_anterior.setText("");
            Cargos_acumulados.setText("");
            Abonos_acumulados.setText("");
            Saldo_actual.setText("");
            Descripcion.setText("");

            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");        
            Actualizar_Tabla();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    
    public void Modificar_CC()
    {
        try
        {
            String ID = Buscar.getText().trim();

            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pstC = cn.prepareStatement("update cuenta_contable set id_cuenta = ?, nombre_cuenta = ?, tipo_cuenta = ?,id_clasificacion =?,saldo_anterior=?, cargos_acumulados=?, abonos_acumulados=?, saldo_actual=?, descripcion_cuenta =? where id_cuenta = " + ID);
            
            pstC.setString(1, ID_cuenta.getText().trim());
            pstC.setString(2, Nombre_cuenta.getText().trim());
            pstC.setString(3, Tipo_cuenta.getText().trim());
            pstC.setString(4, ID_clasificacion.getText().trim());
            pstC.setString(5, Saldo_anterior.getText().trim());
            pstC.setString(6, Cargos_acumulados.getText().trim());
            pstC.setString(7, Abonos_acumulados.getText().trim());
            pstC.setString(8, Saldo_actual.getText().trim());
//            pstC.setString(9, Cargos_acumulados.getText().trim());
//            pstC.setString(10, Abonos_acumulados.getText().trim());
            pstC.setString(9, Descripcion.getText().trim());
           
            pstC.executeUpdate();

            Buscar.setText("");
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");           
            Actualizar_Tabla();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public void Eliminar_CC()
    {
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("delete from cuenta_contable where id_cuenta = ?");

            pst.setString(1, Buscar.getText().trim());
            pst.executeUpdate();

            ID_cuenta.setText("");
            Nombre_cuenta.setText("");
            Tipo_cuenta.setText("");
            ID_clasificacion.setText("");
            Saldo_anterior.setText("");
//            Cargos_mes.setText("");
//            Abonos_mes.setText("");
            Saldo_actual.setText("");
            Cargos_acumulados.setText("");
            Abonos_acumulados.setText("");
            Descripcion.setText("");
            

            JOptionPane.showMessageDialog(null,"Eliminacion Exitosa");
            Actualizar_Tabla(); 
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    
    public DefaultTableModel Buscar_CC(String Buscar)
    {
        String[] nombre_ColumnasCV = {"ID Cuenta", "Nombre Cuenta","Tipo Cuenta","ID Clasificacion","Saldo Anterior","Cargos Acumulados","Abonos Acumulados","Saldo Actual","Descripcion Cuenta"};
        String[] RegistrosCV = new String[9];
        
        DefaultTableModel model = new DefaultTableModel(null,nombre_ColumnasCV);
        
        try
        {
            Connection cn = DriverManager.getConnection(Base_de_Datos,Usuario,Clave);
            PreparedStatement pst = cn.prepareStatement("select * from cuenta_contable WHERE id_cuenta LIKE '%"+Buscar+"%' OR nombre_cuenta LIKE '%"+Buscar+"%'");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                RegistrosCV[0] = rs.getString("id_cuenta");
                RegistrosCV[1] = rs.getString("nombre_cuenta");
                RegistrosCV[2] = rs.getString("tipo_cuenta");
                RegistrosCV[3] = rs.getString("id_clasificacion");
                RegistrosCV[4] = rs.getString("saldo_anterior");
                RegistrosCV[5] = rs.getString("cargos_acumulados");
                RegistrosCV[6] = rs.getString("abonos_acumulados");
                RegistrosCV[7] = rs.getString("saldo_actual");
//                RegistrosCV[8] = rs.getString("cargos_acumulados");
//                RegistrosCV[9] = rs.getString("abonos_acumulados");
                RegistrosCV[8] = rs.getString("descripcion_cuenta");
                   
                
                model.addRow(RegistrosCV);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return model;
    }
    
    public void Buscar_CCF(String Buscar)
    {
        DefaultTableModel model = Buscar_CC(Buscar);
        tbl_cc.setModel(model);
    }
    
    
    
    public void Encontrar_ListaCC(String tablaBD, String nombre,JComboBox boxNombre)
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
    
    
    public void EncontrarID_CC(String ID, String tablaBD, String Nombre,JComboBox boxNombre,JLabel label)
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
    public void BuscarFila_CC(String Nombre,String tablaBD, String ID,JComboBox boxNombre,JLabel labelID){
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
