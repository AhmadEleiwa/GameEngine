package objects;
import org.joml.Matrix4f;

import Engine.EngineController;

import static org.lwjgl.opengl.GL20.*;


public class Projection extends Matrix4f {
    private float[] vertices;
    private int program ;
    private String name;
    private int model;
    private float zfar;
    private float zNear;
    private float aspect;
    public Projection( float aspect){
        super();
        this.name = "projection";
        this.program = EngineController.pushPorgram("defualt");
        this.model = glGetUniformLocation(program, name);
        this.zfar = 500;
        this.zNear = 0.1f;
        this.aspect = aspect;
        this.perspective((float)Math.toRadians(45f), aspect,zNear, zfar);
        vertices = new float[16];
        update();
    }
    public Projection(int program, String name , float aspect){
        super();
        this.name = name;
        this.program = program;
        this.model = glGetUniformLocation(program, name);
        this.zfar = 500;
        this.zNear = 0.1f;
        this.aspect = aspect;

        perspective((float)Math.toRadians(45f), aspect,zNear, zfar);
        vertices = new float[16];
        update();
    }
    private void update(){
        get(vertices);
    }
    public float[] get() {
        update();
        return vertices;
    }
    public int getProgram() {
        return program;
    }
    public String getName() {
        return name;
    };
    public void sendMatrix(){
        update();
        glUniformMatrix4fv(this.model, false, this.vertices);
    }
    public float getZfar() {
        return zfar;
    }
    public void setZfar(float zfar) {
        this.zfar = zfar;
        this.identity();
        this.perspective((float)Math.toRadians(45f), aspect,zNear, zfar);
        
    }
    public float getzNear() {
        return zNear;
    }
    public void setzNear(float zNear) {
        this.zNear = zNear;
        this.identity();

        this.perspective((float)Math.toRadians(45f), aspect,zNear, zfar);

    }

}
