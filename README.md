# Microservicio saldos y movimientos de cuentas
- Repositorio: https://github.com/WilliamMolina/EjercicioEquipo6SLC

## Descripción del servicio
El servicio se encarga de consumir las APIs retrieve balance y retrieve transaction (ambas simulados en Sandbox) y exponer al consumidor, por medio de un solo request, la información obtenida de las APIs.


## Definición mensajeria
Repositorio: https://github.com/WilliamMolina/EjercicioEquipo6SLC/tree/master/Firmas
Nombre de archivos:
- SwaggerMovimientos.yml
- SwaggerSaldos.yml
- SwaggerSaldosYMovimientos.yml

## Estructura de directorios y paquetería

- ### Domain
  El "componente" Domain en el encargado de contener los paquetes
  model y usecase.

    - Model: Entidades del servicio.
    - UseCuse: Se define el que se hace en la peticion.

- ###Infraestructure
  Es el encargado de contener los paquetes de driven-adapter y entry-point.

    - Driven-adapter: Es el paquete que se comunica con todo lo externo al
      servicio, ejemplos: llamado a las APIs
    - Entry-point: Se encarga de configurar las rutas que se expondrán.

- ###Application
  Es el "componente" encargado de construir el proyecto e iniciarlo.

## Clases importantes

- ### UseCase
  Es importante tener claro que aqui es donde ocurre toda la orquestacion en cada
  una de las peticiones.

## Librerías y frameworks
- Spring Webflux: Se usa para las peticiones reactivas.
- Project-reactor : Se implementa para el uso de Mono y Flux.
- Scaffold-clean-architecture: Se utiliza para crear el proyecto base con arquitectura limpia

## Operaciones del servicio

http://localhost:8080/api/saldosymovimientos

## Configuración

Prerequisitos

    - Java 11
	- Gradle
	- Request definido en el archivo SwaggerSaldosYMovimientos.yml
    - Ejecuctar en la raiz del proyecto: ./gradlew bootRun

## Autores
- William Molina
- Maria Isabel Martinez
- Leidy Graciano
- Vanesa Castellar


## Versionamiento
    1.0