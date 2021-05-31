import javax.swing.JOptionPane;
public class DictionaryUIActions
{
    private Dictionary my_dictionary;
    private FileActions fa; 
    private final String[] FILES = {"choose by typing" ,"short words file", "long words file", "simple words file" ,"complicated words file"};
    /**
     * an empty constructor for DictionaryUIActions
     **/
    public DictionaryUIActions()
    {
        my_dictionary = new Dictionary();
        fa = new FileActions();
    }

    /**
     * a method to get an input from the user
     * 
     * @param    instruction
     * @return  String the input
     **/
    private  String inputTreatment(String instruction)
    {
        String input_val;
        while(true)
        {
            input_val = JOptionPane.showInputDialog(null,instruction);          
            if(input_val==null)
                return "";
            else if(input_val.equals(""))
                JOptionPane.showMessageDialog(null,"that's an empty string please try again");
            else 
                break;
        }
        return input_val;
    }

    /**
     * a method to make sure file name have ending id not add - .txt
     * 
     * @param    file_name
     * @return  String the needed file name
     **/
    private String setEnding(String file_name)
    {
        if(file_name.equals(""))
            return"";
        for(int i=0;i<file_name.length();i++)
        {
            if(file_name.charAt(i)=='.'&&i<(file_name.length()-1))//i cant make any further checks since i don't no what files are good for this project ill consider a dot as fine
                return file_name;
            else if(file_name.charAt(i)=='.')
            {
                return file_name+"txt"; 
            }
        }
        return file_name+".txt";
    }

    /**
     * a method to navigate between the needed actes for the decision of the user
     *
     * @return  String the needed file name
     **/
    private void actForDecison(int decision)
    {
        String resulte;
        if(decision==0)
        {
            JOptionPane.showMessageDialog(null,"your dictionary is:\n"+my_dictionary.showDictionary());
            return;
        }
        if(decision<5)
            resulte = inputTreatment("Enter term\n"+
                "be awere that all inputs are non case sensetive");
        else       
        {           
            int file_option = JOptionPane.showOptionDialog(null, "hello please press the needed button","Ariel's Dictionary",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, FILES, null);
            if(file_option==-1)
                return;
            if(file_option==0)
            {
                resulte = inputTreatment("Enter File Name including ending if no file type given\n"+
                    "a .txt file will be created(if the file exists it wll be overwritten)\n"+
                    "be aware that all inputs are non case sensitive");
            }
            else
                resulte =FILES[file_option];
            resulte = setEnding(resulte);
        }
        if(!resulte.equals(""))          
            actForDecision(decision, resulte.toLowerCase());
    }

    /**
     * a method to navigate between the needed acts for the decision of the user
     * 
     * @param    decision, String result
     **/
    private void actForDecision(int decision, String result)
    {
        if(decision==1)
        {
            if(my_dictionary.termInList(result))
            {
                String meaning = my_dictionary.searchTerm(result);
                JOptionPane.showMessageDialog(null,meaning);
            }
            else
                JOptionPane.showMessageDialog(null,"this term does not exists yet in this dictionary");
        }
        else if(decision==2)
        {
            if(my_dictionary.termInList(result))
                JOptionPane.showMessageDialog(null,"this term is already exist you can update it in the menu if you'd like");
            else
            {
                String meaning = inputTreatment("Enter Meaning");
                if(!meaning.equals(""))
                {
                    my_dictionary.addItem(new DictionaryItem(result, meaning));
                    JOptionPane.showMessageDialog(null,"the new term have been added");
                }
            }
        }
        else if (decision == 3)
        {
            if(my_dictionary.termInList(result))
            {                    
                my_dictionary.removeTerm(my_dictionary.getItemByTerm(result));
                JOptionPane.showMessageDialog(null,"the term have been deleted");
            }
            else
                JOptionPane.showMessageDialog(null,"this term does not exists yet in this dictionary");
        }
        else if (decision == 4)
        {
            if(my_dictionary.termInList(result))
            {
                String meaning = inputTreatment("Enter new Meaning (the previous one will be deleted)");
                if(!meaning.equals(""))
                {
                    my_dictionary.updateTerm(my_dictionary.getItemByTerm(result),meaning);
                    JOptionPane.showMessageDialog(null,"the term meaning have been updated");
                }
            }
            else
                JOptionPane.showMessageDialog(null,"this term does not exists yet in this dictionary");
        }
        else if (decision ==5)
        {
            Dictionary temp;
            temp = fa.read(result, my_dictionary);
            if(temp != null)
                my_dictionary = temp;
            else 
                JOptionPane.showMessageDialog(null,"this file don't exists please try again");

        }
        else
        {
            int temp;
            temp = fa.write(result, my_dictionary);
            if(temp==1)
                JOptionPane.showMessageDialog(null,"the dictionary been added to your file("+result+")");
            else if(temp == 0)
                JOptionPane.showMessageDialog(null,"couldn't create the file ");
            else
                JOptionPane.showMessageDialog(null,"this file is unwritable please try different file");
        }
    }

    /**
     * this method receive a user decision and act according to it
     * if everything was ok then it can return true else it will return false
     * 
     * @param    decision
     * @return  boolean a continue flag
     **/
    public boolean decisionActs(int decision)
    {       
        boolean _continue = true; 
        if(decision==-1||decision==7)
        {
            JOptionPane.showMessageDialog(null,"good bey"); 
            _continue = false;
        }
        else
            actForDecison(decision);  
        return _continue;
    }
}
