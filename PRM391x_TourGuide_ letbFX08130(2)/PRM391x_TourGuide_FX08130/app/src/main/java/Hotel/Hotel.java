package Hotel;

import java.io.Serializable;

import funix.prm.prm391x_tourguide_fx08130.Tour;

/**
 * Hotel object
 */
public class Hotel extends Tour implements Serializable {
    public Hotel(String name, String address, int image) {
        super ( name, address, image );
    }


}
