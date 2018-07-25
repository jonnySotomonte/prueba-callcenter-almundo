package callcenter;

import dtos.Call;
import dtos.GeneralEmployee;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class CallDispatcher extends Thread{
    private BlockingQueue<GeneralEmployee> availablesEmployees;
    private BlockingQueue<Call> calls;

    public CallDispatcher(){
        availablesEmployees = new PriorityBlockingQueue<GeneralEmployee>();
        calls = new LinkedBlockingQueue<Call>();
    }

    public void dispatchCall(Call call) throws InterruptedException{
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String time = sdf.format(now);
        System.out.println(time + " Esta entrando la llamada -->" + call.getDescription());
        this.calls.put(call);
    }

    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String time = sdf.format(now);
        Call call;
        GeneralEmployee employee;
        try {
            while(true){
                call = calls.take();
                System.out.println(time + " Llamada pendiente por ser atendida --> " + call.getDescription());
                employee = availablesEmployees.take();
                System.out.println(time + " Empleado --> " + employee.getEmployeeName() + " va a tomar la llamda --> " + call.getDescription());
                employee.answerCall(call);
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido una excepción atendiendo la llamada por el empleado, causado por: ");
            e.printStackTrace();
        }
    }

    public void addAvailablesEmployee(GeneralEmployee employee){
        this.availablesEmployees.add(employee);
    }

    public Queue<Call> getCalls(){
        return calls;
    }

    public Queue<GeneralEmployee> getAvailablesEmployees(){
        return availablesEmployees;
    }
}
