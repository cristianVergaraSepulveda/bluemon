package Modelo.Zenoss;
// Generated 02-04-2012 02:56:43 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * History generated by hbm2java
 */
public class History  implements java.io.Serializable {


     private String evid;
     private String dedupid;
     private String device;
     private String component;
     private String eventClass;
     private String eventKey;
     private String summary;
     private String message;
     private Short severity;
     private Short eventState;
     private String eventClassKey;
     private String eventGroup;
     private Date stateChange;
     private Double firstTime;
     private Double lastTime;
     private Integer count;
     private Short prodState;
     private String suppid;
     private String manager;
     private String agent;
     private String deviceClass;
     private String location;
     private String systems;
     private String deviceGroups;
     private String ipAddress;
     private String facility;
     private Short priority;
     private Short ntevid;
     private String ownerid;
     private Date deletedTime;
     private String clearid;
     private Short devicePriority;
     private String eventClassMapping;
     private String monitor;

    public History() {
    }

	
    public History(String evid, String dedupid, String device, String summary, Date stateChange, String suppid, String manager, String agent, Date deletedTime) {
        this.evid = evid;
        this.dedupid = dedupid;
        this.device = device;
        this.summary = summary;
        this.stateChange = stateChange;
        this.suppid = suppid;
        this.manager = manager;
        this.agent = agent;
        this.deletedTime = deletedTime;
    }
    public History(String evid, String dedupid, String device, String component, String eventClass, String eventKey, String summary, String message, Short severity, Short eventState, String eventClassKey, String eventGroup, Date stateChange, Double firstTime, Double lastTime, Integer count, Short prodState, String suppid, String manager, String agent, String deviceClass, String location, String systems, String deviceGroups, String ipAddress, String facility, Short priority, Short ntevid, String ownerid, Date deletedTime, String clearid, Short devicePriority, String eventClassMapping, String monitor) {
       this.evid = evid;
       this.dedupid = dedupid;
       this.device = device;
       this.component = component;
       this.eventClass = eventClass;
       this.eventKey = eventKey;
       this.summary = summary;
       this.message = message;
       this.severity = severity;
       this.eventState = eventState;
       this.eventClassKey = eventClassKey;
       this.eventGroup = eventGroup;
       this.stateChange = stateChange;
       this.firstTime = firstTime;
       this.lastTime = lastTime;
       this.count = count;
       this.prodState = prodState;
       this.suppid = suppid;
       this.manager = manager;
       this.agent = agent;
       this.deviceClass = deviceClass;
       this.location = location;
       this.systems = systems;
       this.deviceGroups = deviceGroups;
       this.ipAddress = ipAddress;
       this.facility = facility;
       this.priority = priority;
       this.ntevid = ntevid;
       this.ownerid = ownerid;
       this.deletedTime = deletedTime;
       this.clearid = clearid;
       this.devicePriority = devicePriority;
       this.eventClassMapping = eventClassMapping;
       this.monitor = monitor;
    }
   
    public String getEvid() {
        return this.evid;
    }
    
    public void setEvid(String evid) {
        this.evid = evid;
    }
    public String getDedupid() {
        return this.dedupid;
    }
    
    public void setDedupid(String dedupid) {
        this.dedupid = dedupid;
    }
    public String getDevice() {
        return this.device;
    }
    
    public void setDevice(String device) {
        this.device = device;
    }
    public String getComponent() {
        return this.component;
    }
    
    public void setComponent(String component) {
        this.component = component;
    }
    public String getEventClass() {
        return this.eventClass;
    }
    
    public void setEventClass(String eventClass) {
        this.eventClass = eventClass;
    }
    public String getEventKey() {
        return this.eventKey;
    }
    
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
    public String getSummary() {
        return this.summary;
    }
    
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    public Short getSeverity() {
        return this.severity;
    }
    
    public void setSeverity(Short severity) {
        this.severity = severity;
    }
    public Short getEventState() {
        return this.eventState;
    }
    
    public void setEventState(Short eventState) {
        this.eventState = eventState;
    }
    public String getEventClassKey() {
        return this.eventClassKey;
    }
    
    public void setEventClassKey(String eventClassKey) {
        this.eventClassKey = eventClassKey;
    }
    public String getEventGroup() {
        return this.eventGroup;
    }
    
    public void setEventGroup(String eventGroup) {
        this.eventGroup = eventGroup;
    }
    public Date getStateChange() {
        return this.stateChange;
    }
    
    public void setStateChange(Date stateChange) {
        this.stateChange = stateChange;
    }
    public Double getFirstTime() {
        return this.firstTime;
    }
    
    public void setFirstTime(Double firstTime) {
        this.firstTime = firstTime;
    }
    public Double getLastTime() {
        return this.lastTime;
    }
    
    public void setLastTime(Double lastTime) {
        this.lastTime = lastTime;
    }
    public Integer getCount() {
        return this.count;
    }
    
    public void setCount(Integer count) {
        this.count = count;
    }
    public Short getProdState() {
        return this.prodState;
    }
    
    public void setProdState(Short prodState) {
        this.prodState = prodState;
    }
    public String getSuppid() {
        return this.suppid;
    }
    
    public void setSuppid(String suppid) {
        this.suppid = suppid;
    }
    public String getManager() {
        return this.manager;
    }
    
    public void setManager(String manager) {
        this.manager = manager;
    }
    public String getAgent() {
        return this.agent;
    }
    
    public void setAgent(String agent) {
        this.agent = agent;
    }
    public String getDeviceClass() {
        return this.deviceClass;
    }
    
    public void setDeviceClass(String deviceClass) {
        this.deviceClass = deviceClass;
    }
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    public String getSystems() {
        return this.systems;
    }
    
    public void setSystems(String systems) {
        this.systems = systems;
    }
    public String getDeviceGroups() {
        return this.deviceGroups;
    }
    
    public void setDeviceGroups(String deviceGroups) {
        this.deviceGroups = deviceGroups;
    }
    public String getIpAddress() {
        return this.ipAddress;
    }
    
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public String getFacility() {
        return this.facility;
    }
    
    public void setFacility(String facility) {
        this.facility = facility;
    }
    public Short getPriority() {
        return this.priority;
    }
    
    public void setPriority(Short priority) {
        this.priority = priority;
    }
    public Short getNtevid() {
        return this.ntevid;
    }
    
    public void setNtevid(Short ntevid) {
        this.ntevid = ntevid;
    }
    public String getOwnerid() {
        return this.ownerid;
    }
    
    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }
    public Date getDeletedTime() {
        return this.deletedTime;
    }
    
    public void setDeletedTime(Date deletedTime) {
        this.deletedTime = deletedTime;
    }
    public String getClearid() {
        return this.clearid;
    }
    
    public void setClearid(String clearid) {
        this.clearid = clearid;
    }
    public Short getDevicePriority() {
        return this.devicePriority;
    }
    
    public void setDevicePriority(Short devicePriority) {
        this.devicePriority = devicePriority;
    }
    public String getEventClassMapping() {
        return this.eventClassMapping;
    }
    
    public void setEventClassMapping(String eventClassMapping) {
        this.eventClassMapping = eventClassMapping;
    }
    public String getMonitor() {
        return this.monitor;
    }
    
    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }




}


