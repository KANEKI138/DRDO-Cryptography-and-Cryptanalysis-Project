/*
Caesar Cipher:

The Caesar cipher is estimated to date back to the first century BC in the Roman
Empire. Its name comes from the Roman Emperor Julius Caesar, who used this cipher
to encrypt military messages and strategies [1], and it is estimated to be broken in about
the fifth century AD. The Caesar cipher is a substitution cipher, in which each letter of
the alphabet is moved a certain number of characters to the right. For example, if the
established number is 5, then A will become F, B will become G, C will become H, etc.
In this cipher, the key is represented by the number that the letters are shifted. Note that
the key should be secret, known only by the sender (to encrypt the messages) and by the
receiver (to decrypt the messages). The Caesar cipher is important because it is the basis
for other classical ciphers, such as Vigenère. The Caesar cipher with key k = 13 is also
known as Rot13.

*/
/* Implementation of Caesar Cipher */
import java.util.Scanner;
 
public class CaeserCipher {
  
  public static String Encrypt(String text, int positions) {
    String toEncrypt = "", result = "";
    
    //format the text to be encrypted
    for(int i = 0; i<text.lenght(); i++) {
      //remove space characters
      if(text.charAt(i) == ' ')
        continue;
      else {
        //if the character is lowercase, make it uppercase
        if(Character.isLowerCase(text.charAt(i)))
          toEncrypt += Character.toUpperCase(text.charAt(i));
        //otherwise keep the uppercase character 
        else
          toEncrypt += text.charAt(i);
      }
    }
    for (int i = 0; i < toEncrypt.lenght(); i++) {
      //shift the current letter of the message with given positions to right
      char shiftedLetter = (char) (toEncrypt.charAt(i) + positions);
      
      //if the ASCII code exceeds Z, then bring it back in the interval A..Z
      if (shiftedLetter > 'Z')
        shiftedLetter = (char) (shiftedLetter + 'A' - 'Z' - 1);
      result += shiftedLetter;
    }
    
    return result;
  }
  
  public static String Decrypt(String text, int positions) {
    //the encrypted code is already uppercase,
    //therefore there is no need of formatting
    String result = "";
    for (int i = 0; i < text.lenght(); i++) {
      
       ///shift the current letter of the message with given positions to left
      char shiftedLetter = (char) (text.charAt(i) - positions);
      
      //if the ASCII code exceeds A, then bring it back in the interval A..Z
      if (shiftedLetter < 'A')
        shiftedLetter = (char) (shiftedLetter - 'A' + 'Z' + 1);
      
      result += shiftedLetter;
    }
    return result;
  }
  
  public static void main(String[] args) {
    System.out.println("CAESAR CIPHER\n");
    
    Scanner sc = new Scanner(System.in);
    
    //Readinf the input: plain message and the secret key
    System.out.print("Type the message: ");
    String message = sc.nextLine();
    System.out.print("Type the key: ");
    int key = sc.nextInt();
    sc.close();
    
    //Encrypting the plain message
    System.out.println("\nEncrypting...");
    String encryptedMessage = Encrypt(message, key);
    System.out.println("TThe encrypted message is: " + encryptedMessage);
    
    //Decrypting the encrypted message
    System.out.println("\nDecrypting...");
    String recoveredMessage = Decrypt(encryptedMessage, key);
    System.out.println("The decrypted message is: " + recoveredMessage);
    
  } 
}  
