//package dk.brics.soot.callgraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import soot.MethodOrMethodContext;
import soot.PackManager;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootMethod;
import soot.Transform;
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
				   "testers.CallGraphs",//main-class
				   "testers.CallGraphs"//argument classes
		   }));
		

		   PackManager.v().getPack("wjtp").add(new Transform("wjtp.myTrans", new SceneTransformer() {

			@Override
			protected void internalTransform(String phaseName, Map options) {
			       CHATransformer.v().transform();
			       SootClass clas = Scene.v().loadClassAndSupport("testers.CallGraphs");//loading class....
				       List<SootMethod> l=new ArrayList();       
				      l= clas.getMethods(); //getting all methods of a class......

				      Iterator targets = l.iterator();
					CallGraph cg = Scene.v().getCallGraph();
				       while (targets.hasNext()) {
				    	   
				           SootMethod tgt = (SootMethod)targets.next();//getting each method
				           System.out.println("Method name========"+tgt);
				           
			
				           
					       
												//System.out.println("Cg=="+cg);
					       Iterator<MethodOrMethodContext> target = new Targets(cg.edgesOutOf(tgt)); //getting call graph of method
						//System.out.println("Target="+target);
					       while (target.hasNext()) {
						System.out.println("Coming"+tgt);
					           SootMethod tg = (SootMethod)target.next();
					           System.out.println(tgt + "may call " + tg);
					       }//end of while loop....
    
			      }//end of while loop....
				           
			     }//end of ().......
			   
		   }));//end of PackManager......................

	           args = argsList.toArray(new String[0]);
	                      System.out.println("KKKKKKKKKKKKk");
	           soot.Main.main(args);
		}//end of main().................

}//end of class....
