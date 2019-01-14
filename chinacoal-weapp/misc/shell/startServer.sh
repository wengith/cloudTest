cd $1
rm -f nohup.out
nohup java ${@:7} -jar -Djava.security.egd=file:/dev/./urandom $1/$2 --server.port=$3 --spring.profiles.active=$4 --eureka.client.serviceUrl.defaultZone=$5 >> $1/nohup.out 2>&1 &
