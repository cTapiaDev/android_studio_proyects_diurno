package cl.bootcamp.proyectos;

public class ListElement  {

    public String color;
    public String name;
    public String colorName;
    public String subtitle;
    public String status;


    public ListElement(String color, String name, String colorName, String subtitle, String status) {
        this.color = color;
        this.name = name;
        this.colorName = colorName;
        this.subtitle = subtitle;
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorName() {
        return colorName;
    }

    public void SetColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}