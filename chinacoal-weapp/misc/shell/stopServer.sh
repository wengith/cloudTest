netstat -tnlp|grep $1|awk '{print$7}'|awk -F"/" '{print$1}'|while read pid
do
  kill -9 $pid
done
