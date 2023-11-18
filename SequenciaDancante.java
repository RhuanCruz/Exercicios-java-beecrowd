import java.util.Scanner;

public class SequenciaDancante {
public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    String entrada = teclado.nextLine();
    String entradaG = entrada.toUpperCase();
    char [] caracteres = entradaG.toCharArray();

    
    for (int i = 1; i < caracteres.length ; i++) {
        if (Character.isLetter(caracteres[i]) && Character.isLowerCase(caracteres[i-1]) && Character.isLowerCase(caracteres[i]) ) {
            caracteres[i]= (char ) (caracteres[i]- 32);
        }
        else if(Character.isLetter(caracteres[i]) && Character.isUpperCase(caracteres[i-1]) && Character.isUpperCase(caracteres[i])){
            caracteres[i] = (char) (caracteres[i] + 32);
        }
    }
    
    System.out.println(caracteres);
    teclado.close();
    
}

}