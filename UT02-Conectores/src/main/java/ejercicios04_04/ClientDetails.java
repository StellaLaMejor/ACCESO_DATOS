package ejercicios04_04;


import lombok.ToString;

import java.time.LocalDate;
@ToString

public class ClientDetails {
    private final int customerId;
    private final String firstName;
    private final String lastName;
    private final String customerName = firstName + " " + lastName;

    private final String email;
    private final int active;
    private final LocalDate lastUpdate;

    private final String address;
    private final String address2;
    private final String district;
    private final String city;
    private final String country;


    public ClientDetails(int customerId, String firstName, String lastName, String email, int active, LocalDate lastUpdate, String address, String address2, String district, String city, String country) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.lastUpdate = lastUpdate;
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.city = city;
        this.country = country;
    }

}
