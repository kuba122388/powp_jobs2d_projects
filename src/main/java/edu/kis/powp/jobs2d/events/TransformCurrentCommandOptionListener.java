package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.command.visitor.DriverCommandTransformVisitor;
import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.jobs2d.transformations.FlipTransformationDecorator;
import edu.kis.powp.jobs2d.transformations.RotateTransformationDecorator;
import edu.kis.powp.jobs2d.transformations.ScaleTransformationDecorator;
import edu.kis.powp.jobs2d.transformations.TranslateTransformationDecorator;

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
        visitor.addTransformation(new ScaleTransformationDecorator(1.5, 1.5));
        visitor.addTransformation(new RotateTransformationDecorator(30));
        visitor.addTransformation(new TranslateTransformationDecorator(50, 25));
        visitor.addTransformation(new FlipTransformationDecorator(true, false));

        currentCommand.accept(visitor);
        commandManager.setCurrentCommand(visitor.getTransformedCommands(), "Transformed Command");
        System.out.println("Command transformed and updated.");
    }
}
