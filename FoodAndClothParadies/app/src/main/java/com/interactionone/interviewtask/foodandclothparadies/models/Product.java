package com.interactionone.interviewtask.foodandclothparadies.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankita on 27/11/16.
 */

public class Product implements Serializable {
  @SerializedName("id")
  private String productId;
  @SerializedName("title")
  private String productTitle;
  @SerializedName("style_code")
  private String productStyleCode;
  @SerializedName("short_title")
  private String productShortTitle;
  @SerializedName("description")
  private String productDescription;

  @SerializedName("base_price")
  private Integer productBasePrice;
  @SerializedName("sale_price")
  private Integer productSalePrice;
  @SerializedName("offer")
  private String productOffer;
  @SerializedName("size_list")
  private List<String> productSizeList=new ArrayList<>();

  @SerializedName("price_info")
  private String productPriceInfo;
  @SerializedName("brand_name")
  private String productBrandName;
  @SerializedName("brand_id")
  private String productBrandId;


  @SerializedName("brand_slug")
  private String productBrandSlug;
  @SerializedName("store_id")
  private String productStoreId;
  @SerializedName("store_name")
  private String productStoreName;
  @SerializedName("store_logo")
  private String productStoreLogo;
  @SerializedName("store_slug")
  private String productStoreSlug;
  @SerializedName("logo")
  private ProductImages productLogo;


  @SerializedName("logo_thumb")
  private String productLogoThumb;
  @SerializedName("images")
  private List<ProductImages> productListOfImages=new ArrayList<>();
  @SerializedName("added_to_wishcart")
  private Boolean productAddedToWishcart;


  @SerializedName("wishcart_item_id")
  private String productWishcartItemId;
  @SerializedName("buyable")
  private Boolean productBuyable;
  @SerializedName("offer_available")
  private Boolean productOfferAvailable;
  @SerializedName("can_deliver")
  private Boolean productCanDeliver;
  @SerializedName("can_pickup")
  private Boolean productCanPickup;
  @SerializedName("slug")
  private String productSlug;
  @SerializedName("product_type")
  private ProductType ProductType;


  @SerializedName("gift_wrap_amount")
  private Integer productGiftWrapAmount;
  @SerializedName("tags")
  private List<String> productArrayOfTags=new ArrayList<>();
  @SerializedName("inventory_id")
  private String productInventoryId;
  @SerializedName("stock_available")
  private Boolean productStockAvailable;
  @SerializedName("size_guide")
  private SizeGuide productSizeGuide;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getProductTitle() {
    return productTitle;
  }

  public void setProductTitle(String productTitle) {
    this.productTitle = productTitle;
  }

  public String getProductStyleCode() {
    return productStyleCode;
  }

  public void setProductStyleCode(String productStyleCode) {
    this.productStyleCode = productStyleCode;
  }

  public String getProductShortTitle() {
    return productShortTitle;
  }

