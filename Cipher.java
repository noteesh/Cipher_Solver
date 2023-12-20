import java.util.*;

/**
 * Calculates the encryption or decryption of phrases based on the
 * type of cipher the user selects.
 * @author Nitesh Kanamarlapudi
 */
public class Cipher {

    /** Minimum number for the shift amount in a caesar cipher*/
    public static final int MIN_SHIFT_AMOUNT = 1;
    
    /** Maximum number for the shift amount in a caesar cipher*/
    public static final int MAX_SHIFT_AMOUNT = 25;
    
    /** Number of letters in the alphabet*/
    public static final int LETTERS_IN_ALPHABET = 26;
    
    /** Uppercase encryption table for substitution cipher*/
    public static final char[] UPPER_ENCRYPT_SUBSTITUTION_TABLE = {
        'J', 'I', 'D', 'O', 'T', 'H', 'U', 'Q', 'E', 'W',
        'R', 'X', 'K', 'S', 'Z', 'C', 'G', 'L', 'P', 'A',
        'Y', 'B', 'M', 'F', 'N', 'V'};
        
    /** Lowercase encryption table for substitution cipher*/
    public static final char[] LOWER_ENCRYPT_SUBSTITUTION_TABLE = {
        'j', 'i', 'd', 'o', 't', 'h', 'u', 'q', 'e', 'w',
        'r', 'x', 'k', 's', 'z', 'c', 'g', 'l', 'p', 'a',
        'y', 'b', 'm', 'f', 'n', 'v'};
        
    /** Uppercase decryption table for substitution cipher*/
    public static final char[] UPPER_DECRYPT_SUBSTITUTION_TABLE = {
        'T', 'V', 'P', 'C', 'I', 'X', 'Q', 'F', 'B', 'A', 
        'M', 'R', 'W', 'Y', 'D', 'S', 'H', 'K', 'N', 'E', 
        'G', 'Z', 'J', 'L', 'U', 'O'};
        
    /** Lowercase decryption table for substitution cipher*/
    public static final char[] LOWER_DECRYPT_SUBSTITUTION_TABLE = {
        't', 'v', 'p', 'c', 'i', 'x', 'q', 'f', 'b', 'a', 
        'm', 'r', 'w', 'y', 'd', 's', 'h', 'k', 'n', 'e', 
        'g', 'z', 'j', 'l', 'u', 'o'};
        
