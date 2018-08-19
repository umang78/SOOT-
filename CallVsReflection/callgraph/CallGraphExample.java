//package dk.brics.soot.callgraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
//import testers.CallGraphs;
import soot.MethodOrMethodContext;
import soot.PackManager;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootMethod;
import soot.Transform;
import java.lang.reflect.*;
import soot.jimple.toolkits.callgraph.CHATransformer;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Targets;

public class CallGraphExample
{	
	public static void main(String[] args) {

		
	   List<String> argsList = new ArrayList<String>(Arrays.asList(args));
	   argsList.addAll(Arrays.asList(new String[]{
			   "-w",
			   "-main-class",
			   "CallGraphs",//main-class
			   "CallGraphs"
	   }));
	
		
		CallGraphs example=new CallGraphs();
		Class c=example.getClass();
		
		Method[] field=c.getDeclaredMethods();
		for(Method f:field)
		{
			System.out.println("Fiel="+f.getName());
			
		}//end of for loop...


	   PackManager.v().getPack("wjtp").add(new Transform("wjtp.myTrans", new SceneTransformer() {

		@Override
		protected void internalTransform(String phaseName, Map options) {
		       CHATransformer.v().transform();
                      // SootClass a = Scene.v().getSootClass("testers.A");

		       SootClass src = Scene.v().loadClassAndSupport("CallGraphs");
		     //  CallGraph cg = Scene.v().getCallGraph();
		       List<SootMethod> l=new ArrayList();       
		      l= src.getMethods();

		       Iterator targets = l.iterator();
		       while (targets.hasNext()) {
		    	   
		           SootMethod tgt = (SootMethod)targets.next();
		           System.out.println("Soot="+tgt);
			   
		   		      
		       }//end of while loop....
		}
		   
	   }));

           args = argsList.toArray(new String[0]);
                      System.out.println("KKKKKKKKKKKKk");
           soot.Main.main(args);
	}
}

 class CallGraphs
{
	public static void main(String[] args) {
		doStuff();
	}
	
	public static void doStuff() {
		bar();
	}

	public static void foo() {

	}
	
	public static void bar() {
	
	}
}

