# Instala pacotes essenciais, JMeter e Docker
RUN apt-get update && \
    apt-get install -y wget unzip maven apt-transport-https ca-certificates curl gnupg-agent software-properties-common && \
    rm -rf /var/lib/apt/lists/* && \
    wget https://archive.apache.org/dist/jmeter/binaries/apache-jmeter-5.6.3.zip -O /tmp/apache-jmeter.zip && \
    unzip /tmp/apache-jmeter.zip -d /opt && \
    rm /tmp/apache-jmeter.zip && \
    ln -s /opt/apache-jmeter-5.6.3 /opt/jmeter && \
    chown -R jenkins:jenkins /opt/apache-jmeter-5.6.3 && \
    # Instalação do docker
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | apt-key add - && \
    add-apt-repository \
       "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
       $(lsb_release -cs) stable" && \
    apt-get update && apt-get install -y docker.io

# Configura variáveis de ambiente
ENV JMETER_HOME=/opt/jmeter
ENV PATH=$JMETER_HOME/bin:$PATH

# Instala plugins do Jenkins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt

USER jenkins