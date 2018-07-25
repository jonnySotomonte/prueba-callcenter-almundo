package dtos;

import callcenter.CallDispatcher;

public class DirectorEmployee extends GeneralEmployee{
    public DirectorEmployee(CallDispatcher dispatcher, String employeeName) {
        super(dispatcher, employeeName);
        super.employeeType = EmployeeType.DIRECTOR_EMPLOYEE;
    }

    @Override
    void addAvailableEmployee(CallDispatcher dispatcher) {
        dispatcher.addAvailablesEmployee(new OperatorEmployee(dispatcher, employeeName));
    }
}
