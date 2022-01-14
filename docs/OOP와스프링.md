## 좋은 객체 지향 설계의 5가지 원칙의 적용

여기서 3가지 SRP, DIP, OCP 적용

### SRP 단일 책임 원칙

* 한 클래스는 하나의 책임만 가져야 한다.
* 클라이언트 객체는 직접 구현 객체를 생성하고, 연결하고, 실행하는 다양한 책임을 가지고 있음
* SRP 단일 책임 원칙을 따르면서 관심사를 분리함
* 구현 객체를 생성하고 연결하는 책임은 `AppConfig`가 담당
* 클라이언트 객체는 실행하는 책임만 담당

### DIP 의존관계 역전 원칙
* 프로그래머는 “추상화에 의존해야지, 구체화에 의존하면 안된다.” 의존성 주입은 이 원칙을 따르는 방법 중
하나다.

### OCP 개방 폐쇄의 원칙
* 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다
* 다형성 사용하고 클라이언트가 DIP를 지킴
* 애플리케이션을 사용 영역과 구성 영역으로 나눔
* 소프트웨어 요소를 새롭게 확장해도 사용 영역의 변경은 닫혀 있다!

## 프레임워크 vs 라이브러리
* 내가 작성한 코드를 제어하고, 대신 실행하면 그것은 프레임워크
* 내가 작성한 코드가 직접 제어의 흐름을 담당한다면 라이브러리다.

### IoC 컨테이너, DI 컨테이너
* AppConfig 처럼 객체를 생성하고 관리하면서 의존관계를 연결해 주는 것을
* IoC 컨테이너 또는 DI 컨테이너라 한다.
* 의존관계 주입에 초점을 맞추어 최근에는 주로 DI 컨테이너라 한다.
* 또는 어샘블러, 오브젝트 팩토리 등으로 불리기도 한다.

## spring core docs 

* https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans

### 스프링 컨테이너 
스프링 컨테이너를 부를 때 [BeanFactory](https://docs.spring.io/spring-framework/docs/5.3.14/javadoc-api/org/springframework/beans/factory/BeanFactory.html), [ApplicationContext](https://docs.spring.io/spring-framework/docs/5.3.14/javadoc-api/org/springframework/context/ApplicationContext.html) 로 구분해서 이야기한다. 이 부분은 뒤에서 설명하겠다. BeanFactory 를 직접 사용하는 경우는 거의 없으므로 일반적으로 ApplicationContext 를 스프링 컨테이너라 한다.

* 문서를 보면, ApplicationContext는 BeanFactory의 하위 interface임을 알 수 있다. 

### 빈 이름
* 빈 이름은 메서드 이름을 사용한다. 
* 빈 이름을 직접 부여할 수 도 있다.
  * https://docs.spring.io/spring-framework/docs/5.3.14/javadoc-api/org/springframework/context/annotation/Bean.html 참고

빈 이름은 항상 다른 이름을 부여해야 한다. 같은 이름을 부여하면, 다른 빈이 무시되거나, 기존 빈을 덮어버리거나 설정에 따라 오류가 발생한다.

## 스프링 빈 조회 - 상속 관계 

* 부모 타입으로 조회 하면, 자식 타입도 함께 조회 한다. 
* `Object` 타입으로 조회하면, 모든 스프링 빈을 조회 하게 된다.