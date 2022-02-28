package ru.spbu.arts.java.oop.time;

public class Time {
    int hours;
    int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public String show(){
        String h = "";
        String m = "";
        if (hours / 10 == 0)
            h = "0";
        if (minutes / 10 == 0)
            m = "0";
        return String.format("%s%d:%s%d", h, hours, m, minutes );
    }

    public boolean isDay(){
        return hours >= 12 && hours <= 15;
    }

    public boolean isMorning(){
        return hours >= 4 && hours <= 11;
    }

    public boolean isEvening(){
        return hours >= 16 && hours <= 23;
    }

    public boolean isNight(){
        return hours >= 0 && hours <= 3;
    }

    public String sayHello(){
        if (isDay())
            return "Добрый день!";
        else if (isMorning())
            return "Доброе утро!";
        else if (isEvening())
            return "Добрый вечер!";
        else return "Доброй ночи!";
    }

    public String add(int a){
        int tmp1 = minutes + a;
        int tmp2 = tmp1 / 60;
        if (minutes + a < 60)
            minutes += a;
        else minutes = tmp1 - (60 * tmp2);
        if (hours + tmp2 <= 23)
            hours += tmp2;
        else hours += tmp2 - 24;
        return show();
    }
}
