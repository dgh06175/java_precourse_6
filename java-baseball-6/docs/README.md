# 숫자 야구

## 기능 목록 (재작성)

- 게임 초기화 및 시작
    - [X] 시작 문구 출력
    - [X] 컴퓨터가 1~9 사이의 서로 다른 숫자 3개 무작위로 선택
- 사용자 입력 처리
    - [X] 사용자에게 3가지 숫자 입력 요청 문구 출력
    - [X] 입력 값 검증 후 올바르지 않을경우 예외 발생
- 게임 로직 처리
    - [x] 사용자의 입력과 컴퓨터의 숫자 비교하여 스트라이크, 볼 계산
    - [x] 결과 출력
    - [x] 3스트라이크인 경우 게임 종료 및 메세지 출력
- 게임 재시작 또는 종료
    - [x] 사용자에게 게임 재시작(1) 또는 완전한 종료(2)를 입력하도록 문구 출력
    - [x] 입력 값 검증 후 올바르지 않을경우 예외 발생
    - [x] 사용자 입력값에 따라 재시작 또는 완전한 종료

### 추가로 할 일 목록

- [x] 변수명 다듬기
- [x] 매직 넘버 상수로 변환
- [x] 테스트 코드 작성
- [x] 필요없는 로직 개선
- [x] 메소드 분리
- [x] 출력하는 UI 클래스 분리
- [x] 입력 UI 클래스 분리
- [x] 코드 리뷰 받은 것 적용하기
    - [x] 예외 상속받아서 메소드 구현 -> 이번 과제에서는 적용 필요 없었음.
    - [x] 메소드 분리하여 인덴트 1로 개선

## 주의점

- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 준수
    - 자바 코드 컨벤션은
      얼마전 [블로그](https://velog.io/@dgh06175/Java-%EA%B5%AC%EA%B8%80-JAVA-%EC%8A%A4%ED%83%80%EC%9D%BC-%EA%B0%80%EC%9D%B4%EB%93%9C-%EC%9A%94%EC%95%BD)
      에 정리했다.
    - 자바 코드 컨벤션의 .xml 파일을 다음과 같은 내용을 수정한 다음 intelliJ에 적용했다.
        - 열 제한 120
        - 줄 바꿈시 스페이스 +8

- `System.exit()` 가 아닌 로직으로 프로그램 종료하기
- `camp.nextstep.edu.missionutils` 제공 라이브러리 사용하기
    - Randoms: `pickNumberInRange()` : 랜덤 값 추출
    - Console: `readLine()` : 사용자 입력 받기

## 학습정리

### 클린 코드 규칙

1. 한 메소드에 오직 한 단계의 들여쓰기(indent)만 한다.
2. else 예약어를 쓰지 않는다.
3. 모든 원시값과 문자열을 포장한다.
4. 한 줄에 점을 하나만 찍는다.
5. 줄여쓰지 않는다(축약 금지).
6. 모든 엔티티를 작게 유지한다.
7. 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
8. 일급 컬렉션을 쓴다.
9. 게터/세터/프로퍼티를 쓰지 않는다. 단, DTO는 허용한다.
10. 메소드의 인자 수를 최대 3개만 사용한다. 적을 수록 좋다.
11. 메소드가 한가지 일만 담당하도록 구현.
12. 클래스를 작게 유지하기 위해 노력. 50줄 이상이면 여러가지 일을 동시에 하고 있을 확률이 높다.
13. 메서드당 line을 10까지만 허용. 길이가 길어지면 메서드로 분리
14. 매직 리터럴 / 매직 넘버 사용을 자제하고 상수 사용

### 리팩터링 결과

확장성을 상승시켜서 /Constant 패키지 내부의 상수 값만 바꾸면 게임 규칙이 자동으로 바뀌도록 했다.
다음과 같이 숫자 범위는 0~9, 숫자 자리수는 4, 게임 재시작 입력 문자도 바꿔봤다.
물론 테스트 코드는 작동하지 않기 때문에 요구사항의 규칙대로 다시 돌려놨다.

```
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 0123
2볼
숫자를 입력해주세요 : 4567
1스트라이크
숫자를 입력해주세요 : 8901
2볼
숫자를 입력해주세요 : 0852
4볼
숫자를 입력해주세요 : 2580
4스트라이크
4개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 C, 종료하려면 Q를 입력하세요.
C
숫자를 입력해주세요 : 2371
4스트라이크
4개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 C, 종료하려면 Q를 입력하세요.
Q
```
