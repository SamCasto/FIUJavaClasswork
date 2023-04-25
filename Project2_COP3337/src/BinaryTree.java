public class BinaryTree 
{ 
	String s;
	
	public BinaryTree()
	{ 
		s = " ";
	}
       
    public void insert(Node node, Data value) 
    {
		if (value.getWord().compareTo(node.value.getWord()) < 0)
		{ 
			if (node.left != null) 
			{ 
				insert(node.left, value); 
			} 
			else 
			{ 
				s += node.value.getWord() + "  "; 
				System.out.println(" Inserted [" + value.getWord() + "] to left of [" + node.value.getWord()  + "]");
				node.left = new Node(value); 
			} 
		} 
		else if (value.getWord().compareTo(node.value.getWord())  > 0)
		{
			if (node.right != null) 
			{
				insert(node.right, value);
			} 
			else 
			{
				s += node.value.getWord() + "  "; 
				System.out.println(" Inserted [" + value.getWord() + "] to right of [" + node.value.getWord() + "]");
				node.right = new Node(value);
			}
		}
	}
     public void inOrder(Node node) // Ascending order
     {
        if (node != null) 
        {
            inOrder(node.left);
            System.out.print("\n " + node.value.getWord());
            inOrder(node.right);
        }
     }
     
    public boolean contains(Node node, String key)
	{
		// This method is incomplete
		return true;
	}    
     
	public Node deleteNode(Node root, String key)
	{
		// This method is incomplete
		return root;
	}
		//	You may need this helper function to find minimum value node in the subtree rooted at `curr`
	public Node getMinimumKey(Node curr)
	{
		while (curr.left != null) 
		{
			curr = curr.left;
		}
		return curr;
	}

	public String toString()
	{
		return s;
	}
}