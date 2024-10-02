package ejercicios01_03;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Ejercicio03 {
    private static final String USERNAME = "sakilauser";
    private static final String PASSWORD = "pwdsakilauser";
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String SQL_INSERT = "select title, film.release_year, film.film_id, film.language_id, film.rating, film.description from film";
    private static final int TAMANIO_LOTE = 3;

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);

        int contador = 0;
        try (connection; PreparedStatement ps = connection.prepareStatement(SQL_INSERT)) {
            connection.setAutoCommit(false);
            System.out.println("Introduce un valor para la columna contenido");
            String contenido = sc.nextLine();
            while ((!contenido.equals("FIN"))) {
                ps.setString(1, contenido);
                ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));











































































                int numInsertados = ps.executeUpdate();
                System.out.printf("Se ha insertado %d registros\n", numInsertados);
                contador++;
                if (contador % TAMANIO_LOTE == 0)
                    connection.commit();

                System.out.printf("Introduce un valor para la columna contenido: ");
                contenido = sc.nextLine();
            }
          //  connection.commit();
        } catch (SQLException e) {
            System.out.println("Error al insertar el registro");
            e.printStackTrace();
            connection.rollback();
        }
        System.out.println("Gracias por usar el programa");
    }
}

 