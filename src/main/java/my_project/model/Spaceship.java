package my_project.model;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.event.KeyEvent;

public class Spaceship extends InteractiveGraphicalObject {

    private double rotation;
    private boolean start;

    public Spaceship() {
        this.setNewImage("src/main/resources/graphic/spaceship.png");
        reset();
    }

    public void reset(){
        x = 50;
        y = 500;
        rotation = Math.random()*100-30;
        start = false;
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawTransformedImage(getMyImage(),x,y,rotation,1);
    }

    @Override
    public void update(double dt){
        if (ViewController.isKeyDown(KeyEvent.VK_LEFT) && !start){
            rotation = rotation - 50*dt;
        }
        if (ViewController.isKeyDown(KeyEvent.VK_RIGHT) && !start){
            rotation = rotation + 50*dt;
        }
        if(start){
            moveInDirection(rotation,250,dt);
        }
        if(start && (x > 800 || x < -200 || y > 800 || y < -200)){
            reset();
        }
    }

    @Override
    public void keyReleased(int key){
        if(key == KeyEvent.VK_SPACE && !start){
            start  = true;
            SoundController.playSound("whoosh");
        }
    }

}
