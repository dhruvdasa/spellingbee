import java.io.*;
import java.util.*;

public class SpellingBee {
	
	public static void main(String[] args) {
		
		Scanner fileIn=null;
		
		String[] lines=new String[57474];
		
		try {
			fileIn=new Scanner(new File("word.txt"));
		}catch(FileNotFoundException e) {
			System.exit(-1);;
		}
		
		for(int i=0;i<lines.length;i++)
			lines[i]=fileIn.nextLine();
		
//		try {
//			fileIn=new Scanner(new File("words.txt"));
//		}catch(FileNotFoundException e) {
//			System.exit(-1);;
//		}
//		
//		try {
//			FileWriter outFile= new FileWriter("word.txt");
//			
//			for(int i=0;i<lines.length;i++) {
//				
//				lines[i]=fileIn.nextLine();
//				
//				if(lines[i].length()>3)
//					outFile.write(lines[i]+"\n");
//				
//			}
//			
//			outFile.close();
//			
//		}catch(IOException e) {
//			System.out.print("IO issue");
//			System.exit(-1);
//		}
		
		ArrayList<String> validWords=new ArrayList<String>();
		
		Scanner input=new Scanner(System.in);
		
		System.out.println("Which letter has to be in the word? ");
		String need=input.nextLine();
		ArrayList<String> letters=new ArrayList<String>();
		for(int i=0;i<26;i++) 
			letters.add(String.valueOf((char)(i+97)));
		
		System.out.println("Other letters: ");
		String others=input.nextLine();

		for(int i=0;i<6;i++) 
			letters.remove(letters.indexOf(String.valueOf(others.charAt(i))));
		
		
		letters.remove(letters.indexOf(String.valueOf(need.charAt(0))));

		for(int i=0;i<lines.length;i++) 
			
			if(lines[i].indexOf(need)!=-1&&isValid(lines[i],letters)) 
				validWords.add(lines[i]);
		
		for(int i=0;i<validWords.size();i++)
			System.out.println(validWords.get(i));
		
		System.out.println(validWords.size());
	}
	
	public static boolean isValid(String word, ArrayList<String> letters) {
		
		for(int i=0;i<letters.size();i++) {
			
			if(word.indexOf(letters.get(i))!=-1)
				return false;
			
		}
		
		return true;
	}
}
