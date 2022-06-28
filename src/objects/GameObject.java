package objects;

import static org.lwjgl.opengl.GL11.*;

import static org.lwjgl.opengl.GL20.*;



import org.joml.Vector3f;

import Engine.EngineController;
import utils.Color;
import utils.Texture2D;
import utils.Transform;

public class GameObject {
    protected Mesh model;
    protected int texture;
    public String name ;
    public Transform transform;
    public Color color;

    public void enableLight(){
        glUniform1f(glGetUniformLocation(EngineController.pushPorgram("defualt"), "lightOn"),1);

    }
    public void update(){
        model.setTranslation(transform.position);
        model.setRotationXYZ(transform.rotation.x, transform.rotation.y, transform.rotation.z);
        model.scale(new Vector3f(transform.scale));


        glUniform1f(glGetUniformLocation(EngineController.pushPorgram("defualt"), "a"),color.a);
        glUniform2f(glGetUniformLocation(EngineController.pushPorgram("defualt"), "colorFromIn"),0,0);

        int loc = glGetUniformLocation(EngineController.pushPorgram("defualt"), "color");
        glUniform3f(loc,(float)color.r/255, (float)color.g/255, (float)color.b/255);
        if(texture == 0)
            glUniform2f(glGetUniformLocation(EngineController.pushPorgram("defualt"), "textureEnable"),0,0);
        else{
            glUniform2f(glGetUniformLocation(EngineController.pushPorgram("defualt"), "textureEnable"),1, 0);
            glBindTexture(GL_TEXTURE_2D, texture);
        }

        glUniform1f(glGetUniformLocation(EngineController.pushPorgram("defualt"), "lightOn"),0);
        
    }
    public void loadTexture(String src){
        this.texture =  EngineController.loadTexture(src);
    }
    public void loadTexture(Texture2D texture){
        this.texture = EngineController.loadTexture(texture.getSource());
    }

    public void draw(){

    }

}
