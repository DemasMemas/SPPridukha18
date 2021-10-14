package pridukha;


public class RabbitAndTurtle {

    public static void main(String[] args) throws InterruptedException {
	    AnimalThread rabbit = new AnimalThread("Rabbit");
        AnimalThread turtle = new AnimalThread("Turtle");
        for (int i=0;i < 100;i++){
            Thread.sleep(50);
            if (rabbit.metres > turtle.metres){
                System.out.println("Кролик лидирует и устал бежать");
            }
            else{
                if (rabbit.metres < turtle.metres){
                    System.out.println("Черепаха лидирует и устала бежать");
                }
            }
        }
    }
}
