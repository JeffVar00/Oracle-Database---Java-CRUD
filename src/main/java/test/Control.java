package test;

import datos.AccesoDAO;
import datos.Conexion;
import datos.CuotaDAO;
import datos.Cuota_ExtraDAO;
import datos.DuennosDAO;
import datos.FilialDAO;
import domain.Acceso;
import domain.Cuota;
import domain.Cuota_Extra;
import domain.Duenno;
import domain.Filial;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Control {

    public void Menu_Iniciar() {
        Scanner sn = new Scanner(System.in);
        int opc = 0;
        do {
            System.out.println("Bienvenido Al CRUD");
            System.out.println("1-Insertar");
            System.out.println("2-Mostrar");
            System.out.println("3-Actualizar");
            System.out.println("4-Eliminar");
            System.out.println("5-Cursor");
            System.out.println("6-Salir");
            opc = sn.nextInt();

            switch (opc) {
                
                case 1:
                    Insertar();
                    
                    break;
                case 2:
                    Leer();
                    
                    break;
                case 3:
                    
                    Actualizar();
                    
                    break;
                case 4:
                    
                    Eliminar();
                    
                    break;
                case 5:
                    
                    Cursero();
                    
                    break;    

            }
        } while (opc != 6);

    }
    public void Cursero() {
         Scanner sn = new Scanner(System.in);
         
         System.out.println("Digite el ID de Filial");
         int ID_F =sn.nextInt();
         
         
        Connection conexion = null;
        String Cursor="";
        try {
            
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);/*quito la automatizacion del commit*/
            }
           FilialDAO cdao = new FilialDAO(conexion);
           
            System.out.println(cdao.cursero(ID_F));
           
           
            
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
        }
    }
    
    
    public void Insertar(){
        
        Scanner sn = new Scanner(System.in);
        int opc = 0;
        do {
            System.out.println("Bienvenido Al CRUD");
            System.out.println("1-Insertar Duennos");
            System.out.println("2-Insertar Cuotas");
            System.out.println("3-Insertar Cuotas Extras");
            System.out.println("4-Insertar Filial");
            System.out.println("5-Insertar Acceso");
            System.out.println("6-Volver a Menu Principal");
            opc = sn.nextInt();

            switch (opc) {
                
                case 1:
                    Insertar_Duennos();
                    
                    break;
                case 2:
                    Insertar_Cuotas();
                    
                    break;
                case 3:
                    
                    Insertar_Cuotas_Extras();
                    
                    break;
                case 4:
                    
                    Insertar_Filial();
                    
                    break;
                 case 5:
                    
                    Insertar_Acceso();
                    
                    break;
                 case 6:
                    
                    Menu_Iniciar();
                    
                    break;   

            }
        } while (opc != 7);

    
            
    }
    public void Insertar_Duennos(){
        Scanner sn = new Scanner(System.in);
        String NOMBRE="", APE1="", APE2="", CORREO="";
        int ID_DUENNO=0,TELEFONO = 0;
        
        System.out.println("Ingrese el nombre del duenno: ");
        NOMBRE=sn.next();
        System.out.println("");
        System.out.println("Ingrese el ID del duenno: ");
        ID_DUENNO=sn.nextInt();
        System.out.println("");
        System.out.println("Ingrese el Primer Apellido del duenno: ");
        APE1=sn.next();
        System.out.println("");
        System.out.println("Ingrese el Segundo Apellido del duenno: ");
        APE2=sn.next();
        System.out.println("");
        System.out.println("Ingrese el Telefono del duenno: ");
        TELEFONO=sn.nextInt();
        System.out.println("");
        System.out.println("Ingrese el Correo del duenno: ");
        CORREO=sn.next();
        System.out.println("");
        
        
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);/*quito la automatizacion del commit*/
            }

           DuennosDAO ddao = new DuennosDAO(conexion);
           ddao.insertar(new Duenno(NOMBRE, ID_DUENNO, APE1, APE2, TELEFONO, CORREO));
                
    
                

            conexion.commit();
            System.out.println("se ha hecho el commit");
            System.out.println("se ha ingresado el duenno");
                
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }    
        
    }
    public void Insertar_Cuotas(){
        Scanner sn = new Scanner(System.in);
        String DESCRIPCION="";
        int ID_CUOTA=0,ID_DUENNO = 0;
        float MONTO= 0;
     
        Date invoiceDate = new Date(System.currentTimeMillis());
        java.sql.Date invDate = new java.sql.Date (invoiceDate.getTime());
        
        System.out.println("Ingrese el ID de cuota: ");
        ID_CUOTA=sn.nextInt();
        System.out.println("");
        System.out.println("Ingrese el ID del duenno: ");
        ID_DUENNO=sn.nextInt();
        System.out.println("");
        
        System.out.println("");
        System.out.println("Ingrese el Monto de la cuota: ");
        MONTO=sn.nextFloat();
        System.out.println("");
        System.out.println("Ingrese la Descripcion de la cuota: ");
        DESCRIPCION=sn.next();
        System.out.println("");
       
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);/*quito la automatizacion del commit*/
            }

           CuotaDAO cdao = new CuotaDAO(conexion);
           cdao.insertar(new Cuota(ID_CUOTA, ID_DUENNO, MONTO, DESCRIPCION));
                
    
            conexion.commit();
            System.out.println("se ha hecho el commit");
            System.out.println("se ha ingresado la cuota");
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }    
    }
    public void Insertar_Cuotas_Extras(){
        Scanner sn = new Scanner(System.in);
        String FECHA="", DESCRIPCION="";
        int ID_CUOTA_EX=0,ID_DUENNO = 0;
        float MONTO= 0;
        
        System.out.println("Ingrese el ID de cuota extra: ");
        ID_CUOTA_EX=sn.nextInt();
        System.out.println("");
        System.out.println("Ingrese el ID del duenno: ");
        ID_DUENNO=sn.nextInt();
        System.out.println("");
        System.out.println("Ingrese el Monto de la cuota: ");
        MONTO=sn.nextFloat();
        System.out.println("");
        System.out.println("Ingrese la Descripcion de la cuota: ");
        DESCRIPCION=sn.next();
        System.out.println("");
       
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);/*quito la automatizacion del commit*/
            }

           Cuota_ExtraDAO cdao = new Cuota_ExtraDAO(conexion);
           cdao.insertar(new Cuota_Extra(ID_CUOTA_EX, ID_DUENNO, MONTO, DESCRIPCION));
                
    
            conexion.commit();
            System.out.println("se ha hecho el commit");
            System.out.println("se ha ingresado la cuota extra");
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }    
        
    }
    public void Insertar_Filial(){
        Scanner sn = new Scanner(System.in);
        String DESCRIPCION="";
        int ID_FILIAL=0,ID_DUENNO=0;
        
        System.out.println("Ingrese el ID del Filial: ");
        ID_FILIAL=sn.nextInt();
        System.out.println("");
        System.out.println("Ingrese el ID del Duenno: ");
        ID_DUENNO=sn.nextInt();
        System.out.println("");
        System.out.println("Ingrese la Descripcion: ");
        DESCRIPCION=sn.next();
        System.out.println("");
        
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);/*quito la automatizacion del commit*/
            }
           FilialDAO cdao = new FilialDAO(conexion);
           cdao.insertar(new Filial(ID_FILIAL, ID_DUENNO,DESCRIPCION));
           
            conexion.commit();
            System.out.println("se ha hecho el commit");
            System.out.println("se ha ingresado el Filial");
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }    
        
    }
     public void Insertar_Acceso(){
        Scanner sn = new Scanner(System.in);
        String N_VISITANTE="", H_ENTRADA="", H_SALIDA="";
        int N_ACCESO=0,ID_VISITANTE=0, FILIAL=0;
        
        System.out.println("Ingrese el numero de acceso: ");
        N_ACCESO=sn.nextInt();
        System.out.println("");
        System.out.println("Ingrese el nombre del visitante: ");
        N_VISITANTE=sn.next();
        System.out.println("");
        System.out.println("Ingrese el Id del visitante: ");
        ID_VISITANTE=sn.nextInt();
        System.out.println("");
        System.out.println("Ingrese el Filial: ");
        FILIAL=sn.nextInt();
        System.out.println("");
        System.out.println("Ingrese la hora de entrada del visitante: ");
        H_ENTRADA=sn.next();
        System.out.println("");

        
        
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);/*quito la automatizacion del commit*/
            }
           AccesoDAO adao = new AccesoDAO(conexion);
           adao.insertar(new Acceso(N_ACCESO ,"",N_VISITANTE,ID_VISITANTE,FILIAL,H_ENTRADA,H_SALIDA));
           
            conexion.commit();
            System.out.println("se ha hecho el commit");
            System.out.println("se ha ingresado el acceso");
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }    
        
    }
        
   
    public void Leer(){
 Scanner sn = new Scanner(System.in);
        int opc = 0;
        do {
            System.out.println("1-Mostrar Duennos");
            System.out.println("2-Mostrar Cuotas");
            System.out.println("3-Mostrar Cuotas Extras");
            System.out.println("4-Mostrar Filial");
            System.out.println("5-Mostrar Acceso");
            System.out.println("6-Volver a Menu Principal");
            opc = sn.nextInt();

            switch (opc) {
                
                case 1:
                   Mostrar_Duennos();
                    
                    break;
                case 2:
                    Mostrar_Cuotas();
                    
                    break;
                case 3:
                    
                    Mostrar_Cuotas_Extras();
                    
                    break;
                case 4:
                    
                   Mostrar_Filial();
                    
                    break;
                 case 5:
                    
                    Mostrar_Acceso();
                    
                    break;
                 case 6:
                    
                    Menu_Iniciar();
                    
                    break;   

            }
        } while (opc != 6);      
        
    }
    public void Mostrar_Acceso(){
        
    
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            
           AccesoDAO adao = new AccesoDAO(conexion);
           
           List<Acceso>Accesos=adao.seleccionar();
                
            for(Acceso acceso:Accesos){
                System.out.println("acceso = " + acceso);
            }
            
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
        }    
        
    }
    public void Mostrar_Filial(){
        
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            
           FilialDAO cdao = new FilialDAO(conexion);
           
            List<Filial>Filiales=cdao.seleccionar();
                
            for(Filial filial:Filiales){
                System.out.println("filial = " + filial);
            }   
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
                
        }
    }
    
     public void Mostrar_Cuotas_Extras(){

    
       
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
           Cuota_ExtraDAO cdao = new Cuota_ExtraDAO(conexion);
    
           List<Cuota_Extra>Cuotas_Extras=cdao.seleccionar();
                
            for(Cuota_Extra cuota_extra:Cuotas_Extras){
                System.out.println("cuota_extra = " + cuota_extra);
            }     
    
      
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            
        }    
        
    }
    
     public void Mostrar_Cuotas(){
      
      
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
         

           CuotaDAO cdao = new CuotaDAO(conexion);
           List<Cuota>Cuotas=cdao.seleccionar();
                
            for(Cuota cuota:Cuotas){
                System.out.println("cuota = " + cuota);
                
            }
            
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
           
        }    
    }
     public void Mostrar_Duennos(){
       
        try {
            Connection conexion = null;
            
            conexion = Conexion.getConexion();
            
            DuennosDAO ddao = new DuennosDAO(conexion);
            List<Duenno>Duennos=ddao.seleccionar();
            
            for(Duenno duenno:Duennos){
                
                System.out.println("duenno = " + duenno);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
           
         
        
    }
    public void Actualizar(){
       Scanner sn = new Scanner(System.in);
        int opc = 0;
        do {
          
            System.out.println("1-Editar Duennos");
            System.out.println("2-Editar Cuotas");
            System.out.println("3-Editar Cuotas Extras");
            System.out.println("4-Editar Filial");
            System.out.println("5-Editar Acceso");
            System.out.println("6-Volver a Menu Principal");
            opc = sn.nextInt();

            switch (opc) {
                
                case 1:
                    Editar_Duennos();
                    
                    break;
                case 2:
                   Editar_Cuotas();
                    
                    break;
                case 3:
                    
                    Editar_Cuotas_Extras();
                    
                    break;
                case 4:
                    
                    Editar_Filial();
                    
                    break;
                 case 5:
                    
                    Editar_Acceso();
                    
                    break;
                 case 6:
                    
                    Menu_Iniciar();
                    
                    break;   

            }
        } while (opc != 6);
    
    }
    public void Editar_Acceso(){
        Scanner sn = new Scanner(System.in);
        String H_SALIDA="";
        int N_ACCESO=0;
        
        System.out.println("Ingrese el numero de acceso: ");
        N_ACCESO=sn.nextInt();
        System.out.println("");
        System.out.println("Ingrese la hora de salida del visitante: ");
        H_SALIDA=sn.next();
        System.out.println("");

        
        
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);/*quito la automatizacion del commit*/
            }
           AccesoDAO adao = new AccesoDAO(conexion);
           adao.actualizar(new Acceso(N_ACCESO,H_SALIDA));
           
            conexion.commit();
            System.out.println("se ha hecho el commit");
            System.out.println("se ha ingresado el acceso");
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }    
        
    }
    public void Editar_Filial(){
        Scanner sn = new Scanner(System.in);
        String DESCRIPCION="";
        int ID_FILIAL=0,ID_DUENNO=0;
        
        System.out.println("Ingrese el ID del Filial: ");
        ID_FILIAL=sn.nextInt();
        System.out.println("");
        System.out.println("Ingrese el ID del Duenno: ");
        ID_DUENNO=sn.nextInt();
        System.out.println("");
        System.out.println("Ingrese la Descripcion: ");
        DESCRIPCION=sn.next();
        System.out.println("");
        
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);/*quito la automatizacion del commit*/
            }
           FilialDAO cdao = new FilialDAO(conexion);
           cdao.actualizar(new Filial(ID_FILIAL, ID_DUENNO,DESCRIPCION));
           
            conexion.commit();
            System.out.println("se ha hecho el commit");
            System.out.println("se ha ingresado el Filial");
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }    
        
    }
    public void Editar_Cuotas_Extras(){
        Scanner sn = new Scanner(System.in);
        String  DESCRIPCION="";
        int ID_CUOTA_EX=0;
        float MONTO= 0;
        
        
        System.out.println("Ingrese el ID de cuota extra: ");
        ID_CUOTA_EX=sn.nextInt();
        System.out.println("");
        System.out.println("Ingrese el Monto de la cuota: ");
        MONTO=sn.nextFloat();
        System.out.println("");
        System.out.println("Ingrese la Descripcion de la cuota: ");
        DESCRIPCION=sn.next();
        System.out.println("");
       
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);/*quito la automatizacion del commit*/
            }

           Cuota_ExtraDAO cdao = new Cuota_ExtraDAO(conexion);
           cdao.actualizar(new Cuota_Extra(ID_CUOTA_EX, MONTO, DESCRIPCION));
                
    
            conexion.commit();
            System.out.println("se ha hecho el commit");
            System.out.println("se ha ingresado la cuota extra");
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }    
        
    }
    public void Editar_Cuotas(){
        Scanner sn = new Scanner(System.in);
        String DESCRIPCION="";
        int ID_CUOTA=0;
        float MONTO= 0;
     
        Date invoiceDate = new Date(System.currentTimeMillis());
        java.sql.Date invDate = new java.sql.Date (invoiceDate.getTime());
        
        System.out.println("Ingrese el ID de cuota: ");
        ID_CUOTA=sn.nextInt();
        System.out.println("");
        System.out.println("");
        System.out.println("Ingrese el Monto de la cuota: ");
        MONTO=sn.nextFloat();
        System.out.println("");
        System.out.println("Ingrese la Descripcion de la cuota: ");
        DESCRIPCION=sn.next();
        System.out.println("");
       
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);/*quito la automatizacion del commit*/
            }

           CuotaDAO cdao = new CuotaDAO(conexion);
           cdao.actualizar(new Cuota(ID_CUOTA,"", MONTO, DESCRIPCION));
                
    
            conexion.commit();
            System.out.println("se ha hecho el commit");
            System.out.println("se ha ingresado la cuota");
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }    
    }
     public void Editar_Duennos(){
        Scanner sn = new Scanner(System.in);
        String NOMBRE="", APE1="", APE2="", CORREO="";
        int ID_DUENNO=0,TELEFONO = 0;
        
        System.out.println("Ingrese el nombre del duenno: ");
        NOMBRE=sn.next();
        System.out.println("");
        System.out.println("Ingrese el ID del duenno: ");
        ID_DUENNO=sn.nextInt();
        System.out.println("");
        System.out.println("Ingrese el Primer Apellido del duenno: ");
        APE1=sn.next();
        System.out.println("");
        System.out.println("Ingrese el Segundo Apellido del duenno: ");
        APE2=sn.next();
        System.out.println("");
        System.out.println("Ingrese el Telefono del duenno: ");
        TELEFONO=sn.nextInt();
        System.out.println("");
        System.out.println("Ingrese el Correo del duenno: ");
        CORREO=sn.next();
        System.out.println("");
        
        
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);/*quito la automatizacion del commit*/
            }

           DuennosDAO ddao = new DuennosDAO(conexion);
           ddao.actualizar(new Duenno(NOMBRE, ID_DUENNO, APE1, APE2, TELEFONO, CORREO));
                
  

            conexion.commit();
            System.out.println("se ha hecho el commit");
            System.out.println("se ha ingresado el duenno");
                
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }    
        
    }
    
    public void Eliminar(){
        
  Scanner sn = new Scanner(System.in);
        int opc = 0;
        do {
            System.out.println("Bienvenido Al CRUD");
            System.out.println("1-Eliminar Duennos");
            System.out.println("2-Eliminar Cuotas");
            System.out.println("3-Eliminar Cuotas Extras");
            System.out.println("4-Eliminar Filial");
            System.out.println("5-Eliminar Acceso");
            System.out.println("6-Volver a Menu Principal");
            opc = sn.nextInt();

            switch (opc) {
                
                case 1:
                    Eliminar_Duennos();
                    
                    break;
                case 2:
                    Eliminar_Cuotas();
                    
                    break;
                case 3:
                    
                    Eliminar_Cuotas_Extras();
                    
                    break;
                case 4:
                    
                    Eliminar_Filial();
                    
                    break;
                 case 5:
                    
                    Eliminar_Acceso();
                    
                    break;
                 case 6:
                    
                    Menu_Iniciar();
                    
                    break;   

            }
        } while (opc != 6);
    }
    public void Eliminar_Acceso(){
        Scanner sn = new Scanner(System.in);
        int N_ACCESO=0;
        
        System.out.println("Ingrese el numero de acceso: ");
        N_ACCESO=sn.nextInt();
        System.out.println("");

    
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);/*quito la automatizacion del commit*/
            }
           AccesoDAO adao = new AccesoDAO(conexion);
           adao.eliminar(new Acceso(N_ACCESO,""));
           
            conexion.commit();
            System.out.println("se ha hecho el commit");
            System.out.println("se ha ingresado el acceso");
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }    
        
    }
     public void Eliminar_Filial(){
        Scanner sn = new Scanner(System.in);
        int ID_FILIAL=0;
        
        System.out.println("Ingrese el ID del Filial: ");
        ID_FILIAL=sn.nextInt();
        System.out.println("");
        
        
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);/*quito la automatizacion del commit*/
            }
           FilialDAO cdao = new FilialDAO(conexion);
           cdao.eliminar(new Filial(ID_FILIAL));
           
            conexion.commit();
            System.out.println("se ha hecho el commit");
            System.out.println("se ha ingresado el Filial");
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }    
        
    }
    public void Eliminar_Cuotas_Extras(){
        Scanner sn = new Scanner(System.in);
        int ID_CUOTA_EX=0;
    
        
        
        System.out.println("Ingrese el ID de cuota extra: ");
        ID_CUOTA_EX=sn.nextInt();
        System.out.println("");
       
       
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);/*quito la automatizacion del commit*/
            }

           Cuota_ExtraDAO cdao = new Cuota_ExtraDAO(conexion);
           cdao.eliminar(new Cuota_Extra(ID_CUOTA_EX));
                
    
            conexion.commit();
            System.out.println("se ha hecho el commit");
            System.out.println("se ha ingresado la cuota extra");
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }    
        
    }
    public void Eliminar_Cuotas(){
        Scanner sn = new Scanner(System.in);
      
        int ID_CUOTA=0;
      
        
        System.out.println("Ingrese el ID de cuota: ");
        ID_CUOTA=sn.nextInt();
        System.out.println("");
        
       
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);/*quito la automatizacion del commit*/
            }

           CuotaDAO cdao = new CuotaDAO(conexion);
           cdao.eliminar(new Cuota(ID_CUOTA));
                
    
            conexion.commit();
            System.out.println("se ha hecho el commit");
            System.out.println("se ha ingresado la cuota");
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }    
    }
    public void Eliminar_Duennos(){
        Scanner sn = new Scanner(System.in);

        int ID_DUENNO=0;
        
        
        System.out.println("Ingrese el ID del duenno: ");
        ID_DUENNO=sn.nextInt();
        System.out.println("");
       
        
        
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);/*quito la automatizacion del commit*/
            }

           DuennosDAO ddao = new DuennosDAO(conexion);
           ddao.actualizar(new Duenno(ID_DUENNO));
                
  

            conexion.commit();
            System.out.println("se ha hecho el commit");
            System.out.println("se ha ingresado el duenno");
                
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }    
        
    }
}
