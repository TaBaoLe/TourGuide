package funix.prm.prm391x_tourguide_fx08130.Hospital;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import funix.prm.prm391x_tourguide_fx08130.MainActivity;
import funix.prm.prm391x_tourguide_fx08130.R;

public class HospitalFragment extends Fragment {

    private View mView;
    private RecyclerView rcvHospital;
    private MainActivity mMainActivity;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView=inflater.inflate ( R.layout.fragment_hotel, container, false );
        setToolbar ( );
        //set background
        mView.setBackgroundResource ( R.color.orange );
        rcvHospital=mView.findViewById ( R.id.rcv_hotel );
        mMainActivity=(MainActivity) getActivity ( );
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager ( mMainActivity );
        rcvHospital.setLayoutManager ( linearLayoutManager );
        //set adapter
        HospitalAdapter hospitalAdapter=new HospitalAdapter ( getList ( ), hospital -> mMainActivity.detailHospitalFragment ( hospital ) );
        rcvHospital.setAdapter ( hospitalAdapter );
        //set divider decoration
        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration ( mMainActivity, DividerItemDecoration.VERTICAL );
        rcvHospital.addItemDecoration ( itemDecoration );
        return mView;
    }

    private void setToolbar() {
        Toolbar toolbar=(Toolbar) mView.findViewById ( R.id.toolbar );
        toolbar.setTitle ( "B???nh Vi???n" );
        AppCompatActivity activity=(AppCompatActivity) getActivity ( );
        activity.setSupportActionBar ( toolbar );

    }

    private List<Hospital> getList() {
        List<Hospital> hospitalList=new ArrayList<> ( );
        hospitalList.add ( new Hospital ( "B???nh vi???n B???ch Mai", "78 ??? ???????ng Gi???i Ph??ng ??? Ph????ng Mai ??? ?????ng ??a ??? H?? N???i", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "B???nh Vi???n H???u Ngh???", "S??? 1 ??? Tr???n Kh??nh D?? ??? Qu???n Hai B?? Tr??ng ??? H?? N???i", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "B???nh Vi???n E, H?? N???i", "89 ??? Tr???n Cung ??? Ngh??a T??n ??? C???u Gi???y ??? H?? N???i", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "Vi???n R??ng H??m M???t", "40B ??? Tr??ng Thi ??? Ho??n Ki???m ??? H?? N???i", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "B???nh Vi???n Tai M??i H???ng Trung ????ng", "78 ??? ???????ng Gi???i Ph??ng ??? Qu???n ?????ng ??a ??? H?? N???i", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "B???nh Vi???n M???t Trung ????ng", "85 ??? Ph??? B?? Tri???u ??? Qu???n Hai B?? Tr??ng ??? H?? N???i", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "Vi???n Y H???c C??? Truy???n Trung ????ng", "29 ??? Ph??? Nguy???n B???nh Khi??m ??? Qu???n Hai B?? Tr??ng ??? H?? N???i", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "B???nh Vi???n N???i Ti???t", "80 ??? Th??i Th???nh II ??? Th???nh Quang ??? ?????ng ??a ??? H?? N???i", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "B???nh Vi???n Vi???t ?????c", "8 ??? Ph??? Ph??? Do??n ??? Qu???n Ho??n Ki???m ??? H?? N???i", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "B???nh Vi???n Nhi Trung ????ng", "18/879 ??? ???????ng La Th??nh ??? Qu???n ?????ng ??a ??? H?? N???i", R.drawable.hospital ) );
        return hospitalList;
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
