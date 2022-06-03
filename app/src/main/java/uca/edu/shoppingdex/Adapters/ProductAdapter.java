package uca.edu.shoppingdex.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import uca.edu.shoppingdex.Adapters.ViewHolders.ProductViewHolder;
import uca.edu.shoppingdex.R;
import uca.edu.shoppingdex.helpers.events.ItemTapListener;
import uca.edu.shoppingdex.models.ProductModel;


public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    @NonNull
    private List<ProductModel> mModelList;
    @Nullable
    private final ItemTapListener mTapListener;

    public ProductAdapter(@NonNull List<ProductModel> modelList, @Nullable ItemTapListener tapListener) {
        mModelList = modelList;
        mTapListener = tapListener;
    }

    public void updateList(List<ProductModel> newList) {
        mModelList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    //inflamos cada item con su respectiva vista.
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_product, parent, false);
        ProductViewHolder viewHolder = new ProductViewHolder(itemView, mTapListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductModel currentModel = mModelList.get(position);
        holder.tvNombre.setText(currentModel.getNombre());
        holder.tvCategoria.setText(currentModel.getCategory());
        holder.tvPrecio.setText(String.valueOf(currentModel.getPrecio()));
        holder.tvMedida.setText(currentModel.getMedida());
    }
    @Override
    public int getItemCount() {
        return mModelList.size();
    }

}
