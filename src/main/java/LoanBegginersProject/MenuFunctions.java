package LoanBegginersProject;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class MenuFunctions {
    JFrame Loan_Menu = new JFrame();
    JPanel details = new JPanel();
    JPanel loan_details = new JPanel();
    JLabel main_display = new JLabel("Loan Management System");
    JButton deposits_menu = new JButton("Deposits");
    JButton withdrawal_menu = new JButton("Withdrawals");
    JButton overdrafts_menu = new JButton("overdrafts");
    JButton account_menu = new JButton("Account Balance");
    JLabel name = new JLabel("Name");
    JTextField name_field = new JTextField();
    JLabel surname = new JLabel("Surname");
    JTextField surname_field = new JTextField();
    JLabel address = new JLabel("Address");
    JTextField address_field = new JTextField();
    JLabel account_type = new JLabel("Account Number");
    JTextField account_field = new JTextField();
    JLabel deposit = new JLabel("Deposit");
    JTextField deposit_field = new JTextField();
    JLabel withdrawal = new JLabel("Withdrawal");
    JTextField withdrawal_field = new JTextField();
    JLabel overdraft = new JLabel("Overdraft Required ?");
    JTextField overdraft_field = new JTextField();
    JLabel details_background = new JLabel();
    JLabel loan_amount = new JLabel("Amount of Loan");
    JTextField loan_amount_field = new JTextField();
    JLabel interest_rate = new JLabel("Interest Rate");
    JTextField interest_field = new JTextField();
    JLabel total_payments = new JLabel("Number of Payments");
    JTextField total_payments_field = new JTextField();
    JLabel monthly_payments = new JLabel("Monthly Payments");
    JTextField monthly_payments_field = new JTextField();
    JButton calculate_loan = new JButton("Calculate");
    JButton clear = new JButton("Clear");
    JButton calculate_and_save = new JButton("Calculate & Save");
    JButton Deposits = new JButton("Deposits");
    JButton Overdrafts_button = new JButton("Overdrafts");
    JButton Withdrawals = new JButton("Withdrawals");
    JTextArea show_loan_details = new JTextArea();
    JTable table = new JTable();
    JScrollPane scrollPane;
    DefaultTableModel model;
    String[] column_header;
    private final String databaseUrl;
    private final String password;
    private final String username;
    private Object[] columns;
    JFrame depositsFrame;
    JButton depositsRefresh;
    JTable depositsTable;
    JLabel depositsLabel;
    DefaultTableModel depositModel;
    String[] depositCols;
    JScrollPane depositsScrollPane;
    JFrame withdrawalsFrame;
    JButton withdrawalsRefresh;
    JTable withdrawalsTable;
    JLabel withdrawalsLabel;
    DefaultTableModel withdrawalsModel;
    String[] withdrawalsCols;
    JScrollPane withdrawalsScrollPane;
    JFrame overdraftsFrame;
    JButton overdraftsRefresh;
    JTable overdraftsTable;
    JLabel overdraftsLabel;
    DefaultTableModel overdraftsDefaultTableModel;
    String[] overdraftsCols;
    JScrollPane overdraftsScrollPane;
    JFrame AccountFrame;
    JButton accountRefresh;
    JTable accountTable;
    JLabel accountLabel;
    DefaultTableModel accountDefaultTableModel;
    String[] accountCols;
    JScrollPane accountScrollPane;

    MenuFunctions() {
        this.scrollPane = new JScrollPane(this.table);
        this.model = new DefaultTableModel();
        this.column_header = new String[]{"name", "Surname", "Address", "Account Type", "Loan Amount", "Interest Rate", "No: of Payments", "Monthly payments"};
        this.databaseUrl = "jdbc:mysql://localhost:3306/loan_info";
        this.password = "";
        this.username = "root";
        this.columns = new Object[9];
        this.depositsFrame = new JFrame();
        this.depositsRefresh = new JButton("Reload");
        this.depositsTable = new JTable();
        this.depositsLabel = new JLabel("Account Deposits");
        this.depositModel = new DefaultTableModel();
        this.depositCols = new String[]{"Name", "Surname", "Account Number", "Amount Deposited", "Date", "Time Stamp"};
        this.depositsScrollPane = new JScrollPane(this.depositsTable);
        this.withdrawalsFrame = new JFrame();
        this.withdrawalsRefresh = new JButton("Reload");
        this.withdrawalsTable = new JTable();
        this.withdrawalsLabel = new JLabel("Account Withdrawals");
        this.withdrawalsModel = new DefaultTableModel();
        this.withdrawalsCols = new String[]{"Name", "Surname", "Account Number", "Withdrawals", "Date", "Time Stamp"};
        this.withdrawalsScrollPane = new JScrollPane(this.withdrawalsTable);
        this.overdraftsFrame = new JFrame();
        this.overdraftsRefresh = new JButton("Reload");
        this.overdraftsTable = new JTable();
        this.overdraftsLabel = new JLabel("Account Overdrafts");
        this.overdraftsDefaultTableModel = new DefaultTableModel();
        this.overdraftsCols = new String[]{"Name", "Surname", "Account Number", "Overdrafts", "Date", "Time Stamp"};
        this.overdraftsScrollPane = new JScrollPane(this.overdraftsTable);
        this.AccountFrame = new JFrame();
        this.accountRefresh = new JButton("Reload");
        this.accountTable = new JTable();
        this.accountLabel = new JLabel("Account Balance");
        this.accountDefaultTableModel = new DefaultTableModel();
        this.accountCols = new String[]{"Name", "Surname", "Account Number", "Deposits", "Withdrawals", "Account Balance", "Overdrafts", "Date", "Time Stamp"};
        this.accountScrollPane = new JScrollPane(this.accountTable);
        this.Loan_Menu.setDefaultCloseOperation(3);
        this.Loan_Menu.setResizable(false);
        this.Loan_Menu.setSize(1250, 700);
        this.Loan_Menu.getContentPane().setBackground(Color.DARK_GRAY);
        this.Loan_Menu.setLayout((LayoutManager)null);
        this.details.setLayout((LayoutManager)null);
        this.loan_details.setLayout((LayoutManager)null);
        this.details_background.setBounds(0, 0, 1366, 400);
        this.details.setBounds(0, 40, 1366, 420);
        this.details.setBackground(Color.lightGray);
        this.loan_details.setBounds(560, 0, 780, 420);
        this.loan_details.setBackground(Color.GRAY);
        this.deposits_menu.setBounds(0, 0, 200, 30);
        this.deposits_menu.setSize(140, 40);
        this.deposits_menu.setBackground(Color.darkGray);
        this.deposits_menu.setForeground(Color.WHITE);
        this.deposits_menu.setBorder(new LineBorder(Color.RED, 2));
        this.deposits_menu.setFont(new Font("Tahoma", 1, 14));
        this.deposits_menu.setFocusable(false);
        this.withdrawal_menu.setBounds(140, 0, 200, 30);
        this.withdrawal_menu.setSize(140, 40);
        this.withdrawal_menu.setBackground(Color.darkGray);
        this.withdrawal_menu.setForeground(Color.WHITE);
        this.withdrawal_menu.setBorder(new LineBorder(Color.RED, 2));
        this.withdrawal_menu.setFont(new Font("Tahoma", 1, 14));
        this.withdrawal_menu.setFocusable(false);
        this.overdrafts_menu.setBounds(280, 0, 200, 30);
        this.overdrafts_menu.setSize(140, 40);
        this.overdrafts_menu.setBackground(Color.darkGray);
        this.overdrafts_menu.setForeground(Color.WHITE);
        this.overdrafts_menu.setBorder(new LineBorder(Color.RED, 2));
        this.overdrafts_menu.setFont(new Font("Tahoma", 1, 14));
        this.overdrafts_menu.setFocusable(false);
        this.account_menu.setBounds(420, 0, 200, 30);
        this.account_menu.setSize(140, 40);
        this.account_menu.setBackground(Color.darkGray);
        this.account_menu.setForeground(Color.WHITE);
        this.account_menu.setBorder(new LineBorder(Color.RED, 2));
        this.account_menu.setFont(new Font("Tahoma", 1, 14));
        this.account_menu.setFocusable(false);
        this.main_display.setBounds(10, 10, 540, 40);
        this.main_display.setFont(new Font("Copperplate", 1, 40));
        this.main_display.setForeground(Color.darkGray);
        this.main_display.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        this.name.setBounds(10, 80, 100, 20);
        this.name.setFont(new Font("Copperplate", 1, 20));
        this.name_field.setFont(new Font("Copperplate", 1, 20));
        this.name_field.setBounds(10, 100, 250, 30);
        this.surname.setBounds(10, 140, 100, 20);
        this.surname.setFont(new Font("Copperplate", 1, 20));
        this.surname_field.setFont(new Font("Copperplate", 1, 20));
        this.surname_field.setBounds(10, 160, 250, 30);
        this.address.setBounds(10, 200, 100, 20);
        this.address.setFont(new Font("Copperplate", 1, 20));
        this.address_field.setFont(new Font("Copperplate", 1, 20));
        this.address_field.setBounds(10, 240, 250, 30);
        this.account_type.setBounds(10, 280, 200, 20);
        this.account_type.setFont(new Font("Copperplate", 1, 20));
        this.account_field.setFont(new Font("Copperplate", 1, 20));
        this.account_field.setBounds(10, 320, 250, 30);
        this.deposit.setBounds(300, 80, 200, 20);
        this.deposit.setFont(new Font("Copperplate", Font.BOLD, 20));
        this.deposit_field.setFont(new Font("Copperplate", 1, 20));
        this.deposit_field.setBounds(300, 100, 250, 30);
        this.withdrawal.setBounds(300, 140, 200, 20);
        this.withdrawal.setFont(new Font("Copperplate", 1, 20));
        this.withdrawal_field.setFont(new Font("Copperplate", 1, 20));
        this.withdrawal_field.setBounds(300, 160, 250, 30);
        this.overdraft.setBounds(300, 200, 200, 20);
        this.overdraft.setFont(new Font("Copperplate", 1, 20));
        this.overdraft_field.setFont(new Font("Copperplate", 1, 20));
        this.overdraft_field.setBounds(300, 240, 150, 30);
        this.Overdrafts_button.setBounds(470, 240, 80, 20);
        this.Overdrafts_button.setSize(80, 30);
        this.Overdrafts_button.setBackground(Color.darkGray);
        this.Overdrafts_button.setForeground(Color.WHITE);
        this.Overdrafts_button.setBorder(new LineBorder(Color.RED, 2));
        this.Overdrafts_button.setFont(new Font("Tahoma", 1, 12));
        this.Overdrafts_button.setFocusable(false);
        this.Deposits.setBounds(450, 300, 250, 20);
        this.Deposits.setSize(100, 30);
        this.Deposits.setBackground(Color.darkGray);
        this.Deposits.setForeground(Color.WHITE);
        this.Deposits.setBorder(new LineBorder(Color.RED, 2));
        this.Deposits.setFont(new Font("Tahoma", Font.BOLD, 14));
        this.Deposits.setFocusable(false);
        this.Withdrawals.setBounds(270, 300, 200, 20);
        this.Withdrawals.setSize(140, 30);
        this.Withdrawals.setBackground(Color.darkGray);
        this.Withdrawals.setForeground(Color.WHITE);
        this.Withdrawals.setBorder(new LineBorder(Color.RED, 2));
        this.Withdrawals.setFont(new Font("Tahoma", Font.BOLD, 14));
        this.Withdrawals.setFocusable(false);
        this.calculate_and_save.setBounds(270, 350, 200, 20);
        this.calculate_and_save.setSize(140, 30);
        this.calculate_and_save.setBackground(Color.darkGray);
        this.calculate_and_save.setForeground(Color.WHITE);
        this.calculate_and_save.setBorder(new LineBorder(Color.RED, 2));
        this.calculate_and_save.setFont(new Font("Tahoma", Font.BOLD, 14));
        this.calculate_and_save.setFocusable(false);
        this.clear.setBounds(450, 350, 250, 20);
        this.clear.setSize(100, 30);
        this.clear.setBackground(Color.darkGray);
        this.clear.setForeground(Color.WHITE);
        this.clear.setBorder(new LineBorder(Color.RED, 2));
        this.clear.setFont(new Font("Tahoma", 1, 14));
        this.clear.setFocusable(false);
        this.details.add(this.details_background);
        this.loan_amount.setBounds(15, 80, 200, 20);
        this.loan_amount.setFont(new Font("Copperplate", 1, 20));
        this.loan_amount_field.setFont(new Font("Copperplate", 1, 20));
        this.loan_amount_field.setBounds(10, 100, 250, 30);
        this.interest_rate.setBounds(15, 135, 200, 20);
        this.interest_rate.setFont(new Font("Copperplate", 1, 20));
        this.interest_field.setFont(new Font("Copperplate", 1, 20));
        this.interest_field.setBounds(10, 165, 250, 30);
        this.total_payments.setBounds(15, 200, 200, 20);
        this.total_payments.setFont(new Font("Copperplate", 1, 20));
        this.total_payments_field.setFont(new Font("Copperplate", 1, 20));
        this.total_payments_field.setBounds(10, 240, 250, 30);
        this.monthly_payments.setBounds(15, 280, 200, 20);
        this.monthly_payments.setFont(new Font("Copperplate", 1, 20));
        this.monthly_payments_field.setFont(new Font("Copperplate", 1, 20));
        this.monthly_payments_field.setBounds(10, 310, 250, 30);
        this.calculate_loan.setBounds(80, 350, 250, 20);
        this.calculate_loan.setSize(100, 30);
        this.calculate_loan.setBackground(Color.darkGray);
        this.calculate_loan.setForeground(Color.WHITE);
        this.calculate_loan.setBorder(new LineBorder(Color.RED, 2));
        this.calculate_loan.setFont(new Font("Tahoma", 1, 14));
        this.calculate_loan.setFocusable(false);
        this.show_loan_details.setBounds(280, 0, 400, 400);
        this.show_loan_details.setFont(new Font("Copperplate", 1, 20));
        this.show_loan_details.setBackground(Color.getHSBColor(16.0F, 44.0F, 89.0F));
        this.show_loan_details.setEditable(false);
        this.show_loan_details.append("         CUSTOMER LOAN DETAILS\n");
        this.table.setModel(this.model);
        this.table.setRowHeight(30);
        this.table.setAutoCreateRowSorter(true);
        this.table.setSize(1270, 180);
        this.table.setSelectionBackground(Color.lightGray);
        this.table.setBackground(Color.white);
        this.scrollPane.setBounds(0, 440, 1240, 260);
        this.scrollPane.setForeground(Color.lightGray);
        this.model.setColumnIdentifiers(this.column_header);
        this.details_background.add(this.main_display);
        this.details_background.add(this.name);
        this.details_background.add(this.name_field);
        this.details_background.add(this.surname);
        this.details_background.add(this.surname_field);
        this.details_background.add(this.address);
        this.details_background.add(this.address_field);
        this.details_background.add(this.account_type);
        this.details_background.add(this.account_field);
        this.details_background.add(this.deposit);
        this.details_background.add(this.deposit_field);
        this.details_background.add(this.withdrawal);
        this.details_background.add(this.withdrawal_field);
        this.details_background.add(this.overdraft);
        this.details_background.add(this.overdraft_field);
        this.details_background.add(this.Deposits);
        this.details_background.add(this.Overdrafts_button);
        this.details_background.add(this.Withdrawals);
        this.details_background.add(this.calculate_and_save);
        this.details_background.add(this.clear);
        this.details_background.add(this.loan_details);
        this.loan_details.add(this.loan_amount);
        this.loan_details.add(this.loan_amount_field);
        this.loan_details.add(this.interest_rate);
        this.loan_details.add(this.interest_field);
        this.loan_details.add(this.total_payments);
        this.loan_details.add(this.total_payments_field);
        this.loan_details.add(this.monthly_payments);
        this.loan_details.add(this.monthly_payments_field);
        this.loan_details.add(this.calculate_loan);
        this.loan_details.add(this.show_loan_details);
        this.Loan_Menu.add(this.details);
        this.Loan_Menu.add(this.deposits_menu);
        this.Loan_Menu.add(this.withdrawal_menu);
        this.Loan_Menu.add(this.overdrafts_menu);
        this.Loan_Menu.add(this.account_menu);
        this.Loan_Menu.add(this.scrollPane);
        this.Loan_Menu.setVisible(true);
        this.calculate_loan.addActionListener((onclick) -> {
            this.CalculateLoan();
            this.Retrieve_info();
        });
        this.calculate_and_save.addActionListener((onclick) -> {
            this.CalculateAndSave();
            this.Retrieve_info();
        });
        this.clear.addActionListener((clearAllFields) -> {
            this.ClearAllFields();
        });
        this.deposits_menu.addActionListener((onclick) -> {
            this.Deposits();
        });
        this.withdrawal_menu.addActionListener((onclick) -> {
            this.Withdrawals();
        });
        this.overdrafts_menu.addActionListener((onclick) -> {
            this.Overdrafts();
        });
        this.account_menu.addActionListener((onclick) -> {
            this.AccountBalance();
        });
        this.Deposits.addActionListener((onclick) -> {
            this.DepositsDatabase();
        });
        this.depositsRefresh.addActionListener((onclick) -> this.RefreshDepositsDatabase());
        this.Overdrafts_button.addActionListener((onclick) -> {
            this.OverdraftsDatabase();
        });
        this.overdraftsRefresh.addActionListener((onclick) -> this.RefreshOverdraftsDatabase());
        this.Withdrawals.addActionListener((onclick) -> this.WithdrawalsDatabase());
        this.withdrawalsRefresh.addActionListener((onclick) -> {
            this.RefreshWithdrawalsDatabase();
        });
        this.accountRefresh.addActionListener((onclick) -> {
            this.RefreshAccountBalanceDatabase();
        });
    }

    private void CalculateLoan() {
        if (this.loan_amount_field.getText().equals("")) {
            JOptionPane.showMessageDialog((Component)null, "Please Enter: Loan Amount", "AmountError", 0);
        } else if (this.interest_field.getText().equals("")) {
            JOptionPane.showMessageDialog((Component)null, "Please Enter Interest Rate ", "InterestError", 0);
        } else if (this.total_payments_field.getText().equals("")) {
            JOptionPane.showMessageDialog((Component)null, "Please Enter No of Payments ", "PaymentsError", 0);
        } else {
            Double Loan_amount = Double.parseDouble(this.loan_amount_field.getText());
            Double interest = Double.parseDouble(this.interest_field.getText());
            Double numberOfPayments = Double.parseDouble(this.total_payments_field.getText());
            Double totalinterest = Loan_amount * interest;
            Double totalAmountPlusInterest = totalinterest * numberOfPayments + Loan_amount;
            Double monthlypayments = totalAmountPlusInterest / numberOfPayments;
            this.monthly_payments_field.setText(monthlypayments.toString());
            System.out.println("number of payments" + numberOfPayments);
            System.out.println("amount of interest" + totalinterest * numberOfPayments);
            System.out.println("total payments" + totalAmountPlusInterest);
            System.out.println("monthly payments" + monthlypayments);
            this.show_loan_details.setText("");
            this.show_loan_details.append("         CUSTOMER LOAN DETAILS\n");
            this.show_loan_details.append("\n");
            this.show_loan_details.append("\n");
            this.show_loan_details.append("Name: " + this.name_field.getText() + "\n");
            this.show_loan_details.append("Surname: " + this.surname_field.getText() + "\n");
            this.show_loan_details.append("Loan Amount: $ " + Loan_amount + "\n");
            this.show_loan_details.append("Interest Rate: " + interest + "\n");
            this.show_loan_details.append("Monthly Payment:$ " + monthlypayments + "\n");
            this.show_loan_details.append("Total Payment: $ " + totalAmountPlusInterest);
            this.show_loan_details.append("\n");
            this.show_loan_details.append("\n");
            this.show_loan_details.append("        Thank you choosing us :)\n");
        }

    }

    public void CalculateAndSave() {
        if (this.name_field.getText().equals("")) {
            JOptionPane.showMessageDialog((Component)null, "Please Enter: Name", "NameError", 0);
        } else if (this.surname_field.getText().equals("")) {
            JOptionPane.showMessageDialog((Component)null, "Please Enter: Surname", "SurnameError", 0);
        } else if (this.account_field.getText().equals("")) {
            JOptionPane.showMessageDialog((Component)null, "Please Enter: Account Type", "AccountError", 0);
        } else if (this.loan_amount_field.getText().equals("")) {
            JOptionPane.showMessageDialog((Component)null, "Please Enter: Loan Amount", "AmountError", 0);
        } else if (this.interest_field.getText().equals("")) {
            JOptionPane.showMessageDialog((Component)null, "Please Enter Interest Rate ", "InterestError", 0);
        } else if (this.total_payments_field.getText().equals("")) {
            JOptionPane.showMessageDialog((Component)null, "Please Enter No of Payments ", "PaymentsError", 0);
        } else {
            Double Loan_amount = Double.parseDouble(this.loan_amount_field.getText());
            Double interest = Double.parseDouble(this.interest_field.getText());
            Double numberOfPayments = Double.parseDouble(this.total_payments_field.getText());
            Double totalinterest = Loan_amount * interest;
            Double totalAmountPlusInterest = totalinterest * numberOfPayments + Loan_amount;
            Double monthlypayments = totalAmountPlusInterest / numberOfPayments;
            this.monthly_payments_field.setText(monthlypayments.toString());
            this.show_loan_details.setText("");
            this.show_loan_details.append("         CUSTOMER LOAN DETAILS\n");
            this.show_loan_details.append("\n");
            this.show_loan_details.append("\n");
            this.show_loan_details.append("Name: " + this.name_field.getText() + "\n");
            this.show_loan_details.append("Surname: " + this.surname_field.getText() + "\n");
            this.show_loan_details.append("Loan Amount: $ " + Loan_amount + "\n");
            this.show_loan_details.append("Interest Rate: " + interest + "\n");
            this.show_loan_details.append("Monthly Payment:$ " + monthlypayments + "\n");
            this.show_loan_details.append("Total Payment: $ " + totalAmountPlusInterest);
            this.show_loan_details.append("\n");
            this.show_loan_details.append("\n");
            this.show_loan_details.append("        Thank you choosing us :)\n");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_info", "root", "");
                Statement statement = connection.createStatement();
                String var10001 = this.name_field.getText();
                statement.executeUpdate("insert into loan_information values( '" + var10001 + "','" + this.surname_field.getText() + "','" + this.address_field.getText() + "','" + this.account_field.getText() + "','" + Loan_amount + "','" + interest + "','" + numberOfPayments + "','" + monthlypayments + "');");
                connection.close();
                System.out.println("successful");
            } catch (SQLException | ClassNotFoundException var9) {
                var9.printStackTrace();
            }
        }

    }

    private void ClearAllFields() {
        this.name_field.setText("");
        this.surname_field.setText("");
        this.address_field.setText("");
        this.account_field.setText("");
        this.deposit_field.setText("");
        this.overdraft_field.setText("");
        this.withdrawal_field.setText("");
        this.loan_amount_field.setText("");
        this.interest_field.setText("");
        this.total_payments_field.setText("");
        this.monthly_payments_field.setText("");
        this.show_loan_details.setText("");
    }

    private void Retrieve_info() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_info", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from loan_information");
            this.model.setRowCount(0);

            while(resultSet.next()) {
                this.columns[0] = resultSet.getString(1);
                this.columns[1] = resultSet.getString(2);
                this.columns[2] = resultSet.getString(3);
                this.columns[3] = resultSet.getString(4);
                this.columns[4] = resultSet.getString(5);
                this.columns[5] = resultSet.getString(6);
                this.columns[6] = resultSet.getString(7);
                this.columns[7] = resultSet.getString(8);
                this.model.addRow(this.columns);
            }

            JOptionPane.showMessageDialog((Component)null, "Data successfully Saved", "Successful", 1);
            connection.close();
        } catch (SQLException | ClassNotFoundException var4) {
            var4.printStackTrace();
        }

    }

    private void Deposits() {
        this.depositsFrame.setSize(800, 480);
        this.depositsFrame.setDefaultCloseOperation(2);
        this.depositsFrame.setResizable(false);
        this.depositsFrame.setLayout((LayoutManager)null);
        this.depositsFrame.getContentPane().setBackground(Color.GRAY);
        this.depositsFrame.setTitle("Deposits Menu");
        this.depositsFrame.setLocation(500, 200);
        this.depositsLabel.setBounds(320, 10, 350, 40);
        this.depositsLabel.setFont(new Font("Copperplate", 1, 20));
        this.depositsLabel.setForeground(Color.WHITE);
        this.depositsRefresh.setBounds(350, 400, 200, 20);
        this.depositsRefresh.setSize(140, 30);
        this.depositsRefresh.setBackground(Color.darkGray);
        this.depositsRefresh.setForeground(Color.WHITE);
        this.depositsRefresh.setBorder(new LineBorder(Color.RED, 2));
        this.depositsRefresh.setFont(new Font("Tahoma", 1, 14));
        this.depositsRefresh.setFocusable(false);
        this.depositsTable.setModel(this.depositModel);
        this.depositsTable.setSize(600, 300);
        this.depositsTable.setRowHeight(30);
        this.depositsTable.setAutoCreateRowSorter(true);
        this.depositModel.setColumnIdentifiers(this.depositCols);
        this.depositsScrollPane.setBounds(0, 80, 780, 300);
        this.depositsFrame.add(this.depositsLabel);
        this.depositsFrame.add(this.depositsRefresh);
        this.depositsFrame.add(this.depositsScrollPane);
        this.depositsFrame.setVisible(true);
    }

    private void Withdrawals() {
        this.withdrawalsFrame.setSize(800, 480);
        this.withdrawalsFrame.setDefaultCloseOperation(2);
        this.withdrawalsFrame.setResizable(false);
        this.withdrawalsFrame.setLayout((LayoutManager)null);
        this.withdrawalsFrame.getContentPane().setBackground(Color.GRAY);
        this.withdrawalsFrame.setTitle("Withdrawals");
        this.withdrawalsFrame.setLocation(500, 200);
        this.withdrawalsLabel.setBounds(320, 10, 350, 40);
        this.withdrawalsLabel.setFont(new Font("Copperplate", 1, 20));
        this.withdrawalsLabel.setForeground(Color.WHITE);
        this.withdrawalsRefresh.setBounds(350, 400, 200, 20);
        this.withdrawalsRefresh.setSize(140, 30);
        this.withdrawalsRefresh.setBackground(Color.darkGray);
        this.withdrawalsRefresh.setForeground(Color.WHITE);
        this.withdrawalsRefresh.setBorder(new LineBorder(Color.RED, 2));
        this.withdrawalsRefresh.setFont(new Font("Tahoma", 1, 14));
        this.withdrawalsRefresh.setFocusable(false);
        this.withdrawalsTable.setModel(this.withdrawalsModel);
        this.withdrawalsTable.setSize(600, 300);
        this.withdrawalsTable.setRowHeight(30);
        this.withdrawalsTable.setAutoCreateRowSorter(true);
        this.withdrawalsModel.setColumnIdentifiers(this.withdrawalsCols);
        this.withdrawalsScrollPane.setBounds(0, 80, 780, 300);
        this.withdrawalsFrame.add(this.withdrawalsLabel);
        this.withdrawalsFrame.add(this.withdrawalsRefresh);
        this.withdrawalsFrame.add(this.withdrawalsScrollPane);
        this.withdrawalsFrame.setVisible(true);
    }

    private void Overdrafts() {
        this.overdraftsFrame.setSize(800, 480);
        this.overdraftsFrame.setDefaultCloseOperation(2);
        this.overdraftsFrame.setResizable(false);
        this.overdraftsFrame.setLayout((LayoutManager)null);
        this.overdraftsFrame.getContentPane().setBackground(Color.GRAY);
        this.overdraftsFrame.setTitle("Overdrafts Menu");
        this.overdraftsFrame.setLocation(500, 200);
        this.overdraftsLabel.setBounds(300, 10, 350, 40);
        this.overdraftsLabel.setFont(new Font("Copperplate", 1, 20));
        this.overdraftsLabel.setForeground(Color.WHITE);
        this.overdraftsRefresh.setBounds(350, 400, 200, 20);
        this.overdraftsRefresh.setSize(140, 30);
        this.overdraftsRefresh.setBackground(Color.darkGray);
        this.overdraftsRefresh.setForeground(Color.WHITE);
        this.overdraftsRefresh.setBorder(new LineBorder(Color.RED, 2));
        this.overdraftsRefresh.setFont(new Font("Tahoma", 1, 14));
        this.overdraftsRefresh.setFocusable(false);
        this.overdraftsTable.setModel(this.overdraftsDefaultTableModel);
        this.overdraftsTable.setSize(600, 300);
        this.overdraftsTable.setRowHeight(30);
        this.overdraftsTable.setAutoCreateRowSorter(true);
        this.overdraftsDefaultTableModel.setColumnIdentifiers(this.overdraftsCols);
        this.overdraftsScrollPane.setBounds(0, 80, 780, 300);
        this.overdraftsFrame.add(this.overdraftsLabel);
        this.overdraftsFrame.add(this.overdraftsRefresh);
        this.overdraftsFrame.add(this.overdraftsScrollPane);
        this.overdraftsFrame.setVisible(true);
    }

    private void AccountBalance() {
        this.AccountFrame.setSize(800, 480);
        this.AccountFrame.setDefaultCloseOperation(2);
        this.AccountFrame.setResizable(false);
        this.AccountFrame.setLayout((LayoutManager)null);
        this.AccountFrame.getContentPane().setBackground(Color.GRAY);
        this.AccountFrame.setTitle("Account Balance");
        this.AccountFrame.setLocation(500, 200);
        this.accountLabel.setBounds(300, 10, 350, 40);
        this.accountLabel.setFont(new Font("Copperplate", 1, 20));
        this.accountLabel.setForeground(Color.WHITE);
        this.accountRefresh.setBounds(350, 400, 200, 20);
        this.accountRefresh.setSize(140, 30);
        this.accountRefresh.setBackground(Color.darkGray);
        this.accountRefresh.setForeground(Color.WHITE);
        this.accountRefresh.setBorder(new LineBorder(Color.RED, 2));
        this.accountRefresh.setFont(new Font("Tahoma", 1, 14));
        this.accountRefresh.setFocusable(false);
        this.accountTable.setModel(this.accountDefaultTableModel);
        this.accountTable.setSize(600, 300);
        this.accountTable.setRowHeight(30);
        this.accountTable.setAutoCreateRowSorter(true);
        this.accountDefaultTableModel.setColumnIdentifiers(this.accountCols);
        this.accountScrollPane.setBounds(0, 80, 780, 300);
        this.AccountFrame.add(this.accountLabel);
        this.AccountFrame.add(this.accountRefresh);
        this.AccountFrame.add(this.accountScrollPane);
        this.AccountFrame.setVisible(true);
    }

    private void DepositsDatabase() {
        String value = "No";
        String date = LocalDate.now().toString();
        String time = LocalTime.now().toString();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_info", "root", "");
            Statement statement = connection.createStatement();
            if (this.name_field.getText().equals("")) {
                JOptionPane.showMessageDialog((Component)null, "Please Enter: Name", "NameError", 0);
            } else if (this.surname_field.getText().equals("")) {
                JOptionPane.showMessageDialog((Component)null, "Please Enter: Surname", "SurnameError", 0);
            } else if (this.account_field.getText().equals("")) {
                JOptionPane.showMessageDialog((Component)null, "Please Enter: Account Number", "AccountError", 0);
            } else if (this.deposit_field.getText().equals("")) {
                JOptionPane.showMessageDialog((Component)null, "Please Enter:  Amount", "AmountError", 0);
            } else {
                String var10001 = this.name_field.getText();
                statement.executeUpdate("insert into account_details values('" + var10001 + "','" + this.surname_field.getText() + "','" + this.account_field.getText() + "','" + this.deposit_field.getText() + "','" + value + "','" + this.deposit_field.getText() + "','" + value + "','" + date + "','" + time + "');");
                connection.close();
                System.out.println("successful");
                JOptionPane.showMessageDialog((Component)null, "Data successfully Saved", "Successful", 1);
            }
        } catch (SQLException | ClassNotFoundException var6) {
            var6.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, "Error Occurred: Check your Database Connectivity", "DepositsError", 0);
        }

    }

    private void WithdrawalsDatabase() {
        String value = "No";
        String date = LocalDate.now().toString();
        String time = LocalTime.now().toString();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_info", "root", "");
            Statement statement = connection.createStatement();
            if (this.name_field.getText().equals("")) {
                JOptionPane.showMessageDialog((Component)null, "Please Enter: Name", "NameError", 0);
            } else if (this.surname_field.getText().equals("")) {
                JOptionPane.showMessageDialog((Component)null, "Please Enter: Surname", "SurnameError", 0);
            } else if (this.account_field.getText().equals("")) {
                JOptionPane.showMessageDialog((Component)null, "Please Enter: Account Number", "AccountError", 0);
            } else if (this.withdrawal_field.getText().equals("")) {
                JOptionPane.showMessageDialog((Component)null, "Please Enter:  Amount", "AmountError", 0);
            } else {
                String var10001 = this.name_field.getText();
                statement.executeUpdate("insert into account_details values('" + var10001 + "','" + this.surname_field.getText() + "','" + this.account_field.getText() + "','" + value + "','-" + this.withdrawal_field.getText() + "','-" + this.withdrawal_field.getText() + "','" + value + "','" + date + "','" + time + "');");
                connection.close();
                System.out.println("successful");
                JOptionPane.showMessageDialog((Component)null, "Data successfully Saved", "Successful", 1);
            }
        } catch (SQLException | ClassNotFoundException var6) {
            var6.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, "Error Occurred: Check your Database Connectivity", "DepositsError", 0);
        }

    }

    private void OverdraftsDatabase() {
        String value = "No";
        String date = LocalDate.now().toString();
        String time = LocalTime.now().toString();
        Float minimum_amount = Float.parseFloat(this.overdraft_field.getText());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_info", "root", "");
            Statement statement = connection.createStatement();
            if (this.name_field.getText().equals("")) {
                JOptionPane.showMessageDialog((Component)null, "Please Enter: Name", "NameError", 0);
            } else if (this.surname_field.getText().equals("")) {
                JOptionPane.showMessageDialog((Component)null, "Please Enter: Surname", "SurnameError", 0);
            } else if (this.account_field.getText().equals("")) {
                JOptionPane.showMessageDialog((Component)null, "Please Enter: Account Number", "AccountError", 0);
            } else if (this.overdraft_field.getText().equals("")) {
                JOptionPane.showMessageDialog((Component)null, "Please Enter:  Amount", "AmountError", 0);
            } else if (minimum_amount > 1000.0F) {
                JOptionPane.showMessageDialog((Component)null, "Enter amount less than or equal to $1000", "AmountError", 0);
            } else {
                String var10001 = this.name_field.getText();
                statement.executeUpdate("insert into account_details values('" + var10001 + "','" + this.surname_field.getText() + "','" + this.account_field.getText() + "','" + value + "','" + value + "','-" + this.overdraft_field.getText() + "','-" + this.overdraft_field.getText() + "','" + date + "','" + time + "');");
                connection.close();
                System.out.println("successful");
                JOptionPane.showMessageDialog((Component)null, "Data successfully Saved", "Successful", 1);
            }
        } catch (SQLException | ClassNotFoundException var7) {
            var7.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, "Error Occurred: Check your Database Connectivity", "DepositsError", 0);
        }

    }

    private void RefreshDepositsDatabase() {
        Object[] cols = new Object[10];

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_info", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from account_details");
            this.depositModel.setRowCount(0);

            while(resultSet.next()) {
                cols[0] = resultSet.getString(1);
                cols[1] = resultSet.getString(2);
                cols[2] = resultSet.getString(3);
                cols[3] = resultSet.getString(4);
                cols[4] = resultSet.getString(7);
                cols[5] = resultSet.getString(8);
                this.depositModel.addRow(cols);
            }

            connection.close();
        } catch (SQLException | ClassNotFoundException var5) {
            JOptionPane.showMessageDialog((Component)null, "Error Occurred: Check your Database Connectivity", "DepositsError", 0);
        }

    }

    private void RefreshWithdrawalsDatabase() {
        Object[] cols = new Object[10];

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_info", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from account_details");
            this.withdrawalsModel.setRowCount(0);

            while(resultSet.next()) {
                cols[0] = resultSet.getString(1);
                cols[1] = resultSet.getString(2);
                cols[2] = resultSet.getString(3);
                cols[3] = resultSet.getString(5);
                cols[4] = resultSet.getString(8);
                cols[5] = resultSet.getString(9);
                this.withdrawalsModel.addRow(cols);
            }

            System.out.println("successful");
            connection.close();
        } catch (SQLException | ClassNotFoundException var5) {
            JOptionPane.showMessageDialog((Component)null, "Error Occurred: Check your Database Connectivity", "DepositsError", 0);
        }

    }

    private void RefreshOverdraftsDatabase() {
        Object[] cols = new Object[10];

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_info", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from account_details");
            this.overdraftsDefaultTableModel.setRowCount(0);

            while(resultSet.next()) {
                cols[0] = resultSet.getString(1);
                cols[1] = resultSet.getString(2);
                cols[2] = resultSet.getString(3);
                cols[3] = resultSet.getString(7);
                cols[4] = resultSet.getString(8);
                cols[5] = resultSet.getString(9);
                this.overdraftsDefaultTableModel.addRow(cols);
            }

            System.out.println("successful");
            connection.close();
        } catch (SQLException | ClassNotFoundException var5) {
            JOptionPane.showMessageDialog((Component)null, "Error Occurred: Check your Database Connectivity", "DepositsError", 0);
        }

    }

    private void RefreshAccountBalanceDatabase() {
        Object[] cols = new Object[10];

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_info", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from account_details");
            this.accountDefaultTableModel.setRowCount(0);

            while(resultSet.next()) {
                cols[0] = resultSet.getString(1);
                cols[1] = resultSet.getString(2);
                cols[2] = resultSet.getString(3);
                cols[3] = resultSet.getString(4);
                cols[4] = resultSet.getString(5);
                cols[5] = resultSet.getString(6);
                cols[6] = resultSet.getString(7);
                cols[7] = resultSet.getString(8);
                cols[8] = resultSet.getString(9);
                this.accountDefaultTableModel.addRow(cols);
            }

            System.out.println("successful");
            connection.close();
        } catch (SQLException | ClassNotFoundException var5) {
            JOptionPane.showMessageDialog((Component)null, "Error Occurred: Check your Database Connectivity", "DepositsError", 0);
        }

    }
}
