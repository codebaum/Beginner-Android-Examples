package com.codebaum.beginnerandroidexamples.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created on 1/14/18.
 */

public class JavaUtils {

    public static void quickToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
