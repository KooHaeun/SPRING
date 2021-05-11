# 05/11
## 1. 프로젝트생성
- 요즘엔 Test code가 중요함 -> 안드로이드랑 비슷하네...
## 2. 라이브러리 살펴보기
- Gradle/Maven같은 빌드툴들은 의존관계를 관리해준다
- 의존의 의존의 의존의 의존...  
spring-boot-starter-web -> 톰캣, webmvc
spring boot-> spring core, spring-boot-starter-logging ->logback, slf4j
## 3. View 환경설정
- Welcome Page 생성 -> 에러 겁나 떴지만 해결
- 스프링 부트는 스프링 생태계를 감싸서 사용할 수 있게 해줌
-Thyleaf 템플릿 엔진 -> 그냥 던져준 파일 커스텀 가능
<html xmlns:th="http://www.thymeleaf.org"> 이거 써주면 됨 -> 근데 나는 또 에러가 난다 Internal server error 500
