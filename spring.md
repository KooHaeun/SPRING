# 05/11 - 프로젝트 환경설정
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
html xmlns:th="http://www.thymeleaf.org" 이거 써주면 됨 -> 근데 나는 또 에러가 난다 Internal server error 500 -> project 다시 만듦

- 웹주소 입력 -> 내장 서버 -> 스프링이 helloController에서 GetMapping에 hello랑 매칭 -> return 값을 받으면 ViewResolver가 화면 찾아서 처리

## 4. 빌드하고 실행하기
- 윈도우에서 Bit bash 터미널 사용<br>1. setting -> Terminal -> Shell path<br>2. "C:\Program Files\Git\bin\sh.exe" -login -i 변경<br> 3. Terminal 키면 됨

# 05/12 - 스프링 웹 개발 기초
- 정적 컨텐츠: 그냥 파일 받아서 웹브라우저에 내려줌
- MVC&Templates Engine: 서버에서 프로그래밍해서 html을 동적으로 바꿈, MVC(Model, View, Controller)
- API: JSON 데이터 포맷으로 클라이언트에게 전달
## 1. 정적 컨텐츠 
- 걍 받아서 뿌려줌
## 2. MVC & Templates Engine
- ViewResolver에 넘겨
- 내가 준걸로 변환해서 웹브라우저에 넘김
## 3. API
- ResponseBody: body에 데이터 직접 넣어준다
- 데이터만 그냥 넘겨줌, json방식
- ViewResolver대신 HttpMessageConverter가 동작해서 객체가 오면 걍 json방식으로 변경에서 넘겨