public class Species<E> {
	private static class OrganismList<E>
	{
		ru
	}
		
	String name;
	boolean isPlant;
	boolean isAquatic;
	boolean isCarnivorous;
        int population;
	
	public Species(String name, boolean isPlant, boolean isAquatic, boolean isCarnivorous)
	{
		this.name = name;
		this.isPlant = isPlant;
		this.isAquatic = isAquatic;
		this.isCarnivorous = isCarnivorous;
                population = 0;
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
	

	
}
