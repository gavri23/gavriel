# gavriel

public static int longestSlope  (int [][] mat, int num){
int i=0;
int j=0;
int max = 1;

//recusive loop
//max(latestMax, longestSlope  ( mat, num,i,j));

loop(mat,num, i,j);

return max;

}

private static int longestSlope  (int [][] mat, int num,int i,int j){
	int max = 0;
	if(i<mat[0].length-1 && mat[i+1][j] == mat[i][j] - num){ //down
		int down = longestSlope(mat,num,i+1,j); ////// DON'T RETURN!!!
		
		
		  max = (down>max) ? down: max;
	}
	if(i==mat[0].length-1 && mat[i][j+1] == mat[i][j] - num){// Why condidion on i if not changed???? also compare wrong side
		int left = longestSlope(mat,num,i,j+1);
		
		max = (left>max) ? left: max;
	}
	
	if(j==mat.length-1 && mat[i][j] == mat[i][j+1] - num){ 
		int right = longestSlope(mat,num,i+1,j);
		
		max = (right>max) ? right: max;
	}
	if( i!=0 && mat[i-1][j] == mat[i][j] - num ){   
		int up = longestSlope(mat,num,i-1,j);
		
		max = (up>max) ? up: max;
	}    
	
	return max+1;
}

private static int loop(int mat [][],int num, int i, int j){// why void and not int??? how do you get answer?
	if(i<mat.length-1){// why skip testing the last row???
		System.out.println(mat[i][j]);
		longestSlope(mat,num,i,j);        
		loop(mat,num,i+1,j);      
	}
	if(i==mat.length){
		System.out.println(mat[i][j]);
		longestSlope(mat,num,i,j); 
		loop(mat,num,0,j+1); //why not just loop(mat,num,0,j+1);
	}
	if(i == mat[0].length-1 && j == mat.length-1){
		return -1 ; // return ma????
	}
        return loop(mat,num,i+1,j);
}   
