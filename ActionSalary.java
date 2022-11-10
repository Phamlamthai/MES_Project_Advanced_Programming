/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;
import java.util.ArrayList;
/**
 *
 * @author Lenovo T460s
 */
public interface ActionSalary <T, T1> extends Action<T>{
    public Object add(ArrayList<T> list, ArrayList<T1> list2);
    public boolean edit(ArrayList<T> list, ArrayList<T1> list2);
   
}
