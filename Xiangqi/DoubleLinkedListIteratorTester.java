import org.junit.*;
import static org.junit.Assert.*;
import java.util.Iterator;

/*test methods in DoubleLinkedListIterator class
 * */

public class DoubleLinkedListIteratorTester{
  
  /**test hasNext method
    * */
  @Test
  public void testHasNext(){
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    DoubleLinkedListIterator<Integer> it = list.iterator();
    assertFalse("Testing whether it works when there is a empty list",it.hasNext());
    it.add(1);
    assertTrue("Testing whether it works when there is a element in list",it.hasNext());
  }
  
  /**test hasPrevious method
   * */
  @Test
  public void testHasPrevious(){
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    DoubleLinkedListIterator<Integer> it = list.iterator();
    it.add(1);
    assertFalse("Testing whether it works when there is only one element in list",it.hasPrevious());
    it.add(2);
    assertTrue("Testing whether it works when there is two elements in list",it.hasPrevious());
  }
  
  /**test next method
    * */
  @Test
  public void testNext(){
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    DoubleLinkedListIterator<Integer> it = list.iterator();
    it.add(1);
    int r = it.next();
    assertEquals("Testing whether next works",1,r);
  }
  
  /**test previous method
    * */
  @Test
  public void testPrevious(){
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    DoubleLinkedListIterator<Integer> it = list.iterator();
    it.add(1);
    try{
      it.previous();
      fail("No previous element");
    }
    catch (java.util.NoSuchElementException e) {
      /* everything is good */
    }
    catch (Exception e) {
      fail("call previous() while there is no previous element threw the wrong type of exception.");
    }
    it.add(2);
    int r = it.previous();
    assertEquals("Testing whether previous works",2,r);
  }
  
  /**test add method
    * */
  @Test
  public void testAdd(){
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    DoubleLinkedListIterator<Integer> it = list.iterator();
    try{
      it.next();
      fail("No next element");
    }
    catch (java.util.NoSuchElementException e) {
      /* everything is good */
    }
    catch (Exception e) {
      fail("call next() while there is no element in the list threw the wrong type of exception.");
    }
    it.add(1);
    int r1 = list.getFront().getElement();
    assertEquals("Testing add element into an empty list",1,r1);
    it.next();
    it.add(2);
    int r2 = list.getBack().getElement();
    assertEquals("Testing add element in the end of the list",2,r2);

  }
  
  /**test helper method getNodeptr
    * */
  @Test
  public void testGetNodeptr(){
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    DoubleLinkedListIterator<Integer> it = list.iterator();
    it.add(1);
    int r1 = it.getNodeptr().getElement();
    assertEquals("Testing whether the value returned by get-method is right",1,r1);
  }
  
}
  
  
    