#! /bin/bash 

INTROOT="/introots/WEATHER"
CLASSPATH="$CLASSPATH:/opt/groovy/embeddable/groovy-all-1.8.6.jar:$INTROOT/lib/mysql-connector-java-5.1.18-bin.jar:$INTROOT/lib/SensorReader.jar"

export INTROOT
export CLASSPATH

#echo "CLASSPATH=$CLASSPATH"

java SensorReader
