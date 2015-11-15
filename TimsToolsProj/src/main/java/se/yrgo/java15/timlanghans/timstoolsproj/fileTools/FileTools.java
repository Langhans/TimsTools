/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.yrgo.java15.timlanghans.timstoolsproj.fileTools;

import java.util.List;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author timlanghans
 */
public class FileTools {

  /**
   * crawls recursively through a file-structure, parent and all child nodes in
   * file-tree, and saves the files to a java.util.List of File.
   *
   * @author: Tim Langhans , YRGO Göteborg, class Java15 
   * @return: List of File - list of all files in parents directory and
   * subdirectories , throws IllegalArgumentException if input-parameter parent
   * is null!
   * @invar: File parent may not be null => IllegalArguementException!
   *
   */
  public static List<File> crawlSubfilesAndExtractToList(File parent) {
    List<File> files = new ArrayList<File>();

    return fileCrawl(parent, files);
  }
  
  // helpfunction for crawlSubfilesAndExtractToList()
  private static List<File> fileCrawl(File parent, List<File> files) {

    assert parent != null;
    if (parent == null) {
      throw new IllegalArgumentException("File parent may not be null!");
    }

    File[] fs;

    if (parent.isDirectory()) {
      fs = parent.listFiles();
      // recursion base case
      if (fs == null) {
        return files;
      
      } else {

        for (File f : fs) {
          
          if (f.isDirectory()) {
            fileCrawl(f, files);
            
          } else if (f.isFile()) {
            files.add(f);
            
          } else {
            throw new IllegalStateException("Element neither a file"
                    + " nor a directory!");
          }
        }
        return files;
      }
    } else if (parent.isFile()) {
      files.add(parent);
      return files;
    }
    return null;
  }

  
  /**
   * Method to find the absolute path of a specific Class, i.e. for beeing able
   * to use external file resources from an application running from a .jar
   * file.
   *
   * @param clazz Class you want to get the absolute path to
   * @return String of absolute path to the Class from input parameter
   * @warning does not check for possible Exceptions, may return null!
   */
  public static String findSource(Class<?> clazz) {
    
    String resourcesPath = '/' + clazz.getName().replace(".", "/") + ".class";
    URL location = clazz.getResource(resourcesPath);
    String sourcePath = location.getPath();
    String finalPath = sourcePath.replace("file:", "").replace("!" + resourcesPath, "");
    return finalPath;
  }

}
