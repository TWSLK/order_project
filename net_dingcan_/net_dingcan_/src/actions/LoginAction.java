package actions;

import service.AdminService;

import entity.Admin;

public class LoginAction extends BaseAction {
	private AdminService adminservice;
	private Admin admin;
	private boolean flag;
	private String message;

	public String login() {

		flag = adminservice.login(admin.getUsername(), admin.getPassword());
		if(flag){
			return SUCCESS;
		}else{
			message="用户名或密码错误";
			return "login";
		}
		
	}

	public AdminService getAdminservice() {
		return adminservice;
	}

	public void setAdminservice(AdminService adminservice) {
		this.adminservice = adminservice;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
