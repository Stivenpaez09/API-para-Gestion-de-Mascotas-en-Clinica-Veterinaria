API para Gestion de Mascotas en Clinica Veterinaria

Este proyecto es una API REST desarrollada con Spring Boot para gestionar mascotas y dueños en una clínica veterinaria. Implementa un modelo multicapas basado en MVC, asegurando una arquitectura modular, escalable y mantenible.

La API interactúa con la base de datos clinica_veterinaria en phpMyAdmin (MySQL) utilizando JPA con Hibernate como ORM, aplicando buenas prácticas empresariales en el diseño e implementación.

- Funcionalidades Implementadas:
  * CRUD Completo
    Mascotas: Permite crear, leer, actualizar y eliminar registros.
    Dueños: Gestión completa de información personal.

  * Consultas Avanzadas
    Obtener todas las mascotas de la especie “perro” y raza “caniche”.
    Listado combinado de Mascota y Dueño con los siguientes datos:
    - Nombre de la mascota
    - Especie
    - Raza
    - Nombre y apellido del dueño
    
  * Implementación de Buenas Prácticas
    - Modelo Multicapas (MVC): Separación de responsabilidades en Controlador, Servicio y Repositorio.
    - DTO (Data Transfer Object): Uso de objetos específicos para estructurar las respuestas de la API.
    - Anotaciones estándar de JPA y Spring Boot para garantizar eficiencia y claridad en la implementación.
    
- Tecnologías Utilizadas
  * Java 17+ - Lenguaje de programación principal.
  * Spring Boot - Framework principal para la API.
  * Spring Data JPA - Gestión de la persistencia de datos.
  * Hibernate - Implementación de ORM con JPA.
  * MySQL - Base de datos relacional para almacenamiento.
  * Maven - Gestión de dependencias.

- Arquitectura del Proyecto
  * controller: Contiene los controladores REST para manejar las solicitudes HTTP.
  * service: Implementa la lógica de negocio.
  * repository: Accede y manipula la base de datos con JPA/Hibernate.
  * model: Define las entidades Mascota y Dueño con anotaciones JPA.
  * dto: Contiene los objetos DTO utilizados para estructurar respuestas.
  
- Objetivo del Proyecto
  * Este proyecto fue desarrollado con un enfoque similar al de una empresa, aplicando buenas prácticas en arquitectura y desarrollo de APIs con Spring Boot y JPA.
  
  * Es una muestra de mis habilidades en la creación de APIs REST escalables y eficientes, listas para ser consumidas por aplicaciones web y móviles.
  
  * Este repositorio es parte de mi portafolio para demostrar experiencia en el desarrollo de software empresarial.
