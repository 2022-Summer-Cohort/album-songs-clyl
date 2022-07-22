import home from "./home.js"
import header from "./header.js"
import footer from "./footer.js"


function makeHomeView(){
    fetch("http://localhost:8080/api/albums")
    .then(res => res.json())
    .then(albums => {
        makeHomeViewFromJSON(albums);
    })
}
function makeHomeViewFromJSON(albums){
    console.log(albums);
    container.innerHTML = header();
    container.innerHTML += home(albums);
    container.innerHTML += footer();

    const albumEL = container.querySelectorAll(".album");

    albumEL.forEach(album => {
        let albumElId = album.querySelector(".id-field");
        const albumH2 = album.querySelector(".album-title");
        albumH2.addEventListener("click", ()=>{
            albums.forEach(albumJson => {
                makeAlbumView(albumJson);
            })
        } )

        const deleteButton = album.querySelector(".delete-button");
        deleteButton.addEventListener("click", () =>{
            fetch(`http://localhost:8080/api/albums/${albumElId.value}`,{
                method: 'DELETE'
            })
            .then(res => res.json())
            .then(newAlbums =>{
                makeHomeViewFromJSON(newAlbums);
            })

        })
        const updateButton = album.querySelector(".update-button");
        updateButton.addEventListener("click", () =>{
            const updateInput = album.querySelector(".update-title");
            fetch(`http://localhost:8080/api/albums/${albumElId.value}`,{
                method: "PATCH",
                body: updateInput.value
            })
            .then(res => res.json())
            .then(newAlbums => {
                makeHomeViewFromJSON(newAlbums);
            })
        })
    })
}


fetch("http://localhost:8080/api/albums")
.then(res => res.json())
.then(albums =>{
    console.log(albums)
    const container = document.querySelector(".container")
    container.innerHTML += header();
    container.innerHtml += home(albums);
    container.innerHTML += footer();

    const albumsEl = document.querySelectorAll(".album")

    albumsEl.forEach(album =>{
        album.addEventListener("click", ()=>{
            let albumId = campus.querySelector(".id_field")
            alert(`you clicked album id: ${albumId.value}`)
        })
    })

})

