package edu.kis.powp.jobs2d.command;

class ComplexCommandTest {

    static boolean compareCommands(ComplexCommand cc1, ComplexCommand cc2) {
        if (cc1.size() != cc2.size()) {
            return false;
        }
        for (int i = 0; i < cc1.size(); i++) {
            if (!cc1.iterator().next().equals(cc2.iterator().next())) {
                return false;
            }
        }
        return true;
    }

    static void testIterator() {
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(0, 0));
        command.addCommand(new OperateToCommand(10, 10));
        ComplexCommand command2 = new ComplexCommand();
        command2.addCommand(new SetPositionCommand(0, 0));
        command2.addCommand(new OperateToCommand(10, 10));

        if (!compareCommands(command, command2)) {
            System.out.println("testIterator failed");
        } else {
            System.out.println("testIterator passed");
        }
    }

    static void testIsEmpty() {
        ComplexCommand command = new ComplexCommand();

        if (!command.isEmpty()) {
            System.out.println("testIsEmpty failed");
        } else {
            command.addCommand(new SetPositionCommand(0, 0));
            if (command.isEmpty()) {
                System.out.println("testIsEmpty failed");
            } else {
                System.out.println("testIsEmpty passed");
            }
        }
    }

    static void testAddCommand() {
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(0, 0));

        if (command.size() != 1) {
            System.out.println("testAddCommand failed");
        } else {
            System.out.println("testAddCommand passed");
        }
    }

    static void testAddAtIndexCommand() {
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(0, 0));
        command.addCommand(0, new SetPositionCommand(10, 10));

        if (command.size() != 2 || !command.iterator().next().equals(new SetPositionCommand(10, 10))) {
            System.out.println("testAddAtIndexCommand failed");
        } else {
            System.out.println("testAddAtIndexCommand passed");
        }
    }

    static void testRemoveCommand() {
        ComplexCommand command = new ComplexCommand();
        DriverCommand cmd = new SetPositionCommand(0, 0);
        command.addCommand(cmd);
        command.removeCommand(0);

        if (!command.isEmpty()) {
            System.out.println("testRemoveCommand failed");
        } else {
            System.out.println("testRemoveCommand passed");
        }
    }

    static void testRemoveLastCommand() {
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(0, 0));
        command.addCommand(0, new SetPositionCommand(10, 10));
        command.removeLastCommand();

        if (command.size() != 1) {
            System.out.println("testRemoveLastCommand failed");
        } else {
            System.out.println("testRemoveLastCommand passed");
        }
    }

    static void testSetCommand() {
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(0, 0));
        command.setCommand(0, new SetPositionCommand(10, 10));

        if (!command.iterator().next().equals(new SetPositionCommand(10, 10))) {
            System.out.println("testSetCommand failed");
        } else {
            System.out.println("testSetCommand passed");
        }
    }


    static void testClear() {
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(0, 0));
        command.clear();

        if (!command.isEmpty()) {
            System.out.println("testClear failed");
        } else {
            System.out.println("testClear passed");
        }
    }


    static void testCopy() {
        ComplexCommand command = new ComplexCommand();
        command.addCommand(0, new SetPositionCommand(10, 10));
        ComplexCommand copy = (ComplexCommand) command.copy();

        if (command.size() != copy.size() || command == copy) {
            System.out.println("testCopy failed");
        } else {
            System.out.println("testCopy passed");
        }
    }

    public static void main(String[] args) {
        testIterator();
        testAddCommand();
        testAddAtIndexCommand();
        testRemoveCommand();
        testRemoveLastCommand();
        testSetCommand();
        testIsEmpty();
        testClear();
        testCopy();
    }
}