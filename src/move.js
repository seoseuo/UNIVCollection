// 메인 버튼 클릭

var link = ["./index.html","./indexSeo.html","./indexStudy.html","./indexProject.html",
            "./indexHall.html","./indexAble.html","./indexDefy.html","./indexGrim.html",
            "./indexLog.html"]; //html 

var mainTolink = ["src/index.html","src/indexSeo.html","src/indexStudy.html","src/indexProject.html",
            "src/indexHall.html","src/indexAble.html","src/indexDefy.html","src/indexGrim.html",
            "src/indexLog.html"]; //html 


function goTo(number) {
    location.href=link[number];
}

function mainTogo(number) {
    location.href=mainTolink[number];
}

