package dtos;

import callcenter.CallDispatcher;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class GeneralEmployee extends Thread implements Comparable<GeneralEmployee>{

    protected EmployeeType employeeType;
    protected String employeeName;
    private Call answeredCall;
    private CallDispatcher dispatcher;
    private static final int SECOND_IN_MILISECONDS = 1000;

    public GeneralEmployee(CallDispatcher dispatcher, String employeeName){
        this.dispatcher = dispatcher;
        this.employeeName = employeeName;
    }

    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String time = sdf.format(now);
        try {
            Thread.sleep(SECOND_IN_MILISECONDS * answeredCall.getDuration());
            System.out.println(time + " La llamada --> " + answeredCall.getDescription() + " ha sido finalizada. La llamada duró --> " + answeredCall.getDuration()+ " segundos.");
            this.addAvailableEmployee(dispatcher);
            System.out.println(time + " El empleado llamado --> " + this.getEmployeeName() + " nuevamente se encuentra disponible");
        } catch (InterruptedException e) {
            System.out.println("Error atendiendo llamada " + answeredCall.getDescription());
            e.printStackTrace();
        }
    }

    public int compareTo(GeneralEmployee incomingEmployee) {
        int priorityIntoEmployeesQueue = 0;
        if(this.getAttentionPriority() > incomingEmployee.getAttentionPriority())
            priorityIntoEmployeesQueue = 1;
        else if(this.getAttentionPriority() == incomingEmployee.getAttentionPriority())
            priorityIntoEmployeesQueue = 0;
        else if(this.getAttentionPriority() < incomingEmployee.getAttentionPriority())
            priorityIntoEmployeesQueue = -1;
        return priorityIntoEmployeesQueue;
    }

    public int getAttentionPriority(){
        return this.employeeType.getPriority();
    }

    public void answerCall(Call call) {
        this.answeredCall = call;
        this.start();
    }

    abstract void addAvailableEmployee(CallDispatcher dispatcher);

    public String getEmployeeName() {
        return employeeName;
    }
}
