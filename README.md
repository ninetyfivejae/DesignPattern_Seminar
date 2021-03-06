# DesignPatternSeminar

## 주요 디자인 패턴을 활용한 구조화 & 모듈화 - 민현이형

- 상속과 인터페이스에 대한 이해를 높임
  모듈화와 구조화

## 상속

- 부모 클래스의 자원을 자식에게 공유하는 것
  - 코드 재활용함으로써 간소화된 클래스, 구현시 오버라이드

  - 클래스 수정, 추가에 대한 유연성 증가

  - 예를 들어 액티비티, BaseActivity를 만들어서 다른 액티비티 구현할 때 상속을 해줌
    예전에 서울시 공모전 할 때 로딩 GIF 만들 때 BaseActivity 구현을 한 것 처럼

## MVP 패턴

  - Model : Data(VO라고 생각하면 됨)
  - View : 실제 사용자가 눈으로 보고 있는 화면, UI가 변동되는 부분만 코드로 구현
  - Presenter : 기능, 실질적 기능이 동작되는 부분만 코드로 구현
  - View가 Presenter에게 눌렸다고 알려주고, 이벤트를 View로 다시 알려줌

  ==> 모듈별 작업이 가능

  서로간의 연결을 위해서 MainActivity의 initView에서는 presenter를 불러오고, MainPresenter는 initView를 불러와줌
  MainActivity는 interface View를 상속, MainPresenter는 interface Presenter를 상속 받음

- Firebase 궁극적인 목표는 서버개발자를 없애자

  Firebase 서버에서 데이터를 가져오는 것이 기능이기 때문에, Presenter클래스에서 구현
  Presenter클래스를 사용하면서 View와 독립적으로 기능을 수행할 수 있게 해줌

- DAO 클래스에서 데이터베이스 연결, 종료를 일일이 하기 힘들기 때문에 이런 작업을 BaseFirebaseDAO에서 구현을 하고 이것을 상속을 받아서 DAO 안에서 사용

## Strategy Pattern 전략 패턴

- 코드의 변화가 빈번히 발생하는 경우
- 동작은 다르지만 서로 밀접한 관계를 가지는 부분을 method가 아닌 클래스로 만들어 구현
- 예를 들어 카톡 친구목록, 채팅목록, 더보기 메뉴마다 설정 버튼을 눌렀을 때 다르게 이벤트가 일어남

## Observer Pattern 옵저버 패턴

- 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들에게 연락이 가고 자동으로 내용이 갱신되는 방식으로 일대다 의존성
- 보통의 ClickListener는 1대1 의존성의 옵저버 패턴
- 객체 지향 설계를 하다보면 객체들 사이에서 다양한 처리를 할 경우가 많은데, 한 객체의 상태가 바뀔 경우 다른 객체들에게 변경됐다고 알려주는 경우에 정말 많이 쓰이는 패턴이다.
- 서로의 정보를 넘기고 받는 과정에서 정보의 단위가 클 수록, 객체들의 규모가 클 수록, 각 객체들의 관계가 복잡한 상황에서 기능을 단순히 처리할 수 있게 만들어줄 수 있다.
- 카톡방 대화 방에 해당하는 사용자에게만 연락이 가는 것