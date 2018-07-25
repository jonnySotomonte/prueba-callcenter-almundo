package dtos;

public enum EmployeeType {
    OPERATOR_EMPLOYEE(1),
    SUPERVISOR_EMPLOYEE(2),
    DIRECTOR_EMPLOYEE(3);
    private int priority;

    EmployeeType(int priority){
        this.priority =priority;
    }

    public int getPriority(){
        return priority;
    }
}
