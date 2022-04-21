package NadimIF4A.example.pertemuan7.adapters;

import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import NadimIF4A.example.pertemuan7.R;
import NadimIF4A.example.pertemuan7.activities.DetailActivity;
import NadimIF4A.example.pertemuan7.models.food;
import NadimIF4A.example.pertemuan7.utils.ItemClickListener;

//Ketik alt enter pada error line
public class foodViewAdapter extends RecyclerView.Adapter<foodViewAdapter.ViewHolder> {
    //gunakan List karena class food akan digunakan untuk banyak data
    private List<food> data = new ArrayList<>();
    private ItemClickListener<food> itemClickListener;

    public foodViewAdapter(ItemClickListener<food> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setData(List<food> data) {
        this.data = data;
        notifyDataSetChanged();
    }

//    public foodViewAdapter(List<food> data) {
//        this.data = data;
//    }

    //layout mana yang akan diambil (inflate)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false));
    }

    //mem bind apa yang ingin ditampilkan
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int pos = holder.getAdapterPosition();

        holder.ivFood.setImageResource(data.get(pos).getThumbnail());
        holder.tvFoodName.setText(data.get(pos).getNama());
        //buat onclick Listener untuk intent ke detail
        //itemView = 1 kartu penuh
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(data.get(pos), pos);
            }
        });
    }

    //set panjang list
    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //panggil ImageView TextView dari layout
        private ImageView ivFood;
        private TextView tvFoodName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivFood = itemView.findViewById(R.id.ivFood);
            tvFoodName = itemView.findViewById(R.id.tvFoodName);
        }
    }
}
