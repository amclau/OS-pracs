public class FIFO_Page{
    public static void main(String args[]){
        int referenceString[] = {1,2,3,4,2,1,5,3,2,4,6};
        int pageFrame[] = {-1, -1, -1};

        int pageFaults = FIFO(referenceString, pageFrame);

        int pageHits = referenceString.length - pageFaults;

        System.out.println("Page Hits: "+pageHits);
        System.out.println("Page Faults: "+pageFaults);
        System.out.println("Page Hit Ratio: "+(pageHits/referenceString.length));
        System.out.println("Page Fault Ratio: "+(pageFaults/referenceString.length));
    }

    private static int FIFO(int referenceString[], int frames[]){
        int pageFaults = 0;
        int pointer = 0;
        for (int page = 0; page<referenceString.length; page++){
        
            boolean isPagePresent = false;
            for (int frame = 0; frame<frames.length; frame++){
                if (referenceString[page] == frames[frame]){
                    isPagePresent = true;
                }
            }
            if (!isPagePresent){
                pageFaults++;
                frames[pointer] = referenceString[page];
                pointer++;
            }
            if (pointer==2){
                pointer=0;
            }
        }
        return pageFaults;
    }
}