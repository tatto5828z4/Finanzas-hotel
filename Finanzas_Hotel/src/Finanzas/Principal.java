/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas;

import Animaciones.Animaciones;
import Animaciones.Animaciones;
import Animaciones.Animaciones;
import AppPackage.AnimationClass;
import Finanzas_Clases.Actividad;
import Finanzas_Clases.Actividad_Empleado;
import Finanzas_Clases.Aplicacion;
import Finanzas_Clases.Aplicacion_Prueba;
import Finanzas_Clases.Contratacion;
import Finanzas_Clases.Curriculum;
import Finanzas_Clases.Departamento;
import Finanzas_Clases.Empleado_Contratado;
import Finanzas_Clases.Experiencia_Laboral;
import Finanzas_Clases.Experiencia_Laboral_Detallada;
import Finanzas_Clases.Medio;
import Finanzas_Clases.Nivel_Academico;
import Finanzas_Clases.Periodo_Prueba;
import Finanzas_Clases.Puesto;
import Finanzas_Clases.Referencias_Laborales;
import Finanzas_Clases.Referencias_Personales;
import Finanzas_Clases.Seleccion;
import Finanzas_Clases.Solicitud_Empresarial;
import Finanzas_Clases.Tipo_Prueba;
import Finanzas_Clases.Bitacora_Empleado;
import static Finanzas_Clases.Departamento.Base_de_Datos;
import static Finanzas_Clases.Departamento.Usuario;
import static Finanzas_Clases.Departamento.Clave;
import Ventanas_Tablas.Actividad_V;
import Ventanas_Tablas.Aplicacion_V;
import Ventanas_Tablas.Curriculum_V;
import Ventanas_Tablas.Departamento_V;
import Ventanas_Tablas.ExpLD_V;
import Ventanas_Tablas.Experiencia_Laboral_Ve;
import Ventanas_Tablas.Medio_Ve;
import Ventanas_Tablas.Solicitud_Empresarial_V;
import Ventanas_Tablas.Nivel_Academico_Ve;
import Ventanas_Tablas.TipoPrueba_V;
import Ventanas_Tablas.Puesto_V;
import Ventanas_Tablas.Referencias_Laborales_V;
import Ventanas_Tablas.Referencias_Personales_V;
import Ventanas_Tablas.AplicacionPrueba_V;
import Ventanas_Tablas.Contratacion_V;
import Ventanas_Tablas.EmpleadoC_V;
import Ventanas_Tablas.Periodo_Prueba_V;
import Ventanas_Tablas.Seleccion_V;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Langas
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    //Textos para buscar combobox en tablas
    public static String S_ExpLD = "Experiencia Laboral Detallada";
    public static String Item = "";

    public static String S_Puesto = "Puesto";
    public static String Item_P = "";

    public static String S_Departamento = "Departamento";
    public static String Item_D = "";

    public static String S_NA = "Nivel Academico";
    public static String Item_NA = "";

    public static String S_EL = "Experiencia Laboral";
    public static String Item_EL = "";

    public static String S_Emp = "Solicitud Empresarial";
    public static String Item_SE = "";

    public static String S_RP = "Referencias Personales";
    public static String Item_RP;

    public static String S_RL = "Referencias Laborales";
    public static String Item_RL;

    public static String S_Med = "Medio";
    public static String Item_Med;

    public static String S_DPI = "DPI";
    public static String Item_DPI = "";

    public static String S_Prueba = "Tipo Prueba";
    public static String Item_Prueba = "";

    public static String S_Aplicacion = "Aplicacion";
    public static String Item_Aplicacion = "";

    public static String S_Seleccion = "Seleccion";
    public static String Item_Seleccion = "";

    public static String S_PeriodoP = "Periodo Prueba";
    public static String Item_Periodop = "";

    public static String S_Actividad = "Actividad";
    public static String Item_Actividad = "";
    
    public static String S_Contratacion = "Contratacion";
    public static String Item_Contratacion = "";
    
    public static String S_EC = "Empleado Contratado";
    public static String Item_EC = "";

    public Principal() {

        initComponents();

        ExpLD.setVisible(false);
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD1.setVisible(false);
        Departamento1.setVisible(false);
        Puesto1.setVisible(false);
        Nivel_Academico2.setVisible(false);
        SE.setVisible(false);
        RL.setVisible(false);
        ExpL.setVisible(false);
        Medio.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);

        //Paneles Mantenimientos
        Mantenimiento_D.setVisible(false);
        jPanel_MantenimientosP.setVisible(false);
        jPanel_MantenimientoNA.setVisible(false);
        jPanel_MantenimientoExpLD.setVisible(false);
        jPanel_MantenimientoExpL.setVisible(false);
        jPanel_MantenimientoSE.setVisible(false);
        jPanel_Mantenimiento_Medio.setVisible(false);
        jPanel_MantenimientoRL.setVisible(false);
        jPanel_MantenimientosRP.setVisible(false);
        jPanel_MantenimientoCV.setVisible(false);
        jPanel_Tipo_Prueba.setVisible(false);
        jPanel_MantenimientoAP.setVisible(false);
        jPanel_MantenimientoAPP.setVisible(false);
        jPanel_MantenimientoS.setVisible(false);
        jPanel_MantenimientoA.setVisible(false);
        jPanel_MantenimientoPP.setVisible(false);
        jPanel_MantenimientoC.setVisible(false);
        jPanel_MantenimientoEC.setVisible(false);
        jPanel_MantenimientoAE.setVisible(false);
        jPanel_MantenimientoBE.setVisible(false);

        //Labels Departamento Ingresar - Modificar - Eliminar
        jLabel_ModificarD.setVisible(false);
        jLabel_EliminarD.setVisible(false);

        //Labels Puesto Ingresar - Modificar - Eliminar
        jLabel_Modificar_Puesto.setVisible(false);
        jLabel_Eliminar_Puesto.setVisible(false);

        //Labels Nivel Academico Ingresar - Modificar - Eliminar
        jLabel_Eliminar_NivelA.setVisible(false);
        jLabel_Modificar_NivelA.setVisible(false);

        //Labels Experiencia Laboral Detallada Ingresar - Modificar - Eliminar
        jLabel_Modificar_ExpLD.setVisible(false);
        jLabel_Eliminar_ExpLD.setVisible(false);

        //Labels Experiencia Laboral  Ingresar - Modificar - Eliminar
        jLabel_Modificar_ExpL.setVisible(false);
        jLabel_Eliminar_ExpL.setVisible(false);

        //Labels Solicitud Empresarial  Ingresar - Modificar - Eliminar
        jLabel_Modificar_SE.setVisible(false);
        jLabel_Eliminar_SE.setVisible(false);

        //Labels Medio Ingesar -Modificar - Eliminar
        jLabel_ModificarM.setVisible(false);
        jLabel_EliminarM.setVisible(false);

        jLabel_ModificarRL.setVisible(false);
        jLabel_EliminarRL.setVisible(false);

        //Labels medio ingresar y modificar y eliminar
        jLabel_Modificar_RP.setVisible(false);
        jLabel_Eliminar_RP.setVisible(false);

        //LABELS CV ingresar mod y eli
        jLabel_Modificar_CV.setVisible(false);
        jLabel_Eliminar_CV.setVisible(false);

        //Labels Aplicacion Ingresar-Modificar-Eliminar
        jLabel_Modificar_AP.setVisible(false);
        jLabel_Eliminar_AP.setVisible(false);

        //labels tipo prueba Ingresar-Modificar-eliminar
        jLabel_Modificar_TP.setVisible(false);
        jLabel_Eliminar_TP.setVisible(false);

        //Labels Aplicacion Prueba  Ingresar - Modificar - Eliminar
        jLabel_ModificarAPP.setVisible(false);
        jLabel_Eliminar_APP.setVisible(false);

        //Labels Seleccion Modificar - Eliminar
        jLabel_ModificarS.setVisible(false);
        jLabel_EliminarS.setVisible(false);

        //Labels Aplicacion Prueba  Ingresar - Modificar - Eliminar
        jLabel_Modificar_Ac.setVisible(false);
        jLabel_Eliminar_Ac.setVisible(false);

        //Label Periodo Prueba Ingresar-Modificar-Eliminar
        jLabel_Modificar_PP.setVisible(false);
        jLabel_Eliminar_PP.setVisible(false);

        //Label Contratacion Eliminar - Modificar
        jLabel_Modificar_C.setVisible(false);
        jLabel_Eliminar_C.setVisible(false);

        //Label Empleado Contatado Ingresar-Modificar-Eliminar
        jLabel_Modificar_EC.setVisible(false);
        jLabel_Eliminar_EC.setVisible(false);
        
        //Labels Actividad Empleado  Ingresar - Modificar - Eliminar
        jLabel_Modificar_AE.setVisible(false);
        jLabel_Eliminar_AE.setVisible(false);
        
        
        // bitacora
        jTextField_Encontraid.setVisible(false);
        txt_contra.setVisible(false);
        txt_puesto.setVisible(false);
        txt_depa.setVisible(false);
        txt_peri.setVisible(false);
        txt_selec.setVisible(false);
        txt_ap.setVisible(false);
        txt_idap.setVisible(false);
        txt_dpi.setVisible(false);
    }

    /*public void tiempo(JLabel Logo, JLabel Logo1,JLabel Logo2,JLabel Logo3,int tiempoC)
    {

        al = new ActionListener()
        {
        @Override
        public void actionPerformed(ActionEvent ae)
        {   

                Logo.setVisible(true);
                Logo1.setVisible(false);
                Logo2.setVisible(false);
                Logo3.setVisible(false);
        }
        };
    
        t = new Timer(tiempoC,al);
        
        if(!t.isRunning())
        {
            t.start();
        }
    }
    
    public void tiempo_2(JLabel Seleccionar)
    {
        while(m < 100)
        {
            m++;
            
            if(m == 100)
            {
                System.out.println("entre");
                Seleccionar.setVisible(false);
            }
        }
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_MantenimientoBE = new javax.swing.JPanel();
        jLabel_TituloAE1 = new javax.swing.JLabel();
        jLabel_Buscar_BE = new javax.swing.JLabel();
        txt_Buscar_BE = new javax.swing.JTextField();
        jScrollPane40 = new javax.swing.JScrollPane();
        tbl_BE = new javax.swing.JTable();
        jTextField_Encontraid = new javax.swing.JTextField();
        txt_contra = new javax.swing.JTextField();
        txt_puesto = new javax.swing.JTextField();
        txt_depa = new javax.swing.JTextField();
        txt_peri = new javax.swing.JTextField();
        txt_selec = new javax.swing.JTextField();
        txt_ap = new javax.swing.JTextField();
        txt_idap = new javax.swing.JTextField();
        txt_dpi = new javax.swing.JTextField();
        jPanel_MantenimientoAE = new javax.swing.JPanel();
        jLabel_AE_EC = new javax.swing.JLabel();
        jLabel_AE_ECC = new javax.swing.JLabel();
        jComboBox_AE_EC = new javax.swing.JComboBox<>();
        jLabel_Actividad_AE = new javax.swing.JLabel();
        jLabel_Actividad_AEE = new javax.swing.JLabel();
        jComboBox_Actividad_AE = new javax.swing.JComboBox<>();
        jLabel_Insertar_AE = new javax.swing.JLabel();
        jLabel_Modificar_AE = new javax.swing.JLabel();
        jLabel_Eliminar_AE = new javax.swing.JLabel();
        jLabel_BuscarAE = new javax.swing.JLabel();
        txt_BuscarAE = new javax.swing.JTextField();
        jScrollPane39 = new javax.swing.JScrollPane();
        tbl_AE = new javax.swing.JTable();
        jLabel_TituloAE = new javax.swing.JLabel();
        Panel_IngresarAE = new javax.swing.JPanel();
        Texto_IngresarAE = new javax.swing.JLabel();
        Panel_ModificarAE = new javax.swing.JPanel();
        Texto_ModificarAE = new javax.swing.JLabel();
        Panel_EliminarAE = new javax.swing.JPanel();
        Texto_EliminarAE = new javax.swing.JLabel();
        Panel_ConsultarAE = new javax.swing.JPanel();
        Texto_ConsultarAE = new javax.swing.JLabel();
        jComboBox_TablasAE = new javax.swing.JComboBox<>();
        jLabel_Buscar_TablasAE = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel_MantenimientoEC = new javax.swing.JPanel();
        jLabel_ID_EC = new javax.swing.JLabel();
        txt_id_EC = new javax.swing.JTextField();
        jLabel_CEC = new javax.swing.JLabel();
        jLabel_CECC = new javax.swing.JLabel();
        jComboBox_CEC = new javax.swing.JComboBox<>();
        jLabel_ECP = new javax.swing.JLabel();
        jLabel_ECPP = new javax.swing.JLabel();
        jComboBox_ECP = new javax.swing.JComboBox<>();
        jLabel_ECD = new javax.swing.JLabel();
        jLabel_ECDD = new javax.swing.JLabel();
        jComboBox_ECD = new javax.swing.JComboBox<>();
        jLabe_SEC = new javax.swing.JLabel();
        txt_SEC = new javax.swing.JTextField();
        jLabel_IngresarEC = new javax.swing.JLabel();
        jLabel_Modificar_EC = new javax.swing.JLabel();
        jLabel_Eliminar_EC = new javax.swing.JLabel();
        jLabel_BuscarEC = new javax.swing.JLabel();
        txt_BuscarEC = new javax.swing.JTextField();
        jScrollPane38 = new javax.swing.JScrollPane();
        tbl_EC = new javax.swing.JTable();
        jLabel_TituloEC = new javax.swing.JLabel();
        Panel_Ingresar_EC = new javax.swing.JPanel();
        Texto_Ingresar_EC = new javax.swing.JLabel();
        Panel_Modificar_EC = new javax.swing.JPanel();
        Texto_Modificar_EC = new javax.swing.JLabel();
        Panel_Eliminar_EC = new javax.swing.JPanel();
        Texto_Eliminar_EC = new javax.swing.JLabel();
        Panel_Consultar_EC = new javax.swing.JPanel();
        Texto_Consultar_EC = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox_TablasEC = new javax.swing.JComboBox<>();
        jLabel_Buscar_TablasEC = new javax.swing.JLabel();
        jPanel_MantenimientoC = new javax.swing.JPanel();
        txt_id_C = new javax.swing.JTextField();
        jLabel_ID_C = new javax.swing.JLabel();
        jLabel_PPC = new javax.swing.JLabel();
        jLabel_PPCC = new javax.swing.JLabel();
        jComboBox_PPC = new javax.swing.JComboBox<>();
        txt_FC = new javax.swing.JTextField();
        jLabel_FC = new javax.swing.JLabel();
        txt_DC = new javax.swing.JTextField();
        jLabel_DC = new javax.swing.JLabel();
        txt_EC = new javax.swing.JTextField();
        jLabel_EC = new javax.swing.JLabel();
        jLabel_InsertarC = new javax.swing.JLabel();
        jLabel_Modificar_C = new javax.swing.JLabel();
        jLabel_Eliminar_C = new javax.swing.JLabel();
        jLabel_Buscar_C = new javax.swing.JLabel();
        txt_Buscar_C = new javax.swing.JTextField();
        jScrollPane37 = new javax.swing.JScrollPane();
        tbl_C = new javax.swing.JTable();
        jLabel_TituloPP1 = new javax.swing.JLabel();
        Panel_Ingresar_PP1 = new javax.swing.JPanel();
        Texto_Ingresar_PP1 = new javax.swing.JLabel();
        Panel_Modificar_PP1 = new javax.swing.JPanel();
        Texto_Modificar_PP1 = new javax.swing.JLabel();
        Panel_Eliminar_PP1 = new javax.swing.JPanel();
        Texto_Eliminar_PP1 = new javax.swing.JLabel();
        Panel_Consultar_PP1 = new javax.swing.JPanel();
        Texto_Consultar_PP1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox_TablasC = new javax.swing.JComboBox<>();
        jLabel_Buscar_TablasC = new javax.swing.JLabel();
        jPanel_MantenimientoPP = new javax.swing.JPanel();
        jLabel_ID_PP = new javax.swing.JLabel();
        txt_id_PP = new javax.swing.JTextField();
        jLabel_PPS = new javax.swing.JLabel();
        jLabel_PPSE = new javax.swing.JLabel();
        jComboBox_PPS = new javax.swing.JComboBox<>();
        jLabel_FI = new javax.swing.JLabel();
        txt_id_FI = new javax.swing.JTextField();
        jLabel_FF = new javax.swing.JLabel();
        txt_id_FF = new javax.swing.JTextField();
        jLabel_Pago = new javax.swing.JLabel();
        txt_id_Pago = new javax.swing.JTextField();
        jLabel_PPA = new javax.swing.JLabel();
        jComboBox_PPA = new javax.swing.JComboBox<>();
        jLabel_PPAA = new javax.swing.JLabel();
        jLabel_IngresarPP = new javax.swing.JLabel();
        jLabel_Modificar_PP = new javax.swing.JLabel();
        jLabel_Eliminar_PP = new javax.swing.JLabel();
        jLabel_BuscarPP = new javax.swing.JLabel();
        txt_BuscarPP = new javax.swing.JTextField();
        jScrollPane36 = new javax.swing.JScrollPane();
        tbl_PP = new javax.swing.JTable();
        jLabel_TituloPP = new javax.swing.JLabel();
        Panel_Ingresar_PP = new javax.swing.JPanel();
        Texto_Ingresar_PP = new javax.swing.JLabel();
        Panel_Modificar_PP = new javax.swing.JPanel();
        Texto_Modificar_PP = new javax.swing.JLabel();
        Panel_Eliminar_PP = new javax.swing.JPanel();
        Texto_Eliminar_PP = new javax.swing.JLabel();
        Panel_Consultar_PP = new javax.swing.JPanel();
        Texto_Consultar_PP = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox_TablasPP = new javax.swing.JComboBox<>();
        jLabel_Buscar_TablasPP = new javax.swing.JLabel();
        jPanel_MantenimientoA = new javax.swing.JPanel();
        jLabel_ID_A = new javax.swing.JLabel();
        txt_id_A = new javax.swing.JTextField();
        jLabel_TA = new javax.swing.JLabel();
        txt_TA = new javax.swing.JTextField();
        jLabel_DescripcionA = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea_DescripcionA = new javax.swing.JTextArea();
        jLabel_Insertar_A = new javax.swing.JLabel();
        jLabel_Modificar_Ac = new javax.swing.JLabel();
        jLabel_Eliminar_Ac = new javax.swing.JLabel();
        jLabel_BuscarA = new javax.swing.JLabel();
        txt_BuscarA = new javax.swing.JTextField();
        jScrollPane35 = new javax.swing.JScrollPane();
        tbl_A = new javax.swing.JTable();
        jLabel_TituloAPP2 = new javax.swing.JLabel();
        Panel_Ingresar_Actividad = new javax.swing.JPanel();
        Texto_Ingresar_Actividad = new javax.swing.JLabel();
        Panel_Modificar_Actividad = new javax.swing.JPanel();
        Texto_Modificar_Actividad = new javax.swing.JLabel();
        Panel_Eliminar_Actividad = new javax.swing.JPanel();
        Texto_Eliminar_Actividad = new javax.swing.JLabel();
        Panel_Consultar_Actividad = new javax.swing.JPanel();
        Texto_Consultar_Actividad = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel_MantenimientoS = new javax.swing.JPanel();
        jLabel_IDS = new javax.swing.JLabel();
        txt_idS = new javax.swing.JTextField();
        jLabel_APPS = new javax.swing.JLabel();
        jComboBox_APPS = new javax.swing.JComboBox<>();
        jLabel_RL_APPS = new javax.swing.JLabel();
        jLabel_EstatusS = new javax.swing.JLabel();
        txt_EstatusS = new javax.swing.JTextField();
        jLabel_InsertarS = new javax.swing.JLabel();
        jLabel_ModificarS = new javax.swing.JLabel();
        jLabel_EliminarS = new javax.swing.JLabel();
        jLabel_BuscarS = new javax.swing.JLabel();
        txt_BuscarS = new javax.swing.JTextField();
        jScrollPane34 = new javax.swing.JScrollPane();
        tbl_S = new javax.swing.JTable();
        jLabel_TituloAPP1 = new javax.swing.JLabel();
        Panel_IngresarS = new javax.swing.JPanel();
        Texto_IngresarS = new javax.swing.JLabel();
        Panel_ModificarS = new javax.swing.JPanel();
        Texto_ModificarS = new javax.swing.JLabel();
        Panel_EliminarS = new javax.swing.JPanel();
        Texto_EliminarS = new javax.swing.JLabel();
        Panel_ConsultarS = new javax.swing.JPanel();
        Texto_ConsultarS = new javax.swing.JLabel();
        lbl_BuscarS = new javax.swing.JLabel();
        jComboBox_TablasB_S = new javax.swing.JComboBox<>();
        jLabel_Buscar_TablasS = new javax.swing.JLabel();
        jPanel_MantenimientoAPP = new javax.swing.JPanel();
        jLabel_ID_APP = new javax.swing.JLabel();
        txt_id_APP = new javax.swing.JTextField();
        jLabel_PruebaAPP = new javax.swing.JLabel();
        jLabel_Prueba_APP = new javax.swing.JLabel();
        jComboBox_PruebaAPP = new javax.swing.JComboBox<>();
        jLabel_AplicacionAPP = new javax.swing.JLabel();
        jLabel_Aplicacion_APP = new javax.swing.JLabel();
        jComboBox_AplicacionAPP = new javax.swing.JComboBox<>();
        jLabel_EstatusAPP = new javax.swing.JLabel();
        txt_AplicacionAPP = new javax.swing.JTextField();
        jLabel_Ingresar_APP = new javax.swing.JLabel();
        jLabel_ModificarAPP = new javax.swing.JLabel();
        jLabel_Eliminar_APP = new javax.swing.JLabel();
        jLabel_Buscar_APP = new javax.swing.JLabel();
        txt_Buscar_APP = new javax.swing.JTextField();
        jScrollPane33 = new javax.swing.JScrollPane();
        tbl_APP = new javax.swing.JTable();
        jLabel_TituloAPP = new javax.swing.JLabel();
        Panel_IngresarAPP = new javax.swing.JPanel();
        Texto_IngresarAPP = new javax.swing.JLabel();
        Panel_ModificarAPP = new javax.swing.JPanel();
        Texto_ModificarAPP = new javax.swing.JLabel();
        Panel_EliminarAPP = new javax.swing.JPanel();
        Texto_EliminarAPP = new javax.swing.JLabel();
        Panel_ConsultarAPP = new javax.swing.JPanel();
        Texto_ConsultarAPP = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_TablasB_APP = new javax.swing.JComboBox<>();
        jLabel_Buscar_TablasAPP = new javax.swing.JLabel();
        jPanel_Tipo_Prueba = new javax.swing.JPanel();
        jLabel_Prueba = new javax.swing.JLabel();
        txt_id_TP = new javax.swing.JTextField();
        jLabel_DPIAP1 = new javax.swing.JLabel();
        jLabel_TP = new javax.swing.JLabel();
        txt_TP = new javax.swing.JTextField();
        jLabel_IngresarTP = new javax.swing.JLabel();
        jLabel_Modificar_TP = new javax.swing.JLabel();
        jLabel_Eliminar_TP = new javax.swing.JLabel();
        jScrollPane32 = new javax.swing.JScrollPane();
        tbl_TP = new javax.swing.JTable();
        txt_BuscarTP = new javax.swing.JTextField();
        jLabel_BuscarTP = new javax.swing.JLabel();
        jLabel_TituloELD1 = new javax.swing.JLabel();
        Panel_IngresarTP = new javax.swing.JPanel();
        Texto_IngresarTp = new javax.swing.JLabel();
        Panel_ModificarTP = new javax.swing.JPanel();
        Texto_Modificartp = new javax.swing.JLabel();
        Panel_EliminarTP = new javax.swing.JPanel();
        Texto_EliminarTP = new javax.swing.JLabel();
        Panel_ConsultarTP = new javax.swing.JPanel();
        Texto_ConsultarTP = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel_MantenimientoAP = new javax.swing.JPanel();
        txt_id_AP = new javax.swing.JTextField();
        jLabel_ID_AP = new javax.swing.JLabel();
        jLabel_DPIAP = new javax.swing.JLabel();
        jComboBox_DPIAP = new javax.swing.JComboBox<>();
        txt_RequisitosAP = new javax.swing.JTextField();
        jLabel_RequisitosAP = new javax.swing.JLabel();
        jLabel_IngresarAP = new javax.swing.JLabel();
        jLabel_Modificar_AP = new javax.swing.JLabel();
        jLabel_Eliminar_AP = new javax.swing.JLabel();
        jScrollPane31 = new javax.swing.JScrollPane();
        tbl_AP = new javax.swing.JTable();
        txt_BuscarAP = new javax.swing.JTextField();
        jLabel_BuscarAP = new javax.swing.JLabel();
        jLabel_DPI_AP = new javax.swing.JLabel();
        jLabel_NombreAP = new javax.swing.JLabel();
        jLabel_TituloAP = new javax.swing.JLabel();
        Panel_IngresarAP = new javax.swing.JPanel();
        Texto_IngresarAP = new javax.swing.JLabel();
        Panel_ModificarAP = new javax.swing.JPanel();
        Texto_ModificarAP = new javax.swing.JLabel();
        Panel_EliminarAP = new javax.swing.JPanel();
        Texto_EliminarAP = new javax.swing.JLabel();
        Panel_ConsultarAP = new javax.swing.JPanel();
        Texto_ConsultarAP = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox_TablasAP = new javax.swing.JComboBox<>();
        jLabel_Buscar_Tablas_M2 = new javax.swing.JLabel();
        jPanel_MantenimientoCV = new javax.swing.JPanel();
        jLabel_DPICV = new javax.swing.JLabel();
        txt_DPICV = new javax.swing.JTextField();
        jLabel_NombreCV = new javax.swing.JLabel();
        txt_NombreCV = new javax.swing.JTextField();
        jLabel_ApellidoCV = new javax.swing.JLabel();
        txt_ApellidoCV = new javax.swing.JTextField();
        jLabel_TelefonoCV = new javax.swing.JLabel();
        txt_TelefonoCV = new javax.swing.JTextField();
        jLabel_CorreoCV = new javax.swing.JLabel();
        txt_CorreoCV = new javax.swing.JTextField();
        jLabel_DireccionCV = new javax.swing.JLabel();
        txt_DireccionCV = new javax.swing.JTextField();
        jLabel_GeneroCV = new javax.swing.JLabel();
        txt_GeneroCV = new javax.swing.JTextField();
        jLabel_EdadCV = new javax.swing.JLabel();
        txt_EdadCV = new javax.swing.JTextField();
        jLabel_NivelACV = new javax.swing.JLabel();
        jComboBox_NivelACV = new javax.swing.JComboBox<>();
        jLabel_RPCV = new javax.swing.JLabel();
        jComboBox_RPCV = new javax.swing.JComboBox<>();
        jLabel_RLCV = new javax.swing.JLabel();
        jComboBox_RLCV = new javax.swing.JComboBox<>();
        jLabel_ELCV = new javax.swing.JLabel();
        jComboBox_ELCV = new javax.swing.JComboBox<>();
        jLabel_MedioCV = new javax.swing.JLabel();
        jComboBox_MedioCV = new javax.swing.JComboBox<>();
        jLabel_Insertar_CV = new javax.swing.JLabel();
        jLabel_Modificar_CV = new javax.swing.JLabel();
        jLabel_Eliminar_CV = new javax.swing.JLabel();
        jLabel_Buscar_CV = new javax.swing.JLabel();
        txt_Buscar_CV = new javax.swing.JTextField();
        jScrollPane30 = new javax.swing.JScrollPane();
        tbl_CV = new javax.swing.JTable();
        jLabel_NivelA_CV = new javax.swing.JLabel();
        jLabel_RL_CV = new javax.swing.JLabel();
        jLabel_EL_CV = new javax.swing.JLabel();
        jLabel_Correo_CV = new javax.swing.JLabel();
        jLabel_RP_CV = new javax.swing.JLabel();
        jLabel_Medio_CV = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel_TituloSE3 = new javax.swing.JLabel();
        Panel_IngresarM4 = new javax.swing.JPanel();
        Texto_IngresarSE4 = new javax.swing.JLabel();
        Panel_ModificarM4 = new javax.swing.JPanel();
        Texto_ModificarSE4 = new javax.swing.JLabel();
        Panel_EliminarM4 = new javax.swing.JPanel();
        Texto_EliminarSE4 = new javax.swing.JLabel();
        Panel_ConsultarM4 = new javax.swing.JPanel();
        Texto_ConsultarSE4 = new javax.swing.JLabel();
        jComboBox_TablasB_CV1 = new javax.swing.JComboBox<>();
        jLabel_Buscar_Tablas1 = new javax.swing.JLabel();
        jPanel_MantenimientosRP = new javax.swing.JPanel();
        jLabel_ID_RP = new javax.swing.JLabel();
        txt_id_RP = new javax.swing.JTextField();
        jLabel_Nombre_RP = new javax.swing.JLabel();
        txt_Nombre_RP = new javax.swing.JTextField();
        jLabel_Telefono_RP = new javax.swing.JLabel();
        txt_Telefono_RP = new javax.swing.JTextField();
        jLabel_Insertar_RP = new javax.swing.JLabel();
        jLabel_Modificar_RP = new javax.swing.JLabel();
        jLabel_Eliminar_RP = new javax.swing.JLabel();
        txt_Buscar_RP = new javax.swing.JTextField();
        jLabel_Buscar_RP = new javax.swing.JLabel();
        jScrollPane29 = new javax.swing.JScrollPane();
        tbl_RP = new javax.swing.JTable();
        jLabel_TituloSE2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Panel_IngresarM3 = new javax.swing.JPanel();
        Texto_IngresarSE3 = new javax.swing.JLabel();
        Panel_ModificarM3 = new javax.swing.JPanel();
        Texto_ModificarSE3 = new javax.swing.JLabel();
        Panel_EliminarM3 = new javax.swing.JPanel();
        Texto_EliminarSE3 = new javax.swing.JLabel();
        Panel_ConsultarM3 = new javax.swing.JPanel();
        Texto_ConsultarSE3 = new javax.swing.JLabel();
        jPanel_MantenimientoRL = new javax.swing.JPanel();
        txt_id_ReferenciaL = new javax.swing.JTextField();
        jLabel_ID_ReferenciaL = new javax.swing.JLabel();
        txt_NombreRL = new javax.swing.JTextField();
        jLabel_NombreRL = new javax.swing.JLabel();
        txt_TelefonoRL = new javax.swing.JTextField();
        jLabel_TelefonoRL = new javax.swing.JLabel();
        jLabel_IngresarRL = new javax.swing.JLabel();
        jLabel_ModificarRL = new javax.swing.JLabel();
        jLabel_EliminarRL = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        tbl_RL = new javax.swing.JTable();
        jLabel_BuscarRL = new javax.swing.JLabel();
        txt_BuscarRL = new javax.swing.JTextField();
        jLabel_TituloRL = new javax.swing.JLabel();
        Panel_IngresarRL = new javax.swing.JPanel();
        Texto_IngresarRL = new javax.swing.JLabel();
        Panel_ModificarRL = new javax.swing.JPanel();
        Texto_ModificarRL = new javax.swing.JLabel();
        Panel_EliminarRL = new javax.swing.JPanel();
        Texto_EliminarRL = new javax.swing.JLabel();
        Panel_ConsultarRL = new javax.swing.JPanel();
        Texto_ConsultarRL = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel_Mantenimiento_Medio = new javax.swing.JPanel();
        txt_id_Medio = new javax.swing.JTextField();
        jLabel_ID_Medio = new javax.swing.JLabel();
        jLabel_NombreSEM = new javax.swing.JLabel();
        jLabel_ID_SEM = new javax.swing.JLabel();
        jComboBox_IDSEM = new javax.swing.JComboBox<>();
        txt_NombreM = new javax.swing.JTextField();
        jLabel_NombreM = new javax.swing.JLabel();
        jLabel_DescripcionM = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea_DescripcionM = new javax.swing.JTextArea();
        jScrollPane27 = new javax.swing.JScrollPane();
        tbl_Medio = new javax.swing.JTable();
        jLabel_BuscarM = new javax.swing.JLabel();
        txt_BuscarM = new javax.swing.JTextField();
        jLabel_IngresarM = new javax.swing.JLabel();
        jLabel_ModificarM = new javax.swing.JLabel();
        jLabel_EliminarM = new javax.swing.JLabel();
        jLabel_TituloSE1 = new javax.swing.JLabel();
        Panel_IngresarM2 = new javax.swing.JPanel();
        Texto_IngresarSE2 = new javax.swing.JLabel();
        Panel_ModificarM2 = new javax.swing.JPanel();
        Texto_ModificarSE2 = new javax.swing.JLabel();
        Panel_EliminarM2 = new javax.swing.JPanel();
        Texto_EliminarSE2 = new javax.swing.JLabel();
        Panel_ConsultarM2 = new javax.swing.JPanel();
        Texto_ConsultarSE2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox_TablasB_M1 = new javax.swing.JComboBox<>();
        jLabel_Buscar_Tablas_M1 = new javax.swing.JLabel();
        jPanel_MantenimientoSE = new javax.swing.JPanel();
        jLabel_DescripcionSE = new javax.swing.JLabel();
        txt_id_SolicitudE = new javax.swing.JTextField();
        jLabel_RangoEdadM = new javax.swing.JLabel();
        txt_RangoEdadM = new javax.swing.JTextField();
        jLabel_RangoEdadMa = new javax.swing.JLabel();
        txt_RangoEdadMa = new javax.swing.JTextField();
        jLabel_RangoEdadMa1 = new javax.swing.JLabel();
        txt_Genero = new javax.swing.JTextField();
        jLabel_PuestoSE = new javax.swing.JLabel();
        jLabel_Puesto_SE = new javax.swing.JLabel();
        jComboBox_PuestoSE = new javax.swing.JComboBox<>();
        jLabel_DepartamentoSE = new javax.swing.JLabel();
        jLabel_Departamento_SE = new javax.swing.JLabel();
        jComboBox_DepartamentoSE = new javax.swing.JComboBox<>();
        jLabel_NivelASE = new javax.swing.JLabel();
        jLabel_NivelA_SE = new javax.swing.JLabel();
        jComboBox_NivelASE = new javax.swing.JComboBox<>();
        jLabel_ExperieciaLSE = new javax.swing.JLabel();
        jLabel_ExperienciaL_SE = new javax.swing.JLabel();
        jComboBox_ExperienciaL_SE = new javax.swing.JComboBox<>();
        jLabel_ID_SolicitudE1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_DescripcionSE = new javax.swing.JTextArea();
        jScrollPane26 = new javax.swing.JScrollPane();
        tbl_SE = new javax.swing.JTable();
        txt_Buscar_SE = new javax.swing.JTextField();
        jLabel_Buscar_SE = new javax.swing.JLabel();
        jLabel_IngresarSE = new javax.swing.JLabel();
        jLabel_Modificar_SE = new javax.swing.JLabel();
        jLabel_Eliminar_SE = new javax.swing.JLabel();
        jLabel_TituloSE = new javax.swing.JLabel();
        Panel_IngresarSE = new javax.swing.JPanel();
        Texto_IngresarSE = new javax.swing.JLabel();
        Panel_ModificarSE = new javax.swing.JPanel();
        Texto_ModificarSE = new javax.swing.JLabel();
        Panel_EliminarSE = new javax.swing.JPanel();
        Texto_EliminarSE = new javax.swing.JLabel();
        Panel_ConsultarSE = new javax.swing.JPanel();
        Texto_ConsultarSE = new javax.swing.JLabel();
        jComboBox_TablasB_SE = new javax.swing.JComboBox<>();
        jLabel_Buscar_Tablas_SE = new javax.swing.JLabel();
        icono_BuscarSE = new javax.swing.JLabel();
        jPanel_MantenimientoExpL = new javax.swing.JPanel();
        jLabel_ID_ExpL = new javax.swing.JLabel();
        txt_id_ExpL = new javax.swing.JTextField();
        jLabel_ID_ExpLLD = new javax.swing.JLabel();
        jLabel_id_Nombre_EpLLD = new javax.swing.JLabel();
        jLabel_Insertar_ExpL = new javax.swing.JLabel();
        jLabel_Modificar_ExpL = new javax.swing.JLabel();
        jLabel_Eliminar_ExpL = new javax.swing.JLabel();
        txt_Buscar_ExpL = new javax.swing.JTextField();
        jLabel_Buscar_ExpL = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        tbl_ExpL = new javax.swing.JTable();
        jComboBox_Nombre_EpLLD = new javax.swing.JComboBox<>();
        jLabel_TituloExpL = new javax.swing.JLabel();
        Panel_IngresarExpL = new javax.swing.JPanel();
        Texto_IngresarExpL = new javax.swing.JLabel();
        Panel_ModificarExpL = new javax.swing.JPanel();
        Texto_ModificarExpL = new javax.swing.JLabel();
        Panel_EliminarExpL = new javax.swing.JPanel();
        Texto_EliminarExpL = new javax.swing.JLabel();
        Panel_ConsultarExpL = new javax.swing.JPanel();
        Texto_ConsultarExpL = new javax.swing.JLabel();
        icono_Buscar4 = new javax.swing.JLabel();
        jComboBox_TablasB_ExpL = new javax.swing.JComboBox<>();
        jLabel_Buscar_Tablas = new javax.swing.JLabel();
        jPanel_MantenimientoExpLD = new javax.swing.JPanel();
        jLabel_ID_ExpLD = new javax.swing.JLabel();
        txt_id_ExpLD = new javax.swing.JTextField();
        jLabel_NombreExpLD = new javax.swing.JLabel();
        txt_NombreExpLD = new javax.swing.JTextField();
        jLabel_Nombre_EmpresaExpLD = new javax.swing.JLabel();
        txt_Nombre_EmpresaExpLD = new javax.swing.JTextField();
        jLabel_Tiempo_InicioExpLD = new javax.swing.JLabel();
        txt_Tiempo_InicioExpLD = new javax.swing.JTextField();
        jLabel_Tiempo_FinalizacionExpLD = new javax.swing.JLabel();
        txt_Tiempo_FinalizacionExpLD = new javax.swing.JTextField();
        jLabel_Insertar_ExpLD = new javax.swing.JLabel();
        jLabel_Modificar_ExpLD = new javax.swing.JLabel();
        jLabel_Eliminar_ExpLD = new javax.swing.JLabel();
        jLabel_Buscar_ExpLD = new javax.swing.JLabel();
        txt_Buscar_ExpLD = new javax.swing.JTextField();
        jScrollPane24 = new javax.swing.JScrollPane();
        tbl_ExpLD = new javax.swing.JTable();
        jLabel_TituloELD = new javax.swing.JLabel();
        Panel_IngresarExpLD = new javax.swing.JPanel();
        Texto_IngresarExpLD = new javax.swing.JLabel();
        Panel_ModificarExpLD = new javax.swing.JPanel();
        Texto_ModificarExpLD = new javax.swing.JLabel();
        Panel_EliminarExpLD = new javax.swing.JPanel();
        Texto_EliminarExpLD = new javax.swing.JLabel();
        Panel_ConsultarExpLD = new javax.swing.JPanel();
        Texto_ConsultarExpLD = new javax.swing.JLabel();
        icono_Buscar3 = new javax.swing.JLabel();
        jPanel_MantenimientoNA = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        tbl_NivelA = new javax.swing.JTable();
        jLabel_ID_NivelA = new javax.swing.JLabel();
        txt_id_NivelA = new javax.swing.JTextField();
        jLabel_Nombre_NivelA = new javax.swing.JLabel();
        txt_Nombre_NivelA = new javax.swing.JTextField();
        jLabel_Descripcion_NivelA = new javax.swing.JLabel();
        txt_Descripcion_NivelA = new javax.swing.JTextField();
        jLabel_Insertar_NivelA = new javax.swing.JLabel();
        jLabel_Eliminar_NivelA = new javax.swing.JLabel();
        jLabel_Modificar_NivelA = new javax.swing.JLabel();
        jLabel_Buscar_NivelA = new javax.swing.JLabel();
        txt_Buscar_NivelA = new javax.swing.JTextField();
        jLabel_TituloD2 = new javax.swing.JLabel();
        Panel_Ingresar1 = new javax.swing.JPanel();
        Texto_Ingresar1 = new javax.swing.JLabel();
        Panel_Modificar1 = new javax.swing.JPanel();
        Texto_Modificar1 = new javax.swing.JLabel();
        Panel_Eliminar1 = new javax.swing.JPanel();
        Texto_Eliminar1 = new javax.swing.JLabel();
        Panel_Consultar1 = new javax.swing.JPanel();
        Texto_Consultar1 = new javax.swing.JLabel();
        icono_Buscar2 = new javax.swing.JLabel();
        Mantenimiento_D = new javax.swing.JPanel();
        jLabel_TituloD = new javax.swing.JLabel();
        Panel_Consultar = new javax.swing.JPanel();
        Texto_Consultar = new javax.swing.JLabel();
        Panel_Eliminar = new javax.swing.JPanel();
        Texto_Eliminar = new javax.swing.JLabel();
        Panel_Modificar = new javax.swing.JPanel();
        Texto_Modificar = new javax.swing.JLabel();
        Panel_Ingresar = new javax.swing.JPanel();
        Texto_Ingresar = new javax.swing.JLabel();
        jLabel_ID_Departamento = new javax.swing.JLabel();
        txt_id_Departamento = new javax.swing.JTextField();
        jLabel_NombreD = new javax.swing.JLabel();
        txt_Nombre_Departamento = new javax.swing.JTextField();
        jLabel_Estatus_Departamento = new javax.swing.JLabel();
        txt_Estatus_Departamento = new javax.swing.JTextField();
        jLabel_Buscar = new javax.swing.JLabel();
        txt_Buscar = new javax.swing.JTextField();
        jScrollPane21 = new javax.swing.JScrollPane();
        tbl_Departamento = new javax.swing.JTable();
        jLabel_EliminarD = new javax.swing.JLabel();
        jLabel_ModificarD = new javax.swing.JLabel();
        jLabel_Ingresar = new javax.swing.JLabel();
        icono_Buscar = new javax.swing.JLabel();
        jPanel_MantenimientosP = new javax.swing.JPanel();
        jLabel_ID_Puesto = new javax.swing.JLabel();
        txt_id_Puesto = new javax.swing.JTextField();
        jLabel_Nombre_Puesto = new javax.swing.JLabel();
        txt_Nombre_Puesto = new javax.swing.JTextField();
        jLabel_Descripcion_Puesto = new javax.swing.JLabel();
        jLabel_Descripcion_Puesto1 = new javax.swing.JLabel();
        txt_Estatus_Puesto = new javax.swing.JTextField();
        jScrollPane22 = new javax.swing.JScrollPane();
        tbl_Puesto = new javax.swing.JTable();
        jLabel_Buscar_Puesto = new javax.swing.JLabel();
        txt_Buscar_Puesto = new javax.swing.JTextField();
        jLabel_Insertar_Puesto = new javax.swing.JLabel();
        jLabel_Modificar_Puesto = new javax.swing.JLabel();
        jLabel_Eliminar_Puesto = new javax.swing.JLabel();
        Panel_IngresarP = new javax.swing.JPanel();
        Texto_IngresarP = new javax.swing.JLabel();
        Panel_ModificarP = new javax.swing.JPanel();
        Texto_ModificarP = new javax.swing.JLabel();
        Panel_EliminarP = new javax.swing.JPanel();
        Texto_EliminarP = new javax.swing.JLabel();
        Panel_ConsultarP = new javax.swing.JPanel();
        Texto_ConsultarP = new javax.swing.JLabel();
        jLabel_TituloD1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Descripcion_Puesto = new javax.swing.JTextArea();
        icono_Buscar1 = new javax.swing.JLabel();
        jPanel_BG = new javax.swing.JPanel();
        Panel_IzquierdoC = new javax.swing.JPanel();
        Slide = new javax.swing.JPanel();
        Panel_Icono_Conta = new javax.swing.JPanel();
        Icono_Conta = new javax.swing.JLabel();
        Panel_Icono_Bancos = new javax.swing.JPanel();
        Icono_Bancos = new javax.swing.JLabel();
        Panel_Icono_Nomina = new javax.swing.JPanel();
        Icono_Nomina = new javax.swing.JLabel();
        Panel_Icono_RRHH = new javax.swing.JPanel();
        Icono_RRHH = new javax.swing.JLabel();
        jLabel_Logo = new javax.swing.JLabel();
        Slide_Derecho = new javax.swing.JPanel();
        Panel_Text_RRHH = new javax.swing.JPanel();
        Texto_RRHH = new javax.swing.JLabel();
        Panel_Text_Nomina = new javax.swing.JPanel();
        Texto_Nomina = new javax.swing.JLabel();
        Panel_Text_Bancos = new javax.swing.JPanel();
        Texto_Bancos = new javax.swing.JLabel();
        Panel_Text_Conta = new javax.swing.JPanel();
        Texto_Conta = new javax.swing.JLabel();
        jLabel_Titulo = new javax.swing.JLabel();
        jPanel_Bienvenido = new javax.swing.JPanel();
        Bienvenido = new javax.swing.JLabel();
        ExpLD = new javax.swing.JPanel();
        SeleccionadoA3 = new javax.swing.JLabel();
        Cant_R1 = new javax.swing.JLabel();
        icon_ExpLD = new javax.swing.JLabel();
        SeleccionadoA15 = new javax.swing.JLabel();
        Cant_R20 = new javax.swing.JLabel();
        icon_PP = new javax.swing.JLabel();
        Departamento = new javax.swing.JPanel();
        SeleccionadoA1 = new javax.swing.JLabel();
        Cant_R2 = new javax.swing.JLabel();
        icon_Departamento = new javax.swing.JLabel();
        SeleccionadoA12 = new javax.swing.JLabel();
        Cant_R17 = new javax.swing.JLabel();
        icon_APP = new javax.swing.JLabel();
        Puesto = new javax.swing.JPanel();
        SeleccionadoA = new javax.swing.JLabel();
        Cant_R3 = new javax.swing.JLabel();
        icon_Puesto = new javax.swing.JLabel();
        SeleccionadoA13 = new javax.swing.JLabel();
        Cant_R18 = new javax.swing.JLabel();
        icon_Seleccion = new javax.swing.JLabel();
        Nivel_Academico = new javax.swing.JPanel();
        SeleccionadoA2 = new javax.swing.JLabel();
        Cant_R4 = new javax.swing.JLabel();
        icon_NivelA = new javax.swing.JLabel();
        SeleccionadoA14 = new javax.swing.JLabel();
        Cant_R19 = new javax.swing.JLabel();
        icon_Actividad = new javax.swing.JLabel();
        ExpLD1 = new javax.swing.JPanel();
        Cant_R5 = new javax.swing.JLabel();
        icon_NivelA2 = new javax.swing.JLabel();
        Departamento1 = new javax.swing.JPanel();
        Cant_R6 = new javax.swing.JLabel();
        icon_Departamento1 = new javax.swing.JLabel();
        Puesto1 = new javax.swing.JPanel();
        Cant_R7 = new javax.swing.JLabel();
        icon_Puesto2 = new javax.swing.JLabel();
        Nivel_Academico2 = new javax.swing.JPanel();
        Cant_R8 = new javax.swing.JLabel();
        icon_NivelA3 = new javax.swing.JLabel();
        SE = new javax.swing.JPanel();
        SeleccionadoA5 = new javax.swing.JLabel();
        Cant_R11 = new javax.swing.JLabel();
        icon_SE = new javax.swing.JLabel();
        SeleccionadoA17 = new javax.swing.JLabel();
        Cant_R22 = new javax.swing.JLabel();
        icon_EC = new javax.swing.JLabel();
        RL = new javax.swing.JPanel();
        SeleccionadoA7 = new javax.swing.JLabel();
        Cant_R9 = new javax.swing.JLabel();
        icon_RL = new javax.swing.JLabel();
        SeleccionadoA19 = new javax.swing.JLabel();
        Cant_R24 = new javax.swing.JLabel();
        icon_BE = new javax.swing.JLabel();
        ExpL = new javax.swing.JPanel();
        SeleccionadoA4 = new javax.swing.JLabel();
        Cant_R10 = new javax.swing.JLabel();
        icon_ExpL = new javax.swing.JLabel();
        SeleccionadoA16 = new javax.swing.JLabel();
        Cant_R21 = new javax.swing.JLabel();
        icon_Contratacion = new javax.swing.JLabel();
        Medio = new javax.swing.JPanel();
        SeleccionadoA6 = new javax.swing.JLabel();
        Cant_R12 = new javax.swing.JLabel();
        icon_Medio = new javax.swing.JLabel();
        SeleccionadoA18 = new javax.swing.JLabel();
        Cant_R23 = new javax.swing.JLabel();
        icon_AE = new javax.swing.JLabel();
        Aplicacion = new javax.swing.JPanel();
        SeleccionadoA10 = new javax.swing.JLabel();
        Cant_R14 = new javax.swing.JLabel();
        icon_Aplicacion = new javax.swing.JLabel();
        TP = new javax.swing.JPanel();
        SeleccionadoA11 = new javax.swing.JLabel();
        Cant_R15 = new javax.swing.JLabel();
        icon_TP = new javax.swing.JLabel();
        RP = new javax.swing.JPanel();
        SeleccionadoA8 = new javax.swing.JLabel();
        Cant_R13 = new javax.swing.JLabel();
        icon_RP = new javax.swing.JLabel();
        CV = new javax.swing.JPanel();
        SeleccionadoA9 = new javax.swing.JLabel();
        Cant_R16 = new javax.swing.JLabel();
        icon_CV = new javax.swing.JLabel();
        jLabel_Felcha2 = new javax.swing.JLabel();
        jLabel_Flecha_Iz1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 107, 176));
        setMinimumSize(new java.awt.Dimension(100, 70));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_MantenimientoBE.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoBE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_TituloAE1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Actividad Empleado.png"))); // NOI18N
        jPanel_MantenimientoBE.add(jLabel_TituloAE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        jLabel_Buscar_BE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jLabel_Buscar_BE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Buscar_BEMouseClicked(evt);
            }
        });
        jPanel_MantenimientoBE.add(jLabel_Buscar_BE, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, -1, -1));

        txt_Buscar_BE.setBackground(new java.awt.Color(40, 41, 46));
        txt_Buscar_BE.setForeground(new java.awt.Color(153, 153, 153));
        txt_Buscar_BE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Buscar_BE.setBorder(null);
        txt_Buscar_BE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Buscar_BEActionPerformed(evt);
            }
        });
        txt_Buscar_BE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Buscar_BEKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_Buscar_BEKeyTyped(evt);
            }
        });
        jPanel_MantenimientoBE.add(txt_Buscar_BE, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 290, 20));

        tbl_BE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_BE.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_BE.setSelectionBackground(new java.awt.Color(40, 41, 46));
        tbl_BE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_BEMouseClicked(evt);
            }
        });
        jScrollPane40.setViewportView(tbl_BE);

        jPanel_MantenimientoBE.add(jScrollPane40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 1090, 250));

        jTextField_Encontraid.setBackground(new java.awt.Color(28, 27, 33));
        jTextField_Encontraid.setBorder(null);
        jTextField_Encontraid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_EncontraidActionPerformed(evt);
            }
        });
        jPanel_MantenimientoBE.add(jTextField_Encontraid, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 190, 30));

        txt_contra.setBackground(new java.awt.Color(28, 27, 33));
        txt_contra.setForeground(new java.awt.Color(28, 27, 33));
        txt_contra.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoBE.add(txt_contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 70, -1));

        txt_puesto.setBackground(new java.awt.Color(28, 27, 33));
        txt_puesto.setForeground(new java.awt.Color(255, 255, 255));
        txt_puesto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_puesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_puestoActionPerformed(evt);
            }
        });
        jPanel_MantenimientoBE.add(txt_puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 70, -1));

        txt_depa.setBackground(new java.awt.Color(28, 27, 33));
        txt_depa.setForeground(new java.awt.Color(255, 255, 255));
        txt_depa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoBE.add(txt_depa, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 60, 80, -1));

        txt_peri.setBackground(new java.awt.Color(28, 27, 33));
        txt_peri.setForeground(new java.awt.Color(255, 255, 255));
        txt_peri.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoBE.add(txt_peri, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 160, 70, -1));

        txt_selec.setBackground(new java.awt.Color(28, 27, 33));
        txt_selec.setForeground(new java.awt.Color(255, 255, 255));
        txt_selec.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_selec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_selecActionPerformed(evt);
            }
        });
        jPanel_MantenimientoBE.add(txt_selec, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, 80, -1));

        txt_ap.setBackground(new java.awt.Color(28, 27, 33));
        txt_ap.setForeground(new java.awt.Color(255, 255, 255));
        txt_ap.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoBE.add(txt_ap, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 80, -1));

        txt_idap.setBackground(new java.awt.Color(28, 27, 33));
        txt_idap.setForeground(new java.awt.Color(255, 255, 255));
        txt_idap.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoBE.add(txt_idap, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, 70, -1));

        txt_dpi.setBackground(new java.awt.Color(28, 27, 33));
        txt_dpi.setForeground(new java.awt.Color(255, 255, 255));
        txt_dpi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_dpi.setFocusable(false);
        jPanel_MantenimientoBE.add(txt_dpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 80, -1));

        getContentPane().add(jPanel_MantenimientoBE, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1470, 680));

        jPanel_MantenimientoAE.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoAE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_AE_EC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_AE_EC.setText("Empleado Contratado");
        jPanel_MantenimientoAE.add(jLabel_AE_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, -1, -1));

        jLabel_AE_ECC.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoAE.add(jLabel_AE_ECC, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 30, 20));

        jComboBox_AE_EC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_AE_ECActionPerformed(evt);
            }
        });
        jPanel_MantenimientoAE.add(jComboBox_AE_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 140, -1));

        jLabel_Actividad_AE.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Actividad_AE.setText("Actividad");
        jPanel_MantenimientoAE.add(jLabel_Actividad_AE, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, -1, -1));

        jLabel_Actividad_AEE.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoAE.add(jLabel_Actividad_AEE, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 360, 30, 20));

        jComboBox_Actividad_AE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Actividad_AEActionPerformed(evt);
            }
        });
        jPanel_MantenimientoAE.add(jComboBox_Actividad_AE, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 140, -1));

        jLabel_Insertar_AE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_Insertar_AE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Insertar_AEMouseClicked(evt);
            }
        });
        jPanel_MantenimientoAE.add(jLabel_Insertar_AE, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 420, 50, 50));

        jLabel_Modificar_AE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_Modificar_AE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Modificar_AEMouseClicked(evt);
            }
        });
        jPanel_MantenimientoAE.add(jLabel_Modificar_AE, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 420, 50, 50));

        jLabel_Eliminar_AE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar_AE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Eliminar_AEMouseClicked(evt);
            }
        });
        jPanel_MantenimientoAE.add(jLabel_Eliminar_AE, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 420, 50, 50));

        jLabel_BuscarAE.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_BuscarAE.setText("Buscar");
        jLabel_BuscarAE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_BuscarAEMouseClicked(evt);
            }
        });
        jPanel_MantenimientoAE.add(jLabel_BuscarAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 50, 20));

        txt_BuscarAE.setBackground(new java.awt.Color(40, 41, 46));
        txt_BuscarAE.setForeground(new java.awt.Color(153, 153, 153));
        txt_BuscarAE.setBorder(null);
        txt_BuscarAE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarAEActionPerformed(evt);
            }
        });
        txt_BuscarAE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_BuscarAEKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarAEKeyReleased(evt);
            }
        });
        jPanel_MantenimientoAE.add(txt_BuscarAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 240, 20));

        tbl_AE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_AE.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_AE.setSelectionBackground(new java.awt.Color(40, 41, 46));
        tbl_AE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_AEMouseClicked(evt);
            }
        });
        jScrollPane39.setViewportView(tbl_AE);

        jPanel_MantenimientoAE.add(jScrollPane39, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, 600, 190));

        jLabel_TituloAE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Actividad Empleado.png"))); // NOI18N
        jPanel_MantenimientoAE.add(jLabel_TituloAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        Panel_IngresarAE.setBackground(new java.awt.Color(28, 27, 33));
        Panel_IngresarAE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_IngresarAEMouseClicked(evt);
            }
        });
        Panel_IngresarAE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_IngresarAE.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_IngresarAE.setForeground(new java.awt.Color(255, 255, 255));
        Texto_IngresarAE.setText("Ingresar");
        Texto_IngresarAE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_IngresarAE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_IngresarAEMouseClicked(evt);
            }
        });
        Panel_IngresarAE.add(Texto_IngresarAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoAE.add(Panel_IngresarAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 130, 50));

        Panel_ModificarAE.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ModificarAE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ModificarAEMouseClicked(evt);
            }
        });
        Panel_ModificarAE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ModificarAE.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ModificarAE.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ModificarAE.setText("Modificar");
        Texto_ModificarAE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ModificarAE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ModificarAEMouseClicked(evt);
            }
        });
        Panel_ModificarAE.add(Texto_ModificarAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientoAE.add(Panel_ModificarAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 130, 50));

        Panel_EliminarAE.setBackground(new java.awt.Color(28, 27, 33));
        Panel_EliminarAE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_EliminarAEMouseClicked(evt);
            }
        });
        Panel_EliminarAE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_EliminarAE.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_EliminarAE.setForeground(new java.awt.Color(255, 255, 255));
        Texto_EliminarAE.setText("Eliminar");
        Texto_EliminarAE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_EliminarAE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_EliminarAEMouseClicked(evt);
            }
        });
        Panel_EliminarAE.add(Texto_EliminarAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoAE.add(Panel_EliminarAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 130, 50));

        Panel_ConsultarAE.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ConsultarAE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ConsultarAE.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ConsultarAE.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ConsultarAE.setText("Consultar");
        Texto_ConsultarAE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ConsultarAE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ConsultarAEMouseClicked(evt);
            }
        });
        Panel_ConsultarAE.add(Texto_ConsultarAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientoAE.add(Panel_ConsultarAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 130, 50));

        jComboBox_TablasAE.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_TablasAE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TablasAEActionPerformed(evt);
            }
        });
        jPanel_MantenimientoAE.add(jComboBox_TablasAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 520, 170, -1));

        jLabel_Buscar_TablasAE.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_TablasAE.setText("Buscar");
        jLabel_Buscar_TablasAE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Buscar_TablasAEMouseClicked(evt);
            }
        });
        jPanel_MantenimientoAE.add(jLabel_Buscar_TablasAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 560, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientoAE.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, -1, -1));

        getContentPane().add(jPanel_MantenimientoAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1610, 900));

        jPanel_MantenimientoEC.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoEC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_ID_EC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_EC.setText("ID Empleado Contratado");
        jPanel_MantenimientoEC.add(jLabel_ID_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, -1));

        txt_id_EC.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_EC.setForeground(new java.awt.Color(153, 153, 153));
        txt_id_EC.setBorder(null);
        txt_id_EC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_ECActionPerformed(evt);
            }
        });
        jPanel_MantenimientoEC.add(txt_id_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 140, 20));

        jLabel_CEC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CEC.setText("Contratacion");
        jPanel_MantenimientoEC.add(jLabel_CEC, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, -1, -1));

        jLabel_CECC.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoEC.add(jLabel_CECC, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 30, 20));

        jComboBox_CEC.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_CEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_CECActionPerformed(evt);
            }
        });
        jPanel_MantenimientoEC.add(jComboBox_CEC, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 140, -1));

        jLabel_ECP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ECP.setText("Puesto");
        jPanel_MantenimientoEC.add(jLabel_ECP, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, -1, -1));

        jLabel_ECPP.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoEC.add(jLabel_ECPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 30, 20));

        jComboBox_ECP.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_ECP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ECPActionPerformed(evt);
            }
        });
        jPanel_MantenimientoEC.add(jComboBox_ECP, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 140, -1));

        jLabel_ECD.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ECD.setText("Departamento");
        jPanel_MantenimientoEC.add(jLabel_ECD, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 310, -1, -1));

        jLabel_ECDD.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoEC.add(jLabel_ECDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 340, 30, 20));

        jComboBox_ECD.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_ECD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ECDActionPerformed(evt);
            }
        });
        jPanel_MantenimientoEC.add(jComboBox_ECD, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, 140, -1));

        jLabe_SEC.setForeground(new java.awt.Color(255, 255, 255));
        jLabe_SEC.setText("Sueldo Empleado Contratado");
        jPanel_MantenimientoEC.add(jLabe_SEC, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, -1, -1));

        txt_SEC.setBackground(new java.awt.Color(40, 41, 46));
        txt_SEC.setForeground(new java.awt.Color(153, 153, 153));
        txt_SEC.setBorder(null);
        txt_SEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SECActionPerformed(evt);
            }
        });
        jPanel_MantenimientoEC.add(txt_SEC, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 180, 20));

        jLabel_IngresarEC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_IngresarEC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_IngresarEC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_IngresarECMouseClicked(evt);
            }
        });
        jPanel_MantenimientoEC.add(jLabel_IngresarEC, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, 50, 50));

        jLabel_Modificar_EC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_Modificar_EC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Modificar_ECMouseClicked(evt);
            }
        });
        jPanel_MantenimientoEC.add(jLabel_Modificar_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, 50, 50));

        jLabel_Eliminar_EC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar_EC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Eliminar_ECMouseClicked(evt);
            }
        });
        jPanel_MantenimientoEC.add(jLabel_Eliminar_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, 50, 50));

        jLabel_BuscarEC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_BuscarEC.setText("Buscar");
        jPanel_MantenimientoEC.add(jLabel_BuscarEC, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 50, 20));

        txt_BuscarEC.setBackground(new java.awt.Color(40, 41, 46));
        txt_BuscarEC.setForeground(new java.awt.Color(153, 153, 153));
        txt_BuscarEC.setBorder(null);
        txt_BuscarEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarECActionPerformed(evt);
            }
        });
        txt_BuscarEC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_BuscarECKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarECKeyReleased(evt);
            }
        });
        jPanel_MantenimientoEC.add(txt_BuscarEC, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 500, 240, 20));

        tbl_EC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_EC.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_EC.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_EC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ECMouseClicked(evt);
            }
        });
        jScrollPane38.setViewportView(tbl_EC);

        jPanel_MantenimientoEC.add(jScrollPane38, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 540, 600, 190));

        jLabel_TituloEC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Empleado Contratado.png"))); // NOI18N
        jPanel_MantenimientoEC.add(jLabel_TituloEC, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        Panel_Ingresar_EC.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Ingresar_EC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Ingresar_ECMouseClicked(evt);
            }
        });
        Panel_Ingresar_EC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Ingresar_EC.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Ingresar_EC.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Ingresar_EC.setText("Ingresar");
        Texto_Ingresar_EC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Ingresar_EC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Ingresar_ECMouseClicked(evt);
            }
        });
        Panel_Ingresar_EC.add(Texto_Ingresar_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoEC.add(Panel_Ingresar_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 130, 50));

        Panel_Modificar_EC.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Modificar_EC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Modificar_ECMouseClicked(evt);
            }
        });
        Panel_Modificar_EC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Modificar_EC.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Modificar_EC.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Modificar_EC.setText("Modificar");
        Texto_Modificar_EC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Modificar_EC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Modificar_ECMouseClicked(evt);
            }
        });
        Panel_Modificar_EC.add(Texto_Modificar_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientoEC.add(Panel_Modificar_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 130, 50));

        Panel_Eliminar_EC.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Eliminar_EC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Eliminar_ECMouseClicked(evt);
            }
        });
        Panel_Eliminar_EC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Eliminar_EC.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Eliminar_EC.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Eliminar_EC.setText("Eliminar");
        Texto_Eliminar_EC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Eliminar_EC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Eliminar_ECMouseClicked(evt);
            }
        });
        Panel_Eliminar_EC.add(Texto_Eliminar_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoEC.add(Panel_Eliminar_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 130, 50));

        Panel_Consultar_EC.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Consultar_EC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Consultar_ECMouseClicked(evt);
            }
        });
        Panel_Consultar_EC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Consultar_EC.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Consultar_EC.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Consultar_EC.setText("Consultar");
        Texto_Consultar_EC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Consultar_EC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Consultar_ECMouseClicked(evt);
            }
        });
        Panel_Consultar_EC.add(Texto_Consultar_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientoEC.add(Panel_Consultar_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, 130, 50));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientoEC.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, -1, -1));

        jComboBox_TablasEC.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_TablasEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TablasECActionPerformed(evt);
            }
        });
        jPanel_MantenimientoEC.add(jComboBox_TablasEC, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 520, 170, -1));

        jLabel_Buscar_TablasEC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_TablasEC.setText("Buscar");
        jLabel_Buscar_TablasEC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Buscar_TablasECMouseClicked(evt);
            }
        });
        jPanel_MantenimientoEC.add(jLabel_Buscar_TablasEC, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 560, -1, -1));

        getContentPane().add(jPanel_MantenimientoEC, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1150, 640));

        jPanel_MantenimientoC.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoC.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id_C.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_C.setForeground(new java.awt.Color(153, 153, 153));
        txt_id_C.setBorder(null);
        txt_id_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_CActionPerformed(evt);
            }
        });
        jPanel_MantenimientoC.add(txt_id_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 140, 20));

        jLabel_ID_C.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_C.setText("ID Contratacion");
        jPanel_MantenimientoC.add(jLabel_ID_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 90, -1));

        jLabel_PPC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_PPC.setText("Periodo Prueba");
        jPanel_MantenimientoC.add(jLabel_PPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, -1, -1));

        jLabel_PPCC.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoC.add(jLabel_PPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, 30, 20));

        jComboBox_PPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_PPCActionPerformed(evt);
            }
        });
        jComboBox_PPC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox_PPCKeyReleased(evt);
            }
        });
        jPanel_MantenimientoC.add(jComboBox_PPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 140, -1));

        txt_FC.setBackground(new java.awt.Color(40, 41, 46));
        txt_FC.setForeground(new java.awt.Color(153, 153, 153));
        txt_FC.setBorder(null);
        txt_FC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_FCActionPerformed(evt);
            }
        });
        jPanel_MantenimientoC.add(txt_FC, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, 140, 20));

        jLabel_FC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_FC.setText("Fecha Contratacion");
        jPanel_MantenimientoC.add(jLabel_FC, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 110, -1));

        txt_DC.setBackground(new java.awt.Color(40, 41, 46));
        txt_DC.setForeground(new java.awt.Color(153, 153, 153));
        txt_DC.setBorder(null);
        txt_DC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DCActionPerformed(evt);
            }
        });
        jPanel_MantenimientoC.add(txt_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 140, 20));

        jLabel_DC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_DC.setText("Duracion Contrato");
        jPanel_MantenimientoC.add(jLabel_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 110, -1));

        txt_EC.setBackground(new java.awt.Color(40, 41, 46));
        txt_EC.setForeground(new java.awt.Color(153, 153, 153));
        txt_EC.setBorder(null);
        txt_EC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ECActionPerformed(evt);
            }
        });
        jPanel_MantenimientoC.add(txt_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 140, 20));

        jLabel_EC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_EC.setText("Estatus Contratacion");
        jPanel_MantenimientoC.add(jLabel_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 130, -1));

        jLabel_InsertarC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_InsertarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_InsertarC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_InsertarCMouseClicked(evt);
            }
        });
        jPanel_MantenimientoC.add(jLabel_InsertarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, -1, -1));

        jLabel_Modificar_C.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Modificar_C.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_Modificar_C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Modificar_CMouseClicked(evt);
            }
        });
        jPanel_MantenimientoC.add(jLabel_Modificar_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, -1, -1));

        jLabel_Eliminar_C.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Eliminar_C.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar_C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Eliminar_CMouseClicked(evt);
            }
        });
        jPanel_MantenimientoC.add(jLabel_Eliminar_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, -1, -1));

        jLabel_Buscar_C.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_C.setText("Buscar");
        jPanel_MantenimientoC.add(jLabel_Buscar_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, -1, -1));

        txt_Buscar_C.setBackground(new java.awt.Color(40, 41, 46));
        txt_Buscar_C.setForeground(new java.awt.Color(153, 153, 153));
        txt_Buscar_C.setBorder(null);
        txt_Buscar_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Buscar_CActionPerformed(evt);
            }
        });
        txt_Buscar_C.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Buscar_CKeyReleased(evt);
            }
        });
        jPanel_MantenimientoC.add(txt_Buscar_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 290, 20));

        tbl_C.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_C.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_C.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CMouseClicked(evt);
            }
        });
        jScrollPane37.setViewportView(tbl_C);

        jPanel_MantenimientoC.add(jScrollPane37, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 600, 190));

        jLabel_TituloPP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Contratacion.png"))); // NOI18N
        jPanel_MantenimientoC.add(jLabel_TituloPP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        Panel_Ingresar_PP1.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Ingresar_PP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Ingresar_PP1MouseClicked(evt);
            }
        });
        Panel_Ingresar_PP1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Ingresar_PP1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Ingresar_PP1.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Ingresar_PP1.setText("Ingresar");
        Texto_Ingresar_PP1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Ingresar_PP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Ingresar_PP1MouseClicked(evt);
            }
        });
        Panel_Ingresar_PP1.add(Texto_Ingresar_PP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoC.add(Panel_Ingresar_PP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 130, 50));

        Panel_Modificar_PP1.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Modificar_PP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Modificar_PP1MouseClicked(evt);
            }
        });
        Panel_Modificar_PP1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Modificar_PP1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Modificar_PP1.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Modificar_PP1.setText("Modificar");
        Texto_Modificar_PP1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Modificar_PP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Modificar_PP1MouseClicked(evt);
            }
        });
        Panel_Modificar_PP1.add(Texto_Modificar_PP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientoC.add(Panel_Modificar_PP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 130, 50));

        Panel_Eliminar_PP1.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Eliminar_PP1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Eliminar_PP1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Eliminar_PP1.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Eliminar_PP1.setText("Eliminar");
        Texto_Eliminar_PP1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Eliminar_PP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Eliminar_PP1MouseClicked(evt);
            }
        });
        Panel_Eliminar_PP1.add(Texto_Eliminar_PP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoC.add(Panel_Eliminar_PP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 130, 50));

        Panel_Consultar_PP1.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Consultar_PP1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Consultar_PP1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Consultar_PP1.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Consultar_PP1.setText("Consultar");
        Texto_Consultar_PP1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Consultar_PP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Consultar_PP1MouseClicked(evt);
            }
        });
        Panel_Consultar_PP1.add(Texto_Consultar_PP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientoC.add(Panel_Consultar_PP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, 130, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientoC.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, -1, -1));

        jComboBox_TablasC.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_TablasC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TablasCActionPerformed(evt);
            }
        });
        jPanel_MantenimientoC.add(jComboBox_TablasC, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 540, 170, -1));

        jLabel_Buscar_TablasC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_TablasC.setText("Buscar");
        jLabel_Buscar_TablasC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Buscar_TablasCMouseClicked(evt);
            }
        });
        jPanel_MantenimientoC.add(jLabel_Buscar_TablasC, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 580, -1, -1));

        getContentPane().add(jPanel_MantenimientoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1600, 900));

        jPanel_MantenimientoPP.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoPP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_ID_PP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_PP.setText("ID Periodo Prueba");
        jPanel_MantenimientoPP.add(jLabel_ID_PP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, -1, -1));

        txt_id_PP.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_PP.setForeground(new java.awt.Color(153, 153, 153));
        txt_id_PP.setBorder(null);
        txt_id_PP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_PPActionPerformed(evt);
            }
        });
        jPanel_MantenimientoPP.add(txt_id_PP, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 140, 20));

        jLabel_PPS.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_PPS.setText("Seleccion");
        jPanel_MantenimientoPP.add(jLabel_PPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, -1, -1));

        jLabel_PPSE.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoPP.add(jLabel_PPSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 30, 20));

        jComboBox_PPS.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_PPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_PPSActionPerformed(evt);
            }
        });
        jPanel_MantenimientoPP.add(jComboBox_PPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 140, -1));

        jLabel_FI.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_FI.setText("Fecha de Inicio");
        jPanel_MantenimientoPP.add(jLabel_FI, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, -1, -1));

        txt_id_FI.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_FI.setForeground(new java.awt.Color(153, 153, 153));
        txt_id_FI.setBorder(null);
        txt_id_FI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_FIActionPerformed(evt);
            }
        });
        jPanel_MantenimientoPP.add(txt_id_FI, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 140, 20));

        jLabel_FF.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_FF.setText("Fecha de Finalizacion");
        jPanel_MantenimientoPP.add(jLabel_FF, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 310, -1, -1));

        txt_id_FF.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_FF.setForeground(new java.awt.Color(153, 153, 153));
        txt_id_FF.setBorder(null);
        txt_id_FF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_FFActionPerformed(evt);
            }
        });
        jPanel_MantenimientoPP.add(txt_id_FF, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, 140, 20));

        jLabel_Pago.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Pago.setText("Pago");
        jPanel_MantenimientoPP.add(jLabel_Pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, -1, -1));

        txt_id_Pago.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_Pago.setForeground(new java.awt.Color(153, 153, 153));
        txt_id_Pago.setBorder(null);
        txt_id_Pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_PagoActionPerformed(evt);
            }
        });
        jPanel_MantenimientoPP.add(txt_id_Pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, 140, 20));

        jLabel_PPA.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_PPA.setText("Actividad");
        jPanel_MantenimientoPP.add(jLabel_PPA, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, -1, -1));

        jComboBox_PPA.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_PPA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_PPAActionPerformed(evt);
            }
        });
        jPanel_MantenimientoPP.add(jComboBox_PPA, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 140, -1));

        jLabel_PPAA.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoPP.add(jLabel_PPAA, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, 30, 20));

        jLabel_IngresarPP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_IngresarPP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_IngresarPP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_IngresarPPMouseClicked(evt);
            }
        });
        jPanel_MantenimientoPP.add(jLabel_IngresarPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 420, 50, 50));

        jLabel_Modificar_PP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_Modificar_PP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Modificar_PPMouseClicked(evt);
            }
        });
        jPanel_MantenimientoPP.add(jLabel_Modificar_PP, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 420, 50, 50));

        jLabel_Eliminar_PP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar_PP.setText("Eliminar");
        jLabel_Eliminar_PP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Eliminar_PPMouseClicked(evt);
            }
        });
        jPanel_MantenimientoPP.add(jLabel_Eliminar_PP, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 420, 50, 50));

        jLabel_BuscarPP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_BuscarPP.setText("Buscar");
        jLabel_BuscarPP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_BuscarPPMouseClicked(evt);
            }
        });
        jPanel_MantenimientoPP.add(jLabel_BuscarPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 500, 50, 20));

        txt_BuscarPP.setBackground(new java.awt.Color(40, 41, 46));
        txt_BuscarPP.setForeground(new java.awt.Color(153, 153, 153));
        txt_BuscarPP.setBorder(null);
        txt_BuscarPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarPPActionPerformed(evt);
            }
        });
        txt_BuscarPP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarPPKeyReleased(evt);
            }
        });
        jPanel_MantenimientoPP.add(txt_BuscarPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 240, 20));

        tbl_PP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_PP.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_PP.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_PP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_PPMouseClicked(evt);
            }
        });
        jScrollPane36.setViewportView(tbl_PP);

        jPanel_MantenimientoPP.add(jScrollPane36, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, 600, 190));

        jLabel_TituloPP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Periodo Prueba.png"))); // NOI18N
        jPanel_MantenimientoPP.add(jLabel_TituloPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        Panel_Ingresar_PP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Ingresar_PP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Ingresar_PPMouseClicked(evt);
            }
        });
        Panel_Ingresar_PP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Ingresar_PP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Ingresar_PP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Ingresar_PP.setText("Ingresar");
        Texto_Ingresar_PP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Ingresar_PP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Ingresar_PPMouseClicked(evt);
            }
        });
        Panel_Ingresar_PP.add(Texto_Ingresar_PP, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoPP.add(Panel_Ingresar_PP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 130, 50));

        Panel_Modificar_PP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Modificar_PP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Modificar_PPMouseClicked(evt);
            }
        });
        Panel_Modificar_PP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Modificar_PP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Modificar_PP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Modificar_PP.setText("Modificar");
        Texto_Modificar_PP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Modificar_PP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Modificar_PPMouseClicked(evt);
            }
        });
        Panel_Modificar_PP.add(Texto_Modificar_PP, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientoPP.add(Panel_Modificar_PP, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 130, 50));

        Panel_Eliminar_PP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Eliminar_PP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Eliminar_PP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Eliminar_PP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Eliminar_PP.setText("Eliminar");
        Texto_Eliminar_PP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Eliminar_PP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Eliminar_PPMouseClicked(evt);
            }
        });
        Panel_Eliminar_PP.add(Texto_Eliminar_PP, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoPP.add(Panel_Eliminar_PP, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 130, 50));

        Panel_Consultar_PP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Consultar_PP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Consultar_PP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Consultar_PP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Consultar_PP.setText("Consultar");
        Texto_Consultar_PP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Consultar_PP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Consultar_PPMouseClicked(evt);
            }
        });
        Panel_Consultar_PP.add(Texto_Consultar_PP, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientoPP.add(Panel_Consultar_PP, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, 130, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientoPP.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, -1, -1));

        jComboBox_TablasPP.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_TablasPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TablasPPActionPerformed(evt);
            }
        });
        jPanel_MantenimientoPP.add(jComboBox_TablasPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 520, 170, -1));

        jLabel_Buscar_TablasPP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_TablasPP.setText("Buscar");
        jLabel_Buscar_TablasPP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Buscar_TablasPPMouseClicked(evt);
            }
        });
        jPanel_MantenimientoPP.add(jLabel_Buscar_TablasPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 560, -1, -1));

        getContentPane().add(jPanel_MantenimientoPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1600, 720));

        jPanel_MantenimientoA.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoA.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_ID_A.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_A.setText("ID Actividad");
        jPanel_MantenimientoA.add(jLabel_ID_A, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        txt_id_A.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_A.setForeground(new java.awt.Color(255, 255, 255));
        txt_id_A.setBorder(null);
        txt_id_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_AActionPerformed(evt);
            }
        });
        jPanel_MantenimientoA.add(txt_id_A, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 140, 20));

        jLabel_TA.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_TA.setText("Tipo Actividad");
        jPanel_MantenimientoA.add(jLabel_TA, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, -1, -1));

        txt_TA.setBackground(new java.awt.Color(40, 41, 46));
        txt_TA.setForeground(new java.awt.Color(255, 255, 255));
        txt_TA.setBorder(null);
        txt_TA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TAActionPerformed(evt);
            }
        });
        jPanel_MantenimientoA.add(txt_TA, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 140, 20));

        jLabel_DescripcionA.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_DescripcionA.setText("Descripcion Actividad");
        jPanel_MantenimientoA.add(jLabel_DescripcionA, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 330, -1, -1));

        jTextArea_DescripcionA.setBackground(new java.awt.Color(40, 41, 46));
        jTextArea_DescripcionA.setColumns(20);
        jTextArea_DescripcionA.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea_DescripcionA.setRows(5);
        jTextArea_DescripcionA.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jScrollPane4.setViewportView(jTextArea_DescripcionA);

        jPanel_MantenimientoA.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, 160, 80));

        jLabel_Insertar_A.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_Insertar_A.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Insertar_AMouseClicked(evt);
            }
        });
        jPanel_MantenimientoA.add(jLabel_Insertar_A, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 490, 50, 50));

        jLabel_Modificar_Ac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_Modificar_Ac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Modificar_AcMouseClicked(evt);
            }
        });
        jPanel_MantenimientoA.add(jLabel_Modificar_Ac, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 490, 50, 50));

        jLabel_Eliminar_Ac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar_Ac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Eliminar_AcMouseClicked(evt);
            }
        });
        jPanel_MantenimientoA.add(jLabel_Eliminar_Ac, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 490, 50, 50));

        jLabel_BuscarA.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_BuscarA.setText("Buscar");
        jLabel_BuscarA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_BuscarAMouseClicked(evt);
            }
        });
        jPanel_MantenimientoA.add(jLabel_BuscarA, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, 50, 20));

        txt_BuscarA.setBackground(new java.awt.Color(40, 41, 46));
        txt_BuscarA.setForeground(new java.awt.Color(255, 255, 255));
        txt_BuscarA.setBorder(null);
        txt_BuscarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarAActionPerformed(evt);
            }
        });
        txt_BuscarA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarAKeyReleased(evt);
            }
        });
        jPanel_MantenimientoA.add(txt_BuscarA, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, 260, 20));

        tbl_A.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_A.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_A.setSelectionBackground(new java.awt.Color(40, 41, 46));
        tbl_A.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_AMouseClicked(evt);
            }
        });
        jScrollPane35.setViewportView(tbl_A);

        jPanel_MantenimientoA.add(jScrollPane35, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 560, 600, 190));

        jLabel_TituloAPP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Actividad.png"))); // NOI18N
        jPanel_MantenimientoA.add(jLabel_TituloAPP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        Panel_Ingresar_Actividad.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Ingresar_Actividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Ingresar_ActividadMouseClicked(evt);
            }
        });
        Panel_Ingresar_Actividad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Ingresar_Actividad.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Ingresar_Actividad.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Ingresar_Actividad.setText("Ingresar");
        Texto_Ingresar_Actividad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Ingresar_Actividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Ingresar_ActividadMouseClicked(evt);
            }
        });
        Panel_Ingresar_Actividad.add(Texto_Ingresar_Actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoA.add(Panel_Ingresar_Actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 130, 50));

        Panel_Modificar_Actividad.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Modificar_Actividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Modificar_ActividadMouseClicked(evt);
            }
        });
        Panel_Modificar_Actividad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Modificar_Actividad.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Modificar_Actividad.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Modificar_Actividad.setText("Modificar");
        Texto_Modificar_Actividad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Modificar_Actividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Modificar_ActividadMouseClicked(evt);
            }
        });
        Panel_Modificar_Actividad.add(Texto_Modificar_Actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientoA.add(Panel_Modificar_Actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 130, 50));

        Panel_Eliminar_Actividad.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Eliminar_Actividad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Eliminar_Actividad.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Eliminar_Actividad.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Eliminar_Actividad.setText("Eliminar");
        Texto_Eliminar_Actividad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Eliminar_Actividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Eliminar_ActividadMouseClicked(evt);
            }
        });
        Panel_Eliminar_Actividad.add(Texto_Eliminar_Actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoA.add(Panel_Eliminar_Actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 130, 50));

        Panel_Consultar_Actividad.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Consultar_Actividad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Consultar_Actividad.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Consultar_Actividad.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Consultar_Actividad.setText("Consultar");
        Texto_Consultar_Actividad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Consultar_Actividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Consultar_ActividadMouseClicked(evt);
            }
        });
        Panel_Consultar_Actividad.add(Texto_Consultar_Actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientoA.add(Panel_Consultar_Actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 130, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientoA.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, -1, -1));

        getContentPane().add(jPanel_MantenimientoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1670, 840));

        jPanel_MantenimientoS.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_IDS.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IDS.setText("ID Seleccion");
        jPanel_MantenimientoS.add(jLabel_IDS, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        txt_idS.setBackground(new java.awt.Color(40, 41, 46));
        txt_idS.setForeground(new java.awt.Color(153, 153, 153));
        txt_idS.setBorder(null);
        txt_idS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idSActionPerformed(evt);
            }
        });
        jPanel_MantenimientoS.add(txt_idS, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 140, 20));

        jLabel_APPS.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_APPS.setText("Aplicacion Prueba");
        jPanel_MantenimientoS.add(jLabel_APPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, -1, -1));

        jComboBox_APPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_APPSActionPerformed(evt);
            }
        });
        jPanel_MantenimientoS.add(jComboBox_APPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 140, -1));

        jLabel_RL_APPS.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoS.add(jLabel_RL_APPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 30, 20));

        jLabel_EstatusS.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_EstatusS.setText("Estatus Seleccion");
        jPanel_MantenimientoS.add(jLabel_EstatusS, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, -1, -1));

        txt_EstatusS.setBackground(new java.awt.Color(40, 41, 46));
        txt_EstatusS.setForeground(new java.awt.Color(153, 153, 153));
        txt_EstatusS.setBorder(null);
        txt_EstatusS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_EstatusSActionPerformed(evt);
            }
        });
        jPanel_MantenimientoS.add(txt_EstatusS, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 140, 20));

        jLabel_InsertarS.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_InsertarS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_InsertarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_InsertarSMouseClicked(evt);
            }
        });
        jPanel_MantenimientoS.add(jLabel_InsertarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        jLabel_ModificarS.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ModificarS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_ModificarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_ModificarSMouseClicked(evt);
            }
        });
        jPanel_MantenimientoS.add(jLabel_ModificarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        jLabel_EliminarS.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_EliminarS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_EliminarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EliminarSMouseClicked(evt);
            }
        });
        jPanel_MantenimientoS.add(jLabel_EliminarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        jLabel_BuscarS.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_BuscarS.setText("Buscar");
        jLabel_BuscarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_BuscarSMouseClicked(evt);
            }
        });
        jPanel_MantenimientoS.add(jLabel_BuscarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 50, 20));

        txt_BuscarS.setBackground(new java.awt.Color(40, 41, 46));
        txt_BuscarS.setForeground(new java.awt.Color(153, 153, 153));
        txt_BuscarS.setBorder(null);
        txt_BuscarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_BuscarSMouseClicked(evt);
            }
        });
        txt_BuscarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarSActionPerformed(evt);
            }
        });
        txt_BuscarS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarSKeyReleased(evt);
            }
        });
        jPanel_MantenimientoS.add(txt_BuscarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 240, 20));

        tbl_S.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_S.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_S.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_S.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SMouseClicked(evt);
            }
        });
        jScrollPane34.setViewportView(tbl_S);

        jPanel_MantenimientoS.add(jScrollPane34, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, 600, 190));

        jLabel_TituloAPP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Seleccion.png"))); // NOI18N
        jPanel_MantenimientoS.add(jLabel_TituloAPP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        Panel_IngresarS.setBackground(new java.awt.Color(28, 27, 33));
        Panel_IngresarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_IngresarSMouseClicked(evt);
            }
        });
        Panel_IngresarS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_IngresarS.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_IngresarS.setForeground(new java.awt.Color(255, 255, 255));
        Texto_IngresarS.setText("Ingresar");
        Texto_IngresarS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_IngresarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_IngresarSMouseClicked(evt);
            }
        });
        Panel_IngresarS.add(Texto_IngresarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoS.add(Panel_IngresarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 130, 50));

        Panel_ModificarS.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ModificarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ModificarSMouseClicked(evt);
            }
        });
        Panel_ModificarS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ModificarS.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ModificarS.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ModificarS.setText("Modificar");
        Texto_ModificarS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ModificarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ModificarSMouseClicked(evt);
            }
        });
        Panel_ModificarS.add(Texto_ModificarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientoS.add(Panel_ModificarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 130, 50));

        Panel_EliminarS.setBackground(new java.awt.Color(28, 27, 33));
        Panel_EliminarS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_EliminarS.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_EliminarS.setForeground(new java.awt.Color(255, 255, 255));
        Texto_EliminarS.setText("Eliminar");
        Texto_EliminarS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_EliminarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_EliminarSMouseClicked(evt);
            }
        });
        Panel_EliminarS.add(Texto_EliminarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoS.add(Panel_EliminarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 130, 50));

        Panel_ConsultarS.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ConsultarS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ConsultarS.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ConsultarS.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ConsultarS.setText("Consultar");
        Texto_ConsultarS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ConsultarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ConsultarSMouseClicked(evt);
            }
        });
        Panel_ConsultarS.add(Texto_ConsultarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientoS.add(Panel_ConsultarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 130, 50));

        lbl_BuscarS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientoS.add(lbl_BuscarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, -1, -1));

        jComboBox_TablasB_S.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_TablasB_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TablasB_SActionPerformed(evt);
            }
        });
        jPanel_MantenimientoS.add(jComboBox_TablasB_S, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 520, 170, -1));

        jLabel_Buscar_TablasS.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_TablasS.setText("Buscar");
        jLabel_Buscar_TablasS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Buscar_TablasSMouseClicked(evt);
            }
        });
        jPanel_MantenimientoS.add(jLabel_Buscar_TablasS, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 570, -1, -1));

        getContentPane().add(jPanel_MantenimientoS, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1080, 700));

        jPanel_MantenimientoAPP.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoAPP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_ID_APP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_APP.setText("ID Aplicacion Prueba");
        jPanel_MantenimientoAPP.add(jLabel_ID_APP, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        txt_id_APP.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_APP.setForeground(new java.awt.Color(255, 255, 255));
        txt_id_APP.setBorder(null);
        txt_id_APP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_APPActionPerformed(evt);
            }
        });
        jPanel_MantenimientoAPP.add(txt_id_APP, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 140, 20));

        jLabel_PruebaAPP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_PruebaAPP.setText("Prueba");
        jPanel_MantenimientoAPP.add(jLabel_PruebaAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, -1, -1));

        jLabel_Prueba_APP.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoAPP.add(jLabel_Prueba_APP, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 30, 20));

        jComboBox_PruebaAPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_PruebaAPPActionPerformed(evt);
            }
        });
        jPanel_MantenimientoAPP.add(jComboBox_PruebaAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 140, -1));

        jLabel_AplicacionAPP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_AplicacionAPP.setText("Aplicacion");
        jPanel_MantenimientoAPP.add(jLabel_AplicacionAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, -1, -1));

        jLabel_Aplicacion_APP.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoAPP.add(jLabel_Aplicacion_APP, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 350, 30, 20));

        jComboBox_AplicacionAPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_AplicacionAPPActionPerformed(evt);
            }
        });
        jPanel_MantenimientoAPP.add(jComboBox_AplicacionAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 140, -1));

        jLabel_EstatusAPP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_EstatusAPP.setText("Estatus Aplicacion Prueba");
        jPanel_MantenimientoAPP.add(jLabel_EstatusAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 320, -1, -1));

        txt_AplicacionAPP.setBackground(new java.awt.Color(40, 41, 46));
        txt_AplicacionAPP.setForeground(new java.awt.Color(255, 255, 255));
        txt_AplicacionAPP.setBorder(null);
        txt_AplicacionAPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AplicacionAPPActionPerformed(evt);
            }
        });
        jPanel_MantenimientoAPP.add(txt_AplicacionAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 350, 170, 20));

        jLabel_Ingresar_APP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_Ingresar_APP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Ingresar_APP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Ingresar_APPMouseClicked(evt);
            }
        });
        jPanel_MantenimientoAPP.add(jLabel_Ingresar_APP, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 410, 50, 50));

        jLabel_ModificarAPP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_ModificarAPP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_ModificarAPPMouseClicked(evt);
            }
        });
        jPanel_MantenimientoAPP.add(jLabel_ModificarAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 410, 50, 50));

        jLabel_Eliminar_APP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar_APP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Eliminar_APPMouseClicked(evt);
            }
        });
        jPanel_MantenimientoAPP.add(jLabel_Eliminar_APP, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 410, 50, 50));

        jLabel_Buscar_APP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_APP.setText("Buscar");
        jPanel_MantenimientoAPP.add(jLabel_Buscar_APP, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, -1, -1));

        txt_Buscar_APP.setBackground(new java.awt.Color(40, 41, 46));
        txt_Buscar_APP.setForeground(new java.awt.Color(255, 255, 255));
        txt_Buscar_APP.setBorder(null);
        txt_Buscar_APP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Buscar_APPActionPerformed(evt);
            }
        });
        txt_Buscar_APP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Buscar_APPKeyReleased(evt);
            }
        });
        jPanel_MantenimientoAPP.add(txt_Buscar_APP, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 290, 20));

        tbl_APP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_APP.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_APP.setSelectionBackground(new java.awt.Color(40, 41, 46));
        tbl_APP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_APPMouseClicked(evt);
            }
        });
        jScrollPane33.setViewportView(tbl_APP);

        jPanel_MantenimientoAPP.add(jScrollPane33, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, 600, 190));

        jLabel_TituloAPP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Aplicacion Prueba.png"))); // NOI18N
        jPanel_MantenimientoAPP.add(jLabel_TituloAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        Panel_IngresarAPP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_IngresarAPP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_IngresarAPPMouseClicked(evt);
            }
        });
        Panel_IngresarAPP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_IngresarAPP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_IngresarAPP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_IngresarAPP.setText("Ingresar");
        Texto_IngresarAPP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_IngresarAPP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_IngresarAPPMouseClicked(evt);
            }
        });
        Panel_IngresarAPP.add(Texto_IngresarAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoAPP.add(Panel_IngresarAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 130, 50));

        Panel_ModificarAPP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ModificarAPP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ModificarAPPMouseClicked(evt);
            }
        });
        Panel_ModificarAPP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ModificarAPP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ModificarAPP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ModificarAPP.setText("Modificar");
        Texto_ModificarAPP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ModificarAPP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ModificarAPPMouseClicked(evt);
            }
        });
        Panel_ModificarAPP.add(Texto_ModificarAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientoAPP.add(Panel_ModificarAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 130, 50));

        Panel_EliminarAPP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_EliminarAPP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_EliminarAPP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_EliminarAPP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_EliminarAPP.setText("Eliminar");
        Texto_EliminarAPP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_EliminarAPP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_EliminarAPPMouseClicked(evt);
            }
        });
        Panel_EliminarAPP.add(Texto_EliminarAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoAPP.add(Panel_EliminarAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 130, 50));

        Panel_ConsultarAPP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ConsultarAPP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ConsultarAPP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ConsultarAPP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ConsultarAPP.setText("Consultar");
        Texto_ConsultarAPP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ConsultarAPP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ConsultarAPPMouseClicked(evt);
            }
        });
        Panel_ConsultarAPP.add(Texto_ConsultarAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientoAPP.add(Panel_ConsultarAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 130, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientoAPP.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, -1, -1));

        jComboBox_TablasB_APP.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_TablasB_APP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox_TablasB_APPMouseClicked(evt);
            }
        });
        jComboBox_TablasB_APP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TablasB_APPActionPerformed(evt);
            }
        });
        jPanel_MantenimientoAPP.add(jComboBox_TablasB_APP, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 520, 170, -1));

        jLabel_Buscar_TablasAPP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_TablasAPP.setText("Buscar");
        jLabel_Buscar_TablasAPP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Buscar_TablasAPPMouseClicked(evt);
            }
        });
        jPanel_MantenimientoAPP.add(jLabel_Buscar_TablasAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 570, -1, -1));

        getContentPane().add(jPanel_MantenimientoAPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1080, 700));

        jPanel_Tipo_Prueba.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_Tipo_Prueba.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Prueba.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Prueba.setText("ID Prueba");
        jPanel_Tipo_Prueba.add(jLabel_Prueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, -1));

        txt_id_TP.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_TP.setForeground(new java.awt.Color(255, 255, 255));
        txt_id_TP.setBorder(null);
        txt_id_TP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_TPActionPerformed(evt);
            }
        });
        jPanel_Tipo_Prueba.add(txt_id_TP, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 140, 20));
        jPanel_Tipo_Prueba.add(jLabel_DPIAP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        jLabel_TP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_TP.setText("Tipo Prueba");
        jPanel_Tipo_Prueba.add(jLabel_TP, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, -1, -1));

        txt_TP.setBackground(new java.awt.Color(40, 41, 46));
        txt_TP.setForeground(new java.awt.Color(255, 255, 255));
        txt_TP.setBorder(null);
        txt_TP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TPActionPerformed(evt);
            }
        });
        jPanel_Tipo_Prueba.add(txt_TP, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 140, 20));

        jLabel_IngresarTP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IngresarTP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_IngresarTP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_IngresarTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_IngresarTPMouseClicked(evt);
            }
        });
        jPanel_Tipo_Prueba.add(jLabel_IngresarTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 60, -1));

        jLabel_Modificar_TP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Modificar_TP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_Modificar_TP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Modificar_TPMouseClicked(evt);
            }
        });
        jPanel_Tipo_Prueba.add(jLabel_Modificar_TP, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 60, 50));

        jLabel_Eliminar_TP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Eliminar_TP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar_TP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Eliminar_TPMouseClicked(evt);
            }
        });
        jPanel_Tipo_Prueba.add(jLabel_Eliminar_TP, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 50, 50));

        tbl_TP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_TP.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_TP.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_TP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_TPMouseClicked(evt);
            }
        });
        jScrollPane32.setViewportView(tbl_TP);

        jPanel_Tipo_Prueba.add(jScrollPane32, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 600, 190));

        txt_BuscarTP.setBackground(new java.awt.Color(40, 41, 46));
        txt_BuscarTP.setForeground(new java.awt.Color(255, 255, 255));
        txt_BuscarTP.setBorder(null);
        txt_BuscarTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarTPActionPerformed(evt);
            }
        });
        txt_BuscarTP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarTPKeyReleased(evt);
            }
        });
        jPanel_Tipo_Prueba.add(txt_BuscarTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 240, 20));

        jLabel_BuscarTP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_BuscarTP.setText("Buscar");
        jLabel_BuscarTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_BuscarTPMouseClicked(evt);
            }
        });
        jPanel_Tipo_Prueba.add(jLabel_BuscarTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 50, 20));

        jLabel_TituloELD1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Tipo Prueba.png"))); // NOI18N
        jPanel_Tipo_Prueba.add(jLabel_TituloELD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 400, 120));

        Panel_IngresarTP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_IngresarTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_IngresarTPMouseClicked(evt);
            }
        });
        Panel_IngresarTP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_IngresarTp.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_IngresarTp.setForeground(new java.awt.Color(255, 255, 255));
        Texto_IngresarTp.setText("Ingresar");
        Texto_IngresarTp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_IngresarTp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_IngresarTpMouseClicked(evt);
            }
        });
        Panel_IngresarTP.add(Texto_IngresarTp, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_Tipo_Prueba.add(Panel_IngresarTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 130, 50));

        Panel_ModificarTP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ModificarTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ModificarTPMouseClicked(evt);
            }
        });
        Panel_ModificarTP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Modificartp.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Modificartp.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Modificartp.setText("Modificar");
        Texto_Modificartp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Modificartp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ModificartpMouseClicked(evt);
            }
        });
        Panel_ModificarTP.add(Texto_Modificartp, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_Tipo_Prueba.add(Panel_ModificarTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 130, 50));

        Panel_EliminarTP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_EliminarTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_EliminarTPMouseClicked(evt);
            }
        });
        Panel_EliminarTP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_EliminarTP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_EliminarTP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_EliminarTP.setText("Eliminar");
        Texto_EliminarTP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_EliminarTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_EliminarTPMouseClicked(evt);
            }
        });
        Panel_EliminarTP.add(Texto_EliminarTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_Tipo_Prueba.add(Panel_EliminarTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 130, 50));

        Panel_ConsultarTP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ConsultarTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ConsultarTPMouseClicked(evt);
            }
        });
        Panel_ConsultarTP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ConsultarTP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ConsultarTP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ConsultarTP.setText("Consultar");
        Texto_ConsultarTP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ConsultarTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ConsultarTPMouseClicked(evt);
            }
        });
        Panel_ConsultarTP.add(Texto_ConsultarTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_Tipo_Prueba.add(Panel_ConsultarTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 130, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_Tipo_Prueba.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, -1, -1));

        getContentPane().add(jPanel_Tipo_Prueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1110, 750));

        jPanel_MantenimientoAP.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoAP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id_AP.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_AP.setForeground(new java.awt.Color(153, 153, 153));
        txt_id_AP.setBorder(null);
        txt_id_AP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_APActionPerformed(evt);
            }
        });
        jPanel_MantenimientoAP.add(txt_id_AP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 140, 20));

        jLabel_ID_AP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_AP.setText("ID Aplicacion");
        jPanel_MantenimientoAP.add(jLabel_ID_AP, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));

        jLabel_DPIAP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_DPIAP.setText("Nombre");
        jPanel_MantenimientoAP.add(jLabel_DPIAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, -1, -1));

        jComboBox_DPIAP.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_DPIAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_DPIAPActionPerformed(evt);
            }
        });
        jPanel_MantenimientoAP.add(jComboBox_DPIAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 140, -1));

        txt_RequisitosAP.setBackground(new java.awt.Color(40, 41, 46));
        txt_RequisitosAP.setForeground(new java.awt.Color(153, 153, 153));
        txt_RequisitosAP.setBorder(null);
        txt_RequisitosAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RequisitosAPActionPerformed(evt);
            }
        });
        jPanel_MantenimientoAP.add(txt_RequisitosAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, 140, 20));

        jLabel_RequisitosAP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_RequisitosAP.setText("Cumple Requisitos?");
        jPanel_MantenimientoAP.add(jLabel_RequisitosAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, -1, -1));

        jLabel_IngresarAP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_IngresarAP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_IngresarAP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_IngresarAPMouseClicked(evt);
            }
        });
        jPanel_MantenimientoAP.add(jLabel_IngresarAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, 50, 50));

        jLabel_Modificar_AP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_Modificar_AP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Modificar_APMouseClicked(evt);
            }
        });
        jPanel_MantenimientoAP.add(jLabel_Modificar_AP, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, 50, 50));

        jLabel_Eliminar_AP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar_AP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Eliminar_APMouseClicked(evt);
            }
        });
        jPanel_MantenimientoAP.add(jLabel_Eliminar_AP, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, 50, 50));

        tbl_AP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_AP.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_AP.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_AP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_APMouseClicked(evt);
            }
        });
        jScrollPane31.setViewportView(tbl_AP);

        jPanel_MantenimientoAP.add(jScrollPane31, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, 600, 190));

        txt_BuscarAP.setBackground(new java.awt.Color(40, 41, 46));
        txt_BuscarAP.setForeground(new java.awt.Color(153, 153, 153));
        txt_BuscarAP.setBorder(null);
        txt_BuscarAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarAPActionPerformed(evt);
            }
        });
        txt_BuscarAP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarAPKeyReleased(evt);
            }
        });
        jPanel_MantenimientoAP.add(txt_BuscarAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 240, 20));

        jLabel_BuscarAP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_BuscarAP.setText("Buscar");
        jLabel_BuscarAP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_BuscarAPMouseClicked(evt);
            }
        });
        jPanel_MantenimientoAP.add(jLabel_BuscarAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 50, 20));

        jLabel_DPI_AP.setBackground(new java.awt.Color(40, 41, 46));
        jLabel_DPI_AP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_DPI_AP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel_MantenimientoAP.add(jLabel_DPI_AP, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 90, 20));

        jLabel_NombreAP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreAP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_NombreAP.setText("DPI");
        jPanel_MantenimientoAP.add(jLabel_NombreAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 70, -1));

        jLabel_TituloAP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Aplicacion.png"))); // NOI18N
        jPanel_MantenimientoAP.add(jLabel_TituloAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 400, 120));

        Panel_IngresarAP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_IngresarAP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_IngresarAPMouseClicked(evt);
            }
        });
        Panel_IngresarAP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_IngresarAP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_IngresarAP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_IngresarAP.setText("Ingresar");
        Texto_IngresarAP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_IngresarAP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_IngresarAPMouseClicked(evt);
            }
        });
        Panel_IngresarAP.add(Texto_IngresarAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoAP.add(Panel_IngresarAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 130, 50));

        Panel_ModificarAP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ModificarAP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ModificarAPMouseClicked(evt);
            }
        });
        Panel_ModificarAP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ModificarAP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ModificarAP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ModificarAP.setText("Modificar");
        Texto_ModificarAP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ModificarAP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ModificarAPMouseClicked(evt);
            }
        });
        Panel_ModificarAP.add(Texto_ModificarAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientoAP.add(Panel_ModificarAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 130, 50));

        Panel_EliminarAP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_EliminarAP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_EliminarAPMouseClicked(evt);
            }
        });
        Panel_EliminarAP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_EliminarAP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_EliminarAP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_EliminarAP.setText("Eliminar");
        Texto_EliminarAP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_EliminarAP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_EliminarAPMouseClicked(evt);
            }
        });
        Panel_EliminarAP.add(Texto_EliminarAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoAP.add(Panel_EliminarAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 130, 50));

        Panel_ConsultarAP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ConsultarAP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ConsultarAPMouseClicked(evt);
            }
        });
        Panel_ConsultarAP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ConsultarAP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ConsultarAP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ConsultarAP.setText("Consultar");
        Texto_ConsultarAP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ConsultarAP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ConsultarAPMouseClicked(evt);
            }
        });
        Panel_ConsultarAP.add(Texto_ConsultarAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientoAP.add(Panel_ConsultarAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 130, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientoAP.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, -1, -1));

        jComboBox_TablasAP.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_TablasAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TablasAPActionPerformed(evt);
            }
        });
        jPanel_MantenimientoAP.add(jComboBox_TablasAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 530, 170, -1));

        jLabel_Buscar_Tablas_M2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_Tablas_M2.setText("Buscar");
        jLabel_Buscar_Tablas_M2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Buscar_Tablas_M2MouseClicked(evt);
            }
        });
        jPanel_MantenimientoAP.add(jLabel_Buscar_Tablas_M2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 560, -1, -1));

        getContentPane().add(jPanel_MantenimientoAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1060, 680));

        jPanel_MantenimientoCV.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoCV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_DPICV.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_DPICV.setText("DPI ");
        jPanel_MantenimientoCV.add(jLabel_DPICV, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

        txt_DPICV.setBackground(new java.awt.Color(231, 231, 231));
        txt_DPICV.setForeground(new java.awt.Color(153, 153, 153));
        txt_DPICV.setBorder(null);
        txt_DPICV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DPICVActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCV.add(txt_DPICV, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 140, 20));

        jLabel_NombreCV.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreCV.setText("Nombres");
        jPanel_MantenimientoCV.add(jLabel_NombreCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, -1, -1));

        txt_NombreCV.setBackground(new java.awt.Color(231, 231, 231));
        txt_NombreCV.setForeground(new java.awt.Color(153, 153, 153));
        txt_NombreCV.setBorder(null);
        txt_NombreCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreCVActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCV.add(txt_NombreCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 140, 20));

        jLabel_ApellidoCV.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ApellidoCV.setText("Apellidos");
        jPanel_MantenimientoCV.add(jLabel_ApellidoCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, -1, -1));

        txt_ApellidoCV.setBackground(new java.awt.Color(231, 231, 231));
        txt_ApellidoCV.setForeground(new java.awt.Color(153, 153, 153));
        txt_ApellidoCV.setBorder(null);
        txt_ApellidoCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ApellidoCVActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCV.add(txt_ApellidoCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 140, 20));

        jLabel_TelefonoCV.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_TelefonoCV.setText("Telefono");
        jPanel_MantenimientoCV.add(jLabel_TelefonoCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, -1, -1));

        txt_TelefonoCV.setBackground(new java.awt.Color(231, 231, 231));
        txt_TelefonoCV.setForeground(new java.awt.Color(153, 153, 153));
        txt_TelefonoCV.setBorder(null);
        txt_TelefonoCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TelefonoCVActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCV.add(txt_TelefonoCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, 140, 20));

        jLabel_CorreoCV.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CorreoCV.setText("Correo Electronico");
        jPanel_MantenimientoCV.add(jLabel_CorreoCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 300, -1, -1));

        txt_CorreoCV.setBackground(new java.awt.Color(231, 231, 231));
        txt_CorreoCV.setForeground(new java.awt.Color(153, 153, 153));
        txt_CorreoCV.setBorder(null);
        txt_CorreoCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CorreoCVActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCV.add(txt_CorreoCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 330, 140, 20));

        jLabel_DireccionCV.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_DireccionCV.setText("Direccion");
        jPanel_MantenimientoCV.add(jLabel_DireccionCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, -1));

        txt_DireccionCV.setBackground(new java.awt.Color(231, 231, 231));
        txt_DireccionCV.setForeground(new java.awt.Color(153, 153, 153));
        txt_DireccionCV.setBorder(null);
        txt_DireccionCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DireccionCVActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCV.add(txt_DireccionCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 140, 20));

        jLabel_GeneroCV.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_GeneroCV.setText("Genero");
        jPanel_MantenimientoCV.add(jLabel_GeneroCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, -1, -1));

        txt_GeneroCV.setBackground(new java.awt.Color(231, 231, 231));
        txt_GeneroCV.setForeground(new java.awt.Color(153, 153, 153));
        txt_GeneroCV.setBorder(null);
        txt_GeneroCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_GeneroCVActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCV.add(txt_GeneroCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 140, 20));

        jLabel_EdadCV.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_EdadCV.setText("Edad");
        jPanel_MantenimientoCV.add(jLabel_EdadCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, -1, -1));

        txt_EdadCV.setBackground(new java.awt.Color(231, 231, 231));
        txt_EdadCV.setForeground(new java.awt.Color(153, 153, 153));
        txt_EdadCV.setBorder(null);
        txt_EdadCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_EdadCVActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCV.add(txt_EdadCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 140, 20));

        jLabel_NivelACV.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NivelACV.setText("Nivel Academico");
        jPanel_MantenimientoCV.add(jLabel_NivelACV, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, -1, -1));

        jComboBox_NivelACV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_NivelACVActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCV.add(jComboBox_NivelACV, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, 140, -1));

        jLabel_RPCV.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_RPCV.setText("Referencia Personal");
        jPanel_MantenimientoCV.add(jLabel_RPCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 370, -1, -1));

        jComboBox_RPCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_RPCVActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCV.add(jComboBox_RPCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 400, 140, -1));

        jLabel_RLCV.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_RLCV.setText("Referencia Laboral");
        jPanel_MantenimientoCV.add(jLabel_RLCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, -1, -1));

        jComboBox_RLCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_RLCVActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCV.add(jComboBox_RLCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 140, -1));

        jLabel_ELCV.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ELCV.setText("Experiencia Laboral");
        jPanel_MantenimientoCV.add(jLabel_ELCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, -1, -1));

        jComboBox_ELCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ELCVActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCV.add(jComboBox_ELCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 140, -1));

        jLabel_MedioCV.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MedioCV.setText("Medio");
        jPanel_MantenimientoCV.add(jLabel_MedioCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 440, -1, -1));

        jComboBox_MedioCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_MedioCVActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCV.add(jComboBox_MedioCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 470, 140, -1));

        jLabel_Insertar_CV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_Insertar_CV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Insertar_CVMouseClicked(evt);
            }
        });
        jPanel_MantenimientoCV.add(jLabel_Insertar_CV, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, -1, -1));

        jLabel_Modificar_CV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_Modificar_CV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Modificar_CVMouseClicked(evt);
            }
        });
        jPanel_MantenimientoCV.add(jLabel_Modificar_CV, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, -1, -1));

        jLabel_Eliminar_CV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar_CV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Eliminar_CVMouseClicked(evt);
            }
        });
        jPanel_MantenimientoCV.add(jLabel_Eliminar_CV, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, -1, -1));

        jLabel_Buscar_CV.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_CV.setText("Buscar");
        jPanel_MantenimientoCV.add(jLabel_Buscar_CV, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 550, -1, -1));

        txt_Buscar_CV.setBackground(new java.awt.Color(231, 231, 231));
        txt_Buscar_CV.setForeground(new java.awt.Color(153, 153, 153));
        txt_Buscar_CV.setBorder(null);
        txt_Buscar_CV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Buscar_CVActionPerformed(evt);
            }
        });
        txt_Buscar_CV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Buscar_CVKeyReleased(evt);
            }
        });
        jPanel_MantenimientoCV.add(txt_Buscar_CV, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, 290, 20));

        tbl_CV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_CV.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_CV.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_CV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CVMouseClicked(evt);
            }
        });
        jScrollPane30.setViewportView(tbl_CV);

        jPanel_MantenimientoCV.add(jScrollPane30, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 590, 730, 190));

        jLabel_NivelA_CV.setForeground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoCV.add(jLabel_NivelA_CV, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 400, 30, 20));

        jLabel_RL_CV.setForeground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoCV.add(jLabel_RL_CV, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 30, 20));

        jLabel_EL_CV.setForeground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoCV.add(jLabel_EL_CV, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 30, 20));
        jPanel_MantenimientoCV.add(jLabel_Correo_CV, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 50, 30, 20));

        jLabel_RP_CV.setForeground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoCV.add(jLabel_RP_CV, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 400, 30, 20));

        jLabel_Medio_CV.setForeground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoCV.add(jLabel_Medio_CV, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 470, 30, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientoCV.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 550, -1, -1));

        jLabel_TituloSE3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Curriculum.png"))); // NOI18N
        jPanel_MantenimientoCV.add(jLabel_TituloSE3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 400, 120));

        Panel_IngresarM4.setBackground(new java.awt.Color(28, 27, 33));
        Panel_IngresarM4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_IngresarM4MouseClicked(evt);
            }
        });
        Panel_IngresarM4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_IngresarSE4.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_IngresarSE4.setForeground(new java.awt.Color(255, 255, 255));
        Texto_IngresarSE4.setText("Ingresar");
        Texto_IngresarSE4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_IngresarSE4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_IngresarSE4MouseClicked(evt);
            }
        });
        Panel_IngresarM4.add(Texto_IngresarSE4, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoCV.add(Panel_IngresarM4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 130, 50));

        Panel_ModificarM4.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ModificarM4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ModificarM4MouseClicked(evt);
            }
        });
        Panel_ModificarM4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ModificarSE4.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ModificarSE4.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ModificarSE4.setText("Modificar");
        Texto_ModificarSE4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ModificarSE4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ModificarSE4MouseClicked(evt);
            }
        });
        Panel_ModificarM4.add(Texto_ModificarSE4, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientoCV.add(Panel_ModificarM4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 130, 50));

        Panel_EliminarM4.setBackground(new java.awt.Color(28, 27, 33));
        Panel_EliminarM4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_EliminarM4MouseClicked(evt);
            }
        });
        Panel_EliminarM4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_EliminarSE4.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_EliminarSE4.setForeground(new java.awt.Color(255, 255, 255));
        Texto_EliminarSE4.setText("Eliminar");
        Texto_EliminarSE4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_EliminarSE4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_EliminarSE4MouseClicked(evt);
            }
        });
        Panel_EliminarM4.add(Texto_EliminarSE4, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoCV.add(Panel_EliminarM4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 130, 50));

        Panel_ConsultarM4.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ConsultarM4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ConsultarM4MouseClicked(evt);
            }
        });
        Panel_ConsultarM4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ConsultarSE4.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ConsultarSE4.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ConsultarSE4.setText("Consultar");
        Texto_ConsultarSE4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ConsultarSE4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ConsultarSE4MouseClicked(evt);
            }
        });
        Panel_ConsultarM4.add(Texto_ConsultarSE4, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientoCV.add(Panel_ConsultarM4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 130, 50));

        jComboBox_TablasB_CV1.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_TablasB_CV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TablasB_CV1ActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCV.add(jComboBox_TablasB_CV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 610, 170, -1));

        jLabel_Buscar_Tablas1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_Tablas1.setText("Buscar");
        jLabel_Buscar_Tablas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Buscar_Tablas1MouseClicked(evt);
            }
        });
        jPanel_MantenimientoCV.add(jLabel_Buscar_Tablas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 660, -1, -1));

        getContentPane().add(jPanel_MantenimientoCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1080, 700));

        jPanel_MantenimientosRP.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientosRP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_ID_RP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_RP.setText("ID Referencia Personal");
        jPanel_MantenimientosRP.add(jLabel_ID_RP, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, -1, -1));

        txt_id_RP.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_RP.setForeground(new java.awt.Color(153, 153, 153));
        txt_id_RP.setBorder(null);
        txt_id_RP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_RPActionPerformed(evt);
            }
        });
        jPanel_MantenimientosRP.add(txt_id_RP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 140, 20));

        jLabel_Nombre_RP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre_RP.setText("Nombre Persona Referencia Personal");
        jPanel_MantenimientosRP.add(jLabel_Nombre_RP, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, -1, -1));

        txt_Nombre_RP.setBackground(new java.awt.Color(40, 41, 46));
        txt_Nombre_RP.setForeground(new java.awt.Color(153, 153, 153));
        txt_Nombre_RP.setBorder(null);
        txt_Nombre_RP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Nombre_RPActionPerformed(evt);
            }
        });
        jPanel_MantenimientosRP.add(txt_Nombre_RP, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 220, 20));

        jLabel_Telefono_RP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Telefono_RP.setText("Telefono Referencia Personal");
        jPanel_MantenimientosRP.add(jLabel_Telefono_RP, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, -1, -1));

        txt_Telefono_RP.setBackground(new java.awt.Color(40, 41, 46));
        txt_Telefono_RP.setForeground(new java.awt.Color(153, 153, 153));
        txt_Telefono_RP.setBorder(null);
        txt_Telefono_RP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Telefono_RPActionPerformed(evt);
            }
        });
        jPanel_MantenimientosRP.add(txt_Telefono_RP, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 330, 170, 20));

        jLabel_Insertar_RP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_Insertar_RP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Insertar_RPMouseClicked(evt);
            }
        });
        jPanel_MantenimientosRP.add(jLabel_Insertar_RP, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, -1, -1));

        jLabel_Modificar_RP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_Modificar_RP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Modificar_RPMouseClicked(evt);
            }
        });
        jPanel_MantenimientosRP.add(jLabel_Modificar_RP, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, -1, -1));

        jLabel_Eliminar_RP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar_RP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Eliminar_RPMouseClicked(evt);
            }
        });
        jPanel_MantenimientosRP.add(jLabel_Eliminar_RP, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, -1, -1));

        txt_Buscar_RP.setBackground(new java.awt.Color(40, 41, 46));
        txt_Buscar_RP.setForeground(new java.awt.Color(153, 153, 153));
        txt_Buscar_RP.setBorder(null);
        txt_Buscar_RP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Buscar_RPActionPerformed(evt);
            }
        });
        txt_Buscar_RP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Buscar_RPKeyReleased(evt);
            }
        });
        jPanel_MantenimientosRP.add(txt_Buscar_RP, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 290, 20));

        jLabel_Buscar_RP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_RP.setText("Buscar");
        jPanel_MantenimientosRP.add(jLabel_Buscar_RP, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, -1, -1));

        tbl_RP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_RP.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_RP.setSelectionBackground(new java.awt.Color(0, 204, 255));
        jScrollPane29.setViewportView(tbl_RP);

        jPanel_MantenimientosRP.add(jScrollPane29, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 600, 190));

        jLabel_TituloSE2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Referencia Personales.png"))); // NOI18N
        jPanel_MantenimientosRP.add(jLabel_TituloSE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientosRP.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, -1));

        Panel_IngresarM3.setBackground(new java.awt.Color(28, 27, 33));
        Panel_IngresarM3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_IngresarM3MouseClicked(evt);
            }
        });
        Panel_IngresarM3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_IngresarSE3.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_IngresarSE3.setForeground(new java.awt.Color(255, 255, 255));
        Texto_IngresarSE3.setText("Ingresar");
        Texto_IngresarSE3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_IngresarSE3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_IngresarSE3MouseClicked(evt);
            }
        });
        Panel_IngresarM3.add(Texto_IngresarSE3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientosRP.add(Panel_IngresarM3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 130, 50));

        Panel_ModificarM3.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ModificarM3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ModificarM3MouseClicked(evt);
            }
        });
        Panel_ModificarM3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ModificarSE3.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ModificarSE3.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ModificarSE3.setText("Modificar");
        Texto_ModificarSE3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ModificarSE3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ModificarSE3MouseClicked(evt);
            }
        });
        Panel_ModificarM3.add(Texto_ModificarSE3, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientosRP.add(Panel_ModificarM3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 130, 50));

        Panel_EliminarM3.setBackground(new java.awt.Color(28, 27, 33));
        Panel_EliminarM3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_EliminarM3MouseClicked(evt);
            }
        });
        Panel_EliminarM3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_EliminarSE3.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_EliminarSE3.setForeground(new java.awt.Color(255, 255, 255));
        Texto_EliminarSE3.setText("Eliminar");
        Texto_EliminarSE3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_EliminarSE3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_EliminarSE3MouseClicked(evt);
            }
        });
        Panel_EliminarM3.add(Texto_EliminarSE3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientosRP.add(Panel_EliminarM3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 130, 50));

        Panel_ConsultarM3.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ConsultarM3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ConsultarM3MouseClicked(evt);
            }
        });
        Panel_ConsultarM3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ConsultarSE3.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ConsultarSE3.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ConsultarSE3.setText("Consultar");
        Texto_ConsultarSE3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ConsultarSE3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ConsultarSE3MouseClicked(evt);
            }
        });
        Panel_ConsultarM3.add(Texto_ConsultarSE3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientosRP.add(Panel_ConsultarM3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 130, 50));

        getContentPane().add(jPanel_MantenimientosRP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1040, 640));

        jPanel_MantenimientoRL.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoRL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id_ReferenciaL.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_ReferenciaL.setForeground(new java.awt.Color(153, 153, 153));
        txt_id_ReferenciaL.setBorder(null);
        txt_id_ReferenciaL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_ReferenciaLActionPerformed(evt);
            }
        });
        jPanel_MantenimientoRL.add(txt_id_ReferenciaL, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 140, 20));

        jLabel_ID_ReferenciaL.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_ReferenciaL.setText("ID Referencia Laboral");
        jPanel_MantenimientoRL.add(jLabel_ID_ReferenciaL, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, -1));

        txt_NombreRL.setBackground(new java.awt.Color(40, 41, 46));
        txt_NombreRL.setForeground(new java.awt.Color(153, 153, 153));
        txt_NombreRL.setBorder(null);
        txt_NombreRL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreRLActionPerformed(evt);
            }
        });
        jPanel_MantenimientoRL.add(txt_NombreRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 210, 20));

        jLabel_NombreRL.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreRL.setText("Nombre Persona Referencia Laboral");
        jPanel_MantenimientoRL.add(jLabel_NombreRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, -1, -1));

        txt_TelefonoRL.setBackground(new java.awt.Color(40, 41, 46));
        txt_TelefonoRL.setForeground(new java.awt.Color(153, 153, 153));
        txt_TelefonoRL.setBorder(null);
        txt_TelefonoRL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TelefonoRLActionPerformed(evt);
            }
        });
        jPanel_MantenimientoRL.add(txt_TelefonoRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 210, 20));

        jLabel_TelefonoRL.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_TelefonoRL.setText("Telefono Persona Referencia Laboral");
        jPanel_MantenimientoRL.add(jLabel_TelefonoRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, -1, -1));

        jLabel_IngresarRL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_IngresarRL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_IngresarRL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_IngresarRLMouseClicked(evt);
            }
        });
        jPanel_MantenimientoRL.add(jLabel_IngresarRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 400, 50, 50));

        jLabel_ModificarRL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_ModificarRL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_ModificarRLMouseClicked(evt);
            }
        });
        jPanel_MantenimientoRL.add(jLabel_ModificarRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 400, 50, 50));

        jLabel_EliminarRL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_EliminarRL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EliminarRLMouseClicked(evt);
            }
        });
        jPanel_MantenimientoRL.add(jLabel_EliminarRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 400, 50, 50));

        tbl_RL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_RL.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_RL.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_RL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_RLMouseClicked(evt);
            }
        });
        jScrollPane28.setViewportView(tbl_RL);

        jPanel_MantenimientoRL.add(jScrollPane28, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 600, 190));

        jLabel_BuscarRL.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_BuscarRL.setText("Buscar");
        jLabel_BuscarRL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_BuscarRLMouseClicked(evt);
            }
        });
        jPanel_MantenimientoRL.add(jLabel_BuscarRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, 50, 20));

        txt_BuscarRL.setBackground(new java.awt.Color(40, 41, 46));
        txt_BuscarRL.setForeground(new java.awt.Color(153, 153, 153));
        txt_BuscarRL.setBorder(null);
        txt_BuscarRL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarRLActionPerformed(evt);
            }
        });
        txt_BuscarRL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarRLKeyReleased(evt);
            }
        });
        jPanel_MantenimientoRL.add(txt_BuscarRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 240, 20));

        jLabel_TituloRL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Referencia Laborales.png"))); // NOI18N
        jPanel_MantenimientoRL.add(jLabel_TituloRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        Panel_IngresarRL.setBackground(new java.awt.Color(28, 27, 33));
        Panel_IngresarRL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_IngresarRLMouseClicked(evt);
            }
        });
        Panel_IngresarRL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_IngresarRL.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_IngresarRL.setForeground(new java.awt.Color(255, 255, 255));
        Texto_IngresarRL.setText("Ingresar");
        Texto_IngresarRL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_IngresarRL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_IngresarRLMouseClicked(evt);
            }
        });
        Panel_IngresarRL.add(Texto_IngresarRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoRL.add(Panel_IngresarRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 130, 50));

        Panel_ModificarRL.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ModificarRL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ModificarRLMouseClicked(evt);
            }
        });
        Panel_ModificarRL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ModificarRL.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ModificarRL.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ModificarRL.setText("Modificar");
        Texto_ModificarRL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ModificarRL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ModificarRLMouseClicked(evt);
            }
        });
        Panel_ModificarRL.add(Texto_ModificarRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientoRL.add(Panel_ModificarRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 130, 50));

        Panel_EliminarRL.setBackground(new java.awt.Color(28, 27, 33));
        Panel_EliminarRL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_EliminarRLMouseClicked(evt);
            }
        });
        Panel_EliminarRL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_EliminarRL.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_EliminarRL.setForeground(new java.awt.Color(255, 255, 255));
        Texto_EliminarRL.setText("Eliminar");
        Texto_EliminarRL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_EliminarRL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_EliminarRLMouseClicked(evt);
            }
        });
        Panel_EliminarRL.add(Texto_EliminarRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoRL.add(Panel_EliminarRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 130, 50));

        Panel_ConsultarRL.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ConsultarRL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ConsultarRLMouseClicked(evt);
            }
        });
        Panel_ConsultarRL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ConsultarRL.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ConsultarRL.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ConsultarRL.setText("Consultar");
        Texto_ConsultarRL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ConsultarRL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ConsultarRLMouseClicked(evt);
            }
        });
        Panel_ConsultarRL.add(Texto_ConsultarRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientoRL.add(Panel_ConsultarRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 130, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientoRL.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, -1, -1));

        getContentPane().add(jPanel_MantenimientoRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1080, 700));

        jPanel_Mantenimiento_Medio.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_Mantenimiento_Medio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id_Medio.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_Medio.setBorder(null);
        txt_id_Medio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_MedioActionPerformed(evt);
            }
        });
        jPanel_Mantenimiento_Medio.add(txt_id_Medio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 140, 20));

        jLabel_ID_Medio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_Medio.setText("ID Medio ");
        jPanel_Mantenimiento_Medio.add(jLabel_ID_Medio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 60, -1));

        jLabel_NombreSEM.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreSEM.setText("ID de Solicitud Empresarial");
        jPanel_Mantenimiento_Medio.add(jLabel_NombreSEM, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, -1));

        jLabel_ID_SEM.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_Mantenimiento_Medio.add(jLabel_ID_SEM, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 30, 20));

        jComboBox_IDSEM.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_IDSEM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_IDSEMActionPerformed(evt);
            }
        });
        jPanel_Mantenimiento_Medio.add(jComboBox_IDSEM, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 140, 20));

        txt_NombreM.setBackground(new java.awt.Color(40, 41, 46));
        txt_NombreM.setBorder(null);
        txt_NombreM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreMActionPerformed(evt);
            }
        });
        jPanel_Mantenimiento_Medio.add(txt_NombreM, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 140, 20));

        jLabel_NombreM.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreM.setText("Nombre Medio");
        jPanel_Mantenimiento_Medio.add(jLabel_NombreM, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 100, -1));

        jLabel_DescripcionM.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_DescripcionM.setText("Descripcion Medio");
        jPanel_Mantenimiento_Medio.add(jLabel_DescripcionM, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 350, -1, -1));

        jTextArea_DescripcionM.setBackground(new java.awt.Color(40, 41, 46));
        jTextArea_DescripcionM.setColumns(20);
        jTextArea_DescripcionM.setRows(5);
        jTextArea_DescripcionM.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane3.setViewportView(jTextArea_DescripcionM);

        jPanel_Mantenimiento_Medio.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 380, -1, -1));

        tbl_Medio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_Medio.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Medio.setSelectionBackground(new java.awt.Color(0, 204, 255));
        jScrollPane27.setViewportView(tbl_Medio);

        jPanel_Mantenimiento_Medio.add(jScrollPane27, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, 600, 190));

        jLabel_BuscarM.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_BuscarM.setText("Buscar");
        jLabel_BuscarM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_BuscarMMouseClicked(evt);
            }
        });
        jPanel_Mantenimiento_Medio.add(jLabel_BuscarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, 40, 20));

        txt_BuscarM.setBackground(new java.awt.Color(40, 41, 46));
        txt_BuscarM.setBorder(null);
        txt_BuscarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarMActionPerformed(evt);
            }
        });
        txt_BuscarM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarMKeyReleased(evt);
            }
        });
        jPanel_Mantenimiento_Medio.add(txt_BuscarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 240, 20));

        jLabel_IngresarM.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IngresarM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_IngresarM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_IngresarM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_IngresarMMouseClicked(evt);
            }
        });
        jPanel_Mantenimiento_Medio.add(jLabel_IngresarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 50, 50));

        jLabel_ModificarM.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ModificarM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_ModificarM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_ModificarMMouseClicked(evt);
            }
        });
        jPanel_Mantenimiento_Medio.add(jLabel_ModificarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 50, 50));

        jLabel_EliminarM.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_EliminarM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_EliminarM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EliminarMMouseClicked(evt);
            }
        });
        jPanel_Mantenimiento_Medio.add(jLabel_EliminarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, 50, 60));

        jLabel_TituloSE1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Medio.png"))); // NOI18N
        jPanel_Mantenimiento_Medio.add(jLabel_TituloSE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        Panel_IngresarM2.setBackground(new java.awt.Color(28, 27, 33));
        Panel_IngresarM2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_IngresarM2MouseClicked(evt);
            }
        });
        Panel_IngresarM2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_IngresarSE2.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_IngresarSE2.setForeground(new java.awt.Color(255, 255, 255));
        Texto_IngresarSE2.setText("Ingresar");
        Texto_IngresarSE2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_IngresarSE2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_IngresarSE2MouseClicked(evt);
            }
        });
        Panel_IngresarM2.add(Texto_IngresarSE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_Mantenimiento_Medio.add(Panel_IngresarM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 130, 50));

        Panel_ModificarM2.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ModificarM2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ModificarM2MouseClicked(evt);
            }
        });
        Panel_ModificarM2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ModificarSE2.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ModificarSE2.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ModificarSE2.setText("Modificar");
        Texto_ModificarSE2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ModificarSE2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ModificarSE2MouseClicked(evt);
            }
        });
        Panel_ModificarM2.add(Texto_ModificarSE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_Mantenimiento_Medio.add(Panel_ModificarM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 130, 50));

        Panel_EliminarM2.setBackground(new java.awt.Color(28, 27, 33));
        Panel_EliminarM2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_EliminarM2MouseClicked(evt);
            }
        });
        Panel_EliminarM2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_EliminarSE2.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_EliminarSE2.setForeground(new java.awt.Color(255, 255, 255));
        Texto_EliminarSE2.setText("Eliminar");
        Texto_EliminarSE2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_EliminarSE2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_EliminarSE2MouseClicked(evt);
            }
        });
        Panel_EliminarM2.add(Texto_EliminarSE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_Mantenimiento_Medio.add(Panel_EliminarM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 130, 50));

        Panel_ConsultarM2.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ConsultarM2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ConsultarM2MouseClicked(evt);
            }
        });
        Panel_ConsultarM2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ConsultarSE2.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ConsultarSE2.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ConsultarSE2.setText("Consultar");
        Texto_ConsultarSE2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ConsultarSE2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ConsultarSE2MouseClicked(evt);
            }
        });
        Panel_ConsultarM2.add(Texto_ConsultarSE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_Mantenimiento_Medio.add(Panel_ConsultarM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 130, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_Mantenimiento_Medio.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, -1, -1));

        jComboBox_TablasB_M1.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_TablasB_M1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TablasB_M1ActionPerformed(evt);
            }
        });
        jPanel_Mantenimiento_Medio.add(jComboBox_TablasB_M1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 510, 170, -1));

        jLabel_Buscar_Tablas_M1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_Tablas_M1.setText("Buscar");
        jLabel_Buscar_Tablas_M1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Buscar_Tablas_M1MouseClicked(evt);
            }
        });
        jPanel_Mantenimiento_Medio.add(jLabel_Buscar_Tablas_M1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 540, -1, -1));

        getContentPane().add(jPanel_Mantenimiento_Medio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1080, 700));

        jPanel_MantenimientoSE.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoSE.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoSE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_DescripcionSE.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_DescripcionSE.setText("Descripcion Solicitud Empresarial");
        jPanel_MantenimientoSE.add(jLabel_DescripcionSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 400, -1, -1));

        txt_id_SolicitudE.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_SolicitudE.setForeground(new java.awt.Color(153, 153, 153));
        txt_id_SolicitudE.setBorder(null);
        txt_id_SolicitudE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_SolicitudEActionPerformed(evt);
            }
        });
        jPanel_MantenimientoSE.add(txt_id_SolicitudE, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 140, 20));

        jLabel_RangoEdadM.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_RangoEdadM.setText("Rango de Edad Menor");
        jPanel_MantenimientoSE.add(jLabel_RangoEdadM, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, -1));

        txt_RangoEdadM.setBackground(new java.awt.Color(40, 41, 46));
        txt_RangoEdadM.setForeground(new java.awt.Color(153, 153, 153));
        txt_RangoEdadM.setBorder(null);
        txt_RangoEdadM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RangoEdadMActionPerformed(evt);
            }
        });
        jPanel_MantenimientoSE.add(txt_RangoEdadM, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 140, 20));

        jLabel_RangoEdadMa.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_RangoEdadMa.setText("Rango de Edad Mayor");
        jPanel_MantenimientoSE.add(jLabel_RangoEdadMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, -1, -1));

        txt_RangoEdadMa.setBackground(new java.awt.Color(40, 41, 46));
        txt_RangoEdadMa.setForeground(new java.awt.Color(153, 153, 153));
        txt_RangoEdadMa.setBorder(null);
        txt_RangoEdadMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RangoEdadMaActionPerformed(evt);
            }
        });
        jPanel_MantenimientoSE.add(txt_RangoEdadMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 140, 20));

        jLabel_RangoEdadMa1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_RangoEdadMa1.setText("Genero");
        jPanel_MantenimientoSE.add(jLabel_RangoEdadMa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, -1, -1));

        txt_Genero.setBackground(new java.awt.Color(40, 41, 46));
        txt_Genero.setForeground(new java.awt.Color(153, 153, 153));
        txt_Genero.setBorder(null);
        txt_Genero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_GeneroActionPerformed(evt);
            }
        });
        jPanel_MantenimientoSE.add(txt_Genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 140, 20));

        jLabel_PuestoSE.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_PuestoSE.setText("Puesto");
        jPanel_MantenimientoSE.add(jLabel_PuestoSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 310, -1, -1));

        jLabel_Puesto_SE.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Puesto_SE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Puesto_SEMouseClicked(evt);
            }
        });
        jPanel_MantenimientoSE.add(jLabel_Puesto_SE, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 340, 30, 20));

        jComboBox_PuestoSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_PuestoSEActionPerformed(evt);
            }
        });
        jPanel_MantenimientoSE.add(jComboBox_PuestoSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 340, 140, -1));

        jLabel_DepartamentoSE.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_DepartamentoSE.setText("Departamento");
        jPanel_MantenimientoSE.add(jLabel_DepartamentoSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, -1, -1));

        jLabel_Departamento_SE.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoSE.add(jLabel_Departamento_SE, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 30, 20));

        jComboBox_DepartamentoSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_DepartamentoSEActionPerformed(evt);
            }
        });
        jPanel_MantenimientoSE.add(jComboBox_DepartamentoSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 140, -1));

        jLabel_NivelASE.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NivelASE.setText("Nivel Academico");
        jPanel_MantenimientoSE.add(jLabel_NivelASE, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 100, -1));

        jLabel_NivelA_SE.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NivelA_SE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_NivelA_SEMouseClicked(evt);
            }
        });
        jPanel_MantenimientoSE.add(jLabel_NivelA_SE, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 30, 20));

        jComboBox_NivelASE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_NivelASEActionPerformed(evt);
            }
        });
        jPanel_MantenimientoSE.add(jComboBox_NivelASE, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 140, -1));

        jLabel_ExperieciaLSE.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ExperieciaLSE.setText("Experiencia Laboral");
        jPanel_MantenimientoSE.add(jLabel_ExperieciaLSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 130, -1));

        jLabel_ExperienciaL_SE.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoSE.add(jLabel_ExperienciaL_SE, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, 30, 20));

        jComboBox_ExperienciaL_SE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ExperienciaL_SEActionPerformed(evt);
            }
        });
        jPanel_MantenimientoSE.add(jComboBox_ExperienciaL_SE, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 140, -1));

        jLabel_ID_SolicitudE1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_SolicitudE1.setText("ID Solicitud Empresarial");
        jPanel_MantenimientoSE.add(jLabel_ID_SolicitudE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, -1));

        jTextArea_DescripcionSE.setBackground(new java.awt.Color(40, 41, 46));
        jTextArea_DescripcionSE.setColumns(20);
        jTextArea_DescripcionSE.setRows(5);
        jTextArea_DescripcionSE.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jScrollPane1.setViewportView(jTextArea_DescripcionSE);

        jPanel_MantenimientoSE.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 420, -1, -1));

        tbl_SE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_SE.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_SE.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_SE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SEMouseClicked(evt);
            }
        });
        jScrollPane26.setViewportView(tbl_SE);

        jPanel_MantenimientoSE.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, 750, 160));

        txt_Buscar_SE.setBackground(new java.awt.Color(40, 41, 46));
        txt_Buscar_SE.setForeground(new java.awt.Color(153, 153, 153));
        txt_Buscar_SE.setBorder(null);
        txt_Buscar_SE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_Buscar_SEMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_Buscar_SEMouseReleased(evt);
            }
        });
        txt_Buscar_SE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Buscar_SEActionPerformed(evt);
            }
        });
        txt_Buscar_SE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Buscar_SEKeyReleased(evt);
            }
        });
        jPanel_MantenimientoSE.add(txt_Buscar_SE, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 290, 20));

        jLabel_Buscar_SE.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_SE.setText("Buscar");
        jLabel_Buscar_SE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Buscar_SEMouseClicked(evt);
            }
        });
        jPanel_MantenimientoSE.add(jLabel_Buscar_SE, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, -1, -1));

        jLabel_IngresarSE.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IngresarSE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_IngresarSE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_IngresarSE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_IngresarSEMouseClicked(evt);
            }
        });
        jPanel_MantenimientoSE.add(jLabel_IngresarSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 480, 50, 40));

        jLabel_Modificar_SE.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Modificar_SE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_Modificar_SE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Modificar_SEMouseClicked(evt);
            }
        });
        jPanel_MantenimientoSE.add(jLabel_Modificar_SE, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 480, 50, 40));

        jLabel_Eliminar_SE.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Eliminar_SE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar_SE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Eliminar_SEMouseClicked(evt);
            }
        });
        jPanel_MantenimientoSE.add(jLabel_Eliminar_SE, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 50, 60));

        jLabel_TituloSE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Solicitud Empresarial.png"))); // NOI18N
        jPanel_MantenimientoSE.add(jLabel_TituloSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        Panel_IngresarSE.setBackground(new java.awt.Color(28, 27, 33));
        Panel_IngresarSE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_IngresarSEMouseClicked(evt);
            }
        });
        Panel_IngresarSE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_IngresarSE.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_IngresarSE.setForeground(new java.awt.Color(255, 255, 255));
        Texto_IngresarSE.setText("Ingresar");
        Texto_IngresarSE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_IngresarSE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_IngresarSEMouseClicked(evt);
            }
        });
        Panel_IngresarSE.add(Texto_IngresarSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoSE.add(Panel_IngresarSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 130, 50));

        Panel_ModificarSE.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ModificarSE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ModificarSEMouseClicked(evt);
            }
        });
        Panel_ModificarSE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ModificarSE.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ModificarSE.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ModificarSE.setText("Modificar");
        Texto_ModificarSE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ModificarSE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ModificarSEMouseClicked(evt);
            }
        });
        Panel_ModificarSE.add(Texto_ModificarSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientoSE.add(Panel_ModificarSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 130, 50));

        Panel_EliminarSE.setBackground(new java.awt.Color(28, 27, 33));
        Panel_EliminarSE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_EliminarSE.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_EliminarSE.setForeground(new java.awt.Color(255, 255, 255));
        Texto_EliminarSE.setText("Eliminar");
        Texto_EliminarSE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_EliminarSE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_EliminarSEMouseClicked(evt);
            }
        });
        Panel_EliminarSE.add(Texto_EliminarSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoSE.add(Panel_EliminarSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 130, 50));

        Panel_ConsultarSE.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ConsultarSE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ConsultarSEMouseClicked(evt);
            }
        });
        Panel_ConsultarSE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ConsultarSE.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ConsultarSE.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ConsultarSE.setText("Consultar");
        Texto_ConsultarSE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ConsultarSE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ConsultarSEMouseClicked(evt);
            }
        });
        Panel_ConsultarSE.add(Texto_ConsultarSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientoSE.add(Panel_ConsultarSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 130, 50));

        jComboBox_TablasB_SE.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_TablasB_SE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TablasB_SEActionPerformed(evt);
            }
        });
        jPanel_MantenimientoSE.add(jComboBox_TablasB_SE, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 560, 170, -1));

        jLabel_Buscar_Tablas_SE.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_Tablas_SE.setText("Buscar");
        jLabel_Buscar_Tablas_SE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Buscar_Tablas_SEMouseClicked(evt);
            }
        });
        jPanel_MantenimientoSE.add(jLabel_Buscar_Tablas_SE, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 590, -1, -1));

        icono_BuscarSE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientoSE.add(icono_BuscarSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, 20, 20));

        getContentPane().add(jPanel_MantenimientoSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1080, 700));

        jPanel_MantenimientoExpL.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoExpL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_MantenimientoExpLMouseClicked(evt);
            }
        });
        jPanel_MantenimientoExpL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_ID_ExpL.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_ExpL.setText("ID Nivel  Experiencia Laboral");
        jPanel_MantenimientoExpL.add(jLabel_ID_ExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));

        txt_id_ExpL.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_ExpL.setForeground(new java.awt.Color(153, 153, 153));
        txt_id_ExpL.setBorder(null);
        txt_id_ExpL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_ExpLActionPerformed(evt);
            }
        });
        jPanel_MantenimientoExpL.add(txt_id_ExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 180, 20));

        jLabel_ID_ExpLLD.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_ExpLLD.setText("Experienca Laboral Detallada ");
        jPanel_MantenimientoExpL.add(jLabel_ID_ExpLLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, -1, -1));

        jLabel_id_Nombre_EpLLD.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoExpL.add(jLabel_id_Nombre_EpLLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 350, 40, 20));

        jLabel_Insertar_ExpL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_Insertar_ExpL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Insertar_ExpLMouseClicked(evt);
            }
        });
        jPanel_MantenimientoExpL.add(jLabel_Insertar_ExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, -1, -1));

        jLabel_Modificar_ExpL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_Modificar_ExpL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Modificar_ExpLMouseClicked(evt);
            }
        });
        jPanel_MantenimientoExpL.add(jLabel_Modificar_ExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, -1, -1));

        jLabel_Eliminar_ExpL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar_ExpL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Eliminar_ExpLMouseClicked(evt);
            }
        });
        jPanel_MantenimientoExpL.add(jLabel_Eliminar_ExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, -1, -1));

        txt_Buscar_ExpL.setBackground(new java.awt.Color(40, 41, 46));
        txt_Buscar_ExpL.setForeground(new java.awt.Color(153, 153, 153));
        txt_Buscar_ExpL.setBorder(null);
        txt_Buscar_ExpL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Buscar_ExpLActionPerformed(evt);
            }
        });
        txt_Buscar_ExpL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Buscar_ExpLKeyReleased(evt);
            }
        });
        jPanel_MantenimientoExpL.add(txt_Buscar_ExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 290, 20));

        jLabel_Buscar_ExpL.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_ExpL.setText("Buscar");
        jPanel_MantenimientoExpL.add(jLabel_Buscar_ExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, -1, -1));

        tbl_ExpL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_ExpL.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_ExpL.setSelectionBackground(new java.awt.Color(40, 41, 46));
        tbl_ExpL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ExpLMouseClicked(evt);
            }
        });
        jScrollPane25.setViewportView(tbl_ExpL);

        jPanel_MantenimientoExpL.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 500, 600, 190));

        jComboBox_Nombre_EpLLD.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_Nombre_EpLLD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Nombre_EpLLDActionPerformed(evt);
            }
        });
        jPanel_MantenimientoExpL.add(jComboBox_Nombre_EpLLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 170, -1));

        jLabel_TituloExpL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Experiencia Laboral.png"))); // NOI18N
        jPanel_MantenimientoExpL.add(jLabel_TituloExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        Panel_IngresarExpL.setBackground(new java.awt.Color(28, 27, 33));
        Panel_IngresarExpL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_IngresarExpLMouseClicked(evt);
            }
        });
        Panel_IngresarExpL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_IngresarExpL.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_IngresarExpL.setForeground(new java.awt.Color(255, 255, 255));
        Texto_IngresarExpL.setText("Ingresar");
        Texto_IngresarExpL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_IngresarExpL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_IngresarExpLMouseClicked(evt);
            }
        });
        Panel_IngresarExpL.add(Texto_IngresarExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoExpL.add(Panel_IngresarExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 130, 50));

        Panel_ModificarExpL.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ModificarExpL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ModificarExpLMouseClicked(evt);
            }
        });
        Panel_ModificarExpL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ModificarExpL.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ModificarExpL.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ModificarExpL.setText("Modificar");
        Texto_ModificarExpL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ModificarExpL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ModificarExpLMouseClicked(evt);
            }
        });
        Panel_ModificarExpL.add(Texto_ModificarExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientoExpL.add(Panel_ModificarExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 130, 50));

        Panel_EliminarExpL.setBackground(new java.awt.Color(28, 27, 33));
        Panel_EliminarExpL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_EliminarExpLMouseClicked(evt);
            }
        });
        Panel_EliminarExpL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_EliminarExpL.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_EliminarExpL.setForeground(new java.awt.Color(255, 255, 255));
        Texto_EliminarExpL.setText("Eliminar");
        Texto_EliminarExpL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_EliminarExpL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_EliminarExpLMouseClicked(evt);
            }
        });
        Panel_EliminarExpL.add(Texto_EliminarExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoExpL.add(Panel_EliminarExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 130, 50));

        Panel_ConsultarExpL.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ConsultarExpL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ConsultarExpL.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ConsultarExpL.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ConsultarExpL.setText("Consultar");
        Texto_ConsultarExpL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ConsultarExpL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ConsultarExpLMouseClicked(evt);
            }
        });
        Panel_ConsultarExpL.add(Texto_ConsultarExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientoExpL.add(Panel_ConsultarExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 130, 50));

        icono_Buscar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        icono_Buscar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icono_Buscar4MouseClicked(evt);
            }
        });
        jPanel_MantenimientoExpL.add(icono_Buscar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 20, 20));

        jComboBox_TablasB_ExpL.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_TablasB_ExpL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TablasB_ExpLActionPerformed(evt);
            }
        });
        jPanel_MantenimientoExpL.add(jComboBox_TablasB_ExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 510, 170, -1));

        jLabel_Buscar_Tablas.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_Tablas.setText("Buscar");
        jLabel_Buscar_Tablas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Buscar_TablasMouseClicked(evt);
            }
        });
        jPanel_MantenimientoExpL.add(jLabel_Buscar_Tablas, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 560, -1, -1));

        getContentPane().add(jPanel_MantenimientoExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1080, 700));

        jPanel_MantenimientoExpLD.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoExpLD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_ID_ExpLD.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_ExpLD.setText("ID Experiencia Laboral Detallada");
        jPanel_MantenimientoExpLD.add(jLabel_ID_ExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, -1));

        txt_id_ExpLD.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_ExpLD.setForeground(new java.awt.Color(153, 153, 153));
        txt_id_ExpLD.setBorder(null);
        txt_id_ExpLD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_ExpLDActionPerformed(evt);
            }
        });
        jPanel_MantenimientoExpLD.add(txt_id_ExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 190, 20));

        jLabel_NombreExpLD.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreExpLD.setText("Nombre de Experiencia Laboral Detallada");
        jPanel_MantenimientoExpLD.add(jLabel_NombreExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, -1, -1));

        txt_NombreExpLD.setBackground(new java.awt.Color(40, 41, 46));
        txt_NombreExpLD.setForeground(new java.awt.Color(153, 153, 153));
        txt_NombreExpLD.setBorder(null);
        txt_NombreExpLD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreExpLDActionPerformed(evt);
            }
        });
        jPanel_MantenimientoExpLD.add(txt_NombreExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 230, 20));

        jLabel_Nombre_EmpresaExpLD.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre_EmpresaExpLD.setText("Nombre Empresa de Experiencia Laboral Detallada");
        jPanel_MantenimientoExpLD.add(jLabel_Nombre_EmpresaExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, -1, -1));

        txt_Nombre_EmpresaExpLD.setBackground(new java.awt.Color(40, 41, 46));
        txt_Nombre_EmpresaExpLD.setForeground(new java.awt.Color(153, 153, 153));
        txt_Nombre_EmpresaExpLD.setBorder(null);
        txt_Nombre_EmpresaExpLD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Nombre_EmpresaExpLDActionPerformed(evt);
            }
        });
        jPanel_MantenimientoExpLD.add(txt_Nombre_EmpresaExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, 290, 20));

        jLabel_Tiempo_InicioExpLD.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Tiempo_InicioExpLD.setText("Tiempo de Inicio de Experiencia Laboral Detallada");
        jPanel_MantenimientoExpLD.add(jLabel_Tiempo_InicioExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, -1, -1));

        txt_Tiempo_InicioExpLD.setBackground(new java.awt.Color(40, 41, 46));
        txt_Tiempo_InicioExpLD.setForeground(new java.awt.Color(153, 153, 153));
        txt_Tiempo_InicioExpLD.setBorder(null);
        txt_Tiempo_InicioExpLD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Tiempo_InicioExpLDActionPerformed(evt);
            }
        });
        jPanel_MantenimientoExpLD.add(txt_Tiempo_InicioExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 280, 20));

        jLabel_Tiempo_FinalizacionExpLD.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Tiempo_FinalizacionExpLD.setText("Tiempo de Finalizacion de Experiencia Laboral Detallada");
        jPanel_MantenimientoExpLD.add(jLabel_Tiempo_FinalizacionExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, -1, -1));

        txt_Tiempo_FinalizacionExpLD.setBackground(new java.awt.Color(40, 41, 46));
        txt_Tiempo_FinalizacionExpLD.setForeground(new java.awt.Color(153, 153, 153));
        txt_Tiempo_FinalizacionExpLD.setBorder(null);
        txt_Tiempo_FinalizacionExpLD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Tiempo_FinalizacionExpLDActionPerformed(evt);
            }
        });
        jPanel_MantenimientoExpLD.add(txt_Tiempo_FinalizacionExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, 320, 20));

        jLabel_Insertar_ExpLD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_Insertar_ExpLD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Insertar_ExpLDMouseClicked(evt);
            }
        });
        jPanel_MantenimientoExpLD.add(jLabel_Insertar_ExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 480, -1, -1));

        jLabel_Modificar_ExpLD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_Modificar_ExpLD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Modificar_ExpLDMouseClicked(evt);
            }
        });
        jPanel_MantenimientoExpLD.add(jLabel_Modificar_ExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 480, -1, -1));

        jLabel_Eliminar_ExpLD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar_ExpLD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Eliminar_ExpLDMouseClicked(evt);
            }
        });
        jPanel_MantenimientoExpLD.add(jLabel_Eliminar_ExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 480, -1, -1));

        jLabel_Buscar_ExpLD.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_ExpLD.setText("Buscar");
        jPanel_MantenimientoExpLD.add(jLabel_Buscar_ExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, -1, -1));

        txt_Buscar_ExpLD.setBackground(new java.awt.Color(40, 41, 46));
        txt_Buscar_ExpLD.setForeground(new java.awt.Color(153, 153, 153));
        txt_Buscar_ExpLD.setBorder(null);
        txt_Buscar_ExpLD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Buscar_ExpLDActionPerformed(evt);
            }
        });
        txt_Buscar_ExpLD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Buscar_ExpLDKeyReleased(evt);
            }
        });
        jPanel_MantenimientoExpLD.add(txt_Buscar_ExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 500, 290, 20));

        tbl_ExpLD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_ExpLD.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_ExpLD.setSelectionBackground(new java.awt.Color(40, 41, 46));
        tbl_ExpLD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ExpLDMouseClicked(evt);
            }
        });
        jScrollPane24.setViewportView(tbl_ExpLD);

        jPanel_MantenimientoExpLD.add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 570, 730, 190));

        jLabel_TituloELD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Experiencia LaboralD.png"))); // NOI18N
        jPanel_MantenimientoExpLD.add(jLabel_TituloELD, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        Panel_IngresarExpLD.setBackground(new java.awt.Color(28, 27, 33));
        Panel_IngresarExpLD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_IngresarExpLDMouseClicked(evt);
            }
        });
        Panel_IngresarExpLD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_IngresarExpLD.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_IngresarExpLD.setForeground(new java.awt.Color(255, 255, 255));
        Texto_IngresarExpLD.setText("Ingresar");
        Texto_IngresarExpLD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_IngresarExpLD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_IngresarExpLDMouseClicked(evt);
            }
        });
        Panel_IngresarExpLD.add(Texto_IngresarExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoExpLD.add(Panel_IngresarExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 130, 50));

        Panel_ModificarExpLD.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ModificarExpLD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ModificarExpLDMouseClicked(evt);
            }
        });
        Panel_ModificarExpLD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ModificarExpLD.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ModificarExpLD.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ModificarExpLD.setText("Modificar");
        Texto_ModificarExpLD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ModificarExpLD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ModificarExpLDMouseClicked(evt);
            }
        });
        Panel_ModificarExpLD.add(Texto_ModificarExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientoExpLD.add(Panel_ModificarExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 130, 50));

        Panel_EliminarExpLD.setBackground(new java.awt.Color(28, 27, 33));
        Panel_EliminarExpLD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_EliminarExpLD.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_EliminarExpLD.setForeground(new java.awt.Color(255, 255, 255));
        Texto_EliminarExpLD.setText("Eliminar");
        Texto_EliminarExpLD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_EliminarExpLD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_EliminarExpLDMouseClicked(evt);
            }
        });
        Panel_EliminarExpLD.add(Texto_EliminarExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoExpLD.add(Panel_EliminarExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 130, 50));

        Panel_ConsultarExpLD.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ConsultarExpLD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ConsultarExpLD.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ConsultarExpLD.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ConsultarExpLD.setText("Consultar");
        Texto_ConsultarExpLD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ConsultarExpLD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ConsultarExpLDMouseClicked(evt);
            }
        });
        Panel_ConsultarExpLD.add(Texto_ConsultarExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientoExpLD.add(Panel_ConsultarExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 130, 50));

        icono_Buscar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientoExpLD.add(icono_Buscar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 20, 20));

        getContentPane().add(jPanel_MantenimientoExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 670, 780));

        jPanel_MantenimientoNA.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoNA.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_NivelA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_NivelA.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_NivelA.setSelectionBackground(new java.awt.Color(40, 41, 46));
        tbl_NivelA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NivelAMouseClicked(evt);
            }
        });
        jScrollPane23.setViewportView(tbl_NivelA);

        jPanel_MantenimientoNA.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 600, 190));

        jLabel_ID_NivelA.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_NivelA.setText("ID Nivel  Academico");
        jPanel_MantenimientoNA.add(jLabel_ID_NivelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));

        txt_id_NivelA.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_NivelA.setForeground(new java.awt.Color(255, 255, 255));
        txt_id_NivelA.setBorder(null);
        txt_id_NivelA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_NivelAActionPerformed(evt);
            }
        });
        jPanel_MantenimientoNA.add(txt_id_NivelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 140, 20));

        jLabel_Nombre_NivelA.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre_NivelA.setText("Nombre Nivel Academico");
        jPanel_MantenimientoNA.add(jLabel_Nombre_NivelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, -1, -1));

        txt_Nombre_NivelA.setBackground(new java.awt.Color(40, 41, 46));
        txt_Nombre_NivelA.setForeground(new java.awt.Color(255, 255, 255));
        txt_Nombre_NivelA.setBorder(null);
        txt_Nombre_NivelA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Nombre_NivelAActionPerformed(evt);
            }
        });
        jPanel_MantenimientoNA.add(txt_Nombre_NivelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 140, 20));

        jLabel_Descripcion_NivelA.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Descripcion_NivelA.setText("Descripcion Nivel Academico");
        jPanel_MantenimientoNA.add(jLabel_Descripcion_NivelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, -1, -1));

        txt_Descripcion_NivelA.setBackground(new java.awt.Color(40, 41, 46));
        txt_Descripcion_NivelA.setForeground(new java.awt.Color(255, 255, 255));
        txt_Descripcion_NivelA.setBorder(null);
        txt_Descripcion_NivelA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Descripcion_NivelAActionPerformed(evt);
            }
        });
        jPanel_MantenimientoNA.add(txt_Descripcion_NivelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 140, 20));

        jLabel_Insertar_NivelA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_Insertar_NivelA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Insertar_NivelA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Insertar_NivelAMouseClicked(evt);
            }
        });
        jPanel_MantenimientoNA.add(jLabel_Insertar_NivelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, -1, -1));

        jLabel_Eliminar_NivelA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar_NivelA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Eliminar_NivelA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Eliminar_NivelAMouseClicked(evt);
            }
        });
        jPanel_MantenimientoNA.add(jLabel_Eliminar_NivelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, -1, -1));

        jLabel_Modificar_NivelA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_Modificar_NivelA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Modificar_NivelA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Modificar_NivelAMouseClicked(evt);
            }
        });
        jPanel_MantenimientoNA.add(jLabel_Modificar_NivelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, -1, -1));

        jLabel_Buscar_NivelA.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_NivelA.setText("Buscar");
        jPanel_MantenimientoNA.add(jLabel_Buscar_NivelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, -1, -1));

        txt_Buscar_NivelA.setBackground(new java.awt.Color(40, 41, 46));
        txt_Buscar_NivelA.setForeground(new java.awt.Color(255, 255, 255));
        txt_Buscar_NivelA.setBorder(null);
        txt_Buscar_NivelA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Buscar_NivelAActionPerformed(evt);
            }
        });
        txt_Buscar_NivelA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Buscar_NivelAKeyReleased(evt);
            }
        });
        jPanel_MantenimientoNA.add(txt_Buscar_NivelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 290, 20));

        jLabel_TituloD2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Nivel Acdemico.png"))); // NOI18N
        jPanel_MantenimientoNA.add(jLabel_TituloD2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        Panel_Ingresar1.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Ingresar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Ingresar1MouseClicked(evt);
            }
        });
        Panel_Ingresar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Ingresar1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Ingresar1.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Ingresar1.setText("Ingresar");
        Texto_Ingresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Ingresar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Ingresar1MouseClicked(evt);
            }
        });
        Panel_Ingresar1.add(Texto_Ingresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoNA.add(Panel_Ingresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 130, 50));

        Panel_Modificar1.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Modificar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Modificar1MouseClicked(evt);
            }
        });
        Panel_Modificar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Modificar1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Modificar1.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Modificar1.setText("Modificar");
        Texto_Modificar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Modificar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Modificar1MouseClicked(evt);
            }
        });
        Panel_Modificar1.add(Texto_Modificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientoNA.add(Panel_Modificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 130, 50));

        Panel_Eliminar1.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Eliminar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Eliminar1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Eliminar1.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Eliminar1.setText("Eliminar");
        Texto_Eliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Eliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Eliminar1MouseClicked(evt);
            }
        });
        Panel_Eliminar1.add(Texto_Eliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoNA.add(Panel_Eliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 130, 50));

        Panel_Consultar1.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Consultar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Consultar1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Consultar1.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Consultar1.setText("Consultar");
        Texto_Consultar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Consultar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Consultar1MouseClicked(evt);
            }
        });
        Panel_Consultar1.add(Texto_Consultar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientoNA.add(Panel_Consultar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 130, 50));

        icono_Buscar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientoNA.add(icono_Buscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, 20, 20));

        getContentPane().add(jPanel_MantenimientoNA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1100, 700));

        Mantenimiento_D.setBackground(new java.awt.Color(28, 27, 33));
        Mantenimiento_D.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_TituloD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Departamento.png"))); // NOI18N
        Mantenimiento_D.add(jLabel_TituloD, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        Panel_Consultar.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Consultar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Consultar.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Consultar.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Consultar.setText("Consultar");
        Texto_Consultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Consultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ConsultarMouseClicked(evt);
            }
        });
        Panel_Consultar.add(Texto_Consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        Mantenimiento_D.add(Panel_Consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 130, 50));

        Panel_Eliminar.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Eliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Eliminar.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Eliminar.setText("Eliminar");
        Texto_Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_EliminarMouseClicked(evt);
            }
        });
        Panel_Eliminar.add(Texto_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        Mantenimiento_D.add(Panel_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 130, 50));

        Panel_Modificar.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ModificarMouseClicked(evt);
            }
        });
        Panel_Modificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Modificar.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Modificar.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Modificar.setText("Modificar");
        Texto_Modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ModificarMouseClicked(evt);
            }
        });
        Panel_Modificar.add(Texto_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        Mantenimiento_D.add(Panel_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 130, 50));

        Panel_Ingresar.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_IngresarMouseClicked(evt);
            }
        });
        Panel_Ingresar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Ingresar.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Ingresar.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Ingresar.setText("Ingresar");
        Texto_Ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_IngresarMouseClicked(evt);
            }
        });
        Panel_Ingresar.add(Texto_Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        Mantenimiento_D.add(Panel_Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 130, 50));

        jLabel_ID_Departamento.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_Departamento.setText("ID Departamento");
        Mantenimiento_D.add(jLabel_ID_Departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        txt_id_Departamento.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_Departamento.setForeground(new java.awt.Color(255, 255, 255));
        txt_id_Departamento.setBorder(null);
        txt_id_Departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_DepartamentoActionPerformed(evt);
            }
        });
        Mantenimiento_D.add(txt_id_Departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 140, 20));

        jLabel_NombreD.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreD.setText("Nombre Departamento");
        Mantenimiento_D.add(jLabel_NombreD, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, -1, -1));

        txt_Nombre_Departamento.setBackground(new java.awt.Color(40, 41, 46));
        txt_Nombre_Departamento.setForeground(new java.awt.Color(255, 255, 255));
        txt_Nombre_Departamento.setBorder(null);
        txt_Nombre_Departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Nombre_DepartamentoActionPerformed(evt);
            }
        });
        Mantenimiento_D.add(txt_Nombre_Departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 150, 20));

        jLabel_Estatus_Departamento.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Estatus_Departamento.setText("Estatus Departamento");
        Mantenimiento_D.add(jLabel_Estatus_Departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, -1, -1));

        txt_Estatus_Departamento.setBackground(new java.awt.Color(40, 41, 46));
        txt_Estatus_Departamento.setForeground(new java.awt.Color(255, 255, 255));
        txt_Estatus_Departamento.setBorder(null);
        txt_Estatus_Departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Estatus_DepartamentoActionPerformed(evt);
            }
        });
        Mantenimiento_D.add(txt_Estatus_Departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 150, 20));

        jLabel_Buscar.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar.setText("Buscar");
        Mantenimiento_D.add(jLabel_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 50, 20));

        txt_Buscar.setBackground(new java.awt.Color(40, 41, 46));
        txt_Buscar.setForeground(new java.awt.Color(255, 255, 255));
        txt_Buscar.setBorder(null);
        txt_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarActionPerformed(evt);
            }
        });
        txt_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarKeyReleased(evt);
            }
        });
        Mantenimiento_D.add(txt_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 240, 20));

        jScrollPane21.setBackground(new java.awt.Color(40, 41, 46));

        tbl_Departamento.setBackground(new java.awt.Color(40, 41, 46));
        tbl_Departamento.setForeground(new java.awt.Color(255, 255, 255));
        tbl_Departamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_Departamento.setToolTipText("");
        tbl_Departamento.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Departamento.setSelectionBackground(new java.awt.Color(40, 41, 46));
        tbl_Departamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DepartamentoMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(tbl_Departamento);

        Mantenimiento_D.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 600, 190));

        jLabel_EliminarD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_EliminarD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_EliminarD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EliminarDMouseClicked(evt);
            }
        });
        Mantenimiento_D.add(jLabel_EliminarD, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 50, 50));

        jLabel_ModificarD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_ModificarD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_ModificarD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_ModificarDMouseClicked(evt);
            }
        });
        Mantenimiento_D.add(jLabel_ModificarD, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 50, 50));

        jLabel_Ingresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_Ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_IngresarMouseClicked(evt);
            }
        });
        Mantenimiento_D.add(jLabel_Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 50, 50));

        icono_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        Mantenimiento_D.add(icono_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 420, 20, 20));

        getContentPane().add(Mantenimiento_D, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1180, 780));

        jPanel_MantenimientosP.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientosP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_ID_Puesto.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_ID_Puesto.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_Puesto.setText("ID Puesto");
        jPanel_MantenimientosP.add(jLabel_ID_Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, -1, -1));

        txt_id_Puesto.setBackground(new java.awt.Color(40, 41, 46));
        txt_id_Puesto.setForeground(new java.awt.Color(153, 153, 153));
        txt_id_Puesto.setBorder(null);
        txt_id_Puesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_PuestoActionPerformed(evt);
            }
        });
        jPanel_MantenimientosP.add(txt_id_Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 140, 20));

        jLabel_Nombre_Puesto.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre_Puesto.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre_Puesto.setText("Nombre Puesto");
        jPanel_MantenimientosP.add(jLabel_Nombre_Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, -1));

        txt_Nombre_Puesto.setBackground(new java.awt.Color(40, 41, 46));
        txt_Nombre_Puesto.setForeground(new java.awt.Color(153, 153, 153));
        txt_Nombre_Puesto.setBorder(null);
        txt_Nombre_Puesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Nombre_PuestoActionPerformed(evt);
            }
        });
        jPanel_MantenimientosP.add(txt_Nombre_Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 140, 20));

        jLabel_Descripcion_Puesto.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Descripcion_Puesto.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Descripcion_Puesto.setText("Descripcion Puesto");
        jPanel_MantenimientosP.add(jLabel_Descripcion_Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, -1, -1));

        jLabel_Descripcion_Puesto1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Descripcion_Puesto1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Descripcion_Puesto1.setText("Estatus Puesto");
        jPanel_MantenimientosP.add(jLabel_Descripcion_Puesto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 330, -1, -1));

        txt_Estatus_Puesto.setBackground(new java.awt.Color(40, 41, 46));
        txt_Estatus_Puesto.setForeground(new java.awt.Color(153, 153, 153));
        txt_Estatus_Puesto.setBorder(null);
        txt_Estatus_Puesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Estatus_PuestoActionPerformed(evt);
            }
        });
        jPanel_MantenimientosP.add(txt_Estatus_Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 360, 140, 20));

        tbl_Puesto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_Puesto.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Puesto.setSelectionBackground(new java.awt.Color(40, 41, 46));
        tbl_Puesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_PuestoMouseClicked(evt);
            }
        });
        jScrollPane22.setViewportView(tbl_Puesto);

        jPanel_MantenimientosP.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 600, 190));

        jLabel_Buscar_Puesto.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_Puesto.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_Puesto.setText("Buscar");
        jPanel_MantenimientosP.add(jLabel_Buscar_Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, -1, -1));

        txt_Buscar_Puesto.setBackground(new java.awt.Color(40, 41, 46));
        txt_Buscar_Puesto.setForeground(new java.awt.Color(153, 153, 153));
        txt_Buscar_Puesto.setBorder(null);
        txt_Buscar_Puesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Buscar_PuestoActionPerformed(evt);
            }
        });
        txt_Buscar_Puesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Buscar_PuestoKeyReleased(evt);
            }
        });
        jPanel_MantenimientosP.add(txt_Buscar_Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 290, 20));

        jLabel_Insertar_Puesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_Insertar_Puesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Insertar_Puesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Insertar_PuestoMouseClicked(evt);
            }
        });
        jPanel_MantenimientosP.add(jLabel_Insertar_Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, -1, -1));

        jLabel_Modificar_Puesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_Modificar_Puesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Modificar_Puesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Modificar_PuestoMouseClicked(evt);
            }
        });
        jPanel_MantenimientosP.add(jLabel_Modificar_Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, -1, -1));

        jLabel_Eliminar_Puesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar_Puesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Eliminar_Puesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Eliminar_PuestoMouseClicked(evt);
            }
        });
        jPanel_MantenimientosP.add(jLabel_Eliminar_Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, -1, -1));

        Panel_IngresarP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_IngresarP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_IngresarPMouseClicked(evt);
            }
        });
        Panel_IngresarP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_IngresarP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_IngresarP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_IngresarP.setText("Ingresar");
        Texto_IngresarP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_IngresarP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_IngresarPMouseClicked(evt);
            }
        });
        Panel_IngresarP.add(Texto_IngresarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientosP.add(Panel_IngresarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 130, 50));

        Panel_ModificarP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ModificarP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ModificarPMouseClicked(evt);
            }
        });
        Panel_ModificarP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ModificarP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ModificarP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ModificarP.setText("Modificar");
        Texto_ModificarP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ModificarP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ModificarPMouseClicked(evt);
            }
        });
        Panel_ModificarP.add(Texto_ModificarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientosP.add(Panel_ModificarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 130, 50));

        Panel_EliminarP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_EliminarP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_EliminarP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_EliminarP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_EliminarP.setText("Eliminar");
        Texto_EliminarP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_EliminarP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_EliminarPMouseClicked(evt);
            }
        });
        Panel_EliminarP.add(Texto_EliminarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientosP.add(Panel_EliminarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 130, 50));

        Panel_ConsultarP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ConsultarP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ConsultarP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ConsultarP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ConsultarP.setText("Consultar");
        Texto_ConsultarP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ConsultarP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ConsultarPMouseClicked(evt);
            }
        });
        Panel_ConsultarP.add(Texto_ConsultarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientosP.add(Panel_ConsultarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 130, 50));

        jLabel_TituloD1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Puesto.png"))); // NOI18N
        jPanel_MantenimientosP.add(jLabel_TituloD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        txt_Descripcion_Puesto.setBackground(new java.awt.Color(40, 41, 46));
        txt_Descripcion_Puesto.setColumns(20);
        txt_Descripcion_Puesto.setForeground(new java.awt.Color(255, 255, 255));
        txt_Descripcion_Puesto.setRows(5);
        txt_Descripcion_Puesto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jScrollPane2.setViewportView(txt_Descripcion_Puesto);

        jPanel_MantenimientosP.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 190, -1));

        icono_Buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientosP.add(icono_Buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 490, 20, 20));

        getContentPane().add(jPanel_MantenimientosP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1140, 710));

        jPanel_BG.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_BG.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel_BGMouseMoved(evt);
            }
        });
        jPanel_BG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_BGMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_BGMouseExited(evt);
            }
        });
        jPanel_BG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_IzquierdoC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Slide.setBackground(new java.awt.Color(40, 41, 46));
        Slide.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                SlideMouseMoved(evt);
            }
        });
        Slide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Icono_Conta.setBackground(new java.awt.Color(40, 41, 46));
        Panel_Icono_Conta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_Icono_Conta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Icono_ContaMouseClicked(evt);
            }
        });
        Panel_Icono_Conta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Icono_Conta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Conta.png"))); // NOI18N
        Panel_Icono_Conta.add(Icono_Conta, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, -1, -1));

        Slide.add(Panel_Icono_Conta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 70, 40));

        Panel_Icono_Bancos.setBackground(new java.awt.Color(40, 41, 46));
        Panel_Icono_Bancos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_Icono_Bancos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Icono_BancosMouseClicked(evt);
            }
        });
        Panel_Icono_Bancos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Icono_Bancos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bancos2.png"))); // NOI18N
        Panel_Icono_Bancos.add(Icono_Bancos, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, -1, -1));

        Slide.add(Panel_Icono_Bancos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 70, 40));

        Panel_Icono_Nomina.setBackground(new java.awt.Color(40, 41, 46));
        Panel_Icono_Nomina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_Icono_Nomina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Icono_NominaMouseClicked(evt);
            }
        });
        Panel_Icono_Nomina.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Icono_Nomina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nomina3.png"))); // NOI18N
        Panel_Icono_Nomina.add(Icono_Nomina, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, -1, -1));

        Slide.add(Panel_Icono_Nomina, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 70, 40));

        Panel_Icono_RRHH.setBackground(new java.awt.Color(40, 41, 46));
        Panel_Icono_RRHH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_Icono_RRHH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Icono_RRHHMouseClicked(evt);
            }
        });
        Panel_Icono_RRHH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Icono_RRHH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rh2.png"))); // NOI18N
        Icono_RRHH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Icono_RRHHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Icono_RRHHMouseEntered(evt);
            }
        });
        Panel_Icono_RRHH.add(Icono_RRHH, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, -1, -1));

        Slide.add(Panel_Icono_RRHH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 70, 40));

        jLabel_Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N
        jLabel_Logo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_LogoMouseClicked(evt);
            }
        });
        Slide.add(jLabel_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 40));

        Slide_Derecho.setBackground(new java.awt.Color(28, 27, 33));
        Slide_Derecho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Text_RRHH.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Text_RRHH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Text_RRHHMouseClicked(evt);
            }
        });
        Panel_Text_RRHH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_RRHH.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        Texto_RRHH.setForeground(new java.awt.Color(255, 255, 255));
        Texto_RRHH.setText("RRHH");
        Texto_RRHH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_RRHH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_RRHHMouseClicked(evt);
            }
        });
        Panel_Text_RRHH.add(Texto_RRHH, new org.netbeans.lib.awtextra.AbsoluteConstraints(-210, 10, -1, -1));

        Slide_Derecho.add(Panel_Text_RRHH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 140, 40));

        Panel_Text_Nomina.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Text_Nomina.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Nomina.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        Texto_Nomina.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Nomina.setText("Nomina");
        Texto_Nomina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Nomina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_NominaMouseClicked(evt);
            }
        });
        Panel_Text_Nomina.add(Texto_Nomina, new org.netbeans.lib.awtextra.AbsoluteConstraints(-210, 10, -1, -1));

        Slide_Derecho.add(Panel_Text_Nomina, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 140, 40));

        Panel_Text_Bancos.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Text_Bancos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Bancos.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        Texto_Bancos.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Bancos.setText("Bancos");
        Texto_Bancos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Bancos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_BancosMouseClicked(evt);
            }
        });
        Panel_Text_Bancos.add(Texto_Bancos, new org.netbeans.lib.awtextra.AbsoluteConstraints(-210, 10, -1, -1));

        Slide_Derecho.add(Panel_Text_Bancos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 140, 40));

        Panel_Text_Conta.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Text_Conta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Conta.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        Texto_Conta.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Conta.setText("Contabilidad");
        Texto_Conta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Conta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ContaMouseClicked(evt);
            }
        });
        Panel_Text_Conta.add(Texto_Conta, new org.netbeans.lib.awtextra.AbsoluteConstraints(-210, 10, -1, -1));

        Slide_Derecho.add(Panel_Text_Conta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 140, 40));

        Slide.add(Slide_Derecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 140, 790));

        Panel_IzquierdoC.add(Slide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 790));

        jPanel_BG.add(Panel_IzquierdoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, -1));

        jLabel_Titulo.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Mantenimientos Recursos Humanos");
        jPanel_BG.add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 340, 40));

        jPanel_Bienvenido.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Bienvenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Bienvenido.setBackground(new java.awt.Color(51, 51, 51));
        Bienvenido.setFont(new java.awt.Font("Open Sans", 1, 48)); // NOI18N
        Bienvenido.setForeground(new java.awt.Color(51, 51, 51));
        Bienvenido.setText("Welcome");
        jPanel_Bienvenido.add(Bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 380, 230, 40));

        jPanel_BG.add(jPanel_Bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 790));

        ExpLD.setBackground(new java.awt.Color(28, 27, 33));
        ExpLD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExpLD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeleccionadoA3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        ExpLD.add(SeleccionadoA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 10, 40));

        Cant_R1.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R1.setForeground(new java.awt.Color(255, 255, 255));
        ExpLD.add(Cant_R1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 158, 20, 20));

        icon_ExpLD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ExpLD.png"))); // NOI18N
        icon_ExpLD.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_ExpLDMouseMoved(evt);
            }
        });
        icon_ExpLD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_ExpLDMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_ExpLDMouseExited(evt);
            }
        });
        ExpLD.add(icon_ExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        SeleccionadoA15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        ExpLD.add(SeleccionadoA15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, -50, 10, 40));

        Cant_R20.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R20.setForeground(new java.awt.Color(255, 255, 255));
        ExpLD.add(Cant_R20, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 20, 20));

        icon_PP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_PP.png"))); // NOI18N
        icon_PP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_PPMouseMoved(evt);
            }
        });
        icon_PP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_PPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_PPMouseExited(evt);
            }
        });
        ExpLD.add(icon_PP, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, -1));

        jPanel_BG.add(ExpLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 130, 220, 180));

        Departamento.setBackground(new java.awt.Color(28, 27, 33));
        Departamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Departamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DepartamentoMouseClicked(evt);
            }
        });
        Departamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeleccionadoA1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        Departamento.add(SeleccionadoA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 10, 40));

        Cant_R2.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R2.setForeground(new java.awt.Color(255, 255, 255));
        Departamento.add(Cant_R2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 158, 20, 20));

        icon_Departamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Departamento.png"))); // NOI18N
        icon_Departamento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_DepartamentoMouseMoved(evt);
            }
        });
        icon_Departamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_DepartamentoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_DepartamentoMouseExited(evt);
            }
        });
        Departamento.add(icon_Departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 180));

        SeleccionadoA12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        Departamento.add(SeleccionadoA12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, -50, 10, 40));

        Cant_R17.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R17.setForeground(new java.awt.Color(255, 255, 255));
        Departamento.add(Cant_R17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 158, 20, 20));

        icon_APP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_APP.png"))); // NOI18N
        icon_APP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_APPMouseMoved(evt);
            }
        });
        icon_APP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_APPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_APPMouseExited(evt);
            }
        });
        Departamento.add(icon_APP, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 220, 180));

        jPanel_BG.add(Departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 220, 180));

        Puesto.setBackground(new java.awt.Color(28, 27, 33));
        Puesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Puesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PuestoMouseExited(evt);
            }
        });
        Puesto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeleccionadoA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        SeleccionadoA.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                SeleccionadoAMouseMoved(evt);
            }
        });
        Puesto.add(SeleccionadoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 10, 40));

        Cant_R3.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R3.setForeground(new java.awt.Color(255, 255, 255));
        Puesto.add(Cant_R3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 158, 20, 20));

        icon_Puesto.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        icon_Puesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Puesto_1.png"))); // NOI18N
        icon_Puesto.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_PuestoMouseMoved(evt);
            }
        });
        icon_Puesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_PuestoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_PuestoMouseExited(evt);
            }
        });
        Puesto.add(icon_Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 180));

        SeleccionadoA13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        SeleccionadoA13.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                SeleccionadoA13MouseMoved(evt);
            }
        });
        Puesto.add(SeleccionadoA13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, -50, 10, 40));

        Cant_R18.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R18.setForeground(new java.awt.Color(255, 255, 255));
        Cant_R18.setText("1");
        Puesto.add(Cant_R18, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 20, -1));

        icon_Seleccion.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        icon_Seleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_S.png"))); // NOI18N
        icon_Seleccion.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_SeleccionMouseMoved(evt);
            }
        });
        icon_Seleccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_SeleccionMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_SeleccionMouseExited(evt);
            }
        });
        Puesto.add(icon_Seleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 220, 180));

        jPanel_BG.add(Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 220, 180));

        Nivel_Academico.setBackground(new java.awt.Color(28, 27, 33));
        Nivel_Academico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Nivel_Academico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeleccionadoA2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        Nivel_Academico.add(SeleccionadoA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 10, 40));

        Cant_R4.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R4.setForeground(new java.awt.Color(255, 255, 255));
        Nivel_Academico.add(Cant_R4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 158, 20, 20));

        icon_NivelA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nivel_Aca.png"))); // NOI18N
        icon_NivelA.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_NivelAMouseMoved(evt);
            }
        });
        icon_NivelA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_NivelAMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_NivelAMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                icon_NivelAMouseReleased(evt);
            }
        });
        Nivel_Academico.add(icon_NivelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        SeleccionadoA14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        Nivel_Academico.add(SeleccionadoA14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, -50, 10, 40));

        Cant_R19.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R19.setForeground(new java.awt.Color(255, 255, 255));
        Cant_R19.setText("1");
        Nivel_Academico.add(Cant_R19, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 158, 20, 20));

        icon_Actividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_Actividad.png"))); // NOI18N
        icon_Actividad.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_ActividadMouseMoved(evt);
            }
        });
        icon_Actividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_ActividadMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_ActividadMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                icon_ActividadMouseReleased(evt);
            }
        });
        Nivel_Academico.add(icon_Actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, -1));

        jPanel_BG.add(Nivel_Academico, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 220, 180));

        ExpLD1.setBackground(new java.awt.Color(28, 27, 33));
        ExpLD1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExpLD1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cant_R5.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R5.setForeground(new java.awt.Color(255, 255, 255));
        Cant_R5.setText("1");
        ExpLD1.add(Cant_R5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 20, -1));
        ExpLD1.add(icon_NivelA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel_BG.add(ExpLD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 130, 220, 180));

        Departamento1.setBackground(new java.awt.Color(28, 27, 33));
        Departamento1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Departamento1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Departamento1MouseClicked(evt);
            }
        });
        Departamento1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cant_R6.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R6.setForeground(new java.awt.Color(255, 255, 255));
        Cant_R6.setText("1");
        Departamento1.add(Cant_R6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 20, -1));

        icon_Departamento1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Departamento.png"))); // NOI18N
        icon_Departamento1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_Departamento1MouseClicked(evt);
            }
        });
        Departamento1.add(icon_Departamento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 180));

        jPanel_BG.add(Departamento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 220, 180));

        Puesto1.setBackground(new java.awt.Color(28, 27, 33));
        Puesto1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Puesto1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cant_R7.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R7.setForeground(new java.awt.Color(255, 255, 255));
        Cant_R7.setText("1");
        Puesto1.add(Cant_R7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 20, -1));

        icon_Puesto2.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        icon_Puesto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Puesto_1.png"))); // NOI18N
        Puesto1.add(icon_Puesto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 180));

        jPanel_BG.add(Puesto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 220, 180));

        Nivel_Academico2.setBackground(new java.awt.Color(28, 27, 33));
        Nivel_Academico2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Nivel_Academico2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cant_R8.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R8.setForeground(new java.awt.Color(255, 255, 255));
        Cant_R8.setText("1");
        Nivel_Academico2.add(Cant_R8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 20, -1));

        icon_NivelA3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nivel_Aca.png"))); // NOI18N
        Nivel_Academico2.add(icon_NivelA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel_BG.add(Nivel_Academico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 220, 180));

        SE.setBackground(new java.awt.Color(28, 27, 33));
        SE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SEMouseClicked(evt);
            }
        });
        SE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeleccionadoA5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        SE.add(SeleccionadoA5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 10, 40));

        Cant_R11.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R11.setForeground(new java.awt.Color(255, 255, 255));
        SE.add(Cant_R11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 158, 20, 20));

        icon_SE.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        icon_SE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Solicitud Empresarial.png"))); // NOI18N
        icon_SE.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_SEMouseMoved(evt);
            }
        });
        icon_SE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_SEMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_SEMouseExited(evt);
            }
        });
        SE.add(icon_SE, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 180));

        SeleccionadoA17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        SE.add(SeleccionadoA17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, -50, 10, 40));

        Cant_R22.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R22.setForeground(new java.awt.Color(255, 255, 255));
        SE.add(Cant_R22, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 158, 20, 20));

        icon_EC.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        icon_EC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_EC.png"))); // NOI18N
        icon_EC.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_ECMouseMoved(evt);
            }
        });
        icon_EC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_ECMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_ECMouseExited(evt);
            }
        });
        SE.add(icon_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 220, 180));

        jPanel_BG.add(SE, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 220, 180));

        RL.setBackground(new java.awt.Color(28, 27, 33));
        RL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeleccionadoA7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        RL.add(SeleccionadoA7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 10, 40));

        Cant_R9.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R9.setForeground(new java.awt.Color(255, 255, 255));
        RL.add(Cant_R9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 158, 20, 20));

        icon_RL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_RL.png"))); // NOI18N
        icon_RL.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_RLMouseMoved(evt);
            }
        });
        icon_RL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_RLMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_RLMouseExited(evt);
            }
        });
        RL.add(icon_RL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        SeleccionadoA19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        RL.add(SeleccionadoA19, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, -50, 10, 40));

        Cant_R24.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R24.setForeground(new java.awt.Color(255, 255, 255));
        RL.add(Cant_R24, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 158, 20, 20));

        icon_BE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_Bitacora.png"))); // NOI18N
        icon_BE.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_BEMouseMoved(evt);
            }
        });
        icon_BE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_BEMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_BEMouseExited(evt);
            }
        });
        RL.add(icon_BE, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, -1));

        jPanel_BG.add(RL, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 330, 220, 180));

        ExpL.setBackground(new java.awt.Color(28, 27, 33));
        ExpL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExpL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExpLMouseClicked(evt);
            }
        });
        ExpL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeleccionadoA4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        ExpL.add(SeleccionadoA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 10, 40));

        Cant_R10.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R10.setForeground(new java.awt.Color(255, 255, 255));
        ExpL.add(Cant_R10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 158, 20, 20));

        icon_ExpL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icono_ExpL.png"))); // NOI18N
        icon_ExpL.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_ExpLMouseMoved(evt);
            }
        });
        icon_ExpL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_ExpLMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_ExpLMouseExited(evt);
            }
        });
        ExpL.add(icon_ExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 180));

        SeleccionadoA16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        ExpL.add(SeleccionadoA16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, -50, 10, 40));

        Cant_R21.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R21.setForeground(new java.awt.Color(255, 255, 255));
        Cant_R21.setText("1");
        ExpL.add(Cant_R21, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 20, -1));

        icon_Contratacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_C.png"))); // NOI18N
        icon_Contratacion.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_ContratacionMouseMoved(evt);
            }
        });
        icon_Contratacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_ContratacionMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_ContratacionMouseExited(evt);
            }
        });
        ExpL.add(icon_Contratacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 220, 180));

        jPanel_BG.add(ExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 220, 180));

        Medio.setBackground(new java.awt.Color(28, 27, 33));
        Medio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Medio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeleccionadoA6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        Medio.add(SeleccionadoA6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 10, 40));

        Cant_R12.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R12.setForeground(new java.awt.Color(255, 255, 255));
        Medio.add(Cant_R12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 158, 20, 20));

        icon_Medio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_Medio.png"))); // NOI18N
        icon_Medio.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_MedioMouseMoved(evt);
            }
        });
        icon_Medio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_MedioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_MedioMouseExited(evt);
            }
        });
        Medio.add(icon_Medio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        SeleccionadoA18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        Medio.add(SeleccionadoA18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, -50, 10, 40));

        Cant_R23.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R23.setForeground(new java.awt.Color(255, 255, 255));
        Medio.add(Cant_R23, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 158, 20, 20));

        icon_AE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_AE.png"))); // NOI18N
        icon_AE.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_AEMouseMoved(evt);
            }
        });
        icon_AE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_AEMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_AEMouseExited(evt);
            }
        });
        Medio.add(icon_AE, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, -1));

        jPanel_BG.add(Medio, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, 220, 180));

        Aplicacion.setBackground(new java.awt.Color(28, 27, 33));
        Aplicacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Aplicacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeleccionadoA10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        Aplicacion.add(SeleccionadoA10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 10, 40));

        Cant_R14.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R14.setForeground(new java.awt.Color(255, 255, 255));
        Aplicacion.add(Cant_R14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 158, 20, 20));

        icon_Aplicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_Aplicacion.png"))); // NOI18N
        icon_Aplicacion.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_AplicacionMouseMoved(evt);
            }
        });
        icon_Aplicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_AplicacionMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_AplicacionMouseExited(evt);
            }
        });
        Aplicacion.add(icon_Aplicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel_BG.add(Aplicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 530, 220, 180));

        TP.setBackground(new java.awt.Color(28, 27, 33));
        TP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeleccionadoA11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        TP.add(SeleccionadoA11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 10, 40));

        Cant_R15.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R15.setForeground(new java.awt.Color(255, 255, 255));
        TP.add(Cant_R15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 158, 20, 20));

        icon_TP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_TP.png"))); // NOI18N
        icon_TP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_TPMouseMoved(evt);
            }
        });
        icon_TP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_TPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_TPMouseExited(evt);
            }
        });
        TP.add(icon_TP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel_BG.add(TP, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 530, 220, 180));

        RP.setBackground(new java.awt.Color(28, 27, 33));
        RP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RPMouseClicked(evt);
            }
        });
        RP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeleccionadoA8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        RP.add(SeleccionadoA8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 10, 40));

        Cant_R13.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R13.setForeground(new java.awt.Color(255, 255, 255));
        RP.add(Cant_R13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 158, 20, 20));

        icon_RP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_RP.png"))); // NOI18N
        icon_RP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_RPMouseMoved(evt);
            }
        });
        icon_RP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_RPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_RPMouseExited(evt);
            }
        });
        RP.add(icon_RP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 180));

        jPanel_BG.add(RP, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, 220, 180));

        CV.setBackground(new java.awt.Color(28, 27, 33));
        CV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeleccionadoA9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        CV.add(SeleccionadoA9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 10, 40));

        Cant_R16.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R16.setForeground(new java.awt.Color(255, 255, 255));
        CV.add(Cant_R16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 158, 20, 20));

        icon_CV.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        icon_CV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_CV.png"))); // NOI18N
        icon_CV.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_CVMouseMoved(evt);
            }
        });
        icon_CV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_CVMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_CVMouseExited(evt);
            }
        });
        CV.add(icon_CV, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 180));

        jPanel_BG.add(CV, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 530, 220, 180));

        jLabel_Felcha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Flech.png"))); // NOI18N
        jLabel_Felcha2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Felcha2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_Felcha2MouseMoved(evt);
            }
        });
        jLabel_Felcha2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Felcha2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_Felcha2MouseExited(evt);
            }
        });
        jPanel_BG.add(jLabel_Felcha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 390, 30, 30));

        jLabel_Flecha_Iz1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FlechIz.png"))); // NOI18N
        jLabel_Flecha_Iz1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Flecha_Iz1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_Flecha_Iz1MouseMoved(evt);
            }
        });
        jLabel_Flecha_Iz1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Flecha_Iz1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_Flecha_Iz1MouseExited(evt);
            }
        });
        jPanel_BG.add(jLabel_Flecha_Iz1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 390, 30, 30));

        getContentPane().add(jPanel_BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 790));

        setSize(new java.awt.Dimension(1410, 809));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_id_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_AActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_AActionPerformed

    private void txt_TAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TAActionPerformed

    private void jLabel_Insertar_AMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Insertar_AMouseClicked
        // TODO add your handling code here:
        Actividad AC = new Actividad(txt_id_A, txt_TA, jTextArea_DescripcionA, txt_BuscarA, tbl_A);
        AC.Insertar_AC();
    }//GEN-LAST:event_jLabel_Insertar_AMouseClicked

    private void jLabel_Modificar_AcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Modificar_AcMouseClicked
        // TODO add your handling code here:
        Actividad AC = new Actividad(txt_id_A, txt_TA, jTextArea_DescripcionA, txt_BuscarA, tbl_A);
        AC.Modificar_AC();
    }//GEN-LAST:event_jLabel_Modificar_AcMouseClicked

    private void jLabel_Eliminar_AcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Eliminar_AcMouseClicked
        // TODO add your handling code here:
        Actividad AC = new Actividad(txt_id_A, txt_TA, jTextArea_DescripcionA, txt_BuscarA, tbl_A);
        AC.Eliminar_AC();
    }//GEN-LAST:event_jLabel_Eliminar_AcMouseClicked

    private void jLabel_BuscarAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_BuscarAMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_BuscarAMouseClicked

    private void txt_BuscarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarAActionPerformed

    private void txt_BuscarAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarAKeyReleased
        // TODO add your handling code here:
        Actividad AC = new Actividad(txt_id_A, txt_TA, jTextArea_DescripcionA, txt_BuscarA, tbl_A);
        AC.Buscar_ACF(txt_BuscarA.getText());
    }//GEN-LAST:event_txt_BuscarAKeyReleased

    private void tbl_AMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_AMouseClicked
        // TODO add your handling code here:
        int Seleccion = tbl_A.rowAtPoint(evt.getPoint());
        txt_id_A.setText(String.valueOf(tbl_A.getValueAt(Seleccion, 0)));
        txt_TA.setText(String.valueOf(tbl_A.getValueAt(Seleccion, 1)));
        jTextArea_DescripcionA.setText(String.valueOf(tbl_A.getValueAt(Seleccion, 2)));
    }//GEN-LAST:event_tbl_AMouseClicked

    private void Texto_Ingresar_ActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Ingresar_ActividadMouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_Ac.setVisible(false);
        jLabel_Modificar_Ac.setVisible(false);
        jLabel_Insertar_A.setVisible(true);
    }//GEN-LAST:event_Texto_Ingresar_ActividadMouseClicked

    private void Panel_Ingresar_ActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Ingresar_ActividadMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Ingresar_ActividadMouseClicked

    private void Texto_Modificar_ActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Modificar_ActividadMouseClicked
        // TODO add your handling code here:
        jLabel_Modificar_Ac.setVisible(true);
        jLabel_Insertar_A.setVisible(false);
        jLabel_Eliminar_Ac.setVisible(false);
    }//GEN-LAST:event_Texto_Modificar_ActividadMouseClicked

    private void Panel_Modificar_ActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Modificar_ActividadMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Modificar_ActividadMouseClicked

    private void Texto_Eliminar_ActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Eliminar_ActividadMouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_Ac.setVisible(true);
        jLabel_Modificar_Ac.setVisible(false);
        jLabel_Insertar_A.setVisible(false);
    }//GEN-LAST:event_Texto_Eliminar_ActividadMouseClicked

    private void Texto_Consultar_ActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Consultar_ActividadMouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_Ac.setVisible(false);
        jLabel_Modificar_Ac.setVisible(false);
        jLabel_Insertar_A.setVisible(false);
    }//GEN-LAST:event_Texto_Consultar_ActividadMouseClicked

    private void txt_idSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idSActionPerformed

    private void jComboBox_APPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_APPSActionPerformed

        Seleccion S = new Seleccion(txt_idS, jLabel_RL_APPS, txt_EstatusS, txt_BuscarS, tbl_S);
        S.EncontrarID_Seleccion("id_ap", "aplicacion_prueba", "id_ap", jComboBox_APPS, jLabel_RL_APPS);

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_APPSActionPerformed

    private void txt_EstatusSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_EstatusSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EstatusSActionPerformed

    private void jLabel_InsertarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_InsertarSMouseClicked

        Seleccion S = new Seleccion(txt_idS, jLabel_RL_APPS, txt_EstatusS, txt_BuscarS, tbl_S);
        S.Insertar_Seleccion();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_InsertarSMouseClicked

    private void jLabel_ModificarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ModificarSMouseClicked
        Seleccion S = new Seleccion(txt_idS, jLabel_RL_APPS, txt_EstatusS, txt_BuscarS, tbl_S);
        S.Modificar_Seleccion();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_ModificarSMouseClicked

    private void jLabel_EliminarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EliminarSMouseClicked
        Seleccion S = new Seleccion(txt_idS, jLabel_RL_APPS, txt_EstatusS, txt_BuscarS, tbl_S);
        S.Eliminar_Seleccion();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_EliminarSMouseClicked

    private void jLabel_BuscarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_BuscarSMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_BuscarSMouseClicked

    private void txt_BuscarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_BuscarSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarSMouseClicked

    private void txt_BuscarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarSActionPerformed

    private void txt_BuscarSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarSKeyReleased

        Seleccion S = new Seleccion(txt_idS, jLabel_RL_APPS, txt_EstatusS, txt_BuscarS, tbl_S);
        S.Buscar_Sele(txt_BuscarS.getText());

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarSKeyReleased

    private void tbl_SMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SMouseClicked

        int Seleccion = tbl_S.rowAtPoint(evt.getPoint());
        txt_idS.setText(String.valueOf(tbl_S.getValueAt(Seleccion, 0)));
        jLabel_RL_APPS.setText(String.valueOf(tbl_S.getValueAt(Seleccion, 1)));
        txt_EstatusS.setText(String.valueOf(tbl_S.getValueAt(Seleccion, 2)));
        Seleccion S = new Seleccion(txt_idS, jLabel_RL_APPS, txt_EstatusS, txt_BuscarS, tbl_S);
        S.BuscarFila_Seleccion("id_ap", " aplicacion_prueba", " id_ap", jComboBox_APPS, jLabel_RL_APPS);

        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_SMouseClicked

    private void Texto_IngresarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarSMouseClicked

        jLabel_EliminarS.setVisible(false);
        jLabel_InsertarS.setVisible(true);
        jLabel_ModificarS.setVisible(false);
    }//GEN-LAST:event_Texto_IngresarSMouseClicked

    private void Panel_IngresarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarSMouseClicked

    private void Texto_ModificarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificarSMouseClicked
        jLabel_EliminarS.setVisible(false);
        jLabel_InsertarS.setVisible(false);
        jLabel_ModificarS.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_ModificarSMouseClicked

    private void Panel_ModificarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarSMouseClicked

    private void Texto_EliminarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarSMouseClicked
        jLabel_EliminarS.setVisible(true);
        jLabel_InsertarS.setVisible(false);
        jLabel_ModificarS.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_EliminarSMouseClicked

    private void Texto_ConsultarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarSMouseClicked
        jLabel_EliminarS.setVisible(false);
        jLabel_InsertarS.setVisible(false);
        jLabel_ModificarS.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_ConsultarSMouseClicked

    private void jComboBox_TablasB_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TablasB_SActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TablasB_SActionPerformed

    private void jLabel_Buscar_TablasSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Buscar_TablasSMouseClicked

        Item_Seleccion = jComboBox_TablasB_S.getSelectedItem().toString();

        if (Item_Seleccion == S_Seleccion) {
            AplicacionPrueba_V Sele = new AplicacionPrueba_V();
            Sele.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_Buscar_TablasSMouseClicked

    private void txt_id_APPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_APPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_APPActionPerformed

    private void jComboBox_PruebaAPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_PruebaAPPActionPerformed
        // TODO add your handling code here:
        Aplicacion_Prueba APP = new Aplicacion_Prueba(txt_id_APP, jLabel_Prueba_APP, jLabel_Aplicacion_APP, txt_AplicacionAPP, txt_Buscar_APP, tbl_APP);
        APP.EncontrarID_APP("id_prueba", "tipo_pruebas", "tipo_prueba", jComboBox_PruebaAPP, jLabel_Prueba_APP);
    }//GEN-LAST:event_jComboBox_PruebaAPPActionPerformed

    private void jComboBox_AplicacionAPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_AplicacionAPPActionPerformed
        // TODO add your handling code here:
        Aplicacion_Prueba APP = new Aplicacion_Prueba(txt_id_APP, jLabel_Prueba_APP, jLabel_Aplicacion_APP, txt_AplicacionAPP, txt_Buscar_APP, tbl_APP);
        APP.EncontrarID_APP("id_aplicacion", "aplicacion", "dpi_persona", jComboBox_AplicacionAPP, jLabel_Aplicacion_APP);
    }//GEN-LAST:event_jComboBox_AplicacionAPPActionPerformed

    private void txt_AplicacionAPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AplicacionAPPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AplicacionAPPActionPerformed

    private void jLabel_Ingresar_APPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Ingresar_APPMouseClicked
        // TODO add your handling code here:
        Aplicacion_Prueba APP = new Aplicacion_Prueba(txt_id_APP, jLabel_Prueba_APP, jLabel_Aplicacion_APP, txt_AplicacionAPP, txt_Buscar_APP, tbl_APP);
        APP.Insertar_APP();
    }//GEN-LAST:event_jLabel_Ingresar_APPMouseClicked

    private void jLabel_ModificarAPPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ModificarAPPMouseClicked
        // TODO add your handling code here:
        Aplicacion_Prueba APP = new Aplicacion_Prueba(txt_id_APP, jLabel_Prueba_APP, jLabel_Aplicacion_APP, txt_AplicacionAPP, txt_Buscar_APP, tbl_APP);
        APP.Modificar_APP();
    }//GEN-LAST:event_jLabel_ModificarAPPMouseClicked

    private void jLabel_Eliminar_APPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Eliminar_APPMouseClicked
        // TODO add your handling code here:
        Aplicacion_Prueba APP = new Aplicacion_Prueba(txt_id_APP, jLabel_Prueba_APP, jLabel_Aplicacion_APP, txt_AplicacionAPP, txt_Buscar_APP, tbl_APP);
        APP.Eliminar_APP();
    }//GEN-LAST:event_jLabel_Eliminar_APPMouseClicked

    private void txt_Buscar_APPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Buscar_APPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Buscar_APPActionPerformed

    private void txt_Buscar_APPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Buscar_APPKeyReleased
        // TODO add your handling code here:
        Aplicacion_Prueba APP = new Aplicacion_Prueba(txt_id_APP, jLabel_Prueba_APP, jLabel_Aplicacion_APP, txt_AplicacionAPP, txt_Buscar_APP, tbl_APP);
        APP.Buscar_APPF(txt_Buscar_APP.getText());
    }//GEN-LAST:event_txt_Buscar_APPKeyReleased

    private void tbl_APPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_APPMouseClicked
        // TODO add your handling code here:
        int Seleccion = tbl_APP.rowAtPoint(evt.getPoint());
        txt_id_APP.setText(String.valueOf(tbl_APP.getValueAt(Seleccion, 0)));
        jLabel_Prueba_APP.setText(String.valueOf(tbl_APP.getValueAt(Seleccion, 1)));
        jLabel_Aplicacion_APP.setText(String.valueOf(tbl_APP.getValueAt(Seleccion, 2)));
        txt_AplicacionAPP.setText(String.valueOf(tbl_APP.getValueAt(Seleccion, 3)));

        Aplicacion_Prueba APP = new Aplicacion_Prueba(txt_id_APP, jLabel_Prueba_APP, jLabel_Aplicacion_APP, txt_AplicacionAPP, txt_Buscar_APP, tbl_APP);
        APP.BuscarFila_APP("tipo_prueba", "tipo_pruebas", "id_prueba", jComboBox_PruebaAPP, jLabel_Prueba_APP);
        APP.BuscarFila_APP("dpi_persona", "aplicacion", "id_aplicacion", jComboBox_AplicacionAPP, jLabel_Aplicacion_APP);
    }//GEN-LAST:event_tbl_APPMouseClicked

    private void Texto_IngresarAPPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarAPPMouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_APP.setVisible(false);
        jLabel_ModificarAPP.setVisible(false);
        jLabel_Ingresar_APP.setVisible(true);
    }//GEN-LAST:event_Texto_IngresarAPPMouseClicked

    private void Panel_IngresarAPPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarAPPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarAPPMouseClicked

    private void Texto_ModificarAPPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificarAPPMouseClicked
        // TODO add your handling code here:
        jLabel_ModificarAPP.setVisible(true);
        jLabel_Ingresar_APP.setVisible(false);
        jLabel_Eliminar_APP.setVisible(false);
    }//GEN-LAST:event_Texto_ModificarAPPMouseClicked

    private void Panel_ModificarAPPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarAPPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarAPPMouseClicked

    private void Texto_EliminarAPPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarAPPMouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_APP.setVisible(true);
        jLabel_ModificarAPP.setVisible(false);
        jLabel_Ingresar_APP.setVisible(false);
    }//GEN-LAST:event_Texto_EliminarAPPMouseClicked

    private void Texto_ConsultarAPPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarAPPMouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_APP.setVisible(false);
        jLabel_ModificarAPP.setVisible(false);
        jLabel_Ingresar_APP.setVisible(false);
    }//GEN-LAST:event_Texto_ConsultarAPPMouseClicked

    private void jComboBox_TablasB_APPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_TablasB_APPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TablasB_APPMouseClicked

    private void jComboBox_TablasB_APPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TablasB_APPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TablasB_APPActionPerformed

    private void jLabel_Buscar_TablasAPPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Buscar_TablasAPPMouseClicked

        Item_Prueba = jComboBox_TablasB_APP.getSelectedItem().toString();
        Item_Aplicacion = jComboBox_TablasB_APP.getSelectedItem().toString();

        if (Item_Prueba == S_Prueba) {
            TipoPrueba_V Prueba = new TipoPrueba_V();
            Prueba.setVisible(true);
        }

        if (Item_Aplicacion == S_Aplicacion) {
            Aplicacion_V Aplicacion = new Aplicacion_V();
            Aplicacion.setVisible(true);
        }
    }//GEN-LAST:event_jLabel_Buscar_TablasAPPMouseClicked

    private void txt_id_TPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_TPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_TPActionPerformed

    private void txt_TPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TPActionPerformed

    private void jLabel_IngresarTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_IngresarTPMouseClicked
        Tipo_Prueba TP = new Tipo_Prueba(txt_id_TP, txt_TP, tbl_TP, txt_BuscarTP);
        TP.Insertar_TipoPrueba();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_IngresarTPMouseClicked

    private void jLabel_Modificar_TPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Modificar_TPMouseClicked
        // TODO add your handling code here:
        Tipo_Prueba TP = new Tipo_Prueba(txt_id_TP, txt_TP, tbl_TP, txt_BuscarTP);
        TP.Modificar_TipoPrueba();
    }//GEN-LAST:event_jLabel_Modificar_TPMouseClicked

    private void jLabel_Eliminar_TPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Eliminar_TPMouseClicked
        Tipo_Prueba TP = new Tipo_Prueba(txt_id_TP, txt_TP, tbl_TP, txt_BuscarTP);
        TP.Eliminar_TipoPrueba();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_Eliminar_TPMouseClicked

    private void tbl_TPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_TPMouseClicked
        int Seleccion = tbl_TP.rowAtPoint(evt.getPoint());
        txt_id_TP.setText(String.valueOf(tbl_TP.getValueAt(Seleccion, 0)));
        txt_TP.setText(String.valueOf(tbl_TP.getValueAt(Seleccion, 1)));

        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_TPMouseClicked

    private void txt_BuscarTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarTPActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarTPActionPerformed

    private void txt_BuscarTPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarTPKeyReleased
        Tipo_Prueba TP = new Tipo_Prueba(txt_id_TP, txt_TP, tbl_TP, txt_BuscarTP);
        TP.Buscar_TP(txt_BuscarTP.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarTPKeyReleased

    private void jLabel_BuscarTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_BuscarTPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_BuscarTPMouseClicked

    private void Texto_IngresarTpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarTpMouseClicked

        jLabel_IngresarTP.setVisible(true);
        jLabel_Modificar_TP.setVisible(false);
        jLabel_Eliminar_TP.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_IngresarTpMouseClicked

    private void Panel_IngresarTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarTPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarTPMouseClicked

    private void Texto_ModificartpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificartpMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarTP.setVisible(false);
        jLabel_Modificar_TP.setVisible(true);
        jLabel_Eliminar_TP.setVisible(false);
    }//GEN-LAST:event_Texto_ModificartpMouseClicked

    private void Panel_ModificarTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarTPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarTPMouseClicked

    private void Texto_EliminarTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarTPMouseClicked
        jLabel_IngresarTP.setVisible(false);
        jLabel_Modificar_TP.setVisible(false);
        jLabel_Eliminar_TP.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_EliminarTPMouseClicked

    private void Panel_EliminarTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_EliminarTPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_EliminarTPMouseClicked

    private void Texto_ConsultarTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarTPMouseClicked
        jLabel_IngresarTP.setVisible(false);
        jLabel_Modificar_TP.setVisible(false);
        jLabel_Eliminar_TP.setVisible(false);         // TODO add your handling code here:
    }//GEN-LAST:event_Texto_ConsultarTPMouseClicked

    private void Panel_ConsultarTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ConsultarTPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ConsultarTPMouseClicked

    private void txt_id_APActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_APActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_APActionPerformed

    private void jComboBox_DPIAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_DPIAPActionPerformed
        // TODO add your handling code here:
        Aplicacion ap = new Aplicacion(txt_id_AP, jLabel_DPI_AP, txt_RequisitosAP, txt_BuscarAP, tbl_AP);
        ap.EncontrarID_dpi("dpi_persona", "curriculum", "nombres_persona", jComboBox_DPIAP, jLabel_DPI_AP);
    }//GEN-LAST:event_jComboBox_DPIAPActionPerformed

    private void txt_RequisitosAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RequisitosAPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RequisitosAPActionPerformed

    private void jLabel_IngresarAPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_IngresarAPMouseClicked
        // TODO add your handling code here:
        Aplicacion ap = new Aplicacion(txt_id_AP, jLabel_DPI_AP, txt_RequisitosAP, txt_BuscarAP, tbl_AP);
        ap.Insertar_Aplicacion();
    }//GEN-LAST:event_jLabel_IngresarAPMouseClicked

    private void jLabel_Modificar_APMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Modificar_APMouseClicked
        // TODO add your handling code here:
        Aplicacion ap = new Aplicacion(txt_id_AP, jLabel_DPI_AP, txt_RequisitosAP, txt_BuscarAP, tbl_AP);
        ap.Modificar_Aplicacion();
    }//GEN-LAST:event_jLabel_Modificar_APMouseClicked

    private void jLabel_Eliminar_APMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Eliminar_APMouseClicked
        // TODO add your handling code here:
        Aplicacion ap = new Aplicacion(txt_id_AP, jLabel_DPI_AP, txt_RequisitosAP, txt_BuscarAP, tbl_AP);
        ap.Eliminar_Aplicacion();
    }//GEN-LAST:event_jLabel_Eliminar_APMouseClicked

    private void tbl_APMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_APMouseClicked
        // TODO add your handling code here:

        int Seleccion = tbl_AP.rowAtPoint(evt.getPoint());

        txt_id_AP.setText(String.valueOf(tbl_AP.getValueAt(Seleccion, 0)));
        jLabel_DPI_AP.setText(String.valueOf(tbl_AP.getValueAt(Seleccion, 1)));
        txt_RequisitosAP.setText(String.valueOf(tbl_AP.getValueAt(Seleccion, 2)));

        Aplicacion ap = new Aplicacion(txt_id_AP, jLabel_DPI_AP, txt_RequisitosAP, txt_BuscarAP, tbl_AP);
        ap.BuscarFila_AP("nombres_persona", "curriculum", "dpi_persona", jComboBox_DPIAP, jLabel_DPI_AP);
    }//GEN-LAST:event_tbl_APMouseClicked

    private void txt_BuscarAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarAPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarAPActionPerformed

    private void txt_BuscarAPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarAPKeyReleased
        // TODO add your handling code here:
        Aplicacion ap = new Aplicacion(txt_id_AP, jLabel_DPI_AP, txt_RequisitosAP, txt_BuscarAP, tbl_AP);
        ap.Buscar_AplicacionE(txt_BuscarAP.getText());
    }//GEN-LAST:event_txt_BuscarAPKeyReleased

    private void jLabel_BuscarAPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_BuscarAPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_BuscarAPMouseClicked

    private void Texto_IngresarAPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarAPMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarAP.setVisible(true);
        jLabel_Modificar_AP.setVisible(false);
        jLabel_Eliminar_AP.setVisible(false);
    }//GEN-LAST:event_Texto_IngresarAPMouseClicked

    private void Panel_IngresarAPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarAPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarAPMouseClicked

    private void Texto_ModificarAPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificarAPMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarAP.setVisible(false);
        jLabel_Modificar_AP.setVisible(true);
        jLabel_Eliminar_AP.setVisible(false);
    }//GEN-LAST:event_Texto_ModificarAPMouseClicked

    private void Panel_ModificarAPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarAPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarAPMouseClicked

    private void Texto_EliminarAPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarAPMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarAP.setVisible(false);
        jLabel_Modificar_AP.setVisible(false);
        jLabel_Eliminar_AP.setVisible(true);
    }//GEN-LAST:event_Texto_EliminarAPMouseClicked

    private void Panel_EliminarAPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_EliminarAPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_EliminarAPMouseClicked

    private void Texto_ConsultarAPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarAPMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarAP.setVisible(false);
        jLabel_Modificar_AP.setVisible(false);
        jLabel_Eliminar_AP.setVisible(false);
    }//GEN-LAST:event_Texto_ConsultarAPMouseClicked

    private void Panel_ConsultarAPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ConsultarAPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ConsultarAPMouseClicked

    private void jComboBox_TablasAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TablasAPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TablasAPActionPerformed

    private void jLabel_Buscar_Tablas_M2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Buscar_Tablas_M2MouseClicked
        // TODO add your handling code here:

        Item_DPI = jComboBox_TablasAP.getSelectedItem().toString();

        if (Item_DPI == S_DPI) {
            Curriculum_V CV = new Curriculum_V();
            CV.setVisible(true);
        }
    }//GEN-LAST:event_jLabel_Buscar_Tablas_M2MouseClicked

    private void txt_DPICVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DPICVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DPICVActionPerformed

    private void txt_NombreCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreCVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreCVActionPerformed

    private void txt_ApellidoCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ApellidoCVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ApellidoCVActionPerformed

    private void txt_TelefonoCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TelefonoCVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TelefonoCVActionPerformed

    private void txt_CorreoCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CorreoCVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CorreoCVActionPerformed

    private void txt_DireccionCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DireccionCVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DireccionCVActionPerformed

    private void txt_GeneroCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_GeneroCVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_GeneroCVActionPerformed

    private void txt_EdadCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_EdadCVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EdadCVActionPerformed

    private void jComboBox_NivelACVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_NivelACVActionPerformed
        // TODO add your handling code here:
        Curriculum CV = new Curriculum(txt_DPICV, txt_NombreCV, txt_ApellidoCV, txt_TelefonoCV, txt_CorreoCV, txt_DireccionCV, txt_GeneroCV, txt_EdadCV, jLabel_NivelA_CV, jLabel_RP_CV, jLabel_RL_CV, jLabel_EL_CV, jLabel_Medio_CV, txt_Buscar_CV, tbl_CV);
        CV.EncontrarID_CV("id_nivel_academico", "nivel_academico", "nombre_nivel", jComboBox_NivelACV, jLabel_NivelA_CV);
    }//GEN-LAST:event_jComboBox_NivelACVActionPerformed

    private void jComboBox_RPCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_RPCVActionPerformed
        // TODO add your handling code here:
        Curriculum CV = new Curriculum(txt_DPICV, txt_NombreCV, txt_ApellidoCV, txt_TelefonoCV, txt_CorreoCV, txt_DireccionCV, txt_GeneroCV, txt_EdadCV, jLabel_NivelA_CV, jLabel_RP_CV, jLabel_RL_CV, jLabel_EL_CV, jLabel_Medio_CV, txt_Buscar_CV, tbl_CV);
        CV.EncontrarID_CV("id_referenciaP", "referenciasp", "nombre_personaP", jComboBox_RPCV, jLabel_RP_CV);
    }//GEN-LAST:event_jComboBox_RPCVActionPerformed

    private void jComboBox_RLCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_RLCVActionPerformed
        // TODO add your handling code here:
        Curriculum CV = new Curriculum(txt_DPICV, txt_NombreCV, txt_ApellidoCV, txt_TelefonoCV, txt_CorreoCV, txt_DireccionCV, txt_GeneroCV, txt_EdadCV, jLabel_NivelA_CV, jLabel_RP_CV, jLabel_RL_CV, jLabel_EL_CV, jLabel_Medio_CV, txt_Buscar_CV, tbl_CV);
        CV.EncontrarID_CV("id_referenciaL", "referenciasl", "nombre_personaL", jComboBox_RLCV, jLabel_RL_CV);
    }//GEN-LAST:event_jComboBox_RLCVActionPerformed

    private void jComboBox_ELCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ELCVActionPerformed
        // TODO add your handling code here:
        Curriculum CV = new Curriculum(txt_DPICV, txt_NombreCV, txt_ApellidoCV, txt_TelefonoCV, txt_CorreoCV, txt_DireccionCV, txt_GeneroCV, txt_EdadCV, jLabel_NivelA_CV, jLabel_RP_CV, jLabel_RL_CV, jLabel_EL_CV, jLabel_Medio_CV, txt_Buscar_CV, tbl_CV);
        CV.EncontrarID_CV("id_experiencia", "experiencia_laboral", "id_tipoexp", jComboBox_ELCV, jLabel_EL_CV);
    }//GEN-LAST:event_jComboBox_ELCVActionPerformed

    private void jComboBox_MedioCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_MedioCVActionPerformed
        // TODO add your handling code here:
        Curriculum CV = new Curriculum(txt_DPICV, txt_NombreCV, txt_ApellidoCV, txt_TelefonoCV, txt_CorreoCV, txt_DireccionCV, txt_GeneroCV, txt_EdadCV, jLabel_NivelA_CV, jLabel_RP_CV, jLabel_RL_CV, jLabel_EL_CV, jLabel_Medio_CV, txt_Buscar_CV, tbl_CV);
        CV.EncontrarID_CV("id_medio", "medio", "nombre_medio", jComboBox_MedioCV, jLabel_Medio_CV);
    }//GEN-LAST:event_jComboBox_MedioCVActionPerformed

    private void jLabel_Insertar_CVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Insertar_CVMouseClicked
        // TODO add your handling code here:
        Curriculum CV = new Curriculum(txt_DPICV, txt_NombreCV, txt_ApellidoCV, txt_TelefonoCV, txt_CorreoCV, txt_DireccionCV, txt_GeneroCV, txt_EdadCV, jLabel_NivelA_CV, jLabel_RP_CV, jLabel_RL_CV, jLabel_EL_CV, jLabel_Medio_CV, txt_Buscar_CV, tbl_CV);
        CV.Insertar_C();
    }//GEN-LAST:event_jLabel_Insertar_CVMouseClicked

    private void jLabel_Modificar_CVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Modificar_CVMouseClicked
        // TODO add your handling code here:
        Curriculum CV = new Curriculum(txt_DPICV, txt_NombreCV, txt_ApellidoCV, txt_TelefonoCV, txt_CorreoCV, txt_DireccionCV, txt_GeneroCV, txt_EdadCV, jLabel_NivelA_CV, jLabel_RP_CV, jLabel_RL_CV, jLabel_EL_CV, jLabel_Medio_CV, txt_Buscar_CV, tbl_CV);
        CV.Modificar_C();
    }//GEN-LAST:event_jLabel_Modificar_CVMouseClicked

    private void jLabel_Eliminar_CVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Eliminar_CVMouseClicked
        // TODO add your handling code here:
        Curriculum CV = new Curriculum(txt_DPICV, txt_NombreCV, txt_ApellidoCV, txt_TelefonoCV, txt_CorreoCV, txt_DireccionCV, txt_GeneroCV, txt_EdadCV, jLabel_NivelA_CV, jLabel_RP_CV, jLabel_RL_CV, jLabel_EL_CV, jLabel_Medio_CV, txt_Buscar_CV, tbl_CV);
        CV.Eliminar_C();
        CV.EncontrarID_CV("id_nivel_academico", "nivel_academico", "nombre_nivel", jComboBox_NivelACV, jLabel_NivelA_CV);
        CV.EncontrarID_CV("id_referenciaP", "referenciasp", "nombre_personaP", jComboBox_RPCV, jLabel_RP_CV);
        CV.EncontrarID_CV("id_referenciaL", "referenciasl", "nombre_personaL", jComboBox_RLCV, jLabel_RL_CV);
        CV.EncontrarID_CV("id_experiencia", "experiencia_laboral", "id_tipoexp", jComboBox_ELCV, jLabel_EL_CV);
        CV.EncontrarID_CV("id_medio", "medio", "nombre_medio", jComboBox_MedioCV, jLabel_Medio_CV);
    }//GEN-LAST:event_jLabel_Eliminar_CVMouseClicked

    private void txt_Buscar_CVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Buscar_CVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Buscar_CVActionPerformed

    private void txt_Buscar_CVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Buscar_CVKeyReleased
        // TODO add your handling code here:
        Curriculum CV = new Curriculum(txt_DPICV, txt_NombreCV, txt_ApellidoCV, txt_TelefonoCV, txt_CorreoCV, txt_DireccionCV, txt_GeneroCV, txt_EdadCV, jLabel_NivelA_CV, jLabel_RP_CV, jLabel_RL_CV, jLabel_EL_CV, jLabel_Medio_CV, txt_Buscar_CV, tbl_CV);
        CV.Buscar_SolicitudCV(txt_Buscar_CV.getText());
    }//GEN-LAST:event_txt_Buscar_CVKeyReleased

    private void tbl_CVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CVMouseClicked
        // TODO add your handling code here:

        int Seleccion = tbl_CV.rowAtPoint(evt.getPoint());

        txt_DPICV.setText(String.valueOf(tbl_CV.getValueAt(Seleccion, 0)));
        txt_NombreCV.setText(String.valueOf(tbl_CV.getValueAt(Seleccion, 1)));
        txt_ApellidoCV.setText(String.valueOf(tbl_CV.getValueAt(Seleccion, 2)));
        txt_TelefonoCV.setText(String.valueOf(tbl_CV.getValueAt(Seleccion, 3)));
        txt_CorreoCV.setText(String.valueOf(tbl_CV.getValueAt(Seleccion, 4)));
        txt_DireccionCV.setText(String.valueOf(tbl_CV.getValueAt(Seleccion, 5)));
        txt_GeneroCV.setText(String.valueOf(tbl_CV.getValueAt(Seleccion, 6)));
        txt_EdadCV.setText(String.valueOf(tbl_CV.getValueAt(Seleccion, 7)));
        jLabel_NivelA_CV.setText(String.valueOf(tbl_CV.getValueAt(Seleccion, 8)));
        jLabel_RP_CV.setText(String.valueOf(tbl_CV.getValueAt(Seleccion, 9)));
        jLabel_RL_CV.setText(String.valueOf(tbl_CV.getValueAt(Seleccion, 10)));
        jLabel_EL_CV.setText(String.valueOf(tbl_CV.getValueAt(Seleccion, 11)));
        jLabel_Medio_CV.setText(String.valueOf(tbl_CV.getValueAt(Seleccion, 12)));

        Curriculum CV = new Curriculum(txt_DPICV, txt_NombreCV, txt_ApellidoCV, txt_TelefonoCV, txt_CorreoCV, txt_DireccionCV, txt_GeneroCV, txt_EdadCV, jLabel_NivelA_CV, jLabel_RP_CV, jLabel_RL_CV, jLabel_EL_CV, jLabel_Medio_CV, txt_Buscar_CV, tbl_CV);
        CV.BuscarFila_CV("nombre_nivel", "nivel_academico", "id_nivel_academico", jComboBox_NivelACV, jLabel_NivelA_CV);
        CV.BuscarFila_CV("nombre_personaP", "referenciasP", "id_referenciaP", jComboBox_RPCV, jLabel_RP_CV);
        CV.BuscarFila_CV("nombre_personaL", "referenciasL", "id_referenciaL", jComboBox_RLCV, jLabel_RL_CV);
        CV.BuscarFila_CV("id_tipoexp", "experiencia_laboral", "id_tipoexp", jComboBox_ELCV, jLabel_EL_CV);
        CV.BuscarFila_CV("nombre_medio", "medio", "id_medio", jComboBox_MedioCV, jLabel_Medio_CV);
        //id_experiencia
    }//GEN-LAST:event_tbl_CVMouseClicked

    private void Texto_IngresarSE4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarSE4MouseClicked
        // TODO add your handling code here:
        jLabel_Insertar_CV.setVisible(true);
        jLabel_Modificar_CV.setVisible(false);
        jLabel_Eliminar_CV.setVisible(false);
    }//GEN-LAST:event_Texto_IngresarSE4MouseClicked

    private void Panel_IngresarM4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarM4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarM4MouseClicked

    private void Texto_ModificarSE4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificarSE4MouseClicked
        // TODO add your handling code here:
        jLabel_Insertar_CV.setVisible(false);
        jLabel_Modificar_CV.setVisible(true);
        jLabel_Eliminar_CV.setVisible(false);
    }//GEN-LAST:event_Texto_ModificarSE4MouseClicked

    private void Panel_ModificarM4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarM4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarM4MouseClicked

    private void Texto_EliminarSE4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarSE4MouseClicked
        // TODO add your handling code here:
        jLabel_Insertar_CV.setVisible(false);
        jLabel_Modificar_CV.setVisible(false);
        jLabel_Eliminar_CV.setVisible(true);
    }//GEN-LAST:event_Texto_EliminarSE4MouseClicked

    private void Panel_EliminarM4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_EliminarM4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_EliminarM4MouseClicked

    private void Texto_ConsultarSE4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarSE4MouseClicked
        // TODO add your handling code here:
        jLabel_Insertar_CV.setVisible(false);
        jLabel_Modificar_CV.setVisible(false);
        jLabel_Eliminar_CV.setVisible(false);
    }//GEN-LAST:event_Texto_ConsultarSE4MouseClicked

    private void Panel_ConsultarM4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ConsultarM4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ConsultarM4MouseClicked

    private void jComboBox_TablasB_CV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TablasB_CV1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TablasB_CV1ActionPerformed

    private void jLabel_Buscar_Tablas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Buscar_Tablas1MouseClicked
        // TODO add your handling code here:

        Item_NA = jComboBox_TablasB_CV1.getSelectedItem().toString();

        if (Item_NA == S_NA) {
            Nivel_Academico_Ve NA = new Nivel_Academico_Ve();
            NA.setVisible(true);
        }

        Item_EL = jComboBox_TablasB_CV1.getSelectedItem().toString();

        if (Item_EL == S_EL) {
            Experiencia_Laboral_Ve EL = new Experiencia_Laboral_Ve();
            EL.setVisible(true);
        }

        Item_RP = jComboBox_TablasB_CV1.getSelectedItem().toString();
        if (Item_RP == S_RP) {
            Referencias_Personales_V RP = new Referencias_Personales_V();
            RP.setVisible(true);
        }

        Item_RL = jComboBox_TablasB_CV1.getSelectedItem().toString();
        if (Item_RL == S_RL) {
            Referencias_Laborales_V RL = new Referencias_Laborales_V();
            RL.setVisible(true);

        }

        Item_Med = jComboBox_TablasB_CV1.getSelectedItem().toString();
        if (Item_Med == S_Med) {
            Medio_Ve Med = new Medio_Ve();
            Med.setVisible(true);

        }
    }//GEN-LAST:event_jLabel_Buscar_Tablas1MouseClicked

    private void txt_id_RPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_RPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_RPActionPerformed

    private void txt_Nombre_RPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Nombre_RPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Nombre_RPActionPerformed

    private void txt_Telefono_RPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Telefono_RPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Telefono_RPActionPerformed

    private void jLabel_Insertar_RPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Insertar_RPMouseClicked
        // TODO add your handling code here:
        Referencias_Personales RP = new Referencias_Personales(txt_id_RP, txt_Nombre_RP, txt_Telefono_RP, txt_Buscar_RP, tbl_RP);
        RP.Insertar_ReferenciasP();
    }//GEN-LAST:event_jLabel_Insertar_RPMouseClicked

    private void jLabel_Modificar_RPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Modificar_RPMouseClicked
        // TODO add your handling code here:
        //MODIFICAAAR
        Referencias_Personales RP = new Referencias_Personales(txt_id_RP, txt_Nombre_RP, txt_Telefono_RP, txt_Buscar_RP, tbl_RP);
        RP.Modificar_RefPer();
    }//GEN-LAST:event_jLabel_Modificar_RPMouseClicked

    private void jLabel_Eliminar_RPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Eliminar_RPMouseClicked
        // TODO add your handling code here:
        //ELIMINARRRRR
        Referencias_Personales RP = new Referencias_Personales(txt_id_RP, txt_Nombre_RP, txt_Telefono_RP, txt_Buscar_RP, tbl_RP);
        RP.Eliminar_ReferenciasP();
    }//GEN-LAST:event_jLabel_Eliminar_RPMouseClicked

    private void txt_Buscar_RPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Buscar_RPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Buscar_RPActionPerformed

    private void txt_Buscar_RPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Buscar_RPKeyReleased
        // TODO add your handling code here:
        Referencias_Personales RP = new Referencias_Personales(txt_id_RP, txt_Nombre_RP, txt_Telefono_RP, txt_Buscar_RP, tbl_RP);
        RP.Buscar_ReferenciasP(txt_Buscar_RP.getText());
    }//GEN-LAST:event_txt_Buscar_RPKeyReleased

    private void Texto_IngresarSE3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarSE3MouseClicked
        // TODO add your handling code here:
        jLabel_Insertar_RP.setVisible(true);
        jLabel_Modificar_RP.setVisible(false);
        jLabel_Eliminar_RP.setVisible(false);
    }//GEN-LAST:event_Texto_IngresarSE3MouseClicked

    private void Panel_IngresarM3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarM3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarM3MouseClicked

    private void Texto_ModificarSE3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificarSE3MouseClicked
        // TODO add your handling code here:
        jLabel_Insertar_RP.setVisible(false);
        jLabel_Modificar_RP.setVisible(true);
        jLabel_Eliminar_RP.setVisible(false);
    }//GEN-LAST:event_Texto_ModificarSE3MouseClicked

    private void Panel_ModificarM3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarM3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarM3MouseClicked

    private void Texto_EliminarSE3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarSE3MouseClicked
        // TODO add your handling code here:
        jLabel_Insertar_RP.setVisible(false);
        jLabel_Modificar_RP.setVisible(false);
        jLabel_Eliminar_RP.setVisible(true);
    }//GEN-LAST:event_Texto_EliminarSE3MouseClicked

    private void Panel_EliminarM3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_EliminarM3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_EliminarM3MouseClicked

    private void Texto_ConsultarSE3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarSE3MouseClicked
        // TODO add your handling code here:
        jLabel_Insertar_RP.setVisible(false);
        jLabel_Modificar_RP.setVisible(false);
        jLabel_Eliminar_RP.setVisible(false);
    }//GEN-LAST:event_Texto_ConsultarSE3MouseClicked

    private void Panel_ConsultarM3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ConsultarM3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ConsultarM3MouseClicked

    private void txt_id_ReferenciaLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_ReferenciaLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_ReferenciaLActionPerformed

    private void txt_NombreRLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreRLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreRLActionPerformed

    private void txt_TelefonoRLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TelefonoRLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TelefonoRLActionPerformed

    private void jLabel_IngresarRLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_IngresarRLMouseClicked
        // TODO add your handling code here:
        Referencias_Laborales referencias_Lab = new Referencias_Laborales(txt_id_ReferenciaL, txt_NombreRL, txt_TelefonoRL, txt_BuscarRL, tbl_RL);
        referencias_Lab.Insertar_ReferenciasL();
    }//GEN-LAST:event_jLabel_IngresarRLMouseClicked

    private void jLabel_ModificarRLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ModificarRLMouseClicked
        // TODO add your handling code here:
        Referencias_Laborales referencias_Lab = new Referencias_Laborales(txt_id_ReferenciaL, txt_NombreRL, txt_TelefonoRL, txt_BuscarRL, tbl_RL);
        referencias_Lab.Modificar_RefLab();
    }//GEN-LAST:event_jLabel_ModificarRLMouseClicked

    private void jLabel_EliminarRLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EliminarRLMouseClicked
        // TODO add your handling code here:
        Referencias_Laborales referencias_Lab = new Referencias_Laborales(txt_id_ReferenciaL, txt_NombreRL, txt_TelefonoRL, txt_BuscarRL, tbl_RL);
        referencias_Lab.Eliminar_ReferenciasL();
    }//GEN-LAST:event_jLabel_EliminarRLMouseClicked

    private void tbl_RLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_RLMouseClicked
        // TODO add your handling code here:

        int Seleccion = tbl_RL.rowAtPoint(evt.getPoint());

        txt_id_ReferenciaL.setText(String.valueOf(tbl_RL.getValueAt(Seleccion, 0)));
        txt_NombreRL.setText(String.valueOf(tbl_RL.getValueAt(Seleccion, 1)));
        txt_TelefonoRL.setText(String.valueOf(tbl_RL.getValueAt(Seleccion, 2)));
    }//GEN-LAST:event_tbl_RLMouseClicked

    private void jLabel_BuscarRLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_BuscarRLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_BuscarRLMouseClicked

    private void txt_BuscarRLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarRLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarRLActionPerformed

    private void txt_BuscarRLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarRLKeyReleased
        // TODO add your handling code here:
        Referencias_Laborales referencias_lab = new Referencias_Laborales(txt_id_ReferenciaL, txt_NombreRL, txt_TelefonoRL, txt_BuscarRL, tbl_RL);
        referencias_lab.Buscar_ReferenciasLF(txt_BuscarRL.getText());
    }//GEN-LAST:event_txt_BuscarRLKeyReleased

    private void Texto_IngresarRLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarRLMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarRL.setVisible(true);
        jLabel_ModificarRL.setVisible(false);
        jLabel_EliminarRL.setVisible(false);
    }//GEN-LAST:event_Texto_IngresarRLMouseClicked

    private void Panel_IngresarRLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarRLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarRLMouseClicked

    private void Texto_ModificarRLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificarRLMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarRL.setVisible(false);
        jLabel_ModificarRL.setVisible(true);
        jLabel_EliminarRL.setVisible(false);
    }//GEN-LAST:event_Texto_ModificarRLMouseClicked

    private void Panel_ModificarRLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarRLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarRLMouseClicked

    private void Texto_EliminarRLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarRLMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarRL.setVisible(false);
        jLabel_ModificarRL.setVisible(false);
        jLabel_EliminarRL.setVisible(true);
    }//GEN-LAST:event_Texto_EliminarRLMouseClicked

    private void Panel_EliminarRLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_EliminarRLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_EliminarRLMouseClicked

    private void Texto_ConsultarRLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarRLMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarRL.setVisible(false);
        jLabel_ModificarRL.setVisible(false);
        jLabel_EliminarRL.setVisible(false);
    }//GEN-LAST:event_Texto_ConsultarRLMouseClicked

    private void Panel_ConsultarRLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ConsultarRLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ConsultarRLMouseClicked

    private void txt_id_MedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_MedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_MedioActionPerformed

    private void jComboBox_IDSEMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_IDSEMActionPerformed
        // TODO add your handling code here:
        Medio M = new Medio(txt_id_Medio, jLabel_ID_SEM, txt_NombreM, jTextArea_DescripcionM, txt_BuscarM, tbl_Medio);
        M.EncontrarID_M("id_solicitud", "solicitud_empresarial", "id_solicitud", jComboBox_IDSEM, jLabel_ID_SEM);
    }//GEN-LAST:event_jComboBox_IDSEMActionPerformed

    private void txt_NombreMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreMActionPerformed

    private void jLabel_BuscarMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_BuscarMMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_BuscarMMouseClicked

    private void txt_BuscarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarMActionPerformed

    private void txt_BuscarMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarMKeyReleased
        // TODO add your handling code here:
        Medio M = new Medio(txt_id_Medio, jLabel_ID_SEM, txt_NombreM, jTextArea_DescripcionM, txt_BuscarM, tbl_Medio);
        M.Buscar_SolicitudM(txt_BuscarM.getText());
    }//GEN-LAST:event_txt_BuscarMKeyReleased

    private void jLabel_IngresarMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_IngresarMMouseClicked
        // TODO add your handling code here:
        Medio M = new Medio(txt_id_Medio, jLabel_ID_SEM, txt_NombreM, jTextArea_DescripcionM, txt_BuscarM, tbl_Medio);
        M.Insertar_Me();
    }//GEN-LAST:event_jLabel_IngresarMMouseClicked

    private void jLabel_ModificarMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ModificarMMouseClicked
        // TODO add your handling code here:
        //modificar
        Medio M = new Medio(txt_id_Medio, jLabel_ID_SEM, txt_NombreM, jTextArea_DescripcionM, txt_BuscarM, tbl_Medio);
        M.Modificar_SE();
    }//GEN-LAST:event_jLabel_ModificarMMouseClicked

    private void jLabel_EliminarMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EliminarMMouseClicked
        // TODO add your handling code here:
        Medio M = new Medio(txt_id_Medio, jLabel_ID_SEM, txt_NombreM, jTextArea_DescripcionM, txt_BuscarM, tbl_Medio);
        M.Eliminar_SE();
        M.EncontrarID_M("id_solicitud", "solicitud_empresarial", "id_solicitud", jComboBox_IDSEM, jLabel_ID_SEM);
    }//GEN-LAST:event_jLabel_EliminarMMouseClicked

    private void Texto_IngresarSE2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarSE2MouseClicked
        // TODO add your handling code here:
        jLabel_IngresarM.setVisible(true);
        jLabel_ModificarM.setVisible(false);
        jLabel_EliminarM.setVisible(false);
    }//GEN-LAST:event_Texto_IngresarSE2MouseClicked

    private void Panel_IngresarM2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarM2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarM2MouseClicked

    private void Texto_ModificarSE2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificarSE2MouseClicked
        // TODO add your handling code here:
        jLabel_IngresarM.setVisible(false);
        jLabel_ModificarM.setVisible(true);
        jLabel_EliminarM.setVisible(false);
    }//GEN-LAST:event_Texto_ModificarSE2MouseClicked

    private void Panel_ModificarM2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarM2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarM2MouseClicked

    private void Texto_EliminarSE2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarSE2MouseClicked
        // TODO add your handling code here:
        jLabel_IngresarM.setVisible(false);
        jLabel_ModificarM.setVisible(false);
        jLabel_EliminarM.setVisible(true);
    }//GEN-LAST:event_Texto_EliminarSE2MouseClicked

    private void Panel_EliminarM2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_EliminarM2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_EliminarM2MouseClicked

    private void Texto_ConsultarSE2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarSE2MouseClicked
        // TODO add your handling code here:
        jLabel_IngresarM.setVisible(false);
        jLabel_ModificarM.setVisible(false);
        jLabel_EliminarM.setVisible(false);
    }//GEN-LAST:event_Texto_ConsultarSE2MouseClicked

    private void Panel_ConsultarM2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ConsultarM2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ConsultarM2MouseClicked

    private void jComboBox_TablasB_M1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TablasB_M1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TablasB_M1ActionPerformed

    private void jLabel_Buscar_Tablas_M1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Buscar_Tablas_M1MouseClicked
        // TODO add your handling code here:
        Item_SE = jComboBox_TablasB_M1.getSelectedItem().toString();
        //puesto,dep,nive

        if (Item_SE == S_Emp) {
            Solicitud_Empresarial_V MedV = new Solicitud_Empresarial_V();
            MedV.setVisible(true);
        }
    }//GEN-LAST:event_jLabel_Buscar_Tablas_M1MouseClicked

    private void txt_id_SolicitudEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_SolicitudEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_SolicitudEActionPerformed

    private void txt_RangoEdadMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RangoEdadMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RangoEdadMActionPerformed

    private void txt_RangoEdadMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RangoEdadMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RangoEdadMaActionPerformed

    private void txt_GeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_GeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_GeneroActionPerformed

    private void jLabel_Puesto_SEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Puesto_SEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_Puesto_SEMouseClicked

    private void jComboBox_PuestoSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_PuestoSEActionPerformed
        Solicitud_Empresarial SE = new Solicitud_Empresarial(txt_id_SolicitudE, txt_RangoEdadM, txt_RangoEdadMa, txt_Genero, jLabel_Puesto_SE, jLabel_Departamento_SE, jLabel_NivelA_SE, jLabel_ExperienciaL_SE, jTextArea_DescripcionSE, txt_Buscar_SE, tbl_SE);
        SE.EncontrarID_SE("id_puesto", "puesto", "nombre_puesto", jComboBox_PuestoSE, jLabel_Puesto_SE);
    }//GEN-LAST:event_jComboBox_PuestoSEActionPerformed

    private void jComboBox_DepartamentoSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_DepartamentoSEActionPerformed
        // TODO add your handling code here:
        Solicitud_Empresarial SE = new Solicitud_Empresarial(txt_id_SolicitudE, txt_RangoEdadM, txt_RangoEdadMa, txt_Genero, jLabel_Puesto_SE, jLabel_Departamento_SE, jLabel_NivelA_SE, jLabel_ExperienciaL_SE, jTextArea_DescripcionSE, txt_Buscar_SE, tbl_SE);
        SE.EncontrarID_SE("id_departamento", "departamento", "nombre_departamento", jComboBox_DepartamentoSE, jLabel_Departamento_SE);
    }//GEN-LAST:event_jComboBox_DepartamentoSEActionPerformed

    private void jLabel_NivelA_SEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_NivelA_SEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_NivelA_SEMouseClicked

    private void jComboBox_NivelASEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_NivelASEActionPerformed
        // TODO add your handling code here:
        Solicitud_Empresarial SE = new Solicitud_Empresarial(txt_id_SolicitudE, txt_RangoEdadM, txt_RangoEdadMa, txt_Genero, jLabel_Puesto_SE, jLabel_Departamento_SE, jLabel_NivelA_SE, jLabel_ExperienciaL_SE, jTextArea_DescripcionSE, txt_Buscar_SE, tbl_SE);
        SE.EncontrarID_SE("id_nivel_academico", "nivel_academico", "nombre_nivel", jComboBox_NivelASE, jLabel_NivelA_SE);
    }//GEN-LAST:event_jComboBox_NivelASEActionPerformed

    private void jComboBox_ExperienciaL_SEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ExperienciaL_SEActionPerformed
        // TODO add your handling code here:
        Solicitud_Empresarial SE = new Solicitud_Empresarial(txt_id_SolicitudE, txt_RangoEdadM, txt_RangoEdadMa, txt_Genero, jLabel_Puesto_SE, jLabel_Departamento_SE, jLabel_NivelA_SE, jLabel_ExperienciaL_SE, jTextArea_DescripcionSE, txt_Buscar_SE, tbl_SE);
        SE.EncontrarID_SE("id_experiencia", "experiencia_laboral", "id_tipoexp", jComboBox_ExperienciaL_SE, jLabel_ExperienciaL_SE);
    }//GEN-LAST:event_jComboBox_ExperienciaL_SEActionPerformed

    private void tbl_SEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SEMouseClicked
        int Seleccion = tbl_SE.rowAtPoint(evt.getPoint());
        txt_id_SolicitudE.setText(String.valueOf(tbl_SE.getValueAt(Seleccion, 0)));
        txt_RangoEdadM.setText(String.valueOf(tbl_SE.getValueAt(Seleccion, 1)));
        txt_RangoEdadMa.setText(String.valueOf(tbl_SE.getValueAt(Seleccion, 2)));
        txt_Genero.setText(String.valueOf(tbl_SE.getValueAt(Seleccion, 3)));
        jTextArea_DescripcionSE.setText(String.valueOf(tbl_SE.getValueAt(Seleccion, 8)));
        jLabel_Puesto_SE.setText(String.valueOf(tbl_SE.getValueAt(Seleccion, 4)));
        jLabel_Departamento_SE.setText(String.valueOf(tbl_SE.getValueAt(Seleccion, 5)));
        jLabel_NivelA_SE.setText(String.valueOf(tbl_SE.getValueAt(Seleccion, 6)));
        jLabel_ExperienciaL_SE.setText(String.valueOf(tbl_SE.getValueAt(Seleccion, 7)));
        Solicitud_Empresarial SE = new Solicitud_Empresarial(txt_id_SolicitudE, txt_RangoEdadM, txt_RangoEdadMa, txt_Genero, jLabel_Puesto_SE, jLabel_Departamento_SE, jLabel_NivelA_SE, jLabel_ExperienciaL_SE, jTextArea_DescripcionSE, txt_Buscar_SE, tbl_SE);
        SE.BuscarFila_SE("nombre_puesto", "puesto", "id_puesto", jComboBox_PuestoSE, jLabel_Puesto_SE);
        SE.BuscarFila_SE("nombre_departamento", "departamento", "id_departamento", jComboBox_DepartamentoSE, jLabel_Departamento_SE);
        SE.BuscarFila_SE("nombre_nivel", "nivel_academico", "id_nivel_academico", jComboBox_NivelASE, jLabel_NivelA_SE);
        SE.BuscarFila_SE("id_tipoexp", "experiencia_laboral", "id_experiencia", jComboBox_ExperienciaL_SE, jLabel_ExperienciaL_SE);
    }//GEN-LAST:event_tbl_SEMouseClicked

    private void txt_Buscar_SEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_Buscar_SEMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Buscar_SEMousePressed

    private void txt_Buscar_SEMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_Buscar_SEMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Buscar_SEMouseReleased

    private void txt_Buscar_SEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Buscar_SEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Buscar_SEActionPerformed

    private void txt_Buscar_SEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Buscar_SEKeyReleased
        // TODO add your handling code here:
        Solicitud_Empresarial SE = new Solicitud_Empresarial(txt_id_SolicitudE, txt_RangoEdadM, txt_RangoEdadMa, txt_Genero, jLabel_Puesto_SE, jLabel_Departamento_SE, jLabel_NivelA_SE, jLabel_ExperienciaL_SE, jTextArea_DescripcionSE, txt_Buscar_SE, tbl_SE);
        SE.Buscar_SolicitudE(txt_Buscar_SE.getText());
    }//GEN-LAST:event_txt_Buscar_SEKeyReleased

    private void jLabel_Buscar_SEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Buscar_SEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_Buscar_SEMouseClicked

    private void jLabel_IngresarSEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_IngresarSEMouseClicked
        Solicitud_Empresarial SE = new Solicitud_Empresarial(txt_id_SolicitudE, txt_RangoEdadM, txt_RangoEdadMa, txt_Genero, jLabel_Puesto_SE, jLabel_Departamento_SE, jLabel_NivelA_SE, jLabel_ExperienciaL_SE, jTextArea_DescripcionSE, txt_Buscar_SE, tbl_SE);
        SE.Insertar_SE();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_IngresarSEMouseClicked

    private void jLabel_Modificar_SEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Modificar_SEMouseClicked
        Solicitud_Empresarial SE = new Solicitud_Empresarial(txt_id_SolicitudE, txt_RangoEdadM, txt_RangoEdadMa, txt_Genero, jLabel_Puesto_SE, jLabel_Departamento_SE, jLabel_NivelA_SE, jLabel_ExperienciaL_SE, jTextArea_DescripcionSE, txt_Buscar_SE, tbl_SE);
        SE.Modificar_SE();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_Modificar_SEMouseClicked

    private void jLabel_Eliminar_SEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Eliminar_SEMouseClicked
        // TODO add your handling code here:
        Solicitud_Empresarial SE = new Solicitud_Empresarial(txt_id_SolicitudE, txt_RangoEdadM, txt_RangoEdadMa, txt_Genero, jLabel_Puesto_SE, jLabel_Departamento_SE, jLabel_NivelA_SE, jLabel_ExperienciaL_SE, jTextArea_DescripcionSE, txt_Buscar_SE, tbl_SE);
        SE.Eliminar_SE();
        SE.EncontrarID_SE("id_puesto", "puesto", "nombre_puesto", jComboBox_PuestoSE, jLabel_Puesto_SE);
        SE.EncontrarID_SE("id_departamento", "departamento", "nombre_departamento", jComboBox_DepartamentoSE, jLabel_Departamento_SE);
        SE.EncontrarID_SE("id_nivel_academico", "nivel_academico", "nombre_nivel", jComboBox_NivelASE, jLabel_NivelA_SE);
        SE.EncontrarID_SE("id_experiencia", "experiencia_laboral", "id_tipoexp", jComboBox_ExperienciaL_SE, jLabel_ExperienciaL_SE);
    }//GEN-LAST:event_jLabel_Eliminar_SEMouseClicked

    private void Texto_IngresarSEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarSEMouseClicked
        jLabel_Modificar_SE.setVisible(false);
        jLabel_Eliminar_SE.setVisible(false);
        jLabel_IngresarSE.setVisible(true);
    }//GEN-LAST:event_Texto_IngresarSEMouseClicked

    private void Panel_IngresarSEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarSEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarSEMouseClicked

    private void Texto_ModificarSEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificarSEMouseClicked
        jLabel_Modificar_SE.setVisible(true);
        jLabel_Eliminar_SE.setVisible(false);
        jLabel_IngresarSE.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_ModificarSEMouseClicked

    private void Panel_ModificarSEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarSEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarSEMouseClicked

    private void Texto_EliminarSEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarSEMouseClicked
        jLabel_Modificar_SE.setVisible(false);
        jLabel_Eliminar_SE.setVisible(true);
        jLabel_IngresarSE.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_EliminarSEMouseClicked

    private void Texto_ConsultarSEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarSEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_ConsultarSEMouseClicked

    private void Panel_ConsultarSEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ConsultarSEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ConsultarSEMouseClicked

    private void jComboBox_TablasB_SEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TablasB_SEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TablasB_SEActionPerformed

    private void jLabel_Buscar_Tablas_SEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Buscar_Tablas_SEMouseClicked

        Item_P = jComboBox_TablasB_SE.getSelectedItem().toString();

        if (Item_P == S_Puesto) {
            Puesto_V puesto = new Puesto_V();
            puesto.setVisible(true);
        }

        Item_D = jComboBox_TablasB_SE.getSelectedItem().toString();

        if (Item_D == S_Departamento) {
            Departamento_V Depto = new Departamento_V();
            Depto.setVisible(true);
        }

        Item_NA = jComboBox_TablasB_SE.getSelectedItem().toString();

        if (Item_NA == S_NA) {
            Nivel_Academico_Ve NA = new Nivel_Academico_Ve();
            NA.setVisible(true);
        }

        Item_EL = jComboBox_TablasB_SE.getSelectedItem().toString();

        if (Item_EL == S_EL) {
            Experiencia_Laboral_Ve EL = new Experiencia_Laboral_Ve();
            EL.setVisible(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_Buscar_Tablas_SEMouseClicked

    private void txt_id_ExpLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_ExpLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_ExpLActionPerformed

    private void jLabel_Insertar_ExpLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Insertar_ExpLMouseClicked
        // TODO add your handling code here:
        Experiencia_Laboral ExpL = new Experiencia_Laboral(txt_id_ExpL, jLabel_id_Nombre_EpLLD, txt_Buscar_ExpL, tbl_ExpL);
        ExpL.Insertar_ExpL();
        ExpL.EncontrarID_ExpLD("id_tipoexp", "explab_detallado", "nombre_tipo", jComboBox_Nombre_EpLLD);
    }//GEN-LAST:event_jLabel_Insertar_ExpLMouseClicked

    private void jLabel_Modificar_ExpLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Modificar_ExpLMouseClicked
        // TODO add your handling code here:
        Experiencia_Laboral ExpL = new Experiencia_Laboral(txt_id_ExpL, jLabel_id_Nombre_EpLLD, txt_Buscar_ExpL, tbl_ExpL);
        ExpL.Modificar_ExpL();
    }//GEN-LAST:event_jLabel_Modificar_ExpLMouseClicked

    private void jLabel_Eliminar_ExpLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Eliminar_ExpLMouseClicked
        // TODO add your handling code here:
        Experiencia_Laboral ExpL = new Experiencia_Laboral(txt_id_ExpL, jLabel_id_Nombre_EpLLD, txt_Buscar_ExpL, tbl_ExpL);
        ExpL.Eliminar_ExpL();
        ExpL.EncontrarID_ExpLD("id_tipoexp", "explab_detallado", "nombre_tipo", jComboBox_Nombre_EpLLD);
    }//GEN-LAST:event_jLabel_Eliminar_ExpLMouseClicked

    private void txt_Buscar_ExpLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Buscar_ExpLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Buscar_ExpLActionPerformed

    private void txt_Buscar_ExpLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Buscar_ExpLKeyReleased
        // TODO add your handling code here:
        Experiencia_Laboral ExpL = new Experiencia_Laboral(txt_id_ExpL, jLabel_id_Nombre_EpLLD, txt_Buscar_ExpL, tbl_ExpL);
        ExpL.Buscar_ExpLF(txt_Buscar_ExpL.getText());
    }//GEN-LAST:event_txt_Buscar_ExpLKeyReleased

    private void tbl_ExpLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ExpLMouseClicked
        // TODO add your handling code here:
        int Seleccion = tbl_ExpL.rowAtPoint(evt.getPoint());
        txt_id_ExpL.setText(String.valueOf(tbl_ExpL.getValueAt(Seleccion, 0)));
        jLabel_id_Nombre_EpLLD.setText(String.valueOf(tbl_ExpL.getValueAt(Seleccion, 1)));

        Experiencia_Laboral ExpL = new Experiencia_Laboral(txt_id_ExpL, jLabel_id_Nombre_EpLLD, txt_Buscar_ExpL, tbl_ExpL);
        ExpL.BuscarFila_ExpL("nombre_tipo", "explab_detallado", "id_tipoexp", jComboBox_Nombre_EpLLD, jLabel_id_Nombre_EpLLD);
    }//GEN-LAST:event_tbl_ExpLMouseClicked

    private void jComboBox_Nombre_EpLLDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Nombre_EpLLDActionPerformed
        // TODO add your handling code here:
        Experiencia_Laboral ExpL = new Experiencia_Laboral(txt_id_ExpL, jLabel_id_Nombre_EpLLD, txt_Buscar_ExpL, tbl_ExpL);
        ExpL.EncontrarID_ExpLD("id_tipoexp", "explab_detallado", "nombre_tipo", jComboBox_Nombre_EpLLD);
    }//GEN-LAST:event_jComboBox_Nombre_EpLLDActionPerformed

    private void Texto_IngresarExpLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarExpLMouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_ExpL.setVisible(false);
        jLabel_Modificar_ExpL.setVisible(false);
        jLabel_Insertar_ExpL.setVisible(true);
    }//GEN-LAST:event_Texto_IngresarExpLMouseClicked

    private void Panel_IngresarExpLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarExpLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarExpLMouseClicked

    private void Texto_ModificarExpLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificarExpLMouseClicked

        // TODO add your handling code here:
        jLabel_Modificar_ExpL.setVisible(true);
        jLabel_Insertar_ExpL.setVisible(false);
        jLabel_Eliminar_ExpL.setVisible(false);
    }//GEN-LAST:event_Texto_ModificarExpLMouseClicked

    private void Panel_ModificarExpLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarExpLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarExpLMouseClicked

    private void Texto_EliminarExpLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarExpLMouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_ExpL.setVisible(true);
        jLabel_Modificar_ExpL.setVisible(false);
        jLabel_Insertar_ExpL.setVisible(false);
    }//GEN-LAST:event_Texto_EliminarExpLMouseClicked

    private void Panel_EliminarExpLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_EliminarExpLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_EliminarExpLMouseClicked

    private void Texto_ConsultarExpLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarExpLMouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_ExpL.setVisible(false);
        jLabel_Modificar_ExpL.setVisible(false);
        jLabel_Insertar_ExpL.setVisible(false);
    }//GEN-LAST:event_Texto_ConsultarExpLMouseClicked

    private void icono_Buscar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono_Buscar4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_icono_Buscar4MouseClicked

    private void jComboBox_TablasB_ExpLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TablasB_ExpLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TablasB_ExpLActionPerformed

    private void jLabel_Buscar_TablasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Buscar_TablasMouseClicked

        // TODO add your handling code here:
        Item = jComboBox_TablasB_ExpL.getSelectedItem().toString();

        if (Item == S_ExpLD) {
            ExpLD_V ExpL = new ExpLD_V();
            ExpL.setVisible(true);
        }
    }//GEN-LAST:event_jLabel_Buscar_TablasMouseClicked

    private void jPanel_MantenimientoExpLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_MantenimientoExpLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel_MantenimientoExpLMouseClicked

    private void txt_id_ExpLDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_ExpLDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_ExpLDActionPerformed

    private void txt_NombreExpLDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreExpLDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreExpLDActionPerformed

    private void txt_Nombre_EmpresaExpLDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Nombre_EmpresaExpLDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Nombre_EmpresaExpLDActionPerformed

    private void txt_Tiempo_InicioExpLDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Tiempo_InicioExpLDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Tiempo_InicioExpLDActionPerformed

    private void txt_Tiempo_FinalizacionExpLDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Tiempo_FinalizacionExpLDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Tiempo_FinalizacionExpLDActionPerformed

    private void jLabel_Insertar_ExpLDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Insertar_ExpLDMouseClicked
        // TODO add your handling code here:
        Experiencia_Laboral_Detallada ExpLD = new Experiencia_Laboral_Detallada(txt_id_ExpLD, txt_NombreExpLD, txt_Nombre_EmpresaExpLD, txt_Tiempo_InicioExpLD, txt_Tiempo_FinalizacionExpLD, txt_Buscar_ExpLD, tbl_ExpLD);
        ExpLD.Insertar_ExpLD();
    }//GEN-LAST:event_jLabel_Insertar_ExpLDMouseClicked

    private void jLabel_Modificar_ExpLDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Modificar_ExpLDMouseClicked
        // TODO add your handling code here:
        Experiencia_Laboral_Detallada ExpLD = new Experiencia_Laboral_Detallada(txt_id_ExpLD, txt_NombreExpLD, txt_Nombre_EmpresaExpLD, txt_Tiempo_InicioExpLD, txt_Tiempo_FinalizacionExpLD, txt_Buscar_ExpLD, tbl_ExpLD);
        ExpLD.Modificar_ExpLD();
    }//GEN-LAST:event_jLabel_Modificar_ExpLDMouseClicked

    private void jLabel_Eliminar_ExpLDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Eliminar_ExpLDMouseClicked
        // TODO add your handling code here:
        Experiencia_Laboral_Detallada ExpLD = new Experiencia_Laboral_Detallada(txt_id_ExpLD, txt_NombreExpLD, txt_Nombre_EmpresaExpLD, txt_Tiempo_InicioExpLD, txt_Tiempo_FinalizacionExpLD, txt_Buscar_ExpLD, tbl_ExpLD);
        ExpLD.Eliminar_ExpLD();
    }//GEN-LAST:event_jLabel_Eliminar_ExpLDMouseClicked

    private void txt_Buscar_ExpLDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Buscar_ExpLDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Buscar_ExpLDActionPerformed

    private void txt_Buscar_ExpLDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Buscar_ExpLDKeyReleased
        // TODO add your handling code here:
        Experiencia_Laboral_Detallada ExpLD = new Experiencia_Laboral_Detallada(txt_id_ExpLD, txt_NombreExpLD, txt_Nombre_EmpresaExpLD, txt_Tiempo_InicioExpLD, txt_Tiempo_FinalizacionExpLD, txt_Buscar_ExpLD, tbl_ExpLD);
        ExpLD.Buscar_ExpLDF(txt_Buscar_ExpLD.getText());
    }//GEN-LAST:event_txt_Buscar_ExpLDKeyReleased

    private void tbl_ExpLDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ExpLDMouseClicked
        // TODO add your handling code here:
        int Seleccion = tbl_ExpLD.rowAtPoint(evt.getPoint());
        txt_id_ExpLD.setText(String.valueOf(tbl_ExpLD.getValueAt(Seleccion, 0)));
        txt_NombreExpLD.setText(String.valueOf(tbl_ExpLD.getValueAt(Seleccion, 1)));
        txt_Nombre_EmpresaExpLD.setText(String.valueOf(tbl_ExpLD.getValueAt(Seleccion, 2)));
        txt_Tiempo_InicioExpLD.setText(String.valueOf(tbl_ExpLD.getValueAt(Seleccion, 3)));
        txt_Tiempo_FinalizacionExpLD.setText(String.valueOf(tbl_ExpLD.getValueAt(Seleccion, 4)));
    }//GEN-LAST:event_tbl_ExpLDMouseClicked

    private void Texto_IngresarExpLDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarExpLDMouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_ExpLD.setVisible(false);
        jLabel_Modificar_ExpLD.setVisible(false);
        jLabel_Insertar_ExpLD.setVisible(true);
    }//GEN-LAST:event_Texto_IngresarExpLDMouseClicked

    private void Panel_IngresarExpLDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarExpLDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarExpLDMouseClicked

    private void Texto_ModificarExpLDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificarExpLDMouseClicked
        // TODO add your handling code here:
        jLabel_Modificar_ExpLD.setVisible(true);
        jLabel_Insertar_ExpLD.setVisible(false);
        jLabel_Eliminar_ExpLD.setVisible(false);
    }//GEN-LAST:event_Texto_ModificarExpLDMouseClicked

    private void Panel_ModificarExpLDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarExpLDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarExpLDMouseClicked

    private void Texto_EliminarExpLDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarExpLDMouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_ExpLD.setVisible(true);
        jLabel_Modificar_ExpLD.setVisible(false);
        jLabel_Insertar_ExpLD.setVisible(false);
    }//GEN-LAST:event_Texto_EliminarExpLDMouseClicked

    private void Texto_ConsultarExpLDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarExpLDMouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_ExpLD.setVisible(false);
        jLabel_Modificar_ExpLD.setVisible(false);
        jLabel_Insertar_ExpLD.setVisible(false);
    }//GEN-LAST:event_Texto_ConsultarExpLDMouseClicked

    private void tbl_NivelAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NivelAMouseClicked
        // TODO add your handling code here:
        int Seleccion = tbl_NivelA.rowAtPoint(evt.getPoint());
        txt_id_NivelA.setText(String.valueOf(tbl_NivelA.getValueAt(Seleccion, 0)));
        txt_Nombre_NivelA.setText(String.valueOf(tbl_NivelA.getValueAt(Seleccion, 1)));
        txt_Descripcion_NivelA.setText(String.valueOf(tbl_NivelA.getValueAt(Seleccion, 2)));
    }//GEN-LAST:event_tbl_NivelAMouseClicked

    private void txt_id_NivelAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_NivelAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_NivelAActionPerformed

    private void txt_Nombre_NivelAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Nombre_NivelAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Nombre_NivelAActionPerformed

    private void txt_Descripcion_NivelAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Descripcion_NivelAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Descripcion_NivelAActionPerformed

    private void jLabel_Insertar_NivelAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Insertar_NivelAMouseClicked
        // TODO add your handling code here:
        Nivel_Academico NA = new Nivel_Academico(txt_id_NivelA, txt_Nombre_NivelA, txt_Descripcion_NivelA, txt_Buscar_NivelA, tbl_NivelA);
        NA.Insertar_NivelA();
    }//GEN-LAST:event_jLabel_Insertar_NivelAMouseClicked

    private void jLabel_Eliminar_NivelAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Eliminar_NivelAMouseClicked
        // TODO add your handling code here:
        Nivel_Academico NA = new Nivel_Academico(txt_id_NivelA, txt_Nombre_NivelA, txt_Descripcion_NivelA, txt_Buscar_NivelA, tbl_NivelA);
        NA.Eliminar_NivelA();
    }//GEN-LAST:event_jLabel_Eliminar_NivelAMouseClicked

    private void jLabel_Modificar_NivelAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Modificar_NivelAMouseClicked
        // TODO add your handling code here:
        Nivel_Academico NA = new Nivel_Academico(txt_id_NivelA, txt_Nombre_NivelA, txt_Descripcion_NivelA, txt_Buscar_NivelA, tbl_NivelA);
        NA.Modificar_NivelA();
    }//GEN-LAST:event_jLabel_Modificar_NivelAMouseClicked

    private void txt_Buscar_NivelAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Buscar_NivelAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Buscar_NivelAActionPerformed

    private void txt_Buscar_NivelAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Buscar_NivelAKeyReleased
        // TODO add your handling code here:
        Nivel_Academico NA = new Nivel_Academico(txt_id_NivelA, txt_Nombre_NivelA, txt_Descripcion_NivelA, txt_Buscar_NivelA, tbl_NivelA);
        NA.Buscar_NivelAF(txt_Buscar_NivelA.getText());
    }//GEN-LAST:event_txt_Buscar_NivelAKeyReleased

    private void Texto_Ingresar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Ingresar1MouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_NivelA.setVisible(false);
        jLabel_Modificar_NivelA.setVisible(false);
        jLabel_Insertar_NivelA.setVisible(true);
    }//GEN-LAST:event_Texto_Ingresar1MouseClicked

    private void Panel_Ingresar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Ingresar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Ingresar1MouseClicked

    private void Texto_Modificar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Modificar1MouseClicked
        // TODO add your handling code here:
        jLabel_Modificar_NivelA.setVisible(true);
        jLabel_Insertar_NivelA.setVisible(false);
        jLabel_Eliminar_NivelA.setVisible(false);
    }//GEN-LAST:event_Texto_Modificar1MouseClicked

    private void Panel_Modificar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Modificar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Modificar1MouseClicked

    private void Texto_Eliminar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Eliminar1MouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_NivelA.setVisible(true);
        jLabel_Modificar_NivelA.setVisible(false);
        jLabel_Insertar_NivelA.setVisible(false);
    }//GEN-LAST:event_Texto_Eliminar1MouseClicked

    private void Texto_Consultar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Consultar1MouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_NivelA.setVisible(false);
        jLabel_Modificar_NivelA.setVisible(false);
        jLabel_Insertar_NivelA.setVisible(false);
    }//GEN-LAST:event_Texto_Consultar1MouseClicked

    private void Texto_ConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarMouseClicked
        // TODO add your handling code here:
        jLabel_EliminarD.setVisible(false);
        jLabel_ModificarD.setVisible(false);
        jLabel_Ingresar.setVisible(false);
    }//GEN-LAST:event_Texto_ConsultarMouseClicked

    private void Texto_EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarMouseClicked
        // TODO add your handling code here:
        jLabel_EliminarD.setVisible(true);
        jLabel_ModificarD.setVisible(false);
        jLabel_Ingresar.setVisible(false);
    }//GEN-LAST:event_Texto_EliminarMouseClicked

    private void Texto_ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificarMouseClicked
        // TODO add your handling code here:
        jLabel_ModificarD.setVisible(true);
        jLabel_Ingresar.setVisible(false);
        jLabel_EliminarD.setVisible(false);
    }//GEN-LAST:event_Texto_ModificarMouseClicked

    private void Panel_ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarMouseClicked

    private void Texto_IngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarMouseClicked
        // TODO add your handling code here:
        jLabel_EliminarD.setVisible(false);
        jLabel_ModificarD.setVisible(false);
        jLabel_Ingresar.setVisible(true);
    }//GEN-LAST:event_Texto_IngresarMouseClicked

    private void Panel_IngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarMouseClicked

    private void txt_id_DepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_DepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_DepartamentoActionPerformed

    private void txt_Nombre_DepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Nombre_DepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Nombre_DepartamentoActionPerformed

    private void txt_Estatus_DepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Estatus_DepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Estatus_DepartamentoActionPerformed

    private void txt_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarActionPerformed

    private void txt_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarKeyReleased
        // TODO add your handling code here:
        Departamento De = new Departamento(txt_id_Departamento.toString(), txt_Nombre_Departamento.toString(), txt_Estatus_Departamento.toString());
        De.Buscar_Departamento(txt_Buscar.getText(), tbl_Departamento);
    }//GEN-LAST:event_txt_BuscarKeyReleased

    private void tbl_DepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DepartamentoMouseClicked
        // TODO add your handling code here:
        int Seleccion = tbl_Departamento.rowAtPoint(evt.getPoint());
        txt_id_Departamento.setText(String.valueOf(tbl_Departamento.getValueAt(Seleccion, 0)));
        txt_Nombre_Departamento.setText(String.valueOf(tbl_Departamento.getValueAt(Seleccion, 1)));
        txt_Estatus_Departamento.setText(String.valueOf(tbl_Departamento.getValueAt(Seleccion, 2)));
    }//GEN-LAST:event_tbl_DepartamentoMouseClicked

    private void jLabel_EliminarDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EliminarDMouseClicked
        // TODO add your handling code here:
        Departamento De = new Departamento(txt_id_Departamento.toString(), txt_Nombre_Departamento.toString(), txt_Estatus_Departamento.toString());
        De.Eliminar_Departamento(txt_id_Departamento, txt_Nombre_Departamento, txt_Estatus_Departamento, tbl_Departamento, txt_Buscar);
    }//GEN-LAST:event_jLabel_EliminarDMouseClicked

    private void jLabel_ModificarDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ModificarDMouseClicked
        // TODO add your handling code here:
        Departamento De = new Departamento(txt_id_Departamento.toString(), txt_Nombre_Departamento.toString(), txt_Estatus_Departamento.toString());
        De.Modificar_Departamento(txt_id_Departamento, txt_Nombre_Departamento, txt_Estatus_Departamento, tbl_Departamento, txt_Buscar);
    }//GEN-LAST:event_jLabel_ModificarDMouseClicked

    private void jLabel_IngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_IngresarMouseClicked
        // TODO add your handling code here:
        Departamento De = new Departamento(txt_id_Departamento.toString(), txt_Nombre_Departamento.toString(), txt_Estatus_Departamento.toString());
        De.Insertar_Departamento(txt_id_Departamento, txt_Nombre_Departamento, txt_Estatus_Departamento, tbl_Departamento);
    }//GEN-LAST:event_jLabel_IngresarMouseClicked

    private void txt_id_PuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_PuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_PuestoActionPerformed

    private void txt_Nombre_PuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Nombre_PuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Nombre_PuestoActionPerformed

    private void txt_Estatus_PuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Estatus_PuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Estatus_PuestoActionPerformed

    private void tbl_PuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_PuestoMouseClicked
        // TODO add your handling code here:
        int Seleccion = tbl_Puesto.rowAtPoint(evt.getPoint());
        txt_id_Puesto.setText(String.valueOf(tbl_Puesto.getValueAt(Seleccion, 0)));
        txt_Nombre_Puesto.setText(String.valueOf(tbl_Puesto.getValueAt(Seleccion, 1)));
        txt_Descripcion_Puesto.setText(String.valueOf(tbl_Puesto.getValueAt(Seleccion, 2)));
        txt_Estatus_Puesto.setText(String.valueOf(tbl_Puesto.getValueAt(Seleccion, 3)));
    }//GEN-LAST:event_tbl_PuestoMouseClicked

    private void txt_Buscar_PuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Buscar_PuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Buscar_PuestoActionPerformed

    private void txt_Buscar_PuestoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Buscar_PuestoKeyReleased
        // TODO add your handling code here:
        Puesto puesto = new Puesto(txt_id_Puesto, txt_Nombre_Puesto, txt_Descripcion_Puesto, txt_Estatus_Puesto, txt_Buscar_Puesto, tbl_Puesto);
        puesto.Buscar_PuestoF(txt_Buscar_Puesto.getText());
    }//GEN-LAST:event_txt_Buscar_PuestoKeyReleased

    private void jLabel_Insertar_PuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Insertar_PuestoMouseClicked
        // TODO add your handling code here:
        Puesto puesto = new Puesto(txt_id_Puesto, txt_Nombre_Puesto, txt_Descripcion_Puesto, txt_Estatus_Puesto, txt_Buscar_Puesto, tbl_Puesto);
        puesto.Insertar_Puesto();
    }//GEN-LAST:event_jLabel_Insertar_PuestoMouseClicked

    private void jLabel_Modificar_PuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Modificar_PuestoMouseClicked
        // TODO add your handling code here:
        Puesto puesto = new Puesto(txt_id_Puesto, txt_Nombre_Puesto, txt_Descripcion_Puesto, txt_Estatus_Puesto, txt_Buscar_Puesto, tbl_Puesto);
        puesto.Modificar_Puesto();
    }//GEN-LAST:event_jLabel_Modificar_PuestoMouseClicked

    private void jLabel_Eliminar_PuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Eliminar_PuestoMouseClicked
        // TODO add your handling code here:
        Puesto puesto = new Puesto(txt_id_Puesto, txt_Nombre_Puesto, txt_Descripcion_Puesto, txt_Estatus_Puesto, txt_Buscar_Puesto, tbl_Puesto);
        puesto.Eliminar_Puesto();
    }//GEN-LAST:event_jLabel_Eliminar_PuestoMouseClicked

    private void Texto_IngresarPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarPMouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_Puesto.setVisible(false);
        jLabel_Modificar_Puesto.setVisible(false);
        jLabel_Insertar_Puesto.setVisible(true);
    }//GEN-LAST:event_Texto_IngresarPMouseClicked

    private void Panel_IngresarPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarPMouseClicked

    private void Texto_ModificarPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificarPMouseClicked
        // TODO add your handling code here:
        jLabel_Modificar_Puesto.setVisible(true);
        jLabel_Insertar_Puesto.setVisible(false);
        jLabel_Eliminar_Puesto.setVisible(false);
    }//GEN-LAST:event_Texto_ModificarPMouseClicked

    private void Panel_ModificarPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarPMouseClicked

    private void Texto_EliminarPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarPMouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_Puesto.setVisible(true);
        jLabel_Modificar_Puesto.setVisible(false);
        jLabel_Insertar_Puesto.setVisible(false);
    }//GEN-LAST:event_Texto_EliminarPMouseClicked

    private void Texto_ConsultarPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarPMouseClicked
        // TODO add your handling code here:
        jLabel_Eliminar_Puesto.setVisible(false);
        jLabel_Modificar_Puesto.setVisible(false);
        jLabel_Insertar_Puesto.setVisible(false);
    }//GEN-LAST:event_Texto_ConsultarPMouseClicked

    private void Panel_Icono_ContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Icono_ContaMouseClicked
        // TODO add your handling code here:
        setColor_PanelI(Panel_Icono_Conta);
        resetColor_PanelI(Panel_Icono_RRHH);
        resetColor_PanelI(Panel_Icono_Nomina);
        resetColor_PanelI(Panel_Icono_Bancos);
    }//GEN-LAST:event_Panel_Icono_ContaMouseClicked

    private void Panel_Icono_BancosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Icono_BancosMouseClicked
        // TODO add your handling code here:
        setColor_PanelI(Panel_Icono_Bancos);
        resetColor_PanelI(Panel_Icono_RRHH);
        resetColor_PanelI(Panel_Icono_Nomina);
        resetColor_PanelI(Panel_Icono_Conta);
    }//GEN-LAST:event_Panel_Icono_BancosMouseClicked

    private void Panel_Icono_NominaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Icono_NominaMouseClicked
        // TODO add your handling code here:
        setColor_PanelI(Panel_Icono_Nomina);
        resetColor_PanelI(Panel_Icono_RRHH);
        resetColor_PanelI(Panel_Icono_Conta);
        resetColor_PanelI(Panel_Icono_Bancos);
    }//GEN-LAST:event_Panel_Icono_NominaMouseClicked

    private void Icono_RRHHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Icono_RRHHMouseClicked

        int cantidad_D = 0;
        int cantidad_P = 0;
        int cantidad_NA = 0;
        int cantidad_ExpLD = 0;
        int cantidad_ExpL = 0;
        int cantidad_SE = 0;
        int cantidad_M = 0;
        int cantidad_RP = 0;
        int cantidad_RL = 0;
        int cantidad_C = 0;
        int cantidad_AP = 0;
        int cantidad_TP = 0;
        int cantidad_APP = 0;
        int cantidad_S = 0;
        int cantidad_Actividad = 0;
        int cantidad_periodo_p = 0;
        int cantidad_contratacion = 0;
        int cantidad_empleado=0;
        int cantidad_AE = 0;
        int cantidad_BE = 0;

        jPanel_Bienvenido.setVisible(false);
        ExpLD.setVisible(true);
        Departamento.setVisible(true);
        Puesto.setVisible(true);
        Nivel_Academico.setVisible(true);
        ExpLD1.setVisible(true);
        Departamento1.setVisible(true);
        Puesto1.setVisible(true);
        Nivel_Academico2.setVisible(true);
        SE.setVisible(true);
        RL.setVisible(true);
        ExpL.setVisible(true);
        Medio.setVisible(true);
        Aplicacion.setVisible(true);
        TP.setVisible(true);
        RP.setVisible(true);
        CV.setVisible(true);
        Puesto.setVisible(true);
        Mantenimiento_D.setVisible(false);
        jPanel_MantenimientosP.setVisible(false);
        jPanel_MantenimientoNA.setVisible(false);
        jPanel_MantenimientoExpLD.setVisible(false);
        jPanel_MantenimientoSE.setVisible(false);
        jPanel_Mantenimiento_Medio.setVisible(false);
        jPanel_MantenimientoRL.setVisible(false);
        jPanel_MantenimientosRP.setVisible(false);
        jPanel_MantenimientoCV.setVisible(false);
        jPanel_MantenimientoAP.setVisible(false);
        jPanel_Tipo_Prueba.setVisible(false);
        jPanel_MantenimientoAPP.setVisible(false);
        jPanel_MantenimientoS.setVisible(false);
        jPanel_MantenimientoA.setVisible(false);
        jPanel_MantenimientoPP.setVisible(false);
        jPanel_MantenimientoC.setVisible(false);
        jPanel_MantenimientoEC.setVisible(false);
        jPanel_MantenimientoExpL.setVisible(false);
        jPanel_MantenimientoAE.setVisible(false);
        jPanel_MantenimientoBE.setVisible(false);

        jLabel_Felcha2.setVisible(true);
        jLabel_Flecha_Iz1.setVisible(true);

        setColor_PanelI(Panel_Icono_RRHH);
        resetColor_PanelI(Panel_Icono_Nomina);
        resetColor_PanelI(Panel_Icono_Conta);
        resetColor_PanelI(Panel_Icono_Bancos);

        Departamento De = new Departamento(txt_id_Departamento.toString(), txt_Nombre_Departamento.toString(), txt_Estatus_Departamento.toString());
        cantidad_D += De.Cantidad_Registros();

        Puesto puesto = new Puesto(txt_id_Puesto, txt_Nombre_Puesto, txt_Descripcion_Puesto, txt_Estatus_Puesto, txt_Buscar_Puesto, tbl_Puesto);
        cantidad_P += puesto.Cantidad_Registros();

        Nivel_Academico NA = new Nivel_Academico(txt_id_NivelA, txt_Nombre_NivelA, txt_Descripcion_NivelA, txt_Buscar_NivelA, tbl_NivelA);
        cantidad_NA += NA.Cantidad_Registros();

        Experiencia_Laboral_Detallada ExpLD = new Experiencia_Laboral_Detallada(txt_id_ExpLD, txt_NombreExpLD, txt_Nombre_EmpresaExpLD, txt_Tiempo_InicioExpLD, txt_Tiempo_FinalizacionExpLD, txt_Buscar_ExpLD, tbl_ExpLD);
        cantidad_ExpLD += ExpLD.Cantidad_Registros();

        Experiencia_Laboral ExpL = new Experiencia_Laboral(txt_id_ExpL, jLabel_id_Nombre_EpLLD, txt_Buscar_ExpL, tbl_ExpL);
        cantidad_ExpL += ExpL.Cantidad_Registros();

        Solicitud_Empresarial SE = new Solicitud_Empresarial(txt_id_SolicitudE, txt_RangoEdadM, txt_RangoEdadMa, txt_Genero, jLabel_Puesto_SE, jLabel_Departamento_SE, jLabel_NivelA_SE, jLabel_ExperienciaL_SE, jTextArea_DescripcionSE, txt_Buscar_SE, tbl_SE);
        cantidad_SE += SE.Cantidad_Registros();

        Medio M = new Medio(txt_id_Medio, jLabel_ID_SEM, txt_NombreM, jTextArea_DescripcionM, txt_BuscarM, tbl_Medio);
        cantidad_M += M.Cantidad_Registros();

        Referencias_Laborales referencias_laborales = new Referencias_Laborales(txt_id_ReferenciaL, txt_NombreRL, txt_TelefonoRL, txt_BuscarRL, tbl_RL);
        cantidad_RL += referencias_laborales.Cantidad_Registros();

        Referencias_Personales RP = new Referencias_Personales(txt_id_RP, txt_Nombre_RP, txt_Telefono_RP, txt_Buscar_RP, tbl_RP);
        cantidad_RP += RP.Cantidad_Registros();

        Curriculum CV = new Curriculum(txt_DPICV, txt_NombreCV, txt_ApellidoCV, txt_TelefonoCV, txt_CorreoCV, txt_DireccionCV, txt_GeneroCV, txt_EdadCV, jLabel_NivelA_CV, jLabel_RP_CV, jLabel_RL_CV, jLabel_EL_CV, jLabel_Medio_CV, txt_Buscar_CV, tbl_CV);
        cantidad_C += CV.Cantidad_Registros();

        Aplicacion ap = new Aplicacion(txt_id_AP, jLabel_DPI_AP, txt_RequisitosAP, txt_BuscarAP, tbl_AP);
        cantidad_AP += ap.Cantidad_Registros();

        Tipo_Prueba TP = new Tipo_Prueba(txt_id_TP, txt_TP, tbl_TP, txt_BuscarTP);
        cantidad_TP += TP.Cantidad_Registros();

        Aplicacion_Prueba APP = new Aplicacion_Prueba(txt_id_APP, jLabel_Prueba_APP, jLabel_Aplicacion_APP, txt_AplicacionAPP, txt_Buscar_APP, tbl_APP);
        cantidad_APP += APP.Cantidad_Registros();

        Seleccion S = new Seleccion(txt_idS, jLabel_RL_APPS, txt_EstatusS, txt_BuscarS, tbl_S);
        cantidad_S += S.Cantidad_Registros();

        Actividad AC = new Actividad(txt_id_A, txt_TA, jTextArea_DescripcionA, txt_BuscarA, tbl_A);
        cantidad_Actividad += AC.Cantidad_Registros();

        Periodo_Prueba p = new Periodo_Prueba(txt_id_PP, jLabel_PPSE, txt_id_FI, txt_id_FF, txt_id_Pago, jLabel_PPAA, txt_BuscarPP, tbl_PP);
        cantidad_periodo_p += p.Cantidad_Registros();

        Contratacion C = new Contratacion(txt_id_C, jLabel_PPCC, txt_FC, txt_DC, txt_EC, txt_Buscar_C, tbl_C);
        cantidad_contratacion += C.Cantidad_Registros();
        
        Empleado_Contratado empleado = new Empleado_Contratado (txt_id_EC, jLabel_CECC, jLabel_ECPP, jLabel_ECDD, txt_SEC, txt_BuscarEC, tbl_EC);
        cantidad_empleado+= empleado.Cantidad_Registros();
        
        Actividad_Empleado AE = new Actividad_Empleado(jLabel_AE_ECC,jLabel_Actividad_AEE,txt_BuscarAE,tbl_AE);
        cantidad_AE += AE.Cantidad_Registros();
        
        Bitacora_Empleado BE = new Bitacora_Empleado(tbl_BE,jTextField_Encontraid,txt_contra,txt_puesto,txt_depa,txt_peri,txt_selec,txt_ap,txt_idap,txt_dpi,txt_Buscar_BE, tbl_BE);
        cantidad_BE += BE.Cantidad_Registros();
        
        Cant_R2.setText("" + cantidad_D);
        Cant_R3.setText("" + cantidad_P);
        Cant_R4.setText("" + cantidad_NA);
        Cant_R1.setText("" + cantidad_ExpLD);
        Cant_R10.setText("" + cantidad_ExpL);
        Cant_R11.setText("" + cantidad_SE);
        Cant_R12.setText("" + cantidad_M);
        Cant_R9.setText("" + cantidad_RL);
        Cant_R13.setText("" + cantidad_RP);
        Cant_R16.setText("" + cantidad_C);
        Cant_R14.setText("" + cantidad_AP);
        Cant_R15.setText("" + cantidad_TP);
        Cant_R17.setText("" + cantidad_APP);
        Cant_R18.setText("" + cantidad_S);
        Cant_R19.setText("" + cantidad_Actividad);
        Cant_R20.setText("" + cantidad_periodo_p);
        Cant_R21.setText("" + cantidad_contratacion);
        Cant_R22.setText("" + cantidad_empleado);
        Cant_R23.setText("" + cantidad_AE);
        Cant_R24.setText("" + cantidad_BE);
    }//GEN-LAST:event_Icono_RRHHMouseClicked

    private void Panel_Icono_RRHHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Icono_RRHHMouseClicked

        int cantidad_D = 0;
        int cantidad_P = 0;
        int cantidad_NA = 0;
        int cantidad_ExpLD = 0;
        int cantidad_ExpL = 0;
        int cantidad_SE = 0;
        int cantidad_M = 0;
        int cantidad_RP = 0;
        int cantidad_RL = 0;
        int cantidad_C = 0;
        int cantidad_AP = 0;
        int cantidad_TP = 0;
        int cantidad_APP = 0;
        int cantidad_S = 0;
        int cantidad_Actividad = 0;
        int cantidad_periodo_p = 0;
        int cantidad_contratacion = 0;
        int cantidad_empleado=0;
        int cantidad_AE = 0;

        jPanel_Bienvenido.setVisible(false);
        ExpLD.setVisible(true);
        Departamento.setVisible(true);
        Puesto.setVisible(true);
        Nivel_Academico.setVisible(true);
        ExpLD1.setVisible(true);
        Departamento1.setVisible(true);
        Puesto1.setVisible(true);
        Nivel_Academico2.setVisible(true);
        SE.setVisible(true);
        RL.setVisible(true);
        ExpL.setVisible(true);
        Medio.setVisible(true);
        Aplicacion.setVisible(true);
        TP.setVisible(true);
        RP.setVisible(true);
        CV.setVisible(true);
        Puesto.setVisible(true);
        Mantenimiento_D.setVisible(false);
        jPanel_MantenimientosP.setVisible(false);
        jPanel_MantenimientoNA.setVisible(false);
        jPanel_MantenimientoExpLD.setVisible(false);
        jPanel_MantenimientoSE.setVisible(false);
        jPanel_Mantenimiento_Medio.setVisible(false);
        jPanel_MantenimientoRL.setVisible(false);
        jPanel_MantenimientosRP.setVisible(false);
        jPanel_MantenimientoCV.setVisible(false);
        jPanel_MantenimientoAP.setVisible(false);
        jPanel_Tipo_Prueba.setVisible(false);
        jPanel_MantenimientoAPP.setVisible(false);
        jPanel_MantenimientoS.setVisible(false);
        jPanel_MantenimientoA.setVisible(false);
        jPanel_MantenimientoPP.setVisible(false);
        jPanel_MantenimientoC.setVisible(false);
        jPanel_MantenimientoEC.setVisible(false);
        jPanel_MantenimientoExpL.setVisible(false);
        jPanel_MantenimientoAE.setVisible(false);

        jLabel_Felcha2.setVisible(true);
        jLabel_Flecha_Iz1.setVisible(true);

        setColor_PanelI(Panel_Icono_RRHH);
        resetColor_PanelI(Panel_Icono_Nomina);
        resetColor_PanelI(Panel_Icono_Conta);
        resetColor_PanelI(Panel_Icono_Bancos);

        Departamento De = new Departamento(txt_id_Departamento.toString(), txt_Nombre_Departamento.toString(), txt_Estatus_Departamento.toString());
        cantidad_D += De.Cantidad_Registros();

        Puesto puesto = new Puesto(txt_id_Puesto, txt_Nombre_Puesto, txt_Descripcion_Puesto, txt_Estatus_Puesto, txt_Buscar_Puesto, tbl_Puesto);
        cantidad_P += puesto.Cantidad_Registros();

        Nivel_Academico NA = new Nivel_Academico(txt_id_NivelA, txt_Nombre_NivelA, txt_Descripcion_NivelA, txt_Buscar_NivelA, tbl_NivelA);
        cantidad_NA += NA.Cantidad_Registros();

        Experiencia_Laboral_Detallada ExpLD = new Experiencia_Laboral_Detallada(txt_id_ExpLD, txt_NombreExpLD, txt_Nombre_EmpresaExpLD, txt_Tiempo_InicioExpLD, txt_Tiempo_FinalizacionExpLD, txt_Buscar_ExpLD, tbl_ExpLD);
        cantidad_ExpLD += ExpLD.Cantidad_Registros();

        Experiencia_Laboral ExpL = new Experiencia_Laboral(txt_id_ExpL, jLabel_id_Nombre_EpLLD, txt_Buscar_ExpL, tbl_ExpL);
        cantidad_ExpL += ExpL.Cantidad_Registros();

        Solicitud_Empresarial SE = new Solicitud_Empresarial(txt_id_SolicitudE, txt_RangoEdadM, txt_RangoEdadMa, txt_Genero, jLabel_Puesto_SE, jLabel_Departamento_SE, jLabel_NivelA_SE, jLabel_ExperienciaL_SE, jTextArea_DescripcionSE, txt_Buscar_SE, tbl_SE);
        cantidad_SE += SE.Cantidad_Registros();

        Medio M = new Medio(txt_id_Medio, jLabel_ID_SEM, txt_NombreM, jTextArea_DescripcionM, txt_BuscarM, tbl_Medio);
        cantidad_M += M.Cantidad_Registros();

        Referencias_Laborales referencias_laborales = new Referencias_Laborales(txt_id_ReferenciaL, txt_NombreRL, txt_TelefonoRL, txt_BuscarRL, tbl_RL);
        cantidad_RL += referencias_laborales.Cantidad_Registros();

        Referencias_Personales RP = new Referencias_Personales(txt_id_RP, txt_Nombre_RP, txt_Telefono_RP, txt_Buscar_RP, tbl_RP);
        cantidad_RP += RP.Cantidad_Registros();

        Curriculum CV = new Curriculum(txt_DPICV, txt_NombreCV, txt_ApellidoCV, txt_TelefonoCV, txt_CorreoCV, txt_DireccionCV, txt_GeneroCV, txt_EdadCV, jLabel_NivelA_CV, jLabel_RP_CV, jLabel_RL_CV, jLabel_EL_CV, jLabel_Medio_CV, txt_Buscar_CV, tbl_CV);
        cantidad_C += CV.Cantidad_Registros();

        Aplicacion ap = new Aplicacion(txt_id_AP, jLabel_DPI_AP, txt_RequisitosAP, txt_BuscarAP, tbl_AP);
        cantidad_AP += ap.Cantidad_Registros();

        Tipo_Prueba TP = new Tipo_Prueba(txt_id_TP, txt_TP, tbl_TP, txt_BuscarTP);
        cantidad_TP += TP.Cantidad_Registros();

        Aplicacion_Prueba APP = new Aplicacion_Prueba(txt_id_APP, jLabel_Prueba_APP, jLabel_Aplicacion_APP, txt_AplicacionAPP, txt_Buscar_APP, tbl_APP);
        cantidad_APP += APP.Cantidad_Registros();

        Seleccion S = new Seleccion(txt_idS, jLabel_RL_APPS, txt_EstatusS, txt_BuscarS, tbl_S);
        cantidad_S += S.Cantidad_Registros();

        Actividad AC = new Actividad(txt_id_A, txt_TA, jTextArea_DescripcionA, txt_BuscarA, tbl_A);
        cantidad_Actividad += AC.Cantidad_Registros();

        Periodo_Prueba p = new Periodo_Prueba(txt_id_PP, jLabel_PPSE, txt_id_FI, txt_id_FF, txt_id_Pago, jLabel_PPAA, txt_BuscarPP, tbl_PP);
        cantidad_periodo_p += p.Cantidad_Registros();

        Contratacion C = new Contratacion(txt_id_C, jLabel_PPCC, txt_FC, txt_DC, txt_EC, txt_Buscar_C, tbl_C);
        cantidad_contratacion += C.Cantidad_Registros();
        
        Empleado_Contratado empleado = new Empleado_Contratado (txt_id_EC, jLabel_CECC, jLabel_ECPP, jLabel_ECDD, txt_SEC, txt_BuscarEC, tbl_EC);
        cantidad_empleado+= empleado.Cantidad_Registros();
        
        Actividad_Empleado AE = new Actividad_Empleado(jLabel_AE_ECC,jLabel_Actividad_AEE,txt_BuscarAE,tbl_AE);
        cantidad_AE += AE.Cantidad_Registros();
        
        Cant_R2.setText("" + cantidad_D);
        Cant_R3.setText("" + cantidad_P);
        Cant_R4.setText("" + cantidad_NA);
        Cant_R1.setText("" + cantidad_ExpLD);
        Cant_R10.setText("" + cantidad_ExpL);
        Cant_R11.setText("" + cantidad_SE);
        Cant_R12.setText("" + cantidad_M);
        Cant_R9.setText("" + cantidad_RL);
        Cant_R13.setText("" + cantidad_RP);
        Cant_R16.setText("" + cantidad_C);
        Cant_R14.setText("" + cantidad_AP);
        Cant_R15.setText("" + cantidad_TP);
        Cant_R17.setText("" + cantidad_APP);
        Cant_R18.setText("" + cantidad_S);
        Cant_R19.setText("" + cantidad_Actividad);
        Cant_R20.setText("" + cantidad_periodo_p);
        Cant_R21.setText("" + cantidad_contratacion);
        Cant_R22.setText("" + cantidad_empleado);
        Cant_R23.setText("" + cantidad_AE);
    }//GEN-LAST:event_Panel_Icono_RRHHMouseClicked

    private void jLabel_LogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_LogoMouseClicked
        // TODO add your handling code here:
        int posX = 0;
        AnimationClass ani = new AnimationClass();

        posX += Texto_RRHH.getX();

        if (posX == -210) {
            ani.jLabelXRight(Texto_RRHH.getX(), 50, 2, 1, Texto_RRHH);
            ani.jLabelXRight(Texto_Nomina.getX(), 45, 2, 1, Texto_Nomina);
            ani.jLabelXRight(Texto_Conta.getX(), 31, 2, 1, Texto_Conta);
            ani.jLabelXRight(Texto_Bancos.getX(), 50, 2, 1, Texto_Bancos);
            /*resetColor_PanelI(Slide_Derecho1);
            resetColor_PanelI(Panel_Text_RRHH);
            resetColor_PanelI(Panel_Text_Nomina);*/
        }

        posX = 0;

        int posX2 = 0;
        AnimationClass ani_I = new AnimationClass();

        posX2 += Texto_RRHH.getX();

        if (posX2 == 50) {
            ani_I.jLabelXLeft(Texto_RRHH.getX(), -210, 2, 1, Texto_RRHH);
            ani_I.jLabelXLeft(Texto_Nomina.getX(), -210, 2, 1, Texto_Nomina);
            ani_I.jLabelXLeft(Texto_Conta.getX(), -210, 2, 1, Texto_Conta);
            ani_I.jLabelXLeft(Texto_Bancos.getX(), -210, 2, 1, Texto_Bancos);
            /*resetColor_PanelD(Slide_Derecho1);
            resetColor_PanelD(Panel_Text_RRHH);
            resetColor_PanelD(Panel_Text_Nomina);*/
        }
    }//GEN-LAST:event_jLabel_LogoMouseClicked

    private void Texto_RRHHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_RRHHMouseClicked

        int cantidad_D = 0;
        int cantidad_P = 0;
        int cantidad_NA = 0;
        int cantidad_ExpLD = 0;
        int cantidad_ExpL = 0;
        int cantidad_SE = 0;
        int cantidad_M = 0;
        int cantidad_RP = 0;
        int cantidad_RL = 0;
        int cantidad_C = 0;
        int cantidad_AP = 0;
        int cantidad_TP = 0;
        int cantidad_APP = 0;
        int cantidad_S = 0;
        int cantidad_Actividad = 0;
        int cantidad_periodo_p = 0;
        int cantidad_contratacion = 0;
        int cantidad_empleado=0;
        int cantidad_AE = 0;
        int cantidad_BE = 0;

        jPanel_Bienvenido.setVisible(false);
        ExpLD.setVisible(true);
        Departamento.setVisible(true);
        Puesto.setVisible(true);
        Nivel_Academico.setVisible(true);
        ExpLD1.setVisible(true);
        Departamento1.setVisible(true);
        Puesto1.setVisible(true);
        Nivel_Academico2.setVisible(true);
        SE.setVisible(true);
        RL.setVisible(true);
        ExpL.setVisible(true);
        Medio.setVisible(true);
        Aplicacion.setVisible(true);
        TP.setVisible(true);
        RP.setVisible(true);
        CV.setVisible(true);
        Puesto.setVisible(true);
        Mantenimiento_D.setVisible(false);
        jPanel_MantenimientosP.setVisible(false);
        jPanel_MantenimientoNA.setVisible(false);
        jPanel_MantenimientoExpLD.setVisible(false);
        jPanel_MantenimientoSE.setVisible(false);
        jPanel_Mantenimiento_Medio.setVisible(false);
        jPanel_MantenimientoRL.setVisible(false);
        jPanel_MantenimientosRP.setVisible(false);
        jPanel_MantenimientoCV.setVisible(false);
        jPanel_MantenimientoAP.setVisible(false);
        jPanel_Tipo_Prueba.setVisible(false);
        jPanel_MantenimientoAPP.setVisible(false);
        jPanel_MantenimientoS.setVisible(false);
        jPanel_MantenimientoA.setVisible(false);
        jPanel_MantenimientoPP.setVisible(false);
        jPanel_MantenimientoC.setVisible(false);
        jPanel_MantenimientoEC.setVisible(false);
        jPanel_MantenimientoExpL.setVisible(false);
        jPanel_MantenimientoAE.setVisible(false);

        jLabel_Felcha2.setVisible(true);
        jLabel_Flecha_Iz1.setVisible(true);

        setColor_PanelI(Panel_Icono_RRHH);
        resetColor_PanelI(Panel_Icono_Nomina);
        resetColor_PanelI(Panel_Icono_Conta);
        resetColor_PanelI(Panel_Icono_Bancos);

        Departamento De = new Departamento(txt_id_Departamento.toString(), txt_Nombre_Departamento.toString(), txt_Estatus_Departamento.toString());
        cantidad_D += De.Cantidad_Registros();

        Puesto puesto = new Puesto(txt_id_Puesto, txt_Nombre_Puesto, txt_Descripcion_Puesto, txt_Estatus_Puesto, txt_Buscar_Puesto, tbl_Puesto);
        cantidad_P += puesto.Cantidad_Registros();

        Nivel_Academico NA = new Nivel_Academico(txt_id_NivelA, txt_Nombre_NivelA, txt_Descripcion_NivelA, txt_Buscar_NivelA, tbl_NivelA);
        cantidad_NA += NA.Cantidad_Registros();

        Experiencia_Laboral_Detallada ExpLD = new Experiencia_Laboral_Detallada(txt_id_ExpLD, txt_NombreExpLD, txt_Nombre_EmpresaExpLD, txt_Tiempo_InicioExpLD, txt_Tiempo_FinalizacionExpLD, txt_Buscar_ExpLD, tbl_ExpLD);
        cantidad_ExpLD += ExpLD.Cantidad_Registros();

        Experiencia_Laboral ExpL = new Experiencia_Laboral(txt_id_ExpL, jLabel_id_Nombre_EpLLD, txt_Buscar_ExpL, tbl_ExpL);
        cantidad_ExpL += ExpL.Cantidad_Registros();

        Solicitud_Empresarial SE = new Solicitud_Empresarial(txt_id_SolicitudE, txt_RangoEdadM, txt_RangoEdadMa, txt_Genero, jLabel_Puesto_SE, jLabel_Departamento_SE, jLabel_NivelA_SE, jLabel_ExperienciaL_SE, jTextArea_DescripcionSE, txt_Buscar_SE, tbl_SE);
        cantidad_SE += SE.Cantidad_Registros();

        Medio M = new Medio(txt_id_Medio, jLabel_ID_SEM, txt_NombreM, jTextArea_DescripcionM, txt_BuscarM, tbl_Medio);
        cantidad_M += M.Cantidad_Registros();

        Referencias_Laborales referencias_laborales = new Referencias_Laborales(txt_id_ReferenciaL, txt_NombreRL, txt_TelefonoRL, txt_BuscarRL, tbl_RL);
        cantidad_RL += referencias_laborales.Cantidad_Registros();

        Referencias_Personales RP = new Referencias_Personales(txt_id_RP, txt_Nombre_RP, txt_Telefono_RP, txt_Buscar_RP, tbl_RP);
        cantidad_RP += RP.Cantidad_Registros();

        Curriculum CV = new Curriculum(txt_DPICV, txt_NombreCV, txt_ApellidoCV, txt_TelefonoCV, txt_CorreoCV, txt_DireccionCV, txt_GeneroCV, txt_EdadCV, jLabel_NivelA_CV, jLabel_RP_CV, jLabel_RL_CV, jLabel_EL_CV, jLabel_Medio_CV, txt_Buscar_CV, tbl_CV);
        cantidad_C += CV.Cantidad_Registros();

        Aplicacion ap = new Aplicacion(txt_id_AP, jLabel_DPI_AP, txt_RequisitosAP, txt_BuscarAP, tbl_AP);
        cantidad_AP += ap.Cantidad_Registros();

        Tipo_Prueba TP = new Tipo_Prueba(txt_id_TP, txt_TP, tbl_TP, txt_BuscarTP);
        cantidad_TP += TP.Cantidad_Registros();

        Aplicacion_Prueba APP = new Aplicacion_Prueba(txt_id_APP, jLabel_Prueba_APP, jLabel_Aplicacion_APP, txt_AplicacionAPP, txt_Buscar_APP, tbl_APP);
        cantidad_APP += APP.Cantidad_Registros();

        Seleccion S = new Seleccion(txt_idS, jLabel_RL_APPS, txt_EstatusS, txt_BuscarS, tbl_S);
        cantidad_S += S.Cantidad_Registros();

        Actividad AC = new Actividad(txt_id_A, txt_TA, jTextArea_DescripcionA, txt_BuscarA, tbl_A);
        cantidad_Actividad += AC.Cantidad_Registros();

        Periodo_Prueba p = new Periodo_Prueba(txt_id_PP, jLabel_PPSE, txt_id_FI, txt_id_FF, txt_id_Pago, jLabel_PPAA, txt_BuscarPP, tbl_PP);
        cantidad_periodo_p += p.Cantidad_Registros();

        Contratacion C = new Contratacion(txt_id_C, jLabel_PPCC, txt_FC, txt_DC, txt_EC, txt_Buscar_C, tbl_C);
        cantidad_contratacion += C.Cantidad_Registros();
        
        Empleado_Contratado empleado = new Empleado_Contratado (txt_id_EC, jLabel_CECC, jLabel_ECPP, jLabel_ECDD, txt_SEC, txt_BuscarEC, tbl_EC);
        cantidad_empleado+= empleado.Cantidad_Registros();
        
        Actividad_Empleado AE = new Actividad_Empleado(jLabel_AE_ECC,jLabel_Actividad_AEE,txt_BuscarAE,tbl_AE);
        cantidad_AE += AE.Cantidad_Registros();
        
         Bitacora_Empleado BE = new Bitacora_Empleado(tbl_BE,jTextField_Encontraid,txt_contra,txt_puesto,txt_depa,txt_peri,txt_selec,txt_ap,txt_idap,txt_dpi,txt_Buscar_BE, tbl_BE);
        cantidad_BE += BE.Cantidad_Registros();
        
        Cant_R2.setText("" + cantidad_D);
        Cant_R3.setText("" + cantidad_P);
        Cant_R4.setText("" + cantidad_NA);
        Cant_R1.setText("" + cantidad_ExpLD);
        Cant_R10.setText("" + cantidad_ExpL);
        Cant_R11.setText("" + cantidad_SE);
        Cant_R12.setText("" + cantidad_M);
        Cant_R9.setText("" + cantidad_RL);
        Cant_R13.setText("" + cantidad_RP);
        Cant_R16.setText("" + cantidad_C);
        Cant_R14.setText("" + cantidad_AP);
        Cant_R15.setText("" + cantidad_TP);
        Cant_R17.setText("" + cantidad_APP);
        Cant_R18.setText("" + cantidad_S);
        Cant_R19.setText("" + cantidad_Actividad);
        Cant_R20.setText("" + cantidad_periodo_p);
        Cant_R21.setText("" + cantidad_contratacion);
        Cant_R22.setText("" + cantidad_empleado);
        Cant_R23.setText("" + cantidad_AE);
        Cant_R24.setText("" + cantidad_BE);

        setColor_PanelI(Panel_Icono_RRHH);
        resetColor_PanelI(Panel_Icono_Nomina);
        resetColor_PanelI(Panel_Icono_Conta);
        resetColor_PanelI(Panel_Icono_Bancos);
    }//GEN-LAST:event_Texto_RRHHMouseClicked

    private void Panel_Text_RRHHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Text_RRHHMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Text_RRHHMouseClicked

    private void Texto_NominaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_NominaMouseClicked
        // TODO add your handling code here:
        setColor_PanelI(Panel_Icono_Nomina);
        resetColor_PanelI(Panel_Icono_RRHH);
        resetColor_PanelI(Panel_Icono_Conta);
        resetColor_PanelI(Panel_Icono_Bancos);
    }//GEN-LAST:event_Texto_NominaMouseClicked

    private void Texto_BancosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_BancosMouseClicked
        // TODO add your handling code here:
        setColor_PanelI(Panel_Icono_Bancos);
        resetColor_PanelI(Panel_Icono_RRHH);
        resetColor_PanelI(Panel_Icono_Nomina);
        resetColor_PanelI(Panel_Icono_Conta);
    }//GEN-LAST:event_Texto_BancosMouseClicked

    private void Texto_ContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ContaMouseClicked
        // TODO add your handling code here:
        setColor_PanelI(Panel_Icono_Conta);
        resetColor_PanelI(Panel_Icono_RRHH);
        resetColor_PanelI(Panel_Icono_Nomina);
        resetColor_PanelI(Panel_Icono_Bancos);
    }//GEN-LAST:event_Texto_ContaMouseClicked

    private void SlideMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SlideMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_SlideMouseMoved

    private void icon_ExpLDMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ExpLDMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA3);

        animacion.Bajar();
    }//GEN-LAST:event_icon_ExpLDMouseMoved

    private void icon_ExpLDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ExpLDMouseClicked
        // TODO add your handling code here:
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        jPanel_MantenimientoExpLD.setVisible(true);

        Experiencia_Laboral_Detallada ExpLD = new Experiencia_Laboral_Detallada(txt_id_ExpLD, txt_NombreExpLD, txt_Nombre_EmpresaExpLD, txt_Tiempo_InicioExpLD, txt_Tiempo_FinalizacionExpLD, txt_Buscar_ExpLD, tbl_ExpLD);
        ExpLD.Actualizar_Tabla();
    }//GEN-LAST:event_icon_ExpLDMouseClicked

    private void icon_ExpLDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ExpLDMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA3);

        animacion.Subir();
    }//GEN-LAST:event_icon_ExpLDMouseExited

    private void icon_PPMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_PPMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA15);

        animacion.Bajar();
    }//GEN-LAST:event_icon_PPMouseMoved

    private void icon_PPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_PPMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA15);

        animacion.Subir();
    }//GEN-LAST:event_icon_PPMouseExited

    private void icon_DepartamentoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_DepartamentoMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA1);

        animacion.Bajar();
    }//GEN-LAST:event_icon_DepartamentoMouseMoved

    private void icon_DepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_DepartamentoMouseClicked
        // TODO add your handling code here:
        //jPanel_BG.setVisible(false);
        //Slide.setVisible(false);
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        Mantenimiento_D.setVisible(true);
        Departamento De = new Departamento(txt_id_Departamento.toString(), txt_Nombre_Departamento.toString(), txt_Estatus_Departamento.toString());
        De.Actualizar_Tabla(tbl_Departamento);
    }//GEN-LAST:event_icon_DepartamentoMouseClicked

    private void icon_DepartamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_DepartamentoMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA1);

        animacion.Subir();
    }//GEN-LAST:event_icon_DepartamentoMouseExited

    private void icon_APPMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_APPMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA12);

        animacion.Bajar();
    }//GEN-LAST:event_icon_APPMouseMoved

    private void icon_APPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_APPMouseClicked
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        jPanel_MantenimientoAPP.setVisible(true);

        //Asignado String a Combobox para buscar tabla
        jComboBox_TablasB_APP.addItem(S_Prueba);
        jComboBox_TablasB_APP.addItem(S_Aplicacion);

        Aplicacion_Prueba APP = new Aplicacion_Prueba(txt_id_APP, jLabel_Prueba_APP, jLabel_Aplicacion_APP, txt_AplicacionAPP, txt_Buscar_APP, tbl_APP);
        APP.Encontrar_ListaAPP("tipo_pruebas", "tipo_prueba", jComboBox_PruebaAPP);
        APP.Encontrar_ListaAPP("aplicacion", "dpi_persona", jComboBox_AplicacionAPP);
        APP.Actualizar_Tabla();
    }//GEN-LAST:event_icon_APPMouseClicked

    private void icon_APPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_APPMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA12);

        animacion.Subir();
    }//GEN-LAST:event_icon_APPMouseExited

    private void DepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DepartamentoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DepartamentoMouseClicked

    private void SeleccionadoAMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeleccionadoAMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccionadoAMouseMoved

    private void icon_PuestoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_PuestoMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA);

        animacion.Bajar();
    }//GEN-LAST:event_icon_PuestoMouseMoved

    private void icon_PuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_PuestoMouseClicked
        // TODO add your handling code here:

        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        jPanel_MantenimientosP.setVisible(true);

        Puesto puesto = new Puesto(txt_id_Puesto, txt_Nombre_Puesto, txt_Descripcion_Puesto, txt_Estatus_Puesto, txt_Buscar_Puesto, tbl_Puesto);
        puesto.Actualizar_Tabla();
    }//GEN-LAST:event_icon_PuestoMouseClicked

    private void icon_PuestoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_PuestoMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA);

        animacion.Subir();
    }//GEN-LAST:event_icon_PuestoMouseExited

    private void SeleccionadoA13MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeleccionadoA13MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccionadoA13MouseMoved

    private void icon_SeleccionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_SeleccionMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA13);

        animacion.Bajar();
    }//GEN-LAST:event_icon_SeleccionMouseMoved

    private void icon_SeleccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_SeleccionMouseClicked
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        jPanel_MantenimientoS.setVisible(true);
        jComboBox_TablasB_S.addItem(S_Seleccion);

        Seleccion S = new Seleccion(txt_idS, jLabel_RL_APPS, txt_EstatusS, txt_BuscarS, tbl_S);
        S.Encontrar_ListaSeleccion("aplicacion_prueba", "id_ap", jComboBox_APPS);
        S.Actualizar_Tabla();

        // TODO add your handling code here:
    }//GEN-LAST:event_icon_SeleccionMouseClicked

    private void icon_SeleccionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_SeleccionMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA13);

        animacion.Subir();
    }//GEN-LAST:event_icon_SeleccionMouseExited

    private void PuestoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PuestoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PuestoMouseExited

    private void icon_NivelAMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_NivelAMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA2);

        animacion.Bajar();
    }//GEN-LAST:event_icon_NivelAMouseMoved

    private void icon_NivelAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_NivelAMouseClicked
        // TODO add your handling code here:
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        jPanel_MantenimientoNA.setVisible(true);

        Nivel_Academico NA = new Nivel_Academico(txt_id_NivelA, txt_Nombre_NivelA, txt_Descripcion_NivelA, txt_Buscar_NivelA, tbl_NivelA);
        NA.Actualizar_Tabla();
    }//GEN-LAST:event_icon_NivelAMouseClicked

    private void icon_NivelAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_NivelAMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA2);

        animacion.Subir();
    }//GEN-LAST:event_icon_NivelAMouseExited

    private void icon_NivelAMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_NivelAMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_icon_NivelAMouseReleased

    private void icon_ActividadMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ActividadMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA14);

        animacion.Bajar();
    }//GEN-LAST:event_icon_ActividadMouseMoved

    private void icon_ActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ActividadMouseClicked
        // TODO add your handling code here:
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        jPanel_MantenimientoA.setVisible(true);

        Actividad AC = new Actividad(txt_id_A, txt_TA, jTextArea_DescripcionA, txt_BuscarA, tbl_A);
        AC.Actualizar_Tabla();
    }//GEN-LAST:event_icon_ActividadMouseClicked

    private void icon_ActividadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ActividadMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA14);

        animacion.Subir();
    }//GEN-LAST:event_icon_ActividadMouseExited

    private void icon_ActividadMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ActividadMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_icon_ActividadMouseReleased

    private void icon_Departamento1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_Departamento1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_icon_Departamento1MouseClicked

    private void Departamento1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Departamento1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Departamento1MouseClicked

    private void icon_SEMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_SEMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA5);

        animacion.Bajar();
    }//GEN-LAST:event_icon_SEMouseMoved

    private void icon_SEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_SEMouseClicked

        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        jPanel_MantenimientoSE.setVisible(true);

        //Asignado String a Combobox para buscar tabla Departamento
        jComboBox_TablasB_ExpL.addItem(S_ExpLD);
        //Asignando String a Combobox Solicitud Empresarial
        jComboBox_TablasB_SE.addItem(S_Puesto);
        jComboBox_TablasB_SE.addItem(S_Departamento);
        jComboBox_TablasB_SE.addItem(S_NA);
        jComboBox_TablasB_SE.addItem(S_EL);

        Solicitud_Empresarial SE = new Solicitud_Empresarial(txt_id_SolicitudE, txt_RangoEdadM, txt_RangoEdadMa, txt_Genero, jLabel_Puesto_SE, jLabel_Departamento_SE, jLabel_NivelA_SE, jLabel_ExperienciaL_SE, jTextArea_DescripcionSE, txt_Buscar_SE, tbl_SE);
        SE.Encontrar_ListaSE("puesto", "nombre_puesto", jComboBox_PuestoSE);
        SE.Encontrar_ListaSE("departamento", "nombre_departamento", jComboBox_DepartamentoSE);
        SE.Encontrar_ListaSE("nivel_academico", "nombre_nivel", jComboBox_NivelASE);
        SE.Encontrar_ListaSE("experiencia_laboral", "id_tipoexp", jComboBox_ExperienciaL_SE);

        SE.Actualizar_Tabla();
    }//GEN-LAST:event_icon_SEMouseClicked

    private void icon_SEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_SEMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA5);

        animacion.Subir();
    }//GEN-LAST:event_icon_SEMouseExited

    private void icon_ECMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ECMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA17);

        animacion.Bajar();
    }//GEN-LAST:event_icon_ECMouseMoved

    private void icon_ECMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ECMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA17);

        animacion.Subir();
    }//GEN-LAST:event_icon_ECMouseExited

    private void icon_RLMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_RLMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA7);

        animacion.Bajar();
    }//GEN-LAST:event_icon_RLMouseMoved

    private void icon_RLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_RLMouseClicked
        // TODO add your handling code here:
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        jPanel_MantenimientoRL.setVisible(true);

        Referencias_Laborales referencias_laborales = new Referencias_Laborales(txt_id_ReferenciaL, txt_NombreRL, txt_TelefonoRL, txt_BuscarRL, tbl_RL);
        referencias_laborales.Actualizar_Tabla();
    }//GEN-LAST:event_icon_RLMouseClicked

    private void icon_RLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_RLMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA7);

        animacion.Subir();
    }//GEN-LAST:event_icon_RLMouseExited

    private void icon_BEMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_BEMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA19);

        animacion.Bajar();
    }//GEN-LAST:event_icon_BEMouseMoved

    private void icon_BEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_BEMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA19);

        animacion.Subir();
    }//GEN-LAST:event_icon_BEMouseExited

    private void icon_ExpLMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ExpLMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA4);

        animacion.Bajar();
    }//GEN-LAST:event_icon_ExpLMouseMoved

    private void icon_ExpLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ExpLMouseClicked
        // TODO add your handling code here:
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        jPanel_MantenimientoExpL.setVisible(true);

        //Asignado String a Combobox para buscar tabla
        jComboBox_TablasB_ExpL.addItem(S_PeriodoP);

        Experiencia_Laboral ExpL = new Experiencia_Laboral(txt_id_ExpL, jLabel_id_Nombre_EpLLD, txt_Buscar_ExpL, tbl_ExpL);
        ExpL.Encontrar_ListaExpLD("explab_detallado", "nombre_tipo", jComboBox_Nombre_EpLLD);
        ExpL.Actualizar_Tabla();
    }//GEN-LAST:event_icon_ExpLMouseClicked

    private void icon_ExpLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ExpLMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA4);

        animacion.Subir();
    }//GEN-LAST:event_icon_ExpLMouseExited

    private void icon_ContratacionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ContratacionMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA16);

        animacion.Bajar();
    }//GEN-LAST:event_icon_ContratacionMouseMoved

    private void icon_ContratacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ContratacionMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA16);

        animacion.Subir();
    }//GEN-LAST:event_icon_ContratacionMouseExited

    private void ExpLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ExpLMouseClicked

    private void icon_MedioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_MedioMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA6);

        animacion.Bajar();
    }//GEN-LAST:event_icon_MedioMouseMoved

    private void icon_MedioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_MedioMouseClicked
        // TODO add your handling code here: medio
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        jPanel_Mantenimiento_Medio.setVisible(true);

        //LOVIU
        jComboBox_TablasB_M1.addItem(S_Emp);

        Medio M = new Medio(txt_id_Medio, jLabel_ID_SEM, txt_NombreM, jTextArea_DescripcionM, txt_BuscarM, tbl_Medio);
        M.Encontrar_ListaM("solicitud_empresarial", "id_solicitud", jComboBox_IDSEM);

        M.Actualizar_Tabla();
    }//GEN-LAST:event_icon_MedioMouseClicked

    private void icon_MedioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_MedioMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA6);

        animacion.Subir();
    }//GEN-LAST:event_icon_MedioMouseExited

    private void icon_AEMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_AEMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA18);

        animacion.Bajar();
    }//GEN-LAST:event_icon_AEMouseMoved

    private void icon_AEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_AEMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA18);

        animacion.Subir();
    }//GEN-LAST:event_icon_AEMouseExited

    private void icon_AplicacionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_AplicacionMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA10);

        animacion.Bajar();
    }//GEN-LAST:event_icon_AplicacionMouseMoved

    private void icon_AplicacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_AplicacionMouseClicked

        // TODO add your handling code here:
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        jPanel_MantenimientoAP.setVisible(true);

        Aplicacion ap = new Aplicacion(txt_id_AP, jLabel_DPI_AP, txt_RequisitosAP, txt_BuscarAP, tbl_AP);
        ap.Encontrar_ListaAplicacion("curriculum", "nombres_persona", jComboBox_DPIAP);
        ap.Actualizar_Tabla();

        //agregando cadena a combobox
        jComboBox_TablasAP.addItem(S_DPI);
    }//GEN-LAST:event_icon_AplicacionMouseClicked

    private void icon_AplicacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_AplicacionMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA10);

        animacion.Subir();
    }//GEN-LAST:event_icon_AplicacionMouseExited

    private void icon_TPMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_TPMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA11);

        animacion.Bajar();
    }//GEN-LAST:event_icon_TPMouseMoved

    private void icon_TPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_TPMouseClicked
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        jPanel_Tipo_Prueba.setVisible(true);
        Tipo_Prueba TP = new Tipo_Prueba(txt_id_TP, txt_TP, tbl_TP, txt_BuscarTP);
        TP.Actualizar_Tabla();
    }//GEN-LAST:event_icon_TPMouseClicked

    private void icon_TPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_TPMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA11);

        animacion.Subir();
    }//GEN-LAST:event_icon_TPMouseExited

    private void icon_RPMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_RPMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA8);

        animacion.Bajar();
    }//GEN-LAST:event_icon_RPMouseMoved

    private void icon_RPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_RPMouseClicked
        // TODO add your handling code here:
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        jPanel_MantenimientosRP.setVisible(true);

        Referencias_Personales RP = new Referencias_Personales(txt_id_RP, txt_Nombre_RP, txt_Telefono_RP, txt_Buscar_RP, tbl_RP);
        RP.Actualizar_Tabla();
    }//GEN-LAST:event_icon_RPMouseClicked

    private void icon_RPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_RPMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA8);

        animacion.Subir();
    }//GEN-LAST:event_icon_RPMouseExited

    private void RPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_RPMouseClicked

    private void icon_CVMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_CVMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA9);

        animacion.Bajar();
    }//GEN-LAST:event_icon_CVMouseMoved

    private void icon_CVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_CVMouseClicked
        // TODO add your handling code here:
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        jPanel_MantenimientoCV.setVisible(true);
        Curriculum CV = new Curriculum(txt_DPICV, txt_NombreCV, txt_ApellidoCV, txt_TelefonoCV, txt_CorreoCV, txt_DireccionCV, txt_GeneroCV, txt_EdadCV, jLabel_NivelA_CV, jLabel_RP_CV, jLabel_RL_CV, jLabel_EL_CV, jLabel_Medio_CV, txt_Buscar_CV, tbl_CV);
        CV.Actualizar_Tabla();
        CV.Encontrar_ListaCV("nivel_academico", "nombre_nivel", jComboBox_NivelACV);
        CV.Encontrar_ListaCV("referenciasp", "nombre_personaP", jComboBox_RPCV);
        CV.Encontrar_ListaCV("referenciasl", "nombre_personaL", jComboBox_RLCV);
        CV.Encontrar_ListaCV("experiencia_laboral", "id_tipoexp", jComboBox_ELCV);
        CV.Encontrar_ListaCV("medio", "nombre_medio", jComboBox_MedioCV);
        //jComboBox_TablasB_CV1.addItem(S_Emp);
        jComboBox_TablasB_CV1.addItem(S_NA);
        jComboBox_TablasB_CV1.addItem(S_RP);
        jComboBox_TablasB_CV1.addItem(S_RL);
        jComboBox_TablasB_CV1.addItem(S_EL);
        jComboBox_TablasB_CV1.addItem(S_Med);
    }//GEN-LAST:event_icon_CVMouseClicked

    private void icon_CVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_CVMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA9);

        animacion.Subir();
    }//GEN-LAST:event_icon_CVMouseExited

    private void jLabel_Felcha2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Felcha2MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_Felcha2MouseMoved

    private void jLabel_Felcha2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Felcha2MouseClicked
        // TODO add your handling code here:
        AnimationClass ani = new AnimationClass();

        //Flecha a la Derecha
        ani.jLabelXRight(jLabel_Felcha2.getX(), 1500, 2, 1, jLabel_Felcha2);
        ani.jLabelXLeft(jLabel_Flecha_Iz1.getX(), 1270, 2, 1, jLabel_Flecha_Iz1);

        //Departamento
        ani.jLabelYUp(icon_Departamento.getY(), -300, 2, 1, icon_Departamento);
        ani.jLabelYUp(SeleccionadoA1.getY(), -300, 2, 1, SeleccionadoA1);
        ani.jLabelYUp(Cant_R2.getY(), -140, 2, 1, Cant_R2);

        //Puesto
        ani.jLabelYUp(icon_Puesto.getY(), -300, 2, 1, icon_Puesto);
        ani.jLabelYUp(SeleccionadoA.getY(), -300, 2, 1, SeleccionadoA);
        ani.jLabelYUp(Cant_R3.getY(), -140, 2, 1, Cant_R3);

        //Nivel Academico
        ani.jLabelYUp(icon_NivelA.getY(), -300, 2, 1, icon_NivelA);
        ani.jLabelYUp(SeleccionadoA2.getY(), -300, 2, 1, SeleccionadoA2);
        ani.jLabelYUp(Cant_R4.getY(), -140, 2, 1, Cant_R4);

        //Exeperiencia Laboral Detallada
        ani.jLabelYUp(icon_ExpLD.getY(), -300, 2, 1, icon_ExpLD);
        ani.jLabelYUp(SeleccionadoA3.getY(), -300, 2, 1, SeleccionadoA3);
        ani.jLabelYUp(Cant_R1.getY(), -140, 2, 1, Cant_R1);

        //Experiecia Laboral
        ani.jLabelYUp(icon_ExpL.getY(), -300, 2, 1, icon_ExpL);
        ani.jLabelYUp(SeleccionadoA4.getY(), -300, 2, 1, SeleccionadoA4);
        ani.jLabelYUp(Cant_R10.getY(), -140, 2, 1, Cant_R10);

        //Solicitud Empresarial
        ani.jLabelYUp(icon_SE.getY(), -300, 2, 1, icon_SE);
        ani.jLabelYUp(SeleccionadoA5.getY(), -300, 2, 1, SeleccionadoA5);
        ani.jLabelYUp(Cant_R11.getY(), -140, 2, 1, Cant_R11);

        //Medio
        ani.jLabelYUp(icon_Medio.getY(), -300, 2, 1, icon_Medio);
        ani.jLabelYUp(SeleccionadoA6.getY(), -300, 2, 1, SeleccionadoA6);
        ani.jLabelYUp(Cant_R12.getY(), -140, 2, 1, Cant_R12);

        //Referencias Laborales
        ani.jLabelYUp(icon_RL.getY(), -300, 2, 1, icon_RL);
        ani.jLabelYUp(SeleccionadoA7.getY(), -300, 2, 1, SeleccionadoA7);
        ani.jLabelYUp(Cant_R9.getY(), -140, 2, 1, Cant_R9);

        //Referencias Personales
        ani.jLabelYUp(icon_RP.getY(), -300, 2, 1, icon_RP);
        ani.jLabelYUp(SeleccionadoA8.getY(), -300, 2, 1, SeleccionadoA8);
        ani.jLabelYUp(Cant_R13.getY(), -140, 2, 1, Cant_R13);

        //Curriculum
        ani.jLabelYUp(icon_CV.getY(), -300, 2, 1, icon_CV);
        ani.jLabelYUp(SeleccionadoA9.getY(), -300, 2, 1, SeleccionadoA9);
        ani.jLabelYUp(Cant_R16.getY(), -140, 2, 1, Cant_R16);

        //Aplicacion
        ani.jLabelYUp(icon_Aplicacion.getY(), -300, 2, 1, icon_Aplicacion);
        ani.jLabelYUp(SeleccionadoA10.getY(), -300, 2, 1, SeleccionadoA10);
        ani.jLabelYUp(Cant_R14.getY(), -140, 2, 1, Cant_R14);

        //Tipo Prueba
        ani.jLabelYUp(icon_TP.getY(), -300, 2, 1, icon_TP);
        ani.jLabelYUp(SeleccionadoA11.getY(), -300, 2, 1, SeleccionadoA11);
        ani.jLabelYUp(Cant_R15.getY(), -140, 2, 1, Cant_R15);

        //Aplicacion Prueba a la Izquiera
        ani.jLabelXLeft(icon_APP.getX(), -2, 2, 1, icon_APP);
        ani.jLabelXLeft(SeleccionadoA12.getX(), 1, 2, 1, SeleccionadoA12);
        ani.jLabelXLeft(Cant_R17.getX(), 140, 2, 1, Cant_R17);

        //Seleccion a la Izquierda
        ani.jLabelXLeft(icon_Seleccion.getX(), -2, 2, 1, icon_Seleccion);
        ani.jLabelXLeft(SeleccionadoA13.getX(), 1, 2, 1, SeleccionadoA13);
        ani.jLabelXLeft(Cant_R18.getX(), 140, 2, 1, Cant_R18);

        //Actividad a la Izquierda
        ani.jLabelXLeft(icon_Actividad.getX(), -2, 2, 1, icon_Actividad);
        ani.jLabelXLeft(SeleccionadoA14.getX(), 1, 2, 1, SeleccionadoA14);
        ani.jLabelXLeft(Cant_R19.getX(), 140, 2, 1, Cant_R19);

        //Periodo Prueba a la Izquierda
        ani.jLabelXLeft(icon_PP.getX(), -2, 2, 1, icon_PP);
        ani.jLabelXLeft(SeleccionadoA15.getX(), 1, 2, 1, SeleccionadoA15);
        ani.jLabelXLeft(Cant_R20.getX(), 140, 2, 1, Cant_R20);

        //Contratacion a la Izquierda
        ani.jLabelXLeft(icon_Contratacion.getX(), -2, 2, 1, icon_Contratacion);
        ani.jLabelXLeft(SeleccionadoA16.getX(), 1, 2, 1, SeleccionadoA16);
        ani.jLabelXLeft(Cant_R21.getX(), 140, 2, 1, Cant_R21);

        //Empleado contratado a la Izquierda
        ani.jLabelXLeft(icon_EC.getX(), -2, 2, 1, icon_EC);
        ani.jLabelXLeft(SeleccionadoA17.getX(), 1, 2, 1, SeleccionadoA17);
        ani.jLabelXLeft(Cant_R22.getX(), 140, 2, 1, Cant_R22);

        //Actividad Empleado a la Izquierda
        ani.jLabelXLeft(icon_AE.getX(), -2, 2, 1, icon_AE);
        ani.jLabelXLeft(SeleccionadoA18.getX(), 1, 2, 1, SeleccionadoA18);
        ani.jLabelXLeft(Cant_R23.getX(), 140, 2, 1, Cant_R23);

        //Bitacora Empleado a la Izquierda
        ani.jLabelXLeft(icon_BE.getX(), -2, 2, 1, icon_BE);
        ani.jLabelXLeft(SeleccionadoA19.getX(), 1, 2, 1, SeleccionadoA19);
        ani.jLabelXLeft(Cant_R24.getX(), 140, 2, 1, Cant_R24);
    }//GEN-LAST:event_jLabel_Felcha2MouseClicked

    private void jLabel_Felcha2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Felcha2MouseExited
        // TODO add your handling code here:
        /*jLabel_Felcha2.setVisible(false);
        jLabel_Felcha.setVisible(true);
        jLabel_Felcha.setEnabled(false);
        jLabel_Felcha2.setEnabled(false);*/
    }//GEN-LAST:event_jLabel_Felcha2MouseExited

    private void jLabel_Flecha_Iz1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Flecha_Iz1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_Flecha_Iz1MouseMoved

    private void jLabel_Flecha_Iz1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Flecha_Iz1MouseClicked
        // TODO add your handling code here:

        AnimationClass ani = new AnimationClass();
        ani.jLabelXRight(jLabel_Flecha_Iz1.getX(), 1500, 2, 1, jLabel_Flecha_Iz1);
        jLabel_Felcha2.setVisible(true);
        jLabel_Felcha2.setEnabled(true);
        ani.jLabelXLeft(jLabel_Felcha2.getX(), 1270, 2, 1, jLabel_Felcha2);

        //Aplicacion Prueba a la derecha
        ani.jLabelXRight(icon_APP.getX(), 240, 2, 1, icon_APP);
        ani.jLabelXRight(SeleccionadoA12.getX(), 270, 2, 1, SeleccionadoA12);
        ani.jLabelXRight(Cant_R17.getX(), 380, 2, 1, Cant_R17);

        //Seleccion a la derecha
        ani.jLabelXRight(icon_Seleccion.getX(), 240, 2, 1, icon_Seleccion);
        ani.jLabelXRight(SeleccionadoA13.getX(), 270, 2, 1, SeleccionadoA13);
        ani.jLabelXRight(Cant_R18.getX(), 380, 2, 1, Cant_R18);

        //Actividad a la derecha
        ani.jLabelXRight(icon_Actividad.getX(), 240, 2, 1, icon_Actividad);
        ani.jLabelXRight(SeleccionadoA14.getX(), 270, 2, 1, SeleccionadoA14);
        ani.jLabelXRight(Cant_R19.getX(), 380, 2, 1, Cant_R19);

        //Periodo Prueba a la derecha
        ani.jLabelXRight(icon_PP.getX(), 240, 2, 1, icon_PP);
        ani.jLabelXRight(SeleccionadoA15.getX(), 270, 2, 1, SeleccionadoA15);
        ani.jLabelXRight(Cant_R20.getX(), 380, 2, 1, Cant_R20);

        //Contratacion a la derecha
        ani.jLabelXRight(icon_Contratacion.getX(), 240, 2, 1, icon_Contratacion);
        ani.jLabelXRight(SeleccionadoA16.getX(), 270, 2, 1, SeleccionadoA16);
        ani.jLabelXRight(Cant_R21.getX(), 380, 2, 1, Cant_R21);

        //Empleado contratado a la derecha
        ani.jLabelXRight(icon_EC.getX(), 240, 2, 1, icon_EC);
        ani.jLabelXRight(SeleccionadoA17.getX(), 270, 2, 1, SeleccionadoA17);
        ani.jLabelXRight(Cant_R22.getX(), 380, 2, 1, Cant_R22);

        //Actividad Empleado a la derecha
        ani.jLabelXRight(icon_AE.getX(), 240, 2, 1, icon_AE);
        ani.jLabelXRight(SeleccionadoA18.getX(), 270, 2, 1, SeleccionadoA18);
        ani.jLabelXRight(Cant_R23.getX(), 380, 2, 1, Cant_R23);

        //Bitacora Empleado a la derecha
        ani.jLabelXRight(icon_BE.getX(), 240, 2, 1, icon_BE);
        ani.jLabelXRight(SeleccionadoA19.getX(), 270, 2, 1, SeleccionadoA19);
        ani.jLabelXRight(Cant_R24.getX(), 380, 2, 1, Cant_R24);

        //Departamento Para Abajo
        ani.jLabelYDown(icon_Departamento.getY(), 0, 2, 1, icon_Departamento);
        ani.jLabelYDown(SeleccionadoA1.getY(), -50, 2, 1, SeleccionadoA1);
        ani.jLabelYDown(Cant_R2.getY(), 158, 2, 1, Cant_R2);

        //Puesto para abajo
        ani.jLabelYDown(icon_Puesto.getY(), 0, 2, 1, icon_Puesto);
        ani.jLabelYDown(SeleccionadoA.getY(), -50, 2, 1, SeleccionadoA);
        ani.jLabelYDown(Cant_R3.getY(), 158, 2, 1, Cant_R3);

        //Nivel Academico para abajo
        ani.jLabelYDown(icon_NivelA.getY(), 0, 2, 1, icon_NivelA);
        ani.jLabelYDown(SeleccionadoA2.getY(), -50, 2, 1, SeleccionadoA2);
        ani.jLabelYDown(Cant_R4.getY(), 158, 2, 1, Cant_R4);

        //Experiencia Laboral Detallada para abajo
        ani.jLabelYDown(icon_ExpLD.getY(), 0, 2, 1, icon_ExpLD);
        ani.jLabelYDown(SeleccionadoA3.getY(), -50, 2, 1, SeleccionadoA3);
        ani.jLabelYDown(Cant_R1.getY(), 158, 2, 1, Cant_R1);

        //Experiencia Laboral Para abajo
        ani.jLabelYDown(icon_ExpL.getY(), 0, 2, 1, icon_ExpL);
        ani.jLabelYDown(SeleccionadoA4.getY(), -50, 2, 1, SeleccionadoA4);
        ani.jLabelYDown(Cant_R10.getY(), 158, 2, 1, Cant_R10);

        //Solicitud Empresarial para abajo
        ani.jLabelYDown(icon_SE.getY(), 0, 2, 1, icon_SE);
        ani.jLabelYDown(SeleccionadoA5.getY(), -50, 2, 1, SeleccionadoA5);
        ani.jLabelYDown(Cant_R11.getY(), 158, 2, 1, Cant_R11);

        //Medio para abajo
        ani.jLabelYDown(icon_Medio.getY(), 0, 2, 1, icon_Medio);
        ani.jLabelYDown(SeleccionadoA6.getY(), -50, 2, 1, SeleccionadoA6);
        ani.jLabelYDown(Cant_R12.getY(), 158, 2, 1, Cant_R12);

        //Referencias Laborales para abajo
        ani.jLabelYDown(icon_RL.getY(), 0, 2, 1, icon_RL);
        ani.jLabelYDown(SeleccionadoA7.getY(), -50, 2, 1, SeleccionadoA7);
        ani.jLabelYDown(Cant_R9.getY(), 158, 2, 1, Cant_R9);

        //Referencias Personales para abajo
        ani.jLabelYDown(icon_RP.getY(), 0, 2, 1, icon_RP);
        ani.jLabelYDown(SeleccionadoA8.getY(), -50, 2, 1, SeleccionadoA8);
        ani.jLabelYDown(Cant_R13.getY(), 158, 2, 1, Cant_R13);

        //Curriculum para abajo
        ani.jLabelYDown(icon_CV.getY(), 0, 2, 1, icon_CV);
        ani.jLabelYDown(SeleccionadoA9.getY(), -50, 2, 1, SeleccionadoA9);
        ani.jLabelYDown(Cant_R16.getY(), 158, 2, 1, Cant_R16);

        //Aplicacion para abajo
        ani.jLabelYDown(icon_Aplicacion.getY(), 0, 2, 1, icon_Aplicacion);
        ani.jLabelYDown(SeleccionadoA10.getY(), -50, 2, 1, SeleccionadoA10);
        ani.jLabelYDown(Cant_R14.getY(), 158, 2, 1, Cant_R14);

        //Tipo prueba para abajo
        ani.jLabelYDown(icon_TP.getY(), 0, 2, 1, icon_TP);
        ani.jLabelYDown(SeleccionadoA11.getY(), -50, 2, 1, SeleccionadoA11);
        ani.jLabelYDown(Cant_R15.getY(), 158, 2, 1, Cant_R15);
    }//GEN-LAST:event_jLabel_Flecha_Iz1MouseClicked

    private void jLabel_Flecha_Iz1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Flecha_Iz1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_Flecha_Iz1MouseExited

    private void jPanel_BGMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_BGMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel_BGMouseMoved

    private void jPanel_BGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_BGMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel_BGMouseClicked

    private void jPanel_BGMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_BGMouseExited
        // TODO add your handling code here:
        //t.stop();
    }//GEN-LAST:event_jPanel_BGMouseExited

    private void txt_id_PPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_PPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_PPActionPerformed

    private void jComboBox_PPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_PPSActionPerformed
        // TODO add your handling code here:
        Periodo_Prueba periodo_p = new Periodo_Prueba(txt_id_PP, jLabel_PPSE, txt_id_FI, txt_id_FF, txt_id_Pago, jLabel_PPAA, txt_BuscarPP, tbl_PP);
        periodo_p.EncontrarID_PP("id_seleccion", "seleccion", "id_seleccion", jComboBox_PPS, jLabel_PPSE);

    }//GEN-LAST:event_jComboBox_PPSActionPerformed

    private void txt_id_FIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_FIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_FIActionPerformed

    private void txt_id_FFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_FFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_FFActionPerformed

    private void txt_id_PagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_PagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_PagoActionPerformed

    private void jComboBox_PPAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_PPAActionPerformed
        // TODO add your handling code here:
        Periodo_Prueba periodo_p = new Periodo_Prueba(txt_id_PP, jLabel_PPSE, txt_id_FI, txt_id_FF, txt_id_Pago, jLabel_PPAA, txt_BuscarPP, tbl_PP);
        periodo_p.EncontrarID_PP("id_actividad", "actividad", "tipo_actividad", jComboBox_PPA, jLabel_PPAA);
    }//GEN-LAST:event_jComboBox_PPAActionPerformed

    private void jLabel_IngresarPPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_IngresarPPMouseClicked
        // TODO add your handling code here:
        Periodo_Prueba periodo_p = new Periodo_Prueba(txt_id_PP, jLabel_PPSE, txt_id_FI, txt_id_FF, txt_id_Pago, jLabel_PPAA, txt_BuscarPP, tbl_PP);
        periodo_p.Insertar_PP();
    }//GEN-LAST:event_jLabel_IngresarPPMouseClicked

    private void jLabel_Modificar_PPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Modificar_PPMouseClicked
        // TODO add your handling code here:
        Periodo_Prueba periodo_p = new Periodo_Prueba(txt_id_PP, jLabel_PPSE, txt_id_FI, txt_id_FF, txt_id_Pago, jLabel_PPAA, txt_BuscarPP, tbl_PP);
        periodo_p.Modificar_PP();
    }//GEN-LAST:event_jLabel_Modificar_PPMouseClicked

    private void jLabel_Eliminar_PPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Eliminar_PPMouseClicked
        // TODO add your handling code here:
        Periodo_Prueba periodo_p = new Periodo_Prueba(txt_id_PP, jLabel_PPSE, txt_id_FI, txt_id_FF, txt_id_Pago, jLabel_PPAA, txt_BuscarPP, tbl_PP);
        periodo_p.Eliminar_PP();
    }//GEN-LAST:event_jLabel_Eliminar_PPMouseClicked

    private void jLabel_BuscarPPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_BuscarPPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_BuscarPPMouseClicked

    private void txt_BuscarPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarPPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarPPActionPerformed

    private void txt_BuscarPPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarPPKeyReleased
        // TODO add your handling code here:

        Periodo_Prueba periodo_p = new Periodo_Prueba(txt_id_PP, jLabel_PPSE, txt_id_FI, txt_id_FF, txt_id_Pago, jLabel_PPAA, txt_BuscarPP, tbl_PP);
        periodo_p.Buscar_PPE(txt_BuscarPP.getText());
    }//GEN-LAST:event_txt_BuscarPPKeyReleased

    private void tbl_PPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_PPMouseClicked
        // TODO add your handling code here:

        int Seleccion = tbl_PP.rowAtPoint(evt.getPoint());

        txt_id_PP.setText(String.valueOf(tbl_PP.getValueAt(Seleccion, 0)));
        jLabel_PPSE.setText(String.valueOf(tbl_PP.getValueAt(Seleccion, 1)));
        txt_id_FI.setText(String.valueOf(tbl_PP.getValueAt(Seleccion, 2)));
        txt_id_FF.setText(String.valueOf(tbl_PP.getValueAt(Seleccion, 3)));
        txt_id_Pago.setText(String.valueOf(tbl_PP.getValueAt(Seleccion, 4)));
        jLabel_PPAA.setText(String.valueOf(tbl_PP.getValueAt(Seleccion, 5)));

        Periodo_Prueba periodo_p = new Periodo_Prueba(txt_id_PP, jLabel_PPSE, txt_id_FI, txt_id_FF, txt_id_Pago, jLabel_PPAA, txt_BuscarPP, tbl_PP);
        periodo_p.BuscarFila_PP("tipo_actividad", "actividad", "id_actividad", jComboBox_PPA, jLabel_PPAA);
        periodo_p.BuscarFila_PP("id_ap", "seleccion", "id_seleccion", jComboBox_PPS, jLabel_PPSE);
    }//GEN-LAST:event_tbl_PPMouseClicked

    private void Texto_Ingresar_PPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Ingresar_PPMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarPP.setVisible(true);
        jLabel_Modificar_PP.setVisible(false);
        jLabel_Eliminar_PP.setVisible(false);
    }//GEN-LAST:event_Texto_Ingresar_PPMouseClicked

    private void Panel_Ingresar_PPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Ingresar_PPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Ingresar_PPMouseClicked

    private void Texto_Modificar_PPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Modificar_PPMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarPP.setVisible(false);
        jLabel_Modificar_PP.setVisible(true);
        jLabel_Eliminar_PP.setVisible(false);
    }//GEN-LAST:event_Texto_Modificar_PPMouseClicked

    private void Panel_Modificar_PPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Modificar_PPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Modificar_PPMouseClicked

    private void Texto_Eliminar_PPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Eliminar_PPMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarPP.setVisible(false);
        jLabel_Modificar_PP.setVisible(false);
        jLabel_Eliminar_PP.setVisible(true);
    }//GEN-LAST:event_Texto_Eliminar_PPMouseClicked

    private void Texto_Consultar_PPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Consultar_PPMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarPP.setVisible(false);
        jLabel_Modificar_PP.setVisible(false);
        jLabel_Eliminar_PP.setVisible(false);
    }//GEN-LAST:event_Texto_Consultar_PPMouseClicked

    private void icon_PPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_PPMouseClicked
        // TODO add your handling code here:
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        jPanel_MantenimientoPP.setVisible(true);

        //  combobox
        jComboBox_TablasPP.addItem(S_PeriodoP);
        jComboBox_TablasPP.addItem(S_Actividad);

        Periodo_Prueba periodo_p = new Periodo_Prueba(txt_id_PP, jLabel_PPSE, txt_id_FI, txt_id_FF, txt_id_Pago, jLabel_PPAA, txt_BuscarPP, tbl_PP);
        periodo_p.Encontrar_ListaPP("seleccion", "id_seleccion", jComboBox_PPS);
        periodo_p.Encontrar_ListaPP("actividad", "tipo_actividad", jComboBox_PPA);
        periodo_p.Actualizar_Tabla();


    }//GEN-LAST:event_icon_PPMouseClicked

    private void jComboBox_TablasPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TablasPPActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TablasPPActionPerformed

    private void jLabel_Buscar_TablasPPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Buscar_TablasPPMouseClicked
        // TODO add your handling code here:

        Item_Periodop = jComboBox_TablasPP.getSelectedItem().toString();

        if (Item_Periodop == S_PeriodoP) {
            Seleccion_V s = new Seleccion_V();
            s.setVisible(true);
        }

//        public static String S_Actividad = "Actividad";
//    public static String Item_Actividad="";
        Item_Actividad = jComboBox_TablasPP.getSelectedItem().toString();

        if (Item_Actividad == S_Actividad) {
            Actividad_V ac = new Actividad_V();
            ac.setVisible(true);
        }
    }//GEN-LAST:event_jLabel_Buscar_TablasPPMouseClicked

    private void txt_id_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_CActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_CActionPerformed

    private void jComboBox_PPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_PPCActionPerformed
        Contratacion C = new Contratacion(txt_id_C, jLabel_PPCC, txt_FC, txt_DC, txt_EC, txt_Buscar_C, tbl_C);
        C.EncontrarID_Contratacion("id_periodop", "periodo_prueba", "id_periodop", jComboBox_PPC, jLabel_PPCC);
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_PPCActionPerformed

    private void jComboBox_PPCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox_PPCKeyReleased

        Contratacion C = new Contratacion(txt_id_C, jLabel_PPCC, txt_FC, txt_DC, txt_EC, txt_Buscar_C, tbl_C);
        C.Buscar_Contratacion(txt_Buscar_C.getText());

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_PPCKeyReleased

    private void txt_FCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FCActionPerformed

    private void txt_DCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DCActionPerformed

    private void txt_ECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ECActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ECActionPerformed

    private void jLabel_InsertarCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_InsertarCMouseClicked
        Contratacion C = new Contratacion(txt_id_C, jLabel_PPCC, txt_FC, txt_DC, txt_EC, txt_Buscar_C, tbl_C);
        C.Insertar_Contratacion();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_InsertarCMouseClicked

    private void jLabel_Modificar_CMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Modificar_CMouseClicked
        Contratacion C = new Contratacion(txt_id_C, jLabel_PPCC, txt_FC, txt_DC, txt_EC, txt_Buscar_C, tbl_C);
        C.Modificar_Contratacion();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_Modificar_CMouseClicked

    private void jLabel_Eliminar_CMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Eliminar_CMouseClicked
        Contratacion C = new Contratacion(txt_id_C, jLabel_PPCC, txt_FC, txt_DC, txt_EC, txt_Buscar_C, tbl_C);
        C.Eliminar_Contratacion();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_Eliminar_CMouseClicked

    private void txt_Buscar_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Buscar_CActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Buscar_CActionPerformed

    private void txt_Buscar_CKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Buscar_CKeyReleased
        Contratacion C = new Contratacion(txt_id_C, jLabel_PPCC, txt_FC, txt_DC, txt_EC, txt_Buscar_C, tbl_C);
        C.Buscar_SolicitudCon(txt_Buscar_C.getText());
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Buscar_CKeyReleased

    private void tbl_CMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CMouseClicked
        int Seleccion = tbl_C.rowAtPoint(evt.getPoint());
        txt_id_C.setText(String.valueOf(tbl_C.getValueAt(Seleccion, 0)));
        jLabel_PPCC.setText(String.valueOf(tbl_C.getValueAt(Seleccion, 1)));
        txt_FC.setText(String.valueOf(tbl_C.getValueAt(Seleccion, 2)));
        txt_DC.setText(String.valueOf(tbl_C.getValueAt(Seleccion, 3)));
        txt_EC.setText(String.valueOf(tbl_C.getValueAt(Seleccion, 4)));
        Contratacion C = new Contratacion(txt_id_C, jLabel_PPCC, txt_FC, txt_DC, txt_EC, txt_Buscar_C, tbl_C);
        C.BuscarFila_Contratacion("id_periodop", "periodo_prueba", "id_periodop", jComboBox_PPC, jLabel_PPCC);

        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_CMouseClicked

    private void Texto_Ingresar_PP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Ingresar_PP1MouseClicked

        jLabel_InsertarC.setVisible(true);
        jLabel_Modificar_C.setVisible(false);
        jLabel_Eliminar_C.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_Ingresar_PP1MouseClicked

    private void Panel_Ingresar_PP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Ingresar_PP1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Ingresar_PP1MouseClicked

    private void Texto_Modificar_PP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Modificar_PP1MouseClicked
        jLabel_InsertarC.setVisible(false);
        jLabel_Modificar_C.setVisible(true);
        jLabel_Eliminar_C.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_Texto_Modificar_PP1MouseClicked

    private void Panel_Modificar_PP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Modificar_PP1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Modificar_PP1MouseClicked

    private void Texto_Eliminar_PP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Eliminar_PP1MouseClicked
        jLabel_InsertarC.setVisible(false);
        jLabel_Modificar_C.setVisible(false);
        jLabel_Eliminar_C.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_Texto_Eliminar_PP1MouseClicked

    private void Texto_Consultar_PP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Consultar_PP1MouseClicked
        jLabel_InsertarC.setVisible(false);
        jLabel_Modificar_C.setVisible(false);
        jLabel_Eliminar_C.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_Consultar_PP1MouseClicked

    private void jComboBox_TablasCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TablasCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TablasCActionPerformed

    private void jLabel_Buscar_TablasCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Buscar_TablasCMouseClicked

        Item_Periodop = jComboBox_TablasC.getSelectedItem().toString();

        if (Item_Periodop == S_PeriodoP) {
            Periodo_Prueba_V ac = new Periodo_Prueba_V();
            ac.setVisible(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_Buscar_TablasCMouseClicked

    private void icon_ContratacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ContratacionMouseClicked

        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        jComboBox_TablasC.addItem(S_PeriodoP);

        jPanel_MantenimientoC.setVisible(true);
        Contratacion C = new Contratacion(txt_id_C, jLabel_PPCC, txt_FC, txt_DC, txt_EC, txt_Buscar_C, tbl_C);
        C.Encontrar_ListaCon("periodo_prueba", "id_periodop", jComboBox_PPC);
        C.Actualizar_Tabla();

        // TODO add your handling code here:
    }//GEN-LAST:event_icon_ContratacionMouseClicked

    private void txt_id_ECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_ECActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_ECActionPerformed

    private void jComboBox_CECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_CECActionPerformed
        // TODO add your handling code here:
        Empleado_Contratado empleado = new Empleado_Contratado (txt_id_EC, jLabel_CECC, jLabel_ECPP, jLabel_ECDD, txt_SEC, txt_BuscarEC, tbl_EC);
        empleado.EncontrarID_CE("id_contratacion", "contratacion", "id_contratacion", jComboBox_CEC, jLabel_CECC);
        //60,63,65
    }//GEN-LAST:event_jComboBox_CECActionPerformed

    private void jComboBox_ECPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ECPActionPerformed
        // TODO add your handling code here:
        Empleado_Contratado empleado = new Empleado_Contratado (txt_id_EC, jLabel_CECC, jLabel_ECPP, jLabel_ECDD, txt_SEC, txt_BuscarEC, tbl_EC);
        empleado.EncontrarID_CE("id_puesto", "puesto", "nombre_puesto", jComboBox_ECP, jLabel_ECPP);

    }//GEN-LAST:event_jComboBox_ECPActionPerformed

    private void jComboBox_ECDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ECDActionPerformed
        // TODO add your handling code here:
        Empleado_Contratado empleado = new Empleado_Contratado (txt_id_EC, jLabel_CECC, jLabel_ECPP, jLabel_ECDD, txt_SEC, txt_BuscarEC, tbl_EC);
        empleado.EncontrarID_CE("id_departamento", "departamento", "nombre_departamento", jComboBox_ECD, jLabel_ECDD);

    }//GEN-LAST:event_jComboBox_ECDActionPerformed

    private void txt_SECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SECActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SECActionPerformed

    private void jLabel_IngresarECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_IngresarECMouseClicked
        // TODO add your handling code here:
        Empleado_Contratado empleado = new Empleado_Contratado (txt_id_EC, jLabel_CECC, jLabel_ECPP, jLabel_ECDD, txt_SEC, txt_BuscarEC, tbl_EC);
        empleado.Insertar_PP();
       
        // BITACORA APARTADO
//        Bitacora_Empleado BE= new Bitacora_Empleado(jTextField_Encontraid,txt_Buscar_BE,tbl_BE);
//        BE.Insertar_BE();
    }//GEN-LAST:event_jLabel_IngresarECMouseClicked

    private void jLabel_Modificar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Modificar_ECMouseClicked
        // TODO add your handling code here:
        Empleado_Contratado empleado = new Empleado_Contratado (txt_id_EC, jLabel_CECC, jLabel_ECPP, jLabel_ECDD, txt_SEC, txt_BuscarEC, tbl_EC);
        empleado.Modificar_EC();
    }//GEN-LAST:event_jLabel_Modificar_ECMouseClicked

    private void jLabel_Eliminar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Eliminar_ECMouseClicked
        // TODO add your handling code here:
        Empleado_Contratado empleado = new Empleado_Contratado (txt_id_EC, jLabel_CECC, jLabel_ECPP, jLabel_ECDD, txt_SEC, txt_BuscarEC, tbl_EC);
        empleado.Eliminar_EC();
    }//GEN-LAST:event_jLabel_Eliminar_ECMouseClicked

    private void txt_BuscarECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarECActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarECActionPerformed

    private void txt_BuscarECKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarECKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarECKeyPressed

    private void txt_BuscarECKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarECKeyReleased
        // TODO add your handling code here:
        Empleado_Contratado empleado = new Empleado_Contratado (txt_id_EC, jLabel_CECC, jLabel_ECPP, jLabel_ECDD, txt_SEC, txt_BuscarEC, tbl_EC);
        empleado.Buscar_ECE(txt_BuscarEC.getText());
    }//GEN-LAST:event_txt_BuscarECKeyReleased

    private void tbl_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ECMouseClicked
        // TODO add your handling code here:
        int Seleccion = tbl_EC.rowAtPoint(evt.getPoint());

        txt_id_EC.setText(String.valueOf(tbl_EC.getValueAt(Seleccion, 0)));
        jLabel_CECC.setText(String.valueOf(tbl_EC.getValueAt(Seleccion, 1)));
        jLabel_ECPP.setText(String.valueOf(tbl_EC.getValueAt(Seleccion, 2)));
        jLabel_ECDD.setText(String.valueOf(tbl_EC.getValueAt(Seleccion, 3)));
        txt_SEC.setText(String.valueOf(tbl_EC.getValueAt(Seleccion, 4)));

        Empleado_Contratado empleado = new Empleado_Contratado (txt_id_EC, jLabel_CECC, jLabel_ECPP, jLabel_ECDD, txt_SEC, txt_BuscarEC, tbl_EC);
        empleado.BuscarFila_EC("id_contratacion", "contratacion", "id_contratacion", jComboBox_CEC, jLabel_CECC);
        empleado.BuscarFila_EC("nombre_puesto", "puesto", "id_puesto", jComboBox_ECP, jLabel_ECPP);
        empleado.BuscarFila_EC("nombre_departamento", "departamento", "id_departamento", jComboBox_ECD, jLabel_ECDD);
    }//GEN-LAST:event_tbl_ECMouseClicked

    private void Texto_Ingresar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Ingresar_ECMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarEC.setVisible(true);
        jLabel_Modificar_EC.setVisible(false);
        jLabel_Eliminar_EC.setVisible(false);
    }//GEN-LAST:event_Texto_Ingresar_ECMouseClicked

    private void Panel_Ingresar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Ingresar_ECMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_Panel_Ingresar_ECMouseClicked

    private void Texto_Modificar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Modificar_ECMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarEC.setVisible(false);
        jLabel_Modificar_EC.setVisible(true);
        jLabel_Eliminar_EC.setVisible(false);
    }//GEN-LAST:event_Texto_Modificar_ECMouseClicked

    private void Panel_Modificar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Modificar_ECMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Panel_Modificar_ECMouseClicked

    private void Texto_Eliminar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Eliminar_ECMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarEC.setVisible(false);
        jLabel_Modificar_EC.setVisible(false);
        jLabel_Eliminar_EC.setVisible(true);
    }//GEN-LAST:event_Texto_Eliminar_ECMouseClicked

    private void Texto_Consultar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Consultar_ECMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarEC.setVisible(false);
        jLabel_Modificar_EC.setVisible(false);
        jLabel_Eliminar_EC.setVisible(false);
    }//GEN-LAST:event_Texto_Consultar_ECMouseClicked

    private void Panel_Eliminar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Eliminar_ECMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Panel_Eliminar_ECMouseClicked

    private void Panel_Consultar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Consultar_ECMouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_Panel_Consultar_ECMouseClicked

    private void icon_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ECMouseClicked
        // TODO add your handling code here:
        
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);
        
        jPanel_MantenimientoEC.setVisible(true);
        
        //Combobox
        jComboBox_TablasEC.addItem(S_Contratacion);
        jComboBox_TablasEC.addItem(S_Puesto);
        jComboBox_TablasEC.addItem(S_Departamento);
        
        Empleado_Contratado empleado = new Empleado_Contratado (txt_id_EC, jLabel_CECC, jLabel_ECPP, jLabel_ECDD, txt_SEC, txt_BuscarEC, tbl_EC);
        empleado.Encontrar_ListaEC("contratacion", "id_contratacion", jComboBox_CEC);
        empleado.Encontrar_ListaEC("puesto", "nombre_puesto", jComboBox_ECP);
        empleado.Encontrar_ListaEC("departamento", "nombre_departamento", jComboBox_ECD);
        empleado.Actualizar_Tabla();
    }//GEN-LAST:event_icon_ECMouseClicked

    private void jComboBox_TablasECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TablasECActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TablasECActionPerformed

    private void jLabel_Buscar_TablasECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Buscar_TablasECMouseClicked
        // TODO add your handling code here:
        Item_Contratacion = jComboBox_TablasEC.getSelectedItem().toString();

        if (Item_Contratacion == S_Contratacion) {
            Contratacion_V empleado = new Contratacion_V();
            empleado.setVisible(true);
        }
        
        Item_P = jComboBox_TablasEC.getSelectedItem().toString();

        if (Item_P == S_Puesto) {
            Puesto_V puesto = new Puesto_V();
            puesto.setVisible(true);
        }
        
        Item_D = jComboBox_TablasEC.getSelectedItem().toString();

        if (Item_D == S_Departamento) {
            Departamento_V dep = new Departamento_V();
            dep.setVisible(true);
        }
        
    }//GEN-LAST:event_jLabel_Buscar_TablasECMouseClicked

    private void SEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SEMouseClicked

    private void Icono_RRHHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Icono_RRHHMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Icono_RRHHMouseEntered

    private void jComboBox_AE_ECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_AE_ECActionPerformed
        // TODO add your handling code here:
        Actividad_Empleado AE = new Actividad_Empleado(jLabel_AE_ECC,jLabel_Actividad_AEE,txt_BuscarAE,tbl_AE);
        AE.EncontrarID_AE("id_empleado","empleado_contratado","id_empleado",jComboBox_AE_EC,jLabel_AE_ECC);

    }//GEN-LAST:event_jComboBox_AE_ECActionPerformed

    private void jComboBox_Actividad_AEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Actividad_AEActionPerformed
        // TODO add your handling code here:
        Actividad_Empleado AE = new Actividad_Empleado(jLabel_AE_ECC,jLabel_Actividad_AEE,txt_BuscarAE,tbl_AE);
        AE.EncontrarID_AE("id_actividad","actividad","tipo_actividad",jComboBox_Actividad_AE,jLabel_Actividad_AEE);
    }//GEN-LAST:event_jComboBox_Actividad_AEActionPerformed

    private void jLabel_Insertar_AEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Insertar_AEMouseClicked
        // TODO add your handling code here:
        Actividad_Empleado AE = new Actividad_Empleado(jLabel_AE_ECC,jLabel_Actividad_AEE,txt_BuscarAE,tbl_AE);
        AE.Insertar_AE();
    }//GEN-LAST:event_jLabel_Insertar_AEMouseClicked

    private void jLabel_Modificar_AEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Modificar_AEMouseClicked
        // TODO add your handling code here:
        Actividad_Empleado AE = new Actividad_Empleado(jLabel_AE_ECC,jLabel_Actividad_AEE,txt_BuscarAE,tbl_AE);
        AE.Modificar_AE();
    }//GEN-LAST:event_jLabel_Modificar_AEMouseClicked

    private void jLabel_Eliminar_AEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Eliminar_AEMouseClicked
        // TODO add your handling code here:
        Actividad_Empleado AE = new Actividad_Empleado(jLabel_AE_ECC,jLabel_Actividad_AEE,txt_BuscarAE,tbl_AE);
        AE.Eliminar_AE();
    }//GEN-LAST:event_jLabel_Eliminar_AEMouseClicked

    private void jLabel_BuscarAEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_BuscarAEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_BuscarAEMouseClicked

    private void txt_BuscarAEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarAEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarAEActionPerformed

    private void txt_BuscarAEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarAEKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarAEKeyPressed

    private void txt_BuscarAEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarAEKeyReleased
        // TODO add your handling code here:
        Actividad_Empleado AE = new Actividad_Empleado(jLabel_AE_ECC,jLabel_Actividad_AEE,txt_BuscarAE,tbl_AE);
        AE.Buscar_AEF(txt_BuscarAE.getText());

    }//GEN-LAST:event_txt_BuscarAEKeyReleased

    private void tbl_AEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_AEMouseClicked
        // TODO add your handling code here:
        Actividad_Empleado AE = new Actividad_Empleado(jLabel_AE_ECC,jLabel_Actividad_AEE,txt_BuscarAE,tbl_AE);
        AE.BuscarFila_AE("id_empleado","empleado_contratado","id_empleado",jComboBox_AE_EC,jLabel_AE_ECC);
        AE.BuscarFila_AE("tipo_actividad","actividad","id_actividad",jComboBox_Actividad_AE,jLabel_Actividad_AEE);
    }//GEN-LAST:event_tbl_AEMouseClicked

    private void Texto_IngresarAEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarAEMouseClicked
        // TODO add your handling code here:
        jLabel_Insertar_AE.setVisible(true);
        jLabel_Modificar_AE.setVisible(false);
        jLabel_Eliminar_AE.setVisible(false);
    }//GEN-LAST:event_Texto_IngresarAEMouseClicked

    private void Panel_IngresarAEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarAEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarAEMouseClicked

    private void Texto_ModificarAEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificarAEMouseClicked
        // TODO add your handling code here:
        jLabel_Insertar_AE.setVisible(false);
        jLabel_Modificar_AE.setVisible(true);
        jLabel_Eliminar_AE.setVisible(false);
    }//GEN-LAST:event_Texto_ModificarAEMouseClicked

    private void Panel_ModificarAEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarAEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarAEMouseClicked

    private void Texto_EliminarAEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarAEMouseClicked
        // TODO add your handling code here:
        jLabel_Insertar_AE.setVisible(false);
        jLabel_Modificar_AE.setVisible(false);
        jLabel_Eliminar_AE.setVisible(true);
    }//GEN-LAST:event_Texto_EliminarAEMouseClicked

    private void Panel_EliminarAEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_EliminarAEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_EliminarAEMouseClicked

    private void Texto_ConsultarAEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarAEMouseClicked
        // TODO add your handling code here:
        jLabel_Insertar_AE.setVisible(false);
        jLabel_Modificar_AE.setVisible(false);
        jLabel_Eliminar_AE.setVisible(false);
    }//GEN-LAST:event_Texto_ConsultarAEMouseClicked

    private void icon_AEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_AEMouseClicked
        // TODO add your handling code here:
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);
        
        jPanel_MantenimientoAE.setVisible(true);
        
        //Combobox
        jComboBox_TablasAE.addItem(S_Actividad);
        jComboBox_TablasAE.addItem(S_EC);
        
        Actividad_Empleado AE = new Actividad_Empleado(jLabel_AE_ECC,jLabel_Actividad_AEE,txt_BuscarAE,tbl_AE);
        AE.Actualizar_Tabla();
        AE.Encontrar_ListaAE("empleado_contratado","id_empleado",jComboBox_AE_EC);
        AE.Encontrar_ListaAE("actividad","tipo_actividad",jComboBox_Actividad_AE);
    }//GEN-LAST:event_icon_AEMouseClicked

    private void jComboBox_TablasAEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TablasAEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TablasAEActionPerformed

    private void jLabel_Buscar_TablasAEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Buscar_TablasAEMouseClicked
        // TODO add your handling code here:
        Item_Actividad = jComboBox_TablasAE.getSelectedItem().toString();

        if (Item_Actividad == S_Actividad) {
            Actividad_V Ac = new Actividad_V();
            Ac.setVisible(true);
        }
        
        Item_EC = jComboBox_TablasAE.getSelectedItem().toString();

        if (Item_EC == S_EC) {
            EmpleadoC_V ECV = new EmpleadoC_V();
            ECV.setVisible(true);
        }
    }//GEN-LAST:event_jLabel_Buscar_TablasAEMouseClicked

    private void jLabel_Buscar_BEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Buscar_BEMouseClicked
        // TODO add your handling code here:
        Bitacora_Empleado BE = new Bitacora_Empleado(tbl_BE,jTextField_Encontraid,txt_contra,txt_puesto,txt_depa,txt_peri,txt_selec,txt_ap,txt_idap,txt_dpi,txt_Buscar_BE, tbl_BE);
        BE.buscarBit();
    }//GEN-LAST:event_jLabel_Buscar_BEMouseClicked

    private void txt_Buscar_BEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Buscar_BEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Buscar_BEActionPerformed

    private void txt_Buscar_BEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Buscar_BEKeyReleased
        // TODO add your handling code here:
        Bitacora_Empleado BE = new Bitacora_Empleado(tbl_BE,jTextField_Encontraid,txt_contra,txt_puesto,txt_depa,txt_peri,txt_selec,txt_ap,txt_idap,txt_dpi,txt_Buscar_BE, tbl_BE);
        BE.actualizarBit();
        

    }//GEN-LAST:event_txt_Buscar_BEKeyReleased

    private void txt_Buscar_BEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Buscar_BEKeyTyped
        // TODO add your handling code here:
        /* String[] B_datos = new String [9];
        String Idbus;
        Idbus = txt_Buscar_BE.getText();
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
            PreparedStatement pst = cn.prepareStatement("select id_empleado, id_contratacion, id_puesto, id_departamento, sueldo_empleado from empleado_contratado where id_empleado =" + Idbus );
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                txt_puesto.setText(rs.getString("id_puesto"));
                B_datos[0] = (" ");
                B_datos[1] = rs.getString("id_empleado");
                B_datos[2] = rs.getString("id_contratacion");
                B_datos[3] = rs.getString("id_puesto");
                B_datos[4] = rs.getString("id_departamento");
                B_datos[5] = rs.getString("sueldo_empleado");
                model.addRow(B_datos);
            }
            PreparedStatement pst2 = cn.prepareStatement("select nombre_puesto from puesto where id_puesto = " + txt_puesto.getText() );
            ResultSet rs2 = pst2.executeQuery();
            tbl_BE.setModel(model);

        }catch(Exception e)
        {
            System.out.println(e);
        }      */
    }//GEN-LAST:event_txt_Buscar_BEKeyTyped

    private void tbl_BEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_BEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_BEMouseClicked

    private void jTextField_EncontraidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_EncontraidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_EncontraidActionPerformed

    private void txt_puestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_puestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_puestoActionPerformed

    private void txt_selecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_selecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_selecActionPerformed

    private void icon_BEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_BEMouseClicked
        // TODO add your handling code here:
        Departamento.setVisible(false);
        Puesto.setVisible(false);
        Nivel_Academico.setVisible(false);
        ExpLD.setVisible(false);
        ExpL.setVisible(false);
        SE.setVisible(false);
        Medio.setVisible(false);
        RL.setVisible(false);
        RP.setVisible(false);
        CV.setVisible(false);
        Aplicacion.setVisible(false);
        TP.setVisible(false);
        jLabel_Felcha2.setVisible(false);
        jLabel_Flecha_Iz1.setVisible(false);

        jPanel_MantenimientoBE.setVisible(true);

        Bitacora_Empleado BE = new Bitacora_Empleado(tbl_BE,jTextField_Encontraid,txt_contra,txt_puesto,txt_depa,txt_peri,txt_selec,txt_ap,txt_idap,txt_dpi,txt_Buscar_BE, tbl_BE);
        BE.actualizarBit();
    }//GEN-LAST:event_icon_BEMouseClicked

    int posYA1 = 0;

    public void setColor_PanelI(JPanel Panel_Icono) {
        Panel_Icono.setBackground(new Color(59, 62, 65));
    }

    public void resetColor_PanelI(JPanel Panel_Icono) {
        Panel_Icono.setBackground(new Color(40, 41, 46));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Aplicacion;
    private javax.swing.JLabel Bienvenido;
    private javax.swing.JPanel CV;
    private javax.swing.JLabel Cant_R1;
    private javax.swing.JLabel Cant_R10;
    private javax.swing.JLabel Cant_R11;
    private javax.swing.JLabel Cant_R12;
    private javax.swing.JLabel Cant_R13;
    private javax.swing.JLabel Cant_R14;
    private javax.swing.JLabel Cant_R15;
    private javax.swing.JLabel Cant_R16;
    private javax.swing.JLabel Cant_R17;
    private javax.swing.JLabel Cant_R18;
    private javax.swing.JLabel Cant_R19;
    private javax.swing.JLabel Cant_R2;
    private javax.swing.JLabel Cant_R20;
    private javax.swing.JLabel Cant_R21;
    private javax.swing.JLabel Cant_R22;
    private javax.swing.JLabel Cant_R23;
    private javax.swing.JLabel Cant_R24;
    private javax.swing.JLabel Cant_R3;
    private javax.swing.JLabel Cant_R4;
    private javax.swing.JLabel Cant_R5;
    private javax.swing.JLabel Cant_R6;
    private javax.swing.JLabel Cant_R7;
    private javax.swing.JLabel Cant_R8;
    private javax.swing.JLabel Cant_R9;
    private javax.swing.JPanel Departamento;
    private javax.swing.JPanel Departamento1;
    private javax.swing.JPanel ExpL;
    private javax.swing.JPanel ExpLD;
    private javax.swing.JPanel ExpLD1;
    private javax.swing.JLabel Icono_Bancos;
    private javax.swing.JLabel Icono_Conta;
    private javax.swing.JLabel Icono_Nomina;
    private javax.swing.JLabel Icono_RRHH;
    private javax.swing.JPanel Mantenimiento_D;
    private javax.swing.JPanel Medio;
    private javax.swing.JPanel Nivel_Academico;
    private javax.swing.JPanel Nivel_Academico2;
    private javax.swing.JPanel Panel_Consultar;
    private javax.swing.JPanel Panel_Consultar1;
    private javax.swing.JPanel Panel_ConsultarAE;
    private javax.swing.JPanel Panel_ConsultarAP;
    private javax.swing.JPanel Panel_ConsultarAPP;
    private javax.swing.JPanel Panel_ConsultarExpL;
    private javax.swing.JPanel Panel_ConsultarExpLD;
    private javax.swing.JPanel Panel_ConsultarM2;
    private javax.swing.JPanel Panel_ConsultarM3;
    private javax.swing.JPanel Panel_ConsultarM4;
    private javax.swing.JPanel Panel_ConsultarP;
    private javax.swing.JPanel Panel_ConsultarRL;
    private javax.swing.JPanel Panel_ConsultarS;
    private javax.swing.JPanel Panel_ConsultarSE;
    private javax.swing.JPanel Panel_ConsultarTP;
    private javax.swing.JPanel Panel_Consultar_Actividad;
    private javax.swing.JPanel Panel_Consultar_EC;
    private javax.swing.JPanel Panel_Consultar_PP;
    private javax.swing.JPanel Panel_Consultar_PP1;
    private javax.swing.JPanel Panel_Eliminar;
    private javax.swing.JPanel Panel_Eliminar1;
    private javax.swing.JPanel Panel_EliminarAE;
    private javax.swing.JPanel Panel_EliminarAP;
    private javax.swing.JPanel Panel_EliminarAPP;
    private javax.swing.JPanel Panel_EliminarExpL;
    private javax.swing.JPanel Panel_EliminarExpLD;
    private javax.swing.JPanel Panel_EliminarM2;
    private javax.swing.JPanel Panel_EliminarM3;
    private javax.swing.JPanel Panel_EliminarM4;
    private javax.swing.JPanel Panel_EliminarP;
    private javax.swing.JPanel Panel_EliminarRL;
    private javax.swing.JPanel Panel_EliminarS;
    private javax.swing.JPanel Panel_EliminarSE;
    private javax.swing.JPanel Panel_EliminarTP;
    private javax.swing.JPanel Panel_Eliminar_Actividad;
    private javax.swing.JPanel Panel_Eliminar_EC;
    private javax.swing.JPanel Panel_Eliminar_PP;
    private javax.swing.JPanel Panel_Eliminar_PP1;
    private javax.swing.JPanel Panel_Icono_Bancos;
    private javax.swing.JPanel Panel_Icono_Conta;
    private javax.swing.JPanel Panel_Icono_Nomina;
    private javax.swing.JPanel Panel_Icono_RRHH;
    private javax.swing.JPanel Panel_Ingresar;
    private javax.swing.JPanel Panel_Ingresar1;
    private javax.swing.JPanel Panel_IngresarAE;
    private javax.swing.JPanel Panel_IngresarAP;
    private javax.swing.JPanel Panel_IngresarAPP;
    private javax.swing.JPanel Panel_IngresarExpL;
    private javax.swing.JPanel Panel_IngresarExpLD;
    private javax.swing.JPanel Panel_IngresarM2;
    private javax.swing.JPanel Panel_IngresarM3;
    private javax.swing.JPanel Panel_IngresarM4;
    private javax.swing.JPanel Panel_IngresarP;
    private javax.swing.JPanel Panel_IngresarRL;
    private javax.swing.JPanel Panel_IngresarS;
    private javax.swing.JPanel Panel_IngresarSE;
    private javax.swing.JPanel Panel_IngresarTP;
    private javax.swing.JPanel Panel_Ingresar_Actividad;
    private javax.swing.JPanel Panel_Ingresar_EC;
    private javax.swing.JPanel Panel_Ingresar_PP;
    private javax.swing.JPanel Panel_Ingresar_PP1;
    private javax.swing.JPanel Panel_IzquierdoC;
    private javax.swing.JPanel Panel_Modificar;
    private javax.swing.JPanel Panel_Modificar1;
    private javax.swing.JPanel Panel_ModificarAE;
    private javax.swing.JPanel Panel_ModificarAP;
    private javax.swing.JPanel Panel_ModificarAPP;
    private javax.swing.JPanel Panel_ModificarExpL;
    private javax.swing.JPanel Panel_ModificarExpLD;
    private javax.swing.JPanel Panel_ModificarM2;
    private javax.swing.JPanel Panel_ModificarM3;
    private javax.swing.JPanel Panel_ModificarM4;
    private javax.swing.JPanel Panel_ModificarP;
    private javax.swing.JPanel Panel_ModificarRL;
    private javax.swing.JPanel Panel_ModificarS;
    private javax.swing.JPanel Panel_ModificarSE;
    private javax.swing.JPanel Panel_ModificarTP;
    private javax.swing.JPanel Panel_Modificar_Actividad;
    private javax.swing.JPanel Panel_Modificar_EC;
    private javax.swing.JPanel Panel_Modificar_PP;
    private javax.swing.JPanel Panel_Modificar_PP1;
    private javax.swing.JPanel Panel_Text_Bancos;
    private javax.swing.JPanel Panel_Text_Conta;
    private javax.swing.JPanel Panel_Text_Nomina;
    private javax.swing.JPanel Panel_Text_RRHH;
    private javax.swing.JPanel Puesto;
    private javax.swing.JPanel Puesto1;
    private javax.swing.JPanel RL;
    private javax.swing.JPanel RP;
    private javax.swing.JPanel SE;
    private javax.swing.JLabel SeleccionadoA;
    private javax.swing.JLabel SeleccionadoA1;
    private javax.swing.JLabel SeleccionadoA10;
    private javax.swing.JLabel SeleccionadoA11;
    private javax.swing.JLabel SeleccionadoA12;
    private javax.swing.JLabel SeleccionadoA13;
    private javax.swing.JLabel SeleccionadoA14;
    private javax.swing.JLabel SeleccionadoA15;
    private javax.swing.JLabel SeleccionadoA16;
    private javax.swing.JLabel SeleccionadoA17;
    private javax.swing.JLabel SeleccionadoA18;
    private javax.swing.JLabel SeleccionadoA19;
    private javax.swing.JLabel SeleccionadoA2;
    private javax.swing.JLabel SeleccionadoA3;
    private javax.swing.JLabel SeleccionadoA4;
    private javax.swing.JLabel SeleccionadoA5;
    private javax.swing.JLabel SeleccionadoA6;
    private javax.swing.JLabel SeleccionadoA7;
    private javax.swing.JLabel SeleccionadoA8;
    private javax.swing.JLabel SeleccionadoA9;
    private javax.swing.JPanel Slide;
    private javax.swing.JPanel Slide_Derecho;
    private javax.swing.JPanel TP;
    private javax.swing.JLabel Texto_Bancos;
    private javax.swing.JLabel Texto_Consultar;
    private javax.swing.JLabel Texto_Consultar1;
    private javax.swing.JLabel Texto_ConsultarAE;
    private javax.swing.JLabel Texto_ConsultarAP;
    private javax.swing.JLabel Texto_ConsultarAPP;
    private javax.swing.JLabel Texto_ConsultarExpL;
    private javax.swing.JLabel Texto_ConsultarExpLD;
    private javax.swing.JLabel Texto_ConsultarP;
    private javax.swing.JLabel Texto_ConsultarRL;
    private javax.swing.JLabel Texto_ConsultarS;
    private javax.swing.JLabel Texto_ConsultarSE;
    private javax.swing.JLabel Texto_ConsultarSE2;
    private javax.swing.JLabel Texto_ConsultarSE3;
    private javax.swing.JLabel Texto_ConsultarSE4;
    private javax.swing.JLabel Texto_ConsultarTP;
    private javax.swing.JLabel Texto_Consultar_Actividad;
    private javax.swing.JLabel Texto_Consultar_EC;
    private javax.swing.JLabel Texto_Consultar_PP;
    private javax.swing.JLabel Texto_Consultar_PP1;
    private javax.swing.JLabel Texto_Conta;
    private javax.swing.JLabel Texto_Eliminar;
    private javax.swing.JLabel Texto_Eliminar1;
    private javax.swing.JLabel Texto_EliminarAE;
    private javax.swing.JLabel Texto_EliminarAP;
    private javax.swing.JLabel Texto_EliminarAPP;
    private javax.swing.JLabel Texto_EliminarExpL;
    private javax.swing.JLabel Texto_EliminarExpLD;
    private javax.swing.JLabel Texto_EliminarP;
    private javax.swing.JLabel Texto_EliminarRL;
    private javax.swing.JLabel Texto_EliminarS;
    private javax.swing.JLabel Texto_EliminarSE;
    private javax.swing.JLabel Texto_EliminarSE2;
    private javax.swing.JLabel Texto_EliminarSE3;
    private javax.swing.JLabel Texto_EliminarSE4;
    private javax.swing.JLabel Texto_EliminarTP;
    private javax.swing.JLabel Texto_Eliminar_Actividad;
    private javax.swing.JLabel Texto_Eliminar_EC;
    private javax.swing.JLabel Texto_Eliminar_PP;
    private javax.swing.JLabel Texto_Eliminar_PP1;
    private javax.swing.JLabel Texto_Ingresar;
    private javax.swing.JLabel Texto_Ingresar1;
    private javax.swing.JLabel Texto_IngresarAE;
    private javax.swing.JLabel Texto_IngresarAP;
    private javax.swing.JLabel Texto_IngresarAPP;
    private javax.swing.JLabel Texto_IngresarExpL;
    private javax.swing.JLabel Texto_IngresarExpLD;
    private javax.swing.JLabel Texto_IngresarP;
    private javax.swing.JLabel Texto_IngresarRL;
    private javax.swing.JLabel Texto_IngresarS;
    private javax.swing.JLabel Texto_IngresarSE;
    private javax.swing.JLabel Texto_IngresarSE2;
    private javax.swing.JLabel Texto_IngresarSE3;
    private javax.swing.JLabel Texto_IngresarSE4;
    private javax.swing.JLabel Texto_IngresarTp;
    private javax.swing.JLabel Texto_Ingresar_Actividad;
    private javax.swing.JLabel Texto_Ingresar_EC;
    private javax.swing.JLabel Texto_Ingresar_PP;
    private javax.swing.JLabel Texto_Ingresar_PP1;
    private javax.swing.JLabel Texto_Modificar;
    private javax.swing.JLabel Texto_Modificar1;
    private javax.swing.JLabel Texto_ModificarAE;
    private javax.swing.JLabel Texto_ModificarAP;
    private javax.swing.JLabel Texto_ModificarAPP;
    private javax.swing.JLabel Texto_ModificarExpL;
    private javax.swing.JLabel Texto_ModificarExpLD;
    private javax.swing.JLabel Texto_ModificarP;
    private javax.swing.JLabel Texto_ModificarRL;
    private javax.swing.JLabel Texto_ModificarS;
    private javax.swing.JLabel Texto_ModificarSE;
    private javax.swing.JLabel Texto_ModificarSE2;
    private javax.swing.JLabel Texto_ModificarSE3;
    private javax.swing.JLabel Texto_ModificarSE4;
    private javax.swing.JLabel Texto_Modificar_Actividad;
    private javax.swing.JLabel Texto_Modificar_EC;
    private javax.swing.JLabel Texto_Modificar_PP;
    private javax.swing.JLabel Texto_Modificar_PP1;
    private javax.swing.JLabel Texto_Modificartp;
    private javax.swing.JLabel Texto_Nomina;
    private javax.swing.JLabel Texto_RRHH;
    private javax.swing.JLabel icon_AE;
    private javax.swing.JLabel icon_APP;
    private javax.swing.JLabel icon_Actividad;
    private javax.swing.JLabel icon_Aplicacion;
    private javax.swing.JLabel icon_BE;
    private javax.swing.JLabel icon_CV;
    private javax.swing.JLabel icon_Contratacion;
    private javax.swing.JLabel icon_Departamento;
    private javax.swing.JLabel icon_Departamento1;
    private javax.swing.JLabel icon_EC;
    private javax.swing.JLabel icon_ExpL;
    private javax.swing.JLabel icon_ExpLD;
    private javax.swing.JLabel icon_Medio;
    private javax.swing.JLabel icon_NivelA;
    private javax.swing.JLabel icon_NivelA2;
    private javax.swing.JLabel icon_NivelA3;
    private javax.swing.JLabel icon_PP;
    private javax.swing.JLabel icon_Puesto;
    private javax.swing.JLabel icon_Puesto2;
    private javax.swing.JLabel icon_RL;
    private javax.swing.JLabel icon_RP;
    private javax.swing.JLabel icon_SE;
    private javax.swing.JLabel icon_Seleccion;
    private javax.swing.JLabel icon_TP;
    private javax.swing.JLabel icono_Buscar;
    private javax.swing.JLabel icono_Buscar1;
    private javax.swing.JLabel icono_Buscar2;
    private javax.swing.JLabel icono_Buscar3;
    private javax.swing.JLabel icono_Buscar4;
    private javax.swing.JLabel icono_BuscarSE;
    private javax.swing.JComboBox<String> jComboBox_AE_EC;
    private javax.swing.JComboBox<String> jComboBox_APPS;
    private javax.swing.JComboBox<String> jComboBox_Actividad_AE;
    private javax.swing.JComboBox<String> jComboBox_AplicacionAPP;
    private javax.swing.JComboBox<String> jComboBox_CEC;
    private javax.swing.JComboBox<String> jComboBox_DPIAP;
    private javax.swing.JComboBox<String> jComboBox_DepartamentoSE;
    private javax.swing.JComboBox<String> jComboBox_ECD;
    private javax.swing.JComboBox<String> jComboBox_ECP;
    private javax.swing.JComboBox<String> jComboBox_ELCV;
    private javax.swing.JComboBox<String> jComboBox_ExperienciaL_SE;
    private javax.swing.JComboBox<String> jComboBox_IDSEM;
    private javax.swing.JComboBox<String> jComboBox_MedioCV;
    private javax.swing.JComboBox<String> jComboBox_NivelACV;
    private javax.swing.JComboBox<String> jComboBox_NivelASE;
    private javax.swing.JComboBox<String> jComboBox_Nombre_EpLLD;
    private javax.swing.JComboBox<String> jComboBox_PPA;
    private javax.swing.JComboBox<String> jComboBox_PPC;
    private javax.swing.JComboBox<String> jComboBox_PPS;
    private javax.swing.JComboBox<String> jComboBox_PruebaAPP;
    private javax.swing.JComboBox<String> jComboBox_PuestoSE;
    private javax.swing.JComboBox<String> jComboBox_RLCV;
    private javax.swing.JComboBox<String> jComboBox_RPCV;
    private javax.swing.JComboBox<String> jComboBox_TablasAE;
    private javax.swing.JComboBox<String> jComboBox_TablasAP;
    private javax.swing.JComboBox<String> jComboBox_TablasB_APP;
    private javax.swing.JComboBox<String> jComboBox_TablasB_CV1;
    private javax.swing.JComboBox<String> jComboBox_TablasB_ExpL;
    private javax.swing.JComboBox<String> jComboBox_TablasB_M1;
    private javax.swing.JComboBox<String> jComboBox_TablasB_S;
    private javax.swing.JComboBox<String> jComboBox_TablasB_SE;
    private javax.swing.JComboBox<String> jComboBox_TablasC;
    private javax.swing.JComboBox<String> jComboBox_TablasEC;
    private javax.swing.JComboBox<String> jComboBox_TablasPP;
    private javax.swing.JLabel jLabe_SEC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_AE_EC;
    private javax.swing.JLabel jLabel_AE_ECC;
    private javax.swing.JLabel jLabel_APPS;
    private javax.swing.JLabel jLabel_Actividad_AE;
    private javax.swing.JLabel jLabel_Actividad_AEE;
    private javax.swing.JLabel jLabel_ApellidoCV;
    private javax.swing.JLabel jLabel_AplicacionAPP;
    private javax.swing.JLabel jLabel_Aplicacion_APP;
    private javax.swing.JLabel jLabel_Buscar;
    private javax.swing.JLabel jLabel_BuscarA;
    private javax.swing.JLabel jLabel_BuscarAE;
    private javax.swing.JLabel jLabel_BuscarAP;
    private javax.swing.JLabel jLabel_BuscarEC;
    private javax.swing.JLabel jLabel_BuscarM;
    private javax.swing.JLabel jLabel_BuscarPP;
    private javax.swing.JLabel jLabel_BuscarRL;
    private javax.swing.JLabel jLabel_BuscarS;
    private javax.swing.JLabel jLabel_BuscarTP;
    private javax.swing.JLabel jLabel_Buscar_APP;
    private javax.swing.JLabel jLabel_Buscar_BE;
    private javax.swing.JLabel jLabel_Buscar_C;
    private javax.swing.JLabel jLabel_Buscar_CV;
    private javax.swing.JLabel jLabel_Buscar_ExpL;
    private javax.swing.JLabel jLabel_Buscar_ExpLD;
    private javax.swing.JLabel jLabel_Buscar_NivelA;
    private javax.swing.JLabel jLabel_Buscar_Puesto;
    private javax.swing.JLabel jLabel_Buscar_RP;
    private javax.swing.JLabel jLabel_Buscar_SE;
    private javax.swing.JLabel jLabel_Buscar_Tablas;
    private javax.swing.JLabel jLabel_Buscar_Tablas1;
    private javax.swing.JLabel jLabel_Buscar_TablasAE;
    private javax.swing.JLabel jLabel_Buscar_TablasAPP;
    private javax.swing.JLabel jLabel_Buscar_TablasC;
    private javax.swing.JLabel jLabel_Buscar_TablasEC;
    private javax.swing.JLabel jLabel_Buscar_TablasPP;
    private javax.swing.JLabel jLabel_Buscar_TablasS;
    private javax.swing.JLabel jLabel_Buscar_Tablas_M1;
    private javax.swing.JLabel jLabel_Buscar_Tablas_M2;
    private javax.swing.JLabel jLabel_Buscar_Tablas_SE;
    private javax.swing.JLabel jLabel_CEC;
    private javax.swing.JLabel jLabel_CECC;
    private javax.swing.JLabel jLabel_CorreoCV;
    private javax.swing.JLabel jLabel_Correo_CV;
    private javax.swing.JLabel jLabel_DC;
    private javax.swing.JLabel jLabel_DPIAP;
    private javax.swing.JLabel jLabel_DPIAP1;
    private javax.swing.JLabel jLabel_DPICV;
    private javax.swing.JLabel jLabel_DPI_AP;
    private javax.swing.JLabel jLabel_DepartamentoSE;
    private javax.swing.JLabel jLabel_Departamento_SE;
    private javax.swing.JLabel jLabel_DescripcionA;
    private javax.swing.JLabel jLabel_DescripcionM;
    private javax.swing.JLabel jLabel_DescripcionSE;
    private javax.swing.JLabel jLabel_Descripcion_NivelA;
    private javax.swing.JLabel jLabel_Descripcion_Puesto;
    private javax.swing.JLabel jLabel_Descripcion_Puesto1;
    private javax.swing.JLabel jLabel_DireccionCV;
    private javax.swing.JLabel jLabel_EC;
    private javax.swing.JLabel jLabel_ECD;
    private javax.swing.JLabel jLabel_ECDD;
    private javax.swing.JLabel jLabel_ECP;
    private javax.swing.JLabel jLabel_ECPP;
    private javax.swing.JLabel jLabel_ELCV;
    private javax.swing.JLabel jLabel_EL_CV;
    private javax.swing.JLabel jLabel_EdadCV;
    private javax.swing.JLabel jLabel_EliminarD;
    private javax.swing.JLabel jLabel_EliminarM;
    private javax.swing.JLabel jLabel_EliminarRL;
    private javax.swing.JLabel jLabel_EliminarS;
    private javax.swing.JLabel jLabel_Eliminar_AE;
    private javax.swing.JLabel jLabel_Eliminar_AP;
    private javax.swing.JLabel jLabel_Eliminar_APP;
    private javax.swing.JLabel jLabel_Eliminar_Ac;
    private javax.swing.JLabel jLabel_Eliminar_C;
    private javax.swing.JLabel jLabel_Eliminar_CV;
    private javax.swing.JLabel jLabel_Eliminar_EC;
    private javax.swing.JLabel jLabel_Eliminar_ExpL;
    private javax.swing.JLabel jLabel_Eliminar_ExpLD;
    private javax.swing.JLabel jLabel_Eliminar_NivelA;
    private javax.swing.JLabel jLabel_Eliminar_PP;
    private javax.swing.JLabel jLabel_Eliminar_Puesto;
    private javax.swing.JLabel jLabel_Eliminar_RP;
    private javax.swing.JLabel jLabel_Eliminar_SE;
    private javax.swing.JLabel jLabel_Eliminar_TP;
    private javax.swing.JLabel jLabel_EstatusAPP;
    private javax.swing.JLabel jLabel_EstatusS;
    private javax.swing.JLabel jLabel_Estatus_Departamento;
    private javax.swing.JLabel jLabel_ExperieciaLSE;
    private javax.swing.JLabel jLabel_ExperienciaL_SE;
    private javax.swing.JLabel jLabel_FC;
    private javax.swing.JLabel jLabel_FF;
    private javax.swing.JLabel jLabel_FI;
    private javax.swing.JLabel jLabel_Felcha2;
    private javax.swing.JLabel jLabel_Flecha_Iz1;
    private javax.swing.JLabel jLabel_GeneroCV;
    private javax.swing.JLabel jLabel_IDS;
    private javax.swing.JLabel jLabel_ID_A;
    private javax.swing.JLabel jLabel_ID_AP;
    private javax.swing.JLabel jLabel_ID_APP;
    private javax.swing.JLabel jLabel_ID_C;
    private javax.swing.JLabel jLabel_ID_Departamento;
    private javax.swing.JLabel jLabel_ID_EC;
    private javax.swing.JLabel jLabel_ID_ExpL;
    private javax.swing.JLabel jLabel_ID_ExpLD;
    private javax.swing.JLabel jLabel_ID_ExpLLD;
    private javax.swing.JLabel jLabel_ID_Medio;
    private javax.swing.JLabel jLabel_ID_NivelA;
    private javax.swing.JLabel jLabel_ID_PP;
    private javax.swing.JLabel jLabel_ID_Puesto;
    private javax.swing.JLabel jLabel_ID_RP;
    private javax.swing.JLabel jLabel_ID_ReferenciaL;
    private javax.swing.JLabel jLabel_ID_SEM;
    private javax.swing.JLabel jLabel_ID_SolicitudE1;
    private javax.swing.JLabel jLabel_Ingresar;
    private javax.swing.JLabel jLabel_IngresarAP;
    private javax.swing.JLabel jLabel_IngresarEC;
    private javax.swing.JLabel jLabel_IngresarM;
    private javax.swing.JLabel jLabel_IngresarPP;
    private javax.swing.JLabel jLabel_IngresarRL;
    private javax.swing.JLabel jLabel_IngresarSE;
    private javax.swing.JLabel jLabel_IngresarTP;
    private javax.swing.JLabel jLabel_Ingresar_APP;
    private javax.swing.JLabel jLabel_InsertarC;
    private javax.swing.JLabel jLabel_InsertarS;
    private javax.swing.JLabel jLabel_Insertar_A;
    private javax.swing.JLabel jLabel_Insertar_AE;
    private javax.swing.JLabel jLabel_Insertar_CV;
    private javax.swing.JLabel jLabel_Insertar_ExpL;
    private javax.swing.JLabel jLabel_Insertar_ExpLD;
    private javax.swing.JLabel jLabel_Insertar_NivelA;
    private javax.swing.JLabel jLabel_Insertar_Puesto;
    private javax.swing.JLabel jLabel_Insertar_RP;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel jLabel_MedioCV;
    private javax.swing.JLabel jLabel_Medio_CV;
    private javax.swing.JLabel jLabel_ModificarAPP;
    private javax.swing.JLabel jLabel_ModificarD;
    private javax.swing.JLabel jLabel_ModificarM;
    private javax.swing.JLabel jLabel_ModificarRL;
    private javax.swing.JLabel jLabel_ModificarS;
    private javax.swing.JLabel jLabel_Modificar_AE;
    private javax.swing.JLabel jLabel_Modificar_AP;
    private javax.swing.JLabel jLabel_Modificar_Ac;
    private javax.swing.JLabel jLabel_Modificar_C;
    private javax.swing.JLabel jLabel_Modificar_CV;
    private javax.swing.JLabel jLabel_Modificar_EC;
    private javax.swing.JLabel jLabel_Modificar_ExpL;
    private javax.swing.JLabel jLabel_Modificar_ExpLD;
    private javax.swing.JLabel jLabel_Modificar_NivelA;
    private javax.swing.JLabel jLabel_Modificar_PP;
    private javax.swing.JLabel jLabel_Modificar_Puesto;
    private javax.swing.JLabel jLabel_Modificar_RP;
    private javax.swing.JLabel jLabel_Modificar_SE;
    private javax.swing.JLabel jLabel_Modificar_TP;
    private javax.swing.JLabel jLabel_NivelACV;
    private javax.swing.JLabel jLabel_NivelASE;
    private javax.swing.JLabel jLabel_NivelA_CV;
    private javax.swing.JLabel jLabel_NivelA_SE;
    private javax.swing.JLabel jLabel_NombreAP;
    private javax.swing.JLabel jLabel_NombreCV;
    private javax.swing.JLabel jLabel_NombreD;
    private javax.swing.JLabel jLabel_NombreExpLD;
    private javax.swing.JLabel jLabel_NombreM;
    private javax.swing.JLabel jLabel_NombreRL;
    private javax.swing.JLabel jLabel_NombreSEM;
    private javax.swing.JLabel jLabel_Nombre_EmpresaExpLD;
    private javax.swing.JLabel jLabel_Nombre_NivelA;
    private javax.swing.JLabel jLabel_Nombre_Puesto;
    private javax.swing.JLabel jLabel_Nombre_RP;
    private javax.swing.JLabel jLabel_PPA;
    private javax.swing.JLabel jLabel_PPAA;
    private javax.swing.JLabel jLabel_PPC;
    private javax.swing.JLabel jLabel_PPCC;
    private javax.swing.JLabel jLabel_PPS;
    private javax.swing.JLabel jLabel_PPSE;
    private javax.swing.JLabel jLabel_Pago;
    private javax.swing.JLabel jLabel_Prueba;
    private javax.swing.JLabel jLabel_PruebaAPP;
    private javax.swing.JLabel jLabel_Prueba_APP;
    private javax.swing.JLabel jLabel_PuestoSE;
    private javax.swing.JLabel jLabel_Puesto_SE;
    private javax.swing.JLabel jLabel_RLCV;
    private javax.swing.JLabel jLabel_RL_APPS;
    private javax.swing.JLabel jLabel_RL_CV;
    private javax.swing.JLabel jLabel_RPCV;
    private javax.swing.JLabel jLabel_RP_CV;
    private javax.swing.JLabel jLabel_RangoEdadM;
    private javax.swing.JLabel jLabel_RangoEdadMa;
    private javax.swing.JLabel jLabel_RangoEdadMa1;
    private javax.swing.JLabel jLabel_RequisitosAP;
    private javax.swing.JLabel jLabel_TA;
    private javax.swing.JLabel jLabel_TP;
    private javax.swing.JLabel jLabel_TelefonoCV;
    private javax.swing.JLabel jLabel_TelefonoRL;
    private javax.swing.JLabel jLabel_Telefono_RP;
    private javax.swing.JLabel jLabel_Tiempo_FinalizacionExpLD;
    private javax.swing.JLabel jLabel_Tiempo_InicioExpLD;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_TituloAE;
    private javax.swing.JLabel jLabel_TituloAE1;
    private javax.swing.JLabel jLabel_TituloAP;
    private javax.swing.JLabel jLabel_TituloAPP;
    private javax.swing.JLabel jLabel_TituloAPP1;
    private javax.swing.JLabel jLabel_TituloAPP2;
    private javax.swing.JLabel jLabel_TituloD;
    private javax.swing.JLabel jLabel_TituloD1;
    private javax.swing.JLabel jLabel_TituloD2;
    private javax.swing.JLabel jLabel_TituloEC;
    private javax.swing.JLabel jLabel_TituloELD;
    private javax.swing.JLabel jLabel_TituloELD1;
    private javax.swing.JLabel jLabel_TituloExpL;
    private javax.swing.JLabel jLabel_TituloPP;
    private javax.swing.JLabel jLabel_TituloPP1;
    private javax.swing.JLabel jLabel_TituloRL;
    private javax.swing.JLabel jLabel_TituloSE;
    private javax.swing.JLabel jLabel_TituloSE1;
    private javax.swing.JLabel jLabel_TituloSE2;
    private javax.swing.JLabel jLabel_TituloSE3;
    private javax.swing.JLabel jLabel_id_Nombre_EpLLD;
    private javax.swing.JPanel jPanel_BG;
    private javax.swing.JPanel jPanel_Bienvenido;
    private javax.swing.JPanel jPanel_MantenimientoA;
    private javax.swing.JPanel jPanel_MantenimientoAE;
    private javax.swing.JPanel jPanel_MantenimientoAP;
    private javax.swing.JPanel jPanel_MantenimientoAPP;
    private javax.swing.JPanel jPanel_MantenimientoBE;
    private javax.swing.JPanel jPanel_MantenimientoC;
    private javax.swing.JPanel jPanel_MantenimientoCV;
    private javax.swing.JPanel jPanel_MantenimientoEC;
    private javax.swing.JPanel jPanel_MantenimientoExpL;
    private javax.swing.JPanel jPanel_MantenimientoExpLD;
    private javax.swing.JPanel jPanel_MantenimientoNA;
    private javax.swing.JPanel jPanel_MantenimientoPP;
    private javax.swing.JPanel jPanel_MantenimientoRL;
    private javax.swing.JPanel jPanel_MantenimientoS;
    private javax.swing.JPanel jPanel_MantenimientoSE;
    private javax.swing.JPanel jPanel_Mantenimiento_Medio;
    private javax.swing.JPanel jPanel_MantenimientosP;
    private javax.swing.JPanel jPanel_MantenimientosRP;
    private javax.swing.JPanel jPanel_Tipo_Prueba;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane40;
    private javax.swing.JTextArea jTextArea_DescripcionA;
    private javax.swing.JTextArea jTextArea_DescripcionM;
    private javax.swing.JTextArea jTextArea_DescripcionSE;
    private javax.swing.JTextField jTextField_Encontraid;
    private javax.swing.JLabel lbl_BuscarS;
    private javax.swing.JTable tbl_A;
    private javax.swing.JTable tbl_AE;
    private javax.swing.JTable tbl_AP;
    private javax.swing.JTable tbl_APP;
    private javax.swing.JTable tbl_BE;
    private javax.swing.JTable tbl_C;
    private javax.swing.JTable tbl_CV;
    private javax.swing.JTable tbl_Departamento;
    private javax.swing.JTable tbl_EC;
    private javax.swing.JTable tbl_ExpL;
    private javax.swing.JTable tbl_ExpLD;
    private javax.swing.JTable tbl_Medio;
    private javax.swing.JTable tbl_NivelA;
    private javax.swing.JTable tbl_PP;
    private javax.swing.JTable tbl_Puesto;
    private javax.swing.JTable tbl_RL;
    private javax.swing.JTable tbl_RP;
    private javax.swing.JTable tbl_S;
    private javax.swing.JTable tbl_SE;
    private javax.swing.JTable tbl_TP;
    private javax.swing.JTextField txt_ApellidoCV;
    private javax.swing.JTextField txt_AplicacionAPP;
    private javax.swing.JTextField txt_Buscar;
    private javax.swing.JTextField txt_BuscarA;
    private javax.swing.JTextField txt_BuscarAE;
    private javax.swing.JTextField txt_BuscarAP;
    private javax.swing.JTextField txt_BuscarEC;
    private javax.swing.JTextField txt_BuscarM;
    private javax.swing.JTextField txt_BuscarPP;
    private javax.swing.JTextField txt_BuscarRL;
    private javax.swing.JTextField txt_BuscarS;
    private javax.swing.JTextField txt_BuscarTP;
    private javax.swing.JTextField txt_Buscar_APP;
    private javax.swing.JTextField txt_Buscar_BE;
    private javax.swing.JTextField txt_Buscar_C;
    private javax.swing.JTextField txt_Buscar_CV;
    private javax.swing.JTextField txt_Buscar_ExpL;
    private javax.swing.JTextField txt_Buscar_ExpLD;
    private javax.swing.JTextField txt_Buscar_NivelA;
    private javax.swing.JTextField txt_Buscar_Puesto;
    private javax.swing.JTextField txt_Buscar_RP;
    private javax.swing.JTextField txt_Buscar_SE;
    private javax.swing.JTextField txt_CorreoCV;
    private javax.swing.JTextField txt_DC;
    private javax.swing.JTextField txt_DPICV;
    private javax.swing.JTextField txt_Descripcion_NivelA;
    private javax.swing.JTextArea txt_Descripcion_Puesto;
    private javax.swing.JTextField txt_DireccionCV;
    private javax.swing.JTextField txt_EC;
    private javax.swing.JTextField txt_EdadCV;
    private javax.swing.JTextField txt_EstatusS;
    private javax.swing.JTextField txt_Estatus_Departamento;
    private javax.swing.JTextField txt_Estatus_Puesto;
    private javax.swing.JTextField txt_FC;
    private javax.swing.JTextField txt_Genero;
    private javax.swing.JTextField txt_GeneroCV;
    private javax.swing.JTextField txt_NombreCV;
    private javax.swing.JTextField txt_NombreExpLD;
    private javax.swing.JTextField txt_NombreM;
    private javax.swing.JTextField txt_NombreRL;
    private javax.swing.JTextField txt_Nombre_Departamento;
    private javax.swing.JTextField txt_Nombre_EmpresaExpLD;
    private javax.swing.JTextField txt_Nombre_NivelA;
    private javax.swing.JTextField txt_Nombre_Puesto;
    private javax.swing.JTextField txt_Nombre_RP;
    private javax.swing.JTextField txt_RangoEdadM;
    private javax.swing.JTextField txt_RangoEdadMa;
    private javax.swing.JTextField txt_RequisitosAP;
    private javax.swing.JTextField txt_SEC;
    private javax.swing.JTextField txt_TA;
    private javax.swing.JTextField txt_TP;
    private javax.swing.JTextField txt_TelefonoCV;
    private javax.swing.JTextField txt_TelefonoRL;
    private javax.swing.JTextField txt_Telefono_RP;
    private javax.swing.JTextField txt_Tiempo_FinalizacionExpLD;
    private javax.swing.JTextField txt_Tiempo_InicioExpLD;
    private javax.swing.JTextField txt_ap;
    private javax.swing.JTextField txt_contra;
    private javax.swing.JTextField txt_depa;
    private javax.swing.JTextField txt_dpi;
    private javax.swing.JTextField txt_idS;
    private javax.swing.JTextField txt_id_A;
    private javax.swing.JTextField txt_id_AP;
    private javax.swing.JTextField txt_id_APP;
    private javax.swing.JTextField txt_id_C;
    private javax.swing.JTextField txt_id_Departamento;
    private javax.swing.JTextField txt_id_EC;
    private javax.swing.JTextField txt_id_ExpL;
    private javax.swing.JTextField txt_id_ExpLD;
    private javax.swing.JTextField txt_id_FF;
    private javax.swing.JTextField txt_id_FI;
    private javax.swing.JTextField txt_id_Medio;
    private javax.swing.JTextField txt_id_NivelA;
    private javax.swing.JTextField txt_id_PP;
    private javax.swing.JTextField txt_id_Pago;
    private javax.swing.JTextField txt_id_Puesto;
    private javax.swing.JTextField txt_id_RP;
    private javax.swing.JTextField txt_id_ReferenciaL;
    private javax.swing.JTextField txt_id_SolicitudE;
    private javax.swing.JTextField txt_id_TP;
    private javax.swing.JTextField txt_idap;
    private javax.swing.JTextField txt_peri;
    private javax.swing.JTextField txt_puesto;
    private javax.swing.JTextField txt_selec;
    // End of variables declaration//GEN-END:variables
}
