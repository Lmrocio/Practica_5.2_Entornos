# PRÁCTICA 5.2.

<details> 
 <summary>DIAGRAMA UML</summary>
 
<br> 
  <details><summary>Requisitos del diagrama</summary>

  <br>
  
   Para diseñar un sistema que gestione los pedidos de mi empresa, es necesario considerar los siguientes requerimientos:

>- Los pedidos los realizan los clientes, y pueden contener uno o varios productos.
> 
>- Debe registrar la información de cada pedido, incluyendo la fecha en que se realizó.
> 
>- Estos productos deben estar registrados en el sistema junto con su información correspondiente (nombre, descripción, precio, impuestos, etc.).
> 
>- El sistema debe ser capaz de calcular el coste total de cada pedido, teniendo en cuenta la cantidad de cada producto incluido en el pedido, sus precios individuales y los impuestos correspondientes.
> 
>- Debe haber un registro actualizado del stock de cada producto, de forma que se pueda informar al cliente si habrá algún retraso en la entrega debido a falta de stock.
> 
>- Cada pedido puede ser pagado de una sola vez o en varios pagos.
> 
>- Se debe ser capaz de registrar la información de cada pago realizado por el cliente.
> 
>- Las formas de pago aceptadas por el sistema son: Card (número, fecha de caducidad y tipo de tarjeta), Cash  (Tipo de moneda) y cheque (nombre y banco).
> 
>- Cada pedido puede estar en uno de los siguientes estados: pdte, pgdo, pcdo, envdo, entgdo. El estado de cada pedido debe ser actualizado en el sistema en función de su evolución.

  </details>

