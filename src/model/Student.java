package model;

//modelu klase()
public class Student implements Comparable<Student> {
	//1. mainigie
	private long stud_id;
	private String name;
	private String surname;
	private String person_code;
	// paligmainigais, nevajag set, get
	private static long counter = 0;
	
	//2. get funkcijas
	public long get_stud_id() {
		return stud_id;
	}
	
	public String get_name() {
		return name;
	}
	
	public String get_surname() {
		return surname;
	}
	
	public String get_person_code() {
		return person_code;
	}
	
	
	
	//3. set funkcijas
	public void set_stud_id() {
		stud_id = counter;
		counter++;
	}
	
	public void set_name(String input_name) {
		if( (input_name != null) && (!input_name.isEmpty()) && (input_name.matches("[A-Z]{1}[a-z]{2,15}([ ]{1}[A-Z]{1}[a-z]{2,15})?")) ) {
			name = input_name;
		}
		else {
			name = "Unknown";
		}
	}
	
	public void set_surname(String input_surname) {
		if( (input_surname != null) && (!input_surname.isEmpty()) && (input_surname.matches("[A-Z]{1}[a-z]{2,15}([-]{1}[A-Z]{1}[a-z]{2,15})?")) ) {
			surname = input_surname;
		}
		else {
			surname = "Unknown";
		}
	}
	
	public void set_person_code(String input_person_code) {
		if( (input_person_code != null) && (!input_person_code.isEmpty()) && (input_person_code.matches("[0-9]{6}[-]{1}[0-9]{5}")) ) {
			person_code = input_person_code;
		}
		else {
			person_code = "Unknown";
		}
	}
	
	//4.1 bezargumenta funkcijas
	public Student() {
		set_stud_id();
		set_name("Janis");
		set_surname("Berzins-Kalnins");
		set_person_code("121212-12345");
	}
	
	//4.2 argumenta funkcijas
	
	public Student(String input_name, String input_surname, String input_person_code) {
		set_stud_id();
		set_name(input_name);
		set_surname(input_surname);
		set_person_code(input_person_code);	
	}
	
	//5. toString funkcijas
	@Override
	public String toString() {
		String result = stud_id + ": " + name + " " + surname + " ( " + person_code + " ) ";
		return result;
	}

	@Override
	public int compareTo(Student student2) {
	if(surname.charAt(0) > student2.surname.charAt(0)){
		return 1;
	}		
	else if (surname.charAt(0) < student2.surname.charAt(0)) {
		return -1;
	}
	else {
		return 0;
	}
	//throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
		}
		
	//6. visas parejas funkcijas pec nepieciesamibas
}
