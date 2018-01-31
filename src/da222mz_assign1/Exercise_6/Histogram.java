package da222mz_assign1.Exercise_6;


//TODO fix layout and names and stuff
/**
To the testers: Run the application with the -f parameter
then provide the path to your file.
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import org.knowm.xchart.*;

public class Histogram {
	
	// Returns a histogramArray
	public static double[] histogramArray(String path,int mX) throws IOException {
		double[] hList = new double[mX/10+1];
		File hFile = new File(path);
		Scanner input = new Scanner(hFile);
		
		while (input.hasNext()) {
			int value = input.nextInt();
			
			if (value < 0 ^ value > mX) {
				hList[hList.length-1]++;
			}
			else {
				hList[(value-1)/10]++;
			}
		}

		input.close();
		
		return hList;
	}
	
	//Check param, returns -1 if not found
	public static int paramIndex(String param, String[] args) {
		int index = -1;
		for (int i = 0; i < args.length;i++) {
			if (args[i].equals(param)) {
				index = i;
			}
		}
		return index;
	}
	
	public static boolean paramCheck(String param, String[] args) {
		for (int i = 0; i < args.length;i++) {
			if (args[i].equals(param)) {
				return true;
			}
		}
		return false;
	}
	
	//Make pie
	public static PieChart getPie(int w, int h) {
			    return new PieChartBuilder().width(w).height(h).build();
	}
	
	//Make bar
	public static CategoryChart getBar(int w, int h, String t, String x, String y) {
		return new CategoryChartBuilder().width(w).height(h).title(t).xAxisTitle(x).yAxisTitle(y).build();
}
		
	public static void main(String[] args) {
		boolean paramS, paramF;
		double list[];
		int maxSize = 100; //Default size
		String path = "";
		
		//check params
		paramF = paramCheck("-f",args);
		paramS = paramCheck("-s",args);
		

		//if param -f
		if (paramF) {
			try {
				path = args[paramIndex("-f",args)+1];
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.err.println("Provide a path to your file!");
				System.exit(1);
			}
		}
		
		//if param -s		
		if (paramS) {
			try {
				maxSize = Integer.parseInt(args[paramIndex("-s",args)+1]);
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.err.println("Provide a max size!");
				System.exit(1);
			}
		}
		
		//create custom size list
		list = new double[maxSize/10+1];
		
		//Save histogram as array
		try {
			list = histogramArray(path,maxSize);
		}
		
		catch (IOException e){
			e.printStackTrace();
			System.err.println("Use parameter \"-f\" and provide a path to your file!");
			System.exit(1);
		}
			
		//Info
		System.out.println("Reading numbers from the file: "+path);
		
		//Make charts
	    PieChart pie = getPie(800,600);
	    CategoryChart bar = getBar(800,600,"Histogram","Value","Quantity");
		
		//Make lists for bar diagram
		List<Double> yBarList = new ArrayList<Double>();
		List<String> xBarList = new ArrayList<String>();
		
		//Transfer data from histogram array to the bar list
		for (int i = 0;i < list.length;i++) {
			yBarList.add(list[i]);
		}
		
		//Fill xdata list for bar diagram
		for (int i = 0;i < maxSize/10;i++) {
			xBarList.add(Integer.toString((i+1)*10));
		}
		
		//Add others to chart
		pie.addSeries("Others", list[list.length-1]);
		xBarList.add("Others");
		
	    //Add lists to charts
		for (int i = 0;i < list.length-1;i++) {
			pie.addSeries(Integer.toString(1+i*10)+"-"+(i+1)*10, list[i]);
		}
		bar.addSeries("Data",xBarList,yBarList);
	    
		//Display
	    new SwingWrapper<>(pie).displayChart();
	    new SwingWrapper<>(bar).displayChart();
	}

}
