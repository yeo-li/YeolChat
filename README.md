## 기능 사용 설명서

1. 로그인 기능
    1. 아이디와 비밀번호를 입력하면 사용자를 식별하여 로그인 할 수 있어야 한다.
    2. 처음 가입하는 회원이라면 회원 가입을 할 수 있어야 한다.
    3. 회원가입을 하면 로그인 후에 사용자의 정보(이름, 아이디, 비밀번호)를 변경할 수 있어야 한다.
    4. 회원은 사용자가 원하면 탈퇴할 수 있어야 한다.
    
2. 채팅 기능
    1. 사용자는 친구목록에 있는 친구들과 채팅방을 생성할 수 있어야 한다.
    2. 채팅방 안에는 친구가 아닌 사용자들이 있을 수 있다.
    3. 채팅 내용은 각 내용마다 몇 명이 읽었는지 표시되어야 한다.
    4. 채팅방에 속한 사용자는 채팅방을 나갈 수 있어야 한다.
    5. 채팅을 보낼땐, 보낸 사람과 시각이 표시되어야 한다.
    6. 채팅방에 권한이 없는 사람은 참여가 제한되어야 한다.
    7. 채팅방에서 안 읽은 채팅방은 굵은 글씨로, 몇 개의 채팅을 안 읽었는지 표시해야 한다.
    
3. 친구 추가/삭제 기능
    1. 친구의 이름 또는 아이디로 검색 및 친구추가가 가능해야한다.
    2. 친구가 되면 친구 목록에 자동으로 추가가 되어야 한다.
    3. 친구 삭제는 언제든지 가능해야 한다.
    4. 친구의 이름은 변경이 불가하다.
    
4. 관리자 기능
    1. 회원 가입한 회원 리스트를 볼 수 있어야 한다.
    2. 회원을 탈퇴시키거나 비밀번호를 초기화 해줄 수 있어야 한다.
    3. 등록되지 않은 회원을 생성할 수 있어야 한다.
    4. 관리자 권한을 다른 사람에게 넘겨줄 수 있어야 한다.

---

## @Entity(DTO)

1. User
    1. name: 사용자의 이름
    2. id: 아이디
    3. pass word: 비밀번호
    4. key: 고유 식별자
    5. grade: 등급
    
2. Message
    1. content: 메세지 내용
    2. time: 보낸 시각
    3. not reader: 읽지 않은 사람들 리스트
    
3. ChatRoom
    1. Chattings: 채팅 내용 전체
    2. roomId: 채팅방 아이디

---

## @Repository

---

## @Service

1. UserService(Impl)
    1. signUp(name, id, pw): 회원가입
    2. singIn(id, pw): 로그인
    3. deleteUser(key): 계정 탈퇴
    4. updateUserInfo(key, name, id, pw): 회원 정보 변경
    5. updateGrade(key, grade);
    
2. ChatRoomService(Impl)
    1. countReaders(): 읽은 사람 수를 세주는 함수
    2. exitChatroom(roomId, User): 채팅방 나가기
    3. addFriend(roomId, User.key): 채팅방에 친구 추가
    4. read(roomId, User.key): 사용자가 읽었다는걸 확인
    5. createChatRoom(): 채팅방 생성
    
3. MessageService(Impl)
    1. removeReader(roomId, User): 안 읽은 사람 리스트에서 이름 제거
    2. getSendTime(): 서버 시간으로 보낸 시각 반환
    3. saveChat(roomId, Message): 채팅 내용 저장
