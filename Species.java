import java.util.ArrayList;
public class Species
{
	ArrayList<Organism> organisms;
	int key; 
	String name;
	boolean isPlant;
	boolean isAquatic;
	boolean isCarnivorous;
	
	public Species(String name, boolean isPlant, boolean isAquatic, boolean isCarnivorous)
	{
		this.name = name;
		this.isPlant = isPlant;
		this.isAquatic = isAquatic;
		this.isCarnivorous = isCarnivorous;
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
		organisms = new ArrayList<Organism>();
		Organism first = new Organism(this);
		Organism second = new Organism(this);
		organisms.add(first);
		organisms.add(second);
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
		return organisms.size();
	}
	public int getKey()
	{
		return key;
	}
	public void add(Organism o)
	{
	    organisms.add(o);
	}
	public ArrayList<Organism> getOrganisms()
	{
	    return organisms;
	}
	
	

	
}

