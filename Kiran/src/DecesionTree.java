
import java.util.*;
public class DecesionTree
{
	
	private class Question{
		
		public String type;
		
		public String question;
		
		public String operator;
		
	}
	
	
	private List<TreeNode> list = new ArrayList<TreeNode>();
	
	private HashMap trainingData= new HashMap();
	
	
	private HashMap<String,Question> questions = new HashMap<String,Question>();
	
	
	private TreeMap<Double,String> informationGainMap = new TreeMap<Double,String>();
	
	private HashMap<String,Double> EntrophyMap = new HashMap<String,Double>();
	
	private void prepareQuestions()
	{
		for(Object key : trainingData.keySet())
		{
			if(key instanceof String)
			{
				Question question = new Question();
				question.type="String";
				List<String> list = (List<String>)trainingData.get(key);
				
				 Collections.sort(list);
				 
				 int maxCount=0;
				 String str="";
				 int rCount =1;
				 for(int i=0;i<list.size();i++)
				 {
					 if(list.get(i).equals(list.get(i+1)))
					 {
						 rCount= rCount+1;
					 }else{
						 rCount = 1;
					 }
					 
					 if(rCount>maxCount)
					 {
						 maxCount=rCount;
						 str = list.get(i);
					 }
				 }
				 
				 question.question= str;
				
				
			}
			
			
		}
	}
	
	
	private String findQuestionParameter(int index)
	{
		List<String> list = (List<String>)trainingData.get(index);
		Integer average =0;
		for(String number :list)
		{
			average = average + Integer.valueOf(number);
		}
		
		average = average/list.size();
		
		return String.valueOf(average);
	}
	
	
	private Double findEntrophy(int total,int yesCounts,int noCounts)
	{
		return 0d;
	}
	
	private void informationGainMap(HashMap data)
	{
		
	}
	
	private TreeNode createNode(TreeNode node)
	{
		Double infoGain = informationGainMap.firstKey();
		
		String key = informationGainMap.get(infoGain);
		
		TreeNode treeNode = new TreeNode();
		
		treeNode.informationGain= infoGain;
		
		treeNode.question = questions.get(key);
		
		treeNode.entrophy= EntrophyMap.get(key);
		
		return treeNode;
		
	}
	
	
	
	
	
	public TreeNode buildTree(HashMap trainingData,Double entrophy)
	{
		HashMap<Integer,Value> map = new HashMap<Integer,Value>();
		
		
		
		return new TreeNode();
	}
	
	private Value buildInformationValue(TreeNode node)
	{
		return new Value();
	}
	
	private void buildEntrophyMap(Double entrophy,HashMap trainData)
	{
		
	}
	
	public Integer featureCount;
	
	private void recursive()
	{
		TreeNode maxNode = null;
		Value valueInfoGain=null;
		if(featureCount>0)
		{
		for(TreeNode node : list)
		{
			//TreeNode maxNode= null;
			//int infoGain = 0;
			Value v = buildInformationValue(node);
			
			if(valueInfoGain==null)
			{
				valueInfoGain=v;
				maxNode=node;
			}else
			{
				if(v.informationGain>valueInfoGain.informationGain)
				{
					valueInfoGain=v;
					maxNode=node;
				}
			}
			
		}
	
		if(valueInfoGain.informationGain >0.005d)
		buildActualTree(maxNode,valueInfoGain.QuestionIndex);
	}
	
	
	}
	
	private void buildActualTree(TreeNode node,int questionIndex)
	{
		
	}
	
	
	
	private class TreeNode {
		
		public Double informationGain;
		
		public Double entrophy;
		
		public Question question;
		

		public boolean isLeafNode;
		
		public HashMap containingData = new HashMap();
		
		public String accuracy;
		
		
		
	}
	
	private class Value{
		
		public double informationGain;
		
		public double entrophy;
		
		public double leftEntrophy;
		
		public int QuestionIndex;
		
		public double rightEntrophy;
	}
	
}
