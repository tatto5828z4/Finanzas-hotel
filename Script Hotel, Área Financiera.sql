-- Drop database Hotel;
create database Hotel;
use Hotel;

/*Área de RRHH*/
create table nivel_academico( -- peticion de la empresa 
	id_nivel_academico varchar(10) primary key,
	nombre_nivel varchar(100), 
    descripcion varchar(80)
) engine = InnoDB default char set=latin1;

create table explab_detallado(
	id_tipoexp varchar(10) primary key,-- 1
    nombre_tipo varchar(50), -- inventarios, bodega
    nombre_empresa varchar(50), -- x
	tiempo_inicio date, -- 10/10/2000
    tiempo_finalizacion date -- 10/08/2015
) engine = InnoDB default char set=latin1;

create table experiencia_laboral(
	id_experiencia varchar(10) primary key,
    id_tipoexp varchar(10), -- foranea
    
    foreign key (id_tipoexp) references explab_detallado(id_tipoexp)
) engine = InnoDB default char set=latin1;

create table referenciasP(
	id_referenciaP varchar(10) primary key,
	nombre_personaP varchar(50),
    telefono_personaP int
) engine = InnoDB default char set=latin1;

create table referenciasL(
	id_referenciaL varchar(10) primary key,
    nombre_personaL varchar(50),
    telefono_personaL int
) engine = InnoDB default char set=latin1;

create table puesto(
	id_puesto varchar(10) primary key,
    nombre_puesto varchar(35),
    descripcion varchar(35),
    estatus_puesto char(1)
) engine = InnoDB default char set=latin1;

create table departamento(
	id_departamento varchar(10) primary key,
    nombre_departamento varchar(35),
    estatus_departamento char(1)
) engine = InnoDB default char set=latin1;

create table solicitud_empresarial(
	id_solicitud varchar(10) primary key,
    rango_edad_menor int,
    rango_edad_mayor int,
    genero char(1),
    id_puesto varchar(10),
    id_departamento varchar(10),
	id_nivel_academico varchar(10), -- foranea
    id_experiencia varchar(10), -- foranea
    descripcion text, -- sueldo, (lo que se ofrece a la persona) 
    
    foreign key (id_puesto) references puesto(id_puesto),
    foreign key (id_departamento) references departamento(id_departamento),
    foreign key (id_nivel_academico) references nivel_academico(id_nivel_academico),
    foreign key (id_experiencia) references experiencia_laboral(id_experiencia)
) engine = InnoDB default char set=latin1;

create table medio(
	id_medio varchar(10) primary key,
    id_solicitud varchar(10),
    nombre_medio varchar(35),
    descripcion varchar(80),
    
    foreign key(id_solicitud) references solicitud_empresarial(id_solicitud)
) engine = InnoDB default char set=latin1;

create table curriculum(/*Reclutamiento*/
	dpi_persona varchar(13) primary key,
    nombres_persona varchar(100),
    apellidos_persona varchar(100),
    telefono_persona int,
    correo_electronico varchar(80),
    direccion_persona varchar(80),
    genero_persona char(1),
    edad_persona int,
--    nivel_academico varchar(80),
	id_nivel_academico varchar(10), -- foranea
    id_referenciaP varchar(10), -- foranea
    id_referenciaL varchar(10), -- foranea
    id_experiencia varchar(10), -- foranea
    id_medio varchar(10), -- foranea
    
    foreign key ( id_nivel_academico) references nivel_academico(id_nivel_academico),
    foreign key ( id_referenciaP) references referenciasP(id_referenciaP),
    foreign key ( id_referenciaL) references referenciasL(id_referenciaL),
    foreign key ( id_experiencia) references experiencia_laboral(id_experiencia),
    foreign key ( id_medio) references medio(id_medio)
) engine = InnoDB default char set=latin1;


create table aplicacion(
	id_aplicacion varchar(10) primary key,
    dpi_persona varchar(13), -- foranea 
    cumple_requisitos char(1), -- Aplica o no Aplica
    
    foreign key(dpi_persona) references curriculum(dpi_persona)
) engine = InnoDB default char set=latin1;

create table tipo_pruebas(
	id_prueba varchar(10) primary key,
    tipo_prueba varchar(35) -- psicologico, poligrafo, tarjeta de pulmones, socioeconomico, habilidades
) engine = InnoDB default char set=latin1;

