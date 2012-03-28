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

public class ContactList2 {
   	//public final static String Category = "Category";
	//public final static String Contact = "Contact";
	
	private ContactTreeNode root;
        private ContactTreeNode son1;
        EstacionDAO dao = new EstacionDAO();
        
        Sensor senso;
                
	public ContactList2() {
            
	}
    public ContactList2(ContactTreeNode root) {
        this.root = root;
    }
    
    public ContactTreeNode getRoot() {
		return root;
	}
    
    public ContactTreeNode CrearMicro(int IdMicro){
        dao = new EstacionDAO();        
        
        senso = dao.getSensorxID(1);
      Contact con = new Contact(senso.getNombresensor(), "Contact.png");
      con.setCategory(senso.getUnidadmedida());
      con.setIdSensor(senso.getIdSensor());
      con.setIdMicro(IdMicro);
      
      Sensor senso2 = dao.getSensorxID(4);
      Contact con2 = new Contact(senso2.getNombresensor(), "Contact.png");
      con2.setCategory(senso2.getUnidadmedida());
      con2.setIdSensor(senso2.getIdSensor());
      con2.setIdMicro(IdMicro);
      
      Sensor senso3 = dao.getSensorxID(7);
      Contact con3 = new Contact(senso3.getNombresensor(), "Contact.png");
      con3.setCategory(senso3.getUnidadmedida());
      con3.setIdSensor(senso3.getIdSensor());
      con3.setIdMicro(IdMicro);
      
      Sensor senso4 = dao.getSensorxID(15);  
      Contact con4 = new Contact(senso4.getNombresensor(), "Contact.png");
      con4.setCategory(senso4.getUnidadmedida());
      con4.setIdSensor(senso4.getIdSensor());
      con4.setIdMicro(IdMicro);
      
      Sensor senso5 = dao.getSensorxID(16); 
      Contact con5 = new Contact(senso5.getNombresensor(), "Contact.png");
      con5.setCategory(senso5.getUnidadmedida());
      con5.setIdSensor(senso5.getIdSensor());
      con5.setIdMicro(IdMicro);
                    //sensores por defecto
      ContactTreeNode Sensor1 = new ContactTreeNode(con);
      ContactTreeNode Sensor2 = new ContactTreeNode(con2); 
      ContactTreeNode Sensor3 = new ContactTreeNode(con3); 
      ContactTreeNode Sensor4 = new ContactTreeNode(con4);
      ContactTreeNode Sensor5 = new ContactTreeNode(con5);        
        
       // ContactTreeNode  Micro =   new ContactTreeNode(new Contact("Micro"),new ContactTreeNode[] {}, true); 
       ContactTreeNode  Micro =   new ContactTreeNode(new Contact("sitio1"),new ContactTreeNode[] {Sensor1,Sensor2, Sensor3, Sensor4, Sensor5}, true);    //construir micro    
            //  { Sensor1, Sensor2, Sensor3, sensor4, sensor5  }
        return Micro;
    }
  
    public ContactTreeNode CreaEstacionxID(int IdEstacion ){
        ContactTreeNode  estacion ;     //= new ContactTreeNode();
        ContactTreeNode Hijo = null;
        
        List listaMicros = dao.getListMicroXIdEst(IdEstacion);
        /*for(int i=0; i<listaMicros.size(); i++){
            //para cada micro de mierda llamr crearMicro 
            Micro m = (Micro) listaMicros.get(i);
            
            //Integer.parseInt(listaMicros.get(i));
             Hijo = CrearMicro(m.getIdMicro());
        }*/
      ContactTreeNode  Micro2 =    CrearMicro(IdEstacion);   
     estacion = new ContactTreeNode(new Contact("Estacion"+IdEstacion),new ContactTreeNode[] {Micro2}, true);
      //  ContactTreeNode   estacion2 = new ContactTreeNode(new Contact("Estacion2"),new ContactTreeNode[] {Micro2}, true); //  constructor estacion
      return estacion;
    }
    public ContactTreeNode setArbol(){      // revisar
    //1 crear estaciones 
       ContactTreeNode est1, est2, est3, est4;
        est1 = CreaEstacionxID(1);
        est2 = CreaEstacionxID(2);
        est3 = CreaEstacionxID(3);
        est4 = CreaEstacionxID(4);
    ContactTreeNode arbol = new ContactTreeNode(null, new ContactTreeNode[] {est1}, true); // general 
    root = arbol;
    return root;
    }
    
    public ContactTreeNode setContactList(){
        dao = new EstacionDAO();
        ContactTreeNode   estacion1 = CreaEstacionxID(1);
        ContactTreeNode   estacion2 = CreaEstacionxID(2);
        ContactTreeNode   estacion3 = CreaEstacionxID(3);
        ContactTreeNode   estacion4 = CreaEstacionxID(4);
// ContactTreeNode   estacion2 = new ContactTreeNode(new Contact("Estacion2"),new ContactTreeNode[] {Micro2}, true); 
        ContactTreeNode arbol = new ContactTreeNode(null, new ContactTreeNode[] {estacion1, estacion2, estacion3, estacion4}, true); // general 
        root = arbol;
        return root;
    }
 
}
