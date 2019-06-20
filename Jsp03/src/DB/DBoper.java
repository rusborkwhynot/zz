package DB;
import Bean.User;
import JM.UserInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





public class DBoper {

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private int flag;
	private ArrayList<User> list;
	private User user;
//***************************************************閾炬帴鏁版嵁搴�********************************
	public Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/subject?useUnicode=true&characterEncoding=utf8", "root", "wls123");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("閾炬帴瀛楃涓插嚭閿欙紒");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("椹卞姩鍔犺浇鍑洪敊锛�");
		}
		
		return conn;
	}
	//***************************************************鍏抽棴鏁版嵁搴�********************************	
	public void releaseDB(ResultSet rs,PreparedStatement pst,Connection conn)
	{
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pst!=null)
		{
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	 

	//********************************娌℃湁灏佽鐨勬儏鍐典笅锛屾彃鍏ヤ竴鏉℃暟鎹�********************************
public int AdduserOne(String subname,String subpwd,String onoffline,String subclassification,String subpayment)
	{
		conn=getConnection();
		try {
			pst=conn.prepareStatement("insert into subject(subname,subpwd,onoffline,subclassification,subpayment) values (?,?,?,?,?)");
			pst.setString(1, subname);
			pst.setString(2, subpwd);
			pst.setString(3, onoffline);
			pst.setString(4, subclassification);
			pst.setString(5, subpayment);
			flag=pst.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			releaseDB(rs,pst,conn);
		}
		
		return flag;
	}
	//***************************************************甯︽湁灏佽鐨勬彃鍏ヤ竴鏉℃暟鎹�********************************
	
	public int Adduser(User user)
	{
		conn=getConnection();
		try {
			
			pst=conn.prepareStatement("insert into subject(subname,subpwd,onoffline,subclassification,subpayment) values (?,?,?,?,?)");
			pst.setString(1, user.getSubname());
			pst.setString(2, user.getSubpwd());
			pst.setString(3, user.getOnoffline());
			pst.setString(4, user.getSubclassification());
			pst.setString(5, user.getSubpayment());
		    flag=pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			releaseDB(rs,pst,conn);
		}
		return flag;
	}
	//***************************************************渚濇嵁id淇敼鏁版嵁********************************
	public int UpdatUser(User user,int id)
	{
		conn=getConnection();
		try {
			pst=conn.prepareStatement("update subject set subname=?,subpwd=?,onoffline=?,subclassification=?,subpayment=? where id=?");
			pst.setString(1, user.getSubname());
			pst.setString(2, user.getSubpwd());
			pst.setString(3, user.getOnoffline());
			pst.setString(4, user.getSubclassification());
			pst.setString(5, user.getSubpayment());
		    pst.setInt(7, id);
		    flag=pst.executeUpdate();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			releaseDB(rs,pst,conn);
		}
		return flag;
	}
	//***************************************************渚濇嵁id鍒犻櫎鏁版嵁********************************
	public int DeleteUser(int id)
	{
		conn=getConnection();
		try {
			pst=conn.prepareStatement("delete from subject where id=?");
		    pst.setInt(1, id);
		    flag=pst.executeUpdate();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			releaseDB(rs,pst,conn);
		}
		return flag;
	}
	
//***************************************************鏌ヨ鎵�鏈夌敤鎴稲esultSet瀛樺偍********************************
	public void  Queryallusers()
	{
		conn=getConnection();
		String sql="select * from subject";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next())
			{
				String subname=rs.getString("subname");
				String subpwd=rs.getString("subpwd");
				String onoffline=rs.getString("onoffline");
				String subclassification=rs.getString("subclassification");
				String subpayment=rs.getString("subpayment");
				
				System.out.println(subname+"----"+subpwd+"----"+onoffline+"----"+subclassification+"----"+subpayment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally
		{
			releaseDB(rs,pst,conn);
		}
	}
	
	//***************************************************鏍规嵁id杩斿洖鏌愪竴涓敤鎴�********************************
		public User Queryoneuser(int id)
		{
			conn=getConnection();
			user=new User();
			String sql="select * from subject where id=?";
			try {
				pst=conn.prepareStatement(sql);
				pst.setInt(1, id);
				rs=pst.executeQuery();
				while(rs.next())
				{
					user.setId(rs.getInt("id"));
					user.setSubname(rs.getString("subname"));
					user.setSubpwd(rs.getString("subpwd"));
					user.setOnoffline(rs.getString("onoffline"));
					user.setSubclassification(rs.getString("subclassification"));
					user.setSubpayment(rs.getString("subpayment"));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			finally
			{
				releaseDB(rs,pst,conn);
			}
			
			return user;
		}
		
	//***************************************************鏌ヨ鎵�鏈夌敤鎴稟rrayList瀛樺偍********************************
		public ArrayList<User>  QueryallusersAL()
		{
			conn=getConnection();
			list=new ArrayList<User>();
			String sql="select * from subject";
			try {
				pst=conn.prepareStatement(sql);
				rs=pst.executeQuery();
				while(rs.next())
				{
					User user=new User();
					
					int id=rs.getInt("id");
					String subname=rs.getString("subname");
					String subpwd=rs.getString("subpwd");
					String onoffline=rs.getString("onoffline");
					String subclassification=rs.getString("subclassification");
					String subpayment=rs.getString("subpayment");
					user.setId(id);
					user.setSubname(subname);
				    user.setSubpwd(subpwd);
				    user.setOnoffline(onoffline);
				    user.setSubclassification(subclassification);
				    user.setSubpayment(subpayment);
					list.add(user);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				releaseDB(rs,pst,conn);
			}
			return list;
			
		}
		//***************************************************鏌ヨ鐢ㄦ埛by ID  ArrayList瀛樺偍********************************
				public ArrayList<User>  QueryallusersByID(int id)
				{
					conn=getConnection();
					list=new ArrayList<User>();
					String sql="select * from subject where id=?";
					try {
						pst=conn.prepareStatement(sql);
						pst.setInt(1, id);
						rs=pst.executeQuery();
						while(rs.next())
						{
							User user=new User();
							int userid=rs.getInt("id");
							String subname=rs.getString("subname");
							String subpwd=rs.getString("subpwd");
							String onoffline=rs.getString("onoffline");
							String subclassification=rs.getString("subclassification");
							String subpayment=rs.getString("subpayment");
							user.setId(userid);
							user.setSubname(subname);
						    user.setSubpwd(subpwd);
						    user.setOnoffline(onoffline);
						    user.setSubclassification(subclassification);
						    user.setSubpayment(subpayment);
							list.add(user);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally
					{
						releaseDB(rs,pst,conn);
					}
					return list;
					
				}
				
				//***************************************************鏌ヨ鐢ㄦ埛by Name  ArrayList瀛樺偍********************************
				public ArrayList<User>  QueryallusersByName(String subname)
				{
					conn=getConnection();
					list=new ArrayList<User>();
					String sql="select * from subject where subname=?";
					try {
						pst=conn.prepareStatement(sql);
						pst.setString(1, subname);
						rs=pst.executeQuery();
						while(rs.next())
						{
							User user=new User();
							int userid=rs.getInt("id");
							String subname1=rs.getString("subname");
							String subpwd=rs.getString("subpwd");
							String onoffline=rs.getString("onoffline");
							String subclassification=rs.getString("subclassification");
							String subpayment=rs.getString("subpayment");
							user.setId(userid);
							user.setSubname(subname1);
						    user.setSubpwd(subpwd);
						    user.setOnoffline(onoffline);
						    user.setSubclassification(subclassification);
						    user.setSubpayment(subpayment);
							list.add(user);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally
					{
						releaseDB(rs,pst,conn);
					}
					return list;
					
				}
	public static void main(String[] args) {
		
		
		DBoper db=new DBoper();
		Connection con=db.getConnection();
		if(con!=null)
		{
			UserInterface dd = new UserInterface();
			dd.setVisible(true);
			System.out.println("鏁版嵁搴撻摼鎺ユ垚鍔燂紒");
		}
		
		
	}
}

