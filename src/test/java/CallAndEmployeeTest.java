import callcenter.CallDispatcher;
import dtos.Call;
import dtos.DirectorEmployee;
import dtos.OperatorEmployee;
import dtos.SupervisorEmployee;
import org.junit.Assert;
import org.junit.Test;

public class CallAndEmployeeTest {

    @Test
    public void testCallDurationBetweenMinAndMaxLimits(){
        Call call= new Call("call test");
        System.out.print(call.getDuration());
        Assert.assertTrue(call.getDuration()>=Call.MIN_TIME_DURATION);
        Assert.assertTrue(call.getDuration()<=Call.MAX_TIME_DURATION);
    }

    @Test
    public void testEmployees(){
        Call call = new Call("llamada test");
        call.setDuration(5);
        CallDispatcher dispatcher = new CallDispatcher();
        OperatorEmployee operatorEmployee = new OperatorEmployee(dispatcher, "operator test");
        SupervisorEmployee supervisorEmployee = new SupervisorEmployee(dispatcher, "supervisor test");
        DirectorEmployee directorEmployee = new DirectorEmployee(dispatcher, "director test");
        try {
            operatorEmployee.answerCall(call);
            supervisorEmployee.answerCall(call);
            directorEmployee.answerCall(call);
            Thread.sleep(6000);
            Assert.assertTrue(dispatcher.getAvailablesEmployees().size()==3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
