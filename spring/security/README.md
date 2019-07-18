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


##### 트러블 슈팅 내역
* 테스트 용도로 인증서버에 public domain을 붙인 후에 신뢰된 공인인증서가 없는 경우 SSL을 무시하도록 설정해야 한다. 
  spring boot에서 쓸 수 있는 security의 클래스인 'ClientRegistration' 클래스를 이용해서 oauth2인증을 할 경우... oauth2Template, restTemplate 둘 다 수정할 수 없어서ㅠㅠ
  아래와 같이 전역적으로 ssl 설정을 스킵해 보았다...
``` 
[invalid_token_response] An error occurred while attempting to retrieve the OAuth 2.0 Access Token Response: 
I/O error on POST request for "https://uaa.101.55.50.208.xip.io/oauth/token": sun.security.validator.ValidatorException: PKIX path building failed: 
sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target; 
nested exception is javax.net.ssl.SSLHandshakeException: sun.security.validator.ValidatorException: 
PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
```

```
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        turnOffSslChecking();
        ..... 중략
    }

    private static final TrustManager[] UNQUESTIONING_TRUST_MANAGER = new TrustManager[]{
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers(){
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType ){}
                public void checkServerTrusted(X509Certificate[] certs, String authType ){}
            }
    };

    public  static void turnOffSslChecking() throws NoSuchAlgorithmException, KeyManagementException {
        // Install the all-trusting trust manager
        final SSLContext sc = SSLContext.getInstance("SSL");
        sc.init( null, UNQUESTIONING_TRUST_MANAGER, null );
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }
```

* spring oauth2 에서 scope openid 인 경우 token 파싱을 하는데, token header값에 null이 있는 경우는 jwt 익셉션이 난다... 이 경우에는 token을 발급하는 사이트 자체에 버그가 있을 수 있음...
  <br/> ex) 'cty' header null 이런 느낌의에러...