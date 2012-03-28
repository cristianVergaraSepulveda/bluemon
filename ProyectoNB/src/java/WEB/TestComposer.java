package WEB;



import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.util.*;
import org.zkoss.zk.ui.ext.*;
import org.zkoss.zk.au.*;
import org.zkoss.zk.au.out.*;
import org.zkoss.zul.*;
import java.util.*;

public class TestComposer extends GenericForwardComposer{

  private Grid inboxGrid;
  public void doAfterCompose(Component comp) throws Exception {
    super.doAfterCompose(comp);
    
    inboxGrid.setModel(new ListModelList(getData()));

  }
  
  public void onTimer$timer(Event e){
    inboxGrid.setModel(new ListModelList(getUpdatedData()));
  }

  /* simply return a small model here , you could read data from database for your own implementation.*/
  private List<String[]> getData(){
    ArrayList<String[]> list= new ArrayList<String[]>();
    
    list.add(new String[]{"Test Mail1","TonyQ", "10k"});
    list.add(new String[]{"Test Mail12","Ryan", "100k"});
    list.add(new String[]{"Test Mail13","Simon", "15k"});
    list.add(new String[]{"Test Mail14","Jimmy", "5k"});    
    return list;
  }
  
  private List<String[]> getUpdatedData(){
    ArrayList<String[]> list= new ArrayList<String[]>();
    
    list.add(new String[]{"Test Mail1-updated-"+new Date().toString(),"TonyQ", ((int ) ( Math.random() *100 )) + "k"});
    list.add(new String[]{"Test Mail12-updated"+new Date().toString(),"Ryan", ((int ) ( Math.random() *100 )) + "k"});
    list.add(new String[]{"Test Mail13-updated"+new Date().toString(),"Simon", ((int ) ( Math.random() *100 )) + "k"});
    list.add(new String[]{"Test Mail14-updated"+new Date().toString(),"Jimmy", ((int ) ( Math.random() *100 )) + "k"});    
    
    list.add(new String[]{"Test Mail15-updated"+new Date().toString(),"Hi", ((int ) ( Math.random() *100 )) + "k"});    
    
    return list;
 }
  
}
