# Instrucciones para que funciones con jenkins

## Instalación de Selenium GRID

<code>docker network create grid</code>

<code> docker run --name segrid -d -p 4444:4444 -p 7900:7900 --shm-size="2g" --net grid selenium/standalone-chrome:4.1.2-20220317 </code>

Luego conectar el segrid a la red de jenkins

<code>docker network connect "tu-red-jenkins" segrid</code>

Con eso y la ejecucion debiera funcionar.
