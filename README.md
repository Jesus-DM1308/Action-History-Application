

<center> <h1> UNIVERSIDAD AUTÓNOMA DE SINALOA </h1></center>
<center> <h2>FACULTAD DE INFORMATICA</h2> </center> 
<img width="277" height="300" alt="Logotipo de la Universidad Autonoma de Sinaloa" src="https://github.com/user-attachments/assets/4bb536bb-6586-4ee6-bb12-2626d1564bd2" />

<img width="277" height="94" alt="Logotipo de la Facultad de Informatica Culiacan" src="https://github.com/user-attachments/assets/e026f90a-af29-46ca-8892-a491292702bf" />




NOMBRE DEL DOCENTE: MONTAÑO ARAUJO ALEXIS MOISÉS

NOMBRE DEL ALUMNO: DIAZ MARTÍNEZ JESÚS RAMON
### MATERIA: COMPUTO MOVIL
### ACTIVIDAD 3. Historial de acciones
### TURNO: VESPERTINO
### GRUPO: 04
<br>
<br>
<br>

*Culiacán, Sinaloa, a 14 de diciembre de 2025.* 



## Breve Descripcion

Se realizo un historial de acciones, reutilizando el proyecto *"CRUD con Room (https://github.com/Jesus-DM1308/Action-History-Application.git)"* como proyecto base para implementar este sistema de historial de acciones, en este caso trabajaremos con tareas, cada modificacion que se le haga una tarea, ya sea crear, editar, borrar, etc. Se vera reflejada en este historial de acciones.



## Instrucciones de instalacion y ejecucion

### ¿Necesito algun requisito para usar la app de este repositorio?

Practicamente no se necesita instalar nada, solamente se clona el repositorio de la siguiente forma:

- Primero accede a tu explorador de archivos, en la carpeta de descargas o downloads.
- En la parte superior (nav) se encuentra un buscador en el que haras click y escribiras "cmd". Si no ubicas el buscador, la imagen podria serte de ayuda (Windows 11)

  <img width="958" height="41" alt="image" src="https://github.com/user-attachments/assets/b8b08adc-c0ae-4d95-9d97-3a765d78dc2e" />

- Al escribir "cmd" te debio abrir un Simbolo de sistema, es decir, una pantalla en negro, simplemente copia el siguiente comando:
*git clone "https://github.com/Jesus-DM1308/Action-History-Application.git"*
y pegalo en en la pantalla negra, a continuacion se descargaran todos los archivos necesarios para ejecutar el programa. Se necesitara Android Studio para poder ejecutar este programa.


### ¿Como puedo instalar Room en mi proyecto?
Si piensas hacer desde cero tu propio poryecto con Room, entonces las instrucciones serian las siguientes:


#### Instalar Room: 
Como tal Room no se encuentra incluido en el gradle de tu proyecto, ya que es una base de datos local, por lo que necesita implementarlo, versionarlo y incluir sus librerias.
Asi que lo primero es acceder a los Gradle Scripts y entrar a la tarea ***build.gradle.kts(Module:app)*** y incluir una implementacion y una annotationProcessor, que son los siguientes:
   
    
    ~~~
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler.v261)
    ~~~

    
Despues se va acceder en Gradle Scripts a un archivo nombrado como ***libs.versions.toml*** para agregar las versiones y las librerias de esta forma:

    ~~~
    [versions]
    room = "2.8.4"
    roomCompiler = "2.8.4"

    [libraries]
    androidx-room-compiler-v261 = { module = "androidx.room:room-compiler", version.ref = "roomCompiler" }
    androidx-room-runtime = { module = "androidx.room:room-runtime", version.ref = "room" }
    ~~~
**NOTA: Las versiones pueden variar, estas versiones y librerias fueron utilizada como ultima vez el 14 de Diciembre de 2025.**


Y con esto ya tienes lo necesario para trabajar con Room.


## Estructura de la base de datos

Es solamente la base de datos db:task_manager_db y se trabajaran con dos tablas, una de tareas y la otra de las acciones:

|         Task        |
|---------------------|        
| task_title          |        
| task_description    |        
| created_at          |        
| is_completed        |        

|       History       |
|---------------------|
| history_id          |
| action              |
| created_at          |
| details             |



## Capturas de pantalla de las interfaces de usuario

#### Pantalla principal: 
Lista de acciones, aqui se muestran todas las acciones realizadas, en la parte inferior de la pantalla se encuentra un boton para acceder al historial de acciones.

<img width="270" height="600" alt="image" src="https://github.com/user-attachments/assets/3bcff0b2-b945-47ac-9bdd-6b7f0f4ab6d6" />

### Funcionamiento

Cada vez que se crea, modifique o elimine una tarea, la accion se crea automaticamente y se guarda.

#### insert_task:
https://github.com/user-attachments/assets/a3c7a98f-22cf-4806-ae93-b4532e7e7e1b

<video width="320" height="240" controls>
  <source src="https://github.com/user-attachments/assets/a3c7a98f-22cf-4806-ae93-b4532e7e7e1b" type="video/mp4">
</video>


#### update_task:
https://github.com/user-attachments/assets/d126a1a0-29a5-43d5-b060-85d891e97a38

<video width="320" height="240" controls>
  <source src="https://github.com/user-attachments/assets/d126a1a0-29a5-43d5-b060-85d891e97a38" type="video/mp4">
</video>


#### delete_task:
https://github.com/user-attachments/assets/373c3740-8900-4736-b8d5-0bfb1c80664b

<video width="320" height="240" controls>
  <source src="https://github.com/user-attachments/assets/373c3740-8900-4736-b8d5-0bfb1c80664b" type="video/mp4">
</video>
