package com.cambeeler.exploring;

import com.cambeeler.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

import static com.cambeeler.ColorConstants.*;
import static java.time.LocalTime.now;

public
class DataObject
{
    private String   refValNull;
    private int      refIntValNull;
    private int[]    refValArrayNull;
    private String[] refStrValNull;
    public int val;
    public String sval;

    public static void playWithCharacters()
    {
        System.out.println(ColorConstants.BLUE + "playWithCharacters" + ColorConstants.RESET);
        int var = '7';
        System.out.println("int of char value 7 - "
                           + var
                           + " the int '7' as an ASCII character has a numeric value of 55");

        System.out.println("char of int value 7 - "
                           + (char) var
                           + " Can be represented as a character '7'");

        char cvar = 7;
        System.out.println("char 7 - "
                           + cvar
                           + " the ASCII value of 7 is an unprintable ASCII character");
        System.out.println("int value of char 7 - "
                           + (int) cvar
                           + " Casting the ASCII 7 as an int");

        char cvar1 = '7';
        System.out.println("char '7' - "
                           + cvar1
                           + " ASCII character representation");
        System.out.println("int value of char '7' - "
                           + (int) cvar1
                           + " ASCII character value of '7' is encoded from numeric value of 55");
        System.out.println("-------------------------------\n");

    }

    public static void playWithTryCatch()
            throws Exception, ArithmeticException
    {
        System.out.println(ColorConstants.BLUE + "playWithTryCatch" + ColorConstants.RESET);
        int a=0, b=0;
        try
        {
            int x = a/b;
        }
        catch(ArithmeticException e)
        {
            System.out.println(ColorConstants.RED_BOLD + "ArithmeticException thrown" + ColorConstants.RESET);
            throw new ArithmeticException("division by zero");
        }
        catch(Exception e)
        {
            System.out.println(ColorConstants.RED_BOLD + "Exception thrown" + ColorConstants.RESET);
            throw new Exception("I don't know why, but this catches all!");
        }
        System.out.println("-------------------------------\n");

    }

    public static void playWithBinarySearch()
    {
        System.out.println(ColorConstants.BLUE + "playWithBinarySearch" + ColorConstants.RESET);
        List<String> hex = Arrays.asList("10", "8", "4B", "FF");
        Collections.sort(hex);
        int x = Collections.binarySearch(hex, "8");
        int y = Collections.binarySearch(hex, "4B");
        int z = Collections.binarySearch(hex, "4F");
        System.out.println(x + " " + y + " " + z);
        System.out.println("-------------------------------\n");

    }

    public static void playWithArrays()
    {
        System.out.println(ColorConstants.BLUE + "playWithArrays" + ColorConstants.RESET);
        List<Integer> myArrayList = new ArrayList<>();
        myArrayList.add(Integer.parseInt("5"));
        myArrayList.add(Integer.valueOf("6"));
        myArrayList.add(Integer.valueOf(14444));
        myArrayList.add(7);
//        myArrayList.add(null); // - this breaks the unboxing in the for loop as int cannot have a null value.``
        for (int age : myArrayList)
            System.out.println(age);
        System.out.println("-------------------------------\n");

    }

    public static double playwithVarArgs(String s, double ... nbr)
    {
        System.out.println(s);
        int summ =0;

        for (double n : nbr)
        {
            summ+=n;
            System.out.println(n);
        }
       return summ;

    }

    @Override
    public String toString()
    {
        return "Count " + val + " : " + "Order " + sval;
    }

    public void passDOByRef()
    {
        val = 100;
        sval = "Last";
    }

    public
    void arrayListsTest()
    {
        System.out.println(LOG + "arrayListsTest()" + RESET);
        List<String> dryFruits = new ArrayList<>();
        dryFruits.add("Walnut");
        dryFruits.add("Apricot");
        dryFruits.add("Almond");
        dryFruits.add("Date");
        List<String> deadFruit = new ArrayList<>();

        for (String dryFruit : dryFruits)
        {
            if (dryFruit.startsWith("A"))
            {
                deadFruit.add(dryFruit);
            }
        }
        for (String remove : deadFruit)
        {
            dryFruits.remove(remove);
        }

        System.out.println(dryFruits);
        int[] anynbr = new int[10];
        if (anynbr.length > 1)
        {
            System.out.println("true");
        }
    }

