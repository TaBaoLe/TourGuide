package funix.prm.prm391x_tourguide_fx08130;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import Hotel.DetailHotel;
import funix.prm.prm391x_tourguide_fx08130.Atm.Atm;
import Hotel.Hotel;
import funix.prm.prm391x_tourguide_fx08130.Atm.AtmDetail;
import funix.prm.prm391x_tourguide_fx08130.Hospital.Hospital;
import funix.prm.prm391x_tourguide_fx08130.Hospital.HospitalDetail;
import funix.prm.prm391x_tourguide_fx08130.Metro.Metro;
import funix.prm.prm391x_tourguide_fx08130.Metro.MetroDetail;

public class MainActivity extends AppCompatActivity {
    public Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        setToolbar ( );
        homeFragment ( );
    }

    /**
     * set Toobar
     */
    private void setToolbar() {
        mToolbar=findViewById ( R.id.toolbar );
        setSupportActionBar ( mToolbar );
    }

    /**
     * the main home page
     */
    private void homeFragment() {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager ( ).beginTransaction ( );
        fragmentTransaction.add ( R.id.home_layout, new HomeFragment ( ) );
        fragmentTransaction.commit ( );
    }

    /**
     *
     * @param hotel
     * Send data to item of list
     */
    public void detailHotelFragment(Hotel hotel) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager ( ).beginTransaction ( );
        DetailHotel detailHotel=new DetailHotel ( );
        Bundle bundle=new Bundle ( );
        bundle.putSerializable ( "hotel", hotel );
        detailHotel.setArguments ( bundle );
        fragmentTransaction.replace ( R.id.home_layout, detailHotel );
        fragmentTransaction.addToBackStack ( DetailHotel.class.getName ( ) );
        fragmentTransaction.commit ( );
    }

    /**
     *
     * @param atm
     * Send data to item of list
     */

    public void detailAtmFragment(Atm atm) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager ( ).beginTransaction ( );
        AtmDetail atmDetail=new AtmDetail ( );
        Bundle bundle=new Bundle ( );
        bundle.putSerializable ( "atm", atm );
        atmDetail.setArguments ( bundle );
        fragmentTransaction.replace ( R.id.home_layout, atmDetail );
        fragmentTransaction.addToBackStack ( AtmDetail.class.getName ( ) );
        fragmentTransaction.commit ( );
    }

    public void detailHospitalFragment(Hospital hospital) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager ( ).beginTransaction ( );
        HospitalDetail hospitalDetail=new HospitalDetail ( );
        Bundle bundle=new Bundle ( );
        bundle.putSerializable ( "hospital", hospital );
        hospitalDetail.setArguments ( bundle );
        fragmentTransaction.replace ( R.id.home_layout, hospitalDetail );
        fragmentTransaction.addToBackStack ( HospitalDetail.class.getName ( ) );
        fragmentTransaction.commit ( );
    }

    public void detailMetroFragment(Metro metro) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager ( ).beginTransaction ( );
        MetroDetail metroDetail=new MetroDetail ( );
        Bundle bundle=new Bundle ( );
        bundle.putSerializable ( "metro", metro );
        metroDetail.setArguments ( bundle );
        fragmentTransaction.replace ( R.id.home_layout, metroDetail );
        fragmentTransaction.addToBackStack ( MetroDetail.class.getName ( ) );
        fragmentTransaction.commit ( );
    }

}