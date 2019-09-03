# 면접 준비.... 하핳

## JAVA

#### JVM 구조
![ex_screenshot](./캡처.png)
* 메소드 영역 : JVM이 시작할 때 생성됨. 모든 스레드가 공유하는 영역. 클래스 로더에서 읽어들인 클래스 별 static field, constant, method code, constructor 등이 존재함.
* 힙 영역 : new로 생성한 객체 및 배열이 생성되는 곳. 여기에서 생긴 객체들은 JVM 스택의 변수나 다른 객체의 필드에서 참조함. 참조하는 변수나 필드가 없으면 가비지 컬렉터의 제거 대상이 됨 (ex) 객체의 값이 null 일때)
* JVM 스택 영역 : 메소드를 호출할 떄마다 프레임을 추가하고, 메소드가 종료되면 해당 프레임을 제거함.

#### final 키워드
final filed :  값의 재할당 불가 <br>
final method : overried 불가 <br>
final class : 상속 불가
<br>

#### 추상클래스와 인터페이스
추상클래스의 용도 및 특징
 1. 공통된 필드와 메소드의 이름을 통일할 목적
 2. 실제 클래스를 작성할 때 시간 절약
 
인터페이스의 용도 및 특징
 1. 개발 코드를 수정하지 않고 사용하는 객체를 변경할 수 있도록 하기 위함.
 2. 모든 메소드는 public 이어야 함

=> 추상클래스와 인터페이스 모두 new 연산자로 생성할 수 없음


#### 멀티스레드
임계역영(critical section) : 멀티 스레드 환경에서 단 하나의 스레드만 실행할 수 있는 코드 영역 
synchronized method : 임계영역을 지정하기 위한 키워드, 인스턴스, 정적 메소드 어디서든 지정가능
```$xslt
public synchronized void method() {
    임계 영역; // 단 하나의 스레드만 실행!
}
```

데몬스레드 만들기
```$xslt
public static void main(String[] args) {
    BackgroudThread backgroundThread = new BackgroudThread();
    backgroundThread.setDaemon(true);   // setDaemon()랑 start() 함수랑 순서가 바뀌면 IllegalException 발생함
    backgroundThread.start();
}
```

#### 컬렉션 프레임워크
 * List : 객체를 인덱스로 관리, 객체의 주소를 참조
    * ArrayLIst : 배열과 비슷한 형태, 조회가 많은 작업일 때 유용
    * Vector : ArrayList와 동일한 구조를 가짐. synchronized 메소드로 구성되어 있어서 thread safe 함.
    * LinkedList : NodeList의 형태 삽입, 삭제가 빈번할 때 유용
* Set : 순서가 보장되지 않음. 중복저장 불가
    * HashSet : 객체를 저장하기 전에 HashCode() 메소드를 호출해서 동일한 객체인지 판별 후 저장
* Map : key, value로 저장
    * HashMap : key를 해시코드로 저장
    * HashTable : HashMap과 동일한 구조를 가짐. synchronized 메소드로 구성되어 있어서 thread safe 함. </br>
    => 중복 키 값을 put할 경우, 값을 덮어쓰고 이전 값을 리턴함.
* Stack(클래스) : 후입선출
* Queue : 선입선출
    * LinkedList : List의 것과 동일 ㅇㅁㅇ!!
    
    
#### ORM
 * ORM : 참고 [https://github.com/isisrin/knowledge/blob/master/jpa/jpa.md]
 

## HTTP 

#### http에서의 동작과정 간단하게...
1. 문자로 입력된 웹 사이트 주소를 근처의 DNS 서버로 보내 IP 취득함
2. 입력된 정보를 HTTP에 맞게 재구성 후 OS에 요청
3. 네트워크 담당프로그램이 패킷화 한 후에 랜선으로 송출
4. gateway와 proxy 서버가 패킷을 읽어서 주소 파악 후 해당 웹 서버로 전송
5. 웹 서버의 OS가 패킷을 HTTP에 맞게 재구성 함
