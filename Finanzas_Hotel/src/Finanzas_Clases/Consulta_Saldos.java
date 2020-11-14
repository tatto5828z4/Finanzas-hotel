package Finanzas_Clases;

import static Finanzas_Clases.Departamento.Base_de_Datos;
import static Finanzas_Clases.Departamento.Clave;
import static Finanzas_Clases.Departamento.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brayan Cifuentes
 */
public class Consulta_Saldos {

    //Atributos
    JTable consulta_Det;
    JTable consulta_Enc;


    public Consulta_Saldos(JTable consulta_Det, JTable consulta_Enc) {
        this.consulta_Det = consulta_Det;
        this.consulta_Enc = consulta_Enc;
    }



    public void Actualizar_Tabla_DET() {
        // int cantidad = Cantidad_Registros();

        String[] Ac_Datos = new String[7];
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select cuenta_contable.id_cuenta, cuenta_contable.nombre_cuenta, cuenta_contable.tipo_cuenta, clasificacion_cuenta.nombre_clasificacion, SUM(mov_bancDet.saldo_deudor) AS \"Saldo Deudor\", SUM(mov_bancDet.saldo_acreedor) AS \"Saldo Acreedor\", SUM(mov_bancDet.saldo_deudor)-SUM(mov_bancDet.saldo_acreedor) AS \"Saldo Resultante\" from cuenta_contable INNER JOIN clasificacion_cuenta ON cuenta_contable.id_clasificacion = clasificacion_cuenta.id_clasificacion INNER JOIN concepto_bancario ON cuenta_contable.id_cuenta = concepto_bancario.id_cuenta INNER JOIN mov_bancDet ON concepto_bancario.codigo_concepto = mov_bancDet.codigo_concepto group by id_cuenta order by id_cuenta asc;");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Cuenta");
            model.addColumn("Nombre Cuenta");
            model.addColumn("Tipo Cuenta");
            model.addColumn("Nombre Clasificacion");
            model.addColumn("Saldo Deudor");
            model.addColumn("Saldo Acreedor");
            model.addColumn("Saldo Resultante");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Ac_Datos[0] = rs.getString(1);
                Ac_Datos[1] = rs.getString(2);
                Ac_Datos[2] = rs.getString(3);
                Ac_Datos[3] = rs.getString(4);
                Ac_Datos[4] = rs.getString(5);
                Ac_Datos[5] = rs.getString(6);
                Ac_Datos[6] = rs.getString(7);

                model.addRow(Ac_Datos);

