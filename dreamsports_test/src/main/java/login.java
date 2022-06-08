public class login {
    private String user;
    private String pwd;
    public login() {
    }
    public login(String user,String pwd) {
    }
    public void setUser(){
        this.user=user;
    }
    public void setPwd(){
        this.pwd=pwd;

    }

    public String getUser(String user){
        this.user=user;

        return user;
    }
    public String getPwd(String getPwd){
        this.pwd=pwd;

        return getPwd;
    }

    public static void main(String[] args) {

    }

}
