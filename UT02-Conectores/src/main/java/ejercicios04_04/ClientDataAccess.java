package ejercicios04_04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientDataAccess {
    private static final String SQL_FIND_CLIENT_DETAIS= """
    select * from customer
        join sakila.address on customer.address_id = address.address_id
        join sakila.city on address.city_id = city.city_id
        join sakila.country  on city.country_id = country.country_id
    
        where first_name like ? or last_name like ?
    """;

    private static List<ClientDetails> findClientsDetails(String search) throws SQLException {
        List<ClientDetails> results = new ArrayList<>();
        try(Connection connection= SakilaConnectionPool.getInstance().getConnection();
        PreparedStatement ps =connection.prepareStatement(SQL_FIND_CLIENT_DETAIS)) {
            ps.setString(1, search);
            ps.setString(2, search);


            try (ResultSet rs = ps.executeQuery()) {

            }

        }
    }






/*    try(Connection connection= SakilaConnectionPool.getInstance().getConnection();
    PreparedStatement ps= connection.prepareStatement(SQL_FIND_CLIENT_DETAIS)){
        ps.setString(1, serch);
        ps.setString(2, search);

        try(ResultSet rs=ps.executeQuery()){
            while(rs.next()){
                int clientId= rs.getInt("client_id");
                String firstName= rs.getString("first_name");
                String lastName= rs.getString()
            }
        }
    }
*/

}
