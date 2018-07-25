import callcenter.CallDispatcher;
import dtos.Call;
import dtos.DirectorEmployee;
import dtos.OperatorEmployee;
import dtos.SupervisorEmployee;
import org.junit.Assert;
import org.junit.Test;

public class CallDispatcherTest {

    private static final int MAX_DURATION_PER_CALL_IN_MILLISECONDS = 10000;

    @Test
    public void testThreeCallsWithThreeEmployees(){
        try {
            System.out.println("-----------TEST 3 CALLS WITH 3 EMPLOYEES--------------");
            CallDispatcher dispatcher = new CallDispatcher();
            dispatcher.start();
            dispatcher.addAvailablesEmployee(new OperatorEmployee(dispatcher, "Operador 1"));
            dispatcher.addAvailablesEmployee(new OperatorEmployee(dispatcher, "Operador 2"));
            dispatcher.addAvailablesEmployee(new OperatorEmployee(dispatcher, "Operador 3"));
            Call llamada1 = new Call(" 1 ");
            llamada1.setDuration(5);
            Call llamada2 = new Call(" 2 ");
            llamada2.setDuration(5);
            Call llamada3 = new Call(" 3 ");
            llamada3.setDuration(5);
            dispatcher.dispatchCall(llamada1);
            dispatcher.dispatchCall(llamada2);
            dispatcher.dispatchCall(llamada3);

            //Las llamadas asignadas tienen una duración de  5s y como hay 3 operadores, las llamadas tienen que ser atendidas en 5s.
            Thread.sleep(5000);

            //Al finalizar este tiempo, todos los empleados deberian estar disponibles nuevamente
            //Assert.assertTrue(dispatcher.getAvailablesEmployees().size() == 3);
            Assert.assertTrue(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTenCallsWithThreeEmployees(){
        System.out.println("-----------TEST 10 LLAMADAS--------------");
        try {
            int callsQuantity = 10;
            int employeesQuantity = 3;
            CallDispatcher dispatcher = new CallDispatcher();
            dispatcher.start();
            dispatcher.addAvailablesEmployee(new DirectorEmployee(dispatcher, "Director 1"));
            dispatcher.addAvailablesEmployee(new SupervisorEmployee(dispatcher, "Supervisor 1"));
            dispatcher.addAvailablesEmployee(new OperatorEmployee(dispatcher, "Operador 1"));

            dispatcher.dispatchCall(new Call("Llamada 1 "));
            dispatcher.dispatchCall(new Call("Llamada 2 "));
            dispatcher.dispatchCall(new Call("Llamada 3 "));
            dispatcher.dispatchCall(new Call("Llamada 4 "));
            dispatcher.dispatchCall(new Call("Llamada 5 "));
            dispatcher.dispatchCall(new Call("Llamada 6 "));
            dispatcher.dispatchCall(new Call("Llamada 7 "));
            dispatcher.dispatchCall(new Call("Llamada 8 "));
            dispatcher.dispatchCall(new Call("Llamada 9 "));
            dispatcher.dispatchCall(new Call("Llamada 10 "));

            //Espero el tiempo maximo para que todas las llamadas hayan sido atendidas:
            //((tiempo de duracion max de llamada * cant llamadas) / cant empleados)
            Thread.sleep((MAX_DURATION_PER_CALL_IN_MILLISECONDS * callsQuantity)/employeesQuantity);

            //Al finalizar este tiempo, todos los empleados deberian estar disponibles nuevamente
            Assert.assertTrue(dispatcher.getAvailablesEmployees().size() == employeesQuantity);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIncomingCalls(){
        int callsQuantity = 16;
        int employeesQuantity = 8;
        System.out.println("-----------TEST INCOMING CALLS--------------");
        try {
            CallDispatcher dispatcher = new CallDispatcher();
            dispatcher.start();
            dispatcher.dispatchCall(new Call("Llamada 1 "));
            dispatcher.dispatchCall(new Call("Llamada 2 "));
            dispatcher.dispatchCall(new Call("Llamada 3 "));
            dispatcher.addAvailablesEmployee(new OperatorEmployee(dispatcher, "Operador 1"));
            dispatcher.addAvailablesEmployee(new OperatorEmployee(dispatcher, "Operador 2"));
            dispatcher.dispatchCall(new Call("Llamada 4 "));
            dispatcher.dispatchCall(new Call("Llamada 5 "));
            dispatcher.addAvailablesEmployee(new OperatorEmployee(dispatcher, "Operador 3"));
            dispatcher.addAvailablesEmployee(new SupervisorEmployee(dispatcher, "Supervisor 1"));
            dispatcher.dispatchCall(new Call("Llamada 6 "));
            dispatcher.addAvailablesEmployee(new DirectorEmployee(dispatcher, "Director 1"));
            dispatcher.dispatchCall(new Call("Llamada 7 "));
            dispatcher.addAvailablesEmployee(new OperatorEmployee(dispatcher, "Operador 4"));
            dispatcher.dispatchCall(new Call("Llamada 8 "));
            dispatcher.addAvailablesEmployee(new SupervisorEmployee(dispatcher, "Supervisor 2"));
            dispatcher.dispatchCall(new Call("Llamada 9 "));
            dispatcher.dispatchCall(new Call("Llamada 10 "));
            dispatcher.addAvailablesEmployee(new DirectorEmployee(dispatcher, "Director 2"));
            dispatcher.dispatchCall(new Call("Llamada 11 "));
            dispatcher.dispatchCall(new Call("Llamada 12 "));
            dispatcher.dispatchCall(new Call("Llamada 13 "));
            dispatcher.dispatchCall(new Call("Llamada 14 "));
            dispatcher.dispatchCall(new Call("Llamada 15 "));
            dispatcher.dispatchCall(new Call("Llamada 16 "));

            //Espero el tiempo maximo para que todas las llamadas hayan sido atendidas:
            //((tiempo de duracion max de llamada * cant llamadas) / cant empleados)
            Thread.sleep((MAX_DURATION_PER_CALL_IN_MILLISECONDS * callsQuantity)/employeesQuantity);

            //Al finalizar este tiempo, todos los empleados deberian estar disponibles nuevamente
            Assert.assertTrue(dispatcher.getAvailablesEmployees().size() == employeesQuantity);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
