FROM jboss/wildfly

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

ADD target/ICD-9.war /opt/jboss/wildfly/standalone/deployments/
