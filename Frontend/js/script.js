let boton = document.getElementById("boton")
let area = document.getElementById("text-area")

boton.addEventListener("click", () => {
    boton.style.backgroundColor = "black"

    // console.log(area.value)

    fetch("http://localhost:8080/recibir", {
        method: "POST",
        body: area.value
    })
    .then(respuesta => respuesta.json())
    .then(data => {
        console.log(data)
    })
    



    // fetch("http://localhost:8080/hola")
    // .then(response => response.text)
    // .then(dato => {
    //     console.log(dato)
    // })

})