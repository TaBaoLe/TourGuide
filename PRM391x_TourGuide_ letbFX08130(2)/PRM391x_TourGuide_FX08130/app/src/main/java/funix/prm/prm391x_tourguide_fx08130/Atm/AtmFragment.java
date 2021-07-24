package funix.prm.prm391x_tourguide_fx08130.Atm;

import android.graphics.Color;
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

public class AtmFragment extends Fragment {
    private View mView;
    private RecyclerView rcvAtm;
    private MainActivity mMainActivity;

    public AtmFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate ( R.layout.fragment_hotel, container, false );
        setToolbar ( );
        //set background
        mView.setBackgroundResource ( R.color.purple_500 );
        mMainActivity=(MainActivity) getActivity ( );
        rcvAtm=mView.findViewById ( R.id.rcv_hotel );
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager ( mMainActivity );
        rcvAtm.setLayoutManager ( linearLayoutManager );
        //set adapter
        AtmAdapter atmAdapter =new AtmAdapter ( getList ( ), atm -> mMainActivity.detailAtmFragment(atm) );
        rcvAtm.setAdapter ( atmAdapter );
        //set divider decoration
        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration ( mMainActivity, DividerItemDecoration.VERTICAL );
        rcvAtm.addItemDecoration ( itemDecoration );
        return mView;
    }

    private void setToolbar() {
        Toolbar mToolbar=(Toolbar) mView.findViewById ( R.id.toolbar );
        mToolbar.setTitle ( "Atm" );
        AppCompatActivity activity=(AppCompatActivity) getActivity ( );
        activity.setSupportActionBar ( mToolbar );
    }

    private List<Atm> getList() {
        List<Atm> list=new ArrayList<> ( );
        list.add ( new Atm ( "ATM Hoàn Kiếm", "17 phố Lý Thường Kiệt, Phường Phan Chu Trinh, Quận Hoàn Kiếm, Hà Nội", R.drawable.atm_machine ) );
        list.add ( new Atm ( "ATM Đinh Tiên Hoàng", "7 Đinh Tiên Hoàng, Quận Hoàn Kiếm, Hà Nội", R.drawable.atm_machine ) );
        list.add ( new Atm ( "ATM Hội sở", "57 Lý Thường Kiệt, Quận Hoàn Kiếm, Hà Nội", R.drawable.atm_machine ) );
        list.add ( new Atm ( "ATM Nam Hà Nội", "236 Lê Thanh Nghị, Quận Hai Bà Trưng, Hà Nội", R.drawable.atm_machine ) );
        list.add ( new Atm ( "ATM Hai Bà Trưng", "300-302 Trần Khát Chân, Quận Hai Bà Trưng, Hà Nội", R.drawable.atm_machine ) );
        list.add ( new Atm ( "ATM Lê Ngọc Hân", "44 Lê Ngọc Hân, Quận Hai Bà Trưng, Hà Nội", R.drawable.atm_machine ) );
        list.add ( new Atm ( "ATM Thăng Long", "129-131 Hoàng Quốc Việt, Quận Cầu Giấy, Hà Nội", R.drawable.atm_machine ) );
        list.add ( new Atm ( "ATM Phạm Hùng", "Tòa nhà FPT Phạm Hùng, Quận Cầu Giấy, Hà Nội", R.drawable.atm_machine ) );
        list.add ( new Atm ( "ATM Khâm Thiên", "158 Khâm Thiên, Quận Đống Đa, Hà Nội", R.drawable.atm_machine ) );
        return list;
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
