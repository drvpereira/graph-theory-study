
package br.ufrn.info.graph.domain;
import java.util.*;

/**
 * Classe que implementa uma estrutura de dados 
 * do tipo FIFO (First In, First Out). 
 *  
 * @author David
 * 
 */
public class Queue {

    private Vector queue;

    public Queue ()  {
        queue = new Vector();
    }

    public Queue (int initialSize) {
         if (initialSize >= 1) {
             queue = new Vector(initialSize);
         } else {
             queue = new Vector();
         }
     }

    /**
     * Insere um item na fila.
     * @param item Objeto a ser inserido na fila.
     */
    public void enQueue (Object item) {
        queue.addElement(item);
    }

    /**
     * Retorna o primeiro elemento da fila.
     * @return Primeiro elemento da fila.
     */
    public Object front () {
        return queue.firstElement();
    }

    /**
     * Retira um elemento da fila. 
     * @return Objeto retirado da fila.
     */    
    public Object deQueue () {
        Object obj = null;

       if (!queue.isEmpty()) {
            obj = front();
           queue.removeElement(obj);
       }

        return obj;
    }

    /**
     * Informa se a fila está vazia ou não.
     * @return true se estiver vazia, false se não estiver.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Retorna o tamanho da fila.
     * @return Tamanho da fila.
     */
    public int size() {
         return queue.size();
     }

    /**
     * Retorna a quantidade de posições disponíveis na fila.
     * @return número de posições livres na fila.
     */
     public int availableRoom() {
         return (queue.capacity() - queue.size());
     }

    /**
     * Retira um nó da fila e o converte para String
     * @return Representação em String do nó retirado.
     */
     public String deQueueString() {
         Object obj = deQueue();
         if (obj != null)
             return obj.toString();

         return  " ";
     }

     /**
      * Imprime os elementos da fila sem retirar nenhum deles. 
      */
     public void printQueue() {

         Enumeration e = queue.elements();
         String str;
         while (e.hasMoreElements()) {
             str = e.nextElement().toString();
             System.out.print(str + " ");
         }
         System.out.println();
     }

}
