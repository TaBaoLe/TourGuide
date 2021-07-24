package funix.prm.prm391x_tourguide_fx08130.Metro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import funix.prm.prm391x_tourguide_fx08130.R;

public class MetroAdapter extends RecyclerView.Adapter<MetroAdapter.MetroViewHolder> {
    List<Metro> mMetroList;

    public MetroAdapter(List<Metro> mMetroList, IClickItemListener miClickItemListener) {
        this.mMetroList=mMetroList;
        this.miClickItemListener=miClickItemListener;
    }

    final private IClickItemListener miClickItemListener;
    /**
     * interface onclick fot item list
     */
    public interface IClickItemListener {
        void onClickItemMetro(Metro metro);
    }
    @NonNull
    @Override
    public MetroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from ( parent.getContext ( ) ).inflate ( R.layout.list_item, parent, false );
        return new MetroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MetroViewHolder holder, int position) {
        final Metro metro =mMetroList.get ( position );
        if (metro == null) {
            return;
        }
        holder.mName.setText ( metro.getName ( ) );
        holder.mAddress.setText ( metro.getAddress ( ) );
        holder.mImg.setImageResource ( metro.getImage ( ) );
        holder.mName.setOnClickListener ( v -> miClickItemListener.onClickItemMetro (metro) );
    }

    @Override
    public int getItemCount() {
        if(mMetroList != null){
            return mMetroList.size ();
        }
        return 0;
    }

    public static class MetroViewHolder extends RecyclerView.ViewHolder {
        final private ImageView mImg;
        final private TextView mName;
        final private TextView mAddress;

        public MetroViewHolder(@NonNull View itemView) {
            super ( itemView );
            mImg=itemView.findViewById ( R.id.img_hotel_item );
            mName=itemView.findViewById ( R.id.name_hotel );
            mAddress=itemView.findViewById ( R.id.add_hotel );
        }
    }
}

