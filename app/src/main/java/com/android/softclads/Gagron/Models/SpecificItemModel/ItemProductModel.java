
package com.android.softclads.Gagron.Models.SpecificItemModel;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemProductModel {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("stock_available")
    @Expose
    private Boolean stockAvailable;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("old_price")
    @Expose
    private String oldPrice;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("short_description")
    @Expose
    private String shortDescription;
    @SerializedName("full_description")
    @Expose
    private String fullDescription;
    @SerializedName("number_of_reviews")
    @Expose
    private String numberOfReviews;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("manufacturer")
    @Expose
    private ItemManufacturerModel manufacturer;
    @SerializedName("reviews")
    @Expose
    private ArrayList<ItemReviewModel> reviews = null;
    @SerializedName("images")
    @Expose
    private ArrayList<String> images = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getStockAvailable() {
        return stockAvailable;
    }

    public void setStockAvailable(Boolean stockAvailable) {
        this.stockAvailable = stockAvailable;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(String numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public ItemManufacturerModel getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ItemManufacturerModel manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ArrayList<ItemReviewModel> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<ItemReviewModel> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

}
