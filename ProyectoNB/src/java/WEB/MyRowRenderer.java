package WEB;



import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.util.*;
import org.zkoss.zk.ui.ext.*;
import org.zkoss.zk.au.*;
import org.zkoss.zk.au.out.*;
import org.zkoss.zul.*;

 
public class MyRowRenderer implements RowRenderer {
  /*  public void render(Row row, java.lang.Object data) {
        String[] _data = (String[])data;
        new Label(_data[0]).setParent(row); 
        new Label(_data[1]).setParent(row);
    }*/
    
     public void render(final Row row, final java.lang.Object data) {
        String[] ary = (String[]) data;
        new Label(ary[0]).setParent(row);
        new Label(ary[1]).setParent(row);
       // new Label(ary[2]).setParent(row);
    }

    
}