package encodeLengthTest;

import encodeAndDecode.EncodeLength;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EncodelengthTest {
    @Test
    public void encodeLength() {
        Integer length1 =201;
        List<String> list = new ArrayList<>();
        list.add("81");
        list.add("c9");
        assertEquals(list, EncodeLength.encodeLengths(length1));

        Integer length2 =127;
        list.clear();
        list.add("7f");
        assertEquals(list, EncodeLength.encodeLengths(length2));

        Integer length3 =32640;
        list.clear();
        list.add("82");
        list.add("0");
        list.add("ff");
        assertEquals(list, EncodeLength.encodeLengths(length3));

        Integer length4 =40000;
        list.clear();
        list.add("83");
        list.add("40");
        list.add("38");
        list.add("2");
        assertEquals(list, EncodeLength.encodeLengths(length4));

        Integer length5 =4000000;
        list.clear();
        list.add("83");
        list.add("0");
        list.add("12");
        list.add("f4");
        assertEquals(list, EncodeLength.encodeLengths(length5));
    }

    @Test
    public void decodelength(){
        Integer length1 =201;
        List<String> list = new ArrayList<>();
        list.add("81");
        list.add("c9");
        assertEquals(length1, EncodeLength.decodeLengths(list));

        Integer length2 =127;
        list.clear();
        list.add("7f");
        assertEquals(length2, EncodeLength.decodeLengths(list));

        Integer length3 =32640;
        list.clear();
        list.add("82");
        list.add("0");
        list.add("ff");
        assertEquals(length3, EncodeLength.decodeLengths(list));

        Integer length4 =40000;
        list.clear();
        list.add("83");
        list.add("40");
        list.add("38");
        list.add("2");
        assertEquals(length4, EncodeLength.decodeLengths(list));

        Integer length5 =4000000;
        list.clear();
        list.add("83");
        list.add("0");
        list.add("12");
        list.add("f4");
        assertEquals(length5, EncodeLength.decodeLengths(list));
    }
}
