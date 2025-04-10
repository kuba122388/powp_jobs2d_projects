package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.command.*;

public class SimpleCountingVisitor implements DriverCommandVisitor {

    private int commandCount = 0;

    @Override
    public void visit(SetPositionCommand command) {
        commandCount++;
    }

    @Override
    public void visit(OperateToCommand command) {
        commandCount++;
    }

    @Override
    public void visit(ICompoundCommand command) {
        commandCount++;
    }

    public int getCommandCount() {
        return commandCount;
    }
}
