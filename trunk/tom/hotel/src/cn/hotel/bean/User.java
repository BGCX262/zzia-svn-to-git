package cn.hotel.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户信息
 * @author tom
 *
 */

@Entity
@Table(name="USER")
public class User {
	@Id
	@GeneratedValue
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	/*用户名*/
	private String username;
	/*登陆密码*/
	private String password;
	/*用户权限*/
	private String userdes;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserdes() {
		return userdes;
	}

	public void setUserdes(String userdes) {
		this.userdes = userdes;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
