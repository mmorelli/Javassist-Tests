import java.io.File;

import javassist.*;

public class Controller 
{
	private final static String absolutPathToBinaryDirectory = "D:\\Bachelorarbeit\\Javassist Projects\\Source\\bin";
	
	public static void main(String[] args) throws CannotCompileException 
	{
		ClassPool pool = ClassPool.getDefault();
		
		try 
		{
			pool.insertClassPath(absolutPathToBinaryDirectory);
			
			File dir = new File(absolutPathToBinaryDirectory);
			for (File child : dir.listFiles()) 
			{
				String fileName = child.getName();
				
				System.out.println ("class " + fileName + ":");
				
				if (fileName.endsWith(".class"))
				{
					if (child.exists())
					{
						CtClass cc = pool.get(getNameWithoutExtension(fileName));
						cc.instrument (new Reader());
					}
				}
			}
	        
			
			
		} 
		catch (NotFoundException e) 
		{
			e.printStackTrace();
		}



	}
	
	private static String getExtension (String fileName)
	{
		int index = fileName.lastIndexOf('.');
		return fileName.substring(index+1);
	}
	
	private static String getNameWithoutExtension (String fileName)
	{
		int index = fileName.lastIndexOf('.');
		return fileName.substring(0, index);
	}

}
