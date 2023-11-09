/**
 *  Utforer Klient validering av felter
 */

function validateForm() {
    var fornavn = document.forms["signupForm"]["fornavn"].value;
    var etternavn = document.forms["signupForm"]["etternavn"].value;
    var mobil = document.forms["signupForm"]["mobil"].value;

    var lettersOnly = /^[A-Za-z]+$/;
    var numbersOnly = /^\d+$/;

    if (!fornavn.match(lettersOnly)) {
        alert("Fornavn burde bare inneholde bokstaver");
        return false;
    }

    if (!etternavn.match(lettersOnly)) {
        alert("Etternavn burde bare inneholde bokstaver");
        return false;
    }

    if (!mobil.match(numbersOnly)) {
        alert("Mobil burde bare inneholde tall");
        return false;
    }

    var kjonnKnapp = document.forms["signupForm"]["kjonn"];
    var kjonnValgt = false;

    for (var i = 0; i < kjonnKnapp.length; i++) {
        if (kjonnKnapp[i].checked) {
            kjonnValgt = true;
            break;
        }
    }

    if (!kjonnValgt) {
        alert("Vennligst velg skjonn.");
        return false;
    }
}