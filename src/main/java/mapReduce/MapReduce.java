package mapReduce;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;

/**
 * @author 张彦
 * @email: zhangyan1@juxinli.com
 * @date 创建时间：2016年7月7日 下午2:42:11
 * @version 1.0
 */
public class MapReduce {
    public static final void main(String[] args) {
        
        Set<String> s1 = Sets.newHashSet("-1","0","1", "2", "3");
        Set<String> s2 = Sets.newHashSet("2", "3", "4");
        Set<String> a = Sets.difference(s1, s2); 
        Iterator<String>  iterator = a.iterator();
            
        Employee guest = new Builder("Guest").build();
        Employee anna = new Builder("Anna").build();
        Employee thomas = new Builder("Thomas").age(41).build();
        Employee luke = new Builder("Luke").company("LucasArt").build();
        Employee yoda = new Builder("Yoda").age(800).company("LucasArt").build();

        Collection<Employee> employees = new ArrayList<Employee>();
        employees.add(guest);
        employees.add(anna);
        employees.add(thomas);
        employees.add(luke);
        employees.add(yoda);

        ImmutableListMultimap<String, Employee> personsGroupByCompany = Multimaps.index(employees, new Function<Employee, String>() {

            public String apply(Employee person) {
                return person.getCompany();
            }

        });

        ImmutableSet<String> companyNamesFromMap = personsGroupByCompany.keySet();

        List<Employee> averageAgeByCompany = new ArrayList<Employee>();

        for (String company : companyNamesFromMap) {
            List<Employee> employeesForThisCompany = personsGroupByCompany.get(company);
            int sum = 0;
            for (Employee employee : employeesForThisCompany) {
                sum += employee.getAge();
            }
            averageAgeByCompany.add(new Employee("average", sum / employeesForThisCompany.size(), company));
        }
        System.out.println("Result: " + averageAgeByCompany);

    }

    // MapReduce.scala

    // case class Employee(name: String = "guest", age: Int = 30, company:
    // String = "DevCode")
    //
    // object MapReduce {
    // def main(args: Array[String]): Unit = {
    //
    // val guest = Employee()
    // val anna = Employee("Anna")
    // val thomas = Employee("Thomas", 41)
    // val luke = Employee("Luke", company = "LucasArt")
    // val yoda = luke.copy("Yoda", age = 800)
    //
    // val allEmployees = List(luke, anna, guest, yoda, thomas)
    // val sortedEmployees = allEmployees.groupBy(_.company)
    // val averageAgeByCompany = sortedEmployees.map { case (key, value) =>
    // value(0).copy(name = "average", age = (value.map(_.age).sum) /
    // value.size)
    // }
    // println("Result: "+averageAgeByCompany)
    // }
    // }
}