    public
    void infernalLoop()
    {
        System.out.println(LOG + "infernalLoop()" + RESET);
        int           i  = 0;
        StringBuilder sb = new StringBuilder();
        for (; ; )
        {
//            System.out.println(++i + ": Hello");
            sb.append("Hello");
        }
    }

    public
    void passingByReference(ArrayList<String> sla)
    {
        System.out.println("In the call #1");
        for (String s : sla)
        {
            System.out.println(s);
        }
        System.out.println("After the change #2");
//        sla = new ArrayList<String>();
        sla.add("New1");
        sla.add("New2");
        sla.add("New3");
        sla.add("New4");
        sla.add("New5");
        for (String s : sla)
        {
            System.out.println(s);
        }

    }

    public void passStrByRef(String str)
    {
        System.out.println("passStrByRef =>" + str);
        System.out.println("passStrByRef =>" + str.hashCode());
        str.concat(" even even even more stuff");
        str += " even more stuff";

        System.out.println("passStrByRef =>" + str);
        System.out.println("passStrByRef =>" + str.hashCode());
        // When you change the literal the String is pointing
        // to, you must also change the address that the object points to...
    }


    public
    void playWithClasses()
    {
//  Because there is an inheritance chain, the compiler doesn't capture the error
//  but at run-time this creates an exception.
//  A sub type cannot refer to a reference of a super type.
//       M m = new M();
//       N n =(N) m;
    }


    public
    void playWithPeriod()
    {// Not for use with LocalTime, only LocalDate & LocalDateTime
        System.out.println(LOG + "playWithPeriod" + RESET);
        Period        per = Period.of(7, 1, 13);
        LocalDateTime ldt = LocalDateTime.of(2010, 1, 10, 12, 0, 0);
        System.out.println(ldt);
        LocalDateTime ldtp = ldt.plus(per);
        System.out.println(ldtp);
        System.out.println(per + "<<==");
        System.out.println(Period.of(0, 0, 0));
        Period period = Period.parse("p-30000y");
        System.out.println((period));
    }

    public
    void playWithDuration()
    { // Cannot be used with LocalDate, but can be used with LocalDateTime & LocalTime.
        System.out.println(LOG + "playWithDuration" + RESET);
        Duration dur = Duration.ofMinutes(30);
        System.out.println(dur);
        dur = Duration.ofHours(12);
        System.out.println(dur);
        dur = Duration.ofDays(7);
        System.out.println(dur);
        System.out.println(LocalTime.now().plus(dur));
        System.out.println(LocalDateTime.now().plus(dur));
    }


    public
    void playWithTime()
    {

        System.out.println(LOG + "playWithTime" + RESET);
        System.out.println(now());
        LocalTime t1 = LocalTime.of(6, 15);               // hour and minute
        LocalTime t2 = LocalTime.of(6, 15, 30);          // + seconds
        LocalTime t3 = LocalTime.of(6, 15, 30, 200);     // + nanoseconds
        System.out.format("%s%s is t1\n%s%s is t2 and\n%s%s is t3\n%s",
                          PURPLE, t1, GREEN_BOLD, t2, RED_BOLD, t3, RESET);
        // hours 0-23
        // minutes 0-59
        // seconds 0-59
        // if we exceed those numbers, the resulting Runtime exception is thrown.
        LocalTime t4 = LocalTime.of(23, 59, 59);
        System.out.println("does this work? ==> " + t4);
    }

