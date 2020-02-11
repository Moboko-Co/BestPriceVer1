package com.moboko.bestpricever1;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;

import com.google.gson.Gson;
import com.moboko.bestpricever1.entity.ItemList;
import com.moboko.bestpricever1.entity.RakutenItem;
import com.moboko.bestpricever1.recyclerview.PostAdapter;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.moboko.bestpricever1.util.Consts.*;

class FetchPostsTask  extends AsyncTask<Map<String,String>, Void, Map<String, List<ItemList>>> {

    Map<String,List<ItemList>> resItemList = new HashMap<>();
    private CallBackTask callbacktask;

    private static final String ns = null;

    @Override
    protected Map<String,List<ItemList>> doInBackground(Map<String, String>... map) {

        Map<String,String> mp = map[0];

        String amazonJanSearch = mp.get(KEY_AMAZON);
        String rakutenKeySearch = mp.get(KEY_RAKUTEN);

        if(!amazonJanSearch.isEmpty() && amazonJanSearch != null) {
            setAmazonResponse(getItemResults(mp.get(KEY_AMAZON)));
        }
        if(!rakutenKeySearch.isEmpty() && rakutenKeySearch != null) {
            setRakutenResponse(getItemResults(mp.get(KEY_RAKUTEN)));
        }
        return resItemList;
    }

    private void setAmazonResponse(Response amazonResponse) {
        InputStream res;
        try {
            res = amazonResponse.body().byteStream();
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(res, null);
            List<ItemList> itemList = new ArrayList<>();

            parser.require(XmlPullParser.START_TAG, ns, "Result");
            while (parser.next() != XmlPullParser.END_TAG) {
                if (parser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }
                String name = parser.getName();
                // Starts by looking for the entry tag
                if (name.equals("Hit")) {
                    String imageUrl = new String();
                    String itemNm = new String();
                    String itemPrice = new String();
                    while(parser.next() != XmlPullParser.END_TAG) {
                        if (parser.getEventType() != XmlPullParser.START_TAG) {
                            continue;
                        }
                        String name1 = parser.getName();
                        if (name1.equals("Name")) {
                            itemNm = readItemNm(parser);
                        } else if (name1.equals("Small")) {
                            imageUrl = readImageUrl(parser);
                        } else if (name1.equals("Price")) {
                            itemPrice = readItemPrice(parser);
                        } else {
                            skip(parser);
                        }
                    }
                    ItemList itemList1 = new ItemList(imageUrl,itemNm,Integer.parseInt(itemPrice));
                    itemList.add(itemList1);
                } else {
                    skip(parser);
                }
            }
            resItemList.put(KEY_RAKUTEN,itemList);
        } catch (XmlPullParserException e) {
            Log.d("SEARCHITEM : AMAZON",e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String readImageUrl(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "Small");
        String imageUrl = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "Small");
        return imageUrl;
    }
    private String readItemPrice(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "Price");
        String itemPrice = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "Price");
        return itemPrice;
    }
    private String readItemNm(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "Name");
        String itemNm = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "Name");
        return itemNm;
    }

    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }

    private void setRakutenResponse(Response rakutenResponse) {
        Gson gson = new Gson();
        String res = null;
        try {
            res = rakutenResponse.body().string();
        } catch (IOException e) {
            Log.d("SEARCHITEM : RAKUTEN",e.getMessage());
        }
        RakutenItem rakutenItem =  gson.fromJson(res, RakutenItem.class);

        List<ItemList> itemList = new ArrayList<>();
        for(int i = 0; i < rakutenItem.getItems().size(); i++){
            RakutenItem.Items items = rakutenItem.getItems().get(i);
            RakutenItem.Items.Item item = items.getItem();

            ItemList itemList1 = new ItemList(item.getSmallImageUrls().get(0).getImageUrl(),item.getItemName(),item.getItemPrice());
            itemList.add(itemList1);
        }
        resItemList.put(KEY_RAKUTEN,itemList);

    }

    private Response getItemResults(String url) {
        OkHttpClient client = new OkHttpClient();

        Request builder = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(builder).execute();
            return response;
        } catch (IOException e) {
            Log.d("SEARCHITEM : HTTP",e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(Map<String,List<ItemList>> s){
        super.onPostExecute(s);
        callbacktask.CallBack(s);

    }

    public void setOnCallBack(CallBackTask _cbj) {
        callbacktask = _cbj;
    }

    /**
     * コールバック用のstaticなclass
     */
    public static class CallBackTask {
        public void CallBack(Map<String,List<ItemList>> result) {
        }
    }
}
