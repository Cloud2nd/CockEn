package com.exactsix.cocken.service;

import android.app.ActionBar;

import com.exactsix.cocken.view.CockEnFragment;
import com.exactsix.cocken.view.CourseFragment;
import com.exactsix.cocken.view.MyCourseFragment;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.api.Scope;

@EBean(scope = Scope.Singleton)
public class Utils {
	
	private ActionBar actionBar;
	private CourseFragment courseFragment;
	private CockEnFragment cockEnFragment;
	private MyCourseFragment myCourseFragment;

	public void setActionBar(ActionBar actionBar) {
        this.actionBar = actionBar;
    }

    public ActionBar getActionBar() {
        return this.actionBar;
    }
    
    public void setCourseFragment(CourseFragment courseFragment) {
        this.courseFragment = courseFragment;
    }

    public CourseFragment getCourseFragment() {
        return this.courseFragment;
    }
    
    public void setCockEnFragment(CockEnFragment cockEnFragment) {
        this.cockEnFragment = cockEnFragment;
    }

    public CockEnFragment getCockEnFragment() {
        return this.cockEnFragment;
    }
    
    public void setMyCourseFragment(MyCourseFragment myCourseFragment) {
        this.myCourseFragment = myCourseFragment;
    }

    public MyCourseFragment getMyCourseFragment() {
        return this.myCourseFragment;
    }
}
