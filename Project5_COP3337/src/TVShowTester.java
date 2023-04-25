/*
 * Author: Samuel Casto
 * TVShowTester is a program that will read a csv file, store the values of the csv
 * file into tvshow objects, and then sort through the array of tv shows using various
 * sort methods
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TVShowTester {

	public static TVShow[] sortNames(TVShow[] source, int order)
	{

		TVShow[] dest = new TVShow[ source.length ];

		if (order == 1)//ascending order
		{ 
			for ( int i = 0 ; i < source.length ; i++ )
			{
				TVShow next = source[ i ];
				int insertindex = 0;
				int k = i;
				while ( k > 0 && insertindex == 0 )
				{
					if ( next.getName().compareTo(dest[ k - 1 ].getName()) > 0 )
					{
						insertindex = k;
					}
					else
					{
						dest[ k ] = dest[ k - 1 ];
					}
					k--;
				}

				dest[ insertindex ] = next;
			} // end of for
		}
		else if (order == 2)//descending order
		{
			for ( int i = 0 ; i < source.length ; i++ )
			{
				TVShow next = source[ i ];
				int insertindex = 0;
				int k = i;
				while ( k > 0 && insertindex == 0 )
				{
					if ( next.getName().compareTo(dest[ k - 1 ].getName()) < 0)
					{
						insertindex = k;
					}
					else
					{
						dest[ k ] = dest[ k - 1 ];
					}
					k--;
				}

				dest[ insertindex ] = next;
			} // end of for
		}
		return dest;
	} 

	public static TVShow[] sortNumOfSeasons(TVShow[] source, int order){

		TVShow[] dest = new TVShow[ source.length ];

		if (order == 1) //ascending order
		{ 
			for ( int i = 0 ; i < source.length ; i++ )
			{
				TVShow next = source[ i ];
				int insertindex = 0;
				int k = i;
				while ( k > 0 && insertindex == 0 )
				{
					if ( next.getNumOfSeasons() > dest[ k - 1 ].getNumOfSeasons() )
					{
						insertindex = k;
					}
					else
					{
						dest[ k ] = dest[ k - 1 ];
					}
					k--;
				}

				dest[ insertindex ] = next;
			} // end of for
		}
		else if (order == 2)//descending order
		{
			for ( int i = 0 ; i < source.length ; i++ )
			{
				TVShow next = source[ i ];
				int insertindex = 0;
				int k = i;
				while ( k > 0 && insertindex == 0 )
				{
					if ( next.getNumOfSeasons() < dest[ k - 1 ].getNumOfSeasons())
					{
						insertindex = k;
					}
					else
					{
						dest[ k ] = dest[ k - 1 ];
					}
					k--;
				}

				dest[ insertindex ] = next;
			} // end of for
		}
		return dest; 
	}
	public static void sortYearPremiered(TVShow[] source, int order)
	{
		int i;
		int k;
		int posmax;
		TVShow temp;

		if (order == 1)
		{ 
			for ( i = source.length - 1 ; i >= 0 ; i-- )
			{
				// find largest element in the i elements
				posmax = 0;
				for ( k = 0 ; k <= i ; k++ )
				{
					if ( source[ k ].getYearPremiered() > source[ posmax ].getYearPremiered() )
						posmax = k;
				}
				// swap the largest with the position i
				// now the item is in its proper location 
				temp = source[ i ];
				source[ i ] = source[posmax ];
				source[ posmax ] = temp;
			}
		}
		else if (order == 2)
		{
			for ( i = source.length - 1 ; i >= 0 ; i-- )
			{
				// find largest element in the i elements
				posmax = 0;
				for ( k = 0 ; k <= i ; k++ )
				{
					if ( source[ k ].getYearPremiered() < source[ posmax ].getYearPremiered() )
						posmax = k;
				}
				// swap the largest with the position i
				// now the item is in its proper location 
				temp = source[ i ];
				source[ i ] = source[posmax ];
				source[ posmax ] = temp;
			}
		}
	}

	public static void sortGenre(TVShow[] source, int order)
	{
		int i;
		int k;
		int posmax;
		TVShow temp;

		if (order == 1)
		{ 
			for ( i = source.length - 1 ; i >= 0 ; i-- )
			{
				// find largest element in the i elements
				posmax = 0;
				for ( k = 0 ; k <= i ; k++ )
				{
					if ( source[ k ].getGenre().compareTo(source[ posmax ].getGenre()) > 0 )
						posmax = k;
				}
				// swap the largest with the position i
				// now the item is in its proper location 
				temp = source[ i ];
				source[ i ] = source[posmax ];
				source[ posmax ] = temp;
			}
		}
		else if (order == 2)
		{
			for ( i = source.length - 1 ; i >= 0 ; i-- )
			{
				// find largest element in the i elements
				posmax = 0;
				for ( k = 0 ; k <= i ; k++ )
				{
					if ( source[ k ].getGenre().compareTo(source[ posmax ].getGenre()) < 0 )
						posmax = k;
				}
				// swap the largest with the position i
				// now the item is in its proper location 
				temp = source[ i ];
				source[ i ] = source[posmax ];
				source[ posmax ] = temp;
			}
		}
	}

	public static void sortNetwork(TVShow[] a, int low, int high)
	{
		if ( low == high )
			return;

		int mid = ( low + high ) / 2;

		sortNetwork( a, low, mid ); 
		sortNetwork( a, mid + 1, high); 

		mergeNetwork( a, low, mid, high);
	}   

	public static void mergeNetwork( TVShow[] a, int low, int mid, int high )
	{
		TVShow[] temp = new TVShow[ high - low + 1 ];

		int i = low, j = mid + 1, n = 0;

		while ( i <= mid || j <= high )
		{
			if ( i > mid )
			{
				temp[ n ] = a[ j ];
				j++;
			}
			else if ( j > high )
			{
				temp[ n ] = a[ i ];
				i++;
			}
			else if ( a[ i ].getNetwork().compareTo(a[ j ].getNetwork()) < 0 )
			{
				temp[ n ] = a[ i ];
				i++;
			}
			else
			{
				temp[ n ] = a[ j ];
				j++;
			}
			n++;
		}

		for ( int k = low ; k <= high ; k++ )
			a[ k ] = temp[ k - low ];

	} // end of merge


	public static void sortEpisodes(TVShow[] a, int low, int high)
	{
		if ( low == high )
			return;

		int mid = ( low + high ) / 2;

		sortEpisodes( a, low, mid ); 
		sortEpisodes( a, mid + 1, high); 

		mergeEpisodes( a, low, mid, high);
	}
	public static void mergeEpisodes( TVShow[] a, int low, int mid, int high )
	{
		TVShow[] temp = new TVShow[ high - low + 1 ];

		int i = low, j = mid + 1, n = 0;

		while ( i <= mid || j <= high )
		{
			if ( i > mid )
			{
				temp[ n ] = a[ j ];
				j++;
			}
			else if ( j > high )
			{
				temp[ n ] = a[ i ];
				i++;
			}
			else if ( a[ i ].getNumOfEpisodes() > a[ j ].getNumOfEpisodes() )
			{
				temp[ n ] = a[ i ];
				i++;
			}
			else
			{
				temp[ n ] = a[ j ];
				j++;
			}
			n++;
		}

		for ( int k = low ; k <= high ; k++ )
			a[ k ] = temp[ k - low ];

	} // end of merge 

	//sequential search one
	public static void findSeasons(TVShow[] source, int value)
	{
		System.out.println("Shows that lasted " + value + " seasons.");
		int i;
		for(i=0;i<source.length;i++) {
			if(source[i].getNumOfSeasons() == value) {
				//true value so we need to print out the value of source[i]
				System.out.println(source[i].getName() + " premiered in " + source[i].getYearPremiered() +
						" and lasted for " +source[i].getNumOfSeasons() + " on " + source[i].getNetwork() + " network.");
			}
		}


	}
	//sequential search two
	public static void findEpisodes(TVShow[] source, int value)
	{
		System.out.println("Shows that had more than " + value + " episodes.");
		int i;
		for(i=0;i<source.length;i++) {
			if(source[i].getNumOfEpisodes() > value) {
				//true value so we need to print out the value of source[i]
				System.out.println(source[i].getName() +" had " +source[i].getNumOfSeasons() + " seasons "
						+ "for " + source[i].getNumOfEpisodes() + " episodes.");
			}
		}


	}
	//binary search one which has us trying to use equals/comparesto to sort lol
	public static int binarySearchNetwork(TVShow[] source, String value) {
		int low = 0;
		int high = source.length - 1;
		int count = 0;
		while (high >= low) {
			count++;
			int mid = (high + low) / 2;
			if(value.equals(source[mid].getNetwork())){
				System.out.println("We counted " + count + " shows.");
				return mid;
			}
			else if(value.compareTo(source[mid].getNetwork()) < 1) {
				high = mid - 1;
			}
			else
				low = mid + 1;
			
		}
		
		return -1 - low;
	}

	//binary search two which is comparing strings again lol
	public static int binarySearchGenre(TVShow[] source, String value) {
		int low = 0;
		int high = source.length - 1;
		int count = 0;
		while (high >= low) {
			count++;
			int mid = (high + low) / 2;
			if(value.equals(source[mid].getGenre())){
				System.out.println("We counted " + count + " shows.");
				return mid;
			}
			else if(value.compareTo(source[mid].getGenre()) < 1) {
				high = mid - 1;
			}
			else
				low = mid + 1;
			
		}
		
		return -1 - low;
	}
	//binary helper
	public static void binaryOneLeftHelper(TVShow[] source, int index) {
		int value = index - 1;
		if(source[index].getNetwork().equals(source[value].getNetwork())) {
			//means the value to the "left" is true and matches
			binaryOneLeftHelper(source, value);
			//printing the other shows
			System.out.println(source[value].getName() + " also aired on " + source[value].getNetwork() + ".");
		}
	}
	public static void binaryOneRightHelper(TVShow[] source, int index) {
		int value = index + 1;
		if(source[index].getNetwork().equals(source[value].getNetwork())) {
			//means the value to the "left" is true and matches
			binaryOneLeftHelper(source, value);
			//printing the other shows
			System.out.println(source[value].getName() + " also aired on " + source[value].getNetwork() + ".");
		}
	}
	public static void binaryTwoLeftHelper(TVShow[] source, int index) {
		int value = index - 1;
		if(source[index].getGenre().equals(source[value].getGenre())) {
			//means the value to the "left" is true and matches
			binaryOneLeftHelper(source, value);
			//printing the other shows
			System.out.println(source[value].getName() + " is also of the " + source[value].getGenre() + " genre.");
		}
	}
	public static void binaryTwoRightHelper(TVShow[] source, int index) {
		int value = index + 1;
		if(source[index].getGenre().equals(source[value].getGenre())) {
			//means the value to the "left" is true and matches
			binaryOneLeftHelper(source, value);
			//printing the other shows
			System.out.println(source[value].getName() + " is also of the " + source[value].getGenre() + " genre.");
		}
	}
	public static TVShow[] sortMaleLead(TVShow[] source, int order)
	{

		TVShow[] dest = new TVShow[ source.length ];

		if (order == 1)//ascending order
		{ 
			for ( int i = 0 ; i < source.length ; i++ )
			{
				TVShow next = source[ i ];
				int insertindex = 0;
				int k = i;
				while ( k > 0 && insertindex == 0 )
				{
					if ( next.getMaleLead().compareTo(dest[ k - 1 ].getMaleLead()) > 0 )
					{
						insertindex = k;
					}
					else
					{
						dest[ k ] = dest[ k - 1 ];
					}
					k--;
				}

				dest[ insertindex ] = next;
			} // end of for
		}
		else if (order == 2)//descending order
		{
			for ( int i = 0 ; i < source.length ; i++ )
			{
				TVShow next = source[ i ];
				int insertindex = 0;
				int k = i;
				while ( k > 0 && insertindex == 0 )
				{
					if ( next.getMaleLead().compareTo(dest[ k - 1 ].getMaleLead()) < 0)
					{
						insertindex = k;
					}
					else
					{
						dest[ k ] = dest[ k - 1 ];
					}
					k--;
				}

				dest[ insertindex ] = next;
			} // end of for
		}
		return dest;
	}
	
	public static TVShow[] sortFemaleLead(TVShow[] source, int order)
	{

		TVShow[] dest = new TVShow[ source.length ];

		if (order == 1)//ascending order
		{ 
			for ( int i = 0 ; i < source.length ; i++ )
			{
				TVShow next = source[ i ];
				int insertindex = 0;
				int k = i;
				while ( k > 0 && insertindex == 0 )
				{
					if ( next.getFemaleLead().substring(0,0).compareTo(dest[ k - 1 ].getFemaleLead().substring(0, 0)) > 0 )
					{
						insertindex = k;
					}
					else
					{
						dest[ k ] = dest[ k - 1 ];
					}
					k--;
				}

				dest[ insertindex ] = next;
			} // end of for
		}
		else if (order == 2)//descending order
		{
			for ( int i = 0 ; i < source.length ; i++ )
			{
				TVShow next = source[ i ];
				int insertindex = 0;
				int k = i;
				while ( k > 0 && insertindex == 0 )
				{
					if (  next.getFemaleLead().substring(0,1).compareTo(dest[ k - 1 ].getFemaleLead().substring(0, 1)) < 0)
					{
						insertindex = k;
					}
					else
					{
						dest[ k ] = dest[ k - 1 ];
					}
					k--;
				}

				dest[ insertindex ] = next;
			} // end of for
		}
		return dest;
	}



	public static void main(String[] args) throws FileNotFoundException {
		//declaring variables for main
		Scanner scnr = new Scanner(new File("tv_shows.csv")); //loading the scanner with our file to parse
		TVShow[] shows = new TVShow[20]; //array to hold our tv shows
		String line = "";
		int value = -1;
		scnr.useDelimiter(",");

		//skipping our header line in the csv
		line = scnr.nextLine();

		//loop for parsing csv into TVShow objects in the array shows.length
		for(int i = 0;i < shows.length;i++) {
			//since we know the order of the csv we can hardcode each scnr.next()
			shows[i] = new TVShow();
			shows[i].setName(scnr.next());
			shows[i].setYearPremiered(Integer.parseInt(scnr.next()));
			shows[i].setNumOfSeasons(Integer.parseInt(scnr.next()));
			shows[i].setNumOfEpisodes(Integer.parseInt(scnr.next()));
			shows[i].setNetwork(scnr.next());
			shows[i].setGenre(scnr.next());
			shows[i].setMaleLead(scnr.next());
			shows[i].setFemaleLead(scnr.nextLine());
			//there's a pesky comma we need to get rid of
			shows[i].setFemaleLead(shows[i].getFemaleLead().substring(1));
		}

		//sorting methods
		shows = sortNames(shows, 1);//number 1
		for(int i =0;i<shows.length;i++) {
			System.out.println(shows[i].getName() + ", " + shows[i].getYearPremiered() + ", " +
								shows[i].getMaleLead() + ", " + shows[i].getFemaleLead());
		}
		System.out.println();
		shows = sortNumOfSeasons(shows, 2);//number 2
		for(int i =0;i<shows.length;i++) {
			System.out.println(shows[i].getName() + ", " + shows[i].getYearPremiered() + ", " +
								shows[i].getNumOfSeasons());
		}
		System.out.println();
		sortYearPremiered(shows, 1);//number 3
		for(int i =0;i<shows.length;i++) {
			System.out.println(shows[i].getName() + ", " + shows[i].getYearPremiered() + ", " +
								shows[i].getNumOfSeasons());
		}
		System.out.println();
		sortGenre(shows, 2);//number 4
		for(int i =0;i<shows.length;i++) {
			System.out.println(shows[i].getName() + ", " + shows[i].getNumOfEpisodes() + ", " + shows[i].getGenre());
		}
		System.out.println();
		sortNetwork(shows, 0, shows.length - 1);//number 5
		for(int i =0;i<shows.length;i++) {
			System.out.println(shows[i].getName() + ", " + shows[i].getYearPremiered() + ", " +
								shows[i].getNumOfSeasons() + ", " + shows[i].getNetwork());
		}
		System.out.println();
		sortEpisodes(shows, 0, shows.length - 1);//number 6
		for(int i =0;i<shows.length;i++) {
			System.out.println(shows[i].getName() + ", " + shows[i].getYearPremiered() + ", " +
								shows[i].getNumOfSeasons() + ", " + shows[i].getNetwork());
		}
		findSeasons(shows, 2);//number 7
		for(int i =0;i<shows.length;i++) {
			System.out.println(shows[i].getName() + ", " + shows[i].getYearPremiered() + ", " +
								shows[i].getNumOfSeasons() + ", " + shows[i].getNetwork());
		}
		findEpisodes(shows, 100);//number 8
		for(int i =0;i<shows.length;i++) {
			System.out.println(shows[i].getName() + ", " + shows[i].getYearPremiered() + ", " +
								shows[i].getNumOfSeasons() + ", " + shows[i].getNetwork());
		}
		System.out.println();
		sortNetwork(shows, 0, shows.length - 1);//binary 1
		value = binarySearchNetwork(shows, "CBS");//binary 1
		System.out.println(shows[value].getName() + " aired on CBS.");
		binaryOneLeftHelper(shows, value);
		binaryOneRightHelper(shows, value);
		System.out.println();
		sortGenre(shows, 1);
		value = binarySearchGenre(shows, "Fantasy");
		System.out.println(shows[value].getName() + " is of the " + shows[value].getGenre() + " genre.");
		binaryTwoLeftHelper(shows, value);
		binaryTwoRightHelper(shows, value);
		System.out.println();
		
		//bonus questions
		sortMaleLead(shows, 1);
		for(int i = 0;i<shows.length;i++) {
			System.out.println(shows[i]);
		}
		System.out.println();
		sortFemaleLead(shows, 2);
		for(int i = 0;i<shows.length;i++) {
			System.out.println(shows[i]);
		}
	}

}