package uca.edu.shoppingdex.data;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import uca.edu.shoppingdex.helpers.FileHelper;
import uca.edu.shoppingdex.models.ProductModel;

public class ProductFileSource implements IProductResource{

    private final Context mcontext;
    private static final String NOMBRE_ARCHIVO_JSON = "Lacolonia.json";
    private final Gson jsonMapper;

    public ProductFileSource(@NonNull Context mcontext) {
        this.mcontext = mcontext;
        this.jsonMapper = new Gson();
    }

    @Override
    public List<ProductModel> getAll(int count) {
        String productJsonString = FileHelper.getJsonFromAssets(mcontext, NOMBRE_ARCHIVO_JSON);
        ProductResult result = jsonMapper.fromJson(productJsonString, ProductResult.class);

        return result.data;
    }

    static class ProductResult{
        @SerializedName("productos")
        List<ProductModel> data;

        public ProductResult(){};

        public ProductResult(List<ProductModel> data) {
            this.data = data;
        }
    }
}