    public
    void playWithDate()
    {
        System.out.println(LOG + "playWithDate" + RESET);
        System.out.println(LocalDate.now());
        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
        LocalDate date2 = LocalDate.of(2015, 2, 20);
        System.out.println(date1);
        System.out.println(date2);
        if (date1.compareTo(date2) == 0)
        {
            System.out.println("Same Date");
        }
        else if (date1.compareTo(date2) == -1)
        {
            System.out.format("%s is before %s\n", date1, date2);
        }
        else
        {
            System.out.format("%s is after %s\n", date1, date2);
        }
        System.out.println("The day of Week is "
                           + date1.getDayOfWeek()
                           + " and the month "
                           + date1.getMonth()
                           + " and the month number "
                           + date1.getMonthValue()
                           + " and the number of days in the month "
                           + date1.lengthOfMonth());
        System.out.println(date2.plusMonths(3).minusDays(25)
                           + " is three months added, "
                           + RED
                           + "subtract 25 days ".toUpperCase()
                           + RESET
                           + "after "
                           + date2);
        System.out.println(LOG + "playing around with LocalDate.parse()" + RESET);

        LocalDate ldp1 = LocalDate.parse("2019-05-09");
        LocalDate ldp2 = LocalDate.parse("2019-05-09");
        System.out.println(ldp1.minusDays(1).equals(ldp2.minusDays(1)) + "||" + ldp1.isEqual(ldp2));
        System.out.println(ldp1.getDayOfMonth() + "." + ldp1.getMonthValue() + "." + ldp1.getYear());
        ldp1 = ldp1.plusYears(5);
        System.out.println("Local date => " + ldp1);
        System.out.println("Local date with day of year 25 => " + ldp1.withDayOfYear(25));
        System.out.println("Local date with day of month 25 => " + ldp1.withDayOfMonth(25));
        System.out.println("Local date with month of year 9 => " + ldp1.withMonth(9));
        System.out.println("Local date minus 4 years => " + ldp1.minusYears(4));
    }

    public
    void playWithDateTime()
    {
        System.out.println(LOG + "playWithDateTime" + RESET);
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(LocalDateTime.now());
        LocalDateTime ldt1 = LocalDateTime.of(2019, Month.MAY, 06, 22, 30);
        LocalDateTime ldt2 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println(BLUE + ldt1 + RESET);
        System.out.println(BLUE + ldt2 + RESET);
        System.out.println(ldt1.getDayOfMonth()
                           + "-" + ldt1.getMonthValue()
                           + "-" + ldt1.getYear());
        String time = ldt.getHour() + ":" + ldt.getMinute() + "." + ldt.getSecond();
        System.out.println(time);
    }

