
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class Application {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

		Class sc = Student.class;

		// name
		System.out.println("Class");
		String nameOfClass = sc.getName();
		System.out.println("Name of class = " + nameOfClass);

		String simpleName = sc.getSimpleName();
		System.out.println("Simple name = " + simpleName);
		System.out.println();

		// modifier
		System.out.println("Modifier");
		int modifier = sc.getModifiers();
		String modifierText = Modifier.toString(modifier);
		System.out.println("Class modifier = " + modifierText + ", int = " + modifier);
		System.out.println("is static = " + Modifier.isStatic(modifier));
		System.out.println("is public = " + Modifier.isPublic(modifier));
		System.out.println("is private = " + Modifier.isPrivate(modifier));
		System.out.println("is protected = " + Modifier.isProtected(modifier));
		System.out.println();

		// package
		System.out.println("Package");
		Package classPackage = sc.getPackage();
		System.out.println("Package of current class = " + classPackage);
		System.out.println();

		// superclass
		System.out.println("SuperClass");
		Class superClass = sc.getSuperclass();
		System.out.println("Super class = " + superClass);
		System.out.println();

		// interfaces
		System.out.println("Interfaces");
		Class[] interfaces = sc.getInterfaces();
		System.out.println("Interfasec = " + Arrays.toString(interfaces));
		System.out.println();

		// constructor
		Constructor<Student>[] studentConstructor = sc.getConstructors();
		for (int i = 0; i < studentConstructor.length; i++) {
			Constructor<Student> constructor = studentConstructor[i];
			System.out.println("Constructor = " + constructor);
		}
		System.out.println("Constructor size = " + studentConstructor.length);
		System.out.println();

		// params of constructor
		System.out.println("Parameters for cons [0]");
		Constructor<Student> constructor = studentConstructor[0];

		Class<?>[] parameterTypes = constructor.getParameterTypes();
		for (int i = 0; i < parameterTypes.length; i++) {
			Class<?> class1 = parameterTypes[i];
			System.out.println(class1);
		}
		System.out.println();

		// constructor - param
		System.out.println("Constructor - parameters:");
		Constructor<Student> singleConstructor = sc.getConstructor(String.class, int.class, String.class, int.class,
				String.class);
		System.out.println("constructor - param = " + singleConstructor);
		Student newInstanceStudent = singleConstructor.newInstance("Mark", 27, "Wilson", 3, "Economy");
		System.out.println("reflection Student = " + newInstanceStudent);
		System.out.println();

		// fields
		System.out.println("fields:");
		Field[] fields = sc.getFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field);
		}
		System.out.println();

		// declarated fields
		System.out.println("declarated fields:");
		Field[] fields2 = sc.getDeclaredFields();
		for (int i = 0; i < fields2.length; i++) {
			Field field = fields2[i];
			System.out.println(field);
		}
		System.out.println();

		// field set
		System.out.println("Field set:");
		Field nameField = sc.getField("name");
		nameField.set(newInstanceStudent, "Fill");
		System.out.println("New name = " + newInstanceStudent);

		Field ageField = sc.getField("age");
		ageField.set(newInstanceStudent, 19);
		System.out.println("New age = " + newInstanceStudent);

		Field lastNameField = fields2[2];
		lastNameField.setAccessible(true);
		lastNameField.set(newInstanceStudent, "Robson");
		System.out.println("New last name = " + newInstanceStudent);

		Field courseField = fields2[3];
		courseField.setAccessible(true);
		courseField.set(newInstanceStudent, 1);
		System.out.println("New course = " + newInstanceStudent);

		Field proffesionField = fields2[4];
		proffesionField.setAccessible(true);
		proffesionField.set(newInstanceStudent, "Programming");
		System.out.println("new prof = " + newInstanceStudent);
		System.out.println();

		// methods
		System.out.println("methods:");
		Method[] methods = sc.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			System.out.println(method);
		}
		System.out.println();

		// change name
		System.out.println("Change name:");
		Method changeMethod = sc.getMethod("setName", String.class);
		changeMethod.invoke(newInstanceStudent, "Job");
		System.out.println(newInstanceStudent);
		System.out.println();

	}

}