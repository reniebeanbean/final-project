public class Species
{
	ArrayList<Organism> organisms;	
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
		organisms = new ArrayList<Organism>();
		Organism first = new Organism();
		Organism second = new Organism();
		organisms.add(first)
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
	
	

	
}
