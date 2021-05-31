import javax.swing.JOptionPane;
public class DictionaryMain
{
    public static void main(String[]args)
    {
        DictionaryUIActions actions= new DictionaryUIActions();           
        String[] options = {"view" ,"Search", "Add", "Remove", "update", "read file","write file", "leave"};
        boolean _continue = true;
        JOptionPane.showMessageDialog(null,"hello this is Ariel's dictionary lets start");
        while(_continue)
        {            
            int decision = JOptionPane.showOptionDialog(null, "please press the needed button","Ariel's Dictionary home",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
            _continue = actions.decisionActs(decision);                  
        }         
    }
}
