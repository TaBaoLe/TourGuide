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
        list.add ( new Atm ( "ATM Ho??n Ki???m", "17 ph??? L?? Th?????ng Ki???t, Ph?????ng Phan Chu Trinh, Qu???n Ho??n Ki???m, H?? N???i", R.drawable.atm_machine ) );
        list.add ( new Atm ( "ATM ??inh Ti??n Ho??ng", "7 ??inh Ti??n Ho??ng, Qu???n Ho??n Ki???m, H?? N???i", R.drawable.atm_machine ) );
        list.add ( new Atm ( "ATM H???i s???", "57 L?? Th?????ng Ki???t, Qu???n Ho??n Ki???m, H?? N???i", R.drawable.atm_machine ) );
        list.add ( new Atm ( "ATM Nam H?? N???i", "236 L?? Thanh Ngh???, Qu???n Hai B?? Tr??ng, H?? N???i", R.drawable.atm_machine ) );
        list.add ( new Atm ( "ATM Hai B?? Tr??ng", "300-302 Tr???n Kh??t Ch??n, Qu???n Hai B?? Tr??ng, H?? N???i", R.drawable.atm_machine ) );
        list.add ( new Atm ( "ATM L?? Ng???c H??n", "44 L?? Ng???c H??n, Qu???n Hai B?? Tr??ng, H?? N???i", R.drawable.atm_machine ) );
        list.add ( new Atm ( "ATM Th??ng Long", "129-131 Ho??ng Qu???c Vi???t, Qu???n C???u Gi???y, H?? N???i", R.drawable.atm_machine ) );
        list.add ( new Atm ( "ATM Ph???m H??ng", "T??a nh?? FPT Ph???m H??ng, Qu???n C???u Gi???y, H?? N???i", R.drawable.atm_machine ) );
        list.add ( new Atm ( "ATM Kh??m Thi??n", "158 Kh??m Thi??n, Qu???n ?????ng ??a, H?? N???i", R.drawable.atm_machine ) );
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
