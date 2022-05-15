package proyekAkhir.JSN.mygadget;

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

public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.ViewHolder> {

    private List<LaptopModel.Result> results = new ArrayList<>();
    private OnAdapterListener listener;


    //construtor adapter

    public LaptopAdapter(List<LaptopModel.Result> results, OnAdapterListener listener) {
        this.results = results;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder (
                LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_laptop, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull LaptopAdapter.ViewHolder holder, int position) {
        LaptopModel.Result result = results.get(position);
        holder.textView.setText(result.getLaptop_name());
        holder.textView2.setText(result.getBrand_name());
        Glide.with(holder.itemView.getContext())
                .load(result.getImage())
                .placeholder(R.drawable.img_placeholder)
                .fitCenter()
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(result);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView, textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
        }
    }

    public void setData(List<LaptopModel.Result> data) {
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();
    }
    
    interface OnAdapterListener {
        void onClick(LaptopModel.Result result);
    }
}
