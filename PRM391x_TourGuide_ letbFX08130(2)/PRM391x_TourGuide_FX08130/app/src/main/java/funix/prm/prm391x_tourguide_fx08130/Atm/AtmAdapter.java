package funix.prm.prm391x_tourguide_fx08130.Atm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import funix.prm.prm391x_tourguide_fx08130.R;

public class AtmAdapter extends RecyclerView.Adapter<AtmAdapter.AtmViewHolder> {
    final private List<Atm> mAtmList;
    final private AtmAdapter.IClickItemListener miClickItemListener;

    /**
     * interface onclick fot item list
     */
    public interface IClickItemListener {
        void onClickItemHotel(Atm atm);
    }

    public AtmAdapter(List<Atm> mAtm, AtmAdapter.IClickItemListener miClickItemListener) {
        this.mAtmList=mAtm;
        this.miClickItemListener=miClickItemListener;
    }

    @NonNull
    @Override
    public AtmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from ( parent.getContext ( ) ).inflate ( R.layout.list_item, parent, false );
        return new AtmViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull AtmViewHolder holder, int position) {
        final Atm atm=mAtmList.get ( position );
        if (atm == null) {
            return;
        }
        holder.mName.setText ( atm.getName ( ) );
        holder.mAddress.setText ( atm.getAddress ( ) );
        holder.mImg.setImageResource ( atm.getImage ( ) );
        holder.mName.setOnClickListener ( v -> miClickItemListener.onClickItemHotel (atm) );
    }

    @Override
    public int getItemCount() {
        if (mAtmList != null) {
            return mAtmList.size ( );
        }
        return 0;
    }

    public static class AtmViewHolder extends RecyclerView.ViewHolder {
        final private ImageView mImg;
        final private TextView mName;
        final private TextView mAddress;

        public AtmViewHolder(@NonNull View itemView) {
            super ( itemView );
            mImg=itemView.findViewById ( R.id.img_hotel_item );
            mName=itemView.findViewById ( R.id.name_hotel );
            mAddress=itemView.findViewById ( R.id.add_hotel );
        }
    }
}
