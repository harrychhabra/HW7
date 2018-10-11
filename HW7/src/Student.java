import java.util.ArrayList;
public class Student {
	
	// Storing Student Names
	ArrayList<String> names;
	
	// 2D Array for marks
	double[][] marks;
	
	// 2D Array for grades
	char[][] grades;
	
	// Constructer calling
	Student(int length,int test)
	{
		// Allocating Memmory
		names = new ArrayList<String>(length);
		grades = new char[length][];
		marks = new double[length][];
		
		for(int i=0;i<length;i++)
		{
			marks[i] = new double[test];
			grades[i] = new char[test];
		}
		
		// Intializing Values
		for(int i=0; i<length; i++)
		{
			for(int j=0; j<test; j++)
			{
				marks[i][j] = -1;
				grades[i][j] = 'Z';
			}
		}
	}
	
	// returns the index of Student
	private int getIndex(String Name)
	{
		for(int i=0; i<names.size();i++)
		{
			if(Name.compareTo(names.get(i)) == 0)
			{
				return i;
			}
		}
		
		// if not present
		return -1;
	}
	
	// insert marks to the student name
	// sets the grade accordingly
	void insertMarks(String studentName,double mark)
	{
		int index = getIndex(studentName);
		if( index == -1) return;
		for(int i=0; i <marks[index].length  ;i++) {
			if(marks[index][i] == -1)
			{
				marks[index][i] = mark;
				setGrade(index,mark);
			}
		}
		return;
	}
	
	// funnction to set grade
	private void setGrade(int index,double mark)
	{
		char grade = 'F';
		if(mark >= 90 && mark <= 100) grade='A';
		if(mark >= 80 && mark <= 89) grade = 'B';
		if(mark >= 70 && mark <= 79) grade = 'C';
		if(mark >= 60 && mark <= 69) grade = 'D';
		if(mark >= 0 && mark <= 59) grade = 'F';
		insertGrade(index,grade);
	}
	
	// Validity check on student
	private boolean isValid(int index)
	{
		return index < names.size();
	}
	
	// Inserts grade
	private void insertGrade(int index,char grade)
	{
		if(!isValid(index)) return;
		for(int i=0; i< grades[index].length;i++)
		{
			if(grades[index][i] == 'Z')
			{
				grades[index][i] = grade;
				break;
			}
		}
		return;
	}
	
	// return Average
	public double getAverage(int index)
	{
		if(!isValid(index)) return -1;
		double sum = 0;
		for(int i=0; i < marks[index].length;i++)
		{
			sum += marks[index][i];
		}
		return sum/marks[index].length;
	}
}
