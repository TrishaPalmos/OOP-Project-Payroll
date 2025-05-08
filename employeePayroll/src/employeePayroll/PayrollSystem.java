package employeePayroll;

import javax.swing.*;
import java.awt.*;

public class PayrollSystem {
	public PayrollSystem(String name, double salary) {
		Employee emp = new Employee(name, salary);
		
		JFrame frame = new JFrame ("Employee Payroll System"); // Title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 450);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false); // Prevent resizing
		
		// Title Panel
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBackground(Color.WHITE);
		
		JLabel title = new JLabel("Payroll Summary", JLabel.CENTER);
		title.setFont(new Font("Monospaced", Font.BOLD, 26));
		titlePanel.add(title, BorderLayout.CENTER);
		
		// Payroll Details Panel
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createEmptyBorder(10,20,20,20));
		
		JLabel separator = new JLabel("-----------------------------------");
		
		JLabel nameLabel = new JLabel("Employee: " + name);
		nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel salaryLabel = new JLabel("Gross Salary: ₱" + salary);
		salaryLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel sssLabel = new JLabel("SSS Deduction: ₱" + emp.calculateSSS());
		sssLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel pagibigLabel = new JLabel("Pag-IBIG Deduction: ₱" + emp.calculatePagibig());
		pagibigLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel philhealthLabel = new JLabel("PhilHealth Deduction: ₱" + emp.calculatePhilhealth());
		philhealthLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel taxLabel = new JLabel("Tax Deduction: ₱" + emp.calculateTax());
		taxLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel separator2 = new JLabel("-----------------------------------");
		
		JLabel totalLabel = new JLabel("Total Deduction: ₱" + emp.calculateDeductions());
		totalLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel netSalaryLabel = new JLabel("Net Salary: ₱" + emp.calculateNetSalary());
		netSalaryLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		// Footer Panel
		JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		footerPanel.setBackground(Color.WHITE);
		
		JLabel footer = new JLabel("Thank You!", SwingConstants.CENTER);
		footer.setFont(new Font("Monospaced", Font.BOLD, 20));
		
		footerPanel.add(footer);
		footerPanel.add(Box.createVerticalStrut(50)); // Adds small space below the footer
		
		//Adding components to panels
		panel.add(separator);
		panel.add(nameLabel);
		panel.add(salaryLabel);
		panel.add(sssLabel);
		panel.add(pagibigLabel);
		panel.add(philhealthLabel);
		panel.add(taxLabel);
		panel.add(separator2);
		panel.add(totalLabel);
		panel.add(netSalaryLabel);
		panel.add(separator);
		
		//Adding Panels to Frame
		frame.add(titlePanel, BorderLayout.NORTH); // Title is at the top but centered
		frame.add(panel, BorderLayout.CENTER);
		frame.add(footerPanel, BorderLayout.SOUTH);
		
		frame.setVisible(true);		
	}

	public static void main(String [] args) {
		String name =JOptionPane.showInputDialog("Enter Employee Name: ");
		String salaryInput = JOptionPane.showInputDialog("Enter Salary (₱):");
		
		if (name ==null || salaryInput == null || name.isEmpty() || salaryInput.isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Invalid Input. Please enter valid details.");
			return;
		}
		
		double salary = Double.parseDouble(salaryInput);
		new PayrollSystem(name, salary);
	}
}
