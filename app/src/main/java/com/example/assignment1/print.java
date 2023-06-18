package com.example.assignment1;

public class print {
    private   String name="null";
    private  String result="null";
    public print() {

    }
    public print(String name, String result) {
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "print{" +
                "name='" + name + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
