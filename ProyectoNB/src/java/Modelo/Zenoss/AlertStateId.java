package Modelo.Zenoss;
// Generated 02-04-2012 02:56:43 PM by Hibernate Tools 3.2.1.GA



/**
 * AlertStateId generated by hbm2java
 */
public class AlertStateId  implements java.io.Serializable {


     private String evid;
     private String userid;
     private String rule;

    public AlertStateId() {
    }

    public AlertStateId(String evid, String userid, String rule) {
       this.evid = evid;
       this.userid = userid;
       this.rule = rule;
    }
   
    public String getEvid() {
        return this.evid;
    }
    
    public void setEvid(String evid) {
        this.evid = evid;
    }
    public String getUserid() {
        return this.userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getRule() {
        return this.rule;
    }
    
    public void setRule(String rule) {
        this.rule = rule;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlertStateId) ) return false;
		 AlertStateId castOther = ( AlertStateId ) other; 
         
		 return ( (this.getEvid()==castOther.getEvid()) || ( this.getEvid()!=null && castOther.getEvid()!=null && this.getEvid().equals(castOther.getEvid()) ) )
 && ( (this.getUserid()==castOther.getUserid()) || ( this.getUserid()!=null && castOther.getUserid()!=null && this.getUserid().equals(castOther.getUserid()) ) )
 && ( (this.getRule()==castOther.getRule()) || ( this.getRule()!=null && castOther.getRule()!=null && this.getRule().equals(castOther.getRule()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getEvid() == null ? 0 : this.getEvid().hashCode() );
         result = 37 * result + ( getUserid() == null ? 0 : this.getUserid().hashCode() );
         result = 37 * result + ( getRule() == null ? 0 : this.getRule().hashCode() );
         return result;
   }   


}

