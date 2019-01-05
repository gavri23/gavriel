public class Ex14{
//1
  public static void win (int [] arr){
  int sumOdd = 0;
  int sumEven = 0;
  boolean choose;
    for(int i =0; i<arr.length; i++){
        if(i%2==0){
            sumEven += arr[i];
        }
        else{
            sumOdd += arr[i];
        }
    }
  int start = 0;
  int end = arr.length-1;
  int sumAmir = 0;
  int sumTamar = 0;
    choose = sumEven > sumOdd;

    if(choose == true){   
        for(int i = 0; i<arr.length/2; i++){
            if(start%2==0){
                sumAmir += arr[start];
                System.out.println("Amir took " +  arr[start]);
                start++;
            }
            else{
                sumAmir += arr[end];
                System.out.println("Amir took " +  arr[end]);
                end--; 
            }
            if(arr[start]>arr[end]){
                sumTamar+=arr[start];
                System.out.println("Tamar took " +  arr[start]);
                start++;
            }
            else{
                sumTamar+=arr[end];
                System.out.println("Tamar took " +  arr[end]);
                end--;
                 }
                
                }
            }

            else{ 
                for(int i = 0; i<arr.length/2; i++){
                    if(end%2==1){
                        sumAmir+= arr[end];
                        System.out.println("Amir took " +  arr[end]);
                        end--;
                    }
                    else{
                        sumAmir += arr[start];
                        System.out.println("Amir took " +  arr[start]);
                        start++; 
                    }
                    if(arr[start]>arr[end]){
                        sumTamar+=arr[start];
                        System.out.println("Tamar took " +  arr[start]);
                        start++;
                    }
                    else{
                System.out.println("Tamar took " +  arr[end]);
                end--;
                }
                }
            
            }
        System.out.println("total score:");   
        System.out.println("Amir total " + sumAmir);
        System.out.println("Tamar total " + sumTamar);
    }   
        
        
    
    
   
  
 
   
    
   


//2 
public static boolean what (int[]a, int num){
int sum = 0; int start = 0; int end = 0;
while(end < a.length){
  
    if(a[end]==num){
    start=end;
    System.out.println("between " +start+ " and " +end);
    return true;
    
    }
    else  if(a[end]>num){
    end++;
    start=end;
    sum=0;
    
    
    }
    else if(num==sum){
    System.out.println("between " +start+ " and " +(end -1));
    return true;
    
    }
    
    
    
    
     
    else if(num>sum){
      
       sum += a[end];
       
       end++;
       if(end==a.length){
        break;
        }
       
   
}  
    
    
    
    else{
    sum -= a[start];
    start++;
    
    }
}
if(sum==num){
    System.out.println("between " +start+ " and " +(end-1));
    return true;
}
System.out.println("No ");
return false;
}





//q3
public static int longestSlope  (int [][] mat, int num){
int i=0;
int j=0;
int sum = 1;

//recusive loop
//max(latestMax, longestSlope  ( mat, num,i,j));

loop(mat,num, i,j);

return sum;




}
private static int longestSlope  (int [][] mat, int num,int i,int j){
int sum = 1;
int max = 0;

if(i<mat[0].length-1 && mat[i+1][j] == mat[i][j] - num){
   
   
   return sum + longestSlope(mat,num,i+1,j); 

    
}
if(i==mat[0].length-1 && mat[i][j+1] == mat[i][j] - num){
   
   
    return sum + longestSlope(mat,num,i,j+1) ;
}
if(j<mat.length-1 && mat[i][j] == mat[i][j] - num ){
    
     
    return  sum + longestSlope(mat,num,i,j+1) ; 
}
if(j==mat.length-1 && mat[i][j] == mat[i][j+1] - num){
   
   
    return sum + longestSlope(mat,num,i+1,j) ;
}
if( i!=0 && mat[i-1][j] == mat[i][j] - num ){
  
    
 return sum + longestSlope(mat,num,i-1,j);
}    
if( j!=0 && mat[i][j-1] == mat[i][j] + num){
  
  
  return sum + longestSlope(mat,num,i,j-1);
}
if(sum>max){

    max=sum;

}
if(i == mat[0].length && j == mat.length){
    return sum;
}
return max;

}







private static void loop(int mat [][],int num, int i, int j){







if(i<mat.length-1){
System.out.println(mat[i][j]);
longestSlope(mat,num,i,j);    
    
loop(mat,num,i+1,j);          

}
if(i==mat.length){
i = 0;

loop(mat,num,i,j+1);
}
if(i == mat[0].length-1 && j == mat.length-1){
 return;   
}




}   

//4

public static int howManySorted(int n, int max){
int count = 0;
if(n==1){
    return max;
    
}
if(max!=0){
count+= howManySorted(n,max-1);

}
if(n!=1){
  count+= howManySorted(n-1, max);  
    


}

return count;

} 
    











public static void main(){
    

        /* Tester Question 1 */

        System.out.println ("********** Question 1 **********\n");

        int[] array1 = {16,23,30,14,13,21,19,15};
        System.out.println("Checking method 'win' on array [16,23,30,14,13,21,19,15]\n");

        System.out.println ("Expected results:");
        System.out.println ("Amir took 16");
        System.out.println ("Tamar took 23");
        System.out.println ("Amir took 30");
        System.out.println ("Tamar took 15");
        System.out.println ("Amir took 19");
        System.out.println ("Tamar took 21");
        System.out.println ("Amir took 13");
        System.out.println ("Tamar took 14");
        System.out.println ("Final Score:");
        System.out.println ("Amir total 78");
        System.out.println ("Tamar total 73\n");

        System.out.println ("Student results:");
        Ex14.win(array1);
        System.out.println();


    
    
    System.out.println ("********** Question 2 **********\n");
        
        /*test1*/
        int[] arr1 = {6,3,9,1,3};
        int num1 = 22;
        System.out.println ("Test1: arr => {6,3,9,1,3}, num => 22");
        System.out.println ("Expected result => true, Student result = " 
                             + Ex14.what(arr1,num1) + "\n");
                             
                             
                                     System.out.println ("********** Question 3 **********\n");
        
        int[][] mat = {
                            {3,13,15,28,30},
                            {55,54,53,27,26},
                            {54,12,52,51,50},
                            {50,10,8,53,11}
                        };
                        
        int num = 1;
        System.out.println ("Test1: num => 1");
        System.out.println ("Expected result => 6, Student result = " 
                            + Ex14.longestSlope(mat,num) + "\n");

     

/* Tester Question 4 */
        
        System.out.println ("********** Question 4 **********\n");
        
        System.out.println("Test: Checking method 'howManySorted' on n=3 and max=2");
        System.out.println("Expected result = 4, Student result = " 
                            + Ex14.howManySorted(3,2) + "\n");
                                  



}




}