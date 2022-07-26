export default function albumsView(album){
    return `
        <main class="main-content">
        <div class="album-header">
                    <h2 class="campus-library-header__title">${album.title}</h2>
                    <h3 class="campus-library-header__recordLabel">${album.recordLabel}</h3>
                    </div>
                <div class="albums-container">
                    ${
                        album.songs.map(song => {
                            return `
                                <div class="song">
                                <img class="album-cover" src="./src${album.imgUrl}">
                                <input type="hidden" class="id_field" value="${song.id}">
                                    <h3 class="song-title">${song.name}</h3>
                                    <button class="deleteSongButton">delete song</button>
                                    <input type="text" placeholder="New Song Name" class="newNameInput" \>
                                    <button class="changeNameButton">Change Song Name</button>
                                </div>
                            `
                        }).join("")
                    }
                </div>
                <div class="NewSongDiv">
                    <input type="text" placeholder="Song Name" class="songNameInput" \>
                    <input type="number" placeholder="Song Duration" class="songDurationInput" \>
                    
                    <button class="addsongButton">Add song</button>
                </div>
                <a class="back-navigation">back to album listings</a>
        </main>
    `
}