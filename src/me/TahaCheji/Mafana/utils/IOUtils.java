package me.TahaCheji.Mafana.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@SuppressWarnings({ "unused" })
public class IOUtils {
  
  

  public static void closeQuietly(InputStream paramCloseable) {
	  try {
		  if (paramCloseable != null)
			  paramCloseable.close(); 
	    	} catch (IOException iOException) {
	    		
	    	}
	  	}
	  
  public static void closeQuietly(OutputStream paramCloseable) {
	  try {
		  if (paramCloseable != null)
			  paramCloseable.close(); 
	    	} catch (IOException iOException) {
	    		
	   	}
  }
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
    long l = copyLarge(paramInputStream, paramOutputStream);
    if (l > 2147483647L)
      return -1; 
    return (int)l;
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
    return copyLarge(paramInputStream, paramOutputStream, new byte[4096]);
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfbyte) throws IOException {
    long l = 0L;
    int i = 0;
    while (-1 != (i = paramInputStream.read(paramArrayOfbyte))) {
      paramOutputStream.write(paramArrayOfbyte, 0, i);
      l += i;
    } 
    return l;
  }
  
  
  
  
}

