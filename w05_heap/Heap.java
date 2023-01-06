package algo_05_20185249;

class Heap {
    private int count;
    private int size;
    private int[] itemArray;
    
    public Heap() {
        count = 0;
        size = 64;
        itemArray = new int[size];
    }
    
    public Heap(int[] origArray) {
    	
//
    	count = origArray.length;
    	
    	for(int i=count/2; i>=1; i--) {
    		int p=i;
    		
    		for(int j=p*2; j<count-1; j*=2) {
    			if(j<count) {
    				if(origArray[j]<origArray[j+1]) {
    					j++;
    				}
    			}
    			if(origArray[p]>=origArray[j]) {
        			break;
        		}
        		int temp = origArray[p];
        		origArray[p] = origArray[j];
        		origArray[j] = temp;
        		p=j;
    		}	
    	}
    	
    	size = 64;
    	
    	this.itemArray = new int[size];
    	for(int i=1; i<count; i++) {
    		itemArray[i] = origArray[i];
    	}
    	count--;
    }
   
    
    public void insert(int newItem) {
//
    	int i=++count;
    	
    	
    	while(true) {
    		if(i==1) break;
    		if(newItem<=this.itemArray[i/2]) break;
    		this.itemArray[i] = this.itemArray[i/2];
    		i/=2;
    	}
    	itemArray[i] = newItem;
    	
//    	for(i = count;;) {
//    		if(i==1) break;
//    		if(newItem<=this.itemArray[i/2]) break;
//    		this.itemArray[i] = this.itemArray[i/2];
//    		i/=2;
//    	}
//    	itemArray[i] = newItem;
    }

    public int delete() {
//
    	if(count==0) return -1;
    	
    	int item = this.itemArray[1];
    	int temp = this.itemArray[count--];
    	
    	int i=1;
    	int j=2;
    	
    	while(j<=count) {
    		if(j<count) {
    			if(this.itemArray[j]<itemArray[j+1]) {
    				j++;
    			}
    		}  
    		if(temp>=itemArray[j]) {
    			break;
    		}
    		itemArray[i] = itemArray[j];
    		i=j;
    		j*=2;
    	}
    	itemArray[i] = temp;
    	return item;
    }

    public void printHeap() {
        int i;
        for (i = 1; i <= count; i++)
            System.out.print(itemArray[i] + " ");
        System.out.println();
    }
}


class HeapTest {
    public static void main(String args[]) {
        Heap h = new Heap();
        h.insert(30);
        h.insert(40);
        h.insert(20);
        h.insert(10);
        h.insert(35);
        h.insert(45);
        h.insert(50);
        h.insert(25);
        h.insert(70);
        h.insert(48);
        h.insert(64);
        h.printHeap();
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        
        System.out.println("************************");
        
        // -10�� �쓽誘몄뾾�뒗 �닽�옄�엫
        int[] origArray = {-10, 50, 55, 60, 30, 70, 90, 25, 80, 40, 45};
        h = new Heap(origArray);
        h.printHeap();

/*
        // -10�� �쓽誘몄뾾�뒗 �닽�옄�엫
        int[] origArray1 = {-10, 50, 55, 60, 30, 70, 90, 25, 80, 40, 45};
        Heap h1 = Heap.makeHeap(origArray1);
        h.printHeap();
*/
        System.out.println(h.delete());
        System.out.println(h.delete());

        h.printHeap();

    }
}