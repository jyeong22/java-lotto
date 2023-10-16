### 기능 구현 목록

1. 구입금액 입력
    - [ ] 값이 입력되었는가
    - [ ] 숫자인가 
      * try-catch문 이용 : 01000 같은 경우는 숫자로 인식하면 안됨
    - [ ] 양수인가
    - [ ] 1000의 배수인가
    1. 올바른 값인 경우
       - [ ] 로또 수량만큼 로또 구매
    2. 올바르지 않은 값인 경우
       - [ ] IllegalArgumentException 예외 발생
2. 로또 출력
    - [ ] 수량 출력
    - [ ] 로또 수량만큼 번호 오름차순 출력
3. 당첨 번호 입력
    - [ ] 값이 입력되었는가
    - [ ] 쉼표로 구분된 값이 6개인가
    - [ ] 1부터 45사이의 숫자인가
    - [ ] 중복된 숫자가 없는가
    1. 올바른 값인 경우
       - [ ] 당첨 번호 저장
    2. 올바르지 않은 값인 경우
       - [ ] IllegalArgumentException 예외 발생
4. 보너스 번호 입력
    - [ ] 값이 입력되었는가
    - [ ] 1부터 45사이의 숫자인가
    - [ ] 당첨 번호와 중복되지 않은가
    1. 올바른 값인 경우
        - [ ] 보너스 번호 저장
    2. 올바르지 않은 값인 경우
        - [ ] IllegalArgumentException 예외 발생
5. 당첨 통계 출력
    - [ ] 당첨 내역 출력
    - [ ] 총 수익률 출력

### class별 기능 목록

## GameController (controller)
게임 전반적인 흐름을 관리하는 클래스


## Lotto (controller)
입력 받은 로또 번호 유효성 검사하고 로또 번호 저장하는 클래스

- List <Integer> lottoNumber


## PurchaseLottos (model)
구입 금액, 구매한 로또 수량, 수량만큼의 로또 리스트 저장하는 클래스

- int purchaseAmount
- int purchaseQuantity
- List <Lotto> purchaseLottoList


## WinningLotto (model)
당첨 로또 번호 유효성 검사하고 저장하는 클래스

- List <Integer> winningLottoNumber


## BonusNumber (model)
보너스 번호 유효성 검사하고 저장하는 클래스

- int number


## Statistics (model)
당첨 내역, 수익률 계산하고 저장하는 클래스


## OutputView (view)
사용자에게 출력하는 클래스


## InputView (view)
사용자로부터 입력받는 클래스