    /**
     * Prompts user for type of cipher, and if the user wants an 
     * encryption or decryption and outputs the encrypted or 
     * decrypted phrase.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
    
        // Month of departure
        Scanner scnr = new Scanner(System.in);
        
        // Array for the phrase inputted by the user
        char[] phrase;
        
        // Option for which cipher the user wants
        String option = "";

        while (!option.equalsIgnoreCase("Q")) {
        
            //Printing user interface
            displayMenu();
            
            //Scanning which cipher user wants to use
            option = scnr.nextLine();

            //Calculates the encrypted/decrypted phrase for a caesar cipher
            if (option.equalsIgnoreCase("C")) {
            
                //User's choice for encryption/decryption in a caesar cipher
                System.out.print("E-ncrypt/D-ecrypt: ");
                String caesarAction = scnr.next();
                
                //Calculating if the user wants to encrypt or decrypt
                if (caesarAction.length() == 1) {
                    
                    // Character to see if the user wants an encryption or decryption
                    char caesarEncryption = caesarAction.charAt(0);
                    
                    // If the user selects encryption, encryption becomes true
                    boolean encryption = false;
                    
                    //ERROR HANDLING IN USER INTERFACE IF ENCRYPT/DECRYPT IS WRONGLY INPUTTED
                    if (caesarEncryption != 'e' && caesarEncryption != 'E' && 
                        caesarEncryption != 'd' && caesarEncryption != 'D') {
                        System.out.println("Invalid input");
                        System.out.println();
                        scnr.nextLine();
                        continue;
                    } //if
                    
                    //User's choice for shift amount in a caesar cipher
                    System.out.print("Shift amount(1-25): ");
                
                    // Shift amount in a caesar cipher
                    int shiftAmount = Integer.parseInt(scnr.next());
                    
                    //ERROR HANDLING IN USER INTERFACE IF SHIFT AMOUNT IS OUT OF RANGE
                    if (shiftAmount < MIN_SHIFT_AMOUNT || shiftAmount > MAX_SHIFT_AMOUNT) {
                        System.out.println("Invalid amount");
                        System.out.println();
                        scnr.nextLine();
                        continue;
                    } //if
                
                    //User's choice for the phrase in a caesar cipher
                    System.out.print("Phrase: ");
                    phrase = scnr.nextLine().toCharArray();
                    phrase = scnr.nextLine().toCharArray();
                    
                    //Testing if the user wants an encryption
                    if (caesarEncryption == 'e' || caesarEncryption == 'E') {
                        encryption = true;
                        caesarCipher(phrase, true, shiftAmount);
                    } //if
                    
                    //Testing if the user wants a decryption
                    else if (caesarEncryption == 'd' || caesarEncryption == 'D') {
                        encryption = false;
                        caesarCipher(phrase, false, shiftAmount);
                    } //else if
                      
                      //ERROR HANDLING IN USER INTERFACE FOR ENCRYPT/DECRYPT
                    else {
                        System.out.println("Invalid input");
                    } //else
                    
                    //Output if user wants an encrypted phrase
                    if (encryption) {
                        System.out.println("Encrypted phrase: " + String.valueOf(phrase));
                        System.out.println();
                    } //if
                    
                    //Output if user wants a decrypted phrase
                    else {
                        System.out.println("Decrypted phrase: " + String.valueOf(phrase));
                        System.out.println();
                    } //else
                } //if
                  
                  //ERROR HANDLING IN USER INTERFACE IF ENCRYPT/DECRYPT IS INPUTTED WRONG
                else {
                    System.out.println("Invalid input");
                    System.out.println();
                    scnr.nextLine();
                } //else
            } //if
            
            //Calculates the encrypted/decrypted phrase for a rail fence cipher
            else if (option.equalsIgnoreCase("R")) {
            
                //User's choice for encryption/decryption in a rail fence cipher
                System.out.print("E-ncrypt/D-ecrypt: ");
                String railFenceAction = scnr.next();

                //Calculating if the user wants to encrypt or decrypt
                if (railFenceAction.length() == 1) {
                
                    // Character to see if the user wants an encryption or decryption
                    char railFenceEncryption = railFenceAction.charAt(0);
                    
                    // If the user selects encryption, encryption becomes true
                    boolean encryption = false;
                    
                    //ERROR HANDLING IN USER INTERFACE IF ENCRYPT/DECRYPT IS WRONGLY INPUTTED
                    if (railFenceEncryption != 'e' && railFenceEncryption != 'E' && 
                        railFenceEncryption != 'd' && railFenceEncryption != 'D') {
                        System.out.println("Invalid input");
                        System.out.println();
                        scnr.nextLine();
                        continue;
                    } //if
                    
                    //User's choice for the phrase in a rail fence cipher
                    System.out.print("Phrase: ");
                    phrase = scnr.nextLine().toCharArray();
                    phrase = scnr.nextLine().toCharArray();
                    
                    //Testing if the user wants an encryption
                    if (railFenceEncryption == 'e' || railFenceEncryption == 'E') {
                        encryption = true;
                        phrase = railFenceCipher(phrase, true);
                    } //if
                    
                    //Testing if the user wants a decryption
                    else if (railFenceEncryption == 'd' || railFenceEncryption == 'D') {
                        encryption = false;
                        phrase = railFenceCipher(phrase, false);
                    } //else if
                    
                    //ERROR HANDLING IN USER INTERFACE FOR ENCRYPT/DECRYPT
                    else {
                        System.out.println("Invalid input");
                    } //else
                    
                    //Output if user wants an encrypted phrase
                    if (encryption) {
                        System.out.println("Encrypted phrase: " + String.valueOf(phrase));
                        System.out.println();
                    } //if
                    
                    //Output if user wants a decrypted phrase
                    else {
                        System.out.println("Decrypted phrase: " + String.valueOf(phrase));
                        System.out.println();
                    } //else
                } //if
                
                //ERROR HANDLING IN USER INTERFACE IF ENCRYPT/DECRYPT IS INPUTTED WRONG
                else {
                    System.out.println("Invalid input");
                    System.out.println();
                    scnr.nextLine();
                } //else
            } //else if
            
            //Calculates the encrypted/decrypted phrase for a substitution cipher
            else if (option.equalsIgnoreCase("S")) {
            
                //User's choice for encryption/decryption in a substitution cipher
                System.out.print("E-ncrypt/D-ecrypt: ");
                String substitutionAction = scnr.next();
                
                //Calculating if the user wants to encrypt or decrypt
                if (substitutionAction.length() == 1) {
                
                    // Character to see if the user wants an encryption or decryption
                    char substitutionEncryption = substitutionAction.charAt(0);
                    
                    // If the user selects encryption, encryption becomes true
                    boolean encryption = false;
                    
                    //ERROR HANDLING IN USER INTERFACE IF ENCRYPT/DECRYPT IS WRONGLY INPUTTED
                    if (substitutionEncryption != 'e' && substitutionEncryption != 'E' && 
                        substitutionEncryption != 'd' && substitutionEncryption != 'D') {
                        System.out.println("Invalid input");
                        System.out.println();
                        scnr.nextLine();
                        continue;
                    } //if
                    
                    //User's choice for the phrase in a substitution cipher
                    System.out.print("Phrase: ");
                    phrase = scnr.nextLine().toCharArray();
                    phrase = scnr.nextLine().toCharArray();
                    
                    //Testing if the user wants an encryption
                    if (substitutionEncryption == 'e' || substitutionEncryption == 'E') {
                        encryption = true;
                        substitutionCipher(phrase, true);
                    } //if
                    
                    //Testing if the user wants a decryption
                    else if (substitutionEncryption == 'd' || substitutionEncryption == 'D') {
                        encryption = false;
                        substitutionCipher(phrase, false);
                    } //else if
                    
                    //ERROR HANDLING IN USER INTERFACE FOR ENCRYPT/DECRYPT
                    else {
                        System.out.println("Invalid input");
                    } //else
                    
                    //Output if user wants an encrypted phrase
                    if (encryption) {
                        System.out.println("Encrypted phrase: " + String.valueOf(phrase));
                        System.out.println();
                    } //if
                    
                    //Output if user wants a decrypted phrase
                    else {
                        System.out.println("Decrypted phrase: " + String.valueOf(phrase));
                        System.out.println();
                    } //else
                } //if
                
                //ERROR HANDLING IN USER INTERFACE IF ENCRYPT/DECRYPT IS INPUTTED WRONG
                else {
                    System.out.println("Invalid input");
                    System.out.println();
                    scnr.nextLine();
                } //else
            } //else if
            
            //ERROR HANDLING IN USER INTERFACE IF THE OPTION ISN'T A CIPHER OPTION OR QUIT
            else if (!option.equalsIgnoreCase("Q")) {
                System.out.println("Invalid option.");
                System.out.println();
            } //else if
        } //while
        System.out.println();
    } //main method
    
    /**
     * Prints user interface for the ciphers
     */
    public static void displayMenu() {
        
        System.out.println("Cipher Program - Please choose an option.");
        System.out.println();
        System.out.println("C - Caesar");
        System.out.println("R - Rail Fence");
        System.out.println("S - Substitution");
        System.out.println("Q - Quit");
        System.out.println();
        System.out.print("Option: ");
    } //displayMenu method

