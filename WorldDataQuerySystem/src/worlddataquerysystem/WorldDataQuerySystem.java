// PROJECT:  WorldDataQuerySystem
// AUTHOR:
// LAB SECTION:
// DESCRIPTION:
//
//
//
// INPUT FILE DESCRIPTION (a .csv file)
//      NOTE:  string fields are enclosed in quotes, which need to be removed
//      EXTRA NON-DATA:  INSERT INTO `Country` VALUES (
//          to be discarded
//      [ONLY SOME OF THESE FIELDS ARE USED IN THIS PROJECT - SEE SPECS]
//              code,name,continent,region,landArea,indepYear,population,
//              lifeExpectancy,gnp  
//      OTHER FIELDS NOT USED IN THIS PROJECT
//*****************************************************************************
package worlddataquerysystem;

import java.io.*;                   // contains File class - use for any
                                    //      file-I/O classes/methods
import java.util.Scanner;           // same Scanner class methods (nextLine,...)
                                    //      used for reading from a FILE
                                    //      as when reading from the KEYBOARD
public class WorldDataQuerySystem {

        private String name;
        private String continent;
        private int landArea;
        private int population;
        private float lifeExpectancy;
        private int gnp;
        private int n;
    
    public static void main(String[] args) throws IOException {
        
        UserInteraction.introMessage();
        
        final int MAX_N = 300;
        WorldDataQuerySystem[] cA = new WorldDataQuerySystem[MAX_N];
        cA=FillArrayData();
        int n=cA[0].n;
       
        System.out.println(""+n);     
       
        int in, out;

        for (out = 1; out < n; out++) {
            WorldDataQuerySystem temp = cA[out];
            in = out;

            while (in > 0 && cA[in - 1].name.compareTo(temp.name) > 0) {
                cA[in] = cA[in - 1];
                --in;
            }
            cA[in] = temp;
        }
    
        int option = UserInteraction.mainMenu();
        Query qOb = new Query();
            switch (option) {
                case 1:
                    qOb.showDataFor1Country();
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                default:
                    break;
            }
        }
    
    
    public void getName(String name){this.name = name; }
    public void getContinent(String continent){this.continent = continent; }
    public void getLandArea(int landArea){this.landArea = landArea; }
    public void getPopulation(int population){this.population = population; }
    public void getLifeExpectancy(float getLifeExpectancy){this.lifeExpectancy = lifeExpectancy; }
    public void getGnp(int gnp){this.gnp = gnp; }
    public void getN(int n){this.n = n; }
    
    private static WorldDataQuerySystem[] FillArrayData() throws IOException{
        
        

                         // final makes it a constant
        String csvFile = "C:\\Users\\Phil\\Desktop\\Google Drive\\CS 1110\\Lab\\WorldFacts\\WorldDataQuerySystem\\WorldData.csv";
	BufferedReader br = null;
	String line = "";
	String splitBy = ",";
        int index = 0;
        
        final int MAX_N = 300;
        WorldDataQuerySystem[] tempArray = new WorldDataQuerySystem[MAX_N];
        
        try {
		br = new BufferedReader(new FileReader(csvFile));
                
        while ((line = br.readLine()) != null) {
             tempArray[index]=new WorldDataQuerySystem();
             String[] country = line.split(splitBy);
             //System.out.println(country[4]);
             tempArray[index].getName(country[1]);
             tempArray[index].getContinent(country[2]);
             tempArray[index].getLandArea(Integer.parseInt(country[4]));
             tempArray[index].getPopulation(Integer.parseInt(country[6]));
             tempArray[index].getLifeExpectancy(Float.parseFloat(country[7]));
             tempArray[index].getGnp(Integer.parseInt(country[8]));
             
             index++;
 
        }
        tempArray[0].getN(index);
        
        } catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
   
        
       
        return tempArray ;
    }
    
    
    
    
    
    
    
}
