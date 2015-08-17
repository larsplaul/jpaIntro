
package test;

import javax.persistence.Persistence;


public class creater {
    
    public static void main(String[] args) {
      Persistence.generateSchema("Jpa1PU", null);
    }
}
