package previmedical.it.leetcode;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import previmedical.it.leetcode.problems.crack.strings.PalindromePermutation;
import previmedical.it.leetcode.problems.crack.strings.URLify;
import previmedical.it.leetcode.problems.easy.N633_SumOfSquareNumbers;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new PalindromePermutation().test();
    }
}
