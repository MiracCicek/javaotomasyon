package org.example;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class MainTest {
    int workedDays = 0;



@Test(groups = "unit", dataProvider = "employeeData")
public void testEmployeeCalculateSalary(Integer workedDays,Integer salary) {
    Employee employee = new Employee("mami", "test", 1000);

    assertEquals(employee.calculateSalary(workedDays),salary);

}
@DataProvider(name = "employeeData")
    public Object[][] employeeData() {
    return new Object[][] {
            {25,25000},{26,26000},{27,27000}
    };
}
}