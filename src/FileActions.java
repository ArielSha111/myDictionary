import java.io.File;  // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter clas
public class FileActions
{

    /**
     * a method to read from a file
     * 
     * @param   String file_name, Dictionary dictionary
     * @return  Dictionary the Dictionary thet conatin the file data
     **/
    public Dictionary read(String file_name, Dictionary dictionary)
    {        
        String term;
        String meaning = "";
        String temp_meaning;
        try
        {
            Scanner input = new Scanner(new File(file_name)); //open the needed file and make it readable
            while (input.hasNext())//as lomg as there is what to read
            {
                term = input.nextLine();//we read it and save it as p_description
                while(input.hasNext())
                {
                    temp_meaning = input.nextLine();
                    if(temp_meaning==null||temp_meaning.equals("")||temp_meaning.equals("\n"))
                    {
                        dictionary.addItem(new DictionaryItem(term,meaning));
                        break;
                    }
                    meaning += temp_meaning;
                }
                meaning = "";
            } 
        }
        catch (FileNotFoundException e)
        {
            return null;
        }
        return  dictionary;
    }

    /**
     * a method to write to a file
     * 
     * @param    file_name, Dictionary dictionary
     * @return  int according to the ability to open or write in the file
     **/
    public int write(String file_name, Dictionary dictionary)
    {
        try 
        {
            File file = new File(file_name);
            file.createNewFile(); 
        } 
        catch (IOException e) 
        {
            return 0;
        }
        try 
        {
            FileWriter myWriter = new FileWriter(file_name);
            myWriter.write(dictionary.toString());
            myWriter.close();
            return 1;
        } 
        catch (IOException e)
        {
            return -1;
        }
    }
}
