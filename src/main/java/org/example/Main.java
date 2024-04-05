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
                new Employee(2, "John Doe", 22, LocalDate.now()),
                new Employee(3, "John Ly", 17, LocalDate.now())
        );

        printEmployee(employeeList1);
    }

    private static void printEmployee(List<Employee> employeeList) {

        employeeList.stream()
                .sorted(
                        Comparator.comparing(Employee::getName)
                                .thenComparing(Employee::getAge)
                );

        Gson gson = new GsonBuilder().registerTypeAdapter(
                LocalDate.class, new LocalDateTypeAdapter()
        ).create();

        JsonElement jsonElement = gson.toJsonTree(employeeList);
        String json = gson.toJson(jsonElement);
        System.out.println(json);
    }




}