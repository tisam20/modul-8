import java.util.Scanner;

public class Adventure {
    private static long seed = System.currentTimeMillis();
    private static int rand(int bound){
        seed = (seed * 1103515245 + 12345) & 0x7fffffff;
        return (int)(seed % bound);
    }

    private static int pos    = 0;  
    private static int hp     = 50;
    private static int coins  = 0;
    private static int potion = 1;

    private static void game(Scanner sc){
        while(true){
            System.out.printf("%n[Pos %d]  HP:%d  Coins:%d  Potion:%d%n",
                               pos,hp,coins,potion);
            System.out.println("1. Maju"); 
            System.out.println("2. Mundur");
            System.out.println("3. Gunakan potion");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");
            String c = sc.nextLine();

            switch(c){
                case "1" -> { pos++; doEvent(); }
                case "2" -> { pos--; doEvent(); }
                case "3" -> usePotion();
                case "4" -> { System.out.println("Keluar game."); return; }
                default  -> System.out.println("Input salah!");
            }

            if(hp <= 0){
                System.out.println("HP habis! Game Over.");
                return;
            }
        }
    }

    private static void doEvent(){
        int e = rand(3);   
        if(e == 0){                              
            int k = 1 + rand(5);                 
            coins += k;
            System.out.println(">> Menemukan koin "+k+"!");
        }else if(e == 1){                        
            int dmg = 3 + rand(5);           
            hp -= dmg;
            System.out.println(">> Kena jebakan! -"+dmg+" HP");
        }else{                                
            potion++;
            System.out.println(">> Menemukan 1 potion.");
        }
    }

    private static void usePotion(){
        if(potion <= 0){ System.out.println("Potion habis!"); return; }
        potion--;
        hp += 10;
        System.out.println(">> HP bertambah 10.");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("""
                === Mini Adventure ===
                1. Login
                2. Sign up
                3. Exit""");
            System.out.print("Choice: ");
            String ch = sc.nextLine();
            try{
                switch(ch){
                    case "1" -> {
                        System.out.print("Username: "); String u=sc.nextLine();
                        System.out.print("Password: "); String p=sc.nextLine();
                        User.login(u,p);
                        resetPlayer();        
                        game(sc);
                    }
                    case "2" -> {
                        System.out.print("New username: "); String u=sc.nextLine();
                        System.out.print("New password: "); String p=sc.nextLine();
                        User.add(u,p);
                        System.out.println("Registrasi sukses!");
                    }
                    case "3" -> { System.out.println("Bye!"); return; }
                    default -> System.out.println("Pilihan salah!");
                }
            }catch(Exception e){ System.out.println(e.getMessage()); }
        }
    }
    private static void resetPlayer(){
        pos=0; hp=50; coins=0; potion=1;
    }
}
