use Hotel;

-- INSERTS RRHH
insert into nivel_academico values ("1", "Nivel Medio", "ninguna");
insert into nivel_academico values ("2", "Universitario", "ninguna");
insert into nivel_academico values ("3", "Magister", "ninguna");
insert into nivel_academico values ("4", "Doctorado", "ninguna");

insert into explab_detallado values ("1", "Inventarios", "Carro Modelo", "1996-08-15", "2019-05-10");
insert into explab_detallado values ("2", "Ventas", "El hacer", "1980-05-14", "2000-08-06");
insert into explab_detallado values ("3", "Servicio", "LTD", "2015-05-02", "2019-04-04");
insert into explab_detallado values ("4", "Computacion", "TFC", "2013-05-15", "2020-01-13");

insert into experiencia_laboral values ("1", "1");
insert into experiencia_laboral values ("2", "2");
insert into experiencia_laboral values ("3", "3");
insert into experiencia_laboral values ("4", "4");

insert into referenciasP values ("1", "Ernesto Paco", "45785625");
insert into referenciasP values ("2", "Juan Cal", "55558555");
insert into referenciasP values ("3", "Danien Juarez", "45212781");

insert into referenciasL values ("1", "Alex Diego", "45678222");
insert into referenciasL values ("2", "Juan Daniel", "15985222");
insert into referenciasL values ("3", "Artemio Dominguez", "45658545");

insert into puesto values ("1", "Desarrollador", "Conocimientos", "A");
insert into puesto values ("2", "Administrador", "ninguna", "A");
insert into puesto values ("3", "Analista", "De riesgos", "A");

insert into departamento values ("1", "Sistemas", "A");
insert into departamento values ("2", "Financiero", "A");
insert into departamento values ("3", "Seguridad", "A");

insert into solicitud_empresarial values ("1", "20", "35", "M", "1", "1", "2", "1", "ninguna");
insert into solicitud_empresarial values ("2", "20", "35", "M", "2", "2", "2", "2", "ninguna");
insert into solicitud_empresarial values ("3", "20", "35", "M", "3", "3", "3", "3", "ninguna");

insert into medio values ("1", "1","Prensa", "Ninguna");
insert into medio values ("2", "2","Television", "Ninguna");
insert into medio values ("3", "3", "Internet", "Ninguna");

insert into curriculum values ("3110", "Jose", "Migel", "4567895", "Jose@gmail.com", "Ciudad", "M", "22", "2","1","1", "1", "1");
insert into curriculum values ("3111", "Carlos", "Marcos", "56561245", "Carlos@gmail.com", "Ciudad", "M", "25", "2", "2", "2", "2", "2");
insert into curriculum values ("3112", "Daniel", "Guitierrez", "78985623", "Daniel@gmail.com", "Ciudad", "M", "30", "3","3","3", "3", "3");

insert into aplicacion values ("1", "3110", "S");
insert into aplicacion values ("2", "3111", "S");
insert into aplicacion values ("3", "3112", "S");

insert into tipo_pruebas values ("1", "Psicologo");
insert into tipo_pruebas values ("2", "Polígrafo");
insert into tipo_pruebas values ("3", "Habilidades");

insert into aplicacion_prueba values ("1", "1", "1", "A");
insert into aplicacion_prueba values ("2", "2", "2", "A");
insert into aplicacion_prueba values ("3", "3", "3", "A");

insert into seleccion values ("1", "1", "A");
insert into seleccion values ("2", "2", "A");
insert into seleccion values ("3", "3", "A");

insert into actividad values ("1", "Capacitacion", "nuevos");
insert into actividad values ("2", "Induccion", "nuevos");
insert into actividad values ("3", "Desempeño", "Empleados");

insert into periodo_prueba values ("1", "1", "2020-08-15", "2020-09-15", "2000", "1");
insert into periodo_prueba values ("2", "2", "2020-08-15", "2020-10-08", "3000", "2");
insert into periodo_prueba values ("3", "3", "2020-08-15", "2020-12-09", "10000", "2");

insert into contratacion values ("1", "1", "2019-08-15", "1 año", "A");
insert into contratacion values ("2", "2", "2019-08-15", "6 meses", "A");
insert into contratacion values ("3", "3", "2019-08-15", "2 años", "A");

