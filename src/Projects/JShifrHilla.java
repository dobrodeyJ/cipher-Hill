package Projects;

import java.util.Scanner;

public class JShifrHilla {
    private Convert convert;
    private JKeyHill objectKey;
    private Scanner scanner;
    private int sizeKey;
    
    public JShifrHilla(int sizeKey) {
         this.sizeKey = sizeKey;
         this.scanner = new Scanner(System.in);
         this.convert = new Convert(sizeKey);
         this.objectKey = new JKeyHill(sizeKey);
    }
    
    public String Shifruvannya(String text) {
        double arrayShifr[][] = new JMatrix().Dobytok(convert.toCode(text), objectKey.getKey());
        arrayShifr = mod29(arrayShifr);
        return convert.toSymbols(arrayShifr);
    }
    public void setKey(String symbolKey) {
        checkKode(symbolKey);
    }
    
    private void checkKode(String symbolKey) {
        if(symbolKey.length() != Math.pow(sizeKey, 2)) {
            System.out.println("Error size Key, input new Key");
            checkKode(scanner.nextLine());
        }
            else if(objectKey.checkKey(symbolKey))
                objectKey.generateKey(symbolKey);
        else {
            System.out.println("Error Key, input new Key");
            checkKode(scanner.nextLine());
        }
    }
    
    public String DeShifruvannya(String shifr) {
        double arrayText[][] = new JMatrix().Dobytok(convert.toCode(shifr), objectKey.getDKey());
        arrayText = mod29(arrayText);
        return convert.toSymbols(arrayText);
    }
    
    private  double [][] mod29(double arrayCode[][]) {
        for(int i = 0; i < arrayCode.length; i++)
            for(int j = 0; j < arrayCode[i].length; j++)
                arrayCode[i][j] %= 29; 
        return arrayCode;
    }
}