create table aplicacion_prueba(
	id_ap varchar(10) primary key, -- codigo aplicacion prueba
	id_prueba varchar(10),
	id_aplicacion varchar(10), -- si cumple requisitos
    estatus_prueba char(1), -- aprobado, denegado
    
    foreign key (id_prueba) references tipo_pruebas(id_prueba),
    foreign key (id_aplicacion) references aplicacion(id_aplicacion)
) engine = InnoDB default char set=latin1;

create table seleccion(
	id_seleccion varchar(10) primary key,
    id_ap varchar(10), -- foranea
    estatus_seleccion char(1), -- pendiente, aprobado, rechazado
    
    foreign key (id_ap) references aplicacion_prueba (id_ap)
) engine = InnoDB default char set=latin1;

create table actividad(-- capacitacion, induccion, desempeño
	id_actividad varchar(10) primary key,
    tipo_actividad varchar(50),
    descripcion varchar(80)
) engine = InnoDB default char set=latin1;

create table periodo_prueba(
	id_periodop varchar(10) primary key,
    id_seleccion varchar(10), -- foranea
    fecha_inicio date,
    fecha_finalizacion date,
    pago float,
    id_actividad varchar(10),
    
    foreign key (id_actividad) references actividad(id_actividad),
    foreign key (id_seleccion) references seleccion(id_seleccion)
) engine = InnoDB default char set=latin1;

create table contratacion(
	id_contratacion varchar(10) primary key,
	id_periodop varchar(10),
    fecha_contratacion date,
    duracion_contrato varchar(35),
    estatus_contratacion char(1), -- contratado, rechazado
	
    foreign key (id_periodop) references periodo_prueba(id_periodop)
) engine = InnoDB default char set=latin1;

create table bitacora_empleado(
	id_bitacora varchar(10) primary key,
    id_contratacion varchar(10),
    id_departamento varchar(10),
    id_puesto varchar(10),
    
    foreign key (id_contratacion) references contratacion (id_contratacion),
    foreign key (id_departamento) references departamento (id_departamento),
    foreign key (id_puesto) references puesto (id_puesto)
) engine = InnoDB default char set=latin1;

create table empleado_contratado(
	id_empleado varchar(10) primary key,
    id_contratacion varchar(10), -- foranea
    id_puesto varchar(10), -- foranea
    id_departamento varchar(10),  -- foranea
    sueldo_empleado float,
    
    foreign key (id_contratacion) references contratacion(id_contratacion),
    foreign key (id_puesto) references puesto(id_puesto),
    foreign key (id_departamento) references departamento(id_departamento)
) engine = InnoDB default char set=latin1;

create table actividad_empleado( -- capacitacion, desempeño
	id_empleado varchar(10),
    id_actividad varchar(10),
    
    foreign key (id_empleado) references empleado_contratado(id_empleado),
    foreign key (id_actividad) references actividad(id_actividad)
) engine = InnoDB default char set=latin1;

/*Área de Nómina*/
create table concepto_planilla(
	id_conceptoPlanilla varchar(10) primary key,
	nombre_concepto varchar(20),
	tipo_concepto varchar (10),
	clase_concepto varchar(25),
	Valor_concepto  float,
	aplicacion_concepto varchar(20)
) engine = InnoDB default char set=latin1;



/*Área de Bancos*/
create table moneda(
	id_moneda varchar(10) primary key,
    nombre_moneda varchar(20) not null,
    tipo_cambio float,
    estatus_moneda char(1)
)engine = InnoDB default charset=latin1;

create table concepto_movimiento(
	id_concepto varchar(10) primary key,
    nombre_concepto varchar(35), /*clientes, anticipo, cobro a clientes*/
    tipo_concepto varchar(50) /*cargo, abono*/
) engine = InnoDB default char set=latin1;

/*Pago de planilla al banco */
create table planilla_enc(
	id_planillaenc varchar(10) primary key,
	id_empleado varchar(10),
	total_percepcion float,
	total_deduccion float,
	total_liquido  float,
    id_concepto varchar(10),
    
	foreign key(id_empleado) references empleado_contratado(id_empleado),
    foreign key (id_concepto) references concepto_movimiento(id_concepto)
) engine = InnoDB default char set=latin1;

