
public class Species<E>
{
	private static class Node<E>
	{
		E element;
		Node prev;
		Node next;
		public node(E element, Node prev, Node next)
		{
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
		public E getElement()
		{
			return element;
		}
		public void setElement(E element)
		{
			this.element = element;
		}
		public Node getNext()
		{
			return next;
		}
		public void setNext(Node n)
		{
			next = n;
		}
		public Node getPrev()
		{
			return prev;
		}
		public void setPrev(Node p)
		{
			prev = p;
		}
	}
			
	int population;
	int key; 
	String name;
	boolean isPlant;
	boolean isAquatic;
	boolean isCarnivorous;
	Node header;
	Node trailer;
	
	public Species(String name, boolean isPlant, boolean isAquatic, boolean isCarnivorous)
	{
		this.name = name;
		this.isPlant = isPlant;
		this.isAquatic = isAquatic;
		this.isCarnivorous = isCarnivorous;
		header = new Node(null, null, trailer)
		trailer = new Node(null, header, null);
		population = 0;
		if(isCarnivorous)
		{
			key = (int)Math.random()*2 + 4;
		}
		else
		{
			if(isPlant)
			{
				key = 1;
			}
			else
			{
				key = (int)Math.random()*2 +2;
			}
		}
		Organism first = new Organism(this);
		Organism second = new Organism(this);
		add(first);
		add(second);
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String n)
	{
		name = n;
	}
	public boolean isPlant()
	{
		return isPlant;
	}
	public void setIsPlant(boolean p)
	{
		isPlant = p;
	}
	public boolean isAquatic()
	{
		return isAquatic;
	}
	public void setIsAquatic(boolean p)
	{
		isAquatic = p;
	}
	public boolean isCarnivorous()
	{
		return isCarnivorous;
	}
	public void setIsCarnivorous(boolean p)
	{
		isCarnivorous = p;
	}
	public int getPopulation()
	{
		return population;
	}
	public int getKey()
	{
		return key;
	}
	public void add(Organism o)
	{
	    Node newNode = new Node(0, trailer.getPrev(), trailer);
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
		population++;
	}
	public void delete(Organism o)
	{
		Node n = header.getNext();
		for(int i = 0; i<population; i++)
		{
			if(n.getElement() == o)
			{
				n.getNext().setPrev(n.getPrev());
				n.getPrev().setNext(n.getNext());
				population--;
			}
			n = n.getNext();
		}	
	}
	
	

	
}

