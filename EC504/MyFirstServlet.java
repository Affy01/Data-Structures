
package chapter1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.*;
import javax.servlet.ServletContext;
/**
 *
 * @author alexchowdhury
 */
@WebServlet(name = "MyFirstServlet", urlPatterns = {"/MyFirstServlet"})

public class MyFirstServlet extends HttpServlet {
    //-----------------------------------------------------------------------------------//
//									NODE CLASS
//-----------------------------------------------------------------------------------//
	public static class Node{
		Node left;
		Node right;
		double x;
		double y;
		String state;
		String city;
		public Node(String state, String city, double x, double y){
			this.state = state;
			this.city = city;
			this.x = x;
			this.y = y;
			left = null;
			right = null;
		}
	}
//-----------------------------------------------------------------------------------//
//									TREE CLASS
//-----------------------------------------------------------------------------------//
	public static class Tree{
		public Node root;
		public Tree(){
			this.root = null;
		}

//-----------------------------------------------------------------------------------//
//							TREE - INSERTING A NODE IN THE TREE
//-----------------------------------------------------------------------------------//
		public void insertInTree(String state, String city, double x, double y){
			Node temp = new Node(state,city,x,y);
			if (root == null){
				root = temp;
				return;
			}
			else{
				Node current = root;
				int level = 0;
				while(true){
					if(level%2 == 0){
						if(x <= current.x){
							if(current.left == null){
								current.left = temp;
								return;
							}
							else{
								current = current.left;
								level = level+1;
							}
						}
						else{
							if(current.right == null){
								current.right = temp;
								return;
							}
							else{
								current = current.right;
								level = level+1;
							}
						}
					}
					else{
						if(y <= current.y){
							if(current.left == null){
								current.left = temp;
								return;
							}
							else{
								current = current.left;
								level = level+1;
							}
						}
						else{
							if(current.right == null){
								current.right = temp;
								return;
							}
							else{
								current = current.right;
								level = level+1;
							}
						}	
					}
				}
			}
		}

//-----------------------------------------------------------------------------------//
//						TREE - DISPLAYING THE TREE
//-----------------------------------------------------------------------------------//
		public void display(Node root){
			if(root!=null){
				display(root.left);
				System.out.println("City = " + root.city + ", x = " + root.x + ", y = " + root.y);
				display(root.right);
			}
		}
//-----------------------------------------------------------------------------------//
//						TREE - SEARCHING THE TREE
//-----------------------------------------------------------------------------------//
		public ArrayList<Node> search(Node temp, double x, double y, int counter, ArrayList<Node> array, double radius){
			int level = 1;
			while(temp != null && counter > 0){
				if(Math.abs(x-temp.x) <= radius && Math.abs(y-temp.y) <= radius){
					if(!array.contains(temp)){
						array.add(temp);
						counter = counter - 1;
					}
					if(level%2 == 0){
						if(x <= temp.x){
							temp = temp.left;
						}
						else{
							temp = temp.right;
						}
						level = level + 1;
					}
					else{
						if(y <= temp.y){
							temp = temp.left;
						}
						else{
							temp = temp.right;
						}
						level = level + 1;
					}
				}
				else{
					if(level%2 == 0){
						if(x <= temp.x){
							temp = temp.left;
						}
						else{
							temp = temp.right;
						}
						level = level + 1;
					}
					else{
						if(y <= temp.y){
							temp = temp.left;
						}
						else{
							temp = temp.right;
						}
						level = level + 1;
					}
				}
			}
			return array;
		}
	}
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                ServletContext servletContext = getServletContext();
//                String path = servletContext.getRealPath("/WEB-INF/");
//                File newFile2 = new File(path+"/NationalFile_StateProvinceDecimalLatLong.txt");
        String mar1 = request.getParameter("field1");
        double kap1=0.0;
        try{
        kap1=Double.parseDouble(mar1);
        }
        catch(Exception e){}
        System.out.println(mar1);
        String mar2 = request.getParameter("field2");
        double kap2=0.0;
        try{
        kap2=Double.parseDouble(mar2);
        }
        catch(Exception e){}
        System.out.println(mar2);
                Tree myTree = new Tree();
		ArrayList<Node> arrayLeft = new ArrayList<Node>();
		ArrayList<Node> arrayRight = new ArrayList<Node>();
		ArrayList<Node> arrayFinal = new ArrayList<Node>();
//                File varTmpDir = new File("NationalFile_StateProvinceDecimalLatLong.txt");
//                boolean exists = varTmpDir.exists();
//                System.out.println(exists);
                
//                		response.setContentType("text/html");
//		
//		//
//		// We are going to read a file called configuration.properties. This
//		// file is placed under the WEB-INF directory.
//		//
//		String filename = "/WEB-INF/NationalFile_StateProvinceDecimalLatLong.txt";
//		
//		ServletContext context = getServletContext();
//		
//		//
//		// First get the file InputStream using ServletContext.getResourceAsStream()
//		// method.
//		//
//		InputStream is = context.getResourceAsStream(filename);
//		if (is != null) {
//			InputStreamReader isr = new InputStreamReader(is);
//			BufferedReader reader = new BufferedReader(isr);
//			PrintWriter writer = response.getWriter();
//			String text = "";
//			
//			//
//			// We read the file line by line and later will be displayed on the 
//			// browser page.
//			//
//			while ((text = reader.readLine()) != null) {
//				writer.println(text);
//			}
//                }
                response.setContentType("text/html");
		String filename = "/WEB-INF/NationalFile_StateProvinceDecimalLatLong.txt";
		
