# retoddd
Reto DDD

#Modelo de dominio en draw.io

https://drive.google.com/file/d/1yp5zPqpUt0Lft0C3sFTmWep1UqlfWxKn/view?usp=sharing

#Explicacion del problema

Se plantea el desarrollo mediante DDD donde el dominio es el proceso de reparación en un taller de reparación de vehículos. El taller cuenta con tres áreas que son: atención al cliente, área de mecánica y área de ventas.

1) Registro: En este paso un asesor recibe al cliente y le toma sus datos los cuales son registrados, luego le toma los datos del vehículo, le pide que firme una autorización en la que acepta que le reparemos su vehículo y se detalla si el trabajo a realizar es una reparación o una garantía de una reparación anterior. Por último se registra el ingreso del trabajo para que un mecánico lo inicie.

2) Reparación: En esta etapa un mecánico se le asigna al cliente y/o a la orden registrada, el mecánico ejecuta una inspección del vehículo inicial para determinar cuál es la falla de este, que repuestos y elementos requiere, luego registra el tipo de trabajo a realizar(reparación o garantía) y por último registra el trabajo cuando lo finalice.

3) Entrega: En esta etapa un vendedor se le asigna al cliente, el vendedor determina cuál es el costo total, de la reparación más los repuestos utilizados, los repuestos se registran como compras, ya que se adquieren a un proveedor externo, luego se genera una orden de salida al cliente y se le genera una factura.



