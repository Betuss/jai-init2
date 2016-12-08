/*
 *  Java lib with jml for artificial intelligence.
 *  Copyright (C) 2016, Augusto Damasceno
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */


package com.github.augustomatheuss.jai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class Jai {
    private /*@ spec_public @*/ Random  rnd;
    private /*@ spec_public nullable @*/ Object  ans;
    private /*@ spec_public nullable @*/ String  ansType;
    private /*@ spec_public nullable @*/ List    ansSizes;
    private /*@ spec_public @*/ int     ansDim;
    
    public Jai()
    {
        this.rnd = new Random(System.currentTimeMillis());
        this.ansSizes = new ArrayList<Integer>();
        this.ansSizes.add(1);
        this.ansDim = 1;
        this.ans = (Object) 0.0;
    }
    
    public double rand()
    {
        double r = this.rnd.nextDouble();
        this.ans = (Object) r;
        this.ansType = "double";
        this.ansDim = 1;
        this.ansSizes.clear();
        this.ansSizes.add(1);
        return r;
    }
    
    public double[] rand(int e)
    {
        double mat [] = new double [e];
        for(int i=0; i<e; i++)
            mat[i] = this.rnd.nextDouble();

        this.ans = (Object) mat;
        this.ansType = "double";
        this.ansDim = 1;
        this.ansSizes.clear();
        this.ansSizes.add(e);
        return mat;
    }
    
    public double[][] rand(int r, int c)
    {
        double mat [][] = new double [r][c];
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                mat[i][j] = this.rnd.nextDouble();
            }
        }
        this.ans = (Object) mat;
        this.ansType = "double";
        this.ansDim = 2;
        this.ansSizes.clear();
        this.ansSizes.add(r);
        this.ansSizes.add(c);
        return mat;
    }
    
    /*@ requires 0 < e;
	    @ assignable ans, ansType, ansDim, ansSizes;
	    @ ensures (\forall int i; 0 <= i && i < 10; true);
    @*/
    public double[] zeros(int e)
    {
        double mat [] = new double [e];
        for(int i=0; i<e; i++)
            mat[i] = 0.0;
        

        this.ans = (Object) mat;
        this.ansType = "double";
        this.ansDim = 1;
        this.ansSizes.clear();
        this.ansSizes.add(e);
        return mat;
    }
    
    public double[][] zeros(int r, int c)
    {
        double mat [][] = new double [r][c];
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                mat[i][j] = 0.0;
            }
        }
        this.ans = (Object) mat;
        this.ansType = "double";
        this.ansDim = 2;
        this.ansSizes.clear();
        this.ansSizes.add(r);
        this.ansSizes.add(c);
        return mat;
    }
    
    public int[] randperm(int sz)
    {
        int s = this.rnd.nextInt(sz);
        int v [] = new int[sz];
        v[0] = -1;
        
        for(int i=0; i<v.length; i++)
        {
            while(!notIn(s,i-1,v))
                s = this.rnd.nextInt(sz);
            
            v[i] = s;
            s = this.rnd.nextInt(sz);
        }
        
        this.ans = (Object) v;
        this.ansType = "int";
        this.ansDim = 1;
        this.ansSizes.clear();
        this.ansSizes.add(sz);
        return v;
    }
    
    private boolean notIn(int test, int until, int vector [])
    {
        for(int i=0; i <= until; i++)
        {
            if(test == vector[i])
            {
                return false;
            }
        }
        return true;
    }
    
    public double [] sum(double a [], double b[])
    {
        double mat [] = new double [a.length];
        for(int i=0; i<a.length; i++)
            mat[i] = a[i] + b[i];
        
        this.ans = (Object) mat;
        this.ansType = "double";
        this.ansDim = 1;
        this.ansSizes.clear();
        this.ansSizes.add(a.length);
        return mat;
    }
    
    public double [] ceil(double a [])
    {
        double mat [] = new double [a.length];
        for(int i=0; i<mat.length; i++)
            mat[i] = Math.ceil(mat[i]);
        
        this.ans = (Object) mat;
        this.ansType = "double";
        this.ansDim = 1;
        this.ansSizes.clear();
        this.ansSizes.add(mat.length);
        return mat;
    }
    
    public double [][] ceil(double a [][])
    {
        double mat [][] = new double [a.length][a[0].length];
        for(int i=0; i<a.length; i++)
        {
            for(int j=0; j<a[0].length; j++)
                mat[i][j] = Math.ceil(a[i][j]);
        }
            
        this.ans = (Object) mat;
        this.ansType = "double";
        this.ansDim = 2;
        this.ansSizes.clear();
        this.ansSizes.add(a.length);
        this.ansSizes.add(a[0].length);
        return mat;
    }
    
    public void ans()
    {
        if(this.ansType.compareTo("double") == 0)
        {
            if((this.ansDim == 1) && ((int)this.ansSizes.get(0) == 1))
            {
                System.out.println((double)this.ans);
            }
            else
            {
                switch(this.ansDim)
                {
                    case(1):
                        System.out.println(
                        Arrays.toString((double[])this.ans)); 
                        break;
                    case(2):
                        System.out.println(
                        Arrays.deepToString((double[][])this.ans)); 
                        break;
                }
            }
        }
        else if(this.ansType.compareTo("int") == 0)
        {
            if((this.ansDim == 1) && ((int)this.ansSizes.get(0) == 1))
            {
                System.out.println((int)this.ans);
            }
            else
            {
                switch(this.ansDim)
                {
                    case(1):
                        System.out.println(
                        Arrays.toString((int[])this.ans)); 
                        break;
                    case(2):
                        System.out.println(
                        Arrays.deepToString((int[][])this.ans)); 
                        break;
                }
            }
        }
    }
}
