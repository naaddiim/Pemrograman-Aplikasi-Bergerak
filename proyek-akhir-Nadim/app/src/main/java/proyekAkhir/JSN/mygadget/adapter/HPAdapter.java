package proyekAkhir.JSN.mygadget.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import proyekAkhir.JSN.mygadget.R;
import proyekAkhir.JSN.mygadget.models.Hp.Phones;

public class HPAdapter extends RecyclerView.Adapter<HPAdapter.ViewHolder> {
    private List<Phones> phone = new ArrayList<>();
    private OnAdapterListener listener;

    public HPAdapter(List<Phones> phone, OnAdapterListener listener) {
        this.phone = phone;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HPAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_hp, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull HPAdapter.ViewHolder holder, int position) {
        Phones result = phone.get(position);
        holder.tvBrandHP.setText(result.getBrand());
        holder.tvNamaHP.setText(result.getPhone_name());
        Glide.with(holder.itemView.getContext())
                .load(result.getImage())
                .placeholder(R.drawable.img_placeholder)
                .fitCenter()
                .into(holder.ivHP);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(result);
            }
        });
    }

    @Override
    public int getItemCount() {
        return phone.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivHP;
        TextView tvNamaHP, tvBrandHP;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvBrandHP = itemView.findViewById(R.id.tvBrandHP);
            tvNamaHP = itemView.findViewById(R.id.tvNamaHP);
            ivHP = itemView.findViewById(R.id.ivHP);
        }
    }
    public void setData(List<Phones> phonedata) {
        phone.clear();
        phone.addAll(phonedata);
        notifyDataSetChanged();
    }

    public interface OnAdapterListener {
        void onClick(Phones result);
    }

}
