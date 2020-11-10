/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas;

import Finanzas_Clases.Banco;
import Finanzas_Clases.Clasificacion_Cuenta;
import Finanzas_Clases.Concepto_Bancario;
import Finanzas_Clases.Concilacion_Bancaria_Encabezado;
import Finanzas_Clases.Conciliacion_Bancaria_Detalle;
import Finanzas_Clases.Consulta_Saldos;
import Finanzas_Clases.Cuenta_Contable;
import Finanzas_Clases.Documento_Bancario;
import Finanzas_Clases.Forma_de_Pago;
import Finanzas_Clases.Moneda;
import Finanzas_Clases.Movimiento_Bancario_Detalle;
import Finanzas_Clases.Movimiento_Bancario_Encabezado;
import Finanzas_Clases.Solicitud_Empresarial;
import Finanzas_Clases.Forma_de_Pago;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Brayan Cifuentes
 */

public class Bancos extends javax.swing.JFrame {

    /**
     * Creates new form Bancos
     */
    public Bancos() {
        initComponents();
        // mantenimientos
        jPanel_MantenimientoMoneda.setVisible(false);
        jPanel_MantenimientoClasiCuenta.setVisible(false);
        Panel_CuentaContable.setVisible(false);
        jPanel_Mantenimiento_DocB.setVisible(false);
        jPanel_MantenimientoCB.setVisible(false);
        JPanel_MantenimientoMovimientoBanEn.setVisible(false);
        jPanel_MantenimientoMovBanDet.setVisible(false);
        jPanel_Forma_de_Pago.setVisible(false);
        jPanel_MantenimientoBanco.setVisible(false);
        jPanel_Manatenimiento_ConBanEn.setVisible(false);
        jPanel_Mantenimiento_CBD.setVisible(false);
        jPanel_ConsultaBancos_Saldos.setVisible(false);

        //jlabel
        jLabel_Modificar.setVisible(false);
        jLabel_Eliminar.setVisible(false);
        modificard.setVisible(false);
        eliminard.setVisible(false);
        
        IngresaB1.setVisible(true);
        ModificarB1.setVisible(false);
        EliminarB1.setVisible(false);

        // Iconos Panel Cuenta Contable Insertar- Modificar-Eliminar
        jLabel_ModificarCC.setVisible(false);
        jLabel_EliminarCC.setVisible(false);

        //Label Moneda
        ingresar.setVisible(true);
        modificar.setVisible(false);
        eliminar.setVisible(false);

        //labels Concepto - Bancario
        jLabel_IngresarCB.setVisible(true);
        jLabel_Modificar_CB.setVisible(false);
        jLabel_Eliminar_CB.setVisible(false);

        //lable Movimiento Bancario Encabezado
        jLabel_IngresarMBEN.setVisible(true);
        jLabel_Modificar_MBEN.setVisible(false);
        jLabel_Eliminar_MBEN.setVisible(false);

        //Label Movimiento Bancario Detalle (Pendiente para el diseño)
        //Label Forma de Pago (pendiente para el diseño) 
        //Labels Bancos
        IngresaB.setVisible(true);
        EliminarB.setVisible(false);
        ModificarB.setVisible(false);

        //
        //ingresarConcilacionEn.setVisible(true);
        ingresarConcilacionEn.setVisible(true);
        eliminarConcilacionEn.setVisible(false);
        modificarConcilacionEn.setVisible(false);
        
        // bones en cuenta
        jLabel_SaldoA.setVisible(false);
        jTextField_SaldoA.setVisible(false);
        jLabel_Ca.setVisible(false);
        jLabel_AC.setVisible(false);
        jLabel_SA.setVisible(false);
        jTextField_CargosA.setVisible(false);
        jTextField_AbonosA.setVisible(false);
        jTextField_SaldoActual.setVisible(false);
        
        // Contadores de Registros 
        /*
        int cantidad_Mo = 0;
        int cantidad_CC = 0;
        int cantidad_CuCon = 0;
        int cantidad_DB = 0;
        int cantidad_CB = 0;
        int cantidad_BE = 0;
        int cantidad_MBD = 0;
        int cantidad_FP = 0;
        int cantidad_B = 0;
        int cantidad_CBE = 0;
        int cantidad_CBD = 0;

        Clasificacion_Cuenta CC = new Clasificacion_Cuenta(jLabel_CC, txt_idclasi, txt_nombrecla, txt_buscarclasi, tbl_Clasi);
        Cuenta_Contable cuenta_c = new Cuenta_Contable(jTextField_IDCuenta, jTextField_NombreCuenta, jTextField_IDClasif, jLabel_clasificacion, jTextField_SaldoA, jTextField_CargosM, jTextField_AbonosM, jTextField_SaldoActual, jTextField_CargosAC, jTextField_AbonosA, jTextArea_Descripcion, jTextField_Buscar, tbl_CuentaContable);
        Documento_Bancario DB = new Documento_Bancario(jLabel_MMon1, txt_cod, txt_nombred, txt_afec, txt_estd, txt_buscard, tbl_Doc);
        Moneda mon = new Moneda(jLabel_MMon, txt_IDM, txt_NombreM, txt_TipoM, txt_estM, txt_buscarMon, tbl_Moneda);
        Concepto_Bancario CB = new Concepto_Bancario(txt_CodigoConcepto, txt_Nombre_Concepto, txt_Afecta, txt_Estatus, jLabel_ID_Cuenta, tbl_CB, txt_BuscarCB);
        Movimiento_Bancario_Encabezado Mo = new Movimiento_Bancario_Encabezado(txt_CodigoMovimientoE, jLabel_ID_Documento, txt_Fecha, txt_Monto, txt_Descripcion, txt_BuscarMovBanEn, tbl_MovimientoBanEn);
        Movimiento_Bancario_Detalle MovDet = new Movimiento_Bancario_Detalle(jLabel_IDEnc, jLabel_codigoConcepto, jTextField_Saldo, jTextField_tipoSaldo, jTextField_BuscarMov, tbl_MovBancDet);
        Forma_de_Pago forma = new Forma_de_Pago(jTextField_IDForma, jTextField_TipoPago, jTextField_BuscarFP, tbl_FormaPago);
        Banco B = new Banco(jTextField_IDBanco, jTextField_NombreBanco, jTextField_NombreC, jTextField_ClaveBan, jTextField_Funcionario, jTextField_Telefono, jTextField_NumeroPlaza, jTextField_NumeroS, jTextField_SaldoI, jLabel_ID_Moneda, jLabel_IdMovimiento, txt_buscardBan, tbl_Bancos);
        Concilacion_Bancaria_Encabezado Con = new Concilacion_Bancaria_Encabezado(txt_IdEnca, txt_CargoAConciliar, txt_AbonoA_Conciliar, txt_SaldoCorte, txt_Cargo_Conciliado, txt_Abono_Conciliado, txt_Saldo_Final, txt_BuscarCoBaEn, tbl_ConcilacioEn);
        Conciliacion_Bancaria_Detalle CBD = new Conciliacion_Bancaria_Detalle(jLabel_ID_Encabezado, jLabel_Idcodigoconcepto, txt_fechaap, jTextArea_Descrip, jLabel_idformapago, txt_beneficiario, txt_estcon, txt_cargo, txt_abono, txt_buscardCBD, tbl_CBD);

        cantidad_Mo += mon.Cantidad_Registros();
        cantidad_CC += CC.Cantidad_Registros();
        cantidad_CuCon += cuenta_c.Cantidad_Registros();
        cantidad_DB += DB.Cantidad_Registros();
        cantidad_CB += CB.Cantidad_Registros();
        cantidad_BE += Mo.Cantidad_Registros();
        cantidad_MBD += MovDet.Cantidad_Registros();
        cantidad_FP += forma.Cantidad_Registros();
        cantidad_B += B.Cantidad_Registros();
        cantidad_CBE += Con.Cantidad_Registros();
        cantidad_CBD += CBD.Cantidad_Registros();

        Cant_Moneda.setText("" + cantidad_Mo);
        Cant_CC.setText("" + cantidad_CC);
        Cant_CuCon.setText("" + cantidad_CuCon);
        Cant_DB.setText("" + cantidad_DB);
        Cant_CB.setText("" + cantidad_CB);
        Cant_BE.setText("" + cantidad_BE);
        Cant_MBD.setText("" + cantidad_MBD);
        Cant_FP.setText("" + cantidad_FP);
        Cant_B.setText("" + cantidad_B);
        Cant_CBE.setText("" + cantidad_CBE);
        Cant_CBD.setText("" + cantidad_CBD);*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_ConsultaBancos_Saldos = new javax.swing.JPanel();
        jScrollPane47 = new javax.swing.JScrollPane();
        tbl_ConsultaDet = new javax.swing.JTable();
        jLabel94 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jScrollPane48 = new javax.swing.JScrollPane();
        tbl_ConsultaEnc = new javax.swing.JTable();
        jLabel105 = new javax.swing.JLabel();
        jPanel_Mantenimiento_CBD = new javax.swing.JPanel();
        jLabel_MMon4 = new javax.swing.JLabel();
        jScrollPane46 = new javax.swing.JScrollPane();
        tbl_CBD = new javax.swing.JTable();
        jLabel90 = new javax.swing.JLabel();
        txt_buscardCBD = new javax.swing.JTextField();
        IngresaB1 = new javax.swing.JLabel();
        EliminarB1 = new javax.swing.JLabel();
        ModificarB1 = new javax.swing.JLabel();
        Panel_Ingresar_B1 = new javax.swing.JPanel();
        Texto_Ingresar_B1 = new javax.swing.JLabel();
        Panel_Modificar_B1 = new javax.swing.JPanel();
        Texto_Modificar_B1 = new javax.swing.JLabel();
        Panel_Eliminar_B1 = new javax.swing.JPanel();
        Texto_Eliminar_B1 = new javax.swing.JLabel();
        Panel_Consultar_B1 = new javax.swing.JPanel();
        Texto_Consultar_B1 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        txt_fechaap = new javax.swing.JTextField();
        jLabel_ID_Encabezado = new javax.swing.JLabel();
        jComboBoxIDFormaPago = new javax.swing.JComboBox<>();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        txt_beneficiario = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        txt_estcon = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        txt_abono = new javax.swing.JTextField();
        jLabel_Idcodigoconcepto = new javax.swing.JLabel();
        jComboBoxCODIGOCONCEPTO = new javax.swing.JComboBox<>();
        jLabel101 = new javax.swing.JLabel();
        txt_cargo = new javax.swing.JTextField();
        jComboBoxIDEncabezado = new javax.swing.JComboBox<>();
        jLabel_idformapago = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_Descrip = new javax.swing.JTextArea();
        jPanel_Manatenimiento_ConBanEn = new javax.swing.JPanel();
        jLabel_MMon3 = new javax.swing.JLabel();
        txt_IdEnca = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        txt_CargoAConciliar = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        txt_AbonoA_Conciliar = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        txt_SaldoCorte = new javax.swing.JTextField();
        jScrollPane45 = new javax.swing.JScrollPane();
        tbl_ConcilacioEn = new javax.swing.JTable();
        jLabel86 = new javax.swing.JLabel();
        txt_BuscarCoBaEn = new javax.swing.JTextField();
        ingresarConcilacionEn = new javax.swing.JLabel();
        eliminarConcilacionEn = new javax.swing.JLabel();
        modificarConcilacionEn = new javax.swing.JLabel();
        Panel_Ingresar_CoBaEn = new javax.swing.JPanel();
        Texto_Ingresar_CoBaEn = new javax.swing.JLabel();
        Panel_Modificar_CoBaEn = new javax.swing.JPanel();
        Texto_Modificar_CoBaEn = new javax.swing.JLabel();
        Panel_Eliminar_CoBaEn = new javax.swing.JPanel();
        Texto_Eliminar_CoBaEn = new javax.swing.JLabel();
        Panel_Consultar_CoBaEn = new javax.swing.JPanel();
        Texto_Consultar_CoBaEn = new javax.swing.JLabel();
        txt_Cargo_Conciliado = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        txt_Abono_Conciliado = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        txt_Saldo_Final = new javax.swing.JTextField();
        jPanel_MantenimientoBanco = new javax.swing.JPanel();
        jLabel_MMon2 = new javax.swing.JLabel();
        jScrollPane44 = new javax.swing.JScrollPane();
        tbl_Bancos = new javax.swing.JTable();
        jLabel74 = new javax.swing.JLabel();
        txt_buscardBan = new javax.swing.JTextField();
        IngresaB = new javax.swing.JLabel();
        EliminarB = new javax.swing.JLabel();
        ModificarB = new javax.swing.JLabel();
        Panel_Ingresar_B = new javax.swing.JPanel();
        Texto_Ingresar_B = new javax.swing.JLabel();
        Panel_Modificar_B = new javax.swing.JPanel();
        Texto_Modificar_B = new javax.swing.JLabel();
        Panel_Eliminar_B = new javax.swing.JPanel();
        Texto_Eliminar_B = new javax.swing.JLabel();
        Panel_Consultar_B = new javax.swing.JPanel();
        Texto_Consultar_B = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jTextField_IDBanco = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jTextField_NombreBanco = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jTextField_NombreC = new javax.swing.JTextField();
        jLabel_ID_Moneda = new javax.swing.JLabel();
        jComboBoxIDMoneda = new javax.swing.JComboBox<>();
        jTextField_ClaveBan = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jTextField_Funcionario = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jTextField_Telefono = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jTextField_NumeroPlaza = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jTextField_SaldoI = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel_IdMovimiento = new javax.swing.JLabel();
        jComboBoxIDMovEn = new javax.swing.JComboBox<>();
        jLabel84 = new javax.swing.JLabel();
        jTextField_NumeroS = new javax.swing.JTextField();
        jPanel_Forma_de_Pago = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jTextField_IDForma = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jTextField_BuscarFP = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jTextField_TipoPago = new javax.swing.JTextField();
        jScrollPane43 = new javax.swing.JScrollPane();
        tbl_FormaPago = new javax.swing.JTable();
        jPanel_MantenimientoMovBanDet = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jTextField_Saldo = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jTextField_tipoSaldo = new javax.swing.JTextField();
        jLabel_codigoConcepto = new javax.swing.JLabel();
        jLabel_IDEnc = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jTextField_BuscarMov = new javax.swing.JTextField();
        jScrollPane42 = new javax.swing.JScrollPane();
        tbl_MovBancDet = new javax.swing.JTable();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jComboBox_codigoC = new javax.swing.JComboBox<>();
        jComboBox_Encabezado = new javax.swing.JComboBox<>();
        JPanel_MantenimientoMovimientoBanEn = new javax.swing.JPanel();
        txt_CodigoMovimientoE = new javax.swing.JTextField();
        jLabel_CodigoConcepto1 = new javax.swing.JLabel();
        jLabel_DPIAP1 = new javax.swing.JLabel();
        jComboBox_Nombre_Movimiento = new javax.swing.JComboBox<>();
        txt_Fecha = new javax.swing.JTextField();
        jLabel_Fecha = new javax.swing.JLabel();
        jLabel_IngresarMBEN = new javax.swing.JLabel();
        jLabel_Modificar_MBEN = new javax.swing.JLabel();
        jLabel_Eliminar_MBEN = new javax.swing.JLabel();
        jScrollPane32 = new javax.swing.JScrollPane();
        tbl_MovimientoBanEn = new javax.swing.JTable();
        txt_BuscarMovBanEn = new javax.swing.JTextField();
        jLabel_BuscarMBEN = new javax.swing.JLabel();
        jLabel_ID_Documento = new javax.swing.JLabel();
        jLabel_NombreAP1 = new javax.swing.JLabel();
        Panel_IngresarMBEN = new javax.swing.JPanel();
        Texto_IngresarMBEN = new javax.swing.JLabel();
        Panel_ModificarMBEN = new javax.swing.JPanel();
        Texto_ModificarMBEN = new javax.swing.JLabel();
        Panel_EliminarMBEN = new javax.swing.JPanel();
        Texto_EliminarMBEN = new javax.swing.JLabel();
        Panel_ConsultarMBEN = new javax.swing.JPanel();
        Texto_ConsultarMBEN = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jComboBox_TablasCB1 = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        jLabel_NombreConcepto1 = new javax.swing.JLabel();
        txt_Descripcion = new javax.swing.JTextField();
        jLabel_RequisitosAP3 = new javax.swing.JLabel();
        txt_Monto = new javax.swing.JTextField();
        jPanel_MantenimientoCB = new javax.swing.JPanel();
        txt_CodigoConcepto = new javax.swing.JTextField();
        jLabel_CodigoConcepto = new javax.swing.JLabel();
        jLabel_DPIAP = new javax.swing.JLabel();
        jComboBox_Nombre_Cuenta = new javax.swing.JComboBox<>();
        txt_Afecta = new javax.swing.JTextField();
        jLabel_RequisitosAP = new javax.swing.JLabel();
        jLabel_IngresarCB = new javax.swing.JLabel();
        jLabel_Modificar_CB = new javax.swing.JLabel();
        jLabel_Eliminar_CB = new javax.swing.JLabel();
        jScrollPane31 = new javax.swing.JScrollPane();
        tbl_CB = new javax.swing.JTable();
        txt_BuscarCB = new javax.swing.JTextField();
        jLabel_BuscarAP = new javax.swing.JLabel();
        jLabel_ID_Cuenta = new javax.swing.JLabel();
        jLabel_NombreAP = new javax.swing.JLabel();
        Panel_IngresarCB = new javax.swing.JPanel();
        Texto_IngresarCB = new javax.swing.JLabel();
        Panel_ModificarCB = new javax.swing.JPanel();
        Texto_ModificarCB = new javax.swing.JLabel();
        Panel_EliminarCB = new javax.swing.JPanel();
        Texto_EliminarCB = new javax.swing.JLabel();
        Panel_ConsultarCB = new javax.swing.JPanel();
        Texto_ConsultarCB = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_TablasCB = new javax.swing.JComboBox<>();
        jLabel_Buscar_Tablas_CB = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel_NombreConcepto = new javax.swing.JLabel();
        txt_Nombre_Concepto = new javax.swing.JTextField();
        jLabel_RequisitosAP1 = new javax.swing.JLabel();
        txt_Estatus = new javax.swing.JTextField();
        jPanel_Mantenimiento_DocB = new javax.swing.JPanel();
        jLabel_MMon1 = new javax.swing.JLabel();
        txt_cod = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txt_nombred = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txt_afec = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txt_estd = new javax.swing.JTextField();
        jScrollPane41 = new javax.swing.JScrollPane();
        tbl_Doc = new javax.swing.JTable();
        jLabel51 = new javax.swing.JLabel();
        txt_buscard = new javax.swing.JTextField();
        ingresad = new javax.swing.JLabel();
        eliminard = new javax.swing.JLabel();
        modificard = new javax.swing.JLabel();
        Panel_Ingresar_EC1 = new javax.swing.JPanel();
        Texto_Ingresar_EC1 = new javax.swing.JLabel();
        Panel_Modificar_EC1 = new javax.swing.JPanel();
        Texto_Modificar_EC1 = new javax.swing.JLabel();
        Panel_Eliminar_EC1 = new javax.swing.JPanel();
        Texto_Eliminar_EC1 = new javax.swing.JLabel();
        Panel_Consultar_EC1 = new javax.swing.JPanel();
        Texto_Consultar_EC1 = new javax.swing.JLabel();
        Panel_CuentaContable = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_IDCuenta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_NombreCuenta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_IDClasif = new javax.swing.JTextField();
        jLabel_clasificacion = new javax.swing.JLabel();
        jComboBoxIDClasificacion = new javax.swing.JComboBox<>();
        jTextField_SaldoA = new javax.swing.JTextField();
        jLabel_SaldoA = new javax.swing.JLabel();
        jLabel_Ca = new javax.swing.JLabel();
        jTextField_CargosA = new javax.swing.JTextField();
        jLabel_AC = new javax.swing.JLabel();
        jTextField_AbonosA = new javax.swing.JTextField();
        jLabel_SA = new javax.swing.JLabel();
        jTextField_SaldoActual = new javax.swing.JTextField();
        jTextField_Buscar = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Descripcion = new javax.swing.JTextArea();
        jLabel45 = new javax.swing.JLabel();
        jLabel_IngresarCC = new javax.swing.JLabel();
        jLabel_ModificarCC = new javax.swing.JLabel();
        jLabel_EliminarCC = new javax.swing.JLabel();
        jScrollPane40 = new javax.swing.JScrollPane();
        tbl_CuentaContable = new javax.swing.JTable();
        jLabel_TituloCC = new javax.swing.JLabel();
        Panel_Ingresar_CC = new javax.swing.JPanel();
        Texto_Ingresar_CC = new javax.swing.JLabel();
        Panel_Modificar_CC = new javax.swing.JPanel();
        Texto_Modificar_CC = new javax.swing.JLabel();
        Panel_Eliminar_CC = new javax.swing.JPanel();
        Texto_Eliminar_CC = new javax.swing.JLabel();
        Panel_Consultar_CC = new javax.swing.JPanel();
        Texto_Consultar_CC = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton_PDF = new javax.swing.JButton();
        jPanel_MantenimientoClasiCuenta = new javax.swing.JPanel();
        jLabel_CC = new javax.swing.JLabel();
        Panel_IngresarS = new javax.swing.JPanel();
        Texto_IngresarS = new javax.swing.JLabel();
        Panel_ModificarS = new javax.swing.JPanel();
        Texto_ModificarS = new javax.swing.JLabel();
        Panel_EliminarS = new javax.swing.JPanel();
        Texto_EliminarS = new javax.swing.JLabel();
        Panel_ConsultarS = new javax.swing.JPanel();
        Texto_ConsultarS = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_idclasi = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_nombrecla = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_buscarclasi = new javax.swing.JTextField();
        jLabel_Ingresar = new javax.swing.JLabel();
        jLabel_Eliminar = new javax.swing.JLabel();
        jLabel_Modificar = new javax.swing.JLabel();
        jScrollPane39 = new javax.swing.JScrollPane();
        tbl_Clasi = new javax.swing.JTable();
        jPanel_MantenimientoMoneda = new javax.swing.JPanel();
        jLabel_MMon = new javax.swing.JLabel();
        txt_IDM = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_NombreM = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_TipoM = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_estM = new javax.swing.JTextField();
        jScrollPane38 = new javax.swing.JScrollPane();
        tbl_Moneda = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        txt_buscarMon = new javax.swing.JTextField();
        ingresar = new javax.swing.JLabel();
        eliminar = new javax.swing.JLabel();
        modificar = new javax.swing.JLabel();
        Panel_Ingresar_EC = new javax.swing.JPanel();
        Texto_Ingresar_EC = new javax.swing.JLabel();
        Panel_Modificar_EC = new javax.swing.JPanel();
        Texto_Modificar_EC = new javax.swing.JLabel();
        Panel_Eliminar_EC = new javax.swing.JPanel();
        Texto_Eliminar_EC = new javax.swing.JLabel();
        Panel_Consultar_EC = new javax.swing.JPanel();
        Texto_Consultar_EC = new javax.swing.JLabel();
        Panel_Bancos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Panel_MIMEC = new javax.swing.JPanel();
        jLabel_MantenimientoM = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Cant_Moneda = new javax.swing.JLabel();
        Panel_MIMEC1 = new javax.swing.JPanel();
        jLabel_MantenimientoM1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        Cant_CC = new javax.swing.JLabel();
        Panel_MIMECContable = new javax.swing.JPanel();
        jLabel_MantenimientoM2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Cant_CuCon = new javax.swing.JLabel();
        Panel_MIMEDocumento = new javax.swing.JPanel();
        jLabel_MantenimientoM3 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        Cant_DB = new javax.swing.JLabel();
        Panel_MIMEConcepto = new javax.swing.JPanel();
        jLabel_MantenimientoM4 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        Cant_CB = new javax.swing.JLabel();
        Panel_MIMEMBE = new javax.swing.JPanel();
        jLabel_MantenimientoM5 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        Cant_BE = new javax.swing.JLabel();
        Panel_MIMBD = new javax.swing.JPanel();
        jLabel_MantenimientoM6 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        Cant_MBD = new javax.swing.JLabel();
        Panel_MIMFP = new javax.swing.JPanel();
        jLabel_MantenimientoM7 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        Cant_FP = new javax.swing.JLabel();
        Panel_MB = new javax.swing.JPanel();
        jLabel_MantenimientoM8 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        Cant_B = new javax.swing.JLabel();
        Panel_MCBEnc = new javax.swing.JPanel();
        jLabel_MantenimientoM9 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        Cant_CBE = new javax.swing.JLabel();
        Panel_Consultas = new javax.swing.JPanel();
        jLabel_MantenimientoM10 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        Panel_MCBEnc2 = new javax.swing.JPanel();
        jLabel_MantenimientoM11 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        Cant_CBD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel_ConsultaBancos_Saldos.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_ConsultaBancos_Saldos.setPreferredSize(new java.awt.Dimension(1880, 900));

        tbl_ConsultaDet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_ConsultaDet.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_ConsultaDet.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_ConsultaDet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ConsultaDetMouseClicked(evt);
            }
        });
        tbl_ConsultaDet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_ConsultaDetKeyReleased(evt);
            }
        });
        jScrollPane47.setViewportView(tbl_ConsultaDet);

        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setText("Consulta de Saldos, Cuentas");

        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setText("Consulta por cuentas (saldos) ");

        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setText("Consulta por Clasificacion");

        tbl_ConsultaEnc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_ConsultaEnc.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_ConsultaEnc.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_ConsultaEnc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ConsultaEncMouseClicked(evt);
            }
        });
        tbl_ConsultaEnc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_ConsultaEncKeyReleased(evt);
            }
        });
        jScrollPane48.setViewportView(tbl_ConsultaEnc);

        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel105.setText("X");
        jLabel105.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel105MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_ConsultaBancos_SaldosLayout = new javax.swing.GroupLayout(jPanel_ConsultaBancos_Saldos);
        jPanel_ConsultaBancos_Saldos.setLayout(jPanel_ConsultaBancos_SaldosLayout);
        jPanel_ConsultaBancos_SaldosLayout.setHorizontalGroup(
            jPanel_ConsultaBancos_SaldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ConsultaBancos_SaldosLayout.createSequentialGroup()
                .addGroup(jPanel_ConsultaBancos_SaldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ConsultaBancos_SaldosLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_ConsultaBancos_SaldosLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(jPanel_ConsultaBancos_SaldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane47, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(136, 136, 136)
                        .addGroup(jPanel_ConsultaBancos_SaldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane48, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(522, Short.MAX_VALUE))
        );
        jPanel_ConsultaBancos_SaldosLayout.setVerticalGroup(
            jPanel_ConsultaBancos_SaldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ConsultaBancos_SaldosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel94)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel105)
                .addGap(36, 36, 36)
                .addGroup(jPanel_ConsultaBancos_SaldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(jLabel102))
                .addGap(18, 18, 18)
                .addGroup(jPanel_ConsultaBancos_SaldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane47, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane48, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(586, Short.MAX_VALUE))
        );

        jPanel_Mantenimiento_CBD.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_Mantenimiento_CBD.setPreferredSize(new java.awt.Dimension(1880, 900));
        jPanel_Mantenimiento_CBD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MMon4.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        jLabel_MMon4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MMon4.setText("MANTENIMIENTO COINCILIACION BANCARIA DETALLE.");
        jPanel_Mantenimiento_CBD.add(jLabel_MMon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        tbl_CBD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_CBD.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_CBD.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_CBD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CBDMouseClicked(evt);
            }
        });
        tbl_CBD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_CBDKeyReleased(evt);
            }
        });
        jScrollPane46.setViewportView(tbl_CBD);

        jPanel_Mantenimiento_CBD.add(jScrollPane46, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, 600, 190));

        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_Mantenimiento_CBD.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 520, -1, -1));

        txt_buscardCBD.setBackground(new java.awt.Color(40, 41, 46));
        txt_buscardCBD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_buscardCBD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscardCBDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscardCBDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buscardCBDKeyTyped(evt);
            }
        });
        jPanel_Mantenimiento_CBD.add(txt_buscardCBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 520, 219, -1));

        IngresaB1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        IngresaB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IngresaB1MouseClicked(evt);
            }
        });
        jPanel_Mantenimiento_CBD.add(IngresaB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 500, -1, -1));

        EliminarB1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        EliminarB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarB1MouseClicked(evt);
            }
        });
        jPanel_Mantenimiento_CBD.add(EliminarB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 500, -1, -1));

        ModificarB1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        ModificarB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModificarB1MouseClicked(evt);
            }
        });
        jPanel_Mantenimiento_CBD.add(ModificarB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 500, -1, -1));

        Panel_Ingresar_B1.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Ingresar_B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Ingresar_B1MouseClicked(evt);
            }
        });
        Panel_Ingresar_B1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Ingresar_B1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Ingresar_B1.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Ingresar_B1.setText("Ingresar");
        Texto_Ingresar_B1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Ingresar_B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Ingresar_B1MouseClicked(evt);
            }
        });
        Panel_Ingresar_B1.add(Texto_Ingresar_B1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_Mantenimiento_CBD.add(Panel_Ingresar_B1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 130, 50));

        Panel_Modificar_B1.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Modificar_B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Modificar_B1MouseClicked(evt);
            }
        });
        Panel_Modificar_B1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Modificar_B1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Modificar_B1.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Modificar_B1.setText("Modificar");
        Texto_Modificar_B1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Modificar_B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Modificar_B1MouseClicked(evt);
            }
        });
        Panel_Modificar_B1.add(Texto_Modificar_B1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_Mantenimiento_CBD.add(Panel_Modificar_B1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 130, 50));

        Panel_Eliminar_B1.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Eliminar_B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Eliminar_B1MouseClicked(evt);
            }
        });
        Panel_Eliminar_B1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Eliminar_B1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Eliminar_B1.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Eliminar_B1.setText("Eliminar");
        Texto_Eliminar_B1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Eliminar_B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Eliminar_B1MouseClicked(evt);
            }
        });
        Panel_Eliminar_B1.add(Texto_Eliminar_B1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_Mantenimiento_CBD.add(Panel_Eliminar_B1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 130, 50));

        Panel_Consultar_B1.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Consultar_B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Consultar_B1MouseClicked(evt);
            }
        });
        Panel_Consultar_B1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Consultar_B1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Consultar_B1.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Consultar_B1.setText("Consultar");
        Texto_Consultar_B1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Consultar_B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Consultar_B1MouseClicked(evt);
            }
        });
        Panel_Consultar_B1.add(Texto_Consultar_B1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_Mantenimiento_CBD.add(Panel_Consultar_B1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 180, 130, 50));

        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("ID ENCABEZADO");
        jPanel_Mantenimiento_CBD.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 90, -1));

        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("CODIGO CONCEPTO");
        jPanel_Mantenimiento_CBD.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, -1));

        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("FECHA APLICACION");
        jPanel_Mantenimiento_CBD.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, -1, -1));

        txt_fechaap.setBackground(new java.awt.Color(40, 41, 46));
        txt_fechaap.setForeground(new java.awt.Color(153, 153, 153));
        txt_fechaap.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Mantenimiento_CBD.add(txt_fechaap, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, 139, -1));

        jLabel_ID_Encabezado.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_Encabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel_Mantenimiento_CBD.add(jLabel_ID_Encabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 40, 20));

        jComboBoxIDFormaPago.setBackground(new java.awt.Color(40, 41, 46));
        jComboBoxIDFormaPago.setForeground(new java.awt.Color(153, 153, 153));
        jComboBoxIDFormaPago.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBoxIDFormaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIDFormaPagoActionPerformed(evt);
            }
        });
        jPanel_Mantenimiento_CBD.add(jComboBoxIDFormaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 320, 120, -1));

        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("DESCRIPCION");
        jPanel_Mantenimiento_CBD.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 300, 80, -1));

        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("ID FORMA DE PAGO");
        jPanel_Mantenimiento_CBD.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 300, 100, -1));

        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setText("BENEFICIARIO");
        jPanel_Mantenimiento_CBD.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 100, -1));

        txt_beneficiario.setBackground(new java.awt.Color(40, 41, 46));
        txt_beneficiario.setForeground(new java.awt.Color(153, 153, 153));
        txt_beneficiario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Mantenimiento_CBD.add(txt_beneficiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 130, -1));

        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("ESTADO CONCILACION");
        jPanel_Mantenimiento_CBD.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, 120, -1));

        txt_estcon.setBackground(new java.awt.Color(40, 41, 46));
        txt_estcon.setForeground(new java.awt.Color(153, 153, 153));
        txt_estcon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Mantenimiento_CBD.add(txt_estcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, 130, -1));

        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("ABONO");
        jPanel_Mantenimiento_CBD.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 430, 110, -1));

        txt_abono.setBackground(new java.awt.Color(40, 41, 46));
        txt_abono.setForeground(new java.awt.Color(153, 153, 153));
        txt_abono.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Mantenimiento_CBD.add(txt_abono, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 450, 130, -1));

        jLabel_Idcodigoconcepto.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Idcodigoconcepto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel_Mantenimiento_CBD.add(jLabel_Idcodigoconcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, 40, 20));

        jComboBoxCODIGOCONCEPTO.setBackground(new java.awt.Color(40, 41, 46));
        jComboBoxCODIGOCONCEPTO.setForeground(new java.awt.Color(153, 153, 153));
        jComboBoxCODIGOCONCEPTO.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBoxCODIGOCONCEPTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCODIGOCONCEPTOActionPerformed(evt);
            }
        });
        jPanel_Mantenimiento_CBD.add(jComboBoxCODIGOCONCEPTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 120, -1));

        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setText("CARGO");
        jPanel_Mantenimiento_CBD.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 110, -1));

        txt_cargo.setBackground(new java.awt.Color(40, 41, 46));
        txt_cargo.setForeground(new java.awt.Color(153, 153, 153));
        txt_cargo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Mantenimiento_CBD.add(txt_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 450, 130, -1));

        jComboBoxIDEncabezado.setBackground(new java.awt.Color(40, 41, 46));
        jComboBoxIDEncabezado.setForeground(new java.awt.Color(153, 153, 153));
        jComboBoxIDEncabezado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBoxIDEncabezado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIDEncabezadoActionPerformed(evt);
            }
        });
        jPanel_Mantenimiento_CBD.add(jComboBoxIDEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 120, -1));

        jLabel_idformapago.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_Mantenimiento_CBD.add(jLabel_idformapago, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 320, 40, 20));

        jTextArea_Descrip.setColumns(20);
        jTextArea_Descrip.setRows(5);
        jScrollPane2.setViewportView(jTextArea_Descrip);

        jPanel_Mantenimiento_CBD.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 320, -1, -1));

        jPanel_Manatenimiento_ConBanEn.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_Manatenimiento_ConBanEn.setPreferredSize(new java.awt.Dimension(1880, 900));
        jPanel_Manatenimiento_ConBanEn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MMon3.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        jLabel_MMon3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MMon3.setText("Conciliacion Bancaria Encabezado");
        jPanel_Manatenimiento_ConBanEn.add(jLabel_MMon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, -1));

        txt_IdEnca.setBackground(new java.awt.Color(40, 41, 46));
        txt_IdEnca.setForeground(new java.awt.Color(255, 255, 255));
        txt_IdEnca.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Manatenimiento_ConBanEn.add(txt_IdEnca, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, 110, -1));

        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("ID Encabezado");
        jPanel_Manatenimiento_ConBanEn.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, -1, -1));

        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Cargo A Conciliar");
        jPanel_Manatenimiento_ConBanEn.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, -1, -1));

        txt_CargoAConciliar.setBackground(new java.awt.Color(40, 41, 46));
        txt_CargoAConciliar.setForeground(new java.awt.Color(255, 255, 255));
        txt_CargoAConciliar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Manatenimiento_ConBanEn.add(txt_CargoAConciliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 110, -1));

        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Abono A Conciliar");
        jPanel_Manatenimiento_ConBanEn.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, 90, -1));

        txt_AbonoA_Conciliar.setBackground(new java.awt.Color(40, 41, 46));
        txt_AbonoA_Conciliar.setForeground(new java.awt.Color(255, 255, 255));
        txt_AbonoA_Conciliar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Manatenimiento_ConBanEn.add(txt_AbonoA_Conciliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 104, -1));

        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Saldo Corte");
        jPanel_Manatenimiento_ConBanEn.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 270, -1, -1));

        txt_SaldoCorte.setBackground(new java.awt.Color(40, 41, 46));
        txt_SaldoCorte.setForeground(new java.awt.Color(255, 255, 255));
        txt_SaldoCorte.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Manatenimiento_ConBanEn.add(txt_SaldoCorte, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 290, 120, -1));

        tbl_ConcilacioEn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_ConcilacioEn.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_ConcilacioEn.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_ConcilacioEn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ConcilacioEnMouseClicked(evt);
            }
        });
        jScrollPane45.setViewportView(tbl_ConcilacioEn);

        jPanel_Manatenimiento_ConBanEn.add(jScrollPane45, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 600, 190));

        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_Manatenimiento_ConBanEn.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, -1, -1));

        txt_BuscarCoBaEn.setBackground(new java.awt.Color(40, 41, 46));
        txt_BuscarCoBaEn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_BuscarCoBaEn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_BuscarCoBaEnKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarCoBaEnKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_BuscarCoBaEnKeyTyped(evt);
            }
        });
        jPanel_Manatenimiento_ConBanEn.add(txt_BuscarCoBaEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 219, -1));

        ingresarConcilacionEn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        ingresarConcilacionEn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresarConcilacionEnMouseClicked(evt);
            }
        });
        jPanel_Manatenimiento_ConBanEn.add(ingresarConcilacionEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 390, -1, -1));

        eliminarConcilacionEn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        eliminarConcilacionEn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarConcilacionEnMouseClicked(evt);
            }
        });
        jPanel_Manatenimiento_ConBanEn.add(eliminarConcilacionEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 390, -1, -1));

        modificarConcilacionEn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        modificarConcilacionEn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificarConcilacionEnMouseClicked(evt);
            }
        });
        jPanel_Manatenimiento_ConBanEn.add(modificarConcilacionEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 390, -1, -1));

        Panel_Ingresar_CoBaEn.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Ingresar_CoBaEn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Ingresar_CoBaEnMouseClicked(evt);
            }
        });
        Panel_Ingresar_CoBaEn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Ingresar_CoBaEn.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Ingresar_CoBaEn.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Ingresar_CoBaEn.setText("Ingresar");
        Texto_Ingresar_CoBaEn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Ingresar_CoBaEn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Ingresar_CoBaEnMouseClicked(evt);
            }
        });
        Panel_Ingresar_CoBaEn.add(Texto_Ingresar_CoBaEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_Manatenimiento_ConBanEn.add(Panel_Ingresar_CoBaEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 130, 50));

        Panel_Modificar_CoBaEn.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Modificar_CoBaEn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Modificar_CoBaEnMouseClicked(evt);
            }
        });
        Panel_Modificar_CoBaEn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Modificar_CoBaEn.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Modificar_CoBaEn.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Modificar_CoBaEn.setText("Modificar");
        Texto_Modificar_CoBaEn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Modificar_CoBaEn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Modificar_CoBaEnMouseClicked(evt);
            }
        });
        Panel_Modificar_CoBaEn.add(Texto_Modificar_CoBaEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_Manatenimiento_ConBanEn.add(Panel_Modificar_CoBaEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 130, 50));

        Panel_Eliminar_CoBaEn.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Eliminar_CoBaEn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Eliminar_CoBaEnMouseClicked(evt);
            }
        });
        Panel_Eliminar_CoBaEn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Eliminar_CoBaEn.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Eliminar_CoBaEn.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Eliminar_CoBaEn.setText("Eliminar");
        Texto_Eliminar_CoBaEn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Eliminar_CoBaEn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Eliminar_CoBaEnMouseClicked(evt);
            }
        });
        Panel_Eliminar_CoBaEn.add(Texto_Eliminar_CoBaEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_Manatenimiento_ConBanEn.add(Panel_Eliminar_CoBaEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 130, 50));

        Panel_Consultar_CoBaEn.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Consultar_CoBaEn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Consultar_CoBaEnMouseClicked(evt);
            }
        });
        Panel_Consultar_CoBaEn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Consultar_CoBaEn.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Consultar_CoBaEn.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Consultar_CoBaEn.setText("Consultar");
        Texto_Consultar_CoBaEn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Consultar_CoBaEn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Consultar_CoBaEnMouseClicked(evt);
            }
        });
        Panel_Consultar_CoBaEn.add(Texto_Consultar_CoBaEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_Manatenimiento_ConBanEn.add(Panel_Consultar_CoBaEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 180, 130, 50));

        txt_Cargo_Conciliado.setBackground(new java.awt.Color(40, 41, 46));
        txt_Cargo_Conciliado.setForeground(new java.awt.Color(255, 255, 255));
        txt_Cargo_Conciliado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Manatenimiento_ConBanEn.add(txt_Cargo_Conciliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 110, -1));

        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("Cargo Conciliado");
        jPanel_Manatenimiento_ConBanEn.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, -1, -1));

        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("Abono Conciliado");
        jPanel_Manatenimiento_ConBanEn.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 330, -1, -1));

        txt_Abono_Conciliado.setBackground(new java.awt.Color(40, 41, 46));
        txt_Abono_Conciliado.setForeground(new java.awt.Color(255, 255, 255));
        txt_Abono_Conciliado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Manatenimiento_ConBanEn.add(txt_Abono_Conciliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 110, -1));

        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("Saldo Final");
        jPanel_Manatenimiento_ConBanEn.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 330, 90, -1));

        txt_Saldo_Final.setBackground(new java.awt.Color(40, 41, 46));
        txt_Saldo_Final.setForeground(new java.awt.Color(255, 255, 255));
        txt_Saldo_Final.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Manatenimiento_ConBanEn.add(txt_Saldo_Final, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 350, 104, -1));

        jPanel_MantenimientoBanco.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoBanco.setPreferredSize(new java.awt.Dimension(1880, 900));
        jPanel_MantenimientoBanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MMon2.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        jLabel_MMon2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MMon2.setText("MANTENIMIENTO BANCOS");
        jPanel_MantenimientoBanco.add(jLabel_MMon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        tbl_Bancos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_Bancos.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Bancos.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_Bancos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_BancosMouseClicked(evt);
            }
        });
        tbl_Bancos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_BancosKeyReleased(evt);
            }
        });
        jScrollPane44.setViewportView(tbl_Bancos);

        jPanel_MantenimientoBanco.add(jScrollPane44, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 550, 600, 190));

        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientoBanco.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, -1, -1));

        txt_buscardBan.setBackground(new java.awt.Color(40, 41, 46));
        txt_buscardBan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_buscardBan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscardBanKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscardBanKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buscardBanKeyTyped(evt);
            }
        });
        jPanel_MantenimientoBanco.add(txt_buscardBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 510, 219, -1));

        IngresaB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        IngresaB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IngresaBMouseClicked(evt);
            }
        });
        jPanel_MantenimientoBanco.add(IngresaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 490, -1, -1));

        EliminarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        EliminarB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarBMouseClicked(evt);
            }
        });
        jPanel_MantenimientoBanco.add(EliminarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 490, -1, -1));

        ModificarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        ModificarB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModificarBMouseClicked(evt);
            }
        });
        jPanel_MantenimientoBanco.add(ModificarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 490, -1, -1));

        Panel_Ingresar_B.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Ingresar_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Ingresar_BMouseClicked(evt);
            }
        });
        Panel_Ingresar_B.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Ingresar_B.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Ingresar_B.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Ingresar_B.setText("Ingresar");
        Texto_Ingresar_B.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Ingresar_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Ingresar_BMouseClicked(evt);
            }
        });
        Panel_Ingresar_B.add(Texto_Ingresar_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoBanco.add(Panel_Ingresar_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 130, 50));

        Panel_Modificar_B.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Modificar_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Modificar_BMouseClicked(evt);
            }
        });
        Panel_Modificar_B.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Modificar_B.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Modificar_B.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Modificar_B.setText("Modificar");
        Texto_Modificar_B.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Modificar_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Modificar_BMouseClicked(evt);
            }
        });
        Panel_Modificar_B.add(Texto_Modificar_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientoBanco.add(Panel_Modificar_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 130, 50));

        Panel_Eliminar_B.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Eliminar_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Eliminar_BMouseClicked(evt);
            }
        });
        Panel_Eliminar_B.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Eliminar_B.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Eliminar_B.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Eliminar_B.setText("Eliminar");
        Texto_Eliminar_B.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Eliminar_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Eliminar_BMouseClicked(evt);
            }
        });
        Panel_Eliminar_B.add(Texto_Eliminar_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoBanco.add(Panel_Eliminar_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 130, 50));

        Panel_Consultar_B.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Consultar_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Consultar_BMouseClicked(evt);
            }
        });
        Panel_Consultar_B.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Consultar_B.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Consultar_B.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Consultar_B.setText("Consultar");
        Texto_Consultar_B.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Consultar_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Consultar_BMouseClicked(evt);
            }
        });
        Panel_Consultar_B.add(Texto_Consultar_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientoBanco.add(Panel_Consultar_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 130, 50));

        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("ID Banco");
        jPanel_MantenimientoBanco.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 63, -1));

        jTextField_IDBanco.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_IDBanco.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_IDBanco.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoBanco.add(jTextField_IDBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 110, -1));

        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("Nombre Banco");
        jPanel_MantenimientoBanco.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, -1, -1));

        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("Nombre Cuenta");
        jPanel_MantenimientoBanco.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, -1));

        jTextField_NombreBanco.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_NombreBanco.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_NombreBanco.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoBanco.add(jTextField_NombreBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 139, -1));

        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("ID Moneda");
        jPanel_MantenimientoBanco.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, -1, -1));

        jTextField_NombreC.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_NombreC.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_NombreC.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoBanco.add(jTextField_NombreC, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 139, -1));

        jLabel_ID_Moneda.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_Moneda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel_MantenimientoBanco.add(jLabel_ID_Moneda, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, 40, 20));

        jComboBoxIDMoneda.setBackground(new java.awt.Color(40, 41, 46));
        jComboBoxIDMoneda.setForeground(new java.awt.Color(153, 153, 153));
        jComboBoxIDMoneda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBoxIDMoneda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIDMonedaActionPerformed(evt);
            }
        });
        jPanel_MantenimientoBanco.add(jComboBoxIDMoneda, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 120, -1));

        jTextField_ClaveBan.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_ClaveBan.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_ClaveBan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoBanco.add(jTextField_ClaveBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, 110, -1));

        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("Clave Banco");
        jPanel_MantenimientoBanco.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 80, -1));

        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("Funcionario");
        jPanel_MantenimientoBanco.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 280, 100, -1));

        jTextField_Funcionario.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_Funcionario.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Funcionario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField_Funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_FuncionarioActionPerformed(evt);
            }
        });
        jPanel_MantenimientoBanco.add(jTextField_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 310, 130, -1));

        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("Telefono");
        jPanel_MantenimientoBanco.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 100, -1));

        jTextField_Telefono.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_Telefono.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Telefono.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoBanco.add(jTextField_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 130, -1));

        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("Numero Plaza");
        jPanel_MantenimientoBanco.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 100, -1));

        jTextField_NumeroPlaza.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_NumeroPlaza.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_NumeroPlaza.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoBanco.add(jTextField_NumeroPlaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 130, -1));

        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("Saldo Inicial");
        jPanel_MantenimientoBanco.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 110, -1));

        jTextField_SaldoI.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_SaldoI.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_SaldoI.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoBanco.add(jTextField_SaldoI, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 400, 130, -1));

        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("ID Movimiento Enc");
        jPanel_MantenimientoBanco.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, -1, -1));

        jLabel_IdMovimiento.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IdMovimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel_MantenimientoBanco.add(jLabel_IdMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 460, 40, 20));

        jComboBoxIDMovEn.setBackground(new java.awt.Color(40, 41, 46));
        jComboBoxIDMovEn.setForeground(new java.awt.Color(153, 153, 153));
        jComboBoxIDMovEn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBoxIDMovEn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIDMovEnActionPerformed(evt);
            }
        });
        jPanel_MantenimientoBanco.add(jComboBoxIDMovEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 120, -1));

        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("Numero Sucursal");
        jPanel_MantenimientoBanco.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 110, -1));

        jTextField_NumeroS.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_NumeroS.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_NumeroS.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoBanco.add(jTextField_NumeroS, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 130, -1));

        jPanel_Forma_de_Pago.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_Forma_de_Pago.setPreferredSize(new java.awt.Dimension(1880, 900));
        jPanel_Forma_de_Pago.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Forma de Pago ");
        jPanel_Forma_de_Pago.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 14, -1, -1));

        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("ID Forma Pago");
        jPanel_Forma_de_Pago.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, -1, -1));

        jTextField_IDForma.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_IDForma.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_IDForma.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Forma_de_Pago.add(jTextField_IDForma, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 120, -1));

        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Tipo Pago");
        jPanel_Forma_de_Pago.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, -1, -1));

        jTextField_BuscarFP.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_BuscarFP.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_BuscarFP.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField_BuscarFP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextField_BuscarFPMouseReleased(evt);
            }
        });
        jTextField_BuscarFP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_BuscarFPKeyReleased(evt);
            }
        });
        jPanel_Forma_de_Pago.add(jTextField_BuscarFP, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 270, -1));

        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("Insertar");
        jLabel66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel66MouseClicked(evt);
            }
        });
        jPanel_Forma_de_Pago.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 220, -1, -1));

        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Modificar");
        jLabel67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel67MouseClicked(evt);
            }
        });
        jPanel_Forma_de_Pago.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 220, -1, -1));

        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Eliminar");
        jLabel68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel68MouseClicked(evt);
            }
        });
        jPanel_Forma_de_Pago.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 250, -1, -1));

        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Buscar");
        jPanel_Forma_de_Pago.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, -1, -1));

        jTextField_TipoPago.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_TipoPago.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_TipoPago.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Forma_de_Pago.add(jTextField_TipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, 120, -1));

        tbl_FormaPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_FormaPago.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_FormaPago.setSelectionBackground(new java.awt.Color(40, 41, 46));
        tbl_FormaPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_FormaPagoMouseClicked(evt);
            }
        });
        tbl_FormaPago.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                tbl_FormaPagoCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jScrollPane43.setViewportView(tbl_FormaPago);

        jPanel_Forma_de_Pago.add(jScrollPane43, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 620, 170));

        jPanel_MantenimientoMovBanDet.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoMovBanDet.setPreferredSize(new java.awt.Dimension(1880, 900));
        jPanel_MantenimientoMovBanDet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setForeground(java.awt.Color.white);
        jLabel54.setText("Movimiento Bancario Detalle ");
        jPanel_MantenimientoMovBanDet.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 15, -1, -1));

        jLabel55.setForeground(java.awt.Color.white);
        jLabel55.setText("ID Movimiento Encabezado ");
        jPanel_MantenimientoMovBanDet.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, -1));

        jLabel56.setForeground(java.awt.Color.white);
        jLabel56.setText("Codigo Concepto ");
        jPanel_MantenimientoMovBanDet.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, -1));

        jLabel57.setForeground(java.awt.Color.white);
        jLabel57.setText("Saldo Deudor:");
        jPanel_MantenimientoMovBanDet.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, -1, -1));

        jTextField_Saldo.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_Saldo.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Saldo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoMovBanDet.add(jTextField_Saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 160, 20));

        jLabel58.setForeground(java.awt.Color.white);
        jLabel58.setText("Saldo Acreedor:");
        jPanel_MantenimientoMovBanDet.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 120, -1, -1));

        jTextField_tipoSaldo.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_tipoSaldo.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_tipoSaldo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoMovBanDet.add(jTextField_tipoSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 150, 160, 20));

        jLabel_codigoConcepto.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoMovBanDet.add(jLabel_codigoConcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 30, 20));

        jLabel_IDEnc.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_MantenimientoMovBanDet.add(jLabel_IDEnc, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 30, 20));

        jLabel59.setForeground(java.awt.Color.white);
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Buscar por Concepto");
        jPanel_MantenimientoMovBanDet.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 120, 20));

        jTextField_BuscarMov.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_BuscarMov.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_BuscarMov.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField_BuscarMov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_BuscarMovKeyReleased(evt);
            }
        });
        jPanel_MantenimientoMovBanDet.add(jTextField_BuscarMov, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 250, -1));

        tbl_MovBancDet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_MovBancDet.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_MovBancDet.setSelectionBackground(new java.awt.Color(40, 41, 46));
        tbl_MovBancDet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_MovBancDetMouseClicked(evt);
            }
        });
        tbl_MovBancDet.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                tbl_MovBancDetCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jScrollPane42.setViewportView(tbl_MovBancDet);

        jPanel_MantenimientoMovBanDet.add(jScrollPane42, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 820, 170));

        jLabel60.setForeground(java.awt.Color.white);
        jLabel60.setText("Insertar");
        jLabel60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel60MouseClicked(evt);
            }
        });
        jPanel_MantenimientoMovBanDet.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 250, -1, -1));

        jLabel61.setForeground(java.awt.Color.white);
        jLabel61.setText("Modificar");
        jLabel61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel61MouseClicked(evt);
            }
        });
        jPanel_MantenimientoMovBanDet.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 250, -1, -1));

        jLabel62.setForeground(java.awt.Color.white);
        jLabel62.setText("Eliminar");
        jLabel62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel62MouseClicked(evt);
            }
        });
        jPanel_MantenimientoMovBanDet.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 280, -1, -1));

        jComboBox_codigoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_codigoCActionPerformed(evt);
            }
        });
        jPanel_MantenimientoMovBanDet.add(jComboBox_codigoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 170, -1));

        jComboBox_Encabezado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_EncabezadoActionPerformed(evt);
            }
        });
        jPanel_MantenimientoMovBanDet.add(jComboBox_Encabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 160, -1));

        JPanel_MantenimientoMovimientoBanEn.setBackground(new java.awt.Color(28, 27, 33));
        JPanel_MantenimientoMovimientoBanEn.setPreferredSize(new java.awt.Dimension(1880, 900));
        JPanel_MantenimientoMovimientoBanEn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_CodigoMovimientoE.setBackground(new java.awt.Color(40, 41, 46));
        txt_CodigoMovimientoE.setForeground(new java.awt.Color(153, 153, 153));
        txt_CodigoMovimientoE.setBorder(null);
        txt_CodigoMovimientoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CodigoMovimientoEActionPerformed(evt);
            }
        });
        JPanel_MantenimientoMovimientoBanEn.add(txt_CodigoMovimientoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 140, 20));

        jLabel_CodigoConcepto1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CodigoConcepto1.setText("Codigo Movimiento ");
        JPanel_MantenimientoMovimientoBanEn.add(jLabel_CodigoConcepto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));

        jLabel_DPIAP1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_DPIAP1.setText("Nombre Documento");
        JPanel_MantenimientoMovimientoBanEn.add(jLabel_DPIAP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, -1));

        jComboBox_Nombre_Movimiento.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_Nombre_Movimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Nombre_MovimientoActionPerformed(evt);
            }
        });
        JPanel_MantenimientoMovimientoBanEn.add(jComboBox_Nombre_Movimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 140, -1));

        txt_Fecha.setBackground(new java.awt.Color(40, 41, 46));
        txt_Fecha.setForeground(new java.awt.Color(153, 153, 153));
        txt_Fecha.setBorder(null);
        txt_Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_FechaActionPerformed(evt);
            }
        });
        JPanel_MantenimientoMovimientoBanEn.add(txt_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 140, 20));

        jLabel_Fecha.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Fecha.setText("Fecha");
        JPanel_MantenimientoMovimientoBanEn.add(jLabel_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, -1, -1));

        jLabel_IngresarMBEN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_IngresarMBEN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_IngresarMBEN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_IngresarMBENMouseClicked(evt);
            }
        });
        JPanel_MantenimientoMovimientoBanEn.add(jLabel_IngresarMBEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, 50, 50));

        jLabel_Modificar_MBEN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_Modificar_MBEN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Modificar_MBENMouseClicked(evt);
            }
        });
        JPanel_MantenimientoMovimientoBanEn.add(jLabel_Modificar_MBEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, 50, 50));

        jLabel_Eliminar_MBEN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar_MBEN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Eliminar_MBENMouseClicked(evt);
            }
        });
        JPanel_MantenimientoMovimientoBanEn.add(jLabel_Eliminar_MBEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, 50, 50));

        tbl_MovimientoBanEn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_MovimientoBanEn.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_MovimientoBanEn.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_MovimientoBanEn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_MovimientoBanEnMouseClicked(evt);
            }
        });
        jScrollPane32.setViewportView(tbl_MovimientoBanEn);

        JPanel_MantenimientoMovimientoBanEn.add(jScrollPane32, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, 600, 190));

        txt_BuscarMovBanEn.setBackground(new java.awt.Color(40, 41, 46));
        txt_BuscarMovBanEn.setForeground(new java.awt.Color(153, 153, 153));
        txt_BuscarMovBanEn.setBorder(null);
        txt_BuscarMovBanEn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarMovBanEnActionPerformed(evt);
            }
        });
        txt_BuscarMovBanEn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarMovBanEnKeyReleased(evt);
            }
        });
        JPanel_MantenimientoMovimientoBanEn.add(txt_BuscarMovBanEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 240, 20));

        jLabel_BuscarMBEN.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_BuscarMBEN.setText("Buscar");
        jLabel_BuscarMBEN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_BuscarMBENMouseClicked(evt);
            }
        });
        JPanel_MantenimientoMovimientoBanEn.add(jLabel_BuscarMBEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 50, 20));

        jLabel_ID_Documento.setBackground(new java.awt.Color(40, 41, 46));
        jLabel_ID_Documento.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_Documento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPanel_MantenimientoMovimientoBanEn.add(jLabel_ID_Documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 90, 20));

        jLabel_NombreAP1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreAP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_NombreAP1.setText("ID Documento");
        JPanel_MantenimientoMovimientoBanEn.add(jLabel_NombreAP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 70, -1));

        Panel_IngresarMBEN.setBackground(new java.awt.Color(28, 27, 33));
        Panel_IngresarMBEN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_IngresarMBENMouseClicked(evt);
            }
        });
        Panel_IngresarMBEN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_IngresarMBEN.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_IngresarMBEN.setForeground(new java.awt.Color(255, 255, 255));
        Texto_IngresarMBEN.setText("Ingresar");
        Texto_IngresarMBEN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_IngresarMBEN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_IngresarMBENMouseClicked(evt);
            }
        });
        Panel_IngresarMBEN.add(Texto_IngresarMBEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        JPanel_MantenimientoMovimientoBanEn.add(Panel_IngresarMBEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 130, 50));

        Panel_ModificarMBEN.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ModificarMBEN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ModificarMBENMouseClicked(evt);
            }
        });
        Panel_ModificarMBEN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ModificarMBEN.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ModificarMBEN.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ModificarMBEN.setText("Modificar");
        Texto_ModificarMBEN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ModificarMBEN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ModificarMBENMouseClicked(evt);
            }
        });
        Panel_ModificarMBEN.add(Texto_ModificarMBEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        JPanel_MantenimientoMovimientoBanEn.add(Panel_ModificarMBEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 130, 50));

        Panel_EliminarMBEN.setBackground(new java.awt.Color(28, 27, 33));
        Panel_EliminarMBEN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_EliminarMBENMouseClicked(evt);
            }
        });
        Panel_EliminarMBEN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_EliminarMBEN.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_EliminarMBEN.setForeground(new java.awt.Color(255, 255, 255));
        Texto_EliminarMBEN.setText("Eliminar");
        Texto_EliminarMBEN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_EliminarMBEN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_EliminarMBENMouseClicked(evt);
            }
        });
        Panel_EliminarMBEN.add(Texto_EliminarMBEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        JPanel_MantenimientoMovimientoBanEn.add(Panel_EliminarMBEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 130, 50));

        Panel_ConsultarMBEN.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ConsultarMBEN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ConsultarMBENMouseClicked(evt);
            }
        });
        Panel_ConsultarMBEN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ConsultarMBEN.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ConsultarMBEN.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ConsultarMBEN.setText("Consultar");
        Texto_ConsultarMBEN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ConsultarMBEN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ConsultarMBENMouseClicked(evt);
            }
        });
        Panel_ConsultarMBEN.add(Texto_ConsultarMBEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        JPanel_MantenimientoMovimientoBanEn.add(Panel_ConsultarMBEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 130, 50));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        JPanel_MantenimientoMovimientoBanEn.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, -1, -1));

        jComboBox_TablasCB1.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_TablasCB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TablasCB1ActionPerformed(evt);
            }
        });
        JPanel_MantenimientoMovimientoBanEn.add(jComboBox_TablasCB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 500, 170, -1));

        jLabel53.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Movimiento Bancario Encabezado");
        JPanel_MantenimientoMovimientoBanEn.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 400, 90));

        jLabel_NombreConcepto1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreConcepto1.setText("Descripcion");
        JPanel_MantenimientoMovimientoBanEn.add(jLabel_NombreConcepto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 300, -1, -1));

        txt_Descripcion.setBackground(new java.awt.Color(40, 41, 46));
        txt_Descripcion.setForeground(new java.awt.Color(153, 153, 153));
        txt_Descripcion.setBorder(null);
        txt_Descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DescripcionActionPerformed(evt);
            }
        });
        JPanel_MantenimientoMovimientoBanEn.add(txt_Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 330, 140, 20));

        jLabel_RequisitosAP3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_RequisitosAP3.setText("Monto");
        JPanel_MantenimientoMovimientoBanEn.add(jLabel_RequisitosAP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 300, -1, -1));

        txt_Monto.setBackground(new java.awt.Color(40, 41, 46));
        txt_Monto.setForeground(new java.awt.Color(153, 153, 153));
        txt_Monto.setBorder(null);
        txt_Monto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MontoActionPerformed(evt);
            }
        });
        JPanel_MantenimientoMovimientoBanEn.add(txt_Monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, 140, 20));

        jPanel_MantenimientoCB.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoCB.setPreferredSize(new java.awt.Dimension(1880, 900));
        jPanel_MantenimientoCB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_CodigoConcepto.setBackground(new java.awt.Color(40, 41, 46));
        txt_CodigoConcepto.setForeground(new java.awt.Color(153, 153, 153));
        txt_CodigoConcepto.setBorder(null);
        txt_CodigoConcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CodigoConceptoActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCB.add(txt_CodigoConcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 140, 20));

        jLabel_CodigoConcepto.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CodigoConcepto.setText("Codigo Concepto");
        jPanel_MantenimientoCB.add(jLabel_CodigoConcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));

        jLabel_DPIAP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_DPIAP.setText("Nombre Cuenta");
        jPanel_MantenimientoCB.add(jLabel_DPIAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 300, -1, -1));

        jComboBox_Nombre_Cuenta.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_Nombre_Cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Nombre_CuentaActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCB.add(jComboBox_Nombre_Cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 330, 140, -1));

        txt_Afecta.setBackground(new java.awt.Color(40, 41, 46));
        txt_Afecta.setForeground(new java.awt.Color(153, 153, 153));
        txt_Afecta.setBorder(null);
        txt_Afecta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AfectaActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCB.add(txt_Afecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 140, 20));

        jLabel_RequisitosAP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_RequisitosAP.setText("Afecta");
        jPanel_MantenimientoCB.add(jLabel_RequisitosAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, -1, -1));

        jLabel_IngresarCB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_IngresarCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_IngresarCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_IngresarCBMouseClicked(evt);
            }
        });
        jPanel_MantenimientoCB.add(jLabel_IngresarCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, 50, 50));

        jLabel_Modificar_CB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_Modificar_CB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Modificar_CBMouseClicked(evt);
            }
        });
        jPanel_MantenimientoCB.add(jLabel_Modificar_CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, 50, 50));

        jLabel_Eliminar_CB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar_CB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Eliminar_CBMouseClicked(evt);
            }
        });
        jPanel_MantenimientoCB.add(jLabel_Eliminar_CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, 50, 50));

        tbl_CB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_CB.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_CB.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_CB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CBMouseClicked(evt);
            }
        });
        jScrollPane31.setViewportView(tbl_CB);

        jPanel_MantenimientoCB.add(jScrollPane31, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, 600, 190));

        txt_BuscarCB.setBackground(new java.awt.Color(40, 41, 46));
        txt_BuscarCB.setForeground(new java.awt.Color(153, 153, 153));
        txt_BuscarCB.setBorder(null);
        txt_BuscarCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarCBActionPerformed(evt);
            }
        });
        txt_BuscarCB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarCBKeyReleased(evt);
            }
        });
        jPanel_MantenimientoCB.add(txt_BuscarCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 240, 20));

        jLabel_BuscarAP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_BuscarAP.setText("Buscar");
        jLabel_BuscarAP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_BuscarAPMouseClicked(evt);
            }
        });
        jPanel_MantenimientoCB.add(jLabel_BuscarAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 50, 20));

        jLabel_ID_Cuenta.setBackground(new java.awt.Color(40, 41, 46));
        jLabel_ID_Cuenta.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ID_Cuenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel_MantenimientoCB.add(jLabel_ID_Cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 330, 90, 20));

        jLabel_NombreAP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreAP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_NombreAP.setText("ID Cuenta");
        jPanel_MantenimientoCB.add(jLabel_NombreAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 300, 70, -1));

        Panel_IngresarCB.setBackground(new java.awt.Color(28, 27, 33));
        Panel_IngresarCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_IngresarCBMouseClicked(evt);
            }
        });
        Panel_IngresarCB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_IngresarCB.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_IngresarCB.setForeground(new java.awt.Color(255, 255, 255));
        Texto_IngresarCB.setText("Ingresar");
        Texto_IngresarCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_IngresarCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_IngresarCBMouseClicked(evt);
            }
        });
        Panel_IngresarCB.add(Texto_IngresarCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoCB.add(Panel_IngresarCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 130, 50));

        Panel_ModificarCB.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ModificarCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ModificarCBMouseClicked(evt);
            }
        });
        Panel_ModificarCB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ModificarCB.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ModificarCB.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ModificarCB.setText("Modificar");
        Texto_ModificarCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ModificarCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ModificarCBMouseClicked(evt);
            }
        });
        Panel_ModificarCB.add(Texto_ModificarCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_MantenimientoCB.add(Panel_ModificarCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 130, 50));

        Panel_EliminarCB.setBackground(new java.awt.Color(28, 27, 33));
        Panel_EliminarCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_EliminarCBMouseClicked(evt);
            }
        });
        Panel_EliminarCB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_EliminarCB.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_EliminarCB.setForeground(new java.awt.Color(255, 255, 255));
        Texto_EliminarCB.setText("Eliminar");
        Texto_EliminarCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_EliminarCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_EliminarCBMouseClicked(evt);
            }
        });
        Panel_EliminarCB.add(Texto_EliminarCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_MantenimientoCB.add(Panel_EliminarCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 130, 50));

        Panel_ConsultarCB.setBackground(new java.awt.Color(28, 27, 33));
        Panel_ConsultarCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ConsultarCBMouseClicked(evt);
            }
        });
        Panel_ConsultarCB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_ConsultarCB.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_ConsultarCB.setForeground(new java.awt.Color(255, 255, 255));
        Texto_ConsultarCB.setText("Consultar");
        Texto_ConsultarCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_ConsultarCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_ConsultarCBMouseClicked(evt);
            }
        });
        Panel_ConsultarCB.add(Texto_ConsultarCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_MantenimientoCB.add(Panel_ConsultarCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 130, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientoCB.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, -1, -1));

        jComboBox_TablasCB.setBackground(new java.awt.Color(40, 41, 46));
        jComboBox_TablasCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TablasCBActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCB.add(jComboBox_TablasCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 500, 170, -1));

        jLabel_Buscar_Tablas_CB.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buscar_Tablas_CB.setText("Buscar");
        jLabel_Buscar_Tablas_CB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Buscar_Tablas_CBMouseClicked(evt);
            }
        });
        jPanel_MantenimientoCB.add(jLabel_Buscar_Tablas_CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 530, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Concepto Bancario");
        jPanel_MantenimientoCB.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 400, 90));

        jLabel_NombreConcepto.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreConcepto.setText("Nombre Concepto");
        jPanel_MantenimientoCB.add(jLabel_NombreConcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, -1));

        txt_Nombre_Concepto.setBackground(new java.awt.Color(40, 41, 46));
        txt_Nombre_Concepto.setForeground(new java.awt.Color(153, 153, 153));
        txt_Nombre_Concepto.setBorder(null);
        txt_Nombre_Concepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Nombre_ConceptoActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCB.add(txt_Nombre_Concepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 140, 20));

        jLabel_RequisitosAP1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_RequisitosAP1.setText("Estatus");
        jPanel_MantenimientoCB.add(jLabel_RequisitosAP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, -1, -1));

        txt_Estatus.setBackground(new java.awt.Color(40, 41, 46));
        txt_Estatus.setForeground(new java.awt.Color(153, 153, 153));
        txt_Estatus.setBorder(null);
        txt_Estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_EstatusActionPerformed(evt);
            }
        });
        jPanel_MantenimientoCB.add(txt_Estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 140, 20));

        jPanel_Mantenimiento_DocB.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_Mantenimiento_DocB.setPreferredSize(new java.awt.Dimension(1880, 900));
        jPanel_Mantenimiento_DocB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MMon1.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        jLabel_MMon1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MMon1.setText("MANTENIMIENTO DOCUMENTO BANCARIO.");
        jPanel_Mantenimiento_DocB.add(jLabel_MMon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        txt_cod.setBackground(new java.awt.Color(40, 41, 46));
        txt_cod.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Mantenimiento_DocB.add(txt_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, 110, -1));

        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("CODIGO DOCUMENTO");
        jPanel_Mantenimiento_DocB.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, -1, -1));

        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("NOMBRE DOCUMENTO");
        jPanel_Mantenimiento_DocB.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, -1, -1));

        txt_nombred.setBackground(new java.awt.Color(40, 41, 46));
        txt_nombred.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Mantenimiento_DocB.add(txt_nombred, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 110, -1));

        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("AFECTA ( +  , -  )");
        jPanel_Mantenimiento_DocB.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, 90, -1));

        txt_afec.setBackground(new java.awt.Color(40, 41, 46));
        txt_afec.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Mantenimiento_DocB.add(txt_afec, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 104, -1));

        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("ESTADO CONCEPTO");
        jPanel_Mantenimiento_DocB.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 270, -1, -1));

        txt_estd.setBackground(new java.awt.Color(40, 41, 46));
        txt_estd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Mantenimiento_DocB.add(txt_estd, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 290, 120, -1));

        tbl_Doc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_Doc.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Doc.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_Doc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DocMouseClicked(evt);
            }
        });
        jScrollPane41.setViewportView(tbl_Doc);

        jPanel_Mantenimiento_DocB.add(jScrollPane41, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, 600, 190));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_Mantenimiento_DocB.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, -1, -1));

        txt_buscard.setBackground(new java.awt.Color(40, 41, 46));
        txt_buscard.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_buscard.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscardKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscardKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buscardKeyTyped(evt);
            }
        });
        jPanel_Mantenimiento_DocB.add(txt_buscard, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 219, -1));

        ingresad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        ingresad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresadMouseClicked(evt);
            }
        });
        jPanel_Mantenimiento_DocB.add(ingresad, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 330, -1, -1));

        eliminard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        eliminard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminardMouseClicked(evt);
            }
        });
        jPanel_Mantenimiento_DocB.add(eliminard, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 330, -1, -1));

        modificard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        modificard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificardMouseClicked(evt);
            }
        });
        jPanel_Mantenimiento_DocB.add(modificard, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 330, -1, -1));

        Panel_Ingresar_EC1.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Ingresar_EC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Ingresar_EC1MouseClicked(evt);
            }
        });
        Panel_Ingresar_EC1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Ingresar_EC1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Ingresar_EC1.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Ingresar_EC1.setText("Ingresar");
        Texto_Ingresar_EC1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Ingresar_EC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Ingresar_EC1MouseClicked(evt);
            }
        });
        Panel_Ingresar_EC1.add(Texto_Ingresar_EC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_Mantenimiento_DocB.add(Panel_Ingresar_EC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 130, 50));

        Panel_Modificar_EC1.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Modificar_EC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Modificar_EC1MouseClicked(evt);
            }
        });
        Panel_Modificar_EC1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Modificar_EC1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Modificar_EC1.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Modificar_EC1.setText("Modificar");
        Texto_Modificar_EC1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Modificar_EC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Modificar_EC1MouseClicked(evt);
            }
        });
        Panel_Modificar_EC1.add(Texto_Modificar_EC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jPanel_Mantenimiento_DocB.add(Panel_Modificar_EC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 130, 50));

        Panel_Eliminar_EC1.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Eliminar_EC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Eliminar_EC1MouseClicked(evt);
            }
        });
        Panel_Eliminar_EC1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Eliminar_EC1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Eliminar_EC1.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Eliminar_EC1.setText("Eliminar");
        Texto_Eliminar_EC1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Eliminar_EC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Eliminar_EC1MouseClicked(evt);
            }
        });
        Panel_Eliminar_EC1.add(Texto_Eliminar_EC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        jPanel_Mantenimiento_DocB.add(Panel_Eliminar_EC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 130, 50));

        Panel_Consultar_EC1.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Consultar_EC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Consultar_EC1MouseClicked(evt);
            }
        });
        Panel_Consultar_EC1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Consultar_EC1.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Consultar_EC1.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Consultar_EC1.setText("Consultar");
        Texto_Consultar_EC1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Consultar_EC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Consultar_EC1MouseClicked(evt);
            }
        });
        Panel_Consultar_EC1.add(Texto_Consultar_EC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        jPanel_Mantenimiento_DocB.add(Panel_Consultar_EC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 180, 130, 50));

        Panel_CuentaContable.setBackground(new java.awt.Color(28, 27, 33));
        Panel_CuentaContable.setPreferredSize(new java.awt.Dimension(1880, 900));
        Panel_CuentaContable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ID Cuenta");
        Panel_CuentaContable.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 63, -1));

        jTextField_IDCuenta.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_IDCuenta.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_IDCuenta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Panel_CuentaContable.add(jTextField_IDCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 110, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nombre Cuenta");
        Panel_CuentaContable.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 310, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tipo Cuenta");
        Panel_CuentaContable.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 310, -1, -1));

        jTextField_NombreCuenta.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_NombreCuenta.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_NombreCuenta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Panel_CuentaContable.add(jTextField_NombreCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 139, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ID Clasificacion");
        Panel_CuentaContable.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 310, -1, -1));

        jTextField_IDClasif.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_IDClasif.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_IDClasif.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Panel_CuentaContable.add(jTextField_IDClasif, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, 139, -1));

        jLabel_clasificacion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_clasificacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Panel_CuentaContable.add(jLabel_clasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 340, 40, 20));

        jComboBoxIDClasificacion.setBackground(new java.awt.Color(40, 41, 46));
        jComboBoxIDClasificacion.setForeground(new java.awt.Color(153, 153, 153));
        jComboBoxIDClasificacion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBoxIDClasificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxIDClasificacionMouseClicked(evt);
            }
        });
        jComboBoxIDClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIDClasificacionActionPerformed(evt);
            }
        });
        Panel_CuentaContable.add(jComboBoxIDClasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 340, 120, -1));

        jTextField_SaldoA.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_SaldoA.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_SaldoA.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Panel_CuentaContable.add(jTextField_SaldoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 110, -1));

        jLabel_SaldoA.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_SaldoA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_SaldoA.setText("Saldo Anterior");
        Panel_CuentaContable.add(jLabel_SaldoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 80, -1));

        jLabel_Ca.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Ca.setText("Cargos Acumulados");
        Panel_CuentaContable.add(jLabel_Ca, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, -1, -1));

        jTextField_CargosA.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_CargosA.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_CargosA.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Panel_CuentaContable.add(jTextField_CargosA, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 130, -1));

        jLabel_AC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_AC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_AC.setText("Abonos Acumulados");
        Panel_CuentaContable.add(jLabel_AC, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 400, 110, -1));

        jTextField_AbonosA.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_AbonosA.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_AbonosA.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Panel_CuentaContable.add(jTextField_AbonosA, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 430, 130, -1));

        jLabel_SA.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_SA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_SA.setText("Saldo Actual");
        Panel_CuentaContable.add(jLabel_SA, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 400, 100, -1));

        jTextField_SaldoActual.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_SaldoActual.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_SaldoActual.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Panel_CuentaContable.add(jTextField_SaldoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 430, 130, -1));

        jTextField_Buscar.setBackground(new java.awt.Color(40, 41, 46));
        jTextField_Buscar.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Buscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_BuscarKeyReleased(evt);
            }
        });
        Panel_CuentaContable.add(jTextField_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 520, 300, -1));

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Descripcion Cuenta");
        Panel_CuentaContable.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 400, 110, -1));

        jTextArea_Descripcion.setBackground(new java.awt.Color(40, 41, 46));
        jTextArea_Descripcion.setColumns(20);
        jTextArea_Descripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextArea_Descripcion.setForeground(new java.awt.Color(153, 153, 153));
        jTextArea_Descripcion.setRows(5);
        jTextArea_Descripcion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(jTextArea_Descripcion);

        Panel_CuentaContable.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 430, 220, 90));

        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Buscar");
        Panel_CuentaContable.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 520, 60, 20));

        jLabel_IngresarCC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IngresarCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_IngresarCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_IngresarCCMouseClicked(evt);
            }
        });
        Panel_CuentaContable.add(jLabel_IngresarCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 510, 50, 50));

        jLabel_ModificarCC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ModificarCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_ModificarCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_ModificarCCMouseClicked(evt);
            }
        });
        Panel_CuentaContable.add(jLabel_ModificarCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 510, 50, 50));

        jLabel_EliminarCC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_EliminarCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_EliminarCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EliminarCCMouseClicked(evt);
            }
        });
        Panel_CuentaContable.add(jLabel_EliminarCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 510, 50, 50));

        tbl_CuentaContable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_CuentaContable.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_CuentaContable.setSelectionBackground(new java.awt.Color(40, 41, 46));
        tbl_CuentaContable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CuentaContableMouseClicked(evt);
            }
        });
        tbl_CuentaContable.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                tbl_CuentaContableCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jScrollPane40.setViewportView(tbl_CuentaContable);

        Panel_CuentaContable.add(jScrollPane40, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 570, 1070, 170));

        jLabel_TituloCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo Empleado Contratado.png"))); // NOI18N
        Panel_CuentaContable.add(jLabel_TituloCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 400, 120));

        Panel_Ingresar_CC.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Ingresar_CC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Ingresar_CCMouseClicked(evt);
            }
        });
        Panel_Ingresar_CC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Ingresar_CC.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Ingresar_CC.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Ingresar_CC.setText("Ingresar");
        Texto_Ingresar_CC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Ingresar_CC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Ingresar_CCMouseClicked(evt);
            }
        });
        Panel_Ingresar_CC.add(Texto_Ingresar_CC, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        Panel_CuentaContable.add(Panel_Ingresar_CC, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 130, 50));

        Panel_Modificar_CC.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Modificar_CC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Modificar_CCMouseClicked(evt);
            }
        });
        Panel_Modificar_CC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Modificar_CC.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Modificar_CC.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Modificar_CC.setText("Modificar");
        Texto_Modificar_CC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Modificar_CC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Modificar_CCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Texto_Modificar_CCMouseEntered(evt);
            }
        });
        Panel_Modificar_CC.add(Texto_Modificar_CC, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        Panel_CuentaContable.add(Panel_Modificar_CC, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 130, 50));

        Panel_Eliminar_CC.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Eliminar_CC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Eliminar_CCMouseClicked(evt);
            }
        });
        Panel_Eliminar_CC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Eliminar_CC.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Eliminar_CC.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Eliminar_CC.setText("Eliminar");
        Texto_Eliminar_CC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Eliminar_CC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Eliminar_CCMouseClicked(evt);
            }
        });
        Panel_Eliminar_CC.add(Texto_Eliminar_CC, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 15, -1, -1));

        Panel_CuentaContable.add(Panel_Eliminar_CC, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 130, 50));

        Panel_Consultar_CC.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Consultar_CC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Consultar_CCMouseClicked(evt);
            }
        });
        Panel_Consultar_CC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texto_Consultar_CC.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        Texto_Consultar_CC.setForeground(new java.awt.Color(255, 255, 255));
        Texto_Consultar_CC.setText("Consultar");
        Texto_Consultar_CC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Texto_Consultar_CC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Texto_Consultar_CCMouseClicked(evt);
            }
        });
        Panel_Consultar_CC.add(Texto_Consultar_CC, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, -1));

        Panel_CuentaContable.add(Panel_Consultar_CC, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 200, 130, 50));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        Panel_CuentaContable.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Actualizar Saldos");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        Panel_CuentaContable.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 240, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nuevo Mes");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        Panel_CuentaContable.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 270, -1, -1));

        jButton_PDF.setText("Generar PDF");
        jButton_PDF.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton_PDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_PDFMouseClicked(evt);
            }
        });
        Panel_CuentaContable.add(jButton_PDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 310, 110, -1));

        jPanel_MantenimientoClasiCuenta.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoClasiCuenta.setPreferredSize(new java.awt.Dimension(1880, 900));
        jPanel_MantenimientoClasiCuenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_CC.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        jLabel_CC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CC.setText("MANTENIMIENTO  CLASIFICACION  CUENTAS");
        jPanel_MantenimientoClasiCuenta.add(jLabel_CC, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

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

        jPanel_MantenimientoClasiCuenta.add(Panel_IngresarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 130, 50));

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

        jPanel_MantenimientoClasiCuenta.add(Panel_ModificarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 130, 50));

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

        jPanel_MantenimientoClasiCuenta.add(Panel_EliminarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, 130, 50));

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

        jPanel_MantenimientoClasiCuenta.add(Panel_ConsultarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, 130, 50));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID CLASIFICACION");
        jPanel_MantenimientoClasiCuenta.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, -1, -1));

        txt_idclasi.setBackground(new java.awt.Color(40, 41, 46));
        txt_idclasi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoClasiCuenta.add(txt_idclasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 129, -1));

        jLabel20.setBackground(new java.awt.Color(40, 41, 46));
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("NOMBRE CLASIFICACION");
        jPanel_MantenimientoClasiCuenta.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, -1, -1));

        txt_nombrecla.setBackground(new java.awt.Color(40, 41, 46));
        txt_nombrecla.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoClasiCuenta.add(txt_nombrecla, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, 177, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientoClasiCuenta.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, -1));

        txt_buscarclasi.setBackground(new java.awt.Color(40, 41, 46));
        txt_buscarclasi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_buscarclasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarclasiKeyReleased(evt);
            }
        });
        jPanel_MantenimientoClasiCuenta.add(txt_buscarclasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, 221, -1));

        jLabel_Ingresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        jLabel_Ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_IngresarMouseClicked(evt);
            }
        });
        jPanel_MantenimientoClasiCuenta.add(jLabel_Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 280, -1, -1));

        jLabel_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        jLabel_Eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EliminarMouseClicked(evt);
            }
        });
        jPanel_MantenimientoClasiCuenta.add(jLabel_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 280, -1, -1));

        jLabel_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        jLabel_Modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_ModificarMouseClicked(evt);
            }
        });
        jPanel_MantenimientoClasiCuenta.add(jLabel_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, -1, -1));

        tbl_Clasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_Clasi.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Clasi.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_Clasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ClasiMouseClicked(evt);
            }
        });
        tbl_Clasi.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                tbl_ClasiCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jScrollPane39.setViewportView(tbl_Clasi);

        jPanel_MantenimientoClasiCuenta.add(jScrollPane39, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 600, 190));

        jPanel_MantenimientoMoneda.setBackground(new java.awt.Color(28, 27, 33));
        jPanel_MantenimientoMoneda.setPreferredSize(new java.awt.Dimension(1880, 900));
        jPanel_MantenimientoMoneda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MMon.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        jLabel_MMon.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MMon.setText("MANTENIMIENTO MONEDA");
        jPanel_MantenimientoMoneda.add(jLabel_MMon, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, -1, -1));

        txt_IDM.setBackground(new java.awt.Color(40, 41, 46));
        txt_IDM.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoMoneda.add(txt_IDM, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 104, -1));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ID MONEDA");
        jPanel_MantenimientoMoneda.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, -1, -1));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("NOMBRE MONEDA");
        jPanel_MantenimientoMoneda.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, -1, -1));

        txt_NombreM.setBackground(new java.awt.Color(40, 41, 46));
        txt_NombreM.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoMoneda.add(txt_NombreM, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 104, -1));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("TIPO DE CAMBIO");
        jPanel_MantenimientoMoneda.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 250, -1, -1));

        txt_TipoM.setBackground(new java.awt.Color(40, 41, 46));
        txt_TipoM.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoMoneda.add(txt_TipoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, 104, -1));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("ESTADO MONEDA");
        jPanel_MantenimientoMoneda.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 250, -1, -1));

        txt_estM.setBackground(new java.awt.Color(40, 41, 46));
        txt_estM.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_MantenimientoMoneda.add(txt_estM, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 270, 104, -1));

        tbl_Moneda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_Moneda.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Moneda.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tbl_Moneda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_MonedaMouseClicked(evt);
            }
        });
        jScrollPane38.setViewportView(tbl_Moneda);

        jPanel_MantenimientoMoneda.add(jScrollPane38, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 600, 190));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_D.png"))); // NOI18N
        jPanel_MantenimientoMoneda.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, -1, -1));

        txt_buscarMon.setBackground(new java.awt.Color(40, 41, 46));
        txt_buscarMon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_buscarMon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarMonKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarMonKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buscarMonKeyTyped(evt);
            }
        });
        jPanel_MantenimientoMoneda.add(txt_buscarMon, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 219, -1));

        ingresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar_D.png"))); // NOI18N
        ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresarMouseClicked(evt);
            }
        });
        jPanel_MantenimientoMoneda.add(ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 310, -1, -1));

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar_D.png"))); // NOI18N
        eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarMouseClicked(evt);
            }
        });
        jPanel_MantenimientoMoneda.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 310, -1, -1));

        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar_D.png"))); // NOI18N
        modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificarMouseClicked(evt);
            }
        });
        jPanel_MantenimientoMoneda.add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 310, -1, -1));

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

        jPanel_MantenimientoMoneda.add(Panel_Ingresar_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 130, 50));

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

        jPanel_MantenimientoMoneda.add(Panel_Modificar_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 130, 50));

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

        jPanel_MantenimientoMoneda.add(Panel_Eliminar_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 130, 50));

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

        jPanel_MantenimientoMoneda.add(Panel_Consultar_EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 160, 130, 50));

        Panel_Bancos.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Bancos.setPreferredSize(new java.awt.Dimension(1880, 900));
        Panel_Bancos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bancos");
        Panel_Bancos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 78, -1));

        Panel_MIMEC.setBackground(new java.awt.Color(28, 27, 33));
        Panel_MIMEC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        Panel_MIMEC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_MIMEC.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Panel_MIMECMouseDragged(evt);
            }
        });
        Panel_MIMEC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_MIMECMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_MIMECMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Panel_MIMECMouseReleased(evt);
            }
        });
        Panel_MIMEC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MantenimientoM.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel_MantenimientoM.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MantenimientoM.setText("MANTENIMIENTO MONEDA.");
        jLabel_MantenimientoM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_MantenimientoM.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoMMouseMoved(evt);
            }
        });
        jLabel_MantenimientoM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoMMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoMMouseExited(evt);
            }
        });
        Panel_MIMEC.add(jLabel_MantenimientoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Cantidad:");
        Panel_MIMEC.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 71, -1, -1));

        Cant_Moneda.setForeground(new java.awt.Color(255, 255, 255));
        Panel_MIMEC.add(Cant_Moneda, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 68, 20, 20));

        Panel_Bancos.add(Panel_MIMEC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 270, 100));

        Panel_MIMEC1.setBackground(new java.awt.Color(28, 27, 33));
        Panel_MIMEC1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        Panel_MIMEC1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_MIMEC1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Panel_MIMEC1MouseDragged(evt);
            }
        });
        Panel_MIMEC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_MIMEC1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_MIMEC1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Panel_MIMEC1MouseReleased(evt);
            }
        });
        Panel_MIMEC1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MantenimientoM1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel_MantenimientoM1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MantenimientoM1.setText("MANTENIMIENTO CLASIFICACION CUENTAS");
        jLabel_MantenimientoM1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_MantenimientoM1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM1MouseMoved(evt);
            }
        });
        jLabel_MantenimientoM1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM1MouseExited(evt);
            }
        });
        Panel_MIMEC1.add(jLabel_MantenimientoM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, -1));

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Cantidad:");
        Panel_MIMEC1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        Cant_CC.setForeground(new java.awt.Color(255, 255, 255));
        Panel_MIMEC1.add(Cant_CC, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 67, 20, 20));

        Panel_Bancos.add(Panel_MIMEC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 270, 100));

        Panel_MIMECContable.setBackground(new java.awt.Color(28, 27, 33));
        Panel_MIMECContable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        Panel_MIMECContable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_MIMECContable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Panel_MIMECContableMouseDragged(evt);
            }
        });
        Panel_MIMECContable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_MIMECContableMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_MIMECContableMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Panel_MIMECContableMouseReleased(evt);
            }
        });
        Panel_MIMECContable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MantenimientoM2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel_MantenimientoM2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MantenimientoM2.setText("MANTENIMIENTO CUENTA CONTABLE");
        jLabel_MantenimientoM2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_MantenimientoM2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM2MouseMoved(evt);
            }
        });
        jLabel_MantenimientoM2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM2MouseExited(evt);
            }
        });
        Panel_MIMECContable.add(jLabel_MantenimientoM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 200, -1));

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Cantidad:");
        Panel_MIMECContable.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        Cant_CuCon.setForeground(new java.awt.Color(255, 255, 255));
        Panel_MIMECContable.add(Cant_CuCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 20, 20));

        Panel_Bancos.add(Panel_MIMECContable, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 270, 100));

        Panel_MIMEDocumento.setBackground(new java.awt.Color(28, 27, 33));
        Panel_MIMEDocumento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        Panel_MIMEDocumento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_MIMEDocumento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Panel_MIMEDocumentoMouseDragged(evt);
            }
        });
        Panel_MIMEDocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_MIMEDocumentoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_MIMEDocumentoMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Panel_MIMEDocumentoMouseReleased(evt);
            }
        });
        Panel_MIMEDocumento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MantenimientoM3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel_MantenimientoM3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MantenimientoM3.setText("MANTENIMIENTO DOCUMENTO BANCARIO");
        jLabel_MantenimientoM3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_MantenimientoM3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM3MouseMoved(evt);
            }
        });
        jLabel_MantenimientoM3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM3MouseExited(evt);
            }
        });
        Panel_MIMEDocumento.add(jLabel_MantenimientoM3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 220, -1));

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Cantidad:");
        Panel_MIMEDocumento.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        Cant_DB.setForeground(new java.awt.Color(255, 255, 255));
        Panel_MIMEDocumento.add(Cant_DB, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 20, 20));

        Panel_Bancos.add(Panel_MIMEDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, 270, 100));

        Panel_MIMEConcepto.setBackground(new java.awt.Color(28, 27, 33));
        Panel_MIMEConcepto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        Panel_MIMEConcepto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_MIMEConcepto.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Panel_MIMEConceptoMouseDragged(evt);
            }
        });
        Panel_MIMEConcepto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_MIMEConceptoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_MIMEConceptoMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Panel_MIMEConceptoMouseReleased(evt);
            }
        });
        Panel_MIMEConcepto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MantenimientoM4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel_MantenimientoM4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MantenimientoM4.setText("MANTENIMIENTO CONCEPTO BANCARIO");
        jLabel_MantenimientoM4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_MantenimientoM4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM4MouseMoved(evt);
            }
        });
        jLabel_MantenimientoM4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM4MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM4MouseExited(evt);
            }
        });
        Panel_MIMEConcepto.add(jLabel_MantenimientoM4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Cantidad:");
        Panel_MIMEConcepto.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        Cant_CB.setForeground(new java.awt.Color(255, 255, 255));
        Panel_MIMEConcepto.add(Cant_CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 20, 20));

        Panel_Bancos.add(Panel_MIMEConcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 270, 100));

        Panel_MIMEMBE.setBackground(new java.awt.Color(28, 27, 33));
        Panel_MIMEMBE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        Panel_MIMEMBE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_MIMEMBE.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Panel_MIMEMBEMouseDragged(evt);
            }
        });
        Panel_MIMEMBE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_MIMEMBEMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_MIMEMBEMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Panel_MIMEMBEMouseReleased(evt);
            }
        });
        Panel_MIMEMBE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MantenimientoM5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel_MantenimientoM5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MantenimientoM5.setText("MANTENIMIENTO BANCO ENCABEZADO");
        jLabel_MantenimientoM5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_MantenimientoM5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM5MouseMoved(evt);
            }
        });
        jLabel_MantenimientoM5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM5MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM5MouseExited(evt);
            }
        });
        Panel_MIMEMBE.add(jLabel_MantenimientoM5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Cantidad:");
        Panel_MIMEMBE.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        Cant_BE.setForeground(new java.awt.Color(255, 255, 255));
        Panel_MIMEMBE.add(Cant_BE, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 20, 20));

        Panel_Bancos.add(Panel_MIMEMBE, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 270, 100));

        Panel_MIMBD.setBackground(new java.awt.Color(28, 27, 33));
        Panel_MIMBD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        Panel_MIMBD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_MIMBD.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Panel_MIMBDMouseDragged(evt);
            }
        });
        Panel_MIMBD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_MIMBDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel_MIMBDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_MIMBDMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Panel_MIMBDMouseReleased(evt);
            }
        });
        Panel_MIMBD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MantenimientoM6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel_MantenimientoM6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MantenimientoM6.setText("MANTENIMIENTO MOVIMIENTO BANCARIO DETALLE");
        jLabel_MantenimientoM6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_MantenimientoM6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM6MouseMoved(evt);
            }
        });
        jLabel_MantenimientoM6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM6MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM6MouseExited(evt);
            }
        });
        Panel_MIMBD.add(jLabel_MantenimientoM6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Cantidad:");
        Panel_MIMBD.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        Cant_MBD.setForeground(new java.awt.Color(255, 255, 255));
        Panel_MIMBD.add(Cant_MBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 20, 20));

        Panel_Bancos.add(Panel_MIMBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 270, 100));

        Panel_MIMFP.setBackground(new java.awt.Color(28, 27, 33));
        Panel_MIMFP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        Panel_MIMFP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_MIMFP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Panel_MIMFPMouseDragged(evt);
            }
        });
        Panel_MIMFP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_MIMFPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_MIMFPMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Panel_MIMFPMouseReleased(evt);
            }
        });
        Panel_MIMFP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MantenimientoM7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel_MantenimientoM7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MantenimientoM7.setText("MANTENIMIENTO FORMA DE PAGO");
        jLabel_MantenimientoM7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_MantenimientoM7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM7MouseMoved(evt);
            }
        });
        jLabel_MantenimientoM7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM7MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM7MouseExited(evt);
            }
        });
        Panel_MIMFP.add(jLabel_MantenimientoM7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, -1));

        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Cantidad:");
        Panel_MIMFP.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        Cant_FP.setForeground(new java.awt.Color(255, 255, 255));
        Panel_MIMFP.add(Cant_FP, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 20, 20));

        Panel_Bancos.add(Panel_MIMFP, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 190, 270, 100));

        Panel_MB.setBackground(new java.awt.Color(28, 27, 33));
        Panel_MB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        Panel_MB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_MB.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Panel_MBMouseDragged(evt);
            }
        });
        Panel_MB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_MBMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_MBMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Panel_MBMouseReleased(evt);
            }
        });
        Panel_MB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MantenimientoM8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel_MantenimientoM8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MantenimientoM8.setText("MANTENIMIENTO BANCO");
        jLabel_MantenimientoM8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_MantenimientoM8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM8MouseMoved(evt);
            }
        });
        jLabel_MantenimientoM8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM8MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM8MouseExited(evt);
            }
        });
        Panel_MB.add(jLabel_MantenimientoM8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 130, -1));

        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Cantidad:");
        Panel_MB.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        Cant_B.setForeground(new java.awt.Color(255, 255, 255));
        Panel_MB.add(Cant_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 20, 20));

        Panel_Bancos.add(Panel_MB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 270, 100));

        Panel_MCBEnc.setBackground(new java.awt.Color(28, 27, 33));
        Panel_MCBEnc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        Panel_MCBEnc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_MCBEnc.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Panel_MCBEncMouseDragged(evt);
            }
        });
        Panel_MCBEnc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_MCBEncMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_MCBEncMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Panel_MCBEncMouseReleased(evt);
            }
        });
        Panel_MCBEnc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MantenimientoM9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel_MantenimientoM9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MantenimientoM9.setText("MANTENIMIENTO CONC BANCARIO ENCABEZADO");
        jLabel_MantenimientoM9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_MantenimientoM9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM9MouseMoved(evt);
            }
        });
        jLabel_MantenimientoM9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM9MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM9MouseExited(evt);
            }
        });
        Panel_MCBEnc.add(jLabel_MantenimientoM9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Cantidad:");
        Panel_MCBEnc.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        Cant_CBE.setForeground(new java.awt.Color(255, 255, 255));
        Panel_MCBEnc.add(Cant_CBE, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 20, 20));

        Panel_Bancos.add(Panel_MCBEnc, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 280, 100));

        Panel_Consultas.setBackground(new java.awt.Color(28, 27, 33));
        Panel_Consultas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        Panel_Consultas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_Consultas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Panel_ConsultasMouseDragged(evt);
            }
        });
        Panel_Consultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ConsultasMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_ConsultasMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Panel_ConsultasMouseReleased(evt);
            }
        });
        Panel_Consultas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MantenimientoM10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel_MantenimientoM10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MantenimientoM10.setText("CONSULTAS");
        jLabel_MantenimientoM10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_MantenimientoM10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM10MouseMoved(evt);
            }
        });
        jLabel_MantenimientoM10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM10MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM10MouseExited(evt);
            }
        });
        Panel_Consultas.add(jLabel_MantenimientoM10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Cantidad:");
        Panel_Consultas.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("1");
        Panel_Consultas.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 20, 20));

        Panel_Bancos.add(Panel_Consultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 320, 270, 100));

        Panel_MCBEnc2.setBackground(new java.awt.Color(28, 27, 33));
        Panel_MCBEnc2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        Panel_MCBEnc2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_MCBEnc2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Panel_MCBEnc2MouseDragged(evt);
            }
        });
        Panel_MCBEnc2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_MCBEnc2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_MCBEnc2MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Panel_MCBEnc2MouseReleased(evt);
            }
        });
        Panel_MCBEnc2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MantenimientoM11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel_MantenimientoM11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MantenimientoM11.setText("MANTENIMIENTO CONC BANCARIO DETALLE");
        jLabel_MantenimientoM11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_MantenimientoM11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM11MouseMoved(evt);
            }
        });
        jLabel_MantenimientoM11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM11MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_MantenimientoM11MouseExited(evt);
            }
        });
        Panel_MCBEnc2.add(jLabel_MantenimientoM11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setText("Cantidad:");
        Panel_MCBEnc2.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        Cant_CBD.setForeground(new java.awt.Color(255, 255, 255));
        Panel_MCBEnc2.add(Cant_CBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 20, 20));

        Panel_Bancos.add(Panel_MCBEnc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, 270, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Bancos, javax.swing.GroupLayout.PREFERRED_SIZE, 1880, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_MantenimientoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 1880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel_MantenimientoClasiCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 1880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 8, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 4, Short.MAX_VALUE)
                    .addComponent(Panel_CuentaContable, javax.swing.GroupLayout.PREFERRED_SIZE, 1880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 4, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_Mantenimiento_DocB, javax.swing.GroupLayout.PREFERRED_SIZE, 1880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel_MantenimientoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 1880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 8, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(JPanel_MantenimientoMovimientoBanEn, javax.swing.GroupLayout.PREFERRED_SIZE, 1888, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_MantenimientoMovBanDet, javax.swing.GroupLayout.PREFERRED_SIZE, 1880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_Forma_de_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, 1880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_MantenimientoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 1880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_Manatenimiento_ConBanEn, javax.swing.GroupLayout.PREFERRED_SIZE, 1880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_Mantenimiento_CBD, javax.swing.GroupLayout.PREFERRED_SIZE, 1880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_ConsultaBancos_Saldos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Bancos, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_MantenimientoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel_MantenimientoClasiCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Panel_CuentaContable, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_Mantenimiento_DocB, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel_MantenimientoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(JPanel_MantenimientoMovimientoBanEn, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_MantenimientoMovBanDet, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_Forma_de_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_MantenimientoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_Manatenimiento_ConBanEn, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_Mantenimiento_CBD, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_ConsultaBancos_Saldos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Panel_MIMEC1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMEC1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMEC1MouseReleased

    private void Panel_MIMEC1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMEC1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMEC1MouseExited

    private void Panel_MIMEC1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMEC1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMEC1MouseDragged

    private void jLabel_MantenimientoM1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM1MouseExited

    private void jLabel_MantenimientoM1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM1MouseClicked

    private void jLabel_MantenimientoM1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM1MouseMoved

    private void Panel_MIMECMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMECMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMECMouseReleased

    private void Panel_MIMECMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMECMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_Panel_MIMECMouseExited

    private void Panel_MIMECMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMECMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMECMouseDragged

    private void jLabel_MantenimientoMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoMMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoMMouseExited

    private void jLabel_MantenimientoMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoMMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel_MantenimientoMMouseClicked

    private void jLabel_MantenimientoMMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoMMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoMMouseMoved

    private void jLabel_MantenimientoM2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM2MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM2MouseMoved

    private void jLabel_MantenimientoM2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM2MouseClicked

    private void jLabel_MantenimientoM2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM2MouseExited

    private void Panel_MIMECContableMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMECContableMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMECContableMouseDragged

    private void Panel_MIMECContableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMECContableMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMECContableMouseExited

    private void Panel_MIMECContableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMECContableMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMECContableMouseReleased

    private void jLabel_MantenimientoM3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM3MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM3MouseMoved

    private void jLabel_MantenimientoM3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM3MouseClicked

    private void jLabel_MantenimientoM3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM3MouseExited

    private void Panel_MIMEDocumentoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMEDocumentoMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMEDocumentoMouseDragged

    private void Panel_MIMEDocumentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMEDocumentoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMEDocumentoMouseExited

    private void Panel_MIMEDocumentoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMEDocumentoMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMEDocumentoMouseReleased

    private void jLabel_MantenimientoM4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM4MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM4MouseMoved

    private void jLabel_MantenimientoM4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM4MouseClicked

    private void jLabel_MantenimientoM4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM4MouseExited

    private void Panel_MIMEConceptoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMEConceptoMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMEConceptoMouseDragged

    private void Panel_MIMEConceptoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMEConceptoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMEConceptoMouseExited

    private void Panel_MIMEConceptoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMEConceptoMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMEConceptoMouseReleased

    private void jLabel_MantenimientoM5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM5MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM5MouseMoved

    private void jLabel_MantenimientoM5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM5MouseClicked

    private void jLabel_MantenimientoM5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM5MouseExited

    private void Panel_MIMEMBEMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMEMBEMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMEMBEMouseDragged

    private void Panel_MIMEMBEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMEMBEMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMEMBEMouseExited

    private void Panel_MIMEMBEMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMEMBEMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMEMBEMouseReleased

    private void jLabel_MantenimientoM6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM6MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM6MouseMoved

    private void jLabel_MantenimientoM6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM6MouseClicked

    private void jLabel_MantenimientoM6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM6MouseExited

    private void Panel_MIMBDMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMBDMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMBDMouseDragged

    private void Panel_MIMBDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMBDMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMBDMouseExited

    private void Panel_MIMBDMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMBDMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMBDMouseReleased

    private void jLabel_MantenimientoM7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM7MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM7MouseMoved

    private void jLabel_MantenimientoM7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM7MouseClicked

    private void jLabel_MantenimientoM7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM7MouseExited

    private void Panel_MIMFPMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMFPMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMFPMouseDragged

    private void Panel_MIMFPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMFPMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMFPMouseExited

    private void Panel_MIMFPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMFPMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMFPMouseReleased

    private void jLabel_MantenimientoM8MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM8MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM8MouseMoved

    private void jLabel_MantenimientoM8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM8MouseClicked

    private void jLabel_MantenimientoM8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM8MouseExited

    private void Panel_MBMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MBMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MBMouseDragged

    private void Panel_MBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MBMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MBMouseExited

    private void Panel_MBMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MBMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MBMouseReleased

    private void jLabel_MantenimientoM9MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM9MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM9MouseMoved

    private void jLabel_MantenimientoM9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM9MouseClicked

    private void jLabel_MantenimientoM9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM9MouseExited

    private void Panel_MCBEncMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MCBEncMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MCBEncMouseDragged

    private void Panel_MCBEncMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MCBEncMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MCBEncMouseExited

    private void Panel_MCBEncMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MCBEncMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MCBEncMouseReleased

    private void jLabel_MantenimientoM10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM10MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM10MouseMoved

    private void jLabel_MantenimientoM10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM10MouseClicked

    private void jLabel_MantenimientoM10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM10MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM10MouseExited

    private void Panel_ConsultasMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ConsultasMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ConsultasMouseDragged

    private void Panel_ConsultasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ConsultasMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ConsultasMouseExited

    private void Panel_ConsultasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ConsultasMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ConsultasMouseReleased

    private void Panel_MIMECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMECMouseClicked
        // TODO add your handling code here:
        Panel_Bancos.setVisible(false);
        jPanel_MantenimientoMoneda.setVisible(true);
        Moneda mon = new Moneda(jLabel_MMon, txt_IDM, txt_NombreM, txt_TipoM, txt_estM, txt_buscarMon, tbl_Moneda);
        mon.Actualizar_Tabla();

    }//GEN-LAST:event_Panel_MIMECMouseClicked

    private void tbl_MonedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_MonedaMouseClicked
        // TODO add your handling code here:
        int Seleccion = tbl_Moneda.rowAtPoint(evt.getPoint());
        txt_IDM.setText(String.valueOf(tbl_Moneda.getValueAt(Seleccion, 0)));
        txt_NombreM.setText(String.valueOf(tbl_Moneda.getValueAt(Seleccion, 1)));
        txt_TipoM.setText(String.valueOf(tbl_Moneda.getValueAt(Seleccion, 2)));
        txt_estM.setText(String.valueOf(tbl_Moneda.getValueAt(Seleccion, 3)));
        Moneda mon = new Moneda(jLabel_MMon, txt_IDM, txt_NombreM, txt_TipoM, txt_estM, txt_buscarMon, tbl_Moneda);
    }//GEN-LAST:event_tbl_MonedaMouseClicked

    private void Texto_Ingresar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Ingresar_ECMouseClicked
        // TODO add your handling code here:
        ingresar.setVisible(true);
        modificar.setVisible(false);
        eliminar.setVisible(false);

    }//GEN-LAST:event_Texto_Ingresar_ECMouseClicked

    private void Panel_Ingresar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Ingresar_ECMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Ingresar_ECMouseClicked

    private void Texto_Modificar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Modificar_ECMouseClicked
        // TODO add your handling code here:
        ingresar.setVisible(false);
        modificar.setVisible(true);
        eliminar.setVisible(false);
    }//GEN-LAST:event_Texto_Modificar_ECMouseClicked

    private void Panel_Modificar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Modificar_ECMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Modificar_ECMouseClicked

    private void Texto_Eliminar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Eliminar_ECMouseClicked
        // TODO add your handling code here:
        ingresar.setVisible(false);
        modificar.setVisible(false);
        eliminar.setVisible(true);
    }//GEN-LAST:event_Texto_Eliminar_ECMouseClicked

    private void Panel_Eliminar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Eliminar_ECMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Eliminar_ECMouseClicked

    private void Texto_Consultar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Consultar_ECMouseClicked
        // TODO add your handling code here:
        ingresar.setVisible(false);
        modificar.setVisible(false);
        eliminar.setVisible(false);
    }//GEN-LAST:event_Texto_Consultar_ECMouseClicked

    private void Panel_Consultar_ECMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Consultar_ECMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Consultar_ECMouseClicked

    private void ingresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarMouseClicked
        // TODO add your handling code here:
        Moneda mon = new Moneda(jLabel_MMon, txt_IDM, txt_NombreM, txt_TipoM, txt_estM, txt_buscarMon, tbl_Moneda);
        mon.Insertar_Me();
    }//GEN-LAST:event_ingresarMouseClicked

    private void eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseClicked
        // TODO add your handling code here:
        Moneda mon = new Moneda(jLabel_MMon, txt_IDM, txt_NombreM, txt_TipoM, txt_estM, txt_buscarMon, tbl_Moneda);
        mon.Eliminar_M();
    }//GEN-LAST:event_eliminarMouseClicked

    private void modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarMouseClicked
        // TODO add your handling code here:
        Moneda mon = new Moneda(jLabel_MMon, txt_IDM, txt_NombreM, txt_TipoM, txt_estM, txt_buscarMon, tbl_Moneda);
        mon.Modificar_M();
    }//GEN-LAST:event_modificarMouseClicked

    private void txt_buscarMonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarMonKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarMonKeyTyped

    private void txt_buscarMonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarMonKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarMonKeyPressed

    private void txt_buscarMonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarMonKeyReleased
        // TODO add your handling code here:
        String buscar = txt_buscarMon.getText();
        Moneda mon = new Moneda(jLabel_MMon, txt_IDM, txt_NombreM, txt_TipoM, txt_estM, txt_buscarMon, tbl_Moneda);
        mon.BuscarMon(buscar);
    }//GEN-LAST:event_txt_buscarMonKeyReleased

    private void Texto_IngresarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarSMouseClicked

        jLabel_Eliminar.setVisible(false);
        jLabel_Ingresar.setVisible(true);
        jLabel_Modificar.setVisible(false);
    }//GEN-LAST:event_Texto_IngresarSMouseClicked

    private void Panel_IngresarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarSMouseClicked

    private void Texto_ModificarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificarSMouseClicked
        jLabel_Eliminar.setVisible(false);
        jLabel_Ingresar.setVisible(false);
        jLabel_Modificar.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_Texto_ModificarSMouseClicked

    private void Panel_ModificarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarSMouseClicked

    private void Texto_EliminarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarSMouseClicked
        jLabel_Eliminar.setVisible(true);
        jLabel_Ingresar.setVisible(false);
        jLabel_Modificar.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_EliminarSMouseClicked

    private void Texto_ConsultarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarSMouseClicked
        jLabel_Eliminar.setVisible(false);
        jLabel_Ingresar.setVisible(false);
        jLabel_Modificar.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_ConsultarSMouseClicked

    private void tbl_ClasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ClasiMouseClicked
        // TODO add your handling code here:
        int Seleccion = tbl_Clasi.rowAtPoint(evt.getPoint());
        txt_idclasi.setText(String.valueOf(tbl_Clasi.getValueAt(Seleccion, 0)));
        txt_nombrecla.setText(String.valueOf(tbl_Clasi.getValueAt(Seleccion, 1)));
        Clasificacion_Cuenta CC = new Clasificacion_Cuenta(jLabel_CC, txt_idclasi, txt_nombrecla, txt_buscarclasi, tbl_Clasi);
    }//GEN-LAST:event_tbl_ClasiMouseClicked

    private void Panel_MIMEC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMEC1MouseClicked
        // TODO add your handling code here:
        Panel_Bancos.setVisible(false);
        jPanel_MantenimientoClasiCuenta.setVisible(true);
        Clasificacion_Cuenta CC = new Clasificacion_Cuenta(jLabel_CC, txt_idclasi, txt_nombrecla, txt_buscarclasi, tbl_Clasi);
        CC.Actualizar_Tabla();
    }//GEN-LAST:event_Panel_MIMEC1MouseClicked

    private void jLabel_IngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_IngresarMouseClicked
        // TODO add your handling code here:
        Clasificacion_Cuenta CC = new Clasificacion_Cuenta(jLabel_CC, txt_idclasi, txt_nombrecla, txt_buscarclasi, tbl_Clasi);
        CC.Insertar_CC();
    }//GEN-LAST:event_jLabel_IngresarMouseClicked

    private void jLabel_EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EliminarMouseClicked
        // TODO add your handling code here:
        Clasificacion_Cuenta CC = new Clasificacion_Cuenta(jLabel_CC, txt_idclasi, txt_nombrecla, txt_buscarclasi, tbl_Clasi);
        CC.Eliminar_CC();
    }//GEN-LAST:event_jLabel_EliminarMouseClicked

    private void jLabel_ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ModificarMouseClicked
        // TODO add your handling code here:
        Clasificacion_Cuenta CC = new Clasificacion_Cuenta(jLabel_CC, txt_idclasi, txt_nombrecla, txt_buscarclasi, tbl_Clasi);
        CC.Modificar_CC();
    }//GEN-LAST:event_jLabel_ModificarMouseClicked

    private void txt_buscarclasiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarclasiKeyReleased
        // TODO add your handling code here:
        Clasificacion_Cuenta CC = new Clasificacion_Cuenta(jLabel_CC, txt_idclasi, txt_nombrecla, txt_buscarclasi, tbl_Clasi);
        CC.BuscarCC(txt_buscarclasi.getText());
    }//GEN-LAST:event_txt_buscarclasiKeyReleased

    private void tbl_ClasiCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tbl_ClasiCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_ClasiCaretPositionChanged

    private void jLabel_IngresarCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_IngresarCCMouseClicked
        // TODO add your handling code here:

        Cuenta_Contable cuenta_c = new Cuenta_Contable(jTextField_IDCuenta, jTextField_NombreCuenta, jTextField_IDClasif, jLabel_clasificacion, jTextField_SaldoA, jTextField_CargosA, jTextField_AbonosA, jTextField_SaldoActual, jTextArea_Descripcion, jTextField_Buscar, tbl_CuentaContable);
        cuenta_c.Insertar_CC();
    }//GEN-LAST:event_jLabel_IngresarCCMouseClicked

    private void Panel_MIMECContableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMECContableMouseClicked
        // TODO add your handling code here:
        Panel_Bancos.setVisible(false);
        Panel_CuentaContable.setVisible(true);

        Cuenta_Contable cuenta_c = new Cuenta_Contable(jTextField_IDCuenta, jTextField_NombreCuenta, jTextField_IDClasif, jLabel_clasificacion, jTextField_SaldoA, jTextField_CargosA, jTextField_AbonosA, jTextField_SaldoActual, jTextArea_Descripcion, jTextField_Buscar, tbl_CuentaContable);
        cuenta_c.Encontrar_ListaCC("clasificacion_cuenta", "nombre_clasificacion", jComboBoxIDClasificacion);
        cuenta_c.Actualizar_Tabla();
        

    }//GEN-LAST:event_Panel_MIMECContableMouseClicked

    private void tbl_CuentaContableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CuentaContableMouseClicked
        // TODO add your handling code here:

        int Seleccion = tbl_CuentaContable.rowAtPoint(evt.getPoint());

        jTextField_IDCuenta.setText(String.valueOf(tbl_CuentaContable.getValueAt(Seleccion, 0)));
        jTextField_NombreCuenta.setText(String.valueOf(tbl_CuentaContable.getValueAt(Seleccion, 1)));
        jTextField_IDClasif.setText(String.valueOf(tbl_CuentaContable.getValueAt(Seleccion, 2)));
        jLabel_clasificacion.setText(String.valueOf(tbl_CuentaContable.getValueAt(Seleccion, 3)));
        jTextField_SaldoA.setText(String.valueOf(tbl_CuentaContable.getValueAt(Seleccion, 4)));
        jTextField_CargosA.setText(String.valueOf(tbl_CuentaContable.getValueAt(Seleccion, 5)));
        jTextField_AbonosA.setText(String.valueOf(tbl_CuentaContable.getValueAt(Seleccion, 6)));
        jTextField_SaldoActual.setText(String.valueOf(tbl_CuentaContable.getValueAt(Seleccion, 7)));
//        jTextField_CargosAC.setText(String.valueOf(tbl_CuentaContable.getValueAt(Seleccion, 8)));
//        jTextField_AbonosA.setText(String.valueOf(tbl_CuentaContable.getValueAt(Seleccion, 9)));
        jTextArea_Descripcion.setText(String.valueOf(tbl_CuentaContable.getValueAt(Seleccion, 8)));

        Cuenta_Contable cuenta_c = new Cuenta_Contable(jTextField_IDCuenta, jTextField_NombreCuenta, jTextField_IDClasif, jLabel_clasificacion, jTextField_SaldoA, jTextField_CargosA, jTextField_AbonosA, jTextField_SaldoActual, jTextArea_Descripcion, jTextField_Buscar, tbl_CuentaContable);
        cuenta_c.BuscarFila_CC("nombre_clasificacion", "clasificacion_cuenta", "id_clasificacion", jComboBoxIDClasificacion, jLabel_clasificacion);

//   
    }//GEN-LAST:event_tbl_CuentaContableMouseClicked

    private void tbl_CuentaContableCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tbl_CuentaContableCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_CuentaContableCaretPositionChanged

    private void jTextField_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_BuscarKeyReleased
        // TODO add your handling code here:
        Cuenta_Contable cuenta_c = new Cuenta_Contable(jTextField_IDCuenta, jTextField_NombreCuenta, jTextField_IDClasif, jLabel_clasificacion, jTextField_SaldoA, jTextField_CargosA, jTextField_AbonosA, jTextField_SaldoActual, jTextArea_Descripcion, jTextField_Buscar, tbl_CuentaContable);
        cuenta_c.Buscar_CCF(jTextField_Buscar.getText());
    }//GEN-LAST:event_jTextField_BuscarKeyReleased

    private void jLabel_ModificarCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ModificarCCMouseClicked
        // TODO add your handling code here:
        Cuenta_Contable cuenta_c = new Cuenta_Contable(jTextField_IDCuenta, jTextField_NombreCuenta, jTextField_IDClasif, jLabel_clasificacion, jTextField_SaldoA, jTextField_CargosA, jTextField_AbonosA, jTextField_SaldoActual, jTextArea_Descripcion, jTextField_Buscar, tbl_CuentaContable);
        cuenta_c.Modificar_CC();
    }//GEN-LAST:event_jLabel_ModificarCCMouseClicked

    private void jLabel_EliminarCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EliminarCCMouseClicked
        // TODO add your handling code here:
        Cuenta_Contable cuenta_c = new Cuenta_Contable(jTextField_IDCuenta, jTextField_NombreCuenta, jTextField_IDClasif, jLabel_clasificacion, jTextField_SaldoA, jTextField_CargosA, jTextField_AbonosA, jTextField_SaldoActual, jTextArea_Descripcion, jTextField_Buscar, tbl_CuentaContable);
        cuenta_c.Eliminar_CC();
    }//GEN-LAST:event_jLabel_EliminarCCMouseClicked

    private void jComboBoxIDClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIDClasificacionActionPerformed
        // TODO add your handling code here:
        Cuenta_Contable cuenta_c = new Cuenta_Contable(jTextField_IDCuenta, jTextField_NombreCuenta, jTextField_IDClasif, jLabel_clasificacion, jTextField_SaldoA, jTextField_CargosA, jTextField_AbonosA, jTextField_SaldoActual, jTextArea_Descripcion, jTextField_Buscar, tbl_CuentaContable);
        cuenta_c.EncontrarID_CC("id_clasificacion", "clasificacion_cuenta", "nombre_clasificacion", jComboBoxIDClasificacion, jLabel_clasificacion);
    }//GEN-LAST:event_jComboBoxIDClasificacionActionPerformed

    private void Texto_Ingresar_CCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Ingresar_CCMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarCC.setVisible(true);
        jLabel_ModificarCC.setVisible(false);
        jLabel_EliminarCC.setVisible(false);
        
        // bones en cuenta
        jLabel_SaldoA.setVisible(false);
        jTextField_SaldoA.setVisible(false);
        jLabel_Ca.setVisible(false);
        jLabel_AC.setVisible(false);
        jLabel_SA.setVisible(false);
        jTextField_CargosA.setVisible(false);
        jTextField_AbonosA.setVisible(false);
        jTextField_SaldoActual.setVisible(false);
    }//GEN-LAST:event_Texto_Ingresar_CCMouseClicked

    private void Panel_Ingresar_CCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Ingresar_CCMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Ingresar_CCMouseClicked

    private void Texto_Modificar_CCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Modificar_CCMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarCC.setVisible(false);
        jLabel_ModificarCC.setVisible(true);
        jLabel_EliminarCC.setVisible(false);
        
        // bones en cuenta
        jLabel_SaldoA.setVisible(true);
        jTextField_SaldoA.setVisible(true);
        jLabel_Ca.setVisible(true);
        jLabel_AC.setVisible(true);
        jLabel_SA.setVisible(true);
        jTextField_CargosA.setVisible(true);
        jTextField_AbonosA.setVisible(true);
        jTextField_SaldoActual.setVisible(true);
    }//GEN-LAST:event_Texto_Modificar_CCMouseClicked

    private void Panel_Modificar_CCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Modificar_CCMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Modificar_CCMouseClicked

    private void Texto_Eliminar_CCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Eliminar_CCMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarCC.setVisible(false);
        jLabel_ModificarCC.setVisible(false);
        jLabel_EliminarCC.setVisible(true);
    }//GEN-LAST:event_Texto_Eliminar_CCMouseClicked

    private void Panel_Eliminar_CCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Eliminar_CCMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Eliminar_CCMouseClicked

    private void Texto_Consultar_CCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Consultar_CCMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarCC.setVisible(false);
        jLabel_ModificarCC.setVisible(false);
        jLabel_EliminarCC.setVisible(false);
    }//GEN-LAST:event_Texto_Consultar_CCMouseClicked

    private void Panel_Consultar_CCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Consultar_CCMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Consultar_CCMouseClicked

    private void tbl_DocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DocMouseClicked
        // TODO add your handling code here:
        int Seleccion = tbl_Doc.rowAtPoint(evt.getPoint());
        txt_cod.setText(String.valueOf(tbl_Doc.getValueAt(Seleccion, 0)));
        txt_nombred.setText(String.valueOf(tbl_Doc.getValueAt(Seleccion, 1)));
        txt_afec.setText(String.valueOf(tbl_Doc.getValueAt(Seleccion, 2)));
        txt_estd.setText(String.valueOf(tbl_Doc.getValueAt(Seleccion, 3)));
        Documento_Bancario DB = new Documento_Bancario(jLabel_MMon1, txt_cod, txt_nombred, txt_afec, txt_estd, txt_buscard, tbl_Doc);
    }//GEN-LAST:event_tbl_DocMouseClicked

    private void txt_buscardKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscardKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscardKeyPressed

    private void txt_buscardKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscardKeyReleased
        // TODO add your handling code here:
        Documento_Bancario DB = new Documento_Bancario(jLabel_MMon1, txt_cod, txt_nombred, txt_afec, txt_estd, txt_buscard, tbl_Doc);
        DB.BuscarMon(txt_buscard.getText());
    }//GEN-LAST:event_txt_buscardKeyReleased

    private void txt_buscardKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscardKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscardKeyTyped

    private void ingresadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresadMouseClicked
        // TODO add your handling code here:
        Documento_Bancario DB = new Documento_Bancario(jLabel_MMon1, txt_cod, txt_nombred, txt_afec, txt_estd, txt_buscard, tbl_Doc);
        DB.Insertar_DB();
    }//GEN-LAST:event_ingresadMouseClicked

    private void eliminardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminardMouseClicked
        // TODO add your handling code here:
        Documento_Bancario DB = new Documento_Bancario(jLabel_MMon1, txt_cod, txt_nombred, txt_afec, txt_estd, txt_buscard, tbl_Doc);
        DB.Eliminar_DB();
    }//GEN-LAST:event_eliminardMouseClicked

    private void modificardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificardMouseClicked
        // TODO add your handling code here:
        Documento_Bancario DB = new Documento_Bancario(jLabel_MMon1, txt_cod, txt_nombred, txt_afec, txt_estd, txt_buscard, tbl_Doc);
        DB.Modificar_DB();
    }//GEN-LAST:event_modificardMouseClicked

    private void Texto_Ingresar_EC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Ingresar_EC1MouseClicked
        // TODO add your handling code here:
        ingresad.setVisible(true);
        modificard.setVisible(false);
        eliminard.setVisible(false);
    }//GEN-LAST:event_Texto_Ingresar_EC1MouseClicked

    private void Panel_Ingresar_EC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Ingresar_EC1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Ingresar_EC1MouseClicked

    private void Texto_Modificar_EC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Modificar_EC1MouseClicked
        // TODO add your handling code here:
        ingresad.setVisible(false);
        modificard.setVisible(true);
        eliminard.setVisible(false);
    }//GEN-LAST:event_Texto_Modificar_EC1MouseClicked

    private void Panel_Modificar_EC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Modificar_EC1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Modificar_EC1MouseClicked

    private void Texto_Eliminar_EC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Eliminar_EC1MouseClicked
        // TODO add your handling code here:
        ingresad.setVisible(false);
        modificard.setVisible(false);
        eliminard.setVisible(true);
    }//GEN-LAST:event_Texto_Eliminar_EC1MouseClicked

    private void Panel_Eliminar_EC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Eliminar_EC1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Eliminar_EC1MouseClicked

    private void Texto_Consultar_EC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Consultar_EC1MouseClicked
        // TODO add your handling code here:
        ingresad.setVisible(false);
        modificard.setVisible(false);
        eliminard.setVisible(false);
    }//GEN-LAST:event_Texto_Consultar_EC1MouseClicked

    private void Panel_Consultar_EC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Consultar_EC1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Consultar_EC1MouseClicked

    private void Panel_MIMEDocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMEDocumentoMouseClicked
        // TODO add your handling code here:
        Panel_Bancos.setVisible(false);
        jPanel_Mantenimiento_DocB.setVisible(true);
        Documento_Bancario DB = new Documento_Bancario(jLabel_MMon1, txt_cod, txt_nombred, txt_afec, txt_estd, txt_buscard, tbl_Doc);
        DB.Actualizar_Tabla();
    }//GEN-LAST:event_Panel_MIMEDocumentoMouseClicked

    private void txt_CodigoConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CodigoConceptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CodigoConceptoActionPerformed

    private void jComboBox_Nombre_CuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Nombre_CuentaActionPerformed
        // TODO add your handling code here:
        Concepto_Bancario CB = new Concepto_Bancario(txt_CodigoConcepto, txt_Nombre_Concepto, txt_Afecta, txt_Estatus, jLabel_ID_Cuenta, tbl_CB, txt_BuscarCB);
        CB.EncontrarID_ConceptoB("id_cuenta", "cuenta_contable", "nombre_cuenta", jComboBox_Nombre_Cuenta, jLabel_ID_Cuenta);
    }//GEN-LAST:event_jComboBox_Nombre_CuentaActionPerformed

    private void txt_AfectaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AfectaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AfectaActionPerformed

    private void jLabel_IngresarCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_IngresarCBMouseClicked

        // TODO add your handling code here:
        Concepto_Bancario CB = new Concepto_Bancario(txt_CodigoConcepto, txt_Nombre_Concepto, txt_Afecta, txt_Estatus, jLabel_ID_Cuenta, tbl_CB, txt_BuscarCB);
        CB.Insertar_ConceptoB();
    }//GEN-LAST:event_jLabel_IngresarCBMouseClicked

    private void jLabel_Modificar_CBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Modificar_CBMouseClicked
        // TODO add your handling code here:
        Concepto_Bancario CB = new Concepto_Bancario(txt_CodigoConcepto, txt_Nombre_Concepto, txt_Afecta, txt_Estatus, jLabel_ID_Cuenta, tbl_CB, txt_BuscarCB);
        CB.Modificar_ConceptoB();
    }//GEN-LAST:event_jLabel_Modificar_CBMouseClicked

    private void jLabel_Eliminar_CBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Eliminar_CBMouseClicked
        // TODO add your handling code here:
        Concepto_Bancario CB = new Concepto_Bancario(txt_CodigoConcepto, txt_Nombre_Concepto, txt_Afecta, txt_Estatus, jLabel_ID_Cuenta, tbl_CB, txt_BuscarCB);
        CB.Eliminar_ConceptoB();
    }//GEN-LAST:event_jLabel_Eliminar_CBMouseClicked

    private void tbl_CBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CBMouseClicked
        // TODO add your handling code here:

        int Seleccion = tbl_CB.rowAtPoint(evt.getPoint());

        txt_CodigoConcepto.setText(String.valueOf(tbl_CB.getValueAt(Seleccion, 0)));
        txt_Nombre_Concepto.setText(String.valueOf(tbl_CB.getValueAt(Seleccion, 1)));
        txt_Afecta.setText(String.valueOf(tbl_CB.getValueAt(Seleccion, 2)));
        txt_Estatus.setText(String.valueOf(tbl_CB.getValueAt(Seleccion, 3)));
        jLabel_ID_Cuenta.setText(String.valueOf(tbl_CB.getValueAt(Seleccion, 4)));
        Concepto_Bancario CB = new Concepto_Bancario(txt_CodigoConcepto, txt_Nombre_Concepto, txt_Afecta, txt_Estatus, jLabel_ID_Cuenta, tbl_CB, txt_BuscarCB);
        CB.BuscarFila_ConceptoB("id_cuenta", "cuenta_contable", "id_cuenta", jComboBox_Nombre_Cuenta, jLabel_ID_Cuenta);
    }//GEN-LAST:event_tbl_CBMouseClicked

    private void txt_BuscarCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarCBActionPerformed

    private void txt_BuscarCBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarCBKeyReleased
        // TODO add your handling code here:
        Concepto_Bancario CB = new Concepto_Bancario(txt_CodigoConcepto, txt_Nombre_Concepto, txt_Afecta, txt_Estatus, jLabel_ID_Cuenta, tbl_CB, txt_BuscarCB);
        CB.Buscar_SolicitudConceptoB(txt_BuscarCB.getText());
    }//GEN-LAST:event_txt_BuscarCBKeyReleased

    private void jLabel_BuscarAPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_BuscarAPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_BuscarAPMouseClicked

    private void Texto_IngresarCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarCBMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarCB.setVisible(true);
        jLabel_Modificar_CB.setVisible(false);
        jLabel_Eliminar_CB.setVisible(false);
    }//GEN-LAST:event_Texto_IngresarCBMouseClicked

    private void Panel_IngresarCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarCBMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarCBMouseClicked

    private void Texto_ModificarCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificarCBMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarCB.setVisible(false);
        jLabel_Modificar_CB.setVisible(true);
        jLabel_Eliminar_CB.setVisible(false);
    }//GEN-LAST:event_Texto_ModificarCBMouseClicked

    private void Panel_ModificarCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarCBMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarCBMouseClicked

    private void Texto_EliminarCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarCBMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarCB.setVisible(false);
        jLabel_Modificar_CB.setVisible(false);
        jLabel_Eliminar_CB.setVisible(true);
    }//GEN-LAST:event_Texto_EliminarCBMouseClicked

    private void Panel_EliminarCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_EliminarCBMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_EliminarCBMouseClicked

    private void Texto_ConsultarCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarCBMouseClicked
        // TODO add your handling code here:
        jLabel_IngresarCB.setVisible(false);
        jLabel_Modificar_CB.setVisible(false);
        jLabel_Eliminar_CB.setVisible(false);
    }//GEN-LAST:event_Texto_ConsultarCBMouseClicked

    private void Panel_ConsultarCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ConsultarCBMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ConsultarCBMouseClicked

    private void jComboBox_TablasCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TablasCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TablasCBActionPerformed

    private void jLabel_Buscar_Tablas_CBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Buscar_Tablas_CBMouseClicked
        // TODO add your handling code here:

        /* Item_DPI = jComboBox_TablasCB.getSelectedItem().toString();

        if (Item_DPI == S_DPI) {
            Curriculum_V CV = new Curriculum_V();
            CV.setVisible(true);
        }*/
    }//GEN-LAST:event_jLabel_Buscar_Tablas_CBMouseClicked

