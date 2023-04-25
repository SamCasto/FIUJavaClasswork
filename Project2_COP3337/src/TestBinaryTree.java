public class TestBinaryTree 
{ 
     public static void main(String args[]) 
    { 
    	String arr[] = {"listen", "the", "quick", "brown", "fox", "jumped", "over", "lazy", "dogs"};
      	
    	System.out.println("Binary Tree Example"); 
    	BinaryTree tree = new BinaryTree();
        Node root = new Node(new Data(arr[0], " - "));
        
        System.out.print("Building tree with root value [" + root.value.getWord());
        System.out.println("] " + root.value.getMeaning() );
        
        for (int i = 1; i < arr.length; i++)
        	tree.insert(root, new Data(arr[i], " *** ")); 
 		
 		System.out.println("\nTraversing the tree in order - ascending order" ); 
		tree.inOrder(root);
		System.out.println("\n");
				
		String key = "fox";
		try
		{
			// The result from this method (contains) might be incorrect since the code is incomplete
			System.out.println("\nThe value [" + key + "] is in the tree: " +  tree.contains(root, key));
		}
		catch(NullPointerException e)
		{
			System.out.println("\nThe value [" + key + "] is in the tree: false" );
		}
		
//		root = tree.deleteNode(root, key);
//		tree.inOrder(root);
      }
}