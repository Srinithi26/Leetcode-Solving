public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if(base == null) {
            base = new int[256];
            for(int i = 0; i < 256; ++i) base[i] = reverseBitsByte(i);
        }
        
        int result = 0;
        for(int i = 0; i < 4; ++i) {
            int low = n&0xFF;
            low = base[low];
            result <<= 8;
            result |= low;
            n = n >>> 8;
        }
        return result;
    }
    
    private int reverseBitsByte(int n) {
        int result = 0;
        for(int i = 0; i < 8; ++i) {
            int low = n&1;
            result <<= 1; 
            result = result | low;
            n = n >>> 1;
        }
        return result;
    }
    
    private int[] base = null;
}