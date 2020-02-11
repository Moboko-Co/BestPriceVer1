package com.moboko.bestpricever1.util;

public class Consts {
    public static final String EXTRA_KEY_SEARCH = "KeywordSearch";
    public static final String EXTRA_BARCODE_SEARCH = "BarcodeSearch";
    public static final int RC_BARCODE_CAPTURE = 9001;

    public static final String KEY_RAKUTEN = "Rakuten";
    public static final String KEY_AMAZON = "Amazon";
    public static final String KEY_PAYPAY = "Paypay";
    public static final String KEY_MERUKARI = "Merukari";
    public static final String KEY_RAKUMA = "Rakuma";


    public static final String RAKUTEN_BASE_URL = "https://app.rakuten.co.jp/services/api/IchibaItem/Search/20170706?format=json&applicationId=1041744457491155326";
    public static final String RAKUTEN_ADD_KEYWORD = "&keyword=";

    public static final String AMAZON_BASE_URL = "https://shopping.yahooapis.jp/ShoppingWebService/V1/itemSearch?appid=dj00aiZpPURyOGZFSGgyZUl6QSZzPWNvbnN1bWVyc2VjcmV0Jng9NTM-";
    public static final String AMAZON_ADD_JANCODE = "&jan=";

}
