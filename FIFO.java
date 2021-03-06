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
public class FIFO extends ReplacementAlgorithm {

  
    private int maxFrameCount;
    public ArrayList<Integer> list;//list to hold the pages

    public FIFO(int pageFrameCount) {
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
        //check if it's already in the list
        if (list.contains(pageNumber)) {
            return;
        }
       
        //If the list is full, remove the first/oldest page and push the incoming page to the last/newest index of the list
        if (list.size() >= maxFrameCount) {
            list.remove(0);
            list.add(pageNumber);
            pageFaultCount++;
        } //else the list isn't full yet and we can just add it
        else {
            list.add(pageNumber);
            pageFaultCount++;
        }
       
    }

}
