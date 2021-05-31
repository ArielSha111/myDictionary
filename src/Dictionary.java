import java.util.*; 
public class Dictionary
{
    private TreeSet<DictionaryItem> _dictionary_items;
    /**
     * an empty constructor for Dictionary
     **/
    public Dictionary()
    {
        _dictionary_items = new TreeSet<DictionaryItem>();
    }

    /**
     * a parameters constructor for Dictionary
     *
     **/
    public Dictionary(TreeSet<DictionaryItem> dictionary_items)
    {
        _dictionary_items = dictionary_items;
    }

    /**
     * a copy constructor for Dictionary
     *
     **/
    public Dictionary(Dictionary other)
    {
        _dictionary_items = other.getItems();
    }

    /**
     * a get nethod for _dictionary_items
     * 
     * @return  PriorityQueue<DictionaryItem> _dictionary_items
     **/
    public TreeSet<DictionaryItem> getItems()
    {
        return _dictionary_items;
    }

    /**
     * a set nethod for _dictionary_items
     * 
     * @param  dictionary_items
     **/
    public void setItems(TreeSet<DictionaryItem> dictionary_items)
    {
        _dictionary_items = dictionary_items;
    }

    public String toString()
    {
        String s = "";
        Iterator it = _dictionary_items.iterator();  
        while(it.hasNext())
        {             
            DictionaryItem temp = (DictionaryItem)it.next();
            s+=temp.toString();
        }
        return s;
    }

    public String showDictionary()
    {
        String s = "";
        Iterator it = _dictionary_items.iterator();  
        while(it.hasNext())
        {             
            DictionaryItem temp = (DictionaryItem)it.next();
            s+=temp.showTermAndMeaning();
        }
        return s;
    }

    /**
     * a method to add a term from the Dictionary
     *
     **/
    public void addItem(DictionaryItem item)
    {
        _dictionary_items.add(item);
    }

    /**
     * a method to remove a term from the Dictionary
     *
     **/
    public void removeTerm(DictionaryItem item)
    {
        _dictionary_items.remove(item);
    }

    /**
     * a method to update the meaning of a term from the Dictionary
     *
     **/
    public void updateTerm(DictionaryItem item, String updated_data)
    {
        PriorityQueue<DictionaryItem> temp_items= new PriorityQueue<DictionaryItem>();
        Iterator it = _dictionary_items.iterator();  
        while(it.hasNext())
        {             
            DictionaryItem temp = (DictionaryItem)it.next();
            if(temp.equals(item))
            {     
                temp.setMeaning(updated_data);
                DictionaryItem new_item = temp;
                it.remove();
                temp_items.add(new_item);
            } 
        }
        _dictionary_items.addAll(temp_items);
    }

    /**
     * a method to find the meaning of a term 
     * 
     * @param    term
     * @return   String the meaing of the term
     **/
    public String searchTerm(String term)
    {
        Iterator it = _dictionary_items.iterator();  
        while(it.hasNext())
        {             
            DictionaryItem temp = (DictionaryItem)it.next();
            if(temp.getTerm().equals(term))    
                return temp.showTermAndMeaning();
        }
        return "this term does not exists yet in this dictionary";
    }

    /**
     * a method to chack if a term is in the Dictionary
     * 
     * @param    term
     * @return   boolean true if the term is in the Dictionary 
     **/
    public boolean termInList(String term)
    {
        Iterator it = _dictionary_items.iterator();  
        while(it.hasNext())
        {             
            DictionaryItem temp = (DictionaryItem)it.next();
            if(temp.getTerm().equals(term))    
                return true;
        }
        return false;
    }

    /**
     * a method to return an item by its term
     * 
     * @param    term
     * @return   DictionaryItem the needed item
     **/
    public DictionaryItem getItemByTerm(String term)
    {
        Iterator it = _dictionary_items.iterator();  
        while(it.hasNext())
        {             
            DictionaryItem temp = (DictionaryItem)it.next();
            if(temp.getTerm().equals(term))    
                return temp;
        }
        return null;
    }

}
