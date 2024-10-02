package ejercicio01;

import java.sql.*;
import java.util.Scanner;

public class Programa {
    private static final String USERNAME= "sakilauser";
    private static final String PASSWORD= "pwdsakilauser";
    private static final String CONNECTION_STRING= "jdbc:mysql://localhost/sakila";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



    }

    private static void ejecutarSentencia (String query) throws SQLException{
        System.out.printf("Ejecutando senjtencia: %s\n", query);
        try(Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            PreparedStatement ps = connection.prepareStatement(query)){
            boolean isResultSet=ps.execute();
            if (isResultSet){
                System.out.println("Resultados encontrados en la base de datos.");
                mostrarResultset(ps.executeQuery());
            } else {
                System.out.println("Es una actualización, inseción o borrado.");
                System.out.printf("Han sido afectados %d registros.\n", ps.getUpdateCount());
            }
        }
    }
    private static void mostrarResultset(ResultSet rs) throws SQLException{
        ResultSetMetaData metaData = rs.getMetaData();
        mostrarCabeceraResultset(metaData);
        mostrarCuerpoResultset(rs, metaData);
    }

    private static void mostrarCabeceraResultset(ResultSetMetaData metaData) throws SQLException {
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.printf("%s ",metaData.getColumnName(i));
        }

        System.out.println();
    }

    private static void mostrarCuerpoResultset(ResultSet rs, ResultSetMetaData metaData) throws SQLException {
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.printf("%s ",rs.getString(i));
        }

        System.out.println();
    }
}
