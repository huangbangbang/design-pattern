package com.bj.datastructure;

public class SparseArray {

    public static void main(String[] args) {
        int[][] array = new int[10][10];
        array[0][0] = 7;
        array[1][1] = 1;
        array[2][2] = 2;
        array[3][3] = 3;
        array[4][4] = 4;

        System.out.println("原数组:");
        for (int[] row: array){
            for (int data: row){
                System.out.print(data+" ");
            }
            System.out.println();
        }
        /*for ( int i = 0 ; i<array.length;i++){
            for (int j = 0 ; j<array[i].length;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();

        }*/



        /*int sum=0 ;
        for ( int i = 0; i<array.length;i++){
            for (int j = 0; j<array[i].length;j++){
                if (array[i][j]!=0){
                    sum++;
                }
            }
        }

        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0]=array.length;
        sparseArray[0][1]=array[1].length;
        sparseArray[0][2]=sum;

        int k=1;
        for ( int i = 0; i<array.length;i++){
            for (int j = 0; j<array[i].length;j++){
                if (array[i][j]!=0){
                    sparseArray[k][0]=i;
                    sparseArray[k][1]=j;
                    sparseArray[k][2]=array[i][j];
                    k++;
                }

            }
        }*/

        int[][] sparseArray = toSparseArray(array);
        System.out.println("稀疏数组为：");
        /*for ( int i = 0 ; i<sparseArray.length;i++){
            for (int j = 0 ; j<sparseArray[i].length;j++){
                System.out.print(sparseArray[i][j]+" ");
            }
            System.out.println();
        }*/
        for ( int i = 0 ; i<sparseArray.length;i++){

                System.out.print(sparseArray[i][0]+" "+sparseArray[i][1]+" "+sparseArray[i][1]);
            System.out.println();
        }

        int[][] array2 = backToArray(sparseArray);
        System.out.println("还原的数组:");
        for ( int[] row: array2){
            for (int data : row){
                System.out.print(data+" ");
            }
            System.out.println();
        }
    }

    public static int[][] toSparseArray(int array[][]){
        int sum=0 ;
        for ( int i = 0; i<array.length;i++){
            for (int j = 0; j<array[i].length;j++){
                if (array[i][j]!=0){
                    sum++;
                }
            }
        }

        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0]=array.length;
        sparseArray[0][1]=array[1].length;
        sparseArray[0][2]=sum;

        int k=1;
        for ( int i = 0; i<array.length;i++){
            for (int j = 0; j<array[i].length;j++){
                if (array[i][j]!=0){
                    sparseArray[k][0]=i;
                    sparseArray[k][1]=j;
                    sparseArray[k][2]=array[i][j];
                    k++;
                }

            }
        }
        return sparseArray;
    }

    public static int[][] backToArray(int sparseArray[][]){
        int[][] array = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i=1;i<sparseArray.length;i++){
            array[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }
        return array;
    }



}


