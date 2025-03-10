/**
 *classe che istanzaia pianeti
 *
 *@author Sofia Niederhauser I2AA
 *@version 10.03.2025
 */
public class Planet {
    private String name;
    private double mass;
    private double radius;
    private double volume;
    private double density;
    private boolean life;
    private boolean population;
    private float albedo;
    public Planet(String name, double mass, double radius, double volume, double density, boolean life, boolean population, float albedo) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.volume = volume;
        this.density = density;
        this.life = life;
        this.population = population;
        this.albedo = albedo;
    }
    public Planet() {
        this.name = "sun";
        this.mass = 1.989;
        this.radius = 696340;
        this.volume = 1.412000;
        this.density = 1.41;
        this.life = false;
        this.population = false;
        this.albedo = 0.0f;
    }
    public String getName() {return name;}
    public double getMass() {return mass;}
    public double getRadius() {return radius;}
    public double getVolume() {return volume;}
    public double getDensity() {return density;}
    public boolean getLife() {return life;}
    public boolean getPopulation() {return population;}
    public float getAlbedo() {return albedo;}
    public void setName(String name) {this.name = name;}
    public void setMass(double mass) {this.mass = mass;}
    public void setRadius(double radius) {this.radius = radius;}
    public void setVolume(double volume) {this.volume = volume;}
    public void setDensity(double density) {this.density = density;}
    public void setLife(boolean life) {this.life = life;}
    public void setPopulation(boolean population) {this.population = population;}
    public void setAlbedo(float albedo) {this.albedo = albedo;}

    public double accelerazione_gravitazionale(double mass, double radius){
        return 9.81 * (mass/radius*radius);
    }
    public String toString(){
        return "Name: " + name + " Mass: " + mass + " Radius: " + radius + " Volume: " + volume + " Density: " + density + " Life: " + life + " Population: " + population + " Albedo: " + albedo + " Accelerazione gravitazionale: "+ accelerazione_gravitazionale(mass, radius);
    }

}
