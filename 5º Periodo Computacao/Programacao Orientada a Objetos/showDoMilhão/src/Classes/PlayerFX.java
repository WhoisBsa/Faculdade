/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author hemilio
 */
public class PlayerFX {
    
    Clip clip;
    
    public void playFX(String valor){
        String source = "./src/audio/" + valor + ".wav";
        
        if(valor == "tema"){
            try{
                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File(source)));
                clip.start();
                clip.loop(-1);
            }
            catch (Exception exc){
                exc.printStackTrace(System.out);
            }
        }
 
        else{
            try{
                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File(source)));
                //clip.open(AudioSystem.getAudioInputStream("/src/audio/sample.wav"));
                clip.start();
                //clip.loop(1);
            }
            catch (Exception exc){
                exc.printStackTrace(System.out);
            }
        }
        
        
    }
    
    public void stopFX(){
        clip.stop();
    }
}


        
       