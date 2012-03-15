import groovy.sql.Sql
import java.util.Random


class SensorSimulator {
	private sensorList;
	private sqlHandler;
	
	public SensorSimulator() {
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
			println "ID_SENSOR=" + row.ID_SENSOR
		}
	}
	
	public printSensors() {
		println "List of registered sensors"
		println "--------------------------"
		for (s in sensorList) {
			println "ID_SENSOR=${s}"
		}
	}
	
	public simulate() {
		Random rand = new Random()
		def rs, val, idDato, idRegistro 
		int max = 100
		def sSQL, cal, date, time
		
		for (s in sensorList) {				
			val = rand.nextInt(max)
			// Add data to table DATO
			sSQL = "insert into DATO SET ID_MICRO=1,ID_SENSOR=${s}, DATO=${val}"
			//println "sSQL = ${sSQL}"					
			rs = sqlHandler.executeInsert(sSQL)
			idDato = rs[0][0]
			// Add data to table REGISTRO
			//cal = new GregorianCalendar()
			//date = String.format('%tY/%<tm/%<td',cal)
			//time = String.format('%tH:%<tM:%<tS',cal)					
			//sSQL = "insert into REGISTRO SET FECHA=${date}, HORA=${time}, ID_DATO=${idDato}"
			//rs = sqlHandler.executeInsert(sSQL)
			//idRegistro = rs[0][0]
			
			//println "data generated: SENSOR_ID=${s} ID_DATO=${idDato} ID_REGISTRO=${idRegistro} VAL=${val}"			
			println "data generated: SENSOR_ID=${s} ID_DATO=${idDato} VAL=${val}"
		}		
	}
	
	
	static main(args) {
		println "Starting Sensor Simulator ..."
						
		def micro = new SensorSimulator()
		micro.connect()
		micro.getSensors()
		def calendar
		while(1) {
			calendar = new GregorianCalendar()
			println String.format('%tF %<tT %<tp', calendar)
			micro.simulate()
			println "--------------------------------------"
			sleep(5000)
		}
		micro.disconnect()
		
		println "Finished."
		 
	}
}