    private void txt_Nombre_ConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Nombre_ConceptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Nombre_ConceptoActionPerformed

    private void txt_EstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_EstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EstatusActionPerformed

    private void txt_CodigoMovimientoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CodigoMovimientoEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CodigoMovimientoEActionPerformed

    private void jComboBox_Nombre_MovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Nombre_MovimientoActionPerformed
        Movimiento_Bancario_Encabezado Mo = new Movimiento_Bancario_Encabezado(txt_CodigoMovimientoE, jLabel_ID_Documento, txt_Fecha, txt_Monto, txt_Descripcion, txt_BuscarMovBanEn, tbl_MovimientoBanEn);
        Mo.EncontrarID_MovimientoBAEN("codigo_Documento", "Documento_bancario", "nombre_Documento", jComboBox_Nombre_Movimiento, jLabel_ID_Documento);

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_Nombre_MovimientoActionPerformed

    private void txt_FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FechaActionPerformed

    private void jLabel_IngresarMBENMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_IngresarMBENMouseClicked
        // Movimiento_Bancario_Encabezado Mo = new Movimiento_Bancario_Encabezado(txt_CodigoMovimientoE, jLabel_ID_Documento, txt_Fecha, txt_Monto, txt_Descripcion, txt_BuscarMovBanEn,tbl_MovimientoBanEn);
        Movimiento_Bancario_Encabezado Mo = new Movimiento_Bancario_Encabezado(txt_CodigoMovimientoE, jLabel_ID_Documento, txt_Fecha, txt_Monto, txt_Descripcion, txt_BuscarMovBanEn, tbl_MovimientoBanEn);
        Mo.Insertar_MOBAEN();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_IngresarMBENMouseClicked

