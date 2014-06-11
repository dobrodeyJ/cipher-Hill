package Projects;

public class JKeyHill {
    private double[][]key;
    private double [][]dKey;
    private Convert convert;
    private JMatrix matrix;
    private int amountSymbols;

    public JKeyHill(int sizeKey) {
        convert = new Convert(sizeKey);
        key = new double[sizeKey][sizeKey];
        dKey = new double[sizeKey][sizeKey];
        matrix = new JMatrix();
        amountSymbols = new Convert().getAmountSymbols();
    }

    
    public void generateKey(String symbolsKey) {
        key = convert.toCode(symbolsKey);
        generateDKey(key);
    }
    public void generateDKey(double array[][]) {
        int determinant = modAmount((int)matrix.determinant(array));
        int unDeterminant = modAmount(Evklida(determinant, 29)); 
        double tArray[][] = matrix.transposedMatrix(array);
        for(int i = 0; i < tArray.length ; i++)
            for(int j = 0; j < tArray[i].length; j++)
                tArray[i][j] =  tArray[i][j] * unDeterminant;
        dKey = modAmount(tArray);
    }
    
    public boolean checkKey(String symbolsKey) {
        double [][]arrayKode = convert.toCode(symbolsKey);
        if(matrix.determinant(arrayKode) == 0 || NOD(modAmount((int)matrix.determinant(arrayKode)),29) > 1) 
            return false;
        else 
            return true;
    }
    private double [][] modAmount(double array[][]) {
        for(int i = 0; i < array.length; i++)
            for(int j = 0; j < array[i].length; j++){
                array[i][j] %= amountSymbols;
                if(array[i][j] < 0)
                    array[i][j] += amountSymbols;
            }
        return array;
    }
    private int  modAmount(int values) {
        values %= amountSymbols;
        if(values < 0)
            return values + amountSymbols;
        else
            return values;
    }
    private int NOD(int b, int a) {
        while(a != 0 && b != 0) {
            if(a > b)
                a = a % b;
            else 
                b = b % a;
        }
        return (b + a);
    }
    
    private int Evklida(int c , int d) {
        int uc = 1, vc = 0, ud = 0, vd = 1;
        while(c != 0) {
            int q = d / c;
            int buffC = d % c;
            int buffUc = ud - q * uc;
            int buffVc = vd - q * vc;
            d = c; c = buffC; ud = uc;
            vd = vc; uc = buffUc; vc = buffVc;
        }
        if(ud < 0)
            return ud + amountSymbols;
        else 
        return ud;
    }
    
    public double[][] getDKey() {
        return dKey;
    }
    public double[][] getKey() {
        return key;
    }
}
