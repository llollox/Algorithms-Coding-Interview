package com.llollox.algorithms;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.llollox.algorithms.problems.crack.strings.PalindromePermutation;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new PalindromePermutation().test();
    }
}
