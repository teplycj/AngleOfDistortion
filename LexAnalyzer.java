import java.io.File;
import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

public class LexAnalyzer{

    String[] dirs;

    public LexAnalyzer() throws FileNotFoundException{
       String[] tempArray = new String[1];
       tempArray[0] = "lowestNRG.txt";
       ReadFile setupDirs = new ReadFile();
       Scanner dirFile = setupDirs.readFile(tempArray);
       dirs = new String[15];
       for(int i=0;i<15;i++){
          dirs[i] = dirFile.nextLine();
       }
    }

    void sendIt() throws FileNotFoundException{
            for(int y=0; y<15; y++){
                String tempString = dirs[y]+"CONTCAR";
                System.out.println(tempString);
                String[] newArray = new String[1];
                newArray[0]=tempString;
                Scanner toParse;
                ReadFile toRead = new ReadFile();
                toParse= toRead.readFile(newArray);
                mrAnalyzer(toParse);
            }
        
    }
    
    private void mrAnalyzer(Scanner a){
        Scanner contcar=a;
        String ogX;
        String ogY;
        String ogZ;
        String bSite;
        String xSite;
        String ySite;
        String zSite;
        for(int i=0;i<2;i++){
            contcar.nextLine();
        }
        ogX = contcar.nextLine();
        ogY = contcar.nextLine();
        ogZ = contcar.nextLine();
        for(int i=0;i<4;i++){
            contcar.nextLine();
        }
        bSite=contcar.nextLine();
        zSite=contcar.nextLine();
        ySite=contcar.nextLine();
        xSite=contcar.nextLine();
        
        //System.out.println(xSite);
        //System.out.println(ySite);
        //System.out.println(zSite);
        //System.out.println();
        
        double[] cartX = getCoords(ogX);
        double[] cartY = getCoords(ogY);
        double[] cartZ = getCoords(ogZ);
        double[] b = getCoords(bSite);
        double[] z = getCoords(zSite);
        double[] y = getCoords(ySite);
        double[] x = getCoords(xSite);
        
        MathBoi doMath = new MathBoi();
        doMath.findCenter(cartX,cartY,cartZ,b,x,y,z);
        
    }
    
    private double[] getCoords(String s){
    
        Scanner disLine = new Scanner(s);
        double[] toReturn = new double[3];
        toReturn[0] = disLine.nextDouble();
        toReturn[1]= disLine.nextDouble();
        toReturn[2] = disLine.nextDouble();
        return toReturn;
    
    }

}







