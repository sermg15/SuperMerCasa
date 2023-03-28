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
![UML Fase 2]![SuperMerCasaDiagram](https://user-images.githubusercontent.com/79744800/228199435-c5172549-b3ae-4219-b56c-1367d7524d1b.png)


- **Capturas de pantalla**
 - Página principal: página de inicio donde se ofrecen todas las opciones al usuario, y se ofrecen las distintas categorías de productos.
  ![image](https://user-images.githubusercontent.com/104427191/228036257-356be32c-09d3-47fb-aa78-84763f53b3cd.png)
 - Categorías: página con el título de la categoría y distintos productos.
  ![image](https://user-images.githubusercontent.com/79744800/220876146-3051bdb5-b758-462f-8309-a842887d02df.png)
 - Productos: página con el nombre del producto, una fotografía, descripción, selección de la cantidad, botón para añadir al carrito, y botón para la vuelta al inicio.
  ![image](https://user-images.githubusercontent.com/104427191/228038592-41f38a51-f150-4bf2-a168-9589838107ce.png)
 - Login/Register: página para registrar y loguearse con un usuario.
  ![image](https://user-images.githubusercontent.com/104427191/228036690-02f1365b-94bc-43e7-b64e-0e97cb283d54.png)
 - Centros físicos: página que muestra tres fotografías y mapas de los distintos supermercados físicos.
  ![image](https://user-images.githubusercontent.com/104427191/228036339-1b50dad9-1616-49a3-82c7-9a3685d9bb2a.png)
 - Opciones de contacto: página con opciones de contacto como teléfono, mail, etc.
  ![image](https://user-images.githubusercontent.com/79744800/220876489-0e04834f-1995-46a7-a8f3-b9d17dd99fbc.png)
 - FAQ: página para consultar dudas frecuentes.
  ![image](https://user-images.githubusercontent.com/104427191/228036523-c4a7a93b-080a-4c80-92b7-5a84eae961b2.png)
 - Seguimiento de pedidos: página para consultar el estado del proceso del pedido y su envío.
  ![image](https://user-images.githubusercontent.com/104427191/228037971-722a4074-c6d4-4e94-92e3-e67f321a3c93.png)
 - Historial de pedidios: página en la que se consultan pedidos anteriores.
  ![image](https://user-images.githubusercontent.com/104427191/228037847-c82379a9-0ebe-418f-90c9-1ffcc21cd559.png)
 - Carrito: página con listado de productos añadidos al carrito.
  ![image](https://user-images.githubusercontent.com/104427191/228037494-9db9db55-a6ba-41ef-b956-32e612c8584b.png)
 - Ofertas: página en la que aparecen las ofertas semanales con los productos con el precio reducido
  ![image](https://user-images.githubusercontent.com/104427191/228036970-0d7ca467-bd70-4c11-ad62-0b909fdc885f.png)
 - Gestión de productos: página para poder crear productos nuevos; o modificar o borrar los ya creados.
  ![image](https://user-images.githubusercontent.com/104427191/228037289-41abe3a9-4813-45f9-9502-66b98e5c77f0.png)
 - Perfil de usuario: en la cual aparecen los datos del usuario. 
  ![image](https://user-images.githubusercontent.com/104427191/228037753-f78b6ce9-9b78-4dbd-aa44-d31b38db4ea9.png)



- **Instrucciones para desplegar la aplicación en OpenStack**:
   - Compilación: para compilar la aplicación y obtener el .jar tanto de la aplicación como del servicio interno se ha usado la opción Maven->Lifecycle->Package de IntellIJ. 
   - Subir los archivos .jar a la máquina (el de la aplicación y el del servicio interno).
   - Con la máquina desplegada, y haciendo uso del comando "scp -i 'ubicación de la clave ssh' 'ubicación del archivo a subir' ubuntu@10.100.139.249:'ubicacion a la que se sube el archivo'".

- **Configuración de la máquina para la correcta ejecución de la aplicación**:
   - Lo primero de todo es actualizar el repositorio de paquetes con el siguiente comando "sudo apt update". 
   - Hay que instalar Java 19 (ya que es el que usamos en el desarollo de nuestro proyecto). Para instalar Java usamos el comando "sudo apt install ./jdk-19_linux-x64_bin.deb".
   - Instalación de MySQL con el comando "sudo apt-get install mysql-server". También hay que instalar un paquete de seguridad para proteger la base de datos, usando el comando "sudo mysql_secure_installation".
   - Una vez instalado y configurado MySQL, debemos conectarnos al servidor de MySQL con el comando "sudo mysql" y, una vez dentro, crear la base de datos que se usará en el proyecto con el comando "CREATE DATABASE smc" ('smc' es el nombre de la base de datos que se usa en esta aplicación).
