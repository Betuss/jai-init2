package com.github.augustomatheuss.jai;

public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Jai jai = new Jai();
        System.out.println("Functions in Jai\n");
        /* rand() */
        System.out.println(">> rand()");
        jai.rand();
        System.out.print(">> ");
        jai.ans();
        System.out.println();
        /* rand(4) */
        System.out.println(">> rand(4)");
        jai.rand(4);
        System.out.print(">> ");
        jai.ans();
        System.out.println();
        /* rand(1,3) */
        System.out.println(">> rand(1,3)");
        jai.rand(1,3);
        System.out.print(">> ");
        jai.ans();
        System.out.println();
        /* zeros(4) */
        System.out.println(">> zeros(4)");
        jai.zeros(4);
        System.out.print(">> ");
        jai.ans();
        System.out.println();
        /* zeros(1,3) */
        System.out.println(">> zeros(1,3)");
        jai.zeros(1,3);
        System.out.print(">> ");
        jai.ans();
        System.out.println();
        /* randperm(5) */
        System.out.println(">> randperm(5)");
        jai.randperm(5);
        System.out.print(">> ");
        jai.ans();
        System.out.println();
        /* sum(rand(a),rand(b)) */
        System.out.println(">> sum(a,b), where a = rand(3) and b = rand(3)");
        jai.sum(jai.rand(3),jai.rand(3));
        System.out.print(">> ");
        jai.ans();
        System.out.println();
        /* ceil(rand(a)) */
        System.out.println(">> ceil(a), where a = rand(3)");
        jai.ceil(jai.rand(3));
        System.out.print(">> ");
        jai.ans();
        System.out.println();
    }
    
}
