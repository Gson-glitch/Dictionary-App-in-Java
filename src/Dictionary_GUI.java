import javax.swing.*;
import java.awt.event.ActionEvent;

public class Dictionary_GUI {
    private static JFrame frame;
    private static JPanel welcomePanel;
    private static JLabel welcomeLabel, chooseOperationLabel, insertLabel, searchLabel, deleteLabel, modifyLabel, quitLabel;
    private static JTextField choice;

    public void Dictionary_GUI_Func() {
        // Setting up the frame
        frame = new JFrame();
        frame.setTitle("Dictionary App");
        frame.setSize(500, 280);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting up the welcomePanel
        welcomePanel = new JPanel();
//        System.out.println(welcomePanel);
        frame.add(welcomePanel);

        welcomePanel.setLayout(null);

        // Setting up the labels and adding them to the welcomePanel
        welcomeLabel = new JLabel("Welcome to my Dictionary App.");
        welcomeLabel.setBounds(130, 30, 400, 25);
        welcomePanel.add(welcomeLabel, "push, align center");

        chooseOperationLabel = new JLabel("Enter an operation: ");
        chooseOperationLabel.setBounds(40, 80, 240, 25);
        welcomePanel.add(chooseOperationLabel, "push, align center");

        choice = new JTextField(20);
        choice.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                System.out.println(choice.getText());
                try {
                    int option = Integer.parseInt(choice.getText());
                    switch (option) {
                        case 1:
                            InsertPanel I = new InsertPanel();
                            frame.getContentPane().remove(welcomePanel);
                            frame.add(I.getInsert_Panel());
                            frame.getContentPane().invalidate();
                            frame.getContentPane().validate();
                            break;
                        case 2:
                            SearchPanel S = new SearchPanel();
                            frame.getContentPane().remove(welcomePanel);
                            frame.add(S.getSearch_panel());
                            frame.getContentPane().invalidate();
                            frame.getContentPane().validate();
                            break;
                        case 3:
                            DeletePanel D = new DeletePanel();
                            frame.getContentPane().remove(welcomePanel);
                            frame.add(D.getDelete_panel());
                            frame.getContentPane().invalidate();
                            frame.getContentPane().validate();
                            break;
                        case 4:
                            ModifyPanel M = new ModifyPanel();
                            frame.getContentPane().remove(welcomePanel);
                            frame.add(M.getModify_Panel());
                            frame.getContentPane().invalidate();
                            frame.getContentPane().validate();
                            break;
                        case 7:
                            new Sort();
                            destroyFrame();
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                }
                catch (NumberFormatException ignored) { }
            }
        });
        choice.setBounds(240, 80, 165, 25);
        welcomePanel.add(choice);

        insertLabel = new JLabel("1. Insert a new word with its meanings");
        insertLabel.setBounds(40, 120, 300, 35);
        welcomePanel.add(insertLabel);

        searchLabel = new JLabel("2. Search for a word");
        searchLabel.setBounds(40, 140, 300, 35);
        welcomePanel.add(searchLabel);

        deleteLabel = new JLabel("3. Delete a word and its meanings");
        deleteLabel.setBounds(40, 160, 300, 35);
        welcomePanel.add(deleteLabel);

        modifyLabel = new JLabel("4. Modify the meanings of a word");
        modifyLabel.setBounds(40, 180, 300, 35);
        welcomePanel.add(modifyLabel);

        quitLabel = new JLabel("7. Save changes and exit.");
        quitLabel.setBounds(40, 200, 300, 35);
        welcomePanel.add(quitLabel);

        frame.setVisible(true);
    }
    public static void main(String[] args) {
       Dictionary_GUI Test = new Dictionary_GUI();
       Test.Dictionary_GUI_Func();
    }
    public  void destroyFrame() {
        frame.dispose();
    }
}
