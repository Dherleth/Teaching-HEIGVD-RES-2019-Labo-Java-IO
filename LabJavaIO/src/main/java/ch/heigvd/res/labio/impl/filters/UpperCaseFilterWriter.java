package ch.heigvd.res.labio.impl.filters;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/**
 *
 * @author Olivier Liechti
 */
public class UpperCaseFilterWriter extends FilterWriter {
  
  public UpperCaseFilterWriter(Writer wrappedWriter) {
    super(wrappedWriter);
  }

  @Override
  public void write(String str, int off, int len) throws IOException {
   this.out.write(str.substring(off, off + len).toUpperCase());
  }

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException {
    char[] result = Arrays.copyOfRange(cbuf, off, off + len);

    // We go over each char and upper case them
    for(int i = 0; i < result.length; ++i)
      result[i] = Character.toUpperCase(result[i]);

    this.out.write(result);
  }

  @Override
  public void write(int c) throws IOException {
    this.out.write(Character.toUpperCase(c));
  }
}
