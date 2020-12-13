/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;


import com.opensymphony.xwork2.ActionSupport;
import dao.DAO;

/**
 *
 * @author thai
 */

public class Login extends ActionSupport{
    private String username;
    private String password;
    @Override
    public String execute() throws Exception {
        String result = DAO.CheckLogin(username, password);
        if(result.equals(username)){
            return "success";
        }else{
            return "fail";
        }
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    

}
