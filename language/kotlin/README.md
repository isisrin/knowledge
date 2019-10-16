## 빅 너드 랜치의 코틀린 책을 보고 실습한 것을 기록하는 플줵!! <br>


#### 변수 선언
```
 var experiencePoints: Int = 5 
 // var -> 값을 재 할당할 수 있는 키워드
 // experiencePoints: Int -> Int 타입 변수를 선언 중...
 // var experiencePoints: Int = 5  -> var experiencePoints = 5
 
  val playerName: String = "Hyerin"
  // val -> java의 final같은 녀석
  // 타입추론을 해주니 Int나 String을 작성할 필요는 없다...ㅠㅠ
```
 * 자바와 달리 코틀린은 참조 타입만 제공한다고 함. int 대신 Int?
  
#### 함수 선언
```
private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
// 코틀린에서는 접근제한자를 안쓰면 public이라고 함 오올!
    ....
}

private fun castFireball(numFireballs: Int = 2) { 
    // 기본 인자값을 설정해줄 수 있다 castFireball() -> castFireaball(2)와 같음
    .....
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) = when (healthPoints) {
    // 단일 표현식 함수 (뭥미?!) 함수 몸체를 쓰는게 아니고 '=' 다음에 표현식(실행코드)를 정의한다고 함
    // 두 개 이상의 표현식을 쓸 경우에는 원래처럼 {} 요거 써야함
    .....
}
```
 * Unit 함수 : return이 없는 Java의 void 함수 같은 뇨속, 제네릭을 처리할 수 있게 해줌 
   * 아무것도 반환하지 않는 타입의 함수임을 나타냄 (리턴타입이 Unit 타입이라서)
 * Nothing 함수 : 함수의 실행이 끝나더라고 호출 코드로 제어가 복귀되지 않음 -> 익셉션을 발생시킬 때 사용할 수 있다고 함... ㅇㅁㅇ?

##### 함수 호출
```
printPlayerStatus(auraColor = "NONE", isBlessed = true, name = "혜린", healthStatus = healthStatus)
// 작정하고 파라미터를 할당할 수 있다
```
