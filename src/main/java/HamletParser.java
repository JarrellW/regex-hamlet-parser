import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }
    public boolean findHamlet(String findHim){
        String regex = "Hamlet";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(findHim);
        return matcher.find();
    }
    public boolean findHoratio(String findHim){
        String regex = "Horatio";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(findHim);
        return matcher.find();
    }
    public String ChangeHamletToLeon(String changedString){
        String regex = "Hamlet";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(changedString);
        String result = matcher.replaceAll("Leon");
        return result;
    }
    public String ChangeHoratioToTariq(String changedString){
        String regex = "Horatio";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(changedString);
        String result = matcher.replaceAll("Tariq");
        return result;
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

}