		ServletContext context = getServletContext();
		InputStream is = context.getResourceAsStream(filename);
		try{
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			PrintWriter writer = response.getWriter();
			String line;
			while((line = br.readLine()) != null){
//                                System.out.println(line);
				if(line.matches(".*\\d+.*")){
//                                    System.out.println(line);
 					myTree.insertInTree((line.split("	"))[0], (line.split("	"))[1], Double.parseDouble((line.split("	"))[2]), Double.parseDouble((line.split("	"))[3]));
                                }
			}
			br.close();
		}
		catch(Exception e){
			System.out.println("Error!");
		}

		double radius = 0.0;
		int counter = 10;
                
		double x = kap1;
		double y = kap2;
//                myTree.display(myTree.root);
//                System.out.println(myTree.root.city);
//                System.out.println(myTree.root.left.city);
//                System.out.println(myTree.root.city);
//                System.out.println("Done!");
//             
		while(arrayLeft.size() < 10){
			radius = radius + 0.1;
			arrayLeft = myTree.search(myTree.root.left,x,y,counter,arrayLeft,radius);
			counter = 10 - arrayLeft.size();
		}

		counter = 10;
		radius = 0.0;

		while(arrayRight.size() < 10){
			radius = radius + 0.1;
			arrayRight = myTree.search(myTree.root.right,x,y,counter,arrayRight,radius);
			counter = 10 - arrayRight.size();
		}
		int i = 0;
		int j = 0;
		while((i < arrayLeft.size() && j < arrayRight.size()) || arrayFinal.size() < 1){
			if((Math.abs((arrayLeft.get(i).x)-x) < Math.abs(arrayRight.get(j).x)-x) && (Math.abs((arrayLeft.get(i).y)-y) < Math.abs(arrayRight.get(j).y)-y)){
				arrayFinal.add(arrayLeft.get(i));
				i = i + 1;
			}
			else{
				arrayFinal.add(arrayRight.get(j));
				j = j + 1;
			}
		}

		for(int m = 0; m < arrayLeft.size(); m++){
				System.out.println("City = " + arrayLeft.get(m).city + ", x = " + arrayLeft.get(m).x + ", y = " + arrayLeft.get(m).y);
		}

		System.out.println("=======================================================");

		for(int n = 0; n < arrayRight.size(); n++){
				System.out.println("City = " + arrayRight.get(n).city + ", x = " + arrayRight.get(n).x + ", y = " + arrayRight.get(n).y);
		}
                                double[] testarrayx = new double[10];
                                double[] testarrayy = new double[10];
		System.out.println("=======================================================");
		for(int m = 0; m < arrayFinal.size(); m++){
				System.out.println("City = " + arrayFinal.get(m).city + ", x = " + arrayFinal.get(m).x + ", y = " + arrayFinal.get(m).y);

                                testarrayx[m] = arrayFinal.get(m).x;
                                testarrayy[m] = arrayFinal.get(m).y;
                }
//	response.setContentType("text/html;charset=UTF-8");
        PrintWriter outx = response.getWriter();       
        outx.println(testarrayx);
        request.setAttribute("testarrayx", testarrayx); 
        RequestDispatcher rdx = getServletContext().getRequestDispatcher("/MyFirstJSP.jsp");
        rdx.forward(request, response);
        PrintWriter outy = response.getWriter();       
        outy.println(testarrayy);
        request.setAttribute("testarrayy", testarrayy); 
        RequestDispatcher rdy = getServletContext().getRequestDispatcher("/MyFirstJSP.jsp");
        rdy.forward(request, response);
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
