package io.opeleh.bulkpay.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private long roleID;

    @Column(nullable = false, length = 25)
    private String role;

	public long getRoleID() {
		return roleID;
	}

	public void setRoleID(long roleID) {
		this.roleID = roleID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Roles() {

	} 

}