![image](https://github.com/user-attachments/assets/23d9e371-5ab4-48d4-9a5d-55e724aced2a)

</details>

<hr>

### a) Una breve lista de los conceptos que te has encontrado en los diagramas UML que se asemejan a los conceptos de programación orientada a objetos. Por ejemplo: Clases: GestorPedidos

- Clases: represetan las partes de la transacción que queremos recoger en el sistema.
  - Cliente, es una clase que representa a los clientes que realizan los pedidos, es decir, a las intancias de tipo Cliente cuya información queremos almacenar (atributos) y que poseen unos comportamientos o métodos que son las gestiones necesarias para realizar un pedido.
  - Pedido, es una clase que representa los pedidos que pueden realizarse por los clientes, es decir, es una instancia, un objeto de tipo Pedido que almacena la información necesaria sobre la compra que realizan los clientes, así como posee unos métodos que son las operaciones necesarias para dicha compra.
  - Producto, es una clase que representa a los productos que pueden ser parte de un pedido, son, por tanto, los objetos de tipo Producto que almacenan los datos de cada producto que puede comprar un cliente. También poseen sus propios métodos, necesario para la gestión de la compra.
  - Pago, es una clase que representa los pagos que pueden realizarse para un mismo pedido, es decir, son los métodos necesarios, así como los datos de interes sobre dichos plazos y formas de pago.
  - Fecha, es una clase que recoge el día, mes y año de una fecha en concreto, teniendo, a su vez, un método o comportamiento de la clase que verifique que dicha fecha sea válida.

- Atributos: representan, dentro de cada clase, la información que queremos almacenar de cada parte de la gestión de una compra. Son variables que, en algunos casos, pueden modificar su valor mediente actualizaciones. Algunos ejemplos de los atributos son:
   - Email, dentro de la clase Cliente tenemos dicho atributo para almacenar el correo del usuario para poder tramitar su pedido e informarle de las actualizaciones.
   - Stock, dentro de la clase Producto para almacenar la cantidad existente de ese producto determinado y, mediante los métodos, comprobar si el pedido puede ser realizado.
  
- Métodos: se tratan del comportamiento o funciones necesarias, dentro de cada clase, para que la realización de un pedido pueda ser llevada a cabo. Algunos ejemplos:

- Herencia: podríamos hablar de herencia en la clase de FormaPago si no fuera un enum, sino una clase abstracta, ya que contaría con las subclases de Card, Cash y Cheque, las cuales heredarían de la clase FormaPago una interfaz común, aunque permitiendo que tengan sus propias implementación específica.

- Enumeración: lo encontramos tanto en FormaPago como en EstadoPedido, los cuales tiene predefinido unos valores concretos que son los únicos que puede tomar la clase.

- Relaciones entre clases: las relaciones entre las clases pueden ser de asociación, agregación o composición, y nos hablan de cómo se relaciona la información y se conectan los métodos en el sistemas que estamos definiendo.
  - Cliente y Pedido, un cliente puede realizar muchos pedidos, pero un pedido sólo puede estar asociado a un cliente. Con esto sabemos la multiplicidad de la relación y el tipo, en este caso de agregación, ya que pedidos se agregan a un cliente determinado.
  - Pedido y Producto, un pedido puede contar con uno o varios productos, y un producto puede aparecer en uno o varios pedidos. En este caso el tipo de relación es de composición.
  - Pedido y Pago, un pedido puede tener varios pagos registrados, y un pago está asociado a un sólo pedido. En este caso, la relación es de tipo asociación.

<hr>

## b) Explicación de la herramienta que has utilizado parra generar el diagrama UML, y si la has contrastado con otra y conclusiones de porque has elegido esa.

He utilizado Lucidchart para generar el diagrama UML de mi sistema. Lucidchart es una herramienta en línea basada en la web que permite crear diagramas de todo tipo, incluyendo diagramas UML. Es ampliamente utilizada debido a su interfaz intuitiva, sus múltiples plantillas y su capacidad para colaborar en tiempo real.

Lucidchart ofrece una amplia gama de formas predefinidas para diagramas UML, lo que facilita la creación de diagramas estructurados de clases, secuencias, actividades, etc. Además, permite personalizar los diagramas según las necesidades del proyecto, lo que lo hace muy flexible. Características principales de Lucidchart que utilicé:
- Plantillas y formas UML: Lucidchart proporciona plantillas específicas para diagramas UML, como clases, objetos, relaciones de herencia, asociaciones, etc. Esto hace que sea más fácil estructurar y crear un diagrama limpio y bien organizado.
- Interfaz intuitiva: La herramienta es bastante fácil de usar, incluso para aquellos que no tienen mucha experiencia en diseño de diagramas. Se pueden arrastrar y soltar las formas, agregar texto y conectar las clases sin complicaciones.
- Colaboración en tiempo real: Lucidchart permite compartir y colaborar en el diagrama con otros miembros del equipo o personas, lo que es útil en proyectos en grupo o cuando se requieren comentarios de otras personas.
- Exportación: Una vez terminado el diagrama, es posible exportarlo en varios formatos (como PNG, JPEG, PDF o incluso en formato de archivo de Lucidchart) para incluirlo en informes o presentaciones.

Elegí Lucidchart por su interfaz intuitiva, plantillas UML predefinidas, y capacidades de colaboración en tiempo real, lo que hizo que el proceso de diseño fuera más sencillo y eficiente. Exsiten herramientas como draw.io y StarUML que son muy útiles; no obstante, la facilidad de uso que Lucidchart ofrece para la creación y exportación de diagramas me hicieron elegirla para este trabajo.

<hr>

## c) Una explicación sobre la conversión del diagrama UML al código.

Para convertir el diagrama UML a código en Kotlin, he mantenido la estructura básica planteada en el diagrama, adaptándola a las características del lenguaje de programación. Las clases del diagrama UML se han transformado en clases de objetos en Kotlin, donde se almacenan los atributos que representan los datos clave del sistema, y las funciones necesarias para las operaciones del sistema, como las relacionadas con el proceso de compra, se han convertido en métodos dentro de cada clase. Las relaciones que se reflejan en el diagrama indican cómo se comunican las clases y cómo se pasan los atributos de una clase a otra cuando es necesario.

En cuanto a la clase FormaPago, originalmente se pensé en utilizar herencia, pero se opté por un enum para simplificar la implementación. Cada tipo de pago (como CARD, CASH y CHEQUE) tiene su propia implementación de la función realizarVerificacion(), lo que es un claro ejemplo de polimorfismo, ya que la verificación se realiza de forma diferente según el tipo de pago. En resumen, la conversión del diagrama UML al código Kotlin se ha hecho manteniendo su estructura y alineándola con los principios de la programación orientada a objetos. Los métodos se implementaron siguiendo las funcionalidades definidas en el diagrama, y las relaciones entre clases se reflejan mediante el uso de listas y referencias. De este modo, el código en Kotlin mantiene la fidelidad al diseño UML, lo que facilita tanto la comprensión como el mantenimiento del sistema.

Enlace al código --> 
![código](https://github.com/Lmrocio/Practica_5.2_Entornos/blob/main/Main.kt)
