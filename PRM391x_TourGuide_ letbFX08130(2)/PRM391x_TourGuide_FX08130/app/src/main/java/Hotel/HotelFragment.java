package Hotel;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import funix.prm.prm391x_tourguide_fx08130.MainActivity;
import funix.prm.prm391x_tourguide_fx08130.R;


public class HotelFragment extends Fragment {
    private View mView;
    private RecyclerView rcvHotel;
    private MainActivity mMainActivity;

    public HotelFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Infalter layout for this fragment
        mView=inflater.inflate ( R.layout.fragment_hotel, container, false );
        //set background
        mView.setBackgroundResource ( R.color.black );
        setToolbar ( );
        rcvHotel=mView.findViewById ( R.id.rcv_hotel );
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager ( mMainActivity );
        rcvHotel.setLayoutManager ( linearLayoutManager );
        //set adapter
        HoteLAdapter hoteLAdapter=new HoteLAdapter ( getList ( ), hotel -> mMainActivity.detailHotelFragment ( hotel ) );
        rcvHotel.setAdapter ( hoteLAdapter );
        //set divider decoration
        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration ( mMainActivity, DividerItemDecoration.VERTICAL );
        rcvHotel.addItemDecoration ( itemDecoration );
        return mView;
    }

    private void setToolbar() {
        Toolbar mToolbar=(Toolbar) mView.findViewById ( R.id.toolbar );
        mToolbar.setTitle ( "Khách Sạn" );
        AppCompatActivity activity=(AppCompatActivity) getActivity ( );
        activity.setSupportActionBar ( mToolbar );
        mMainActivity=(MainActivity) getActivity ( );
    }

    private List<Hotel> getList() {
        List<Hotel> list=new ArrayList<> ( );
        list.add ( new Hotel ( "The Queen Hotel & Spa", "67 Thuốc Bắc, Hàng Bồ, Hàng Bồ, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel ) );
        list.add ( new Hotel ( "Hanoi Nostalgia Hotel & Spa", "13-15 Luong Ngoc Quyen, Hang Buom, Hoan Kiem, Hàng Buồm, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel ) );
        list.add ( new Hotel ( "Church Legend Hotel Hanoi", "46 Ấu Triệu, Phường Hàng Trống, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel ) );
        list.add ( new Hotel ( "Little Hanoi Diamond Hotel", "11 Bát Đàn, Quận Hoàn Kiếm, Hàng Bồ, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel ) );
        list.add ( new Hotel ( "Flamingo Dai Lai Resort", "Thôn Ngọc Quang, Xã Ngọc Thanh, Vĩnh Phúc, Phúc Yên, Hà Nội, Việt Nam", R.drawable.hotel ) );
        list.add ( new Hotel ( "Annam Legend Hotel", "27 Hàng Bè, Hàng Bạc, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel ) );
        list.add ( new Hotel ( "Hanoi Zesty Hotel", "20 Hàng Cân, Hàng Đào, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel ) );
        list.add ( new Hotel ( "Bluebell Hotel", "41 Ngõ Huyện, Phường Hàng Trống, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel ) );
        return list;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setHasOptionsMenu ( true );
    }
    /**
     * interface onclick fot item list
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            getFragmentManager ().popBackStack ();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}