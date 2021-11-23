package practice.basic;

public class LangAndUtil {

	
	
	public static void main(String[] args) {
		Keyboard k = new Keyboard();
		Keyboard k2 = new Keyboard();
		Keyboard k3 = new Keyboard();
		System.out.println("k == k2 :"+(k == k2));
		k = k2;
		System.out.println("k == k2 :"+(k == k2));
		
		System.out.println(System.identityHashCode(k));
		System.out.println(System.identityHashCode(k3));
		System.out.println("k.getClass(): "+k.getClass());
		System.out.println(k);
		
		Meat m = new Meat(new Nutri(100,30), 25);
		Meat m2 = m.clone();
		
		m.n.protin = 50;
		m.n.water= 5;
		System.out.println(m.n.protin+" "+m.n.water+" "+m.weight);
		System.out.println(m2.n.protin+" "+m2.n.water+" "+m2.weight);
		
		Class cObj = new Meat(new Nutri(100,30), 25).getClass();
		System.out.println(cObj);
		cObj = Meat.class;
		System.out.println(cObj);
		
		char[] cArr = {};
		System.out.println("cArr.length :"+cArr.length);
		
		char[] c = {'a','b','c','d','e'};
		String s = new String(c);
		String s2 = new String(c);
		String s3 = String.valueOf(2);
		System.out.println(s3);
		
		System.out.println(s);
		int a = s.indexOf('c');
		System.out.println(s.charAt(a));
		System.out.println(s.intern()==s2.intern());
		
		String s5 = String.join("-", new String[] {"a","b","c"});
		System.out.println(s5);
		
		StringBuffer buf = new StringBuffer(new String(c));
		System.out.println(buf+"     "+buf.hashCode());
		buf.append("123");
		System.out.println(buf+"  "+buf.hashCode());
		
		
		
	}

}

class Keyboard{
	String name;
	long id;
	
	public Keyboard() {
		this.name = "기계식키보드";
		this.id = 777;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Keyboard) {
			return id == ((Keyboard)obj).id;
		}else
			return false;
		
	}
	
	@Override
	public String toString() {
		return name+"("+id+")";
		
	}
}

class Meat implements Cloneable{
	Nutri n;
	int weight;
	public Meat(Nutri n,int weight) {
		this.n = n;
		this.weight = weight;
	}
	
	@Override // protected => public 
	public Meat clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
		
		Meat m = (Meat)obj;
		m.n = new Nutri(this.n.water,this.n.protin);
		return m;
	}
}

class Nutri {
	int water;
	int protin;
	
	public Nutri(int water , int protin) {
		this.water = water;
		this.protin = protin;
	}
}
