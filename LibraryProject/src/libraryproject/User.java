
package libraryproject;

public class User {
    private static String password;
    private static String role;
    
    public User(String password, String role){
        this.password = password;
        this.role = role;
    }
    
    public static String getPassword(){
        return password;
    }
    
    public static String getRole(){
        return role;
    }
}
