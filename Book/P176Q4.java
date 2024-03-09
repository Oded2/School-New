public class P176Q4 {

    public static final Hooks hooks = new Hooks();

    public static void main(String[] args) {
        Time[] times = {new Time(1, 2, 3), new Time(3, 2, 1), new Time(2, 1, 3)};
        Queue<Time> q = hooks.buildQueue(times);
        System.out.println(firstLastDiff(q));
    }

    public static Time firstLastDiff(Queue<Time> q) {
        Time first = q.head();
        Time last = hooks.getLast(q);
        int difSeconds = Math.abs(convertSeconds(first)-convertSeconds(last));
        return secondsToTime(difSeconds);
    }

    public static int convertSeconds(Time time) {
        return time.getHour() * 3600 + time.getMinute() * 60 + time.getSecond();
    }
    public static Time secondsToTime(int seconds){
        int hours = seconds/3600;
        seconds %= 3600;
        int minutes = seconds/60;
        seconds %= 60;
        return new Time(hours, minutes, seconds);
    }
}
