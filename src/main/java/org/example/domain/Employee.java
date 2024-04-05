package org.example.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Comparable<Employee> {

   private int id;
   private String name;
   private Integer age;
   private LocalDate birthday;

   @Override
   public int compareTo(Employee o) {
      return name.compareTo(o.getName());
   }
}