    public
    void playWithFormatter()
    {
//        BASIC_ISO_DATE,
//        ISO_DATE,
//        ISO_LOCAL_DATE,
//        ISO_TIME,
//        ISO_LOCAL_TIME,
//        ISO_DATE_TIME,
//        ISO_LOCAL_DATE_TIME.

        System.out.println(LOG + "playWithDateTimeFormatter" + RESET);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter df1  = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter df2  = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        DateTimeFormatter tf1  = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        DateTimeFormatter tf2  = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        LocalDate         date = LocalDate.now();
        LocalTime         time = LocalTime.now();
        LocalDateTime     ldt  = LocalDateTime.of(2019, 05, 8, 22, 45, 15);
//        System.out.println(dtf1.format(time));  // -- Date + Time formatter, cannot format LocalTime
        System.out.println(ldt);
        System.out.println("SHORT Format ==> " + tf1.format(time));
        System.out.println("SHORT Format ==> " + df1.format(date));
        System.out.println("SHORT Format ==> " + dtf1.format(ldt));
        System.out.println("SHORT Format ==> " + tf1.format(ldt));
        System.out.println("MEDIUM Format ==> " + tf2.format(time));
        System.out.println("MEDIUM Format ==> " + df2.format(date));
        System.out.println("MEDIUM Format ==> " + dtf2.format(ldt));
        System.out.println("ISO_LOCAL_DATE ==> " + date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("ISO_DATE ==> " + date.format(DateTimeFormatter.ISO_DATE));
        System.out.println("ISO_LOCAL_TIME ==> " + time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println("ISO_LOCAL_DATE ==> " + ldt.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("ISO_LOCAL_TIME ==> " + ldt.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println("ISO_LOCAL_DATE_TIME ==> " + ldt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

//  Month:  M - date(significant digits only), MM - (0 padded digits), MMM - Abbreviated Months, MMMM - fully resolved
//  Year:   yy - two digit year, yyyy - fully resolved year
//  Day:    d - day, dd, zero padded,
//  Hour:   h - hour, hh - zero padded
//  Minute: m - minute, mm - zero padded
//  Second: s - second, ss - zero padded
//  Milli:
        DateTimeFormatter f  = DateTimeFormatter.ofPattern("dd, MMMM, yyyy, hh:mm:ss");
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.println("CUSTOM Format day, month, year ==> " + f.format(ldt));
        LocalDate today = LocalDate.parse("2019-05-08");
        System.out.println("Today ==> " + f2.format(today));
    }

    public
    void integers()
    {
//  this demonstrates the pooling of literal declaration as well as the 'valueOf() decleration
//  in this case, there are precisely two objects
        Integer i1 = 10;
        Integer i2 = 10;
//        Integer i3 = new Integer(10); // new Integer has been deprecated
        Integer i4 = Integer.valueOf(10);
        System.out.println(i1 == i2);
//        System.out.println(i1 == i3);
        System.out.println(i1 == i4);
//        System.out.println(i4 == i3);
    }

    public
    void strings()
    {
        //String nullable = null;
//        if(nullable.isBlank())
//        {
//            System.out.println("I failed");
//        }
        ArrayList<String> l = new ArrayList<>();
        l.size();
        StringBuilder sb  = new StringBuilder("Hello");
        StringBuilder sb1 = new StringBuilder("0123456789");
        System.out.println(sb.capacity());
        System.out.println(sb1.delete(8, 1000));

        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        for (String s : list)
        {
            System.out.print(s);
        }
        System.out.println();
// A string that adds two primitive or String CONSTANT variables together is itself
//  a constant whose value is stored in the String pool.
//  Only final primitives and Strings are included for Constant pool types.

        final String  s1   = ":ONE";
        final int     i    = 1;
        final Integer I    = 1;
        String        cati = i + s1;
        String        catI = I + s1;
        System.out.println(cati == "1:ONE");
        System.out.println(catI == "1:ONE");
        String str1 = "String";
        String str2 = " Two";
        System.out.println("str1 = \"String\" is in pool? " + (str1 == "String"));
        System.out.println("str2 = \" Two\" is in pool? " + (str2 == " Two"));
        String str3 = "String" + " Two";
        System.out.println("str3 = \"String\" + \" Two\" is in pool? " + (str3 == "String Two"));
        str3 = str1 + str2;
        System.out.println("str3 = str1 + str2 is in pool? " + (str3 == "String Two"));

    }

    public
    void playWithPrimitivesPlus()
    {
        System.out.println(LOG + "playWithPrimitivesPlus()" + RESET);
        int[]  one   = new int[4];
        int[]  two   = new int[4];
        int[]  three = new int[]{100, 200};
        int[]  four;
        int[]  five  = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        byte   b     = 0;
        char   c     = (char) b;
        short  s     = (short) c;
        int    i     = c;
        long   l     = i;
        float  f     = l;
        double d     = f;
        int    n     = (int) d;

        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(n);

        String[] strArray = new String[6];
        String   str      = new String();
        four = new int[6];
        int[] x = new int[4];
        System.out.println(x.length);

        System.out.println(four.length);
        System.out.println(strArray.length);
        System.out.println(strArray.length);
        System.out.println(str.length());
        StringBuilder sb = new StringBuilder(100);
        System.out.println(sb.append("Twenty").toString().length());
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        try
        {
            System.out.println("Object String Variable is null==>" + refIntValNull);
            System.out.println("Object String Variable is null==>" + refStrValNull);
            System.out.println("Object String Variable.method is null==>" + refStrValNull.length);
//            System.out.println("Object String Variable is null==>" + refValArrayNull);
//            System.out.println("Object String Variable.method is null==>" + refValArrayNull.length);
//            System.out.println("Object String Variable is null==>" + refValNull);
//            System.out.println("Object String Variable.method is null==>" + refValNull.length());
        }
        catch (NullPointerException e)
        {
            System.out.println("NullPointerException captured because of null object variable");

        }

        ArrayList <Integer> teg = new ArrayList<>();
        teg.add(127);
        teg.add(127);
        System.out.println(teg.get(0) == teg.get(1));

    }

    public
    void trySwitch()
    {
        Number n = 1;
        int    x = 2;

//  CANNOT use boolean, BOOLEAN, or any other wrappers.
//  Can ONLY use byte, char, short, int
//      Byte, Character, Short, Integer, String, enum
        String zz = new String(new char[]{'M', 'a', 'n', 'g', 'o'});
        System.out.println(zz);
        switch (zz)
        {
            default:
                System.out.println("Still no idea what x is");
            case "apple":
                System.out.println("x is equal to 1");
                break;
            case "orange":
                System.out.println("x is equal to 2");
                break;
            case "Mango":
                System.out.println("x is equal to 3");
                break;
        }

        int  xchar = 'A';
        char ychar = 56;
        switch (ychar)
        {
            default:
                System.out.println(ychar);
                break;
            case '1':
                System.out.print("ONE-");
                System.out.print("1-");
                break;
            case '7':
                System.out.print("SEVEN-");
                System.out.print("7-");
                break;
            case '8':
                System.out.print("EIGHT-");
                System.out.print("8-");
                break;
            case '9':
                System.out.print("NINE-");
                System.out.print("9-");
                break;
            case 'A':
                System.out.print('A');
                break;
        }
//        System.out.println(xchar + " xchar");
        System.out.println(ychar + " ychar");
        System.out.println((int) ychar + " ychar - int value");
    }

    public
    void playWithInstanceOf()
    {

        M cam = new O();
        if (cam instanceof M)
        {
            System.out.print("M");
        }
        if (cam instanceof N)
        {
            System.out.print("N");
        }
        if (cam instanceof O)
        {
            System.out.print("O");
        }
        if (cam instanceof P)
        {
            System.out.print("P");
        }
        System.out.println();
    }

    public
    void playWithDefaults()
    {

        boolean[] bean = new boolean[10];
        System.out.println(bean[5]);
        Boolean[] bean2 = new Boolean[10];
        System.out.println(bean2[5]);

        int[] in = new int[12];
        System.out.println(in[6]);

        String[] sing = new String[10];
        System.out.println(sing[5]);

        byte[] little = new byte[1];
        System.out.println(little[0]);

        int _a = 8000;
        if (_a > 500)
        {
            System.out.println(_a + " is true!");
        }
    }

    public
    void playWithLambdas()
    {
        StringLength ct     = a -> a.length();
        String       any    = "Im a string of unknown length";
        int          length = ct.getStrLength(any);
        System.out.println(length);
    }


    public
    void
    playingWithPassByRef()
    {
        ArrayList<String> als = new ArrayList<>();
        als.add("one");
        als.add("two");
        als.add("three");
        als.add("four");
        als.add("five");
        System.out.println("Before the call");
        for (String s : als)
        {
            System.out.println(s);
        }
        passingByReference(als);
        System.out.println("After the call");
        for (String s : als)
        {
            System.out.println(s);
        }

        ListIterator li = als.listIterator();
        while (li.hasNext())
        {
            String temp = (String) li.next();
            if (temp.equals("three"))
            {
                li.remove();
                continue;
            }
            System.out.println(temp);
        }

        StringBuilder sb = new StringBuilder("I Love ");
        System.out.println(sb.equals("I Love ") + " Testing the stringbuilder equals()");
        passSBRef(sb);
        System.out.println(sb);

        String passme = "Some stuff";
        passStrByRef(passme);
        System.out.println(passme);

        Character c = 'A';
        passIntByRef(c);
        System.out.println(c);

        DataObject d = new DataObject();
        d.sval = "First";
        d.val = 1;
        d.passDOByRef();
        System.out.println(d);

    }

    public
    void passIntByRef(Character c)
    {
        c = 'B';
    }

    public
    void passSBRef(StringBuilder s)
    {
//        s = new StringBuilder("I Hate ");
        s.append("Rock -n- Roll");
    }
    

}
/*
        String[]  arr = {"*", "**", "***", "****", "*****"};
        Predicate<String> pr1 = s -> s.length() < 4;
        print(arr, pr1);
        String s = "net a bunch a crap";
        System.out.println(play("adelbc"));
        System.out.println(play("adelhello"));
        System.out.println(play("adedbc"));
        System.out.println(play("adcdel"));
        System.out.println(play("add"));
        System.out.println(play("ad"));
        System.out.println(play("a"));
        System.out.println(play(""));
        System.out.println(play("del"));
        System.out.println(play("adel"));
        System.out.println(play("aadelbb"));
        System.out.println("binary (127+21) = " + (byte)(127+21));
        System.out.println("binary (127+1) = " + (byte)(127+1));
        System.out.println("binary (127+1 + 20) = " + ((byte)(127+1)+(byte)(20)));
        Boolean [] bool = new Boolean[2];
        boolean [] bul = {true, false};
        System.out.println(bool[0] + ":" + bool[1]);
        System.out.println(bul[0] + ":" + bul[1]);

        Map<String, Integer> m = new TreeMap<String, Integer>();
        for(String word : args)
        {
            Integer freq = m.get(word);     // if the value is not already in the TreeMap 'm',
                                            // then this will return null, else it will return the increment value.
            m.put(word, (freq==null? 1 : freq + 1));
        }
        System.out.println(m);

        // The following leverages two principles.
        //  First, of the types are common, then the 'widening' of a value is allowed.  Narrowing is NOT allowed.
        //  Widening includes:
        //  byte -> short -> int -> long
        //  float -> double
        //  char -> byte -> char are allowed
        //
        //  Second, boxing and auto-unboxing occur on common types.
        //  ie, you can begin with a byte value and box to Byte, to Short, to Integer, but not to Float or Double.
        //  the number would need to LOOK like a float or double value (#.#).
        byte b_p = 7;
        Byte b_w = b_p;
        short s_p = b_w;
        Short s_w = s_p;
        int i_p = s_w;
        Integer i_w = i_p;
        char c_p = 'A';
        Character c_w = c_p;
        byte bx_p = (byte) c_p;
        System.out.println(bx_p);

        String myInt_s = i_w.toString();
        System.out.println("My integer value is " + myInt_s);
        System.out.println("My short value unboxed from Integer is " + s_p);
        int is_p = Integer.parseInt(myInt_s);
        System.out.println("My short value unboxed from String is " + is_p);
        System.out.println("eq " + (new Integer(10) == 10));

        Integer iv_w = new Integer(127);
        Integer iv2_w = new Integer(127);
        System.out.println(iv_w == iv2_w);

        Integer iw1 = 127;
        Integer iw2 = 127;
        System.out.println(iw1 == iw2);

        int big = 1234567890;
        float approx = big;
        double approx_d = big;
        System.out.println(big - (int)approx); //   In the conversion from int to float, we can lose info
        System.out.println(big - (int)approx_d); //     in the conversion between int and double there is no loss
        System.out.println(big );
        System.out.println(approx_d);
        System.out.println(approx);
        System.out.println(1 + 2 + 3 + 4 + "Hello");
        System.out.println(1 + 2 + "Hello" + 2 + 3 + 4); // addition is left->right associative.  so we do the following
                                                        // (((((1+2) + "Hello") + 2) + 3) + 4)
        int aa = 7;
        System.out.println((aa++==7 && ++aa == 9  || aa++ == 9));
        System.out.println(aa);

        int myInt = 7;
        Integer myInteger = myInt;



        int i;
        for (i=0;i<=2;i++){}
        System.out.println(i);

    }

    public static String play(String str)
    {
        if(str.length()<4) return str;
        if(str.substring(1,4).equals("del"))
        {
            return str.substring(0,1) + str.substring(4,str.length());
        }
        return str;
    }

    private static
    void print(String[] arr, Predicate<String> predicate)
    {
        for (String str : arr)
        {
            if (predicate.test(str))
            {
                System.out.println(str);
            }
        }
    }
}

 */