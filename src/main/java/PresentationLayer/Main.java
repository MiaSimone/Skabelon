package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test");
        ArrayList<User> tmp = UserMapper.customerList();
        for(int i = 0; i < tmp.size(); i++) {
            System.out.print(tmp.get(i));
        }
    }
}
