package week9_FRI;

class Ticket implements Comparable {
	int no;

	public Ticket(int no) {
		this.no = no;
	}

	public int compareTo(Object o) {
		Ticket t = (Ticket) o;
		return no < t.no ? -1 : (no > t.no ? 1 : 0);
	}
}

public class Week9_assignment {
	public static <T extends Comparable> int countGT(T[] a, T elem) {
		int count = 0;
		for (T e : a){
			System.out.print(e.compareTo(elem)+" ");
			if (e.compareTo(elem) < 0){
				++count;				
			}
		}
		System.out.println();
		return count;
	}

	public static void main(String[] args) {
		Ticket[] a = { new Ticket(5), new Ticket(3), new Ticket(10), new Ticket(7), new Ticket(4) };
		
		for (Ticket t : a) System.out.printf("%d ", t.no);
		System.out.println();
		
		System.out.println(countGT(a, a[3]));
	}
}