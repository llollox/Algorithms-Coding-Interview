package com.llollox.algorithms.problems.crack.objectoriented;

import java.util.*;

public class CallCenter {

    /*
         Imagine you have a call center with three levels of employees: respondent, manager, and director.
         An incoming telephone call must be first allocated to a respondent who is free.
         If the respondent can't handle the call, he or she must escalate the call to a manager.
         If the manager is not free or not able to handle it, then the call should be escalated to a director.
         Design the classes and data structures for this problem.
         Implement a method dispatchCall () which assigns a call to the first available employee.
     */

    /*
        Al momento se un employee non può risponde scala, senza vedere se altri di pari livello possono rispondere.

        Coda di chiamate in entrata
        Lavoratore, esteso dai 3 tipi
        HashMap<Employee, Call> per definire quelli che sono occupati
     */


    // Class attributes ************************************************************************************************
    List<Respondant> respondants;
    List<Manager> managers;
    List<Director> directors;

    Queue<Call> pendingCalls = new LinkedList<>();
    HashMap<Employee, Call> callingMap = new HashMap<>();


    // Constructor *****************************************************************************************************
    public CallCenter(List<Respondant> respondants, List<Manager> managers, List<Director> directors) {
        this.respondants = respondants;
        this.managers = managers;
        this.directors = directors;


    }


    // Class functions *************************************************************************************************
    public void dispatchCall(Call call) {

        Employee employee = this.firstAvailableEmployee();

        if (employee == null) {

            // Nobody is available
            this.pendingCalls.add(call);
        }
        else {

            // Someone is available
            this.callingMap.put(employee, call);
            employee.respond(call);
        }
    }

    public void endCall(Employee employee) {
        this.callingMap.remove(employee);

        if (!this.pendingCalls.isEmpty()) {
            Call pendingCall = this.pendingCalls.poll();

            this.callingMap.put(employee, pendingCall);
            employee.respond(pendingCall);
        }
    }

    private Employee firstAvailableEmployee() {
        for (Respondant respondant : this.respondants) {
            if (!callingMap.containsKey(respondant)) {
                return respondant;
            }
        }

        for (Manager manager : this.managers) {
            if (!callingMap.containsKey(manager)) {
                return manager;
            }
        }

        for (Director director : this.directors) {
            if (!callingMap.containsKey(director)) {
                return director;
            }
        }

        return null;
    }


    // Inner classes ***************************************************************************************************
    class Call {
        String callerNumber;
    }


    class Respondant extends Employee {

        public Respondant(String name, String surname) {
            super(name, surname, Rank.RESPONDANT);
        }
    }

    class Manager extends Employee {

        public Manager(String name, String surname) {
            super(name, surname, Rank.MANAGER);
        }
    }

    class Director extends Employee {

        public Director(String name, String surname) {
            super(name, surname, Rank.DIRECTOR);
        }
    }

    static class Employee {

        enum Rank {
            RESPONDANT, MANAGER, DIRECTOR
        }

        String name;
        String surname;
        Rank rank;

        public Employee(String name, String surname, Rank rank) {
            this.name = name;
            this.surname = surname;
            this.rank = rank;
        }

        public void respond(Call call) {
            // do something with call.
        }
    }

}
