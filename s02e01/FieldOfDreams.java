package s02e01;
import java.util.Scanner;
public class FieldOfDreams {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String letter="", word="Itis", word2="";
		int k=word.length();
		for (int i=0; i<word.length(); i++){
			word2=word2+"X";
		}
		while (k!=0){
			System.out.println(word2);
			letter=in.nextLine();
			for (int i=0; i<word.length(); i++){
				if (letter.equals(word.substring(i,i+1).toLowerCase())){
					k--;
					word2=word2.substring(0,i)+word.substring(i,i+1)+word2.substring(i+1);
				}
			}
		}
		System.out.println(word);
	}

}
