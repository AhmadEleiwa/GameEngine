import static org.lwjgl.opengl.GL11.*;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;



public class Lines {
    
    private int[] buffer= new int[2];
    public Model model;
    public int texture;

    private final float[] verticesCube={
        0,0,-5000,1,0,0,
        0,0,5000, 1,0,0,
        0,-5000,0,0,1,0,
        0,5000,0, 0,1,0,
        -5000,0,0,0,0,1,
        5000,0,0, 0,0,1
        };

    public Lines(){    

            model = new Model(EngineController.pushPorgram("defualt"), "model");

            buffer = EngineController.pushBuffer("lines");
            
            glBindVertexArray(buffer[0]);
            glBindBuffer(GL_ARRAY_BUFFER, buffer[1]);
            glBufferData(GL_ARRAY_BUFFER, verticesCube, GL_STATIC_DRAW);

            glVertexAttribPointer(0, 3, GL_FLOAT, false, 6*4, 0);
            glEnableVertexAttribArray(0);


            glVertexAttribPointer(1, 3, GL_FLOAT, false, 6*4, 3*4);
            glEnableVertexAttribArray(1);


           
    }



    public void draw(){
        model.sendMatrix();
        // glBindTexture(GL_TEXTURE_2D, texture);
        glBindVertexArray(buffer[0]);
        glDrawArrays(GL_LINES, 0, 6);
        
    }
}