package da222mz_assign1.Exercise_3_4_5;

//Insert a path as an argument when running the application

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.lang.StringBuilder;
import java.util.List;

public class PrintJavaMain {
	private static int depth = 0; //Keeps track of folder depth
	
	//Not sure if it should print folders as well, it does so currently
	public static void PrintJava(File directory) throws IOException {
			if (directory.isDirectory()) {
				indentedPrint(directory);
				depth++;
				File[] fileList = directory.listFiles();
				for (File f : fileList) {
					PrintJava(f);
				}
				depth--;
			}
			
			else if (directory.isFile() && directory.getName().contains(".java")) {
				indentedPrint(directory);
			}
		}
	
	public static void indentedPrint(File f) throws IOException {
		StringBuilder deepthBuilder = new StringBuilder();
		for (int i=0;i<depth;i++) {
			deepthBuilder.append("  ");
		}
		if (f.isFile()) {
			List<String> lineList;
			lineList = Files.readAllLines(f.toPath());
			System.out.println(deepthBuilder.toString()+f.getName());
			System.out.println(deepthBuilder.toString()+" "+lineList.size()+" Rows"
					+"\n"+deepthBuilder.toString()+" "+f.length()+" Bytes");
		}
		else {
			System.out.println(deepthBuilder+f.getName());
		}
	}
	
	public static void paramCheck(String[] args) throws IllegalArgumentException {
		if (args.length == 0) {
			throw new IllegalArgumentException("Folder to analyze is required, insert path as application parameter");
		}
	}

	public static void main(String[] args) {
		
		try {
			paramCheck(args);
		}
		
		catch (IllegalArgumentException e) {
			System.out.println(e);
			System.exit(1);
		}
		
		try {
			File f1 = new File(args[0]);
			PrintJava(f1);
		}
		
		catch (IOException e) {
			System.out.println(e);
		}
		
	}

}
