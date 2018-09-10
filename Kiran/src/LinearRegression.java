
import java.util.function.*;
import java.util.*;

enum GradientDescentChoice{
	STOCHASTIC,BATCH
}
public class LinearRegression
{

	
	private double  slope;

	private double yintercept;

	// It can be optimised using hyper parameter
	// optimization
	private double learningRate = 0.1d;

	// I have kept it as 50 but it can user supplied as well.
	private int epoch=50;
	
	private double[][] trainingSet;
	
	private GradientDescentChoice gradientChoice;
	
	//private static final String choice = "Stochastic";
	
	public LinearRegression(double[] [] set,int epoch,GradientDescentChoice gradientChoice)
	{
		this.trainingSet=set;
		
		this.epoch = epoch>0?epoch:this.epoch;
		
		this.gradientChoice=gradientChoice;
		
		trainModel();
	}
	
	
	private final void trainModel()
	{
		if(GradientDescentChoice.STOCHASTIC.equals((this.gradientChoice)))
		{
			stochasticGradientDescent();
		}else
		{
			batchGradientDescent();
		}
		
	}


	private void batchGradientDescent()
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
	
	
	private void stochasticGradientDescent()
	{
		for(int i =0;i<epoch*100;i++)
		{
			//int randomIndex = Math.r
			
			Random random = new Random();
			int randomIndex = random.nextInt(trainingSet.length);
			
			double slopeGradient = derivativeWithRespectToSlope(trainingSet[randomIndex][0],trainingSet[randomIndex][1],slope,yintercept);
			double interceptGradient = derivativeWithRespectToSlope(trainingSet[randomIndex][0],trainingSet[randomIndex][1],slope,yintercept);
			
			this.slope = slope - learningRate*slopeGradient;
			this.yintercept= yintercept-learningRate*interceptGradient;
			
			this.yintercept= yintercept-learningRate*interceptGradient;
		}
	}


	private double derivativeWithRespectToSlope(Double actual,Double x,Double slope,Double intercept)
	{
		double derivative= 2*x*(slope*x+intercept-actual);

		return derivative;
	}

	private double derivativeWithRespectToIntercept(Double actual,Double x,Double slope,Double intercept)
	{
		double derivative=2*(actual-slope*x-intercept);

		return derivative;
	}
	
	
	public double predict(double predictForValue)
	{
		return  yintercept+(slope*predictForValue);
	}
	

}
