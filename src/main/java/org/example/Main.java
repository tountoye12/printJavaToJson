package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.example.domain.Employee;
import org.example.helper.LocalDateTypeAdapter;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Employee> employeeList1 = List.of(
                new Employee(1, "Adama Diallo", 24, LocalDate.now()),
                new Employee(2, "John Doe", 27, LocalDate.now()),
                new Employee(3, "John Doe", 22, LocalDate.now()),
                new Employee(4, "John Ly", 17, LocalDate.now()),
                new Employee(5, "Ebrima Doe", 22, LocalDate.now()),
                new Employee(6, "Gabou Ly", 17, LocalDate.now())
        );

        List<Employee> employeeListSorted = sortEmployeeList(employeeList1);
        printEmployeeJson(employeeListSorted);
    }

    private static void printEmployeeJson(List<Employee> employeeList) {
        Gson gson = new GsonBuilder().registerTypeAdapter(
                LocalDate.class, new LocalDateTypeAdapter()
        ).setPrettyPrinting().create();
        JsonElement jsonElement = gson.toJsonTree(employeeList);
        String json = gson.toJson(jsonElement);
        System.out.println(json);
    }

    private static List<Employee> sortEmployeeList(List<Employee> employeeList) {
        Comparator<Employee> comparatorByName = Comparator.comparing(Employee::getName);
        Comparator<Employee> comparatorByAge = Comparator.comparing(Employee::getAge);
        return employeeList.stream()
                .sorted(
                        comparatorByName.thenComparing(comparatorByAge)
                ).toList();
    }




}