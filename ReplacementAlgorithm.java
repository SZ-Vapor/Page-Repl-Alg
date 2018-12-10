/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc460_p10;

/**
 *
 * @author Steven
 */
public abstract class ReplacementAlgorithm {

    // the number of page faults
    protected int pageFaultCount;
    // the number of physical page frame
    protected int pageFrameCount;
    // pageFrameCount - the number of physical page frames

    public ReplacementAlgorithm(int pageFrameCount) {
        if (pageFrameCount < 0) {
            throw new IllegalArgumentException();
        }
        this.pageFrameCount = pageFrameCount;
        pageFaultCount = 0;
    }
    // return - the number of page faults that occurred.

    public int getPageFaultCount() {
        return pageFaultCount;
    }
    // int pageNumber - the page number to be inserted

    public abstract void insert(int pageNumber);

}
