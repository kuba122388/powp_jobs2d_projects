package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.command.visitor.DriverCommandTransformVisitor;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransformCurrentCommandOptionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        DriverCommandManager commandManager = CommandsFeature.getDriverCommandManager();
        DriverCommand currentCommand = commandManager.getCurrentCommand();
        if (currentCommand == null) {
            System.out.println("No command loaded.");
            return;
        }

        DriverCommandTransformVisitor visitor = new DriverCommandTransformVisitor();
        visitor.setScaleX(1.5);
        visitor.setScaleY(1.5);
        visitor.setRotation(30.0);
        visitor.setTranslateX(50);
        visitor.setTranslateY(25);

        currentCommand.accept(visitor);
        commandManager.setCurrentCommand(visitor.getTransformedCommands(), "Transformed Command");
        System.out.println("Command transformed and updated.");
    }
}
