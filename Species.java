
import java.util.ArrayList;

public class Species<E>
{
 public static class Node<E>
 {
  E element;
  Node prev;
  Node next;
  public Node(E element, Node prev, Node next)
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
  header = new Node(null, null, null);
  trailer = new Node(null, header, null);
  header.setNext(trailer);
  population = 0;
  if(isCarnivorous)
  {
   key = 3
  }
  else
  {
   if(isPlant)
   {
    key = 1;
   }
   else
   {
    key = 2;
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
     Node oldNext = header.getNext();
        Node newest = new Node(o, header, header.getNext());
        header.setNext(newest);
        oldNext.setPrev(newest);
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
 public Node getHeader()
 {
     return header;
 }
 public Node getTrailer()
 {
     return trailer;
 }
 //Returns a random organism excluding Organism o
 public Organism getRandomOrganism(Organism o)
 {
     int size = (int)Math.random()*getPopulation() + 1;
     Node n = getHeader().getNext();
     Organism thing = o;
     while(thing == o)
     {
         for(int i = 0; i<size; i++)
         {
             n = n.getNext();
         }
         thing = (Organism)n.getElement();
     }
     return thing;
 }
 //Simply returns a random organism
 public Organism getRandomOrganism()
 {
     int size = (int)Math.random()*(population) + 1;
     Node n = getHeader().getNext();
     for(int i = 0; i<size; i++)
     {
         n = n.getNext();
     }
     return (Organism)n.getElement();
 }
 public Organism traverse(int k)
 {
     Node n = getHeader().getNext();
     for(int i = 0; i<k; i++)
     {
         n = n.getNext();
     }
     return (Organism)n.getElement();
 }
 
 

 
}
