
/* DriverIntroToJava
 *
 * Class to intro running programs on the lab machines
 */
public class DriverIntroToJava 
{
  public static void main(String[] args)
  {
    makeAndPrintArray( 5, 5 );
    makeAndPrintArray( 5, 10 );
    makeAndPrintArray( 10, 5 );
  }
  
  public static void makeAndPrintArray( int length, int width )
  {
    int[][] arrayData = new int[length][width];

    System.out.printf( "(%d, %d)\n", length, width );
    fillArray( arrayData );
    printArray( arrayData );
  }  

  /* Fills the 2d Array */
  public static void fillArray( int[][] arrayData ) 
  {
    int i, j;

    for(i = 0; i < arrayData.length; i++)
    {
      for(j = 0; j < arrayData[i].length; j++)
      {
        if( (i+j)%2==0 )
          arrayData[i][j] = arrayData.length;
        else
          arrayData[i][j] = arrayData[i].length;
      }
    }
  }
  
  /* Prints the 2d Array */
  public static void printArray( int[][] arrayData )
  {
    int i, j;

    for(i = 0; i < arrayData.length; i++)
    {
      for(j = 0; j < arrayData.length; j++)//JESS: Logic error on this line
      {
        System.out.printf("%-7d", arrayData[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  }
}
