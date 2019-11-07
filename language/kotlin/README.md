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
 
#### Null처리
 * 안전 호출 연산자
```kotlin
var beverage = readLine()?.capitalize()  // 있으면 capitalize()를 호출 없으면 null리턴 Optional느낌!

var beverage = readLine()?.let {   // Null일 때 하고 싶은 조건을 달기위해... let을 썼음다
  if (it.isNotBlank()) {
      it.capitalize()
  } else {
      "막걸리"
  }
}
```
 * non-null 단언 연산자
```kotlin
var beverage = readLine()!!.capitalize()    // readLine이 뭘 리턴하던 간에 실행! null이면 익셉션 발생..
```
* null인지 체크
```kotlin
var beverage = readLine()

if (beverage != null) {
// ... 
}

val beverageServed: String = beverage ?: "막걸리"    // beverage가 null이면 막걸리 리턴 오옭...!
```

#### 예외던지기
```kotlin
fun proficiencyCheck(swordsJuggling: Int?) {
    swordsJuggling ?: throw UnskilledSwordJugglerException()   //커스텀에러 던지깃!
}

class UnskilledSwordJugglerException : IllegalArgumentException("저글링이 불가눙햅")  //커스텀에러 작성
```
   
#### 예외 처리
```kotlin
fun proficiencyCheck(swordsJuggling: Int?) {
    checkNotNull(swordsJuggling, {"저글링이 불가눙햅"})   //전제 조건 함수 사용 
}
```
 * 코틀린에선 모든 예외가 unchecked Exception!!
 
#### 문자열
 * replace 함수도 Java 와 마찬가지로 새로운 문자열을 출력해준당
 * 코틀린에선 `==` 가 `String.equals()` 와 같다. (`===` 는 `String A == String B`)
 
#### 표준함수
 * 확장 함수를 실행하는 주체를 수신자 객체라하고, 확장 함수가 호출될 때 수신자 객체의 참조가 확장 함수로 전달됨 ~~멍게소리여~~
    * apply : 람다 내부에서 해당 수신자에 대한 모든 함수 호출이 가능하도록 apply 함수가 사용 범위를 설중해 줌
     ```kotlin
     val menuFile = File("menu-file.txt")
     menuFile.setReadable(true)
     menuFile.setWritable(true)
     menuFile.setExecutable(false)
     
     // apply 적용    
     val menuFile = File("menu-file.txt").apply {
        setReadable(true)
        setWritable(true)
        setExecutable(false)  // menuFile을 안써도 됨
     // 연관 범위 (relative scoping) 혹은 수신자에 대한 암시적 호출(implicitly called)
     }
     ```
    * let : 함수의 인자로 전달된 람다를 실행한 후의 결과를 리턴해줌
     ```kotlin
     val firstItemSquared = listOf(1,2,3).first().let {
        it * it  // let을 호출한 수신자 객체를 참조할 수 있다
     }  // -> 답은 1이얌!

     fun formatGreeting(vipGuest: String?): String {
       return vipGuest?.let {
           "$vipGuest 야 앙뇽!1"   // vipGuest가 널이아니면 출력
       } ?: {
           "처음오셨나욤!"  // null이면 출력
       }  
     }
     ```
     > let 함수는 수신자 객체를 람다로 전달하고 람다의 실행결과를 반환함, apply는 람다의 실행이 끝나면 현재의 수신자 객체를 반환
     * run : 수신자 객체를 반환하지 않음, 람다의 결과를 반환 =
     ```kotlin
     val menuFile = File("menu-file.txt")
     val servesDragonsBreath = menuFile.run {
       readText().contains("Dragon's Breath")  // false 반환
     }

     fun nameIsLong(name: String) = name.length >= 20
     "hyerin".run(::nameIsLong)  // false반환
     "hyerin + 나옹 + 우리는 행보캐! 니니닝".run(::nameIsLong)  // true 반환   
  
     ```
     > 중첩해서 썼을 때 빛을 발휘하는 듯 ex) "hyerin".run(::nameIsLong).run(::createMessage).run(::println)
     * with : run과 같은 동작이지만 호출이 다름
     ```kotlin
       val nameTooLong = with("니나오~~ 니나노~~ 뱃놀이가자아아~") {
           length >= 20
       } // -> 수신자 객체가 파라미터로 전달됨 run을 권장한다고 합니다
     ```
     * also : let과 비슷하게 동작, 자신을 호출한 수신자 객체를 람다의 인자로 전달 후 `수신자 객체를`반환
     ```kotlin
     var fileContents: List<String>
     File("file.txt").also {
       print(it.name)
     }.also {
       fileContents = it.readLines()
     }  // return this; 같은 느낌이라서 연쇄호출이 가능하다고 하네양!
     ```
     * takeIf : 람다에 제공된 조건식(predicate)를 싱행한 후 그 결과에 따라 true, false 리턴
     ```kotlin
     val fileContents = File("myfile.txt")
         .takeIf { it.canRead() && it.canWrite() }  
         ?.readText()  // 조건문이 true면 file을 리턴할 테니 file을 읽는 것이로군용!
     ```     
     > 조건식의 결과가 true면 객체반환, false면 null반환
     * takeIf : false일 때 값을 반환
     ```kotlin
     val fileContents = File("myfile.txt").takeUnless { it.isHidden }?.readTest() //->그닥 권장 ㄴㄴ
     ```

