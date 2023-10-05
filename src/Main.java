import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int dmg, livello, puntiVita;
        String arma;
        boolean error=false, isDead=false;
        Scanner input = new Scanner(System.in);
        Troll trl1 = null;

        do{
            try{
                System.out.print("Inserire il livello del troll: ");
                livello = input.nextInt();
                System.out.print("Inserire l'arma del troll: ");
                input.nextLine();
                arma = input.nextLine();
                System.out.print("Inserire i punti vita del troll: ");
                puntiVita = input.nextInt();
                trl1 = new Troll(puntiVita, arma, livello);
                error = false;
            }catch (InputMismatchException e){
                System.out.println("I dati inseriti non sono validi");
                livello = 0;
                puntiVita = 0;
                input = new Scanner(System.in);
                error = true;
            }catch (Exception e){
                System.out.println(e.getMessage());
                error = true;
            }
        }while(error);

        System.out.println("\nUn troll selvaggio è apparso!!!");
        System.out.println(trl1.toString());

        do {
            do {
                try {
                    System.out.println("\nInserire il danno che si vuole recare: ");
                    dmg = input.nextInt();
                    trl1.receiveDamage(dmg);
                    if(trl1.getHealthPoints()<=0){
                        isDead = true;
                        System.out.println("Al troll rimangono 0 punti vita");
                    }else {
                        System.out.println("Al troll rimangono " + trl1.getHealthPoints() + " punti vita");
                    }
                    error = false;
                }catch(InputMismatchException e){
                    System.out.println("Il danno inserito non è valido");
                    dmg = 0;
                    input = new Scanner(System.in);
                    error = true;
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    error = true;
                }
            }while(error);
        }while(!isDead);

        System.out.println("Il troll è morto!");
    }
}