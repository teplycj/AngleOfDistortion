import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class ReadFile{

   private File inputFile;

   Scanner readFile(String[] args) throws FileNotFoundException{
   
      if(handleArguments(args)){
         Scanner toParse = new Scanner(inputFile);
         //CoordsLexAnalyzer scan = new CoordsLexAnalyzer(args);
         //scan.scanInput(toParse);
         return toParse;
      }else{
        return null;
      }
   }
   
   private static final String USAGE = "Usage: MakePOSCAR UnitCellCoords.txt A_site B_site X_site Direction.";

   private boolean handleArguments(String[] args){

      if(args.length != 1){
         System.out.println("Wrong number of command line arguments.");
         System.out.println(USAGE);
         return false;
       }
      
      inputFile = new File(args[0]);
      if(!inputFile.canRead()){
         System.out.println("The file " + args[0] + " cannot be opened for input.");
         System.out.println(USAGE);
         return false;
      }
      
      return true;
   }
   
   

}
