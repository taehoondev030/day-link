const deleteButton = document.getElementById('delete-btn')

if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('story-id').value;
        fetch(`/api/stories/${id}`, {
            method: 'DELETE'
        })
        .then(() => {
            alert('삭제가 완료되었습니다.');
            location.replace('/stories');
        });
    });
}


const modifyButton = document.getElementById('modify-btn');

if(modifyButton) {
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch(`/api/stories/${id}`, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
        .then(() => {
            alert('수정이 완료되었습니다.');
            location.replace(`/stories/${id}`);
        });
    });
}


const createButton = document.getElementById("create-btn")

if (createButton) {
    createButton.addEventListener("click", (event) => {
        fetch("/api/stories", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById("title").value,
                content: document.getElementById("content").value,
            }),
        }). then(() => {
            alert("등록 완료되었습니다.");
            location.replace("/stories");
        });
    });
}