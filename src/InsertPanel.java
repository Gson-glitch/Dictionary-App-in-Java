import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertPanel extends Dictionary implements ActionListener {
    private static JPanel insert_panel;
    private static JLabel wordLabel, meaningLabel, successfulLabel, anotherInsertLabel;
    private static JTextField wordEntry, meaningEntry;
    private static JButton addButton, yesButton, noButton;
    public InsertPanel() {
        // Setting up the insert_panel
        insert_panel = new JPanel();
        insert_panel.setLayout(null);
//        System.out.println(insert_panel);

        // Adding the labels to the insert_panel
        wordLabel = new JLabel("Enter the word to insert into the dictionary: ");
        wordLabel.setBounds(40, 20, 330, 25);
        insert_panel.add(wordLabel);

        wordEntry = new JTextField(20);
        wordEntry.setBounds(40, 45, 400, 25);
        insert_panel.add(wordEntry);

        meaningLabel = new JLabel("Enter the meaning: ");
        meaningLabel.setBounds(40, 75, 200, 25);
        insert_panel.add(meaningLabel);

        meaningEntry = new JTextField(40);
        meaningEntry.setBounds(40, 95, 400, 25);
        insert_panel.add(meaningEntry);

        // Adding the successfulLabel which lets the user know if a word has been successfully added to the dictionary
        successfulLabel = new JLabel("");
        successfulLabel.setBounds(40, 130, 400, 25);
        insert_panel.add(successfulLabel);

        // Adding the button to the panel
        addButton = new JButton("Add Word and Meaning");
        addButton.addActionListener(this);
        addButton.setBounds(40, 155, 400, 25);
        insert_panel.add(addButton);


        // Adding the anotherInsertLabel
        anotherInsertLabel = new JLabel("Do you want to perform another Insertion?");
        anotherInsertLabel.setBounds(80,180, 330, 25);
        insert_panel.add(anotherInsertLabel);

        // Adding the yesButton and the noButton
        yesButton = new JButton("Yes");
        yesButton.addActionListener(this);
        yesButton.setBounds(40, 215, 100, 25);
        insert_panel.add(yesButton);

        noButton = new JButton("No");
        noButton.addActionListener(this);
        noButton.setBounds(345, 215, 100, 25);
        insert_panel.add(noButton);
    }

    public JPanel getInsert_Panel() {
        return insert_panel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == addButton) {
            if (wordEntry.getText().isEmpty() || meaningEntry.getText().isEmpty()) {
                successfulLabel.setText("Please input a word and it's meaning");
            } else {
//                Dictionary D = new Dictionary();
//                insertWord(wordEntry.getText().toLowerCase(), meaningEntry.getText().toLowerCase());
                successfulLabel.setText(insertWord(wordEntry.getText().toLowerCase(), meaningEntry.getText().toLowerCase()));
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
