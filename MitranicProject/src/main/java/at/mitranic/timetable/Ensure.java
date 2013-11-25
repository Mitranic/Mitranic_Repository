package at.mitranic.timetable;

public class Ensure {

	public static void notNull(String string, Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException((string != null) ? string
					+ " must not be null" : "Argument must not be null");
		}
	}

	public static void notEmpty(String string, String str) {
		notNull(string, str);
		if (str.isEmpty()) {
			throw new IllegalArgumentException((string != null) ? string
					+ " must not be empty" : "Argument must not be empty");
		}
	}

}
