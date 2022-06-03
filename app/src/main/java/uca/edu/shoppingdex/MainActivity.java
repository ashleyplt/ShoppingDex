package uca.edu.shoppingdex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

import uca.edu.shoppingdex.Adapters.ProductAdapter;
import uca.edu.shoppingdex.data.ColoniaRepository;
import uca.edu.shoppingdex.data.ProductFileSource;
import uca.edu.shoppingdex.helpers.events.ItemTapListener;
import uca.edu.shoppingdex.models.ProductModel;

public class MainActivity extends AppCompatActivity implements ItemTapListener {

    private ColoniaRepository mColoniaRepository;
    private ProductAdapter mProductAdapter;
    private List<ProductModel> mProductModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }

    private void setup() {
        mColoniaRepository = new ColoniaRepository(getBaseContext());
        mProductModel = mColoniaRepository.getAll();
        mProductAdapter = new ProductAdapter(mProductModel, this);
        RecyclerView rvProduct = findViewById(R.id.rv_product);
        rvProduct.setAdapter(mProductAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setHasFixedSize(true);
    }

    @Override
    public void onItemTap(View view, int position) {

    }
}