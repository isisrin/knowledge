## Spring

#### IoC 
 * 자신이 사용할 객체를 new로 생성하지 않음.
 
#### 프레임워크 vs 라이브러리
 * 라이브러리를 사용하는 애플리케이션 코드는 애플리케이션 흐름을 직접 제어함. 
 * 프레임워크는 어플리케이션 코드가 프레임워크에 의해 사용됨. => IoC가 적용되어 있음

#### 스프링 빈
 * 스프링에 의해 IoC 방식으로 관리되는 오브젝트, 스프링이 new 해줌 
 
 
#### 알게 된 사실
 * @Conditional 기반으로 빈이 추가되는지 아닌지가 결정됨
 * spring.fatories에 가면 autoconfig일 때 만들어줄 빈들이 목록화 되어이씀
 
 
#### Spring 이해 포인트를 읽고 정리! 한 것
* 원문 : https://www.slideshare.net/masatoshitada7/spring-boot-jjug
* Spring Frame work의 문제점 : CoC가 아니다. 
    * CoC : Convention over Configuration (설정보다 규약) 프레임 워크를 사용하기 위해 여러가지 설정을 기술하지 않고, 미리 규약을 정해놔서 설정을 되도록 없애자는 사고방식
* Spring Boot란? : Spring에 CoC를 도입한 것, 설정을 최소화 하고 바로 개발에 착수할 수 있도록 함.
* 스프링에서의 설정이란? : 이 클래스의 인스턴스를 Bean으로 한다고 DI Container에게 알려주는 것
    * 설정 ≒ Bean 정의
    * 설정 방법엔 3가지가 있다
        * 1 어노테이션과 컴포넌트 스캔 조합
        * 2 메서드에 의한 Bean 정의
        * 3 XML 설정파일에 의한 정의
* Spring MVC 동작 원리 : 
    * DispatcherServlet이 컨테이너를 가지고 있고, 필요한 빈을 꺼내서 사용한다
    * Spring MVC의 각 부품은 인터페이스화 되어 있어, 실제 클래스를 빈으로 정의한다
    * @EnableWebMvc로 전형적인 빈들을 일괄 정의한다 예) @Controller, @Service etc...
    * @Controller랑 @ComponentScan으로 컨트롤러를 빈으로 정의한다
* Spring Boot가 해주는 것 : 프레임워크를 동작시키는 빈을 미리 정의해 놓음 
    * JAR 안의 AutoConfiguration class가 여러개 준비되어 있음
    * @EnableAutoConfiguration으로 spring.factories을 읽어들이도록 지정하고, 그 중에서 쓰겠다고 기술한 AutoConfiguration class 를 읽어들이고 있다
    *  @ConditionalOnXxx로 지정된 조건을 판단해서, Bean마다 유효화/무효화를 선별하고 있다

