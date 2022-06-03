package uca.edu.shoppingdex.data;

import android.content.Context;

import androidx.annotation.NonNull;

import java.util.List;

import uca.edu.shoppingdex.models.ProductModel;

public class ColoniaRepository {

    private IProductResource mSource;

    public ColoniaRepository(@NonNull Context context) {
        mSource = new ProductFileSource(context);
    }

    public ColoniaRepository(IProductResource source) {
        mSource = source;
    }

    public List<ProductModel> getAll() {
        return mSource.getAll(50);
    }
}
