package edu.kis.powp.jobs2d.command.gui;

import edu.kis.powp.jobs2d.command.*;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ComplexCommandEditorUI extends JFrame {
    private final DriverCommandManager manager;
    private ComplexCommandEditor editor;
    private DefaultListModel<DriverCommand> listModel;
    private JList<DriverCommand> commandList;

    public ComplexCommandEditorUI(DriverCommandManager manager) {
        this.manager = manager;

        if (manager.getCurrentCommand() instanceof ICompoundCommand) {
            this.editor = new ComplexCommandEditor((ICompoundCommand) manager.getCurrentCommand());
        } else {
            this.editor = new ComplexCommandEditor();
        }

        setupUI();
    }

    private void setupUI() {
        setTitle("Complex Command Editor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        updateListModel();
        commandList = new JList<>(listModel);
        add(new JScrollPane(commandList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 5));

        buttonPanel.add(new JButton(new AbstractAction("Add Command") {
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                String[] commandOptions = {"SetPosition", "OperateTo"};
                JComboBox<String> commandType = new JComboBox<>(commandOptions);
                JTextField inputX = new JTextField(5);
                JTextField inputY = new JTextField(5);

                panel.add(new JLabel("Command Type:"));
                panel.add(commandType);
                panel.add(new JLabel("X:"));
                panel.add(inputX);
                panel.add(new JLabel("Y:"));
                panel.add(inputY);

                int result = JOptionPane.showConfirmDialog(null, panel, "Add Command",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    try {
                        int x = Integer.parseInt(inputX.getText());
                        int y = Integer.parseInt(inputY.getText());

                        DriverCommand command;
                        if ("SetPosition".equals(commandType.getSelectedItem())) {
                            command = new SetPositionCommand(x, y);
                        } else {
                            command = new OperateToCommand(x, y);
                        }

                        editor.addCommand(command);
                        updateListModel();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input: X and Y must be integers.");
                    }
                }
            }
        }));

        buttonPanel.add(new JButton(new AbstractAction("Remove") {
            public void actionPerformed(ActionEvent e) {
                int index = commandList.getSelectedIndex();
                if (index != -1) {
                    editor.removeCommand(index);
                    updateListModel();
                }
            }
        }));

        buttonPanel.add(new JButton(new AbstractAction("Up") {
            public void actionPerformed(ActionEvent e) {
                int index = commandList.getSelectedIndex();
                if (index > 0) {
                    editor.moveCommand(index, index - 1);
                    updateListModel();
                    commandList.setSelectedIndex(index - 1);
                }
            }
        }));

        buttonPanel.add(new JButton(new AbstractAction("Down") {
            public void actionPerformed(ActionEvent e) {
                int index = commandList.getSelectedIndex();
                if (index < listModel.size() - 1) {
                    editor.moveCommand(index, index + 1);
                    updateListModel();
                    commandList.setSelectedIndex(index + 1);
                }
            }
        }));

        buttonPanel.add(new JButton(new AbstractAction("Apply") {
            public void actionPerformed(ActionEvent e) {
                manager.setCurrentCommand(editor.getCommands(), "Edited Command");
                JOptionPane.showMessageDialog(null, "Command updated in manager.");
            }
        }));

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void updateListModel() {
        listModel.clear();
        for (DriverCommand cmd : editor.getCommands()) {
            listModel.addElement(cmd);
        }
    }

}
