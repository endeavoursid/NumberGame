import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }
}
class ATM extends JFrame {
    private BankAccount account;
    private JLabel balanceLabel;
    private JTextField amountField;

    public ATM(BankAccount account) {
        this.account = account;
        setTitle("ATM Machine");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(6, 1));

        balanceLabel = new JLabel("Balance: $" + account.checkBalance());
        panel.add(balanceLabel);

        JLabel depositLabel = new JLabel("Enter deposit amount:");
        panel.add(depositLabel);

        amountField = new JTextField();
        panel.add(amountField);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if (account.deposit(amount)) {
                        JOptionPane.showMessageDialog(null, "Deposited $" + amount + " successfully.");
                        balanceLabel.setText("Balance: $" + account.checkBalance());
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid deposit amount.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }
        });
        panel.add(depositButton);

        JLabel withdrawLabel = new JLabel("Enter withdraw amount:");
        panel.add(withdrawLabel);

        JTextField withdrawField = new JTextField();
        panel.add(withdrawField);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(withdrawField.getText());
                    if (account.withdraw(amount)) {
                        JOptionPane.showMessageDialog(null, "Withdrawn $" + amount + " successfully.");
                        balanceLabel.setText("Balance: $" + account.checkBalance());
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid withdrawal amount.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }
        });
        panel.add(withdrawButton);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double balance = account.checkBalance();
                JOptionPane.showMessageDialog(null, "Your balance is $" + balance);
            }
        });
        panel.add(checkBalanceButton);

        getContentPane().add(panel);
    }
}


public class task4 {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);  // Initial balance
        SwingUtilities.invokeLater(() -> {
            ATM atm = new ATM(userAccount);
            atm.setVisible(true);
        });
    }
}