    /**
     * Calculates the encryption and decryption phrase of a caesar cipher
     * 
     * @param phrase array of the user's inputted phrase
     * @param encrypt boolean of whether the user wants to encrypt or decrypt their phrase
     * @param shiftAmount number of letters needed to be shifted forward or backwards for 
     *           each character in the user's phrase
     * @throws IllegalArgumentException "Invalid amount" if the shift amount is less than
     *            1 or greater than 25
     */
    public static void caesarCipher(char[] phrase, boolean encrypt, int shiftAmount) {
    
        //ERROR HANDLING IN USER INTERFACE IF SHIFT AMOUNT IS OUT OF RANGE
        if (shiftAmount < MIN_SHIFT_AMOUNT || shiftAmount > MAX_SHIFT_AMOUNT) {
            throw new IllegalArgumentException("Invalid amount");
        } //iff

        //Direction of shift based on encrypt/decrypt
        int direction;
        
        //if encrypt is true, direction is positive
        if (encrypt) {
            direction = 1;
        } //if
        
        //else, direction is positive
        else {
            direction = -1;
        } //else
        
        //Calculating the encrypted/decrypted phrase
        for (int i = 0; i < phrase.length; i++) {
            char c = phrase[i];
            if (Character.isLetter(c)) {
                char base;
                if (Character.isUpperCase(c)) {
                    base = 'A';
                } //if
                else {
                    base = 'a';
                } //else
                phrase[i] = (char) (base + (LETTERS_IN_ALPHABET + 
                                            c - base + shiftAmount * 
                                            direction) % LETTERS_IN_ALPHABET);
            } //if
        } //for
    } //caesarCipher method

