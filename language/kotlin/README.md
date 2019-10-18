## 빅 너드 랜치의 코틀린 책을 보고 실습한 것을 기록하는 플줵!! <br>


#### 변수 선언
```kotlin
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
```kotlin
private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
// 코틀린에서는 접근제한자를 안쓰면 public이라고 함 오올!
    //....
}

private fun castFireball(numFireballs: Int = 2) { 
    // 기본 인자값을 설정해줄 수 있다 castFireball() -> castFireaball(2)와 같음
    //.....
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) = when (healthPoints) {
    // 단일 표현식 함수 (뭥미?!) 함수 몸체를 쓰는게 아니고 '=' 다음에 표현식(실행코드)를 정의한다고 함
    // 두 개 이상의 표현식을 쓸 경우에는 원래처럼 {} 요거 써야함
    //.....
}
```
 * Unit 함수 : return이 없는 Java의 void 함수 같은 뇨속, 제네릭을 처리할 수 있게 해줌 
   * 아무것도 반환하지 않는 타입의 함수임을 나타냄 (리턴타입이 Unit 타입이라서)
 * Nothing 함수 : 함수의 실행이 끝나더라고 호출 코드로 제어가 복귀되지 않음 -> 익셉션을 발생시킬 때 사용할 수 있다고 함... ㅇㅁㅇ?

##### 함수 호출
```kotlin
printPlayerStatus(auraColor = "NONE", isBlessed = true, name = "혜린", healthStatus = healthStatus)
// 작정하고 파라미터를 할당할 수 있다
```


#### 익명함수
```kotlin
fun greetingFunction(): String
//인자가 없고, String을 리턴하는 함수! 

val greetingFunction:() -> String = {
        val currentYear = 2019
        "촌장님! 여긴 동물의 숲이다구리! (copyright $currentYear)"
}  
// 익명함수는 return 키워드가 필요 없음. -> 암시적으로 혹은 자동으로 마지막 코드 결과를 반환하기 때문
// return 키워드가 있으면 어떤곳으로 복귀되어야 하는지 컴파일러가 알 수 없대요!

val greetingFunction:(String) -> String = {playerName ->
// 입력받은 String을 playerName으로 씁답니닭!!
// 그치만 인자가 하나면 $it을 쓸 수 있대엽;;

val greetingFunction:(String) -> String = {
    val currentYear = 2019
    "$it 촌장님! 여긴 동물의 숲이다구리! (copyright $currentYear)"
}

runSimulation("혜린", ::printConstructionCost) {playerName, numBuildings ->
// 함수참조를 얻을 때는 :: 연산자를 사용 
```
 * 클로저 : `close over`가 합쳐진 용어, 다른 함수에 포함된 함수에서 자신을 포함하는 함수의 매개변수와 변수를 사용할 수 있는 것