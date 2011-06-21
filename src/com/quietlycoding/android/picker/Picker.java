/*
 * Copyright 2010-2011 Mike Novak <michael.novakjr@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.quietlycoding.android.picker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class Picker extends Activity implements NumberPickerDialog.OnNumberSetListener {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.picker_menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_preferences_item:
            startActivity(new Intent(this, PickerPreferences.class));
            return true;
        case R.id.menu_dialog_item:
            NumberPickerDialog dialog = new NumberPickerDialog(this, -1, 5);
            dialog.setTitle(getString(R.string.dialog_picker_title));
            dialog.setOnNumberSetListener(this);
            dialog.show();
            return true;
        }
        
        return false;
    }

    public void onNumberSet(int number) {
        Log.d("NumberPicker", "Number selected: " + number);
    }
}
