/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas;

import Animaciones.Animaciones;
import AppPackage.AnimationClass;
import Clases_Nomina.Concepto_Planilla;
import Clases_Nomina.Planilla_Detalle;
import Clases_Nomina.Planilla_General;
import static Finanzas_Clases.Departamento.Base_de_Datos;
import static Finanzas_Clases.Departamento.Clave;
import static Finanzas_Clases.Departamento.Usuario;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Langas
 */
public class Nomina extends javax.swing.JFrame {

    /**
     * Creates new form Nomina2
     */
    int x, y;

    //Items para obetener el texto de los ComboBox
    public static String TipoCP = "";
    public static String ClaseCP = "";
    public static String AplicacionCP = "";

    //Nombres para ComboBox Tipo Concepto
    public static String Porcentaje = "Porcentaje";
    public static String Cuota = "Cuota";
    public static String Monto = "Monto";

    //Nombres para ComboBox Clase Concepto
    public static String Deduccion = "Deduccion";
    public static String Percepcion = "Percepcion";
    public static String Nada = "";

    //Nombres para ComboBox Aplicacion Concepto
    public static String Todos = "Todos";
    public static String Rango = "Rango";
    public static String Unico = "Unico";

    //Rangos para asignar Conceptos
    public static int RangoMenor = 0;
    public static int RangoMayor = 0;
    public static int I_Unico = 0;

    //Valores en ceros Para planilla General
    public static String TotalP = "0";
    public static String TotalD = "0";
    public static String TotalL = "0";

    //Strings para obtener valor de Deduccion - Percepcion - Liquido
    public static String S_Deduccion = "";
    public static String S_Percepcion = "";
    public static String S_Liquido = "";

    //Flotantes para obtener valor de Deduccion - Percepcion - Liquido
    public static float f_Deduccion;
    public static float f_Percepcion;
    public static float f_Liquido;

    //Flotantes para sumas Deduccion - Percepcion - Liquido
    public static float sumaT;
    public static float sumaA;
    public static String S_Valor = "";
    public static float Valor;

    public static float sumaTP;
    public static float sumaAP;
    public static String S_ValorPP = "";
    public static float ValorP;

    //Suledo Empleado
    public static String S_Sueldo = "";
    public static float f_Sueldo = 0;

    //Sumas Principio del Programa
    public static float I_SueldoD;
    public static float I_SueldoP;

    //Vector de datos Conceptos - PD
    String[] Concepto = new String[5];
    String[] PDE = new String[5];
    String[] Datos_ISR = new String[5];

    //Totales de Percepcion
    public static String S_TotalP = "";
    public static float f_TotalP;

    //Modificar Planilla Detalle - General
    public static String S_VC = "";
    public static float f_VC;
    public static String id_C = "";
    public static String NombreC = "";
    public static String id_ISR = "";

    public Nomina() {
        initComponents();

        txt_ValorCP.setEnabled(false);

        //Escondiendo Mantenimientos
        MantenimientoCP.setVisible(false);

        //Rango Menor para nor ver desde el inicio
        jLabel_RMenorCP.setVisible(false);
        txt_RMenorCP.setVisible(false);

        //Rango Mayor para nor ver desde el inicio
        jLabel_RMayorCP.setVisible(false);
        txt_RMayorCP.setVisible(false);

        //Escondiendo ID Empledo
        jLabel_IDUCP.setVisible(false);
        txt_IDUCP.setVisible(false);

        //Utilizados para poder modificar los Rangos
        Modificar_Rangos.setVisible(false);
        jButton_MDR.setVisible(false);
        txt_IDUCP1.setVisible(false);
        jButton_MDU.setVisible(false);
        txt_RMayorCP2.setVisible(false);
        txt_RMenorCP2.setVisible(false);
        Modificar_IDU.setVisible(false);
        MantenimientoPDG.setVisible(false);
        jLabel_ModificarCP.setVisible(false);
        jLabel_EliminarCP.setVisible(false);

        //Para que el usuario no pueda interacturar con textfield de Planilla Detalle
        txt_IDR.setEnabled(false);
        jLabel_IDU.setVisible(false);
        jLabel_IDR.setVisible(false);
        

        int cantidad_CP = 0;
        int cantidad_PD = 0;
        int cantidad_PG = 0;


        ConceptoPlanilla.setVisible(true);
        Planilla_DetalleG.setVisible(true);
        Planilla_DetalleG.setVisible(true);

        Concepto_Planilla CP = new Concepto_Planilla(txt_IDCP, txt_NombreCP, TipoCP, ClaseCP, txt_ValorCP, AplicacionCP, txt_BuscarCP, tbl_CP, jComboBox_TipoCP, jComboBox_ClaseCP, jComboBox_AplicacionCP);
        cantidad_CP += CP.Cantidad_Registros();

        Planilla_Detalle PD = new Planilla_Detalle(txt_ID_PD, txt_IDPD, jComboBox_IDCP, jLabel_id_IDCP, txt_VCP, cbDeduccion, cbPercepcion, jButton_Igss, jLabel_ISR, txt_Buscar_PD, tbl_PD);
        cantidad_PD += PD.Cantidad_Registros();

        Planilla_General PG = new Planilla_General(txt_IDPD, TotalP, TotalD, TotalL, txt_Buscar_PG, tbl_PG);
        cantidad_PG += PG.Cantidad_Registros();

        

        Cant_R2.setText("" + cantidad_CP);
        Cant_R4.setText("" + cantidad_PD);
        Cant_R3.setText("" + cantidad_PG);
        
        jButton_Igss.setVisible(false);
        jLabel_ISR.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MantenimientoPDG = new javax.swing.JPanel();
        jLabel_Titulo1 = new javax.swing.JLabel();
        jLabel_IDR = new javax.swing.JLabel();
        txt_IDR = new javax.swing.JTextField();
        jLabel_IDPD = new javax.swing.JLabel();
        txt_IDPD = new javax.swing.JTextField();
        jLabel_IDCP = new javax.swing.JLabel();
        jComboBox_IDCP = new javax.swing.JComboBox<>();
        jLabel_id_IDCP = new javax.swing.JLabel();
        jLabel_VCP = new javax.swing.JLabel();
        txt_VCP = new javax.swing.JTextField();
        jButton_Igss = new javax.swing.JButton();
        txt_Buscar_PD = new javax.swing.JTextField();
        jLabel_Buscar_PD = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        tbl_PD = new javax.swing.JTable();
        cbDeduccion = new javax.swing.JCheckBox();
        cbPercepcion = new javax.swing.JCheckBox();
        jLabel_Buscar_PG = new javax.swing.JLabel();
        txt_Buscar_PG = new javax.swing.JTextField();
        jScrollPane27 = new javax.swing.JScrollPane();
        tbl_PG = new javax.swing.JTable();
        jLabel_IngresarPDG = new javax.swing.JLabel();
        jLabel_ModificarPDG = new javax.swing.JLabel();
        jLabel_EliminarPDG = new javax.swing.JLabel();
        jLabel_ISR = new javax.swing.JLabel();
        jLabel_IDU = new javax.swing.JLabel();
        jLabel_ID_PD = new javax.swing.JLabel();
        txt_ID_PD = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Modificar_IDU = new javax.swing.JPanel();
        Movimiento1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Titulo_IDU = new javax.swing.JLabel();
        jLabel_IDUCP1 = new javax.swing.JLabel();
        txt_IDUCP2 = new javax.swing.JTextField();
        txt_RMenorCP2 = new javax.swing.JTextField();
        txt_RMayorCP2 = new javax.swing.JTextField();
        jLabel_MIDU = new javax.swing.JLabel();
        Modificar_Rangos = new javax.swing.JPanel();
        jLabel_Titulo_MDR = new javax.swing.JLabel();
        jLabel_RMenorCP1 = new javax.swing.JLabel();
        txt_RMenorCP1 = new javax.swing.JTextField();
        jLabel_RMayorCP1 = new javax.swing.JLabel();
        txt_RMayorCP1 = new javax.swing.JTextField();
        txt_IDUCP1 = new javax.swing.JTextField();
        jLabel_MDR = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MantenimientoCP = new javax.swing.JPanel();
        jLabel_Titulo = new javax.swing.JLabel();
        jLabel_ID_ExpL = new javax.swing.JLabel();
        txt_IDCP = new javax.swing.JTextField();
        jLabel_NombreCP = new javax.swing.JLabel();
        txt_NombreCP = new javax.swing.JTextField();
        jLabel_TipoCP = new javax.swing.JLabel();
        jComboBox_TipoCP = new javax.swing.JComboBox<>();
        jLabel_Tipo_CP = new javax.swing.JLabel();
        jLabel_ClaseCP = new javax.swing.JLabel();
        jComboBox_ClaseCP = new javax.swing.JComboBox<>();
        jLabel_Clase_CP = new javax.swing.JLabel();
        jLabel_ValorCP = new javax.swing.JLabel();
        txt_ValorCP = new javax.swing.JTextField();
        jLabel_AplicacionCP = new javax.swing.JLabel();
        jComboBox_AplicacionCP = new javax.swing.JComboBox<>();
        jLabel_RMenorCP = new javax.swing.JLabel();
        txt_RMenorCP = new javax.swing.JTextField();
        jLabel_RMayorCP = new javax.swing.JLabel();
        txt_RMayorCP = new javax.swing.JTextField();
        jLabel_IDUCP = new javax.swing.JLabel();
        txt_IDUCP = new javax.swing.JTextField();
        jScrollPane25 = new javax.swing.JScrollPane();
        tbl_CP = new javax.swing.JTable();
        jLabel_Buscar_CP = new javax.swing.JLabel();
        txt_BuscarCP = new javax.swing.JTextField();
        jButton_MDU = new javax.swing.JButton();
        jButton_MDR = new javax.swing.JButton();
        jLabel_IngresarCP = new javax.swing.JLabel();
        jLabel_ModificarCP = new javax.swing.JLabel();
        jLabel_EliminarCP = new javax.swing.JLabel();
        jLabel_IngresarAplicacion = new javax.swing.JLabel();
        Panel_IngresarCP = new javax.swing.JPanel();
        Texto_IngresarCP = new javax.swing.JLabel();
        Panel_ModificarCP = new javax.swing.JPanel();
        Texto_ModificarCP = new javax.swing.JLabel();
        Panel_EliminarCP = new javax.swing.JPanel();
        Texto_EliminarPD = new javax.swing.JLabel();
        Panel_ConsultarCP = new javax.swing.JPanel();
        Texto_ConsultarCP = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
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
        jLabel_Titulo2 = new javax.swing.JLabel();
        ConceptoPlanilla = new javax.swing.JPanel();
        SeleccionadoA1 = new javax.swing.JLabel();
        Cant_R2 = new javax.swing.JLabel();
        icon_ConceptoPlanilla = new javax.swing.JLabel();
        Planilla_DetalleG = new javax.swing.JPanel();
        SeleccionadoA = new javax.swing.JLabel();
        Cant_R3 = new javax.swing.JLabel();
        Cant_R4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        icon_Planilla_DetalleG = new javax.swing.JLabel();
        esquis = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MantenimientoPDG.setBackground(new java.awt.Color(28, 27, 33));
        MantenimientoPDG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo1.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel_Titulo1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_Titulo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Planilla Detalle - General.png"))); // NOI18N
        MantenimientoPDG.add(jLabel_Titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 400, 120));

