import java.util.Random;

import org.lwjgl.glfw.GLFW;
import org.joml.Vector3f;

import Engine.EngineController;
import objects.Circle;
import objects.Cube;
import objects.GameObject;
import objects.Light;
import objects.Lines;
import objects.Projection;
import objects.Rectangle;
import objects.Sprite;
import objects.View;
import objects.Window;
import utils.Color;
import utils.Input;
import utils.Time;
import utils.Texture2D;

public class App{

    public static void main(String[] args) {
        new App().app();
    }

    void app(){

        int winWidth = 1900 , winHeight =  1200;
        String title = "My title";
        Window window = new Window(winWidth, winHeight, title);
 
        Texture2D[] tex = new Texture2D[5];
        
        tex[0] = new Texture2D("src/ss.jpg");
        tex[1] = new Texture2D("src/lava.jpg");
        tex[2] = new Texture2D("src/player.png");
        tex[3] = new Texture2D("src/dirt_0.png");
        tex[4] = new Texture2D("src/grass.jpg");


        Projection proj = new Projection( (float)winWidth/(float)winHeight);
    
        View view = new View();

        int x = 120;
        window.setBackGroundColor(new Color(x, x, x));

 
 

        Lines line = new Lines();
        view.setCameraIoMovement(true);


        Light l = new Light();
        l.transform.position = new Vector3f(2,8,3);
        l.color = new Color(220, 220, 200);

        Cube cube = new Cube();
        cube.color = new Color(144, 120, 240);

        view.cameraPos.y = 7;
        view.cameraPos.x = 0;
        view.cameraPos.z = 15;

        float xi = 0.1f;
        while(!window.isRunning()){
            window.render();
            EngineController.useDefualtProgram();
            if(Input.getKeyDown(GLFW.GLFW_KEY_UP))
                l.transform.position.z -= xi; 
            if(Input.getKeyDown(GLFW.GLFW_KEY_DOWN))
                l.transform.position.z += xi; 
            if(Input.getKeyDown(GLFW.GLFW_KEY_RIGHT))
                l.transform.position.x += xi; 
            if(Input.getKeyDown(GLFW.GLFW_KEY_LEFT))
                l.transform.position.x -= xi; 
            if(Input.getKeyDown(GLFW.GLFW_KEY_SPACE))
                l.transform.position.y += xi;
            if(Input.getKeyDown(GLFW.GLFW_KEY_LEFT_CONTROL))
                l.transform.position.y -= xi;  

            view.render();
            proj.sendMatrix();
            cube.draw();
            line.draw();


            l.draw();
            


            window.pollEvent();
            
        }        
        
        window.cleanUp();
    }
}