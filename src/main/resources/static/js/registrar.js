//Registro usuarios
async function registrarUsuario(){
const request = await fecth('api/usuarios',{
method:'POST',
headers:{
'Accept':'aplication/json',
'Content-Type':'application/json'
}
});
const usuarios = await request.json();
}