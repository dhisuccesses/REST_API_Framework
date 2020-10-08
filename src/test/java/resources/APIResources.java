package resources;
//enum is special class in java which has collection of constants or  methods
public enum APIResources {
	
	
	GetUserList("/api/users?page=2"),
	CreateUser("api/users"),
	UpdateUser("api/users/"),
	DeleteUser("api/users/"),
	Register("api/register"),
	Login("api/login"),
	GetResourceList("api/unknown"),
	GetResource("api/unknown/"),
	DELAY("api/users?delay="),
	GetUser("api/users/");
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
