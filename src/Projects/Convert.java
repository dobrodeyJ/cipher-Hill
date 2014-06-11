package Projects;

public class Convert {
	private int codeSymbols[];
	private String smallSymbols;
	private String bigSymbols;
	private int amountSymbols;
	private int countRow;
		
		public Convert() {
			amountSymbols = 29;	
		}

	    public Convert(int countRow) {
	       this.countRow = countRow;
	       amountSymbols = 29;
	       smallSymbols = "abcdefghijklmnopqrstuvwxyz ,.";
	       bigSymbols   = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ,.";
	        codeSymbols = new int[amountSymbols];
	        for(int i = 0; i < amountSymbols; i++)
	            codeSymbols[i] = i;
	    }
	    
	    public double[][] toCode(String symbols) {
	        int columns = amountColumn(symbols.length());
	        double code[][] = new double[countRow][columns];
	        for(int row = 0; row < countRow; row++)
	            for(int col = 0; col < columns; col++)
	                code[row][col] = 100;
	        for(int i = 0; i < symbols.length(); i++){
	            boolean flag = true;
	            for(int col = 0; col < columns; col++) {
	                if(!flag) break;
	                for(int row = 0; row < countRow; row++) {
	                    if(code[row][col] == 100){
	                        code[row][col] = checkSymbols(symbols.charAt(i));
	                        flag = false;
	                        break;
	                    }
	                }
	            }
	        }
	        for(int i = 0; i < code.length; i++)
	            for(int j = 0; j < code[i].length; j++)
	                if(code[i][j] == 100)
	                    code[i][j] = 26;
	        return code;
	    }

	    
	    public String toSymbols(double code[][]) {
	        String symbols = new String();
	        int size = code[0].length;
	        for(int i = 0; i < size; i++)
	            for(int j = 0; j < code.length; j++)
	                symbols += checkNumber(code[j][i]);
	        return symbols;
	    }
	    private int amountColumn(int amountSymbol) {
	        if(amountSymbol % countRow == 0)
	            return amountSymbol / countRow;
	        else
	            return amountSymbol / countRow + 1;
	    }
	    private int checkSymbols(char symbol){
	        for(int i = 0; i < amountSymbols; i++) 
	            if(symbol == smallSymbols.charAt(i) ||
	                        symbol == bigSymbols.charAt(i))
	                            return codeSymbols[i];
	        return 1;      
	    }
	    
	    private char checkNumber(double values) {
	        for(int i = 0; i < amountSymbols; i++) 
	           if(codeSymbols[i] == values)
	               return bigSymbols.charAt(i);
	        return 1;
	    }
	    public int getAmountSymbols() {
	    	return amountSymbols;
	    }
}
