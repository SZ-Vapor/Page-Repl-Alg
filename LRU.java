/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc460_p10;

import java.util.ArrayList;

/**
 *
 * @author Steven
 */
public class LRU extends ReplacementAlgorithm {

    public ArrayList<Integer> list;	//the list to keep track of the frames
    private int maxFrameCount;			//the maximum size of the list
   
    public LRU(int pageFrameCount) {
        super(pageFrameCount);
        maxFrameCount = pageFrameCount;
        //list = new ArrayList<>(frameCountMax);
        list = new ArrayList<>();
    }

    @Override
    public void insert(int pageNumber) {
 if (list.contains(pageNumber)) {
            //bubble this page to the bottom
            //list.remove(list.size()-1);
            list.remove(list.indexOf(pageNumber));
            //list.add(0, pageNumber);//old
            list.add(pageNumber);//new
            return;
        }

        //if the stack is full, pop the old page and push the new page
        if (list.size() >= maxFrameCount) {
            //list.remove(list.size() - 1);//old
            list.remove(0);//new
            //stack.addLast(pageNumber);
            //list.add(0, pageNumber);//old
            list.add(pageNumber);//new
            pageFaultCount++;
        } //if the stack isn't full, just push the page
        else {
            //list.add(0, pageNumber);//old
            list.add(pageNumber);//new
            pageFaultCount++;
        }

    }
}
