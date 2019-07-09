# spring security

회사에서 삽질중... 공부한 내역을 간단하게 정리해봤다!
코드가 제대로 돌아가면 코드 단위로도 올려야겠다
##### Java Configuration and Form Login
```
protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login") 1  // spring security 기본이 html 혹은 jsp를 명시하지 않아도 됨, 스프링 시큐리티가 자동적으로 하나 만들어줌! 두둥탁
            .permitAll();        2
}

```

#####
WebSecurityConfigurerAdapter를 쓰면 기본적으로 /logout URL에 접속하면 로그아웃 되게 해놓음
  - HTTP Session 을 무효화시킴
  - RememberMe 인증도 싹다 정리함
  - SecurityContextHolder도 정리함
  - /login?logout으로 이동함


##### OAuth 2.0 Client
OAuth 2.0 Client는 아래와 같은 기능을 제공
  - 인증 코드 부여
  - 클라이언트 계정 부여
  - 서블릿 환경에서의 WebClient 제공


#### Spring boot with OAuth2.0
##### redirect URI 세팅
 - redirect URI는 OAuth 클라이언트에서 액세스 권한을 부여한 후 리다이렉션되는 앱의 경로이다

##### application.yml 정의
  - 특별한 custom 한 링크로 연결해야 할 경우는 아래와 같이 정의한다
```
spring:
  security:
    oauth2:
      client:
        registration:
          cf:
            client-id: okta-client-id
            client-secret: okta-client-secret
        provider:
          cf:   // 엔드 포인트 들을 다 적어줌 흐음!
            authorization-uri: https://your-subdomain.oktapreview.com/oauth2/v1/authorize
            token-uri: https://your-subdomain.oktapreview.com/oauth2/v1/token
            user-info-uri: https://your-subdomain.oktapreview.com/oauth2/v1/userinfo
            user-name-attribute: sub
            jwk-set-uri: https://your-subdomain.oktapreview.com/oauth2/v1/keys
```
