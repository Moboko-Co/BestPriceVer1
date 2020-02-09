package com.moboko.bestpricever1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.material.tabs.TabLayout;

public class SearchResultActivity extends AppCompatActivity {

    private static final String EXTRA_KEY_SEARCH = MainActivity.EXTRA_KEY_SEARCH;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_results);

        final String searchItem = getIntent().getStringExtra(EXTRA_KEY_SEARCH);

        TextView resultItem = findViewById(R.id.resultItemTextView);
        resultItem.setText(searchItem);

        findViewById(R.id.backImageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra(EXTRA_KEY_SEARCH, searchItem);
                setResult(CommonStatusCodes.SUCCESS, data);
                finish();
            }
        });

        Fragment[] arrFragments = new Fragment[5];
        arrFragments[0] = new AmazonFrag();
        arrFragments[1] = new RakutenFrag();
        arrFragments[2] = new MerukariFrag();
        arrFragments[3] = new RakumaFrag();
        arrFragments[4] = new PaypayFrag();


        TabLayout tabLayout = findViewById(R.id.searchViewTabs);
        ViewPager viewPager = findViewById(R.id.searchViewPager);

        SearchResultActivity.SearchPagerAdapter adapter = new SearchResultActivity.SearchPagerAdapter(getSupportFragmentManager(), arrFragments);
        viewPager.setAdapter(adapter);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
        tabLayout.setTabTextColors(getResources().getColor(R.color.colorGray),getResources().getColor(R.color.colorPrimary));
        tabLayout.setupWithViewPager(viewPager);
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
}
