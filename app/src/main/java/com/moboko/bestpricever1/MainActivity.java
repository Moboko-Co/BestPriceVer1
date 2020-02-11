package com.moboko.bestpricever1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.api.CommonStatusCodes;

import static com.moboko.bestpricever1.util.Consts.*;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_KEY_BARCODE = BarcodeCaptureActivity.EXTRA_KEY_BARCODE;
    static final int PICK_CONTACT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.searchItemImageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.searchItemEditText);
                startSearchResultActivity(EXTRA_KEY_SEARCH,editText.getText().toString());
            }
        });

        findViewById(R.id.barCodeImageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBarcodeCaptureActivity();
            }
        });

    }

    private void startSearchResultActivity(String searchFlag,String searchItem) {
        Intent intent = new Intent(this, SearchResultActivity.class);

        switch(searchFlag) {
            case EXTRA_BARCODE_SEARCH :
                intent.putExtra(EXTRA_BARCODE_SEARCH, searchItem);
                break;
            case EXTRA_KEY_SEARCH:
                intent.putExtra(EXTRA_KEY_SEARCH, searchItem);
                break;
        }
        startActivityForResult(intent, RC_BARCODE_CAPTURE);
    }

    private void startBarcodeCaptureActivity() {
        Intent intent = new Intent(this, BarcodeCaptureActivity.class);
        startActivityForResult(intent, RC_BARCODE_CAPTURE);
    }

    @Override
    protected void  onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_BARCODE_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                String barcode = data.getStringExtra(EXTRA_KEY_BARCODE);
                startSearchResultActivity(EXTRA_BARCODE_SEARCH,barcode);
            }
        }
    }
}
