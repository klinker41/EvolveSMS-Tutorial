/*
 * Copyright 2013 Jacob Klinker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.klinker.android.tutorial;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class TestActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                findViewById(R.id.text1).setVisibility(View.VISIBLE);
            }
        }, new IntentFilter(TutorialActivity.ACTION_1_1));

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                findViewById(R.id.text2).setVisibility(View.VISIBLE);
            }
        }, new IntentFilter(TutorialActivity.ACTION_1_2));

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                findViewById(R.id.text3).setVisibility(View.VISIBLE);
            }
        }, new IntentFilter(TutorialActivity.ACTION_2_1));

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                findViewById(R.id.text4).setVisibility(View.VISIBLE);
            }
        }, new IntentFilter(TutorialActivity.ACTION_2_2));
    }

    @Override
    public void onStart() {
        super.onStop();

        // start the tutorial activity on top
        startActivity(new Intent(this, TutorialActivity.class));
    }
}
