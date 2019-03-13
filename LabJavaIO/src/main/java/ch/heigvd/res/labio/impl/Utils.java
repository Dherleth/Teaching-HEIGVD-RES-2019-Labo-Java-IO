package ch.heigvd.res.labio.impl;

import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments.
   *
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {
    String windowsReturn = "\r\n";
    String macOSReturn = "\r";
    String unixReturn = "\n";
    int endOfLine = 0;
    String[] response = new String[2];

    // We prepare the default response, when there is no line separator
    response[0] = "";
    response[1] = lines;


    // Finds which kind of return we have
    if ((endOfLine = lines.indexOf(windowsReturn)) > 0) {
      endOfLine += 2;
    } else if (((endOfLine = lines.indexOf(macOSReturn)) > 0) || ((endOfLine = lines.indexOf(unixReturn)) > 0)) {
      endOfLine += 1;
    }

    // We prepare the response isolating the next line
    if (endOfLine > 0) {
      response[0] = lines.substring(0, endOfLine);
      response[1] = lines.substring(endOfLine);
    }

    return response;
  }
}
