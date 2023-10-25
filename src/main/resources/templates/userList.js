
const API_URL = 'http://localhost:8080/Users'

function loadList() {
    document.getElementById('main').innerHTML = 'List User'
    axios.get(API_URL).then((res) => {
        let list = res.data;
        let str = ''
        for (let i = 0; i < list.length; i++) {
            str += `<span onclick="loadEdit(${list[i].idUser})">${list[i].name}</span><br>`
        }
        document.getElementById('main').innerHTML = str
    })
}
function loadFormAdd() {
    document.getElementById('main').innerHTML =
        '\n' +
        '<input type="text" id="name">\n' +
        '<input type="text" id="password">\n' +
        '<button onclick="save()">Save</button>'
}
function loadEdit(u){
    document.getElementById("main").innerHTML =
        '\n' +
        `<input type="hidden" value="${u}" id="idUser">\n` +
        '<input type="text" id="name">\n' +
        '<input type="text" id="password">\n' +
        '<button onclick="update()">Save</button>'
}
function save() {
    let data = {
        name: document.getElementById('name').value,
        password: document.getElementById('password').value,

    }

        axios.post(API_URL, data).then(() => {
            loadList();
        });
}
function update() {
    let data = {
        idUser: document.getElementById('idUser').value,
        name: document.getElementById('name').value,
        password: document.getElementById('password').value,

    }
    axios.post(API_URL, data).then(() => {
        loadList();
    });
}