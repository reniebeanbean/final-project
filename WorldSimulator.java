import java.util.Timer;
import java.util.TimerTask;
public class WorldSimulator
{
    public static void main(String[] args)
    {
        World newWorld = new World();
        Timer time = new Timer();
        TimerTask task = new TimerTask(){
                int n = 0;
                public void run()
                {
                    newWorld.event();
                }
            };
            time.schedule(task, 0, 1000);
        
    }
}
