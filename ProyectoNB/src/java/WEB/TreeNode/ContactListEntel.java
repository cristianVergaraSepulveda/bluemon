/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WEB.TreeNode;

/**
 *
 * @author athanatos
 */
import DAO.EstacionDAO;
import Modelo.Micro;
import Modelo.Sensor;
import java.util.List;
public class ContactListEntel {
    
    private ContactTreeNode root;
        private ContactTreeNode son1;
        EstacionDAO dao = new EstacionDAO();
        
        Sensor senso;

    public ContactListEntel() {
    }

    public ContactListEntel(ContactTreeNode root) {
        this.root = root;
    }
        
    public ContactTreeNode getRoot() {
		return root;
	}
    
    
    
    
    
    
    
    
    
   //################################################### 
    public ContactTreeNode CrearMicro(int IdMicro){
        dao = new EstacionDAO();        
        
      senso = dao.getSensorxID(1);
      Contact con = new Contact(senso.getNombresensor(), "Contact.png");
      con.setCategory(senso.getUnidadmedida());
      con.setIdSensor(senso.getIdSensor());
      con.setIdMicro(IdMicro);
      
      Sensor senso2 = dao.getSensorxID(2);
      Contact con2 = new Contact(senso2.getNombresensor(), "Contact.png");
      con2.setCategory(senso2.getUnidadmedida());
      con2.setIdSensor(senso2.getIdSensor());
      con2.setIdMicro(IdMicro);
      
      Sensor senso3 = dao.getSensorxID(3);
      Contact con3 = new Contact(senso3.getNombresensor(), "Contact.png");
      con3.setCategory(senso3.getUnidadmedida());
      con3.setIdSensor(senso3.getIdSensor());
      con3.setIdMicro(IdMicro);
      
      Sensor senso4 = dao.getSensorxID(4);  
      Contact con4 = new Contact(senso4.getNombresensor(), "Contact.png");
      con4.setCategory(senso4.getUnidadmedida());
      con4.setIdSensor(senso4.getIdSensor());
      con4.setIdMicro(IdMicro);
      
      Sensor senso5 = dao.getSensorxID(5); 
      Contact con5 = new Contact(senso5.getNombresensor(), "Contact.png");
      con5.setCategory(senso5.getUnidadmedida());
      con5.setIdSensor(senso5.getIdSensor());
      con5.setIdMicro(IdMicro);
      Sensor senso6 = dao.getSensorxID(6); 
      Contact con6 = new Contact(senso6.getNombresensor(), "Contact.png");
      con6.setCategory(senso6.getUnidadmedida());
      con6.setIdSensor(senso6.getIdSensor());
      con6.setIdMicro(IdMicro);
      Sensor senso7 = dao.getSensorxID(7); 
      Contact con7 = new Contact(senso7.getNombresensor(), "Contact.png");
      con7.setCategory(senso7.getUnidadmedida());
      con7.setIdSensor(senso7.getIdSensor());
      con7.setIdMicro(IdMicro);
      Sensor senso8 = dao.getSensorxID(8); 
      Contact con8 = new Contact(senso8.getNombresensor(), "Contact.png");
      con8.setCategory(senso8.getUnidadmedida());
      con8.setIdSensor(senso8.getIdSensor());
      con8.setIdMicro(IdMicro);
      Sensor senso9 = dao.getSensorxID(9); 
      Contact con9 = new Contact(senso9.getNombresensor(), "Contact.png");
      con9.setCategory(senso9.getUnidadmedida());
      con9.setIdSensor(senso9.getIdSensor());
      con9.setIdMicro(IdMicro);
      Sensor senso10 = dao.getSensorxID(10); 
      Contact con10 = new Contact(senso10.getNombresensor(), "Contact.png");
      con10.setCategory(senso10.getUnidadmedida());
      con10.setIdSensor(senso10.getIdSensor());
      con10.setIdMicro(IdMicro);
      Sensor senso11 = dao.getSensorxID(11); 
      Contact con11 = new Contact(senso11.getNombresensor(), "Contact.png");
      con11.setCategory(senso11.getUnidadmedida());
      con11.setIdSensor(senso11.getIdSensor());
      con11.setIdMicro(IdMicro);
      Sensor senso12 = dao.getSensorxID(12); 
      Contact con12 = new Contact(senso12.getNombresensor(), "Contact.png");
      con12.setCategory(senso12.getUnidadmedida());
      con12.setIdSensor(senso12.getIdSensor());
      con12.setIdMicro(IdMicro);
     
      Sensor senso13 = dao.getSensorxID(13); 
      Contact con13 = new Contact(senso13.getNombresensor(), "Contact.png");
      con13.setCategory(senso13.getUnidadmedida());
      con13.setIdSensor(senso13.getIdSensor());
      con13.setIdMicro(IdMicro);
      Sensor senso14 = dao.getSensorxID(14); 
      Contact con14 = new Contact(senso14.getNombresensor(), "Contact.png");
      con14.setCategory(senso14.getUnidadmedida());
      con14.setIdSensor(senso14.getIdSensor());
      con14.setIdMicro(IdMicro);
      Sensor senso15 = dao.getSensorxID(15); 
      Contact con15 = new Contact(senso15.getNombresensor(), "Contact.png");
      con15.setCategory(senso15.getUnidadmedida());
      con15.setIdSensor(senso15.getIdSensor());
      con15.setIdMicro(IdMicro);
                    //sensores por defecto
      ContactTreeNode Sensor1 = new ContactTreeNode(con);
      ContactTreeNode Sensor2 = new ContactTreeNode(con2); 
      ContactTreeNode Sensor3 = new ContactTreeNode(con3); 
      ContactTreeNode Sensor4 = new ContactTreeNode(con4);
      ContactTreeNode Sensor5 = new ContactTreeNode(con5);       
      ContactTreeNode Sensor6 = new ContactTreeNode(con6);
      ContactTreeNode Sensor7 = new ContactTreeNode(con7);
      ContactTreeNode Sensor8 = new ContactTreeNode(con8);
      ContactTreeNode Sensor9 = new ContactTreeNode(con9);
      ContactTreeNode Sensor10 = new ContactTreeNode(con10);
      ContactTreeNode Sensor11 = new ContactTreeNode(con11);
      ContactTreeNode Sensor12 = new ContactTreeNode(con12);
      ContactTreeNode Sensor13 = new ContactTreeNode(con13);
      ContactTreeNode Sensor14 = new ContactTreeNode(con14);
      ContactTreeNode Sensor15 = new ContactTreeNode(con15);
       // ContactTreeNode  Micro =   new ContactTreeNode(new Contact("Micro"),new ContactTreeNode[] {}, true); 
      ContactTreeNode  Micro =   new ContactTreeNode(new Contact("sitio1"),new ContactTreeNode[] {Sensor1,Sensor2, Sensor3, Sensor4, Sensor5, Sensor6, Sensor7, Sensor8, Sensor9,Sensor10,Sensor11,Sensor12,Sensor13,Sensor14,Sensor15}, true);    //construir micro    
            //  { Sensor1, Sensor2, Sensor3, sensor4, sensor5  }
        return Micro;
    } 
    //########################################################################
    public ContactTreeNode CreaEstacionxID(int IdEstacion ){
        ContactTreeNode  estacion ;     //= new ContactTreeNode();
        ContactTreeNode Hijo = null;
        
        List listaMicros = dao.getListMicroXIdEst(IdEstacion);
       
      ContactTreeNode  Micro2 =    CrearMicro(IdEstacion);   
     estacion = new ContactTreeNode(new Contact("Estacion"+IdEstacion),new ContactTreeNode[] {Micro2}, true);
      //  ContactTreeNode   estacion2 = new ContactTreeNode(new Contact("Estacion2"),new ContactTreeNode[] {Micro2}, true); //  constructor estacion
      return estacion;
    }
        public ContactTreeNode setArbol(){      // revisar
    //1 crear estaciones 
       ContactTreeNode est1, est2, est3, est4;
        est1 = CreaEstacionxID(1);       
    ContactTreeNode arbol = new ContactTreeNode(null, new ContactTreeNode[] {est1}, true); // general 
    root = arbol;
    return root;
    }
    
    public ContactTreeNode setContactList(){
        dao = new EstacionDAO();
        ContactTreeNode   estacion1 = CreaEstacionxID(1);
       
// ContactTreeNode   estacion2 = new ContactTreeNode(new Contact("Estacion2"),new ContactTreeNode[] {Micro2}, true); 
        ContactTreeNode arbol = new ContactTreeNode(null, new ContactTreeNode[] {estacion1}, true); // general 
        root = arbol;
        return root;
    }
}
