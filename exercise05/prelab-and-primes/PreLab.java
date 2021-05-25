import java.util.*;
/**
 * Fill in your solutions for the PreLab in
 * the corresponding methods.
 * 
 * @author Barne Kleinen
 */
public class PreLab
{
    public void methodTester () {
        
        // Expected Vaues all multiples of 5 between 10 and 95
        printMultiplesOf5();
        
        // Expected Value 6 + 7 + 8 + 9 = 30
        int sum = sumBetween(5, 10);
        System.out.println(sum);
        
        Collection<Student> students = new ArrayList<>();
        students.add(new Student("test", "tester"));
        students.add(new Student("test2", "tester2"));
        students.add(new Student("test3", "tester3"));
        
        // Expected results: Printing the above students
        printStudentList(students);
        
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        
        // Expected result: output true on 3,5,7
        for (Integer num : numbers) {
            System.out.println(num + " -> " + isPrime(num));
        }
    }
    
    public void printMultiplesOf5()
    {
        int base = 5;
        boolean isDone = false;
        
        for (int i = 0; isDone == false; i++) {
            int res = base * (i+1);
            if (res >= 95) {
                isDone = true;
            } else {
                if (res > 10) {
                    System.out.println(res);
                }
            }
        }
    }

    public int sumBetween(int a, int b){
        int sum = 0;
        for (int i = a+1; i < b; i++) {
            sum += i;
        }
        return sum;
    }

    public void printStudentList(Collection<Student> imi1)
    {
        for (Student stud : imi1) {
            System.out.println(stud.getFirstName());
            System.out.println(",");
            System.out.println(" ");
            System.out.println(stud.getSurname());
        }
    }
    
    public boolean isPrime(int num){
        int remainder = -1;
        boolean isPrime = false;
        int i = 1;
        while (remainder != 0 && i < num) {
            remainder = num % i;
            isPrime = remainder != 0;
            i++;
        }
        return isPrime; 
    }
    
    public int countPrimesSmallerThan1000(){
        List<Integer> primes = new ArrayList<>();
        int i = 1;
        while (i < 1000) {
            if (isPrime(i)) {
                primes.add(i);
            }
            i++;
        }
        System.out.println(primes);
        return primes.size();
    }
    
}
