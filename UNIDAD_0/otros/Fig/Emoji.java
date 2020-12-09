package Fig;

import javafx.scene.image.Image;

public class Emoji {
    private String ruta;
    private Image imagen;
    private double x, y, ancho, alto;

    public Emoji(String ruta, double x, double y, double ancho, double alto){
        this.ruta = ruta;
        this.imagen = new Image(getClass().getResourceAsStream(ruta));
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public String getRuta(){
        return this.ruta;
    }    
    public Image getImagen(){
        return this.imagen;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getAncho(){
        return this.ancho;
    }
    public double getAlto(){
        return this.alto;
    }

    public void setRuta(String ruta){
        this.ruta = ruta;
    }
    public void setImage(String ruta){
        setRuta(ruta);
        this.imagen = new Image(getClass().getResourceAsStream(ruta));
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setAncho(double ancho){
        this.ancho = ancho;
    }
    public void setAlto(double alto){
        this.alto = alto;
    }

}
