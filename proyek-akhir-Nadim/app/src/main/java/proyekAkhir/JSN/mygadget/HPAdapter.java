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

public class HPAdapter extends RecyclerView.Adapter<HPAdapter.ViewHolder> {
    private List<HpModel.Result> data = new ArrayList<>();
    private HPAdapter.OnAdapterListener listener;

    public HPAdapter(List<HpModel.Result> data, OnAdapterListener listener) {
        this.data = data;
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
        HpModel.Result phone = data.get(position);
        holder.textView.setText(phone.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(phone);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
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

    public void setData(List<HpModel.Result> data) {
        data.clear();
        data.addAll(data);
        notifyDataSetChanged();
    }

    interface OnAdapterListener {
        void onClick(HpModel.Result phone);
    }
}
