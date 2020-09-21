/* Time complexity: O(3n)
space complexity: O(1)
*/

class Solution{
    public int candy(int[] ratings){
        if(ratings == null || ratings.length == 0) return 0;
        int sum = 0;
        int[] candy  = new int[ratings.length];
        Arrays.fill(candy,1);
        for(int i=1; i<ratings.length; i++){
            if(ratings[i] > ratings[i+1]){
                candy[i] = candy[i-1] + 1;
            }
        }
        for(int j=ratings.length-2; j>=0; j--){
            if(ratings[j] > ratings[j+1]){
                candy[j] = Math.max(candy[j], candy[j+1]+1);
            }
            sum += candy[j];
        }
        return sum;
    }
}