package View.Main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogInPanel extends JPanel {
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JLabel lblPassword;
    private JPasswordField txtPassword;
    private JButton btnLogIn;
    private MainPanel mainPanel;
    private JLabel lblNoAccount;


    public LogInPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        initializeComponents();
        initializeGUI();
        registerListeners();
    }

    private void initializeComponents() {
        lblUsername = new JLabel("Username: ");
        txtUsername = new JTextField();
        txtUsername.setMinimumSize(new Dimension(80,20));
        txtUsername.setPreferredSize(new Dimension(80,20));

        lblPassword = new JLabel("Password: ");
        txtPassword = new JPasswordField();
        txtPassword.setMinimumSize(new Dimension(80,20));
        txtPassword.setPreferredSize(new Dimension(80,20));

        btnLogIn = new JButton("Log in");
        btnLogIn.setMinimumSize(new Dimension(60,20));
        btnLogIn.setPreferredSize(new Dimension(60,20));
        btnLogIn.setFont(new Font("Helvetica", Font.PLAIN, 9));
        btnLogIn.setOpaque(true);
        btnLogIn.setBorderPainted(false);

        lblNoAccount = new JLabel("Create account!");
        lblNoAccount.setMinimumSize(new Dimension(100,30));
        lblNoAccount.setPreferredSize(new Dimension(100,30));

    }

    private void initializeGUI() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(600, 100));
        setMaximumSize(new Dimension(600,100));
        setMinimumSize(new Dimension(600,100));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblUsername, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtUsername, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        add(lblPassword, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        add(txtPassword, gbc);

        gbc.gridx = 4;
        gbc.gridy = 0;
        add(btnLogIn, gbc);

        gbc.gridx = 5;
        gbc.gridy = 0;
        add(lblNoAccount, gbc);
    }

    private void registerListeners() {
        btnLogIn.addActionListener(new BtnLoginListener());
        lblNoAccount.addMouseListener(new LabelListener());
    }

    public String getUsernameLogin(){
        return txtUsername.getText();
    }

    public String getPasswordLogin() {
        char[] charPass = txtPassword.getPassword();
        return String.valueOf(charPass);
    }

    private class BtnLoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String userNameLogin = txtUsername.getText();
            char[] charPass = txtPassword.getPassword();
            String passwordLogin = String.valueOf(charPass);

            if(!mainPanel.isUserCostumer(userNameLogin, passwordLogin) && mainPanel.isUserAdmin(userNameLogin, passwordLogin)) {
                mainPanel.updateAdminView();
            } else if(mainPanel.isUserCostumer(userNameLogin, passwordLogin) && !mainPanel.isUserAdmin(userNameLogin, passwordLogin)){
                mainPanel.updateUserView();
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Username or password!");
            }
        }
    }

    private class LabelListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            mainPanel.openCreateAccountWindow();
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
            lblNoAccount.setText("<HTML><U>Create account!</U></HTML>");
            lblNoAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }

}

