import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePanel extends Dictionary implements ActionListener {
    private static JPanel delete_panel;
    private static JLabel wordToDeleteLabel, deletionStatusLabel, anotherDeleteLabel;
    private static JTextField wordToDeleteTextField;
    private static JButton yesButton, noButton;
    public DeletePanel() {
        // Setting up the search_panel
        delete_panel = new JPanel();
        delete_panel.setLayout(null);

        // Adding the labels to the search_panel
        wordToDeleteLabel = new JLabel("Enter the word to delete");
        wordToDeleteLabel.setBounds(40, 20, 330, 25);
        delete_panel.add(wordToDeleteLabel);

        wordToDeleteTextField = new JTextField(20);
        wordToDeleteTextField.addActionListener(this);
        wordToDeleteTextField.setBounds(40, 45, 400, 25);
        delete_panel.add(wordToDeleteTextField);

        deletionStatusLabel = new JLabel("");
        deletionStatusLabel.setBounds(40, 75, 500, 25);
        delete_panel.add(deletionStatusLabel);

        anotherDeleteLabel = new JLabel("Would you wish to make another deletion? ");
        anotherDeleteLabel.setBounds(40, 100, 400, 25);
        delete_panel.add(anotherDeleteLabel);

        yesButton = new JButton("Yes");
        yesButton.addActionListener(this);
        yesButton.setBounds(40, 140, 100, 25);
        delete_panel.add(yesButton);

        noButton = new JButton("No");
        noButton.addActionListener(this);
        noButton.setBounds(215, 140, 100, 25);
        delete_panel.add(noButton);

    }
    public JPanel getDelete_panel() {
        return delete_panel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == wordToDeleteTextField) {
            if (wordToDeleteTextField.getText().isEmpty()) {
                deletionStatusLabel.setText("You have not entered a word yet.");
            } else {
//                Dictionary D = new Dictionary();
                deletionStatusLabel.setText(deleteWord(wordToDeleteTextField.getText().toLowerCase()));
                deleteWord(wordToDeleteTextField.getText());
            }
        }
        else if(actionEvent.getSource() == yesButton) {
//            System.out.println("I'm the yesButton");
            wordToDeleteTextField.setText("");
            deletionStatusLabel.setText("");
        }
        else if(actionEvent.getSource() == noButton) {
            Dictionary_GUI DG = new Dictionary_GUI();
            DG.destroyFrame();
            DG.Dictionary_GUI_Func();
//            System.out.println("I'm the noButton");
        }
//        System.out.println(wordToSearchTextField.getText());
    }
}
