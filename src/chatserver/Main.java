/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.IOException;

/**
 *
 * @author RYU
 */
public class Main {

    public static void main(String args[]) throws IOException {

        /*Create new ChatServer object and run serve method.*/
        ChatServer cs = new ChatServer();
        System.out.println("Chat Started");

        cs.serve();

    }
}