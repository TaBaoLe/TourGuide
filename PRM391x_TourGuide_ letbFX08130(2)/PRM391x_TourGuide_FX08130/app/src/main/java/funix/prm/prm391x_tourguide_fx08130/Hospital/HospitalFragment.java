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
        toolbar.setTitle ( "Bệnh Viện" );
        AppCompatActivity activity=(AppCompatActivity) getActivity ( );
        activity.setSupportActionBar ( toolbar );

    }

    private List<Hospital> getList() {
        List<Hospital> hospitalList=new ArrayList<> ( );
        hospitalList.add ( new Hospital ( "Bệnh viện Bạch Mai", "78 – Đường Giải Phóng – Phương Mai – Đống Đa – Hà Nội", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "Bệnh Viện Hữu Nghị", "Số 1 – Trần Khánh Dư – Quận Hai Bà Trưng – Hà Nội", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "Bệnh Viện E, Hà Nội", "89 – Trần Cung – Nghĩa Tân – Cầu Giấy – Hà Nội", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "Viện Răng Hàm Mặt", "40B – Tràng Thi – Hoàn Kiếm – Hà Nội", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "Bệnh Viện Tai Mũi Họng Trung Ương", "78 – Đường Giải Phóng – Quận Đống Đa – Hà Nội", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "Bệnh Viện Mắt Trung Ương", "85 – Phố Bà Triệu – Quận Hai Bà Trưng – Hà Nội", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "Viện Y Học Cổ Truyền Trung Ương", "29 – Phố Nguyễn Bỉnh Khiêm – Quận Hai Bà Trưng – Hà Nội", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "Bệnh Viện Nội Tiết", "80 – Thái Thịnh II – Thịnh Quang – Đống Đa – Hà Nội", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "Bệnh Viện Việt Đức", "8 – Phố Phủ Doãn – Quận Hoàn Kiếm – Hà Nội", R.drawable.hospital ) );
        hospitalList.add ( new Hospital ( "Bệnh Viện Nhi Trung Ương", "18/879 – Đường La Thành – Quận Đống Đa – Hà Nội", R.drawable.hospital ) );
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
