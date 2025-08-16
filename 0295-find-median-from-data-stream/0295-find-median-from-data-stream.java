class MedianFinder {
    private PriorityQueue<Integer> leftMaxHeap;
    private PriorityQueue<Integer> rightMinHeap;
    public MedianFinder() {
        leftMaxHeap=new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftMaxHeap.isEmpty() || num <leftMaxHeap.peek()){
            leftMaxHeap.add(num);
        }else{
            rightMinHeap.add(num);
        }

        //always keep Maxheap size 1 > that minheap or both equal
        if(Math.abs(leftMaxHeap.size() - rightMinHeap.size())>1){
            rightMinHeap.add(leftMaxHeap.poll());
        }else if (leftMaxHeap.size()<rightMinHeap.size()){
            leftMaxHeap.add(rightMinHeap.poll());
            
        }

    }
    
    public double findMedian() {
        if(leftMaxHeap.size() == rightMinHeap.size()){
            // even num
            return(double) (leftMaxHeap.peek()+rightMinHeap.peek())/2;
        }
        // odd num

        return leftMaxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */