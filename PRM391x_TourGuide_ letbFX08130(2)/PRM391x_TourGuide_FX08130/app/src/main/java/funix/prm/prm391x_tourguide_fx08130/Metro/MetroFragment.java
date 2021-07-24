package funix.prm.prm391x_tourguide_fx08130.Metro;

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

public class MetroFragment extends Fragment {
    private View mView;
    private RecyclerView rcvMetro;
    private MainActivity mMainActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate ( R.layout.fragment_hotel, container, false );
        setToolbar();
        mView.setBackgroundResource ( R.color.blue );
        mMainActivity=(MainActivity) getActivity ( );
        rcvMetro=mView.findViewById ( R.id.rcv_hotel );

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager ( mMainActivity );
        rcvMetro.setLayoutManager ( linearLayoutManager );
        MetroAdapter metroAdapter =new MetroAdapter ( getList ( ), metro -> mMainActivity.detailMetroFragment(metro) );
        rcvMetro.setAdapter ( metroAdapter );
        //set divider decoration
        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration ( mMainActivity, DividerItemDecoration.VERTICAL );
        rcvMetro.addItemDecoration ( itemDecoration );
        return mView;
    }

    private List<Metro> getList() {
        List<Metro> list=new ArrayList<> ( );
        list.add ( new Metro ( "Tuyến 01", "BX Gia Lâm - BX Yên Nghĩa", R.drawable.metro ) );
        list.add ( new Metro (  "Tuyến 02", "Bác cổ - BX Yên Nghĩa", R.drawable.metro ) );
        list.add ( new Metro ( "Tuyến 03A", "BX Giáp Bát - BX Gia Lâm" ,R.drawable.metro ) );
        list.add ( new Metro (  "Tuyến 03B", "Bx Giáp Bát - Vincom - Phúc Lợi", R.drawable.metro ) );
        list.add ( new Metro (  "Tuyến 04", "Long Biên - BX Nước Ngầm", R.drawable.metro ) );
        list.add ( new Metro (  "Tuyến 05", "Linh Đàm - Phú Diễn", R.drawable.metro ) );
        list.add ( new Metro (  "Tuyến 06", "BX. Giáp Bát - Phú Minh (Phú Xuyên)", R.drawable.metro ) );
        list.add ( new Metro (  "Tuyến 07", "Cầu Giấy - Nội Bài", R.drawable.metro ) );
        list.add ( new Metro (  "Tuyến 08", "Long Biên - Đông Mỹ", R.drawable.metro ) );
        return list;
    }

    private void setToolbar() {
        Toolbar mToolbar=(Toolbar) mView.findViewById ( R.id.toolbar );
        mToolbar.setTitle ( "Metro" );
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
