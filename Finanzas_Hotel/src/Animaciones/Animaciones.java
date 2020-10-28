/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animaciones;

import AppPackage.AnimationClass;
import javax.swing.JLabel;

/**
 *
 * @author Langas
 */
public class Animaciones 
{
    //Atributos
    AnimationClass ani;
    int posY_Bajar;
    int posY_Subir;
    JLabel seleccionado;
    JLabel cantidad;

    public Animaciones(AnimationClass ani, int posY_Bajar, int posY_Subir, JLabel seleccionado) {
        this.ani = ani;
        this.posY_Bajar = posY_Bajar;
        this.posY_Subir = posY_Subir;
        this.seleccionado = seleccionado;
    }
    
    
    public void Bajar()
    {
        ani = new AnimationClass(); 
        
        posY_Bajar += seleccionado.getY();
        
        if(posY_Bajar == -50)
        {
            seleccionado.setVisible(true);
            ani.jLabelYDown(posY_Bajar,20, 2, 1,seleccionado);
        }
        
        posY_Bajar = 0;
    }
    
    public void Subir()
    {
        ani = new AnimationClass();
        
        posY_Subir += seleccionado.getY();
        
        if(posY_Subir == 20)
        {
          ani.jLabelYUp(posY_Subir,-50, 2, 1,seleccionado);           
        }

        posY_Subir = 0;
    }
    
    
}
