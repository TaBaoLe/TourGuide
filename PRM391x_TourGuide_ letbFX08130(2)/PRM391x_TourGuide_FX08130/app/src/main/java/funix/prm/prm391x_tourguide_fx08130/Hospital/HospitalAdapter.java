package funix.prm.prm391x_tourguide_fx08130.Hospital;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import funix.prm.prm391x_tourguide_fx08130.R;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.hospitalViewHolder> {
    final List<Hospital> mHospitalList;
    final private IClickItemListener miClickItemListener;

    public HospitalAdapter(List<Hospital> mHospitalList,IClickItemListener miClickItemListener) {
        this.mHospitalList=mHospitalList;
        this.miClickItemListener = miClickItemListener;
    }
    /**
     * interface onclick fot item list
     */
    public interface IClickItemListener {
        void onClickItemHospital(Hospital hospital);
    }

    @NonNull
    @Override
    public hospitalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from ( parent.getContext ( ) ).inflate ( R.layout.list_item, parent, false );
        return new hospitalViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull hospitalViewHolder holder, int position) {
        final Hospital hospital=mHospitalList.get ( position );
        if (hospital == null) {
            return;
        }
        holder.mImg.setImageResource ( R.drawable.hospital );
        holder.mName.setText ( hospital.getName ( ) );
        holder.mAddress.setText ( hospital.getAddress ( ) );
        holder.mName.setOnClickListener ( v -> miClickItemListener.onClickItemHospital (hospital) );
    }

    @Override
    public int getItemCount() {
        if (mHospitalList != null) {
            return mHospitalList.size ( );
        }
        return 0;
    }

    public static class hospitalViewHolder extends RecyclerView.ViewHolder {
        final private ImageView mImg;
        final private TextView mName;
        final private TextView mAddress;

        public hospitalViewHolder(@NonNull View itemView) {
            super ( itemView );
            mImg=itemView.findViewById ( R.id.img_hotel_item );
            mName=itemView.findViewById ( R.id.name_hotel );
            mAddress=itemView.findViewById ( R.id.add_hotel );
        }
    }
}