    private void jLabel_Modificar_MBENMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Modificar_MBENMouseClicked
        Movimiento_Bancario_Encabezado Mo = new Movimiento_Bancario_Encabezado(txt_CodigoMovimientoE, jLabel_ID_Documento, txt_Fecha, txt_Monto, txt_Descripcion, txt_BuscarMovBanEn, tbl_MovimientoBanEn);
        Mo.Modificar_MOBAEN();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_Modificar_MBENMouseClicked

    private void jLabel_Eliminar_MBENMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Eliminar_MBENMouseClicked
        Movimiento_Bancario_Encabezado Mo = new Movimiento_Bancario_Encabezado(txt_CodigoMovimientoE, jLabel_ID_Documento, txt_Fecha, txt_Monto, txt_Descripcion, txt_BuscarMovBanEn, tbl_MovimientoBanEn);
        Mo.Eliminar_MOBAEN();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_Eliminar_MBENMouseClicked

    private void tbl_MovimientoBanEnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_MovimientoBanEnMouseClicked
        Movimiento_Bancario_Encabezado Mo = new Movimiento_Bancario_Encabezado(txt_CodigoMovimientoE, jLabel_ID_Documento, txt_Fecha, txt_Monto, txt_Descripcion, txt_BuscarMovBanEn, tbl_MovimientoBanEn);
        int Seleccion = tbl_MovimientoBanEn.rowAtPoint(evt.getPoint());

