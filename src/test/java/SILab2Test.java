import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
     SILab2 obj=new SILab2();
    private List<Angle> createList(Angle ... angles)
    {
        return new ArrayList<>(Arrays.asList(angles));
    }
    @Test
    void testEveryStatement()
    {
        RuntimeException rx;

        rx=assertThrows(RuntimeException.class, () -> obj.function(createList(new Angle(-1,25,50),new Angle(10,0,2))));
        assertTrue(rx.getMessage().contains("The angle is smaller or greater then the minimum"));
        rx=assertThrows(RuntimeException.class, () -> obj.function(createList(new Angle(60,-3,50),new Angle(15,0,2))));
        assertTrue(rx.getMessage().contains("The minutes of the angle are not valid!"));
        rx=assertThrows(RuntimeException.class, () -> obj.function(createList(new Angle(60,52,-15),new Angle(13,45,23))));
        assertTrue(rx.getMessage().contains("The seconds of the angle are not valid"));
        rx=assertThrows(RuntimeException.class, () -> obj.function(createList(new Angle(360,32,26),new Angle(15,0,2))));
        assertTrue(rx.getMessage().contains("The angle is greater then the maximum"));
        List<Integer> result1=new ArrayList<>(Arrays.asList(255133,1296000));
        assertEquals(result1,obj.function(createList(new Angle(70,52,13),new Angle(360,0,0))));

    }
    @Test
    void testMultipleStatement(){
        RuntimeException rx;

        rx=assertThrows(RuntimeException.class, () -> obj.function(createList(new Angle(-1,43,12))));//ovde pagja prviot if,false &&X
        assertTrue(rx.getMessage().contains("The angle is smaller or greater then the minimum"));
        rx=assertThrows(RuntimeException.class, () -> obj.function(createList(new Angle(500,43,12))));//ovde T&&F=FALSE
        assertTrue(rx.getMessage().contains("The angle is smaller or greater then the minimum"));
        rx=assertThrows(RuntimeException.class, () -> obj.function(createList(new Angle(50,-35,12))));//ovde sme vo vtoriot if, T||X=TRUE
        assertTrue(rx.getMessage().contains("The minutes of the angle are not valid!"));
        rx=assertThrows(RuntimeException.class, () -> obj.function(createList(new Angle(50,76,12))));//ovde F || T=TRUE
        assertTrue(rx.getMessage().contains("The minutes of the angle are not valid!"));
        rx=assertThrows(RuntimeException.class, () -> obj.function(createList(new Angle(50,35,-12))));//ovde sme vo tretiot if, T ||X=TRUE
        assertTrue(rx.getMessage().contains("The seconds of the angle are not valid"));
        rx=assertThrows(RuntimeException.class, () -> obj.function(createList(new Angle(50,35,85))));//F||T =TRUE
        assertTrue(rx.getMessage().contains("The seconds of the angle are not valid"));

        List<Integer> results2=new ArrayList<>(Arrays.asList(181942));//ovde se e vo red, i presmetuvame
        assertEquals(results2,obj.function(createList(new Angle(50,32,22))));

        rx=assertThrows(RuntimeException.class, () -> obj.function(createList(new Angle(360,35,5))));//ovde ako padne najprviot if, odime vo else if i vo 4tiot if,F&&X=FALSE
        assertTrue(rx.getMessage().contains("The angle is greater then the maximum"));
        rx=assertThrows(RuntimeException.class, () -> obj.function(createList(new Angle(360,0,5))));// sega deg i min se okej, no sec ne T&&F=FALSE
        assertTrue(rx.getMessage().contains("The angle is greater then the maximum"));

        results2=new ArrayList<>(Arrays.asList(1296000)); //tuka site se okej i si prsmetuvame, deg=360,min=0,sec=0
        assertEquals(results2,obj.function(createList(new Angle(360,0,0))));





    }

}