package com.cambeeler;

//http://www.java2s.com/Tutorials/Java/OCA_Java_SE_8_Core_Java_APIs/0080__Java_Date_Time.htm
//https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html   -- format strings and such!

import com.cambeeler.exploring.DataObject;

import static com.cambeeler.ColorConstants.*;

public
class Main
{


    public
    Main()
    {
        System.out.println(LOG + "Yeah, the Main constructor is here!!" + RESET);
        System.out.println("this is a static declared at the end..." + class_static);
    }

    public static
    void main(String[] args)
    {

        int        x = 1;
        Main       m = new Main();
        DataObject d = new DataObject();
//        d.playWithPrimitivesPlus();
//        d.playWithFormatter();
//        d.playWithPeriod();
//        d.playWithDuration();
//        d.playWithTime();
//        d.playWithDate();
//        d.playWithDateTime();
//        d.strings();
//        d.integers();
//        d.arrayListsTest();
//        d.infernalLoop();
//        d.trySwitch();
//        d.playWithInstanceOf();
//        d.playWithDefaults();
//        d.playWithLambdas();
//        d.playWithClasses();
        d.playingWithPassByRef();
    }

    public String class_static = "PublicStaticVariable declared at thebottom";

}


