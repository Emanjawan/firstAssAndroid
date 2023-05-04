package com.example.assignment1;

public class physics {
    private  double distance;
    private  double speed;
    private  double time;


    public double distance(double speed,double time){
        return speed*time;



    }

    public double speed(double distance,double time){
        return distance/time;



    }
    public double time(double distance,double speed){
        return distance/speed;



    }

    public String distanceDetails(double speed,double time){
        return "*) Distance = speed x time.\n\n                   = "+speed+" x "+time+"\n\n                   = "+(speed*time)+"\n\n *) measured in units (meter).";



    }
    public String speedDetails(double distance,double time){
        return "*) Speed = distance / time.\n\n                   = "+distance+" / "+time+"\n\n                   = "+(distance/time)+"\n\n *) measured in units (meter/second).";



    }

    public String timeDetails(double distance,double speed){
        return "*) Time = distance / speed.\n\n                   = "+distance+" / "+speed+"\n\n                   = "+(distance/speed)+"\n\n *) measured in units (second).";



    }

}