        jLabel_IDR.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IDR.setText("ID Rangos");
        MantenimientoPDG.add(jLabel_IDR, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, -1, -1));

        txt_IDR.setBackground(new java.awt.Color(40, 41, 46));
        txt_IDR.setForeground(new java.awt.Color(153, 153, 153));
        txt_IDR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_IDR.setBorder(null);
        txt_IDR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDRActionPerformed(evt);
            }
        });
        MantenimientoPDG.add(txt_IDR, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 180, 20));

        jLabel_IDPD.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IDPD.setText("ID Planilla General");
        MantenimientoPDG.add(jLabel_IDPD, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 350, -1, -1));

        txt_IDPD.setBackground(new java.awt.Color(40, 41, 46));
        txt_IDPD.setForeground(new java.awt.Color(153, 153, 153));
        txt_IDPD.setBorder(null);
        txt_IDPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDPDActionPerformed(evt);
            }
        });
        MantenimientoPDG.add(txt_IDPD, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 180, 20));

        jLabel_IDCP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IDCP.setText("Concepto Planilla");
        MantenimientoPDG.add(jLabel_IDCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, -1, -1));

        jComboBox_IDCP.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_IDCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_IDCPActionPerformed(evt);
            }
        });
        MantenimientoPDG.add(jComboBox_IDCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 170, -1));

        jLabel_id_IDCP.setForeground(new java.awt.Color(0, 0, 0));
        MantenimientoPDG.add(jLabel_id_IDCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 40, 20));

        jLabel_VCP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_VCP.setText("Valor Concepto ");
        MantenimientoPDG.add(jLabel_VCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        txt_VCP.setBackground(new java.awt.Color(40, 41, 46));
        txt_VCP.setForeground(new java.awt.Color(153, 153, 153));
        txt_VCP.setBorder(null);
        txt_VCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_VCPActionPerformed(evt);
            }
        });
        MantenimientoPDG.add(txt_VCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 180, 20));

        jButton_Igss.setBackground(new java.awt.Color(0, 204, 204));
        jButton_Igss.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_Igss.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Igss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bancos.png"))); // NOI18N
        jButton_Igss.setBorder(null);
        jButton_Igss.setBorderPainted(false);
        jButton_Igss.setContentAreaFilled(false);
        jButton_Igss.setFocusable(false);
        jButton_Igss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_IgssActionPerformed(evt);
            }
        });
        MantenimientoPDG.add(jButton_Igss, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 110, 30));

        txt_Buscar_PD.setBackground(new java.awt.Color(40, 41, 46));
        txt_Buscar_PD.setForeground(new java.awt.Color(153, 153, 153));
        txt_Buscar_PD.setBorder(null);
        txt_Buscar_PD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Buscar_PDActionPerformed(evt);
            }
        });
        txt_Buscar_PD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Buscar_PDKeyReleased(evt);
            }
        });
        MantenimientoPDG.add(txt_Buscar_PD, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 290, 20));

        jLabel_Buscar_PD.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_PD.setText("Buscar");
        MantenimientoPDG.add(jLabel_Buscar_PD, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, -1, -1));

        tbl_PD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_PD.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_PD.setSelectionBackground(new java.awt.Color(40, 41, 46));
        tbl_PD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_PDMouseClicked(evt);
            }
        });
        jScrollPane26.setViewportView(tbl_PD);

        MantenimientoPDG.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 490, 190));

        cbDeduccion.setBackground(new java.awt.Color(28, 27, 33));
        cbDeduccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbDeduccion.setForeground(new java.awt.Color(153, 153, 153));
        cbDeduccion.setText("Deduccion");
        cbDeduccion.setFocusable(false);
        cbDeduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDeduccionActionPerformed(evt);
            }
        });
        MantenimientoPDG.add(cbDeduccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 100, -1));

        cbPercepcion.setBackground(new java.awt.Color(28, 27, 33));
        cbPercepcion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbPercepcion.setForeground(new java.awt.Color(153, 153, 153));
        cbPercepcion.setSelected(true);
        cbPercepcion.setText("Percepcion");
        cbPercepcion.setFocusable(false);
        cbPercepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPercepcionActionPerformed(evt);
            }
        });
        MantenimientoPDG.add(cbPercepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 230, 100, -1));

        jLabel_Buscar_PG.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_PG.setText("Buscar");
        MantenimientoPDG.add(jLabel_Buscar_PG, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, -1, -1));

        txt_Buscar_PG.setBackground(new java.awt.Color(40, 41, 46));
        txt_Buscar_PG.setForeground(new java.awt.Color(153, 153, 153));
        txt_Buscar_PG.setBorder(null);
        txt_Buscar_PG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Buscar_PGActionPerformed(evt);
            }
        });
        txt_Buscar_PG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Buscar_PGKeyReleased(evt);
            }
        });
        MantenimientoPDG.add(txt_Buscar_PG, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 450, 290, 20));

        tbl_PG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_PG.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_PG.setSelectionBackground(new java.awt.Color(40, 41, 46));
        tbl_PG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_PGMouseClicked(evt);
            }
        });
        jScrollPane27.setViewportView(tbl_PG);

        MantenimientoPDG.add(jScrollPane27, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, 520, 190));

        jLabel_IngresarPDG.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IngresarPDG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_IngresarPDG.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_IngresarPDG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_IngresarPDGMouseClicked(evt);
            }
        });
        MantenimientoPDG.add(jLabel_IngresarPDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 220, 50, 50));

        jLabel_ModificarPDG.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ModificarPDG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_ModificarPDG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_ModificarPDGMouseClicked(evt);
            }
        });
        MantenimientoPDG.add(jLabel_ModificarPDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 220, 50, 50));

        jLabel_EliminarPDG.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_EliminarPDG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_EliminarPDG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EliminarPDGMouseClicked(evt);
            }
        });
        MantenimientoPDG.add(jLabel_EliminarPDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 220, 50, 50));

        jLabel_ISR.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ISR.setText("ISR");
        MantenimientoPDG.add(jLabel_ISR, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, -1, -1));

        jLabel_IDU.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IDU.setText("ID Unico");
        MantenimientoPDG.add(jLabel_IDU, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        jLabel_ID_PD.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_PD.setText("ID Planilla Detalle");
        MantenimientoPDG.add(jLabel_ID_PD, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        txt_ID_PD.setBackground(new java.awt.Color(40, 41, 46));
        txt_ID_PD.setForeground(new java.awt.Color(153, 153, 153));
        txt_ID_PD.setBorder(null);
        txt_ID_PD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ID_PDActionPerformed(evt);
            }
        });
        MantenimientoPDG.add(txt_ID_PD, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 90, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        MantenimientoPDG.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 450, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        MantenimientoPDG.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Eliminar");
        MantenimientoPDG.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 280, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar");
        MantenimientoPDG.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 280, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Modificar");
        MantenimientoPDG.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 280, -1, -1));

        getContentPane().add(MantenimientoPDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1670, 720));

        Modificar_IDU.setBackground(new java.awt.Color(28, 27, 33));
        Modificar_IDU.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Movimiento1.setBackground(new java.awt.Color(28, 27, 33));
        Movimiento1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Movimiento1MouseDragged(evt);
            }
        });
        Movimiento1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Movimiento1MousePressed(evt);
            }
        });
        Movimiento1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        Movimiento1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 20, 30));

        Modificar_IDU.add(Movimiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1090, 40));

        jLabel_Titulo_IDU.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel_Titulo_IDU.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo_IDU.setText("Modificar ID Unico");
        Modificar_IDU.add(jLabel_Titulo_IDU, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, 40));

        jLabel_IDUCP1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IDUCP1.setText("ID Unico");
        Modificar_IDU.add(jLabel_IDUCP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, -1, -1));

        txt_IDUCP2.setBackground(new java.awt.Color(40, 41, 46));
        txt_IDUCP2.setForeground(new java.awt.Color(153, 153, 153));
        txt_IDUCP2.setBorder(null);
        txt_IDUCP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDUCP2ActionPerformed(evt);
            }
        });
        Modificar_IDU.add(txt_IDUCP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 170, 20));

        txt_RMenorCP2.setBackground(new java.awt.Color(40, 41, 46));
        txt_RMenorCP2.setForeground(new java.awt.Color(153, 153, 153));
        txt_RMenorCP2.setBorder(null);
        txt_RMenorCP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RMenorCP2ActionPerformed(evt);
            }
        });
        Modificar_IDU.add(txt_RMenorCP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 170, 20));

        txt_RMayorCP2.setBackground(new java.awt.Color(40, 41, 46));
        txt_RMayorCP2.setForeground(new java.awt.Color(153, 153, 153));
        txt_RMayorCP2.setBorder(null);
        txt_RMayorCP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RMayorCP2ActionPerformed(evt);
            }
        });
        Modificar_IDU.add(txt_RMayorCP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 170, 20));

        jLabel_MIDU.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MIDU.setText("Modificar");
        jLabel_MIDU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MIDUMouseClicked(evt);
            }
        });
        Modificar_IDU.add(jLabel_MIDU, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, -1, -1));

        getContentPane().add(Modificar_IDU, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1078, 1078));

        Modificar_Rangos.setBackground(new java.awt.Color(28, 27, 33));
        Modificar_Rangos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo_MDR.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel_Titulo_MDR.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo_MDR.setText("Modificar Rangos");
        Modificar_Rangos.add(jLabel_Titulo_MDR, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, -1, 40));

        jLabel_RMenorCP1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_RMenorCP1.setText("Rango Menor");
        Modificar_Rangos.add(jLabel_RMenorCP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, -1));

        txt_RMenorCP1.setBackground(new java.awt.Color(40, 41, 46));
        txt_RMenorCP1.setForeground(new java.awt.Color(153, 153, 153));
        txt_RMenorCP1.setBorder(null);
        txt_RMenorCP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RMenorCP1ActionPerformed(evt);
            }
        });
        Modificar_Rangos.add(txt_RMenorCP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 170, 20));

        jLabel_RMayorCP1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_RMayorCP1.setText("Rango Mayor");
        Modificar_Rangos.add(jLabel_RMayorCP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, -1, -1));

        txt_RMayorCP1.setBackground(new java.awt.Color(40, 41, 46));
        txt_RMayorCP1.setForeground(new java.awt.Color(153, 153, 153));
        txt_RMayorCP1.setBorder(null);
        txt_RMayorCP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RMayorCP1ActionPerformed(evt);
            }
        });
        Modificar_Rangos.add(txt_RMayorCP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 170, 20));

        txt_IDUCP1.setBackground(new java.awt.Color(40, 41, 46));
        txt_IDUCP1.setForeground(new java.awt.Color(153, 153, 153));
        txt_IDUCP1.setBorder(null);
        txt_IDUCP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDUCP1ActionPerformed(evt);
            }
        });
        Modificar_Rangos.add(txt_IDUCP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 170, 20));

        jLabel_MDR.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MDR.setText("Modificar");
        jLabel_MDR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MDRMouseClicked(evt);
            }
        });
        Modificar_Rangos.add(jLabel_MDR, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 470, -1, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        Modificar_Rangos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 20, 30));

        getContentPane().add(Modificar_Rangos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1078, 720));

        MantenimientoCP.setBackground(new java.awt.Color(28, 27, 33));
        MantenimientoCP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Concepto Planilla.png"))); // NOI18N
        MantenimientoCP.add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 400, 120));

        jLabel_ID_ExpL.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_ExpL.setText("ID Concepto Planilla");
        MantenimientoCP.add(jLabel_ID_ExpL, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        txt_IDCP.setBackground(new java.awt.Color(40, 41, 46));
        txt_IDCP.setForeground(new java.awt.Color(153, 153, 153));
        txt_IDCP.setBorder(null);
        txt_IDCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDCPActionPerformed(evt);
            }
        });
        MantenimientoCP.add(txt_IDCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 170, 20));

        jLabel_NombreCP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreCP.setText("Nombre Concepto Planilla");
        MantenimientoCP.add(jLabel_NombreCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, -1, -1));

        txt_NombreCP.setBackground(new java.awt.Color(40, 41, 46));
        txt_NombreCP.setForeground(new java.awt.Color(153, 153, 153));
        txt_NombreCP.setBorder(null);
        txt_NombreCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreCPActionPerformed(evt);
            }
        });
        MantenimientoCP.add(txt_NombreCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 170, 20));

        jLabel_TipoCP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_TipoCP.setText("Tipo Concepto");
        MantenimientoCP.add(jLabel_TipoCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, -1, -1));

        jComboBox_TipoCP.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_TipoCP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_TipoCPItemStateChanged(evt);
            }
        });
        jComboBox_TipoCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TipoCPActionPerformed(evt);
            }
        });
        MantenimientoCP.add(jComboBox_TipoCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 170, -1));

        jLabel_Tipo_CP.setForeground(new java.awt.Color(0, 0, 0));
        MantenimientoCP.add(jLabel_Tipo_CP, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 350, 40, 20));

        jLabel_ClaseCP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ClaseCP.setText("Clase Concepto");
        MantenimientoCP.add(jLabel_ClaseCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 320, -1, -1));

        jComboBox_ClaseCP.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_ClaseCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ClaseCPActionPerformed(evt);
            }
        });
        MantenimientoCP.add(jComboBox_ClaseCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 350, 170, -1));

        jLabel_Clase_CP.setForeground(new java.awt.Color(0, 0, 0));
        MantenimientoCP.add(jLabel_Clase_CP, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 370, 40, 20));

        jLabel_ValorCP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ValorCP.setText("Valor Concepto");
        MantenimientoCP.add(jLabel_ValorCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, -1, -1));

        txt_ValorCP.setBackground(new java.awt.Color(40, 41, 46));
        txt_ValorCP.setForeground(new java.awt.Color(153, 153, 153));
        txt_ValorCP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ValorCP.setText("0");
        txt_ValorCP.setBorder(null);
        txt_ValorCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ValorCPActionPerformed(evt);
            }
        });
        MantenimientoCP.add(txt_ValorCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 170, 20));

        jLabel_AplicacionCP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_AplicacionCP.setText("Aplicacion Concepto");
        MantenimientoCP.add(jLabel_AplicacionCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, -1, -1));

        jComboBox_AplicacionCP.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_AplicacionCP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_AplicacionCPItemStateChanged(evt);
            }
        });
        jComboBox_AplicacionCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_AplicacionCPActionPerformed(evt);
            }
        });
        MantenimientoCP.add(jComboBox_AplicacionCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 170, -1));

        jLabel_RMenorCP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_RMenorCP.setText("Rango Menor");
        MantenimientoCP.add(jLabel_RMenorCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, -1, -1));

        txt_RMenorCP.setBackground(new java.awt.Color(40, 41, 46));
        txt_RMenorCP.setForeground(new java.awt.Color(153, 153, 153));
        txt_RMenorCP.setBorder(null);
        txt_RMenorCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RMenorCPActionPerformed(evt);
            }
        });
        MantenimientoCP.add(txt_RMenorCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 170, 20));

        jLabel_RMayorCP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_RMayorCP.setText("Rango Mayor");
        MantenimientoCP.add(jLabel_RMayorCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 400, -1, -1));

        txt_RMayorCP.setBackground(new java.awt.Color(40, 41, 46));
        txt_RMayorCP.setForeground(new java.awt.Color(153, 153, 153));
        txt_RMayorCP.setBorder(null);
        txt_RMayorCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RMayorCPActionPerformed(evt);
            }
        });
        MantenimientoCP.add(txt_RMayorCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 430, 170, 20));

        jLabel_IDUCP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IDUCP.setText("ID Unico");
        MantenimientoCP.add(jLabel_IDUCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, -1, -1));

        txt_IDUCP.setBackground(new java.awt.Color(40, 41, 46));
        txt_IDUCP.setForeground(new java.awt.Color(153, 153, 153));
        txt_IDUCP.setBorder(null);
        txt_IDUCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDUCPActionPerformed(evt);
            }
        });
        MantenimientoCP.add(txt_IDUCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 170, 20));

        tbl_CP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_CP.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_CP.setSelectionBackground(new java.awt.Color(40, 41, 46));
        tbl_CP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CPMouseClicked(evt);
            }
        });
        jScrollPane25.setViewportView(tbl_CP);

        MantenimientoCP.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 600, 600, 180));

        jLabel_Buscar_CP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_CP.setText("Buscar");
        MantenimientoCP.add(jLabel_Buscar_CP, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 540, -1, -1));

        txt_BuscarCP.setBackground(new java.awt.Color(40, 41, 46));
        txt_BuscarCP.setForeground(new java.awt.Color(153, 153, 153));
        txt_BuscarCP.setBorder(null);
        txt_BuscarCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarCPActionPerformed(evt);
            }
        });
        txt_BuscarCP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_BuscarCPKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarCPKeyReleased(evt);
            }
        });
        MantenimientoCP.add(txt_BuscarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 540, 290, 20));

        jButton_MDU.setBackground(new java.awt.Color(28, 27, 33));
        jButton_MDU.setForeground(new java.awt.Color(255, 255, 255));
        jButton_MDU.setText("Modificar ID Unico");
        jButton_MDU.setBorder(null);
        jButton_MDU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MDUActionPerformed(evt);
            }
        });
        MantenimientoCP.add(jButton_MDU, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 680, -1, 20));

        jButton_MDR.setBackground(new java.awt.Color(28, 27, 33));
        jButton_MDR.setForeground(new java.awt.Color(255, 255, 255));
        jButton_MDR.setText("Modificar Rangos");
        jButton_MDR.setBorder(null);
        jButton_MDR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MDRActionPerformed(evt);
            }
        });
        MantenimientoCP.add(jButton_MDR, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 680, -1, -1));

        jLabel_IngresarCP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IngresarCP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_IngresarCP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_IngresarCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_IngresarCPMouseClicked(evt);
            }
        });
        MantenimientoCP.add(jLabel_IngresarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 520, 50, 50));

        jLabel_ModificarCP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ModificarCP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_ModificarCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_ModificarCPMouseClicked(evt);
            }
        });
        MantenimientoCP.add(jLabel_ModificarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 520, 50, 50));

        jLabel_EliminarCP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_EliminarCP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_EliminarCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EliminarCPMouseClicked(evt);
            }
        });
        MantenimientoCP.add(jLabel_EliminarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 520, 50, 50));

        jLabel_IngresarAplicacion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IngresarAplicacion.setText("Ingresar Aplicacion");
        jLabel_IngresarAplicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_IngresarAplicacionMouseClicked(evt);
            }
        });
        MantenimientoCP.add(jLabel_IngresarAplicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, -1, -1));

        Panel_IngresarCP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_IngresarCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_IngresarCPMouseClicked(evt);
            }
        });
        Panel_IngresarCP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_IngresarCP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_IngresarCP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_IngresarCP.setText("Ingresar");
        Texto_IngresarCP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_IngresarCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_IngresarCPMouseClicked(evt);
            }
        });
        Panel_IngresarCP.add(Texto_IngresarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        MantenimientoCP.add(Panel_IngresarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 130, 50));

        Panel_ModificarCP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ModificarCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ModificarCPMouseClicked(evt);
            }
        });
        Panel_ModificarCP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ModificarCP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ModificarCP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ModificarCP.setText("Modificar");
        Texto_ModificarCP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ModificarCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ModificarCPMouseClicked(evt);
            }
        });
        Panel_ModificarCP.add(Texto_ModificarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        MantenimientoCP.add(Panel_ModificarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 130, 50));

        Panel_EliminarCP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_EliminarCP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_EliminarPD.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_EliminarPD.setForeground(new java.awt.Color(255, 255, 255));
        Texto_EliminarPD.setText("Eliminar");
        Texto_EliminarPD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_EliminarPD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_EliminarPDMouseClicked(evt);
            }
        });
        Panel_EliminarCP.add(Texto_EliminarPD, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        MantenimientoCP.add(Panel_EliminarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 130, 50));

        Panel_ConsultarCP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ConsultarCP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ConsultarCP.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ConsultarCP.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ConsultarCP.setText("Consultar");
        Texto_ConsultarCP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ConsultarCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ConsultarCPMouseClicked(evt);
            }
        });
        Panel_ConsultarCP.add(Texto_ConsultarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        MantenimientoCP.add(Panel_ConsultarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 130, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        MantenimientoCP.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, -1, -1));

        getContentPane().add(MantenimientoCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1080, 720));

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
        Icono_Conta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Icono_ContaMouseClicked(evt);
            }
        });
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
        Icono_Bancos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Icono_BancosMouseClicked(evt);
            }
        });
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
        Icono_Nomina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Icono_NominaMouseClicked(evt);
            }
        });
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

        jLabel_Titulo2.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel_Titulo2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo2.setText("Mantenimientos Nomina");
        jPanel_BG.add(jLabel_Titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 240, 40));

        ConceptoPlanilla.setBackground(new java.awt.Color(28, 27, 33));
        ConceptoPlanilla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ConceptoPlanilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConceptoPlanillaMouseClicked(evt);
            }
        });
        ConceptoPlanilla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeleccionadoA1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        ConceptoPlanilla.add(SeleccionadoA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 10, 40));

        Cant_R2.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R2.setForeground(new java.awt.Color(255, 255, 255));
        ConceptoPlanilla.add(Cant_R2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 158, 20, 20));

        icon_ConceptoPlanilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Concepto Planilla.png"))); // NOI18N
        icon_ConceptoPlanilla.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_ConceptoPlanillaMouseMoved(evt);
            }
        });
        icon_ConceptoPlanilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_ConceptoPlanillaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_ConceptoPlanillaMouseExited(evt);
            }
        });
        ConceptoPlanilla.add(icon_ConceptoPlanilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 180));

        jPanel_BG.add(ConceptoPlanilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 220, 180));

        Planilla_DetalleG.setBackground(new java.awt.Color(28, 27, 33));
        Planilla_DetalleG.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Planilla_DetalleG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Planilla_DetalleGMouseExited(evt);
            }
        });
        Planilla_DetalleG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeleccionadoA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seleccionado.png"))); // NOI18N
        SeleccionadoA.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                SeleccionadoAMouseMoved(evt);
            }
        });
        Planilla_DetalleG.add(SeleccionadoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 10, 40));

        Cant_R3.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R3.setForeground(new java.awt.Color(255, 255, 255));
        Planilla_DetalleG.add(Cant_R3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 158, 20, 20));

        Cant_R4.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        Cant_R4.setForeground(new java.awt.Color(255, 255, 255));
        Planilla_DetalleG.add(Cant_R4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 158, 20, 20));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("-");
        Planilla_DetalleG.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 160, -1, -1));

        icon_Planilla_DetalleG.setFont(new java.awt.Font("Open Sans SemiBold", 1, 12)); // NOI18N
        icon_Planilla_DetalleG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Planilla Detalle - General.png"))); // NOI18N
        icon_Planilla_DetalleG.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_Planilla_DetalleGMouseMoved(evt);
            }
        });
        icon_Planilla_DetalleG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_Planilla_DetalleGMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_Planilla_DetalleGMouseExited(evt);
            }
        });
        Planilla_DetalleG.add(icon_Planilla_DetalleG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 180));

        jPanel_BG.add(Planilla_DetalleG, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 220, 180));

        esquis.setBackground(new java.awt.Color(232, 16, 34));
        esquis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        esquis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                esquisMouseClicked(evt);
            }
        });
        esquis.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/equis.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        esquis.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, -1, -1));

        jPanel_BG.add(esquis, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 40, 30));

        getContentPane().add(jPanel_BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_IDCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDCPActionPerformed

    private void txt_NombreCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreCPActionPerformed

    private void jComboBox_TipoCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TipoCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TipoCPActionPerformed

    private void jComboBox_ClaseCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ClaseCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_ClaseCPActionPerformed

    private void txt_ValorCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ValorCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ValorCPActionPerformed

    private void jComboBox_AplicacionCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_AplicacionCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_AplicacionCPActionPerformed

    private void txt_RMenorCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RMenorCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RMenorCPActionPerformed

    private void txt_RMayorCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RMayorCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RMayorCPActionPerformed

    private void txt_IDUCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDUCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDUCPActionPerformed

    private void tbl_CPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CPMouseClicked
        // TODO add your handling code here:

        int CP = tbl_CP.rowAtPoint(evt.getPoint());
        txt_IDCP.setText(String.valueOf(tbl_CP.getValueAt(CP, 0)));
        txt_NombreCP.setText(String.valueOf(tbl_CP.getValueAt(CP, 1)));
    }//GEN-LAST:event_tbl_CPMouseClicked

    private void txt_BuscarCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarCPActionPerformed

    private void txt_BuscarCPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarCPKeyReleased
        // TODO add your handling code here:
        Concepto_Planilla CP = new Concepto_Planilla(txt_IDCP, txt_NombreCP, TipoCP, ClaseCP, txt_ValorCP, AplicacionCP, txt_BuscarCP, tbl_CP, jComboBox_TipoCP, jComboBox_ClaseCP, jComboBox_AplicacionCP);
        CP.Buscar_CPF(txt_BuscarCP.getText());
    }//GEN-LAST:event_txt_BuscarCPKeyReleased

    private void jButton_MDUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MDUActionPerformed
        // TODO add your handling code here:
        jButton_MDU.setVisible(false);
        MantenimientoCP.setVisible(false);
        Modificar_IDU.setVisible(true);
    }//GEN-LAST:event_jButton_MDUActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Modificar_Rangos.setVisible(false);
        MantenimientoCP.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_RMenorCP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RMenorCP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RMenorCP1ActionPerformed

    private void txt_RMayorCP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RMayorCP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RMayorCP1ActionPerformed

    private void txt_IDUCP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDUCP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDUCP1ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        Modificar_IDU.setVisible(false);
        MantenimientoCP.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void Movimiento1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Movimiento1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Movimiento1MouseDragged

    private void Movimiento1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Movimiento1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Movimiento1MousePressed

    private void txt_IDUCP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDUCP2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDUCP2ActionPerformed

    private void txt_RMenorCP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RMenorCP2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RMenorCP2ActionPerformed

    private void txt_RMayorCP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RMayorCP2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RMayorCP2ActionPerformed

    private void txt_BuscarCPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarCPKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarCPKeyPressed

    private void jLabel_IngresarCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_IngresarCPMouseClicked
        // TODO add your handling code here:

        Concepto_Planilla CP = new Concepto_Planilla(txt_IDCP, txt_NombreCP, TipoCP, ClaseCP, txt_ValorCP, AplicacionCP, txt_BuscarCP, tbl_CP, jComboBox_TipoCP, jComboBox_ClaseCP, jComboBox_AplicacionCP);
        CP.Insertar_CP();
    }

    private void jLabel_InsertarCPMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:


    }//GEN-LAST:event_jLabel_IngresarCPMouseClicked

    private void jLabel_ModificarCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ModificarCPMouseClicked
        // TODO add your handling code here:
        Concepto_Planilla CP = new Concepto_Planilla(txt_IDCP, txt_NombreCP, TipoCP, ClaseCP, txt_ValorCP, AplicacionCP, txt_BuscarCP, tbl_CP, jComboBox_TipoCP, jComboBox_ClaseCP, jComboBox_AplicacionCP);
        CP.Modificar_CP();
    }//GEN-LAST:event_jLabel_ModificarCPMouseClicked

    private void jLabel_EliminarCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EliminarCPMouseClicked
        // TODO add your handling code here:
        Concepto_Planilla CP = new Concepto_Planilla(txt_IDCP, txt_NombreCP, TipoCP, ClaseCP, txt_ValorCP, AplicacionCP, txt_BuscarCP, tbl_CP, jComboBox_TipoCP, jComboBox_ClaseCP, jComboBox_AplicacionCP);
        CP.Eliminar_CP();
    }//GEN-LAST:event_jLabel_EliminarCPMouseClicked

    private void jComboBox_AplicacionCPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_AplicacionCPItemStateChanged
        // TODO add your handling code here:
        AplicacionCP = jComboBox_AplicacionCP.getSelectedItem().toString();

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (AplicacionCP == Todos) {
                jLabel_RMenorCP.setVisible(false);
                txt_RMenorCP.setVisible(false);

                jLabel_RMayorCP.setVisible(false);
                txt_RMayorCP.setVisible(false);

                jLabel_IDUCP.setVisible(false);
                txt_IDUCP.setVisible(false);
            } else if (AplicacionCP == Rango) {
                jLabel_RMenorCP.setVisible(true);
                txt_RMenorCP.setVisible(true);

                jLabel_RMayorCP.setVisible(true);
                txt_RMayorCP.setVisible(true);

                jLabel_IDUCP.setVisible(false);
                txt_IDUCP.setVisible(false);
            } else if (AplicacionCP == Unico) {
                jLabel_RMenorCP.setVisible(false);
                txt_RMenorCP.setVisible(false);

                jLabel_RMayorCP.setVisible(false);
                txt_RMayorCP.setVisible(false);

                jLabel_IDUCP.setVisible(true);
                txt_IDUCP.setVisible(true);
            }
        }
    }//GEN-LAST:event_jComboBox_AplicacionCPItemStateChanged

    private void jLabel_MDRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MDRMouseClicked
        // TODO add your handling code here:
        String Rango_Menor;
        String Rango_Mayor;
        String S_Unico;

        RangoMenor = 0;
        RangoMayor = 0;
        I_Unico = 0;

        Rango_Menor = txt_RMenorCP1.getText();
        Rango_Mayor = txt_RMayorCP1.getText();
        S_Unico = txt_IDUCP1.getText();

        if (Rango_Menor.equalsIgnoreCase("")) {
            RangoMenor = 0;
            RangoMayor = 0;

            System.out.println("Modificado");
        } else if (S_Unico.equalsIgnoreCase("")) {
            RangoMenor = Integer.parseInt(Rango_Menor.trim());
            RangoMayor = Integer.parseInt(Rango_Mayor.trim());
            I_Unico = 0;

            System.out.println("Modificado");
        }

        if (RangoMenor >= 0 && RangoMayor >= 0 && I_Unico >= 0) {
            //CP.Vaciando_TextField(txt_RangoMenorCP,txt_RangoMayorCP,txt_IDEmpleadoCP);
        }
    }//GEN-LAST:event_jLabel_MDRMouseClicked

    private void jButton_MDRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MDRActionPerformed
        // TODO add your handling code here:
        jButton_MDR.setVisible(false);
        MantenimientoCP.setVisible(false);
        Modificar_Rangos.setVisible(true);
    }//GEN-LAST:event_jButton_MDRActionPerformed

    private void jLabel_MIDUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MIDUMouseClicked
        // TODO add your handling code here:
        String Rango_Menor;
        String Rango_Mayor;
        String S_Unico;

        RangoMenor = 0;
        RangoMayor = 0;
        I_Unico = 0;

        Rango_Menor = txt_RMenorCP2.getText();
        Rango_Mayor = txt_RMayorCP2.getText();
        S_Unico = txt_IDUCP2.getText();

        if (Rango_Menor.equalsIgnoreCase("")) {

            RangoMenor = 0;
            RangoMayor = 0;
            I_Unico = Integer.parseInt(S_Unico.trim());

            System.out.println("Modificado");
        } else if (S_Unico.equalsIgnoreCase("")) {
            RangoMenor = Integer.parseInt(Rango_Menor.trim());
            RangoMayor = Integer.parseInt(Rango_Mayor.trim());
            I_Unico = 0;

            System.out.println("Modificado");
        }

        if (RangoMenor >= 0 && RangoMayor >= 0 && I_Unico >= 0) {
            //CP.Vaciando_TextField(txt_RangoMenorCP,txt_RangoMayorCP,txt_IDEmpleadoCP);
        }
    }//GEN-LAST:event_jLabel_MIDUMouseClicked

    private void txt_IDRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDRActionPerformed

    private void txt_IDPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDPDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDPDActionPerformed

    private void jComboBox_IDCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_IDCPActionPerformed
        // TODO add your handling code here:
        Planilla_Detalle PD = new Planilla_Detalle(txt_ID_PD, txt_IDPD, jComboBox_IDCP, jLabel_id_IDCP, txt_VCP, cbDeduccion, cbPercepcion, jButton_Igss, jLabel_ISR, txt_Buscar_PD, tbl_PD);
        PD.EncontrarID_PD("id_conceptoPlanilla", "concepto_planilla", "nombre_concepto", jComboBox_IDCP);
    }//GEN-LAST:event_jComboBox_IDCPActionPerformed

    private void txt_VCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_VCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_VCPActionPerformed

    private void txt_Buscar_PDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Buscar_PDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Buscar_PDActionPerformed

    private void txt_Buscar_PDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Buscar_PDKeyReleased
        // TODO add your handling code here:
        Planilla_Detalle PD = new Planilla_Detalle(txt_ID_PD, txt_IDPD, jComboBox_IDCP, jLabel_id_IDCP, txt_VCP, cbDeduccion, cbPercepcion, jButton_Igss, jLabel_ISR, txt_Buscar_PD, tbl_PD);
        PD.Buscar_PDF(txt_Buscar_PD.getText());

    }//GEN-LAST:event_txt_Buscar_PDKeyReleased

    private void tbl_PDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_PDMouseClicked
        // TODO add your handling code here:
        int Seleccion = tbl_PD.rowAtPoint(evt.getPoint());
        txt_ID_PD.setText(String.valueOf(tbl_PD.getValueAt(Seleccion, 0)));
        txt_IDR.setText(String.valueOf(tbl_PD.getValueAt(Seleccion, 2)));
        jLabel_id_IDCP.setText(String.valueOf(tbl_PD.getValueAt(Seleccion, 3)));
        txt_VCP.setText(String.valueOf(tbl_PD.getValueAt(Seleccion, 4)));
        txt_Buscar_PD.setText(String.valueOf(tbl_PD.getValueAt(Seleccion, 0)));
        txt_IDPD.setText(String.valueOf(tbl_PD.getValueAt(Seleccion, 1)));
        txt_Buscar_PG.setText(String.valueOf(tbl_PD.getValueAt(Seleccion, 1)));

        Planilla_Detalle PD = new Planilla_Detalle(txt_ID_PD, txt_IDPD, jComboBox_IDCP, jLabel_id_IDCP, txt_VCP, cbDeduccion, cbPercepcion, jButton_Igss, jLabel_ISR, txt_Buscar_PD, tbl_PD);
        PD.BuscarFila_PD("nombre_concepto", "concepto_planilla", "id_conceptoPlanilla", jComboBox_IDCP, jLabel_id_IDCP);

        if (ValidarC() == true) {
            cbPercepcion.setSelected(true);
            cbDeduccion.setSelected(false);
        } else {
            cbPercepcion.setSelected(false);
            cbDeduccion.setSelected(true);
        }

    }//GEN-LAST:event_tbl_PDMouseClicked

    private void cbDeduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDeduccionActionPerformed
        if (cbDeduccion.isSelected()) {
            cbPercepcion.setSelected(false);
        }
    }//GEN-LAST:event_cbDeduccionActionPerformed

    private void cbPercepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPercepcionActionPerformed
        if (cbPercepcion.isSelected()) {
            cbDeduccion.setSelected(false);
        }

    }//GEN-LAST:event_cbPercepcionActionPerformed

    private void txt_Buscar_PGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Buscar_PGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Buscar_PGActionPerformed

    private void txt_Buscar_PGKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Buscar_PGKeyReleased
        // TODO add your handling code here:
        Planilla_General PG = new Planilla_General(txt_IDPD, TotalP, TotalD, TotalL, txt_Buscar_PG, tbl_PG);
        PG.Buscar_PGF(txt_Buscar_PG.getText());
    }//GEN-LAST:event_txt_Buscar_PGKeyReleased

    private void tbl_PGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_PGMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_PGMouseClicked

    private void jLabel_IngresarAplicacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_IngresarAplicacionMouseClicked
        // TODO add your handling code here:

        String Rango_Menor;
        String Rango_Mayor;
        String S_Unico;

        RangoMenor = 0;
        RangoMayor = 0;
        I_Unico = 0;

        Rango_Menor = txt_RMenorCP.getText();
        Rango_Mayor = txt_RMayorCP.getText();
        S_Unico = txt_IDUCP.getText();

        Concepto_Planilla CP = new Concepto_Planilla(txt_IDCP, txt_NombreCP, TipoCP, ClaseCP, txt_ValorCP, AplicacionCP, txt_BuscarCP, tbl_CP, jComboBox_TipoCP, jComboBox_ClaseCP, jComboBox_AplicacionCP);

        if (Rango_Menor.equalsIgnoreCase("")) {
            RangoMenor = 0;
            RangoMayor = 0;
            I_Unico = Integer.parseInt(S_Unico.trim());

            jButton_MDU.setVisible(true);
        } else if (S_Unico.equalsIgnoreCase("")) {
            RangoMenor = Integer.parseInt(Rango_Menor.trim());
            RangoMayor = Integer.parseInt(Rango_Mayor.trim());
            I_Unico = 0;

            jButton_MDR.setVisible(true);
        }

        if (RangoMenor >= 0 && RangoMayor >= 0 && I_Unico >= 0) {
            CP.Vaciando_TextField(txt_RMenorCP, txt_RMayorCP, txt_IDUCP);
        }
    }//GEN-LAST:event_jLabel_IngresarAplicacionMouseClicked

    private void jLabel_IngresarPDGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_IngresarPDGMouseClicked
        // TODO add your handling code here:
        float SueldoE = 0;
        float f_TotalP = 0;
        sumaA = 0;
        sumaT = 0;
        sumaAP = 0;
        sumaTP = 0;

        String IDPG = "";

        Datos_CP();

        Planilla_General PG = new Planilla_General(txt_IDPD, String.valueOf(sumaAP), String.valueOf(sumaA), TotalL, txt_Buscar_PG, tbl_PG);
        Planilla_Detalle PD = new Planilla_Detalle(txt_ID_PD, txt_IDPD, jComboBox_IDCP, jLabel_id_IDCP, txt_VCP, cbDeduccion, cbPercepcion, jButton_Igss, jLabel_ISR, txt_Buscar_PD, tbl_PD);

        if (PG.Encontrar_IDPG() == false) {
            PG.Insertar_PG();
            PD.Insertar_PD(PD.Cantidad_Registros(), RangoMenor, RangoMayor, I_Unico);

            if (cbPercepcion.isSelected()) {

                sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");
                sumaTP = PD.SumaT_DPL(S_ValorPP, txt_VCP, ValorP, sumaAP, sumaTP, txt_IDPD, RangoMenor, RangoMayor, I_Unico, cbPercepcion);

                sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");

                PG.Modificar_PG(sumaA, sumaTP, (sumaTP - sumaA));
            } else if (cbDeduccion.isSelected()) {

                if (Concepto[2].equals("Porcentaje")) {
                    System.out.println("Es " + Concepto[2]);
                    ConceptoP(Concepto[1], Float.parseFloat(Concepto[4]));
                } else {
                    System.out.println("No es Porcentaje");
                    sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");
                    sumaT = PD.SumaT_DPL(S_Valor, txt_VCP, Valor, sumaA, sumaT, txt_IDPD, RangoMenor, RangoMayor, I_Unico, cbDeduccion);

                    sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");
                }

                PG.Modificar_PG(sumaT, sumaAP, (sumaAP - sumaT));
            }

        } else {
            PD.Insertar_PD(PD.Cantidad_Registros(), RangoMenor, RangoMayor, I_Unico);

            if (cbPercepcion.isSelected()) {
                sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");
                sumaTP = PD.SumaT_DPL(S_ValorPP, txt_VCP, ValorP, sumaAP, sumaTP, txt_IDPD, RangoMenor, RangoMayor, I_Unico, cbPercepcion);

                sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");

                PG.Modificar_PG(sumaA, sumaTP, (sumaTP - sumaA));
            } else if (cbDeduccion.isSelected()) {
                if (Concepto[2].equals("Porcentaje")) {
                    System.out.println("Es " + Concepto[2]);
                    ConceptoP(Concepto[1], Float.parseFloat(Concepto[4]));
                } else {
                    sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");
                    sumaT = PD.SumaT_DPL(S_Valor, txt_VCP, Valor, sumaA, sumaT, txt_IDPD, RangoMenor, RangoMayor, I_Unico, cbDeduccion);

                    sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");
                }

                PG.Modificar_PG(sumaT, sumaAP, (sumaAP - sumaT));
            }

        }

        /*Planilla_General PG = new Planilla_General(txt_IDPD,String.valueOf(sumaAP),String.valueOf(sumaA),TotalL,txt_Buscar_PG,tbl_PG);
        PG.Insertar_PG(sumaA,sumaAP);
        
        Planilla_Detalle PD = new Planilla_Detalle(txt_IDPD,jComboBox_IDCP,jLabel_id_IDCP,txt_VCP,cbDeduccion,cbPercepcion,jButton_Igss,jLabel_ISR,txt_Buscar_PD,tbl_PD);
        PD.Encontrar_DPL(S_Deduccion,f_Deduccion,"total_deduccion");
        int cantidadPD = PD.Cantidad_Registros();
        //PD.Insertar_PD(cantidadPD,RangoMenor,RangoMayor,I_Unico);
        
        if(jComboBox_IDCP.getSelectedItem().toString().equals("IGGS"))
        {
            if(RangoMenor > 0 && RangoMayor > 0)
            {
                for(int j = RangoMenor; j<=RangoMayor; j++)
                {
                    
                        SueldoE = PD.Impuesto_PG(S_Sueldo,f_Sueldo,j) * (0.0483f);
                        System.out.println(SueldoE);
                        txt_VCP.setText(String.valueOf(SueldoE));
                        
                        sumaA = PD.Encontrar_DPL(S_Deduccion,f_Deduccion,"total_deduccion");
                        sumaT = PD.SumaT_DPL(S_Valor,txt_VCP,Valor,sumaA,sumaT,txt_IDPD,0,0,j,cbDeduccion);
                        
                        sumaAP = PD.Encontrar_DPL(S_Percepcion,f_Percepcion,"total_percepcion");
                        sumaTP = PD.SumaT_DPL(S_ValorPP,txt_VCP,ValorP,sumaAP,sumaTP,txt_IDPD,0,0,j,cbPercepcion);
                        
                        
                        PD.Insertar_PD(cantidadPD,0,0,j);
                        
                    
                        
                }        
            }
            else if(I_Unico > 0)
            {
                
                        SueldoE = PD.Impuesto_PG(S_Sueldo,f_Sueldo,I_Unico) * (0.0483f);
                        System.out.println(SueldoE);
                        txt_VCP.setText(String.valueOf(SueldoE));
                        
                        sumaA = PD.Encontrar_DPL(S_Deduccion,f_Deduccion,"total_deduccion");
                        sumaT = PD.SumaT_DPL(S_Valor,txt_VCP,Valor,sumaA,sumaT,txt_IDPD,RangoMenor,RangoMayor,I_Unico,cbDeduccion);
                        
                        sumaAP = PD.Encontrar_DPL(S_Percepcion,f_Percepcion,"total_percepcion");
                        sumaTP = PD.SumaT_DPL(S_ValorPP,txt_VCP,ValorP,sumaAP,sumaTP,txt_IDPD,RangoMenor,RangoMayor,I_Unico,cbPercepcion);
                      
                        PD.Insertar_PD(cantidadPD,RangoMenor,RangoMayor,I_Unico);
                        
                       
                    
            }
        }
        else
        {
           
                sumaA = PD.Encontrar_DPL(S_Deduccion,f_Deduccion,"total_deduccion");
                sumaT = PD.SumaT_DPL(S_Valor,txt_VCP,Valor,sumaA,sumaT,txt_IDPD,RangoMenor,RangoMayor,I_Unico,cbDeduccion);
            
            
                sumaAP = PD.Encontrar_DPL(S_Percepcion,f_Percepcion,"total_percepcion");
                sumaTP = PD.SumaT_DPL(S_ValorPP,txt_VCP,ValorP,sumaAP,sumaTP,txt_IDPD,RangoMenor,RangoMayor,I_Unico,cbPercepcion); 
                
                PD.Insertar_PD(cantidadPD,RangoMenor,RangoMayor,I_Unico); 
            
            
        }
        
                
            
            
                         
            //PD.Insertar_PD(cantidadPD,RangoMenor,RangoMayor,I_Unico);
        
            System.out.println("Es" + sumaT);
            System.out.println("Es" +sumaTP);
            PG.Modificar_PG(sumaT, sumaTP, (sumaTP - sumaT) );*/

    }//GEN-LAST:event_jLabel_IngresarPDGMouseClicked

    private void jLabel_ModificarPDGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ModificarPDGMouseClicked

        f_VC = 0;
        float fVC = 0;
        float fVCD = 0;
        float sumaAP = 0;
        float restaVC = 0;
        float restaVCD = 0;
        sumaA = 0;
        boolean Encontrado = ValidarC();

        Datos_CP();
        
        //Datos_CP();
        Planilla_Detalle PD = new Planilla_Detalle(txt_ID_PD, txt_IDPD, jComboBox_IDCP, jLabel_id_IDCP, txt_VCP, cbDeduccion, cbPercepcion, jButton_Igss, jLabel_ISR, txt_Buscar_PD, tbl_PD);
        Planilla_General PG = new Planilla_General(txt_IDPD, String.valueOf(sumaAP), String.valueOf(sumaA), TotalL, txt_Buscar_PG, tbl_PG);

        if ((Encontrado == true && cbPercepcion.isSelected()) || (Encontrado == false && cbDeduccion.isSelected())) {
            if (cbPercepcion.isSelected()) {
                fVC = PD.Encontrar_VC(S_VC, f_VC, "valor_conceptoDet", "planilla_det", "id_planillaDe");
                sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");

                restaVC = (sumaAP - fVC) + Float.parseFloat(txt_VCP.getText());

                sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");

                PD.Modificar_PD(RangoMenor, RangoMayor, I_Unico);
                PG.Modificar_PG(sumaA, restaVC, (restaVC - sumaA));

            } else if (cbDeduccion.isSelected()) {
                if (Concepto[2].equals("Porcentaje")) {
                    JOptionPane.showMessageDialog(null, "El concepto de Tipo porcentaje Depende de una Percepcion");
                } else {
                    fVCD = PD.Encontrar_VC(S_VC, f_VC, "valor_conceptoDet", "planilla_det", "id_planillaDe");
                    sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");

                    restaVCD = (sumaA - fVCD) + Float.parseFloat(txt_VCP.getText());

                    sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");

                    PD.Modificar_PD(RangoMenor, RangoMayor, I_Unico);
                    PG.Modificar_PG(restaVCD, sumaAP, (sumaAP - restaVCD));
                }
            }

            if (Encontrado == true) {
                if (Datos_IDPD() == true) 
                {
                   Modificar_PDISR();
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Imposible realizar modificacion, no se puede pasar un Percepcion a Deduccion ni viseversa");
        }

    }//GEN-LAST:event_jLabel_ModificarPDGMouseClicked

    private void jLabel_EliminarPDGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EliminarPDGMouseClicked
        // TODO add your handling code here:
        sumaAP = 0;
        float Valor = 0;
        float resta = 0;
        String S_ID = txt_Buscar_PD.getText();
        
        Planilla_Detalle PD = new Planilla_Detalle(txt_ID_PD, txt_IDPD, jComboBox_IDCP, jLabel_id_IDCP, txt_VCP, cbDeduccion, cbPercepcion, jButton_Igss, jLabel_ISR, txt_Buscar_PD, tbl_PD);
        Planilla_General PG = new Planilla_General(txt_IDPD, TotalP, TotalD, TotalL, txt_Buscar_PG, tbl_PG);
        
        if(cbPercepcion.isSelected())
        {
            sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");
            
            Valor = Float.parseFloat(txt_VCP.getText());
            
            resta = (sumaAP - Valor);
            
            sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");

            PG.Modificar_PG(sumaA, resta, (resta - sumaA));
            
        }
        else if(cbDeduccion.isSelected())
        {
            sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");
            
            Valor = Float.parseFloat(txt_VCP.getText());
            
            resta = (sumaA - Valor);
            
            sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");

            PG.Modificar_PG(resta, sumaAP, (sumaAP - resta));
        }
        
        if (Datos_IDPD() == true) 
        {
            sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");
            
            Valor = Float.parseFloat(Datos_ISR[4]);
            
            resta = (sumaA - Valor);
            
            sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");

            PG.Modificar_PG(resta, sumaAP, (sumaAP - resta));

            PD.Eliminar_PD(Datos_ISR[0]);
        }

        PD.Eliminar_PD(S_ID);
        
        if(Ningun_PD() == false)
        {
            PG.Eliminar_PG();
        }
        
            JOptionPane.showMessageDialog(null,"Ya que Elimino una Percepcion es necesario volver a Ingresar ISR");
    }//GEN-LAST:event_jLabel_EliminarPDGMouseClicked

    private void jComboBox_TipoCPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_TipoCPItemStateChanged
        // TODO add your handling code here:
        if (jComboBox_TipoCP.getSelectedItem().toString().equals("Porcentaje")) {
            txt_ValorCP.setEnabled(true);
        } else {
            txt_ValorCP.setEnabled(false);
            txt_ValorCP.setText("0");
        }
    }//GEN-LAST:event_jComboBox_TipoCPItemStateChanged

    private void jButton_IgssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_IgssActionPerformed

    }//GEN-LAST:event_jButton_IgssActionPerformed

    private void txt_ID_PDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ID_PDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ID_PDActionPerformed

    private void Icono_ContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Icono_ContaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_Icono_ContaMouseClicked

    private void Panel_Icono_ContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Icono_ContaMouseClicked
        // TODO add your handling code here:
        setColor_PanelI(Panel_Icono_Conta);
        resetColor_PanelI(Panel_Icono_RRHH);
        resetColor_PanelI(Panel_Icono_Nomina);
        resetColor_PanelI(Panel_Icono_Bancos);
    }//GEN-LAST:event_Panel_Icono_ContaMouseClicked

    private void Icono_BancosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Icono_BancosMouseClicked
        // TODO add your handling code here:
        this.dispose();
        Bancos ban= new Bancos();
        ban.setVisible(true);
    }//GEN-LAST:event_Icono_BancosMouseClicked

    private void Panel_Icono_BancosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Icono_BancosMouseClicked
        // TODO add your handling code here:
        setColor_PanelI(Panel_Icono_Bancos);
        resetColor_PanelI(Panel_Icono_RRHH);
        resetColor_PanelI(Panel_Icono_Nomina);
        resetColor_PanelI(Panel_Icono_Conta);

        this.dispose();
        Bancos ban= new Bancos();
        ban.setVisible(true);
    }//GEN-LAST:event_Panel_Icono_BancosMouseClicked

    private void Icono_NominaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Icono_NominaMouseClicked
        // TODO add your handling code here:
        this.dispose();
        Nomina n= new Nomina();
        n.setVisible(true);
    }//GEN-LAST:event_Icono_NominaMouseClicked

    private void Panel_Icono_NominaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Icono_NominaMouseClicked
        // TODO add your handling code here:
        setColor_PanelI(Panel_Icono_Nomina);
        resetColor_PanelI(Panel_Icono_RRHH);
        resetColor_PanelI(Panel_Icono_Conta);
        resetColor_PanelI(Panel_Icono_Bancos);

        this.dispose();
        Nomina n= new Nomina();
        n.setVisible(true);
    }//GEN-LAST:event_Panel_Icono_NominaMouseClicked

    private void Icono_RRHHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Icono_RRHHMouseClicked

        this.dispose();
        
        Principal P = new Principal();
        P.setVisible(true);
        
        int cantidad_CP = 0;
        int cantidad_PD = 0;
        int cantidad_PG = 0;


        ConceptoPlanilla.setVisible(true);
        Planilla_DetalleG.setVisible(true);
        Planilla_DetalleG.setVisible(true);



        setColor_PanelI(Panel_Icono_RRHH);
        resetColor_PanelI(Panel_Icono_Nomina);
        resetColor_PanelI(Panel_Icono_Conta);
        resetColor_PanelI(Panel_Icono_Bancos);

        Concepto_Planilla CP = new Concepto_Planilla(txt_IDCP, txt_NombreCP, TipoCP, ClaseCP, txt_ValorCP, AplicacionCP, txt_BuscarCP, tbl_CP, jComboBox_TipoCP, jComboBox_ClaseCP, jComboBox_AplicacionCP);
        cantidad_CP += CP.Cantidad_Registros();

        Planilla_Detalle PD = new Planilla_Detalle(txt_ID_PD, txt_IDPD, jComboBox_IDCP, jLabel_id_IDCP, txt_VCP, cbDeduccion, cbPercepcion, jButton_Igss, jLabel_ISR, txt_Buscar_PD, tbl_PD);
        cantidad_PD += PD.Cantidad_Registros();

        Planilla_General PG = new Planilla_General(txt_IDPD, TotalP, TotalD, TotalL, txt_Buscar_PG, tbl_PG);
        cantidad_PG += PG.Cantidad_Registros();

        

        Cant_R2.setText("" + cantidad_CP);
        Cant_R4.setText("" + cantidad_PD);
        Cant_R3.setText("" + cantidad_PG);
    }//GEN-LAST:event_Icono_RRHHMouseClicked

    private void Icono_RRHHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Icono_RRHHMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Icono_RRHHMouseEntered

    private void Panel_Icono_RRHHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Icono_RRHHMouseClicked

        Principal P = new Principal();
        P.setVisible(true);
        
        int cantidad_CP = 0;
        int cantidad_PD = 0;
        int cantidad_PG = 0;


        ConceptoPlanilla.setVisible(true);
        Planilla_DetalleG.setVisible(true);
        Planilla_DetalleG.setVisible(true);



        setColor_PanelI(Panel_Icono_RRHH);
        resetColor_PanelI(Panel_Icono_Nomina);
        resetColor_PanelI(Panel_Icono_Conta);
        resetColor_PanelI(Panel_Icono_Bancos);

        Concepto_Planilla CP = new Concepto_Planilla(txt_IDCP, txt_NombreCP, TipoCP, ClaseCP, txt_ValorCP, AplicacionCP, txt_BuscarCP, tbl_CP, jComboBox_TipoCP, jComboBox_ClaseCP, jComboBox_AplicacionCP);
        cantidad_CP += CP.Cantidad_Registros();

        Planilla_Detalle PD = new Planilla_Detalle(txt_ID_PD, txt_IDPD, jComboBox_IDCP, jLabel_id_IDCP, txt_VCP, cbDeduccion, cbPercepcion, jButton_Igss, jLabel_ISR, txt_Buscar_PD, tbl_PD);
        cantidad_PD += PD.Cantidad_Registros();

        Planilla_General PG = new Planilla_General(txt_IDPD, TotalP, TotalD, TotalL, txt_Buscar_PG, tbl_PG);
        cantidad_PG += PG.Cantidad_Registros();

        

        Cant_R2.setText("" + cantidad_CP);
        Cant_R4.setText("" + cantidad_PD);
        Cant_R3.setText("" + cantidad_PG);
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

        Principal P = new Principal();
        P.setVisible(true);
        
        int cantidad_CP = 0;
        int cantidad_PD = 0;
        int cantidad_PG = 0;


        ConceptoPlanilla.setVisible(true);
        Planilla_DetalleG.setVisible(true);
        Planilla_DetalleG.setVisible(true);



        setColor_PanelI(Panel_Icono_RRHH);
        resetColor_PanelI(Panel_Icono_Nomina);
        resetColor_PanelI(Panel_Icono_Conta);
        resetColor_PanelI(Panel_Icono_Bancos);

        Concepto_Planilla CP = new Concepto_Planilla(txt_IDCP, txt_NombreCP, TipoCP, ClaseCP, txt_ValorCP, AplicacionCP, txt_BuscarCP, tbl_CP, jComboBox_TipoCP, jComboBox_ClaseCP, jComboBox_AplicacionCP);
        cantidad_CP += CP.Cantidad_Registros();

        Planilla_Detalle PD = new Planilla_Detalle(txt_ID_PD, txt_IDPD, jComboBox_IDCP, jLabel_id_IDCP, txt_VCP, cbDeduccion, cbPercepcion, jButton_Igss, jLabel_ISR, txt_Buscar_PD, tbl_PD);
        cantidad_PD += PD.Cantidad_Registros();

        Planilla_General PG = new Planilla_General(txt_IDPD, TotalP, TotalD, TotalL, txt_Buscar_PG, tbl_PG);
        cantidad_PG += PG.Cantidad_Registros();

        

        Cant_R2.setText("" + cantidad_CP);
        Cant_R4.setText("" + cantidad_PD);
        Cant_R3.setText("" + cantidad_PG);

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

        this.dispose();
        Nomina n= new Nomina();
        n.setVisible(true);
    }//GEN-LAST:event_Texto_NominaMouseClicked

    private void Texto_BancosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_BancosMouseClicked
        // TODO add your handling code here:
        setColor_PanelI(Panel_Icono_Bancos);
        resetColor_PanelI(Panel_Icono_RRHH);
        resetColor_PanelI(Panel_Icono_Nomina);
        resetColor_PanelI(Panel_Icono_Conta);

        this.dispose();
        Bancos ban= new Bancos();
        ban.setVisible(true);
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

    private void icon_ConceptoPlanillaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ConceptoPlanillaMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA1);

        animacion.Bajar();
    }//GEN-LAST:event_icon_ConceptoPlanillaMouseMoved

    private void icon_ConceptoPlanillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ConceptoPlanillaMouseClicked
        // TODO add your handling code here:
        //jPanel_BG.setVisible(false);
        //Slide.setVisible(false);
        ConceptoPlanilla.setVisible(false);
        Planilla_DetalleG.setVisible(false);
        
        MantenimientoCP.setVisible(true);
        Concepto_Planilla CP = new Concepto_Planilla(txt_IDCP, txt_NombreCP, TipoCP, ClaseCP, txt_ValorCP, AplicacionCP, txt_BuscarCP, tbl_CP, jComboBox_TipoCP, jComboBox_ClaseCP, jComboBox_AplicacionCP);

        if(jComboBox_TipoCP.getItemCount() == 0)
        {
            jComboBox_TipoCP.addItem("Porcentaje");
            jComboBox_TipoCP.addItem("Cuota");
            jComboBox_TipoCP.addItem("Monto");
        }
        if(jComboBox_ClaseCP.getItemCount() == 0)
        {
            jComboBox_ClaseCP.addItem("Deduccion");
            jComboBox_ClaseCP.addItem("Percepcion");
        }
        if(jComboBox_AplicacionCP.getItemCount() == 0)
        {
            jComboBox_AplicacionCP.addItem("Rango");
            jComboBox_AplicacionCP.addItem("Unico");
        }
       
       

        CP.Actualizar_CP();

    }//GEN-LAST:event_icon_ConceptoPlanillaMouseClicked

    private void icon_ConceptoPlanillaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_ConceptoPlanillaMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA1);

        animacion.Subir();
    }//GEN-LAST:event_icon_ConceptoPlanillaMouseExited

    private void ConceptoPlanillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConceptoPlanillaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ConceptoPlanillaMouseClicked

    private void SeleccionadoAMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeleccionadoAMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccionadoAMouseMoved

    private void icon_Planilla_DetalleGMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_Planilla_DetalleGMouseMoved
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA);

        animacion.Bajar();
    }//GEN-LAST:event_icon_Planilla_DetalleGMouseMoved

    private void icon_Planilla_DetalleGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_Planilla_DetalleGMouseClicked
        // TODO add your handling code here:

        ConceptoPlanilla.setVisible(false);
        Planilla_DetalleG.setVisible(false);

        if(RangoMayor > 0 && RangoMenor > 0)
        {
            jLabel_ModificarPDG.setVisible(false);
            jLabel_EliminarPDG.setVisible(false);
            
            jLabel5.setVisible(false);
            jLabel3.setVisible(false);
        }
        else if(I_Unico >= 0)
        {
            jLabel_ModificarPDG.setVisible(true);
            jLabel_EliminarPDG.setVisible(true);
            
            jLabel5.setVisible(true);
            jLabel3.setVisible(true);
        }
        
        MantenimientoPDG.setVisible(true);
        Planilla_General PG = new Planilla_General(txt_IDPD, TotalP, TotalD, TotalL, txt_Buscar_PG, tbl_PG);
        PG.Actualizar_PG();

        Planilla_Detalle PD = new Planilla_Detalle(txt_ID_PD, txt_IDPD, jComboBox_IDCP, jLabel_id_IDCP, txt_VCP, cbDeduccion, cbPercepcion, jButton_Igss, jLabel_ISR, txt_Buscar_PD, tbl_PD);
        PD.Encontrar_ListaPD("concepto_planilla", "nombre_concepto", jComboBox_IDCP);
        PD.Obtener_Rangos(RangoMenor, RangoMayor, I_Unico, txt_IDR, jLabel_IDR, jLabel_IDU);
        PD.Actualizar_PD();
    }//GEN-LAST:event_icon_Planilla_DetalleGMouseClicked

    private void icon_Planilla_DetalleGMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_Planilla_DetalleGMouseExited
        // TODO add your handling code here:
        int posY_Subir = 0, posY_Bajar = 0;
        AnimationClass ani = new AnimationClass();
        Animaciones animacion = new Animaciones(ani, posY_Bajar, posY_Subir, SeleccionadoA);

        animacion.Subir();
    }//GEN-LAST:event_icon_Planilla_DetalleGMouseExited

    private void Planilla_DetalleGMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Planilla_DetalleGMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Planilla_DetalleGMouseExited

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

    private void Texto_IngresarCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarCPMouseClicked

        // TODO add your handling code here:
        jLabel_EliminarCP.setVisible(false);
        jLabel_ModificarCP.setVisible(false);
        jLabel_IngresarCP.setVisible(true);
    }//GEN-LAST:event_Texto_IngresarCPMouseClicked

    private void Panel_IngresarCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarCPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarCPMouseClicked

    private void Texto_ModificarCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificarCPMouseClicked
        // TODO add your handling code here:
        jLabel_ModificarCP.setVisible(true);
        jLabel_IngresarCP.setVisible(false);
        jLabel_EliminarCP.setVisible(false);
    }//GEN-LAST:event_Texto_ModificarCPMouseClicked

    private void Panel_ModificarCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarCPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarCPMouseClicked

    private void Texto_EliminarPDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarPDMouseClicked
        // TODO add your handling code here:
        jLabel_EliminarCP.setVisible(true);
        jLabel_ModificarCP.setVisible(false);
        jLabel_IngresarCP.setVisible(false);
    }//GEN-LAST:event_Texto_EliminarPDMouseClicked

    private void Texto_ConsultarCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarCPMouseClicked
        // TODO add your handling code here:
        jLabel_EliminarCP.setVisible(false);
        jLabel_ModificarCP.setVisible(false);
        jLabel_IngresarCP.setVisible(false);
    }//GEN-LAST:event_Texto_ConsultarCPMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void esquisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_esquisMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_esquisMouseClicked

    public void ConceptoP(String NombreC, float f_Concepto) {
        float SueldoE = 0;
        f_TotalP = 0;

        Planilla_Detalle PD = new Planilla_Detalle(txt_ID_PD, txt_IDPD, jComboBox_IDCP, jLabel_id_IDCP, txt_VCP, cbDeduccion, cbPercepcion, jButton_Igss, jLabel_ISR, txt_Buscar_PD, tbl_PD);
        Planilla_General PG = new Planilla_General(txt_IDPD, String.valueOf(sumaAP), String.valueOf(sumaA), TotalL, txt_Buscar_PG, tbl_PG);

        f_TotalP = PG.Percepcion_T(S_TotalP, f_TotalP);

        if (jComboBox_IDCP.getSelectedItem().toString().equals(NombreC)) {
            if (RangoMenor > 0 && RangoMayor > 0) {
                for (int j = RangoMenor; j <= RangoMayor; j++) {

                    if (jComboBox_IDCP.getSelectedItem().toString().equals("IGSS")) {
                        SueldoE = PD.Impuesto_PG(S_Sueldo, f_Sueldo, j) * (f_Concepto);
                        System.out.println(SueldoE);
                        txt_VCP.setText(String.valueOf(SueldoE));

                        sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");
                        sumaT = PD.SumaT_DPL(S_Valor, txt_VCP, Valor, sumaA, sumaT, txt_IDPD, 0, 0, j, cbDeduccion);

                        sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");
                    } else if (jComboBox_IDCP.getSelectedItem().toString().equals("ISR1") || jComboBox_IDCP.getSelectedItem().toString().equals("ISR2") || jComboBox_IDCP.getSelectedItem().toString().equals("ISR3")) {
                        if (f_TotalP >= 6000 && f_TotalP <= 7500) {
                            f_TotalP = PG.Percepcion_T(S_TotalP, f_TotalP) * (f_Concepto);
                            System.out.println(f_TotalP);
                            txt_VCP.setText(String.valueOf(f_TotalP));

                            sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");
                            sumaT = PD.SumaT_DPL(S_Valor, txt_VCP, Valor, sumaA, sumaT, txt_IDPD, 0, 0, j, cbDeduccion);

                            sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");
                        } else if (f_TotalP >= 7500 && f_TotalP <= 9000) {
                            f_TotalP = PG.Percepcion_T(S_TotalP, f_TotalP) * (f_Concepto);
                            System.out.println(f_TotalP);
                            txt_VCP.setText(String.valueOf(f_TotalP));

                            sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");
                            sumaT = PD.SumaT_DPL(S_Valor, txt_VCP, Valor, sumaA, sumaT, txt_IDPD, 0, 0, j, cbDeduccion);

                            sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");
                        } else if (f_TotalP >= 9000) {
                            f_TotalP = PG.Percepcion_T(S_TotalP, f_TotalP) * (f_Concepto);
                            System.out.println(f_TotalP);
                            txt_VCP.setText(String.valueOf(f_TotalP));

                            sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");
                            sumaT = PD.SumaT_DPL(S_Valor, txt_VCP, Valor, sumaA, sumaT, txt_IDPD, 0, 0, j, cbDeduccion);

                            sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");
                        }
                    }

                    PD.Insertar_PD(PD.Cantidad_Registros(), 0, 0, j);
                }

            } else if (I_Unico > 0) {
                if (jComboBox_IDCP.getSelectedItem().toString().equals("IGSS")) {
                    SueldoE = PD.Impuesto_PG(S_Sueldo, f_Sueldo, I_Unico) * (f_Concepto);
                    System.out.println(SueldoE);
                    txt_VCP.setText(String.valueOf(SueldoE));

                    sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");
                    sumaT = PD.SumaT_DPL(S_Valor, txt_VCP, Valor, sumaA, sumaT, txt_IDPD, RangoMenor, RangoMayor, I_Unico, cbDeduccion);

                    sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");
                } else if (jComboBox_IDCP.getSelectedItem().toString().equals("ISR1") || jComboBox_IDCP.getSelectedItem().toString().equals("ISR2") || jComboBox_IDCP.getSelectedItem().toString().equals("ISR3")) {
                    if (f_TotalP >= 6000 && f_TotalP <= 7500) {
                        f_TotalP = PG.Percepcion_T(S_TotalP, f_TotalP) * (f_Concepto);
                        System.out.println(f_TotalP);
                        txt_VCP.setText(String.valueOf(f_TotalP));

                        sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");
                        sumaT = PD.SumaT_DPL(S_Valor, txt_VCP, Valor, sumaA, sumaT, txt_IDPD, RangoMenor, RangoMayor, I_Unico, cbDeduccion);

                        sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");
                    } else if (f_TotalP >= 7500 && f_TotalP <= 9000) {
                        f_TotalP = PG.Percepcion_T(S_TotalP, f_TotalP) * (f_Concepto);
                        System.out.println(f_TotalP);
                        txt_VCP.setText(String.valueOf(f_TotalP));

                        sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");
                        sumaT = PD.SumaT_DPL(S_Valor, txt_VCP, Valor, sumaA, sumaT, txt_IDPD, RangoMenor, RangoMayor, I_Unico, cbDeduccion);

                        sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");
                    } else if (f_TotalP >= 9000) {
                        f_TotalP = PG.Percepcion_T(S_TotalP, f_TotalP) * (f_Concepto);
                        System.out.println(f_TotalP);
                        txt_VCP.setText(String.valueOf(f_TotalP));

                        sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");
                        sumaT = PD.SumaT_DPL(S_Valor, txt_VCP, Valor, sumaA, sumaT, txt_IDPD, RangoMenor, RangoMayor, I_Unico, cbDeduccion);

                        sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");
                    }
                }

                PD.Insertar_PD(PD.Cantidad_Registros(), RangoMenor, RangoMayor, I_Unico);
            }
        }
    }

    public void Datos_CP() {
        try {
            String ID = jLabel_id_IDCP.getText();
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from concepto_planilla where id_conceptoPlanilla = ?");
            pst.setString(1, ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Concepto[0] = rs.getString("id_conceptoPlanilla");
                Concepto[1] = rs.getString("nombre_concepto");
                Concepto[2] = rs.getString("tipo_concepto");
                Concepto[3] = rs.getString("clase_concepto");
                Concepto[4] = rs.getString("Valor_concepto");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void Datos_PD() {
        try {
            String ID = txt_ID_PD.getText();
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from planilla_det where id_planillaDe = ?");
            pst.setString(1, ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                PDE[0] = rs.getString("id_planillaDe");
                PDE[1] = rs.getString("id_planillaenc");
                PDE[2] = rs.getString("id_empleado");
                PDE[3] = rs.getString("id_conceptoPlanilla");
                PDE[4] = rs.getString("valor_conceptoDet");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean ValidarC() {
        Datos_PD();
        Datos_CP();

        boolean Encontrado = false;

        try {
            String ID = PDE[3];
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from concepto_planilla where id_conceptoPlanilla = ?");
            pst.setString(1, ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                if (Concepto[3].equals("Percepcion")) {
                    Encontrado = true;
                } else if (Concepto[3].equals("Deduccion")) {
                    Encontrado = false;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return Encontrado;
    }

    public boolean Datos_IDPD() {

        boolean Encontrado = false;
        String id_PG = "";
        
        try {
            String ID = txt_IDR.getText();
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from planilla_det where id_empleado = ?");
            pst.setString(1, ID);

            ResultSet rs = pst.executeQuery();

            
            while (rs.next()) {
                id_C = rs.getString("id_conceptoPlanilla");
                id_PG = rs.getString("id_planillaenc");
                
                if(id_PG.equals(txt_IDPD.getText()))
                {
                    if (Encontrar_ISR() == true) {
                    Encontrado = true;
                    Datos_ISR[0] = rs.getString("id_planillaDe");
                    Datos_ISR[1] = rs.getString("id_planillaenc");
                    Datos_ISR[2] = rs.getString("id_empleado");
                    Datos_ISR[3] = rs.getString("id_conceptoPlanilla");
                    Datos_ISR[4] = rs.getString("valor_conceptoDet");
                    
                    //id_ISR = rs.getString("nombre_concepto");
                    
                    break;
                } else {
                    Encontrado = false;
                }
                }
                
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return Encontrado;
    }

    public boolean Encontrar_ISR() {

        boolean Encontrado = false;

        try {
            String ID = id_C;
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from concepto_planilla where id_conceptoPlanilla = ?");
            pst.setString(1, ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                NombreC = rs.getString("nombre_concepto");

                if (NombreC.equals("ISR1") || NombreC.equals("ISR2") || NombreC.equals("ISR3")) {
                    Encontrado = true;
                } else {
                    Encontrado = false;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return Encontrado;
    }

    public void Modificar_PDISR() {
        String S_TotalP = "";
        float f_TotalP = 0;
        float f_VC = 0;
        float restaVC = 0;
        
        Planilla_General PG = new Planilla_General(txt_IDPD, String.valueOf(sumaAP), String.valueOf(sumaA), TotalL, txt_Buscar_PG, tbl_PG);
        Planilla_Detalle PD = new Planilla_Detalle(txt_ID_PD, txt_IDPD, jComboBox_IDCP, jLabel_id_IDCP, txt_VCP, cbDeduccion, cbPercepcion, jButton_Igss, jLabel_ISR, txt_Buscar_PD, tbl_PD);
        
            f_TotalP = PG.Percepcion_T(S_TotalP, f_TotalP);
        
            if (f_TotalP >= 6000 && f_TotalP <= 7500) {
                f_TotalP = PG.Percepcion_T(S_TotalP, f_TotalP) * (0.05f);

                f_VC = Float.parseFloat(Datos_ISR[4]);
                sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");
                
                restaVC = (sumaA - f_VC) + f_TotalP;

                sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");

                Modificar_PD2(RangoMenor, RangoMayor,String.valueOf(f_TotalP));
                PG.Modificar_PG(restaVC, sumaAP, (sumaAP - restaVC));

            } else if (f_TotalP >= 7500 && f_TotalP <= 9000) {
                f_TotalP = PG.Percepcion_T(S_TotalP, f_TotalP) * (0.06f);

                f_VC = Float.parseFloat(Datos_ISR[4]);
                sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");
                
                restaVC = (sumaA - f_VC) + f_TotalP;

                sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");

                Modificar_PD2(RangoMenor, RangoMayor,String.valueOf(f_TotalP));
                PG.Modificar_PG(restaVC, sumaAP, (sumaAP - restaVC));


            } else if (f_TotalP >= 9000) {
                f_TotalP = PG.Percepcion_T(S_TotalP, f_TotalP) * (0.08f);

                f_VC = Float.parseFloat(Datos_ISR[4]);
                sumaA = PD.Encontrar_DPL(S_Deduccion, f_Deduccion, "total_deduccion");
                
                restaVC = (sumaA - f_VC) + f_TotalP;

                sumaAP = PD.Encontrar_DPL(S_Percepcion, f_Percepcion, "total_percepcion");

                Modificar_PD2(RangoMenor, RangoMayor,String.valueOf(f_TotalP));
                PG.Modificar_PG(restaVC, sumaAP, (sumaAP - restaVC));
            }
        
    }
    
    public void Modificar_PD2(int RangoMe, int RangoMa,String Valor) {
        Planilla_Detalle PD = new Planilla_Detalle(txt_ID_PD, txt_IDPD, jComboBox_IDCP, jLabel_id_IDCP, txt_VCP, cbDeduccion, cbPercepcion, jButton_Igss, jLabel_ISR, txt_Buscar_PD, tbl_PD);
        
        try {
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("update planilla_det set id_planillaDe = ?,id_planillaenc = ?, id_empleado=?,id_conceptoPlanilla = ?, valor_conceptoDet=? where id_planillaDe= " + Datos_ISR[0]);

            
                pst.setString(1, Datos_ISR[0]);
                pst.setString(2, Datos_ISR[1]);
                pst.setString(3, Datos_ISR[2]);
                pst.setString(4, Datos_ISR[3]);
                pst.setString(5, Valor);
            
            

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");

            PD.Actualizar_PD();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public boolean Ningun_PD() {

        boolean Encontrado = false;
        String id_PG = "";
        
        try {
            String ID = txt_IDPD.getText();
            Connection cn = DriverManager.getConnection(Base_de_Datos, Usuario, Clave);
            PreparedStatement pst = cn.prepareStatement("select * from planilla_det where id_planillaenc = ?");
            pst.setString(1, ID);

            ResultSet rs = pst.executeQuery();

            
            while (rs.next()) {
                id_PG = rs.getString("id_planillaenc");
                
                if(id_PG.equals(txt_IDPD.getText()))
                {
                    if (Encontrar_ISR() == true) {
                    
                        Encontrado = true;
                    
                    break;
                } else {
                        Encontrado = false;
                }
                }
                
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return Encontrado;
    }
    
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
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Nomina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cant_R2;
    private javax.swing.JLabel Cant_R3;
    private javax.swing.JLabel Cant_R4;
    private javax.swing.JPanel ConceptoPlanilla;
    private javax.swing.JLabel Icono_Bancos;
    private javax.swing.JLabel Icono_Conta;
    private javax.swing.JLabel Icono_Nomina;
    private javax.swing.JLabel Icono_RRHH;
    private javax.swing.JPanel MantenimientoCP;
    private javax.swing.JPanel MantenimientoPDG;
    private javax.swing.JPanel Modificar_IDU;
    private javax.swing.JPanel Modificar_Rangos;
    private javax.swing.JPanel Movimiento1;
    private javax.swing.JPanel Panel_ConsultarCP;
    private javax.swing.JPanel Panel_EliminarCP;
    private javax.swing.JPanel Panel_Icono_Bancos;
    private javax.swing.JPanel Panel_Icono_Conta;
    private javax.swing.JPanel Panel_Icono_Nomina;
    private javax.swing.JPanel Panel_Icono_RRHH;
    private javax.swing.JPanel Panel_IngresarCP;
    private javax.swing.JPanel Panel_IzquierdoC;
    private javax.swing.JPanel Panel_ModificarCP;
    private javax.swing.JPanel Panel_Text_Bancos;
    private javax.swing.JPanel Panel_Text_Conta;
    private javax.swing.JPanel Panel_Text_Nomina;
    private javax.swing.JPanel Panel_Text_RRHH;
    private javax.swing.JPanel Planilla_DetalleG;
    private javax.swing.JLabel SeleccionadoA;
    private javax.swing.JLabel SeleccionadoA1;
    private javax.swing.JPanel Slide;
    private javax.swing.JPanel Slide_Derecho;
    private javax.swing.JLabel Texto_Bancos;
    private javax.swing.JLabel Texto_ConsultarCP;
    private javax.swing.JLabel Texto_Conta;
    private javax.swing.JLabel Texto_EliminarPD;
    private javax.swing.JLabel Texto_IngresarCP;
    private javax.swing.JLabel Texto_ModificarCP;
    private javax.swing.JLabel Texto_Nomina;
    private javax.swing.JLabel Texto_RRHH;
    private javax.swing.JCheckBox cbDeduccion;
    private javax.swing.JCheckBox cbPercepcion;
    private javax.swing.JPanel esquis;
    private javax.swing.JLabel icon_ConceptoPlanilla;
    private javax.swing.JLabel icon_Planilla_DetalleG;
    private javax.swing.JButton jButton_Igss;
    private javax.swing.JButton jButton_MDR;
    private javax.swing.JButton jButton_MDU;
    private javax.swing.JComboBox<String> jComboBox_AplicacionCP;
    private javax.swing.JComboBox<String> jComboBox_ClaseCP;
    private javax.swing.JComboBox<String> jComboBox_IDCP;
    private javax.swing.JComboBox<String> jComboBox_TipoCP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_AplicacionCP;
    private javax.swing.JLabel jLabel_Buscar_CP;
    private javax.swing.JLabel jLabel_Buscar_PD;
    private javax.swing.JLabel jLabel_Buscar_PG;
    private javax.swing.JLabel jLabel_ClaseCP;
    private javax.swing.JLabel jLabel_Clase_CP;
    private javax.swing.JLabel jLabel_EliminarCP;
    private javax.swing.JLabel jLabel_EliminarPDG;
    private javax.swing.JLabel jLabel_IDCP;
    private javax.swing.JLabel jLabel_IDPD;
    private javax.swing.JLabel jLabel_IDR;
    private javax.swing.JLabel jLabel_IDU;
    private javax.swing.JLabel jLabel_IDUCP;
    private javax.swing.JLabel jLabel_IDUCP1;
    private javax.swing.JLabel jLabel_ID_ExpL;
    private javax.swing.JLabel jLabel_ID_PD;
    private javax.swing.JLabel jLabel_ISR;
    private javax.swing.JLabel jLabel_IngresarAplicacion;
    private javax.swing.JLabel jLabel_IngresarCP;
    private javax.swing.JLabel jLabel_IngresarPDG;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel jLabel_MDR;
    private javax.swing.JLabel jLabel_MIDU;
    private javax.swing.JLabel jLabel_ModificarCP;
    private javax.swing.JLabel jLabel_ModificarPDG;
    private javax.swing.JLabel jLabel_NombreCP;
    private javax.swing.JLabel jLabel_RMayorCP;
    private javax.swing.JLabel jLabel_RMayorCP1;
    private javax.swing.JLabel jLabel_RMenorCP;
    private javax.swing.JLabel jLabel_RMenorCP1;
    private javax.swing.JLabel jLabel_TipoCP;
    private javax.swing.JLabel jLabel_Tipo_CP;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Titulo1;
    private javax.swing.JLabel jLabel_Titulo2;
    private javax.swing.JLabel jLabel_Titulo_IDU;
    private javax.swing.JLabel jLabel_Titulo_MDR;
    private javax.swing.JLabel jLabel_VCP;
    private javax.swing.JLabel jLabel_ValorCP;
    private javax.swing.JLabel jLabel_id_IDCP;
    private javax.swing.JPanel jPanel_BG;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JTable tbl_CP;
    private javax.swing.JTable tbl_PD;
    private javax.swing.JTable tbl_PG;
    private javax.swing.JTextField txt_BuscarCP;
    private javax.swing.JTextField txt_Buscar_PD;
    private javax.swing.JTextField txt_Buscar_PG;
    private javax.swing.JTextField txt_IDCP;
    private javax.swing.JTextField txt_IDPD;
    private javax.swing.JTextField txt_IDR;
    private javax.swing.JTextField txt_IDUCP;
    private javax.swing.JTextField txt_IDUCP1;
    private javax.swing.JTextField txt_IDUCP2;
    private javax.swing.JTextField txt_ID_PD;
    private javax.swing.JTextField txt_NombreCP;
    private javax.swing.JTextField txt_RMayorCP;
    private javax.swing.JTextField txt_RMayorCP1;
    private javax.swing.JTextField txt_RMayorCP2;
    private javax.swing.JTextField txt_RMenorCP;
    private javax.swing.JTextField txt_RMenorCP1;
    private javax.swing.JTextField txt_RMenorCP2;
    private javax.swing.JTextField txt_VCP;
    private javax.swing.JTextField txt_ValorCP;
    // End of variables declaration//GEN-END:variables
}
