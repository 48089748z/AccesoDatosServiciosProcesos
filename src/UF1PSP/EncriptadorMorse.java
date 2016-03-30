package UF1PSP;

import java.util.Scanner;

/**
 * Created by 48089748z on 30/03/16.
 */
public class EncriptadorMorse
{
    private static Scanner in = new Scanner(System.in);
    private static String[] characters;
    public static void main(String[] args)
    {
        System.out.println("\nINTRODUCE UNA FRASE PARA CODIFICAR");
        String cadena = in.nextLine();

        System.out.println("\nFRASE ORIGINAL\n"+cadena);

        cadena = textToMorse(cadena);
        System.out.println("\nFRASE CODIFICADA A MORSE\n"+cadena);

        cadena = morseToText(cadena);
        System.out.println("\nFRASE DECODIFICADA DE MORSE\n"+cadena);
    }
    public static String textToMorse(String toTranslate)
    {
        String toReturn = "";
        try
        {
            for (int x=0; x<toTranslate.length(); x++)
            {
                toReturn = toReturn + encode(String.valueOf(toTranslate.charAt(x)))+" ";
            }
            return toReturn;
        }
        catch(Exception lenght0)
        {
            return "";
        }

    }
    public static String morseToText(String morseCode)
    {
        String toReturn = "";
        String[] codes = morseCode.split(" ");
        for (int x=0; x<codes.length; x++)
        {
            toReturn=toReturn+decode(codes[x]);
        }
        return toReturn;
    }
    public static String decode(String morse)
    {
        switch (morse)
        {
            case "-----":{return "0";}
            case ".----":{return "1";}
            case "..---":{return "2";}
            case "...--":{return "3";}
            case "....-":{return "4";}
            case ".....":{return "5";}
            case "-....":{return "6";}
            case "--...":{return "7";}
            case "---..":{return "8";}
            case "----.":{return "9";}
            case ".-":{return "a";}
            case "-...":{return "b";}
            case "-.-.":{return "c";}
            case "-..":{return "d";}
            case ".":{return "e";}
            case "..-.":{return "f";}
            case "--.":{return "g";}
            case "....":{return "h";}
            case "..":{return "i";}
            case ".---":{return "j";}
            case "-.-":{return "k";}
            case ".-..":{return "l";}
            case "--":{return "m";}
            case "-.":{return "n";}
            case "---":{return "o";}
            case ".--.":{return "p";}
            case "--.-":{return "q";}
            case ".-.":{return "r";}
            case "...":{return "s";}
            case "-":{return "t";}
            case "..-":{return "u";}
            case "...-":{return "v";}
            case ".--":{return "w";}
            case "-..-":{return "x";}
            case "-.--":{return "y";}
            case "--..":{return "z";}
            default: {return " ";}
        }
    }
    public static String encode(String character)
    {
        switch (character.toUpperCase())
        {
            case "0":{return "-----";}
            case "1":{return ".----";}
            case "2":{return "..---";}
            case "3":{return "...--";}
            case "4":{return "....-";}
            case "5":{return ".....";}
            case "6":{return "-....";}
            case "7":{return "--...";}
            case "8":{return "---..";}
            case "9":{return "----.";}
            case "A":{return ".-";}
            case "B":{return "-...";}
            case "C":{return "-.-.";}
            case "D":{return "-..";}
            case "E":{return ".";}
            case "F":{return "..-.";}
            case "G":{return "--.";}
            case "H":{return "....";}
            case "I":{return "..";}
            case "J":{return ".---";}
            case "K":{return "-.-";}
            case "L":{return ".-..";}
            case "M":{return "--";}
            case "N":{return "-.";}
            case "O":{return "---";}
            case "P":{return ".--.";}
            case "Q":{return "--.-";}
            case "R":{return ".-.";}
            case "S":{return "...";}
            case "T":{return "-";}
            case "U":{return "..-";}
            case "V":{return "...-";}
            case "W":{return ".--";}
            case "X":{return "-..-";}
            case "Y":{return "-.--";}
            case "Z":{return "--..";}
            default: {return "";}
        }
    }
}
