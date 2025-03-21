FROM jenkins/jenkins:lts

USER root

# Instala pacotes essenciais e JMeter
RUN apt-get update && \
    apt-get install -y wget unzip maven && \
    rm -rf /var/lib/apt/lists/* && \
    wget https://archive.apache.org/dist/jmeter/binaries/apache-jmeter-5.6.3.zip -O /tmp/apache-jmeter.zip && \
    unzip /tmp/apache-jmeter.zip -d /opt && \
    rm /tmp/apache-jmeter.zip && \
    ln -s /opt/apache-jmeter-5.6.3 /opt/jmeter && \
    chown -R jenkins:jenkins /opt/apache-jmeter-5.6.3

# Configura variáveis de ambiente
ENV JMETER_HOME=/opt/jmeter
ENV PATH=$JMETER_HOME/bin:$PATH

# Instala plugins do Jenkins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt

USER jenkins