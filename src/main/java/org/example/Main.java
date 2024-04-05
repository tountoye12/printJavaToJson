package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.example.domain.Employee;
import org.example.helper.LocalDateTypeAdapter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.time.LocalDate.now;

public class Main {
    public static void main(String[] args) {


        List<Employee> employeeList1 = new ArrayList<>();
        employeeList1.add(new Employee(1, "Adama Diallo", 24, now()));
        employeeList1.add(new Employee(2, "John Doe", 27, now()));
        employeeList1.add(new Employee(3, "Ebrima Doe", 22, now()));
        employeeList1.add(new Employee(4, "Gabou Ly", 17, now()));

        Collections.sort(employeeList1);
        printEmployee(employeeList1);
    }

    private static void printEmployee(List<Employee> employeeList) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(
                LocalDate.class, new LocalDateTypeAdapter()
        ).create();

        JsonElement jsonElement = gson.toJsonTree(employeeList);
        String json = gson.toJson(jsonElement);
        System.out.println(json);
    }




}