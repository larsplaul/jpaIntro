/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import facade.JsonAssembler;

/**
 *
 * @author lam
 */
public class jsonTester {
    public static void main(String[] args) {
        JsonAssembler json = new JsonAssembler();
        System.out.println(json.getUser(1));
    }
    
}
