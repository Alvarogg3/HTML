function showContent(arrData, div) {
        var html = []
        arrData.forEach(element => {
            html.push("<br>");
            html.push(element)
        });
        document.getElementById(div).innerHTML = html.join("");
    }

function showCards(arrData, div) {
        var num = 1;
        let inv = 0;
        var cat= 9;
        var html = [];
        arrData.forEach(element => {
            html.push(`<a class="card" href="detail.html?category=${cat}">`);
            html.push(`<div class="card__background" style="background-image: url(images/img${num}.jfif)"> </div>`);
            html.push('<div class="card__content">');
            html.push('<p class="card__category">Category</p>');
            html.push('<h3 class="card__heading"><br>');
            html.push(element);
            html.push('</h3></div> </a>');
            if (inv==1){
                if(num==1){
                    inv=0;
                }else{
                    num--;
                }
            }else{
                if(num==4){
                    inv=1;
                }else{
                    num++;
                }
            }
            cat++;
        });
        document.getElementById(div).innerHTML = html.join("");
    }

    function getQuestions() {
            var headers = {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    };
            fetch("/api/home/questions", {
                    method: 'GET',
                    headers: headers
                })
                .then(response => response.json())
                .then(data => {
                    showCards(data, "content");
                });

            console.log("End Questions");
        }

    getQuestions();


