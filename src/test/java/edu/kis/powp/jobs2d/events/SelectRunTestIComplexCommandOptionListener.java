package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.ImmutableComplexCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.features.DriverFeature;

public class SelectRunTestIComplexCommandOptionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {


        List<DriverCommand> commands = new ArrayList<DriverCommand>();
        commands.add(new SetPositionCommand(-80, -40));
        commands.add(new OperateToCommand(-20, 50));
        commands.add(new SetPositionCommand(70, -50));
        commands.add(new OperateToCommand(20, -50));
        commands.add(new OperateToCommand(80, 20));
        commands.add(new OperateToCommand(70, 20));
        commands.add(new OperateToCommand(140, 50));
        commands.add(new OperateToCommand(20, 50));

        ImmutableComplexCommand complexCommand = new ImmutableComplexCommand(commands);
        complexCommand.execute(DriverFeature.getDriverManager().getCurrentDriver());
    }
}