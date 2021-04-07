# openjdk 중 tag가 8-jdk-alpine인 jdk를 기반으로 하여 docker 이미지를 만듭니다.
FROM openjdk:8-jdk-alpine
# Docker 에서 컨테이너를 삭제할 때 컨테이너 내부의 데이터가 삭제되는데,
# VOLUME 명령어를 사용할 경우 컨테이너 외부와 컨테이너 내부를 연결시켜 저장된 데이터의 수명과 데이터를 생성한 컨테이너의 수명을 분리할 수 있습니다.
VOLUME /tmp
# 환경 변수를 선언합니다. 실습에서는 Spring Jar파일이 생성되는 위치를 변수로 선언합니다.
ARG JAR_FILE=build/libs/*.jar
# ENVIRONMENT라는 이름의 argument를 받을 수 있도록 설정
#ARG SPRING_PROFILES_ACTIVE

#RUN echo $SPRING_PROFILES_ACTIVE
# argument로 받은 ENVIRONMENT 값을 SPRING_PROFILES_ACTIVE에 적용
#ENV SPRING_PROFILES_ACTIVE=$SPRING_PROFILES_ACTIVE
# Jar파일을 app.jar 이름으로 복사합니다. 이는 실행할 jar 파일명을 통일하기 위해서입니다.
# Container화 할 때 Jar파일명이 매번 달라지면 실행하기 어렵기 때문입니다.
COPY ${JAR_FILE} app.jar

EXPOSE 8080
# 이미지를 Container로 띄울 때 Jar파일이 실행되어 Spring 서버가 구동되도록 Command를 설정합니다.
ENTRYPOINT ["java","-jar","/app.jar"]