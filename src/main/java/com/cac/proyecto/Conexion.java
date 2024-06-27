// package com.ar.movies;
package com.cac.proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// CONCLUSION DE LA CLASE Conexion:
// Esta clase es la encargada de establecer la conexión con la base de datos 'peliculas_cac_java' en localhost, en su constructor se cargan dinámicamente el driver de MySQL y se establece la conexión con la base de datos 'peliculas_cac_java' en localhost. Además, tiene un método para obtener la conexión(getConnection) y otro para cerrar la conexión. En caso de no encontrar el driver o problemas con la conexión a la base de datos, se imprime el error correspondiente.

public class Conexion {
    // este es un atributo mio de mi clase Conexion, pero el tipo de dato de este atributo es Connection
    // que es una clase del paquete java.sql Connection se llama la clase
    private Connection connection;  // Objeto Connection para manejar la conexión a la base de datos

    // Constructor de la clase Conexion
    public Conexion() {
        // manejo de excepciones
        try {
            // Paso 1: Cargar dinámicamente el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Paso 2: Establecer la conexión con la base de datos 'peliculas_cac_java' en localhost
            this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/peliculas_cac_java",  // URL de conexión JDBC para MySQL
                "root",  // Nombre de usuario de la base de datos (cambia según tu configuración)
                ""  // Contraseña de la base de datos (cambia según tu configuración)
            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  // Imprimir el error en caso de no encontrar el driver
        } catch (SQLException e) {
            e.printStackTrace();  // Imprimir el error en caso de problemas con la conexión a la base de datos
        }
    }

    // Método para obtener la conexión GETTER
    public Connection getConnection() {
        return connection;  // Devuelve el objeto Connection establecido
    }

    // Método para cerrar la conexión
    public void close() {
        try {
            // Verificar si la conexión no es nula y está abierta, entonces cerrarla
            if (connection != null && !connection.isClosed()) {
                connection.close();  // Cierra la conexión a la base de datos
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Imprimir el error en caso de problemas al cerrar la conexión
        }
    }
}
