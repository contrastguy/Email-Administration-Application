package Email;

import java.util.Scanner;

public class Email {
    //    Criação das variáveis
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 10;
    private String email;
    private String companySuffix = "xyzcompany.com";
    private int mailBoxCapacity = 500;
    private String department;
    private String alternateEmail;


//    Criação dos métodos
//    Construtor para o firstName e lastName
    public Email(String firstName, String lastName){
//        this referencia a classe global, a variável local é referenciada com o parâmetro do construtor
        this.firstName =  firstName;
        this.lastName = lastName;
        System.out.println("Email criado : " + this.firstName + " " + this.lastName);

//        Cria um método que pergunta o departamento - retorna o departamento
        this.department = askDepartment();

        //Criar método que gera senha aleatória
        this.password = randomPassword(defaultPasswordLength);


        this.email = generateEmail();

    }

//    Perguntar para o departamento
    private String askDepartment(){
        System.out.println("Digite o número do departamento\n1 para Finanças\n2 para Desenvolvimento\n3 para Contabilidade\n0 para nenhum");
        System.out.println("Número do departamento aqui: ");
//        Declara a var que scaneia o input do usuário
        Scanner sc = new Scanner(System.in);
//        Coloca o método pra ler um inteiro
        int depChoice = sc.nextInt();
        if(depChoice == 1){
            return "Finanças";
        } else if (depChoice == 2) {
            return "Desenvolvimento";
        } else if (depChoice == 3) {
            return "Contabilidade";
        } else if (depChoice == 0) {
            return "nenhum";
        }else{
            return "Selecione um dos números requisitados.";
        }
    }

    //Método para gerar uma senha aleatória
    private String randomPassword(int length){
        //Seta todos os caracteres possíveis para a senha
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVXWYZ0123456789@!$%#";
        //Cria uma array com o comprimento igual ao parâmetro do método
        char[] password = new char[length];
        //Loop para gerar as letras na array
        for(int i = 0; i < length; i++){
            // Cria uma var que pega um numero (0 ou 1) multiplica pelo comprimento da array
            int rand = (int) (Math.random() * passwordSet.length());
            password[i]  = passwordSet.charAt(rand);
        }
        return new String(password);
    }

//    Setar um email aleatório
    private String generateEmail(){
       email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
       return email;
    }

//    Setar a capacidade do mailbox
    public void  mailBoxCapacity(int capacity){
        this.mailBoxCapacity =  capacity;
    }

//    Mudar um email

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }


    //Muda Senha
    public void changePassword(String password){
        this.password = password;
    }


    //Acessar dados usando métodos, conceito de encapsulação
    public int getMailBoxCapacity(){return mailBoxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}

    //Juntar todas as informações e colocar em um método só
    public String showInfo(){
        return "Display Name: " + firstName + " " + lastName + '\n' +
                "Email: " + email + '\n' +
                "Alternative Email: " + alternateEmail  + '\n' +
                "Password: " + password + '\n' +
                "Department: " + department + '\n' +
                "Mail Box Capacity : " + mailBoxCapacity;
    }

}
