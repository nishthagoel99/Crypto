/*
Crypto is a project that basically encrypts and decrypts texts!
Noemalizetext(): removes the spaces,punctuation marks from the text and then convert it into uppercase
Caeserify():shifts the characters of the string by a value taken by the user
Groupify(): makes groups of letters(no of letters entered by the user)

 */
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.util.Scanner;

public class crypto {
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the string: ");
        String string1=input.nextLine();
        System.out.print("Enter the key (number) places past the original letter? ");
        int key=input.nextInt();
        System.out.print("Enter the number of letters per group? ");
        int letter=input.nextInt();
        string1=encrypt(string1,key,letter);
        System.out.println("The string after being encrypted is : " + string1);

    }
    public static String encrypt(String string1,int key,int letter){
        string1= normalizetext(string1);
        string1=caesarify(string1, key);
        string1=groupify(string1, letter);
        return string1;
    }
    public static String normalizetext(String string1)
    {
        //REMOVING PUNCTUATIONS
        string1=string1.replace("."," ");
        string1=string1.replace(","," ");
        string1=string1.replace("!"," ");
        string1=string1.replace("?"," ");
        string1=string1.replace("'"," ");
        string1=string1.replace("/"," ");
        string1=string1.replace("\""," ");
        string1=string1.replace("("," ");
        string1=string1.replace(")"," ");
        string1=string1.replace(";"," ");
        string1=string1.replace(":"," ");
        string1=string1.replace("\\"," ");
        string1=string1.replaceAll(" ",""); //REMOVING SPACES
        string1=string1.toUpperCase(); //converting to upper case
        return string1;
    }
    public static String caesarify(String string1,int key)
    {
        int l=string1.length();
        String result = "";
        char z,b;
        int a;
        for(int i=0;i<l;i++) {
            z = string1.charAt(i);
            a = (int) z + key;
            b = (char) a;
            if (b < 'A') {
                a=a-(int)'A'+(int)'Z'+1;
                b=(char)a;
            }else
                if(b>'Z'){
                    a=a-(int)'Z'+(int)'A'-1;
                    b=(char)a;
            }
            result+=b;

        }
        return result;
    }
    public static String groupify(String string1,int letter)
    {
        String result="";
        int length=string1.length();
        int jnew=0;
        if(length%letter==0)
        {
            for(int i=1;i<=length;i++)
            {
                char val=string1.charAt(i-1);
                if(i%letter==0)
                {

                    result=result+val+ " ";
                }else
                {
                    result+=val;
                }
            }
        }else
        {
            for(int j=1;j<=length;j++) {
                char val = string1.charAt(j - 1);
                if (j % letter == 0) {

                    result = result + val + " ";
                } else {
                    result += val;
                }
                jnew=j;
            }
                while(jnew%letter!=0)
                {
                    result+='x';
                    jnew++;
                }
        }
        return result;
    }
}
