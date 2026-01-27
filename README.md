En este repositorio se encuentran dos apis
  Login
  Productos

La api Producto tiene los siguientes endpoints

De tipo GetMapping esta


/products     


En este se consultan todos los productos que se tienen registrados


/products/{id}


Aqui se consulta solo un producto y se busca por su clave unica, su ID


  De tipo PostMapping

  
  /products
  
  En este metodo se agregan nuevos productos
  
  De tipo PutMapping
  
  /products/{id}
  
  Se actualiza un producto ya existente y lo busca por su ID
  
  De tipo DeleteMapping
  
  /products/{id}
  
  Se elimina un producto y lo busca por su ID
      
Todos los anteriores endpoints estan validados para que reciban un JWT que a su vez valida que el usuario con el rol "admin" pueda hacer uso de los metodos de tipo PostMapping, PutMapping y DeleteMapping

La api Login solo tiene un solo endpoint de tipo PostMapping

/login

Busca un usuario y contraseña y si los encuentra los retorna, a su vez se genera un JWT que se utiliza para poder consumir la api Productos
  
 
