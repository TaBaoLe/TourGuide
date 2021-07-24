package funix.prm.prm391x_tourguide_fx08130;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import Hotel.HotelFragment;
import funix.prm.prm391x_tourguide_fx08130.Atm.AtmFragment;
import funix.prm.prm391x_tourguide_fx08130.Hospital.HospitalFragment;
import funix.prm.prm391x_tourguide_fx08130.Metro.MetroFragment;


public class HomeFragment extends Fragment implements View.OnClickListener {
    private View mView;
    private ImageView mHotel;
    private ImageView mAtm;
    private ImageView mHospital;
    private ImageView mMetro;

    public HomeFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate ( R.layout.fragment_home, container, false );
        init ( );
        setToolbar();

        return mView;
    }

    /**
     * init view and set onclcik
     */
    private void init() {
        mHotel=mView.findViewById ( R.id.imageHotel );
        mAtm=mView.findViewById ( R.id.imageAtm );
        mHospital=mView.findViewById ( R.id.imageHospital );
        mMetro=mView.findViewById ( R.id.imageBus );

        mHotel.setOnClickListener ( this );
        mAtm.setOnClickListener ( this );
        mHospital.setOnClickListener ( this );
        mMetro.setOnClickListener ( this );
    }

    /**
     * @param v Set onclick for home imageView hotel, atm, hospital and metro tranfer display bu fragment;
     */
    @Override
    public void onClick(View v) {
        int chose=v.getId ( );
        FragmentTransaction fragmentTransaction=getFragmentManager ( ).beginTransaction ( );
        switch (chose) {
            case R.id.imageHotel:
                imageHotel ( fragmentTransaction );
                break;
            case R.id.imageAtm:
                imageAtm ( fragmentTransaction );
                break;
            case R.id.imageHospital:
                imageHospital ( fragmentTransaction );
                break;
            case R.id.imageBus:
                imageBus ( fragmentTransaction );
                break;
            default:
                break;
        }
    }

    /**
     *
     * @param fragmentTransaction
     * Transform to each fragment
     */
    private void imageAtm(FragmentTransaction fragmentTransaction) {
        fragmentTransaction.add ( R.id.home_layout, new AtmFragment ( ) );
        fragmentTransaction.addToBackStack ( AtmFragment.class.getName ( ) );
        fragmentTransaction.commit ( );
    }

    private void imageHotel(FragmentTransaction fragmentTransaction) {
        fragmentTransaction.add ( R.id.home_layout, new HotelFragment ( ) );
        fragmentTransaction.addToBackStack ( HotelFragment.class.getName ( ) );
        fragmentTransaction.commit ( );
    }

    private void imageHospital(FragmentTransaction fragmentTransaction) {
        fragmentTransaction.add ( R.id.home_layout, new HospitalFragment ( ) );
        fragmentTransaction.addToBackStack ( HospitalFragment.class.getName ( ) );
        fragmentTransaction.commit ( );
    }

    private void imageBus(FragmentTransaction fragmentTransaction) {
        fragmentTransaction.add ( R.id.home_layout, new MetroFragment ( ) );
        fragmentTransaction.addToBackStack ( MetroFragment.class.getName ( ) );
        fragmentTransaction.commit ( );
    }

    /**
     * set toolbar
     */
    private void setToolbar() {
        Toolbar toolbar=(Toolbar) mView.findViewById ( R.id.toolbar );
        toolbar.setNavigationIcon ( null );
        AppCompatActivity activity=(AppCompatActivity) getActivity ( );
        activity.setSupportActionBar ( toolbar );

    }
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate ( savedInstanceState );
    setHasOptionsMenu ( true );
}
}