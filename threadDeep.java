/**
 * threadmain
 */
class Booking extends Thread
{   
    int available=2;
    int require;
    Booking(int n)
    {
        require=n;
    }

    public void run()
    {
     System.out.println("Welcome to ticket booking system "+Thread.currentThread().getName());   
    System.out.println("No of ticket left :"+available);
        if(available>=require)
        {
            System.out.println("Ticket is booked");

            available=available-require;
        }
        else if(available<=require){
            System.out.println("Ticket not available");
        }
    }

} 
class threadDeep {
public static void main(String[] args) {
    Booking user1=new Booking(2);
    Booking user2=new Booking(2);
    Thread t1 = new Thread(user1);
    Thread t2 = new Thread(user2);
    
    t1.start();
    t2.start();
}
}