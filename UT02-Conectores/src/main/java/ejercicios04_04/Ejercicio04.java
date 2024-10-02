package ejercicios04_04;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio04 {
    public static void main(String[] args) {
        SakilaConnectionPool pool = new SakilaConnectionPool();

        try (Connection conexion = pool.getConnection();
             Statement ps = conexion.createStatement()) {

        } catch (SQLException e) {
            throw new RunTimeExcetion(e);
        }
    }
}
