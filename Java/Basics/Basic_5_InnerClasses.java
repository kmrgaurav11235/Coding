class NestedOuterClass
{
	//Nested Inner class that access data and method of outerclass
	//we can’t have static method in a nested inner class because an inner class is implicitly associated with an object of its 
	//outer class so it cannot define any static method for itself.
	private int info;
	NestedOuterClass()
	{
		info = -1;
	}
	NestedOuterClass(int x)
	{
		info = x;
	}
	class NestedInnerClass
	{
		private int innerInfo;
		NestedInnerClass()
		{
			innerInfo = info;
		}
		NestedInnerClass(int x)
		{
			innerInfo = x;
		}
		void display()
		{
			System.out.println("Inner Info = " + innerInfo);
		}
	}
	void display()
	{
		System.out.println("Outer Info = " + info);
	}
}

class MethodLocalOuterClass
{
	private int info;
	private final int DEFAULT_VAR = 10;
	MethodLocalOuterClass()
	{
		info = -1;
	}
	MethodLocalOuterClass(int x)
	{
		info = x;
	}
	void display()
	{
		System.out.println("Outer Info = " + info);
		class MethodLocalInnerClass
		{
			//Method Local inner classes can access outer variables only if those variables are final
			private int innerInfo;
			MethodLocalInnerClass()
			{
				innerInfo = DEFAULT_VAR;
			}
			MethodLocalInnerClass(int x)
			{
				innerInfo = x;
			}
			void display()
			{
				System.out.println("Inner Info = " + innerInfo);
			}
		}
		MethodLocalInnerClass i1 = new MethodLocalInnerClass();
		i1.display();
	}
}

class StaticNestedOuterClass
{
	//Static nested classes are not technically an inner class. They are like a static member of outer class. 
	private static int info = 10;
	
	static void display()
	{
		System.out.println("Inside outer display method.\nOuterInfo = " + info);
		StaticNestedInnerClass.display();
	}
	
	static class StaticNestedInnerClass
	{
		private static int innerInfo = 12;
		
		static void display()
		{
			System.out.println("Inside inner display method.\nInner Info = " + innerInfo);
		}
		
	}
}

class AnonymousBaseClass
{
	int info;
	AnonymousBaseClass()
	{
		info = 0;
	}
	AnonymousBaseClass(int x)
	{
		info = x;
	}
	void display()
	{
		System.out.println("Inside AnonymousBaseClass display method.\nInfo = " + info);
	}
}

interface AnonymousInterface
{
	void setInfo(int x);
	void display();
}

class Basic_5_InnerClasses
{
	public static void main(String args[])
	{
		
		System.out.println("Type 1: Nested Inner class");
		NestedOuterClass oc1 = new NestedOuterClass(10);
		oc1.display();
		NestedOuterClass.NestedInnerClass ic1 = new NestedOuterClass(11).new NestedInnerClass();
		ic1.display();
		System.out.println();		
		
		System.out.println("Type 2: Method Local inner classes");
		MethodLocalOuterClass oc2 = new MethodLocalOuterClass(13);
		oc2.display();
		System.out.println();
		
		
		System.out.println("Type 3: Static Inner Class");
		StaticNestedOuterClass.display();
		System.out.println();
		
		System.out.println("Type 4: Anonymous Inner Class");
		System.out.println("4.1: As subclass of specified type");
		AnonymousBaseClass a1 = new AnonymousBaseClass(10){
				@Override				
				void display()
				{
					super.display();
					System.out.println("Inside AnonymousDerivedClass display method.\nInfo = " + info);
				}
			};
		a1.display();
		System.out.println();
		
		System.out.println("4.2: As implementer of the specified interface");
		AnonymousInterface ai1 = new AnonymousInterface(){
			int info;
			public void setInfo(int x)
			{
				info = x;
			}
			public void display()
			{
				System.out.println("Inside AnonymousClass implementing AnonymousInterface: Display method.\nInfo = " + info);				
			}
		};
		ai1.setInfo(10);
		ai1.display();
	}
}
