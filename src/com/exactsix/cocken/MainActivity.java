package com.exactsix.cocken;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.exactsix.cocken.service.Utils;
import com.exactsix.cocken.view.SectionsPagerAdapter;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends FragmentActivity {
	
	private ActionBar actionBar;
	
	@Bean
    Utils util;
	
	@ViewById(R.id.pager)
    ViewPager viewPager;

	@AfterViews
    void afterViews() {
		initActionBar();
    }
	
	 private SectionsPagerAdapter sectionsPagerAdapter;
	    private final ActionBar.TabListener actionsTabListener = new ActionBar.TabListener() {
	        @Override
	        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	            viewPager.setCurrentItem(tab.getPosition());
	        }

	        @Override
	        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	        }

	        @Override
	        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	        }
	    };
	
	    private void initActionBar() {
	        actionBar = getActionBar();
	        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	        actionBar.setDisplayShowTitleEnabled(true);
	        actionBar.setDisplayShowHomeEnabled(true);

	        util.setActionBar(actionBar);

	        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), getApplicationContext());
	        viewPager.setAdapter(sectionsPagerAdapter);

	        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
	            @Override
	            public void onPageSelected(int position) {
	                actionBar.setSelectedNavigationItem(position);
	            }
	        });

	        for (int i = 0; i < sectionsPagerAdapter.getCount(); i++) {
	            Tab tab = actionBar.newTab().setText(sectionsPagerAdapter.getPageTitle(i));
	            actionBar.addTab(tab.setTabListener(actionsTabListener));
	            // tab.setIcon(drawable.tobi01);
	        }
	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
