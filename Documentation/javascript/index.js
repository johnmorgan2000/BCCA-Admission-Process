const mainDiv = document.getElementById("main");

function renderCodeDocs(){
    var source = document.getElementById("codeDoc").innerHTML;
    var template = Handlebars.compile(source);
    var context = {
        data: DATA
    };

    var html = template(context);
    mainDiv.innerHTML = "";
    mainDiv.insertAdjacentHTML("beforeend", html);
}

function renderHome(){
    var source = document.getElementById("home").innerHTML;
    var template = Handlebars.compile(source);

    var html = template();
    mainDiv.innerHTML="";
    mainDiv.insertAdjacentHTML("beforeend", html);
}

function renderUseApp(){
    var source = document.getElementById("useApp").innerHTML;
    var template = Handlebars.compile(source);

    var html = template();
    mainDiv.innerHTML="";
    mainDiv.insertAdjacentHTML("beforeend", html);
}

function renderAbout(){
    var source = document.getElementById("about").innerHTML;
    var template = Handlebars.compile(source);

    var html = template();
    mainDiv.innerHTML="";
    mainDiv.insertAdjacentHTML("beforeend", html);
}



renderHome();
