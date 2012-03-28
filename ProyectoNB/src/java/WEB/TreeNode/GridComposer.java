/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WEB.TreeNode;

/**
 *
 * @author athanatos
 */
import ConexionBD.Sql;
import DAO.EstacionDAO;
import Modelo.Dato;
import Modelo.Registro;
import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.util.*;
import org.zkoss.zk.ui.ext.*;
import org.zkoss.zk.au.*;
import org.zkoss.zk.au.out.*;
import org.zkoss.zul.*;
import java.util.*;
public class GridComposer extends GenericForwardComposer {
    
    private Grid datos;
    private Label IdSensor;
    private Label IdMicro;
    
        String maxD;
    
    public int cn=0;
    public void doAfterCompose(Component comp) throws Exception {
    super.doAfterCompose(comp);
    datos.setModel(new ListModelList(getUpdatedData()));

  }
   public void onTimer$timer(Event e){
         
    datos.setModel(new ListModelList(getUpdated()));    //getUpdatedData()
  }
   
  
   private List<String[]> getData(){
   ArrayList<String[]> list= new ArrayList<String[]>();
    //IdSensor.getValue()
       // IdMicro.getValue();
    list.add(new String[]{"Test dato1","lunes"});
    list.add(new String[]{"Test dato2","martes"});
    list.add(new String[]{"Test dto3","miercoles"});
    list.add(new String[]{"Test dato4","jueves"});    
    return list;
   }
   
    private List<String[]> getUpdatedData(){    
        EstacionDAO dao = new EstacionDAO();
     List allDatos = dao.getDatoXidSensor2(Integer.parseInt(IdSensor.getValue()));  
     List AllRegistros = dao.getDatoRegistroxIdSensor2(Integer.parseInt(IdSensor.getValue()));
   
     Dato dato = new Dato();
     Registro registro = new Registro();
     cn++;
     int j=0;
        ArrayList<String[]> list= new ArrayList<String[]>();
    //dao = new EstacionDAO();
      for( j=0; j < allDatos.size(); ++j) {
                   
        dato = (Dato) allDatos.get(j);
      
        registro = (Registro) AllRegistros.get(j);
              
        list.add(new String[]{cn+" "+String.valueOf(dato.getDato()),String.valueOf(registro.getFecha()+" "+registro.getHora())});
     }         
       // list.add(new String[]{cn+""+"update", "update"+cn});      
    //list.add(new String[]{IdSensor.getValue(), IdMicro.getValue()});
    return list;
    }
    
   private List<String[]> getUpdated(){
   Sql Sql= new Sql();
    Vector  Sel = Sql.consulta("SELECT * FROM monitoreo.DATO D, monitoreo.REGISTRO R WHERE R.ID_DATO=D.ID_DATO order by D.ID_DATO desc limit 100;");
    ArrayList<String[]> list= new ArrayList<String[]>();
    cn++;
    for(int j=1; j < Sel.size(); ++j){
         String [] unafila =(String [])Sel.get(j);
         
     list.add(new String[]{unafila[3],unafila[5] +" "+unafila[6]});
     //String.valueOf(dato.getDato())
    }
    return list;
   
   } 

}
