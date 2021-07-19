package com.example.movieapp.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.movieapp.R;
import com.example.movieapp.models.Show;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import ru.embersoft.expandabletextview.ExpandableTextView;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ShowItemViewHolder> implements
        Filterable {

    private List<Show> dataSource;
    private List<Show> fullDataSource;

    public ShowAdapter(List<Show> dataSource) {
        this.dataSource = dataSource;
        fullDataSource = new ArrayList<>(dataSource);
    }

    @NonNull
    @Override
    public ShowItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RelativeLayout view = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_show, parent, false);
        return new ShowItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowItemViewHolder holder, int position) {
        Show current_show = dataSource.get(position);
        holder.update(current_show);
    }


    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Show> filteredList = new ArrayList<>();
            if(constraint == null || constraint.length() == 0) {
                filteredList.addAll(fullDataSource);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for(Show show : fullDataSource) {
                    if(show.getTitle().toLowerCase().contains(filterPattern)) {
                        filteredList.add(show);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            dataSource.clear();
            dataSource.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    static class ShowItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView showImage;
        private TextView showTitle;
//        private ExpandableTextView showSynopsys;
        TextView showSynopsys;
        private RatingBar rating;

        public ShowItemViewHolder(@NonNull View itemView) {
            super(itemView);
            showImage = itemView.findViewById(R.id.itemShow_vPicture);
            showTitle = itemView.findViewById(R.id.itemShow_title);
            showSynopsys = itemView.findViewById(R.id.itemShow_synopsys);
            rating = itemView.findViewById(R.id.itemShow_ratingBar);
        }

        public void update(Show show) {


            showTitle.setText(show.getTitle());
            showSynopsys.setText(show.getSynopsys());
            rating.setRating((float) show.getRating() / 2);

        }
    }
}


