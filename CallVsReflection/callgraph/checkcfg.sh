javac -cp "soot-trunk.jar:reflection.jar" CallGraphExample.java
 
#java -cp .:soot-trunk.jar CallGraphExample -pp -w -allow-phantom-refs -ire -process-dir $1 -src-prec java
#java -cp .:soot-trunk.jar soot.Main CallGraphExample -pp -w -allow-phantom-refs -ire -process-dir $1 -src-prec java  
#-w -allow-phantom-refs -ire 
#$logfile -pp -d /media/jyoti/a56a27d9-6252-44a9-a4c1-1862971af1d4/jyoti/shi/sh_instrument/instrumentedapps -android-jars /media/jyoti/a56a27d9-6252-44a9-a4c1-1862971af1d4/jyoti/Android/adt-bundle-linux-x86_64-20140702/sdk/platforms/ -w -allow-phantom-refs -ire -process-dir $1 -output-format dex -src-prec apk 

java -cp .:soot-trunk.jar:reflection.jar CallGraphExample -soot-class-path /usr/lib/jvm/java-7-openjdk-amd64/jre/lib/rt.jar:/usr/lib/jvm/java-7-openjdk-amd64/jre/lib/jce.jar:. -pp -w -allow-phantom-refs -ire -process-dir $1 -src-prec java

