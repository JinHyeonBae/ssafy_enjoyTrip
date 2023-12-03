FROM mysql:latest

ADD ./db /docker-entrypoint-initdb.d

# MySQL 설정

ENV MYSQL_ROOT_ID=ssafy
ENV MYSQL_ROOT_PASSWORD=ssafy
ENV MYSQL_DATABASE=ssafyweb
ENV MYSQL_USER=ssafy
ENV MYSQL_PASSWORD=ssafy

# 포트 설정 (기본 MySQL 포트는 3306)
EXPOSE 3307