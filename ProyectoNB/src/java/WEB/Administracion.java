/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WEB;

import DAO.AdminDAO;
import Modelo.Login;
import Modelo.Sensor;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;
import java.util.ArrayList;
import java.util.List;
import org.zkoss.zul.Button;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import DAO.LoginDAO;
import java.sql.SQLException;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
/**
 *
 * @author athanatos
 */
public class Administracion {
    
    private Window win;
   
    public Administracion(Window win) {
        this.win = win;
    }

    public Administracion() {
    }
    
    public Window getListUser(){
        Window wini = new Window();
        Grid grid = new Grid();
        Columns columns = new Columns();
        columns.setId("columna");
        Column column = new Column();
        Column column2 = new Column();
        Column column3 = new Column();
        Column editar = new Column();
        
        columns.appendChild(column);        
        columns.appendChild(column2);
        columns.appendChild(column3);
        columns.appendChild(editar);
        
        column.appendChild(new Label("Usuarios"));
        column2.appendChild(new Label("Password"));
        column3.appendChild(new Label("Tipo Usuario")); 
        editar.appendChild(new Label("editar"));
        
        grid.appendChild(columns);        
       
        List pepe = new ArrayList();
        LoginDAO log = new LoginDAO();
        pepe = log.getLogin();
        //empieza
        Rows rows1 = new Rows();
                
        for (int i=0;i<pepe.size();i++){
            Row row = new Row();
            Login login = new Login();
            login = (Login) pepe.get(i);
            rows1.appendChild(row);
            row.appendChild(new Label(login.getLogin()));
            row.appendChild(new Label(login.getPassword()));
            row.appendChild(new Label(login.getTipoLogin().getNombreTipo()));
            Button edit = new Button();
            Button Cambio = new Button();
            Cambio.setLabel("Aplicar");
            Cambio.setVisible(false);
            edit.setLabel("editar");
            edit.setAttribute("ID", login.getIdLogin());
                    
            edit.setAction("onClick : getPopupNewUser();"); // <<  ---  linea critica info.doPopup();
               
                
            row.appendChild(edit);
           // row.appendChild(Cambio);
            //edit.setAction("onClick : setCrearUser() ");
             // WORKS!!  btnTest.setAction("onClick : alert(self.label) ");
              //edit.setParent(setCrearUser()); //setPopup(setCrearUser());
        }              
        grid.appendChild(rows1);
        
        //fin
        wini.appendChild(grid);        
        Button testbot = new Button();
        testbot.setLabel("nuevo");
        testbot.setAction(null);
        wini.appendChild(testbot);
    return wini;
    }
    
    public Window getPopupNewUser(){
        Window info = new Window();
        info.appendChild(new Label("Crear Usuario"));
        info.setVisible(true);
        info.setWidth("120px");
       // info.setPosition("parent");
        info.doHighlighted();
        return info;        
    }
    
    public Window  getListVariable(){
        Window wini = new Window();
         Sensor sen= new Sensor();
        Grid grid = new Grid();
        grid.setSizedByContent(true);
        grid.setSpan(true);
        
        grid.setHeight("300px");
               
        Columns columns = new Columns();
        columns.setId("columna");
        Column column = new Column();
        Column column2 = new Column();
        Column column3 = new Column();
        Column editar = new Column();
       
        columns.appendChild(column);        
        columns.appendChild(column2);
        columns.appendChild(column3);
        columns.appendChild(editar);
        
        column.appendChild(new Label("Nombre VAr "));
        column2.appendChild(new Label("Max"));
        column3.appendChild(new Label("Min")); 
        editar.appendChild(new Label("editar"));
        
        grid.appendChild(columns);
        
        //insertar
        List pepe = new ArrayList();
        final AdminDAO admin = new AdminDAO();
        pepe=admin.getMaxMinSensor();
        Rows rows1 = new Rows();
        //for
        for (int i=0;i<pepe.size();i++){
            Row row = new Row();
           
            sen = (Sensor) pepe.get(i);
            rows1.appendChild(row);
            row.appendChild(new Label(sen.getNombresensor()));
              final Intbox IbMax = new Intbox();
              IbMax.setValue(sen.getMaxima());
            row.appendChild(IbMax);
              final Intbox IbMin = new Intbox();
              IbMin.setValue(sen.getMinima());
            row.appendChild(IbMin);
            final int idSensor = sen.getIdSensor();
            Button edit = new Button();
            edit.setId("edit");
            edit.setLabel("editar");
            edit.setAttribute("IDSensor", sen.getIdSensor());
            edit.addEventListener("onClick", new EventListener() {
                public void onEvent(Event event) throws Exception {
                    //Messagebox.show(System.getProperty("mensaje"));
                    String aslo = "Update:";
              boolean update = admin.setUpdateSensor(idSensor, IbMax.getValue(), IbMin.getValue());
              Messagebox.show(aslo+String.valueOf(update));
/* Messagebox.show("Are you sure to save?", "Confirm Dialog", Messagebox.OK | Messagebox.IGNORE  | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
    public void onEvent(Event evt) throws InterruptedException {
        if (evt.getName().equals("onOK")) {    alert("Data Saved !");
        }else if (evt.getName().equals("onIgnore")) {
            Messagebox.show("Ignore Save", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
        }else{   alert("Save Canceled !");    }
    }
});*/
                }
            });
            //edit.setAction("onclick: alert('mensaje alert')");
            row.appendChild(edit);            
        }//fin for 
        
        grid.appendChild(rows1);
        //fin insertar
        
        wini.appendChild(grid);
        return wini;
    
    }
    public Window setCrearUser() throws InterruptedException{
    Window wini = new Window();
        wini.appendChild(new Label("Crear Usuario"));
        wini.setMode("overlapped");
        //wini.doOverlapped();
    return wini;
    }
    
    public void onClick$edit(Event e) throws Exception, SQLException {
       
    }
    
}
