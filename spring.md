# 프로젝트 환경설정
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

# 스프링 웹 개발 기초
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

# 회원 관리 예제 - 백엔드 개발
## 1. 비즈니스 요구사항 정리
- test 중요..., 만들어봄
1. 일반적인 웹어플리케이션 계층 구조
- 컨트롤러: 웹 MVC의 컨트롤러 역활
- 서비스: 핵심 비즈니스 로직 구현
- 리포지토리: 디비에 접근, 도메인 객체를 디비에 저장하고 관리
- 도메인: 비즈니스 도메인 객체

# 스프링 빈과 의존관계
 - 스프링 빈의 등록방식
## 1. 컴포넌트 스캔과 자동 의존관계 설정
- 프로그램 실행시 스프링 컨테이너 생성 -> @controller가 있으면 컨트롤러 객체가 생성돼서 스프링에 넣어지고 스프링이 관리 => 컨테이너에서 스프링 빈 관리
- 객체를 new 생성보다는 스프링 컨테이너에 등록해서 사용
- @Autowired: memberController 생성시 컨테이너에 있는 memberService를 데려와서 생성자에 넣어줌 -> dependency injection
- @Controller에서 외부요청 받고 @Service에서 비즈니스 로직만들고 @Repository에서 데이터 저장 -> 정형화된 패턴
- @Component: 스프링 빈으로 자동 등록됨 -> @Controller, @Service, @Repository도 @Component 가지고 있음
- 스프링 빈을 컨테이너에 등록시 싱글톤으로 등록, 그래서 대부분 같은 스프링 빈이면 같은 스프링 인스턴스임
## 2. 자바 코드로 직접 스프링 빈 등록하기
- Dependency Injection: 필드 주입, setter 주입, 생성자 주입 -> 의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 생성자 주입을 권장
- @Autowired 를 통한 DI는 helloConroller , memberService 등과 같이 스프링이 관리하는 객체에서만 동작, 직접 생성한 객체에서는 동작x

# 회원 관리 예제 - 웹 MVC 개발
## 회원 웹 기능
- PostMapping: 값 전달, 데이터 등록
- GetMapping: 데이터 조회
- thymeleaf 반복문
tr th:each="member : ${members}">
                td th:text="${member.id}"></td>
                td th:text="${member.name}"></td>

# 스프링 DB 접근 기술
