
import java.util.*;
public class MultiLinearRegression
{
	
	private Map<Integer,List<Double>> traingSet = new HashMap<Integer,List<Double>>();
	
	private Double[] slopes;
	
	private Double yintercept;
	
	private double learningRate=0.2;
	
	private int epoch;
	
	
	private void batchGradientDescent()
	{
		for(int i=0;i<epoch;i++)
		{
			double[] derivatives = new double[slopes.length];
			int length = traingSet.get(0).size();
			double derivativesIntercept =0;
			for(int j=0;j<length;j++)
			{
				for(int z=0;z<slopes.length;z++)
				{
					
				
				derivatives[z] = derivatives[z]+ derivativeofCoefficents(i,z);
			
				}
				
				derivativesIntercept = derivativeOfIntercept(i);	
				
		     }
			 
		yintercept = yintercept - learningRate * derivativesIntercept;
		
		for(int k=0;k<slopes.length;k++)
		{
			slopes[k] = slopes[k] - learningRate*derivatives[k];
		}
		
				
		}
	}
	
	
	private Double derivativeofCoefficents(int index,int derivativeIndex)
	{
		
		Double x = -(traingSet.get(derivativeIndex).get(index));
		Double derivative = traingSet.get(0).get(index) *x;
		
		for(int i=1;i<slopes.length;i++)
		{
			if(i!=derivativeIndex)
			derivative = derivative + x*slopes[i]*traingSet.get(i).get(index);
		}
		
		derivative = derivative + yintercept;
		
		return derivative;
	}
	
	private Double derivativeOfIntercept(int index)
	{
		Double gradient = traingSet.get(0).get(index);
		
		for(int i=0 ; i <slopes.length;i++)
		{
			gradient = gradient + slopes[i]*traingSet.get(i).get(index);
		}
		
		return gradient;
	}
	
}
