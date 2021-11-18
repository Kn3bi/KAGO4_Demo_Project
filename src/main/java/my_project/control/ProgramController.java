package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.Spaceship;
import my_project.model.Target;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute
    private int winCounter;

    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Spaceship theShip;
    private Target target1;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        winCounter = 0;
        // Erstelle ein Objekt der Klasse Target und lasse es zeichnen
        target1 = new Target(650,100);
        viewController.draw(target1);
        // Erstelle ein Objekt der Klasse Spaceship und lasse es zeichnen und auf Eingaben reagieren
        theShip = new Spaceship();
        viewController.draw(theShip);
        viewController.register(theShip);
        // Lade und benenne einen Ton
        viewController.getSoundController().loadSound("src/main/resources/sound/whoosh.mp3","whoosh",false);
        // Spielanleitung in Konsole ausgeben
        System.out.println();
        System.out.println("********** SUPER RAUMSCHIFF SPIEL *******************");
        System.out.println("Steuerung: Zielen mit Links/Rechts, Losfliegen mit Leertaste!");
        System.out.println("Was für ein Spaß!");
        System.out.println("**********************************************************");
        System.out.println();
    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){
        if(theShip.collidesWith(target1)){
            winCounter++;
            System.out.println(winCounter + "mal GEWONNEN!!!");
            theShip.reset();
        }
    }
}
