package com.bj.algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HuffmanCode {
    static HashMap<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    static StringBuilder stringBuilder = new StringBuilder();

        public static void main(String[] args) {
        //String content = "i like like like java do you like a java";
        //byte[] bytes = content.getBytes();

        //byte[] huffmanBytes = huffmanZip(bytes);
        //System.out.println(Arrays.toString(huffmanBytes));
        //byte[] decodeBytes=decode(huffmanBytes,huffmanCodes);
        //System.out.println(new String(decodeBytes));

        //zipFile("F:\\谷歌下载\\123.txt","F:\\谷歌下载\\123.zip");
        unZipFile("F:\\谷歌下载\\123.zip","F:\\谷歌下载\\123.txt");
    }

    public static void zipFile(String srcFile,String destFile){
        FileInputStream fis = null;
        OutputStream os=null;
        ObjectOutputStream oos=null;
        try {
            fis= new FileInputStream(srcFile);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            byte[] huffmanBytes = huffmanZip(bytes);
            os= new FileOutputStream(destFile);

            oos = new ObjectOutputStream(os);
            oos.writeObject(huffmanBytes);
            oos.writeObject(huffmanCodes);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fis.close();
                os.close();
                oos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void unZipFile(String zipFile,String destFile){
        FileInputStream fis = null;
        FileOutputStream fos=null;
        ObjectInputStream ois=null;
        try {
            fis= new FileInputStream(zipFile);
            ois = new ObjectInputStream(fis);
            byte[] huffmanBytes=(byte[])ois.readObject();
            Map<Byte,String> huffmanCodes = (Map<Byte,String>)ois.readObject();
            byte[] bytes = decode(huffmanBytes, huffmanCodes);
            fos= new FileOutputStream(destFile);
            fos.write(bytes);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fos.close();
                fis.close();
                ois.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private  static byte[] decode(byte[] huffmanBytes,Map<Byte,String> huffmanCodes){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<huffmanBytes.length;i++){
            byte b=huffmanBytes[i];
            boolean flag =(i==huffmanBytes.length-1);
            stringBuilder.append(byteToBitString(!flag,b));
        }
        //System.out.println(stringBuilder.toString());
        HashMap<String, Byte> map = new HashMap<String, Byte>();
        for (Map.Entry<Byte,String> entry:huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
        ArrayList<Byte> list = new ArrayList<>();
        for (int i=0;i<stringBuilder.length();){
            int count =1;
            boolean flag = true;
            Byte b=null;
            while (flag){
                String key = stringBuilder.substring(i,i+count);
                b=map.get(key);
                if (b==null){
                    count++;
                }else {
                    flag=false;
                }
            }
            list.add(b);
            i+=count;
        }
        byte[] b = new byte[list.size()];
        for (int i =0;i<b.length;i++){
            b[i]=list.get(i);
        }
        return b;
    }

    private static String byteToBitString(boolean flag,byte b){
        int temp = b;
        if (flag){
            temp|=256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag){
            return str.substring(str.length()-8);
        }else {
            return str;
        }
    }
    private static byte[] huffmanZip(byte[] bytes){
        ArrayList nodes =getToBytes(bytes);
        ToByte root = createHuffmanTree(nodes);

        Map<Byte,String> huffmanCodes = getCodes(root);
        //System.out.println(huffmanCodes);
        byte[] zipByte = zip(bytes,huffmanCodes);
        return zipByte;
    }

    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b:bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        //System.out.println(stringBuilder.toString());
        int len = (stringBuilder.length()+7)/8;

        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i=0;i<stringBuilder.length();i=i+8){
            String str;
            if (i+8>stringBuilder.length()){
                str=stringBuilder.substring(i);
            }else {
                str=stringBuilder.substring(i,i+8);
            }
            huffmanCodeBytes[index]= (byte) Integer.parseInt(str,2);
            index++;
        }
        return huffmanCodeBytes;
    }

    private static Map<Byte, String> getCodes(ToByte root) {
        if (root==null){
            return null;
        }
            getCodes(root.left,"0",stringBuilder);
            getCodes(root.right,"1",stringBuilder);
        return huffmanCodes;
    }
    private static void getCodes(ToByte toByte, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (toByte!=null){
            if (toByte.data==null){
                getCodes(toByte.left,"0",stringBuilder2);
                getCodes(toByte.right,"1",stringBuilder2);
            }else {
                huffmanCodes.put(toByte.data,stringBuilder2.toString());
            }
        }
    }

    private  static void preOrder(ToByte root){
        if (root==null){
            System.out.println("empty");
        }else {
            root.preOrder();
        }
    }

    private static ToByte createHuffmanTree(ArrayList list) {


        ArrayList<ToByte> nodes = list;

        while (nodes.size()>1){
            Collections.sort(nodes);

            ToByte node0 = nodes.get(0);
            ToByte node1 = nodes.get(1);

            ToByte parent = new ToByte(null,node0.value + node1.value);
            parent.left=node0;
            parent.right=node1;

            nodes.remove(node0);
            nodes.remove(node1);
            nodes.add(parent);
        }
        return nodes.get(0);

    }
    private static ArrayList<ToByte> getToBytes(byte[] bytes) {
        ArrayList<ToByte> nodes = new ArrayList<>();
        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b:bytes){
            Integer count = counts.get(b);
            if (count==null){
                counts.put(b,1);
            }else {
                counts.put(b,count++);
            }
        }

        for (Map.Entry<Byte,Integer> entry:counts.entrySet()){
            nodes.add(new ToByte(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
}


class ToByte implements Comparable<ToByte>{
    public Byte data;
    public int value;
    public ToByte left;
    public ToByte right;

    public ToByte(Byte data, int value) {
        this.data = data;
        this.value = value;
    }

    public void preOrder(){
        System.out.println(this.value);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "[" +
                "value=" + value +
                ']';
    }

    @Override
    public int compareTo(ToByte o) {
        return this.value-o.value;
    }
}