/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;
import java.util.ArrayList;
/*Pham Lam Thai */
public interface Action<T> {
    public Object add(ArrayList<T> list);
    public boolean edit(ArrayList<T> list);
    public boolean delete(ArrayList<T> list);
    public void show(ArrayList<T> list);
    public void search(ArrayList<T> list);
    public boolean checkID(ArrayList<T> list, String id);
}
