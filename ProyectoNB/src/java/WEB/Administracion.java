/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WEB;

import DAO.AdminDAO;
import DAO.EstacionDAO;
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
import Modelo.TipoLogin;
import java.sql.SQLException;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
/**
 *
 * @author athanatos
 */
public class Administracion extends GenericForwardComposer{
    
    private Window win;
   
    public Administracion(Window win) {
        this.win = win;
    }

    public Administracion() {
    }
    
    public Window getListUser(){
        final Window wini = new Window();
        
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
            
            edit.setId("edit");
          
            edit.setAttribute("ID", login.getIdLogin());
            
            
          //  edit.setAction("onClick : getPopupNewUser();"); // <<  ---  linea critica info.doPopup();               
            row.appendChild(edit);
        }              
        grid.appendChild(rows1);
        
        //fin
        wini.appendChild(grid);        
        Button testbot = new Button();
        testbot.setLabel("nuevo");
        //testbot.setAttribute("onClick", getPopupNewUser());
        testbot.addEventListener("onClick",new EventListener(){
            public void onEvent(Event event) throws Exception {
               // ventana emergente
               final Window test = new Window();// pasarlo al metodo getPopupNewUser
               test.setVisible(true);
               test.setTitle("Nuevo Usuario");
               test.setClosable(true);              
              try { test.setMode("overlapped"); } catch (Exception e) {/*IGNORE EXCEPTION*/}
              /* agregar lsitbox para la cosa */
              Listbox asd = new Listbox();              
              asd.setParent(test);
              Listitem asd1 = new Listitem();
              asd1.setParent(asd);
              Listcell cel1 = new Listcell();
              cel1.setLabel("Login");
              final Listcell cel11 = new Listcell();
              final Textbox Login = new Textbox();
              cel11.appendChild(Login);              
              Listitem asd2 = new Listitem();
               asd2.setParent(asd);
              Listcell cell2 = new Listcell();              
              final Textbox password = new Textbox();
              cell2.setLabel("Passwords");
              final Listcell cell22 = new Listcell();      
              cell22.appendChild(password);
              Listitem asd3 = new Listitem();
              asd3.setParent(asd);
              Listcell cell3 = new Listcell(); 
              cell3.setLabel("Tipo Usuario:");
              final Listcell cell33 = new Listcell(); 
              final Listbox select = new Listbox();
                select.setMold("select");
                select.setId("Esta");
                select.setRows(1);
                List allTipo = new LoginDAO().getListTipoLogin();
                for(int i=0;i<allTipo.size(); i++){
                   Listitem TipoLog = new Listitem();
                   TipoLogin TLog = new TipoLogin();
                    TLog = (TipoLogin) allTipo.get(i);           
                   TipoLog.setLabel(TLog.getNombreTipo());
                   TipoLog.setValue(TLog.getIdTipoLogin());
                   TipoLog.setParent(select);
                }
                cell33.appendChild(select);
              //----------------------------
              Listitem asd4 = new Listitem();
               asd4.setParent(asd);
              Listcell cell4 = new Listcell();              
              Button ok = new Button();
              ok.setLabel("OK");  
              ok.addEventListener("onClick", new EventListener() {
           		 public void onEvent(Event event) throws Exception {
                              Messagebox.show("Se creara un nuevo usuario ,esta Seguro que quiere salvar?", "Confirm Dialog", Messagebox.OK | Messagebox.IGNORE  | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
    public void onEvent(Event evt) throws InterruptedException {
        if (evt.getName().equals("onOK")) {
            //alert("Data Saved !");
              int ak= Integer.parseInt((String) select.getSelectedItem().getValue());
           TipoLogin Ltipo = new LoginDAO().getTipoLoginxIDTipo(ak);
            LoginDAO insert = new LoginDAO();
            
            insert.CreateandStoreLogin(Ltipo, (String) Login.getValue(), (String) password.getValue());                       
            Messagebox.show("Datos salvados");            
            test.onClose();
            
        } else if (evt.getName().equals("onIgnore")) {
            Messagebox.show("Datos Ignorados", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
             Login.setValue(null);
             password.setValue(null);
             
        } else {
            //alert("Save Canceled !");
            Messagebox.show("Save Canceled !");
            test.isClosable();
        }
    }
});
         	   }
      	  });		
              ok.setParent(cell4);              
              cel1.setParent(asd1);
              cel11.setParent(asd1);
              cell2.setParent(asd2);
              cell22.setParent(asd2);
              cell3.setParent(asd3);
              cell33.setParent(asd3);
              cell4.setParent(asd4);              
              //fin contenido test                            
              test.isClosable();
              test.setParent(wini);
              test.setWidth("290px");
              test.setHeight("170px");
              test.setPosition("center");
               //fin
            }
        });
    wini.appendChild(testbot);
    return wini;
    }//fin admin usuario
    
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
        
        column.appendChild(new Label("Nombre Variable "));
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
                }
            });
            //edit.setAction("onclick: alert('mensaje alert')");
            row.appendChild(edit);            
        }//fin for 
        
        grid.appendChild(rows1);
        //fin insertar
        
        wini.appendChild(grid);
        return wini;
    
    }//fin administrar variables
   
    
    public void onClick$edit() throws InterruptedException{
        Messagebox.show("Edit box");
    }
    
    
    public Window getListEstaciones(){
    Window winix = new Window();
    
    return winix;        
    }//fin administrar estaciones
    
}