        txt_CodigoMovimientoE.setText(String.valueOf(tbl_MovimientoBanEn.getValueAt(Seleccion, 0)));
        jLabel_ID_Documento.setText(String.valueOf(tbl_MovimientoBanEn.getValueAt(Seleccion, 1)));
        txt_Fecha.setText(String.valueOf(tbl_MovimientoBanEn.getValueAt(Seleccion, 2)));
        txt_Monto.setText(String.valueOf(tbl_MovimientoBanEn.getValueAt(Seleccion, 3)));
        txt_Descripcion.setText(String.valueOf(tbl_MovimientoBanEn.getValueAt(Seleccion, 4)));
        Mo.BuscarFila_MovimientoBAEN("nombre_Documento", "Documento_bancario", "codigo_Documento", jComboBox_Nombre_Cuenta, jLabel_ID_Documento);

        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_MovimientoBanEnMouseClicked

    private void txt_BuscarMovBanEnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarMovBanEnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarMovBanEnActionPerformed

    private void txt_BuscarMovBanEnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarMovBanEnKeyReleased
        Movimiento_Bancario_Encabezado Mo = new Movimiento_Bancario_Encabezado(txt_CodigoMovimientoE, jLabel_ID_Documento, txt_Fecha, txt_Monto, txt_Descripcion, txt_BuscarMovBanEn, tbl_MovimientoBanEn);
        Mo.Buscar_MovimientoBanEn(txt_BuscarMovBanEn.getText());// TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarMovBanEnKeyReleased

