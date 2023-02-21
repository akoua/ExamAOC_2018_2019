package ci.culture.exam.deuxmilledixhuit.entities;

import ci.culture.exam.deuxmilledixhuit.interfaces.ProductCategory;

public class ProductCategoryImpl implements ProductCategory {

    private String category;

    public ProductCategoryImpl(String category) {
        this.category = category;
    }

    @Override
    public String getName() {
        return this.category;
    }

    @Override
    public void setName(String name) {
        this.category = name;
    }
}
