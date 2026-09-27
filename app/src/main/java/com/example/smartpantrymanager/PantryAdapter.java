package com.example.smartpantrymanager;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import  android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import  java.util.List;

public class PantryAdapter extends RecyclerView.Adapter<PantryAdapter.ViewHolder>{
    private List<PantryItem> items;

    public  PantryAdapter(List<PantryItem> items){
        this.items= items;
    }

    public void updateData(List<PantryItem> newItems){
        this.items=newItems;
        notifyDataSetChanged();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pantry_item,parent ,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PantryItem item =items.get(position);
        holder.name.setText(item.getName());
        holder.quantity.setText("Qty :"+ item.getQuantity());
        holder.expiry.setText("Expires : "+ item.getExpiryDate());

        holder.itemView.setOnClickListener(v-> {
            Intent intent = new Intent(v.getContext(), PantryItemActivity.class);
            intent.putExtra("name",item.getName());
            intent.putExtra("quantity",item.getQuantity());
            intent.putExtra("expiry",item.getExpiryDate());
            v.getContext().startActivity(intent);

        });


    }
    @Override
    public int getItemCount(){
        return items.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name , quantity ,expiry;

        public ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.itemName);
            quantity = itemView.findViewById(R.id.itemQuantity);
            expiry =itemView.findViewById(R.id.itemExpiry);
        }


    }

}