                consulta_Det.setModel(model);

            }
            //JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            consulta_Det.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void Actualizar_Tabla_ENC() {
        // int cantidad = Cantidad_Registros();

        String[] Ac_Datos = new String[2];
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select tipo_cuenta, SUM(saldo_deudor)-SUM(saldo_acreedor) AS \"Total en la Cuenta\" from cuenta_contable INNER JOIN clasificacion_cuenta ON cuenta_contable.id_clasificacion = clasificacion_cuenta.id_clasificacion INNER JOIN concepto_bancario ON cuenta_contable.id_cuenta = concepto_bancario.id_cuenta INNER JOIN mov_bancDet ON concepto_bancario.codigo_concepto = mov_bancDet.codigo_concepto group by tipo_cuenta;");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Tipo Cuenta");
            model.addColumn("Total en Cuenta");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Ac_Datos[0] = rs.getString(1);
                Ac_Datos[1] = rs.getString(2);

                model.addRow(Ac_Datos);

                consulta_Enc.setModel(model);

            }
            //JOptionPane.showMessageDialog(null, "La cantidad es " + cantidad);
            consulta_Enc.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void Buscar_Saldo_Actual() {
        // int cantidad = Cantidad_Registros();

        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            //Datos
            PreparedStatement pst = cn.prepareStatement("select SUM(mov_bancDet.saldo_deudor)-SUM(mov_bancDet.saldo_acreedor) AS \"Saldo Resultante\" from cuenta_contable INNER JOIN clasificacion_cuenta ON cuenta_contable.id_clasificacion = clasificacion_cuenta.id_clasificacion INNER JOIN concepto_bancario ON cuenta_contable.id_cuenta = concepto_bancario.id_cuenta INNER JOIN mov_bancDet ON concepto_bancario.codigo_concepto = mov_bancDet.codigo_concepto group by cuenta_contable.id_cuenta order by cuenta_contable.id_cuenta asc;");
            ResultSet rs = pst.executeQuery();

            //ID
            PreparedStatement pst3 = cn.prepareStatement("select cuenta_contable.id_cuenta from cuenta_contable INNER JOIN clasificacion_cuenta ON cuenta_contable.id_clasificacion = clasificacion_cuenta.id_clasificacion INNER JOIN concepto_bancario ON cuenta_contable.id_cuenta = concepto_bancario.id_cuenta INNER JOIN mov_bancDet ON concepto_bancario.codigo_concepto = mov_bancDet.codigo_concepto group by cuenta_contable.id_cuenta order by cuenta_contable.id_cuenta asc;");
            ResultSet rs3 = pst3.executeQuery();

            DefaultTableModel model = (DefaultTableModel) consulta_Det.getModel();
            int filas = model.getRowCount();

            float vector[] = new float[filas];
            float ID[] = new float[filas];

            //Totales
            int i = 0;
            while (rs.next()) {
                if (i < filas) {
                    vector[i] = Integer.parseInt(rs.getString(1));
                } else {
                    break;
                }

                i++;
            }

            //ID
            int j = 0;

            while (rs3.next()) {
                if (j < filas) {
                    ID[j] = Integer.parseInt(rs3.getString(1));
                } else {
                    break;
                }

                j++;
            }

//            System.out.println("Filas = " + filas);
//
//            for (int z = 0; z < filas; z++) {
//                System.out.println(vector[z]);
//            }
//            System.out.println("");
//
//            for (int k = 0; k < filas; k++) {
//                System.out.println(ID[k]);
//            }
//            
//            System.out.println("Longitudes");
//            System.out.println("Vector: "+vector.length);
//            System.out.println("ID: "+ID.length);
            
            
            // Actualizar
            for (int l = 0; ((l < vector.length) && (l<ID.length)); l++) {

                    PreparedStatement pst2 = cn.prepareStatement("update cuenta_contable set saldo_actual ="+vector[l]+" where id_cuenta="+ID[l]);
                    pst2.executeUpdate();
            }

            

        } catch (Exception e) {
            System.out.println(e);
        }
     
    }
    
    public void Buscar_Saldo_Deudor()
    {
        try {
            
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            //Datos
            PreparedStatement pst = cn.prepareStatement("select  SUM(mov_bancDet.saldo_deudor) from cuenta_contable INNER JOIN concepto_bancario ON cuenta_contable.id_cuenta = concepto_bancario.id_cuenta INNER JOIN mov_bancDet ON concepto_bancario.codigo_concepto = mov_bancDet.codigo_concepto group by cuenta_contable.id_cuenta order by cuenta_contable.id_cuenta asc;");
            ResultSet rs = pst.executeQuery();

            //ID
            PreparedStatement pst3 = cn.prepareStatement("select cuenta_contable.id_cuenta from cuenta_contable INNER JOIN clasificacion_cuenta ON cuenta_contable.id_clasificacion = clasificacion_cuenta.id_clasificacion INNER JOIN concepto_bancario ON cuenta_contable.id_cuenta = concepto_bancario.id_cuenta INNER JOIN mov_bancDet ON concepto_bancario.codigo_concepto = mov_bancDet.codigo_concepto group by cuenta_contable.id_cuenta order by cuenta_contable.id_cuenta asc;");
            ResultSet rs3 = pst3.executeQuery();

            DefaultTableModel model = (DefaultTableModel) consulta_Det.getModel();
            int filas = model.getRowCount();

            float vector[] = new float[filas];
            float ID[] = new float[filas];

            //Totales
            int i = 0;
            while (rs.next()) {
                if (i < filas) {
                    vector[i] = Integer.parseInt(rs.getString(1));
                } else {
                    break;
                }

                i++;
            }

            //ID
            int j = 0;

            while (rs3.next()) {
                if (j < filas) {
                    ID[j] = Integer.parseInt(rs3.getString(1));
                } else {
                    break;
                }

                j++;
            }
            
            
            // Actualizar
            for (int l = 0; ((l < vector.length) && (l<ID.length)); l++) {

                    PreparedStatement pst2 = cn.prepareStatement("update cuenta_contable set cargos_acumulados ="+vector[l]+" where id_cuenta="+ID[l]);
                    pst2.executeUpdate();
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public void Buscar_Saldo_Acreedor()
    {
        try {
            
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            //Datos
            PreparedStatement pst = cn.prepareStatement("select SUM(mov_bancDet.saldo_acreedor) from cuenta_contable INNER JOIN concepto_bancario ON cuenta_contable.id_cuenta = concepto_bancario.id_cuenta INNER JOIN mov_bancDet ON concepto_bancario.codigo_concepto = mov_bancDet.codigo_concepto group by cuenta_contable.id_cuenta order by cuenta_contable.id_cuenta asc;");
            ResultSet rs = pst.executeQuery();

            //ID
            PreparedStatement pst3 = cn.prepareStatement("select cuenta_contable.id_cuenta from cuenta_contable INNER JOIN clasificacion_cuenta ON cuenta_contable.id_clasificacion = clasificacion_cuenta.id_clasificacion INNER JOIN concepto_bancario ON cuenta_contable.id_cuenta = concepto_bancario.id_cuenta INNER JOIN mov_bancDet ON concepto_bancario.codigo_concepto = mov_bancDet.codigo_concepto group by cuenta_contable.id_cuenta order by cuenta_contable.id_cuenta asc;");
            ResultSet rs3 = pst3.executeQuery();

            //anterior
            PreparedStatement pst5 = cn.prepareStatement("select cuenta_contable.id_cuenta from cuenta_contable INNER JOIN clasificacion_cuenta ON cuenta_contable.id_clasificacion = clasificacion_cuenta.id_clasificacion INNER JOIN concepto_bancario ON cuenta_contable.id_cuenta = concepto_bancario.id_cuenta INNER JOIN mov_bancDet ON concepto_bancario.codigo_concepto = mov_bancDet.codigo_concepto group by cuenta_contable.id_cuenta order by cuenta_contable.id_cuenta asc;");
            ResultSet rs5 = pst5.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) consulta_Det.getModel();
            int filas = model.getRowCount();

            float vector[] = new float[filas];
            float ID[] = new float[filas];

            //Totales
            int i = 0;
            while (rs.next()) {
                if (i < filas) {
                    vector[i] = Integer.parseInt(rs.getString(1));
                } else {
                    break;
                }

                i++;
            }

            //ID
            int j = 0;

            while (rs3.next()) {
                if (j < filas) {
                    ID[j] = Integer.parseInt(rs3.getString(1));
                } else {
                    break;
                }

                j++;
            }
            
            
            // Actualizar
            for (int l = 0; ((l < vector.length) && (l<ID.length)); l++) {

                    PreparedStatement pst2 = cn.prepareStatement("update cuenta_contable set abonos_acumulados ="+vector[l]+" where id_cuenta="+ID[l]);
                    pst2.executeUpdate();
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    // trae el saldo actual y lo suma al anterior
    public void Saldo_Anterior()
    {
        try {
            
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            //Datos
            PreparedStatement pst = cn.prepareStatement("select SUM(mov_bancDet.saldo_deudor)-SUM(mov_bancDet.saldo_acreedor) from cuenta_contable INNER JOIN clasificacion_cuenta ON cuenta_contable.id_clasificacion = clasificacion_cuenta.id_clasificacion INNER JOIN concepto_bancario ON cuenta_contable.id_cuenta = concepto_bancario.id_cuenta INNER JOIN mov_bancDet ON concepto_bancario.codigo_concepto = mov_bancDet.codigo_concepto group by cuenta_contable.id_cuenta order by cuenta_contable.id_cuenta asc;");
            ResultSet rs = pst.executeQuery();

            //ID
            PreparedStatement pst3 = cn.prepareStatement("select cuenta_contable.id_cuenta from cuenta_contable INNER JOIN clasificacion_cuenta ON cuenta_contable.id_clasificacion = clasificacion_cuenta.id_clasificacion INNER JOIN concepto_bancario ON cuenta_contable.id_cuenta = concepto_bancario.id_cuenta INNER JOIN mov_bancDet ON concepto_bancario.codigo_concepto = mov_bancDet.codigo_concepto group by cuenta_contable.id_cuenta order by cuenta_contable.id_cuenta asc;");
            ResultSet rs3 = pst3.executeQuery();
            
            //Datos anteriores
            PreparedStatement pst5 = cn.prepareStatement("select saldo_anterior from cuenta_contable INNER JOIN concepto_bancario ON cuenta_contable.id_cuenta = concepto_bancario.id_cuenta INNER JOIN mov_bancDet ON concepto_bancario.codigo_concepto = mov_bancDet.codigo_concepto group by cuenta_contable.id_cuenta order by cuenta_contable.id_cuenta asc;");
            ResultSet rs5 = pst5.executeQuery();

            DefaultTableModel model = (DefaultTableModel) consulta_Det.getModel();
            int filas = model.getRowCount();

            float vector[] = new float[filas];
            float ID[] = new float[filas];
            float saldo_anterior[] = new float[filas];
            float suma_total[] = new float [filas];

            
            //Saldo Resultante 
            int i = 0;
            while (rs.next()) {
                if (i < filas) {
                    vector[i] = Float.parseFloat(rs.getString(1));
                } else {
                    break;
                }

                i++;
            }

            //ID
            int j = 0;
            while (rs3.next()) {
                if (j < filas) {
                    ID[j] = Float.parseFloat(rs3.getString(1));
                } else {
                    break;
                }

                j++;
            }
            
            //Tomando valores de saldos anteriores  
            int b = 0;
            while (rs5.next()) {
                if (b < filas) {
                    saldo_anterior[b] = Float.parseFloat(rs5.getString(1));
                } else {
                    break;
                }

                b++;
            }
            
            
//            for (int k = 0; k < filas; k++) {
//                System.out.println(saldo_anterior[k]);
//            }
            
        
            for (int k = 0; k < filas; k++) {
                System.out.println(vector[k]);
            }
            System.out.println("");
            
            //Suma de anterior + el actual 
            for (int k = 0; k < filas; k++) 
            {
                suma_total[k] = vector[k]+saldo_anterior[k];
                System.out.println(suma_total[k]+ " valor ");
            }
           
            
           
            
            int valor_inicial=0;
            // Actualizar el saldo resultante al saldo anterior
            for (int l = 0; ((l < vector.length) && (l<ID.length) && (l<suma_total.length)); l++) {

                    PreparedStatement pst2 = cn.prepareStatement("update cuenta_contable set cuenta_contable.saldo_anterior="+suma_total[l]+", cuenta_contable.cargos_acumulados="+valor_inicial+", cuenta_contable.abonos_acumulados="+valor_inicial+", cuenta_contable.saldo_actual="+valor_inicial+" where id_cuenta = "+ID[l]);
                    pst2.executeUpdate();
            }
            
            
            //volviendo vector a cero 
//            for (int k = 0; k < filas; k++) {
//                suma[k]=0;
//            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    
//    public void Sumador(){
//        
//        try {
//
//            DefaultTableModel model = (DefaultTableModel) tabla_cuenta.getModel();
//            int filas = model.getRowCount();
//            
//            float saldo_anterior[] = new float [filas];
//            float valores[] = new float [filas];
//            float suma[]= new float[filas];
//            float ID[]= new float[filas];
//            
//            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
//            
//            //Totales
//            PreparedStatement pst = cn.prepareStatement("select saldo_anterior from cuenta_contable INNER JOIN concepto_bancario ON cuenta_contable.id_cuenta = concepto_bancario.id_cuenta INNER JOIN mov_bancDet ON concepto_bancario.codigo_concepto = mov_bancDet.codigo_concepto group by cuenta_contable.id_cuenta order by cuenta_contable.id_cuenta asc;");
//            ResultSet rs = pst.executeQuery();
//            
//            //ID
//            
//            PreparedStatement pst3 = cn.prepareStatement("select cuenta_contable.id_cuenta from cuenta_contable INNER JOIN clasificacion_cuenta ON cuenta_contable.id_clasificacion = clasificacion_cuenta.id_clasificacion INNER JOIN concepto_bancario ON cuenta_contable.id_cuenta = concepto_bancario.id_cuenta INNER JOIN mov_bancDet ON concepto_bancario.codigo_concepto = mov_bancDet.codigo_concepto group by cuenta_contable.id_cuenta order by cuenta_contable.id_cuenta asc;");
//            ResultSet rs3 = pst3.executeQuery();
//            
//            //Tomando valores de saldos anteriores 
//            int b = 0;
//            while (rs.next()) {
//                if (b < filas) {
//                    saldo_anterior[b] = Float.parseFloat(rs.getString(1));
//                } else {
//                    break;
//                }
//
//                b++;
//            }
//            
//            //obteniendo los datos de la 4 columna de la tabla 
//            for (int i = 0; i < filas; i++) {
//                valores[i]= Float.parseFloat((String)tabla_cuenta.getValueAt(i, 4));
//            }
//            
//            //suma de valores
//            for (int i = 0; i < filas; i++) {
//                suma[i]=valores[i] +saldo_anterior[i];
//            }
//            
//            //ID
//            int j = 0;
//            while (rs3.next()) {
//                if (j < filas) {
//                    ID[j] = Float.parseFloat(rs3.getString(1));
//                } else {
//                    break;
//                }
//
//                j++;
//            }
//            
//            //actualizar el valor 
//             int valor_inicial=0;
//            for (int l = 0; ((l < saldo_anterior.length) && (l<valores.length) && (l<suma.length)); l++) {
//
//                    PreparedStatement pst2 = cn.prepareStatement("update cuenta_contable set cuenta_contable.saldo_anterior="+suma[l]+", cuenta_contable.cargos_acumulados="+valor_inicial+", cuenta_contable.abonos_acumulados="+valor_inicial+", cuenta_contable.saldo_actual="+valor_inicial+" where id_cuenta = "+ID[l]);
//                    pst2.executeUpdate();
//            }
//            
//            
//            // volviendo a cero 
//            for (int i = 0; i < filas; i++) {
//                saldo_anterior[i] = 0;
//                valores[i] = 0;
//                suma[i]= 0;
//                ID[i]= 0;
//            }
//            
//            
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//    
////    public float Sumar(float n1[], float n2[], int cantidad){
////        
////        float suma[] = new float[cantidad];
////        
////        for (int i = 0; i < cantidad; i++) {
////            suma[i]=n1[i]+n2[i];
////        }
////        
////        return suma[cantidad];
////    }
}
