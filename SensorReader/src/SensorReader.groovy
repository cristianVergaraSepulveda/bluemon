import groovy.sql.Sql
import java.sql.ResultSet;
import java.util.Random
import java.util.Date
import java.text.SimpleDateFormat
import java.lang.Math

class SensorReader {
	private sensorList;
	private sqlHandler;
	
	public SensorReader() {
		sensorList = []
	}
	
	public connect() {
		this.sqlHandler = Sql.newInstance("jdbc:mysql://localhost:3306/monitoreo", "entel",
			"entel", "com.mysql.jdbc.Driver")
	}
	
	public disconnect() {
		this.sqlHandler.close()
	}
	
	public getSensors() {
		this.sqlHandler.eachRow("select * from SENSOR") { row ->
			sensorList.add(row.ID_SENSOR)
			//println "ID_SENSOR=" + row.ID_SENSOR
		}
	}
	
	public printSensors() {
		println "List of registered sensors"
		println "--------------------------"
		for (s in sensorList) {
			println "ID_SENSOR=${s}"
		}
	}
	
	public String deprecated_getSensorValue(int idMicro) {
		def sSQL; 
		def sResult
		def date, time
		int size
		def idRegistro	
		int now	
		
		def cal = new GregorianCalendar()
		date = String.format('%tY/%<tm/%<td',cal)
		time = String.format('%tH:%<tM:%<tS',cal)
		
		sSQL = "select max(ID_REGISTRO) from REGISTRO"
		sqlHandler.eachRow(sSQL) { row ->
			idRegistro = row[0]
		}
		//println "max ID_REGISTRO = ${idRegistro}"
		
		sSQL = "select ID_REGISTRO, FECHA, HORA from REGISTRO where ID_REGISTRO = ${idRegistro}"
		sqlHandler.eachRow(sSQL) { row -> 
			date = row.FECHA
			time = row.HORA
		}
		
		//TODO: we should compare that the time of the newest register is close enough
		//      to the current time. otherwise => no new register is being sent by the sensors
		now = System.currentTimeMillis()
		Date dtTmp = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss").parse("${date}T${time}");
		int delta = now - dtTmp.getTime()
		//println "delta = ${delta}"
		if(Math.abs(delta) >= 30000 ) {
			//data older than 30 seconds
			sResult = "ERROR: Data too old (${delta}/1000.0 s)|"
			return sResult;
		}


		//verify that 
		sSQL = "select SQL_NO_CACHE count(*)"
		sSQL += " from REGISTRO"
		sSQL += " LEFT JOIN DATO ON REGISTRO.ID_DATO = DATO.ID_DATO"
		sSQL += " LEFT JOIN SENSOR ON SENSOR.ID_SENSOR = DATO.ID_SENSOR"
		sSQL += " where REGISTRO.FECHA =\"${date}\""
		sSQL += " and REGISTRO.HORA =\"${time}\""
		sSQL += " and DATO.ID_MICRO = ${idMicro}"
		
		boolean quit = false;
		int startTime = System.currentTimeMillis();
		int timeout = 5000 // 5 seconds		
		while(!quit) {
				
			sqlHandler.eachRow(sSQL) { row ->
				size = row[0]
			}
			sqlHandler.cacheStatements() { cache ->
				cache = false
			}
		
			//println("sensorList.size=${this.sensorList.size()}, and there are  ${size} in the DB")		
			if (size < this.sensorList.size()) {
				//data is being persisted. wait a second
				println "wait an additional second, size=${size}, expected=${this.sensorList.size()}"
				sleep(1000) 
			} else { 
				quit = true
			}
			
			now = System.currentTimeMillis();
			if( now - startTime > timeout) {
				//sResult = "ERROR: Timeout. Only found ${size} sensor data instead of ${this.sensorList.size()}|"
				//return sResult;
				println "Timeout ..., return what I got: ${size}, expected: ${this.sensorList.size()}"				
				break;
			}		
		}
				
		sSQL = "select SENSOR.NOMBRESENSOR, DATO.DATO, REGISTRO.FECHA, REGISTRO.HORA"
        sSQL += " from REGISTRO" 
        sSQL += " LEFT JOIN DATO ON REGISTRO.ID_DATO = DATO.ID_DATO"
		sSQL += " LEFT JOIN SENSOR ON SENSOR.ID_SENSOR = DATO.ID_SENSOR"		
	    sSQL += " where REGISTRO.FECHA =\"${date}\"" 
	    sSQL += " and REGISTRO.HORA =\"${time}\""
		sSQL += " and DATO.ID_MICRO = ${idMicro}"
		
		//println sSQL				
		 
	    sResult = "OK|"	 		
		size = 0
        sqlHandler.eachRow(sSQL) { row -> 
			size++
			sResult += " " + row.NOMBRESENSOR + "=" + row.DATO			
		} 
		
		if(size == 0){
			sResult = "ERROR: no data available|"
		} 
		
		
		//return additional info about the status of data acquisition process
		sResult += " MAX_ID_REGISTRO=${idRegistro}" 
		sResult += " NUM_SENSOR_DATA=${size}"
		return sResult		 		
	}
	
	public String getSensorValue(int idMicro) {
		def sSQL;
		def sResult
		def date, time
		int size
		def idRegistro
		int now
		
		def cal = new GregorianCalendar()
		date = String.format('%tY/%<tm/%<td',cal)
		time = String.format('%tH:%<tM:%<tS',cal)
		
		sSQL = "select * from DATO_ACTUAL order by ID_SENSOR"
		sqlHandler.eachRow(sSQL) { row ->
			date = row.FECHA
			time = row.HORA
		}
		
		//TODO: we should compare that the time of the newest register is close enough
		//      to the current time. otherwise => no new register is being sent by the sensors



		
		
		sSQL = "select SENSOR.NOMBRESENSOR, SENSOR.ID_MICRO, DATO_ACTUAL.DATO, DATO_ACTUAL.FECHA, DATO_ACTUAL.HORA"
		sSQL += " from DATO_ACTUAL"
		sSQL += " LEFT JOIN SENSOR ON SENSOR.ID_SENSOR = DATO_ACTUAL.ID_SENSOR"
		sSQL += " where SENSOR.ID_MICRO = ${idMicro}"
		
		//println sSQL
		 
		sResult = "OK|"
		size = 0
		now = System.currentTimeMillis()
		Date dtTmp = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss").parse("${date}T${time}");
		
		sqlHandler.eachRow(sSQL) { row ->
			date = row.FECHA
			time = row.HORA			
			int delta = now - dtTmp.getTime()
			if(Math.abs(delta) <= 30000 ) {
				size++
				sResult += " " + row.NOMBRESENSOR + "=" + row.DATO
			} else {
				//data older than 30 seconds
				//sResult = " ERROR: Data too old (${delta/1000.0} s)|"
				//return sResult;
			} 
		}
					
		if(size == 0){
			sResult = "ERROR: no data available|"
		} 
		
		sResult += " Expected=${this.sensorList.size()}"
		sResult += " Received=${size}"
				
		return sResult
	}

	
	static main(args) {
		def micro = new SensorReader()		
		micro.connect()
		micro.getSensors()
		println micro.getSensorValue(1)
		micro.disconnect()
	}

}
