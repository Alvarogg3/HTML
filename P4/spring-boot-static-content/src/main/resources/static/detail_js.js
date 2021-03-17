showQuestions();

function showQuestions() {

    const dir = window.location.search;
    var s = dir.split("=");
    var num = s[1];

    fetch(`https://opentdb.com/api.php?amount=20&category=${num}`, {
      headers: {
        Accept: 'application/json'
      },
      method: 'GET'
    })
      .then(res => {
        console.log("Response here")
        return res.json()
      })
      .then(r => {
        results = r.results;
        console.log("Updating cards" + results);
        shResults(results, "add");
      })
      .catch(e => {
        console.error("Error " + e)
      })
    return false;
}

function shResults(data, div) {
    data.forEach(element => {
        document.getElementById(div).innerHTML += `<br><br><h5 class="card-title mt-3">${element.question}</h5>`
            + "<br>"
            + `<label id='correct' class="text-white-50  mt-2 mb-5">${element.correct_answer}</label>`
            + allAnswers(element)
            + '<hr>';
    });
}

function allAnswers(question) {
    var a = "";
    for (var i = 0; i < question.incorrect_answers.length; i += 1) {
        a += `&emsp;&emsp;<label class="text-white-50 mt-2 mb-5">${question.incorrect_answers[i]}</label>`;
    }
    return a;
}

