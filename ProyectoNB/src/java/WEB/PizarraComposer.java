package WEB;


import ConexionBD.Sql;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.List;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Separator;
import org.zkoss.zul.Textbox;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author athanatos
 */
public class PizarraComposer extends GenericForwardComposer {
   
    
     Div viewer ; 
    // Label titulo;
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
	//Label titulo = new Label();
        //titulo.setValue("");
        //titulo.setParent(viewer); 
       //text.setValue("algo");
    }
    
    public void onTimer$timerPizzara(Event e) throws ParseException{
     Sql Sql= new Sql();
     String txt="";
     List perro = Sql.consulta("SELECT A.ID_ALARMA, T.TIPO_ALARMA, A.ID_MICRO, A.ID_SENSOR, D.DATO, R.FECHA, R.HORA FROM monitoreo.ALARMA A, monitoreo.TIPO_ALARMA T, monitoreo.DATO D, monitoreo.REGISTRO R WHERE A.ID_TIPOALARMA=T.ID_TIPO and D.ID_DATO = A.ID_DATO AND R.ID_DATO=D.ID_DATO ORDER BY A.ID_ALARMA DESC LIMIT 200;");
     ArrayList<String[]> list= new ArrayList<String[]>();
     for(int j=1;j<perro.size();j++){
         String [] unafila =(String [])perro.get(j);
         
        // list.add(new String[]{" alarma text "+unafila[3],unafila[5] +" "+unafila[6]});
        txt = " alarma: "+unafila[1]+" de "+unafila[4] +", a las "+unafila[5] +" "+unafila[6]+" en el sensor "+unafila[3];
        Label fila = new Label();
        fila.setValue(txt);
        fila.setParent(viewer);
        Separator asd = new Separator();
        asd.setParent(viewer);
        
     }         
     
   }
}
