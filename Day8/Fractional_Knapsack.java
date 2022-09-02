    // Time Complexity: O(nlogn) + O(n)
    // Space Complexity: O(1)

//Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Arrays.sort(arr, (a, b) -> b.value*a.weight - a.value*b.weight);
        double res = 0.0;
        
        for(int i=0; i<n; i++){
            if(arr[i].weight <= W){
                res += arr[i].value;
                W -= arr[i].weight;
            }
            else{
                res += (double)(arr[i].value)/arr[i].weight * W;
                break;
            }
        }
        
        return res;
    }
