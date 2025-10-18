package classes.problems.heaps;

import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> data;

    public MinHeap() {
        this.data = new ArrayList<>();
    }

    public void insert(int value){
        this.data.set(this.data.size(),value);
        heapifyUp(this.data.size());
    }

    public int delete(){
        int out = this.data.getFirst();
        if(this.data.size() == 1){
            this.data = new ArrayList<>();
            return out;
        }

        this.data.set(0,this.data.getLast());
        this.heapifyDown(0);
        return out;
    }

    private void heapifyUp(int idx){
        if(idx == 0) return;

        int parentIdx = getParent(idx);
        int parentV = data.get(parentIdx);
        int val = data.get(idx);
        if(data.get(idx) < data.get(parentIdx)){
            data.set(idx,parentV);
            data.set(idx,val);
            heapifyUp(parentIdx);
        }
    }

    private void heapifyDown(int idx){
        int lIdx = leftChild(idx);
        int rIdx = rightChild(idx);

        if(idx >= data.size() || lIdx >= data.size()) return;

        int lVal = data.get(lIdx);
        int rVal = data.get(rIdx);
        int val = data.get(idx);

        if(lVal > rVal && val > rVal){
            data.set(idx, rVal);
            data.set(rIdx, val);
            heapifyDown(rIdx);
        }else if(rVal > lVal && val > lVal){
            data.set(idx, lVal);
            data.set(lVal, val);
            heapifyDown(rIdx);
        }
    }

    private int getParent(int idx){
        return (idx - 1) / 2;
    }

    private int leftChild(int idx){
        return (idx * 2) + 1;
    }

    private int rightChild(int idx){
        return (idx * 2) + 2;
    }
}
