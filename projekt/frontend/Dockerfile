ARG UBUNTU=20.04
FROM ubuntu:${UBUNTU}

LABEL maintainer="Wojciech Sękowski <wojciech.sekowski@student.uj.edu.pl>"
# Wersje
ENV SCALA_VERSION 2.13.6
ENV SBT_VERSION 1.6.2

ENV SCALA http://www.scala-lang.org/files/archive/scala-$SCALA_VERSION.deb  
ENV SCALA_HOME /usr/local
ENV SBT https://repo.scala-sbt.org/scalasbt/debian/sbt-$SBT_VERSION.deb

RUN \
    apt-get update -y && \
    apt-get upgrade -y && \
    apt install default-jdk -y

RUN \
    apt-get install -y libjansi-java && \  
    apt-get install -y curl && \
    apt-get install -y --no-install-recommends apt-utils \
    curl -sSL $SCALA -o scala.deb && \  
    dpkg -i scala.deb

RUN \
    curl -L -o sbt-$SBT_VERSION.deb $SBT && \
    dpkg -i sbt-$SBT_VERSION.deb && \
    rm sbt-$SBT_VERSION.deb && \
    apt-get update && \
    apt-get install sbt

RUN \
    rm -f *.deb && \  
    apt-get clean && \  
    rm -rf /var/lib/apt/lists/*

# COPY \
#     ./target/scala-2.13 .

WORKDIR /files

COPY \
    ./conf /files/conf

COPY \
    ./app /files/app

COPY \
    ./project /files/project

# COPY \
#     ./target /files/target

COPY \
    ./build.sbt .



# COPY * /files/
# RUN ls -la /files/*

# RUN \
#     cd files

# RUN \
#     sbt run -Dsbt.rootdir=true

# WORKDIR /shop-1.0

EXPOSE 9000
EXPOSE 9001
EXPOSE 9002

CMD [ "sbt", "run",  "-Dhttp.port=9001", "-Dhttps.port=9002" ]