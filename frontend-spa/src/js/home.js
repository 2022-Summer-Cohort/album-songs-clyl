export default function home(albums){
    return `
    <main class="main-content">
    <section class ="album-library">
    ${albums.map(album =>{
        return `
        <div class ="album">
        <h2> class="album-title">${album.title}</h2>
        <input type="hidden" class="id_field" value="${album.id}">
        <h3> class="album-recordLabel">${album.recordLabel}</h3>

        <input type="text" class="update-title" placeholder="New Album Title">
        <button class="update-button">Update Title</button>
        </div>
        `
    }).join("")
}
    </section>
    </main>
    `
}