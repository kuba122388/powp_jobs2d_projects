package edu.kis.powp.jobs2d.command;

public class SimpleDriverCommandCountingVisitor implements DriverCommandVisitor {
    private int total;

    @Override
    public void visit(SetPositionCommand command) {
    }

    public int getTotal() {
        return total;
    }

    @Override
    public void visit(OperateToCommand command) {
    }

    @Override
    public void visit(ICompoundCommand compoundCommand) {
        total = 0;
        for (DriverCommand subCommand : compoundCommand) {
            subCommand.accept(this);
            total++;
        }
    }
}