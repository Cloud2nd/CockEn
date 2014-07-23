package com.exactsix.cocken.view;

import android.support.v4.app.ListFragment;

import com.exactsix.cocken.R;
import com.exactsix.cocken.service.Utils;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_course)
public class CourseFragment extends ListFragment {

	@Bean Utils util;
	
	@AfterViews
	void afterViews(){
		util.setCourseFragment(this);
	}
}
