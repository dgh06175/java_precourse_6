# 편의점

# 기능 목록

- 총구매액은 상품의 가격과 수량을 곱하여 계산한다.
- 프로모션 및 멤버십 할인 정책을 반영하여 최종 결제 금액을 산출한다.
- 구매 내역과 산출한 금액 정보를 영수증으로 출력한다.
- 영수증 출력 후 추가 구매를 진행할지 또는 종료할지를 선택할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 재입력 받는다.

### 재고 관리

- [x] 각 상품의 재고 수량을 고려하여 결제 가능 여부 확인
- [ ] 고객이 상품을 구매할 때마다 결제된 수량만큼 재고에서 차감

### 프로모션 할인

- [ ] 오늘 날짜가 프로모션 기간 내 포함된 경우 할인 적용
- [x] 프로모션은 N개 구매 시 1개 무료 증정
- [ ] 동일 상품에 여러 프로모션 적용되지 않음
- [ ] 프로모션 기간 중이면 프로모션 재고 우선 차감
- [x] 프로모션 상품을 고객이 프로모션 적용보다 적게 가져온 경우 더 가져오면 혜택 받을 수 있다고 안내
- [x] 프로모션 재고가 부족할 경우 나머지 수량은 정가로 결제

### 멤버십 할인

- [ ] 멤버십 회원은 프로모션 미적용 금액의 30% 할인 받는다
- [ ] 프로모션 적용 후 남은 금액에 대해 멤버십 할인을 적용한다.
- [ ] 멤버십 할인 한도는 8,000원

## 객체 역할

### 편의점

구매 내역 받기
구매 내역에 따라 재고 확인
구매 내역에 따라 사용자에게 물어봐야하는것 질문
사용자 대답에 따라 결제 확인 및 영수증에 추가

### 창고 CLASS

재고 초기화
재고 전체 반환
구매에 맞게 재고 차감
구매 수량 받아서 재고에 맞게 상황 알리기

### 프로모션 ENUM

프로모션 정보 초기화
제품이 프로모션 적용 되는지, 얼마나 되는지 반환

### 영수증 CLASS

초기화
구매 성공 건에 따라 내역 추가
전체 내용 반환

## 입출력 요구 사항

### 입력

- [x] 상품 목록과 행사 목록 `.md` 파일 불러오기 (수정 가능)
- [x] 구매할 상품과 수량 입력 받기
- [x] 프로모션 수량보다 적게 가져온 경우 그 수량만큼 추가 여부 입력 받기
- [x] 프로모션 재고 부족하여 일부 수량을 프로모션 혜택 없이 결제해야 하는 경우 일부 수량을 정가로 결제할지 제외할지 입력받기
- [ ] 멤버십 할인 적용 여부
- [x] 추가 구매 여부
- [x] 사용자가 잘못된 값을 입력했을 때, "[ERROR]"로 시작하는 오류 메시지와 함께 상황에 맞는 안내를 출력한다

### 출력

- [x] 환영 인사
- [x] 상품명, 가격, 프로모션 이름, 재고 안내
- [x] 프로모션 수량보다 적게 가져온 경우 혜택에 안내 메시지 출력
- [x] 프로모션 재고 부족하여 일부 수량을 프로모션 혜택 없이 결제해야 하는 경우 일부 수량을 정가로 결제할지 제외할지 안내 메시지 출력
- [ ] 멤버십 할인 적용 여부 출력
- [x] 구매 상품 내역, 증정 상품 내역, 금액 정보를 출력
- [x] 추가 구매 여부 확인 안내 문구 출력

### 영수증 출력

- 영수증 항목은 아래와 같다.
    - 구매 상품 내역: 구매한 상품명, 수량, 가격
    - 증정 상품 내역: 프로모션에 따라 무료로 제공된 증정 상품의 목록
    - 금액 정보
        - 총구매액: 구매한 상품의 총 수량과 총 금액
        - 행사할인: 프로모션에 의해 할인된 금액
        - 멤버십할인: 멤버십에 의해 추가로 할인된 금액
        - 내실돈: 최종 결제 금액

# 프로그래밍 요구사항

- [ ] indent 2까지 허용
- [ ] 메소드 한가지 일만 하도록 10줄 넘지 않도록
- [x] enum 사용
- [x] 입출력 담당하는 클래스 구현

# 리팩토링 체크리스트

- [ ] 예외 상황에 대해 고민한다
- [ ] 비즈니스 로직과 UI 로직 분리
- [ ] 로그 메세지를 위해 객체의 상태가 필요하다면 `.toString()` 사용
- [ ] 연관성이 있는 상수는 `Enum` 활용
- [ ] 인자에도 변경이 없으면 `final` 사용
- [ ] 데이터를 가지고 있는 객체가 스스로 처리할 수 있도록 구조 변경
- [ ] 필드의 수가 많으면 객체가 복잡해진다. 필드 줄이기
- [ ] 예외 케이스 테스트
- [ ] 테스트하기 어려운 랜덤값은 외부에서 주입
- [ ] private 함수를 테스트 하고 싶으면 객체 분리 고려