#### 컬렉션
 * List
 ```kotlin
 val patronList: List<String> = listOf("태태", "망개", "슙슙")  // 읽기전용 list를 만들어 줍니다
 patronList.getOrElse(4) { "없어요 없어!!" }   // 없어요 없어 출력
 patronList.getOrNull(4) ?: "누구세요 누구!!"  // 누구세요 출력
 
 val patronList = mutableListOf("태태", "슙슙", "호비") // 수정가능한 리스트를 만들어 줍니다
 val readOnlyList = patronList.toList() // 읽기전용 리스트로 바꿔준닭!
 
 patronList.forEachIndexed { index, patron ->   // forEach를 쓰면서 인덱스도 필요할 때 오올!!
     println("안녕하세용 $patron 님! $index 번째로 도착하셨네용!!")
 }
 ```
 
 * Set
 ```kotlin
 val lastName = setOf("김", "민", "정")
 ```
 -> 코틀린에서는 Arrays 타입으로 배열을 지원. (ex. IntArray -> intArrayOf())
 
#### 클래스
 * 코틀린에서는 접근제한자를 걸지 않으면 기본으로 `public`임
    * internal : 함수나 속성이 정의된 클래스가 포함된 모듈(module)에서 사용될 수 있
 * getter, setter
    * 코틀린에서는 getter, setter가 자동 생성됨. 
    * 별도로 쓰고 싶을 경우는 get(), set(value)등의 함수를 추가해야 함
 * var, val 내부 구현
 ```kotlin
 class Student(var name: String)  // 디컴파일 해보면 ... 아래와 같다

 public final class Student {
    @NotNull
    private String name;

    @NotNull
    public final String getName() {
        return this.name;
    }   
    
    public final void setName(@NotNull String val1) {
        Intrinsics.checkParameterIsNotNull(val1, "<set-?>");
        this.name = val1;
    }  // -> var에는 set함수가 있음, val에는 없음
 }
 ```
 * internal : 같은 모듈안에 있는 클래스, 함수, 속성끼리 사용가능
 * 생성자 
 ```kotlin
 // 아래와 같이 선언하면 클래스 속성겸 생성자 매개변수로 쓸 수 있당!
 class Player (_name: String, var healthPoints: Int, val isBlessed: Boolean, private val isImmortal: Boolean) { 
 
 // 아래와 같이 생성자를 만들 수 있댱!
 constructor(name: String) : this (name,
     healthPoints = 100,
     isBlessed = true,
     isImmortal = false)
         
 }
 
 // 속성값 검사도 할 수 있다아앙!!!
 init {
     require(healthPoints > 0, { "healthPoints는 0보다 커야 해욥!" })
     require(name.isNotBlank(), { "플레이어는 이름이 있어야 행!" })
 }
 
 // 늦 초기화, 다른 코드에서 최초 사용될 때 비로소 실행되어 초기화 됨
 val hometown by lazy { selectHometown() }
 ```
 * 상속
 ```kotlin
 open class Room(val name: String) {  // 상속가능 하도록 open 키워드 추가
 
 
 
 
 open class Room(val name: String) {
     fun description() = "Room: $name"
 
     open fun load() = "아무도 여기에 오지 않았습니닭!"   // 오버라이드 할 수 있는 함수에 open 키워드를 추가한다
 }
 
 class TownSquare : Room("게링이네") {   // 상속을 받으려면 요렇게 해야 한다아.. 슈퍼클래스의 생성자가 호출되어야 해서
     override fun load() = "당신의 참여를 돈동네사람들이 환영한다구리!!"  
 }
 
  final override fun load() = "당신의 참여를 돈동네사람들이 환영한다구리!! \r\n ${ringBell()}" // 상속 못하게 막늗아아아아앗
 ```