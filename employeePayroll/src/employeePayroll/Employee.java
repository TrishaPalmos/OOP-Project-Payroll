package employeePayroll;

public class Employee {
	String name;
	double salary;
	double sssRate = 0.045;
	double pagibigRate = 0.02;
	double philhealthRate = 0.04;
	double taxRate = 0.10;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public double calculateSSS() {
		return salary * sssRate;
	}
	
	public double calculatePagibig() {
		return salary * pagibigRate;
	}
	
	public double calculatePhilhealth() {
		return salary * philhealthRate;
	}
	
	public double calculateTax() {
		return salary * taxRate;
	}
	
	public double calculateDeductions() {
		return calculateSSS() + calculatePagibig() + calculatePhilhealth() + calculateTax();
	}
	
	public double calculateNetSalary() {
		return salary - calculateDeductions();
	}
}
