package edu.kis.powp.jobs2d.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ComplexCommandTest {

    static boolean compareCommands(ComplexCommand cc1, ComplexCommand cc2){
        while(cc1.iterator().hasNext()){
            if(!cc2.iterator().hasNext()){
                return false;
            }
            if(cc1.iterator().next() != cc2.iterator().next()){
                return false;
            }

        }
        return true;
    }

    static void testIterator() {

    }

    static void testAddCommand() {
        List<DriverCommand> commandList = Arrays.asList(new SetPositionCommand(0,0),  new OperateToCommand(1,1), new SetPositionCommand(2,2));
        ComplexCommand cc = new ComplexCommand();
        for (DriverCommand command: commandList){
            cc.addCommand(command);
        }

    }



    static void testAddAtIndexCommand() {
    }


    static void testRemoveCommand() {
    }


    static void testRemoveLastCommand() {
    }


    static void testSetCommand() {
    }


    static void testClear() {
    }


    static void testIsEmpty() {
    }

    
    static void testCopy() {
    }

    public static void main(String[] args) {
        testIterator();
        testAddCommand();
        testAddAtIndexCommand();
        testRemoveCommand();
        testRemoveLastCommand();
        testSetCommand();
        testClear();
        testIsEmpty();
        testCopy();
    }
}