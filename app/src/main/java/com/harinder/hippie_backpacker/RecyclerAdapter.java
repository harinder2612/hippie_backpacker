package com.harinder.hippie_backpacker;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {

    private int[] images;
    private String[] names;
    private String [] latlngs;
    private Context context;

    //constructor
    public RecyclerAdapter(int[] images, String[] names, String[] latlngs, Context context)
    {
        this.images = images;
        this.names = names;
        this.latlngs = latlngs;
        this.context = context;
    }


    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view,context, latlngs);

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

        //
        int image_id = images[position];
        String name_id = names[position];
        String latlng_id = latlngs[position];
        holder.image.setImageResource(image_id);
        holder.imageTitle.setText(name_id);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView image;
        TextView imageTitle;
        Context context;
        String[] latlngs;

        public ImageViewHolder(@NonNull View itemView,Context context, String [] latlngs) {
            super(itemView);
            image = itemView.findViewById(R.id.recImageItem);
            imageTitle = itemView.findViewById(R.id.recNameItem);
            itemView.setOnClickListener(this);
            this.context =context;
            this.latlngs = latlngs;
        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(context,Panorama.class);
            intent.putExtra("LatLngString",latlngs[getAdapterPosition()]);
            context.startActivity(intent);
        }
    }
}
