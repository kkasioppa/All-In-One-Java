package com.allinonejava;

public class Scratch {

    public static void main(String[] args) {

        System.out.println("[StartUp]=========================");
        Scratch s = new Scratch();
        s.StartUp();
        System.out.println("[Ended  ]=========================");
    }

    public void StartUp()
    {
        Parent p = new Parent();
        p.PrintMessage("shit the world!!");
    }

    class Parent {
        public void PrintMessage(String strMessage) {
            System.out.println(strMessage);
        }
    }
}
