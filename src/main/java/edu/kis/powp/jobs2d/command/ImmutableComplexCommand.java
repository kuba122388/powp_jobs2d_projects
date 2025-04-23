package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class ImmutableComplexCommand implements ICompoundCommand {

    private final List<DriverCommand> commands;

    public ImmutableComplexCommand(List<DriverCommand> commands) {
        // Defensive copy + unmodifiable wrapper for immutability
        this.commands = Collections.unmodifiableList(new ArrayList<>(commands));
    }

    @Override
    public void execute(Job2dDriver driver) {
        for (DriverCommand command : commands) {
            command.execute(driver);
        }
    }

    @Override
    public Iterator<DriverCommand> iterator() {
        return commands.iterator();
    }

    @Override
    public DriverCommand copy() {
        List<DriverCommand> copiedCommands = new ArrayList<>();
        for (DriverCommand command : commands) {
            copiedCommands.add(command.copy());
        }
        return new ImmutableComplexCommand(copiedCommands);
    }
}
