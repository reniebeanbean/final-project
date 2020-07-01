import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;

public class World implements Comparator<Species>
{
  private HashMap<Integer, ArrayList<Species>> hierarchy;
  private int capacity;
  private ArrayList<Species> allSpecies;
  public World()
  {
    capacity = 101;
    hierarchy = new HashMap<Integer, ArrayList<Species>>();
    allSpecies = new ArrayList<Species>();
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
            hierarchy.put(i, arr);
          }
        }
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
          System.out.println(hierarchy.get(i).remove(j) + "s went extinct");
        }
      }
    }
  }
  public int getCapacity()
  {
      return capacity;
  }
  public HashMap<Integer,ArrayList<Species>> getHierarchy()
  {
      return hierarchy;
  }
}
