package ru.spbu.arts.java.oop.time;

public class ExperimentsWithTime {
    public static void main(String[] args) {
        Time new_time = new Time(21, 35);
        System.out.println(new_time.hours);

        var t_new = new Time(9,10);
        System.out.println(t_new.show());

        var t_morning = new Time(7,15);
        var t_day = new Time(13,40);
        var t_evening = new Time(22,50);
        var t_night = new Time(3,55);

        System.out.println(t_morning.isEvening());
        System.out.println(t_night.isNight());
        System.out.println(t_day.isDay());
        System.out.println(t_evening.isMorning());

        System.out.println(t_morning.sayHello());
        System.out.println(t_night.sayHello());
        System.out.println(t_day.sayHello());
        System.out.println(t_evening.sayHello());

        System.out.println(t_night.add(80));
        System.out.println(t_evening.add(80));
        System.out.println(t_morning.add(50));
        System.out.println(t_day.add(10));
    }

}
