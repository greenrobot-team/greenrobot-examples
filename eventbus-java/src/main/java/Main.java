import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        EventBus.getDefault().register(main);
        EventBus.getDefault().post("hello?");
        EventBus.getDefault().unregister(main);
    }

    @Subscribe
    public void onEvent(String event) {
        System.out.println("Event: " + event);
    }

}
