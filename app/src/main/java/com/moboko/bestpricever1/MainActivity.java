package com.moboko.bestpricever1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_KEY_BARCODE =     BarcodeCaptureActivity.EXTRA_KEY_BARCODE;

    private static final int RC_BARCODE_CAPTURE = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment[] arrFragments = new Fragment[5];
        arrFragments[0] = new AmazonFrag();
        arrFragments[1] = new RakutenFrag();
        arrFragments[2] = new MerukariFrag();
        arrFragments[3] = new RakumaFrag();
        arrFragments[4] = new PaypayFrag();

        // Inflate the layout for this fragment

        TabLayout tabLayout = findViewById(R.id.searchViewTabs);
        ViewPager viewPager = findViewById(R.id.searchViewPager);

        SearchPagerAdapter adapter = new SearchPagerAdapter(getSupportFragmentManager(), arrFragments);
        viewPager.setAdapter(adapter);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
        tabLayout.setTabTextColors(getResources().getColor(R.color.colorGray),getResources().getColor(R.color.colorPrimary));
        tabLayout.setupWithViewPager(viewPager);


        findViewById(R.id.barCodeImageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBarcodeCaptureActivity();

            }
        });

    }

    private class SearchPagerAdapter extends FragmentStatePagerAdapter {
        private Fragment[] arrFragments;

        public SearchPagerAdapter(@NonNull FragmentManager fm, Fragment[] arrFragments) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            this.arrFragments = arrFragments;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return arrFragments[position];
        }

        @Override
        public int getCount() {
            return arrFragments.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            switch(position) {
                case 0:
                    return getString(R.string.tab_name_amazon);
                case 1:
                    return getString(R.string.tab_name_rakuten);
                case 2:
                    return getString(R.string.tab_name_merukari);
                case 3:
                    return getString(R.string.tab_name_rakuma);
                case 4:
                    return getString(R.string.tab_name_paypay);
                default:
                    return "";
            }
        }
    }
    private void startBarcodeCaptureActivity() {
        Intent intent = new Intent(this, BarcodeCaptureActivity.class);
        startActivityForResult(intent, RC_BARCODE_CAPTURE);
    }
}
