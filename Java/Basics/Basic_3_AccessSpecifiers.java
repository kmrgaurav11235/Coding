class AccessSpecifierPrivate
{
	private int num;
	AccessSpecifierPrivate()
	{
		num = 10;
	}
	void display()
	{
		System.out.println("Accessing private member from inside AccessSpecifierPrivate class. Num = " + num + ".");
	}
}

class AccessSpecifierDefault
{
	int num;
	AccessSpecifierDefault()
	{
		num = 11;
	}
	void display()
	{
		System.out.println("Accessing default member from inside AccessSpecifierDefault class. Num = " + num + ".");
	}
}

class AccessSpecifierDefaultSubClass extends AccessSpecifierDefault
{
	AccessSpecifierDefaultSubClass()
	{
	}
	void display()
	{
		System.out.println("Accessing default member from inside AccessSpecifierDefaultSubClass which is inherited from AccessSpecifierDefault class. Num = " + num + ".");
	}
}

class AccessSpecifierProtected
{
	protected int num;
	AccessSpecifierProtected()
	{
		num = 12;
	}
	void display()
	{
		System.out.println("Accessing protected member from inside AccessSpecifierProtected class. Num = " + num + ".");
	}
}

class AccessSpecifierProtectedSubClass extends AccessSpecifierProtected
{
	AccessSpecifierProtectedSubClass()
	{
	}
	void display()
	{
		System.out.println("Accessing protected member from inside AccessSpecifierProtectedSubClass which is inherited from AccessSpecifierProtected class. Num = " + num + ".");
	}
}

class AccessSpecifierPublic
{
	public int num;
	AccessSpecifierPublic()
	{
		num = 13;
	}
	void display()
	{
		System.out.println("Accessing public member from inside AccessSpecifierPublic class. Num = " + num + ".");
	}
}

class AccessSpecifierPublicSubClass extends AccessSpecifierPublic
{
	AccessSpecifierPublicSubClass()
	{
	}
	void display()
	{
		System.out.println("Accessing public member from inside AccessSpecifierPublicSubClass which is inherited from AccessSpecifierPublic class. Num = " + num + ".");
	}
}

class Basic_3_AccessSpecifiers
{
	public static void main(String args[])
	{
		AccessSpecifierPrivate asp1 = new AccessSpecifierPrivate();
		asp1.display();
		System.out.println();
		
		AccessSpecifierDefault asd2 = new AccessSpecifierDefault();
		asd2.display();
		System.out.println("Accessing default member from outside AccessSpecifierDefault class. Num = " + asd2.num + ".");
		AccessSpecifierDefaultSubClass asdSub2 = new AccessSpecifierDefaultSubClass();
		asdSub2.display();
		System.out.println();
		
		AccessSpecifierProtected asp3 = new AccessSpecifierProtected();
		asp3.display();
		System.out.println("Accessing protected member from outside AccessSpecifierProtected class. Num = " + asp3.num + ".");
		AccessSpecifierProtectedSubClass aspSub3 = new AccessSpecifierProtectedSubClass();
		aspSub3.display();		
		System.out.println();
		
		AccessSpecifierPublic asp4 = new AccessSpecifierPublic();
		asp4.display();
		System.out.println("Accessing public member from outside AccessSpecifierPublic class. Num = " + asp4.num + ".");
		AccessSpecifierPublicSubClass aspSub4 = new AccessSpecifierPublicSubClass();
		aspSub4.display();
		System.out.println();
	}
}

