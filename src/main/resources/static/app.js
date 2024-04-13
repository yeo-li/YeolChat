const userId = window.prompt("이름을 입력해주세요");

function connect() {
    var socket = new SockJS("/chatting");
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function() {
            sub = stompClient.subscribe('/topic/roomId', function (e) {
                showMessage(JSON.parse(e.body));
            });
        }, function (e){
            alert('error!');
        }
    );
}

connect();

$('#msg').keypress(function(e){
    if(e.keyCode === 13) send();
});

function showMessage(data) {
    $('#chatting').append(`<p>{sender: ${data.sender}, message: ${data.message}, sendTime: ${data.sendTime}}</p>`);
}

function send() {
    function getFormatTime(date) {
        let hh = date.getHours();
        hh = hh >= 10 ? hh : '0' + hh;
        let mm = date.getMinutes();
        mm = mm >= 10 ? mm : '0' + mm;

        return hh + ':' + mm;
    }

    const sendTime = getFormatTime(new Date());

    data = {
        'sender' : userId,
        'message' : $('#msg').val(),
        'sendTime' : sendTime
    };
    stompClient.send("/app/chat/send", {}, JSON.stringify(data));
    $('#msg').val('');
}





