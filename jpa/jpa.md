# JPA

#### ORM을 쓰면?
 * 객체지향 프로그래밍이 가능
 * 코드 재사용 가능
 * 비지니스 로직 및 테스트 용이

#### ORM? (Object Relation Mapping)
 > 맵핑 정보를 기술한 메타데이터를 기반으로 자바의 객체를 SQL Table과 연결해줌.
 ex) @Table, @Entity


#### Entity의 상태?
* transient : JPA(하이버네이트)가 객체들에 대해 전혀 모르는 상태 ex) Obejct test = new Obejct();
* persistent : JPA가 알고 관리하게 되는 상태. ex) entityManager.save(test); # persistContext에 넣은 상태, 캐시된 상태
  * 이때는 더티체킹, write behind등의 관리를 해줌. <br/>
   * 더티체킹 : 객체의 변경 사항을 감지
   *  write behind : 객체의 상태변화를 DB에 최대한 늦게, 필요한 시점에 적용하려는 것 ==> insert등의 연산이 비용이 크기 때문)
* detached : 트랜잭션이 끝나고 세션밖으로 나올 때 ex) entityManager가 관리하는 상태였지만 다른 클래스(Service class)등에서 return등의 형태로 받아 쓰는 상태. 세션이 끝났기 때문에 JPA가 관리해주지 않는다.
* removed : JPA가 관리하긴 하지만 삭제하기로 한 상태


#### Cascade?
 * 객체의 상태변화를 전이시킴 <br/>
  ~~ ex) 회사객체가 사라지자 직원 객체들도 사라졌다... ~~ <br/>
  어떤 객체가 다른 객체의 상태에 영향을 끼칠 때 사용하는 것 같다!


#### 연관관계?
 JPA에서는 최대 2개의 엔티티끼리의 관계만 있음.
  * OneToMany : 1:N
  * ManyToOne : N:1
  * ManyToMany : N:M <br/>

양방향 연관관계는 mappedby를 적어서 표시  <br/>
 ex) ManyToOne과 OneToMany가 있다면 OneToMany쪽에 mappedby를 적어줘야 함( 기본적으로는 외래키를 가진쪽이 오너 ) <br/>
 : N+1 문제가 발생할 수 있다. = 하나의 객체를 가져오고 거기서 쓰는 collection을 순회하면서 하나하나 데려오는 문제.

#### Fetch?
 * 연관관계에 있는 엔티티들을 어떻게 가져올 것인가에 대한 설정 == 성능에 영향을 끼침.
 * Eager : 즉시로딩 (@ManyToOne)
 * Lazy : 지연로딩 (@OneToMany)

#### QueryDSL?
 * 조건문을 작성할 때 type safe 함.
   쿼리용 domain specific language를 만들어줌

## Spring Data JPA
##### @NoRepositorybean
spring data jpa 혹은 다른게 CrudRepository 빈을 만들어서 등록하지 않도록 하기 위한 어노테이션 (실제 리파지토리가 아님을 표시함)

##### @DataJpaTest
@DataJpaTest 어노테이션은 기본적으로 rollback인데
rollback하고 싶지 않으면 @Rollback(false)를 넣자!
(H2 라이브러리를 추가했다면 Test는 H2에서 동작)

##### JPA Test시 유의할 점
@Test 할 때의 기본정책이 rollback이니, repository.delete()해도 동작하지 않는다. '어차피 rollback에서 지워질건데 뭐하러 내가 지움?' 이런느낌이다. 그래도 delete를 테스트하려면 repository.flush()를 호출하면 된다.

##### @RepositoryDefinition
나의 Custom repository를 만들 수 있다.
