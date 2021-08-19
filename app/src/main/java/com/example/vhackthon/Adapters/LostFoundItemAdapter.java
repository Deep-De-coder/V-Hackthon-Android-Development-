package com.example.vhackthon.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vhackthon.GetterSetterClasses.LostFoundItem;
import com.example.vhackthon.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LostFoundItemAdapter extends RecyclerView.Adapter<LostFoundItemAdapter.MyViewHolder>{

    ArrayList<LostFoundItem> list;

    public LostFoundItemAdapter(ArrayList<LostFoundItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lostfounditemholder,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.itemname.setText(list.get(position).getName());
        holder.location.setText(list.get(position).getLocation());
        Picasso.get().load(list.get(position).getImageUrl()).into(holder.itemimage);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemname,location;
        ImageView itemimage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemname = itemView.findViewById(R.id.itemname);
            itemimage = itemView.findViewById(R.id.itemimage);
            location = itemView.findViewById(R.id.location);
        }
    }
}