    private void jLabel_BuscarMBENMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_BuscarMBENMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_BuscarMBENMouseClicked

    private void Texto_IngresarMBENMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_IngresarMBENMouseClicked
        jLabel_IngresarMBEN.setVisible(true);
        jLabel_Modificar_MBEN.setVisible(false);
        jLabel_Eliminar_MBEN.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_Texto_IngresarMBENMouseClicked

    private void Panel_IngresarMBENMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_IngresarMBENMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_IngresarMBENMouseClicked

    private void Texto_ModificarMBENMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ModificarMBENMouseClicked
        jLabel_IngresarMBEN.setVisible(false);
        jLabel_Modificar_MBEN.setVisible(true);
        jLabel_Eliminar_MBEN.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_ModificarMBENMouseClicked

    private void Panel_ModificarMBENMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ModificarMBENMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ModificarMBENMouseClicked

    private void Texto_EliminarMBENMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_EliminarMBENMouseClicked
        jLabel_IngresarMBEN.setVisible(false);
        jLabel_Modificar_MBEN.setVisible(false);
        jLabel_Eliminar_MBEN.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_EliminarMBENMouseClicked

    private void Panel_EliminarMBENMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_EliminarMBENMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_EliminarMBENMouseClicked

    private void Texto_ConsultarMBENMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_ConsultarMBENMouseClicked
        jLabel_IngresarMBEN.setVisible(false);
        jLabel_Modificar_MBEN.setVisible(false);
        jLabel_Eliminar_MBEN.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_ConsultarMBENMouseClicked

