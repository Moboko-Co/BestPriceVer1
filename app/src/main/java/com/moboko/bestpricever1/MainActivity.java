package com.moboko.bestpricever1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_KEY_BARCODE = BarcodeCaptureActivity.EXTRA_KEY_BARCODE;
    public static final String EXTRA_KEY_SEARCH = "Search";
    private static final int RC_BARCODE_CAPTURE = 9001;
    static final int PICK_CONTACT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.searchItemImageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.searchItemEditText);
                startSearchResultActivity(editText.getText().toString());
            }
        });

        findViewById(R.id.barCodeImageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBarcodeCaptureActivity();
            }
        });

    }

    private void startSearchResultActivity(String searchItem) {
        Intent intent = new Intent(this, SearchResultActivity.class);
        intent.putExtra(EXTRA_KEY_SEARCH, searchItem);
        startActivityForResult(intent, RC_BARCODE_CAPTURE);
    }

    private void startBarcodeCaptureActivity() {
        Intent intent = new Intent(this, BarcodeCaptureActivity.class);
        startActivityForResult(intent, RC_BARCODE_CAPTURE);
    }

    @Override
    protected void  onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_CONTACT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String barcode = data.getStringExtra(EXTRA_KEY_BARCODE);
            }
        }
    }
}
