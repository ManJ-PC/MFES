package Stack2;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class StackTest {
  private Stack s = new Stack(4L);

  private void assertTrue(final Boolean cond) {

    return;
  }

  private void testPushPop() {

    s.clear();
    s.push(1L);
    s.push(2L);
    assertTrue(Utils.equals(s.top(), 2L));
    s.pop();
    assertTrue(Utils.equals(s.top(), 1L));
    s.pop();
  }

  public static void main() {

    new StackTest().testPushPop();
  }

  public StackTest() {}

  public String toString() {

    return "StackTest{" + "s := " + Utils.toString(s) + "}";
  }
}
