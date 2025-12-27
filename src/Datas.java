import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Datas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite sua data de nascimento (dd/MM/yyyy): ");
        String nasc = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nascimento = LocalDate.parse(nasc, formatter);

        LocalDate dataAtual = LocalDate.now();

        // Aniversário no ano atual
        LocalDate niverAtual = nascimento.withYear(dataAtual.getYear());

        //Próximo aniversário
        LocalDate proxNiver;
        if(niverAtual.isAfter(dataAtual)){
            proxNiver = niverAtual;
        } else {
            proxNiver = niverAtual.plusYears(1);
        }

        System.out.println("=====================");
        System.out.println("--- DADOS DO USUARIO ---");
        System.out.println("Idade: "+ ChronoUnit.YEARS.between(nascimento, dataAtual) + " anos");
        System.out.println("Dia da semana do nascimento: "+ nascimento.getDayOfWeek());
        System.out.println("Dias para o próximo aniversário: "+ ChronoUnit.DAYS.between(dataAtual, proxNiver));
    }
}
