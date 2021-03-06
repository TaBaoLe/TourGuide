package funix.prm.prm391x_tourguide_fx08130;

public class Tour {
    private String name;
    private String address;
    private int image;

    public Tour(String name, String address, int image) {
        this.name=name;
        this.address=address;
        this.image=image;
    }

    public Tour() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address=address;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image=image;
    }
}
