const contenidoPrincipal= document.getElementById('dashboard');

async function cargarVista(vista){

    try{

        const respuesta= await fetch(`pages/${vista}.html`);
        const html = await respuesta.text();
        contenidoPrincipal.innerHTML=html;

    } catch(error){
        console.error('Error al cargar la vista', error);
    }



}

cargarVista('home');