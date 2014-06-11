package Projects;

public class JMatrix {
    
    private double determ(double [][]array){
        double values = 1;
        for(int i = 3; i < array.length; i++) {
            values *= array[0][0];
            array = reducedStepin(array);
        }
        double result = values * determinant(array); 
        return result;
    }
    
    public double determinant(double array[][]) {
        int stepen = array.length;
        double result = 0;
        if(stepen > 3) 
          result = determ(array);
        else {
        switch (stepen) {
            case 1: {
                result = array[0][0];
                break;
            }
            case 2: {
                result = array[0][0] * array[1][1]
                        - array[1][0] * array[0][1];
                break;
            }
            case 3: {
                result = array[0][0] * array[1][1] * array[2][2]
                        + array[0][1] * array[1][2] * array[2][0]
                        + array[0][2] * array[1][0] * array[2][1]
                        - array[2][0] * array[1][1] * array[0][2]
                        - array[2][1] * array[1][2] * array[0][0]
                        - array[2][2] * array[1][0] * array[0][1];
                break;
            }
        }
        }
        return result;
    }
    
    public double[][] transposedMatrix(double [][]array) {
        double tArray[][] = new double[array.length][array.length];
            for(int i = 0; i < array.length; i++)
            for(int j = 0; j < array[i].length; j++)
                tArray[j][i] = transpodesValues(i,j,array);
            return tArray;
    }
    public double[][] obernArray(double [][]array) {
        double determinant = determinant(array);
            double tArray[][] = transposedMatrix(array);
            double obernArray[][] = new double[array.length][array.length];
            for(int i = 0; i < tArray.length; i++)
                for(int j = 0; j < tArray[i].length; j++)
                    obernArray[i][j] = tArray[i][j] / determinant;
            return obernArray;
    }
    private double[][] reducedStepin(double array[][]) {
        double result[][] = new double[array.length - 1][array.length - 1];
        for(int i = 1; i < array.length; i++)
            for(int j = 1; j < array[i].length; j++)
                result[i - 1][j - 1] = (array[i][j] * array[0][0] - array[i][0] * array[0][j]) / array[0][0];
        return result;
    }
    
    private double transpodesValues(int rowIndex,int colIndex,double array[][]) {
        double [][]bufferArray = new double[array.length - 1][array.length - 1];
        for(int i = 0; i < array.length; i++)
            for(int j = 0; j < array[i].length; j++) {
                if(i < rowIndex && j < colIndex)
                    bufferArray[i][j] = array[i][j];
                else if(i < rowIndex && j > colIndex)
                    bufferArray[i][j - 1] = array[i][j];
                else if(i  > rowIndex && j < colIndex)
                    bufferArray[i - 1][j] = array[i][j];
                else if(i > rowIndex && j > colIndex)
                    bufferArray[i - 1][j - 1] = array[i][j];
            }   
        if((rowIndex + colIndex) % 2 ==0)
            return determinant(bufferArray);
        else
            return determinant(bufferArray) * -1; 
    }
    
    public double[][] Dobytok(double arrayOne[][], double arrayTwo[][]) {
        int sizeColumn = arrayOne[0].length;
        int sizeRow = arrayTwo.length;
        double temp[][] = new double[sizeRow][sizeColumn];
        for (int i = 0; i < sizeRow; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                temp[i][j] = 0;
                for (int k = 0; k < sizeRow; k++) {
                    temp[i][j] += arrayTwo[i][k] * arrayOne[k][j];
                }
            }
        }
        return temp;
    }
}
