package encodeAndDecode;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class EncodeLength {

    public static List<String> encodeLengths(Integer length){
        int numLengthBytes = 1;
        List<Integer> list = new ArrayList<>();
        List<String> listResult = new ArrayList<>();

        while (((int) (Math.pow(2, 8 * numLengthBytes) - 1)) < length) {
            numLengthBytes++;
        }

        if(length<128){
            String s = Integer.toBinaryString(length);
            String s_result ="0";
            s_result = s_result.concat(s);
            int result = Integer.parseInt(s_result, 2);
            listResult.add(Integer.toHexString(result));
            return listResult;
        }
        if(length<=255) {

            Integer first_octets = Integer.parseInt("10000001", 2);
            listResult.add(Integer.toHexString(first_octets));
            listResult.add(Integer.toHexString(length));
            return listResult;
        }
        if (length<=32640){
            listResult.add(Integer.toHexString(0x80 | 2));
            int result = (int)length/128;
            listResult.add(Integer.toHexString(length-result*128));
            listResult.add(Integer.toHexString(result));


            return listResult;
        }

        if (length>32640) {
            list.add(length%128);
            list.add((int)length/128);

            for(int i =0; i<numLengthBytes;i++){
                list =reseach(list);
            }
            int size = list.size();
            list.add(0,0x80 | size);
            for(Integer i : list){
                listResult.add(Integer.toHexString(i));
            }
            return listResult;
        }
        return listResult;
    }

    public static List<Integer> reseach(List<Integer> list) {
        List<Integer> list2 = new ArrayList<>();
        int k=0;

        for(Integer i : list){
            if(i<255){
                list2.add(i);
            }else{
                list2.add(i % 128);
                list2.add((int) i / 128);
            }
        }


        return list2;
    }

    public static Integer decodeLengths(List<String> list) {
        int size = list.size();
        Integer result=0;
        if (size < 1) {
            System.out.println("List is epmty");
        }
        if (size == 1) {

            result = Integer.parseInt(list.get(0), 16);
            return result;
        }

        Integer i = Integer.parseInt(list.get(0),16);
        System.out.println("count octets = "+ (i-128));
        for (int k=1; k<size;k++){
            result+=(int)Math.pow(128,k-1)*Integer.parseInt(list.get(k),16);

        }
        return result;
    }
    public static void main(String[] args) throws IOException {
//        Integer length =1000001234;
//        Integer length2;
//
//        List<String> list = new ArrayList<>();
//        list = encodeLength(length);
//
//        for(String i :list){
//            System.out.println(i);
//        }
//        length2 = decodeLength(list);
//        System.out.println("length= " +length2);
//        System.out.println(Integer.parseInt("81",16));

    }
}