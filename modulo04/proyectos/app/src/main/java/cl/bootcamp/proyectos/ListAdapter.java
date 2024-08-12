package cl.bootcamp.proyectos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> implements View.OnClickListener {

    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;
    private View.OnClickListener listener;

    public ListAdapter(List<ListElement> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view = mInflater.inflate(R.layout.list_element, null);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() { return mData.size(); }

    public void setItems(List<ListElement> items) { mData = items; }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView name, subtitle, status;

        ViewHolder(View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.ivCard);
            name = itemView.findViewById(R.id.tvNameCard);
            subtitle = itemView.findViewById(R.id.tvSubtitleCard);
            status = itemView.findViewById(R.id.tvStatus);
        }

        void bindData(final ListElement item) {
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(item.getName());
            name.setTextColor(Color.parseColor(item.getColorName()));
            subtitle.setText(item.getSubtitle());
            status.setText(item.getStatus());
        }
    }
}
