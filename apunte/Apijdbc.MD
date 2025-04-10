                                # **    # Java Data Base Conectivity  **                                          

JDBC es una api standard de java, y se utiliza para conectarnos a una base de dato relacional,
 como puede ser PostgreSql, MySql,Oracle,etc.
La API JDBC es un conjunto de clases, en este caso Java las cuales se encuentran empaquetados,
 en un archivo conocido como JAR (java archive ) cumplendo una funcion muy especifica,
  conectar a una base de datos.

                                   ** ## Paquete JAVA.SQL**

Clase DriverManager
    permite establecer y gestionar conexiones a las BD
Clase SQLPermission
    proporciona permios para poder usar el DriverManager a codigo de ejecución dentro de un Security Manager
Interfaz Driver 
    metodos para registrar y conectar controladores basa en tecnologia JDBC
Clase DriverPropertyInfo
    propiedades de un controlador
Excepciones
    SQLExtception
    SQLWarning
Interfaz con la aplicación
	   Envío de instrucciones SQL a la BD
 	Connection
       Métodos para crear instrucciones y para gestionar conexiones y sus propiedades.
 	Statement
       Permite enviar instrucciones a la BD
 	PreparedStatement
       Permite usar instrucciones preparadas o SQL básicas
    CallableStatement
       Llamada a procedimientos almacenados en la BD
 	 Savepoint
       Puntos de recuperación en una transacción
	Recuperación de los resultados de la consulta a la BD
 	   ResultSet
    Conjunto de resultados que se devuelven de una query
 	   ResultSetMetaData
    Información sobre las columnas del objeto ResultSet

                                 **  ## Correspondencia de tipos SQL con clases e interfaces de JAVA**
           
                       Array ------> SQL ARRAY.
                       Blob -------> SQL BLOB.
                       Clob -------> SQL CLOB.
                       Date -------> SQL DATE.
                       Time -------> SQL TIME

                      ** ### TIPOS en JAVA-->SQL
**
                       boolean -----> BIT
                       short -------> SMALLING
                       int ---------> INTEGER
                       long --------> BIGINT
                       float -------> FLOAT 
                       double ------> DOUBLE
                       char --------> CHAR
                       string ------> VARCHAR
                       byte[] ------> BINARY

                                   ## Interfaz con la aplicación
            
Para obtener información de la BD (metadatos)
    • DatabaseMetaData
        • Información sobre la BD
     `   `try {
        DatabaseMetaData infoBD= conexion.getMetaData();
        System.out.println("Base de datos: " + infoBD.getDatabaseProductName());
        System.out.println("Version: " + infoBD.getDatabaseProductVersion());
        } catch (Exception ex) {
        // Tratar el error
        }//fin try{}``
                                   ## Excepciones

• SQLException
     Es obligatorio capturar estas excepciones
     Se puede obtener información adicional sobre el error
        • getMessage()
            • Mensaje de error de la excepción
        • getSQLState()
            • Texto de SQLstate según la convención X/Open o SQL:2003
        • getErrorCode()
            • Código de error (entero) específico del vendedor
• SQLWarning
    • No es obligatorio capturar estas excepciones
    • Errorews leves de objetos Connection, Statement, o Resultset
• Data Truncation
    • Subclases de SQLWarming
    • Avisos de truncado de datos en operaciones de Lectura / Escritura

                                    ##Transacciones

• Por defecto se funciona en modo autocommint.
    • Cada instrucción sobre la BD va en su propia transacción.
    • Es seguro pero ineficiente
    • se desactiva con conexion.setAutoCommint(false)
• Para gestionar las transacciones con autocommint(false),
    • commint()
        • Hacer efectivo todos los cambios desde el ultimo commint/rollback.
        • Libera los bloqueos de la BD que tuvieran el objeto Connection.
    • rollback()
        • Desahace todos los cambios realizados en la transacción.
        • Libera los bloqueos de la BD que tuvieran el objeto Connection.
• Crear puntos de recuperación    
    • setSavepoint(String name)
        • permite hacer commint parciales para volver a este punto,
                • si fuera necesario con rollback(savepoints)