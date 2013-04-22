
import javassist.NotFoundException;
import javassist.expr.Cast;
import javassist.expr.ExprEditor;
import javassist.expr.FieldAccess;
import javassist.expr.MethodCall;


public class Reader extends ExprEditor 
{
	public void edit (FieldAccess f)
	{
		try 
		{
			
			System.out.println ("fieldAcess " + f.getField().getType().getName() + " " + f.getField().getName() + " " + f.getField().toString());
		
			
		} 
		catch (NotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void edit (Cast c)
	{
	
			System.out.println ("cast " + c.getEnclosingClass());
		
	
	}
	
	public void edit (MethodCall mc)
	{
	
			System.out.println ("method call " + mc.getMethodName());
		
	
	}
}
