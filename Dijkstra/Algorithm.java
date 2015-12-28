package shortestpath;

import java.util.HashMap;
import java.util.List;

public class Algorithm
{
    HashMap<String,Integer> hm = new HashMap();
    Node source;
    List<Node> nodeList;

    Algorithm(Node source, List<Node> v)
    {
        this.source = source;
        this.nodeList = v;
    }

    void modifiedDijkstra()         ///False=Already Visited True = Not visited
    {
        for(int i =0;i<nodeList.size();i++)
        {
            nodeList.get(i).inqueue = true;
            nodeList.get(i).dist = Integer.MAX_VALUE;   
        }
        nodeList.get(0).dist = 0;
        nodeList.get(0).inqueue = false;
        
        int temp_min = Integer.MAX_VALUE;
        int temp_index = 0;
//        String temp_node = "";
//        int flag = 0;
//        boolean nodes_run = true;
        int j=0;                                    ///Index to access nodes
        
        for(int flag = 0;flag<nodeList.size();flag++)
        {
            
        for(int i = 0;i<nodeList.get(j).out_list.size();i++)         ///i for out_list
        {
            nodeList.get(j).inqueue = false;

            if( nodeList.get(j).dist + nodeList.get(j).out_list.get(i).len<nodeList.get(j).out_list.get(i).end.dist && nodeList.get(j).dist != Integer.MAX_VALUE)
            {
                nodeList.get(j).out_list.get(i).end.dist = nodeList.get(j).dist + nodeList.get(j).out_list.get(i).len;
                nodeList.get(j).out_list.get(i).end.parent = nodeList.get(j).out_list.get(i).start;                
            }
        }
        
        temp_min = Integer.MAX_VALUE;
        for(int q = 0; q<nodeList.size();q++)
        {
            
            if(nodeList.get(q).inqueue == true && nodeList.get(q).dist<=temp_min)
            {
                temp_min = nodeList.get(q).dist;
                j = q;
            }
        }        

        }
        int array_count[] = new int [nodeList.size()];
        int x = 0;
        int temp_min1 = Integer.MAX_VALUE;
        int  z =0,e = 0;
        
        for(int i =0;i<nodeList.size();i++)
        {
            nodeList.get(i).inqueue = true;
            array_count[i]=0;
            if(i == 0)
            {
                hm.put(nodeList.get(i).name,1);
            }
            else
            hm.put(nodeList.get(i).name,0);

        }
        
        for(int flag = 0; flag<nodeList.size();flag++)
        {
            nodeList.get(x).inqueue = false;
            for(int i = 0;i<nodeList.get(x).out_list.size();i++)
            {

                if(nodeList.get(x).dist + nodeList.get(x).out_list.get(i).len == nodeList.get(x).out_list.get(i).end.dist)
                {
                    z = hm.get(nodeList.get(x).out_list.get(i).end.name);
                    e = hm.get(nodeList.get(x).name);
                    hm.put(nodeList.get(x).out_list.get(i).end.name,z+e);

                }
            }
            temp_min1 = Integer.MAX_VALUE;
            for(int q = 0; q<nodeList.size();q++)
            {
            
                if(nodeList.get(q).inqueue == true && nodeList.get(q).dist <= temp_min1)
                {
                    temp_min1 = nodeList.get(q).dist;
                    x = q;
                    
                    
                }
            }
        }    
    }
    
    public int count (Node node)
        {
            return hm.get(node.name);
        }
}


