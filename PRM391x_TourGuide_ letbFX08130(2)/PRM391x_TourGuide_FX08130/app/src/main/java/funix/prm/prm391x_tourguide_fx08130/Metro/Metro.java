package funix.prm.prm391x_tourguide_fx08130.Metro;

import java.io.Serializable;

import funix.prm.prm391x_tourguide_fx08130.Tour;

public class Metro extends Tour implements Serializable {
    public Metro(String name, String address, int image) {
        super ( name, address, image );
    }
}
