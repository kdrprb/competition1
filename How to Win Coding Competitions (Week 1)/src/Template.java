import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Template {
    

    static Scanner newInput() throws IOException {
        return new Scanner(new File("template.in"));
    }
    
    static PrintWriter newOutput() throws IOException {
        return new PrintWriter("template.out");
    }

    public static void main(String[] args) throws IOException {
        try (Scanner in = newInput(); PrintWriter out = newOutput()) {
            
            // get dimensions
            String[] firstLineArray = in.nextLine().split(" ");
            int w = Integer.parseInt(firstLineArray[0]);
            int h = Integer.parseInt(firstLineArray[1]);
            
            
            // setup keyboard
            Map<String,Integer> xCoord = new HashMap<String,Integer>();
            Map<String,Integer> yCoord = new HashMap<String,Integer>();
            for(int i=0; i<h; i++)
            {
                char[] nextLineChars = in.nextLine().toCharArray();
                
                for(int j=0; j<w; j++)
                {
                    String nextChar = String.valueOf(nextLineChars[j]);
                    xCoord.put(nextChar, j);
                    yCoord.put(nextChar, i);
                }
            }
            
            //System.out.println(xCoord);
            //System.out.println(yCoord);
            in.nextLine();
            
            // add each template by language
            List<String> templateNames = new ArrayList<String>();
            List<List<String>> templates = new ArrayList<List<String>>();
            while(in.hasNext())
            {
                String currentTemplateName = in.nextLine();
                templateNames.add(currentTemplateName);
                List<String> currentTemplate = new ArrayList<String>();

                String currentLine = in.nextLine();
                while(!currentLine.isEmpty()) {
                    char[] currentCharArray = currentLine.toCharArray();
                    for(int i=0; i < currentCharArray.length; i++) currentTemplate.add(String.valueOf(currentCharArray[i]));
                    currentLine = in.nextLine();
                }

                templates.add(currentTemplate);
            }            
            
/*            LinkedHashMap<String,List<String>> templates = new LinkedHashMap<String,List<String>>();
            while(in.hasNext())
            {
                String currentTemplateName = in.nextLine();
                List<String> currentTemplate = new ArrayList<String>();

                String currentLine = in.nextLine();
                while(!currentLine.isEmpty()) {
                    char[] currentCharArray = currentLine.toCharArray();
                    for(int i=0; i < currentCharArray.length; i++) currentTemplate.add(String.valueOf(currentCharArray[i]));
                    currentLine = in.nextLine();
                }
                
                templates.put(currentTemplateName, currentTemplate);
            }
*/            
            //System.out.println(templates);
            
            // calculate costs of all templates
            int minCost = -1;
            String minCostTemplateName = "";
            
            for(int a=0; a<templateNames.size(); a++)
            {                
                String currentTemplateName = templateNames.get(a);
                List<String> currentTemplate = templates.get(a);
                
                // calculate cost of current template
                int currentCost=0; 
                String currentKey = currentTemplate.get(0);
                int currentX = xCoord.get(currentKey);
                int currentY = yCoord.get(currentKey);
                for(int i=1; i<currentTemplate.size(); i++)
                {
                    currentKey = currentTemplate.get(i);
                    int newX = xCoord.get(currentKey);
                    int newY = yCoord.get(currentKey);
                    currentCost += Math.max(Math.abs(newX-currentX),Math.abs(newY-currentY));
                    currentX = newX;
                    currentY = newY;                    
                }

                // keep track of min cost template
                if(minCostTemplateName.isEmpty())
                {
                    minCost = currentCost;
                    minCostTemplateName = currentTemplateName;
                }
                else if(currentCost < minCost)
                {
                    minCost = currentCost;
                    minCostTemplateName = currentTemplateName;                    
                }
                
            }
            
/*            Iterator<String> templateIterator = templateNames.iterator();
            while (templateIterator.hasNext())
            {
                String currentTemplateName = templateIterator.next();
                List<String> currentTemplate = templates.get(currentTemplateName);
                
                // calculate cost of current template
                int currentCost=0; 
                String currentKey = currentTemplate.get(0);
                int currentX = xCoord.get(currentKey);
                int currentY = yCoord.get(currentKey);
                for(int i=1; i<currentTemplate.size(); i++)
                {
                    currentKey = currentTemplate.get(i);
                    int newX = xCoord.get(currentKey);
                    int newY = yCoord.get(currentKey);
                    currentCost += Math.max(Math.abs(newX-currentX),Math.abs(newY-currentY));
                    currentX = newX;
                    currentY = newY;                    
                }
                
                //System.out.println("currentTemplateName:" + currentTemplateName);
                //System.out.println("cost:" + currentCost);
                
                // keep track of min cost template
                if(minCostTemplateName.isEmpty())
                {
                    minCost = currentCost;
                    minCostTemplateName = currentTemplateName;
                }
                else if(currentCost < minCost)
                {
                    minCost = currentCost;
                    minCostTemplateName = currentTemplateName;                    
                }
                
            }
*/
            // print out lowest cost template name and cost
            out.println(minCostTemplateName);
            out.println(minCost);

        }
    }

}

