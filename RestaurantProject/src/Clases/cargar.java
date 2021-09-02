/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JProgressBar;

/**
 *
 * @author nahs1
 */
public class cargar extends Thread {
    JProgressBar BarraProgreso;
    
    public cargar(JProgressBar BarraProgreso){
        super();
        this.BarraProgreso = BarraProgreso; 
    }
    @Override
    public void run(){
        for (int i = 1; i <= 100; i++) {
            BarraProgreso.setValue(i);
            pausa(30);
        }
    }
    public void pausa(int mlSeg){
        try {
            Thread.sleep(mlSeg);
        }
        catch(Exception e){
            
        }
    }
    
}
