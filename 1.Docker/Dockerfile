ARG OPENJDK_TAG=11.0.13
FROM openjdk:${OPENJDK_TAG}

LABEL maintainer="Wojciech Sękowski <wojciech.sekowski@student.uj.edu.pl>"

# Wersje
ENV SCALA_VERSION 2.12.10
ENV SBT_VERSION 1.6.2

# Instalowanie scali i sbt
RUN \
  echo 'Instalujemy Scale...' && \
  wget "http://www.scala-lang.org/files/archive/scala-$SCALA_VERSION.tgz" && \
  tar xzf scala-$SCALA_VERSION.tgz -C /tmp/ && \
  mv /tmp/scala-$SCALA_VERSION/* /usr/local/bin/ && \
  rm -rf scala-$SCALA_VERSION.tgz && \
  echo 'Instalujemy sbt...' && \
  curl -L -o sbt-$SBT_VERSION.deb https://repo.scala-sbt.org/scalasbt/debian/sbt-$SBT_VERSION.deb && \
  dpkg -i sbt-$SBT_VERSION.deb && \
  rm sbt-$SBT_VERSION.deb && \
  apt-get update && \
  apt-get install sbt && \
  echo 'Instalujemy nano...' && \
  apt-get install nano && \
  echo 'Tworzenie wszystkich zaleznosci sbt...' && \
  mkdir -p /tmp/project && \
  echo 'name := "project"' > /tmp/project/build.sbt && \
  echo 'version := "1.0"' >> /tmp/project/build.sbt && \
  echo "scalaVersion := \"$SCALA_VERSION\"" >> /tmp/project/build.sbt && \
  mkdir -p /tmp/project/src/main/scala && \
  echo 'object Main { def main(args: Array[String]) = println("Hello") }' > /tmp/project/src/main/scala/Main.scala && \
  cd /tmp/project && sbt run 
  #rm -rf /tmp/*

ENV SCALA_HOME /usr/local

VOLUME /home/wojtek/ebiznes/

EXPOSE 8000

# odpalamy bash
CMD ["bash"]

# budowanie obrazu z Dockerfile: sudo docker build -t java_scala:1.1 .
# wejscie do srodka kontenera:  sudo docker exec -it 71942e5b815f bash