# Ace Server 12.*
FROM quay.io/luisbaez/ace-server:12.0.2.0-r1

RUN mkdir /home/aceuser/initial-config/setdbparms \
	&& mkdir /home/aceuser/initial-config/serverconf 

COPY BARfiles /home/aceuser/bars

COPY AceAdaptadorCacheJava/libs/jedis-3.5.2.jar /home/aceuser/ace-server/shared-classes/

ENV LICENSE accept
ENV ACE_SERVER_NAME ACESERVER 

EXPOSE 7600
EXPOSE 7800
EXPOSE 7843

USER root
 
RUN chmod -R ugo+rwx /home/aceuser
 
USER 1000

COPY ace_compile_bars.sh .

RUN ace_compile_bars.sh

USER root
 
RUN  chmod -R ugo+rwx /home/aceuser

# RUN chmod 100 /home/aceuser/initial-config/setdbparms/
 
USER 1000