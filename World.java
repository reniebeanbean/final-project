import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;

public class World implements Comparator<Species>
{
  private HashMap<Integer, ArrayList<Species>> hierarchy;
  private int capacity;
  private ArrayList<Species> allSpecies;
  private int plants;
  private int fish;
  private int landAnimals;
  public World()
  {
    capacity = 10;
    hierarchy = new HashMap<Integer, ArrayList<Species>>();
    allSpecies = new ArrayList<Species>();
    ArrayList<Species> blank = new ArrayList<Species>();
    for(int i = 1; i<=5; i++)
    {
        hierarchy.put(i, blank);
    }
    plants = 0;
    fish = 0;
    landAnimals = 0;
  }
  @Override
  public int compare(Species obj1, Species obj2)
  {
    if(obj1 == null && obj2 != null)
    {
      return -1;
    }
    else if(obj1.getKey() < obj2.getKey())
    {
      return -1;
    }
    else if(obj1.getKey() > obj2.getKey())
    {
      return 1;
    }
    return 0;
  }
  public void insert(Species s)
  {
    if(allSpecies.size() == capacity)
    {
      return;
    }
    else
    {
      allSpecies.add(s);
      for(int i = 1; i<=5; i++)
      {
        ArrayList<Species> arr = new ArrayList<Species>();
        for(int j = 0; j<allSpecies.size(); j++)
        {
          if(allSpecies.get(j).getKey() == i)
          {
            arr.add(allSpecies.get(j));
          }
        }
        hierarchy.put(i,arr);
    }
    }
  }
  public void delete()
  {
    for(int i = 0; i<hierarchy.size(); i++)
    {
      for(int j = 0; j<hierarchy.get(i).size(); j++)
      {
        if(hierarchy.get(i).get(j).getPopulation() == 0)
        {
          System.out.println(hierarchy.get(i).remove(j).getName() + "s went extinct");
        }
      }
    }
  }
  public int getCapacity()
  {
      return capacity;
  }
  public void setCapacity(int k)
  {
      capacity = k;
  }
  public HashMap<Integer,ArrayList<Species>> getHierarchy()
  {
      return hierarchy;
  }
  public void addSpecies()
  {
      int choice = (int)(Math.random() * 2);
        boolean isPlant = false;
        boolean isAquatic = false;
        boolean isCarnivorous = false;
        if(choice > 0)
        {
            isPlant = true;
            
        }
        choice = (int)(Math.random() * 2);
        if(choice > 0)
        {
            isAquatic = true;
        }
        choice = (int)(Math.random() * 2);
        if(choice > 0 && !isPlant)
        {
            isCarnivorous = true;
        }
        if(isPlant)
        {
            Species newSpecies = new Species("Plant " + plants, isPlant, isAquatic, isCarnivorous);
            plants++;
            this.insert(newSpecies);
            System.out.println(newSpecies.getName() + " have been added");
        }
        else if(isAquatic)
        {
            Species newSpecies = new Species("Fish " + fish, isPlant, isAquatic, isCarnivorous);
            fish++;
            this.insert(newSpecies);
            System.out.println(newSpecies.getName() + " have been added");
        }
        else
        {
            Species newSpecies = new Species("Animal " + landAnimals, isPlant, isAquatic, isCarnivorous);
            landAnimals++;
            this.insert(newSpecies);
            System.out.println(newSpecies.getName() + " have been added");
        }
        
  }
  public void randomEvent(Organism o)
    {
        int event = (int)Math.random()*2;
        int key = o.getType().getKey();
        if(event == 0)
        {
          o.reproduce(this.getHierarchy().get(key).get(this.getHierarchy().get(key).indexOf(o.getType())).getRandomOrganism(o));
        }
        if(event == 1)
        {
            addSpecies();
        }
    }
    public void event()
    {
        if(allSpecies.size() == 0)
        {
            addSpecies();
        }
        else
        {
            int event = (int)(Math.random()*2);
            if(event == 0)
            {
                addSpecies();
            }
            if(event == 1)
            {
                for(int i = 1; i<=this.getHierarchy().size(); i++)
                {
                        for(int j = 0; j< this.getHierarchy().get(i).size(); j++)
                        {
                            Species s = this.getHierarchy().get(i).get(j);
                            int pop = getHierarchy().get(i).get(j).getPopulation();
                            for(int k = 0; k<pop; k++)
                            {
                                randomEvent(s.traverse(k));
                            }
                        }
                    }
                }
            }
    }
}
