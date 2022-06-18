import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPanel extends Dictionary implements ActionListener {
    private static JPanel search_panel;
    private static JLabel wordToSearchLabel, meaningLabel, anotherSearchLabel;
    private static JTextField wordToSearchTextField;
    private static JButton yesButton, noButton;
    public SearchPanel() {
        // Setting up the search_panel
        search_panel = new JPanel();
        search_panel.setLayout(null);

        // Adding the labels to the search_panel
        wordToSearchLabel = new JLabel("Enter the word to search");
        wordToSearchLabel.setBounds(40, 20, 330, 25);
        search_panel.add(wordToSearchLabel);

        wordToSearchTextField = new JTextField(20);
        wordToSearchTextField.addActionListener(this);
        wordToSearchTextField.setBounds(40, 45, 400, 25);
        search_panel.add(wordToSearchTextField);

        meaningLabel = new JLabel("");
        meaningLabel.setBounds(40, 75, 500, 25);
        search_panel.add(meaningLabel);

        anotherSearchLabel = new JLabel("Would you wish to make another search? ");
        anotherSearchLabel.setBounds(40, 100, 400, 25);
        search_panel.add(anotherSearchLabel);

        yesButton = new JButton("Yes");
        yesButton.addActionListener(this);
        yesButton.setBounds(40, 140, 100, 25);
        search_panel.add(yesButton);

        noButton = new JButton("No");
        noButton.addActionListener(this);
        noButton.setBounds(215, 140, 100, 25);
        search_panel.add(noButton);

    }
    public JPanel getSearch_panel() {
        return search_panel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == wordToSearchTextField) {
            if (wordToSearchTextField.getText().isEmpty()) {
                meaningLabel.setText("You have not entered a word yet.");
            } else {
//                Dictionary D = new Dictionary();
//                initializeDictionary();
                meaningLabel.setText(searchWord(wordToSearchTextField.getText().toLowerCase()));
            }
        }
        else if(actionEvent.getSource() == yesButton) {
//            System.out.println("I'm the yesButton");
            wordToSearchTextField.setText("");
            meaningLabel.setText("");
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
