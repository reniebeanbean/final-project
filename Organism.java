public class Organism{
	// Instance Variables that can be used
	private Species type;
	
	public Organism(Species type)
	{
		this.type = type;
	}
	
	/*Below the constructor will be some action methods. They could be like eating organisms from another species, reproduce, genetic mutation, etc*/
	public void reproduce(Organism o)
	{
	    if(this.getType() == o.getType())
	    {
	        Organism newThing = new Organism(type);
	        type.add(newThing);
	    }
	}
	public void eat(Organism o)
	{
		o.die();
	}
	public void die()
	{
		this.getType().delete(this);
	}
	public Species getType()
	{
	    return type;
	}
}
