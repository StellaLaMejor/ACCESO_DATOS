package ejercicios04_04;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String searchString="";
        do {
            System.out.println("Introduce la cadena de búsqueda: ");
            searchString = sc.nextLine();

            if(!searchString.isBlank()){

                var results =ClientDataAccess.findClientsDetails(searchString);
                System.out.println("No se ha encontrado % clientes: \n", results.size());
                results.forEach(System.out::println);
                results.stream().filter(cd-> cd.getFirstName();
                if(results.isEmpty()){
                    showClientsDetails(results);

                }else {

                }
            }
        }while (!searchString.isBlank());
    }

    private static void showClientsDetails(List<ClientDetails> results) {

        results.forEach(System.out::println);
    }
}
