public class Main{
  public static void main(String[] args) {
        int x[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
        
        FIFO w = new FIFO(3);//change paramter to args[]
        LRU p = new LRU(3);
        for (int i = 0; i < x.length; i++) {
            w.insert(x[i]);
            p.insert(x[i]);
        }
        System.out.println(w.getPageFaultCount());
        System.out.println(p.getPageFaultCount());
    }

}
