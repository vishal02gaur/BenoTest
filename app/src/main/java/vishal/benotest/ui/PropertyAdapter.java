package vishal.benotest.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vishal.benotest.R;
import vishal.benotest.models.Property;

/**
 * Created by Vishal Gaur on 6/20/2018.
 */

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.ViewHolder> {
    private List<Property> list;

    public PropertyAdapter(List<Property> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.property_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView landmark;
        TextView city;
        TextView price;
        TextView review;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            landmark = itemView.findViewById(R.id.landmark);
            city = itemView.findViewById(R.id.city);
            price = itemView.findViewById(R.id.price);
            review = itemView.findViewById(R.id.review);
        }

        public void onBind(Property property) {
            name.setText(property.getName());
            landmark.setText(property.getLandmark());
            city.setText(property.getCity());
            price.setText("Price : "+String.valueOf(property.getPrice()));
            review.setText("Reviews : "+String.valueOf(property.getReviewCount()));
        }
    }
}
