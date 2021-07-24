package Hotel;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import funix.prm.prm391x_tourguide_fx08130.R;

public class HoteLAdapter extends RecyclerView.Adapter<HoteLAdapter.HotelViewHolder> {
    final private List<Hotel> mListHotel;
    final private IClickItemListener miClickItemListener;

    /**
     * interface onclick fot item list
     */
    public interface IClickItemListener {
        void onClickItemHotel(Hotel hotel);
    }

    public HoteLAdapter(List<Hotel> mListHotel, IClickItemListener iClickItemListener) {
        this.mListHotel=mListHotel;
        this.miClickItemListener=iClickItemListener;
    }


    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView=LayoutInflater.from ( parent.getContext ( ) ).inflate ( R.layout.list_item, parent, false );
        return new HotelViewHolder ( mView );
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
        final Hotel hotel=mListHotel.get ( position );
        if (hotel == null) {
            return;
        }
        holder.mAddress.setText ( hotel.getAddress ( ) );
        holder.mName.setText ( hotel.getName ( ) );
        holder.mImg.setImageResource ( R.drawable.hotel );
        holder.mName.setOnClickListener ( v -> miClickItemListener.onClickItemHotel ( hotel ) );

    }

    @Override
    public int getItemCount() {
        if (mListHotel != null) {
            return mListHotel.size ( );
        }
        return 0;
    }

    public static class HotelViewHolder extends RecyclerView.ViewHolder {
        final private ImageView mImg;
        final private TextView mName;
        final private TextView mAddress;

        public HotelViewHolder(@NonNull View itemView) {
            super ( itemView );
            mImg=itemView.findViewById ( R.id.img_hotel_item );
            mName=itemView.findViewById ( R.id.name_hotel );
            mAddress=itemView.findViewById ( R.id.add_hotel );
        }
    }


}
