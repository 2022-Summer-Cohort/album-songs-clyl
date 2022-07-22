export default function albumsView(campus){
    return `
        <main class="main-content">
            <section class="campus-library">
                <header class="campus-library-header">
                    <h2 class="campus-library-header__title">${album.title}</h2>
                    <h3 class="campus-library-header__recordLabel">${album.recordLabel}</h3>
                </header>
                <section class="campus-books">
                    ${
                        album.songs.map(song => {
                            return `
                                <div class="song">
                                    <h3 class="song-title">${song.title}</h3>
                                    <input type="hidden" class="sum_field" value="${song.summary}">
                                </div>
                            `
                        }).join("")
                    }
                </section>
                <div class="NewSongDiv">
                    <input type="text" placeholder="Song Name" class="songNameInput" \>
                    <input type="text" placeholder="Song Description" class="songDescriptionInput" \>
                    
                    <button class="addsongButton">Add song</button>
                </div>
                <a class="back-navigation">back to album listings</a>
            </section>
        </main>
    `
}