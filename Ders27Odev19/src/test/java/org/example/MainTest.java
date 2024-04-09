package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.qameta.allure.Story;

import static org.testng.Assert.assertEquals;

public class MainTest {

    @Test(groups = "unit", dataProvider = "employeeData")
    @Description("Test employee salary calculation")
    @Feature("Salary Calculation")
    @Story("As a manager, I want to calculate employee salaries")
    @Issues({@Issue("ISSUE-1"), @Issue("ISSUE-2")})
    public void testEmployeeCalculateSalary(Integer workedDays, Integer expectedSalary) {
        Employee employee = new Employee("mami", "test", 1000);
        assertEquals(employee.calculateSalary(workedDays), expectedSalary.intValue());
    }

    @DataProvider(name = "employeeData")
    public Object[][] employeeData() {
        return new Object[][] {
                {25, 25000},
                {26, 26000},
                {27, 27000}
        };
    }
}