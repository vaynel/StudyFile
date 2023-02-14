let user = JSON.parse(localStorage.getItem('user'));

let addUser= ev=>{
    if(ev.keyCode==13){
        let user={
            name : inp.value
        }
        // localStorage에 user의 이름을 저장(JSON형태로)
        localStorage.setItem('user',JSON.stringify(user));
        location.reload();
    }
}
let addTodo=ev=>{
    if(ev.keyCode==13){
        // console.dir('Todo 추가 '+inp.value)
        
        let todo = JSON.parse(localStorage.getItem('todo'));
        if(!todo){
            //todoList[0]=user , todoList[1]=todo
            let todo=[{'user' : user.name , 'todoList' : [inp.value]}]
            //key :todo ,value : todoList
            localStorage.setItem('todo',JSON.stringify(todo));
            inp.value ='';
            renderTodo();
            return;
        }
        
        //filter => Array로 반환
        let todoUser = searchUser(todo);
        console.dir(todoUser);

        //todoUser가 없다는 것은 todo에 user가 없는것
        if(!todoUser){
            let newUserTodo={'user':user.name,'todoList':[inp.value]};
            todo.push(newUserTodo);
            localStorage.setItem('todo',JSON.stringify(todo));
            inp.value ='';
            renderTodo();
            return;
        }
        
        // todo가 새로이 toduUser가 덮어써지는 것이 이해가 안됨
        todoUser['todoList'].push(inp.value);
        console.dir(todo);
        localStorage.setItem('todo',JSON.stringify(todo));
        inp.value ='';
        renderTodo();
    }
}

let LoginClass = ()=>{
     // 로그인 전
     if(!userName.innerHTML){
        LogOut.innerHTML="로그인하세요"
        let todo = JSON.parse(localStorage.getItem('todo'));
        todo.forEach((e,i)=>{
            let userlist = createElement('li',{text:`${e['user']}`})
            userlist.addEventListener('click',ev=>{
                let user={
                    name : userlist.innerHTML
                }
                localStorage.setItem('user',JSON.stringify(user));
                userName.innerHTML=userlist.innerHTML;
                renderTodo();
                location.reload();
                return;
            })
            todolists.append(userlist);
        })
        return;
    }

}


let renderTodo=()=>{
    if(!localStorage.getItem('user')) return;
    
    let todo = JSON.parse(localStorage.getItem('todo'));
    let todoUser = searchUser(todo);
    console.dir(todoUser);
    todolists.innerHTML = '';
    if(!todoUser) return;

    todoUser.todoList.forEach((e,i) => {
        let icon = createElement('i',{prop:{className:"fa-regular fa-circle-xmark"}})
        let todoText = createElement('li',{text:`  ${e}`});

        icon.addEventListener('click', ev => {
            todoUser.todoList.splice(i,1);
            localStorage.setItem('todo', JSON.stringify(todo));
            renderTodo();
        });

        todoText.append(icon);
        todolists.append(todoText);

    });
}


let setToday=()=>{
    $('#today').innerHTML='';
    let now = new Date();
    let year = now.getFullYear();
    let mon = now.getMonth()+1;
    let day = now.getDate();
    if(mon<10) mon="0"+mon;
    let today = year+"."+mon+"."+day;
    $('#today').innerHTML=today;
    // console.log(year+"년"+mon+"월"+day+"일");
}

let searchUser=todo=>{
    if(!localStorage.getItem('user')) return;

    let user = JSON.parse(localStorage.getItem('user'));
    let todoUser = todo.filter(e=>{
        return e['user'] == user.name;
    })[0];
    return todoUser;
}

let clickLogOut = LogOut.addEventListener('click',ev=>{
    console.dir("logout");
    localStorage.removeItem('user');
    location.reload();
});




// 실제 실행 구간
if(!user){
    inp.addEventListener('keyup',addUser);
}
else{
    userName.innerHTML = user.name;
    inp.placeholder = '할 일을 작성하세요.';
    inp.addEventListener('keyup',addTodo);
}

LoginClass();
setToday();
renderTodo();

