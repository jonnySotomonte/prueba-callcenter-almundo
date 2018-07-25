package dtos;

import callcenter.CallDispatcher;

public class OperatorEmployee extends GeneralEmployee{

    public OperatorEmployee(CallDispatcher dispatcher, String employeeName) {
        super(dispatcher, employeeName);
        super.employeeType = EmployeeType.OPERATOR_EMPLOYEE;
    }

    @Override
    void addAvailableEmployee(CallDispatcher dispatcher) {
        dispatcher.addAvailablesEmployee(new OperatorEmployee(dispatcher, employeeName));
    }
}
