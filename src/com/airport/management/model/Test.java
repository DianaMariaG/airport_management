package com.airport.management.model;

class Test {
    public int x;
    public int y;
    public Test(int xVal, int yVal) { x = xVal; y = yVal; }
    public String toString () { return "x=" + x + ",y=" + y; }

    public static void main(String[] args) {
        Test t1 = new Test(1, 2);
        Test t2 = t1; //t2 arata catre acelasi obiect t1 (nu primeste valorile lui t1, ci e chiar t1) t1 si t2 au aceeasi referinta(arata catre acelasi spatiu din memorie)
        Test t3 = new Test (t1.x, t1.y); //t3 e un obiect nou cu valorile lui t1
        t1.x = 94;
        System.out.println("T2 " + t2);
        System.out.println("T3 " + t3);
        t1 = new Test(3, 4); //t1 primeste un alt obiect; acum t1 arata catre alt obiect, dar t2 nu se schimba
        System.out.println("T2 " + t2);
        t2 = t1; //acum se shcimba si t2 si arata catre noul t1
        System.out.println("T2 " + t2);
    }
}


