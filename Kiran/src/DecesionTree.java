
import java.util.*;
public class DecesionTree
{
	
	private class Question{
		
		public String type;
		
		public String question;
		
		public String operator;
		
	}
	
	
	private HashMap trainingData= new HashMap();
	
	
	private List<Question> questions = new ArrayList<Question>();
	
	
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
}
