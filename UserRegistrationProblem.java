import java.util.Scanner;
import java.util.regex.Pattern;
public class UserRegistrationProblem {
    @FunctionalInterface
    public interface Validator{
        public boolean check(String type,String value);
    }

    Pattern namePattern = Pattern.compile("[A-Z][a-z]{2,}");
    Pattern emailPattern = Pattern.compile("^(?!.*\\.\\.)[^.][a-zA-Z0-9+_.-]+[^.]@[a-zA-Z0-9&&[^.]][a-zA-Z0-9.]*[\\.]{1}[a-zA-z]{2,}$");
    Pattern mobilePattern = Pattern.compile("[0-9]{2} [0-9]{10}");
    Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])(?=[^@#$%^&-+=()]*[@#$%^&-+=()][^@#$%^&-+=()]*$).{8,}$");

    public final String NAME_TYPE = "NAME";
    public final String EMAIL_TYPE = "EMAIL";
    public final String MOBILE_TYPE = "MOBILE";
    public final String PASSWORD_TYPE = "PASSWORD";

    Validator validator = (String type,String value) -> {
        switch (type) {
            case NAME_TYPE:
                return namePattern.matcher(value).matches();
            case EMAIL_TYPE:
                return emailPattern.matcher(value).matches();
            case MOBILE_TYPE:
                return mobilePattern.matcher(value).matches();
            case PASSWORD_TYPE:
                return passwordPattern.matcher(value).matches();
            default:
                return false;
        }
    };

    public boolean validate(String type,String value){
       boolean isValid = validator.check(type,value);
       if(isValid){
           return true;
       }
       else{
           return false;
       }
    }



    public static void main(String[] args) {
        UserRegistrationProblem user = new UserRegistrationProblem();
        System.out.println("Validation check for FirstName");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        if(user.validate(user.NAME_TYPE,name)){
            System.out.println("Correct");
        }
        else{
            System.out.println("Incorrect, Name should be start from Capital Letter");
        }
        System.out.println("Validation check for LastName");
        String lastName = scan.nextLine();
        if(user.validate(user.NAME_TYPE,lastName)){
            System.out.println("Correct");
        }
        else{
            System.out.println("Incorrect, LastName should be start from Capital Letter");
        }
        System.out.println("Validation check for Email");
        String email = scan.nextLine();
        if(user.validate(user.EMAIL_TYPE,email)){
            System.out.println("Correct");
        }
        else{
            System.out.println("Incorrect");
        }
        System.out.println("Validation check for password");
        String password = scan.nextLine();
        if(user.validate(user.NAME_TYPE,password)){
            System.out.println("Correct");
        }
        else{
            System.out.println("Incorrect");
        }
        System.out.println("Validation check for mobile");
        String mobile = scan.nextLine();
        if(user.validate(user.NAME_TYPE,mobile)){
            System.out.println("Correct");
        }
        else{
            System.out.println("Incorrect");
        }

    }
}
