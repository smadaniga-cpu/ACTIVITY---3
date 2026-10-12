class Solution {
    public class Pair implements Comparable<Pair>{
        int ele;
        int freq;
        Pair(int ele , int freq){
            this.ele = ele;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            return this.freq - p.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

        // Store the pair of elements and freq into HashMap
        for(int ele : nums){
            if(!map.containsKey(ele)){
                map.put(ele,1);
            }
            else{
                map.put(ele,map.get(ele)+1);
            }
        }
        // Now put pairs into priorityQueue
        for(int ele : map.keySet()){
            
            int freq = map.get(ele);
            pq.add(new Pair(ele,freq));
            if(pq.size() > k) pq.remove();
        }
        // Now pq have k frequent elements in it so remove one by one and put into ans array
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            Pair p = pq.remove();
            ans[i] = p.ele;
        }
        return ans;
    }
}
