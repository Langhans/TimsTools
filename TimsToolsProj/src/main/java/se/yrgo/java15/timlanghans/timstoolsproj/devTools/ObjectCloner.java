package se.yrgo.java15.timlanghans.timstoolsproj.devTools;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



/**
 *  Adapted from  http://www.javaworld.com/ , java-tip-76
 *  
 *  Performes a deep clone of every object and its object-tree as long as they 
 *  implements Serializable or Externalizable. This implementation makes use 
 *  of a sequential serialization and deserialization with 
 *  java.io.ObjectInputStream and java.io.ObjectOutputStream which does the job 
 *  of deep-cloning the object-tree for the user.
 * 
 * @author tim langhans ,se.yrgo.java15
 * 
 * 2015-11-15
 */
public class ObjectCloner {
  
  
  public static Object cloneDeep( Object obj) throws NotSerializableException{
  
    if (obj == null  ){
     throw new IllegalArgumentException("Object may not be null!");
    }   
    
    ByteArrayOutputStream ba_out;
    ObjectOutputStream o_out;
  
    ByteArrayInputStream ba_in;
    ObjectInputStream o_in;
    
    try{
      
      ba_out = new ByteArrayOutputStream();
      o_out = new ObjectOutputStream(ba_out);
      o_out.writeObject( obj );
      o_out.flush();
      
      ba_in = new ByteArrayInputStream(ba_out.toByteArray());
      o_in = new ObjectInputStream(ba_in);
     return  o_in.readObject();
      
    } catch (Exception e){
      e.printStackTrace();
      throw new RuntimeException("ObjectCloner.cloneDeep(): "
              + "Serious error occured!");
    }  
  }
}