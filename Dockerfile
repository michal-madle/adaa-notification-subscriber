FROM nexus3.kb.cz:18443/base/kb_openjdk_slim:11.0.1
COPY ./server/target/adaa-notification-subscriber.war /appl/tomcatmw/

# 8080 - application, 8009 - jmx, 25232 - actuator production-ready monitoring
EXPOSE 8080 8009 25323

#ENV TZ=Europe/Prague
#RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ENV JAVA_OPTS="\
-Duser.timezone=Europe/Prague \
"

CMD ["java", "-jar", "/appl/tomcatmw/adaa-notification-subscriber.war"]
