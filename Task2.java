package pack1;
import java.util.*;
public class Task2{
	private int regno;
	private int n;
	private float m;
	private float tot;
	private float avg;
	private String grade;
	
    public Task2(int regno,float tot,float avg,String grade) 
    {
	   this.regno=regno;
	   this.tot=tot;
	   this.avg=avg;
	   this.grade=grade;
    }
    
    public String toString()
    {
    	return "Reg No: " + regno +
    		       " | Total: " + tot +
    		       " | Average: " + avg +
    		       " | Grade: " + grade;

    }
    public static Scanner scan=new Scanner(System.in);
    public static void main(String args[])
    {
    	List<Task2> std=new ArrayList<>();
    	int choice;
    	System.out.println("TASK2==>\n");
    	System.out.println("STUDENT GRADE CALCULATOR\n");
    	System.out.println("1.Add student marks");
    	System.out.println("2.View student grade\n");
    	do
    	{
    	System.out.println("Enter choice");
    	choice=scan.nextInt();
    	switch(choice)
    	{
    	case 1:
    		addstd(std);
    		break;
    	case 2:
    		viewstd(std);
    		break;
    	}
    	}while(choice<3);
    	System.err.println("EXIT");
    }

	private static void viewstd(List<Task2> std) {
		// TODO Auto-generated method stub
		if (std.isEmpty()) {
	        System.out.println("No student records found");
	        return;
	    }
		else
		{
			System.out.println("+-----------+------------+------------+-------------+");
			System.out.println("|   REGNO   |    TOTAL   |   AVERAGE  |     GRADE   |");
			System.out.println("+-----------+------------+------------+-------------+");
			for(Task2 std3:std)
			{
				System.out.printf("| %9d | %10.2f | %10.2f | %11s |\n",std3.regno,std3.tot,std3.avg,std3.grade);
				
			}
			System.out.println("+-----------+------------+------------+-------------+");
		}
	}

	private static void addstd(List<Task2> std) {
		// TODO Auto-generated method stub
		float tot=0;String grade = null;
		System.out.println("Enter regno:");
		int regno=scan.nextInt();
		System.out.println("Enter no of subject:");
		int n=scan.nextInt();
		for(int i=1;i<=n;i++)
		{
			System.out.println("Enter mark"+i+":");
			float m=scan.nextFloat();
			tot+=m;
		}
		float avg=tot/n;
		
		if((avg>=90)&&(avg<=100))
		{
			grade="A";
		}
		else if(avg>=80)
		{
			grade="B";
		}
		else if(avg>=70)
		{
			grade="C";
		}
		else if(avg>=60)
		{
			grade="D";
		}
		else
		{
			grade="E";
		}
		Task2 std2=new Task2(regno,tot,avg, grade);
		std.add(std2);
		System.out.println("INSERTED SUCCESFULLY");
		System.out.println("==================================");
	}
}