package net.greg.examples.webhook;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public final class SlackEnvoy {

  /**
   * varargs (variable-arity) arguments identical
   * to static arrays, and just as expensive
   */
  public static void main(String ... words) {

    StringBuilder message = new StringBuilder();

    System.err.println("\n\n SlackEnvoy fires ...\n\n");


    Arrays.asList(words).
      stream().
        forEach(word -> message.append(
          word + " [ Streams: Inefficient and Complex ] \n"));


    for (String word : words) {
      message.append(word + " [ Old Way: Efficient ] ");
    }

    // concatenation-coerces-builder-2-String
    SlackHandler.POST(message + "");
  }
}
