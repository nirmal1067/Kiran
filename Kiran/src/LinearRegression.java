public class LinearRegression
{

	private double  slope;

	private double yintercept;

	// It can be optimised using hyper parameter
	// optimization
	private double learningRate = 0.1d;

	// I have kept it as 50 but it can user supplied as well.
	private int epoch=50;


	public void trainAlgorithm(double[][] trainingSet)
	{
		for(int i=0;i<epoch;i++)
		{

			double gradientSlope=0;
			double gradlentIntercept=0;

			for(int j= 0 ; j< trainingSet.length;j++)
			{
				gradientSlope = gradientSlope+derivativeWithRespectToSlope(null,null,null,null);
				gradlentIntercept = gradlentIntercept+derivativeWithRespectToIntercept(null,null,null,null);
			}

			slope = slope - learningRate* gradientSlope;
			yintercept = yintercept - learningRate*gradlentIntercept;

		}

		//slope= slope - learningRate*
	}


	private double derivativeWithRespectToSlope(Double actual,Double x,Double slope,Double intercept)
	{
		double derivative=0;

		return derivative;
	}

	private double derivativeWithRespectToIntercept(Double actual,Double x,Double slope,Double intercept)
	{
		double derivative=0;

		return derivative;
	}

}
