package uca.edu.shoppingdex.data;

import java.util.List;

import uca.edu.shoppingdex.models.ProductModel;

public interface IProductResource {

    public interface Categories {
        public static final String ABARROTES_COMESTIBLES = "abarrotes comestibles";
        public static final String FRUTAS_Y_VERDURAS = "frutas y verduras";
        public static final String BEBIDAS = "bebidas";
        public static final String CARNES = "carnes";
        public static final String LACTEOS = "lacteos";
        public static final String EMBUTIDOS = "embutidos";
        public static final String SNACKS = "snacks";
    }

    List<ProductModel> getAll(int count);
}
