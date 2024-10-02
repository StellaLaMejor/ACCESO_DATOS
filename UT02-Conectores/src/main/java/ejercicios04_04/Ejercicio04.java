package ejercicios04_04;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio04 {
    public static void main(String[] args) {


        try (Connection conexion = SakilaConnectionPool.getInstance().getConnection();
             Statement s = conexion.createStatement()) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
