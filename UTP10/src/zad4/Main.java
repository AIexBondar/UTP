/**
 *
 *  @author Weikert Robert S17092
 *
 */

package zad4;


public class Main {
  public static void main(String[] args) {
	String[] tab = { "Pies", "Kot", "Zebra", "Lew", "Owca", "Słoń", null};
    Author autor = new Author(tab);
    new Thread(autor).start();
    new Thread(new Writer(autor)).start();
  }
}
