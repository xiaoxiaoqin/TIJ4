package initialization;

//: initialization/StaticInitialization.java
// Specifying initial values in a class definition.
import static net.mindview.util.Print.*;
/*
 * 	无论创建多少个对象，静态数据都只占用一份存储区域。static关键字不能应用于局部变量，因此它只能作用于域。如果没有初始化，
 * 就会得到默认初始值。
 *  静态初始化只有在不要的时候才进行，如果不创建Table对象，也不引用Table.b1和table.b2，那么静态的Bowl b1和b2永远不会
 * 被创建。而且只出始化一次。
 * 	初始化顺序是先静态对象，后非精态对象。要执行main（）静态方法，必须加载StaticInitialization类，然后其静态域table
 * 和cupboard被初始化，这导致它们对应的类也被加载，并且由于它们包含静态的Bowl对象，因此Bowl随后也被加载。
 * 总结： 1.即使没有显示地使用static关键字，构造器实际上也是静态方法。因此，当首次创建类型为Dog对象时，或者Dog类的静态方/静态域
 * 首次被访问时，Java解释器必须查找路径，以定位Dog.class文件
 * 		2.然后载入Dog.class,有关静态初始化的所有动作都会执行。因此，静态初始化只在class对象首次加载时候进行一次。
 * 		3.当用new Dog()创建对象的时候，首先将在堆上为Dog对象分配足够的存储空间。
 * 		4.这块存储空间会被清零，这就自动地将Dog对象中的所有基本类型都设置成了默认值，而引用则被设置成了null
 * 		5.执行所有出现于字段定义出的初始化动作。
 * 
 */
class Bowl {
	Bowl(String marker) {print(marker);}
	void f1(int marker) {print("f1(" + marker + ")");}
}

class Table {
	static Bowl bowl1 = new Bowl("static Bowl1");
	Bowl bowl3 = new Bowl("Bowl3");
	Table() {
		print("Table()");
		bowl3.f1(3);
	}
	void f2(int marker) {print("f2(" + marker + ")");}
	Bowl bowl4 = new Bowl("Bowl4");
	static Bowl bowl2 = new Bowl("static Bowl2");
}
public class StaticInitialization {
	public static void main(String[] args) {
		//Table.bowl1.f1(1);		
		print("Creating new Table in main");
		new Table();
		print("Creating new Table in main");
		new Table();
	}
	static Table table = new Table();
} 

//法阻止自动初始化的进行，他将在构造器被调用之前发生，
//在类的内部，变量定义的先后顺序决定了初始化的顺序。即使变量定义散步与方法定义之间，它们仍旧会在任何方法（包括构造器）被
//调用之前得到初始化,w3被调用两次，第二次在构造器内，第一次被回收