insert into empleado_contratado values ("1010", "1", "1", "1", "10000");
insert into empleado_contratado values ("1011", "2", "2", "2", "8000");
insert into empleado_contratado values ("1012", "3", "3", "3", "12000");

insert into actividad_empleado values ("1010", "1");
insert into actividad_empleado values ("1011", "2");
insert into actividad_empleado values ("1012", "3");

-- INSERTS NOMINA 
-- para los % (Usarlos si no se corrienron en la BD en el script donde esta el LDD, si si se insertarin omitir lo comentado)
/*insert into Concepto_Planilla values ("1","IGSS","Porcentaje","Deducccion","0.0483");
insert into Concepto_Planilla values ("2","ISR1","Porcentaje","Deducccion","0.05");
insert into Concepto_Planilla values ("3","ISR2","Porcentaje","Deducccion","0.06");
insert into Concepto_Planilla values ("4","ISR3","Porcentaje","Deducccion","0.08");*/

insert into planilla_enc values ("1", "10100", "483", "9617");

insert into planilla_det values ("1", "1", "1010", "1", "483");
insert into planilla_det values ("2", "1", "1010", "5", "10");
insert into planilla_det values ("3", "1", "1010", "6", "10000");

-- INSERTS BANCOS
insert into moneda values ("1", "Quetzal", "0.00", "A");
insert into moneda values ("2", "Dólar", "7.78", "A");
insert into moneda values ("3", "Euro", "0.11", "A");
insert into moneda values ("4", "Yen Japones", "13.51", "A");

insert into clasificacion_cuenta values ("1", "Corriente");
insert into clasificacion_cuenta values ("2", "No Corriente");
insert into clasificacion_cuenta values ("3", "Ingresos");
insert into clasificacion_cuenta values ("4", "Pérdida");
insert into clasificacion_cuenta values ("5", "Ganancia");

insert into cuenta_contable values ("1", "Caja", "Activo", "1", 0,0,0,0, "Efectivo");
insert into cuenta_contable values ("2", "Bancos", "Activo", "1", 0,0,0,0, "Cheques");
insert into cuenta_contable values ("3", "Ventas", "Estado de Resultados", "5", 0,0,0,0, "Ganancias");
insert into cuenta_contable values ("4", "Préstamos Bancarios", "Activo", "1", 0,0,0,0, "Cheques");

insert into documento_bancario values ("0001", "Pago", "+", "A");
insert into documento_bancario values ("0002", "Cheque", "+", "A");
insert into documento_bancario values ("0003", "Factura", "+", "A");
insert into documento_bancario values ("0004", "Depósito", "-", "A");

insert into concepto_bancario values ("1", "Concepto 1", "+", "A", "1");
insert into concepto_bancario values ("2", "Concepto 2", "+", "A", "2");
insert into concepto_bancario values ("3", "Concepto 3", "+", "A", "3");
insert into concepto_bancario values ("4", "Concepto 4", "-", "A", "4");

insert into mov_bancEnc values ("1", "0001", "2020-11-10", "10000", "Diferentes operaciones");
insert into mov_bancEnc values ("2", "0002", "2020-11-09", "15000", "Distintas Transacciones");

insert into forma_pago values ("1", "Efectivo");
insert into forma_pago values ("2", "Crédito");
insert into forma_pago values ("3", "Cuota");
insert into forma_pago values ("4", "Cheque");

insert into banco values ("1", "Banco X", "ADMINISTRADOR 1", "1203", "David de Paz", 45852555, 1, 1, "15000", "1", "1");
insert into banco values ("2", "Banco Y", "ADMINISTRADOR 2", "1597", "Karla Santos", 58256522, 1, 1, "5000", "2", "2");

insert into conciliacion_bancenc values ("1", "1000", "50", "800", "60", "40", "100");
insert into conciliacion_bancenc values ("2", "500", "80", "200", "100", "500", "800");

describe conciliacion_bancaria_det;
insert into conciliacion_bancaria_det values ("1", "1", "2020-08-15", "operacion", "1", "cliente", "A", "800", "200");
insert into conciliacion_bancaria_det values ("2", "3", "2020-08-15", "operacion", "3", "Proveedor", "A", "1000", "500");