    private void Panel_ConsultarMBENMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ConsultarMBENMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_ConsultarMBENMouseClicked

    private void jComboBox_TablasCB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TablasCB1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TablasCB1ActionPerformed

    private void txt_DescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DescripcionActionPerformed

    private void txt_MontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MontoActionPerformed

    private void Panel_MIMEConceptoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMEConceptoMouseClicked
        Panel_Bancos.setVisible(false);
        jPanel_MantenimientoCB.setVisible(true);
        Concepto_Bancario CB = new Concepto_Bancario(txt_CodigoConcepto, txt_Nombre_Concepto, txt_Afecta, txt_Estatus, jLabel_ID_Cuenta, tbl_CB, txt_BuscarCB);
        CB.Encontrar_ListaConceptoB("cuenta_contable", "nombre_cuenta", jComboBox_Nombre_Cuenta);
        CB.EncontrarID_ConceptoB("id_cuenta", "cuenta_contable", "nombre_cuenta", jComboBox_Nombre_Cuenta, jLabel_ID_Cuenta);
        CB.Actualizar_Tabla();      // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMEConceptoMouseClicked

    private void Panel_MIMEMBEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMEMBEMouseClicked
        Panel_Bancos.setVisible(false);
        JPanel_MantenimientoMovimientoBanEn.setVisible(true);
        Movimiento_Bancario_Encabezado Mo = new Movimiento_Bancario_Encabezado(txt_CodigoMovimientoE, jLabel_ID_Documento, txt_Fecha, txt_Monto, txt_Descripcion, txt_BuscarMovBanEn, tbl_MovimientoBanEn);

        Mo.Actualizar_Tabla();

        Mo.Encontrar_ListaMovimientoBAEN("Documento_bancario", "nombre_Documento", jComboBox_Nombre_Movimiento);
        //Mo.EncontrarID_MovimientoBAEN("codigo_Documento", "Documento_bancario", "nombre_Documento", jComboBox_Nombre_Cuenta, jLabel_ID_Documento);        // TODO add your handling code here:


    }//GEN-LAST:event_Panel_MIMEMBEMouseClicked

    private void jTextField_BuscarMovKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_BuscarMovKeyReleased
        // TODO add your handling code here:
        Movimiento_Bancario_Detalle MovDet = new Movimiento_Bancario_Detalle(jLabel_IDEnc, jLabel_codigoConcepto, jTextField_Saldo, jTextField_tipoSaldo, jTextField_BuscarMov, tbl_MovBancDet);
        MovDet.Buscar_MovD(jTextField_BuscarMov.getText());

    }//GEN-LAST:event_jTextField_BuscarMovKeyReleased

    private void tbl_MovBancDetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_MovBancDetMouseClicked
        // TODO add your handling code here:

        Movimiento_Bancario_Detalle MovDet = new Movimiento_Bancario_Detalle(jLabel_IDEnc, jLabel_codigoConcepto, jTextField_Saldo, jTextField_tipoSaldo, jTextField_BuscarMov, tbl_MovBancDet);
        int Seleccion = tbl_MovimientoBanEn.rowAtPoint(evt.getPoint());

        jLabel_IDEnc.setText(String.valueOf(tbl_MovBancDet.getValueAt(Seleccion, 0)));
        jLabel_codigoConcepto.setText(String.valueOf(tbl_MovBancDet.getValueAt(Seleccion, 1)));
        jTextField_Saldo.setText(String.valueOf(tbl_MovBancDet.getValueAt(Seleccion, 2)));
        jTextField_tipoSaldo.setText(String.valueOf(tbl_MovBancDet.getValueAt(Seleccion, 3)));
        MovDet.BuscarFila_Mov("id_movEnc", "mov_bancEnc", "id_movEnc", jComboBox_Encabezado, jLabel_IDEnc);
        MovDet.BuscarFila_Mov("nombre_concepto", "concepto_bancario", "codigo_concepto", jComboBox_codigoC, jLabel_codigoConcepto);

        //Mo.BuscarFila_MovimientoBAEN("nombre_Documento", "Documento_bancario", "codigo_Documento", jComboBox_Nombre_Cuenta, jLabel_ID_Documento);
    }//GEN-LAST:event_tbl_MovBancDetMouseClicked

    private void tbl_MovBancDetCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tbl_MovBancDetCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_MovBancDetCaretPositionChanged

    private void jLabel60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel60MouseClicked
        // TODO add your handling code here:
        Movimiento_Bancario_Detalle MovDet = new Movimiento_Bancario_Detalle(jLabel_IDEnc, jLabel_codigoConcepto, jTextField_Saldo, jTextField_tipoSaldo, jTextField_BuscarMov, tbl_MovBancDet);
        MovDet.Insertar_Mov();
    }//GEN-LAST:event_jLabel60MouseClicked

    private void Panel_MIMBDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMBDMouseClicked
        // TODO add your handling code here:
        Panel_Bancos.setVisible(false);
        jPanel_MantenimientoMovBanDet.setVisible(true);

        Movimiento_Bancario_Detalle MovDet = new Movimiento_Bancario_Detalle(jLabel_IDEnc, jLabel_codigoConcepto, jTextField_Saldo, jTextField_tipoSaldo, jTextField_BuscarMov, tbl_MovBancDet);
        MovDet.Encontrar_ListaMov("concepto_bancario", "nombre_concepto", jComboBox_codigoC);
        MovDet.Encontrar_ListaMov("mov_bancEnc", "id_movEnc", jComboBox_Encabezado);
        MovDet.Actualizar_Tabla();

    }//GEN-LAST:event_Panel_MIMBDMouseClicked

    private void Panel_MIMBDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMBDMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MIMBDMouseEntered

    private void jComboBox_EncabezadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_EncabezadoActionPerformed
        // TODO add your handling code here:
        Movimiento_Bancario_Detalle MovDet = new Movimiento_Bancario_Detalle(jLabel_IDEnc, jLabel_codigoConcepto, jTextField_Saldo, jTextField_tipoSaldo, jTextField_BuscarMov, tbl_MovBancDet);
        MovDet.EncontrarIDMov("id_movEnc", "mov_bancEnc", "id_movEnc", jComboBox_Encabezado, jLabel_IDEnc);

    }//GEN-LAST:event_jComboBox_EncabezadoActionPerformed

    private void jComboBox_codigoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_codigoCActionPerformed
        // TODO add your handling code here:
        Movimiento_Bancario_Detalle MovDet = new Movimiento_Bancario_Detalle(jLabel_IDEnc, jLabel_codigoConcepto, jTextField_Saldo, jTextField_tipoSaldo, jTextField_BuscarMov, tbl_MovBancDet);
        MovDet.EncontrarIDMov("codigo_concepto", "concepto_bancario", "nombre_concepto", jComboBox_codigoC, jLabel_codigoConcepto);
    }//GEN-LAST:event_jComboBox_codigoCActionPerformed

    private void jLabel61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseClicked
        // TODO add your handling code here:
        Movimiento_Bancario_Detalle MovDet = new Movimiento_Bancario_Detalle(jLabel_IDEnc, jLabel_codigoConcepto, jTextField_Saldo, jTextField_tipoSaldo, jTextField_BuscarMov, tbl_MovBancDet);
        MovDet.Modificar_Mov();
    }//GEN-LAST:event_jLabel61MouseClicked

    private void jLabel62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel62MouseClicked
        // TODO add your handling code here:
        Movimiento_Bancario_Detalle MovDet = new Movimiento_Bancario_Detalle(jLabel_IDEnc, jLabel_codigoConcepto, jTextField_Saldo, jTextField_tipoSaldo, jTextField_BuscarMov, tbl_MovBancDet);
        MovDet.Eliminar_Mov();
    }//GEN-LAST:event_jLabel62MouseClicked

    private void tbl_FormaPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_FormaPagoMouseClicked
        // TODO add your handling code here:
        Forma_de_Pago forma = new Forma_de_Pago(jTextField_IDForma, jTextField_TipoPago, jTextField_BuscarFP, tbl_FormaPago);
        int Seleccion = tbl_MovimientoBanEn.rowAtPoint(evt.getPoint());

        jTextField_IDForma.setText(String.valueOf(tbl_FormaPago.getValueAt(Seleccion, 0)));
        jTextField_TipoPago.setText(String.valueOf(tbl_FormaPago.getValueAt(Seleccion, 1)));


    }//GEN-LAST:event_tbl_FormaPagoMouseClicked

    private void tbl_FormaPagoCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tbl_FormaPagoCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_FormaPagoCaretPositionChanged

    private void Panel_MIMFPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MIMFPMouseClicked
        // TODO add your handling code here:
        Panel_Bancos.setVisible(false);
        jPanel_Forma_de_Pago.setVisible(true);

        Forma_de_Pago forma = new Forma_de_Pago(jTextField_IDForma, jTextField_TipoPago, jTextField_BuscarFP, tbl_FormaPago);
        forma.Actualizar_Tabla();
    }//GEN-LAST:event_Panel_MIMFPMouseClicked

    private void jLabel66MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel66MouseClicked
        // TODO add your handling code here:
        Forma_de_Pago forma = new Forma_de_Pago(jTextField_IDForma, jTextField_TipoPago, jTextField_BuscarFP, tbl_FormaPago);
        forma.Insertar_FormaPago();
    }//GEN-LAST:event_jLabel66MouseClicked

    private void jTextField_BuscarFPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_BuscarFPMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField_BuscarFPMouseReleased

    private void jTextField_BuscarFPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_BuscarFPKeyReleased
        // TODO add your handling code here:
        Forma_de_Pago forma = new Forma_de_Pago(jTextField_IDForma, jTextField_TipoPago, jTextField_BuscarFP, tbl_FormaPago);
        forma.Buscar_FPF(jTextField_BuscarFP.getText());
    }//GEN-LAST:event_jTextField_BuscarFPKeyReleased

    private void jLabel67MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel67MouseClicked
        // TODO add your handling code here:
        Forma_de_Pago forma = new Forma_de_Pago(jTextField_IDForma, jTextField_TipoPago, jTextField_BuscarFP, tbl_FormaPago);
        forma.Modificar_FormaPago();
    }//GEN-LAST:event_jLabel67MouseClicked

    private void jLabel68MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel68MouseClicked
        // TODO add your handling code here:
        Forma_de_Pago forma = new Forma_de_Pago(jTextField_IDForma, jTextField_TipoPago, jTextField_BuscarFP, tbl_FormaPago);
        forma.Eliminar_formapago();
    }//GEN-LAST:event_jLabel68MouseClicked

    private void tbl_BancosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_BancosMouseClicked
        Banco B = new Banco(jTextField_IDBanco, jTextField_NombreBanco, jTextField_NombreC, jTextField_ClaveBan, jTextField_Funcionario, jTextField_Telefono, jTextField_NumeroPlaza, jTextField_NumeroS, jTextField_SaldoI, jLabel_ID_Moneda, jLabel_IdMovimiento, txt_buscardBan, tbl_Bancos);

        int Seleccion = tbl_Bancos.rowAtPoint(evt.getPoint());

        jTextField_IDBanco.setText(String.valueOf(tbl_Bancos.getValueAt(Seleccion, 0)));
        jTextField_NombreBanco.setText(String.valueOf(tbl_Bancos.getValueAt(Seleccion, 1)));
        jTextField_NombreC.setText(String.valueOf(tbl_Bancos.getValueAt(Seleccion, 2)));
        jTextField_ClaveBan.setText(String.valueOf(tbl_Bancos.getValueAt(Seleccion, 3)));
        jTextField_Funcionario.setText(String.valueOf(tbl_Bancos.getValueAt(Seleccion, 5)));
        jTextField_Telefono.setText(String.valueOf(tbl_Bancos.getValueAt(Seleccion, 6)));
        jTextField_NumeroPlaza.setText(String.valueOf(tbl_Bancos.getValueAt(Seleccion, 7)));
        jTextField_NumeroS.setText(String.valueOf(tbl_Bancos.getValueAt(Seleccion, 8)));
        jTextField_SaldoI.setText(String.valueOf(tbl_Bancos.getValueAt(Seleccion, 9)));
        jLabel_ID_Moneda.setText(String.valueOf(tbl_Bancos.getValueAt(Seleccion, 10)));
        jTextField_IDBanco.setText(String.valueOf(tbl_Bancos.getValueAt(Seleccion, 11)));
        jLabel_IdMovimiento.setText(String.valueOf(tbl_Bancos.getValueAt(Seleccion, 12)));

        B.BuscarFila_Bancos("nombre_moneda", "moneda", "id_moneda", jComboBoxIDMoneda, jLabel_ID_Moneda);
        B.BuscarFila_Bancos("codigo_Documento", "mov_bancEnc", "id_movEnc", jComboBoxIDMovEn, jLabel_IdMovimiento);

        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_BancosMouseClicked

    private void txt_buscardBanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscardBanKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscardBanKeyPressed

    private void txt_buscardBanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscardBanKeyReleased

        Banco B = new Banco(jTextField_IDBanco, jTextField_NombreBanco, jTextField_NombreC, jTextField_ClaveBan, jTextField_Funcionario, jTextField_Telefono, jTextField_NumeroPlaza, jTextField_NumeroS, jTextField_SaldoI, jLabel_ID_Moneda, jLabel_IdMovimiento, txt_buscardBan, tbl_Bancos);
        B.Buscar_BancosB(txt_buscardBan.getText());
    }//GEN-LAST:event_txt_buscardBanKeyReleased

    private void txt_buscardBanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscardBanKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscardBanKeyTyped

    private void IngresaBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IngresaBMouseClicked
        Banco B = new Banco(jTextField_IDBanco, jTextField_NombreBanco, jTextField_NombreC, jTextField_ClaveBan, jTextField_Funcionario, jTextField_Telefono, jTextField_NumeroPlaza, jTextField_NumeroS, jTextField_SaldoI, jLabel_ID_Moneda, jLabel_IdMovimiento, txt_buscardBan, tbl_Bancos);
        B.Insertar_Banco();
