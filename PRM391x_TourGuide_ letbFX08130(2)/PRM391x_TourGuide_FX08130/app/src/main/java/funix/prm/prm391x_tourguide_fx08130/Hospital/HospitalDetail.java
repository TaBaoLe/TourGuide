package funix.prm.prm391x_tourguide_fx08130.Hospital;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import funix.prm.prm391x_tourguide_fx08130.R;

public class HospitalDetail extends Fragment {
    private TextView mName;
    private TextView mAddress;
    private ImageView mImg;
    private View mView;

    public HospitalDetail() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate ( R.layout.fragment_detail_hotel, container, false );
        mView.setBackgroundResource ( R.color.orange );
        init ( );
        setToolbar ( );
        getBundle ( );
        return mView;
    }

    private void init() {
        mName=mView.findViewById ( R.id.name_hotel_detail );
        mAddress=mView.findViewById ( R.id.add_hotel_detail );
        mImg=mView.findViewById ( R.id.img_hotel_detail );
    }
    /**
     * get bundle from HospitalFragment and show on detaillist
     */
    private void getBundle() {
        Bundle bundleReceived=getArguments ( );
        if (bundleReceived != null) {
            Hospital hospital=(Hospital) bundleReceived.get ( "hospital" );
            if (hospital != null) {
                mName.setText ( hospital.getName ( ) );
                mAddress.setText ( hospital.getAddress ( ) );
                mImg.setImageResource ( hospital.getImage ( ) );
            }

        }
    }
    /**
     * set toolbar
     */
    private void setToolbar() {
        Toolbar mToolbar=(Toolbar) mView.findViewById ( R.id.toolbar );
        mToolbar.setTitle ( "Bệnh Viện" );
        AppCompatActivity activity=(AppCompatActivity) getActivity ( );
        activity.setSupportActionBar ( mToolbar );
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setHasOptionsMenu ( true );
    }
    /**
     *
     * @param menuItem
     * @return
     * set back to front stack when click toolbar icon
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId ( ) == android.R.id.home) {
            getFragmentManager ( ).popBackStack ( );
        }
        return super.onOptionsItemSelected ( menuItem );
    }
}
