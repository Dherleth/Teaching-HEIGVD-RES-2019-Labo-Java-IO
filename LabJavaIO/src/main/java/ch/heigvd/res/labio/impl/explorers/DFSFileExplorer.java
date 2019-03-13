package ch.heigvd.res.labio.impl.explorers;

import ch.heigvd.res.labio.interfaces.IFileExplorer;
import ch.heigvd.res.labio.interfaces.IFileVisitor;
import java.io.File;

/**
 * This implementation of the IFileExplorer interface performs a depth-first
 * exploration of the file system and
 * a. invokes the visitor for every encountered node (file and directory).
 * b. When the explorer reaches a directory, it visits all
 * files in the directory and then moves into the subdirectories.
 * 
 * @author Olivier Liechti
 */
public class DFSFileExplorer implements IFileExplorer {

  @Override
  public void explore(File rootDirectory, IFileVisitor visitor) {
    // a.
    visitor.visit(rootDirectory);

    // List of all the nodes in rootDirectory
    File[] nodes = rootDirectory.listFiles();

    if (nodes != null) {
      // We are in a directory -> b.
      for (File node : nodes) {
        if (node.isFile()) {
          visitor.visit(node);
        } else {
          explore(node, visitor);
        }
      }
    }

  }
}