create table planilla_det(
	id_planillaenc varchar(10),
	id_conceptoPlanilla varchar(10),
	id_empleado varchar(10),
	valor_conceptoDet float,
    
    primary key (id_planillaenc, id_conceptoPlanilla, id_empleado),
    
    foreign key (id_planillaenc) references planilla_enc(id_planillaenc),
	foreign key(id_conceptoPlanilla) references Concepto_Planilla(id_conceptoPlanilla),
	foreign key(id_empleado) references empleado_contratado(id_empleado)
) engine = InnoDB default char set=latin1;


create table forma_pago(
	id_formapago varchar(10) primary key,
    tipo_pago varchar(35) /*cheque, efectivo, tarjeta, nota de credito, otro*/
) engine = InnoDB default char set=latin1;

create table movimientos_bancarios(
	id_concepto varchar(10), /*foranea*/
    fecha date,
    fecha_aplicacion datetime,
    descripcion varchar(80),
    estado char(1),
    id_formapago varchar(10), /*foranea*/
	abono float, 
    cargo float,
    saldo float,
    
    foreign key (id_concepto) references concepto_movimiento(id_concepto),
    foreign key (id_formapago) references forma_pago(id_formapago)
) engine = InnoDB default char set=latin1;

create table banco(
	nombre_banco varchar(50),
    nombre_cuenta varchar(50), /*Cuenta maestra*/
    clave_banco varchar(10),
    funcionario varchar(50),
    telefono int,
    numero_plaza int,
    numero_sucursal int,
    saldo_inicial float,
    id_moneda varchar(10),
    id_concepto varchar(10), /*Movimientos*/
    
    foreign key (id_moneda) references moneda(id_moneda),
    foreign key (id_concepto) references movimientos_bancarios(id_concepto)
) engine = InnoDB default char set=latin1;

create table conciliacion_bancenc(
	id_encabezado varchar(10) primary key,
    cargo_conciliar float,
    abono_conciliar float,
    saldo_corte float,
    cargo_conciliado float,
    abono_conciliado float,
    saldo_final float
) engine = InnoDB default char set=latin1;

create table conciliacion_bancaria_det(
	id_encabezado varchar(10), /*foranea*/
	id_concepto varchar(10), /*foranea*/
    fecha_aplicacion date,
    descripcion varchar(50),
    id_formapago varchar(10), /*foranea*/
    beneficiario varchar(35),
    estado_conciliacion char(1),
    cargo float,
    abono float,
    
    primary key (id_encabezado, id_concepto, id_formapago),
    
    foreign key(id_concepto) references concepto_movimiento(id_concepto),
    foreign key(id_formapago) references forma_pago(id_formapago),
    foreign key(id_encabezado) references conciliacion_bancenc(id_encabezado)
) engine = InnoDB default char set=latin1;


/*Área de Contabilidad*/
create table cuenta_contable(
	id_cuenta varchar(10) primary key,
    nombre_cuenta varchar(35),
    tipo_cuenta varchar(35),
    descripcion_cuenta varchar(35)
) engine = InnoDB default char set=latin1;

create table poliza_encab(
	id_encabezado varchar(10) primary key,
    tipo_poliza varchar(50), /*DR:diario, EG: egresos. IG: ingresos*/
    fecha date,
    descripcion_poliza varchar(80)
) engine = InnoDB default char set=latin1;

create table poliza_detalle(
	id_encabezado varchar(10), /*foranea*/
    id_cuenta varchar(10), /*foranea*/
    descripcion_movpoliza varchar(50),
    fecha_inicio date,
    fecha_final date,
    debe float,
    haber float,
    estatus_poliza char(1),
    
    primary key (id_encabezado, id_cuenta),
    
    /*Foraneas*/
    foreign key (id_encabezado) references poliza_encab(id_encabezado),
    foreign key (id_cuenta) references cuenta_contable(id_cuenta)
) engine = InnoDB default char set=latin1;

create table impuesto_huesped(
	id_impuesto varchar(10) primary key,
    tipo_impuesto varchar(50), /*IVA, impuesto turismo*/
    cantidad_impuesto float,
    descripcion_impuesto varchar(80),
    estatus_impuesto char(1)
) engine = InnoDB default char set=latin1;

/*Multi usuario*/
create table usuario( -- login de usuario
	id_usuario varchar(10) primary key,
    password_usuario varchar(35) not null
    -- id_hotel varchar(10), /*Foranea*/
    
    -- foreign key (ID_Empresa) references Empresa(ID_Empresa)
)engine = InnoDB default charset=latin1;