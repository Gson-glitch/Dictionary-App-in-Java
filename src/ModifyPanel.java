import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyPanel extends Dictionary implements ActionListener {
    private static JPanel modify_panel;
    private static JLabel wordLabel, meaningLabel, successfulLabel, anotherModifyLabel;
    private static JTextField wordEntry, meaningEntry;
    private static JButton modifyButton, yesButton, noButton;
    public ModifyPanel() {
        // Setting up the insert_panel
        modify_panel = new JPanel();
        modify_panel.setLayout(null);
//        System.out.println(insert_panel);

        // Adding the labels to the insert_panel
        wordLabel = new JLabel("Enter the word to modify: ");
        wordLabel.setBounds(40, 20, 330, 25);
        modify_panel.add(wordLabel);

        wordEntry = new JTextField(20);
        wordEntry.setBounds(40, 45, 400, 25);
        modify_panel.add(wordEntry);

        meaningLabel = new JLabel("Enter the new meaning: ");
        meaningLabel.setBounds(40, 75, 200, 25);
        modify_panel.add(meaningLabel);

        meaningEntry = new JTextField(40);
        meaningEntry.setBounds(40, 95, 400, 25);
        modify_panel.add(meaningEntry);

        // Adding the successfulLabel which lets the user know if a word has been successfully added to the dictionary
        successfulLabel = new JLabel("");
        successfulLabel.setBounds(40, 130, 400, 25);
        modify_panel.add(successfulLabel);

        // Adding the button to the panel
        modifyButton = new JButton("Modify Word");
        modifyButton.addActionListener(this);
        modifyButton.setBounds(40, 155, 400, 25);
        modify_panel.add(modifyButton);


        // Adding the anotherInsertLabel
        anotherModifyLabel = new JLabel("Do you want to modify another word?");
        anotherModifyLabel.setBounds(80,180, 330, 25);
        modify_panel.add(anotherModifyLabel);

        // Adding the yesButton and the noButton
        yesButton = new JButton("Yes");
        yesButton.addActionListener(this);
        yesButton.setBounds(40, 215, 100, 25);
        modify_panel.add(yesButton);

        noButton = new JButton("No");
        noButton.addActionListener(this);
        noButton.setBounds(345, 215, 100, 25);
        modify_panel.add(noButton);
    }

    public JPanel getModify_Panel() {
        return modify_panel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == modifyButton) {
            if (wordEntry.getText().isEmpty() || meaningEntry.getText().isEmpty()) {
                successfulLabel.setText("Please input a word and it's meaning");
            } else {
//                Dictionary D = new Dictionary();
                modifyWord(wordEntry.getText().toLowerCase(), meaningEntry.getText().toLowerCase());
                successfulLabel.setText(modifyWord(wordEntry.getText().toLowerCase(), meaningEntry.getText().toLowerCase()));
//                successfulLabel.setText(MessageFormat.format("{0} modified successfully", wordEntry.getText()));
            }
        }
        else if(actionEvent.getSource() == yesButton) {
//            System.out.println("I am the yesButton");
            wordEntry.setText("");
            meaningEntry.setText("");
            successfulLabel.setText("");
        }
        else if(actionEvent.getSource() == noButton) {
//            System.out.println("I am the noButton");
            Dictionary_GUI DG = new Dictionary_GUI();
            DG.destroyFrame();
            DG.Dictionary_GUI_Func();
        }
    }

//    public static void main(String[] args) {
//        new InsertPanel();
//        System.out.println(insert_panel);
////        System.out.println(new InsertPanel());
//    }
}
