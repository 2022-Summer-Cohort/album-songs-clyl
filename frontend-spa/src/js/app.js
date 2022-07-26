import home from "./home.js"
import header from "./header.js"
import footer from "./footer.js"
import albumsView from "./albumsView.js";

const container = document.querySelector(".container");
function makeHomeView(){
    fetch(`http://localhost:8080/api/albums`)
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

    const albumEl = container.querySelectorAll(".album");

    albumEl.forEach(album => {
        let albumElId = album.querySelector(".id_field");
        const albumCover = album.querySelector(".album-cover");
        albumCover.addEventListener("click", () =>{
            // albums.forEach(albumJson => {
            //     makeAlbumView(albumJson)
            // })
            fetch(`http://localhost:8080/api/albums/${albumElId.value}`)
            .then(res => res.json())
            .then(album =>{
                makeAlbumView(album);
            })
        })
    // const deleteButton = album.querySelector(".delete-button");
    // deleteButton.addEventListener("click", () => {
    //     fetch(`http://localhost:8080/api.albums/${albumElId.value}`, {
    //         method: 'DELETE'
    //     })
    //     .then(res => res.json())
    //     .then(newAlbums => {
    //         makeHomeViewFromJSON(newAlbums);
    //     })
    // })
    const updateButton = album.querySelector(".update-button");
    updateButton.addEventListener("click", () => {
        const updateInput = album.querySelector(".update-title");
        fetch(`http://localhost:8080/api/albums/${albumElId.value}/title`,{
            method: 'PATCH',
            body: updateInput.value
        })
       .then(res => res.json())
       .then(newAlbums => {
            makeHomeViewFromJSON(newAlbums);
       })
    })
})
}
function makeAlbumView(album) {
        console.log(album);
        container.innerHTML = header();
        container.innerHTML += albumsView(album);
        container.innerHTML += footer();

        const songElement = document.querySelectorAll(".song");

        // songElement.forEach(song=>{
        //     song.addEventListener("click",()=>{
        //         let songSum = song.querySelector(".sum_field");
        //         alert(songSum.value);
        //     })
        // })

        const backButton = document.querySelector(".back-navigation");
        backButton.addEventListener("click",()=>{
            makeHomeView();
        })

        const songNameIn = container.querySelector(".songNameInput");
        const songSumIn = container.querySelector(".songDescriptionInput");
        const addSongButton = container.querySelector(".addSongButton");

        // addSongButton.addEventListener("click",()=>{
        //     const newSongJson = {
        //         "title": songNameIn.value,
        //         "recordLabel": songSumIn.value,
        //     }
        //     fetch(`http://localhost:8080/api/albums/${album.id}/addSong`,{
        //         method: 'POST',
        //         headers: {
        //             'Content-Type': 'application/json'
        //         },
        //         body: JSON.stringify(newSongJson)
        //     })
        //     .then(res => res.json())
        //     .then(albums => {
        //         makeAlbumView(albums.id);
        //     })
        // })
}

makeHomeView()