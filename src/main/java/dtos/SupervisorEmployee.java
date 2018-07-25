package dtos;

import callcenter.CallDispatcher;

public class SupervisorEmployee extends GeneralEmployee{

    public SupervisorEmployee(CallDispatcher dispatcher, String employeeName) {
        super(dispatcher, employeeName);
        super.employeeType = EmployeeType.SUPERVISOR_EMPLOYEE;
    }

    @Override
    void addAvailableEmployee(CallDispatcher dispatcher) {
        dispatcher.addAvailablesEmployee(new OperatorEmployee(dispatcher, employeeName));
    }
}
