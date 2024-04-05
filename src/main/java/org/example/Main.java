package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.example.domain.Employee;
import org.example.helper.LocalDateTypeAdapter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Employee> employeeList1 = new ArrayList<>();
        employeeList1.add(new Employee(1, "Adama Diallo", 24, java.time.LocalDate.now()));
        employeeList1.add(new Employee(2, "John Doe", 27, java.time.LocalDate.now()));
        employeeList1.add(new Employee(3, "Ebrima Doe", 22, java.time.LocalDate.now()));
        employeeList1.add(new Employee(4, "Gabou Ly", 17, java.time.LocalDate.now()));

        Collections.sort(employeeList1);
        printEmployee(employeeList1);
    }

    private static void printEmployee(List<Employee> employeeList) {

        Gson gson = new GsonBuilder().registerTypeAdapter(
                LocalDate.class, new LocalDateTypeAdapter()
        ).create();

        JsonElement jsonElement = gson.toJsonTree(employeeList);
        String json = gson.toJson(jsonElement);
        System.out.println(json);
    }




}