package com.zxr.mygraduation.entity;
/**
 * Admin class
 * @author xueran.zhang
 * @date 2020/04/15
 */
public class Admin {
    private String root;
    private  String password;

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Admin{" +
                "root='" + root + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
