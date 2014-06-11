package test;
import java.text.DecimalFormat;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import Projects.*;


public class TestMatrix {
	private JMatrix matr;
	DecimalFormat decFormat;
	
	@Before
	public void  initialization() {
		matr = new JMatrix();
		decFormat = new DecimalFormat("#.##");
	}
	@Test
	public void testDeterninantSizeTwo() {
		double [][]matrix = {{1,2},{3,7}};
		double determinant = Double.parseDouble(decFormat.format(matr.determinant(matrix)));
		double result = 1;
		Assert.assertEquals(result, determinant);	
	}
	@Test
	public void testDeterminantSizeThreeNull() {
		double [][]matrix = {{1,2,3},{1,2,3},{1,2,3}};
		double determinant = matr.determinant(matrix);
		double result = 0;
		Assert.assertEquals(result, determinant);
	}
	@Test
	public void testDeterminantsSizeThree() {
		double [][]matrix = {{6,24,1},{13,16,10},{20,17,15}};
		double determinant = Double.parseDouble(decFormat.format(matr.determinant(matrix)));
		double result = 441;
		Assert.assertEquals(result, determinant);	
	}
	@Test
	public void testDeterminantSizeFour(){
		double [][]matrix = {{1,3,8,5},{4,5,7,8},{2,3,2,2},{1,10,4,8}};
		double determinant = Double.parseDouble(decFormat.format(matr.determinant(matrix)));
		double result = 373;
		Assert.assertEquals(result, determinant);	
	}
	@Test
	public void testDeterminantSizeFive(){
		double [][]matrix = {{2,4,5,8,9},{23,2,8,9,10},{2,8,3,12,10},{3,7,8,9,2},{2,2,1,3,5}};
		double determinant = Double.parseDouble(decFormat.format(matr.determinant(matrix)));
		double result = -7913;
		Assert.assertEquals(result, determinant);	
	}
	@Test
	public void testDeterminantSizeSix(){
		double [][]matrix = {{2,3,5,7,8,1},{2,5,7,9,2,1},{4,5,8,1,8,3},
							 {7,9,2,1,2,2},{3,1,23,3,3,1},{3,5,8,6,2,1}};
		double determinant = Double.parseDouble(decFormat.format(matr.determinant(matrix)));
		double result = -4128;
		Assert.assertEquals(result, determinant);	
	}
	@Test
	public void testDeterminantSizeSeven(){
		double [][]matrix = {{3,7,8,3,2,5,2},{5,7,8,2,1,9,3},{22,34,2,3,2,1,22},
							 {33,2,1,1,1,2,2},{4,5,8,7,9,10,2},{3,4,8,9,3,2,1},
							 {12,4,7,9,4,3,2}};
		double determinant = Double.parseDouble(decFormat.format(matr.determinant(matrix)));
		double result = 277520;
		Assert.assertEquals(result, determinant);	
	}
	@Test
	public void testObernMatrix() {
		double [][]matrix = {{2,1,3},{2,2,3},{1,2,2}};
		double [][]result = {{-2,4,-3},{-1,1,0},{2,-3,2}};
		double [][]obernMatrix = matr.obernArray(matrix);
		Assert.assertEquals(result, obernMatrix);
	}
}
