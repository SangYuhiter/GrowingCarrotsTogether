package com.sangyu.growingcarrotstogether.Service;

import java.util.Random;

public class Blocks {
    private int[][] cubes;

    public int[][] getCubes() {
        return cubes;
    }

    public void setCubes(int[][] cubes) {
        this.cubes = cubes;
    }

    public Blocks() {
        int [][] c = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++) {
                c[i][j] = getRandomNumber();
            }
        }
        this.cubes = c;
    }

    public Blocks(int[][] cubes) {
        this.cubes = cubes;
    }

    private int getRandomNumber() {
        Random r = new Random();
        //设定2和4出现的概率，
        double f_2 = 0.7;
        if(r.nextInt()%10<f_2*10){
            return 2;
        }
        return 4;
    }
    public void clearBlocks(){
        int [][] c = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++) {
                c[i][j] = getRandomNumber();
            }
        }
        this.cubes = c;
    }

    public void updateBlocks(int op){
        cubes = this.getCubes();
        switch(op){
            //up
            case 1:
                cubes = trans_mod1(cubes);
                break;
            case 2:
                cubes = trans_mod2(cubes);
                break;
            case 3:
                cubes = trans_mod3(cubes);
                break;
            case 4:
                cubes = trans_mod4(cubes);
                break;
            default:
                break;
        }
        this.setCubes(cubes);
    }


    private int[][] trans_mod1(int [][] cubes) {
        for (int j=0; j<4; j++)
        {
            if(cubes[0][j] == cubes[1][j])
            {
                cubes[0][j] *= 2;
                if(cubes[2][j]==cubes[3][j])
                {
                    cubes[1][j] = cubes[2][j]*2;
                    cubes[2][j] = getRandomNumber();
                    cubes[3][j] = getRandomNumber();
                }
                else
                {
                    cubes[1][j] = cubes[2][j];
                    cubes[2][j] = cubes[3][j];
                    cubes[3][j] = getRandomNumber();
                }
            }
            else if(cubes[1][j]==cubes[2][j])
            {
                cubes[1][j] *=2;
                cubes[2][j] = cubes[3][j];
                cubes[3][j] = getRandomNumber();
            }
            else if(cubes[2][j]==cubes[3][j])
            {
                cubes[2][j] *=2;
                cubes[3][j] = getRandomNumber();
            }
        }
        return cubes;
    }

    private int[][] trans_mod2(int[][] cubes) {
        for (int j=0; j<4; j++)
        {
            if(cubes[3][j] == cubes[2][j])
            {
                cubes[3][j] *= 2;
                if(cubes[1][j]==cubes[0][j])
                {
                    cubes[2][j] = cubes[1][j]*2;
                    cubes[1][j] = getRandomNumber();
                    cubes[0][j] = getRandomNumber();
                }
                else
                {
                    cubes[2][j] = cubes[1][j];
                    cubes[1][j] = cubes[0][j];
                    cubes[0][j] = getRandomNumber();
                }
            }
            else if(cubes[2][j]==cubes[1][j])
            {
                cubes[2][j] *=2;
                cubes[1][j] = cubes[0][j];
                cubes[0][j] = getRandomNumber();
            }
            else if(cubes[1][j]==cubes[0][j])
            {
                cubes[1][j] *=2;
                cubes[0][j] = getRandomNumber();
            }
        }
        return cubes;

    }
    private int[][] trans_mod3(int[][] cubes) {
        for (int i=0; i<4; i++)
        {
            if(cubes[i][0] == cubes[i][1])
            {
                cubes[i][0] *= 2;
                if(cubes[i][2]==cubes[i][3])
                {
                    cubes[i][1] = cubes[i][2]*2;
                    cubes[i][2] = getRandomNumber();
                    cubes[i][3] = getRandomNumber();
                }
                else
                {
                    cubes[i][1] = cubes[i][2];
                    cubes[i][2] = cubes[i][3];
                    cubes[i][3] = getRandomNumber();
                }
            }
            else if(cubes[i][1]==cubes[i][2])
            {
                cubes[i][1] *=2;
                cubes[i][2] = cubes[i][3];
                cubes[i][3] = getRandomNumber();
            }
            else if(cubes[i][2]==cubes[i][3])
            {
                cubes[i][2] *=2;
                cubes[i][3] = getRandomNumber();
            }
        }
        return cubes;
    }

    private int[][] trans_mod4(int[][] cubes) {
        for (int i=0; i<4; i++)
        {
            if(cubes[i][3] == cubes[i][2])
            {
                cubes[i][3] *= 2;
                if(cubes[i][1]==cubes[i][0])
                {
                    cubes[i][2] = cubes[i][1]*2;
                    cubes[i][1] = getRandomNumber();
                    cubes[i][0] = getRandomNumber();
                }
                else
                {
                    cubes[i][2] = cubes[i][1];
                    cubes[i][1] = cubes[i][0];
                    cubes[i][0] = getRandomNumber();
                }
            }
            else if(cubes[i][2]==cubes[i][1])
            {
                cubes[i][2] *=2;
                cubes[i][1] = cubes[i][0];
                cubes[i][0] = getRandomNumber();
            }
            else if(cubes[i][1]==cubes[i][0])
            {
                cubes[i][1] *=2;
                cubes[i][0] = getRandomNumber();
            }
        }
        return cubes;
    }
}
