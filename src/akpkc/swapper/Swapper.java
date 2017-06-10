package akpkc.swapper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Swapper {

    public static void main(String[] args) {
        ReadFile orig,broken;
        int limit;
        String[] origMetin = null,brokenMetin=null;
        String dosya = null,space = " ",blank="",
                censusFile ="C:\\Users\\Kpkc\\Desktop\\p\\census-income.data",
                origFile="C:\\Users\\Kpkc\\Desktop\\p\\orig.txt",
                brokenFile ="C:\\Users\\Kpkc\\Desktop\\p\\broken.txt";

        editer(space,blank,censusFile); //removing space
        editer("\\{",blank,origFile);
        editer("\\{",blank,brokenFile);
        editer("\\}",blank,origFile);
        editer("\\}",blank,brokenFile);


        orig=new ReadFile(origFile);
        broken=new ReadFile(brokenFile);

        try {
            origMetin = orig.OpenFile();
            brokenMetin = broken.OpenFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        limit=origMetin.length;

        for (int a=0;a<limit;a++)
        {
            String[] brokenKelime = brokenMetin[a].split(" ");
            String[] origKelime = origMetin[a].split(" ");
            for (int b=0;b<origKelime.length;b++)
            {
                editer(brokenKelime[b],origKelime[b],censusFile); //removing dupes
            }
        }
        System.out.println("Replacement operation is complete.");
    }



    public static void editer(String from, String to,String location)
    {
        try {
            Path path = Paths.get(location);
            Charset charset = StandardCharsets.UTF_8;
            String content;
            content = new String(Files.readAllBytes(path), charset);
            content = content.replaceAll(from, to);
            Files.write(path, content.getBytes(charset));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Conversion from '"+from+"' to '" +to+"' is done at "+location+".");
    }

}
