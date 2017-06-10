package akpkc.swapper;

/**
 * Created by Kpkc on 10.06.2017.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {


    private String path;
    public ReadFile(String file_path)
    {
        path = file_path;
    }
    public String[] OpenFile() throws IOException {

        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);

        int numberOfLines = 10000;//1000000;
        String [] textData = new String[numberOfLines];
        int i=0;
        String strLine;
        while ((strLine = textReader.readLine()) != null)   {
            // Print the content on the console
            strLine= strLine.replaceAll("null", "\"null\"");
            textData[i]= strLine;
            i++;
        }

        textReader.close();
        String[] textData2=new String[i];
        int b=0;
        for(String a: textData)
        {
            if (a!=null)
            {
                textData2[b]=textData[b];
                b++;
            }
        }

        return textData2;
    }
}
