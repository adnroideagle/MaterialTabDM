package it.neokree.materialtabtest;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class TextTabActivity extends FragmentActivity implements
		MaterialTabListener {

	MaterialTabHost tabHost;
	ViewPager pager;
	ViewPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text);

		tabHost = (MaterialTabHost) this.findViewById(R.id.tabHost);
		pager = (ViewPager) this.findViewById(R.id.pager);

		// init view pager
		adapter = new ViewPagerAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);
		pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				// when user do a swipe the selected tab change
				tabHost.setSelectedNavigationItem(position);

			}
		});

		// insert all tabs from pagerAdapter data
		for (int i = 0; i < adapter.getCount(); i++) {
			tabHost.addTab(tabHost.newTab().setText(adapter.getPageTitle(i))
					.setTabListener(this));

		}

	}

	@Override
	public void onTabSelected(MaterialTab tab) {
		pager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabReselected(MaterialTab tab) {

	}

	@Override
	public void onTabUnselected(MaterialTab tab) {

	}

	private class ViewPagerAdapter extends FragmentStatePagerAdapter {

		public ViewPagerAdapter(
				android.support.v4.app.FragmentManager fragmentManager) {
			super(fragmentManager);

		}

		public FragmentText getItem(int num) {
			return new FragmentText();
		}

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return "Sezione " + position;
		}

	}
}
