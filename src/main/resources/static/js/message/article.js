
//버튼 const로 선언
const createBtn = document.getElementById('createBtn'); //생성버튼 (post)

createBtn.addEventListener('click', ()=>{
    fetch('/api/messages/send', {
        method : 'POST',
        headers : {
            "Content-Type" : "application/json",
        },
        body : JSON.stringify({
            roomId : 1,
            senderId : 1,
            personaId : 1,
            originalMsg : "test",
            correctedMsg : "test",
            finalMsg : document.getElementById('finalMsg').value,
            explanation : "test"
        })
    })
        .then(res => {
            if (!res.ok) throw new Error();
            return res.json();
        })
        .then(data => {
            alert('등록 완료');
        })
        .catch(() => {
            alert('전송 실패');
        });
});


