
import java.util.*;
public class MultiLinearRegression
{
	
	private Map<Integer,List<Double>> traingSet = new HashMap<Integer,List<Double>>();
	
	private Double[] slopes;
	
	private Double yintercept;
	
	
	private Double derivativeofCoefficents(Double[] derivatives, int index,int derivativeIndex)
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
	
}
