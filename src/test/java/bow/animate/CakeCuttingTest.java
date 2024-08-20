package bow.animate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CakeCuttingTest {

    @Test
    void calcMax() {
        long w=4,h=4;
        boolean[] vc={true,true,true,false,true};
        boolean[] hc={true,true,false,true,true};
        long ans=CakeCutting.calcMax(w,h,vc,hc);
        assertEquals(4,ans);
    }
}