## KAMA

## Descripción del proyecto

Halloween game es un juego de aventura y acción en el que los jugadores controlan a Aiden, un joven héroe, para derrotar a las criaturas del malvado hechicero Mortis. El objetivo principal es restaurar la paz en un pueblo sumido en el caos, enfrentándose a esqueletos, fantasmas y vampiros, mientras recogen objetos mágicos y mejoras para aumentar sus habilidades.

<p align="center">
	  <img src="https://github.com/andreamsgi27/KAMA/blob/aiden4/aiden.png" width=50% height=50%/>
</p>



Este proyecto implica el desarrollo de una API que gestione las mecánicas del juego











## Herramientas utilizadas

<p align="center">
	  <img src="https://github.com/andreamsgi27/KAMA/blob/aiden4/herramientasyversiones.png" width=50% height=50%/>
</p>


## Ejecutar el Proyecto

To run app:
```bash
mvn spring-boot:run
```
## Base de datos
Nos conectamos a la consola de H2

```bash
# http://localhost:8080/h2-console
```
<p align="center">
	  <img src="https://github.com/andreamsgi27/KAMA/blob/aiden4/pantallaH2.png" width=50% height=50%/>
</p>
<p align="center">
	  <img src="https://github.com/andreamsgi27/KAMA/blob/aiden4/BaseDeDatosKAMA.png" width=50% height=50%/>
</p>


## Endpoints

Base URL: /games

 

Endpoints
1. Obtener todos los juegos
Endpoint: GET /games

Descripción: Devuelve una lista de todos los juegos en la base de datos.

Respuesta:

Código 200 OK: Retorna un array de objetos Game.

Ejemplo de respuesta:

<p align="center">
  <img src="https://github.com/andreamsgi27/KAMA/blob/aiden4/GetGames-20241107-081234 (1).png" width=50% height=50%/>
</p>

2. Crear un nuevo juego
Endpoint: POST /games

Descripción: Crea un nuevo juego en la base de datos con la información proporcionada.

Cuerpo de la solicitud (JSON):

 { "playerName": "Horse Luis", "gameCleared": true, "finalScore": 30000, "gameDate": "2024-10-14T00:00:00" }

Respuesta:

Código 201 Created: Retorna el objeto Game creado, incluyendo su id asignado.

Código 400 Bad Request: Si el cuerpo de la solicitud no cumple con los requisitos de validación.

Ejemplo de respuesta:

<p align="center">
  <img src="https://github.com/andreamsgi27/KAMA/blob/aiden4/crearnuevojuego.png" width=50% height=50%/>
</p>

3.PUT /monsters/{id}

Descripción: Actualiza los detalles de un monstruo existente mediante su ID.
Parámetro de ruta: id - ID del monstruo.
Request Body:

{ "typeMonster": "string", "monsterName": "string", "monsterDamage": "int", "monsterHealth": "int", "bonus": "int", "lifeStealingActive": "boolean", "invisibleActive": "boolean", "numSkeletons": "int" }

Response: Retorna el objeto MonsterModel actualizado.
Código de respuesta: 200 OK
Respuesta:
<p align="center">
  <img src="https://github.com/andreamsgi27/KAMA/blob/aiden4/PUTMonster.png" width=50% height=50%/>
</p>

4.- GET /monsters/{id}/is-alive

Descripción: Verifica si un monstruo específico sigue vivo.

Parámetro de ruta: id - ID del monstruo.

Response: true o false dependiendo de la salud del monstruo.
Código de respuesta: 200 OK
<p align="center">
  <img src="https://github.com/andreamsgi27/KAMA/blob/aiden4/Monstervivo.png" width=50% height=50%/>
</p>
5 PUT actualizar mochila (nombre):

localhost:8080/api/backpacks/3
{
  "name": "saco updateado"
}
<p align="center">
  <img src="https://github.com/andreamsgi27/KAMA/blob/aiden4/añadirmochila.png" width=50% height=50%/>
</p>
6 AIDEN: GET:
 Te trae toda la información de Aiden
localhost:8080/api/aiden

<p align="center">
  <img src="https://github.com/andreamsgi27/KAMA/blob/aiden4/postmanaiden.png" width=50% height=50%/>
</p>


## Diagrama UML
<p align="center">
  <img src="https://github.com/andreamsgi27/KAMA/blob/aiden4/uml.png" width=50% height=50%/>
</p>


## Estructura del Juego

A continuación se muestra una visión general de los principales directorios y archivos en el proyecto Kama



```
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
├── .mvn/wrapper/maven-wrapper.properties
├── .vscode/settings.json
└── src
    ├── main
    │   ├── java/org/factoriaf5/game
    │   │   ├── controllers
    │   │   ├── models
    │   │   ├── repositories
    │   │   └── services
    │   └── resources
    │       ├── application.properties
    │       └── data.sql
    └── test
        └── java/org/factoriaf5/game
            ├── controllers
            ├── models
            └── services

```
## Ejecucion de los test
Para asegurarte de que todo está funcionando como se espera, puedes ejecutar las pruebas unitarias e integrales incluidas en el proyecto. Usa el siguiente comando para ejecutar todas las pruebas:"

```bash
mvn test
```
<p align="center">
	  <img src="https://github.com/andreamsgi27/KAMA/blob/aiden4/image.png" width=50% height=40%/>
</p>

### Colaboradores:
<p align="center">
	  <img src="https://github.com/andreamsgi27/KAMA/blob/aiden4/colaboradores.png" width=50% height=40%/>
</p>
