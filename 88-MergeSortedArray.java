class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int m_pointer = m-1;
        int n_pointer = n-1;
        int x_pointer = m+n-1;

        while (m_pointer >= 0 && n_pointer >= 0) {
            if (nums1[m_pointer] <= nums2[n_pointer]) {
                nums1[x_pointer] = nums2[n_pointer];
                n_pointer -= 1;
            } else {
                nums1[x_pointer] = nums1[m_pointer];
                m_pointer -= 1;
            }
            x_pointer -= 1;           
        }    
            
        // nums1 has a smaller length m (such as m = 0).
        // All elements in nums1 are smaller than those in nums2.
        while (n_pointer >= 0) {
            nums1[x_pointer] = nums2[n_pointer];
            n_pointer -= 1;
            x_pointer -= 1;
        }       
       
    }
}


//      m    
//   [1,2,3,4,5,6]
//        x
// n
//   [4,5,6]

//       m
//  [4,5,3,0,0,0] 
//             x
//     n
//  [1,2,3]

         
