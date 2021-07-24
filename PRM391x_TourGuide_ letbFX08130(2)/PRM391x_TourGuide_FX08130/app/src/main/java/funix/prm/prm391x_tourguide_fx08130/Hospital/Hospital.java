package funix.prm.prm391x_tourguide_fx08130.Hospital;

import java.io.Serializable;

import funix.prm.prm391x_tourguide_fx08130.Tour;

public class Hospital extends Tour implements Serializable {
    public Hospital(String name, String address, int image) {
        super ( name, address, image );
    }
}
