# Proyecto: Gestión de Facturas con JPA

Este proyecto está implementado utilizando **Java Persistence API (JPA)**, que permite el mapeo de clases a tablas de una base de datos relacional. A continuación se describe el modelo de clases y cómo se relacionan las entidades.

## Modelo de Clases

### 1. Entidades principales

El proyecto contiene las siguientes entidades:

- **Categoría**: Representa una categoría de artículos.
  - Atributos:
    - `denominacion` (String): Nombre de la categoría.
    - `id` (Long): Identificador único.

- **Artículo**: Representa un artículo o producto que puede ser facturado.
  - Atributos:
    - `cantidad` (int): Cantidad disponible del artículo.
    - `denominacion` (String): Nombre del artículo.
    - `id` (Long): Identificador único del artículo.
    - `precio` (int): Precio del artículo.
  - Relación:
    - Muchas instancias de **Artículo** pertenecen a una **Categoría** (`@ManyToOne`).

- **Factura**: Representa una factura emitida a un cliente.
  - Atributos:
    - `fecha` (String): Fecha en la que se emitió la factura.
    - `id` (Long): Identificador único de la factura.
    - `numero` (int): Número de la factura.
    - `total` (int): Total de la factura.
  - Relación:
    - Una **Factura** puede tener múltiples **DetalleFactura** (`@OneToMany`).
    - Una **Factura** está asociada con un único **Cliente** (`@ManyToOne`).

- **DetalleFactura**: Representa el detalle de los artículos en una factura.
  - Atributos:
    - `cantidad` (int): Cantidad de artículos facturados.
    - `id` (Long): Identificador único del detalle de la factura.
    - `subtotal` (int): Subtotal del artículo en el detalle.
  - Relación:
    - Muchos **DetalleFactura** pertenecen a una única **Factura** (`@ManyToOne`).
    - Cada **DetalleFactura** está asociado con un único **Artículo** (`@ManyToOne`).

- **Cliente**: Representa a un cliente que puede tener una o varias facturas.
  - Atributos:
    - `apellido` (String): Apellido del cliente.
    - `dni` (int): Número de documento del cliente.
    - `id` (Long): Identificador único del cliente.
    - `nombre` (String): Nombre del cliente.
  - Relación:
    - Un **Cliente** tiene un único **Domicilio** (`@OneToOne`).

## Relación entre Entidades

El diagrama de clases adjunto muestra cómo estas entidades están relacionadas entre sí:

- **Cliente** tiene una relación de uno a uno con **Domicilio**.
- **Cliente** tiene una relación de uno a muchos con **Factura**.
- **Factura** tiene una relación de uno a muchos con **DetalleFactura**.
- **DetalleFactura** tiene una relación de muchos a uno con **Artículo**.
- **Artículo** tiene una relación de muchos a uno con **Categoría**.

## Auditoría con Hibernate Envers

El proyecto utiliza **Hibernate Envers** para auditar los cambios realizados en todas las entidades. Esto permite mantener un historial de las modificaciones en las tablas, registrando las operaciones de creación, actualización y eliminación. Se han configurado revisiones para todas las entidades del proyecto, lo que proporciona trazabilidad completa de los datos.

## Tecnologías utilizadas

- **Java**: Lenguaje de programación principal.
- **JPA**: Para el mapeo objeto-relacional.
- **Hibernate**: Implementación de JPA utilizada.
- **Hibernate Envers**: Para auditoría de entidades.
- **MySQL/PostgreSQL** (o cualquier otra base de datos relacional): Como sistema de gestión de bases de datos.

## Cómo ejecutar el proyecto

Descargar en el archivo en .zip, extraerlo y abrilo con java intelligent
