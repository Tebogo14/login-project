# login-project
public class Testing {

    public static void main(String[] args) {
     
     //Registration//
    Scanner sc = new Scanner(System.in);
    
    System.out.println("*****registration******");        
        String userName;
               
                System.out.println("Username must contain an underscore (_) and is no more than five character long.");
                System.out.print("Create a username : ");
                userName = sc.nextLine();
        
        String password;
                
                System.out.println("Password must at leaste be eight characters long, with a mixter of capital letter(s), number(s), and symbol(s).");
                System.out.print("Create a password : ");
                password = sc.nextLine();
                
                //Boolean//
                
               boolean hasSpec = false;
               boolean hasCap = false;
               boolean hasNum = false;
                
               for(int i = 0; i < password.length(); i++){
		    char ch = password.charAt(i);
                     
                    //if statements//
                    if(!Character.isLetterOrDigit(ch)){
                        hasSpec = true;
                    }
                        
                    if(Character.isUpperCase(ch)){
                        hasCap = true;
                    }
                    
                    if(Character.isDigit(ch));{
                        hasNum = true;
               }
                    //if statements 
		if(userName.contains("_") && userName.length() <= 5){
                    System.out.println("Username successfully captured ");
		}
            else{
                System.out.println("Username is not correctly formatted;please ensure that your username contains an underscore and it is not more than 5 characters in length.");
            }
                if(hasCap && hasNum && hasSpec && password.length() >= 8){
                    System.out.println("Password successfully captured ");  
              }
            else{
                  System.out.println("password is not correctly formatted; please ensure that your password conntains at least eight charaters, a number, and a special charater.");
              }
                

          
        
               }
    }
}
                
                        
           
                        
               
                       
       
    
            
         
    
               
   

    
   
