# 테스트 코드 목록 작성

## 단위 테스트
- (고전파 방식의 테스트 코드 작성)

baseball_oop 프로젝트 구조
- game
  - BaseBallGame
- participant
  - computer
    - Hitter
  - judgment
    - Umpire
  - player
    - Pitcher
- enums
  - ExceptionMessage
  - ReplayOrNot
- vo
  - Answer
  - Result
- Application

### BaseBallGame


### Hitter
- 메세지에 대한 처리가 잘 이루어지는지 체크

### Umpire
- 메세지에 대한 처리가 잘 이루어지는지 체크

### Pitcher
- 메세지에 대한 처리가 잘 이루어지는지 체크

### ExceptionMessage
- 불변객체이기 때문에 X

### ReplayOrNot
- 불변객체이기 때문에 X

### Answer
- 값 유효성체크하는 부분 & 같은 숫자 같은 자리 카운트하는 메서드만 테스트 코드 작성
- 랜덤한 값을 생성에 대한 테스트 코드는 그 API를 믿고 사용한 것이기 때문에 작성할 필요x
- Set으로 중복값을 제외하며 생성하는 부분도 Set이라는 자료구조를 신뢰하지 않는게 아니기 때문에 작성할 필요X

### Result
- 불견객체이기 때문에 X

### Application
- 통합테스트