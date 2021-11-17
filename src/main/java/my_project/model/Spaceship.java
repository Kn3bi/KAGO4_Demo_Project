package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.event.KeyEvent;

public class Spaceship extends InteractiveGraphicalObject {

    public Spaceship(double x, double y) {
        this.x = x;
        this.y = y;
        this.setNewImage("src/main/resources/graphic/spaceship.png");
        //this.getMyImage()
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(getMyImage(),x,y);
    }

    @Override
    public void keyReleased(int key){
        if(key == KeyEvent.VK_SPACE){

        }
    }

}
