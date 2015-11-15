/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.yrgo.java15.timlanghans.timstoolsproj.graphicTools;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Creates a copy of a java.awt.BufferedImage
 * 
 * @author Tim Langhans , se.yrgo.java15
 * 
 * 2015-11-15
 */
public class ImageTools {
        
    public static BufferedImage copyImage( BufferedImage source ) {
        BufferedImage b = new BufferedImage(
                source.getWidth(),
                source.getHeight(), 
                source.getType());
        Graphics g = b.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return b;
    }
    
    
}