  public void setProductShortTitle(String productShortTitle) {
    this.productShortTitle = productShortTitle;
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public Integer getProductBasePrice() {
    return productBasePrice;
  }

  public void setProductBasePrice(Integer productBasePrice) {
    this.productBasePrice = productBasePrice;
  }

  public Integer getProductSalePrice() {
    return productSalePrice;
  }

  public void setProductSalePrice(Integer productSalePrice) {
    this.productSalePrice = productSalePrice;
  }

  public String getProductOffer() {
    return productOffer;
  }

  public void setProductOffer(String productOffer) {
    this.productOffer = productOffer;
  }

  public List<String> getProductSizeList() {
    return productSizeList;
  }

  public void setProductSizeList(List<String> productSizeList) {
    this.productSizeList = productSizeList;
  }

  public String getProductPriceInfo() {
    return productPriceInfo;
  }

  public void setProductPriceInfo(String productPriceInfo) {
    this.productPriceInfo = productPriceInfo;
  }

  public String getProductBrandName() {
    return productBrandName;
  }

  public void setProductBrandName(String productBrandName) {
    this.productBrandName = productBrandName;
  }

  public String getProductBrandId() {
    return productBrandId;
  }

  public void setProductBrandId(String productBrandId) {
    this.productBrandId = productBrandId;
  }

  public String getProductBrandSlug() {
    return productBrandSlug;
  }

  public void setProductBrandSlug(String productBrandSlug) {
    this.productBrandSlug = productBrandSlug;
  }

  public String getProductStoreId() {
    return productStoreId;
  }

  public void setProductStoreId(String productStoreId) {
    this.productStoreId = productStoreId;
  }

  public String getProductStoreName() {
    return productStoreName;
  }

  public void setProductStoreName(String productStoreName) {
    this.productStoreName = productStoreName;
  }

  public String getProductStoreLogo() {
    return productStoreLogo;
  }

  public void setProductStoreLogo(String productStoreLogo) {
    this.productStoreLogo = productStoreLogo;
  }

  public String getProductStoreSlug() {
    return productStoreSlug;
  }

  public void setProductStoreSlug(String productStoreSlug) {
    this.productStoreSlug = productStoreSlug;
  }

  public ProductImages getProductLogo() {
    return productLogo;
  }

  public void setProductLogo(ProductImages productLogo) {
    this.productLogo = productLogo;
  }

  public String getProductLogoThumb() {
    return productLogoThumb;
  }

  public void setProductLogoThumb(String productLogoThumb) {
    this.productLogoThumb = productLogoThumb;
  }

  public List<ProductImages> getProductListOfImages() {
    return productListOfImages;
  }

  public void setProductListOfImages(List<ProductImages> productListOfImages) {
    this.productListOfImages = productListOfImages;
  }

  public Boolean getProductAddedToWishcart() {
    return productAddedToWishcart;
  }

  public void setProductAddedToWishcart(Boolean productAddedToWishcart) {
    this.productAddedToWishcart = productAddedToWishcart;
  }

  public String getProductWishcartItemId() {
    return productWishcartItemId;
  }

  public void setProductWishcartItemId(String productWishcartItemId) {
    this.productWishcartItemId = productWishcartItemId;
  }

  public Boolean getProductBuyable() {
    return productBuyable;
  }

  public void setProductBuyable(Boolean productBuyable) {
    this.productBuyable = productBuyable;
  }

  public Boolean getProductOfferAvailable() {
    return productOfferAvailable;
  }

  public void setProductOfferAvailable(Boolean productOfferAvailable) {
    this.productOfferAvailable = productOfferAvailable;
  }

  public Boolean getProductCanDeliver() {
    return productCanDeliver;
  }

  public void setProductCanDeliver(Boolean productCanDeliver) {
    this.productCanDeliver = productCanDeliver;
  }

  public Boolean getProductCanPickup() {
    return productCanPickup;
  }

  public void setProductCanPickup(Boolean productCanPickup) {
    this.productCanPickup = productCanPickup;
  }

  public String getProductSlug() {
    return productSlug;
  }

  public void setProductSlug(String productSlug) {
    this.productSlug = productSlug;
  }

  public com.interactionone.interviewtask.foodandclothparadies.models.ProductType getProductType() {
    return ProductType;
  }

  public void setProductType(com.interactionone.interviewtask.foodandclothparadies.models.ProductType productType) {
    ProductType = productType;
  }

  public Integer getProductGiftWrapAmount() {
    return productGiftWrapAmount;
  }

  public void setProductGiftWrapAmount(Integer productGiftWrapAmount) {
    this.productGiftWrapAmount = productGiftWrapAmount;
  }

  public List<String> getProductArrayOfTags() {
    return productArrayOfTags;
  }

  public void setProductArrayOfTags(List<String> productArrayOfTags) {
    this.productArrayOfTags = productArrayOfTags;
  }

  public String getProductInventoryId() {
    return productInventoryId;
  }

  public void setProductInventoryId(String productInventoryId) {
    this.productInventoryId = productInventoryId;
  }

  public Boolean getProductStockAvailable() {
    return productStockAvailable;
  }

  public void setProductStockAvailable(Boolean productStockAvailable) {
    this.productStockAvailable = productStockAvailable;
  }

  public SizeGuide getProductSizeGuide() {
    return productSizeGuide;
  }

  public void setProductSizeGuide(SizeGuide productSizeGuide) {
    this.productSizeGuide = productSizeGuide;
  }

  /*@Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel parcel, int i) {

parcel.writeString(productId);
    parcel.writeString(productTitle);
    parcel.writeString(productStyleCode);
    parcel.writeString(productShortTitle);
    parcel.writeString(productDescription);


    parcel.writeString(""+productBasePrice);
    parcel.writeString(""+productSalePrice);
    parcel.writeString(productOffer);
    parcel.writeStringList(productSizeList);
    parcel.writeString(productBrandName);
    parcel.writeString(productPriceInfo);



    parcel.writeString(""+productBrandId);
    parcel.writeString(""+productBrandSlug);
    parcel.writeString(productStoreId);
    parcel.writeString(productStoreName);
    parcel.writeString(productStoreLogo);
    parcel.writeString(productStoreSlug);

    parcel.writeValue(productLogo);
    parcel.writeString(productLogoThumb);



    parcel.writeList(productListOfImages);
    parcel.writeString(""+productAddedToWishcart);
    parcel.writeString(""+productWishcartItemId);
    parcel.writeString(""+productBuyable);
    parcel.writeString(""+productOfferAvailable);
    parcel.writeString(""+productCanDeliver);

    parcel.writeString(""+productCanPickup);
    parcel.writeString(""+productSlug);
    parcel.writeString(""+ProductType);
    parcel.writeString(""+productGiftWrapAmount);
    parcel.writeStringList(productArrayOfTags);
    parcel.writeString(""+productInventoryId);
    parcel.writeString(""+productStockAvailable);
    parcel.writeString(""+productSizeGuide);

  }

  public static final Parcelable.Creator<Product> CREATOR
          = new Parcelable.Creator<Product>() {
    public Product createFromParcel(Parcel in) {
      return new Product(in);
    }

    public Product[] newArray(int size) {
      return new Product[size];
    }
  };

  private Product(Parcel in) {
    productId = in.readString();
    productTitle = in.readString();
    productStyleCode = in.readString();

    productShortTitle = in.readString();
    productDescription = in.readString();
    productBasePrice = Integer.parseInt(in.readString());
    productSalePrice = Integer.parseInt(in.readString());

    productOffer = in.readString();
    productSizeList =  in.createStringArrayList();
    productBrandName = in.readString();
    productPriceInfo = in.readString();

    productBrandId = in.readString();
    productBrandSlug = in.readString();
    productStoreId = in.readString();
    productStoreName = in.readString();


    productStoreLogo = in.readString();
    productStoreSlug = in.readString();
    //productLogo = in.readValue()
    productLogoThumb = in.readString();

    //productListOfImages = in.readString();
    productAddedToWishcart = Boolean.parseBoolean(in.readString());
    productWishcartItemId = in.readString();
    productBuyable = Boolean.parseBoolean(in.readString());


    productOfferAvailable =Boolean.parseBoolean(in.readString());
    productCanDeliver = Boolean.parseBoolean(in.readString());
    productCanPickup = Boolean.parseBoolean(in.readString());
    productSlug = in.readString();

   /// ProductType = in.readString();


    productGiftWrapAmount = Integer.parseInt(in.readString());
   // productArrayOfTags = in.readString();
    productInventoryId = in.readString();

    productStockAvailable = Boolean.parseBoolean(in.readString());
    productSizeGuide = in.readString();

  }
*/

  @Override
  public String toString() {
    return "Product{" +
            "productId='" + productId + '\'' +
            ", productTitle='" + productTitle + '\'' +
            ", productStyleCode='" + productStyleCode + '\'' +
            ", productShortTitle='" + productShortTitle + '\'' +
            ", productDescription='" + productDescription + '\'' +
            ", productBasePrice=" + productBasePrice +
            ", productSalePrice=" + productSalePrice +
            ", productOffer='" + productOffer + '\'' +
            ", productSizeList=" + productSizeList +
            ", productPriceInfo='" + productPriceInfo + '\'' +
            ", productBrandName='" + productBrandName + '\'' +
            ", productBrandId='" + productBrandId + '\'' +
            ", productBrandSlug='" + productBrandSlug + '\'' +
            ", productStoreId='" + productStoreId + '\'' +
            ", productStoreName='" + productStoreName + '\'' +
            ", productStoreLogo='" + productStoreLogo + '\'' +
            ", productStoreSlug='" + productStoreSlug + '\'' +
            ", productLogo=" + productLogo +
            ", productLogoThumb='" + productLogoThumb + '\'' +
            ", productListOfImages=" + productListOfImages +
            ", productAddedToWishcart=" + productAddedToWishcart +
            ", productWishcartItemId='" + productWishcartItemId + '\'' +
            ", productBuyable=" + productBuyable +
            ", productOfferAvailable=" + productOfferAvailable +
            ", productCanDeliver=" + productCanDeliver +
            ", productCanPickup=" + productCanPickup +
            ", productSlug='" + productSlug + '\'' +
            ", ProductType=" + ProductType +
            ", productGiftWrapAmount=" + productGiftWrapAmount +
            ", productArrayOfTags=" + productArrayOfTags +
            ", productInventoryId='" + productInventoryId + '\'' +
            ", productStockAvailable=" + productStockAvailable +
            ", productSizeGuide=" + productSizeGuide +
            '}';
  }
}
