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
        list = new ArrayList<>();
    }

    public void resetData(){
        list.clear();
        pageFaultCount = 0;
    }

    @Override
    public void insert(int pageNumber) {
        if (list.contains(pageNumber)) {
            list.remove(list.indexOf(pageNumber));
            list.add(pageNumber);
            return;
        }

        //if the stack is full, pop the old page and push the new page
        if (list.size() >= maxFrameCount) {
            list.remove(0);
            list.add(pageNumber);
            pageFaultCount++;
        } //if the stack isn't full, just push the page
        else {
            list.add(pageNumber);
            pageFaultCount++;
        }

    }
}
