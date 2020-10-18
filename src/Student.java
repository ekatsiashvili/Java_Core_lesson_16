public class Student {

	public String name;
	public int age;
	private String lastName;
	private int level;
	private String prof;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Student() {
		super();
	}

	public Student(String name, int age, String lastName, int level, String prof) {
		super();
		this.name = name;
		this.age = age;
		this.lastName = lastName;
		this.level = level;
		this.prof = prof;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getlevel() {
		return level;
	}

	public void setlevel(int level) {
		this.level = level;
	}

	public String getprof() {
		return prof;
	}

	public void setprof(String prof) {
		this.prof = prof;
	}
	
	public void changeUniversity(String name, String lastName) {
		System.out.println("Student " + name + " " + lastName + " transfered to another university");
	}
	
	public void changelevel(String name, String lastName, int level) {
		System.out.println("Student " + name + " " + lastName + " transfered to the " + level + "th level");
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", lastName=" + lastName + ", level=" + level
				+ ", prof=" + prof + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + level;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((prof == null) ? 0 : prof.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (level != other.level)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (prof == null) {
			if (other.prof != null)
				return false;
		} else if (!prof.equals(other.prof))
			return false;
		return true;
	}

}