// TODO add your handling code here:
    }//GEN-LAST:event_IngresaBMouseClicked

    private void EliminarBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarBMouseClicked
        Banco B = new Banco(jTextField_IDBanco, jTextField_NombreBanco, jTextField_NombreC, jTextField_ClaveBan, jTextField_Funcionario, jTextField_Telefono, jTextField_NumeroPlaza, jTextField_NumeroS, jTextField_SaldoI, jLabel_ID_Moneda, jLabel_IdMovimiento, txt_buscardBan, tbl_Bancos);
        B.Eliminar_Banco();

// TODO add your handling code here:
    }//GEN-LAST:event_EliminarBMouseClicked

    private void ModificarBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificarBMouseClicked
        Banco B = new Banco(jTextField_IDBanco, jTextField_NombreBanco, jTextField_NombreC, jTextField_ClaveBan, jTextField_Funcionario, jTextField_Telefono, jTextField_NumeroPlaza, jTextField_NumeroS, jTextField_SaldoI, jLabel_ID_Moneda, jLabel_IdMovimiento, txt_buscardBan, tbl_Bancos);
        B.Modificar_Bancos();

// TODO add your handling code here:
    }//GEN-LAST:event_ModificarBMouseClicked

    private void Texto_Ingresar_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Ingresar_BMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_Ingresar_BMouseClicked

    private void Panel_Ingresar_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Ingresar_BMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Ingresar_BMouseClicked

    private void Texto_Modificar_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Modificar_BMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_Modificar_BMouseClicked

    private void Panel_Modificar_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Modificar_BMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Modificar_BMouseClicked

    private void Texto_Eliminar_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Eliminar_BMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_Eliminar_BMouseClicked

    private void Panel_Eliminar_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Eliminar_BMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Eliminar_BMouseClicked

    private void Texto_Consultar_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Consultar_BMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_Consultar_BMouseClicked

    private void Panel_Consultar_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Consultar_BMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Consultar_BMouseClicked

    private void jComboBoxIDMonedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIDMonedaActionPerformed
        Banco B = new Banco(jTextField_IDBanco, jTextField_NombreBanco, jTextField_NombreC, jTextField_ClaveBan, jTextField_Funcionario, jTextField_Telefono, jTextField_NumeroPlaza, jTextField_NumeroS, jTextField_SaldoI, jLabel_ID_Moneda, jLabel_IdMovimiento, txt_buscardBan, tbl_Bancos);
        B.EncontrarID_Bancos("id_moneda", "moneda", "nombre_moneda", jComboBoxIDMoneda, jLabel_ID_Moneda);// TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxIDMonedaActionPerformed

    private void jTextField_FuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_FuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_FuncionarioActionPerformed

    private void jComboBoxIDMovEnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIDMovEnActionPerformed
        Banco B = new Banco(jTextField_IDBanco, jTextField_NombreBanco, jTextField_NombreC, jTextField_ClaveBan, jTextField_Funcionario, jTextField_Telefono, jTextField_NumeroPlaza, jTextField_NumeroS, jTextField_SaldoI, jLabel_ID_Moneda, jLabel_IdMovimiento, txt_buscardBan, tbl_Bancos);
        B.EncontrarID_Bancos("id_movEnc", "mov_bancEnc", "codigo_Documento", jComboBoxIDMovEn, jLabel_IdMovimiento);// TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxIDMovEnActionPerformed

    private void Panel_MBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MBMouseClicked
        Panel_Bancos.setVisible(false);
        jPanel_MantenimientoBanco.setVisible(true);

        Banco B = new Banco(jTextField_IDBanco, jTextField_NombreBanco, jTextField_NombreC, jTextField_ClaveBan, jTextField_Funcionario, jTextField_Telefono, jTextField_NumeroPlaza, jTextField_NumeroS, jTextField_SaldoI, jLabel_ID_Moneda, jLabel_IdMovimiento, txt_buscardBan, tbl_Bancos);
        B.Actualizar_Tabla();
        B.Encontrar_ListaBancos("moneda", "nombre_moneda", jComboBoxIDMoneda);
        B.Encontrar_ListaBancos("mov_bancEnc", "codigo_Documento", jComboBoxIDMovEn);

        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MBMouseClicked

    private void tbl_BancosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_BancosKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_BancosKeyReleased

    private void tbl_ConcilacioEnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ConcilacioEnMouseClicked
        Concilacion_Bancaria_Encabezado Con = new Concilacion_Bancaria_Encabezado(txt_IdEnca, txt_CargoAConciliar, txt_AbonoA_Conciliar, txt_SaldoCorte, txt_Cargo_Conciliado, txt_Abono_Conciliado, txt_Saldo_Final, txt_BuscarCoBaEn, tbl_ConcilacioEn);
        int Seleccion = tbl_ConcilacioEn.rowAtPoint(evt.getPoint());

        txt_IdEnca.setText(String.valueOf(tbl_ConcilacioEn.getValueAt(Seleccion, 0)));
        txt_CargoAConciliar.setText(String.valueOf(tbl_ConcilacioEn.getValueAt(Seleccion, 1)));
        txt_AbonoA_Conciliar.setText(String.valueOf(tbl_ConcilacioEn.getValueAt(Seleccion, 2)));
        txt_SaldoCorte.setText(String.valueOf(tbl_ConcilacioEn.getValueAt(Seleccion, 3)));
        txt_Cargo_Conciliado.setText(String.valueOf(tbl_ConcilacioEn.getValueAt(Seleccion, 4)));
        txt_Abono_Conciliado.setText(String.valueOf(tbl_ConcilacioEn.getValueAt(Seleccion, 5)));
        txt_Saldo_Final.setText(String.valueOf(tbl_ConcilacioEn.getValueAt(Seleccion, 6)));

// TODO add your handling code here:
    }//GEN-LAST:event_tbl_ConcilacioEnMouseClicked

    private void txt_BuscarCoBaEnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarCoBaEnKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarCoBaEnKeyPressed

    private void txt_BuscarCoBaEnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarCoBaEnKeyReleased
        Concilacion_Bancaria_Encabezado Con = new Concilacion_Bancaria_Encabezado(txt_IdEnca, txt_CargoAConciliar, txt_AbonoA_Conciliar, txt_SaldoCorte, txt_Cargo_Conciliado, txt_Abono_Conciliado, txt_Saldo_Final, txt_BuscarCoBaEn, tbl_ConcilacioEn);
        Con.Buscar_ConciliacionEncabezado(txt_BuscarCoBaEn.getText());
// TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarCoBaEnKeyReleased

    private void txt_BuscarCoBaEnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarCoBaEnKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarCoBaEnKeyTyped

    private void ingresarConcilacionEnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarConcilacionEnMouseClicked
        Concilacion_Bancaria_Encabezado Con = new Concilacion_Bancaria_Encabezado(txt_IdEnca, txt_CargoAConciliar, txt_AbonoA_Conciliar, txt_SaldoCorte, txt_Cargo_Conciliado, txt_Abono_Conciliado, txt_Saldo_Final, txt_BuscarCoBaEn, tbl_ConcilacioEn);
        Con.Insertar_ConciliacionEn();// TODO add your handling code here:
    }//GEN-LAST:event_ingresarConcilacionEnMouseClicked

    private void eliminarConcilacionEnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarConcilacionEnMouseClicked
        Concilacion_Bancaria_Encabezado Con = new Concilacion_Bancaria_Encabezado(txt_IdEnca, txt_CargoAConciliar, txt_AbonoA_Conciliar, txt_SaldoCorte, txt_Cargo_Conciliado, txt_Abono_Conciliado, txt_Saldo_Final, txt_BuscarCoBaEn, tbl_ConcilacioEn);
        Con.Eliminar_ConcilacionEn();// TODO add your handling code here:
    }//GEN-LAST:event_eliminarConcilacionEnMouseClicked

    private void modificarConcilacionEnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarConcilacionEnMouseClicked
        Concilacion_Bancaria_Encabezado Con = new Concilacion_Bancaria_Encabezado(txt_IdEnca, txt_CargoAConciliar, txt_AbonoA_Conciliar, txt_SaldoCorte, txt_Cargo_Conciliado, txt_Abono_Conciliado, txt_Saldo_Final, txt_BuscarCoBaEn, tbl_ConcilacioEn);
        Con.Modificar_ConciliacionEN(); // TODO add your handling code here:
    }//GEN-LAST:event_modificarConcilacionEnMouseClicked

    private void Texto_Ingresar_CoBaEnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Ingresar_CoBaEnMouseClicked
        ingresarConcilacionEn.setVisible(true);
        eliminarConcilacionEn.setVisible(false);
        modificarConcilacionEn.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_Texto_Ingresar_CoBaEnMouseClicked

    private void Panel_Ingresar_CoBaEnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Ingresar_CoBaEnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Ingresar_CoBaEnMouseClicked

    private void Texto_Modificar_CoBaEnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Modificar_CoBaEnMouseClicked
        ingresarConcilacionEn.setVisible(false);
        eliminarConcilacionEn.setVisible(false);
        modificarConcilacionEn.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_Modificar_CoBaEnMouseClicked

    private void Panel_Modificar_CoBaEnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Modificar_CoBaEnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Modificar_CoBaEnMouseClicked

    private void Texto_Eliminar_CoBaEnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Eliminar_CoBaEnMouseClicked
        ingresarConcilacionEn.setVisible(false);
        eliminarConcilacionEn.setVisible(true);
        modificarConcilacionEn.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_Eliminar_CoBaEnMouseClicked

    private void Panel_Eliminar_CoBaEnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Eliminar_CoBaEnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Eliminar_CoBaEnMouseClicked

    private void Texto_Consultar_CoBaEnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Consultar_CoBaEnMouseClicked
        ingresarConcilacionEn.setVisible(false);
        eliminarConcilacionEn.setVisible(false);
        modificarConcilacionEn.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_Consultar_CoBaEnMouseClicked

    private void Panel_Consultar_CoBaEnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Consultar_CoBaEnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Consultar_CoBaEnMouseClicked

    private void Panel_MCBEncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MCBEncMouseClicked
        Concilacion_Bancaria_Encabezado Con = new Concilacion_Bancaria_Encabezado(txt_IdEnca, txt_CargoAConciliar, txt_AbonoA_Conciliar, txt_SaldoCorte, txt_Cargo_Conciliado, txt_Abono_Conciliado, txt_Saldo_Final, txt_BuscarCoBaEn, tbl_ConcilacioEn);
        Con.Actualizar_Tabla();
        Panel_Bancos.setVisible(false);
        jPanel_Manatenimiento_ConBanEn.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MCBEncMouseClicked

    private void tbl_CBDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CBDMouseClicked
        // TODO add your handling code here:
        int Seleccion = tbl_CBD.rowAtPoint(evt.getPoint());

        jLabel_ID_Encabezado.setText(String.valueOf(tbl_CBD.getValueAt(Seleccion, 0)));
        jLabel_Idcodigoconcepto.setText(String.valueOf(tbl_CBD.getValueAt(Seleccion, 1)));
        txt_fechaap.setText(String.valueOf(tbl_CBD.getValueAt(Seleccion, 2)));
        jTextArea_Descrip.setText(String.valueOf(tbl_CBD.getValueAt(Seleccion, 3)));
        jLabel_idformapago.setText(String.valueOf(tbl_CBD.getValueAt(Seleccion, 4)));
        txt_beneficiario.setText(String.valueOf(tbl_CBD.getValueAt(Seleccion, 5)));
        txt_estcon.setText(String.valueOf(tbl_CBD.getValueAt(Seleccion, 6)));
        txt_cargo.setText(String.valueOf(tbl_CBD.getValueAt(Seleccion, 7)));
        txt_abono.setText(String.valueOf(tbl_CBD.getValueAt(Seleccion, 8)));

        Conciliacion_Bancaria_Detalle CBD = new Conciliacion_Bancaria_Detalle(jLabel_ID_Encabezado,jLabel_Idcodigoconcepto,txt_fechaap,jTextArea_Descrip,jLabel_idformapago, txt_beneficiario,txt_estcon,txt_cargo,txt_abono,txt_buscardCBD,tbl_CBD);       
        CBD.BuscarFila_CBD("id_encabezado", "conciliacion_bancenc", "id_encabezado", jComboBoxIDEncabezado, jLabel_ID_Encabezado);
        CBD.BuscarFila_CBD("nombre_concepto", "concepto_bancario", "codigo_concepto", jComboBoxCODIGOCONCEPTO, jLabel_Idcodigoconcepto);
        CBD.BuscarFila_CBD("tipo_pago", "forma_pago", "id_formapago", jComboBoxIDFormaPago, jLabel_idformapago);
        
        
        
    }//GEN-LAST:event_tbl_CBDMouseClicked

    private void tbl_CBDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_CBDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_CBDKeyReleased

    private void txt_buscardCBDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscardCBDKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscardCBDKeyPressed

    private void txt_buscardCBDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscardCBDKeyReleased
        // TODO add your handling code here:
        Conciliacion_Bancaria_Detalle CBD = new Conciliacion_Bancaria_Detalle(jLabel_ID_Encabezado,jLabel_Idcodigoconcepto,txt_fechaap,jTextArea_Descrip,jLabel_idformapago, txt_beneficiario,txt_estcon,txt_cargo,txt_abono,txt_buscardCBD,tbl_CBD);
        CBD.Buscar_CBD2(txt_buscardCBD.getText());
        
    }//GEN-LAST:event_txt_buscardCBDKeyReleased

    private void txt_buscardCBDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscardCBDKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscardCBDKeyTyped

    private void IngresaB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IngresaB1MouseClicked
        // TODO add your handling code here:
        Conciliacion_Bancaria_Detalle CBD = new Conciliacion_Bancaria_Detalle(jLabel_ID_Encabezado,jLabel_Idcodigoconcepto,txt_fechaap,jTextArea_Descrip,jLabel_idformapago, txt_beneficiario,txt_estcon,txt_cargo,txt_abono,txt_buscardCBD,tbl_CBD);
        CBD.Insertar_CBD();
        CBD.Actualizar_Tabla();
    }//GEN-LAST:event_IngresaB1MouseClicked

    private void EliminarB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarB1MouseClicked
        // TODO add your handling code here:
        Conciliacion_Bancaria_Detalle CBD = new Conciliacion_Bancaria_Detalle(jLabel_ID_Encabezado,jLabel_Idcodigoconcepto,txt_fechaap,jTextArea_Descrip,jLabel_idformapago, txt_beneficiario,txt_estcon,txt_cargo,txt_abono,txt_buscardCBD,tbl_CBD);
        CBD.Eliminar_CBD();
    }//GEN-LAST:event_EliminarB1MouseClicked

    private void ModificarB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificarB1MouseClicked
        // TODO add your handling code here:
        Conciliacion_Bancaria_Detalle CBD = new Conciliacion_Bancaria_Detalle(jLabel_ID_Encabezado,jLabel_Idcodigoconcepto,txt_fechaap,jTextArea_Descrip,jLabel_idformapago, txt_beneficiario,txt_estcon,txt_cargo,txt_abono,txt_buscardCBD,tbl_CBD);
        CBD.Modificar_CBD();
        /*CBD.Encontrar_ListaCBD("conciliacion_bancenc", "id_encabezado", jComboBoxIDEncabezado);
        CBD.Encontrar_ListaCBD("concepto_bancario", "codigo_concepto", jComboBoxCODIGOCONCEPTO);
        CBD.Encontrar_ListaCBD("forma_pago", "id_formapago", jComboBoxIDFormaPago);*/
    }//GEN-LAST:event_ModificarB1MouseClicked

    private void Texto_Ingresar_B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Ingresar_B1MouseClicked
        // TODO add your handling code here:
        IngresaB1.setVisible(true);
        ModificarB1.setVisible(false);
        EliminarB1.setVisible(false);
        
    }//GEN-LAST:event_Texto_Ingresar_B1MouseClicked

    private void Panel_Ingresar_B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Ingresar_B1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Ingresar_B1MouseClicked

    private void Texto_Modificar_B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Modificar_B1MouseClicked
        // TODO add your handling code here:
        IngresaB1.setVisible(false);
        ModificarB1.setVisible(true);
        EliminarB1.setVisible(false);
    }//GEN-LAST:event_Texto_Modificar_B1MouseClicked

    private void Panel_Modificar_B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Modificar_B1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Modificar_B1MouseClicked

    private void Texto_Eliminar_B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Eliminar_B1MouseClicked
        // TODO add your handling code here:
        IngresaB1.setVisible(false);
        ModificarB1.setVisible(false);
        EliminarB1.setVisible(true);
    }//GEN-LAST:event_Texto_Eliminar_B1MouseClicked

    private void Panel_Eliminar_B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Eliminar_B1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Eliminar_B1MouseClicked

    private void Texto_Consultar_B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Consultar_B1MouseClicked
        // TODO add your handling code here:
        IngresaB1.setVisible(false);
        ModificarB1.setVisible(false);
        EliminarB1.setVisible(false);
    }//GEN-LAST:event_Texto_Consultar_B1MouseClicked

    private void Panel_Consultar_B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Consultar_B1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_Consultar_B1MouseClicked

    private void jComboBoxIDFormaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIDFormaPagoActionPerformed
        // TODO add your handling code here:
        Conciliacion_Bancaria_Detalle CBD = new Conciliacion_Bancaria_Detalle(jLabel_ID_Encabezado,jLabel_Idcodigoconcepto,txt_fechaap,jTextArea_Descrip,jLabel_idformapago, txt_beneficiario,txt_estcon,txt_cargo,txt_abono,txt_buscardCBD,tbl_CBD);
        CBD.EncontrarID_CBD("id_formapago", "forma_pago", "tipo_pago", jComboBoxIDFormaPago, jLabel_idformapago);
    }//GEN-LAST:event_jComboBoxIDFormaPagoActionPerformed

    private void jComboBoxCODIGOCONCEPTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCODIGOCONCEPTOActionPerformed
        // TODO add your handling code here:
        Conciliacion_Bancaria_Detalle CBD = new Conciliacion_Bancaria_Detalle(jLabel_ID_Encabezado,jLabel_Idcodigoconcepto,txt_fechaap,jTextArea_Descrip,jLabel_idformapago, txt_beneficiario,txt_estcon,txt_cargo,txt_abono,txt_buscardCBD,tbl_CBD);
        CBD.EncontrarID_CBD("codigo_concepto", "concepto_bancario", "nombre_concepto", jComboBoxCODIGOCONCEPTO, jLabel_Idcodigoconcepto);
    }//GEN-LAST:event_jComboBoxCODIGOCONCEPTOActionPerformed

    private void jComboBoxIDEncabezadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIDEncabezadoActionPerformed
        // TODO add your handling code here:
        Conciliacion_Bancaria_Detalle CBD = new Conciliacion_Bancaria_Detalle(jLabel_ID_Encabezado,jLabel_Idcodigoconcepto,txt_fechaap,jTextArea_Descrip,jLabel_idformapago, txt_beneficiario,txt_estcon,txt_cargo,txt_abono,txt_buscardCBD,tbl_CBD);
        CBD.EncontrarID_CBD("id_encabezado", "conciliacion_bancenc", "id_encabezado", jComboBoxIDEncabezado, jLabel_ID_Encabezado);
    }//GEN-LAST:event_jComboBoxIDEncabezadoActionPerformed

    private void jComboBoxIDClasificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxIDClasificacionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxIDClasificacionMouseClicked

    private void Panel_ConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ConsultasMouseClicked
        // TODO add your handling code here:
        Panel_Bancos.setVisible(false);
        jPanel_ConsultaBancos_Saldos.setVisible(true);
        
        Consulta_Saldos consulta = new Consulta_Saldos(tbl_ConsultaDet, tbl_ConsultaEnc, tbl_CuentaContable);
        consulta.Actualizar_Tabla_DET();
        consulta.Actualizar_Tabla_ENC();