    /**
     * Calculates the encryption and decryption phrase of a rail fence cipher
     * 
     * @param phrase array of the user's inputted phrase
     * @param encrypt boolean of whether the user wants to encrypt or decrypt their phrase
     * @return railFence the encrypted/decrypted phrase array from the rail fence cipher
     */
    public static char[] railFenceCipher(char[] phrase, boolean encrypt) {
    
        //creating the bottom part of the array phrase for the rail fence cipher
        char[] bottomPhrase = new char[phrase.length / 2];
        
        //creating the top part of the array phrase for the rail fence cipher
        char[] topPhrase = new char[phrase.length - bottomPhrase.length];
        
        //creating the final rail fence array that carries the encrypted/decrypted array
        char[] railFence = new char[phrase.length];
        
        //calculating if user wants an encrypted array and storing it in railFence
        if (encrypt) {
            int j = 0;
            for (int i = 0; i < phrase.length; i += 2) {
                topPhrase[j] = phrase[i];
                j++;
            } //for
            int k = 0;
            for (int i = 1; i < phrase.length; i += 2) {
                bottomPhrase[k] = phrase[i];
                k++;
            } //for
            railFence = (String.valueOf(topPhrase) + 
                         String.valueOf(bottomPhrase)).toCharArray();
        } //if
        
        //calculating if user wants a decrypted array and storing it in railFence
        else {
            String writtenPhrase = String.valueOf(phrase);
            topPhrase = (writtenPhrase.substring(0, (topPhrase.length))).toCharArray();
            bottomPhrase = (writtenPhrase.substring((topPhrase.length), 
                                                     phrase.length)).toCharArray();
            
            int j = 0;
            for (int i = 0; i < phrase.length; i += 2) {
                railFence[i] = topPhrase[j];
                j++;
            } //for
            int k = 0;
            for (int i = 1; i < phrase.length; i += 2) {
                railFence[i] = bottomPhrase[k];
                k++;
            } //for
        } //else
        //returning the encrypted/decrypted railFence array back to main method
        return railFence;
    } //railFenceCipher method

    /**
     * Calculates the encryption and decryption phrase of a substitution cipher
     * 
     * @param phrase array of the user's inputted phrase
     * @param encrypt boolean of whether the user wants to encrypt or decrypt their phrase
     */
    public static void substitutionCipher(char[] phrase, boolean encrypt) {
        
        //Calculating the encrypted/decrypted phrase of the substitution cipher
        for (int i = 0; i < phrase.length; i++) {
            
            //char c holds each character of the phrase array with each for loop iteration
            char c = phrase[i];
            
            //if c holds a letter, it gets substituted for the substitution cipher letter
            if (Character.isLetter(c)) {
            
                //Uppercase 'A' and lowercase 'a' serve as an array starting point
                char start;
                
                //Using uppercase 'A' as starting point if c holds an uppercase letter
                if (Character.isUpperCase(c)) {
                    start = 'A';
                } //if
                
                //Using lowercase 'a' as starting point if c holds a lowercase letter
                else {
                    start = 'a';
                } //else
                
                //index is the number of how far c is away from the starting point
                int index = c - start;

                //if the user wants to encrypt, finds the encrypted character for c
                if (encrypt) {
                
                    //if c is uppercase, c is substituted through a uppercase array
                    if (Character.isUpperCase(c)) {
                        phrase[i] = UPPER_ENCRYPT_SUBSTITUTION_TABLE[index];
                    } //if
                    
                    //if c is lowercase, c is substituted through a lowercase array
                    else {
                        phrase[i] = LOWER_ENCRYPT_SUBSTITUTION_TABLE[index];
                    } //else
                } //if
                
                //if the user wants to decrypt, finds the decrypted character for c
                else {
                
                    //if c is uppercase, c is substituted through a uppercase array
                    if (Character.isUpperCase(c)) {
                        phrase[i] = UPPER_DECRYPT_SUBSTITUTION_TABLE[index];
                    } //if
                    
                    //if c is lowercase, c is substituted through a lowercase array
                    else {
                        phrase[i] = LOWER_DECRYPT_SUBSTITUTION_TABLE[index];
                    } //else
                } //else
            } //if
        } //for
    } //substitutionCipher method
} //cipher class
