package com.probosoft.PSUtils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.probosoft.lwp.geometro.full.R;

public class PSSeekBarPreference extends Preference implements OnSeekBarChangeListener{
	
	protected int minLevel = 0;
	protected int maxLevel = 99;
	protected int defaultProgress = 0;

	/**
	 * Constructs seek bar preference
	 * @param Context context Context of the application uses this preference
	 * @param AttributeSet attrs Attribute set for preference
	 */
	public PSSeekBarPreference(Context context, AttributeSet attrs) {
		super(context, attrs);
		minLevel = attrs.getAttributeIntValue(android.R.attr.minLevel, 0);
		maxLevel = attrs.getAttributeIntValue(android.R.attr.maxLevel, 99);
		defaultProgress = attrs.getAttributeIntValue(android.R.attr.progress, 0);
	}
	
	/**
	 * Initializing seek bar preference
	 */
	@Override
	 protected View onCreateView(ViewGroup parent) {
		RelativeLayout layout;
		layout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.psseekbar, null);
		
		TextView title = (TextView)layout.findViewById(R.id.PSSeekTitle);
		title.setText(this.getTitle());
		
		SeekBar seek = (SeekBar)layout.findViewById(R.id.PSSeekSeek);
		seek.setMax(maxLevel-minLevel);
		seek.setProgress(this.getPersistedInt(defaultProgress));
		seek.setOnSeekBarChangeListener(this);
		
		return layout;
	}

	/**
	 * Updates value of preference while changing seek bar position
	 */
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		SharedPreferences.Editor prefsEditor = getEditor();
		prefsEditor.putInt(this.getKey(), progress+minLevel);
		prefsEditor.commit();
	}

	/**
	 * Dummy override
	 */
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
	}

	/**
	 * Dummy override
	 */
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
	}
}
