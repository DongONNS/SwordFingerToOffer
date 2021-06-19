package edu.csu.swordFingerOffer.ThirdPractice.string;

import java.util.LinkedList;
import java.util.Queue;

public class Insert {

    int[] cnts = new int[128];
    Queue<Character> queue = new LinkedList();

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        cnts[ch]++;
        queue.add(ch);
        while(!queue.isEmpty() && cnts[queue.peek()] > 1){
            queue.poll();
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
