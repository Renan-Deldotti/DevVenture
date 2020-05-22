package com.teste.fragmentsnavigation;

import android.os.Bundle;

import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
        CheckBoxPreference checkBoxPreference = findPreference("check_box_preference_1");
        if (checkBoxPreference != null)
        checkBoxPreference.isChecked();
    }
}
