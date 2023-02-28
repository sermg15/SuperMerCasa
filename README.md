**Nombre: SuperMerCasa**

- **Integrantes del grupo:**
   - Sergio Martínez González
   - Ignacio Sainz de la Maza Martín
   - Mario García Barrero

- **Descripción de la temática**:
  - Tienda online de un supermercado. 

- **Funcionalidad pública** (Funcionalidad para usuarios no registrados):

  - Registrarse en la web / iniciar sesión. 
  - Navegar de forma libre por la web para ver los productos, categorías y ofertas. 
  - Ver en el mapa los centros físicos. 
  - Información de contacto con la empresa.  
  - Búsqueda de productos por nombre. 

- **Funcionalidad privada** (Funcionalidades después del registro):

  - Gestionar carrito(ver carrito, añadir productos, eliminar productos, etc). 
  - Ver el historial de compras. 
  - Realizar seguimiento del pedido.
  - Admministrar perfil con información del usuario. 
  - Valorar con un método de estrellas los productos comprados.

- **Entidades principales**:

  - Usuario: Persona que usa la web y de la cual se tiene la información que dicha persona facilita (nombre, apellidos, domicilio, teléfono de contacto...).
  - Producto: Entidad que representa el producto, que almacena toda su información (categoría, precio, peso, cantidad...).
  - Carrito de compra: Listado de productos guardados pendientes de compra.
  - Pedido: Entidad que representa la lista de productos que el usuario tiene en el carrito y que ya se ha comprado. 
  - Ofertas: Promociones aplicadas a ciertos productos o categorías que van variando con el tiempo. 

- **Funcionalidades del servicio interno**:

  El servicio interno de la página realizará ciertas tareas:

    - Actualización del stock de los productos. 
    - Actualización de las ofertas cada cierto tiempo. 
    - Envío de correos de confirmación de login, pedidos realizados y nuevas ofertas. 
    - Actualización de la información de seguimiento de los pedidos. 

- **Diagrama de navegación**:
![Mapa mental](https://user-images.githubusercontent.com/104427191/216313017-6aeacfba-ecbe-4bc7-9eca-2fe28769f5d4.png)

- **Diagrama entidad-relación**:
![220427299-b4921096-acc6-4b43-a748-01882968d1e7](https://user-images.githubusercontent.com/64080266/220580722-e7f7e92c-7245-4d4a-af7e-5bee2926c37f.png)

- **Diagrama UML**:
![UML Fase 2]![SuperMerCasaDiagram](https://user-images.githubusercontent.com/79744800/221853493-8cde46da-1051-4e3f-aadc-947fb6ac973b.png)

- **Capturas de pantalla**
 - Página principal: página de inicio donde se ofrecen todas las opciones al usuario, y se ofrecen las distintas categorías de productos.
  ![image](https://user-images.githubusercontent.com/79744800/220876031-fcab4e26-b8c0-45d6-9bf9-208821caafc0.png)
 - Categorías: página con el título de la categoría y distintos productos.
  ![image](https://user-images.githubusercontent.com/79744800/220876146-3051bdb5-b758-462f-8309-a842887d02df.png)
 - Productos: página con el nombre del producto, una fotografía, descripción, selección de la cantidad, botón para añadir al carrito, y botón para la vuelta al inicio.
  ![image](https://user-images.githubusercontent.com/79744800/220876247-2aff8ce9-8451-4109-a4a2-dcd1b065a70d.png)
 - Login/Register: página para registrar y loguearse con un usuario.
  ![image](https://user-images.githubusercontent.com/79744800/220876315-4ec384a4-4de3-4637-b8c2-795b22b531f3.png)
 - Centros físicos: página que muestra tres fotografías y mapas de los distintos supermercados físicos.
  ![image](https://user-images.githubusercontent.com/79744800/220876415-08556d96-928a-4b78-8ad3-eb2c2677caa6.png)
 - Opciones de contacto: página con opciones de contacto como teléfono, mail, etc.
  ![image](https://user-images.githubusercontent.com/79744800/220876489-0e04834f-1995-46a7-a8f3-b9d17dd99fbc.png)
 - FAQ: página para consultar dudas frecuentes.
  ![image](https://user-images.githubusercontent.com/79744800/220876542-1e948e87-27db-424b-80ac-cd55383d4902.png)
 - Seguimiento de pedidos: página para consultar el estado del proceso del pedido y su envío.
  ![image](https://user-images.githubusercontent.com/79744800/220876590-dc3d3bda-eaa9-44a6-91fb-11dace74e1e6.png)
 - Historial de pedidios: página en la que se consultan pedidos anteriores.
  ![image](https://user-images.githubusercontent.com/79744800/220876640-46b9a9d3-63d6-4639-affe-49261a825fb1.png)
 - Carrito: página con listado de productos añadidos al carrito.
  ![image](https://user-images.githubusercontent.com/79744800/220876698-fa9f09fb-2c4a-492c-80f8-6bbad9018bbc.png)


