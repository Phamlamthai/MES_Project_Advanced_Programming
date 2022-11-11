/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manage;

import Interface.Action;
import Model.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lenovo T460s
 */
public class PositionManage implements Action<Position>{

    @Override
    public Object add(ArrayList<Position> list) {
        Position pos = new Position();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Position ID :  ");
        String posID = sc.nextLine();
        while(checkID(list, posID)){
            System.out.println("Pos ID is valid ...... Please Try again!........");
            posID = sc.nextLine();
        }
        while(posID.contains(" ") || posID.equals(" ")){
            System.out.println("   Not space!  ");
            posID = sc.nextLine();
        }
        pos.setPosID(posID);
        System.out.println("Enter position name: ");
        String posName = sc.nextLine();
        pos.setPosName(posName);
        System.out.println("Enter position Bonus");
        Double posBonus = sc.nextDouble();
        pos.setPosBonus(posBonus);
        return pos;
    }

    @Override
    public boolean edit(ArrayList<Position> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Position ID: ");
        String posID = sc.nextLine();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getPosID().equals(posID)){
                System.out.println("Enter position Name: ");
                String posName = sc.nextLine();
                System.out.println("Enter position Bonus: ");
                Double posBonus = sc.nextDouble();
                list.get(i).setPosName(posName);
                list.get(i).setPosBonus(posBonus);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(ArrayList<Position> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Position ID:  ");
        String posID = sc.nextLine();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getPosID().equals(posID)){
                System.out.println("Do you want to really delete this POSITION? (Y/N) ");
                String choice =sc.nextLine();
                if(choice.equals("Y")){
                    list.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void show(ArrayList<Position> list) {
        for(int i=0;i<list.size();i++){
            System.out.println("Position ID : " + list.get(i).getPosID());
            System.out.println("Position Name : " + list.get(i).getPosName());
            System.out.println("Position Bonus : " + list.get(i).getPosBonus());

        }
    }

    @Override
    public void search(ArrayList<Position> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Position ID : ");
        String posID = sc.nextLine();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getPosID().equals(posID)){
                System.out.println("Position ID : " + list.get(i).getPosID());
                System.out.println("Position Name : " + list.get(i).getPosName());
                System.out.println("Position Bonus : " + list.get(i).getPosBonus());
            }
        }
    }

    @Override
    public boolean checkID(ArrayList<Position> list, String id) {
        for(int i=0;i<list.size();i++){
            if(list.get(i).getPosID().equals(id)){
                return true;
            }
        }
        return false;
    }
    
}
