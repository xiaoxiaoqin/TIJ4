package innerclasses;
//: innerclasses/Parcel11.java
// Nested classes (static inner classes).
/*嵌套类
 * 如果不需要内部类对象与其外围类对象之间的联系，那么可以将内部类声明为static。
 * 必须记住：普通的内部类对象隐士地保存了一个引用，指向创建他的外围类对象。
 * 1）要创建嵌套类对象，并不需要其外围类的对象
 * 2）不能从嵌套类的对象中访问非静态的外围类对象
 * 普通内部类的字段和方法，只能放在类的外部层次上，所以普通的内部类不能有static数据和static字段，也不能包含嵌套类。
 */
public class Parcel11 {
	private static class ParcelContents implements Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	protected static class ParcelDestination implements Destination {
		private String label;

		private ParcelDestination(String whereTo) {
			label = whereTo;
		}

		public String readLabel() {
			return label;
		}

		// Nested classes can contain other static elements:
		public static void f() {
		}

		static int x = 10;

		static class AnotherLevel {
			public static void f() {
			}

			static int x = 10;
		}
	}

	public static Destination destination(String s) {
		return new ParcelDestination(s);
	}

	public static Contents contents() {
		return new ParcelContents();
	}

	public static void main(String[] args) {
		Contents c = contents();
		Destination d = destination("Tasmania");
	}
} /// :~
