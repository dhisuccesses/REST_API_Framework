package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	
	
	public AddPlace userPayLoad(String name, String job)
	{
		AddPlace p =new AddPlace();	
		p.setName(name);
		p.setJob(job);
		return p;
	}
	
	public AddPlace registerPayLoad(String email, String password)
	{
		AddPlace p =new AddPlace();	
		p.setEmail(email);
		p.setPassword(password);
		return p;
	}
	
	public AddPlace registerNegativePayLoad(String email)
	{
		AddPlace p =new AddPlace();	
		p.setEmail(email);
		return p;
	}
	public AddPlace loginPayLoad(String email, String password)
	{
		AddPlace p =new AddPlace();	
		p.setEmail(email);
		p.setPassword(password);
		return p;
	}
	
	public AddPlace loginNegativePayLoad(String email)
	{
		AddPlace p =new AddPlace();	
		p.setEmail(email);
		return p;
	}

}
