// todo endpoint reference.html 가 아니라 chatting으로 만들고 싶음
// TODO window.pronmpt()가 뭔지 공부해봅시다.
var userId = window.prompt("사용자 닉네임?");

// 먼소리고....
function connect() {
    //StompConfig.java에 설정된 endpoint에 SockJS 객체, StompClient 객체 생성
    var socket = new SockJS("/chatting");
    //do Handshake
    stompClient = Stomp.over(socket); //TODO Stomp.over()는 무슨 함수인데 SockJS를 인자로 받는거지

    // connect(header,연결 성공시 콜백,에러발생시 콜백)
    stompClient.connect(
        //TODO header는 어떤걸 담당하는지
        // header
        {},

        // 연결 성공 시 콜백
        function () {
            //subscribe(subscribe url,해당 url로 메시지를 받을때마다 실행할 함수)
            sub = stompClient.subscribe('/topic/roomId', function (e) {
                //e.body에 전송된 data가 들어있다
                showMessage(JSON.parse(e .body));
            });
        },
        // 에러발생시 콜백
        function(e){
            //에러 콜백
            alert('에러발생!!!!!!');
        }
    );
}

connect();

//엔터 눌렀을때 전송 (이해 완료)
$('#msg').keypress(function(e){
    if(e.keyCode===13) send();
});


//화면에 메시지를 표시하는 함수 (이해중)
function showMessage(data){
    // class value를 지정해주기 위한 if문
    if(data.sender===userId){
        // todo jQuery는 어떤 역할을 하는 것인가?
        // TODO jQuery로 이렇게 바로 뷰어로 보낼 수 있는건가?
        $('#chatting').append("<p class='me'>"+data.sender+" : "+data.contents+"</p>");
    } else {
        $('#chatting').append("<p class='other'>"+data.sender+" : "+data.contents+"</p>");
    }
}


//메시지 브로커로 메시지 전송
function send(){
    // data 생성
    data = {
        'sender' :userId,
        'contents': $("#msg").val() // TODO val() 이 무슨 함수지
    };

    // TODO payload 공부하기
    // send(destination,헤더,페이로드)
    stompClient.send("/app/chat/send", {}, JSON.stringify(data));
    $("#msg").val('');
}
