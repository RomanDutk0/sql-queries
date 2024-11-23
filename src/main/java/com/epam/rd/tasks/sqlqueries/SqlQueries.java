package com.epam.rd.tasks.sqlqueries;

/**
 * Implement sql queries like described
 */
public class SqlQueries {
    //Select all employees sorted by last name in ascending order
    //language=HSQLDB
    String select01 = "SELECT * FROM EMPLOYEE ORDER BY LASTNAME ASC";

    //Select employees having no more than 5 characters in last name sorted by last name in ascending order
    //language=HSQLDB
    String select02 = "SELECT * FROM EMPLOYEE WHERE LENGTH(LASTNAME) <= 5 ORDER BY LASTNAME ASC";

    //Select employees having salary no less than 2000 and no more than 3000
    //language=HSQLDB
    String select03 = "SELECT * FROM EMPLOYEE WHERE SALARY BETWEEN 2000 AND 3000 ";

    //Select employees having salary no more than 2000 or no less than 3000
    //language=HSQLDB
    String select04 = "SELECT * FROM EMPLOYEE WHERE SALARY <= 2000 OR SALARY >= 3000";

    //Select all employees assigned to departments and corresponding department
    //language=HSQLDB
    String select05 = "SELECT EMPLOYEE.ID AS EmployeeID, EMPLOYEE.FIRSTNAME, EMPLOYEE.LASTNAME, EMPLOYEE.MIDDLENAME, EMPLOYEE.POSITION, EMPLOYEE.MANAGER, EMPLOYEE.HIREDATE, EMPLOYEE.SALARY, DEPARTMENT.ID AS DepartmentID, DEPARTMENT.NAME AS DepartmentName, DEPARTMENT.LOCATION AS DepartmentLocation FROM EMPLOYEE JOIN DEPARTMENT ON EMPLOYEE.DEPARTMENT = DEPARTMENT.ID;";

    //Select all employees and corresponding department name if there is one.
    //Name column containing name of the department "depname".
    //language=HSQLDB
    String select06 = "SELECT \n" +
            "    EMPLOYEE.ID AS EmployeeID,\n" +
            "    EMPLOYEE.FIRSTNAME,\n" +
            "    EMPLOYEE.LASTNAME,\n" +
            "    EMPLOYEE.MIDDLENAME,\n" +
            "    EMPLOYEE.POSITION,\n" +
            "    EMPLOYEE.MANAGER,\n" +
            "    EMPLOYEE.HIREDATE,\n" +
            "    EMPLOYEE.SALARY,\n" +
            "    DEPARTMENT.NAME AS depname\n" +
            "FROM \n" +
            "    EMPLOYEE\n" +
            "LEFT JOIN \n" +
            "    DEPARTMENT ON EMPLOYEE.DEPARTMENT = DEPARTMENT.ID;\n";

    //Select total salary pf all employees. Name it "total".
    //language=HSQLDB
    String select07 = "SELECT \n" +
            "    SUM(SALARY) AS total\n" +
            "FROM \n" +
            "    EMPLOYEE;\n";

    //Select all departments and amount of employees assigned per department
    //Name column containing name of the department "depname".
    //Name column containing employee amount "staff_size".
    //language=HSQLDB
    String select08 = "SELECT \n" +
            "    DEPARTMENT.NAME AS depname,\n" +
            "    COUNT(EMPLOYEE.ID) AS staff_size\n" +
            "FROM \n" +
            "    DEPARTMENT\n" +
            "INNER JOIN \n" +
            "    EMPLOYEE ON EMPLOYEE.DEPARTMENT = DEPARTMENT.ID\n" +
            "GROUP BY \n" +
            "    DEPARTMENT.ID, DEPARTMENT.NAME;\n";


    //Select all departments and values of total and average salary per department
    //Name column containing name of the department "depname".
    //language=HSQLDB
    String select09 = "SELECT \n" +
            "    D.NAME AS depname, \n" +
            "    COALESCE(SUM(E.SALARY), 0) AS total, \n" +
            "    COALESCE(AVG(E.SALARY), 0) AS average\n" +
            "FROM \n" +
            "    DEPARTMENT D\n" +
            "LEFT JOIN \n" +
            "    EMPLOYEE E ON D.ID = E.DEPARTMENT\n" +
            "GROUP BY \n" +
            "    D.ID, D.NAME\n" +
            "HAVING \n" +
            "    COALESCE(SUM(E.SALARY), 0) > 0;\n";

    //Select lastnames of all employees and lastnames of their managers if an employee has a manager.
    //Name column containing employee's lastname "employee".
    //Name column containing manager's lastname "manager".
    //language=HSQLDB
    String select10 = "SELECT \n" +
            "    E.LASTNAME AS employee,\n" +
            "    M.LASTNAME AS manager\n" +
            "FROM \n" +
            "    EMPLOYEE E\n" +
            "LEFT JOIN \n" +
            "    EMPLOYEE M ON E.MANAGER = M.ID;\n";


}
