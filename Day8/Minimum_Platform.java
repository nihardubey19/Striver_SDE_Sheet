    // time complexity -> O(2nlogn) + O(2n)
    // space complexity -> O(1)

    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int ans = 1;
        int platform=1;
        int i=1, j=0;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                platform++;
                i++;
            }
            else if(arr[i]>dep[j]){
                platform--;
                j++;
            }
            
            
            if(platform>ans){
                ans = platform;
            }
        }
        return ans;
    }
