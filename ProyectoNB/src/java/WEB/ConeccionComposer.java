package WEB;


import ConexionBD.Sql;
import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class ConeccionComposer extends GenericForwardComposer {
    
    private Label alert1;
    private Image conIMG;
    
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
	//alert1.setValue("-------");
    }
    
    public void onTimer$timerCon(Event e) throws ParseException{
        Sql Sql= new Sql();
        String[] alarm = Sql.getFila("select * from monitoreo.REGISTRO R where ID_REGISTRO =(SELECT max(ID_REGISTRO) FROM monitoreo.REGISTRO R)");
        String[] nowTime = Sql.getFila("select curtime() from dual");
        String[] nowDate = Sql.getFila("select curdate() from dual");
        
        //SELECT A.ID_DATO, A.ID_ALARMA, A.ID_TIPOALARMA, R.ID_REGISTRO, R.FECHA, R.HORA FROM monitoreo.ALARMA A, monitoreo.REGISTRO R where A.ID_DATO= R.ID_DATO and A.ID_ALARMA = (select max(ID_ALARMA) from monitoreo.ALARMA A);
        new SimpleDateFormat();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd 'de' MMMM 'de' yyyy ");
        SimpleDateFormat Fec = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat Hor = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat anho = new SimpleDateFormat("yyyy");
        SimpleDateFormat mes = new SimpleDateFormat("MM");
        SimpleDateFormat dia = new SimpleDateFormat("dd");
        SimpleDateFormat hora = new SimpleDateFormat("HH");
        SimpleDateFormat min = new SimpleDateFormat("mm");
        SimpleDateFormat seg = new SimpleDateFormat("ss");
       
        //alert1.setValue(now[0]);
        Date NowwTime = Hor.parse(nowTime[0]);
        Date NowDate = Fec.parse(nowDate[0]);
        Calendar CalNow = Calendar.getInstance();
        CalNow.set(Integer.parseInt((String)anho.format(NowDate)),Integer.parseInt((String)mes.format(NowDate))-1,Integer.parseInt((String)dia.format(NowDate)),  Integer.parseInt((String)hora.format(NowwTime)),Integer.parseInt((String)min.format(NowwTime)),Integer.parseInt((String)seg.format(NowwTime)));
        Date noww = CalNow.getTime();
        //Date noww = sdf.parse(now[0]);   //tiene que estar la fecha actual en formato Date 
        Date Fecha = Fec.parse(alarm[1]);
        Date Time = Hor.parse(alarm[2]);
        Calendar DateSql = Calendar.getInstance();
        
        DateSql.set(Integer.parseInt((String)anho.format(Fecha)) , Integer.parseInt((String)mes.format(Fecha))-1, Integer.parseInt((String)dia.format(Fecha)), Integer.parseInt((String)hora.format(Time)), Integer.parseInt((String)min.format(Time)), Integer.parseInt((String)seg.format(Time)));
        Date FechaAlarm = DateSql.getTime();  
        
        Calendar ahora = Calendar.getInstance();    //ahoora es pa sa restarle la alarma a noww
        ahora.set(Integer.parseInt((String)anho.format(noww)),Integer.parseInt((String)mes.format(noww))-1,Integer.parseInt((String)dia.format(noww)),  Integer.parseInt((String)hora.format(noww)),Integer.parseInt((String)min.format(noww)),Integer.parseInt((String)seg.format(noww)));
        String SegXAlarm= "45";
        ahora.add(ahora.MILLISECOND, -(1000*Integer.parseInt(SegXAlarm)));      //ahora.add(ahora.HOUR, -1);
        Date TAlarm = ahora.getTime();
        
        long diferenciaMils,segundos,horas,minutos,DAYS;
        diferenciaMils =  noww.getTime() - FechaAlarm.getTime();                                //FechaActual.getTime() - DateTemp1.getTime();
            segundos = diferenciaMils / 1000;
            horas = segundos / 3600;
            segundos -= horas * 3600;
            minutos = segundos / 60;
            segundos -= minutos * 60;
            DAYS = horas / 24;
            horas -= DAYS * 24;
        String dif = "han trascurrido "+DAYS+" dias con "+horas+" horas. con "+minutos+" minutos";
        if(TAlarm.compareTo(FechaAlarm) > 0) {
        //   alert1.setValue(dif);
           alert1.setVisible(true);
           conIMG.setSrc("/images/ConeccionKO.gif");
           conIMG.setTooltiptext(dif);
            //out.println(" <img src='images/redsiren.gif' width='25' height='35' title='"+dif+"'>");
		
        }else if(TAlarm.compareTo(FechaAlarm) < 0){
            alert1.setVisible(false);
            
            conIMG.setSrc("/images/ConeccionOK.gif");
            //out.println("<img src='images/Greensiren.gif'  width='25' height='35' title='"+dif+"' >");
        }else{
    alert1.setValue("ERROR INUSUAL consulte con soporte tecnico");        
    }
        
    }
        //Alerta de Desconeccion, no se han registrado datos en /xtiempo/
  
    
}
