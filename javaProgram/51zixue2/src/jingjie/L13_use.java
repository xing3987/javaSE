package jingjie;

public class L13_use implements java.io.Serializable{//对象要变成对象流进行数据传送要实现 java.io.Serializable端口
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