//        consulta.Buscar_Saldo_Actual();
//        consulta.Buscar_Saldo_Deudor();
//        consulta.Buscar_Saldo_Acreedor();
        
    }//GEN-LAST:event_Panel_ConsultasMouseClicked

    private void tbl_ConsultaDetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ConsultaDetMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_ConsultaDetMouseClicked

    private void tbl_ConsultaDetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_ConsultaDetKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_ConsultaDetKeyReleased

    private void tbl_ConsultaEncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ConsultaEncMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_ConsultaEncMouseClicked

    private void tbl_ConsultaEncKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_ConsultaEncKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_ConsultaEncKeyReleased

    private void jLabel_MantenimientoM11MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM11MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM11MouseMoved

    private void jLabel_MantenimientoM11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM11MouseClicked

    private void jLabel_MantenimientoM11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MantenimientoM11MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MantenimientoM11MouseExited

    private void Panel_MCBEnc2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MCBEnc2MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MCBEnc2MouseDragged

    private void Panel_MCBEnc2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MCBEnc2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MCBEnc2MouseClicked

    private void Panel_MCBEnc2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MCBEnc2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MCBEnc2MouseExited

    private void Panel_MCBEnc2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_MCBEnc2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_MCBEnc2MouseReleased

    private void jLabel105MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel105MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel105MouseClicked

    private void Texto_Modificar_CCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Texto_Modificar_CCMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_Modificar_CCMouseEntered

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        Consulta_Saldos consulta = new Consulta_Saldos(tbl_ConsultaDet, tbl_ConsultaEnc, tbl_CuentaContable);
        consulta.Actualizar_Tabla_DET();
        consulta.Actualizar_Tabla_ENC();
        consulta.Buscar_Saldo_Actual();
        consulta.Buscar_Saldo_Deudor();
        consulta.Buscar_Saldo_Acreedor();
        
        Cuenta_Contable cuenta_c = new Cuenta_Contable(jTextField_IDCuenta, jTextField_NombreCuenta, jTextField_IDClasif, jLabel_clasificacion, jTextField_SaldoA, jTextField_CargosA, jTextField_AbonosA, jTextField_SaldoActual, jTextArea_Descripcion, jTextField_Buscar, tbl_CuentaContable);
        cuenta_c.Actualizar_Tabla();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        Consulta_Saldos consulta = new Consulta_Saldos(tbl_ConsultaDet, tbl_ConsultaEnc, tbl_CuentaContable);
        consulta.Saldo_Anterior();
        
        
        Cuenta_Contable cuenta_c = new Cuenta_Contable(jTextField_IDCuenta, jTextField_NombreCuenta, jTextField_IDClasif, jLabel_clasificacion, jTextField_SaldoA, jTextField_CargosA, jTextField_AbonosA, jTextField_SaldoActual, jTextArea_Descripcion, jTextField_Buscar, tbl_CuentaContable);
        cuenta_c.Actualizar_Tabla();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jButton_PDFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_PDFMouseClicked
        // TODO add your handling code here:
        
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);

        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }

        Document doc = new Document();


        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + ".pdf"));
            
            doc.open();
            
            /*Titulo*/
            Paragraph p= new Paragraph("Bitácora de Saldo en Cuentas \n \n", FontFactory.getFont("Arial", 11 , Font.BOLD));
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);
            doc.add(new Paragraph(""));
            
            float [] celdas= {7.00f, 7.00f, 7.00f, 7.00f,7.00f,7.00f,7.00f,7.00f,7.00f, };
            
            PdfPTable tb1= new PdfPTable(9); //cantidad de columnas
            tb1.setWidths(celdas);
            
            //agregando encabezado
            tb1.addCell(new Paragraph("Codigo", FontFactory.getFont("Arial", 10)));
            tb1.addCell(new Paragraph ("Nombre", FontFactory.getFont("Arial", 10)));
            tb1.addCell(new Paragraph ("Tipo", FontFactory.getFont("Arial", 10)));
            tb1.addCell(new Paragraph ("ID Clasificacion", FontFactory.getFont("Arial", 10)));
            tb1.addCell(new Paragraph ("Saldo Anterior", FontFactory.getFont("Arial", 10)));
            tb1.addCell(new Paragraph ("Cargos Acum.", FontFactory.getFont("Arial", 10)));
            tb1.addCell(new Paragraph ("Abonos Acumu.", FontFactory.getFont("Arial", 10)));
            tb1.addCell(new Paragraph ("Saldo Actual", FontFactory.getFont("Arial", 10)));
            tb1.addCell(new Paragraph ("Descrip.", FontFactory.getFont("Arial", 10)));
            
            
            
            for (int i = 0; i < tbl_CuentaContable.getRowCount(); i++) {
                
                String Codigo_Cuenta =(String) tbl_CuentaContable.getValueAt(i, 0); // columna inicial
                String Nombre = (String) tbl_CuentaContable.getValueAt(i, 1); 
                String Tipo= (String) tbl_CuentaContable.getValueAt(i, 2);
                String Clasificacion = (String) tbl_CuentaContable.getValueAt(i, 3); 
                String SA= (String) tbl_CuentaContable.getValueAt(i, 4);
                String CA = (String) tbl_CuentaContable.getValueAt(i, 5); 
                String AC= (String) tbl_CuentaContable.getValueAt(i, 6);
                String SAC = (String) tbl_CuentaContable.getValueAt(i, 7); 
                String Des= (String) tbl_CuentaContable.getValueAt(i, 8);
                
                //tb1.addCell(new Paragraph("Codigo", FontFactory.getFont("Arial", 10)));
                
                int valor =8;
                tb1.addCell(new Paragraph(Codigo_Cuenta, FontFactory.getFont("Arial", valor))); // agregando lo que tiene el string en la posicion de la tabla
                tb1.addCell(new Paragraph(Nombre, FontFactory.getFont("Arial", valor)));
                tb1.addCell(new Paragraph(Tipo, FontFactory.getFont("Arial", valor)));
                tb1.addCell(new Paragraph(Clasificacion, FontFactory.getFont("Arial", valor)));
                tb1.addCell(new Paragraph(SA, FontFactory.getFont("Arial", valor)));
                tb1.addCell(new Paragraph(CA, FontFactory.getFont("Arial", valor)));
                tb1.addCell(new Paragraph(AC, FontFactory.getFont("Arial", valor)));
                tb1.addCell(new Paragraph(SAC, FontFactory.getFont("Arial", valor)));
                tb1.addCell(new Paragraph(Des, FontFactory.getFont("Arial", valor)));
            }
            
            doc.add(tb1);
            
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            //Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }

        doc.close();
    }//GEN-LAST:event_jButton_PDFMouseClicked

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
            java.util.logging.Logger.getLogger(Bancos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bancos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bancos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bancos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bancos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cant_B;
    private javax.swing.JLabel Cant_BE;
    private javax.swing.JLabel Cant_CB;
    private javax.swing.JLabel Cant_CBD;
    private javax.swing.JLabel Cant_CBE;
    private javax.swing.JLabel Cant_CC;
    private javax.swing.JLabel Cant_CuCon;
    private javax.swing.JLabel Cant_DB;
    private javax.swing.JLabel Cant_FP;
    private javax.swing.JLabel Cant_MBD;
    private javax.swing.JLabel Cant_Moneda;
    private javax.swing.JLabel EliminarB;
    private javax.swing.JLabel EliminarB1;
    private javax.swing.JLabel IngresaB;
    private javax.swing.JLabel IngresaB1;
    private javax.swing.JPanel JPanel_MantenimientoMovimientoBanEn;
    private javax.swing.JLabel ModificarB;
    private javax.swing.JLabel ModificarB1;
    private javax.swing.JPanel Panel_Bancos;
    private javax.swing.JPanel Panel_ConsultarCB;
    private javax.swing.JPanel Panel_ConsultarMBEN;
    private javax.swing.JPanel Panel_ConsultarS;
    private javax.swing.JPanel Panel_Consultar_B;
    private javax.swing.JPanel Panel_Consultar_B1;
    private javax.swing.JPanel Panel_Consultar_CC;
    private javax.swing.JPanel Panel_Consultar_CoBaEn;
    private javax.swing.JPanel Panel_Consultar_EC;
    private javax.swing.JPanel Panel_Consultar_EC1;
    private javax.swing.JPanel Panel_Consultas;
    private javax.swing.JPanel Panel_CuentaContable;
    private javax.swing.JPanel Panel_EliminarCB;
    private javax.swing.JPanel Panel_EliminarMBEN;
    private javax.swing.JPanel Panel_EliminarS;
    private javax.swing.JPanel Panel_Eliminar_B;
    private javax.swing.JPanel Panel_Eliminar_B1;
    private javax.swing.JPanel Panel_Eliminar_CC;
    private javax.swing.JPanel Panel_Eliminar_CoBaEn;
    private javax.swing.JPanel Panel_Eliminar_EC;
    private javax.swing.JPanel Panel_Eliminar_EC1;
    private javax.swing.JPanel Panel_IngresarCB;
    private javax.swing.JPanel Panel_IngresarMBEN;
    private javax.swing.JPanel Panel_IngresarS;
    private javax.swing.JPanel Panel_Ingresar_B;
    private javax.swing.JPanel Panel_Ingresar_B1;
    private javax.swing.JPanel Panel_Ingresar_CC;
    private javax.swing.JPanel Panel_Ingresar_CoBaEn;
    private javax.swing.JPanel Panel_Ingresar_EC;
    private javax.swing.JPanel Panel_Ingresar_EC1;
    private javax.swing.JPanel Panel_MB;
    private javax.swing.JPanel Panel_MCBEnc;
    private javax.swing.JPanel Panel_MCBEnc2;
    private javax.swing.JPanel Panel_MIMBD;
    private javax.swing.JPanel Panel_MIMEC;
    private javax.swing.JPanel Panel_MIMEC1;
    private javax.swing.JPanel Panel_MIMECContable;
    private javax.swing.JPanel Panel_MIMEConcepto;
    private javax.swing.JPanel Panel_MIMEDocumento;
    private javax.swing.JPanel Panel_MIMEMBE;
    private javax.swing.JPanel Panel_MIMFP;
    private javax.swing.JPanel Panel_ModificarCB;
    private javax.swing.JPanel Panel_ModificarMBEN;
    private javax.swing.JPanel Panel_ModificarS;
    private javax.swing.JPanel Panel_Modificar_B;
    private javax.swing.JPanel Panel_Modificar_B1;
    private javax.swing.JPanel Panel_Modificar_CC;
    private javax.swing.JPanel Panel_Modificar_CoBaEn;
    private javax.swing.JPanel Panel_Modificar_EC;
    private javax.swing.JPanel Panel_Modificar_EC1;
    private javax.swing.JLabel Texto_ConsultarCB;
    private javax.swing.JLabel Texto_ConsultarMBEN;
    private javax.swing.JLabel Texto_ConsultarS;
    private javax.swing.JLabel Texto_Consultar_B;
    private javax.swing.JLabel Texto_Consultar_B1;
    private javax.swing.JLabel Texto_Consultar_CC;
    private javax.swing.JLabel Texto_Consultar_CoBaEn;
    private javax.swing.JLabel Texto_Consultar_EC;
    private javax.swing.JLabel Texto_Consultar_EC1;
    private javax.swing.JLabel Texto_EliminarCB;
    private javax.swing.JLabel Texto_EliminarMBEN;
    private javax.swing.JLabel Texto_EliminarS;
    private javax.swing.JLabel Texto_Eliminar_B;
    private javax.swing.JLabel Texto_Eliminar_B1;
    private javax.swing.JLabel Texto_Eliminar_CC;
    private javax.swing.JLabel Texto_Eliminar_CoBaEn;
    private javax.swing.JLabel Texto_Eliminar_EC;
    private javax.swing.JLabel Texto_Eliminar_EC1;
    private javax.swing.JLabel Texto_IngresarCB;
    private javax.swing.JLabel Texto_IngresarMBEN;
    private javax.swing.JLabel Texto_IngresarS;
    private javax.swing.JLabel Texto_Ingresar_B;
    private javax.swing.JLabel Texto_Ingresar_B1;
    private javax.swing.JLabel Texto_Ingresar_CC;
    private javax.swing.JLabel Texto_Ingresar_CoBaEn;
    private javax.swing.JLabel Texto_Ingresar_EC;
    private javax.swing.JLabel Texto_Ingresar_EC1;
    private javax.swing.JLabel Texto_ModificarCB;
    private javax.swing.JLabel Texto_ModificarMBEN;
    private javax.swing.JLabel Texto_ModificarS;
    private javax.swing.JLabel Texto_Modificar_B;
    private javax.swing.JLabel Texto_Modificar_B1;
    private javax.swing.JLabel Texto_Modificar_CC;
    private javax.swing.JLabel Texto_Modificar_CoBaEn;
    private javax.swing.JLabel Texto_Modificar_EC;
    private javax.swing.JLabel Texto_Modificar_EC1;
    private javax.swing.JLabel eliminar;
    private javax.swing.JLabel eliminarConcilacionEn;
    private javax.swing.JLabel eliminard;
    private javax.swing.JLabel ingresad;
    private javax.swing.JLabel ingresar;
    private javax.swing.JLabel ingresarConcilacionEn;
    private javax.swing.JButton jButton_PDF;
    private javax.swing.JComboBox<String> jComboBoxCODIGOCONCEPTO;
    private javax.swing.JComboBox<String> jComboBoxIDClasificacion;
    private javax.swing.JComboBox<String> jComboBoxIDEncabezado;
    private javax.swing.JComboBox<String> jComboBoxIDFormaPago;
    private javax.swing.JComboBox<String> jComboBoxIDMoneda;
    private javax.swing.JComboBox<String> jComboBoxIDMovEn;
    private javax.swing.JComboBox<String> jComboBox_Encabezado;
    private javax.swing.JComboBox<String> jComboBox_Nombre_Cuenta;
    private javax.swing.JComboBox<String> jComboBox_Nombre_Movimiento;
    private javax.swing.JComboBox<String> jComboBox_TablasCB;
    private javax.swing.JComboBox<String> jComboBox_TablasCB1;
    private javax.swing.JComboBox<String> jComboBox_codigoC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLabel jLabel_AC;
    private javax.swing.JLabel jLabel_BuscarAP;
    private javax.swing.JLabel jLabel_BuscarMBEN;
    private javax.swing.JLabel jLabel_Buscar_Tablas_CB;
    private javax.swing.JLabel jLabel_CC;
    private javax.swing.JLabel jLabel_Ca;
    private javax.swing.JLabel jLabel_CodigoConcepto;
    private javax.swing.JLabel jLabel_CodigoConcepto1;
    private javax.swing.JLabel jLabel_DPIAP;
    private javax.swing.JLabel jLabel_DPIAP1;
    private javax.swing.JLabel jLabel_Eliminar;
    private javax.swing.JLabel jLabel_EliminarCC;
    private javax.swing.JLabel jLabel_Eliminar_CB;
    private javax.swing.JLabel jLabel_Eliminar_MBEN;
    private javax.swing.JLabel jLabel_Fecha;
    private javax.swing.JLabel jLabel_IDEnc;
    private javax.swing.JLabel jLabel_ID_Cuenta;
    private javax.swing.JLabel jLabel_ID_Documento;
    private javax.swing.JLabel jLabel_ID_Encabezado;
    private javax.swing.JLabel jLabel_ID_Moneda;
    private javax.swing.JLabel jLabel_IdMovimiento;
    private javax.swing.JLabel jLabel_Idcodigoconcepto;
    private javax.swing.JLabel jLabel_Ingresar;
    private javax.swing.JLabel jLabel_IngresarCB;
    private javax.swing.JLabel jLabel_IngresarCC;
    private javax.swing.JLabel jLabel_IngresarMBEN;
    private javax.swing.JLabel jLabel_MMon;
    private javax.swing.JLabel jLabel_MMon1;
    private javax.swing.JLabel jLabel_MMon2;
    private javax.swing.JLabel jLabel_MMon3;
    private javax.swing.JLabel jLabel_MMon4;
    private javax.swing.JLabel jLabel_MantenimientoM;
    private javax.swing.JLabel jLabel_MantenimientoM1;
    private javax.swing.JLabel jLabel_MantenimientoM10;
    private javax.swing.JLabel jLabel_MantenimientoM11;
    private javax.swing.JLabel jLabel_MantenimientoM2;
    private javax.swing.JLabel jLabel_MantenimientoM3;
    private javax.swing.JLabel jLabel_MantenimientoM4;
    private javax.swing.JLabel jLabel_MantenimientoM5;
    private javax.swing.JLabel jLabel_MantenimientoM6;
    private javax.swing.JLabel jLabel_MantenimientoM7;
    private javax.swing.JLabel jLabel_MantenimientoM8;
    private javax.swing.JLabel jLabel_MantenimientoM9;
    private javax.swing.JLabel jLabel_Modificar;
    private javax.swing.JLabel jLabel_ModificarCC;
    private javax.swing.JLabel jLabel_Modificar_CB;
    private javax.swing.JLabel jLabel_Modificar_MBEN;
    private javax.swing.JLabel jLabel_NombreAP;
    private javax.swing.JLabel jLabel_NombreAP1;
    private javax.swing.JLabel jLabel_NombreConcepto;
    private javax.swing.JLabel jLabel_NombreConcepto1;
    private javax.swing.JLabel jLabel_RequisitosAP;
    private javax.swing.JLabel jLabel_RequisitosAP1;
    private javax.swing.JLabel jLabel_RequisitosAP3;
    private javax.swing.JLabel jLabel_SA;
    private javax.swing.JLabel jLabel_SaldoA;
    private javax.swing.JLabel jLabel_TituloCC;
    private javax.swing.JLabel jLabel_clasificacion;
    private javax.swing.JLabel jLabel_codigoConcepto;
    private javax.swing.JLabel jLabel_idformapago;
    private javax.swing.JPanel jPanel_ConsultaBancos_Saldos;
    private javax.swing.JPanel jPanel_Forma_de_Pago;
    private javax.swing.JPanel jPanel_Manatenimiento_ConBanEn;
    private javax.swing.JPanel jPanel_MantenimientoBanco;
    private javax.swing.JPanel jPanel_MantenimientoCB;
    private javax.swing.JPanel jPanel_MantenimientoClasiCuenta;
    private javax.swing.JPanel jPanel_MantenimientoMoneda;
    private javax.swing.JPanel jPanel_MantenimientoMovBanDet;
    private javax.swing.JPanel jPanel_Mantenimiento_CBD;
    private javax.swing.JPanel jPanel_Mantenimiento_DocB;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JScrollPane jScrollPane40;
    private javax.swing.JScrollPane jScrollPane41;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JScrollPane jScrollPane43;
    private javax.swing.JScrollPane jScrollPane44;
    private javax.swing.JScrollPane jScrollPane45;
    private javax.swing.JScrollPane jScrollPane46;
    private javax.swing.JScrollPane jScrollPane47;
    private javax.swing.JScrollPane jScrollPane48;
    private javax.swing.JTextArea jTextArea_Descrip;
    private javax.swing.JTextArea jTextArea_Descripcion;
    private javax.swing.JTextField jTextField_AbonosA;
    private javax.swing.JTextField jTextField_Buscar;
    private javax.swing.JTextField jTextField_BuscarFP;
    private javax.swing.JTextField jTextField_BuscarMov;
    private javax.swing.JTextField jTextField_CargosA;
    private javax.swing.JTextField jTextField_ClaveBan;
    private javax.swing.JTextField jTextField_Funcionario;
    private javax.swing.JTextField jTextField_IDBanco;
    private javax.swing.JTextField jTextField_IDClasif;
    private javax.swing.JTextField jTextField_IDCuenta;
    private javax.swing.JTextField jTextField_IDForma;
    private javax.swing.JTextField jTextField_NombreBanco;
    private javax.swing.JTextField jTextField_NombreC;
    private javax.swing.JTextField jTextField_NombreCuenta;
    private javax.swing.JTextField jTextField_NumeroPlaza;
    private javax.swing.JTextField jTextField_NumeroS;
    private javax.swing.JTextField jTextField_Saldo;
    private javax.swing.JTextField jTextField_SaldoA;
    private javax.swing.JTextField jTextField_SaldoActual;
    private javax.swing.JTextField jTextField_SaldoI;
    private javax.swing.JTextField jTextField_Telefono;
    private javax.swing.JTextField jTextField_TipoPago;
    private javax.swing.JTextField jTextField_tipoSaldo;
    private javax.swing.JLabel modificar;
    private javax.swing.JLabel modificarConcilacionEn;
    private javax.swing.JLabel modificard;
    private javax.swing.JTable tbl_Bancos;
    private javax.swing.JTable tbl_CB;
    private javax.swing.JTable tbl_CBD;
    private javax.swing.JTable tbl_Clasi;
    private javax.swing.JTable tbl_ConcilacioEn;
    private javax.swing.JTable tbl_ConsultaDet;
    private javax.swing.JTable tbl_ConsultaEnc;
    private javax.swing.JTable tbl_CuentaContable;
    private javax.swing.JTable tbl_Doc;
    private javax.swing.JTable tbl_FormaPago;
    private javax.swing.JTable tbl_Moneda;
    private javax.swing.JTable tbl_MovBancDet;
    private javax.swing.JTable tbl_MovimientoBanEn;
    private javax.swing.JTextField txt_AbonoA_Conciliar;
    private javax.swing.JTextField txt_Abono_Conciliado;
    private javax.swing.JTextField txt_Afecta;
    private javax.swing.JTextField txt_BuscarCB;
    private javax.swing.JTextField txt_BuscarCoBaEn;
    private javax.swing.JTextField txt_BuscarMovBanEn;
    private javax.swing.JTextField txt_CargoAConciliar;
    private javax.swing.JTextField txt_Cargo_Conciliado;
    private javax.swing.JTextField txt_CodigoConcepto;
    private javax.swing.JTextField txt_CodigoMovimientoE;
    private javax.swing.JTextField txt_Descripcion;
    private javax.swing.JTextField txt_Estatus;
    private javax.swing.JTextField txt_Fecha;
    private javax.swing.JTextField txt_IDM;
    private javax.swing.JTextField txt_IdEnca;
    private javax.swing.JTextField txt_Monto;
    private javax.swing.JTextField txt_NombreM;
    private javax.swing.JTextField txt_Nombre_Concepto;
    private javax.swing.JTextField txt_SaldoCorte;
    private javax.swing.JTextField txt_Saldo_Final;
    private javax.swing.JTextField txt_TipoM;
    private javax.swing.JTextField txt_abono;
    private javax.swing.JTextField txt_afec;
    private javax.swing.JTextField txt_beneficiario;
    private javax.swing.JTextField txt_buscarMon;
    private javax.swing.JTextField txt_buscarclasi;
    private javax.swing.JTextField txt_buscard;
    private javax.swing.JTextField txt_buscardBan;
    private javax.swing.JTextField txt_buscardCBD;
    private javax.swing.JTextField txt_cargo;
    private javax.swing.JTextField txt_cod;
    private javax.swing.JTextField txt_estM;
    private javax.swing.JTextField txt_estcon;
    private javax.swing.JTextField txt_estd;
    private javax.swing.JTextField txt_fechaap;
    private javax.swing.JTextField txt_idclasi;
    private javax.swing.JTextField txt_nombrecla;
    private javax.swing.JTextField txt_nombred;
    // End of variables declaration//GEN-END:variables
}
