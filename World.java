import java.util.Comparator;
import java.util.Timer;

public class World implements Comparator<Species>
{
  private Species[] hierarchy;
  private int pos;
  private int capacity;
  Species root;
  
  public World()
  {
    capacity = 101;
    hierarchy = new Species[capacity];
    pos = 1;
    root = null;
  }
  @Override
  public int compare(Species obj1, Species obj2)
  {
    if(obj1.getKey() < obj2.getKey())
    {
      return -1;
    }
    else if(obj1.getKey() > obj2.getKey())
    {
      return 1;
    }
    else if(obj1 == null)
    {
      return -1
    return 0;
  }
  
  public Species left(Species s)
  {
    for(int i = 0; i<hierarchy.length; i++)
    {
      if(hierarchy[i] == s)
      {
        return hierarchy[2*i + 1];
      }
    }
  }
  public Species right(Species s)
  {
    for(int i = 0; i<hierarchy.length; i++)
    {
      if(hierarchy[i] == s)
      {
        return hierarchy[2*i + 2];
      }
    }
  }
  public void insert(Species s)
  {
    if(pos == capacity)
    {
      return;
    }
    else
    {
      hierarchy[pos++] = s;
      int child = pos - 1;
      int parent = child/2;
      while(compare(hierarchy[parent], hierarchy[child]) == -1)
      {
        Species temp = hierarchy[parent];
        hierarchy[parent] = hierarchy[child];
        hierarchy[child] = temp;
        child = parent;
        parent = child/2;
      }
    }
  }
  public void delete()
  {
    for(int i = 0; i<hierarchy.length; i++)
    {
      if(hierarchy[i].getPopulation() == 0)
      {
        hierarchy[i] = null;
        pos--;
      }
    }
      int child = pos - 1;
      int parent = child/2;
      while(compare(hierarchy[parent], hierarchy[child]) == -1)
      {
        Species temp = hierarchy[parent];
        hierarchy[parent] = hierarchy[child];
        hierarchy[child] = temp;
        child = parent;
        parent = child/2;
      }
  }
  
