package pack1;
import java.util.*;

public class Task3 {
	public static Scanner scan=new Scanner(System.in);
	private int custid;
	private double balance;
	
	Task3(int custid,double balance){
		this.custid=custid;
		this.balance=balance;
	}
	public int getid() {
		return custid;
	}
	public double getBalance() {
		return balance;
	}
	public void getsetBalance(double balance) {
		this.balance=balance;
	}
	public String toString() {
		return""+custid+""+balance+"";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Task3> bank=new ArrayList<>();
		int choice;
		System.out.println("TASK 3\n");
		System.out.println("-------------ATM INTERFACE-------------");
		System.out.println("1.Withdraw amount\n");
		System.out.println("2.Deposit amount\n");
		System.out.println("3.Checking Balance\n");
		System.out.println("4.Display All customer BankAmount details\n ");
		System.out.println("------------------------------------------");
		do {
			System.out.println("Enter Choice:");
			choice=scan.nextInt();
			switch(choice) {
			case 1:
				withdraw(bank);
				break;
			case 2:
				deposit(bank);
				break;
			case 3:
				balance(bank);
				break;
			case 4:
				displayall(bank);
				break;
			
			}
		}while(choice<5);
		System.err.println("EXIT");
		

	}

	private static void displayall(List<Task3> bank) {

	    if (bank.isEmpty()) {
	        System.out.println("RECORD EMPTY");
	    } else {

	        System.out.println("+------------+------------+");
	        System.out.println("| ID         | BALANCE    |");
	        System.out.println("+------------+------------+");

	        for (Task3 b : bank) {
	            System.out.printf("| %-10d | %-10.2f |\n", b.getid(), b.getBalance());
	        }

	        System.out.println("+------------+------------+");
	    }
	}
	private static void balance(List<Task3> bank) {

	    System.out.println("Enter id:");
	    int id = scan.nextInt();
	    boolean found = false;

	    for (Task3 b : bank) {
	        if (b.getid() == id) {

	            // Display existing customer balance
	            System.out.println("+------------+------------+");
	            System.out.println("| ID         | BALANCE    |");
	            System.out.println("+------------+------------+");
	            System.out.printf("| %-10d | %-10.2f |\n", b.getid(), b.getBalance());
	            System.out.println("+------------+------------+");

	            found = true;
	            break;
	        }
	    }

	    // If ID not found → create new account with 0 balance
	    if (!found) {
	        Task3 newAcc = new Task3(id, 0);

	        bank.add(newAcc);

	        System.out.println("New account created with ZERO balance");

	        System.out.println("+------------+------------+");
	        System.out.println("| ID         | BALANCE    |");
	        System.out.println("+------------+------------+");
	        System.out.printf("| %-10d | %-10.2f |\n", newAcc.getid(), newAcc.getBalance());
	        System.out.println("+------------+------------+");
	    }
	}



	private static void deposit(List<Task3> bank) {

	    System.out.println("Enter id:");
	    int id = scan.nextInt();
	    boolean found = false;

	    for (Task3 d : bank) {
	        if (d.getid() == id) {
	            System.out.println("Enter deposit amount:");
	            double deposit = scan.nextDouble();
	            d.getsetBalance(d.getBalance() + deposit);
	            System.out.println("DEPOSITED SUCCESSFULLY");
	            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        System.out.println("Customer not found");
	        System.out.println("Enter Deposit amount to create new account:");
	        double deposit = scan.nextDouble();
	        bank.add(new Task3(id, deposit));
	        System.out.println("NEW ACCOUNT CREATED");
	    }
	    System.out.println("------------------------------------------");
	}


	private static void withdraw(List<Task3> bank) {

	    System.out.println("Enter id:");
	    int id = scan.nextInt();
	    boolean found = false;

	    for (Task3 w : bank) {
	        if (w.getid() == id) {
	            System.out.println("Enter withdraw amount:");
	            double amt = scan.nextDouble();

	            if (amt <= w.getBalance()) {
	                w.getsetBalance(w.getBalance() - amt);
	                System.out.println("Amount withdrawn successfully");
	            } else {
	                System.out.println("Insufficient balance");
	            }
	            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        System.out.println("NO id found");
	    }
	    System.out.println("------------------------------------------");
	}


}
