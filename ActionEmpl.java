/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import java.util.ArrayList;


public interface ActionEmpl<T, T1, T2> extends Action<T>{
    public Object add(ArrayList<T> list , ArrayList<T1> list2, ArrayList<T2> list3);
    public boolean edit(ArrayList<T> list , ArrayList<T1> list2, ArrayList<T2> list3);
    public boolean delete(ArrayList<T> list );
    public void show(ArrayList<T> list );
    public void search(ArrayList<T> list );
}
