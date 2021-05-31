
public class DictionaryItem implements Comparable <DictionaryItem>
{
    private String _term; 
    private String _meaning;
    /**
     *an empty constractor for DictionaryItem
     *
     **/
    public DictionaryItem()
    {
        _term = ""; 
        _meaning = "";
    }

    /**
     *a parameters constractor for DictionaryItem
     *
     *@param     term, String meaning
     **/
    public DictionaryItem(String term, String meaning)
    {
        _term = term.toLowerCase(); 
        _meaning = meaning.toLowerCase();
    }

    /**
     *a copy constractor for DictionaryItem
     *
     *@param     other
     **/
    public DictionaryItem(DictionaryItem other)
    {
        _term = other.getTerm(); 
        _meaning = other.getMeaning();
    }

    /**
     * a get method for _term
     * 
     * @return String _term
     **/
    public String getTerm()
    {
        return _term;
    }

    /**
     * a get method for _meaning
     * 
     * @return String _meaning
     **/
    public String getMeaning()
    {
        return _meaning;
    }

    /**
     * a set method for _term
     * 
     * @param  term
     **/
    public void setTerm(String term)
    {
        _term = term;
    }

    /**
     * a set method for _meaning
     * 
     * @param  meaning
     **/
    public void setMeaning(String meaning)
    {
        _meaning = meaning;
    }

    public String toString()
    {
        return _term+"\n"+_meaning +"\n\n";
    }

    public String showTermAndMeaning()
    {     
        return "term: "+_term+"\nmeaning: "+_meaning +"\n\n";
    }

    /**
     *a compareTo implementation
     *
     *@param   other
     *@return    int the compareTo value
     **/
    public int compareTo(DictionaryItem other)
    {
        return _term.compareTo(other.getTerm());
    }
}
