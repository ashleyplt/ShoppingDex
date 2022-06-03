package uca.edu.shoppingdex.Adapters.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import uca.edu.shoppingdex.R;
import uca.edu.shoppingdex.helpers.events.ItemTapListener;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvNombre, tvCategoria, tvPrecio, tvMedida;

    @Nullable
    private final ItemTapListener mTapListener;

    public ProductViewHolder(@NonNull View itemView, @Nullable ItemTapListener tapListener) {
        super(itemView);

        mTapListener = tapListener;
        itemView.setOnClickListener(this);

        tvNombre = itemView.findViewById(R.id.tv_nombre);
        tvCategoria = itemView.findViewById(R.id.tv_category);
        tvPrecio = itemView.findViewById(R.id.tv_precio);
        tvMedida = itemView.findViewById(R.id.tv_medida);
    }

    @Override
    public void onClick(View view) {
        if(mTapListener == null) return;
        mTapListener.onItemTap(view, getAdapterPosition());
    }
}
