# OpenJDK 17 기반 이미지 사용
FROM openjdk:17

# 애플리케이션 JAR 파일 위치 설정
ARG JAR_FILE=target/*.jar

# 컨테이너 내에서 실행될 디렉토리 설정
WORKDIR /app

# JAR 파일을 컨테이너 이미지로 복사
COPY ${JAR_FILE} app.jar

# 컨테이너가 시작될 때 실행할 명령어 설정
ENTRYPOINT ["java","-jar","app.jar"]
