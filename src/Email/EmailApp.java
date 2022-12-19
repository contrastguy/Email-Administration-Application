package Email;

public class EmailApp {
    public static void main(String[] args){
        Email em1 = new Email("John","Doe");
        em1.setAlternateEmail("jd@gmail.com");
        System.out.println(em1.showInfo());

    }
}
