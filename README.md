[![Università degli studi di Firenze](https://i.imgur.com/1NmBfH0.png)](https://ingegneria.unifi.it)

Made by [Mattia Marilli](https://github.com/mattiamarilli) and [Giacomo Ponzuoli](https://github.com/jackponzo)

 - Adminer available on port **8080** if you run the project in devmode

### Requirement
 - Docker (Version 4.10.1 or latest)
 - GNU Make (Version 3.81 or latest)
 
### To make it work

> BUILD the container with the database
```sh
$ make build
```
> RUN the container with the database
```sh
$ make up
```
> MAKE SCHEMAS with
```sh
$ make db
```
> INSERT TEST DATA with
```sh
$ make data
```
> DOWN the container with the database
```sh
$ make down
```
