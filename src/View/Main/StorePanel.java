package View.Main;

import View.Main.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StorePanel extends JPanel {
    private MainPanel mainPanel;
    private JList listProducts;
    private DefaultListModel<String> defaultListModel;
    private JScrollPane scrollPane;
    private JTextField txtSearch;
    private JButton btnSearch;
    private JButton btnUpdate;

    public StorePanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        initializeComponents();
        initializeGUI();
        registerListeners();
    }

    private void initializeComponents() {
        txtSearch = new JTextField();
        txtSearch.setSize(new Dimension(400, 25));
        txtSearch.setPreferredSize(new Dimension(400, 25));
        txtSearch.setMinimumSize(new Dimension(400, 25));
        txtSearch.setToolTipText("Search for products by code, name or supplier...");

        defaultListModel = new DefaultListModel<>();

        listProducts = new JList<>(defaultListModel);
        listProducts.setSize(new Dimension(900, 300));
        listProducts.setPreferredSize(new Dimension(900, 300));
        listProducts.setMinimumSize(new Dimension(900, 300));

        scrollPane = new JScrollPane(listProducts, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setSize(new Dimension(500, 300));
        scrollPane.setPreferredSize(new Dimension(500, 300));
        scrollPane.setMinimumSize(new Dimension(500, 300));

        btnSearch = new JButton("Search");
        btnSearch.setSize(new Dimension(100, 25));
        btnSearch.setPreferredSize(new Dimension(100, 25));
        btnSearch.setFont(new Font("Helvetica", Font.PLAIN, 12));
        btnSearch.setOpaque(true);
        btnSearch.setBorderPainted(false);

        btnUpdate = new JButton("Update List");
        btnUpdate.setSize(new Dimension(200, 25));
        btnUpdate.setPreferredSize(new Dimension(100, 25));
        btnUpdate.setFont(new Font("Helvetica", Font.PLAIN, 12));
        btnUpdate.setOpaque(true);
        btnUpdate.setBorderPainted(false);

    }

    private void registerListeners(){
        btnSearch.addActionListener(new BtnSearchActionListener());
        btnUpdate.addActionListener(new BtnUpdateActionListener());
    }

    public static boolean isParsable(String searchedCode) {
        try {
            Integer.parseInt(searchedCode);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }

    private void initializeGUI() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(600,600));
        setMaximumSize(new Dimension(600,600));
        setMinimumSize(new Dimension(600,600));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(0, 0, 50, 0);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;

        gbc.insets = new Insets(0, 0, 0, 0);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(txtSearch, gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        add(btnSearch, gbc);

        gbc.insets = new Insets(10, 0, 10, 0);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(scrollPane, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(btnUpdate, gbc);

    }

    public void updateSearchedProducts(String searchedCode, String searchedSupplier, String searchedProduct){
        defaultListModel.removeAllElements();
        for(int i = 0; i < mainPanel.getSearchedProducts(searchedCode, searchedSupplier, searchedProduct).size(); i++){
            defaultListModel.addElement(mainPanel.getSearchedProducts(searchedCode, searchedSupplier, searchedProduct).get(i));
        }
        if(defaultListModel.isEmpty()){
            defaultListModel.addElement("No products found");
        }
    }

    public void updateProductList(){
        defaultListModel.removeAllElements();
        for(int i = 0; i < mainPanel.getProductsForCustomers().size(); i++){
            defaultListModel.addElement(mainPanel.getProductsForCustomers().get(i));
        }
    }

    private class BtnSearchActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String searchedCode = txtSearch.getText();
            String searchedSupplier = txtSearch.getText();
            String searchedProduct = txtSearch.getText();

            if(isParsable(searchedCode)){
                searchedProduct = null;
                searchedSupplier = null;
            }
            else {
                searchedCode = null;
            }

            if(!txtSearch.getText().isEmpty()){
                mainPanel.getSearchedProducts(searchedCode, searchedSupplier, searchedProduct);
                updateSearchedProducts(searchedCode, searchedSupplier, searchedProduct);
            } else {
                mainPanel.getAllProducts();
                updateProductList();
            }
        }
    }

    private class BtnUpdateActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mainPanel.getAllProducts();
            updateProductList();
        }
    }
}

