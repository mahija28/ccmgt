package edu.pdx.ccmgt.ccmgt;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

public class Query {
	Cluster cluster;
	Session session;
	ResultSet result;
	
	
	public void connect(String host, int port, String keyspace){
        //creating Cluster object
        cluster = Cluster.builder().withPort(port).addContactPoint(host).build();
        
        //Creating Session object
        session = cluster.connect(keyspace);
	}
	
	public void connect(String host, String keyspace){
        //creating Cluster object
        cluster = Cluster.builder().addContactPoint(host).build();
        
        //Creating Session object
        session = cluster.connect(keyspace);
	}
	
	public void connect (String host, int port){
        //creating Cluster object
        cluster = Cluster.builder().withPort(port).addContactPoint(host).build();
        
        //Creating Session object
        session = cluster.connect();
	}
	
	public void connect (String host){
        //creating Cluster object
        cluster = Cluster.builder().addContactPoint(host).build();
        
        //Creating Session object
        session = cluster.connect();
	}
	
	public void execute(){
		//To To: Write your query here and print out the result
		System.out.println("Query Result:");
		
        //Executing the query
        result = session.execute("select * from emp");
        for(Row row: result){
        	System.out.format("%s %s\n", row.getString("emp_first"), row.getString("emp_last"));
        }
	}
	
	public void hello(){
		System.out.println("Hello World");
	}
};
